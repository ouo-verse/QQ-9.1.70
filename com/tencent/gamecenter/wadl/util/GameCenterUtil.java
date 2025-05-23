package com.tencent.gamecenter.wadl.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameMMKVService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.api.IQQGameProviderService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule;
import com.tencent.gamecenter.wadl.config.FloatingPermissionConfProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import eipc.EIPCResult;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GameCenterUtil {
    public static final int AUTH_DIALOG_TYPE_NEW = 1;
    public static final String CONF_DNS_PRE_PARSE_DOMAINS_TASK_NAME = "qqwadl_dns_domains";
    public static final String CONF_FILE_COMM = "conf.json";
    public static final String CONF_FILE_JOINT_REGEX_CONFIG = "jointRegexConfig.json";
    public static final String CONF_KEY_AUTH_DIALOG = "authDialog";
    public static final String CONF_KEY_AUTO_DOWNLOAD_INFO = "autoDownloadInfo";
    public static final String CONF_KEY_AUTO_DOWNLOAD_PULL = "autoDownloadPull";
    public static final String CONF_KEY_CLEAR_FILE_SWITCH = "clearFileSwitch";
    public static final String CONF_KEY_DNS_PRE_PARSE = "dns_preparse_switch";
    public static final String CONF_KEY_DOWNLOAD_MGR_URL = "download_mgr_url";
    public static final String CONF_KEY_FLOAT_WINDOW_INFO = "float_window_info";
    public static final String CONF_KEY_HARDCODE_INFO = "hardCodeInfo";
    public static final String CONF_KEY_INTERRUPT_JOINT_REGEX_SWITCH = "interruptJointRegexSwitch";
    public static final String CONF_KEY_INTERRUPT_JOINT_SWITCH = "interruptJointSwitch";
    public static final String CONF_KEY_INTERRUPT_JUMP_URL = "interrupt_jump_url";
    public static final String CONF_KEY_INTERRUPT_MAPPING_SWITCH = "interruptMappingSwitch";
    public static final String CONF_KEY_INTERRUPT_REGEX_SWITCH = "interruptRegexSwitch";
    public static final String CONF_KEY_INTERRUPT_SCHEME = "interrupt_scheme";
    public static final String CONF_KEY_INTERRUPT_URL_SWITCH = "interruptUrlSwitch";
    public static final String CONF_KEY_MATCH_CONFIG_INVALID_TIME = "match_config_invalid_time";
    public static final String CONF_KEY_MATCH_INFO = "match_info";
    public static final String CONF_KEY_MATCH_SLEEP_TIME = "match_sleep_time";
    public static final String CONF_KEY_MINI_PROVIDER_SWITCH = "miniProviderSwitch";
    public static final String CONF_KEY_NOTICE_INSTALL_SWITCH = "noticeInstallSwitch";
    public static final String CONF_KEY_REPORT_PERMISSION_SWITCH = "reportPermissionSwitch";
    public static final String CONF_KEY_REPORT_RATE = "reportSampleRate";
    public static final String CONF_KEY_SCHEDULE_INFO = "scheduleInfo";
    public static final String CONF_KEY_SPEED_LIMIT = "speedLimitSwitch";
    public static final String CONF_KEY_TGPA_PROVIDER_SWITCH = "tgpaProviderSwitch";
    public static final String CONF_KEY_TIPS_PRE_INFO = "tips_pre_info";
    public static final String CONF_KEY_WEB_SSO_CMDS = "websso_cmds";
    public static final String CONF_KEY_X5_LOG_SEED = "x5_log_seed";
    public static final String CONF_WADL_SWITCH = "qqwadl_switch";
    public static final String CONF_WADL_SWITCH_COMMON_VLAUES_ON = "1";
    public static final String DIR_PKG = "pkg";
    public static final String DIR_PRE = "com.tencent.gamecenter.wadl/";
    public static final String DIR_RES = "res";
    public static final String FILE_NAME_PRE = "wadl_";
    public static final String GC_CONF_DIR = "gc_conf";
    public static final String INSTALL_FROM_AUTO = "auto";
    public static final String INSTALL_FROM_CHECK_MODEL = "checkModel";
    public static final String INSTALL_FROM_CUSTOM = "custom";
    public static final String INSTALL_FROM_DEFAULT = "default";
    public static final String INSTALL_FROM_FLOAT_BALL = "floatball";
    public static final String INSTALL_FROM_NOTIFICATION = "notification";
    public static final String INSTALL_FROM_TIPS = "tips";
    public static final String KEY_DISCUSS_GROUP_UIN = "dicussgroup_uin";
    public static final String KEY_FRIEND_UIN = "friend_uin";
    public static final String KEY_GROUP_UIN = "groupUin";
    public static final String KEY_UIN_TYPE = "uinType";
    public static final String SCHEMA_MINI_INSTALL = "phoenix://jump/install";
    public static final String TAG = "Wadl_GameCenterUtil";
    private static final String TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static boolean hasCheckFirstInstall;
    private static boolean isFirstInstall;
    private static String sDeceiveMetrics;
    public static HashSet<String> DEFAULT_WEBSSO_CMDS = new HashSet<>();
    public static SparseIntArray ERROR_CODE_MAP = new SparseIntArray();
    static LruCache<String, Boolean> UNMATCH_URL_CACHE = new LruCache<>(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f107658d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f107659e;

        a(String str, Activity activity) {
            this.f107658d = str;
            this.f107659e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("559").setGameAppId(this.f107658d).setOperId(WadlProxyConsts.OPER_ID_FLOAT_PERMISSION).setRetId(1).setExt(31, "1").report();
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(this.f107659e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f107660d;

        b(QQCustomDialog qQCustomDialog) {
            this.f107660d = qQCustomDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f107660d.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f107661d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f107662e;

        c(String str, Activity activity) {
            this.f107661d = str;
            this.f107662e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("559").setGameAppId(this.f107661d).setOperId(WadlProxyConsts.OPER_ID_FLOAT_PERMISSION).setRetId(1).setExt(31, "0").report();
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(this.f107662e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    static {
        DEFAULT_WEBSSO_CMDS.add(WadlProxyConsts.CMD_GET_APK_DOWNLOAD_INFO);
        DEFAULT_WEBSSO_CMDS.add(WadlProxyConsts.CMD_SET_AUTO_DOWNLOAD);
        DEFAULT_WEBSSO_CMDS.add(WadlProxyConsts.CMD_PRELOAD_GAME);
        ERROR_CODE_MAP.put(0, 0);
        ERROR_CODE_MAP.put(999, 7);
        ERROR_CODE_MAP.put(-1, 1);
        ERROR_CODE_MAP.put(-15, 1);
        ERROR_CODE_MAP.put(-16, 1);
        ERROR_CODE_MAP.put(-23, 1);
        ERROR_CODE_MAP.put(-24, 1);
        ERROR_CODE_MAP.put(-25, 1);
        ERROR_CODE_MAP.put(-26, 1);
        ERROR_CODE_MAP.put(-30, 1);
        ERROR_CODE_MAP.put(-71, 1);
        ERROR_CODE_MAP.put(-11, 2);
        ERROR_CODE_MAP.put(-51, 2);
        ERROR_CODE_MAP.put(-12, 3);
        ERROR_CODE_MAP.put(-40, 3);
        ERROR_CODE_MAP.put(-10, 5);
        ERROR_CODE_MAP.put(-60, 5);
        ERROR_CODE_MAP.put(100, 5);
    }

    public static boolean addAppidToList(String str, String str2) {
        String readFromSp;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (readFromSp = GameCenterSpUtils.readFromSp(str2)) == null) {
            return false;
        }
        QLog.i(TAG, 1, "yuyue:addAppidToList,appid:" + str + ",key:" + str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("|");
        return GameCenterSpUtils.writeToSp(str2, readFromSp.replace(sb5.toString(), "") + str + "|");
    }

    public static void addKingCardSwitch(String str, int i3) {
        GameCenterSpUtils.writeToSpInt(str, i3);
    }

    public static void addMinElectricity(String str, int i3) {
        GameCenterSpUtils.writeToSpInt(str, i3);
    }

    public static boolean addPullFlag(String str, int i3, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            GameCenterSpUtils.writeToSpInt(str + "_" + str2, i3);
            return true;
        }
        return false;
    }

    public static boolean checkInstallPermission() {
        boolean canRequestPackageInstalls;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                canRequestPackageInstalls = BaseApplication.getContext().getPackageManager().canRequestPackageInstalls();
                return canRequestPackageInstalls;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "checkInstallPermission exception", th5);
                return true;
            }
        }
        return true;
    }

    public static boolean checkVersion(String str, int i3) {
        int appVersionCode = getAppVersionCode(str);
        QLog.i(TAG, 1, "checkVersion packageName=" + str + ",versionCode=" + i3 + ",localVersion=" + appVersionCode);
        if (appVersionCode != -1 && appVersionCode < i3) {
            return true;
        }
        return false;
    }

    public static void closeIO(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static int convertRemoteStatusToLocal(int i3) {
        int i16 = 6;
        if (i3 == 6) {
            return 4;
        }
        if (i3 == 4) {
            return 2;
        }
        if (i3 == 5) {
            return 3;
        }
        if (i3 != 7 && i3 != 14) {
            if (i3 == 0) {
                return 1;
            }
            if (i3 != 9) {
                if (i3 == 11) {
                    return 9;
                }
                i16 = 10;
                if (i3 != 12) {
                    if (i3 != 2 && i3 != 13) {
                        if (i3 == 10) {
                            return 13;
                        }
                        return 0;
                    }
                    return 20;
                }
            }
            return i16;
        }
        return -2;
    }

    public static Intent createBrowserIntent(String str) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.addFlags(268435456);
        return intent;
    }

    public static String createFileNameBySuffix(String str, int i3, String str2) {
        return FILE_NAME_PRE + str + "_" + i3 + str2;
    }

    public static Intent createHippyIntent(String str) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        return intent;
    }

    public static Intent createInstallScheme(String str, String str2, String str3) {
        QLog.d(TAG, 1, "createInstallScheme localAPKPath=" + str + ",sourceId=" + str2 + ",callFrom=" + str3);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.addFlags(131072);
        intent.setData(Uri.parse("mqqapi://gamecenter/install"));
        intent.putExtra(WadlProxyConsts.KEY_LOCAL_APK_PATH, str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "biz_src_zf_games";
        }
        intent.putExtra("sourceId", str2);
        return intent;
    }

    public static Intent createMiniScheme(String str, String str2, String str3) {
        QLog.d(TAG, 1, "createMiniScheme dstPkgName=" + str + ",appId=" + str2 + ",localAPKPath=" + str3);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.addFlags(131072);
        intent.setPackage(str);
        intent.setData(Uri.parse(SCHEMA_MINI_INSTALL));
        intent.putExtra("appid", str2);
        intent.putExtra(WadlProxyConsts.KEY_LOCAL_APK_PATH, str3);
        intent.putExtra("big_brother_source_key", "biz_src_zf_games");
        return intent;
    }

    public static boolean delAppDetail(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return GameCenterSpUtils.deleteToSp(str2 + str);
    }

    public static boolean deleteAppidFromList(String str, String str2) {
        String readFromSp;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (readFromSp = GameCenterSpUtils.readFromSp(str2)) == null) {
            return false;
        }
        String str3 = "";
        String replace = readFromSp.replace(str + "|", "");
        if (!str.equals(replace)) {
            str3 = replace;
        }
        return GameCenterSpUtils.writeToSp(str2, str3);
    }

    private static boolean doInstall(String str, String str2, String str3, String str4, String str5, boolean z16) {
        if (handleMiniLogic(str, str2, str3, str5)) {
            return false;
        }
        if (z16) {
            RouteUtils.startActivity(MobileQQ.sMobileQQ, createInstallScheme(str3, str4, str5), RouterConstants.UI_ROUTER_JUMP);
            return true;
        }
        Intent openApkIntent = FileProvider7Helper.openApkIntent(BaseApplication.getContext(), str3);
        if (openApkIntent == null) {
            return false;
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = "biz_src_zf_games";
        }
        openApkIntent.putExtra("big_brother_source_key", str4);
        BaseApplication.getContext().startActivity(openApkIntent);
        return true;
    }

    public static boolean fileExists(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static String getApkSourceDir(String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = MobileQQ.sMobileQQ.getPackageManager();
            if (packageManager != null) {
                applicationInfo = packageManager.getApplicationInfo(str, 0);
            } else {
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Exception e16) {
            QLog.i(TAG, 1, "getApkSourceDir: " + str + " exception: " + e16.getMessage());
            return null;
        }
    }

    public static int getApkVersonCodeFromPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = com.tencent.open.adapter.a.f().e().getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d(TAG, "getApkVersonCodeFromApkFile>>>", e16);
        }
        return 0;
    }

    public static int getAppVersionCode(String str) {
        PackageInfo packageInfo;
        QLog.d(TAG, 1, "getAppVersionCode packageName=" + str);
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageManager packageManager = MobileQQ.sMobileQQ.getPackageManager();
            if (packageManager != null) {
                packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 0);
            } else {
                packageInfo = null;
            }
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            QLog.d(TAG, 1, "getAppVersionCode packageName=" + str + ",not found");
        }
        return -1;
    }

    public static String getChannelId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String fileChannel = getFileChannel(getApkSourceDir(str));
            QLog.i(TAG, 1, "++++++channelId:" + fileChannel);
            return fileChannel;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getChannelId], error:" + th5);
            return "";
        }
    }

    public static File getConfDir() {
        File file = new File(MobileQQ.sMobileQQ.getFilesDir(), GC_CONF_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getConfigFile(String str) {
        return new File(getConfDir(), str);
    }

    public static String getDateStr(long j3) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE).format(new Date(j3 * 1000));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getDeceiveMetrics() {
        String str;
        if (sDeceiveMetrics == null) {
            DisplayMetrics displayMetrics = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                str = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            } else {
                str = "";
            }
            sDeceiveMetrics = str;
        }
        return sDeceiveMetrics;
    }

    public static String getDownloadApkDir(int i3) {
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(DIR_PRE + i3);
        QLog.d(TAG, 1, "getDownloadApkDir realPath=" + sDKPrivatePath);
        try {
            File file = new File(sDKPrivatePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getDownloadApkDir make dir error", th5);
        }
        return sDKPrivatePath;
    }

    public static String getDownloadResDir(String str, int i3) {
        String str2;
        if (i3 == 4) {
            str2 = "pkg";
        } else {
            str2 = "res";
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(DIR_PRE + str2 + "/" + str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getDownloadResDir realPath=");
        sb5.append(sDKPrivatePath);
        QLog.d(TAG, 1, sb5.toString());
        try {
            File file = new File(sDKPrivatePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getDownloadApkDir make dir error", th5);
        }
        return sDKPrivatePath;
    }

    public static String getFileChannel(String str) {
        String str2;
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = com.tencent.gamecenter.wadl.util.a.a(str);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getFileChannel v2 exception:" + th5.getMessage());
            str2 = "";
        }
        if (StringUtil.isEmpty(str2)) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    File file = new File(str);
                    if (file.exists() && file.length() > 0) {
                        long length = file.length();
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            try {
                                bufferedInputStream2.skip(length - 50);
                                byte[] bArr = new byte[50];
                                bufferedInputStream2.read(bArr, 0, 50);
                                String str4 = new String(bArr);
                                if (!TextUtils.isEmpty(str4) && str4.contains("channelId=")) {
                                    String substring = str4.substring(str4.indexOf("channelId=") + 10);
                                    try {
                                        if (!TextUtils.isEmpty(substring)) {
                                            str3 = substring.trim();
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                        bufferedInputStream = bufferedInputStream2;
                                        str2 = substring;
                                    }
                                    try {
                                        QLog.i(TAG, 1, "getFileChannel result=" + str3 + ",fileLen=" + length);
                                        bufferedInputStream = bufferedInputStream2;
                                        str2 = str3;
                                    } catch (Exception e17) {
                                        bufferedInputStream = bufferedInputStream2;
                                        str2 = str3;
                                        e = e17;
                                        QLog.e(TAG, 1, "getFileChannel v1 exception:" + e.getMessage());
                                        IOUtil.closeStream(bufferedInputStream);
                                        return str2;
                                    }
                                } else {
                                    bufferedInputStream = bufferedInputStream2;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedInputStream = bufferedInputStream2;
                                IOUtil.closeStream(bufferedInputStream);
                                throw th;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            bufferedInputStream = bufferedInputStream2;
                        }
                    }
                } catch (Exception e19) {
                    e = e19;
                }
                IOUtil.closeStream(bufferedInputStream);
            } catch (Throwable th7) {
                th = th7;
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        r7 = java.nio.file.Files.getLastModifiedTime(r7, new java.nio.file.LinkOption[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        r7 = java.nio.file.Paths.get(r7, new java.lang.String[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getFileLastModifyTime(String str) {
        Path path;
        FileTime lastModifiedTime;
        long j3 = 0;
        if (StringUtil.isEmpty(str)) {
            return 0L;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26 && path != null && lastModifiedTime != null) {
                j3 = lastModifiedTime.toMillis();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        QLog.i(TAG, 1, "getFileLastModifyTime ts " + j3);
        return j3;
    }

    public static com.tencent.gamecenter.wadl.biz.entity.a getInstallInfo(String str, String str2) {
        com.tencent.gamecenter.wadl.biz.entity.a aVar = new com.tencent.gamecenter.wadl.biz.entity.a(str, str2);
        if (!TextUtils.isEmpty(str2)) {
            String apkSourceDir = getApkSourceDir(str2);
            int appVersionCode = getAppVersionCode(str2);
            aVar.f106751f = appVersionCode;
            if (appVersionCode != -1) {
                aVar.f106749d = true;
                boolean isExistMiniApp = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).isExistMiniApp(str2);
                aVar.f106750e = isExistMiniApp;
                if (!isExistMiniApp) {
                    aVar.f106748c = getFileChannel(apkSourceDir);
                }
            }
        }
        QLog.i(TAG, 1, "getInstallInfo installInfo=" + aVar);
        return aVar;
    }

    public static Intent getInstallSettingIntent() {
        return new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + BaseApplication.getContext().getPackageName()));
    }

    public static int getKingCardSwitch(String str) {
        return GameCenterSpUtils.readFromSpInt(str);
    }

    public static int getMinElectricity(String str) {
        int i3;
        try {
            i3 = GameCenterSpUtils.readFromSpInt(str);
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "getMinElectricity error");
            i3 = 20;
        }
        QLog.i(TAG, 1, "getMinElectricity: " + i3);
        return i3;
    }

    public static long getPackageFirstInstallTime(String str, Context context) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getPackageFirstInstallTime exception", e16);
            return 0L;
        }
    }

    public static PackageInfo getPackageInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageManager packageManager = MobileQQ.sMobileQQ.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return InstalledAppListMonitor.getPackageInfo(packageManager, str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static long getPackageLastUpdateTime(String str, Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).lastUpdateTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static long getResAvilTime() {
        long readFromSpLong = ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).readFromSpLong(GameCenterSpUtils.KEY_GAMECENTER_RES_TIME);
        QLog.i(TAG, 1, "getResAvilTime ts" + readFromSpLong);
        return readFromSpLong;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, String> getSessionInfo(Intent intent) {
        String stringExtra;
        String str = "";
        if (intent == null) {
            return new Pair<>(-1, "");
        }
        int intExtra = intent.getIntExtra("uinType", -1);
        if (intExtra == -1) {
            intExtra = intent.getIntExtra("curtype", -1);
        }
        if (intExtra != 0) {
            if (intExtra != 1) {
                if (intExtra != 1000 && intExtra != 1001 && intExtra != 1004 && intExtra != 1005) {
                    if (intExtra != 3000) {
                        stringExtra = null;
                    } else {
                        stringExtra = intent.getStringExtra("dicussgroup_uin");
                    }
                }
            } else {
                stringExtra = intent.getStringExtra("groupUin");
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                str = stringExtra;
            }
            return new Pair<>(Integer.valueOf(intExtra), str);
        }
        stringExtra = intent.getStringExtra("friend_uin");
        if (!TextUtils.isEmpty(stringExtra)) {
        }
        return new Pair<>(Integer.valueOf(intExtra), str);
    }

    public static String getUin() {
        Bundle bundle;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        WadlQIPCConnector.getInstance().checkConnect();
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_GETUIN, new Bundle());
        if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
            return bundle.getString("uin");
        }
        return "";
    }

    public static String getUrlParameter(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return Uri.parse(str).getQueryParameter(str2);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getUrlParameter error, url:", str, ", key:", str2, th5);
            }
        }
        return "";
    }

    public static int getWadlErrCode(int i3) {
        if (ERROR_CODE_MAP.indexOfKey(i3) >= 0) {
            return ERROR_CODE_MAP.get(i3);
        }
        return 6;
    }

    public static String getWadlErrMsg(int i3) {
        switch (i3) {
            case 0:
                return "";
            case 1:
                return com.tencent.open.adapter.a.f().e().getString(R.string.cob);
            case 2:
                return com.tencent.open.adapter.a.f().e().getString(R.string.cof);
            case 3:
                return com.tencent.open.adapter.a.f().e().getString(R.string.cod);
            case 4:
                return com.tencent.open.adapter.a.f().e().getString(R.string.co_);
            case 5:
                return com.tencent.open.adapter.a.f().e().getString(R.string.co7);
            case 6:
                return com.tencent.open.adapter.a.f().e().getString(R.string.co7);
            default:
                return com.tencent.open.adapter.a.f().e().getString(R.string.co7);
        }
    }

    public static void goToInstall(String str, String str2, String str3, String str4, String str5) {
        goToInstall(str, str2, str3, str4, str5, true);
    }

    public static void goToInstallWithJump(String str, String str2, String str3, String str4, String str5, boolean z16) {
        jumpUrlOrSchema(MobileQQ.sMobileQQ, WadlProxyConsts.KUIKLY_DOWNLOAD_ADMIN_SCHEME);
        goToInstall(str, str2, str3, str4, str5, z16);
    }

    public static void gotoBrowserActivityWithParams(Activity activity, String str, Map<String, String> map) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }
        }
        activity.startActivity(intent);
    }

    public static void gotoGameCenterPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(BaseApplication.getContext(), RouterConstants.UI_ROUTE_GAME_CENTER_ACTIVITY);
            activityURIRequest.extra().putString("url", str);
            activityURIRequest.extra().putString("big_brother_source_key", "biz_src_zf_games");
            activityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
            activityURIRequest.setFlags(268435456);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "gotoGameCenterPage exception", th5);
        }
    }

    private static boolean handleMiniLogic(String str, String str2, String str3, String str4) {
        boolean z16;
        boolean z17 = false;
        if (((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).isExistMiniApp(str2)) {
            com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
            if (gVar != null) {
                z16 = gVar.f106802o;
            } else {
                z16 = false;
            }
            QLog.d(TAG, 1, "doInstall isExistMiniApp miniProviderSwitchOn=" + z16 + ", callFrom=" + str4 + ",processId=" + MobileQQ.sProcessId);
            if (z16) {
                if (!INSTALL_FROM_FLOAT_BALL.equals(str4) && !"notification".equals(str4) && !"tips".equals(str4)) {
                    if ("auto".equals(str4)) {
                        if (MobileQQ.sProcessId == 1) {
                            IQQGameProviderService iQQGameProviderService = (IQQGameProviderService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameProviderService.class, "all");
                            if (iQQGameProviderService != null) {
                                z17 = iQQGameProviderService.notifyInstall(str2);
                            }
                            QLog.d(TAG, 1, "doInstall notifyInstall result=" + z17);
                        }
                        return true;
                    }
                } else {
                    MobileQQ.sMobileQQ.startActivity(createMiniScheme(str2, str, str3));
                    return true;
                }
            }
        }
        return false;
    }

    public static void handleQueryResult(ArrayList<WadlResult> arrayList) {
        try {
            PackageManager packageManager = MobileQQ.sMobileQQ.getPackageManager();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (InstalledAppListMonitor.getPackageInfo(packageManager, arrayList.get(i3).wadlParams.packageName.trim(), 0) != null && arrayList.get(i3).taskStatus != 9) {
                    arrayList.get(i3).taskStatus = 9;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleQueryResult e=" + e16.toString());
        }
    }

    public static String isApkExist(String str, int i3, int i16) {
        String str2 = getDownloadApkDir(i3) + "/" + createFileNameBySuffix(str, i16, ".apk");
        if (fileExists(str2)) {
            return str2;
        }
        return null;
    }

    public static boolean isAppFirstInstall(String str, Context context) {
        if (!hasCheckFirstInstall) {
            boolean z16 = true;
            hasCheckFirstInstall = true;
            if (getPackageFirstInstallTime(str, context) != getPackageLastUpdateTime(str, context)) {
                z16 = false;
            }
            isFirstInstall = z16;
        }
        QLog.i(TAG, 2, "[isAppFirstInstall] " + isFirstInstall);
        return isFirstInstall;
    }

    public static boolean isApplicationBroughtToBackground(Context context) {
        ComponentName componentName;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && !runningTasks.isEmpty()) {
            componentName = runningTasks.get(0).topActivity;
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCheckInstallPermissionByBusiness(int i3) {
        if (3 == i3) {
            return false;
        }
        return true;
    }

    public static boolean isClearFileSwitchOn() {
        com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar != null && gVar.f106793f) {
            return true;
        }
        return false;
    }

    public static boolean isContainsUnMatchUrl(String str) {
        if (UNMATCH_URL_CACHE.get(str) != null) {
            return true;
        }
        return false;
    }

    public static boolean isForeground() {
        Bundle bundle;
        if (MobileQQ.sProcessId == 1) {
            return Foreground.isCurrentProcessForeground();
        }
        WadlQIPCConnector.getInstance().checkConnect();
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_CHECK_FOREGROUND, new Bundle());
        if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
            return bundle.getBoolean("isForeground");
        }
        return false;
    }

    public static boolean isHippyScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith(WadlProxyConsts.HIPPY_OPEN_SCHEME);
    }

    public static boolean isInvalidResType(int i3) {
        com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar == null) {
            gVar = new com.tencent.gamecenter.wadl.biz.entity.g(IQQGameConfigService.KEY_CONF_COMM);
        }
        if ((i3 == 4 && !gVar.f106809v) || (i3 == 0 && !gVar.f106810w)) {
            return true;
        }
        return false;
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static boolean isNeedDownloadByAppId(String str, String str2, int i3, ArrayList<WadlResult> arrayList) {
        boolean z16 = true;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && arrayList != null && arrayList.size() != 0) {
            Iterator<WadlResult> it = arrayList.iterator();
            while (it.hasNext()) {
                WadlResult next = it.next();
                WadlParams wadlParams = next.wadlParams;
                if (str.equals(wadlParams.appId) && str2.equals(wadlParams.apkUrl) && i3 == wadlParams.versionCode && !TextUtils.isEmpty(next.downloadFilePath) && fileExists(next.downloadFilePath)) {
                    z16 = false;
                }
            }
        }
        return z16;
    }

    public static boolean isNeedFloatingPermissionAppid(String str) {
        List<String> list;
        ol0.a a16 = FloatingPermissionConfProcessor.a();
        if (a16 != null && (list = a16.f423085c) != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int isNeedFloatingPermissionType() {
        ol0.a a16 = FloatingPermissionConfProcessor.a();
        if (a16 != null) {
            return a16.f423083a;
        }
        return -1;
    }

    public static boolean isNeedInstallPermission() {
        ol0.a a16 = FloatingPermissionConfProcessor.a();
        if (a16 == null || a16.f423084b != 1) {
            return false;
        }
        return true;
    }

    public static boolean isPackageInstalled(@Nullable String str) {
        if (getPackageInfo(str) != null) {
            return true;
        }
        return false;
    }

    public static boolean isResExist(int i3, String str, String str2) {
        return fileExists(getDownloadResDir(str, i3) + "/" + str2);
    }

    public static boolean isSameDay(long j3, long j16, TimeZone timeZone) {
        long j17 = j3 - j16;
        if (j17 < 86400000 && j17 > -86400000 && millis2Days(j3, timeZone) == millis2Days(j16, timeZone)) {
            return true;
        }
        return false;
    }

    public static void jumpUrlOrSchema(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent();
            if (HttpUtil.isValidUrl(str)) {
                intent.putExtra("url", str);
                RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
                return;
            }
            try {
                intent.setData(Uri.parse(str));
                RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_JUMP);
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return;
            }
        }
        QLog.e(TAG, 1, "[jumpUrlOrSchema] url is empty or context isEmpty");
    }

    private static long millis2Days(long j3, TimeZone timeZone) {
        return (timeZone.getOffset(j3) + j3) / 86400000;
    }

    public static void putUnMatchUrl(String str) {
        UNMATCH_URL_CACHE.put(str, Boolean.TRUE);
    }

    public static void requestFloatingScreenPermission(String str) {
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 <= 28) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "sdk version lower android10,version is " + i3);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.e(TAG, 1, "requestFloatingScreenPermission dataJson is null");
                return;
            }
            String optString = new JSONObject(str).optString("appid");
            if (TextUtils.isEmpty(optString)) {
                QLog.e(TAG, 1, "requestFloatingScreenPermission appid is null");
                return;
            }
            if (isNeedFloatingPermissionType() == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "requestFloatingScreenPermission appid =" + optString);
                }
                if (isNeedFloatingPermissionAppid(optString)) {
                    showFloatingPermissionDialog(optString);
                    return;
                }
                QLog.e(TAG, 1, "Appid " + optString + " is not in config");
                return;
            }
            if (isNeedFloatingPermissionType() == 2) {
                showFloatingPermissionDialog(optString);
            } else if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "isNeedFloatingPermission is 0");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static boolean saveAppDetail(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            QLog.i(TAG, 1, "yuyue:saveAppDetail,appid:" + str + ",detail:" + str2 + ",keyPre:" + str3);
            return GameCenterSpUtils.writeToSp(str3 + str, str2);
        }
        return false;
    }

    public static boolean saveResAvilTime(long j3) {
        ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).writeToSpLong(GameCenterSpUtils.KEY_GAMECENTER_RES_TIME, j3);
        QLog.i(TAG, 1, "saveResAvilTime: ts=" + j3);
        return true;
    }

    public static void sendUseRemoveNotice() {
        Intent intent = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_ACTION);
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        intent.putExtra("key_event_id", 7);
        MobileQQ.sMobileQQ.sendBroadcast(intent);
    }

    public static void showFloatingPermissionDialog(String str) {
        if (!((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("559").setGameAppId(str).setOperId(WadlProxyConsts.OPER_ID_FLOAT_PERMISSION).setRetId(0).report();
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                try {
                    com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
                    String string = topActivity.getString(R.string.f209695g4);
                    String string2 = topActivity.getString(R.string.f209685g3);
                    if (gVar != null) {
                        if (!TextUtils.isEmpty(gVar.A)) {
                            string = gVar.A;
                        }
                        if (!TextUtils.isEmpty(gVar.B)) {
                            string2 = gVar.B;
                        }
                    }
                    if (gVar != null && gVar.f106792e == 1) {
                        QQCustomDialog qQCustomDialog = new QQCustomDialog(topActivity, R.style.qZoneInputDialog);
                        qQCustomDialog.setContentView(R.layout.f167834j4);
                        ImageView imageView = (ImageView) qQCustomDialog.findViewById(R.id.close);
                        qQCustomDialog.findViewById(R.id.bif).setVisibility(4);
                        qQCustomDialog.setCanceledOnTouchOutside(false);
                        qQCustomDialog.setTitle(string);
                        qQCustomDialog.setMessage(string2);
                        qQCustomDialog.setPositiveButton(topActivity.getString(R.string.f209675g2), new a(str, topActivity));
                        imageView.setOnClickListener(new b(qQCustomDialog));
                        qQCustomDialog.show();
                        return;
                    }
                    DialogUtil.createCustomDialog(topActivity, 230, string, string2, topActivity.getString(R.string.f209665g1), topActivity.getString(R.string.f209675g2), new c(str, topActivity), new d()).show();
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "showFloatingPermissionDialog exception", th5);
                }
            }
        }
    }

    public static JSONObject toJSONObject(WadlResult wadlResult) {
        JSONObject jSONObject = new JSONObject();
        if (wadlResult != null) {
            try {
                if (wadlResult.wadlParams != null) {
                    int convertRemoteStatusToLocal = convertRemoteStatusToLocal(wadlResult.taskStatus);
                    WadlParams wadlParams = wadlResult.wadlParams;
                    jSONObject.put("appid", wadlParams.appId);
                    jSONObject.put("downloadType", wadlParams.downloadType);
                    jSONObject.put("state", convertRemoteStatusToLocal);
                    jSONObject.put(WadlResult.WEB_KEY_PROGRESS, wadlResult.progress);
                    jSONObject.put(WadlResult.WEB_KEY_F_PROGRESS, wadlResult.floatProgress);
                    jSONObject.put("speed", wadlResult.speed);
                    jSONObject.put("packagename", wadlParams.packageName);
                    jSONObject.put("via", wadlParams.via);
                    jSONObject.put("mieActId", wadlParams.mieActId);
                    jSONObject.put(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK, wadlParams.getFlagEnable(1));
                    jSONObject.put(WadlResult.WEB_KEY_IS_RES, wadlParams.isRes);
                    jSONObject.put(WadlResult.WEB_KEY_WRITE_CODE_STATE, 0);
                    jSONObject.put("extraInfo", wadlParams.extraData);
                    jSONObject.put("versionCode", wadlParams.versionCode);
                    int wadlErrCode = getWadlErrCode(wadlResult.errCode);
                    jSONObject.put("errorCode", wadlErrCode);
                    jSONObject.put("errorMsg", getWadlErrMsg(wadlErrCode));
                    jSONObject.put("appName", wadlParams.appName);
                    jSONObject.put("iconUrl", wadlParams.iconUrl);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject toResJSONObject(WadlResult wadlResult) {
        JSONObject jSONObject = new JSONObject();
        if (wadlResult != null) {
            try {
                WadlParams wadlParams = wadlResult.wadlParams;
                if (wadlParams != null) {
                    jSONObject.put("appid", wadlParams.appId);
                    jSONObject.put("packagename", wadlParams.packageName);
                    jSONObject.put("state", convertRemoteStatusToLocal(wadlResult.taskStatus));
                    jSONObject.put(WadlResult.WEB_KEY_PROGRESS, wadlResult.progress);
                    jSONObject.put(WadlResult.WEB_KEY_F_PROGRESS, wadlResult.floatProgress);
                    jSONObject.put("speed", wadlResult.speed);
                    jSONObject.put("via", wadlParams.via);
                    jSONObject.put("versionCode", wadlParams.versionCode);
                    jSONObject.put(WadlResult.WEB_KEY_RES_MD5, wadlParams.resMD5);
                    jSONObject.put("resVersionName", wadlParams.resVersionName);
                    jSONObject.put("resName", wadlParams.resName);
                    int wadlErrCode = getWadlErrCode(wadlResult.errCode);
                    jSONObject.put("errorCode", wadlErrCode);
                    jSONObject.put("errorMsg", getWadlErrMsg(wadlErrCode));
                    jSONObject.put("appName", wadlParams.appName);
                    jSONObject.put("iconUrl", wadlParams.iconUrl);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static void goToInstall(String str, String str2, String str3, String str4, String str5, boolean z16) {
        IQQGameNoticeService iQQGameNoticeService;
        QLog.d(TAG, 1, "goToInstall appid=" + str + ",pkgName=" + str2 + ",path=" + str3 + ",sourceId=" + str4 + ",callFrom=" + str5);
        if (MobileQQ.sProcessId == 1) {
            boolean doInstall = doInstall(str, str2, str3, str4, str5, z16);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            IQQGameDownloadService iQQGameDownloadService = (IQQGameDownloadService) peekAppRuntime.getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI);
            if (iQQGameDownloadService != null) {
                iQQGameDownloadService.reportInstallRequest(str, isForeground());
            }
            if (!doInstall || (iQQGameNoticeService = (IQQGameNoticeService) peekAppRuntime.getRuntimeService(IQQGameNoticeService.class, "all")) == null) {
                return;
            }
            iQQGameNoticeService.onRequestInstall(str);
            return;
        }
        WadlQIPCConnector.getInstance().checkConnect();
        Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        bundle.putString("packageName", str2);
        bundle.putString(WadlProxyConsts.PARAM_LOCAL_APK_PATH, str3);
        bundle.putString("sourceId", str4);
        bundle.putString("actionFrom", str5);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_INSTALL_APK, bundle);
        if (callServer == null || callServer.code != 0) {
            doInstall(str, str2, str3, str4, str5, z16);
        }
    }

    public static void handleQueryResult(WadlResult wadlResult) {
        try {
            if (InstalledAppListMonitor.getPackageInfo(MobileQQ.sMobileQQ.getPackageManager(), wadlResult.wadlParams.packageName.trim(), 0) == null || wadlResult.taskStatus == 9) {
                return;
            }
            wadlResult.taskStatus = 9;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleQueryResult e=" + e16.toString());
        }
    }
}
