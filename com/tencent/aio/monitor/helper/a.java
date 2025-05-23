package com.tencent.aio.monitor.helper;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/aio/monitor/helper/a;", "", "Landroid/content/Context;", "context", "", "b", "", "start", "end", "devRefreshRate", "", "a", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "c", "()Ljava/text/SimpleDateFormat;", "TIME_FORMATTER", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat TIME_FORMATTER;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f69420b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f69420b = new a();
            TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public final int a(long start, long end, float devRefreshRate) {
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Long.valueOf(start), Long.valueOf(end), Float.valueOf(devRefreshRate))).intValue();
        }
        long convert = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
        roundToInt = MathKt__MathJVMKt.roundToInt(devRefreshRate);
        long j3 = roundToInt;
        if (1 > j3 || convert <= j3) {
            return 0;
        }
        return (int) (convert / j3);
    }

    public final float b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "windowManager.defaultDisplay");
            return defaultDisplay.getRefreshRate();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @NotNull
    public final SimpleDateFormat c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SimpleDateFormat) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return TIME_FORMATTER;
    }
}
