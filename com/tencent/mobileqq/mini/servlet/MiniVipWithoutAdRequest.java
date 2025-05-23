package com.tencent.mobileqq.mini.servlet;

import NS_MINI_AD.MiniAppAd$StGetMemberStateReq;
import NS_MINI_AD.MiniAppAd$StGetMemberStateRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniVipWithoutAdRequest extends ProtoBufRequest {
    private static final String TAG = "MiniVipWithoutAdRequest";
    private final MiniAppAd$StGetMemberStateReq req = new MessageMicro<MiniAppAd$StGetMemberStateReq>() { // from class: NS_MINI_AD.MiniAppAd$StGetMemberStateReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MiniAppAd$StGetMemberStateReq.class);
    };

    public static MiniAppAd$StGetMemberStateRsp onResponse(byte[] bArr) {
        MiniAppAd$StGetMemberStateRsp miniAppAd$StGetMemberStateRsp = new MiniAppAd$StGetMemberStateRsp();
        try {
            miniAppAd$StGetMemberStateRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppAd$StGetMemberStateRsp;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onResponse error:" + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return toByteArray();
    }
}
