package com.tencent.mobileqq.perf.terrible;

import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/perf/terrible/f;", "", "Lcom/tencent/mobileqq/perf/terrible/a;", "accumulatedData", "maxData", "", "a", "b", "Z", "isHighFrequencyLogPrint", "c", "isHighFrequencyGc", "d", "isPersistenceJavaMemCeil", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f258078a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isHighFrequencyLogPrint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isHighFrequencyGc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isPersistenceJavaMemCeil;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f258078a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull a accumulatedData, @NotNull a maxData) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) accumulatedData, (Object) maxData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(accumulatedData, "accumulatedData");
        Intrinsics.checkNotNullParameter(maxData, "maxData");
        QQPerfConfigLoader qQPerfConfigLoader = QQPerfConfigLoader.f257603a;
        boolean z18 = false;
        if (qQPerfConfigLoader.b().b().c() < MemoryUtil.f258173a.r() / 1024) {
            if (QLog.isDevelopLevel()) {
                QLog.i("TerribleEnvJudge", 1, "physicalMemoryThreshold is low than totalSystemMemSpace, not need to judge");
            }
            return false;
        }
        if (!qQPerfConfigLoader.b().b().e() && QLog.isDevelopLevel()) {
            QLog.i("TerribleEnvJudge", 1, "EnvStateFeatureSwitch.switch is false, not need to judge");
        }
        if (accumulatedData.f() > qQPerfConfigLoader.b().b().b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        isHighFrequencyLogPrint = z16;
        if (accumulatedData.d() > qQPerfConfigLoader.b().b().a()) {
            z17 = true;
        } else {
            z17 = false;
        }
        isHighFrequencyGc = z17;
        if (isHighFrequencyLogPrint || z17 || isPersistenceJavaMemCeil) {
            z18 = true;
        }
        if (z18) {
            QLog.w("TerribleEnvJudge", 1, "is in isTerribleEnv, last 10 seconds envStateData: " + accumulatedData + ", maxSecondData: " + maxData);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("TerribleEnvJudge", 1, "last 10 seconds accumulatedData: " + accumulatedData + ", maxData: " + maxData);
        }
        return z18;
    }
}
