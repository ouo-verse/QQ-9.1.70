package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO;
import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSOCallback;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f270884a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.widget.verify.g f270885b;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270884a = false;
        }
    }

    private void c(@NonNull final Activity activity, final IQQLiveSDK iQQLiveSDK, long j3, final byte[] bArr, final IQQLiveAnchorRoomPrepare iQQLiveAnchorRoomPrepare) {
        try {
            iQQLiveAnchorRoomPrepare.onStartFaceAuth();
            this.f270885b = new com.tencent.mobileqq.qqlive.widget.verify.g() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.g
                @Override // com.tencent.mobileqq.qqlive.widget.verify.g
                public final void a(int i3, String str) {
                    h.this.e(iQQLiveAnchorRoomPrepare, activity, iQQLiveSDK, bArr, i3, str);
                }
            };
            com.tencent.mobileqq.qqlive.widget.verify.l.f274086a.i(activity, QQLiveBusinessConfig.f271165b.a(), String.valueOf(iQQLiveSDK.getLoginModule().getUserInfo().uid), this.f270885b);
        } catch (Throwable th5) {
            this.f270885b = null;
            QLog.e("QQLiveAnchorHelperPrepare", 1, "faceAuth, error, seq:" + j3, th5);
        }
    }

    private void d(@Nullable Activity activity, IQQLiveSDK iQQLiveSDK, IQQLiveAnchorRoomPrepare iQQLiveAnchorRoomPrepare, long j3, byte[] bArr, QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        if (iQQLiveAnchorRoomPrepare == null) {
            QLog.e("QQLiveAnchorHelperPrepare", 1, "[handlePrepareResult] callback is null, seq:" + j3);
            return;
        }
        if (qQLiveAnchorDataPrepare == null) {
            h(iQQLiveAnchorRoomPrepare, "[handlePrepareResult] data is null, seq:" + j3);
            return;
        }
        QLog.i("QQLiveAnchorHelperPrepare", 1, String.format("[handlePrepareResult] data:%s, seq:%s", qQLiveAnchorDataPrepare.errorMsg, Long.valueOf(j3)));
        if (qQLiveAnchorDataPrepare.roomInfo != null) {
            QLog.i("QQLiveAnchorHelperPrepare", 1, "[handlePrepareResult] programId:" + qQLiveAnchorDataPrepare.roomInfo.programId);
        }
        try {
            if (qQLiveAnchorDataPrepare.isSuccess) {
                iQQLiveAnchorRoomPrepare.onPrepare(new QQLiveAnchorDataPrepare(qQLiveAnchorDataPrepare));
                return;
            }
            QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataPrepare.errorMsg;
            if (qQLiveErrorMsg != null && qQLiveErrorMsg.originErrCode == 1004 && activity != null) {
                c(activity, iQQLiveSDK, j3, bArr, iQQLiveAnchorRoomPrepare);
            } else {
                iQQLiveAnchorRoomPrepare.onPrepare(new QQLiveAnchorDataPrepare(qQLiveAnchorDataPrepare));
                iQQLiveAnchorRoomPrepare.onError(new QQLiveErrorMsg(qQLiveAnchorDataPrepare.errorMsg));
            }
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchorHelperPrepare", 1, "[handlePrepareResult] exception ", th5);
            h(iQQLiveAnchorRoomPrepare, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(IQQLiveAnchorRoomPrepare iQQLiveAnchorRoomPrepare, Activity activity, IQQLiveSDK iQQLiveSDK, byte[] bArr, int i3, String str) {
        QLog.i("QQLiveAnchorHelperPrepare", 1, "faceAuth, callback, code = " + i3);
        if (i3 == 0) {
            iQQLiveAnchorRoomPrepare.onFaceAuth(new QQLiveAnchorDataAuth(true, null));
            g(activity, iQQLiveSDK, bArr, iQQLiveAnchorRoomPrepare);
        } else {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6210;
            qQLiveErrorMsg.bizErrMsg = "auth error: " + str;
            qQLiveErrorMsg.originErrCode = i3;
            iQQLiveAnchorRoomPrepare.onFaceAuth(new QQLiveAnchorDataAuth(false, qQLiveErrorMsg));
            iQQLiveAnchorRoomPrepare.onPrepare(new QQLiveAnchorDataPrepare(false, qQLiveErrorMsg));
        }
        this.f270885b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Activity activity, IQQLiveSDK iQQLiveSDK, IQQLiveAnchorRoomPrepare iQQLiveAnchorRoomPrepare, long j3, byte[] bArr, QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        d(activity, iQQLiveSDK, iQQLiveAnchorRoomPrepare, j3, bArr, qQLiveAnchorDataPrepare);
        this.f270884a = false;
    }

    private void h(@NonNull IQQLiveAnchorRoomPrepare iQQLiveAnchorRoomPrepare, String str) {
        QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
        qQLiveErrorMsg.bizModule = 2;
        qQLiveErrorMsg.bizErrCode = -1;
        qQLiveErrorMsg.bizErrMsg = str;
        iQQLiveAnchorRoomPrepare.onPrepare(new QQLiveAnchorDataPrepare(false, qQLiveErrorMsg));
        iQQLiveAnchorRoomPrepare.onError(qQLiveErrorMsg);
    }

    public void g(@Nullable final Activity activity, final IQQLiveSDK iQQLiveSDK, final byte[] bArr, final IQQLiveAnchorRoomPrepare iQQLiveAnchorRoomPrepare) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, iQQLiveSDK, bArr, iQQLiveAnchorRoomPrepare);
            return;
        }
        QLog.i("QQLiveAnchorHelperPrepare", 1, "prepare start");
        if (this.f270884a) {
            QLog.e("QQLiveAnchorHelperPrepare", 1, "preparing, ignore");
            return;
        }
        this.f270884a = true;
        if (iQQLiveSDK != null && iQQLiveAnchorRoomPrepare != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchorHelperPrepare", 1, "prepare, start, seq:" + currentTimeMillis);
            }
            try {
                iQQLiveAnchorRoomPrepare.onStartPrepare();
                gr4.n nVar = new gr4.n();
                nVar.f403151b = com.tencent.mobileqq.qqlive.utils.e.a();
                if (bArr != null) {
                    nVar.f403156g = bArr;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQLiveAnchorHelperPrepare", 1, "prepare, machineId:" + nVar.f403151b);
                }
                QQLiveAnchorSSO.prepare(iQQLiveSDK, nVar, new QQLiveAnchorSSOCallback() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.f
                    @Override // com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSOCallback
                    public final void onResult(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
                        h.this.f(activity, iQQLiveSDK, iQQLiveAnchorRoomPrepare, currentTimeMillis, bArr, (QQLiveAnchorDataPrepare) qQLiveAnchorDataBase);
                    }
                });
                return;
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchorHelperPrepare", 1, "prepare, error, seq:" + currentTimeMillis, th5);
                this.f270884a = false;
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("prepare, params is null, activity's null=");
        if (activity == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", liveSDK's null=");
        if (iQQLiveSDK == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append(", callback's null=");
        if (iQQLiveAnchorRoomPrepare == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        sb5.append(z18);
        QLog.e("QQLiveAnchorHelperPrepare", 1, sb5.toString());
        if (iQQLiveAnchorRoomPrepare != null) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6200;
            qQLiveErrorMsg.bizErrMsg = "params is null";
            iQQLiveAnchorRoomPrepare.onPrepare(new QQLiveAnchorDataPrepare(false, qQLiveErrorMsg));
            iQQLiveAnchorRoomPrepare.onError(qQLiveErrorMsg);
        }
    }
}
