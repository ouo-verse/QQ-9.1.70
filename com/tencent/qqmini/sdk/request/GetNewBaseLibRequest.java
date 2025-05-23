package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StBaseLibInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetNewBaseLibReq;
import NS_MINI_INTERFACE.INTERFACE$StGetNewBaseLibRsp;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetNewBaseLibRequest extends ProtoBufRequest {
    private static final String TAG = "GetNewBaseLibRequest";
    private INTERFACE$StGetNewBaseLibReq req;

    public GetNewBaseLibRequest(String str, int i3) {
        INTERFACE$StGetNewBaseLibReq iNTERFACE$StGetNewBaseLibReq = new INTERFACE$StGetNewBaseLibReq();
        this.req = iNTERFACE$StGetNewBaseLibReq;
        iNTERFACE$StGetNewBaseLibReq.curVersion.set(str);
        this.req.type.set(i3);
    }

    public String getBaseLibUrl64(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            return new JSONObject(str).optString("downloadUrl_64", str2);
        } catch (Throwable th5) {
            QMLog.e(TAG, "Failed to parse downloadUrl_64", th5);
            return str2;
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return com.tencent.mobileqq.mini.servlet.GetNewBaseLibRequest.unikey;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetNewBaseLibRsp iNTERFACE$StGetNewBaseLibRsp = new INTERFACE$StGetNewBaseLibRsp();
        try {
            iNTERFACE$StGetNewBaseLibRsp.mergeFrom(bArr);
            int i3 = iNTERFACE$StGetNewBaseLibRsp.interval.get();
            QMLog.i(TAG, "[MiniEng] GetNewBaseLib interval:" + i3);
            StorageUtil.getPreference().edit().putLong("baselib_min_update_time", ((long) (i3 * 1000)) + System.currentTimeMillis()).apply();
            for (INTERFACE$StBaseLibInfo iNTERFACE$StBaseLibInfo : iNTERFACE$StGetNewBaseLibRsp.jsOrsoLibs.get()) {
                BaseLibInfo baseLibInfo = new BaseLibInfo();
                baseLibInfo.baseLibUrl = iNTERFACE$StBaseLibInfo.downloadUrl.get();
                baseLibInfo.baseLibVersion = iNTERFACE$StBaseLibInfo.version.get();
                baseLibInfo.baseLibKey = null;
                String str = iNTERFACE$StBaseLibInfo.extInfo.get();
                baseLibInfo.baseLibDesc = str;
                if (TextUtils.isEmpty(str)) {
                    baseLibInfo.baseLibDesc = "{'file_length':-1}";
                }
                baseLibInfo.baseLibType = iNTERFACE$StBaseLibInfo.libType.get();
                if (QUAUtil.isAbi64()) {
                    baseLibInfo.baseLibUrl = getBaseLibUrl64(baseLibInfo.baseLibDesc, baseLibInfo.baseLibUrl);
                }
                jSONObject.put(baseLibInfo.getKey(), baseLibInfo.toJSONObject());
                QMLog.i(TAG, "[MiniEng] GetNewBaseLib " + baseLibInfo);
            }
            jSONObject.put("version", iNTERFACE$StGetNewBaseLibRsp.libInfo.version.get());
            jSONObject.put("downloadUrl", iNTERFACE$StGetNewBaseLibRsp.libInfo.downloadUrl.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
