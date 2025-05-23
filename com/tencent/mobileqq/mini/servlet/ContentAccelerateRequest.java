package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StContentAccelerateReq;
import NS_MINI_INTERFACE.INTERFACE$StContentAccelerateRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ContentAccelerateRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_accelerate_proxy.ContentAccelerate";
    public static final String TAG = "ContentAccelerateRequest";
    private INTERFACE$StContentAccelerateReq req;

    public ContentAccelerateRequest(COMM.StCommonExt stCommonExt, String str, String str2, int i3, Map<String, String> map) {
        INTERFACE$StContentAccelerateReq iNTERFACE$StContentAccelerateReq = new INTERFACE$StContentAccelerateReq();
        this.req = iNTERFACE$StContentAccelerateReq;
        iNTERFACE$StContentAccelerateReq.appid.set(str);
        this.req.dataUrl.set(str2);
        this.req.needCode.set(i3);
        if (map != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                COMM.Entry entry2 = new COMM.Entry();
                entry2.key.set(entry.getKey());
                entry2.value.set(entry.getValue());
                arrayList.add(entry2);
            }
            this.req.reqHeaders.set(arrayList);
        }
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StContentAccelerateRsp onResponse(byte[] bArr) {
        INTERFACE$StContentAccelerateRsp iNTERFACE$StContentAccelerateRsp = new INTERFACE$StContentAccelerateRsp();
        try {
            iNTERFACE$StContentAccelerateRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StContentAccelerateRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ContentAccelerateRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
