package com.tencent.biz.now;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.now_proxy.pb_now_proxy$ForwardReq;
import com.tencent.now_proxy.pb_now_proxy$ForwardRsp;
import com.tencent.pb.now.ilive_get_record_info_svr$GetRoomStateReq;
import com.tencent.pb.now.ilive_get_record_info_svr$GetRoomStateRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NowRecordInfo extends BusinessHandler {
    public static String C = "NowRecordInfo";

    /* renamed from: d, reason: collision with root package name */
    a f78771d;

    /* renamed from: e, reason: collision with root package name */
    long f78772e;

    /* renamed from: f, reason: collision with root package name */
    boolean f78773f;

    /* renamed from: h, reason: collision with root package name */
    int f78774h;

    /* renamed from: i, reason: collision with root package name */
    String f78775i;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f78776m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z16, String str, String str2, long j3, String str3);
    }

    public NowRecordInfo(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f78772e = 0L;
        this.f78773f = false;
        this.f78776m = qQAppInterface;
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = false;
        this.f78773f = false;
        this.f78772e = 0L;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        }
        if (!z16) {
            this.f78774h = fromServiceMsg.getBusinessFailCode();
            this.f78775i = fromServiceMsg.getBusinessFailMsg();
            G2(true, "", "", System.currentTimeMillis() - this.f78772e, "");
            return;
        }
        pb_now_proxy$ForwardRsp pb_now_proxy_forwardrsp = new pb_now_proxy$ForwardRsp();
        try {
            pb_now_proxy_forwardrsp.mergeFrom((byte[]) obj);
            if (pb_now_proxy_forwardrsp.busi_error_code.get() == 0 && pb_now_proxy_forwardrsp.busi_buf.get() != null) {
                I2(pb_now_proxy_forwardrsp.busi_error_code.get(), pb_now_proxy_forwardrsp.busi_buf.get().toByteArray());
            } else {
                this.f78774h = pb_now_proxy_forwardrsp.busi_error_code.get();
                G2(true, "", "", System.currentTimeMillis() - this.f78772e, "");
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            G2(true, "", "", System.currentTimeMillis() - this.f78772e, "");
        }
    }

    private void J2(byte[] bArr, String str) {
        if (this.f78776m == null) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", str, "NowGetRecordInfoSvr.get_record_info");
        toServiceMsg.putWupBuffer(bArr);
        sendPbReq(toServiceMsg);
    }

    public int D2() {
        return this.f78774h;
    }

    public String E2() {
        return this.f78775i;
    }

    public void F2(String str, long j3, String str2, a aVar) {
        this.f78771d = aVar;
        this.f78772e = System.currentTimeMillis();
        if (this.f78776m == null) {
            QLog.e(C, 1, "getRecordInfo fail,app is null ");
            G2(true, "", "", 0L, "");
            return;
        }
        this.f78773f = true;
        ilive_get_record_info_svr$GetRoomStateReq ilive_get_record_info_svr_getroomstatereq = new ilive_get_record_info_svr$GetRoomStateReq();
        ilive_get_record_info_svr_getroomstatereq.source.set(str);
        ilive_get_record_info_svr_getroomstatereq.roomid.set((int) j3);
        pb_now_proxy$ForwardReq pb_now_proxy_forwardreq = new pb_now_proxy$ForwardReq();
        pb_now_proxy_forwardreq.cmd.set(26182);
        pb_now_proxy_forwardreq.subcmd.set(2);
        pb_now_proxy_forwardreq.uid.set(Long.valueOf(str2).longValue());
        pb_now_proxy_forwardreq.platform.set(1);
        pb_now_proxy_forwardreq.codec.set(0);
        pb_now_proxy_forwardreq.busi_buf.set(ByteStringMicro.copyFrom(ilive_get_record_info_svr_getroomstatereq.get().toByteArray()));
        pb_now_proxy_forwardreq.original_id_type.set(1);
        pb_now_proxy_forwardreq.original_id.set(str2);
        J2(pb_now_proxy_forwardreq.toByteArray(), str2);
    }

    protected void G2(boolean z16, String str, String str2, long j3, String str3) {
        a aVar = this.f78771d;
        if (aVar != null) {
            aVar.a(z16, str2, str, j3, str3);
        }
    }

    public void I2(int i3, byte[] bArr) {
        boolean z16;
        QLog.i(C, 2, "\u62c9\u53d6\u5f55\u64ad\u4fe1\u606f\u6210\u529f");
        this.f78774h = 0;
        this.f78775i = "";
        try {
            ilive_get_record_info_svr$GetRoomStateRsp ilive_get_record_info_svr_getroomstatersp = new ilive_get_record_info_svr$GetRoomStateRsp();
            ilive_get_record_info_svr_getroomstatersp.mergeFrom(bArr);
            int i16 = ilive_get_record_info_svr_getroomstatersp.is_on_live.get();
            String str = ilive_get_record_info_svr_getroomstatersp.vid.get();
            String str2 = ilive_get_record_info_svr_getroomstatersp.recorded_share_url.get();
            String str3 = ilive_get_record_info_svr_getroomstatersp.another_live_mqq.get();
            if (i16 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            G2(z16, str, str2, System.currentTimeMillis() - this.f78772e, str3);
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.e(C, 1, "NowRecordObserver InvalidProtocolBufferMicroException! ");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("NowGetRecordInfoSvr.get_record_info".equals(fromServiceMsg.getServiceCmd())) {
            QLog.i(C, 1, "onReceive called.");
            H2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
