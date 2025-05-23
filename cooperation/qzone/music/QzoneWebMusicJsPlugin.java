package cooperation.qzone.music;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneWebMusicJsPlugin extends WebViewPlugin implements WebEventListener {
    public static final String CONFIG_MOBINET_TIPS = "qzbg_music_mobinet_tips";
    public static final String EVENT_BUFFERING = "buffering";
    public static final String EVENT_BUTTON_CLICK = "buttonclick";
    public static final String EVENT_CANCEL = "cancel";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_FINISH = "finish";
    public static final String EVENT_GET_LIVINGINGO = "livinginfo";
    public static final String EVENT_GET_NETWORKE_TYPE = "networktype";
    public static final String EVENT_GET_PLAY_MODE = "playmode";
    public static final String EVENT_GET_SONGINFO = "songinfo";
    public static final String EVENT_PAUSED = "paused";
    public static final String EVENT_PLAYING = "playing";
    public static final String EVENT_STOP = "stop";
    public static final String EVENT_UNKOWN = "unknow";
    public static final String METHOD_STOP_MUSIC_BOX = "stopMusicBox";
    public static final String MUSIC_METHOD_NAMESPACE = "QzMusic";
    public static final String WEB_APP_MUSIC_EVENT = "WEBAPP_MUSIC";
    private static JsBridgeListener mFMLiveInfoJsBridgeListener;
    private String TAG = QzoneWebMusicJsPlugin.class.getSimpleName();
    private boolean isWebPageListening = false;
    private boolean isUseRemoteMusicManager = false;
    public boolean isFlowWarningVisible = false;
    private Handler mMainHandler = null;
    private boolean isRandom = false;
    private boolean isAutoPlay = false;
    private boolean isLoop = true;
    private boolean isShowing = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes38.dex */
    public interface onUserConfirmListener {
        void onConfirm();
    }

    private void callNetWorkInterface(String str) {
        if (this.isDestroy) {
            return;
        }
        this.mRuntime.e().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"networktype\",data:{type:\"isUnicomNetwork\",value:" + str + "}})}catch(e){}");
    }

    private void callNetWorkInterfaceForGetttingLiveInfo(String str, final Bundle bundle) {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        this.mMainHandler.post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.25
            @Override // java.lang.Runnable
            public void run() {
                if (QzoneWebMusicJsPlugin.this.isWebPageListening) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        Bundle bundle2 = bundle;
                        if (bundle2 != null) {
                            SongInfo songInfo = (SongInfo) bundle2.getParcelable(RemoteHandleConst.PARAM_SONG);
                            if (songInfo != null && songInfo.I == 9 && songInfo.K != null) {
                                int i3 = bundle.getInt(RemoteHandleConst.PARAM_STATE);
                                jSONObject.put("code", 0);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("uin", bundle.getLong("param.uin"));
                                jSONObject2.put("detailUrl", songInfo.K.f251825f);
                                jSONObject2.put("broadcastID", songInfo.K.f251823d);
                                jSONObject2.put("broadcastName", songInfo.K.f251824e);
                                if (i3 == 2) {
                                    jSONObject2.put("state", QzoneWebMusicJsPlugin.EVENT_PLAYING);
                                } else if (i3 == 1) {
                                    jSONObject2.put("state", QzoneWebMusicJsPlugin.EVENT_BUFFERING);
                                } else {
                                    jSONObject2.put("state", "paused");
                                }
                                jSONObject.put("data", jSONObject2);
                            } else {
                                jSONObject.put("code", 1);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e(QzoneWebMusicJsPlugin.this.TAG, 2, "callNetWorkInterfaceForGetttingLiveInfo  isDestroy " + QzoneWebMusicJsPlugin.this.isDestroy + "  result " + jSONObject.toString());
                        }
                        if (QzoneWebMusicJsPlugin.this.isDestroy || QzoneWebMusicJsPlugin.mFMLiveInfoJsBridgeListener == null) {
                            return;
                        }
                        if (QzoneWebMusicJsPlugin.mFMLiveInfoJsBridgeListener.f314008c) {
                            QzoneWebMusicJsPlugin.this.callJs4OpenApi(QzoneWebMusicJsPlugin.mFMLiveInfoJsBridgeListener, 0, jSONObject.toString());
                        } else {
                            QzoneWebMusicJsPlugin.mFMLiveInfoJsBridgeListener.d(jSONObject);
                        }
                    } catch (Exception unused) {
                        if (QLog.isColorLevel()) {
                            QLog.e(QzoneWebMusicJsPlugin.this.TAG, 2, "callNetWorkInterfaceForGetttingLiveInfo error");
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callWebPageInterface(String str) {
        if (!this.isWebPageListening || this.isDestroy) {
            return;
        }
        this.mRuntime.e().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + str + "\"}})}catch(e){}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callWebPageInterfaceImpl(String str, Bundle bundle) {
        if (this.isWebPageListening) {
            JSONObject jSONObject = new JSONObject();
            if (bundle != null) {
                try {
                    SongInfo songInfo = (SongInfo) bundle.getParcelable(RemoteHandleConst.PARAM_SONG);
                    if (songInfo != null) {
                        jSONObject.put("name", songInfo.f251871i);
                        jSONObject.put("singer", songInfo.F);
                        jSONObject.put(IOnlineStatusService.SONG_ID, songInfo.f251867d);
                        jSONObject.put("songMid", songInfo.E);
                        jSONObject.put("singerId", songInfo.G);
                        jSONObject.put("type", songInfo.I);
                        jSONObject.put("cover", songInfo.C);
                        jSONObject.put("ownerUin", songInfo.f251869f);
                        jSONObject.put("playUrl", songInfo.f251870h);
                        jSONObject.put("detailUrl", songInfo.D);
                        if (!TextUtils.isEmpty(songInfo.f251872m)) {
                            jSONObject.put("showId", songInfo.f251872m);
                        }
                        int i3 = songInfo.I;
                        if (i3 == 6 || i3 == 8) {
                            jSONObject.put("voiceType", 1);
                        } else if (i3 != 9) {
                            jSONObject.put("voiceType", 0);
                        } else {
                            jSONObject.put("voiceType", 2);
                        }
                    }
                    jSONObject.put("uin", bundle.getLong("param.uin"));
                    jSONObject.put("state", getStateString(bundle.getInt(RemoteHandleConst.PARAM_STATE, -1)));
                    jSONObject.put("total", bundle.getInt("param.duration"));
                    jSONObject.put("curr", bundle.getInt(RemoteHandleConst.PARAM_CURREN_TTIME));
                    jSONObject.put("isDefaultList", bundle.getInt(RemoteHandleConst.PARAM_PALY_ORIGIN) == 2);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            if (bundle != null) {
                try {
                    this.isRandom = bundle.getInt(RemoteHandleConst.PARAM_PLAY_MODE_RANDOM, 0) == 1;
                    this.isAutoPlay = bundle.getInt(RemoteHandleConst.PARAM_PLAY_MODE_AUTO, 0) == 1;
                    this.isLoop = bundle.getInt(RemoteHandleConst.PARAM_PLAY_MODE_LOOP, 0) == 0;
                    jSONObject.put(QzoneMusicConst.KEY_PLAY_MODE_RANDOM, this.isRandom);
                    jSONObject.put(QzoneMusicConst.KEY_PLAY_MODE_AUTO_PLAY, this.isAutoPlay);
                    jSONObject.put("isLoop", this.isLoop);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w(this.TAG, 1, " callWebPageInterfaceImpl  \uff1a" + str + " isdetroy " + this.isDestroy + " value  " + jSONObject.toString() + " plugin " + this);
            }
            if (this.isDestroy) {
                return;
            }
            this.mRuntime.e().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + str + "\",value:" + jSONObject.toString() + "}})}catch(e){}");
        }
    }

    private void doPlayMusicOrAudioCommon(final onUserConfirmListener onuserconfirmlistener) {
        Activity a16 = this.mRuntime.a();
        if (a16 != null && needPlayTips()) {
            showPlayTips(a16, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.29
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    LocalMultiProcConfig.putBool(QzoneWebMusicJsPlugin.CONFIG_MOBINET_TIPS, true);
                    onUserConfirmListener onuserconfirmlistener2 = onuserconfirmlistener;
                    if (onuserconfirmlistener2 != null) {
                        onuserconfirmlistener2.onConfirm();
                    }
                    dialogInterface.dismiss();
                    QzoneWebMusicJsPlugin.this.isFlowWarningVisible = false;
                }
            }, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.30
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    QzoneWebMusicJsPlugin qzoneWebMusicJsPlugin = QzoneWebMusicJsPlugin.this;
                    qzoneWebMusicJsPlugin.isFlowWarningVisible = false;
                    qzoneWebMusicJsPlugin.callWebPageInterface("cancel");
                }
            });
            this.isFlowWarningVisible = true;
        } else if (onuserconfirmlistener != null) {
            onuserconfirmlistener.onConfirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSetPlayMode(final int i3, final int i16, final int i17) {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.24
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().setPlayMode(QzoneWebMusicJsPlugin.this.mRuntime.b().getLongAccountUin(), i3, i16, i17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public long getCurrentHostUin() {
        String str = "";
        try {
            String queryParameter = Uri.parse(this.mRuntime.e().getUrl()).getQueryParameter("guestuin");
            if (queryParameter == null) {
                str = this.mRuntime.b().getLongAccountUin();
            } else {
                str = Long.parseLong(queryParameter);
            }
            return str;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(this.TAG, 2, "illegal guestuin,url=" + str, e16);
            }
            return 10000L;
        }
    }

    private void initUserInfo() {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.15
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().initUserInfo();
            }
        });
    }

    private boolean needPlayTips() {
        return NetworkState.isMobile() && !LocalMultiProcConfig.getBool(CONFIG_MOBINET_TIPS, false);
    }

    private boolean needSetAutoPlayTips() {
        return BaseApplication.getContext().getSharedPreferences("share", 0).getBoolean(AppConstants.Preferences.QZONE_BG_MUSIC_AUTO_PLAY_WARN_FLAG, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAudioListForBgMusic(String str) {
        final ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            final int optInt = jSONObject.optInt("index");
            JSONArray jSONArray = jSONObject.getJSONArray("songList");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(QzoneMusicHelper.convertFMBgMusic(jSONArray.getJSONObject(i3)));
            }
            if (arrayList.size() > 0) {
                this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.10
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteHandleManager.getInstance().getSender().playMusicList(QzoneWebMusicJsPlugin.this.getCurrentHostUin(), 2, optInt, arrayList);
                    }
                });
            } else {
                QLog.e(this.TAG, 2, "playAudioListForBgMusic no song in song list");
            }
        } catch (JSONException e16) {
            QLog.e(this.TAG, 1, "playAudioListForBgMusic \u53c2\u6570\u5f02\u5e38", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playFMBrocastList(String str) {
        final ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            final int optInt = jSONObject.optInt("index");
            int optInt2 = jSONObject.optInt("playMode");
            JSONArray jSONArray = jSONObject.getJSONArray("liveList");
            new BroadcastMusicInfo();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(BroadcastMusicInfo.b(jSONArray.getString(i3)).f(NetworkState.isWifiConn()));
            }
            if (arrayList.size() > 0) {
                final int i16 = optInt2 != 1 ? 4 : 2;
                this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.11
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteHandleManager.getInstance().getSender().playFmBroadCastList(QzoneWebMusicJsPlugin.this.getCurrentHostUin(), i16, optInt, arrayList);
                    }
                });
            } else {
                QLog.e(this.TAG, 2, "playAudioListForBgMusic no song in song list");
            }
        } catch (JSONException e16) {
            QLog.e(this.TAG, 1, "playFMBrocastList \u53c2\u6570\u5f02\u5e38", e16);
        }
    }

    public void changeMusicList(String str) {
        try {
            ListenTogetherIPCModuleWebClient.b(new JSONObject(str), "changeMusicList", null);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void getLivingInfo() {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.18
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().getLivingInfo();
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return MUSIC_METHOD_NAMESPACE;
    }

    public void getPlayMode() {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.20
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().getPlayMode();
            }
        });
    }

    public void getPlayingSongInfo() {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.17
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().getPlayingSong();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!str2.equals(MUSIC_METHOD_NAMESPACE)) {
            return false;
        }
        if (str3.equals("playMusic") && strArr != null && strArr.length > 0 && !this.isFlowWarningVisible) {
            final String str4 = strArr[0];
            doPlayMusicOrAudioCommon(new onUserConfirmListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.1
                @Override // cooperation.qzone.music.QzoneWebMusicJsPlugin.onUserConfirmListener
                public void onConfirm() {
                    QzoneWebMusicJsPlugin.this.playMusic(str4);
                }
            });
            return true;
        }
        if (str3.equals("playMusicList") && strArr != null && strArr.length > 0 && !this.isFlowWarningVisible) {
            final String str5 = strArr[0];
            doPlayMusicOrAudioCommon(new onUserConfirmListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.2
                @Override // cooperation.qzone.music.QzoneWebMusicJsPlugin.onUserConfirmListener
                public void onConfirm() {
                    QzoneWebMusicJsPlugin.this.playMusicList(str5);
                }
            });
            return true;
        }
        if (str3.equals("playAudioList") && strArr != null && strArr.length > 0 && !this.isFlowWarningVisible) {
            final String str6 = strArr[0];
            doPlayMusicOrAudioCommon(new onUserConfirmListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.3
                @Override // cooperation.qzone.music.QzoneWebMusicJsPlugin.onUserConfirmListener
                public void onConfirm() {
                    QzoneWebMusicJsPlugin.this.playAudioList(str6);
                }
            });
            return true;
        }
        if ("playLiveList".equals(str3) && strArr != null && strArr.length > 0 && !this.isFlowWarningVisible) {
            final String str7 = strArr[0];
            doPlayMusicOrAudioCommon(new onUserConfirmListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.4
                @Override // cooperation.qzone.music.QzoneWebMusicJsPlugin.onUserConfirmListener
                public void onConfirm() {
                    QzoneWebMusicJsPlugin.this.playFMBrocastList(str7);
                }
            });
            return true;
        }
        if (str3.equals("resumePlay")) {
            resumePlay();
            return true;
        }
        if (str3.equals(QZoneJsConstants.METHOD_RECORDER_PAUSE_PLAY)) {
            pausePlay();
            return true;
        }
        if (str3.equals("listenMusicState") && strArr != null && strArr.length > 0) {
            listenMusicState(strArr[0]);
            return true;
        }
        if (str3.equals("musicListChange")) {
            musicListChange();
            return true;
        }
        if (str3.equals("setPlayMode") && strArr != null && strArr.length > 0) {
            setPlayMode(strArr[0]);
            return true;
        }
        if (str3.equals(IndividuationPlugin.Method_setRightButton) && strArr != null && strArr.length > 0) {
            setRightButton(strArr[0]);
            return true;
        }
        if (str3.equals("getPlayingSongInfo")) {
            RemoteHandleManager.getInstance().addWebEventListener(this);
            getPlayingSongInfo();
            return true;
        }
        if (str3.equals("playMusicList") && strArr != null && strArr.length > 0) {
            playMusicList(strArr[0]);
            return true;
        }
        if (str3.equals("getPlayMode")) {
            getPlayMode();
            return true;
        }
        if (str3.equals("getNetworkType")) {
            if (NetworkState.getIsUnicomNetWork()) {
                callNetWorkInterface("true");
            } else {
                callNetWorkInterface("false");
            }
            return true;
        }
        if ("playAudioListForBgMusic".equals(str3) && strArr != null && strArr.length > 0 && !this.isFlowWarningVisible) {
            final String str8 = strArr[0];
            doPlayMusicOrAudioCommon(new onUserConfirmListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.5
                @Override // cooperation.qzone.music.QzoneWebMusicJsPlugin.onUserConfirmListener
                public void onConfirm() {
                    QzoneWebMusicJsPlugin.this.playAudioListForBgMusic(str8);
                }
            });
            return true;
        }
        if ("FmListChange".equals(str3)) {
            musicListChange();
            return true;
        }
        if ("getLivingInfo".equals(str3)) {
            mFMLiveInfoJsBridgeListener = jsBridgeListener;
            getLivingInfo();
            return true;
        }
        if ("changeMusicList".equals(str3) && strArr != null && strArr.length > 0) {
            changeMusicList(strArr[0]);
            return true;
        }
        if (QZoneJsConstants.METHOD_RECORDER_STOP_PLAY.equals(str3) && strArr != null && strArr.length > 0) {
            stopPlay(strArr[0]);
            return true;
        }
        QLog.w(this.TAG, 1, "method \uff1a" + str3 + " \u6ca1\u6709\u505a\u4efb\u4f55\u5904\u7406\u3002");
        return false;
    }

    public void listenMusicState(String str) {
        try {
            int i3 = new JSONObject(str).getInt(h.f248218g);
            if (i3 == 1) {
                if (!this.isWebPageListening) {
                    RemoteHandleManager.getInstance().addWebEventListener(this);
                    initUserInfo();
                }
                this.isWebPageListening = true;
                this.isUseRemoteMusicManager = true;
                return;
            }
            if (i3 == 0) {
                if (this.isWebPageListening) {
                    RemoteHandleManager.getInstance().removeWebEventListener(this);
                }
                this.isWebPageListening = false;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void musicListChange() {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.16
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().notifyPlayListChange();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (this.isWebPageListening) {
            RemoteHandleManager.getInstance().addWebEventListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        RemoteHandleManager.getInstance().removeWebEventListener(this);
        if (this.isUseRemoteMusicManager) {
            RemoteHandleManager.getInstance().destroy();
        }
    }

    public void pausePlay() {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.13
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().pausePlay();
                ListenTogetherIPCModuleWebClient.b(new JSONObject(), "pauseFloatView", null);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void playAudioList(String str) {
        int i3;
        JSONException e16;
        final int i16;
        JSONObject jSONObject;
        final ArrayList arrayList = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
            i16 = jSONObject.getInt("index");
            try {
                i3 = jSONObject.getInt(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE);
            } catch (JSONException e17) {
                i3 = 0;
                e16 = e17;
            }
        } catch (JSONException e18) {
            i3 = 0;
            e16 = e18;
            i16 = 0;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("songList");
            for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                arrayList.add(QzoneMusicHelper.convertAudioSongInfo(jSONArray.getJSONObject(i17)));
            }
        } catch (JSONException e19) {
            e16 = e19;
            e16.printStackTrace();
            final int i18 = 2;
            if (arrayList.size() <= 0) {
            }
        }
        final int i182 = 2;
        if (arrayList.size() <= 0) {
            if (i3 != 1 && i3 != 3) {
                i182 = 6;
            }
            this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.9
                @Override // java.lang.Runnable
                public void run() {
                    RemoteHandleManager.getInstance().getSender().playAudioList(QzoneWebMusicJsPlugin.this.getCurrentHostUin(), i182, i16, arrayList, 102);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "no song in song list");
        }
    }

    public void playMusic(String str) {
        final ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(QzoneMusicHelper.convertSongInfo(new JSONObject(str)));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (arrayList.size() > 0) {
            final int i3 = ((SongInfo) arrayList.get(0)).I != 6 ? 1 : 6;
            this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.7
                @Override // java.lang.Runnable
                public void run() {
                    RemoteHandleManager.getInstance().getSender().playMusicList(QzoneWebMusicJsPlugin.this.getCurrentHostUin(), i3, 0, arrayList);
                }
            });
        } else if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "song info error");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void playMusicList(String str) {
        JSONException e16;
        final int i3;
        JSONObject jSONObject;
        final ArrayList arrayList = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
            i3 = jSONObject.getInt("index");
        } catch (JSONException e17) {
            e16 = e17;
            i3 = 0;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("songList");
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                SongInfo convertSongInfo = QzoneMusicHelper.convertSongInfo(jSONArray.getJSONObject(i16));
                if (convertSongInfo.f251867d == 0) {
                    convertSongInfo.f251867d = i16;
                }
                arrayList.add(convertSongInfo);
            }
            if (jSONArray.length() > 0 && i3 < jSONArray.length() && jSONArray.getJSONObject(0).optInt("isProfileMusicBox", 0) == 1) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uin", ((SongInfo) arrayList.get(i3)).f251869f);
                jSONObject2.put("coverUrl", ((SongInfo) arrayList.get(i3)).C);
                ListenTogetherIPCModuleWebClient.b(jSONObject2, "showFloatView", null);
            }
        } catch (JSONException e18) {
            e16 = e18;
            e16.printStackTrace();
            if (arrayList.size() <= 0) {
            }
        }
        if (arrayList.size() <= 0) {
            this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.8
                @Override // java.lang.Runnable
                public void run() {
                    RemoteHandleManager.getInstance().getSender().playMusicList(QzoneWebMusicJsPlugin.this.getCurrentHostUin(), 2, i3, arrayList);
                }
            });
        } else if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "no song in song list");
        }
    }

    public void resumePlay() {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.12
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().resumePlay();
                ListenTogetherIPCModuleWebClient.b(new JSONObject(), "showFloatView", null);
            }
        });
    }

    public void setPlayMode(String str) {
        int i3;
        final int i16;
        JSONObject jSONObject;
        if (!NetworkState.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, QzoneMusicHelper.NO_NETWORK_MSG, 1).show();
            getPlayMode();
            return;
        }
        final int i17 = -1;
        try {
            jSONObject = new JSONObject(str);
            i16 = jSONObject.optBoolean(QzoneMusicConst.KEY_PLAY_MODE_RANDOM, this.isRandom) ? 1 : 0;
        } catch (JSONException e16) {
            e = e16;
            i3 = 0;
        }
        try {
            r1 = jSONObject.optBoolean(QzoneMusicConst.KEY_PLAY_MODE_AUTO_PLAY, this.isAutoPlay) ? 1 : 0;
            if (jSONObject.has("isLoop")) {
                i17 = !jSONObject.optBoolean("isLoop") ? 1 : 0;
            }
        } catch (JSONException e17) {
            e = e17;
            int i18 = r1;
            r1 = i16;
            i3 = i18;
            e.printStackTrace();
            int i19 = r1;
            r1 = i3;
            i16 = i19;
            boolean needSetAutoPlayTips = needSetAutoPlayTips();
            if (r1 != 1) {
            }
            doSetPlayMode(i16, r1, i17);
        }
        boolean needSetAutoPlayTips2 = needSetAutoPlayTips();
        if (r1 != 1 && !this.isAutoPlay && needSetAutoPlayTips2) {
            showAutoPlayTips(this.mRuntime.a(), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.21
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i26) {
                    QzoneWebMusicJsPlugin.this.getPlayMode();
                }
            }, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.22
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i26) {
                    BaseApplication.getContext().getSharedPreferences("share", 0).edit().putBoolean(AppConstants.Preferences.QZONE_BG_MUSIC_AUTO_PLAY_WARN_FLAG, false).apply();
                    QzoneWebMusicJsPlugin.this.doSetPlayMode(i16, r3, i17);
                }
            }, new DialogInterface.OnCancelListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.23
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    QzoneWebMusicJsPlugin.this.getPlayMode();
                }
            });
        } else {
            doSetPlayMode(i16, r1, i17);
        }
    }

    public void setRightButton(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("text");
            String string2 = jSONObject.getString("color");
            boolean z16 = jSONObject.getBoolean(NodeProps.VISIBLE);
            if (this.mRuntime.a() instanceof QQBrowserActivity) {
                TextView textView = (TextView) this.mRuntime.a().findViewById(R.id.ivTitleBtnRightText);
                try {
                    if (z16) {
                        textView.setVisibility(0);
                        textView.setTextColor(Color.parseColor("#" + string2));
                        textView.setText(string);
                        textView.setOnClickListener(new View.OnClickListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.19
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                EventCollector.getInstance().onViewClickedBefore(view);
                                QzoneWebMusicJsPlugin.this.callWebPageInterface(QzoneWebMusicJsPlugin.EVENT_BUTTON_CLICK);
                                EventCollector.getInstance().onViewClicked(view);
                            }
                        });
                    } else {
                        textView.setVisibility(8);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(this.TAG, 2, "set right textview error");
                    }
                    e16.printStackTrace();
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public void stopPlay(String str) {
        try {
            if (new JSONObject(str).optInt("isProfileMusicBox") == 1) {
                this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.6
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteHandleManager.getInstance().getSender().stopPlay();
                        ListenTogetherIPCModuleWebClient.b(new JSONObject(), "stopMusicBox", null);
                    }
                });
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void callWebPageInterface(final String str, final Bundle bundle) {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        this.mMainHandler.post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.26
            @Override // java.lang.Runnable
            public void run() {
                QzoneWebMusicJsPlugin.this.callWebPageInterfaceImpl(str, bundle);
            }
        });
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        if (bundle == null || !bundle.containsKey("data")) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(this.TAG, 2, "call js function,bundle is empty");
                return;
            }
            return;
        }
        String stateString = getStateString(bundle2.getInt(RemoteHandleConst.PARAM_STATE, -1));
        if (str.equals(RemoteHandleConst.CMD_NOTIFY_STATE_CALLBACK)) {
            callWebPageInterface(stateString, bundle2);
            boolean z16 = bundle2.getBoolean(RemoteHandleConst.PARAM_NEED_PALY_TIPS);
            Activity a16 = this.mRuntime.a();
            if (a16 == null || a16.isFinishing() || this.isShowing || !z16 || !needPlayTips()) {
                return;
            }
            pausePlay();
            showPlayTips(a16, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.27
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    QzoneWebMusicJsPlugin.this.resumePlay();
                    LocalMultiProcConfig.putBool(QzoneWebMusicJsPlugin.CONFIG_MOBINET_TIPS, true);
                    dialogInterface.dismiss();
                    QzoneWebMusicJsPlugin.this.isShowing = false;
                }
            }, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.28
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    QzoneWebMusicJsPlugin.this.stopPlay();
                    QzoneWebMusicJsPlugin.this.callWebPageInterface("cancel");
                    dialogInterface.dismiss();
                    QzoneWebMusicJsPlugin.this.isShowing = false;
                }
            });
            this.isShowing = true;
            return;
        }
        if (str.equals(RemoteHandleConst.CMD_GET_PLAY_MODE)) {
            callWebPageInterface("playmode", bundle2);
        } else if (str.equals(RemoteHandleConst.CMD_GET_PLAYING_SONG)) {
            callWebPageInterface(EVENT_GET_SONGINFO, bundle2);
        } else if (str.equals(RemoteHandleConst.CMD_GET_LIVING_INFO)) {
            callNetWorkInterfaceForGetttingLiveInfo(EVENT_GET_LIVINGINGO, bundle2);
        }
    }

    private String getStateString(int i3) {
        switch (i3) {
            case 1:
                return EVENT_BUFFERING;
            case 2:
                return EVENT_PLAYING;
            case 3:
                return "paused";
            case 4:
            case 6:
                return "stop";
            case 5:
            case 7:
                return "error";
            default:
                return EVENT_UNKOWN;
        }
    }

    public void stopPlay() {
        this.mRuntime.b().getHandler(QzoneWebMusicJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.music.QzoneWebMusicJsPlugin.14
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().stopPlay();
                ListenTogetherIPCModuleWebClient.b(new JSONObject(), "pauseFloatView", null);
            }
        });
    }

    private static final void showPlayTips(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.sfj), "\u4f60\u6b63\u5904\u4e8e\u975eWiFi\u73af\u5883\uff0c\u7ee7\u7eed\u64ad\u653e\u5c06\u4f1a\u6d88\u8017\u6d41\u91cf\uff0c\u8fd0\u8425\u5546\u53ef\u80fd\u4f1a\u6536\u53d6\u8d39\u7528\uff0c\u662f\u5426\u7ee7\u7eed\n", HardCodeUtil.qqStr(R.string.sfd), HardCodeUtil.qqStr(R.string.j6l), onClickListener2, onClickListener).show();
    }

    private static final void showAutoPlayTips(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, HardCodeUtil.qqStr(R.string.sfi), HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.sfe), onClickListener2, onClickListener);
        createCustomDialog.setOnCancelListener(onCancelListener);
        createCustomDialog.show();
    }
}
