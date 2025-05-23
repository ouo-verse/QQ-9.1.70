package com.tencent.mobileqq.perf.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/perf/report/PerfFeature;", "", "", "c", "Lcom/tencent/mobileqq/perf/report/PerfFeature$CustomFlag;", "flag", "a", "d", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "b", "Ljava/util/concurrent/CopyOnWriteArraySet;", "customFlagSet", "<init>", "()V", "CustomFlag", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PerfFeature {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PerfFeature f258005a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArraySet<String> customFlagSet;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/perf/report/PerfFeature$CustomFlag;", "", "(Ljava/lang/String;I)V", "NatMemMonitor", "ZPlanProcess", "ZPlanFilament", "ZPlanFilamentCoupleAvatar", "MetaDream", "SwitchAccountRebootExp", "SwitchAccountRebootContrast", "AdelieAV", "TBSToolOffice", "TBSToolPDF", "TBSToolOfficeMMKV", "TBSToolPDFMMKV", "WVMainProcEnable", "WVMainProcDisEnable", "WVMainProcInUse", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class CustomFlag {
        private static final /* synthetic */ CustomFlag[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CustomFlag AdelieAV;
        public static final CustomFlag MetaDream;
        public static final CustomFlag NatMemMonitor;
        public static final CustomFlag SwitchAccountRebootContrast;
        public static final CustomFlag SwitchAccountRebootExp;
        public static final CustomFlag TBSToolOffice;
        public static final CustomFlag TBSToolOfficeMMKV;
        public static final CustomFlag TBSToolPDF;
        public static final CustomFlag TBSToolPDFMMKV;
        public static final CustomFlag WVMainProcDisEnable;
        public static final CustomFlag WVMainProcEnable;
        public static final CustomFlag WVMainProcInUse;
        public static final CustomFlag ZPlanFilament;
        public static final CustomFlag ZPlanFilamentCoupleAvatar;
        public static final CustomFlag ZPlanProcess;

        private static final /* synthetic */ CustomFlag[] $values() {
            return new CustomFlag[]{NatMemMonitor, ZPlanProcess, ZPlanFilament, ZPlanFilamentCoupleAvatar, MetaDream, SwitchAccountRebootExp, SwitchAccountRebootContrast, AdelieAV, TBSToolOffice, TBSToolPDF, TBSToolOfficeMMKV, TBSToolPDFMMKV, WVMainProcEnable, WVMainProcDisEnable, WVMainProcInUse};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35169);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            NatMemMonitor = new CustomFlag("NatMemMonitor", 0);
            ZPlanProcess = new CustomFlag("ZPlanProcess", 1);
            ZPlanFilament = new CustomFlag("ZPlanFilament", 2);
            ZPlanFilamentCoupleAvatar = new CustomFlag("ZPlanFilamentCoupleAvatar", 3);
            MetaDream = new CustomFlag("MetaDream", 4);
            SwitchAccountRebootExp = new CustomFlag("SwitchAccountRebootExp", 5);
            SwitchAccountRebootContrast = new CustomFlag("SwitchAccountRebootContrast", 6);
            AdelieAV = new CustomFlag("AdelieAV", 7);
            TBSToolOffice = new CustomFlag("TBSToolOffice", 8);
            TBSToolPDF = new CustomFlag("TBSToolPDF", 9);
            TBSToolOfficeMMKV = new CustomFlag("TBSToolOfficeMMKV", 10);
            TBSToolPDFMMKV = new CustomFlag("TBSToolPDFMMKV", 11);
            WVMainProcEnable = new CustomFlag("WVMainProcEnable", 12);
            WVMainProcDisEnable = new CustomFlag("WVMainProcDisEnable", 13);
            WVMainProcInUse = new CustomFlag("WVMainProcInUse", 14);
            $VALUES = $values();
        }

        CustomFlag(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static CustomFlag valueOf(String str) {
            return (CustomFlag) Enum.valueOf(CustomFlag.class, str);
        }

        public static CustomFlag[] values() {
            return (CustomFlag[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35180);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        PerfFeature perfFeature = new PerfFeature();
        f258005a = perfFeature;
        customFlagSet = new CopyOnWriteArraySet<>();
        perfFeature.c();
    }

    PerfFeature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull CustomFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        customFlagSet.add(flag.name());
    }

    @JvmStatic
    @NotNull
    public static final CopyOnWriteArraySet<String> b() {
        return customFlagSet;
    }

    private final void c() {
        if (a.c("ZPlanFilament", false)) {
            a(CustomFlag.ZPlanFilament);
        } else {
            d(CustomFlag.ZPlanFilament);
        }
    }

    @JvmStatic
    public static final void d(@NotNull CustomFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        customFlagSet.remove(flag.name());
    }
}
