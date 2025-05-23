package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserInteractiveStorageRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetUserInteractiveStorageRequest extends ProtoBufRequest {
    public static final String TAG = "GetUserInteractiveStorageRequest";
    private CloudStorage$StGetUserInteractiveStorageReq req;

    public GetUserInteractiveStorageRequest(COMM.StCommonExt stCommonExt, String str, String[] strArr) {
        CloudStorage$StGetUserInteractiveStorageReq cloudStorage$StGetUserInteractiveStorageReq = new CloudStorage$StGetUserInteractiveStorageReq();
        this.req = cloudStorage$StGetUserInteractiveStorageReq;
        if (stCommonExt != null) {
            cloudStorage$StGetUserInteractiveStorageReq.ext.set(stCommonExt);
        }
        for (String str2 : strArr) {
            this.req.keyList.add(str2);
        }
        this.req.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetUserInteractiveStorage";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_cloudstorage";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        CloudStorage$StGetUserInteractiveStorageRsp cloudStorage$StGetUserInteractiveStorageRsp = new CloudStorage$StGetUserInteractiveStorageRsp();
        try {
            cloudStorage$StGetUserInteractiveStorageRsp.mergeFrom(bArr);
            jSONObject.put("response", cloudStorage$StGetUserInteractiveStorageRsp);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("GetUserInteractiveStorageRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
