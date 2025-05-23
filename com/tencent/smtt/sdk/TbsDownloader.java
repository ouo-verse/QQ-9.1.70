package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.Timer;
import com.tencent.smtt.utils.g;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.video.decode.AVDecodeError;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsDownloader {
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";

    /* renamed from: a, reason: collision with root package name */
    static boolean f369089a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f369090b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Context f369091c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Handler f369092d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f369093e = null;

    /* renamed from: f, reason: collision with root package name */
    private static final Object f369094f = new byte[0];

    /* renamed from: g, reason: collision with root package name */
    private static l f369095g = null;

    /* renamed from: h, reason: collision with root package name */
    private static HandlerThread f369096h = null;

    /* renamed from: i, reason: collision with root package name */
    private static int f369097i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f369098j = false;

    /* renamed from: k, reason: collision with root package name */
    private static String f369099k = "";

    /* renamed from: l, reason: collision with root package name */
    private static String f369100l = "";

    /* renamed from: m, reason: collision with root package name */
    private static boolean f369101m = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f369102n = false;

    /* renamed from: o, reason: collision with root package name */
    private static JSONObject f369103o = null;

    /* renamed from: p, reason: collision with root package name */
    private static JSONObject f369104p = null;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f369105q = false;

    /* renamed from: r, reason: collision with root package name */
    private static int f369106r = 0;

    /* renamed from: s, reason: collision with root package name */
    private static int f369107s = 0;

    /* renamed from: t, reason: collision with root package name */
    private static JSONObject f369108t = null;

    /* renamed from: u, reason: collision with root package name */
    private static long f369109u = -1;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z16, int i3);
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static synchronized void d() {
        synchronized (TbsDownloader.class) {
            if (f369096h == null) {
                f369096h = TbsHandlerThread.getInstance();
                try {
                    f369095g = new l(f369091c);
                    f369092d = new Handler(f369096h.getLooper()) { // from class: com.tencent.smtt.sdk.TbsDownloader.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            boolean z16;
                            boolean z17;
                            String str;
                            boolean z18;
                            int i3 = message.what;
                            if (i3 != 109) {
                                if (i3 != 110) {
                                    switch (i3) {
                                        case 100:
                                            if (message.arg1 == 1) {
                                                z16 = true;
                                            } else {
                                                z16 = false;
                                            }
                                            if (message.arg2 == 1) {
                                                z17 = true;
                                            } else {
                                                z17 = false;
                                            }
                                            boolean b16 = TbsDownloader.b(true, false, false, z17);
                                            Object obj = message.obj;
                                            if (obj != null && (obj instanceof TbsDownloaderCallback)) {
                                                TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + b16);
                                                if (TbsDownloader.f369091c != null && TbsDownloader.f369091c.getApplicationContext() != null && TbsDownloader.f369091c.getApplicationContext().getApplicationInfo() != null) {
                                                    str = TbsDownloader.f369091c.getApplicationContext().getApplicationInfo().packageName;
                                                } else {
                                                    str = "";
                                                }
                                                if (b16 && !z16) {
                                                    if ("com.tencent.mm".equals(str) || "com.tencent.mobileqq".equals(str)) {
                                                        TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + b16);
                                                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(b16, TbsDownloadConfig.getInstance(TbsDownloader.f369091c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                                    }
                                                } else {
                                                    ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(b16, TbsDownloadConfig.getInstance(TbsDownloader.f369091c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                                }
                                            }
                                            if (TbsShareManager.isThirdPartyApp(TbsDownloader.f369091c) && b16) {
                                                TbsDownloader.startDownload(TbsDownloader.f369091c);
                                                return;
                                            }
                                            return;
                                        case 101:
                                            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(TbsDownloader.f369091c);
                                            if (Apn.getApnType(TbsDownloader.f369091c) != 3 && !QbSdk.canDownloadWithoutWifi()) {
                                                TbsLog.i(TbsDownloader.LOGTAG, "not wifi,no need send request");
                                                tbsDownloadConfig.setDownloadInterruptCode(-220);
                                                QbSdk.f369006p.onDownloadFinish(111);
                                                QbSdk.f369006p.onInstallFinish(243);
                                                return;
                                            }
                                            TbsLog.i(TbsDownloader.LOGTAG, "---getting download file lock...");
                                            FileOutputStream b17 = FileUtil.b(TbsDownloader.f369091c, true, "tbs_download_lock_file");
                                            if (b17 != null) {
                                                FileLock a16 = FileUtil.a(TbsDownloader.f369091c, b17);
                                                if (a16 == null) {
                                                    TbsLog.i(TbsDownloader.LOGTAG, "download file-lock locked, core is downloading");
                                                    tbsDownloadConfig.setDownloadInterruptCode(-203);
                                                    FileUtil.a(b17);
                                                    if (QbSdk.c() != null) {
                                                        TbsDownloader.a(TbsDownloader.f369091c, new Runnable() { // from class: com.tencent.smtt.sdk.TbsDownloader.1.1
                                                            @Override // java.lang.Runnable
                                                            public void run() {
                                                                QbSdk.f369006p.onDownloadFinish(177);
                                                                QbSdk.f369006p.onInstallFinish(243);
                                                            }
                                                        });
                                                        return;
                                                    } else {
                                                        QbSdk.f369006p.onDownloadFinish(177);
                                                        QbSdk.f369006p.onInstallFinish(243);
                                                        return;
                                                    }
                                                }
                                                if (message.arg1 == 1) {
                                                    z18 = true;
                                                } else {
                                                    z18 = false;
                                                }
                                                if (TbsDownloader.b(false, z18, false, true)) {
                                                    if (tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                                                        TbsDownloadConfig.getInstance(TbsDownloader.f369091c).setDownloadInterruptCode(-215);
                                                        TbsLog.i(TbsDownloader.LOGTAG, "start download in apk downloader...");
                                                        TbsDownloader.f369095g.a(z18, false);
                                                    } else {
                                                        tbsDownloadConfig.setDownloadInterruptCode(ExportErrorStatus.STOP_AUDIO_ENCODE);
                                                        QbSdk.f369006p.onDownloadFinish(154);
                                                        QbSdk.f369006p.onInstallFinish(243);
                                                    }
                                                } else {
                                                    int currentDownloadInterruptCode = TbsDownloadConfig.getInstance(TbsDownloader.f369091c).getCurrentDownloadInterruptCode();
                                                    TbsLog.i(TbsDownloader.LOGTAG, "No need to download, code is " + currentDownloadInterruptCode);
                                                    QbSdk.f369006p.onDownloadFinish(currentDownloadInterruptCode);
                                                    QbSdk.f369006p.onInstallFinish(243);
                                                }
                                                TbsLog.i(TbsDownloader.LOGTAG, "------freeDownloadFileLock...");
                                                FileUtil.a(a16, b17);
                                                return;
                                            }
                                            tbsDownloadConfig.setDownloadInterruptCode(-204);
                                            QbSdk.f369006p.onDownloadFinish(153);
                                            QbSdk.f369006p.onInstallFinish(243);
                                            TbsLog.w(TbsDownloader.LOGTAG, "download file-lock file io exception");
                                            return;
                                        case 102:
                                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                            int k3 = n.a().k(TbsDownloader.f369091c);
                                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + k3);
                                            TbsDownloader.f369095g.b(k3);
                                            TbsLogReport.getInstance(TbsDownloader.f369091c).dailyReport();
                                            return;
                                        case 103:
                                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                            if (message.arg1 == 0) {
                                                n.a().a((Context) message.obj, true);
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                if (TbsDownloader.f369091c != null) {
                                    TbsDownloadConfig.getInstance(TbsDownloader.f369091c).saveDownloadInterruptCode();
                                    return;
                                }
                                return;
                            }
                            if (TbsDownloader.f369095g != null) {
                                TbsDownloader.f369095g.e();
                            }
                        }
                    };
                } catch (Exception e16) {
                    f369098j = true;
                    TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception, " + Log.getStackTraceString(e16));
                }
            }
        }
    }

    private static boolean e() {
        try {
            return TbsDownloadConfig.getInstance(f369091c).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(f().toString());
        } catch (Exception unused) {
            return false;
        }
    }

    private static JSONArray f() {
        if (TbsShareManager.isThirdPartyApp(f369091c)) {
            JSONArray jSONArray = new JSONArray();
            int tbsVersion = QbSdk.getTbsVersion(f369091c);
            if (tbsVersion > 0) {
                jSONArray.put(tbsVersion);
            }
            return jSONArray;
        }
        return null;
    }

    private static boolean g() {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f369091c);
        if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            tbsDownloadConfig.setDownloadInterruptCode(AVDecodeError.JNI_BITMAP_STRIDE_ERR);
            return false;
        }
        if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            tbsDownloadConfig.setDownloadInterruptCode(AVDecodeError.AUDIO_DATA_DECODE_FINISH);
            return false;
        }
        if (!FileUtil.b(f369091c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            tbsDownloadConfig.setDownloadInterruptCode(-117);
            return false;
        }
        if (System.currentTimeMillis() - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0L) <= 86400000) {
            long j3 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j3);
            if (j3 >= tbsDownloadConfig.getDownloadMaxflow()) {
                TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                tbsDownloadConfig.setDownloadInterruptCode(-120);
                return false;
            }
        }
        return true;
    }

    public static String getBackupFileName(boolean z16) {
        return getBackupFileName(z16, 0);
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return n.a().f(f369091c);
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        return n.a().f(context);
    }

    public static int getNextPostInterval(Context context) {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        long j3 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
        return Math.max((int) (((tbsDownloadConfig.getRetryInterval() * 1000) - (System.currentTimeMillis() - j3)) / 1000), 0);
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z16;
        synchronized (TbsDownloader.class) {
            if (!f369102n) {
                f369102n = true;
                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
                if (tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                    f369101m = tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + f369101m);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + f369101m);
            }
            z16 = f369101m;
        }
        return z16;
    }

    public static long getRetryIntervalInSeconds() {
        return f369109u;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return f369096h;
    }

    private static void h() {
        File file = new File(n.o(f369091c), "switch_disable_check");
        if (!file.exists()) {
            try {
                TbsLog.i(LOGTAG, "addSwitchDisableCheckFlag status: " + file.createNewFile());
            } catch (IOException e16) {
                TbsLog.i(LOGTAG, "" + e16);
            }
        }
    }

    private static void i() {
        Handler handler = f369092d;
        if (handler != null) {
            handler.obtainMessage(110).sendToTarget();
        }
    }

    public static boolean isDownloadForeground() {
        l lVar = f369095g;
        if (lVar != null && lVar.c()) {
            return true;
        }
        return false;
    }

    public static synchronized boolean isDownloading() {
        boolean z16;
        synchronized (TbsDownloader.class) {
            TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + f369089a);
            z16 = f369089a;
        }
        return z16;
    }

    public static boolean isTbsCoreDisabledBySwitch(Context context, int i3) {
        return new File(n.o(context), "tbs_switch_disable_" + i3).exists();
    }

    public static boolean needDownload(Context context, boolean z16) {
        return needDownload(context, z16, false, true, null);
    }

    public static boolean needDownloadDecoupleCore() {
        int i3;
        if (TbsShareManager.isThirdPartyApp(f369091c) || a(f369091c)) {
            return false;
        }
        if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(f369091c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) < TbsDownloadConfig.getInstance(f369091c).getRetryInterval() * 1000 || (i3 = TbsDownloadConfig.getInstance(f369091c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0)) <= 0 || i3 == n.a().f(f369091c) || TbsDownloadConfig.getInstance(f369091c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) == i3) {
            return false;
        }
        return true;
    }

    public static void pauseDownload() {
        TbsLog.i(LOGTAG, "called pauseDownload,downloader=" + f369095g);
        l lVar = f369095g;
        if (lVar != null) {
            lVar.d();
        }
    }

    public static void resumeDownload() {
        TbsLog.i(LOGTAG, "called resumeDownload,downloader=" + f369095g);
        Handler handler = f369092d;
        if (handler != null) {
            handler.removeMessages(109);
            f369092d.sendEmptyMessage(109);
        }
    }

    public static void setAppContext(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            f369091c = context.getApplicationContext();
        }
    }

    public static void setRetryIntervalInSeconds(Context context, long j3) {
        if (context == null) {
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            f369109u = j3;
        }
        TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + f369109u);
    }

    public static void setTbsCoreDisabledBySwitch(Context context, int i3) {
        File file = new File(n.o(context), "tbs_switch_disable_" + i3);
        if (!file.exists()) {
            try {
                TbsLog.i(LOGTAG, "setTbsCoreDisabledBySwitch status: " + file.createNewFile());
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Deprecated
    public static boolean startDecoupleCoreIfNeeded() {
        return false;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static void stopDownload() {
        if (f369098j) {
            return;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
        l lVar = f369095g;
        if (lVar != null) {
            lVar.a();
        }
        Handler handler = f369092d;
        if (handler != null) {
            handler.removeMessages(100);
            f369092d.removeMessages(101);
            f369092d.removeMessages(108);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(final boolean z16, boolean z17, boolean z18, boolean z19) {
        boolean z26;
        final TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f369091c);
        Map<String, Object> map = QbSdk.f369007q;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f369007q.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            tbsDownloadConfig.setDownloadInterruptCode(ExportErrorStatus.STOP_MUXER);
            return false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z16 + " forDecoupleCore is " + z18);
        if (n.a().c(f369091c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            tbsDownloadConfig.setDownloadInterruptCode(ExportErrorStatus.STOP_VIDEO_ENCODE);
            return false;
        }
        if (f369093e == null) {
            String deviceCpuabi = AppUtil.getDeviceCpuabi();
            f369093e = deviceCpuabi;
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, deviceCpuabi);
            tbsDownloadConfig.commit();
        }
        if (!TextUtils.isEmpty(f369093e) && !AppUtil.isCpuValid(f369093e)) {
            tbsDownloadConfig.setDownloadInterruptCode(-104);
            TbsLog.i(LOGTAG, "TbsDownloader sendRequest cpu is invalid:" + f369093e);
            return false;
        }
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, AppUtil.getAppVersionName(f369091c));
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(AppUtil.getAppVersionCode(f369091c)));
        tbsDownloadConfig.commit();
        JSONObject a16 = a(z16, z17, z18);
        int optInt = a16.optInt("TBSV", -1);
        if (optInt != -1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbsShareManager.isThirdPartyApp(f369091c)) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(currentTimeMillis - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L) < tbsDownloadConfig.getRetryInterval() * 1000 ? tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L) + 1 : 1L));
            }
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(currentTimeMillis));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, AppUtil.getAppVersionName(f369091c));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(AppUtil.getAppVersionCode(f369091c)));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, AppUtil.getAppMetadata(f369091c, TBS_METADATA));
            tbsDownloadConfig.commit();
        }
        if (optInt == -1 && !z18) {
            tbsDownloadConfig.setDownloadInterruptCode(-113);
            z26 = false;
        } else {
            try {
                String d16 = com.tencent.smtt.utils.p.a(f369091c).d();
                TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=" + d16);
                if (z16) {
                    f369103o = a16;
                } else {
                    f369104p = a16;
                }
                if (z16) {
                    return true;
                }
                z26 = false;
                try {
                    String a17 = com.tencent.smtt.utils.g.a(d16, a16.toString().getBytes("utf-8"), new g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.2
                        @Override // com.tencent.smtt.utils.g.a
                        public void a(int i3) {
                            TbsDownloadConfig.this.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
                            TbsDownloadConfig.this.commit();
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i3);
                            if (TbsShareManager.isThirdPartyApp(TbsDownloader.f369091c) && i3 == 200) {
                                TbsDownloadConfig.this.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, Long.valueOf(System.currentTimeMillis()));
                                TbsDownloadConfig.this.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                                TbsDownloadConfig.this.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                                TbsDownloadConfig.this.commit();
                            }
                            if (i3 >= 300) {
                                if (z16) {
                                    TbsDownloadConfig.this.setDownloadInterruptCode(-107);
                                } else {
                                    TbsDownloadConfig.this.setDownloadInterruptCode(-207);
                                }
                            }
                        }
                    }, false);
                    if (!TextUtils.isEmpty(a17) && a17.contains("HttpError")) {
                        TbsLog.i(LOGTAG, "Cfg Request error: " + a17);
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f369091c).tbsLogInfo();
                        tbsLogInfo.setErrorCode(-129);
                        tbsLogInfo.setFailDetail(a17);
                        TbsLogReport.getInstance(f369091c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    }
                    return a(a17, optInt, z16, z17, z19);
                } catch (Throwable th5) {
                    th = th5;
                    TbsLog.i(LOGTAG, "sendrequest return false " + Log.getStackTraceString(th));
                    th.printStackTrace();
                    tbsDownloadConfig.setDownloadInterruptCode(-106);
                    return z26;
                }
            } catch (Throwable th6) {
                th = th6;
                z26 = false;
            }
        }
        return z26;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    public static void c(Context context) {
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        l.b(context);
        context.getSharedPreferences("tbs_extension_config", 4).edit().clear().commit();
        context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit().clear().commit();
    }

    public static String getBackupFileName(boolean z16, int i3) {
        boolean is64BitImpl;
        if (i3 == 64) {
            is64BitImpl = true;
        } else {
            is64BitImpl = i3 == 32 ? false : AppUtil.is64BitImpl();
        }
        return z16 ? is64BitImpl ? "x5.tbs.decouple.64" : "x5.tbs.decouple" : is64BitImpl ? "x5.tbs.org.64" : "x5.tbs.org";
    }

    public static boolean needDownload(Context context, boolean z16, boolean z17, TbsDownloaderCallback tbsDownloaderCallback) {
        return needDownload(context, z16, z17, true, tbsDownloaderCallback);
    }

    public static synchronized void startDownload(Context context, boolean z16) {
        synchronized (TbsDownloader.class) {
            int i3 = 1;
            if (TbsShareManager.isThirdPartyApp(context)) {
                int i16 = f369097i + 1;
                f369097i = i16;
                if (i16 > 1) {
                    TbsLog.w(LOGTAG, "[Warning] for privacy security, TBS Only allow startDownload 1 times each process");
                    QbSdk.f369006p.onDownloadFinish(127);
                    return;
                }
            }
            if (QbSdk.d()) {
                TbsLog.w(LOGTAG, "[warning] using private CDN mode, default downloader can not startDownload.");
                QbSdk.f369006p.onDownloadFinish(135);
                return;
            }
            Context applicationContext = context.getApplicationContext();
            f369091c = applicationContext;
            TbsLog.initIfNeed(applicationContext);
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f369091c);
            tbsDownloadConfig.setDownloadInterruptCode(-200);
            TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f369091c);
            if (n.f369419a) {
                tbsDownloadConfig.setDownloadInterruptCode(-130);
                QbSdk.f369006p.onDownloadFinish(151);
                return;
            }
            n.a().b(context, g.f369355a == 0);
            int b16 = n.a().b(context);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],renameRet=" + b16);
            if (b16 < 0) {
                tbsDownloadConfig.setDownloadInterruptCode(-128);
                QbSdk.f369006p.onDownloadFinish(152);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needReNameFile=" + b16);
                return;
            }
            f369089a = true;
            d();
            if (f369098j) {
                tbsDownloadConfig.setDownloadInterruptCode(-202);
                QbSdk.f369006p.onDownloadFinish(121);
                return;
            }
            if (z16) {
                stopDownload();
            }
            f369092d.removeMessages(101);
            f369092d.removeMessages(100);
            Message obtain = Message.obtain(f369092d, 101, QbSdk.f369006p);
            if (!z16) {
                i3 = 0;
            }
            obtain.arg1 = i3;
            obtain.sendToTarget();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(Context context, boolean z16, boolean z17) {
        String str;
        boolean z18;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        if (!z16) {
            String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i3 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null);
            String appVersionName = AppUtil.getAppVersionName(f369091c);
            int appVersionCode = AppUtil.getAppVersionCode(f369091c);
            String appMetadata = AppUtil.getAppMetadata(f369091c, TBS_METADATA);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + appVersionName + " oldAppVersionName=" + string + " appVersionCode=" + appVersionCode + " oldAppVersionCode=" + i3 + " appMetadata=" + appMetadata + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
            sb5.append(j3);
            sb5.append(" timeNow=");
            sb5.append(currentTimeMillis);
            TbsLog.i(LOGTAG, sb5.toString());
            if (z17) {
                boolean contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK);
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + contains);
                if (contains && j3 == 0) {
                    j3 = currentTimeMillis;
                }
            }
            long j16 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, 0L);
            long j17 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
            long retryInterval = tbsDownloadConfig.getRetryInterval();
            TbsLog.i(LOGTAG, "retryInterval = " + retryInterval + " s");
            TbsPVConfig.releaseInstance();
            int emergentCoreVersion = TbsPVConfig.getInstance(f369091c).getEmergentCoreVersion();
            int i16 = TbsDownloadConfig.getInstance(f369091c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            long j18 = currentTimeMillis - j3;
            long j19 = retryInterval * 1000;
            if (j18 > j19) {
                TbsLog.i(LOGTAG, "needSendRequest  true  #1");
            } else if (emergentCoreVersion > n.a().g(f369091c) && emergentCoreVersion > i16) {
                TbsLog.i(LOGTAG, "emergentCoreVersion is " + emergentCoreVersion + " getTbsCoreInstalledVerInNolock is " + n.a().g(f369091c) + " responseCoreVersion is " + i16);
            } else if (TbsShareManager.isThirdPartyApp(f369091c) && j16 > 0 && currentTimeMillis - j16 > j19 && j17 < 11) {
                TbsLog.i(LOGTAG, "needSendRequest  true  #3");
            } else {
                if (!TbsShareManager.isThirdPartyApp(f369091c) || QbSdk.getTbsVersion(f369091c) != 0 || e()) {
                    if (appVersionName != null && appVersionCode != 0 && appMetadata != null) {
                        if (!appVersionName.equals(string) || appVersionCode != i3 || !appMetadata.equals(string2)) {
                            TbsLog.i(LOGTAG, "needSendRequest  true  #5");
                        }
                    } else if (TbsShareManager.isThirdPartyApp(f369091c)) {
                        str = "timeNow - timeLastCheck is " + j18 + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + appVersionName + " appVersionCode is " + appVersionCode + " appMetadata is " + appMetadata + " oldAppVersionName is " + string + " oldAppVersionCode is " + i3 + " oldAppVersionMetadata is " + string2;
                        z18 = false;
                        if (!z18 && TbsShareManager.isThirdPartyApp(f369091c)) {
                            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f369091c).tbsLogInfo();
                            tbsLogInfo.setErrorCode(-119);
                            tbsLogInfo.setFailDetail(str);
                            TbsLogReport.getInstance(f369091c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                        }
                        return z18;
                    }
                    z18 = false;
                    str = null;
                    if (!z18) {
                        TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(f369091c).tbsLogInfo();
                        tbsLogInfo2.setErrorCode(-119);
                        tbsLogInfo2.setFailDetail(str);
                        TbsLogReport.getInstance(f369091c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                    }
                    return z18;
                }
                TbsLog.i(LOGTAG, "needSendRequest  true  #4");
                n.a().d(f369091c);
            }
        } else {
            TbsLog.i(LOGTAG, "needSendRequest true download foreground, stack: " + Log.getStackTraceString(new Throwable()));
        }
        z18 = true;
        str = null;
        if (!z18) {
        }
        return z18;
    }

    public static boolean needDownload(Context context, boolean z16, boolean z17, boolean z18, TbsDownloaderCallback tbsDownloaderCallback) {
        TbsShareManager.mHasQueried = true;
        Context applicationContext = context.getApplicationContext();
        f369091c = applicationContext;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(applicationContext);
        tbsDownloadConfig.setDownloadInterruptCode(-100);
        TbsLog.initIfNeed(context);
        TbsLog.i(LOGTAG, "needDownload,process=" + QbSdk.getCurrentProcessName(context) + "stack=" + Log.getStackTraceString(new Throwable()));
        n.a().b(context, g.f369355a == 0);
        int b16 = n.a().b(context);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],renameRet=" + b16);
        if (b16 != 0) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.f369131a = 129;
            tbsLogInfo.setFailDetail("code=2" + b16);
        }
        if (b16 < 0) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needReNameFile=" + b16);
            tbsDownloadConfig.setDownloadInterruptCode(-128);
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z16 + ",isDownloadForeground=" + z17);
        if (n.f369419a) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1 Static Installing, return false");
            tbsDownloadConfig.setDownloadInterruptCode(-130);
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        if (!a(f369091c, z16)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2 Not shouldDoNeedDownload, return false");
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        d();
        if (f369098j) {
            tbsDownloadConfig.setDownloadInterruptCode(-105);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3 TbsApkDownloader init Exception, return false");
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        boolean a16 = a(f369091c, z17, false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=" + a16);
        if (a16) {
            a(z17, tbsDownloaderCallback, z18);
            tbsDownloadConfig.setDownloadInterruptCode(AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR);
        } else {
            tbsDownloadConfig.setDownloadInterruptCode(-122);
        }
        f369092d.removeMessages(102);
        Message.obtain(f369092d, 102).sendToTarget();
        boolean contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + contains);
        boolean z19 = (contains || TbsShareManager.isThirdPartyApp(context)) ? tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z19 + ",hasNeedDownloadKey=" + contains);
        if (z19) {
            if (!g()) {
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
                z19 = false;
            } else {
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] NEEDDOWNLOAD_WILL_STARTDOWNLOAD");
            }
        } else {
            int k3 = n.a().k(f369091c);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + k3 + ",needSendRequest=" + a16);
            if (a16 || k3 <= 0) {
                f369092d.removeMessages(103);
                if (k3 <= 0 && !a16) {
                    Message.obtain(f369092d, 103, 0, 0, f369091c).sendToTarget();
                }
            }
        }
        if (!a16 && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(z19, 0);
        }
        i();
        return z19;
    }

    private static boolean a(Context context, boolean z16) {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
        f369093e = string;
        if (TextUtils.isEmpty(string) || AppUtil.isCpuValid(f369093e)) {
            return true;
        }
        TbsLog.e(LOGTAG, "can not support x86 devices!!");
        tbsDownloadConfig.setDownloadInterruptCode(-104);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context) {
        if (!TextUtils.isEmpty(f369090b)) {
            return f369090b;
        }
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        try {
            str = new String(str.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (str == null) {
            stringBuffer.append("1.0");
        } else if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String a16 = com.tencent.smtt.utils.r.a(context);
            try {
                a16 = new String(a16.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception unused2) {
            }
            if (a16 == null) {
                stringBuffer.append("; ");
            } else if (a16.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(a16);
            }
        }
        String str2 = Build.ID;
        if (str2 == null) {
            str2 = "";
        }
        String replaceAll = str2.replaceAll("[\u4e00-\u9fa5]", "");
        if (replaceAll == null) {
            stringBuffer.append(" Build/");
            stringBuffer.append("00");
        } else if (replaceAll.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(replaceAll);
        }
        String format = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
        f369090b = format;
        return format;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        return TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
    }

    private static void a(boolean z16, TbsDownloaderCallback tbsDownloaderCallback, boolean z17) {
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        f369092d.removeMessages(100);
        Message obtain = Message.obtain(f369092d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = z16 ? 1 : 0;
        obtain.arg2 = z17 ? 1 : 0;
        obtain.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, int i3) {
        return Build.VERSION.SDK_INT > 28 && context.getApplicationInfo().targetSdkVersion > 28 && i3 > 0 && i3 < 45114;
    }

    private static JSONObject a(boolean z16, boolean z17, boolean z18) {
        int k3;
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z16 + " forDecoupleCore is " + z18);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f369091c);
        String b16 = b(f369091c);
        String imsi = AppUtil.getImsi(f369091c);
        String sdkuid = AppUtil.getSDKUID(f369091c);
        String androidID = AppUtil.getAndroidID(f369091c);
        String id5 = TimeZone.getDefault().getID();
        String str = id5 != null ? id5 : "";
        try {
            if (((TelephonyManager) f369091c.getSystemService("phone")) != null) {
                id5 = "cn";
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (id5 == null) {
            id5 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (m.a(f369091c).c("tpatch_num") < 5) {
                if (TbsShareManager.isThirdPartyApp(f369091c)) {
                    jSONObject.put("REQUEST_TPATCH", 2);
                } else {
                    jSONObject.put("REQUEST_TPATCH", 1);
                }
            } else {
                jSONObject.put("REQUEST_TPATCH", 0);
            }
            jSONObject.put("TIMEZONEID", str);
            jSONObject.put("COUNTRYISO", id5);
            if (AppUtil.is64BitImpl()) {
                jSONObject.put("REQUEST_64", 1);
            }
            jSONObject.put("PROTOCOLVERSION", 1);
            if (TbsShareManager.isThirdPartyApp(f369091c)) {
                k3 = n.a().k(f369091c);
            } else {
                if (z18) {
                    k3 = n.a().g(f369091c);
                } else {
                    k3 = n.a().k(f369091c);
                }
                if (k3 == 0 && n.a().j(f369091c)) {
                    if ("com.tencent.mobileqq".equals(f369091c.getApplicationInfo().packageName)) {
                        TbsPVConfig.releaseInstance();
                        if (TbsPVConfig.getInstance(f369091c).getLocalCoreVersionMoreTimes() == 1) {
                            k3 = n.a().g(f369091c);
                        }
                    }
                    k3 = -1;
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + k3 + " isDownloadForeground=" + z17);
                if (z17 && !n.a().j(f369091c)) {
                    k3 = 0;
                }
            }
            if (z16) {
                jSONObject.put("FUNCTION", 2);
            } else {
                jSONObject.put("FUNCTION", k3 == 0 ? 0 : 1);
            }
            if (TbsShareManager.isThirdPartyApp(f369091c)) {
                JSONArray f16 = f();
                jSONObject.put("TBSVLARR", f16);
                f369099k = f16.toString();
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, f16.toString());
                tbsDownloadConfig.commit();
                if (QbSdk.f368994d) {
                    jSONObject.put("THIRDREQ", 1);
                }
            }
            jSONObject.put("APPN", f369091c.getPackageName());
            jSONObject.put("APPVN", a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 44357);
            jSONObject.put("TBSV", k3);
            if (k3 == 0) {
                jSONObject.put("ISFORCE", true);
            }
            f369100l = "" + k3;
            jSONObject.put("DOWNLOADDECOUPLECORE", z18 ? 1 : 0);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z18 ? 1 : 0));
            tbsDownloadConfig.commit();
            if (k3 != 0) {
                jSONObject.put("TBSBACKUPV", 0);
            }
            jSONObject.put(PreDownloadConstants.RPORT_KEY_CPU, f369093e);
            jSONObject.put("UA", b16);
            jSONObject.put("IMSI", a(imsi));
            jSONObject.put(Global.TRACKING_IMEI, a(sdkuid));
            jSONObject.put("ANDROID_ID", a(androidID));
            jSONObject.put("GUID", AppUtil.getGuid(f369091c));
            if (!TbsShareManager.isThirdPartyApp(f369091c)) {
                if (k3 != 0) {
                    jSONObject.put(CommonConstant.RETKEY.STATUS, QbSdk.a(f369091c, k3) ? 0 : 1);
                } else {
                    jSONObject.put(CommonConstant.RETKEY.STATUS, 0);
                }
                int f17 = n.a().f(f369091c);
                jSONObject.put("TBSDV", k3 % 10000);
                jSONObject.put("TBSBACKUPV", f17);
            }
            boolean z19 = TbsDownloadConfig.getInstance(f369091c).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
            Object a16 = QbSdk.a(f369091c, "can_unlzma", (Bundle) null);
            if ((a16 == null || !(a16 instanceof Boolean)) ? false : ((Boolean) a16).booleanValue() ? !z19 : false) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (getOverSea(f369091c)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z17) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (Exception unused) {
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    @TargetApi(11)
    private static boolean a(String str, int i3, boolean z16, boolean z17, boolean z18) throws Exception {
        long j3;
        int i16;
        JSONObject jSONObject;
        String str2;
        boolean z19;
        Integer num;
        int tbsVersion;
        TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] response=" + str + ";isNeedInstall=" + z18);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f369091c);
        if (TextUtils.isEmpty(str)) {
            tbsDownloadConfig.setDownloadInterruptCode(AVDecodeError.VIDEO_DECODE_V_ERR);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #1,response is empty...");
            return false;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        int i17 = jSONObject2.getInt("RET");
        if (i17 != 0) {
            tbsDownloadConfig.setDownloadInterruptCode(AVDecodeError.VIDEO_DECODE_A_ERR);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #2,returnCode=" + i17);
            return false;
        }
        int i18 = jSONObject2.getInt("RESPONSECODE");
        String string = jSONObject2.getString("DOWNLOADURL");
        String optString = jSONObject2.optString("URLLIST", "");
        int i19 = jSONObject2.getInt("TBSAPKSERVERVERSION");
        if (QbSdk.b(f369091c, i19)) {
            tbsDownloadConfig.setDownloadInterruptCode(Constants.BINARY_PERF_STATS);
            return false;
        }
        int i26 = jSONObject2.getInt("DOWNLOADMAXFLOW") * 2;
        int i27 = jSONObject2.getInt("DOWNLOAD_MIN_FREE_SPACE");
        int i28 = jSONObject2.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
        int i29 = jSONObject2.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
        long j16 = jSONObject2.getLong("DOWNLOAD_SINGLE_TIMEOUT");
        long j17 = jSONObject2.getLong("TBSAPKFILESIZE");
        long optLong = jSONObject2.optLong("RETRY_INTERVAL", 0L);
        int optInt = jSONObject2.optInt("FLOWCTR", -1);
        int optInt2 = jSONObject2.optInt("USEX5", 1);
        h();
        a();
        if (optInt2 == 0 && (tbsVersion = QbSdk.getTbsVersion(f369091c)) != 0) {
            setTbsCoreDisabledBySwitch(f369091c, tbsVersion);
        }
        try {
            if (!TextUtils.isEmpty(string)) {
                string.contains("" + i19);
            }
            j3 = j16;
            i16 = i29;
        } catch (Throwable th5) {
            j3 = j16;
            StringBuilder sb5 = new StringBuilder();
            i16 = i29;
            sb5.append("throwable is ");
            sb5.append(Log.getStackTraceString(th5));
            TbsLog.i(LOGTAG, sb5.toString());
        }
        int optInt3 = jSONObject2.optInt("USEBBACKUPVER", 0);
        try {
            optInt3 = jSONObject2.getInt("USEBBACKUPVER");
        } catch (Exception unused) {
        }
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, Integer.valueOf(optInt3));
        String optString2 = jSONObject2.optString("PKGMD5", null);
        int optInt4 = jSONObject2.optInt("RESETX5", 0);
        jSONObject2.optInt("UPLOADLOG", 0);
        jSONObject2.optInt("RESETDECOUPLECORE", 0);
        String optString3 = jSONObject2.optString("SETTOKEN", "");
        boolean z26 = jSONObject2.optInt("RESETTOKEN", 0) != 0;
        boolean z27 = jSONObject2.optInt("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT", 1) != 0;
        int optInt5 = jSONObject2.optInt("RESETTODECOUPLECORE", 0);
        synchronized (f369094f) {
            if (z26) {
                jSONObject = jSONObject2;
                str2 = optString2;
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
            } else {
                str2 = optString2;
                jSONObject = jSONObject2;
            }
            if (!TextUtils.isEmpty(optString3) && optString3.length() == 96) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, optString3 + ContainerUtils.FIELD_DELIMITER + com.tencent.smtt.utils.i.c());
            }
        }
        if (optInt4 == 1) {
            tbsDownloadConfig.setDownloadInterruptCode(-110);
            QbSdk.reset(f369091c, optInt5 == 1);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=" + z16);
            return false;
        }
        if (!z27) {
            tbsDownloadConfig.setTbsCoreLoadRenameFileLockWaitEnable(z27);
        }
        if (optInt == 1) {
            if (optLong > JoinTimeType.SEVEN_DAY) {
                optLong = 604800;
            }
            r11 = optLong > 0 ? optLong : 86400L;
            TbsLog.w(LOGTAG, "Download is Flowed, next download request is " + r11 + "s later");
            if (TbsShareManager.isThirdPartyApp(f369091c)) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                tbsDownloadConfig.commit();
                tbsDownloadConfig.setDownloadInterruptCode(TbsCommonCode.DOWNLOAD_FLOW_CANCEL);
                return false;
            }
        }
        if (getRetryIntervalInSeconds() >= 0) {
            r11 = getRetryIntervalInSeconds();
        }
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, Long.valueOf(r11));
        boolean isEmpty = TextUtils.isEmpty(string);
        int i36 = ExportErrorStatus.END_WRITE_AUDIO_SAMPLE;
        if (isEmpty && TbsShareManager.isThirdPartyApp(f369091c)) {
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            tbsDownloadConfig.commit();
            tbsDownloadConfig.setDownloadInterruptCode(ExportErrorStatus.END_WRITE_AUDIO_SAMPLE);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] blank url,current app is third app...");
            return false;
        }
        TbsLog.i(LOGTAG, "in response responseCode is " + i18);
        if (i18 == 0) {
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i18));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            tbsDownloadConfig.setDownloadInterruptCode(-111);
            tbsDownloadConfig.commit();
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
            return false;
        }
        int i37 = TbsDownloadConfig.getInstance(f369091c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (i37 > i19) {
            f369095g.b();
            n.a().l(f369091c);
        }
        if (TbsShareManager.isThirdPartyApp(f369091c)) {
            z19 = false;
        } else {
            int a16 = n.a().a(f369091c, 0);
            z19 = a16 >= i19;
            TbsLog.i(LOGTAG, "tmpCoreVersion is " + a16 + " tbsDownloadVersion is" + i19);
        }
        if (i3 < i19 && !TextUtils.isEmpty(string) && !z19) {
            if (string.equals(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                num = 0;
            } else {
                f369095g.b();
                num = 0;
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, null);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, null);
            }
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i19));
            TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i19);
            if (i19 > 0) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, num);
            }
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, optString);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i18));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, Integer.valueOf(i26));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, Integer.valueOf(i27));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, Integer.valueOf(i28));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, Integer.valueOf(i16));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, Long.valueOf(j3));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j17));
            tbsDownloadConfig.commit();
            if (str2 != null) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, str2);
            }
            if (!z16) {
                tbsDownloadConfig.setDownloadInterruptCode(-216);
            }
            Map<String, Object> map = tbsDownloadConfig.mSyncMap;
            Boolean bool = Boolean.TRUE;
            map.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, bool);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##9 set needDownload=true");
            if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, bool);
            }
            tbsDownloadConfig.commit();
            return true;
        }
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
        tbsDownloadConfig.commit();
        if (!TextUtils.isEmpty(string)) {
            i36 = i19 <= 0 ? -125 : i3 >= i19 ? -127 : -112;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i36);
        TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i3 + " tbsDownloadVersion=" + i19 + " tbsLastDownloadVersion=" + i37 + " downloadUrl=" + string);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        File o16 = n.o(f369091c);
        if (o16 == null) {
            return;
        }
        File[] listFiles = o16.listFiles();
        Pattern compile = Pattern.compile("tbs_switch_disable_(.*)");
        for (File file : listFiles) {
            if (compile.matcher(file.getName()).find() && file.isFile() && file.exists() && file.canRead()) {
                TbsLog.i(LOGTAG, "clearTbsCoreDisableFlagFiles: " + file.getName() + "; res: " + file.delete());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, final Runnable runnable) {
        BaseThread baseThread = new BaseThread() { // from class: com.tencent.smtt.sdk.TbsDownloader.3
            /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
            /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                FileOutputStream fileOutputStream;
                final FileChannel fileChannel;
                Runnable runnable2;
                FileLock fileLock = null;
                try {
                    final Timer c16 = QbSdk.c();
                    fileOutputStream = FileUtil.b(context, true, "tbs_download_lock_file");
                    if (fileOutputStream != null && c16 != null) {
                        try {
                            fileChannel = fileOutputStream.getChannel();
                        } catch (Exception e16) {
                            e = e16;
                            fileChannel = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileChannel = null;
                            FileUtil.a(fileLock, fileOutputStream);
                            TbsLog.i(TbsDownloader.LOGTAG, "release wait download lock");
                            FileUtil.a(fileChannel);
                            FileUtil.a(fileOutputStream);
                            throw th;
                        }
                        try {
                            try {
                                new BaseTimer().schedule(new TimerTask() { // from class: com.tencent.smtt.sdk.TbsDownloader.3.1
                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public void run() {
                                        FileChannel fileChannel2 = fileChannel;
                                        if (fileChannel2 != null && fileChannel2.isOpen()) {
                                            try {
                                                fileChannel.close();
                                                c16.onTimeOut();
                                                TbsLog.i(TbsDownloader.LOGTAG, "wait download process lock timeout");
                                            } catch (IOException e17) {
                                                e17.printStackTrace();
                                            }
                                        }
                                    }
                                }, c16.timeOut);
                                TbsLog.i(TbsDownloader.LOGTAG, "start waiting other process Download finished");
                                fileLock = fileChannel.lock();
                                TbsLog.i(TbsDownloader.LOGTAG, "wait lock success");
                            } catch (Throwable th6) {
                                th = th6;
                                FileUtil.a(fileLock, fileOutputStream);
                                TbsLog.i(TbsDownloader.LOGTAG, "release wait download lock");
                                FileUtil.a(fileChannel);
                                FileUtil.a(fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            TbsLog.w(TbsDownloader.LOGTAG, "MultiProcessSyncInit exception: " + Log.getStackTraceString(e));
                            FileUtil.a(fileLock, fileOutputStream);
                            TbsLog.i(TbsDownloader.LOGTAG, "release wait download lock");
                            FileUtil.a(fileChannel);
                            FileUtil.a(fileOutputStream);
                            runnable2 = runnable;
                            if (runnable2 == null) {
                            }
                        }
                    } else {
                        fileChannel = null;
                    }
                } catch (Exception e18) {
                    e = e18;
                    fileOutputStream = null;
                    fileChannel = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                    fileChannel = null;
                }
                FileUtil.a(fileLock, fileOutputStream);
                TbsLog.i(TbsDownloader.LOGTAG, "release wait download lock");
                FileUtil.a(fileChannel);
                FileUtil.a(fileOutputStream);
                runnable2 = runnable;
                if (runnable2 == null) {
                    runnable2.run();
                }
            }
        };
        baseThread.setName("tbsSyncWaiter");
        baseThread.start();
    }
}
