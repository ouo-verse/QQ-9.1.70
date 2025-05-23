package com.tencent.mobileqq.app;

import MAAccessClient.AccessRsp;
import MAAccessClient.CheckSinglePkgSigRsp;
import MAAccessClient.GetSinglePkgSigRsp;
import MAAccessClient.NoCheckMarket;
import MAAccessClient.Tips;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.download.b;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.dx;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.weather.api.IWeatherRuntimeService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.Pair;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.mobiletips.MobileTips$MobileTipsPkg;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$ReqBody;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.SubMsgType0x43$UpdateTips;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ConfigHandler extends BusinessHandler implements b.InterfaceC8883b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private HashSet<String> f194521d;

    /* renamed from: e, reason: collision with root package name */
    public QQAppInterface f194522e;

    public ConfigHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194521d = new HashSet<>();
            this.f194522e = qQAppInterface;
        }
    }

    private void E2(UpgradeDetailWrapper upgradeDetailWrapper) {
        if (upgradeDetailWrapper.f306174i.dialog.f306164p) {
            MyAppApi.z().a0(BaseActivity.sTopActivity, "biz_src_yyb");
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.ConfigHandler.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConfigHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    UpgradeDetailWrapper j3 = com.tencent.mobileqq.upgrade.k.i().j();
                    if (j3 != null && j3.f306173h != null) {
                        boolean c16 = dx.c();
                        int a16 = dx.a();
                        int i3 = j3.f306173h.f306179d;
                        if (c16 && i3 == a16) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            com.tencent.mobileqq.upgrade.k.i().w(true);
                            dx.f(i3);
                            dx.j(true);
                        }
                    }
                }
            }, 5000L);
        }
    }

    private void F2(Intent intent) {
        intent.putExtra("logout_intent", true);
        ThemeUiPlugin.destroy(this.f194522e);
        ChatBackgroundManager.d();
        this.f194522e.logout(true);
        ImageCacheHelper.f98636a.e();
        Context context = BaseActivity.sTopActivity;
        if (context == null) {
            context = BaseApplication.getContext();
            intent.addFlags(268435456);
        }
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_LOGIN);
    }

    private static String J2() {
        Date date = new Date();
        return date.getYear() + ":" + date.getMonth() + ":" + date.getDay();
    }

    public static String O2(Context context) {
        ComponentName componentName;
        ComponentName componentName2;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && !runningTasks.isEmpty()) {
            componentName = runningTasks.get(0).topActivity;
            if (componentName != null) {
                componentName2 = runningTasks.get(0).topActivity;
                return componentName2.getClassName();
            }
            return null;
        }
        return null;
    }

    public static int P2(QQAppInterface qQAppInterface) {
        int i3 = qQAppInterface.getPreferences().getInt("UPGRADE_TIPS_SHOW_COUNT", 0);
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsShowCount:" + i3);
        }
        return i3;
    }

    public static String Q2(QQAppInterface qQAppInterface, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + i3);
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        String string = preferences.getString("UPGRADE_TIPS_URL", null);
        if (string == null) {
            return null;
        }
        String string2 = preferences.getString("UPGRADE_TIPS_URL_MARK", null);
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + string2);
        }
        if (!TextUtils.isEmpty(string2)) {
            String[] split = string2.split(":");
            long parseLong = Long.parseLong(split[0]);
            long parseLong2 = Long.parseLong(split[1]);
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + currentTimeMillis);
            }
            if (parseLong2 < parseLong || currentTimeMillis <= parseLong) {
                return null;
            }
            if (currentTimeMillis <= parseLong2 && i3 > 0) {
                return null;
            }
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void S2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        CheckSinglePkgSigRsp checkSinglePkgSigRsp;
        ArrayList<NoCheckMarket> arrayList;
        String str;
        String str2;
        String str3;
        Tips tips;
        String str4;
        String str5;
        boolean z17 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str6 = null;
        if (z16) {
            AccessRsp accessRsp = (AccessRsp) obj;
            if (accessRsp.ret == 0) {
                byte[] bArr = accessRsp.body;
                if (bArr != null && bArr.length > 0) {
                    try {
                        JceInputStream jceInputStream = new JceInputStream(bArr);
                        checkSinglePkgSigRsp = new CheckSinglePkgSigRsp();
                        try {
                            checkSinglePkgSigRsp.readFrom(jceInputStream);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                    }
                    if (checkSinglePkgSigRsp != null && checkSinglePkgSigRsp.ret == 0) {
                        arrayList = checkSinglePkgSigRsp.vtMarket;
                        if (arrayList != null) {
                            Iterator<NoCheckMarket> it = arrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                NoCheckMarket next = it.next();
                                if (!TextUtils.isEmpty(next.pkgName)) {
                                    if (!z17) {
                                        z17 = com.tencent.securitysdk.utils.d.b(BaseApplicationImpl.sApplication, next.pkgName, next.versionCode, next.signatureMd5);
                                    }
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("UpgradeController", 4, "handleCheckAuthCode NoCheckMarket:" + next.pkgName + ", " + next.versionCode);
                                    }
                                    if (z17) {
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d("UpgradeController", 4, "handleCheckAuthCode NoCheckMarket:" + z17);
                                        }
                                    }
                                }
                            }
                        }
                        str = checkSinglePkgSigRsp.pkgSig;
                        str2 = checkSinglePkgSigRsp.tmastUrl;
                        String str7 = checkSinglePkgSigRsp.pageUrl;
                        int i3 = checkSinglePkgSigRsp.sigVersionCode;
                        str3 = str7 + "#versioncode=" + i3;
                        if (QLog.isDevelopLevel()) {
                            QLog.d("UpgradeController", 4, "handleCheckAuthCode TargetCode:" + str + ", " + i3);
                        }
                        tips = accessRsp.tips;
                        if (tips == null) {
                            str6 = tips.title;
                            str5 = tips.content;
                            str4 = tips.button;
                        } else {
                            str4 = null;
                            str5 = null;
                        }
                        if (!z16) {
                            z17 = true;
                        } else if (z17) {
                            com.tencent.securitysdk.utils.d.c(BaseApplicationImpl.sApplication);
                        }
                        QLog.d("UpgradeController", 1, "handleCheckAuthCode:" + z16 + ", valid:" + z17);
                        if (!z17) {
                            BaseApplicationImpl.sApplication.getResources();
                            Intent intent = new Intent();
                            intent.putExtra("reason_for_checkAuth", true);
                            intent.putExtra("StrTitle", str6);
                            intent.putExtra("StrUpgradeDesc", str5);
                            intent.putExtra("StrButton", str4);
                            intent.putExtra("StrClientUrl", str2);
                            intent.putExtra("StrH5Url", str3);
                            intent.putExtra("StrCode", str);
                            F2(intent);
                        }
                        notifyUI(11, z16, Boolean.valueOf(z17));
                    }
                }
                checkSinglePkgSigRsp = null;
                if (checkSinglePkgSigRsp != null) {
                    arrayList = checkSinglePkgSigRsp.vtMarket;
                    if (arrayList != null) {
                    }
                    str = checkSinglePkgSigRsp.pkgSig;
                    str2 = checkSinglePkgSigRsp.tmastUrl;
                    String str72 = checkSinglePkgSigRsp.pageUrl;
                    int i36 = checkSinglePkgSigRsp.sigVersionCode;
                    str3 = str72 + "#versioncode=" + i36;
                    if (QLog.isDevelopLevel()) {
                    }
                    tips = accessRsp.tips;
                    if (tips == null) {
                    }
                    if (!z16) {
                    }
                    QLog.d("UpgradeController", 1, "handleCheckAuthCode:" + z16 + ", valid:" + z17);
                    if (!z17) {
                    }
                    notifyUI(11, z16, Boolean.valueOf(z17));
                }
            }
            z17 = true;
        }
        str4 = null;
        str5 = null;
        str = null;
        str2 = null;
        str3 = null;
        if (!z16) {
        }
        QLog.d("UpgradeController", 1, "handleCheckAuthCode:" + z16 + ", valid:" + z17);
        if (!z17) {
        }
        notifyUI(11, z16, Boolean.valueOf(z17));
    }

    private void T2(EntityManager entityManager, GetResourceRespInfo getResourceRespInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "get share appid resp info");
        }
        if (getResourceRespInfo.iResult != 0) {
            notifyUI(5, false, null);
            return;
        }
        AppShareID b16 = com.tencent.mobileqq.utils.h.b(getResourceRespInfo);
        if (b16 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "parser share appid from resp info, result:  " + b16);
        }
        AppShareID appShareID = (AppShareID) DBMethodProxy.find(entityManager, AppShareID.class, "strPkgName=?", new String[]{getResourceRespInfo.strPkgName});
        if (appShareID == null) {
            entityManager.persist(b16);
            if (QLog.isColorLevel()) {
                QLog.d("share_appid", 2, "Persist DB appid = " + b16.strPkgName);
            }
        } else if (b16.uiNewVer != appShareID.uiNewVer) {
            entityManager.remove(appShareID);
            entityManager.persist(b16);
            if (QLog.isColorLevel()) {
                QLog.d("share_appid", 2, "Update DB appid = " + b16.strPkgName);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Not need update DB appid = " + b16.strPkgName);
        }
        this.f194522e.getMsgHandler().f194809f.e(b16.strPkgName, b16);
        G2(b16.strResURLBig, this.f194522e.getApplication().getFileStreamPath(b16.strPkgName));
        notifyUI(5, true, b16);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void U2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String string = toServiceMsg.extraData.getString("rid");
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = "";
        if (z16) {
            AccessRsp accessRsp = (AccessRsp) obj;
            int i3 = accessRsp.ret;
            if (i3 == 1) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("UpgradeController", 4, "handleGetAuthCode not supported");
                }
            } else if (i3 == 0) {
                byte[] bArr = accessRsp.body;
                GetSinglePkgSigRsp getSinglePkgSigRsp = null;
                if (bArr != null && bArr.length > 0) {
                    try {
                        JceInputStream jceInputStream = new JceInputStream(bArr);
                        GetSinglePkgSigRsp getSinglePkgSigRsp2 = new GetSinglePkgSigRsp();
                        try {
                            getSinglePkgSigRsp2.readFrom(jceInputStream);
                        } catch (Exception unused) {
                        }
                        getSinglePkgSigRsp = getSinglePkgSigRsp2;
                    } catch (Exception unused2) {
                    }
                }
                if (getSinglePkgSigRsp != null && getSinglePkgSigRsp.ret == 0) {
                    str = getSinglePkgSigRsp.pkgSig;
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("UpgradeController", 4, "handleGetAuthCode:" + z17 + ", " + string + ", code:" + str);
            }
            notifyUI(10, z17, new Pair(str, string));
            com.tencent.mobileqq.upgrade.k.h().e(z17, string, str);
        }
        z17 = false;
        if (QLog.isDevelopLevel()) {
        }
        notifyUI(10, z17, new Pair(str, string));
        com.tencent.mobileqq.upgrade.k.h().e(z17, string, str);
    }

    private void V2(GetResourceRespInfo getResourceRespInfo) {
        if (getResourceRespInfo.iResult != 0) {
            notifyUI(1, false, getResourceRespInfo);
            return;
        }
        String str = getResourceRespInfo.strResURL_big;
        if (str != null && str.length() > 0) {
            this.f194522e.execute(new Runnable(str, getResourceRespInfo) { // from class: com.tencent.mobileqq.app.ConfigHandler.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f194530d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ GetResourceRespInfo f194531e;

                {
                    this.f194530d = str;
                    this.f194531e = getResourceRespInfo;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ConfigHandler.this, str, getResourceRespInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (HttpDownloadUtil.download(ConfigHandler.this.f194522e, new URL(this.f194530d), new File(AppConstants.PATH_SYSTEM_BACKGROUND_CONFIG))) {
                            ConfigHandler.this.notifyUI(1, true, this.f194531e);
                        } else {
                            ConfigHandler.this.notifyUI(1, false, this.f194531e);
                        }
                    } catch (MalformedURLException unused) {
                        ConfigHandler.this.notifyUI(1, false, this.f194531e);
                    }
                }
            });
        }
    }

    private void W2(GetResourceRespInfo getResourceRespInfo) {
        String str;
        com.tencent.mobileqq.filemanager.data.e.f207749h = true;
        int i3 = getResourceRespInfo.iResult;
        if ((i3 == -2 || i3 == 0) && (str = getResourceRespInfo.strResURL_big) != null && str.length() > 0) {
            ThreadManagerV2.excute(new Runnable(str, getResourceRespInfo) { // from class: com.tencent.mobileqq.app.ConfigHandler.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f194528d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ GetResourceRespInfo f194529e;

                {
                    this.f194528d = str;
                    this.f194529e = getResourceRespInfo;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ConfigHandler.this, str, getResourceRespInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ((IFMConfig) QRoute.api(IFMConfig.class)).updatePreviewList(ConfigHandler.this.f194522e, MsfSdkUtils.insertMtype("ConfigCheck", this.f194528d), this.f194529e.uiNewVer);
                    }
                }
            }, 64, null, true);
        }
    }

    private void X2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        StringBuilder sb5;
        boolean z17 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig success=" + z16);
        }
        if (z16) {
            try {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + z16);
                    }
                    if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        ByteBuffer wrap = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        short s16 = wrap.getShort();
                        int i3 = wrap.getShort();
                        if (s16 == 16) {
                            byte[] bArr = new byte[i3];
                            wrap.get(bArr);
                            if ((bArr[16] & 1) > 0) {
                                z17 = true;
                            }
                            SettingCloneUtil.writeValue(this.f194522e.getApplication(), toServiceMsg.getUin(), (String) null, AppConstants.PCACTIVE_CONFIG, z17);
                            this.f194522e.openMsfPCActive(toServiceMsg.getUin(), DownloadInfo.spKey_Config, z17);
                            QLog.d("ConfigHandler", 1, "PCActive opened: " + z17 + " by config");
                            Intent intent = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
                            intent.putExtra("configPCActive", z17);
                            intent.putExtra("uin", toServiceMsg.getUin());
                            this.f194522e.getApp().sendBroadcast(intent);
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    } else {
                        return;
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + z16 + ";allow=" + z17);
                }
                throw th5;
            }
        }
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder();
            sb5.append("handleGetPCActiveConfig result=");
            sb5.append(z16);
            sb5.append(";allow=");
            sb5.append(z17);
            QLog.d("ConfigHandler", 2, sb5.toString());
        }
    }

    private void Y2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        cmd0x9ae$AuthTips cmd0x9ae_authtips;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (fromServiceMsg != null && obj != null) {
            int intValue = ((Integer) toServiceMsg.getAttribute("serviceType", 2)).intValue();
            cmd0x9ae$RspBody cmd0x9ae_rspbody = new cmd0x9ae$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x9ae_rspbody);
            String str6 = "";
            if (parseOIDBPkg == 0) {
                if (cmd0x9ae_rspbody.bool_has_been_authenticated.has()) {
                    z16 = cmd0x9ae_rspbody.bool_has_been_authenticated.get();
                } else {
                    z16 = true;
                }
                if (cmd0x9ae_rspbody.bool_need_auth_tips.has()) {
                    z17 = cmd0x9ae_rspbody.bool_need_auth_tips.get();
                } else {
                    z17 = false;
                }
                if (cmd0x9ae_rspbody.msg_auth_tips.has()) {
                    cmd0x9ae_authtips = cmd0x9ae_rspbody.msg_auth_tips.get();
                } else {
                    cmd0x9ae_authtips = null;
                }
                this.f194522e.getPreferences().edit().putBoolean("has_auth_real_name", z16).commit();
                if (intValue == 2) {
                    if (cmd0x9ae_authtips != null) {
                        if (!cmd0x9ae_authtips.string_tips_title.has()) {
                            str4 = "";
                        } else {
                            str4 = cmd0x9ae_authtips.string_tips_title.get();
                        }
                        if (!cmd0x9ae_authtips.string_tips_context.has()) {
                            str5 = "";
                        } else {
                            str5 = cmd0x9ae_authtips.string_tips_context.get();
                        }
                        if (cmd0x9ae_authtips.string_tips_action_url.has()) {
                            str6 = cmd0x9ae_authtips.string_tips_action_url.get();
                        }
                        notifyUI(13, true, new Object[]{Boolean.valueOf(z16), Boolean.valueOf(z17), str4, str5, str6});
                        if (QLog.isColorLevel()) {
                            QLog.i("RealName", 2, "handleGetRealNameStatus value is: " + z16 + "|" + z17 + "|" + str4 + "|" + str5 + "|" + str6);
                            return;
                        }
                        return;
                    }
                    QLog.i("RealName", 2, "handleGetRealNameStatus, authTips is null " + z16 + " " + z17);
                } else if (intValue == 10) {
                    if (cmd0x9ae_authtips == null) {
                        str = "";
                        str2 = str;
                    } else {
                        if (!cmd0x9ae_authtips.string_tips_title.has()) {
                            str3 = "";
                        } else {
                            str3 = cmd0x9ae_authtips.string_tips_title.get();
                        }
                        if (!cmd0x9ae_authtips.string_tips_context.has()) {
                            str2 = "";
                        } else {
                            str2 = cmd0x9ae_authtips.string_tips_context.get();
                        }
                        if (cmd0x9ae_authtips.string_tips_action_url.has()) {
                            str6 = cmd0x9ae_authtips.string_tips_action_url.get();
                        }
                        str = str6;
                        str6 = str3;
                    }
                    com.tencent.mobileqq.qqexpand.manager.d dVar = (com.tencent.mobileqq.qqexpand.manager.d) this.f194522e.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
                    dVar.f(z16);
                    dVar.c(z17, str6, str2, str);
                    this.f194522e.getPreferences().edit().putBoolean("has_auth_real_name_extendfriend", z16).putBoolean("has_request_auth_real_name_extendfriend", true).commit();
                    notifyUI(14, true, new Object[]{Boolean.valueOf(z16), Boolean.valueOf(z17), str6, str2, str});
                    if (QLog.isColorLevel()) {
                        QLog.i("RealName", 2, "handleGetRealNameStatus value is: " + z16 + "|" + z17 + "|" + str6 + "|" + str2 + "|" + str);
                    }
                } else if (intValue == 12) {
                    if (QLog.isColorLevel()) {
                        QLog.i("RealName", 2, "handleGetRealNameStatus type=12, value is: " + z16);
                    }
                    this.f194522e.getPreferences().edit().putBoolean("has_auth_real_name_av", z16).putBoolean("has_request_auth_real_name_av", true).commit();
                    notifyUI(15, true, new Object[]{Boolean.valueOf(z16)});
                }
            } else if (intValue == 10) {
                Boolean bool = Boolean.FALSE;
                notifyUI(14, false, new Object[]{bool, bool, "", "", ""});
            } else if (intValue == 12) {
                notifyUI(15, false, new Object[]{Boolean.FALSE});
            }
            if (QLog.isColorLevel()) {
                QLog.i("RealName", 2, "handleGetRealNameStatus, result is: " + parseOIDBPkg + " serviceType:" + intValue);
            }
        }
    }

    private void Z2(GetResourceRespInfo getResourceRespInfo) {
        if (getResourceRespInfo == null) {
            return;
        }
        long g16 = com.tencent.mobileqq.utils.bf.h().g();
        long j3 = getResourceRespInfo.uiNewVer;
        if (QLog.isColorLevel()) {
            QLog.d("JumpWhiteList", 2, "handleJumpWhiteList currentVersion: " + g16 + ", serverVersion: " + j3 + ",iResult: " + getResourceRespInfo.iResult + ", bigUrl: " + getResourceRespInfo.strResURL_big);
        }
        if (j3 != g16) {
            String str = getResourceRespInfo.strResURL_big;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f194522e.execute(new Runnable(str, j3) { // from class: com.tencent.mobileqq.app.ConfigHandler.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f194523d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f194524e;

                {
                    this.f194523d = str;
                    this.f194524e = j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ConfigHandler.this, str, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    new File(ConfigHandler.this.f194522e.getApplication().getFilesDir(), "qq_safe_jump_whitelist.zip");
                    MsfSdkUtils.insertMtype("ConfigCheck", this.f194523d);
                    if (QLog.isColorLevel()) {
                        QLog.d("JumpWhiteList", 2, "handleJumpWhiteList download: 13");
                    }
                    com.tencent.mobileqq.utils.bf.h().c(ConfigHandler.this.f194522e.getApplication());
                }
            });
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.ConfigHandler.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConfigHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.utils.bf.h().c(ConfigHandler.this.f194522e.getApplication());
                }
            }
        });
    }

    private void c3(GetResourceRespInfo getResourceRespInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "ConfigHandler.handleUpdateStatusActions, result is " + getResourceRespInfo.iResult + ", server version:" + getResourceRespInfo.uiNewVer);
        }
        int i3 = getResourceRespInfo.iResult;
        if (i3 == -2) {
            notifyUI(7, true, 100);
            return;
        }
        if (i3 != 0) {
            notifyUI(7, false, -1);
            return;
        }
        StatusManager statusManager = (StatusManager) this.f194522e.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager == null) {
            return;
        }
        if (!statusManager.U(getResourceRespInfo.uiNewVer)) {
            notifyUI(7, true, 100);
            return;
        }
        String str = getResourceRespInfo.strResURL_big;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.richstatus.xml", 2, "url is empty");
            }
            notifyUI(7, false, -1);
            return;
        }
        this.f194522e.execute(new Runnable(str, statusManager, getResourceRespInfo) { // from class: com.tencent.mobileqq.app.ConfigHandler.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f194532d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ StatusManager f194533e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ GetResourceRespInfo f194534f;

            {
                this.f194532d = str;
                this.f194533e = statusManager;
                this.f194534f = getResourceRespInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ConfigHandler.this, str, statusManager, getResourceRespInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                File file = new File(ConfigHandler.this.f194522e.getApplication().getFilesDir(), "rich_status.tmp");
                int downloadData = HttpDownloadUtil.downloadData(ConfigHandler.this.f194522e, MsfSdkUtils.insertMtype("ConfigCheck", this.f194532d), file);
                if (QLog.isColorLevel()) {
                    QLog.w("Q.richstatus.xml", 2, "handleUpdateStatusActions download " + this.f194532d + " result " + downloadData);
                }
                if (downloadData == 0) {
                    if (this.f194533e.e0(file, this.f194534f.uiNewVer)) {
                        ConfigHandler.this.notifyUI(7, true, 102);
                    } else {
                        ConfigHandler.this.notifyUI(7, false, -3);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.richstatus.xml", 2, "httpdownload failed: " + this.f194532d + ", result " + downloadData);
                    }
                    if (downloadData != 4 && downloadData != 12) {
                        ConfigHandler.this.notifyUI(7, false, -1);
                    } else {
                        ConfigHandler.this.notifyUI(7, false, -3);
                    }
                }
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("result", String.valueOf(downloadData));
                hashMap.put("version", String.valueOf(this.f194534f.uiNewVer));
                hashMap.put("url", this.f194532d);
                String currentAccountUin = ConfigHandler.this.f194522e.getCurrentAccountUin();
                if (downloadData == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                statisticCollector.collectPerformance(currentAccountUin, "RichStatusAction", z16, 0L, 0L, hashMap, "");
            }
        });
    }

    private void d3(GetResourceRespInfo getResourceRespInfo) {
        if (getResourceRespInfo == null) {
            return;
        }
        IWeatherRuntimeService iWeatherRuntimeService = (IWeatherRuntimeService) this.f194522e.getRuntimeService(IWeatherRuntimeService.class);
        long j3 = getResourceRespInfo.uiNewVer;
        long configVersion = iWeatherRuntimeService.getConfigVersion();
        if (QLog.isColorLevel()) {
            QLog.d("qq_weather", 2, "handleWeatherResources currentVersion: " + configVersion + ", serverVersion: " + j3 + ",iResult: " + getResourceRespInfo.iResult + ", bigUrl: " + getResourceRespInfo.strResURL_big);
        }
        if (j3 != configVersion) {
            String str = getResourceRespInfo.strResURL_big;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f194522e.execute(new Runnable(str, iWeatherRuntimeService, j3) { // from class: com.tencent.mobileqq.app.ConfigHandler.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f194525d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ IWeatherRuntimeService f194526e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f194527f;

                {
                    this.f194525d = str;
                    this.f194526e = iWeatherRuntimeService;
                    this.f194527f = j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ConfigHandler.this, str, iWeatherRuntimeService, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    File file = new File(ConfigHandler.this.f194522e.getApplication().getFilesDir(), "WeatherResource.zip");
                    int downloadData = HttpDownloadUtil.downloadData(ConfigHandler.this.f194522e, MsfSdkUtils.insertMtype("ConfigCheck", this.f194525d), file);
                    if (QLog.isColorLevel()) {
                        QLog.d("qq_weather", 2, "handleWeatherResources download: " + downloadData + ",downloadpath" + file.getAbsolutePath());
                    }
                    if (downloadData == 0) {
                        z16 = this.f194526e.unzipResource(this.f194527f, file.getAbsolutePath());
                    } else {
                        z16 = false;
                    }
                    ConfigHandler.this.notifyUI(9, z16, null);
                }
            });
        }
    }

    public static boolean e3(QQAppInterface qQAppInterface) {
        return qQAppInterface.getPreferences().getBoolean(AppConstants.Preferences.UPGRADE_DOWNLOAD_WAY, false);
    }

    public static boolean f3(QQAppInterface qQAppInterface) {
        boolean z16;
        String string = qQAppInterface.getPreferences().getString("UPGRADE_TIPS_DAILY_STR", null);
        if (string != null && J2().equals(string)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "ConfigHandler.isDailyShowTips:" + z16 + "--> " + string);
        }
        return z16;
    }

    public static boolean g3(QQAppInterface qQAppInterface, boolean z16) {
        return qQAppInterface.getPreferences().getBoolean(AppConstants.Preferences.UPGRADE_AUTO_DOWNLOAD_IN_WIFI, z16);
    }

    public static void h3(QQAppInterface qQAppInterface) {
        SharedPreferences.Editor edit = qQAppInterface.getPreferences().edit();
        edit.putString("UPGRADE_TIPS_DAILY_STR", J2());
        edit.commit();
    }

    public static void i3(QQAppInterface qQAppInterface, boolean z16) {
        qQAppInterface.getPreferences().edit().putBoolean(AppConstants.Preferences.UPGRADE_DOWNLOAD_WAY, z16).apply();
        if (QLog.isColorLevel()) {
            QLog.d("preLoad_configServlet", 2, "is auto download : " + z16);
        }
    }

    public static void j3(QQAppInterface qQAppInterface, String str, int i3) {
        SharedPreferences preferences = qQAppInterface.getPreferences();
        String string = preferences.getString("UPGRADE_TIPS_URL", null);
        if (string != null && i3 >= 0) {
            if (string.equals(str)) {
                return;
            } else {
                k3(qQAppInterface, 0);
            }
        }
        if (TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = preferences.edit();
            edit.remove("UPGRADE_TIPS_URL_MARK");
            edit.putString("UPGRADE_TIPS_URL", str);
            edit.commit();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = currentTimeMillis + ":" + ((i3 * 24 * 60 * 60 * 1000) + currentTimeMillis);
        SharedPreferences.Editor edit2 = preferences.edit();
        edit2.putString("UPGRADE_TIPS_URL_MARK", str2);
        edit2.putString("UPGRADE_TIPS_URL", str);
        edit2.commit();
    }

    public static void k3(QQAppInterface qQAppInterface, int i3) {
        qQAppInterface.getPreferences().edit().putInt("UPGRADE_TIPS_SHOW_COUNT", i3).apply();
    }

    private void l3(boolean z16, UpgradeDetailWrapper upgradeDetailWrapper) {
        notifyUI(4, z16, upgradeDetailWrapper);
    }

    public static void p3(QQAppInterface qQAppInterface, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage");
        }
        SubMsgType0x43$UpdateTips subMsgType0x43$UpdateTips = new SubMsgType0x43$UpdateTips();
        try {
            String obj = subMsgType0x43$UpdateTips.bytes_desc.get().toString();
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage: " + obj);
            }
            subMsgType0x43$UpdateTips.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException unused) {
        }
    }

    public static void w3(QQAppInterface qQAppInterface, boolean z16) {
        QLog.d("UpgradeController", 1, String.format("setUpgradeAutoDownloadInWifi isAuto=%s", Boolean.valueOf(z16)));
        qQAppInterface.getPreferences().edit().putBoolean(AppConstants.Preferences.UPGRADE_AUTO_DOWNLOAD_IN_WIFI, z16).apply();
    }

    private void x3(UpgradeDetailWrapper upgradeDetailWrapper) {
        String str;
        if (upgradeDetailWrapper != null && upgradeDetailWrapper.f306170d != null) {
            boolean j3 = com.tencent.mobileqq.upgrade.n.j();
            QQAppInterface qQAppInterface = this.f194522e;
            if (j3) {
                str = "1";
            } else {
                str = "0";
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004DA5", "0X8004DA5", 0, 0, str, "", com.tencent.mobileqq.upgrade.k.g(), "");
            l3(true, upgradeDetailWrapper);
            UpgradeInfo upgradeInfo = upgradeDetailWrapper.f306170d;
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController_ConfigHandler", 2, String.format("showUpgradeIfNecessary iActionType=%s iUpgradeType=%s", Integer.valueOf(upgradeInfo.iActionType), Integer.valueOf(upgradeInfo.iUpgradeType)));
            }
            if (upgradeInfo.iActionType == 0) {
                if (upgradeInfo.iUpgradeType != 1) {
                    t3();
                }
                int i3 = upgradeInfo.iUpgradeType;
                if (i3 == 2) {
                    String O2 = O2(this.f194522e.getApp());
                    if (O2 != null && !O2.equals("com.tencent.mobileqq.activity.UserguideActivity")) {
                        Intent intent = new Intent();
                        intent.putExtra("reason_for_upgrade", true);
                        intent.putExtra("StrNewTitle", upgradeInfo.strNewTitle);
                        intent.putExtra("StrUpgradeDesc", upgradeInfo.strUpgradeDesc);
                        intent.putExtra("StrUrl", upgradeInfo.strNewSoftwareURL);
                        intent.putExtra(upgradeDetailWrapper.getClass().getSimpleName(), upgradeDetailWrapper);
                        F2(intent);
                        return;
                    }
                    return;
                }
                if (i3 == 1) {
                    if (com.tencent.mobileqq.upgrade.k.i().k() == 4) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UpgradeConfigManager", 2, "showUpgradeIfNecessary apk has been download");
                        }
                        com.tencent.mobileqq.upgrade.k.i().x(true);
                        return;
                    }
                    boolean g36 = g3(this.f194522e, false);
                    boolean isWifiConn = AppNetConnInfo.isWifiConn();
                    if (QLog.isColorLevel()) {
                        QLog.d("UpgradeConfigManager", 2, String.format("showUpgradeIfNecessary apk has not been download. autoDownloadInWifi=%s isWifiConn=%s", Boolean.valueOf(g36), Boolean.valueOf(isWifiConn)));
                    }
                    com.tencent.mobileqq.upgrade.k i16 = com.tencent.mobileqq.upgrade.k.i();
                    if (g36) {
                        if (isWifiConn) {
                            i16.y();
                            return;
                        } else {
                            i16.x(true);
                            return;
                        }
                    }
                    int i17 = upgradeInfo.iTipsType;
                    if (i17 != 0 && i17 != 2) {
                        MqqHandler handler = this.f194522e.getHandler(Conversation.class);
                        if (handler != null) {
                            handler.obtainMessage(Conversation.MSG_NEW_UPGRADE_DIALOG, upgradeDetailWrapper).sendToTarget();
                            return;
                        }
                        return;
                    }
                    i16.x(true);
                    return;
                }
                if (i3 == 3) {
                    E2(upgradeDetailWrapper);
                }
            }
        }
    }

    public boolean D2() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        boolean a16 = com.tencent.securitysdk.utils.d.a(BaseApplicationImpl.sApplication);
        if (QLog.isDevelopLevel()) {
            QLog.d("UpgradeController", 4, "checkAuthIfNeccessary preCheck:" + a16);
        }
        if (a16) {
            return false;
        }
        try {
            str = com.tencent.securitysdk.utils.a.f(new File(BaseApplicationImpl.sApplication.getPackageResourcePath()));
        } catch (Exception unused) {
            str = null;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UpgradeController", 4, "checkAuthIfNeccessary forCode:" + str);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("MAAControl.CheckSinglePkgSig");
        createToServiceMsg.extraData.putString(com.tencent.mobileqq.search.model.ac.f283467k0, str);
        createToServiceMsg.extraData.putInt(QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE, com.tencent.mobileqq.cooperation.a.a(this.f194522e.getApp()));
        createToServiceMsg.extraData.putInt(GdtADFlyingStreamingReportHelper.PARAM_KEY_SV, com.tencent.mobileqq.utils.ah.K());
        send(createToServiceMsg);
        return true;
    }

    public void G2(String str, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) file);
        } else {
            this.f194522e.execute(new Runnable(str, file) { // from class: com.tencent.mobileqq.app.ConfigHandler.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f194535d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ File f194536e;

                {
                    this.f194535d = str;
                    this.f194536e = file;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ConfigHandler.this, str, file);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        try {
                            HttpDownloadUtil.download(ConfigHandler.this.f194522e, new URL(this.f194535d), this.f194536e);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public GetResourceReqInfo H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (GetResourceReqInfo) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        ConditionSearchManager conditionSearchManager = (ConditionSearchManager) this.f194522e.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        if (conditionSearchManager == null) {
            return null;
        }
        GetResourceReqInfo getResourceReqInfo = new GetResourceReqInfo();
        getResourceReqInfo.uiResID = 0L;
        getResourceReqInfo.strPkgName = "QQAddFriend.AdministrateRegion";
        getResourceReqInfo.uiCurVer = conditionSearchManager.v(true);
        getResourceReqInfo.sResType = (short) 2;
        getResourceReqInfo.sLanType = (short) 0;
        getResourceReqInfo.sReqType = (short) 1;
        return getResourceReqInfo;
    }

    public boolean I2(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), str2)).booleanValue();
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("MAAControl.GetSinglePkgSig");
        createToServiceMsg.extraData.putString("pn", str);
        createToServiceMsg.extraData.putInt("vc", i3);
        createToServiceMsg.extraData.putString("rid", str2);
        createToServiceMsg.extraData.putInt(QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE, com.tencent.mobileqq.cooperation.a.a(this.f194522e.getApp()));
        createToServiceMsg.extraData.putInt(GdtADFlyingStreamingReportHelper.PARAM_KEY_SV, com.tencent.mobileqq.utils.ah.K());
        send(createToServiceMsg);
        if (QLog.isDevelopLevel()) {
            QLog.d("UpgradeController", 4, "getAuthCode:" + str2 + ", forPkg:" + str);
        }
        return true;
    }

    public GetResourceReqInfo K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (GetResourceReqInfo) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        SharedPreferences sharedPreferences = this.f194522e.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
        long K0 = com.tencent.mobileqq.service.message.e.K0() - sharedPreferences.getLong("SettingQlinkResistTerroristLastTime", 0L);
        if (QLog.isColorLevel()) {
            QLog.i(((IFMConfig) QRoute.api(IFMConfig.class)).getTAG(), 2, "verifyResistTerrorist,qlinkdur[" + K0 + "]");
        }
        if (!sharedPreferences.getString("SettingQlinkResistTerroristLastAccount", "0").equalsIgnoreCase(this.f194522e.getCurrentAccountUin())) {
            if (QLog.isColorLevel()) {
                QLog.i(((IFMConfig) QRoute.api(IFMConfig.class)).getTAG(), 2, "verifyResistTerrorist,change account!");
            }
            this.f194522e.getFileTransferHandler().B1();
        } else if (K0 > 86400) {
            if (QLog.isColorLevel()) {
                QLog.i(((IFMConfig) QRoute.api(IFMConfig.class)).getTAG(), 2, "verifyResistTerrorist,durtime over one day!");
            }
            this.f194522e.getFileTransferHandler().B1();
        }
        SharedPreferences sharedPreferences2 = this.f194522e.getApplication().getSharedPreferences("OfflineFileConfigV2", 0);
        long j3 = sharedPreferences2.getLong("FMConfigUpdateLastTime", 0L);
        long K02 = com.tencent.mobileqq.service.message.e.K0();
        if (QLog.isDevelopLevel()) {
            j3 = 0;
        }
        long j16 = K02 - j3;
        if (QLog.isColorLevel()) {
            QLog.i(((IFMConfig) QRoute.api(IFMConfig.class)).getTAG(), 2, "updateConfig,durtime[" + j16 + "]");
        }
        if (j16 > 86400) {
            long j17 = sharedPreferences2.getLong("FileOnlinePreviewVersionKey", 0L);
            if (QLog.isDevelopLevel()) {
                j17 = 0;
            }
            GetResourceReqInfo getResourceReqInfo = new GetResourceReqInfo();
            getResourceReqInfo.uiResID = 0L;
            getResourceReqInfo.strPkgName = "FileOnlinePreviewConfigV2";
            getResourceReqInfo.uiCurVer = j17;
            getResourceReqInfo.sResType = (short) 3;
            getResourceReqInfo.sLanType = (short) 0;
            getResourceReqInfo.sReqType = (short) 1;
            if (QLog.isColorLevel()) {
                QLog.i(((IFMConfig) QRoute.api(IFMConfig.class)).getTAG(), 2, "updateConfig,durtime over one day!currentVersion[" + j17 + "]");
            }
            return getResourceReqInfo;
        }
        return null;
    }

    public GetResourceReqInfo L2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (GetResourceReqInfo) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        long j3 = BaseApplicationImpl.getApplication().getSharedPreferences("qq_safe_jump_whitelist", 0).getLong("key_jump_whitelist_version", 0L);
        GetResourceReqInfo getResourceReqInfo = new GetResourceReqInfo();
        getResourceReqInfo.uiResID = 0L;
        getResourceReqInfo.strPkgName = "com.tencent.jumpCI";
        getResourceReqInfo.uiCurVer = j3;
        getResourceReqInfo.sResType = (short) 2;
        getResourceReqInfo.sLanType = (short) 0;
        getResourceReqInfo.sReqType = (short) 1;
        return getResourceReqInfo;
    }

    public void M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConfigHandler", 2, "getPCActiveConfig");
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2095);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            ByteBuffer allocate = ByteBuffer.allocate(6);
            allocate.putInt(Utils.O(Long.parseLong(this.f194522e.getAccount()))).putShort((short) 16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x82f_0");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigHandler", 2, "getPCActiveConfig ex", e16);
            }
        }
    }

    public GetResourceReqInfo N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (GetResourceReqInfo) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        StatusManager statusManager = (StatusManager) this.f194522e.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager == null) {
            return null;
        }
        long L = statusManager.L();
        GetResourceReqInfo getResourceReqInfo = new GetResourceReqInfo();
        getResourceReqInfo.uiResID = 0L;
        getResourceReqInfo.strPkgName = "rich_status_android";
        getResourceReqInfo.uiCurVer = L;
        getResourceReqInfo.sResType = (short) 2;
        getResourceReqInfo.sLanType = (short) 0;
        getResourceReqInfo.sReqType = (short) 1;
        return getResourceReqInfo;
    }

    public GetResourceReqInfo R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (GetResourceReqInfo) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        long j3 = this.f194522e.getPreferences().getLong("k_voice_notify2_file_version", 0L);
        if (QLog.isColorLevel()) {
            QLog.d("VoiceNotify", 2, "updateVoiceNotifyConfig => curVersion: " + j3);
        }
        GetResourceReqInfo getResourceReqInfo = new GetResourceReqInfo();
        getResourceReqInfo.uiResID = 0L;
        getResourceReqInfo.strPkgName = "QQVoiceNotifyConfig2_android_CI";
        getResourceReqInfo.uiCurVer = j3;
        getResourceReqInfo.sResType = (short) 2;
        getResourceReqInfo.sLanType = (short) 0;
        getResourceReqInfo.sReqType = (short) 1;
        return getResourceReqInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4 A[Catch: all -> 0x0162, TryCatch #0 {, blocks: (B:31:0x00af, B:33:0x00b5, B:34:0x00cd, B:37:0x00de, B:40:0x00e4, B:43:0x00ee, B:45:0x00f4, B:47:0x0110, B:49:0x011b, B:50:0x0124, B:52:0x0128, B:54:0x012c, B:56:0x0132, B:58:0x0138, B:59:0x0141, B:60:0x0160, B:63:0x0151, B:65:0x0157, B:69:0x010e, B:71:0x00d6), top: B:30:0x00af }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        byte[] bArr = (byte[]) obj;
        if (QLog.isColorLevel() && fromServiceMsg != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleSendGetWifiPreLoadSwitch, ");
            sb5.append(fromServiceMsg.isSuccess());
            sb5.append(", ");
            if (bArr != null) {
                i16 = bArr.length;
            } else {
                i16 = -1;
            }
            sb5.append(i16);
            QLog.d("UpgradeController_ConfigHandler", 2, sb5.toString());
        }
        com.tencent.mobileqq.upgrade.k i17 = com.tencent.mobileqq.upgrade.k.i();
        UpgradeDetailWrapper j3 = i17.j();
        boolean z17 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && bArr != null) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("UpgradeController_ConfigHandler", 2, "", th5);
                }
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                if (!oidb_0x5eb_rspbody.rpt_msg_uin_data.isEmpty()) {
                    i3 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_preload_disable_flag.get();
                    synchronized (j3) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UpgradeConfigManager", 2, "preDownload switch bit has been got. value=" + i3);
                        }
                        j3.f306175m = true;
                        if (i3 == 1) {
                            z16 = true;
                        } else {
                            if (i3 == 2) {
                                com.tencent.mobileqq.upgrade.k.i().z();
                            }
                            z16 = false;
                        }
                        if (j3.f306171e != null) {
                            if (i3 == 0) {
                                int i18 = j3.C;
                                if (i18 == 1) {
                                    z17 = true;
                                } else if (i18 == 2) {
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("UpgradeConfigManager", 2, "handle_oidb_0x5eb_42073.wifi_pre_download_switch=" + z17);
                                }
                                z16 = z17;
                            }
                            z17 = z16;
                            if (QLog.isColorLevel()) {
                            }
                            z16 = z17;
                        } else {
                            j3.D = i3;
                        }
                        w3(this.f194522e, z16);
                        if (QLog.isColorLevel()) {
                            QLog.d("preLoad_configServlet", 2, "begin synchronized --toggle bit");
                        }
                        if (j3.f306171e != null && j3.f306174i != null && j3.f306171e.iUpgradeType != 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("preLoad_configServlet", 2, "begin synchronized --toggle bit go on");
                            }
                            i17.o(j3.f306171e, (ConfigHandler) this.f194522e.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER));
                        } else if (QLog.isColorLevel()) {
                            QLog.d("preLoad_configServlet", 2, "begin synchronized --toggle bit wait");
                        }
                    }
                    return;
                }
            }
        }
        i3 = 0;
        synchronized (j3) {
        }
    }

    public void b3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z16 = true;
        toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, true);
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                if (4 <= byteArray.length && ((valueOf = String.valueOf(PkgTools.getLongData(byteArray, 0))) == null || !valueOf.equals(this.f194522e.getAccount()))) {
                    z16 = false;
                }
                if (z16 && QLog.isDevelopLevel()) {
                    QLog.d("UpgradeController_ConfigHandler", 4, "toggle update value success");
                }
            }
        }
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.mobileqq.upgrade.banner.b.f(true);
            l3(true, null);
        }
    }

    @Override // com.tencent.mobileqq.upgrade.download.b.InterfaceC8883b
    public void g1(int i3, UpgradeDetailWrapper upgradeDetailWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) upgradeDetailWrapper);
            return;
        }
        QLog.d("UpgradeController_ConfigHandler", 1, "onFinish");
        UpgradeInfo upgradeInfo = upgradeDetailWrapper.f306170d;
        if (i3 == 0 && upgradeInfo != null) {
            j3(this.f194522e, upgradeInfo.strNewTipsDescURL, upgradeInfo.iTipsWaitDay);
            x3(upgradeDetailWrapper);
        } else {
            l3(true, upgradeDetailWrapper);
        }
    }

    public void m3(UpgradeDetailWrapper upgradeDetailWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) upgradeDetailWrapper);
        } else if (upgradeDetailWrapper != null) {
            upgradeDetailWrapper.f306170d = new UpgradeInfo();
            l3(false, upgradeDetailWrapper);
        }
    }

    public void n3(String str, int i3, ArrayList<QQOperationViopTipTask> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, Integer.valueOf(i3), arrayList);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "receive task, uin =" + str + " uinType=" + i3);
            Iterator<QQOperationViopTipTask> it = arrayList.iterator();
            while (it.hasNext()) {
                QLog.d("QQOperateVoIP", 4, "receive task, taskid=" + it.next().taskid);
            }
        }
        OperateVoipTipsInfo operateVoipTipsInfo = new OperateVoipTipsInfo();
        operateVoipTipsInfo.uin = str;
        operateVoipTipsInfo.uinType = i3;
        operateVoipTipsInfo.taskList = arrayList;
        QQOperateManager d16 = QQOperateManager.d(this.f194522e);
        Iterator<QQOperationViopTipTask> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            QQOperationViopTipTask e16 = d16.e(it5.next().taskid);
            if (e16 == null) {
                ConfigServlet.q(this.f194522e);
                return;
            }
            QQOperationVoipTipsTaskExcuteRecord qQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
            qQOperationVoipTipsTaskExcuteRecord.taskid = e16.taskid;
            qQOperationVoipTipsTaskExcuteRecord.tipType = e16.tipType;
            qQOperationVoipTipsTaskExcuteRecord.uin = str;
            qQOperationVoipTipsTaskExcuteRecord.uinType = i3;
            qQOperationVoipTipsTaskExcuteRecord.count = 1;
            qQOperationVoipTipsTaskExcuteRecord.time = System.currentTimeMillis();
            d16.b(this.f194522e, qQOperationVoipTipsTaskExcuteRecord);
        }
        notifyUI(8, true, operateVoipTipsInfo);
    }

    public void o3(ToServiceMsg toServiceMsg, Object obj) {
        IEarlyDownloadService iEarlyDownloadService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) toServiceMsg, obj);
            return;
        }
        if (obj == null) {
            if (toServiceMsg.extraData.getBoolean("reqRegionConfig")) {
                ((ConditionSearchManager) this.f194522e.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).L(null);
                return;
            }
            return;
        }
        ArrayList<GetResourceRespInfo> arrayList = ((GetResourceResp) obj).vecResRespInfo;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                GetResourceRespInfo getResourceRespInfo = arrayList.get(i3);
                if (QLog.isColorLevel()) {
                    QLog.d("ThemeDownloadTrace", 2, String.format("onReceive_GetResourceRespInfo. \r\n%s", getResourceRespInfo));
                }
                short s16 = getResourceRespInfo.sResType;
                if (s16 == 3) {
                    if ("FileOnlinePreviewConfigV2".equals(getResourceRespInfo.strPkgName)) {
                        W2(getResourceRespInfo);
                    } else {
                        V2(getResourceRespInfo);
                    }
                } else if (s16 == 0) {
                    if ("com.tencent.weather_bg".equals(getResourceRespInfo.strPkgName)) {
                        d3(getResourceRespInfo);
                    }
                } else if (s16 == 2) {
                    if ("rich_status_android".equals(getResourceRespInfo.strPkgName)) {
                        c3(getResourceRespInfo);
                    } else if ("QQAddFriend.AdministrateRegion".equals(getResourceRespInfo.strPkgName)) {
                        ConditionSearchManager conditionSearchManager = (ConditionSearchManager) this.f194522e.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
                        if (conditionSearchManager != null) {
                            conditionSearchManager.L(getResourceRespInfo);
                        }
                    } else if ("com.tencent.jumpCI".equals(getResourceRespInfo.strPkgName)) {
                        Z2(getResourceRespInfo);
                    }
                } else if (s16 == 4) {
                    EntityManager createEntityManager = this.f194522e.getEntityManagerFactory().createEntityManager();
                    T2(createEntityManager, getResourceRespInfo);
                    createEntityManager.close();
                } else if (s16 == 512 && (iEarlyDownloadService = (IEarlyDownloadService) this.f194522e.getRuntimeService(IEarlyDownloadService.class, "")) != null) {
                    iEarlyDownloadService.onServerResp(getResourceRespInfo);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Class) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return h.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z17 = true;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[3];
            objArr[0] = fromServiceMsg.getServiceCmd();
            objArr[1] = Integer.valueOf(toServiceMsg.getAppSeq());
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[2] = Boolean.valueOf(z16);
            QLog.d("ConfigHandler", 2, String.format("ConfigHandler serviceCmd[%s], appseq[%s], data[%s]", objArr));
        }
        if ("ResourceConfig.GetResourceReq".equals(fromServiceMsg.getServiceCmd())) {
            o3(toServiceMsg, obj);
            return;
        }
        if ("MobileTipsSvc.TipsReport".equals(fromServiceMsg.getServiceCmd())) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            if (isSuccess) {
                MobileTips$MobileTipsPkg mobileTips$MobileTipsPkg = new MobileTips$MobileTipsPkg();
                try {
                    mobileTips$MobileTipsPkg.mergeFrom((byte[]) obj);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (mobileTips$MobileTipsPkg.rsp.result.get() != 0) {
                    z17 = false;
                }
                isSuccess = z17;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QQOperateVoIP", 4, "get voip_tips req ack rsp confighandler isSuccess " + isSuccess);
                return;
            }
            return;
        }
        if ("OidbSvc.0x82f_0".equals(fromServiceMsg.getServiceCmd())) {
            X2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("MAAControl.CheckSinglePkgSig".equals(fromServiceMsg.getServiceCmd())) {
            S2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("MAAControl.GetSinglePkgSig".equals(fromServiceMsg.getServiceCmd())) {
            U2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x9ae_2".equals(fromServiceMsg.getServiceCmd())) {
            Y2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x4ff_42073".equals(fromServiceMsg.getServiceCmd())) {
            b3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x5eb_42073".equals(fromServiceMsg.getServiceCmd())) {
            a3(toServiceMsg, fromServiceMsg, obj);
        } else if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
        }
    }

    public void q3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            com.tencent.mobileqq.upgrade.k.i().v(false);
            l3(false, null);
        }
    }

    public void r3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (this.f194522e.getPreferences().getBoolean("has_auth_real_name", false)) {
            if (QLog.isColorLevel()) {
                QLog.i("RealName", 2, "has auth real name.");
            }
        } else {
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 2, new cmd0x9ae$ReqBody().toByteArray());
            makeOIDBPkg.addAttribute("serviceType", 2);
            sendPbReq(makeOIDBPkg);
            if (QLog.isColorLevel()) {
                QLog.i("RealName", 2, "queryRealNameStatus");
            }
        }
    }

    public boolean s3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        SharedPreferences preferences = this.f194522e.getPreferences();
        boolean z16 = preferences.getBoolean("has_auth_real_name_av", false);
        boolean z17 = preferences.getBoolean("has_request_auth_real_name_av", false);
        if (QLog.isColorLevel()) {
            QLog.i("RealName", 2, "hasAuthRealNameForAv " + z16 + " " + z17);
        }
        if (z16) {
            return true;
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 12, new cmd0x9ae$ReqBody().toByteArray());
        makeOIDBPkg.addAttribute("serviceType", 12);
        sendPbReq(makeOIDBPkg);
        if (z17) {
            return false;
        }
        return true;
    }

    public void t3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QLog.d("UpgradeController", 1, "resetCounter");
        i3(this.f194522e, false);
        k3(this.f194522e, 0);
        com.tencent.mobileqq.upgrade.banner.b.i(0L);
    }

    public void u3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UpgradeController_ConfigHandler", 2, "sendGetWifiPreLoadSwitch");
        }
        String account = this.f194522e.getAccount();
        if (account == null) {
            QLog.i("UpgradeController_ConfigHandler", 1, "sendGetWifiPreLoadSwitch fail");
            return;
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Long.valueOf(Long.parseLong(account)));
            oidb_0x5eb_reqbody.rpt_uint64_uins.set(arrayList);
            oidb_0x5eb_reqbody.uint32_preload_disable_flag.set(1);
            sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42073", 1515, 22, oidb_0x5eb_reqbody.toByteArray()));
        } catch (Exception e16) {
            QLog.w("UpgradeController_ConfigHandler", 1, "sendGetWifiPreLoadSwitch error", e16);
        }
    }

    public void v3(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(13);
        long parseLong = Long.parseLong(this.f194522e.getCurrentAccountUin());
        if (z16) {
            s16 = 1;
        } else {
            s16 = 2;
        }
        allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort((short) -23463).putShort((short) 2).putShort(s16);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x4ff_42073", 1279, 9, allocate.array());
        makeOIDBPkg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
        sendPbReq(makeOIDBPkg);
    }

    public int y3(ArrayList<GetResourceReqInfo> arrayList, GetResourceReqInfo... getResourceReqInfoArr) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) arrayList, (Object) getResourceReqInfoArr)).intValue();
        }
        ArrayList arrayList2 = new ArrayList(4);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<GetResourceReqInfo> it = arrayList.iterator();
            z16 = false;
            while (it.hasNext()) {
                GetResourceReqInfo next = it.next();
                if (next != null) {
                    if (next.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
                        z16 = true;
                    }
                    arrayList2.add(next);
                }
            }
        } else {
            z16 = false;
        }
        for (GetResourceReqInfo getResourceReqInfo : getResourceReqInfoArr) {
            if (getResourceReqInfo != null) {
                if (getResourceReqInfo.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
                    z16 = true;
                }
                arrayList2.add(getResourceReqInfo);
            }
        }
        if (arrayList2.size() <= 0) {
            return -1;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("ResourceConfig.GetResourceReq");
        createToServiceMsg.extraData.putSerializable("getResourceReqInfos", arrayList2);
        createToServiceMsg.extraData.putBoolean("reqRegionConfig", z16);
        int i3 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i3 + 1;
        createToServiceMsg.setAppSeq(i3);
        if (QLog.isColorLevel()) {
            QLog.d("updateConfigs", 2, String.format("updateConfigs reqRegionConfig!, AppSeq[%s]", Integer.valueOf(createToServiceMsg.getAppSeq())));
        }
        send(createToServiceMsg);
        return createToServiceMsg.getAppSeq();
    }

    public void z3(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) bool);
        } else {
            notifyUI(16, true, bool);
        }
    }
}
