package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByLinkRsp;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
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
public class GetAppInfoByLinkRequest extends ProtoBufRequest {
    private static final String unikey = "GetAppInfoByLink";
    private JSONObject mJSONObject = new JSONObject();
    private INTERFACE$StGetAppInfoByLinkReq req = new INTERFACE$StGetAppInfoByLinkReq();

    public GetAppInfoByLinkRequest(String str, int i3) {
        if (getContentType() == 0) {
            this.req.link.set(str);
            this.req.linkType.set(i3);
            return;
        }
        try {
            this.mJSONObject.put(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, str);
            this.mJSONObject.put("linkType", i3);
        } catch (Exception e16) {
            QMLog.d("ProtoBufRequest", "GetAppInfoByLinkRequest Exception:" + e16);
        }
    }

    private void savaMiniAppInfo(final MiniAppInfo miniAppInfo) {
        if (!ProcessUtil.isMainProcess(AppLoaderFactory.g().getContext())) {
            return;
        }
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest.1
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
        return "GetAppInfoByLink";
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
            INTERFACE$StGetAppInfoByLinkRsp iNTERFACE$StGetAppInfoByLinkRsp = new INTERFACE$StGetAppInfoByLinkRsp();
            try {
                iNTERFACE$StGetAppInfoByLinkRsp.mergeFrom(bArr);
                INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = iNTERFACE$StGetAppInfoByLinkRsp.appInfo;
                if (iNTERFACE$StApiAppInfo != null) {
                    MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
                    from.link = this.req.link.get();
                    from.linkType = this.req.linkType.get();
                    Object obj = iNTERFACE$StGetAppInfoByLinkRsp.shareTicket.get();
                    jSONObject.put("mini_app_info_data", from);
                    jSONObject.put(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB, iNTERFACE$StGetAppInfoByLinkRsp.appInfo.get().toByteArray());
                    jSONObject.put("shareTicket", obj);
                    if (iNTERFACE$StGetAppInfoByLinkRsp.appInfo.type.get() == 3) {
                        savaMiniAppInfo(from);
                    }
                    return jSONObject;
                }
                QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
                return null;
            } catch (Exception e16) {
                QMLog.d("ProtoBufRequest", "onResponse fail." + e16);
                return null;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject(new String(bArr));
            JSONObject optJSONObject = jSONObject2.optJSONObject("appInfo");
            MiniAppInfo createMiniAppInfo = MiniAppInfo.createMiniAppInfo(optJSONObject);
            createMiniAppInfo.link = this.mJSONObject.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
            createMiniAppInfo.linkType = this.mJSONObject.optInt("linkType");
            jSONObject.put("mini_app_info_data", createMiniAppInfo);
            jSONObject.put(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON, optJSONObject);
            jSONObject.put("shareTicket", jSONObject2.optString("shareTicket"));
            if (createMiniAppInfo.verType == 3) {
                savaMiniAppInfo(createMiniAppInfo);
            }
            return jSONObject;
        } catch (Exception e17) {
            QMLog.d("ProtoBufRequest", "onResponse fail." + e17);
            return null;
        }
    }
}
