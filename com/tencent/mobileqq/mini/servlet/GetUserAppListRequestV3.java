package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$DeviceInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetDropdownAppListReq;
import NS_MINI_INTERFACE.INTERFACE$StGetDropdownAppListRsp;
import NS_MINI_INTERFACE.INTERFACE$StRecommendApp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetUserAppListRequestV3 extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_dropdown.GetDropdownAppList";
    public static final String KEY_RSP = "response";
    private INTERFACE$StGetDropdownAppListReq req;

    public GetUserAppListRequestV3(COMM.StCommonExt stCommonExt, ArrayList<INTERFACE$StRecommendApp> arrayList, ArrayList<Integer> arrayList2, int i3, INTERFACE$DeviceInfo iNTERFACE$DeviceInfo, ArrayList<Integer> arrayList3, ArrayList<String> arrayList4) {
        INTERFACE$StGetDropdownAppListReq iNTERFACE$StGetDropdownAppListReq = new INTERFACE$StGetDropdownAppListReq();
        this.req = iNTERFACE$StGetDropdownAppListReq;
        if (stCommonExt != null) {
            iNTERFACE$StGetDropdownAppListReq.extInfo.set(stCommonExt);
        }
        this.req.oldRecommendList.set(arrayList);
        this.req.types.set(arrayList2);
        this.req.hasCache.set(i3);
        this.req.deviceInfo.set(iNTERFACE$DeviceInfo);
        this.req.subTypes.set(arrayList3);
        this.req.itemIds.set(arrayList4);
    }

    public static INTERFACE$StGetDropdownAppListRsp onResponse(byte[] bArr) {
        INTERFACE$StGetDropdownAppListRsp iNTERFACE$StGetDropdownAppListRsp = new INTERFACE$StGetDropdownAppListRsp();
        try {
            iNTERFACE$StGetDropdownAppListRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetDropdownAppListRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
