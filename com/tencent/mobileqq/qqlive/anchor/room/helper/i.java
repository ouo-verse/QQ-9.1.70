package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO;
import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSOCallback;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f270886a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements QQLiveAnchorSSOCallback<QQLiveAnchorDataSet> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f270887a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorRoomInfo f270888b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorDataRoomAttr f270889c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQLiveAnchorRoomSet f270890d;

        a(long j3, QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr, IQQLiveAnchorRoomSet iQQLiveAnchorRoomSet) {
            this.f270887a = j3;
            this.f270888b = qQLiveAnchorRoomInfo;
            this.f270889c = qQLiveAnchorDataRoomAttr;
            this.f270890d = iQQLiveAnchorRoomSet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, i.this, Long.valueOf(j3), qQLiveAnchorRoomInfo, qQLiveAnchorDataRoomAttr, iQQLiveAnchorRoomSet);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSOCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataSet);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_Set", 1, "set, handle result, seq:" + this.f270887a);
            }
            i.this.c(this.f270888b, this.f270889c, qQLiveAnchorDataSet, this.f270887a, this.f270890d);
            i.this.f270886a = false;
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270886a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr, QQLiveAnchorDataSet qQLiveAnchorDataSet, long j3, IQQLiveAnchorRoomSet iQQLiveAnchorRoomSet) {
        if (iQQLiveAnchorRoomSet == null) {
            return;
        }
        try {
            qQLiveAnchorRoomInfo.roomAttr = new QQLiveAnchorDataRoomAttr(qQLiveAnchorDataRoomAttr);
            com.tencent.mobileqq.qqlive.anchor.util.a.N(qQLiveAnchorDataRoomAttr, qQLiveAnchorRoomInfo);
            iQQLiveAnchorRoomSet.onSet(qQLiveAnchorDataSet);
            if (!qQLiveAnchorDataSet.isSuccess) {
                iQQLiveAnchorRoomSet.onError(new QQLiveErrorMsg(qQLiveAnchorDataSet.errorMsg));
            }
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_Set", 1, "set, handle error, seq:" + j3, th5);
            d("set, handle error", iQQLiveAnchorRoomSet);
        }
    }

    private void d(String str, IQQLiveAnchorRoomSet iQQLiveAnchorRoomSet) {
        if (iQQLiveAnchorRoomSet == null) {
            return;
        }
        QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
        qQLiveErrorMsg.bizModule = 2;
        qQLiveErrorMsg.bizErrCode = QQLiveError.ANCHOR_SET_ERR;
        qQLiveErrorMsg.bizErrMsg = str;
        iQQLiveAnchorRoomSet.onSet(new QQLiveAnchorDataSet(false, qQLiveErrorMsg));
        iQQLiveAnchorRoomSet.onError(qQLiveErrorMsg);
    }

    public void e(IQQLiveSDK iQQLiveSDK, QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr, byte[] bArr, IQQLiveAnchorRoomSet iQQLiveAnchorRoomSet) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iQQLiveSDK, qQLiveAnchorRoomInfo, qQLiveAnchorDataRoomAttr, bArr, iQQLiveAnchorRoomSet);
            return;
        }
        if (this.f270886a) {
            QLog.e("QQLiveAnchor_Set", 1, "setting, ignore");
            return;
        }
        if (iQQLiveSDK != null && qQLiveAnchorRoomInfo != null && qQLiveAnchorDataRoomAttr != null && iQQLiveAnchorRoomSet != null) {
            this.f270886a = true;
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_Set", 1, "set, start, seq:" + currentTimeMillis);
            }
            try {
                iQQLiveAnchorRoomSet.onStartSet();
                gr4.u C = com.tencent.mobileqq.qqlive.anchor.util.a.C(qQLiveAnchorRoomInfo, qQLiveAnchorDataRoomAttr);
                if (bArr != null) {
                    C.f403223j = bArr;
                } else {
                    fr4.c cVar = new fr4.c();
                    cVar.f400378a = IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID;
                    cVar.f400379b = iQQLiveSDK.getLoginModule().getLoginInfo().uid;
                    cVar.f400380c = iQQLiveSDK.getLoginModule().getLoginInfo().f271214a2.getBytes();
                    cVar.f400381d = 2;
                    cVar.f400382e = AppSetting.f99554n;
                    C.f403223j = MessageNano.toByteArray(cVar);
                }
                QQLiveAnchorSSO.set(iQQLiveSDK, C, new a(currentTimeMillis, qQLiveAnchorRoomInfo, qQLiveAnchorDataRoomAttr, iQQLiveAnchorRoomSet));
                return;
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_Set", 1, "set, error, seq:" + currentTimeMillis, th5);
                d("set, error", iQQLiveAnchorRoomSet);
                this.f270886a = false;
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("set, params is null, liveSDK's null=");
        if (iQQLiveSDK == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", roomInfo's null=");
        if (qQLiveAnchorRoomInfo == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append(", attr's null=");
        if (qQLiveAnchorDataRoomAttr == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        sb5.append(z18);
        sb5.append(", callback's null=");
        if (iQQLiveAnchorRoomSet == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        sb5.append(z19);
        QLog.e("QQLiveAnchor_Set", 1, sb5.toString());
        d("set, but params is null", iQQLiveAnchorRoomSet);
    }
}
