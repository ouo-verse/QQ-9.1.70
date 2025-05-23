package cooperation.qzone;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CrashGuard {
    private static final int DEFAULT_CRASH_DURATION_AFTER_LAUNCH = 15;
    private static final int DEFAULT_CRASH_MAX_COUNT = 2;
    private static long appLaunchTime = 0;
    private static int crashBetweenLaunch = -1;
    private Runnable clearTimestamp;
    private CrashListener crashListener;
    AtomicBoolean isTimeOvered = new AtomicBoolean(false);
    private Handler mHandler;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface CrashListener {
        void onCrashHandle(Throwable th5);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class H {
        public static CrashGuard instance = new CrashGuard();
    }

    public static void clearFileCache(Context context) {
        CacheManager.clearFileCache(context);
    }

    public static int getCrashDurationAfterLaunch() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SAFEMODE, QzoneConfig.SECONDARY_SAFEMODE_START_DURATION, 15) * 1000;
    }

    public static int getCrashMaxCount() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SAFEMODE, QzoneConfig.SECONDARY_SAFEMODE_CRASH_MAX, 2);
    }

    public static CrashGuard getInstance() {
        return H.instance;
    }

    public void clearCache(BaseApplication baseApplication, String str) {
        clearFileCache(baseApplication);
        if (!TextUtils.isEmpty(str)) {
            baseApplication.deleteDatabase(SecurityUtil.c(str));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(baseApplication.getFilesDir().getParent());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("shared_prefs");
        String sb6 = sb5.toString();
        if (!TextUtils.isEmpty(sb6)) {
            FileUtils.deleteFile(new File(sb6 + str2 + "qz_predownload_config.xml"));
            FileUtils.deleteFile(new File(sb6 + str2 + "QZ_Per_Config.xml"));
            FileUtils.deleteFile(new File(sb6 + str2 + "QZONE_UNREAD.xml"));
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + "tencent" + str2 + "MobileQQ" + str2 + "trace");
        if (sDKPrivatePath != null) {
            FileUtils.deleteFile(new File(sDKPrivatePath));
        }
    }

    public void onAppLaunch(final long j3, Handler handler, CrashListener crashListener) {
        appLaunchTime = System.currentTimeMillis();
        this.mHandler = handler;
        this.crashListener = crashListener;
        if (this.clearTimestamp == null) {
            this.clearTimestamp = new Runnable() { // from class: cooperation.qzone.CrashGuard.1
                @Override // java.lang.Runnable
                public void run() {
                    CrashGuard.this.isTimeOvered.set(true);
                    QLog.i(QZLog.TO_DEVICE_TAG, 1, "clear crash count with no crash");
                    LocalMultiProcConfig.putInt4Uin("key_crash_count", 0, j3);
                }
            };
        }
        if (crashBetweenLaunch < 0) {
            crashBetweenLaunch = getCrashDurationAfterLaunch();
        }
        this.mHandler.postDelayed(this.clearTimestamp, crashBetweenLaunch);
    }

    public void onException(Throwable th5, long j3) {
        int i3;
        CrashListener crashListener = this.crashListener;
        if (crashListener != null) {
            crashListener.onCrashHandle(th5);
        }
        if (this.isTimeOvered.get()) {
            return;
        }
        Runnable runnable = this.clearTimestamp;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        int i16 = 0;
        int int4Uin = LocalMultiProcConfig.getInt4Uin("key_crash_count", 0, j3);
        if (crashBetweenLaunch < 0) {
            crashBetweenLaunch = getCrashDurationAfterLaunch();
        }
        if (System.currentTimeMillis() - appLaunchTime <= crashBetweenLaunch) {
            i3 = int4Uin + 1;
        } else {
            QLog.i(QZLog.TO_DEVICE_TAG, 1, "clear crash count with overtime");
            i3 = 0;
        }
        String valueOf = String.valueOf(j3);
        if (i3 >= getCrashMaxCount()) {
            QLog.i(QZLog.TO_DEVICE_TAG, 1, "crash in a row, clearCache " + valueOf);
            clearCache(BaseApplication.getContext(), valueOf);
        } else {
            i16 = i3;
        }
        LocalMultiProcConfig.putInt4Uin("key_crash_count", i16, j3);
    }
}
