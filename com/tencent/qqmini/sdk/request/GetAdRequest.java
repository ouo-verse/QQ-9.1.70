package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_AD.MiniAppAd$StGetAdForSdkReq;
import NS_MINI_AD.MiniAppAd$StGetAdForSdkRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetAdRequest extends ProtoBufRequest {
    private static final String TAG = "GetAdRequest";
    private MiniAppAd$StGetAdForSdkReq req;

    public GetAdRequest(String str, int i3, String str2, String str3, String str4, HashMap<String, String> hashMap) {
        MiniAppAd$StGetAdForSdkReq miniAppAd$StGetAdForSdkReq = new MiniAppAd$StGetAdForSdkReq();
        this.req = miniAppAd$StGetAdForSdkReq;
        miniAppAd$StGetAdForSdkReq.strAppid.set(str);
        this.req.iAdType.set(i3);
        this.req.strGetAdUrl.set(str4);
        ArrayList arrayList = new ArrayList();
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                COMM.Entry entry2 = new COMM.Entry();
                entry2.key.set(key);
                entry2.value.set(value);
                arrayList.add(entry2);
            }
        }
        if (arrayList.size() > 0) {
            this.req.mapParam.addAll(arrayList);
        }
        COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
        ArrayList arrayList2 = new ArrayList();
        COMM.Entry entry3 = new COMM.Entry();
        entry3.key.set("refer");
        entry3.value.set(TextUtils.isEmpty(str2) ? "" : str2);
        arrayList2.add(entry3);
        COMM.Entry entry4 = new COMM.Entry();
        entry4.key.set("via");
        entry4.value.set(TextUtils.isEmpty(str3) ? "" : str3);
        arrayList2.add(entry4);
        stCommonExt.mapInfo.set(arrayList2);
        this.req.extInfo.setHasFlag(true);
        this.req.extInfo.set(stCommonExt);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetAdForSdk";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_ad";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MessageMicro<MiniAppAd$StGetAdForSdkRsp> messageMicro = new MessageMicro<MiniAppAd$StGetAdForSdkRsp>() { // from class: NS_MINI_AD.MiniAppAd$StGetAdForSdkRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "strAdRspJson"}, new Object[]{null, ""}, MiniAppAd$StGetAdForSdkRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
            public final PBStringField strAdRspJson = PBField.initString("");
        };
        try {
            messageMicro.mergeFrom(bArr);
            jSONObject.put("response", messageMicro);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, jSONObject.get("retCode"));
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
