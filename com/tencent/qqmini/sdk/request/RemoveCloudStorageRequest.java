package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StRemoveUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StRemoveUserCloudStorageRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RemoveCloudStorageRequest extends ProtoBufRequest {
    private CloudStorage$StRemoveUserCloudStorageReq req = new CloudStorage$StRemoveUserCloudStorageReq();

    public RemoveCloudStorageRequest(String[] strArr, String str) {
        for (String str2 : strArr) {
            this.req.keyList.add(str2);
        }
        this.req.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "RemoveUserCloudStorage";
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
        try {
            new MessageMicro<CloudStorage$StRemoveUserCloudStorageRsp>() { // from class: NS_MINI_CLOUDSTORAGE.CloudStorage$StRemoveUserCloudStorageRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ext"}, new Object[]{null}, CloudStorage$StRemoveUserCloudStorageRsp.class);
                public COMM.StCommonExt ext = new COMM.StCommonExt();
            }.mergeFrom(bArr);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("ProtoBufRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
