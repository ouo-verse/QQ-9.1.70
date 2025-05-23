package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO;
import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSOCallback;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f270902a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f270903b;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements QQLiveAnchorSSOCallback<QQLiveAnchorDataPushInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorRoomInfo f270904a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IQQLiveAnchorRoomThirdPushCallback f270905b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorAutoCheckPullPlayParams f270906c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQLiveSDK f270907d;

        a(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveSDK iQQLiveSDK) {
            this.f270904a = qQLiveAnchorRoomInfo;
            this.f270905b = iQQLiveAnchorRoomThirdPushCallback;
            this.f270906c = qQLiveAnchorAutoCheckPullPlayParams;
            this.f270907d = iQQLiveSDK;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, q.this, qQLiveAnchorRoomInfo, iQQLiveAnchorRoomThirdPushCallback, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveSDK);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSOCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataPushInfo);
                return;
            }
            if (qQLiveAnchorDataPushInfo.isSuccess) {
                this.f270904a.thirdPushInfo = new QQLiveAnchorDataPushInfo(qQLiveAnchorDataPushInfo);
                this.f270905b.onGetPushInfo(new QQLiveAnchorDataPushInfo(qQLiveAnchorDataPushInfo));
                QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams = this.f270906c;
                if (qQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay) {
                    q.this.c(this.f270907d, this.f270904a, qQLiveAnchorAutoCheckPullPlayParams, this.f270905b);
                }
            } else {
                this.f270905b.onGetPushInfo(new QQLiveAnchorDataPushInfo(qQLiveAnchorDataPushInfo));
                this.f270905b.onError(new QQLiveErrorMsg(qQLiveAnchorDataPushInfo.errorMsg));
            }
            q.this.f270902a = false;
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270902a = false;
            this.f270903b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback, QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
        if (qQLiveAnchorDataPullInfo.isSuccess && qQLiveAnchorRoomInfo != null && qQLiveAnchorRoomInfo.thirdPushInfo != null) {
            qQLiveAnchorRoomInfo.thirdPullInfo = new QQLiveAnchorDataPullInfo(qQLiveAnchorDataPullInfo);
        }
        iQQLiveAnchorRoomThirdPushCallback.onGetPullInfo(new QQLiveAnchorDataPullInfo(qQLiveAnchorDataPullInfo));
        this.f270903b = false;
    }

    public void c(IQQLiveSDK iQQLiveSDK, final QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, final IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, iQQLiveSDK, qQLiveAnchorRoomInfo, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPushCallback);
            return;
        }
        if (this.f270903b) {
            QLog.e("QQLiveAnchor_thirdpush", 1, "gettingPullUrl, ignore");
            return;
        }
        this.f270903b = true;
        try {
            iQQLiveAnchorRoomThirdPushCallback.onStartGetPullInfo();
            ot3.d dVar = new ot3.d();
            dVar.f424026f = 1;
            dVar.f424025e = com.tencent.mobileqq.qqlive.anchor.util.a.M(iQQLiveSDK.getAppId());
            if (qQLiveAnchorRoomInfo != null) {
                dVar.f424023c = qQLiveAnchorRoomInfo.uid;
                dVar.f424024d = qQLiveAnchorRoomInfo.roomData.f271212id;
                QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo = qQLiveAnchorRoomInfo.thirdPushInfo;
                if (qQLiveAnchorDataPushInfo != null) {
                    str = qQLiveAnchorDataPushInfo.rtmpUrl;
                    QQLiveAnchorSSO.getRtmpPullUrl(iQQLiveSDK, str, dVar, qQLiveAnchorAutoCheckPullPlayParams, new QQLiveAnchorSSOCallback() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.p
                        @Override // com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSOCallback
                        public final void onResult(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
                            q.this.e(qQLiveAnchorRoomInfo, iQQLiveAnchorRoomThirdPushCallback, (QQLiveAnchorDataPullInfo) qQLiveAnchorDataBase);
                        }
                    });
                }
            }
            str = null;
            QQLiveAnchorSSO.getRtmpPullUrl(iQQLiveSDK, str, dVar, qQLiveAnchorAutoCheckPullPlayParams, new QQLiveAnchorSSOCallback() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.p
                @Override // com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSOCallback
                public final void onResult(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
                    q.this.e(qQLiveAnchorRoomInfo, iQQLiveAnchorRoomThirdPushCallback, (QQLiveAnchorDataPullInfo) qQLiveAnchorDataBase);
                }
            });
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_thirdpush", 1, th5, new Object[0]);
            this.f270903b = false;
        }
    }

    public void d(IQQLiveSDK iQQLiveSDK, QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iQQLiveSDK, qQLiveAnchorRoomInfo, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPushCallback);
            return;
        }
        if (this.f270902a) {
            QLog.e("QQLiveAnchor_thirdpush", 1, "gettingPushUrl, ignore");
            return;
        }
        this.f270902a = true;
        try {
            iQQLiveAnchorRoomThirdPushCallback.onStartGetPushInfo();
            QQLiveAnchorSSO.getRtmpPushUrl(iQQLiveSDK, com.tencent.mobileqq.qqlive.anchor.util.a.A(qQLiveAnchorRoomInfo), new a(qQLiveAnchorRoomInfo, iQQLiveAnchorRoomThirdPushCallback, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveSDK));
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_thirdpush", 1, th5, new Object[0]);
            this.f270902a = false;
        }
    }
}
