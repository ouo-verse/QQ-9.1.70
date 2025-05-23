package com.tencent.gamecenter.wadl.api.impl;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.h;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameReportServiceImpl implements IQQGameReportService {
    private static final String ATTA_ID = "0ac00055074";
    public static final String ATTA_KEY_ERROR_MSG = "error_msg";
    public static final String ATTA_KEY_ERROR_TYPE = "error_type";
    public static final String ATTA_KEY_FPS = "fps";
    public static final String ATTA_KEY_STACK = "stack";
    public static final String ATTA_REPORT_URL = "https://h.trace.qq.com/kv";
    private static final String ATTA_TOKEN = "6377279485";
    public static final String DNFLUTTER_DYNAMIC_PAGE_NAME = "qflutter_qqgame_dnflutter";
    public static final int DOWNLOADER_TYPE_DEFAULT = 0;
    public static final int DOWNLOADER_TYPE_NEW_SDK = 2;
    public static final int DOWNLOADER_TYPE_NEW_SDK_DUAL = 4;
    public static final int DOWNLOADER_TYPE_NEW_SDK_SCHEDULE = 3;
    public static final int DOWNLOADER_TYPE_QUIC = 1;
    public static final int DOWNLOAD_FROM_APK_AUTO_UPDATE = 3;
    public static final int DOWNLOAD_FROM_APK_MANUAL = 1;
    public static final int DOWNLOAD_FROM_RES_NEW_APK = 5;
    public static final int DOWNLOAD_FROM_RES_OTHER = 4;
    public static final int DOWNLOAD_FROM_RES_UPDATE_APK = 2;
    public static final String FALSE_FLAG = "0";
    public static final int FLUTTER_DYNAMIC_TYPE_DNFLUTTER = 1;
    public static final int FLUTTER_DYNAMIC_TYPE_NONE = 0;
    public static final int INSTALL_FROM_DEFAULT = 0;
    public static final int INSTALL_FROM_NOTICE = 2;
    public static final int INSTALL_FROM_TIPS = 1;
    public static final String PLATFORM_TYPE_ANDROID = "1";
    private static final String TAG = "Wadl_QQGameReportServiceImpl";
    public static final String TRUE_FLAG = "1";
    public static final String USR_TYPE_CONTRAST = "1";
    public static final String USR_TYPE_DEFAULT = "0";
    public static final String USR_TYPE_EXP = "2";
    private static String mCarrier = "";

    private void reportToAttaFormMap(String str, String str2, Map<String, String> map) {
        StringBuilder attaReportBody = getAttaReportBody(str, str2);
        for (String str3 : map.keySet()) {
            if (map.get(str3) != null) {
                attaReportBody.append(ContainerUtils.FIELD_DELIMITER);
                attaReportBody.append(str3);
                attaReportBody.append(ContainerUtils.KEY_VALUE_DELIMITER);
                attaReportBody.append(URLEncoder.encode(map.get(str3)));
            }
        }
        GamePubAccountHelper.I("https://h.trace.qq.com/kv", attaReportBody.toString());
    }

    public void fillReportBuilder(WadlParams wadlParams, WadlReportBuilder wadlReportBuilder) {
        String str;
        if (wadlParams != null && wadlReportBuilder != null) {
            int downloadFrom = getDownloadFrom(wadlParams);
            int downloaderType = getDownloaderType(wadlParams);
            int installFrom = getInstallFrom(wadlParams);
            int a16 = com.tencent.mobileqq.vip.e.a();
            boolean flagEnable = wadlParams.getFlagEnable(32768);
            wadlReportBuilder.setGameAppId(wadlParams.appId);
            WadlReportBuilder ext = wadlReportBuilder.setExt(2, String.valueOf(wadlParams.from)).setExt(5, String.valueOf(downloadFrom)).setExt(10, String.valueOf(installFrom)).setExt(18, wadlParams.via).setExt(20, String.valueOf(a16));
            String str2 = "1";
            if (flagEnable) {
                str = "1";
            } else {
                str = "0";
            }
            WadlReportBuilder ext2 = ext.setExt(21, str).setExt(29, String.valueOf(wadlParams.speedBuffer)).setExt(30, wadlParams.appName).setExt(33, wadlParams.packageName).setExt(34, wadlParams.apkUrl).setExt(35, wadlParams.apkChannel).setExt(37, "0").setExt(38, String.valueOf(wadlParams.flags)).setExt(39, wadlParams.adtag).setExt(40, wadlParams.extraData);
            if (!wadlParams.getFlagEnable(512)) {
                str2 = "0";
            }
            ext2.setExt(41, str2).setExt(44, String.valueOf(downloaderType)).setExt(46, String.valueOf(wadlParams.channelNum)).setExt(47, wadlParams.fromWebUrl).setTianjiReportStr(wadlParams.wadlParamsExt.f106734e);
        }
    }

    protected StringBuilder getAttaReportBody(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("attaid=");
        sb5.append(URLEncoder.encode(ATTA_ID));
        sb5.append("&event_name=");
        sb5.append(URLEncoder.encode(str2));
        sb5.append("&uin=");
        sb5.append(URLEncoder.encode(GameCenterUtil.getUin()));
        sb5.append("&client_version=");
        sb5.append(URLEncoder.encode(AppSetting.f99551k));
        sb5.append("&dynamic_type=");
        sb5.append(str.startsWith(DNFLUTTER_DYNAMIC_PAGE_NAME) ? 1 : 0);
        sb5.append("&module=");
        sb5.append(URLEncoder.encode(IQQGameReportService.QQGAME_PAGE_NAME));
        sb5.append("&token=");
        sb5.append(URLEncoder.encode(ATTA_TOKEN));
        sb5.append("&page_name=");
        sb5.append(URLEncoder.encode(str));
        sb5.append("&phone_type=");
        sb5.append(URLEncoder.encode(DeviceInfoMonitor.getModel()));
        sb5.append("&system_type=");
        sb5.append(URLEncoder.encode(Build.VERSION.RELEASE));
        sb5.append("&platform_type=");
        sb5.append(URLEncoder.encode("1"));
        sb5.append("&_dc=");
        sb5.append(Math.random());
        return sb5;
    }

    protected int getDownloadFrom(WadlParams wadlParams) {
        if (wadlParams.isRes) {
            if (wadlParams.resType != 4) {
                return 4;
            }
            return 5;
        }
        if (wadlParams.from == 3) {
            return 3;
        }
        return 1;
    }

    protected int getDownloaderType(WadlParams wadlParams) {
        if (wadlParams.getFlagEnable(65536)) {
            return 4;
        }
        if (wadlParams.getFlagEnable(8192)) {
            return 3;
        }
        if (wadlParams.getFlagEnable(1024)) {
            return 2;
        }
        return 0;
    }

    protected int getInstallFrom(WadlParams wadlParams) {
        return wadlParams.isExtFlagEnable(1) ? 1 : 0;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void report(JSONObject jSONObject, int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (i3 == 0) {
                reportDC(peekAppRuntime, jSONObject.toString());
                return;
            } else {
                if (i3 == 1) {
                    ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).reportAtta(jSONObject);
                    return;
                }
                return;
            }
        }
        WadlQIPCConnector.getInstance().checkConnect();
        Bundle bundle = new Bundle();
        bundle.putString("reportData", jSONObject.toString());
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_REPORT, bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void report157(WadlReportBuilder wadlReportBuilder) {
        if (wadlReportBuilder == null) {
            return;
        }
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).reportAtta157(wadlReportBuilder.parseJson(wadlReportBuilder.target));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void reportDC(String str, String str2, h hVar, String str3) {
        if (hVar != null) {
            try {
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
                wadlReportBuilder.setDcId(str3).setOperId(str).setApkVolume(String.valueOf(hVar.f106824k)).setRetId(hVar.f106816c).setExt(4, str2).setExt(16, mCarrier).setExt(17, hVar.f106827n).setExt(22, hVar.f106818e).setExt(23, hVar.f106828o).setExt(24, hVar.f106829p).setExt(25, hVar.f106830q).setExt(28, hVar.f106820g).setExt(31, hVar.f106815b).setExt(32, hVar.f106819f).setExt(36, hVar.a()).setExt(42, hVar.f106822i).setExt(43, hVar.f106823j).setExt(45, hVar.f106821h).setExt(48, hVar.f106817d).setExt(49, String.valueOf(hVar.f106826m)).setExt(50, hVar.f106825l).setExt(51, hVar.f106831r).setExt(52, hVar.f106832s);
                fillReportBuilder(hVar.f106814a, wadlReportBuilder);
                reportDC(wadlReportBuilder);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void reportToAtta(String str, String str2, String str3) {
        try {
            StringBuilder attaReportBody = getAttaReportBody(str, str2);
            if (!TextUtils.isEmpty(str3)) {
                JSONObject jSONObject = new JSONObject(str3);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    String optString = jSONObject.optString(str4);
                    if (!TextUtils.isEmpty(optString)) {
                        attaReportBody.append(ContainerUtils.FIELD_DELIMITER);
                        attaReportBody.append(str4);
                        attaReportBody.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        attaReportBody.append(URLEncoder.encode(optString));
                    }
                }
                GamePubAccountHelper.I("https://h.trace.qq.com/kv", attaReportBody.toString());
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void reportToAtta78603(com.tencent.gamecenter.wadl.biz.entity.d dVar) {
        if (dVar == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        JSONObject a16 = dVar.a();
        if (peekAppRuntime != null) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).reportAttaV2(a16);
            return;
        }
        WadlQIPCConnector.getInstance().checkConnect();
        Bundle bundle = new Bundle();
        bundle.putString("reportData", a16.toString());
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_REPORT_V2, bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void reportToAttaForException(String str, String str2, String str3, String str4) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "reportToAttaForFps pageName=" + str + " errorType=" + str2 + " errorMsg=" + str3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ATTA_KEY_ERROR_TYPE, str2);
        hashMap.put("error_msg", str3);
        hashMap.put("stack", str4);
        reportToAttaFormMap(str, "exception", hashMap);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void reportToAttaForFps(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "reportToAttaForFps pageName=" + str + " fps=" + i3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fps", i3 + "");
        reportToAttaFormMap(str, "scrollPerfomance", hashMap);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void reportDC(WadlReportBuilder wadlReportBuilder) {
        if (wadlReportBuilder == null) {
            return;
        }
        report(wadlReportBuilder.parseJson(wadlReportBuilder.target), wadlReportBuilder.target);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameReportService
    public void reportDC(AppRuntime appRuntime, String str) {
        if (appRuntime == null) {
            QLog.w(TAG, 1, "reportDC fail,,appRuntime is null");
            return;
        }
        QLog.d(TAG, 1, "reportDC appRuntime=" + appRuntime);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(WadlReportBuilder.KEY_REPORT_LIST)) {
                int optInt = jSONObject.optInt("target", 0);
                jSONObject.remove("target");
                if (optInt == 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("req", jSONObject);
                    ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).reportToDcByTrpc(jSONObject2);
                } else if (optInt == 1) {
                    ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).reportAtta(jSONObject);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
