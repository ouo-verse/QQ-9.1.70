package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.module.vas.VasModule;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QvipSpecialCareHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.config.business.QVipHippyConfig;
import com.tencent.mobileqq.vas.config.business.QVipHippyProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHttpUtil;
import cooperation.qzone.report.lp.LpReportInfo_dc04233;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProtocolUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasDepTempImpl implements IVasDepTemp {
    private final String TAG = "VasDepTempImpl";
    private final String DT_REPORT_INDEX_POST_URL_PREFIX = "https://club.vip.qq.com/api/trpc/datong/DataReport?g_tk=";
    private final String TRACE_DETAIL_PARAM_PREFIX = "trace_detail=base64-";

    /* JADX INFO: Access modifiers changed from: private */
    public Call createPostCall(String str, String str2) {
        String str3 = "https://club.vip.qq.com/api/trpc/datong/DataReport?g_tk=" + getCSRFToken(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("old_index", "");
            jSONObject.put("trace_detail", getTraceDetail(str));
        } catch (JSONException e16) {
            QLog.e("VasDepTempImpl", 1, e16.toString());
        }
        return new OkHttpClient().newCall(new Request.Builder().url(str3).post(RequestBody.create(MediaType.parse("application/json"), jSONObject.toString())).addHeader(ISchemeApi.KEY_REFERER, "https://club.vip.qq.com").addHeader("Cookie", SwiftBrowserCookieMonster.r(str3)).build());
    }

    private String getCSRFToken(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("VasDepTempImpl", 1, "getCSRFToken pSKey is empty.");
            return "";
        }
        long j3 = 5381;
        for (int i3 = 0; i3 < str.length(); i3++) {
            j3 += ((j3 << 5) & TTL.MAX_VALUE) + str.charAt(i3);
        }
        return String.valueOf(j3 & TTL.MAX_VALUE);
    }

    private String getTraceDetail(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            QLog.e("VasDepTempImpl", 1, "getTraceDetail, url is empty.");
            return "";
        }
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        int length = split.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str3 = split[i3];
            if (str3.startsWith("trace_detail=base64-")) {
                str2 = str3.replace("trace_detail=base64-", "");
                break;
            }
            i3++;
        }
        return new String(PluginBaseInfoHelper.Base64Helper.decode(str2, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeDTReportIndex(Response response) {
        if (!response.isSuccessful()) {
            QLog.e("VasDepTempImpl", 1, "storeDTReportIndex, rsp is not successful.");
        }
        ResponseBody body = response.body();
        if (body == null) {
            QLog.e("VasDepTempImpl", 1, "storeDTReportIndex, rsp body is null.");
            return;
        }
        try {
            VipMMKV.getCommon().encodeString(VasModule.MMKV_KEY_DT_REPORT_INDEX, new JSONObject(body.string()).getString("data"));
        } catch (IOException | JSONException e16) {
            QLog.e("VasDepTempImpl", 1, "storeDTReportIndex error, " + e16);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void colorRingDownload(AppRuntime appRuntime, int i3, boolean z16, int i16, com.tencent.mobileqq.vip.k kVar) {
        com.tencent.mobileqq.vas.h hVar = (com.tencent.mobileqq.vas.h) appRuntime.getManager(QQManagerFactory.COLOR_RING_MANAGER);
        hVar.f309446e = kVar;
        hVar.g(i3, 3, z16, i16, "comering");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public String convert2SharpPFilePath(File file) {
        return com.tencent.qqsharpP.a.a(file);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void fetchHippyDTReportIndex(final String str, AppRuntime appRuntime) {
        MMKV.u().J(VasModule.MMKV_KEY_DT_REPORT_INDEX, "");
        final String pSkey = VasSkey.getPSkey(appRuntime, "vip.qq.com");
        if (TextUtils.isEmpty(pSkey)) {
            QLog.e("VasDepTempImpl", 1, "fetchHippyDTReportIndex, PSKey is empty.");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.VasDepTempImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        VasDepTempImpl.this.storeDTReportIndex(VasDepTempImpl.this.createPostCall(str, pSkey).execute());
                    } catch (Exception e16) {
                        QLog.e("VasDepTempImpl", 1, e16.toString());
                    }
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public Card findAndCreateCardByUin(String str) {
        return null;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public NTVasSimpleInfo findFriendEntityByUin(AppRuntime appRuntime, String str) {
        return ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "VasDepTempImpl");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public com.tencent.mobileqq.vip.h getDownloader(AppRuntime appRuntime) {
        AppRuntime appRuntime2;
        Manager manager;
        if (appRuntime instanceof ToolAppRuntime) {
            AppRuntime appRuntime3 = appRuntime.getAppRuntime("modular_web");
            if (appRuntime3 instanceof BrowserAppInterface) {
                manager = appRuntime3.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
            }
            manager = null;
        } else if (appRuntime instanceof QQAppInterface) {
            manager = appRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        } else {
            if ((appRuntime instanceof QzoneMainRuntime) && (appRuntime2 = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("qzone_plugin.apk")) != null) {
                manager = appRuntime2.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
            }
            manager = null;
        }
        if (manager == null || !(manager instanceof DownloaderFactory)) {
            return null;
        }
        return ((DownloaderFactory) manager).u(1);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public Intent getQQBrowserIntent() {
        return new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void guanjiaReport(String str, String str2, boolean z16, int i3, String str3) {
        VipInfoHandler vipInfoHandler = (VipInfoHandler) VasUtil.getAppInterface().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
        if (vipInfoHandler != null) {
            vipInfoHandler.guanjiaReport(str, str2, z16, i3, str3);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isBelongServiceAccountFolderInner(String str) {
        return ServiceAccountFolderManager.m(VasUtil.getApp(), str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isCanOpenGxhHippyPage() {
        return isContainsModule(HippyQQConstants.ModuleName.QQ_PERSONALITY);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isCanOpenHippyPage(String str) {
        return QVipHippyConfig.isContainsModule(str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isCanOpenQQVipHippyPage() {
        return isContainsModule(HippyQQConstants.ModuleName.QQ_VIP);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isContainsModule(String str) {
        return QVipHippyConfig.isContainsModule(str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isEnable() {
        return ((IPreDownloadController) VasUtil.getApp().getRuntimeService(IPreDownloadController.class, "")).isEnable();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isEnableGetAuth(String str, String str2) {
        return QVipHippyProcessor.a().isEnableGetAuth(str, str2);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isFunctionAvaliable(Context context) {
        return com.tencent.qqsharpP.a.b(context);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean isQQBrowserActivity(Activity activity) {
        return activity instanceof QQBrowserActivity;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void openGxhHippyPage(String str) {
        QVipHippyConfig.HippyInfo hippyInfoFromKey = QVipHippyProcessor.a().getHippyInfoFromKey(HippyQQConstants.ModuleName.QQ_PERSONALITY);
        if (hippyInfoFromKey != null) {
            OpenHippyInfo openHippyInfo = hippyInfoFromKey.openParams;
            if (openHippyInfo != null) {
                openHippyInfo.url = str;
            }
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(BaseApplication.getContext(), hippyInfoFromKey.openParams);
            return;
        }
        openHippyPageWithConfig(HippyQQConstants.ModuleName.QQ_PERSONALITY, str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void openHippyPageWithConfig(String str, String str2) {
        OpenHippyInfo mergeCommonParams = QVipHippyConfig.mergeCommonParams(str);
        if (mergeCommonParams != null && !TextUtils.isEmpty(str2)) {
            mergeCommonParams.url = str2;
        }
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(BaseApplication.getContext(), mergeCommonParams);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void openQQVipHippyPage(String str) {
        QVipHippyConfig.HippyInfo hippyInfoFromKey = QVipHippyProcessor.a().getHippyInfoFromKey(QVipHippyConfig.getVipBundleName());
        if (hippyInfoFromKey != null) {
            OpenHippyInfo openHippyInfo = hippyInfoFromKey.openParams;
            if (openHippyInfo != null) {
                openHippyInfo.url = str;
            }
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(BaseApplication.getContext(), hippyInfoFromKey.openParams);
            return;
        }
        openHippyPageWithConfig(HippyQQConstants.ModuleName.QQ_VIP, str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void registerSeqKey(IJce iJce, String str) {
        com.tencent.mobileqq.service.j.b(iJce, str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void reportKCLP(long j3, int i3) {
        new LpReportInfo_dc04233(j3, i3).report();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void requestPreDownload(File file, String str, int i3, String str2, int i16, int i17, RunnableTask runnableTask) {
        try {
            ((IPreDownloadController) VasUtil.getApp().getRuntimeService(IPreDownloadController.class, "")).requestPreDownload(i3, str2, "vas_special_remind", 0, str, file.getCanonicalPath(), i16, i17, false, runnableTask);
        } catch (IOException unused) {
            throw new RuntimeException("getCanonicalPath: Invalid file path");
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void sendGetBaseVipInfoReq(String str, String str2) {
        VipInfoHandler vipInfoHandler = (VipInfoHandler) VasUtil.getAppInterface().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
        if (vipInfoHandler != null) {
            vipInfoHandler.sendGetBaseVipInfoReq(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void sendSpecialCareEvent(List<String> list, int i3, List<String> list2, AppRuntime appRuntime) {
        QvipSpecialCareHandler qvipSpecialCareHandler;
        if ((appRuntime instanceof QQAppInterface) && (qvipSpecialCareHandler = (QvipSpecialCareHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.SPECIAL_CARE_HANDLER)) != null) {
            qvipSpecialCareHandler.M2(list, i3, list2);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean setContentBackground(View view, int i3) {
        if (!(view instanceof ChatXListView)) {
            return false;
        }
        ((ChatXListView) view).setContentBackground(i3);
        return true;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public int specialSoundDownload(com.tencent.mobileqq.vip.g gVar) {
        AppRuntime app = VasUtil.getApp();
        if (app == null) {
            app = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        return DownloaderFactory.o(gVar, app);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void startDownload(AppRuntime appRuntime, Bundle bundle, com.tencent.mobileqq.vip.g gVar, com.tencent.mobileqq.vip.f fVar) {
        ((DownloaderFactory) appRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1).startDownload(gVar, fVar, bundle);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void startPhotoListEditForResult(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, int i19) {
        PhotoUtils.startPhotoListEditForResult(intent, activity, str, i3, i16, i17, i18, str2, i19);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void unRegisterSeqKey(String str) {
        com.tencent.mobileqq.service.j.c(str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void updateDisPlayInteval(long j3) {
        ((ICommercialDrainageManagerService) VasUtil.getApp().getRuntimeService(ICommercialDrainageManagerService.class, "")).updateDisPlayInteval(j3);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public void vipFuncallReport(String str, boolean z16, int i3, long j3) {
        VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EXTERNAL_STORAGE, str, i3 + "_t", j3 + "", z16 + "", j3 + "", z16 + "_p", "", "", "");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public byte[] websoEncode(String str, long j3, HttpReq httpReq, String str2) {
        return new com.tencent.mobileqq.webview.webso.d(str, j3, httpReq, str2).encode();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public HttpResponse websoExecuteHttpPost(Context context, String str, HttpEntity httpEntity) throws IOException {
        return QZoneHttpUtil.executeHttpPost(context, str, httpEntity);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public String websoGetAPN() {
        return NetworkState.getAPN();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public String websoGetCookie4WebSoOrSonic(String str) {
        return SwiftBrowserCookieMonster.r(str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public String websoGetQUA() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public HttpRsp websoOnResponse(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return (HttpRsp) ProtocolUtils.decode(bArr, str);
        } catch (Throwable th5) {
            QLog.e("WebSoRequest", 1, "onResponse error:", th5);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDepTemp
    public boolean setContentBackground(View view, Drawable drawable) {
        if (!(view instanceof ChatXListView)) {
            return false;
        }
        ((ChatXListView) view).setContentBackground(drawable);
        return true;
    }
}
