package com.tencent.mobileqq.qqlive.anchor.room.sso;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.anchor.util.a;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFrame;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.sso.c;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import gr4.aa;
import gr4.n;
import gr4.o;
import gr4.u;
import gr4.v;
import java.util.ArrayList;
import ot3.d;
import ot3.e;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorSSO {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLiveAnchor_SSO";

    public QQLiveAnchorSSO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getFrameUrl(ArrayList<QQLiveAnchorDataFrame> arrayList, int i3) {
        return arrayList.get(i3).addresses.get(0).url;
    }

    public static void getRtmpPullUrl(IQQLiveSDK iQQLiveSDK, String str, d dVar, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, QQLiveAnchorSSOCallback<QQLiveAnchorDataPullInfo> qQLiveAnchorSSOCallback) {
        ((c) iQQLiveSDK.getExtModule("sso_module")).f("trpc.qlive.ilive_stream_control.StreamControl", "GetLiveStreams", MessageNano.toByteArray(dVar), new f(str, qQLiveAnchorSSOCallback) { // from class: com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQLiveAnchorSSOCallback val$callback;
            final /* synthetic */ String val$pushUrl;

            {
                this.val$pushUrl = str;
                this.val$callback = qQLiveAnchorSSOCallback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQLiveAnchorAutoCheckPullPlayParams.this, str, qQLiveAnchorSSOCallback);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sso.f
            public void onReceive(int i3, boolean z16, h hVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QQLiveAnchorSSO.TAG, 1, "get pull url recieve, type:" + i3 + ", success:" + z16);
                }
                try {
                    a.a(i3, z16, hVar);
                    e c16 = e.c(hVar.e());
                    if (c16.f424029a == 0) {
                        QQLiveAnchorDataPullInfo z17 = a.z(c16);
                        String str2 = "";
                        try {
                            str2 = QQLiveAnchorSSO.pickFramesStrategy(z17.streams.get(0).frames, QQLiveAnchorAutoCheckPullPlayParams.this.definition);
                        } catch (Throwable th5) {
                            QLog.e(QQLiveAnchorSSO.TAG, 1, "get pull url error, try use push url to play", th5);
                            if (!TextUtils.isEmpty(this.val$pushUrl)) {
                                str2 = this.val$pushUrl.replace("livepush", "liveplay");
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(QQLiveAnchorSSO.TAG, 1, "get pull url = " + str2);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            z17.defaultPlayUrl = str2;
                            this.val$callback.onResult(z17);
                            return;
                        } else {
                            throw new Throwable("get pull url is null or empty: " + str2);
                        }
                    }
                    throw new QQLiveAnchorThrowable("get pull url result error", c16.f424029a, c16.f424030b);
                } catch (Throwable th6) {
                    QLog.e(QQLiveAnchorSSO.TAG, 1, "error:", th6);
                    this.val$callback.onResult(new QQLiveAnchorDataPullInfo(false, QQLiveAnchorThrowable.covert(QQLiveError.ANCHOR_PULL_URL_ERR, th6)));
                }
            }
        });
    }

    public static void getRtmpPushUrl(IQQLiveSDK iQQLiveSDK, pt3.d dVar, QQLiveAnchorSSOCallback<QQLiveAnchorDataPushInfo> qQLiveAnchorSSOCallback) {
        ((c) iQQLiveSDK.getExtModule("sso_module")).f("trpc.qlive.media_logic4opensdk.MediaLogic", "GetRtmpPushUrl", MessageNano.toByteArray(dVar), new f() { // from class: com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorSSOCallback.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sso.f
            public void onReceive(int i3, boolean z16, h hVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QQLiveAnchorSSO.TAG, 1, "getPushRtmpUrl receive, type:" + i3 + ", success:" + z16);
                }
                try {
                    a.a(i3, z16, hVar);
                    pt3.e c16 = pt3.e.c(hVar.e());
                    if (c16.f427136a == 0) {
                        QQLiveAnchorDataPushInfo B = a.B(c16);
                        if (QLog.isColorLevel()) {
                            QLog.d(QQLiveAnchorSSO.TAG, 1, "push rtmp result:" + B.toString());
                        }
                        QQLiveAnchorSSOCallback.this.onResult(B);
                        return;
                    }
                    throw new QQLiveAnchorThrowable("getPushRtmpUrl rsp error", c16.f427136a, "");
                } catch (Throwable th5) {
                    QLog.d(QQLiveAnchorSSO.TAG, 1, "getPushRtmpUrl failed: ", th5);
                    QQLiveAnchorSSOCallback.this.onResult(new QQLiveAnchorDataPushInfo(false, QQLiveAnchorThrowable.covert(6221, th5)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String pickFramesStrategy(ArrayList<QQLiveAnchorDataFrame> arrayList, EnterRoomInfo.VideoDefinition videoDefinition) {
        if (arrayList.get(videoDefinition.level) == null) {
            return getFrameUrl(arrayList, 0);
        }
        return getFrameUrl(arrayList, videoDefinition.level);
    }

    public static void prepare(IQQLiveSDK iQQLiveSDK, n nVar, QQLiveAnchorSSOCallback<QQLiveAnchorDataPrepare> qQLiveAnchorSSOCallback) {
        ((c) iQQLiveSDK.getExtModule("sso_module")).f("trpc.qlive.ilive_room_play.RoomPlay", "Prepare", MessageNano.toByteArray(nVar), new f(qQLiveAnchorSSOCallback) { // from class: com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQLiveAnchorSSOCallback val$callback;

            {
                this.val$callback = qQLiveAnchorSSOCallback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) IQQLiveSDK.this, (Object) qQLiveAnchorSSOCallback);
                }
            }

            private void updateUserInfo(o oVar) {
                aa aaVar = oVar.f403165i;
                if (aaVar == null) {
                    return;
                }
                if (((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).updateUserInfo(IQQLiveSDK.this.getAppId(), String.valueOf(oVar.f403165i.f403092a), new LiveUserInfo(aaVar.f403092a, aaVar.f403095d, aaVar.f403094c, aaVar.f403099h))) {
                    QLog.i(QQLiveAnchorSSO.TAG, 1, "prepare... updateUserInfo Success name:" + oVar.f403165i.f403094c + " id:" + oVar.f403165i.f403092a + " sexual:" + oVar.f403165i.f403099h);
                    return;
                }
                QLog.i(QQLiveAnchorSSO.TAG, 1, "prepare... updateUserInfo Fail name:" + oVar.f403165i.f403094c + " id:" + oVar.f403165i.f403092a);
            }

            @Override // com.tencent.mobileqq.qqlive.sso.f
            public void onReceive(int i3, boolean z16, h hVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    return;
                }
                QLog.i(QQLiveAnchorSSO.TAG, 1, "prepare receive, type:" + i3 + ", success:" + z16 + ", appid=" + IQQLiveSDK.this.getAppId());
                try {
                    a.a(i3, z16, hVar);
                    o c16 = o.c(hVar.e());
                    int i16 = c16.f403157a;
                    if (i16 == 2003) {
                        QQLiveAnchorDataPrepare o16 = a.o(c16);
                        o16.isSuccess = false;
                        QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                        qQLiveErrorMsg.bizModule = 2;
                        qQLiveErrorMsg.bizErrCode = 6200;
                        qQLiveErrorMsg.originErrCode = c16.f403157a;
                        qQLiveErrorMsg.originErrMsg = c16.f403158b;
                        o16.errorMsg = qQLiveErrorMsg;
                        this.val$callback.onResult(o16);
                        return;
                    }
                    if (i16 == 0) {
                        if (IQQLiveSDK.this.getAppId().equals(QQLiveBusinessConfig.QQLIVE_APP_ID)) {
                            updateUserInfo(c16);
                        }
                        this.val$callback.onResult(a.o(c16));
                        return;
                    }
                    throw new QQLiveAnchorThrowable("prepare rsp error", c16.f403157a, c16.f403158b);
                } catch (Throwable th5) {
                    QQLiveErrorMsg covert = QQLiveAnchorThrowable.covert(6200, th5);
                    QLog.e(QQLiveAnchorSSO.TAG, 1, "prepare error, ", covert, th5);
                    this.val$callback.onResult(new QQLiveAnchorDataPrepare(false, covert));
                }
            }
        });
    }

    public static void set(IQQLiveSDK iQQLiveSDK, u uVar, QQLiveAnchorSSOCallback<QQLiveAnchorDataSet> qQLiveAnchorSSOCallback) {
        ((c) iQQLiveSDK.getExtModule("sso_module")).f("trpc.qlive.ilive_room_play.RoomPlay", "Set", MessageNano.toByteArray(uVar), new f() { // from class: com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorSSOCallback.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sso.f
            public void onReceive(int i3, boolean z16, h hVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QQLiveAnchorSSO.TAG, 1, "set receive, type:" + i3 + ", success:" + z16);
                }
                try {
                    a.a(i3, z16, hVar);
                    v c16 = v.c(hVar.e());
                    if (c16.f403228a == 0) {
                        QQLiveAnchorDataSet qQLiveAnchorDataSet = new QQLiveAnchorDataSet();
                        qQLiveAnchorDataSet.isSuccess = true;
                        QQLiveAnchorSSOCallback.this.onResult(qQLiveAnchorDataSet);
                        return;
                    }
                    throw new QQLiveAnchorThrowable("set rsp error", c16.f403228a, c16.f403229b);
                } catch (Throwable th5) {
                    QLog.e(QQLiveAnchorSSO.TAG, 1, "set failed: ", th5);
                    QQLiveAnchorSSOCallback.this.onResult(new QQLiveAnchorDataSet(false, QQLiveAnchorThrowable.covert(QQLiveError.ANCHOR_SET_ERR, th5)));
                }
            }
        });
    }
}
