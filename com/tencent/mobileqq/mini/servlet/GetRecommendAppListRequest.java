package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$DeviceInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetRecommendAppListReq;
import NS_MINI_INTERFACE.INTERFACE$StGetRecommendAppListRsp;
import NS_MINI_INTERFACE.INTERFACE$StRecommendApp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetRecommendAppListRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetRecommendAppList";
    public static final String KEY_RSP = "response";
    public static final String TAG = "GetRecommendAppListRequest";
    private INTERFACE$StGetRecommendAppListReq req;

    public GetRecommendAppListRequest(COMM.StCommonExt stCommonExt, String str, int i3, long j3, ArrayList<INTERFACE$StRecommendApp> arrayList, INTERFACE$DeviceInfo iNTERFACE$DeviceInfo) {
        INTERFACE$StGetRecommendAppListReq iNTERFACE$StGetRecommendAppListReq = new INTERFACE$StGetRecommendAppListReq();
        this.req = iNTERFACE$StGetRecommendAppListReq;
        iNTERFACE$StGetRecommendAppListReq.appId.set(str);
        this.req.verType.set(i3);
        this.req.useTime.set(j3);
        this.req.oldRecommendList.set(arrayList);
        this.req.deviceInfo.set(iNTERFACE$DeviceInfo);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, NS_MINI_INTERFACE.INTERFACE$StGetRecommendAppListRsp] */
    public static INTERFACE$StGetRecommendAppListRsp onResponse(byte[] bArr) {
        ?? r06 = new MessageMicro<INTERFACE$StGetRecommendAppListRsp>() { // from class: NS_MINI_INTERFACE.INTERFACE$StGetRecommendAppListRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "recommendModule"}, new Object[]{null, null}, INTERFACE$StGetRecommendAppListRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
            public final PBRepeatMessageField<INTERFACE$StModuleInfo> recommendModule = PBField.initRepeatMessage(INTERFACE$StModuleInfo.class);
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
