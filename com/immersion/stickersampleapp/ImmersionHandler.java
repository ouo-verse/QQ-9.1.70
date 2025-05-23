package com.immersion.stickersampleapp;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d$IMMRReq;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d$ReqBody;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d$RspBody;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ImmersionHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f38077d;

    /* renamed from: e, reason: collision with root package name */
    private b f38078e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        private b f38079d;

        public a(boolean z16, b bVar) {
            super(z16);
            this.f38079d = bVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            oidb_0xa4d$RspBody oidb_0xa4d_rspbody = new oidb_0xa4d$RspBody();
            if (i3 == 0) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i("ImmersionHandler", 2, "HapticMediaPlayer request success.errorcode = " + i3);
                    }
                    oidb_0xa4d_rspbody.mergeFrom(bArr);
                    this.f38079d.setConnection(new com.immersion.stickersampleapp.a(oidb_0xa4d_rspbody.msg_immr_rsp.get()));
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("ImmersionHandler", 2, "HapticMediaPlayer request failerrorcode = " + i3);
            }
            this.f38079d.setConnection(null);
        }
    }

    public ImmersionHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f38077d = qQAppInterface;
    }

    public void D2(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("ImmersionHandler", 2, "HapticMediaPlayer start request");
        }
        oidb_0xa4d$IMMRReq oidb_0xa4d_immrreq = new oidb_0xa4d$IMMRReq();
        oidb_0xa4d_immrreq.str_url.set(str);
        oidb_0xa4d$ReqBody oidb_0xa4d_reqbody = new oidb_0xa4d$ReqBody();
        oidb_0xa4d_reqbody.msg_immr_req.set(oidb_0xa4d_immrreq);
        ProtoUtils.b(this.f38077d, new a(false, this.f38078e), oidb_0xa4d_reqbody.toByteArray(), "OidbSvc.0xa4d", 2637, 1, null);
    }

    public void E2(b bVar) {
        this.f38078e = bVar;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
        this.f38077d = null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
