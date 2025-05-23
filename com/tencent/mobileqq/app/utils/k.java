package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/app/utils/k;", "", "Landroid/content/Context;", "context", "", "", "b", "Landroid/content/res/Configuration;", "configuration", "c", "currentWidth", "", "uiDesignWidth", "oldDensity", "systemDensityScale", "a", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f196670a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37358);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f196670a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Set<Integer> b(Context context) {
        HashSet hashSet = new HashSet();
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display.Mode[] supportedModes = ((WindowManager) systemService).getDefaultDisplay().getSupportedModes();
        Intrinsics.checkNotNullExpressionValue(supportedModes, "windowManager.defaultDisplay.supportedModes");
        for (Display.Mode mode : supportedModes) {
            if (!hashSet.contains(Integer.valueOf(mode.getPhysicalWidth()))) {
                hashSet.add(Integer.valueOf(mode.getPhysicalWidth()));
                QLog.i("GlobalDensityComputer3", 1, "[getAllWidth]: addWidth " + mode.getPhysicalWidth());
            }
        }
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        int c16 = c(configuration);
        if (!hashSet.contains(Integer.valueOf(c16))) {
            hashSet.add(Integer.valueOf(c16));
        }
        return hashSet;
    }

    private final int c(Configuration configuration) {
        int i3 = configuration.smallestScreenWidthDp;
        int i16 = configuration.densityDpi;
        int i17 = (int) (i3 * (i16 / 160));
        QLog.i("GlobalDensityComputer3", 1, "[getDeviceWidthByConfiguration]: smallestWidth is " + i3 + " densityDpi is " + i16 + " densityDefault is 160 width is " + i17);
        return i17;
    }

    public final float a(@NotNull Context context, int currentWidth, float uiDesignWidth, float oldDensity, float systemDensityScale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(currentWidth), Float.valueOf(uiDesignWidth), Float.valueOf(oldDensity), Float.valueOf(systemDensityScale))).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<T> it = b(context).iterator();
        while (it.hasNext()) {
            float f16 = currentWidth;
            float intValue = ((Number) it.next()).intValue() / f16;
            float f17 = ((intValue * systemDensityScale) * f16) / uiDesignWidth;
            QLog.i("GlobalDensityComputer3", 1, "[computeDensity]: revolutionScale is " + intValue + ", systemDensityScale is " + systemDensityScale + ", currentWidth is " + currentWidth);
            if (GlobalDisplayMetricsManager.checkAdjustInRange(context, f17, oldDensity)) {
                return f17;
            }
        }
        return -1.0f;
    }
}
