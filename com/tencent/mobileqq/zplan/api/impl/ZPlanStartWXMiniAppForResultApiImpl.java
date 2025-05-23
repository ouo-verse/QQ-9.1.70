package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.zplan.api.IZPlanStartWXMiniAppForResultApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanStartWXMiniAppForResultApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanStartWXMiniAppForResultApi;", "", "ensureApi", "", "getWXAppId", "originId", "path", "", "miniprogramType", "startWXMiniAppForResult", "WX_APP_ID_RELEASE", "Ljava/lang/String;", "WX_APP_ID_DEBUG", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "wxApi", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanStartWXMiniAppForResultApiImpl implements IZPlanStartWXMiniAppForResultApi {
    public static final String TAG = "ZPlanStartWXMiniAppForResult";
    private IWXAPI wxApi;
    private final String WX_APP_ID_RELEASE = "wxf14070172bb44e41";
    private final String WX_APP_ID_DEBUG = "wx8fa54061b1675a6f";

    private final void ensureApi() {
        if (this.wxApi == null) {
            String wx_app_id_release = getWX_APP_ID_RELEASE();
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(BaseApplication.context, wx_app_id_release, true);
            this.wxApi = createWXAPI;
            if (createWXAPI != null) {
                createWXAPI.registerApp(wx_app_id_release);
            }
        }
    }

    /* renamed from: getWXAppId, reason: from getter */
    private final String getWX_APP_ID_RELEASE() {
        return this.WX_APP_ID_RELEASE;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanStartWXMiniAppForResultApi
    public void startWXMiniAppForResult(String originId, String path, int miniprogramType) {
        Intrinsics.checkNotNullParameter(originId, "originId");
        Intrinsics.checkNotNullParameter(path, "path");
        ensureApi();
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = originId;
        req.miniprogramType = miniprogramType;
        req.path = path;
        IWXAPI iwxapi = this.wxApi;
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
        QLog.d(TAG, 1, "startWXMiniAppForResult,originId:" + originId + ",path:" + path + ",miniprogramType:" + miniprogramType);
    }
}
