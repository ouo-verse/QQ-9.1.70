package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StRejectFrequentlyRecommendsReq;
import NS_MINI_INTERFACE.INTERFACE$StRejectFrequentlyRecommendsRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RejectFrequentlyRecommendsReq extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.RejectFrequentlyRecommends";
    private static final String TAG = "RejectFrequentlyRecommendsReq";
    private INTERFACE$StRejectFrequentlyRecommendsReq req;

    public RejectFrequentlyRecommendsReq(String str) {
        INTERFACE$StRejectFrequentlyRecommendsReq iNTERFACE$StRejectFrequentlyRecommendsReq = new INTERFACE$StRejectFrequentlyRecommendsReq();
        this.req = iNTERFACE$StRejectFrequentlyRecommendsReq;
        iNTERFACE$StRejectFrequentlyRecommendsReq.appID.set(str);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [NS_MINI_INTERFACE.INTERFACE$StRejectFrequentlyRecommendsRsp, com.tencent.mobileqq.pb.MessageMicro] */
    public static INTERFACE$StRejectFrequentlyRecommendsRsp onResponse(byte[] bArr) {
        ?? r06 = new MessageMicro<INTERFACE$StRejectFrequentlyRecommendsRsp>() { // from class: NS_MINI_INTERFACE.INTERFACE$StRejectFrequentlyRecommendsRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"state", "msg"}, new Object[]{0, ""}, INTERFACE$StRejectFrequentlyRecommendsRsp.class);
            public final PBUInt32Field state = PBField.initUInt32(0);

            /* renamed from: msg, reason: collision with root package name */
            public final PBStringField f24967msg = PBField.initString("");
        };
        try {
            r06.mergeFrom(bArr);
            return r06;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
