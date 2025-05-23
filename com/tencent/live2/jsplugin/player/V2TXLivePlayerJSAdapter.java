package com.tencent.live2.jsplugin.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.live2.impl.V2TXLiveUtils;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.jsplugin.JSAdapterOnlineLog;
import com.tencent.live2.jsplugin.LiveURLParser;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class V2TXLivePlayerJSAdapter extends a {
    static IPatchRedirector $redirector_ = null;
    private static final int FRAMEWORK_TYPE_LIVEV2_WXAPPLET = 9;
    private static final int FRAMEWORK_TYPE_WXROOM_WXAPPLET = 3;
    private static final String ROOM_PROTOCOL_PREFIX = "room";
    private static final String TAG = "applet-player-api";
    private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
    private V2TXLivePlayerJSConfig mConfig;
    private boolean mIsInit;
    private boolean mNeedCompressSnapshot;
    private int mNetworkQuality;
    private ITXLivePlayListener mPlayListener;
    private V2TXLiveDef.V2TXLiveMode mPlayMode;
    private V2TXLivePlayer mPlayer;
    private String mPlayerId;
    private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
    private String mTraceId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16635);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            SoLoader.loadAllLibraries();
        }
    }

    public V2TXLivePlayerJSAdapter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mPlayerId = "";
        this.mTraceId = "";
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        V2TXLivePlayerImpl v2TXLivePlayerImpl = new V2TXLivePlayerImpl(context);
        this.mPlayer = v2TXLivePlayerImpl;
        v2TXLivePlayerImpl.setObserver(this);
        this.mNetworkQuality = 2;
        this.mConfig = new V2TXLivePlayerJSConfig();
    }

    private void apiOnlineError(String str, boolean z16) {
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(this.mTraceId)) {
            this.mTraceId = String.valueOf(hashCode()).substring(String.valueOf(hashCode()).length() - 4);
        }
        if (z16 && checkIsRoomProtocolByUrl(this.mConfig.url)) {
            JSAdapterOnlineLog.getInstance().log("[applet-player-api][" + this.mTraceId + "][" + this.mPlayerId + "] " + str, true);
            return;
        }
        LiteavLog.e(TAG, "[" + this.mTraceId + "][" + this.mPlayerId + "] " + str);
    }

    private void apiOnlineLog(String str, boolean z16) {
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(this.mTraceId)) {
            this.mTraceId = String.valueOf(hashCode()).substring(String.valueOf(hashCode()).length() - 4);
        }
        if (z16 && checkIsRoomProtocolByUrl(this.mConfig.url)) {
            JSAdapterOnlineLog.getInstance().log("[applet-player-api][" + this.mTraceId + "][" + this.mPlayerId + "] " + str, true);
            return;
        }
        LiteavLog.i(TAG, "[" + this.mTraceId + "][" + this.mPlayerId + "] " + str);
    }

    private void callbackSDKVersion() {
        ITXLivePlayListener iTXLivePlayListener = this.mPlayListener;
        if (iTXLivePlayListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
            bundle.putLong("EVT_TIME", System.currentTimeMillis());
            apiOnlineLog("OnPlayEvent: event[-9999999], msg[" + bundle.toString() + "]", false);
            iTXLivePlayListener.onPlayEvent(V2TXJSAdapterConstants.EVT_ID_SDK_VERSION, bundle);
        }
    }

    private boolean checkIsRoomProtocolByUrl(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(ROOM_PROTOCOL_PREFIX)) {
            return true;
        }
        return false;
    }

    private String getPlayerIdByURL(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!str.startsWith(V2TXLiveUtils.TRTC_ADDRESS1) && !str.startsWith(V2TXLiveUtils.TRTC_ADDRESS2)) {
                return LiveURLParser.getStreamId(str);
            }
            return LiveURLParser.getURLParams(str, "userid");
        } catch (Exception unused) {
            LiteavLog.e(TAG, "Get streamId failed, url:".concat(String.valueOf(str)));
            return "";
        }
    }

    private V2TXJSAdapterError initLivePlayerInner(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        if (bundle == null) {
            apiOnlineError("Init player failed, params is null", false);
            return new V2TXJSAdapterError(-1, "Init player failed, params is null");
        }
        if (this.mIsInit) {
            apiOnlineError("Init player failed, player has been initialized", false);
            return new V2TXJSAdapterError(-1, "Init player failed, player has been initialized");
        }
        if (tXCloudVideoView != null) {
            this.mPlayer.setRenderView(tXCloudVideoView);
        }
        apiOnlineLog("Init player success", false);
        this.mIsInit = true;
        this.mConfig.updateFromBundle(bundle);
        this.mPlayerId = getPlayerIdByURL(this.mConfig.url);
        setFullParams(this.mConfig);
        return new V2TXJSAdapterError();
    }

    private void setDiffParams(V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig, V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig2) {
        String diffConfig = v2TXLivePlayerJSConfig2.diffConfig(v2TXLivePlayerJSConfig);
        if (!TextUtils.isEmpty(diffConfig)) {
            apiOnlineLog("Set diff config:".concat(String.valueOf(diffConfig)), true);
        }
        boolean z16 = v2TXLivePlayerJSConfig.isMuteVideo;
        boolean z17 = v2TXLivePlayerJSConfig2.isMuteVideo;
        if (z16 != z17) {
            if (z17) {
                this.mPlayer.pauseVideo();
            } else {
                this.mPlayer.resumeVideo();
            }
        }
        boolean z18 = v2TXLivePlayerJSConfig.isMuteAudio;
        boolean z19 = v2TXLivePlayerJSConfig2.isMuteAudio;
        if (z18 != z19) {
            if (z19) {
                this.mPlayer.pauseAudio();
            } else {
                this.mPlayer.resumeAudio();
            }
        }
        boolean z26 = v2TXLivePlayerJSConfig.enableRecvSEIMessage;
        boolean z27 = v2TXLivePlayerJSConfig2.enableRecvSEIMessage;
        if (z26 != z27) {
            this.mPlayer.enableReceiveSeiMessage(z27, 5);
            this.mPlayer.enableReceiveSeiMessage(v2TXLivePlayerJSConfig2.enableRecvSEIMessage, 100);
            this.mPlayer.enableReceiveSeiMessage(v2TXLivePlayerJSConfig2.enableRecvSEIMessage, 242);
            this.mPlayer.enableReceiveSeiMessage(v2TXLivePlayerJSConfig2.enableRecvSEIMessage, 243);
        }
        boolean z28 = v2TXLivePlayerJSConfig.enableDebugView;
        boolean z29 = v2TXLivePlayerJSConfig2.enableDebugView;
        if (z28 != z29) {
            this.mPlayer.showDebugView(z29);
        }
        float f16 = v2TXLivePlayerJSConfig.minCache;
        float f17 = v2TXLivePlayerJSConfig2.minCache;
        if (f16 != f17 || v2TXLivePlayerJSConfig.maxCache != v2TXLivePlayerJSConfig2.maxCache) {
            this.mPlayer.setCacheParams(Math.min(f17, v2TXLivePlayerJSConfig2.maxCache), Math.max(v2TXLivePlayerJSConfig2.minCache, v2TXLivePlayerJSConfig2.maxCache));
        }
        int i3 = v2TXLivePlayerJSConfig.volumeNotifyIntervals;
        int i16 = v2TXLivePlayerJSConfig2.volumeNotifyIntervals;
        if (i3 != i16) {
            this.mPlayer.enableVolumeEvaluation(i16);
        }
        V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode = v2TXLivePlayerJSConfig.fillMode;
        V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode2 = v2TXLivePlayerJSConfig2.fillMode;
        if (v2TXLiveFillMode != v2TXLiveFillMode2) {
            this.mPlayer.setRenderFillMode(v2TXLiveFillMode2);
        }
        V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation = v2TXLivePlayerJSConfig.renderRotation;
        V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation2 = v2TXLivePlayerJSConfig2.renderRotation;
        if (v2TXLiveRotation != v2TXLiveRotation2) {
            this.mPlayer.setRenderRotation(v2TXLiveRotation2);
        }
        int i17 = v2TXLivePlayerJSConfig.audioRoute;
        int i18 = v2TXLivePlayerJSConfig2.audioRoute;
        if (i17 != i18) {
            this.mPlayer.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, Integer.valueOf(i18));
        }
        if (!TextUtils.isEmpty(v2TXLivePlayerJSConfig2.url) && !v2TXLivePlayerJSConfig2.url.equals(v2TXLivePlayerJSConfig.url) && v2TXLivePlayerJSConfig2.isCanAutoPlay && v2TXLivePlayerJSConfig2.isAutoPlay) {
            if (this.mPlayer.isPlaying() == 1) {
                apiOnlineLog("Set diff config:[auto play is true, url is changed, player is playing], need to stop play", false);
                this.mPlayer.stopPlay();
            }
            apiOnlineLog("Set diff config:[auto play is true, url is changed, player is not playing], need to start auto play", false);
            startPlayInner(v2TXLivePlayerJSConfig2.url, v2TXLivePlayerJSConfig2.mode);
        }
        if (v2TXLivePlayerJSConfig2.isAutoPlay && v2TXLivePlayerJSConfig2.isCanAutoPlay && !TextUtils.isEmpty(v2TXLivePlayerJSConfig2.url) && this.mPlayer.isPlaying() != 1) {
            apiOnlineLog("Set diff config:[auto play is true, url is not empty, player is not playing], need to start auto play", false);
            startPlayInner(v2TXLivePlayerJSConfig2.url, v2TXLivePlayerJSConfig2.mode);
        }
    }

    private void setFullParams(V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig) {
        apiOnlineLog("Set full config:".concat(String.valueOf(v2TXLivePlayerJSConfig)), true);
        if (v2TXLivePlayerJSConfig.isMuteVideo) {
            this.mPlayer.pauseVideo();
        } else {
            this.mPlayer.resumeVideo();
        }
        if (v2TXLivePlayerJSConfig.isMuteAudio) {
            this.mPlayer.pauseAudio();
        } else {
            this.mPlayer.resumeAudio();
        }
        this.mPlayer.enableReceiveSeiMessage(v2TXLivePlayerJSConfig.enableRecvSEIMessage, 5);
        this.mPlayer.enableReceiveSeiMessage(v2TXLivePlayerJSConfig.enableRecvSEIMessage, 100);
        this.mPlayer.enableReceiveSeiMessage(v2TXLivePlayerJSConfig.enableRecvSEIMessage, 242);
        this.mPlayer.enableReceiveSeiMessage(v2TXLivePlayerJSConfig.enableRecvSEIMessage, 243);
        this.mPlayer.showDebugView(v2TXLivePlayerJSConfig.enableDebugView);
        this.mPlayer.setCacheParams(Math.min(v2TXLivePlayerJSConfig.minCache, v2TXLivePlayerJSConfig.maxCache), Math.max(v2TXLivePlayerJSConfig.minCache, v2TXLivePlayerJSConfig.maxCache));
        this.mPlayer.enableVolumeEvaluation(v2TXLivePlayerJSConfig.volumeNotifyIntervals);
        this.mPlayer.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, Integer.valueOf(v2TXLivePlayerJSConfig.audioRoute));
        this.mPlayer.setRenderFillMode(v2TXLivePlayerJSConfig.fillMode);
        this.mPlayer.setRenderRotation(v2TXLivePlayerJSConfig.renderRotation);
        V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig2 = this.mConfig;
        if (v2TXLivePlayerJSConfig2.isCanAutoPlay && v2TXLivePlayerJSConfig2.isAutoPlay && !TextUtils.isEmpty(v2TXLivePlayerJSConfig2.url)) {
            if (this.mPlayer.isPlaying() == 1) {
                this.mPlayer.stopPlay();
                apiOnlineError("Set full config:[auto play is true, player is playing], need to stop play", false);
            }
            apiOnlineLog("Set full config:[auto play is true, url is not empty, player is not playing], need to start auto play", false);
            V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig3 = this.mConfig;
            startPlayInner(v2TXLivePlayerJSConfig3.url, v2TXLivePlayerJSConfig3.mode);
        }
    }

    private void startPlayInner(String str, int i3) {
        int i16;
        int i17;
        if (TextUtils.isEmpty(str)) {
            apiOnlineError("Start play failed, url is empty", false);
            return;
        }
        boolean z16 = true;
        if (i3 == 1) {
            if ((str.startsWith("http://") || str.startsWith("https://")) && str.contains(".flv")) {
                i16 = 1;
            } else {
                i16 = 0;
            }
        } else {
            i16 = 5;
        }
        apiOnlineLog("Start play,[url:" + str + "][type:" + i16 + "]", false);
        this.mPlayMode = V2TXLiveUtils.parseLiveMode(str);
        V2TXLivePlayer v2TXLivePlayer = this.mPlayer;
        if (i16 != 5) {
            z16 = false;
        }
        v2TXLivePlayer.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableRTMPAcc, Boolean.valueOf(z16));
        if (!str.startsWith(V2TXLiveUtils.TRTC_ADDRESS1) && !str.startsWith(V2TXLiveUtils.TRTC_ADDRESS2)) {
            if (str.startsWith("trtc://")) {
                i17 = 9;
            } else {
                i17 = 0;
            }
        } else {
            i17 = 3;
        }
        if (i17 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("framework", i17);
                jSONObject.put(HippyQQConstants.URL_COMPONENT_NAME, 0);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.mPlayer.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetFramework, jSONObject.toString());
        }
        this.mPlayer.startLivePlay(str);
    }

    public V2TXJSAdapterError initLivePlayer(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        }
        callbackSDKVersion();
        return initLivePlayerInner(null, bundle);
    }

    public boolean isMuted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mConfig.isMuteAudio;
    }

    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.mPlayer.isPlaying() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.live2.impl.a.a
    public void onNetworkQuality(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.mNetworkQuality = i3;
        }
    }

    @Override // com.tencent.live2.impl.a.a
    public void onPlayEvent(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) bundle);
            return;
        }
        ITXLivePlayListener iTXLivePlayListener = this.mPlayListener;
        if (iTXLivePlayListener != null) {
            apiOnlineLog("OnPlayEvent: event[" + i3 + "], msg[" + bundle.toString() + "]", false);
            iTXLivePlayListener.onPlayEvent(i3, bundle);
        }
    }

    @Override // com.tencent.live2.impl.a.a
    public void onPlayNetStatus(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
            return;
        }
        if (bundle != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_QUALITY_LEVEL, this.mNetworkQuality);
        }
        ITXLivePlayListener iTXLivePlayListener = this.mPlayListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onNetStatus(bundle);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayerObserver
    public void onPlayoutVolumeUpdate(V2TXLivePlayer v2TXLivePlayer, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) v2TXLivePlayer, i3);
            return;
        }
        TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mAudioVolumeListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i3);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayerObserver
    public void onReceiveSeiMessage(V2TXLivePlayer v2TXLivePlayer, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, v2TXLivePlayer, Integer.valueOf(i3), bArr);
            return;
        }
        ITXLivePlayListener iTXLivePlayListener = this.mPlayListener;
        if (iTXLivePlayListener != null && this.mConfig.enableRecvSEIMessage && bArr.length > 0) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("EVT_MSG", new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            iTXLivePlayListener.onPlayEvent(2012, bundle);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayerObserver
    public void onSnapshotComplete(V2TXLivePlayer v2TXLivePlayer, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) v2TXLivePlayer, (Object) bitmap);
            return;
        }
        TXLivePlayer.ITXSnapshotListener iTXSnapshotListener = this.mSnapshotListener;
        if (iTXSnapshotListener == null) {
            return;
        }
        apiOnlineLog("OnSnapshotComplete image:".concat(String.valueOf(bitmap)), false);
        if (bitmap != null) {
            if (this.mNeedCompressSnapshot) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.setScale(0.5f, 0.5f);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
                iTXSnapshotListener.onSnapshot(createBitmap);
                if (createBitmap != null && !createBitmap.isRecycled()) {
                    createBitmap.recycle();
                    return;
                }
                return;
            }
            iTXSnapshotListener.onSnapshot(bitmap);
            return;
        }
        iTXSnapshotListener.onSnapshot(bitmap);
    }

    public V2TXJSAdapterError operateLivePlayer(String str, JSONObject jSONObject) {
        boolean z16;
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) jSONObject);
        }
        boolean z17 = false;
        if (TextUtils.isEmpty(str)) {
            apiOnlineError("Call operate failed, operate name is null", false);
            return new V2TXJSAdapterError(-1, "Call operate failed, operate name is null");
        }
        if (!str.equals("start") && !str.equals("stop") && !str.equals("resume") && !str.equals("pause") && !str.equals("mute")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!this.mIsInit) {
            apiOnlineError("Call operate failed, player is not initialized, operate name:".concat(str), z16);
            return new V2TXJSAdapterError(-3, "Call operate failed, player is not initialized");
        }
        if (z16) {
            apiOnlineLog("Call operate [name:" + str + "]", true);
        }
        if (str.equalsIgnoreCase("play")) {
            V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig = this.mConfig;
            startPlayInner(v2TXLivePlayerJSConfig.url, v2TXLivePlayerJSConfig.mode);
        } else if (str.equalsIgnoreCase("stop")) {
            this.mPlayer.stopPlay();
        } else if (str.equalsIgnoreCase("pause")) {
            this.mPlayer.pauseAudio();
            this.mPlayer.pauseVideo();
        } else if (str.equalsIgnoreCase("resume")) {
            if (!this.mConfig.isMuteAudio) {
                this.mPlayer.resumeAudio();
            }
            this.mPlayer.resumeVideo();
        } else if (str.equalsIgnoreCase("mute")) {
            V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig2 = this.mConfig;
            boolean z18 = !v2TXLivePlayerJSConfig2.isMuteAudio;
            v2TXLivePlayerJSConfig2.isMuteAudio = z18;
            if (z18) {
                this.mPlayer.pauseAudio();
            } else {
                this.mPlayer.resumeAudio();
            }
        } else if (str.equalsIgnoreCase("snapshot")) {
            if (jSONObject != null && (optString = jSONObject.optString(CustomImageProps.QUALITY)) != null && optString.equalsIgnoreCase("compressed")) {
                z17 = true;
            }
            takePhoto(z17, this.mSnapshotListener);
        } else {
            return new V2TXJSAdapterError(-4, "Call operate failed, invalid operate name:".concat(str));
        }
        return new V2TXJSAdapterError();
    }

    public void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iTXAudioVolumeEvaluationListener);
        } else {
            this.mAudioVolumeListener = iTXAudioVolumeEvaluationListener;
        }
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTXLivePlayListener);
        } else {
            this.mPlayListener = iTXLivePlayListener;
        }
    }

    public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iTXSnapshotListener);
        } else {
            this.mSnapshotListener = iTXSnapshotListener;
        }
    }

    public V2TXJSAdapterError setSurface(Surface surface) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 13, (Object) this, (Object) surface);
        }
        StringBuilder sb5 = new StringBuilder("Set surface:");
        if (surface != null) {
            obj = Integer.valueOf(surface.hashCode());
        } else {
            obj = "0";
        }
        sb5.append(obj);
        apiOnlineLog(sb5.toString(), false);
        this.mPlayer.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, surface);
        return new V2TXJSAdapterError();
    }

    public V2TXJSAdapterError setSurfaceSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        apiOnlineLog("Set surface size [width:" + i3 + "][height:" + i16 + "]", false);
        this.mPlayer.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, new V2TXLiveDefInner.SurfaceSize(i3, i16));
        return new V2TXJSAdapterError();
    }

    public void takePhoto(boolean z16, TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), iTXSnapshotListener);
            return;
        }
        this.mNeedCompressSnapshot = z16;
        this.mSnapshotListener = iTXSnapshotListener;
        int snapshot = this.mPlayer.snapshot();
        apiOnlineLog("Snapshot, image compress:".concat(String.valueOf(z16)), false);
        ITXLivePlayListener iTXLivePlayListener = this.mPlayListener;
        if (iTXLivePlayListener != null && snapshot != 0) {
            Bundle bundle = new Bundle();
            apiOnlineLog("OnPlayEvent: event[-3], msg[" + bundle.toString() + "]", false);
            iTXLivePlayListener.onPlayEvent(-3, bundle);
        }
    }

    public V2TXJSAdapterError uninitLivePlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (!this.mIsInit) {
            apiOnlineError("Uninit player failed, player is not initialized", false);
            return new V2TXJSAdapterError(-3, "Uninit player failed, player is not initialized");
        }
        apiOnlineLog("Uninit player success", false);
        this.mIsInit = false;
        this.mPlayer.stopPlay();
        return new V2TXJSAdapterError();
    }

    public V2TXJSAdapterError updateLivePlayer(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        }
        if (bundle == null) {
            apiOnlineError("Update player params failed, params is null", false);
            return new V2TXJSAdapterError(-1, "Update player params failed, params is null");
        }
        if (!this.mIsInit) {
            apiOnlineError("Update player params failed, player not initialized", false);
            return new V2TXJSAdapterError(-3, "Update player params failed, player not initialized");
        }
        V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig = new V2TXLivePlayerJSConfig(this.mConfig);
        v2TXLivePlayerJSConfig.updateFromBundle(bundle);
        setDiffParams(this.mConfig, v2TXLivePlayerJSConfig);
        if (!TextUtils.isEmpty(v2TXLivePlayerJSConfig.url) && !v2TXLivePlayerJSConfig.url.equals(this.mConfig.url)) {
            this.mPlayerId = getPlayerIdByURL(v2TXLivePlayerJSConfig.url);
        }
        this.mConfig = v2TXLivePlayerJSConfig;
        return new V2TXJSAdapterError();
    }

    public V2TXJSAdapterError initLivePlayer(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 6, (Object) this, (Object) tXCloudVideoView, (Object) bundle);
        }
        if (tXCloudVideoView == null) {
            return new V2TXJSAdapterError(-1, "Init player failed, view is null");
        }
        return initLivePlayerInner(tXCloudVideoView, bundle);
    }
}
