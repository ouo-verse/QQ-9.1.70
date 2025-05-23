package com.tencent.mobileqq.perf.memory.largeobject;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.squarepants.SquarePants;
import com.tencent.mobileqq.squarepants.c;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/largeobject/b;", "", "a", "b", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f257761b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f257762c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f257763d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/perf/memory/largeobject/b$a", "Lcom/tencent/mobileqq/squarepants/b;", "", "tag", "msg", "", "d", "e", "", "th", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements com.tencent.mobileqq.squarepants.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.squarepants.b
        public void d(@Nullable String tag, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
            } else {
                QLog.d(tag, 1, msg2);
            }
        }

        @Override // com.tencent.mobileqq.squarepants.b
        public void e(@Nullable String tag, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QLog.e(tag, 1, msg2);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
            }
        }

        @Override // com.tencent.mobileqq.squarepants.b
        public void e(@Nullable String tag, @Nullable Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                QLog.d(tag, 1, th5, new Object[0]);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) th5);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0006*\u0001\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0004R$\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/largeobject/b$b;", "", "", "ret", "", "e", "Lcom/tencent/mobileqq/perf/memory/collect/a;", "memoryUsage", "c", "f", "", "<set-?>", "hooked", "Z", "a", "()Z", "modifiedThreshold", "b", "", "GROUP_ID", "Ljava/lang/String;", "KEY_LOS_THRESHOLD", "TAG", "com/tencent/mobileqq/perf/memory/largeobject/b$a", "logger", "Lcom/tencent/mobileqq/perf/memory/largeobject/b$a;", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.memory.largeobject.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        public static /* synthetic */ void d(Companion companion, com.tencent.mobileqq.perf.memory.collect.a aVar, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                aVar = null;
            }
            companion.c(aVar);
        }

        private final void e(int ret) {
            long j3;
            String str;
            HashMap hashMapOf;
            if (Random.INSTANCE.nextInt(500) / 500 != 0) {
                return;
            }
            if (a()) {
                byte[] bArr = new byte[12288];
                if (QLog.isDebugVersion()) {
                    bArr.hashCode();
                }
                j3 = SquarePants.getNonDetachedLOS();
            } else {
                j3 = 0;
            }
            QLog.d("LargeObjectHooker", 1, "los_size: " + j3);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            boolean a16 = a();
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("los_ret", String.valueOf(ret)), TuplesKt.to("los_size", String.valueOf(j3)));
            QQBeaconReport.report(str, "los_hook", a16, (Map<String, String>) hashMapOf, false);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.f257761b;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return b.f257762c;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }

        public final void c(@Nullable com.tencent.mobileqq.perf.memory.collect.a memoryUsage) {
            long coerceAtLeast;
            com.tencent.cache.api.memory.b a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) memoryUsage);
                return;
            }
            boolean z16 = true;
            if (!LargeObjectConfigParser.f257754d.a()) {
                QLog.d("LargeObjectHooker", 1, "config not received yet");
                return;
            }
            QRouteApi api = QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) api;
            if (!iUnitedConfigManager.isSwitchOn("102475", false)) {
                if (QLog.isColorLevel()) {
                    QLog.d("LargeObjectHooker", 1, "hook not enable");
                    return;
                }
                return;
            }
            com.tencent.mobileqq.perf.memory.largeobject.a aVar = (com.tencent.mobileqq.perf.memory.largeobject.a) iUnitedConfigManager.loadConfig("102475");
            if (aVar == null) {
                return;
            }
            if (aVar.a() > 0.0f) {
                if (memoryUsage == null || (a16 = memoryUsage.a()) == null) {
                    a16 = com.tencent.cache.api.memory.a.f98606b.a();
                }
                if (a16.e() < aVar.a()) {
                    return;
                }
            }
            if (!a()) {
                int a17 = SquarePants.a();
                if (a17 == 0) {
                    b.f257761b = true;
                }
                e(a17);
            }
            if (!b() && Build.VERSION.SDK_INT != 29 && !Utils.K() && aVar.b() >= 4096) {
                MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
                if (fromV2.getBoolean("los_threshold_suc", true)) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(aVar.b(), 4096L);
                    QLog.d("LargeObjectHooker", 1, "modify threshold: " + (coerceAtLeast / 1024) + 'k');
                    fromV2.putBoolean("los_threshold_suc", false);
                    fromV2.commit();
                    int d16 = SquarePants.d(coerceAtLeast);
                    fromV2.putBoolean("los_threshold_suc", true);
                    fromV2.commit();
                    QLog.d("LargeObjectHooker", 1, "modify threshold result: " + d16);
                    if (d16 != 0) {
                        z16 = false;
                    }
                    b.f257762c = z16;
                    return;
                }
                QLog.e("LargeObjectHooker", 1, "modify threshold crashed before");
            }
        }

        public final void f() {
            String str;
            HashMap hashMapOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (!a()) {
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            boolean a16 = a();
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("undetach", String.valueOf(SquarePants.getNonDetachedLOS())), TuplesKt.to("allocated", String.valueOf(SquarePants.getLOSAllocated())));
            QQBeaconReport.report(str, "los_size", a16, (Map<String, String>) hashMapOf, false);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30392);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        a aVar = new a();
        f257763d = aVar;
        c.d(aVar);
    }
}
