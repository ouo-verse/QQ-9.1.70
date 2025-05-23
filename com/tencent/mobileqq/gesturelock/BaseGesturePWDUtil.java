package com.tencent.mobileqq.gesturelock;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* loaded from: classes12.dex */
public class BaseGesturePWDUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int GESTUREPWD_MODE_AUTO = 21;
    public static final int GESTUREPWD_MODE_MANUAL = 20;
    public static final int GESTUREPWD_STATE_CLOSED = 1;
    public static final int GESTUREPWD_STATE_NOTSET = 0;
    public static final int GESTUREPWD_STATE_OPEN = 2;
    public static final int GESTUREPWD_UNLOCKFAILED_TYPE_FORGET = 0;
    public static final int GESTUREPWD_UNLOCKFAILED_TYPE_WRONG = 1;
    public static final String GESTURE_SALT = "28DF17A9B837BAFD951724E325F6F86B5B6E477D";
    static final String KEY_GESTURE_APP_FORGROUND = "gesturepassword_appforground";
    static final String KEY_GESTURE_CURRENTUIN_FORPLUGIN = "gesturepassword_currentuin_forplugin";
    static final String KEY_GESTURE_LOCKING = "gesturepassword_locking";
    static final String KEY_GESTURE_MODE = "gesturepassword_gesture_mode";
    static final String KEY_GESTURE_PWD = "gesturepassword_gesture_pwd";
    static final String KEY_GESTURE_SHAREPRE_NAME = "gesturepassword_sharepreference";
    static final String KEY_GESTURE_STATE = "gesturepassword_gesture_state";
    static final String KEY_GESTURE_UNLOCK_FAILED = "gesturepassword_unlock_failed";
    static final String KEY_GESTURE_UNLOCK_FAILED_TIME = "gesturepassword_unlock_failed_time";
    static final String KEY_GESTURE_UNLOCK_FAILED_TYPE = "gesturepassword_unlock_failed_type";
    private static final String KEY_MMKV_MIGRATE_FLAG = "_migrate_flag_";
    public static final int PROCESS_STATE_TOP = 2;
    static final String UTIL_TAG = "Q.gesturelock.util";
    static Field mProcStateField;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        if (mProcStateField == null) {
            try {
                mProcStateField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(UTIL_TAG, 2, "getDeclaredField processState", e16);
                }
            }
        }
    }

    public BaseGesturePWDUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clearGestureData(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "clearGestureData.uin=" + str);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putInt(KEY_GESTURE_STATE + str, 0);
        edit.putString(KEY_GESTURE_PWD + str, "");
        edit.commit();
    }

    public static boolean enableGestureLock(Context context) {
        String str;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        String packageName = context.getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (it.hasNext()) {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        str = next.processName;
                        break;
                    }
                } else {
                    str = "";
                    break;
                }
            }
            if (str != null) {
                if (!str.equals(packageName + ":qzone")) {
                    if (!str.equals(packageName + ":picture")) {
                        if (!str.equals(packageName + ":qqfav")) {
                            if (str.equals(packageName + ":qlink")) {
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static String encodeGesture(String str, String str2) {
        int i3;
        String str3;
        String md5 = MD5.toMD5(str);
        if (!TextUtils.isEmpty(str2)) {
            i3 = str2.length();
        } else {
            i3 = 0;
        }
        if (!TextUtils.isEmpty(md5)) {
            StringBuilder sb5 = new StringBuilder(md5);
            sb5.insert(6, GESTURE_SALT.substring(0, 20));
            sb5.insert(sb5.length() - 9, GESTURE_SALT.substring(20, 40));
            if (!TextUtils.isEmpty(str2)) {
                int i16 = i3 / 2;
                sb5.insert(2, str2.substring(0, i16));
                sb5.insert(sb5.length() - 5, str2.substring(i16, i3));
            }
            str3 = sb5.toString();
        } else {
            str3 = "";
        }
        return MD5.toMD5(str3);
    }

    public static boolean getAppForground(Context context) {
        boolean z16 = getSharedPreferences(context).getBoolean(KEY_GESTURE_APP_FORGROUND, false);
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getAppForground.uin=,isAppFroground=" + z16);
        }
        return z16;
    }

    public static boolean getGestureLocking(Context context) {
        boolean z16 = getSharedPreferences(context).getBoolean(KEY_GESTURE_LOCKING, false);
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setGestureLocking.uin=,islocking=" + z16);
        }
        return z16;
    }

    public static String getGesturePWD(Context context, String str) {
        String string = getSharedPreferences(context).getString(KEY_GESTURE_PWD + str, "");
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getGesturePWD.uin=" + str + ",pw=" + string);
        }
        return string;
    }

    public static int getGesturePWDMode(Context context, String str) {
        int i3 = getSharedPreferences(context).getInt(KEY_GESTURE_MODE + str, 21);
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getGesturePWDMode.uin=" + str + ",mode=" + i3);
        }
        return i3;
    }

    public static int getGesturePWDState(Context context, String str) {
        int i3 = getSharedPreferences(context).getInt(KEY_GESTURE_STATE + str, 0);
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getGesturePWDState.uin=" + str + ",state=" + i3);
        }
        return i3;
    }

    public static boolean getGestureUnlockFailed(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        String string = sharedPreferences.getString(KEY_GESTURE_UNLOCK_FAILED, "");
        boolean z16 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string) && string.equals(str)) {
            if (sharedPreferences.getInt(KEY_GESTURE_STATE + str, 0) == 0) {
                z16 = true;
            }
        }
        if (!TextUtils.isEmpty(string)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(KEY_GESTURE_UNLOCK_FAILED, "");
            edit.commit();
        }
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getGestureUnlockFailed.uin=" + str + ",ret=" + z16);
        }
        return z16;
    }

    public static int getGestureUnlockFailedTime(Context context, String str) {
        int i3 = getSharedPreferences(context).getInt(KEY_GESTURE_UNLOCK_FAILED_TIME + str, 0);
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getGestureUnlockFailedTime.uin=" + str + ",failedTime=" + i3);
        }
        return i3;
    }

    public static int getGestureUnlockFailedType(Context context) {
        int i3 = getSharedPreferences(context).getInt(KEY_GESTURE_UNLOCK_FAILED_TYPE, 0);
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getGestureUnlockFailedType.type=" + i3);
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r5.getBoolean(com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil.KEY_GESTURE_LOCKING, false) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0037, code lost:
    
        if (r5.getInt(com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil.KEY_GESTURE_STATE + r6, 0) == 2) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean getJumpLock(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        int i3 = sharedPreferences.getInt(KEY_GESTURE_MODE + str, 21);
        boolean z16 = true;
        if (i3 == 21) {
        } else {
            if (i3 == 20) {
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getJumpLock.uin=" + str + ",isjumplock=" + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, KEY_GESTURE_SHAREPRE_NAME, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(context, KEY_GESTURE_SHAREPRE_NAME, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
    
        if (r5.getBoolean(com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil.KEY_GESTURE_LOCKING, false) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003d, code lost:
    
        if (r5.getInt(com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil.KEY_GESTURE_STATE + r6, 0) == 2) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x004d, code lost:
    
        r2 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean getSplashLock(Context context, String str) {
        boolean z16 = false;
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            int i3 = sharedPreferences.getInt(KEY_GESTURE_MODE + str, 21);
            if (i3 == 21) {
            } else if (i3 == 20) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getSplashLock.uin=" + str + ",islock=" + z16);
        }
        return z16;
    }

    public static String getUinForPlugin(Context context) {
        String string = getSharedPreferences(context).getString(KEY_GESTURE_CURRENTUIN_FORPLUGIN, "");
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "getUinForPlugin.uin=" + string);
        }
        return string;
    }

    public static boolean isAppOnForeground(Context context) {
        if (Foreground.getActivityCount() > 0) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        String packageName = context.getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppOnForegroundByTasks(Context context) {
        return isAppOnForegroundByTasks(context, 0);
    }

    private static void printServiceInfos(ActivityManager activityManager, String str) {
        List<ActivityManager.RunningServiceInfo> list;
        if (activityManager != null) {
            list = activityManager.getRunningServices(1000);
        } else {
            list = null;
        }
        if (list != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : list) {
                if (runningServiceInfo != null && runningServiceInfo.foreground && runningServiceInfo.process.startsWith(str)) {
                    QLog.d(UTIL_TAG, 2, "foreground service=" + runningServiceInfo.service.getClassName());
                }
            }
        }
    }

    public static void setAppForground(Context context, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setAppForground.uin=,isAppFroground=" + z16);
        }
        ThreadManagerV2.excute(new Runnable(context, z16) { // from class: com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f213632d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f213633e;

            {
                this.f213632d = context;
                this.f213633e = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                SharedPreferences.Editor edit = BaseGesturePWDUtil.getSharedPreferences(this.f213632d).edit();
                edit.putBoolean(BaseGesturePWDUtil.KEY_GESTURE_APP_FORGROUND, this.f213633e);
                edit.apply();
            }
        }, 16, null, false);
        if (context == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable(z16, context) { // from class: com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f213634d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f213635e;

            {
                this.f213634d = z16;
                this.f213635e = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Intent intent = new Intent();
                if (this.f213634d) {
                    intent.setAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
                } else {
                    intent.setAction(IECScreenReceiver.ACTION_QQ_BACKGROUND);
                }
                intent.putExtra("process_name", MobileQQ.sMobileQQ.getQQProcessName());
                try {
                    this.f213635e.sendBroadcast(intent);
                } catch (Exception e16) {
                    QLog.i("GESTUREPWDUTILS", 1, e16.toString(), e16);
                }
            }
        }, 8, null, false);
    }

    public static void setGestureLocking(Context context, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setGestureLocking.uin=,islock=" + z16);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putBoolean(KEY_GESTURE_LOCKING, z16);
        edit.commit();
    }

    public static void setGesturePWD(Context context, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setGesturePWD.uin=" + str + ",pw=" + str2);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString(KEY_GESTURE_PWD + str, str2);
        edit.commit();
    }

    public static void setGesturePWDMode(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setGesturePWDMode.uin=" + str + ",mode=" + i3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putInt(KEY_GESTURE_MODE + str, i3);
        edit.commit();
    }

    public static void setGestureUnlockFailed(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setGestureUnlockFailed.uin=" + str);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString(KEY_GESTURE_UNLOCK_FAILED, str);
        edit.commit();
    }

    public static void setGestureUnlockFailedTime(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setGestureUnlockFailedTime.uin=" + str + ",failedTime=" + i3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putInt(KEY_GESTURE_UNLOCK_FAILED_TIME + str, i3);
        edit.commit();
    }

    public static void setGestureUnlockFailedType(Context context, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setGestureUnlockFailedType.type=" + i3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putInt(KEY_GESTURE_UNLOCK_FAILED_TYPE, i3);
        edit.commit();
    }

    public static void setUinForPlugin(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(UTIL_TAG, 2, "setUinForPlugin.uin=" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString(KEY_GESTURE_CURRENTUIN_FORPLUGIN, str);
        edit.commit();
    }

    public static boolean isAppOnForegroundByTasks(Context context, int i3) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int i16;
        Field field;
        if (Foreground.getActivityCountFromLifecycle(i3) > 0) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        String packageName = context.getApplicationContext().getPackageName();
        try {
            runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(UTIL_TAG, 2, "isAppOnForegroundByTasks.uin", e16);
            }
        }
        if (runningAppProcesses == null) {
            return false;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && myPid != runningAppProcessInfo.pid && runningAppProcessInfo.processName.startsWith(packageName) && !runningAppProcessInfo.processName.endsWith(ProcessConstant.MSF) && !runningAppProcessInfo.processName.endsWith("TMAssistantDownloadSDKService")) {
                if (runningAppProcessInfo.importance == 100) {
                    try {
                        field = mProcStateField;
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(UTIL_TAG, 2, "isAppOnForegroundByTasks", e17);
                        }
                        i16 = 0;
                    }
                    if (field != null) {
                        i16 = field.getInt(runningAppProcessInfo);
                        if (i16 == 2) {
                            if (QLog.isColorLevel()) {
                                QLog.d(UTIL_TAG, 2, "isAppOnForegroundByTasks is true, realforeProcessName=" + runningAppProcessInfo.processName);
                                printServiceInfos(activityManager, packageName);
                            }
                            return true;
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(UTIL_TAG, 2, "isAppOnForegroundByTasks, mProcStateField is null");
                        }
                        return true;
                    }
                } else {
                    i16 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(UTIL_TAG, 2, "isAppOnForegroundByTasks, procName=" + runningAppProcessInfo.processName + ",importance=" + runningAppProcessInfo.importance + ",reasonCode=" + runningAppProcessInfo.importanceReasonCode + ",procState=" + i16 + ",pid=" + runningAppProcessInfo.pid);
                }
            }
        }
        return false;
    }
}
