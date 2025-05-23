package com.tencent.mobileqq.webview.swift.startup.step;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.v;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.RandomKt;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/InitX5StrategyStep;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserGlobalStep;", "", "j", "", "k", "mask", "sample", "", "i", h.F, "", "e", "f", "<init>", "()V", "d", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class InitX5StrategyStep extends BrowserGlobalStep {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f314689e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/InitX5StrategyStep$a;", "", "", "a", "", "INDEX_OF_DPC_CONFIG_MASK", "I", "INDEX_OF_DPC_CONFIG_SAMPLE", "", "LAST_PRELOAD_STRATEGY_MASK", "Ljava/lang/String;", "LAST_PRELOAD_STRATEGY_SAMPLE", "PRELOAD_STRATEGY_SWITCH", "TAG", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.swift.startup.step.InitX5StrategyStep$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final boolean a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                t.Companion companion = t.INSTANCE;
                if (companion.a().i("debug_enable_x5_preload")) {
                    boolean booleanValue = ((Boolean) companion.a().b("debug_enable_x5_preload", Boolean.TRUE)).booleanValue();
                    QLog.d("InitX5StrategyStep", 1, "isX5PreloadOn:" + booleanValue + " by debugSwitch");
                    return booleanValue;
                }
            }
            t b16 = t.INSTANCE.b("busi_preload_");
            boolean i3 = b16.i("x5_preload_strategy_switch");
            if (i3) {
                z16 = ((Boolean) b16.b("x5_preload_strategy_switch", Boolean.FALSE)).booleanValue();
            } else {
                z16 = false;
            }
            QLog.d("InitX5StrategyStep", 1, "isX5PreloadOn:" + z16 + " has:" + i3);
            return z16;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44694);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InitX5StrategyStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void i(int mask, float sample) {
        boolean z16;
        boolean z17;
        int checkRadix;
        int deviceLevel = ((v) aa.k(v.class)).getDeviceLevel();
        if (((1 << deviceLevel) & mask) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && RandomKt.Random(System.currentTimeMillis()).nextFloat() < sample) {
            z17 = true;
        } else {
            z17 = false;
        }
        t b16 = t.INSTANCE.b("busi_preload_");
        b16.d("x5_preload_strategy_switch", Boolean.valueOf(z17));
        b16.d("x5_preload_last_strategy_mask", Integer.valueOf(mask));
        b16.d("x5_preload_last_strategy_sample", Float.valueOf(sample));
        b16.g();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(mask, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(sample)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("InitX5StrategyStep", 1, "switchOn:" + z17 + " deviceLevel:" + deviceLevel + " deviceOn:" + z16 + " strategy:0x" + num + " sample:" + format);
    }

    private final int j() {
        List split$default;
        String dpc = WebAccelerateHelper.getInstance().getTBSDpcParam();
        Intrinsics.checkNotNullExpressionValue(dpc, "dpc");
        split$default = StringsKt__StringsKt.split$default((CharSequence) dpc, new String[]{"|"}, false, 0, 6, (Object) null);
        if (split$default.size() >= 5) {
            return Integer.parseInt((String) split$default.get(4));
        }
        return 0;
    }

    private final float k() {
        List split$default;
        String dpc = WebAccelerateHelper.getInstance().getTBSDpcParam();
        Intrinsics.checkNotNullExpressionValue(dpc, "dpc");
        split$default = StringsKt__StringsKt.split$default((CharSequence) dpc, new String[]{"|"}, false, 0, 6, (Object) null);
        if (split$default.size() >= 6) {
            return Float.parseFloat((String) split$default.get(5));
        }
        return 0.0f;
    }

    @Override // com.tencent.mobileqq.webview.swift.startup.c
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return f314689e;
    }

    @Override // com.tencent.mobileqq.webview.swift.startup.c
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            f314689e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        if (r7 == false) goto L18;
     */
    @Override // com.tencent.mobileqq.webview.swift.startup.step.BrowserGlobalStep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int h() {
        int checkRadix;
        int checkRadix2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        t b16 = t.INSTANCE.b("busi_preload_");
        if (!b16.i("x5_preload_strategy_switch")) {
            QLog.d("InitX5StrategyStep", 1, "no strategy");
            i(j(), k());
        } else {
            int intValue = ((Number) b16.b("x5_preload_last_strategy_mask", -1)).intValue();
            float floatValue = ((Number) b16.b("x5_preload_last_strategy_sample", Float.valueOf(-1.0f))).floatValue();
            int j3 = j();
            float k3 = k();
            if (j3 == intValue) {
                if (k3 == floatValue) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            String num = Integer.toString(intValue, checkRadix);
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            checkRadix2 = CharsKt__CharJVMKt.checkRadix(16);
            String num2 = Integer.toString(j3, checkRadix2);
            Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(floatValue)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String format2 = String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(k3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            QLog.d("InitX5StrategyStep", 1, "strategy mask or sample changes 0x" + num + " to 0x" + num2 + " " + format + " to " + format2);
            i(j3, k3);
        }
        return super.h();
    }
}
