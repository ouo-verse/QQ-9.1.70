package com.tencent.live2.jsplugin.pusher;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.live2.impl.V2TXLivePusherImpl;
import com.tencent.live2.impl.V2TXLiveUtils;
import com.tencent.live2.impl.a.b;
import com.tencent.live2.jsplugin.JSAdapterOnlineLog;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.live2.jsplugin.player.V2TXLivePlayerJSConfig;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import common.config.service.QzoneConfig;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class V2TXLivePusherJSAdapter extends b implements TXAudioEffectManager.TXMusicPlayObserver {
    static IPatchRedirector $redirector_ = null;
    private static final int ANDROID_DISPLAY_OBTAIN_METHOD_MODE = 1;
    private static final int BGM_ID = 1234567;
    private static final int FRAMEWORK_TYPE_LIVEV2_WXAPPLET = 9;
    private static final int FRAMEWORK_TYPE_WXROOM_WXAPPLET = 3;
    public static final int PUSH_MODE_HIGH_QUALITY = 2;
    public static final int PUSH_MODE_HVGA_QUALITY = 9;
    public static final int PUSH_MODE_LINKMIC_MAIN = 4;
    public static final int PUSH_MODE_LINKMIC_SUB = 5;
    public static final int PUSH_MODE_QVGA_QUALITY = 8;
    public static final int PUSH_MODE_REALTIME = 6;
    public static final int PUSH_MODE_STANDARD_QUALITY = 1;
    public static final int PUSH_MODE_SUPER_QUALITY = 3;
    public static final int PUSH_MODE_ULTRA_QUALITY = 7;
    private static final int ROOM_PUSHER_MODE = 102;
    private static final int RTMP_PUSHER_MODE = 0;
    private static final String TAG = "applet-pusher-api";
    private static final int TRTC_PUSHER_MODE = 1;
    private static final int VIDEO_ASPECT_3X4 = 1;
    private static final int VIDEO_ASPECT_9X16 = 2;
    private static Constructor<?> mConstructor;
    private TXLivePusher.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
    private TXLivePusher.OnBGMNotify mBGMNotifyListener;
    private int mBGMVolume;
    private V2TXLivePusherJSConfig mConfig;
    private Context mContext;
    private boolean mEnableCamera;
    private boolean mEnableCustomVideoCapture;
    private boolean mIsBGMPlaying;
    private boolean mIsBGMPlayingWhenPausePusher;
    private boolean mIsCameraOpened;
    private boolean mIsFlashLightOpened;
    private boolean mIsInit;
    private boolean mIsMicrophoneOpened;
    private int mLastAngle;
    private ITXLivePushListener mLivePushListener;
    private final List<String> mMainStreamUserIdList;
    private Handler mMainThreadHandler;
    private int mMicVolume;
    private boolean mNeedCompressSnapshot;
    private int mNetworkQuality;
    private V2TXLivePusher mPusher;
    private V2TXLiveDef.V2TXLiveMode mPusherMode;
    private V2TXLiveProtocolType mRTCProtocolType;
    private TXLivePusher.ITXSnapshotListener mSnapshotListener;
    private final List<String> mSubStreamUserIdList;
    private Surface mSurface;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private String mTraceId;
    private TXLivePusher.VideoCustomProcessListener mVideoCustomProcessListener;
    private TXCloudVideoView mVideoView;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveProtocolType {
        private static final /* synthetic */ V2TXLiveProtocolType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveProtocolType V2TXLiveProtocolTypeROOM;
        public static final V2TXLiveProtocolType V2TXLiveProtocolTypeRTMP;
        public static final V2TXLiveProtocolType V2TXLiveProtocolTypeTRTC;
        public static final V2TXLiveProtocolType V2TXLiveProtocolTypeWEBRTC;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16664);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveProtocolType v2TXLiveProtocolType = new V2TXLiveProtocolType("V2TXLiveProtocolTypeROOM", 0);
            V2TXLiveProtocolTypeROOM = v2TXLiveProtocolType;
            V2TXLiveProtocolType v2TXLiveProtocolType2 = new V2TXLiveProtocolType("V2TXLiveProtocolTypeTRTC", 1);
            V2TXLiveProtocolTypeTRTC = v2TXLiveProtocolType2;
            V2TXLiveProtocolType v2TXLiveProtocolType3 = new V2TXLiveProtocolType("V2TXLiveProtocolTypeRTMP", 2);
            V2TXLiveProtocolTypeRTMP = v2TXLiveProtocolType3;
            V2TXLiveProtocolType v2TXLiveProtocolType4 = new V2TXLiveProtocolType("V2TXLiveProtocolTypeWEBRTC", 3);
            V2TXLiveProtocolTypeWEBRTC = v2TXLiveProtocolType4;
            $VALUES = new V2TXLiveProtocolType[]{v2TXLiveProtocolType, v2TXLiveProtocolType2, v2TXLiveProtocolType3, v2TXLiveProtocolType4};
        }

        V2TXLiveProtocolType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveProtocolType valueOf(String str) {
            return (V2TXLiveProtocolType) Enum.valueOf(V2TXLiveProtocolType.class, str);
        }

        public static V2TXLiveProtocolType[] values() {
            return (V2TXLiveProtocolType[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 39)) {
            redirector.redirect((short) 39);
            return;
        }
        SoLoader.loadAllLibraries();
        try {
            int i3 = V2TXLivePusherImpl.f119784a;
            Constructor<?> declaredConstructor = V2TXLivePusherImpl.class.getDeclaredConstructor(Context.class, Integer.TYPE);
            mConstructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
        } catch (Exception e16) {
            LiteavLog.e(TAG, "Constructor pusher failed, exception:".concat(String.valueOf(e16)));
        }
    }

    public V2TXLivePusherJSAdapter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mEnableCamera = true;
        this.mBGMVolume = -1;
        this.mMicVolume = -1;
        this.mLastAngle = 0;
        this.mTraceId = "";
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mContext = context.getApplicationContext();
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mConfig = new V2TXLivePusherJSConfig();
        this.mMainStreamUserIdList = new ArrayList();
        this.mSubStreamUserIdList = new ArrayList();
        this.mNetworkQuality = 2;
        if (context instanceof Activity) {
            i.a().a((Activity) context);
        }
    }

    private void apiOnlineError(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.mTraceId)) {
            this.mTraceId = String.valueOf(hashCode()).substring(String.valueOf(hashCode()).length() - 4);
        }
        if (z16) {
            JSAdapterOnlineLog.getInstance().log("[applet-pusher-api][" + this.mTraceId + "]: " + str, true);
            return;
        }
        LiteavLog.e(TAG, "[" + this.mTraceId + "]: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apiOnlineLog(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.mTraceId)) {
            this.mTraceId = String.valueOf(hashCode()).substring(String.valueOf(hashCode()).length() - 4);
        }
        if (z16) {
            JSAdapterOnlineLog.getInstance().log("[applet-pusher-api][" + this.mTraceId + "]: " + str, true);
            return;
        }
        LiteavLog.i(TAG, "[" + this.mTraceId + "]: " + str);
    }

    private void callbackSDKVersion() {
        if (this.mLivePushListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
            bundle.putLong("EVT_TIME", System.currentTimeMillis());
            apiOnlineLog("OnPushEvent: event[-9999999], msg[" + bundle.toString() + "]", false);
            this.mLivePushListener.onPushEvent(V2TXJSAdapterConstants.EVT_ID_SDK_VERSION, bundle);
        }
    }

    private void createPusherInstance(int i3) {
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher != null) {
            v2TXLivePusher.release();
        }
        try {
            V2TXLivePusher v2TXLivePusher2 = (V2TXLivePusher) mConstructor.newInstance(this.mContext, Integer.valueOf(i3));
            this.mPusher = v2TXLivePusher2;
            if (i3 == 0) {
                this.mPusherMode = V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP;
            } else {
                this.mPusherMode = V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
                this.mRTCProtocolType = i3 == 102 ? V2TXLiveProtocolType.V2TXLiveProtocolTypeROOM : V2TXLiveProtocolType.V2TXLiveProtocolTypeTRTC;
            }
            v2TXLivePusher2.setObserver(this);
            this.mPusher.enableCustomVideoCapture(this.mEnableCustomVideoCapture);
            this.mPusher.enableCustomVideoProcess(this.mVideoCustomProcessListener != null, V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D, V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture);
            this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetDisplayRotationObtainMethod, 1);
        } catch (Exception e16) {
            LiteavLog.e(TAG, "Init pusher failed, exception:" + e16 + ", mode:" + i3);
        }
    }

    private void doSetVideoEncParam(int i3, int i16, int i17, int i18, int i19, int i26, boolean z16) {
        int i27;
        if (i17 == 0) {
            i17 = 900;
        }
        if (i18 == 0) {
            i18 = 500;
        }
        if (i18 > i17) {
            int i28 = i18;
            i18 = i17;
            i17 = i28;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("videoWidth", i3);
            jSONObject.put("videoHeight", i16);
            jSONObject.put("videoFps", i19);
            jSONObject.put("videoBitrate", i17);
            jSONObject.put("minVideoBitrate", i18);
            jSONObject.put("videoGop", i26);
            if (z16) {
                i27 = 0;
            } else {
                i27 = 1;
            }
            jSONObject.put("resolutionMode", i27);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        this.mPusher.setProperty(V2TXLiveProperty.kV2SetVideoQualityEx, jSONObject.toString());
    }

    private String generateURL(String str, int i3) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(V2TXLiveUtils.TRTC_ADDRESS1);
        sb5.append("?userid=");
        sb5.append(str);
        sb5.append("&streamtype=");
        if (i3 == 2) {
            str2 = "aux";
        } else {
            str2 = "main";
        }
        sb5.append(str2);
        return sb5.toString();
    }

    private JSONObject getAudioAvailableJSONObject(String str, String str2, boolean z16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userid", str);
            jSONObject.put("playurl", str2);
            jSONObject.put("hasaudio", z16);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject getUserJSONObject(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userid", str);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject getVideoAvailableJSONObject(String str, String str2, int i3, boolean z16) {
        String str3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userid", str);
            jSONObject.put("playurl", str2);
            if (i3 == 2) {
                str3 = "aux";
            } else {
                str3 = "main";
            }
            jSONObject.put("streamtype", str3);
            jSONObject.put("hasvideo", z16);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private V2TXJSAdapterError initLivePusherInner(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        JSAdapterOnlineLog.getInstance().updateUrl("");
        if (bundle == null) {
            apiOnlineError("Init pusher failed, params is null", false);
            return new V2TXJSAdapterError(-1, "Init pusher failed, params is null");
        }
        if (this.mIsInit) {
            apiOnlineError("Init pusher failed, pusher has been initialized", false);
            return new V2TXJSAdapterError(-1, "Init pusher failed, pusher has been initialized");
        }
        this.mIsInit = true;
        this.mVideoView = tXCloudVideoView;
        this.mConfig.updateFromBundle(bundle);
        if (TextUtils.isEmpty(this.mConfig.url)) {
            apiOnlineLog("Init default rtmp pusher instance, url is empty", false);
            createPusherInstance(0);
        } else {
            createPusherInstance(this.mConfig.url);
        }
        apiOnlineLog("Init pusher success, params:" + bundle.toString(), true);
        setFullParam(this.mConfig);
        if (this.mConfig.isAutoPush) {
            apiOnlineLog("Init pusher, [auto push is true, url is not empty, pusher is not pushing], need to start auto push", false);
            startPushInner(this.mConfig.url);
        }
        return new V2TXJSAdapterError();
    }

    private boolean isRTCProtocolType() {
        if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC) {
            return true;
        }
        return false;
    }

    private boolean isRTCRoomProtocolType() {
        if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC && this.mRTCProtocolType == V2TXLiveProtocolType.V2TXLiveProtocolTypeROOM) {
            return true;
        }
        return false;
    }

    private void notifyFullUserList() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("userlist", jSONArray);
            synchronized (this) {
                for (String str : this.mMainStreamUserIdList) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("userid", str);
                    jSONObject2.put("playurl", generateURL(str, 0));
                    jSONArray.mo162put(jSONObject2);
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONObject.put("userlist_aux", jSONArray2);
            synchronized (this) {
                for (String str2 : this.mSubStreamUserIdList) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("userid", str2);
                    jSONObject3.put("playurl", generateURL(str2, 2));
                    jSONArray2.mo162put(jSONObject3);
                }
            }
            sendEventNotify(1020, jSONObject, false);
        } catch (Exception e16) {
            LiteavLog.e(TAG, "Notify full user list failed", e16);
        }
    }

    private V2TXJSAdapterError pause(JSONObject jSONObject) {
        apiOnlineLog("Pause push, camera enable:" + this.mIsCameraOpened + ", microphone enable:" + this.mIsMicrophoneOpened, true);
        if (!TextUtils.isEmpty(this.mConfig.backgroundImagePath)) {
            this.mPusher.startVirtualCamera(BitmapFactory.decodeFile(this.mConfig.backgroundImagePath));
        } else {
            this.mPusher.pauseVideo();
        }
        if (!this.mConfig.isVOIP) {
            this.mPusher.pauseAudio();
        }
        boolean z16 = this.mIsBGMPlaying;
        this.mIsBGMPlayingWhenPausePusher = z16;
        if (z16) {
            operateLivePusher("pauseBGM", null);
        }
        return new V2TXJSAdapterError();
    }

    private V2TXJSAdapterError playBGM(JSONObject jSONObject) {
        String str = "";
        long j3 = 0;
        long j16 = -1;
        if (jSONObject != null) {
            str = jSONObject.optString("BGMFilePath", "");
            j3 = jSONObject.optLong("startTimeMs", 0L);
            j16 = jSONObject.optLong("endTimeMs", -1L);
        }
        if (TextUtils.isEmpty(str)) {
            apiOnlineError("Play BGM failed, bgm url is empty", false);
            return new V2TXJSAdapterError(-2, "Play BGM failed, bgm url is empty");
        }
        this.mIsBGMPlaying = true;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(BGM_ID, str);
        audioMusicParam.publish = true;
        audioMusicParam.startTimeMS = j3;
        audioMusicParam.endTimeMS = j16;
        this.mPusher.getAudioEffectManager().setMusicObserver(BGM_ID, this);
        this.mPusher.getAudioEffectManager().startPlayMusic(audioMusicParam);
        if (this.mBGMVolume != -1) {
            this.mPusher.getAudioEffectManager().setAllMusicVolume(this.mBGMVolume);
        }
        if (this.mMicVolume != -1) {
            this.mPusher.getAudioEffectManager().setVoiceCaptureVolume(this.mMicVolume);
        }
        return new V2TXJSAdapterError();
    }

    private void processAudioConfig(V2TXLivePusherJSConfig v2TXLivePusherJSConfig, V2TXLivePusherJSConfig v2TXLivePusherJSConfig2) {
        boolean z16 = v2TXLivePusherJSConfig.isMuteAudio;
        boolean z17 = v2TXLivePusherJSConfig2.isMuteAudio;
        if (z16 != z17) {
            if (z17) {
                this.mPusher.pauseAudio();
            } else {
                this.mPusher.resumeAudio();
            }
        }
        boolean z18 = v2TXLivePusherJSConfig.enableANS;
        boolean z19 = v2TXLivePusherJSConfig2.enableANS;
        if (z18 != z19) {
            this.mPusher.setProperty("enableANS", String.format("{\"enable\": %b, \"level\":%d}", Boolean.valueOf(z19), 100));
        }
        if (v2TXLivePusherJSConfig.enableEarMonitor != v2TXLivePusherJSConfig2.enableEarMonitor) {
            this.mPusher.getAudioEffectManager().enableVoiceEarMonitor(v2TXLivePusherJSConfig2.enableEarMonitor);
        }
        int i3 = v2TXLivePusherJSConfig.volumeNotifyIntervals;
        int i16 = v2TXLivePusherJSConfig2.volumeNotifyIntervals;
        if (i3 != i16) {
            this.mPusher.enableVolumeEvaluation(i16);
        }
        if (v2TXLivePusherJSConfig.volumeType != v2TXLivePusherJSConfig2.volumeType) {
            this.mPusher.getDeviceManager().setSystemVolumeType(v2TXLivePusherJSConfig2.volumeType);
        }
        if (v2TXLivePusherJSConfig.reverbType != v2TXLivePusherJSConfig2.reverbType) {
            this.mPusher.getAudioEffectManager().setVoiceReverbType(v2TXLivePusherJSConfig2.reverbType);
        }
        if (v2TXLivePusherJSConfig.voiceChangerType != v2TXLivePusherJSConfig2.voiceChangerType) {
            this.mPusher.getAudioEffectManager().setVoiceChangerType(v2TXLivePusherJSConfig2.voiceChangerType);
        }
        V2TXLiveDef.V2TXLiveAudioQuality v2TXLiveAudioQuality = v2TXLivePusherJSConfig.audioQuality;
        V2TXLiveDef.V2TXLiveAudioQuality v2TXLiveAudioQuality2 = v2TXLivePusherJSConfig2.audioQuality;
        if (v2TXLiveAudioQuality != v2TXLiveAudioQuality2) {
            this.mPusher.setAudioQuality(v2TXLiveAudioQuality2);
        }
        boolean z26 = v2TXLivePusherJSConfig.enableMicrophone;
        boolean z27 = v2TXLivePusherJSConfig2.enableMicrophone;
        if (z26 != z27) {
            if (z27) {
                startMicrophoneInner();
                return;
            } else {
                stopMicrophoneInner();
                return;
            }
        }
        if (z27 && !this.mIsMicrophoneOpened) {
            startMicrophoneInner();
        }
    }

    private void processBeautyConfig(V2TXLivePusherJSConfig v2TXLivePusherJSConfig, V2TXLivePusherJSConfig v2TXLivePusherJSConfig2) {
        if (v2TXLivePusherJSConfig.beautyStyle != v2TXLivePusherJSConfig2.beautyStyle) {
            this.mPusher.getBeautyManager().setBeautyStyle(v2TXLivePusherJSConfig2.beautyStyle);
        }
        if (v2TXLivePusherJSConfig.beautyLevel != v2TXLivePusherJSConfig2.beautyLevel) {
            this.mPusher.getBeautyManager().setBeautyLevel(v2TXLivePusherJSConfig2.beautyLevel);
        }
        if (v2TXLivePusherJSConfig.whitenessLevel != v2TXLivePusherJSConfig2.whitenessLevel) {
            this.mPusher.getBeautyManager().setWhitenessLevel(v2TXLivePusherJSConfig2.whitenessLevel);
        }
        String str = v2TXLivePusherJSConfig2.filterImagePath;
        if (str != null && !str.equals(v2TXLivePusherJSConfig.filterImagePath)) {
            if (TextUtils.isEmpty(v2TXLivePusherJSConfig2.filterImagePath)) {
                this.mPusher.getBeautyManager().setFilter(null);
            } else {
                this.mPusher.getBeautyManager().setFilter(BitmapFactory.decodeFile(v2TXLivePusherJSConfig2.filterImagePath));
            }
        }
    }

    private void processVideoConfig(V2TXLivePusherJSConfig v2TXLivePusherJSConfig, V2TXLivePusherJSConfig v2TXLivePusherJSConfig2) {
        if (v2TXLivePusherJSConfig.isFrontCamera != v2TXLivePusherJSConfig2.isFrontCamera) {
            this.mPusher.getDeviceManager().switchCamera(v2TXLivePusherJSConfig2.isFrontCamera);
        }
        if (v2TXLivePusherJSConfig.enableAutoFocus != v2TXLivePusherJSConfig2.enableAutoFocus) {
            this.mPusher.getDeviceManager().enableCameraAutoFocus(v2TXLivePusherJSConfig2.enableAutoFocus);
        }
        boolean z16 = v2TXLivePusherJSConfig.enableZoom;
        boolean z17 = v2TXLivePusherJSConfig2.enableZoom;
        if (z16 != z17) {
            this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableCameraZoom, Boolean.valueOf(z17));
        }
        boolean z18 = v2TXLivePusherJSConfig.enableRemoteMirror;
        boolean z19 = v2TXLivePusherJSConfig2.enableRemoteMirror;
        if (z18 != z19) {
            this.mPusher.setEncoderMirror(z19);
        }
        V2TXLiveDef.V2TXLiveMirrorType v2TXLiveMirrorType = v2TXLivePusherJSConfig.mirrorType;
        V2TXLiveDef.V2TXLiveMirrorType v2TXLiveMirrorType2 = v2TXLivePusherJSConfig2.mirrorType;
        if (v2TXLiveMirrorType != v2TXLiveMirrorType2) {
            this.mPusher.setRenderMirror(v2TXLiveMirrorType2);
        }
        boolean z26 = v2TXLivePusherJSConfig.isVerticalOrientation;
        boolean z27 = v2TXLivePusherJSConfig2.isVerticalOrientation;
        if (z26 != z27) {
            if (z27) {
                this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kEnableAdjustEncoderDirectionToUIOrientation, Boolean.TRUE);
            } else {
                this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kEnableAdjustEncoderDirectionToUIOrientation, Boolean.FALSE);
            }
        }
        if (v2TXLivePusherJSConfig.isVerticalOrientation != v2TXLivePusherJSConfig2.isVerticalOrientation || v2TXLivePusherJSConfig.aspect != v2TXLivePusherJSConfig2.aspect || v2TXLivePusherJSConfig.width != v2TXLivePusherJSConfig2.width || v2TXLivePusherJSConfig.height != v2TXLivePusherJSConfig2.height || v2TXLivePusherJSConfig.mode != v2TXLivePusherJSConfig2.mode || v2TXLivePusherJSConfig.minBitrate != v2TXLivePusherJSConfig2.minBitrate || v2TXLivePusherJSConfig.maxBitrate != v2TXLivePusherJSConfig2.maxBitrate || v2TXLivePusherJSConfig.fps != v2TXLivePusherJSConfig2.fps) {
            setVideoEncParam(v2TXLivePusherJSConfig2);
        }
        boolean z28 = v2TXLivePusherJSConfig2.enableCamera;
        this.mEnableCamera = z28;
        if (v2TXLivePusherJSConfig.enableCamera != z28) {
            if (z28) {
                startCameraInner(v2TXLivePusherJSConfig2.isFrontCamera);
                return;
            } else {
                stopCameraInner();
                return;
            }
        }
        if (z28 && !this.mIsCameraOpened) {
            startCameraInner(v2TXLivePusherJSConfig2.isFrontCamera);
        }
    }

    private void processWatermarkConfig(V2TXLivePusherJSConfig v2TXLivePusherJSConfig, V2TXLivePusherJSConfig v2TXLivePusherJSConfig2) {
        String str = v2TXLivePusherJSConfig2.watermarkImagePath;
        if ((str != null && !str.equals(v2TXLivePusherJSConfig.watermarkImagePath)) || v2TXLivePusherJSConfig.watermarkWidth != v2TXLivePusherJSConfig2.watermarkWidth || v2TXLivePusherJSConfig.watermarkLeft != v2TXLivePusherJSConfig2.watermarkLeft || v2TXLivePusherJSConfig.watermarkTop != v2TXLivePusherJSConfig2.watermarkTop) {
            if (TextUtils.isEmpty(v2TXLivePusherJSConfig2.watermarkImagePath)) {
                this.mPusher.setWatermark(null, 0.0f, 0.0f, 0.0f);
            } else {
                this.mPusher.setWatermark(BitmapFactory.decodeFile(v2TXLivePusherJSConfig2.watermarkImagePath), v2TXLivePusherJSConfig2.watermarkLeft, v2TXLivePusherJSConfig2.watermarkTop, v2TXLivePusherJSConfig2.watermarkWidth);
            }
        }
    }

    private V2TXJSAdapterError resume(JSONObject jSONObject) {
        apiOnlineLog("Resume push", true);
        this.mPusher.stopVirtualCamera();
        if (this.mConfig.isMuteAudio) {
            this.mPusher.pauseAudio();
        } else {
            this.mPusher.resumeAudio();
        }
        this.mPusher.resumeVideo();
        if (this.mIsBGMPlayingWhenPausePusher) {
            operateLivePusher("resumeBGM", null);
        }
        return new V2TXJSAdapterError();
    }

    private void sendEventNotify(int i3, String str) {
        ITXLivePushListener iTXLivePushListener = this.mLivePushListener;
        if (iTXLivePushListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("EVT_MSG", str);
            apiOnlineLog("OnPushEvent: event[" + i3 + "], msg[" + bundle.toString() + "]", false);
            iTXLivePushListener.onPushEvent(i3, bundle);
        }
    }

    private V2TXJSAdapterError sendMessage(JSONObject jSONObject) {
        String str;
        int i3;
        if (jSONObject != null) {
            str = jSONObject.optString("msg");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return new V2TXJSAdapterError(-2, "Send SEI message failed, message is empty");
        }
        try {
            if (isRTCRoomProtocolType()) {
                i3 = 243;
            } else {
                i3 = 242;
            }
            this.mPusher.sendSeiMessage(i3, str.getBytes("UTF-8"));
        } catch (Exception e16) {
            apiOnlineLog("Send SEI message failed, error:" + e16.getMessage(), false);
        }
        return new V2TXJSAdapterError(0, "Success");
    }

    private V2TXJSAdapterError setBGMVolume(JSONObject jSONObject) {
        double d16 = 1.0d;
        if (jSONObject != null) {
            d16 = jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, 1.0d);
        }
        this.mBGMVolume = (int) (d16 * 100.0d);
        this.mPusher.getAudioEffectManager().setAllMusicVolume(this.mBGMVolume);
        return new V2TXJSAdapterError();
    }

    private void setDiffParam(V2TXLivePusherJSConfig v2TXLivePusherJSConfig, V2TXLivePusherJSConfig v2TXLivePusherJSConfig2) {
        String diffConfig = v2TXLivePusherJSConfig2.diffConfig(v2TXLivePusherJSConfig);
        if (!TextUtils.isEmpty(diffConfig)) {
            apiOnlineLog("Set diff config:".concat(String.valueOf(diffConfig)), true);
        }
        boolean z16 = v2TXLivePusherJSConfig.enableDebugView;
        boolean z17 = v2TXLivePusherJSConfig2.enableDebugView;
        if (z16 != z17) {
            this.mPusher.showDebugView(z17);
        }
        processVideoConfig(v2TXLivePusherJSConfig, v2TXLivePusherJSConfig2);
        processAudioConfig(v2TXLivePusherJSConfig, v2TXLivePusherJSConfig2);
        processBeautyConfig(v2TXLivePusherJSConfig, v2TXLivePusherJSConfig2);
        processWatermarkConfig(v2TXLivePusherJSConfig, v2TXLivePusherJSConfig2);
        if (v2TXLivePusherJSConfig2.isAutoPush && !TextUtils.isEmpty(v2TXLivePusherJSConfig2.url) && this.mPusher.isPushing() != 1) {
            JSAdapterOnlineLog.getInstance().updateUrl(v2TXLivePusherJSConfig2.url);
            apiOnlineLog("Set diff config:[auto push is true, url is not empty, pusher is not pushing], need to start auto push", false);
            startPushInner(v2TXLivePusherJSConfig2.url);
        }
    }

    private void setFullParam(V2TXLivePusherJSConfig v2TXLivePusherJSConfig) {
        apiOnlineLog("Set full config:".concat(String.valueOf(v2TXLivePusherJSConfig)), true);
        this.mPusher.showDebugView(v2TXLivePusherJSConfig.enableDebugView);
        this.mPusher.getDeviceManager().enableCameraAutoFocus(v2TXLivePusherJSConfig.enableAutoFocus);
        this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableCameraZoom, Boolean.valueOf(v2TXLivePusherJSConfig.enableZoom));
        this.mPusher.setEncoderMirror(v2TXLivePusherJSConfig.enableRemoteMirror);
        this.mPusher.setRenderMirror(v2TXLivePusherJSConfig.mirrorType);
        setVideoEncParam(v2TXLivePusherJSConfig);
        TXCloudVideoView tXCloudVideoView = this.mVideoView;
        if (tXCloudVideoView != null) {
            this.mPusher.setRenderView(tXCloudVideoView);
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, surface);
            this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, new V2TXLiveDefInner.SurfaceSize(this.mSurfaceWidth, this.mSurfaceHeight));
        }
        boolean z16 = v2TXLivePusherJSConfig.enableCamera;
        this.mEnableCamera = z16;
        if (z16) {
            startCameraInner(v2TXLivePusherJSConfig.isFrontCamera);
        } else {
            stopCameraInner();
        }
        if (v2TXLivePusherJSConfig.isMuteAudio) {
            this.mPusher.pauseAudio();
        } else {
            this.mPusher.resumeAudio();
        }
        this.mPusher.setProperty("enableANS", String.format("{\"enable\": %b, \"level\":%d}", Boolean.valueOf(v2TXLivePusherJSConfig.enableANS), 100));
        this.mPusher.getAudioEffectManager().enableVoiceEarMonitor(v2TXLivePusherJSConfig.enableEarMonitor);
        this.mPusher.enableVolumeEvaluation(v2TXLivePusherJSConfig.volumeNotifyIntervals);
        this.mPusher.getDeviceManager().setSystemVolumeType(v2TXLivePusherJSConfig.volumeType);
        this.mPusher.getAudioEffectManager().setVoiceReverbType(v2TXLivePusherJSConfig.reverbType);
        this.mPusher.getAudioEffectManager().setVoiceChangerType(v2TXLivePusherJSConfig.voiceChangerType);
        this.mPusher.setAudioQuality(v2TXLivePusherJSConfig.audioQuality);
        if (v2TXLivePusherJSConfig.enableMicrophone) {
            startMicrophoneInner();
        } else {
            stopMicrophoneInner();
        }
        if (v2TXLivePusherJSConfig.isVerticalOrientation) {
            this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kEnableAdjustEncoderDirectionToUIOrientation, Boolean.TRUE);
        } else {
            this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kEnableAdjustEncoderDirectionToUIOrientation, Boolean.FALSE);
        }
        this.mPusher.getBeautyManager().setBeautyStyle(v2TXLivePusherJSConfig.beautyStyle);
        this.mPusher.getBeautyManager().setBeautyLevel(v2TXLivePusherJSConfig.beautyLevel);
        this.mPusher.getBeautyManager().setWhitenessLevel(v2TXLivePusherJSConfig.whitenessLevel);
        if (TextUtils.isEmpty(v2TXLivePusherJSConfig.filterImagePath)) {
            this.mPusher.getBeautyManager().setFilter(null);
        } else {
            this.mPusher.getBeautyManager().setFilter(BitmapFactory.decodeFile(v2TXLivePusherJSConfig.filterImagePath));
        }
        if (TextUtils.isEmpty(v2TXLivePusherJSConfig.watermarkImagePath)) {
            this.mPusher.setWatermark(null, 0.0f, 0.0f, 0.0f);
        } else {
            this.mPusher.setWatermark(BitmapFactory.decodeFile(v2TXLivePusherJSConfig.watermarkImagePath), v2TXLivePusherJSConfig.watermarkLeft, v2TXLivePusherJSConfig.watermarkTop, v2TXLivePusherJSConfig.watermarkWidth);
        }
    }

    private V2TXJSAdapterError setMICVolume(JSONObject jSONObject) {
        double d16 = 1.0d;
        if (jSONObject != null) {
            d16 = jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, 1.0d);
        }
        this.mMicVolume = (int) (d16 * 100.0d);
        this.mPusher.getAudioEffectManager().setVoiceCaptureVolume(this.mMicVolume);
        return new V2TXJSAdapterError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setVideoEncParam(V2TXLivePusherJSConfig v2TXLivePusherJSConfig) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int max;
        int min;
        int i26;
        int max2;
        int min2;
        boolean z17 = false;
        if (this.mPusher == null) {
            apiOnlineError("Set video encoder params failed, pusher is null", false);
            return;
        }
        boolean userLandscapeResolution = userLandscapeResolution(this.mLastAngle, v2TXLivePusherJSConfig.isVerticalOrientation);
        int i27 = v2TXLivePusherJSConfig.fps;
        V2TXLiveDef.V2TXLiveMode v2TXLiveMode = this.mPusherMode;
        if (v2TXLiveMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC) {
            if (!userLandscapeResolution) {
                max2 = Math.min(v2TXLivePusherJSConfig.width, v2TXLivePusherJSConfig.height);
                min2 = Math.max(v2TXLivePusherJSConfig.width, v2TXLivePusherJSConfig.height);
            } else {
                max2 = Math.max(v2TXLivePusherJSConfig.width, v2TXLivePusherJSConfig.height);
                min2 = Math.min(v2TXLivePusherJSConfig.width, v2TXLivePusherJSConfig.height);
            }
            doSetVideoEncParam(max2, min2, v2TXLivePusherJSConfig.maxBitrate, v2TXLivePusherJSConfig.minBitrate, i27, 1, userLandscapeResolution);
            return;
        }
        if (v2TXLiveMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP) {
            int i28 = v2TXLivePusherJSConfig.minBitrate;
            int i29 = 1;
            if (i28 > 0 && v2TXLivePusherJSConfig.maxBitrate > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int min3 = Math.min(i28, v2TXLivePusherJSConfig.maxBitrate);
            int max3 = Math.max(v2TXLivePusherJSConfig.minBitrate, v2TXLivePusherJSConfig.maxBitrate);
            int i36 = v2TXLivePusherJSConfig.mode;
            if (i36 == 6) {
                z17 = true;
            }
            if (z17) {
                i3 = 1;
            } else {
                i3 = 5;
            }
            if (i36 != 2) {
                if (i36 != 3) {
                    i17 = 480;
                    i16 = 368;
                    switch (i36) {
                        case 6:
                            if (!z16) {
                                min3 = 190;
                                max3 = 810;
                            }
                            if (v2TXLivePusherJSConfig.aspect != 1) {
                                i17 = 368;
                            }
                            i18 = min3;
                            i19 = max3;
                            i16 = i17;
                            i17 = 640;
                            break;
                        case 7:
                            if (!z16) {
                                min3 = 3000;
                                max3 = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
                            }
                            i16 = 1088;
                            i17 = 1920;
                            break;
                        case 8:
                            if (!z16) {
                                min3 = 250;
                                max3 = QidPagView.DESIGN_PAG_WIDTH;
                            }
                            if (v2TXLivePusherJSConfig.aspect == 1) {
                                i26 = 240;
                            } else {
                                i26 = 192;
                            }
                            i16 = i26;
                            i17 = 320;
                            break;
                        case 9:
                            if (!z16) {
                                min3 = 400;
                                max3 = 600;
                            }
                            if (v2TXLivePusherJSConfig.aspect != 1) {
                                i16 = 272;
                                break;
                            }
                            break;
                        default:
                            if (!z16) {
                                min3 = 500;
                                max3 = 900;
                            }
                            i19 = max3;
                            i29 = i3;
                            i17 = 640;
                            i18 = min3;
                            break;
                    }
                    if (userLandscapeResolution) {
                        max = Math.min(i16, i17);
                        min = Math.max(i16, i17);
                    } else {
                        max = Math.max(i16, i17);
                        min = Math.min(i16, i17);
                    }
                    doSetVideoEncParam(max, min, i19, i18, i27, i29, userLandscapeResolution);
                    this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableRealtimeMode, Boolean.valueOf(z17));
                }
                if (!z16) {
                    min3 = 1000;
                    max3 = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
                }
                i16 = 720;
                i17 = 1280;
            } else {
                if (!z16) {
                    min3 = 800;
                    max3 = 1500;
                }
                i16 = TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE;
                i17 = 960;
            }
            i18 = min3;
            i29 = 5;
            i19 = max3;
            if (userLandscapeResolution) {
            }
            doSetVideoEncParam(max, min, i19, i18, i27, i29, userLandscapeResolution);
            this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableRealtimeMode, Boolean.valueOf(z17));
        }
    }

    private V2TXJSAdapterError snapshot(JSONObject jSONObject) {
        String optString;
        this.mNeedCompressSnapshot = false;
        if (jSONObject != null && (optString = jSONObject.optString(CustomImageProps.QUALITY)) != null && optString.equalsIgnoreCase("compressed")) {
            this.mNeedCompressSnapshot = true;
        }
        this.mPusher.snapshot();
        return new V2TXJSAdapterError();
    }

    private V2TXJSAdapterError start(JSONObject jSONObject) {
        apiOnlineLog("Start push, url:" + this.mConfig.url + ", isPushing: " + this.mPusher.isPushing(), true);
        if (this.mPusher.isPushing() != 1 && !TextUtils.isEmpty(this.mConfig.url)) {
            startPushInner(this.mConfig.url);
            return new V2TXJSAdapterError();
        }
        apiOnlineError("Start push failed", false);
        return new V2TXJSAdapterError(-2, "Start push failed");
    }

    private void startCameraInner(boolean z16) {
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            apiOnlineError("Start camera failed, pusher is not initialized", false);
            return;
        }
        if (this.mIsCameraOpened) {
            apiOnlineError("Start camera failed, camera has been started", false);
        } else if (this.mEnableCamera) {
            this.mIsCameraOpened = true;
            v2TXLivePusher.startCamera(z16);
        }
    }

    private void startMicrophoneInner() {
        TXDeviceManager.TXAudioRoute tXAudioRoute;
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            apiOnlineError("Start microphone failed, pusher is not initialized", false);
            return;
        }
        if (this.mIsMicrophoneOpened) {
            apiOnlineError("Start microphone failed, microphone has been started", false);
            return;
        }
        this.mIsMicrophoneOpened = true;
        v2TXLivePusher.startMicrophone();
        TXDeviceManager deviceManager = this.mPusher.getDeviceManager();
        if (V2TXLivePlayerJSConfig.sAudioRoute == 0) {
            tXAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
        } else {
            tXAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
        }
        deviceManager.setAudioRoute(tXAudioRoute);
    }

    private V2TXJSAdapterError startPreview(JSONObject jSONObject) {
        apiOnlineLog("Start preview", true);
        if (this.mPusher.isPushing() == 1) {
            apiOnlineLog("Start preview failed, current is pushing", false);
            return new V2TXJSAdapterError(-2, "Start preview failed, current is pushing");
        }
        startCameraInner(this.mConfig.isFrontCamera);
        return new V2TXJSAdapterError();
    }

    private void startPushInner(String str) {
        int i3;
        if (this.mPusher == null) {
            apiOnlineError("Start push failed, pusher is not initialized", false);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            apiOnlineError("Start push failed, url is empty", false);
            return;
        }
        if (this.mConfig.enableMicrophone && !this.mIsMicrophoneOpened) {
            startMicrophoneInner();
        }
        V2TXLivePusherJSConfig v2TXLivePusherJSConfig = this.mConfig;
        if (v2TXLivePusherJSConfig.enableCamera && !this.mIsCameraOpened) {
            startCameraInner(v2TXLivePusherJSConfig.isFrontCamera);
        }
        if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC) {
            if (isRTCRoomProtocolType()) {
                i3 = 3;
            } else {
                i3 = 9;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("framework", i3);
                jSONObject.put(HippyQQConstants.URL_COMPONENT_NAME, 0);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.mPusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetFramework, jSONObject.toString());
        }
        apiOnlineLog("Start push result:".concat(String.valueOf(this.mPusher.startPush(str))), false);
    }

    private void stopCameraInner() {
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            apiOnlineError("Stop camera failed, pusher is not initialized", false);
        } else if (!this.mIsCameraOpened) {
            apiOnlineError("Stop camera failed, camera has been stopped", false);
        } else {
            this.mIsCameraOpened = false;
            v2TXLivePusher.stopCamera();
        }
    }

    private void stopMicrophoneInner() {
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            apiOnlineError("Stop microphone failed, pusher is not initialized", false);
        } else if (!this.mIsMicrophoneOpened) {
            apiOnlineError("Stop microphone failed, microphone has been stopped", false);
        } else {
            this.mIsMicrophoneOpened = false;
            v2TXLivePusher.stopMicrophone();
        }
    }

    private V2TXJSAdapterError stopPreview(JSONObject jSONObject) {
        apiOnlineLog("Stop preview", true);
        if (this.mPusher.isPushing() == 1) {
            apiOnlineLog("Stop preview failed, current is pushing", false);
            return new V2TXJSAdapterError(-2, "Stop preview failed, current is pushing");
        }
        stopCameraInner();
        return new V2TXJSAdapterError();
    }

    private void stopPushInner(String str) {
        apiOnlineLog(str, true);
        this.mIsBGMPlaying = false;
        this.mIsBGMPlayingWhenPausePusher = false;
        this.mIsFlashLightOpened = false;
        this.mIsMicrophoneOpened = false;
        this.mIsCameraOpened = false;
        this.mBGMVolume = -1;
        this.mMicVolume = -1;
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher != null) {
            v2TXLivePusher.getAudioEffectManager().stopPlayMusic(BGM_ID);
            this.mPusher.getAudioEffectManager().setMusicObserver(BGM_ID, null);
            this.mPusher.stopPush();
        }
    }

    private boolean userLandscapeResolution(int i3, boolean z16) {
        if (i3 == 1) {
            if (!z16) {
                return false;
            }
            return true;
        }
        if (i3 == 3) {
            if (!z16) {
                return false;
            }
            return true;
        }
        if (i3 == 0) {
            if (z16) {
                return false;
            }
            return true;
        }
        if (i3 != 2 || z16) {
            return false;
        }
        return true;
    }

    public int enableCustomVideoCapture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, z16)).intValue();
        }
        apiOnlineLog("Custom video capture, enable:".concat(String.valueOf(z16)), false);
        this.mEnableCustomVideoCapture = z16;
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            return 0;
        }
        return v2TXLivePusher.enableCustomVideoCapture(z16);
    }

    public int getMaxZoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            return 0;
        }
        return (int) v2TXLivePusher.getDeviceManager().getCameraZoomMaxRatio();
    }

    public V2TXJSAdapterError initLivePusher(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        }
        callbackSDKVersion();
        return initLivePusherInner(null, bundle);
    }

    public boolean isPushing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null || v2TXLivePusher.isPushing() != 1) {
            return false;
        }
        return true;
    }

    public void notifyOrientationChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mMainThreadHandler.post(new Runnable(i3) { // from class: com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$angle;

                {
                    this.val$angle = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) V2TXLivePusherJSAdapter.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (V2TXLivePusherJSAdapter.this.mLastAngle != this.val$angle) {
                        V2TXLivePusherJSAdapter.this.apiOnlineLog("Notify orientation changed, [angle:" + this.val$angle + "]", false);
                        V2TXLivePusherJSAdapter.this.mLastAngle = this.val$angle;
                        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = V2TXLivePusherJSAdapter.this;
                        v2TXLivePusherJSAdapter.setVideoEncParam(v2TXLivePusherJSAdapter.mConfig);
                    }
                }
            });
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onComplete(int i3, int i16) {
        TXLivePusher.OnBGMNotify onBGMNotify;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        V2TXLivePusherJSConfig v2TXLivePusherJSConfig = this.mConfig;
        if (BGM_ID == i3 && v2TXLivePusherJSConfig.enableBGMEventCallback && (onBGMNotify = this.mBGMNotifyListener) != null) {
            onBGMNotify.onBGMComplete(i16);
        }
    }

    @Override // com.tencent.live2.impl.a.b
    public void onEnterRoom(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, j3);
            return;
        }
        if (!isRTCRoomProtocolType()) {
            apiOnlineLog("onEnterRoom: isn't room protocol,ignore", false);
            return;
        }
        this.mMainStreamUserIdList.clear();
        this.mSubStreamUserIdList.clear();
        if (j3 > 0) {
            sendEventNotify(1018, "onEnterRoom success, time cost[" + j3 + "]");
            return;
        }
        sendEventNotify(1022, "onEnterRoom failed, error code[" + j3 + "]");
        sendEventNotify(-3301, "onEnterRoom failed, error code[" + j3 + "]");
        if (j3 == -100018) {
            sendEventNotify(-100018, "onEnterRoom failed, user sign invalid.");
        }
    }

    @Override // com.tencent.live2.impl.a.b
    public void onExitRoom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        if (!isRTCRoomProtocolType()) {
            apiOnlineLog("OnExitRoom: isn't room protocol,ignore", false);
            return;
        }
        this.mMainStreamUserIdList.clear();
        this.mSubStreamUserIdList.clear();
        sendEventNotify(1019, "onExitRoom reason[" + i3 + "]");
    }

    @Override // com.tencent.live2.V2TXLivePusherObserver
    public void onGLContextCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            super.onGLContextCreated();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusherObserver
    public void onGLContextDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onTextureDestoryed();
        }
    }

    @Override // com.tencent.live2.V2TXLivePusherObserver
    public void onMicrophoneVolumeUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mAudioVolumeListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i3);
        }
    }

    @Override // com.tencent.live2.impl.a.b
    public void onNetworkQuality(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
        } else {
            this.mNetworkQuality = i3;
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onPlayProgress(int i3, long j3, long j16) {
        TXLivePusher.OnBGMNotify onBGMNotify;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        V2TXLivePusherJSConfig v2TXLivePusherJSConfig = this.mConfig;
        if (BGM_ID == i3 && v2TXLivePusherJSConfig.enableBGMEventCallback && (onBGMNotify = this.mBGMNotifyListener) != null) {
            onBGMNotify.onBGMProgress(j3, j16);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusherObserver
    public int onProcessVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame, V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) v2TXLiveVideoFrame, (Object) v2TXLiveVideoFrame2)).intValue();
        }
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            v2TXLiveVideoFrame2.texture.textureId = videoCustomProcessListener.onTextureCustomProcess(v2TXLiveVideoFrame.texture.textureId, v2TXLiveVideoFrame.width, v2TXLiveVideoFrame.height);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.live2.impl.a.b
    public void onPushEvent(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) bundle);
            return;
        }
        ITXLivePushListener iTXLivePushListener = this.mLivePushListener;
        if (iTXLivePushListener != null) {
            apiOnlineLog("OnPushEvent: event[" + i3 + "], msg[" + bundle.toString() + "]", false);
            iTXLivePushListener.onPushEvent(i3, bundle);
        }
        if (iTXLivePushListener != null && i3 == 1003) {
            V2TXLiveProtocolType v2TXLiveProtocolType = this.mRTCProtocolType;
            if (v2TXLiveProtocolType == V2TXLiveProtocolType.V2TXLiveProtocolTypeROOM || v2TXLiveProtocolType == V2TXLiveProtocolType.V2TXLiveProtocolTypeTRTC) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("EVT_MSG", "Start encoder success.");
                apiOnlineLog("OnPushEvent: event[" + i3 + "], msg[" + bundle2.toString() + "]", false);
                iTXLivePushListener.onPushEvent(1008, bundle2);
            }
        }
    }

    @Override // com.tencent.live2.impl.a.b
    public void onPushNetStatus(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) bundle);
            return;
        }
        if (bundle != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_QUALITY_LEVEL, this.mNetworkQuality);
        }
        ITXLivePushListener iTXLivePushListener = this.mLivePushListener;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onNetStatus(bundle);
        }
    }

    @Override // com.tencent.live2.impl.a.b
    public void onRemoteUserEnter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else if (!isRTCRoomProtocolType()) {
            apiOnlineLog("OnRemoteUserEnter: isn't room protocol,ignore", false);
        } else {
            sendEventNotify(1031, getUserJSONObject(str), true);
        }
    }

    @Override // com.tencent.live2.impl.a.b
    public void onRemoteUserExit(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, i3);
        } else if (!isRTCRoomProtocolType()) {
            apiOnlineLog("OnRemoteUserExit: isn't room protocol,ignore", false);
        } else {
            sendEventNotify(1032, getUserJSONObject(str), true);
        }
    }

    @Override // com.tencent.live2.V2TXLivePusherObserver
    public void onSnapshotComplete(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) bitmap);
            return;
        }
        TXLivePusher.ITXSnapshotListener iTXSnapshotListener = this.mSnapshotListener;
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

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onStart(int i3, int i16) {
        TXLivePusher.OnBGMNotify onBGMNotify;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        V2TXLivePusherJSConfig v2TXLivePusherJSConfig = this.mConfig;
        if (BGM_ID == i3 && v2TXLivePusherJSConfig.enableBGMEventCallback && (onBGMNotify = this.mBGMNotifyListener) != null) {
            onBGMNotify.onBGMStart();
        }
    }

    @Override // com.tencent.live2.impl.a.b
    public void onUserAudioAvailable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, Boolean.valueOf(z16));
        } else if (!isRTCRoomProtocolType()) {
            apiOnlineLog("OnUserAudioAvailable: isn't room protocol,ignore", false);
        } else {
            sendEventNotify(1034, getAudioAvailableJSONObject(str, generateURL(str, 0), z16), true);
        }
    }

    @Override // com.tencent.live2.impl.a.b
    public void onUserVideoAvailable(String str, int i3, boolean z16) {
        List<String> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (!isRTCRoomProtocolType()) {
            apiOnlineLog("OnUserVideoAvailable: isn't room protocol,ignore", false);
            return;
        }
        sendEventNotify(1033, getVideoAvailableJSONObject(str, generateURL(str, i3), i3, z16), true);
        if (i3 == 2) {
            list = this.mSubStreamUserIdList;
        } else {
            list = this.mMainStreamUserIdList;
        }
        if (z16) {
            list.add(str);
        } else {
            list.remove(str);
        }
        notifyFullUserList();
    }

    public V2TXJSAdapterError operateLivePusher(String str, JSONObject jSONObject) {
        boolean z16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) jSONObject);
        }
        if (TextUtils.isEmpty(str)) {
            return new V2TXJSAdapterError(-1, "Call operate failed, operate name is null");
        }
        boolean z17 = false;
        int i3 = 0;
        if (!str.equals("start") && !str.equals("stop") && !str.equals("resume") && !str.equals("pause") && !str.equals("startPreview") && !str.equals("stopPreview")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.mIsInit && this.mPusher != null) {
            if (str.equalsIgnoreCase("start")) {
                return start(jSONObject);
            }
            if (str.equalsIgnoreCase("stop")) {
                stopPushInner("Stop push call by business, operate stop");
            } else {
                if (str.equalsIgnoreCase("pause")) {
                    return pause(jSONObject);
                }
                if (str.equalsIgnoreCase("resume")) {
                    return resume(jSONObject);
                }
                if (str.equalsIgnoreCase("startPreview")) {
                    return startPreview(jSONObject);
                }
                if (str.equalsIgnoreCase("stopPreview")) {
                    return stopPreview(jSONObject);
                }
                if (str.equalsIgnoreCase("switchCamera")) {
                    this.mConfig.isFrontCamera = !r11.isFrontCamera;
                    this.mPusher.getDeviceManager().switchCamera(this.mConfig.isFrontCamera);
                } else {
                    if (str.equalsIgnoreCase("snapshot")) {
                        return snapshot(jSONObject);
                    }
                    if (str.equalsIgnoreCase("toggleTorch")) {
                        boolean z18 = !this.mIsFlashLightOpened;
                        boolean enableCameraTorch = this.mPusher.getDeviceManager().enableCameraTorch(z18);
                        if (!enableCameraTorch) {
                            z18 = this.mIsFlashLightOpened;
                        }
                        this.mIsFlashLightOpened = z18;
                        if (!enableCameraTorch) {
                            i3 = -2;
                        }
                        if (enableCameraTorch) {
                            str2 = "Success";
                        } else {
                            str2 = "Failed";
                        }
                        return new V2TXJSAdapterError(i3, str2);
                    }
                    if (str.equalsIgnoreCase(c.f123373g0)) {
                        return playBGM(jSONObject);
                    }
                    if (str.equalsIgnoreCase("stopBGM")) {
                        this.mIsBGMPlaying = false;
                        this.mPusher.getAudioEffectManager().setMusicObserver(BGM_ID, null);
                        this.mPusher.getAudioEffectManager().stopPlayMusic(BGM_ID);
                    } else if (str.equalsIgnoreCase("pauseBGM")) {
                        this.mIsBGMPlaying = false;
                        this.mPusher.getAudioEffectManager().pausePlayMusic(BGM_ID);
                    } else if (str.equalsIgnoreCase("resumeBGM")) {
                        this.mIsBGMPlaying = true;
                        this.mPusher.getAudioEffectManager().resumePlayMusic(BGM_ID);
                    } else {
                        if (str.equalsIgnoreCase("setBGMVolume")) {
                            return setBGMVolume(jSONObject);
                        }
                        if (str.equalsIgnoreCase("setMICVolume")) {
                            return setMICVolume(jSONObject);
                        }
                        if (str.equalsIgnoreCase("sendMessage")) {
                            return sendMessage(jSONObject);
                        }
                        if (str.equalsIgnoreCase("setZoom")) {
                            return setZoom(jSONObject);
                        }
                        if (str.equalsIgnoreCase("getMaxZoom")) {
                            return getMaxZoom(jSONObject);
                        }
                        return new V2TXJSAdapterError(-4, "Call operate failed, invalid operate name:".concat(str));
                    }
                }
            }
            return new V2TXJSAdapterError();
        }
        StringBuilder sb5 = new StringBuilder("Call operate failed, pusher is not initialized, [name:");
        sb5.append(str);
        sb5.append("][init:");
        sb5.append(this.mIsInit);
        sb5.append("][pusher:");
        if (this.mPusher != null) {
            z17 = true;
        }
        sb5.append(z17);
        sb5.append("]");
        apiOnlineError(sb5.toString(), z16);
        return new V2TXJSAdapterError(-3, "Call operate failed, pusher is not initialized");
    }

    public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) v2TXLiveVideoFrame)).intValue();
        }
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher != null) {
            return v2TXLivePusher.sendCustomVideoFrame(v2TXLiveVideoFrame);
        }
        return 0;
    }

    public void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iTXAudioVolumeEvaluationListener);
        } else {
            this.mAudioVolumeListener = iTXAudioVolumeEvaluationListener;
        }
    }

    public void setBGMNotifyListener(TXLivePusher.OnBGMNotify onBGMNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onBGMNotify);
        } else {
            this.mBGMNotifyListener = onBGMNotify;
        }
    }

    public V2TXJSAdapterError setFocusPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            return new V2TXJSAdapterError(-3, "Set focus position failed, pusher not initialized");
        }
        v2TXLivePusher.getDeviceManager().setCameraFocusPosition((int) f16, (int) f17);
        return new V2TXJSAdapterError();
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTXLivePushListener);
        } else {
            this.mLivePushListener = iTXLivePushListener;
        }
    }

    public void setSnapshotListener(TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iTXSnapshotListener);
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
        this.mSurface = surface;
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher != null) {
            v2TXLivePusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, surface);
        }
        return new V2TXJSAdapterError();
    }

    public V2TXJSAdapterError setSurfaceSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        apiOnlineLog("Set surface size [width:" + i3 + "][height:" + i16 + "]", false);
        this.mSurfaceWidth = i3;
        this.mSurfaceHeight = i16;
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher != null) {
            v2TXLivePusher.setProperty(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, new V2TXLiveDefInner.SurfaceSize(i3, i16));
        }
        return new V2TXJSAdapterError();
    }

    public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) videoCustomProcessListener);
            return;
        }
        this.mVideoCustomProcessListener = videoCustomProcessListener;
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher != null) {
            if (videoCustomProcessListener != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            v2TXLivePusher.enableCustomVideoProcess(z16, V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D, V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture);
        }
    }

    public V2TXJSAdapterError setZoom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            return new V2TXJSAdapterError(-3, "Set zoom failed, pusher not initialized");
        }
        v2TXLivePusher.getDeviceManager().setCameraZoomRatio(i3);
        return new V2TXJSAdapterError();
    }

    public void takePhoto(boolean z16, TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), iTXSnapshotListener);
            return;
        }
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher != null) {
            this.mNeedCompressSnapshot = z16;
            this.mSnapshotListener = iTXSnapshotListener;
            int snapshot = v2TXLivePusher.snapshot();
            if (this.mLivePushListener != null && snapshot != 0) {
                Bundle bundle = new Bundle();
                apiOnlineLog("OnPushEvent: event[-3], msg[" + bundle.toString() + "]", false);
                this.mLivePushListener.onPushEvent(-3, bundle);
            }
        }
    }

    public V2TXJSAdapterError unInitLivePusher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (!this.mIsInit) {
            return new V2TXJSAdapterError(-3, "Uninit pusher failed, pusher is not initialized");
        }
        stopPushInner("Stop push call by inner, unInit pusher");
        this.mIsInit = false;
        this.mPusher.release();
        apiOnlineLog("Uninit pusher success", true);
        return new V2TXJSAdapterError();
    }

    public V2TXJSAdapterError updateLivePusher(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
        }
        if (bundle == null) {
            return new V2TXJSAdapterError(-1, "Update pusher params failed, params is null.");
        }
        if (!this.mIsInit) {
            return new V2TXJSAdapterError(-3, "Update pusher params failed, pusher is not initialized");
        }
        apiOnlineLog("Update pusher params:" + bundle.toString(), false);
        V2TXLivePusherJSConfig v2TXLivePusherJSConfig = new V2TXLivePusherJSConfig(this.mConfig);
        v2TXLivePusherJSConfig.updateFromBundle(bundle);
        if (!TextUtils.isEmpty(v2TXLivePusherJSConfig.url) && !v2TXLivePusherJSConfig.url.equals(this.mConfig.url)) {
            JSAdapterOnlineLog.getInstance().updateUrl("");
            apiOnlineLog("Url has been updated\uff0cnew url:" + v2TXLivePusherJSConfig.url, false);
            stopPushInner("Stop push call by inner, url is changed");
            createPusherInstance(v2TXLivePusherJSConfig.url);
            setFullParam(v2TXLivePusherJSConfig);
            this.mConfig = v2TXLivePusherJSConfig;
            if (v2TXLivePusherJSConfig.isAutoPush) {
                apiOnlineLog("Update pusher params:[auto push is true, url is changed], need to start auto push", false);
                startPushInner(v2TXLivePusherJSConfig.url);
            }
        } else {
            if (this.mPusher != null) {
                setDiffParam(this.mConfig, v2TXLivePusherJSConfig);
            } else {
                apiOnlineError("Pusher is not initialized, ignore set diff param", false);
            }
            this.mConfig = v2TXLivePusherJSConfig;
        }
        return new V2TXJSAdapterError();
    }

    private V2TXJSAdapterError getMaxZoom(JSONObject jSONObject) {
        V2TXLivePusher v2TXLivePusher = this.mPusher;
        if (v2TXLivePusher == null) {
            return new V2TXJSAdapterError(-3, "Get max zoom failed, pusher is not initialized");
        }
        float cameraZoomMaxRatio = v2TXLivePusher.getDeviceManager().getCameraZoomMaxRatio();
        HashMap hashMap = new HashMap();
        hashMap.put("maxZoom", Float.valueOf(cameraZoomMaxRatio));
        return new V2TXJSAdapterError(0, hashMap);
    }

    public V2TXJSAdapterError initLivePusher(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (V2TXJSAdapterError) iPatchRedirector.redirect((short) 8, (Object) this, (Object) tXCloudVideoView, (Object) bundle);
        }
        if (tXCloudVideoView == null) {
            return new V2TXJSAdapterError(-1, "Init pusher failed, view is null");
        }
        return initLivePusherInner(tXCloudVideoView, bundle);
    }

    private V2TXJSAdapterError setZoom(JSONObject jSONObject) {
        this.mPusher.getDeviceManager().setCameraZoomRatio((float) (jSONObject != null ? jSONObject.optDouble("zoom", 1.0d) : 1.0d));
        return new V2TXJSAdapterError();
    }

    private void sendEventNotify(int i3, JSONObject jSONObject, boolean z16) {
        String jSONObject2;
        String valueOf = String.valueOf(i3);
        if (i3 != 1020) {
            switch (i3) {
                case 1031:
                    valueOf = "UserEnter";
                    break;
                case 1032:
                    valueOf = "UserExit";
                    break;
                case 1033:
                    valueOf = "VideoStateUpdate";
                    break;
                case 1034:
                    valueOf = "AudioStateUpdate";
                    break;
            }
        } else {
            valueOf = "UserList";
        }
        StringBuilder sb5 = new StringBuilder("SendEventNotify [eventName:");
        sb5.append(valueOf);
        sb5.append("][params:");
        sb5.append(jSONObject != null ? jSONObject.toString() : "");
        sb5.append("]");
        apiOnlineLog(sb5.toString(), false);
        if (jSONObject == null) {
            return;
        }
        try {
            if (z16) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put(jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("userlist", jSONArray);
                jSONObject2 = jSONObject3.toString();
            } else {
                jSONObject2 = jSONObject.toString();
            }
            ITXLivePushListener iTXLivePushListener = this.mLivePushListener;
            if (iTXLivePushListener != null) {
                Bundle bundle = new Bundle();
                bundle.putString("EVT_MSG", jSONObject2);
                apiOnlineLog("OnPushEvent: event[" + i3 + "], msg[" + bundle.toString() + "]", false);
                iTXLivePushListener.onPushEvent(i3, bundle);
            }
        } catch (Exception unused) {
        }
    }

    private void createPusherInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int ordinal = V2TXLiveUtils.parseLiveMode(str).ordinal();
        if (str.startsWith(V2TXLiveUtils.TRTC_ADDRESS1) || str.startsWith(V2TXLiveUtils.TRTC_ADDRESS2)) {
            ordinal = 102;
        }
        JSAdapterOnlineLog.getInstance().updateUrl(str);
        createPusherInstance(ordinal);
    }
}
