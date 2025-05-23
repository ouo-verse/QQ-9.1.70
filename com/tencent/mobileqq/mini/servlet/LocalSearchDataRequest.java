package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_APP_SEARCH.SEARCH$StLocalSearchDataReq;
import NS_MINI_APP_SEARCH.SEARCH$StLocalSearchDataRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LocalSearchDataRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_search.LocalSearchData";
    public static final String TAG = "LocalSearchDataRequest";
    private SEARCH$StLocalSearchDataReq req;

    public LocalSearchDataRequest(COMM.StCommonExt stCommonExt) {
        SEARCH$StLocalSearchDataReq sEARCH$StLocalSearchDataReq = new SEARCH$StLocalSearchDataReq();
        this.req = sEARCH$StLocalSearchDataReq;
        if (stCommonExt != null) {
            sEARCH$StLocalSearchDataReq.extInfo.set(stCommonExt);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, NS_MINI_APP_SEARCH.SEARCH$StLocalSearchDataRsp] */
    public static SEARCH$StLocalSearchDataRsp onResponse(byte[] bArr) {
        ?? r06 = new MessageMicro<SEARCH$StLocalSearchDataRsp>() { // from class: NS_MINI_APP_SEARCH.SEARCH$StLocalSearchDataRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "status", "items"}, new Object[]{null, 0, null}, SEARCH$StLocalSearchDataRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
            public final PBInt32Field status = PBField.initInt32(0);
            public final PBRepeatMessageField<SEARCH$StAppSearchItem> items = PBField.initRepeatMessage(SEARCH$StAppSearchItem.class);
        };
        try {
            r06.mergeFrom(ProtoBufRequest.decode(bArr));
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
