package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class y {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        protected abstract void b(boolean z16, long j3, IPublicAccountDetail iPublicAccountDetail);

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            IPublicAccountDetail iPublicAccountDetail = null;
            if (i3 == 0 && bundle != null) {
                j3 = bundle.getLong("uin");
                if (bArr != null) {
                    mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
                    try {
                        mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(bArr);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        z16 = false;
                    }
                    if (mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.has()) {
                        if (mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get() == 0) {
                            try {
                                iPublicAccountDetail = ((IPublicAccountDetail) QRoute.api(IPublicAccountDetail.class)).init(mobileqq_mp_getpublicaccountdetailinforesponse);
                            } catch (InvalidProtocolBufferMicroException e17) {
                                e = e17;
                                if (QLog.isColorLevel()) {
                                    QLog.i("TroopBindPubAccountProtocol", 2, e.toString());
                                }
                                z17 = z16;
                                b(z17, j3, iPublicAccountDetail);
                            }
                            z17 = z16;
                        }
                    }
                    z16 = false;
                    z17 = z16;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopBindPubAccountProtocol", 2, "get pubAccountInfo failed, errorCode=" + i3);
                }
                j3 = 0;
            }
            b(z17, j3, iPublicAccountDetail);
        }
    }

    public static void a(QQAppInterface qQAppInterface, long j3, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        if (j3 <= 0) {
            return;
        }
        mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
        mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        mobileqq_mp_getpublicaccountdetailinforequest.version.set(1);
        mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(0);
        mobileqq_mp_getpublicaccountdetailinforequest.luin.set(j3);
        Bundle bundle = new Bundle();
        bundle.putLong("uin", j3);
        ProtoUtils.e(qQAppInterface, troopProtocolObserver, mobileqq_mp_getpublicaccountdetailinforequest.toByteArray(), "PubAccountSvc.get_detail_info", bundle);
    }
}
