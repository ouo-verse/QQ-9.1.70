package com.tencent.qqperf.monitor.crash.tools;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.tools.e;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static MMKVOptionEntity f363230a;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<a> f363231b;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a extends b {

        /* renamed from: c, reason: collision with root package name */
        int f363232c = -1;

        /* renamed from: d, reason: collision with root package name */
        e.a f363233d;

        /* renamed from: e, reason: collision with root package name */
        ApplicationExitInfo f363234e;

        public int a() {
            return this.f363232c;
        }

        @Override // com.tencent.qqperf.monitor.crash.tools.g.b
        public String toString() {
            String aVar;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("QQExitInfo{qqReason=");
            sb5.append(this.f363232c);
            sb5.append(", pid=");
            sb5.append(this.f363235a);
            sb5.append(", pTime=");
            sb5.append(this.f363236b);
            sb5.append(", lastCrashInfo=");
            e.a aVar2 = this.f363233d;
            String str = "null";
            if (aVar2 == null) {
                aVar = "null";
            } else {
                aVar = aVar2.toString();
            }
            sb5.append(aVar);
            sb5.append(", sysInfo=");
            ApplicationExitInfo applicationExitInfo = this.f363234e;
            if (applicationExitInfo != null) {
                str = applicationExitInfo.toString();
            }
            sb5.append(str);
            sb5.append('}');
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f363235a = -1;

        /* renamed from: b, reason: collision with root package name */
        long f363236b = -1;

        public String toString() {
            return "QQProcessInfo{pid=" + this.f363235a + ", processTime=" + this.f363236b + '}';
        }
    }

    public static b a(@NonNull Context context) {
        b bVar = new b();
        MMKVOptionEntity e16 = e(context);
        if (e16 == null) {
            QLog.e("LastExitInfoHelper", 1, "getLastProcessInfo failed mmkvOptionEntity is null");
            return bVar;
        }
        int decodeInt = e16.decodeInt("key_current_process_id", -1);
        long decodeLong = e16.decodeLong("key_current_process_time", -1L);
        bVar.f363235a = decodeInt;
        bVar.f363236b = decodeLong;
        return bVar;
    }

    public static String b(Context context) {
        String aVar;
        String applicationExitInfo;
        StringBuilder sb5 = new StringBuilder();
        if (context == null) {
            sb5.append("get info jump context is null \n");
            return sb5.toString();
        }
        sb5.append("LastQQExitInfo:\n");
        a d16 = d(context);
        if (d16 == null) {
            aVar = "null";
        } else {
            aVar = d16.toString();
        }
        sb5.append(aVar);
        sb5.append("\nLastSystemExitInfoList:\n");
        List<ApplicationExitInfo> g16 = g(context);
        if (g16 == null) {
            sb5.append("get system info list failed Build.VERSION.SDK_INT : " + Build.VERSION.SDK_INT + "\n");
            return sb5.toString();
        }
        sb5.append("get infoList size: " + g16.size() + "\n");
        for (ApplicationExitInfo applicationExitInfo2 : g16) {
            StringBuilder sb6 = new StringBuilder();
            applicationExitInfo = applicationExitInfo2.toString();
            sb6.append(applicationExitInfo);
            sb6.append("\n");
            sb5.append(sb6.toString());
        }
        return sb5.toString();
    }

    public static b c(@NonNull Context context) {
        b bVar = new b();
        MMKVOptionEntity e16 = e(context);
        if (e16 == null) {
            QLog.e("LastExitInfoHelper", 1, "getLastProcessInfo failed mmkvOptionEntity is null");
            return bVar;
        }
        int decodeInt = e16.decodeInt("key_previous_process_id", -1);
        long decodeLong = e16.decodeLong("key_previous_process_time", -1L);
        bVar.f363235a = decodeInt;
        bVar.f363236b = decodeLong;
        return bVar;
    }

    public static a d(@NonNull Context context) {
        int i3;
        ApplicationExitInfo f16;
        int pid;
        a aVar;
        a aVar2 = new a();
        WeakReference<a> weakReference = f363231b;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            QLog.i("LastExitInfoHelper", 2, "getLastQQExitInfo find weakReference info");
            return aVar;
        }
        if (context == null) {
            QLog.e("LastExitInfoHelper", 1, "getLastQQExitInfo failed context is null");
            return aVar2;
        }
        b c16 = c(context);
        if (c16 != null && (i3 = c16.f363235a) != -1) {
            aVar2.f363235a = i3;
            aVar2.f363236b = c16.f363236b;
            if (QLog.isColorLevel()) {
                QLog.w("LastExitInfoHelper", 2, "getLastQQExitInfo lastProcessInfo is " + c16.toString());
            }
            e.a c17 = e.c(context);
            aVar2.f363232c = 0;
            if (c17 != null && c17.f363228d == c16.f363235a && c17.f363229e == c16.f363236b) {
                aVar2.f363232c = 1;
                aVar2.f363233d = c17;
            }
            if (Build.VERSION.SDK_INT >= 30 && (f16 = f(context, "com.tencent.mobileqq")) != null) {
                pid = f16.getPid();
                if (pid == c16.f363235a) {
                    aVar2.f363234e = f16;
                }
            }
            f363231b = new WeakReference<>(aVar2);
            return aVar2;
        }
        QLog.w("LastExitInfoHelper", 1, "getLastQQExitInfo failed lastExitPid is default");
        return aVar2;
    }

    private static MMKVOptionEntity e(@NonNull Context context) {
        if (f363230a == null) {
            f363230a = QMMKV.from(context, "BuglySdkInfos");
        }
        return f363230a;
    }

    @Nullable
    @RequiresApi(api = 30)
    public static ApplicationExitInfo f(Context context, String str) {
        String processName;
        long timestamp;
        long timestamp2;
        List<ApplicationExitInfo> g16 = g(context);
        ApplicationExitInfo applicationExitInfo = null;
        if (g16 != null && g16.size() != 0) {
            if (StringUtil.isEmpty(str)) {
                return g16.get(0);
            }
            for (ApplicationExitInfo applicationExitInfo2 : g16) {
                processName = applicationExitInfo2.getProcessName();
                if (processName.equalsIgnoreCase(str)) {
                    if (applicationExitInfo != null) {
                        timestamp = applicationExitInfo2.getTimestamp();
                        timestamp2 = applicationExitInfo.getTimestamp();
                        if (timestamp > timestamp2) {
                        }
                    }
                    applicationExitInfo = applicationExitInfo2;
                }
            }
            return applicationExitInfo;
        }
        if (QLog.isColorLevel()) {
            QLog.w("LastExitInfoHelper", 2, "getSysLastExitInfoByProcessName infoList is empty");
        }
        return null;
    }

    @Nullable
    public static List<ApplicationExitInfo> g(Context context) {
        List<ApplicationExitInfo> historicalProcessExitReasons;
        if (Build.VERSION.SDK_INT >= 30 && context != null) {
            historicalProcessExitReasons = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getHistoricalProcessExitReasons(MobileQQ.PACKAGE_NAME, 0, 10);
            return historicalProcessExitReasons;
        }
        return null;
    }

    public static boolean h() {
        if (d(MobileQQ.sMobileQQ).a() == 1) {
            return true;
        }
        return false;
    }

    public static void i(@NonNull Context context) {
        int myPid = Process.myPid();
        long currentTimeMillis = System.currentTimeMillis();
        MMKVOptionEntity e16 = e(context);
        if (e16 == null) {
            QLog.e("LastExitInfoHelper", 1, "startUpRecordProcess failed mmkvOptionEntity is null");
            return;
        }
        int decodeInt = e16.decodeInt("key_current_process_id", -1);
        long decodeLong = e16.decodeLong("key_current_process_time", -1L);
        e16.encodeInt("key_current_process_id", myPid);
        e16.encodeInt("key_previous_process_id", decodeInt);
        e16.encodeLong("key_current_process_time", currentTimeMillis);
        e16.encodeLong("key_previous_process_time", decodeLong);
    }
}
