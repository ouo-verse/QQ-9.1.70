package com.tencent.biz.pubaccount;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountStQWebServletImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.oac.OACProfilePb$ProfileDataReq;
import com.tencent.pb.oac.OACProfilePb$ProfileDataRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

/* loaded from: classes32.dex */
public class PublicAccountStQWebServletWrapper extends PublicAccountStQWebServletImpl {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class a<T extends MessageMicro<?>> implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        private b<T> f78837d;

        /* renamed from: e, reason: collision with root package name */
        private Class<T> f78838e;

        public a(b<T> bVar, Class<T> cls) {
            this.f78837d = bVar;
            this.f78838e = cls;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            b<T> bVar = this.f78837d;
            if (bVar == null) {
                return;
            }
            if (!z16) {
                bVar.a(i3, z16, null, bundle);
            }
            byte[] byteArray = bundle.getByteArray("data");
            if (a(byteArray, this.f78838e) == null) {
                this.f78837d.a(i3, false, null, bundle);
            } else {
                this.f78837d.a(i3, z16, a(byteArray, this.f78838e), bundle);
            }
        }

        private T a(byte[] bArr, Class<T> cls) {
            try {
                T newInstance = cls.newInstance();
                if (bArr == null) {
                    return null;
                }
                newInstance.mergeFrom(bArr);
                return newInstance;
            } catch (Throwable th5) {
                QQToast.makeText(BaseApplication.getContext(), R.string.d6b, 0).show();
                QLog.w("PublicAccountStQWebServlet", 4, "decode pb err:" + th5.getMessage(), th5);
                return null;
            }
        }
    }

    /* loaded from: classes32.dex */
    public interface b<T> {
        void a(int i3, boolean z16, T t16, Bundle bundle);
    }

    public static <E extends MessageMicro<?>> void sendCmd(String str, MessageMicro<?> messageMicro, Class<E> cls, b<E> bVar) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), PublicAccountStQWebServletWrapper.class);
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        stQWebReq.Seq.set(-1L);
        stQWebReq.qua.set(QUA.getQUA3());
        stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(messageMicro.toByteArray()));
        String traceId = ze0.a.getTraceId();
        if (!TextUtils.isEmpty(traceId)) {
            stQWebReq.traceid.set(traceId);
        }
        newIntent.putExtra("traceid", traceId);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", stQWebReq.toByteArray());
        newIntent.setObserver(new a(bVar, cls));
        BaseApplicationImpl.getApplication().peekAppRuntime().startServlet(newIntent);
    }

    @Override // com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        ((IRIJNetworkUtils) QRoute.api(IRIJNetworkUtils.class)).debugSendPb(byteArrayExtra, stringExtra);
        packet.setSSOCommand(stringExtra);
        if (byteArrayExtra != null) {
            packet.putSendData(fh.b(byteArrayExtra));
        }
    }

    public static void getAccountDetail(Long l3, String str, b<OACProfilePb$ProfileDataRsp> bVar) {
        if (str == null) {
            str = "";
        }
        OACProfilePb$ProfileDataReq oACProfilePb$ProfileDataReq = new OACProfilePb$ProfileDataReq();
        oACProfilePb$ProfileDataReq.puin.set(l3.longValue());
        oACProfilePb$ProfileDataReq.attachinfo.set(str);
        sendCmd("officialaccount.clientbusilogic.DataProfile", oACProfilePb$ProfileDataReq, OACProfilePb$ProfileDataRsp.class, bVar);
    }
}
