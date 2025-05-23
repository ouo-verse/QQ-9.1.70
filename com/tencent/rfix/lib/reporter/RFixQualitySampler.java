package com.tencent.rfix.lib.reporter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.utils.ProcessUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixQualitySampler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, b> f364986a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class ReportAction {
        private static final /* synthetic */ ReportAction[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ReportAction All;
        public static final ReportAction Error;
        public static final ReportAction None;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10277);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ReportAction reportAction = new ReportAction("All", 0);
            All = reportAction;
            ReportAction reportAction2 = new ReportAction("Error", 1);
            Error = reportAction2;
            ReportAction reportAction3 = new ReportAction("None", 2);
            None = reportAction3;
            $VALUES = new ReportAction[]{reportAction, reportAction2, reportAction3};
        }

        ReportAction(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ReportAction valueOf(String str) {
            return (ReportAction) Enum.valueOf(ReportAction.class, str);
        }

        public static ReportAction[] values() {
            return (ReportAction[]) $VALUES.clone();
        }

        boolean match(boolean z16) {
            int i3 = a.f364987a[ordinal()];
            if (i3 == 1) {
                return true;
            }
            if (i3 != 2) {
                return false;
            }
            return !z16;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class ReportType {
        private static final /* synthetic */ ReportType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ReportType Force;
        public static final ReportType None;
        public static final ReportType Normal;
        public static final ReportType Sample;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10285);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ReportType reportType = new ReportType("Normal", 0);
            Normal = reportType;
            ReportType reportType2 = new ReportType("Sample", 1);
            Sample = reportType2;
            ReportType reportType3 = new ReportType("Force", 2);
            Force = reportType3;
            ReportType reportType4 = new ReportType("None", 3);
            None = reportType4;
            $VALUES = new ReportType[]{reportType, reportType2, reportType3, reportType4};
        }

        ReportType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ReportType valueOf(String str) {
            return (ReportType) Enum.valueOf(ReportType.class, str);
        }

        public static ReportType[] values() {
            return (ReportType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f364987a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10263);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ReportAction.values().length];
            f364987a = iArr;
            try {
                iArr[ReportAction.All.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f364987a[ReportAction.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f364987a[ReportAction.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final ReportAction f364988a;

        /* renamed from: b, reason: collision with root package name */
        final ReportAction f364989b;

        /* renamed from: c, reason: collision with root package name */
        final int f364990c;

        /* renamed from: d, reason: collision with root package name */
        int f364991d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f364992e;

        public b(ReportAction reportAction, ReportAction reportAction2, int i3, int i16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, reportAction, reportAction2, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
                return;
            }
            this.f364988a = reportAction;
            this.f364989b = reportAction2;
            this.f364990c = i3;
            this.f364991d = i16;
            this.f364992e = z16;
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.f364991d = i3;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "SampleConfig{mainProcAction=" + this.f364988a + ", childProcAction=" + this.f364989b + ", reportInterval=" + this.f364990c + ", reportSample=" + this.f364991d + ", forceErrorReport=" + this.f364992e + '}';
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10335);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        f364986a = hashMap;
        ReportAction reportAction = ReportAction.All;
        hashMap.put("Launch", new b(reportAction, ReportAction.Error, 12, 100, false));
        hashMap.put("Load", new b(reportAction, reportAction, 0, 10, true));
        ReportAction reportAction2 = ReportAction.None;
        hashMap.put("Config", new b(reportAction, reportAction2, 0, 10, true));
        hashMap.put("Download", new b(reportAction, reportAction2, 0, 10, true));
        hashMap.put("Install", new b(reportAction, reportAction2, 0, 10, true));
    }

    private static boolean a(Context context, String str, int i3) {
        String str2;
        if (i3 <= 0) {
            return true;
        }
        String processName = ProcessUtils.getProcessName(context);
        int indexOf = processName.indexOf(58);
        if (indexOf >= 0) {
            str2 = processName.substring(indexOf);
        } else {
            str2 = "";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("rfix_quality_sample_sp", 4);
        String str3 = str + "_last_report_time" + str2;
        long j3 = sharedPreferences.getLong(str3, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j3 < TimeUnit.HOURS.toMillis(i3)) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str3, currentTimeMillis);
        edit.apply();
        return true;
    }

    private static boolean b(int i3) {
        if (i3 <= 0 || i3 >= 100 || ((int) (Math.random() * 100.0d)) + 1 <= i3) {
            return true;
        }
        return false;
    }

    private static ReportType c(Context context, String str, boolean z16) {
        b bVar = f364986a.get(str);
        if (bVar == null) {
            return ReportType.Normal;
        }
        boolean isInMainProcess = ProcessUtils.isInMainProcess(context);
        if ((isInMainProcess && bVar.f364988a.match(z16)) || (!isInMainProcess && bVar.f364989b.match(z16))) {
            boolean a16 = a(context, str, bVar.f364990c);
            boolean b16 = b(bVar.f364991d);
            if (a16 && b16) {
                return ReportType.Sample;
            }
        }
        if (!z16 && bVar.f364992e) {
            return ReportType.Force;
        }
        return ReportType.None;
    }

    public static ReportType d(Context context, String str, boolean z16) {
        try {
            return c(context, str, z16);
        } catch (Exception e16) {
            RFixLog.e("RFix.RFixQualitySampler", "sample fail!", e16);
            return ReportType.Normal;
        }
    }

    public static void e() {
        for (String str : f364986a.keySet()) {
            if (!"Launch".equals(str)) {
                b bVar = f364986a.get(str);
                if (bVar != null) {
                    bVar.a(1);
                }
                RFixLog.i("RFix.RFixQualitySampler", "useLowSampleRate config=" + bVar);
            }
        }
    }
}
