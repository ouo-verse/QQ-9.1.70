package com.tencent.mobileqq.webview;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import android.system.Os;
import android.system.StructStat;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.MultiProcessHelper;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.AbiUtil;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\nH\u0007J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/webview/SandBoxControl;", "", "", "a", "", "sandBoxLevel", "b", "f", "Landroid/content/Context;", "context", "", "c", "d", "g", "", "apkPath", "e", "Z", "getOpenPerf", "()Z", "setOpenPerf", "(Z)V", "openPerf", "I", "getSandboxLevel", "()I", "setSandboxLevel", "(I)V", "sandboxLevel", "Ljava/lang/Boolean;", "isOdexWorldReadable", "()Ljava/lang/Boolean;", "setOdexWorldReadable", "(Ljava/lang/Boolean;)V", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class SandBoxControl {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SandBoxControl f313756a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean openPerf;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int sandboxLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean isOdexWorldReadable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f313756a = new SandBoxControl();
        }
    }

    SandBoxControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a() {
        int i3;
        if (((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).s()) {
            if (((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).g()) {
                i3 = 3;
            } else {
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        sandboxLevel = i3;
        openPerf = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).b();
        b(sandboxLevel);
    }

    @JvmStatic
    public static final void b(int sandBoxLevel) {
        boolean z16;
        if (openPerf) {
            ((com.tencent.mobileqq.webview.swift.injector.k) aa.k(com.tencent.mobileqq.webview.swift.injector.k.class)).b(250L, 20);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TbsCoreSettings.MULTI_PROCESS_ENABLE, Integer.valueOf(sandBoxLevel));
        if (sandBoxLevel == 3) {
            z16 = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).l();
        } else {
            z16 = false;
        }
        hashMap.put(TbsCoreSettings.MULTI_PROCESS_FALLBACK_SERVICE, Boolean.valueOf(z16));
        hashMap.put(TbsCoreSettings.MULTI_PROCESS_NO_SANDBOX, Boolean.FALSE);
        Boolean bool = Boolean.TRUE;
        hashMap.put(TbsCoreSettings.MULTI_PROCESS_AUTO_RECOVERY, bool);
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, bool);
        QbSdk.initTbsSettings(hashMap);
        QLog.d("WVPerf.DebugTrace_SandBoxControl", 1, "init sandBoxLevel:" + sandBoxLevel + " fallbackEnabled:" + z16);
    }

    @JvmStatic
    public static final boolean c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isOdexWorldReadable == null) {
            isOdexWorldReadable = Boolean.valueOf(f313756a.d(context));
        }
        Boolean bool = isOdexWorldReadable;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    private final boolean d(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.getApplicationInfo()");
        String str = applicationInfo.sourceDir;
        Intrinsics.checkNotNullExpressionValue(str, "appInfo.sourceDir");
        String e16 = e(str);
        try {
            StructStat stat = Os.stat(e16);
            Intrinsics.checkNotNullExpressionValue(stat, "stat(oatPath)");
            if (QLog.isColorLevel()) {
                QLog.d("WVPerf.DebugTrace_SandBoxControl", 2, "isOdexWorldReadable: " + e16 + " mode: " + stat.st_mode);
            }
            if ((stat.st_mode & 7) == 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            QLog.e("WVPerf.DebugTrace_SandBoxControl", 1, "isOdexWorldReadable ex:" + th5.getMessage());
            return false;
        }
    }

    @JvmStatic
    public static final void f() {
        int multiProcessType = MultiProcessHelper.getMultiProcessType();
        boolean multiProcessFallbackServiceEnabled = MultiProcessHelper.getMultiProcessFallbackServiceEnabled();
        String multiProcessChoseTypeReason = MultiProcessHelper.getMultiProcessChoseTypeReason();
        boolean multiProcessNoSandBoxEnabled = MultiProcessHelper.getMultiProcessNoSandBoxEnabled();
        boolean multiProcessAutoRecoveryEnabled = MultiProcessHelper.getMultiProcessAutoRecoveryEnabled();
        if (sandboxLevel == 3) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QLog.d("WVPerf.DebugTrace_SandBoxControl", 1, "read type:" + multiProcessType + " fallbackOn:" + multiProcessFallbackServiceEnabled + " isOdexWorldReadable:" + c(context) + " softSandBoxOn:" + multiProcessNoSandBoxEnabled + " crashRecoveryOn:" + multiProcessAutoRecoveryEnabled + " msg:{" + multiProcessChoseTypeReason + "}");
        } else {
            QLog.d("WVPerf.DebugTrace_SandBoxControl", 1, "read type:" + multiProcessType + " fallbackOn:" + multiProcessFallbackServiceEnabled + " softSandBoxOn:" + multiProcessNoSandBoxEnabled + " crashRecoveryOn:" + multiProcessAutoRecoveryEnabled + " msg:{" + multiProcessChoseTypeReason + "}");
        }
        if (openPerf) {
            QLog.d("WVPerf.DebugTrace_SandBoxControl", 1, "multiProcessType=" + multiProcessType + " initTbsCost=" + SwiftBrowserStatistics.W0 + " initTbsDone2PageFinishCost=" + (SystemClock.elapsedRealtime() - SwiftBrowserStatistics.X0));
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webview.SandBoxControl$onPageFinished$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.d("WVPerf.DebugTrace_SandBoxControl", 1, "perf:" + ((com.tencent.mobileqq.webview.swift.injector.k) aa.k(com.tencent.mobileqq.webview.swift.injector.k.class)).a());
                }
            }, 2000L);
        }
    }

    @JvmStatic
    public static final boolean g() {
        int multiProcessType = MultiProcessHelper.getMultiProcessType();
        if (multiProcessType == 1) {
            return true;
        }
        if (multiProcessType == 3) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (c(context)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String e(@NotNull String apkPath) {
        String str;
        int lastIndexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) apkPath);
        }
        Intrinsics.checkNotNullParameter(apkPath, "apkPath");
        if (AbiUtil.isArm64Runtime(BaseApplication.context)) {
            str = ResourceAttributes.HostArchValues.ARM64;
        } else {
            str = AbiUtil.ARM;
        }
        File file = new File(apkPath);
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "apkFile.getName()");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null);
        String substring = name.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String format = String.format("%s/oat/%s/%s.odex", file.getParent(), str, substring);
        Intrinsics.checkNotNullExpressionValue(format, "format(\"%s/oat/%s/%s.ode\u2026ent(), isaName, baseName)");
        return format;
    }
}
