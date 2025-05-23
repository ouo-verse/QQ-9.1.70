package com.tencent.mobileqq.listentogether.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.lyrics.ProfileMusicBoxController;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import com.tencent.qzonehub.api.music.IQzoneMusicHelper;
import eipc.EIPCResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class ListenTogetherIPCModuleMainServer extends QIPCModule {

    /* loaded from: classes33.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static ListenTogetherIPCModuleMainServer f240979a = new ListenTogetherIPCModuleMainServer();
    }

    ListenTogetherIPCModuleMainServer() {
        super("ListenTogetherIPCModuleMainServer");
    }

    public static void b(JSONObject jSONObject) {
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherIPCModuleMainServer", 2, "callWebClientStatusChanged data:" + jSONObject + "  isToolRunning:" + isProcessRunning);
        }
        if (isProcessRunning) {
            Bundle bundle = new Bundle();
            bundle.putString("data", jSONObject.toString());
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "ListenTogetherIPCModuleWebClient", "action_status_changed", bundle, null);
        }
    }

    public static ListenTogetherIPCModuleMainServer c() {
        return a.f240979a;
    }

    private EIPCResult d(String str, Bundle bundle, int i3) {
        JSONObject jSONObject;
        if ("action_status_changed".equals(str) && bundle != null) {
            try {
                jSONObject = new JSONObject(bundle.getString("data"));
            } catch (JSONException e16) {
                QLog.i("ListenTogetherIPCModuleMainServer", 1, "statusChanged error:" + e16.getMessage());
                jSONObject = null;
            }
            QQAppInterface qQAppInterface = BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface ? (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime() : null;
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogetherIPCModuleMainServer", 2, "statusChanged action:" + str + " data=" + jSONObject + " app:" + qQAppInterface);
            }
            if (qQAppInterface != null && jSONObject != null) {
                ((ListenTogetherManager) qQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).m1(jSONObject);
                EIPCResult eIPCResult = new EIPCResult();
                eIPCResult.code = 0;
                return eIPCResult;
            }
        }
        return null;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherIPCModuleMainServer", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        if (bundle == null) {
            QLog.d("ListenTogetherIPCModuleMainServer", 1, "onCall, param is null, action=" + str + ", callBackId=" + i3);
            return null;
        }
        if ("action_status_changed".equals(str)) {
            return d(str, bundle, i3);
        }
        if ("isOpener".equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", com.tencent.mobileqq.listentogether.ui.a.k().l());
            EIPCResult createResult = EIPCResult.createResult(0, bundle2);
            if (i3 > 0) {
                callbackResult(i3, createResult);
            }
        } else if ("isShowAtmosphere".equals(str)) {
            try {
                new JSONObject(bundle.getString("data")).optString("uin");
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("result", com.tencent.mobileqq.listentogether.ui.a.k().l());
                EIPCResult createResult2 = EIPCResult.createResult(0, bundle3);
                if (i3 > 0) {
                    callbackResult(i3, createResult2);
                }
            } catch (JSONException e16) {
                QLog.e("ListenTogetherIPCModuleMainServer", 1, "METHOD_IS_SHOW_ATMOSPHERE: ", e16);
            }
        } else if ("setPlayerId".equals(str)) {
            try {
                FloatViewSkin.o().u(new JSONObject(bundle.getString("data")).optInt("id"));
            } catch (JSONException e17) {
                QLog.e("ListenTogetherIPCModuleMainServer", 1, "METHOD_SET_PLAYERID: ", e17);
            }
        } else if ("showFloatView".equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(bundle.getString("data"));
                final String optString = jSONObject.optString("uin");
                final String optString2 = jSONObject.optString("coverUrl");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ProfileMusicBoxController W = ListenTogetherManager.J((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).W();
                        if (W != null) {
                            W.u0(optString);
                            if (W.h0() || TextUtils.isEmpty(optString2)) {
                                return;
                            }
                            SongInfo songInfo = new SongInfo();
                            songInfo.C = optString2;
                            W.k0(songInfo);
                        }
                    }
                });
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
        } else if ("pauseFloatView".equals(str)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.2
                @Override // java.lang.Runnable
                public void run() {
                    ProfileMusicBoxController W = ListenTogetherManager.J((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).W();
                    if (W == null || !W.z()) {
                        return;
                    }
                    W.r0(false);
                }
            });
        } else if ("changeMusicList".equals(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject(bundle.getString("data"));
                int optInt = jSONObject2.optInt(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE);
                int optInt2 = jSONObject2.optInt("index");
                JSONArray jSONArray = jSONObject2.getJSONArray("songList");
                SongInfo[] songInfoArr = new SongInfo[jSONArray.length()];
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    SongInfo songInfo = (SongInfo) ((IQzoneMusicHelper) QRoute.api(IQzoneMusicHelper.class)).convertSongInfo(jSONArray.getJSONObject(i16));
                    if (songInfo.f251867d == 0) {
                        songInfo.f251867d = i16;
                    }
                    songInfoArr[i16] = songInfo;
                }
                QQPlayerService.e1(songInfoArr, optInt, optInt2);
            } catch (JSONException e19) {
                e19.printStackTrace();
            }
        } else if ("stopMusicBox".equals(str)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.3
                @Override // java.lang.Runnable
                public void run() {
                    ProfileMusicBoxController W = ListenTogetherManager.J((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).W();
                    if (W != null) {
                        W.v0();
                    }
                }
            });
        }
        return null;
    }
}
