package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByIdRsp;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByIdRequest;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetAppInfoByIdRequest extends ProtoBufRequest {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_APP_INFO_DATA = "mini_app_info_data";
    public static final String KEY_APP_INFO_DATA_JSON = "mini_app_info_data_json";
    public static final String KEY_APP_INFO_DATA_PB = "mini_app_info_data_pb";
    public static final String KEY_ENV_VERSION = "key_env_version";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_FIRST_PATH = "key_first_path";
    private static final String TAG = "GetAppInfoByIdRequest";
    private JSONObject mJSONObject = new JSONObject();
    private INTERFACE$StGetAppInfoByIdReq req;

    public GetAppInfoByIdRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, String str2, String str3, String str4) {
        if (getContentType() == 0) {
            INTERFACE$StGetAppInfoByIdReq iNTERFACE$StGetAppInfoByIdReq = new INTERFACE$StGetAppInfoByIdReq();
            this.req = iNTERFACE$StGetAppInfoByIdReq;
            iNTERFACE$StGetAppInfoByIdReq.appid.set(str);
            this.req.needVersionInfo.set(i3);
            this.req.checkDevRight.set(i16);
            this.req.firstPath.set(str2);
            this.req.envVersion.set(str3);
            this.req.fromAppid.set(str4 == null ? "" : str4);
            if (stCommonExt != null) {
                this.req.extInfo.set(stCommonExt);
                return;
            }
            return;
        }
        try {
            this.mJSONObject.put("appid", str);
            this.mJSONObject.put("needVersionInfo", i3);
            this.mJSONObject.put("checkDevRight", i16);
            this.mJSONObject.put("firstPath", str2);
            this.mJSONObject.put("envVersion", str3);
            this.mJSONObject.put("fromAppid", str4 == null ? "" : str4);
        } catch (Exception e16) {
            QMLog.d("GetAppInfoByIdRequest", "GetAppInfoByIdRequest Exception:" + e16);
        }
    }

    private void savaMiniAppInfo(final MiniAppInfo miniAppInfo) {
        if (!ProcessUtil.isMainProcess(AppLoaderFactory.g().getContext())) {
            return;
        }
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest.1
            @Override // java.lang.Runnable
            public void run() {
                ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).notifyMiniAppInfo(0, miniAppInfo);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        if (getContentType() == 0) {
            return this.req.toByteArray();
        }
        return this.mJSONObject.toString().getBytes();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return HttpGetAppInfoByIdRequest.CMD_STRING;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public int getContentType() {
        return QUAUtil.isAlienApp() ? 1 : 0;
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
        if (getContentType() == 0) {
            INTERFACE$StGetAppInfoByIdRsp iNTERFACE$StGetAppInfoByIdRsp = new INTERFACE$StGetAppInfoByIdRsp();
            try {
                iNTERFACE$StGetAppInfoByIdRsp.mergeFrom(bArr);
                INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = iNTERFACE$StGetAppInfoByIdRsp.appInfo;
                MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
                from.firstPath = this.req.firstPath.get();
                jSONObject.put("mini_app_info_data", from);
                jSONObject.put(KEY_APP_INFO_DATA_PB, iNTERFACE$StApiAppInfo.get().toByteArray());
                if (iNTERFACE$StGetAppInfoByIdRsp.appInfo.type.get() == 3) {
                    savaMiniAppInfo(from);
                }
                return jSONObject;
            } catch (Exception e16) {
                QMLog.d("GetAppInfoByIdRequest", "onResponse fail." + e16);
                return null;
            }
        }
        try {
            JSONObject optJSONObject = new JSONObject(new String(bArr)).optJSONObject("appInfo");
            MiniAppInfo createMiniAppInfo = MiniAppInfo.createMiniAppInfo(optJSONObject);
            createMiniAppInfo.firstPath = this.mJSONObject.optString("firstPath");
            jSONObject.put("mini_app_info_data", createMiniAppInfo);
            jSONObject.put(KEY_APP_INFO_DATA_JSON, optJSONObject);
            if (createMiniAppInfo.verType == 3) {
                savaMiniAppInfo(createMiniAppInfo);
            }
            return jSONObject;
        } catch (Exception e17) {
            QMLog.d("GetAppInfoByIdRequest", "onResponse fail." + e17);
            return null;
        }
    }
}
