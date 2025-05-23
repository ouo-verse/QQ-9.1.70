package com.tencent.mobileqq.perf.process.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.commons.lang.time.FastDateFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013J\b\u0010\u0015\u001a\u00020\u0005H\u0007J$\u0010\u001a\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/perf/process/util/b;", "", "", "k", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "", h.F, "g", "i", "o", DomainData.DOMAIN_NAME, "", "e", "Ljava/lang/Runnable;", "runnable", "p", "", "j", "b", "enableMfrList", "mfr", "", "funcIndex", "d", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f257946a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f257946a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        QLog.flushLog(true);
        SystemMethodProxy.killProcess(Process.myPid());
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "activityThread.getDeclar\u2026(\"currentActivityThread\")");
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            Intrinsics.checkNotNullExpressionValue(declaredField, "activityThread.getDeclaredField(\"mActivities\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            return ((Map) obj).isEmpty();
        } catch (Exception e16) {
            QLog.e("ProcessUtil", 1, "getAppActivities fail", e16);
            return false;
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            return guardManager.isApplicationForeground();
        }
        return true;
    }

    public final boolean d(@NotNull List<String> enableMfrList, @NotNull String mfr, int funcIndex) {
        Object obj;
        String removePrefix;
        boolean contains$default;
        List split$default;
        List split$default2;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, enableMfrList, mfr, Integer.valueOf(funcIndex))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(enableMfrList, "enableMfrList");
        Intrinsics.checkNotNullParameter(mfr, "mfr");
        try {
            String str = mfr + '-' + funcIndex + '-';
            Iterator<T> it = enableMfrList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) obj, str, false, 2, null);
                    if (startsWith$default) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            String str2 = (String) obj;
            if (str2 != null) {
                removePrefix = StringsKt__StringsKt.removePrefix(str2, (CharSequence) str);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) removePrefix, (CharSequence) "..", false, 2, (Object) null);
                if (contains$default) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) removePrefix, new String[]{".."}, false, 0, 6, (Object) null);
                    int parseInt = Integer.parseInt((String) split$default.get(0));
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) removePrefix, new String[]{".."}, false, 0, 6, (Object) null);
                    int parseInt2 = Integer.parseInt((String) split$default2.get(1));
                    int i3 = Build.VERSION.SDK_INT;
                    if (parseInt <= i3 && i3 <= parseInt2) {
                        return true;
                    }
                } else if (Build.VERSION.SDK_INT == Integer.parseInt(removePrefix)) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.preExit();
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.perf.process.util.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f();
            }
        }, 16, null, false, 150L);
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String format = FastDateFormat.getInstance("HH", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "getInstance(\"HH\", Locale\u2026Default()).format(Date())");
        return format;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return (SystemClock.elapsedRealtime() - com.tencent.mobileqq.startup.a.f289661b) / 1000;
    }

    @NotNull
    public final String i() {
        String removePrefix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (Intrinsics.areEqual(MobileQQ.processName, MobileQQ.PACKAGE_NAME)) {
            return "Main";
        }
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        removePrefix = StringsKt__StringsKt.removePrefix(processName, (CharSequence) (MobileQQ.PACKAGE_NAME + ':'));
        return removePrefix;
    }

    @Nullable
    public final List<String> j() {
        List<String> emptyList;
        ArrayList<ActivityManager.RunningServiceInfo> arrayList;
        int collectionSizeOrDefault;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        try {
            Object systemService = MobileQQ.sMobileQQ.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) systemService).getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null) {
                arrayList = new ArrayList();
                for (Object obj : runningServices) {
                    ActivityManager.RunningServiceInfo runningServiceInfo = (ActivityManager.RunningServiceInfo) obj;
                    boolean z16 = false;
                    if (runningServiceInfo.foreground) {
                        String str = runningServiceInfo.process;
                        Intrinsics.checkNotNullExpressionValue(str, "it.process");
                        String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
                        Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, PACKAGE_NAME, false, 2, null);
                        if (startsWith$default) {
                            z16 = true;
                        }
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo2 : arrayList) {
                    QLog.i("ProcessUtil", 1, "find foregroundService, " + runningServiceInfo2.service.getClassName() + ", " + runningServiceInfo2.process);
                }
            }
            if (arrayList == null) {
                return null;
            }
            ArrayList arrayList2 = arrayList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String className = ((ActivityManager.RunningServiceInfo) it.next()).service.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "it.service.className");
                arrayList3.add(className);
            }
            return arrayList3;
        } catch (Throwable th5) {
            QLog.e("ProcessUtil", 1, "check isForegroundServiceRunning fail", th5);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @NotNull
    public final String k() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return "null";
        }
        return str;
    }

    @NotNull
    public final String l() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            str = firstSimpleAccount.getUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "null";
        }
        return str;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !peekAppRuntime.isLogin()) {
            return false;
        }
        return true;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return Intrinsics.areEqual(MobileQQ.processName, MobileQQ.PACKAGE_NAME);
    }

    public final boolean o() {
        boolean endsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(processName, ":tool", false, 2, null);
        return endsWith$default;
    }

    public final void p(@NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            ThreadManagerV2.excute(runnable, 16, null, true);
        }
    }
}
