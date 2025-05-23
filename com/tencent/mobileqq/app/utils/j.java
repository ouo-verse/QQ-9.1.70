package com.tencent.mobileqq.app.utils;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ.\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/app/utils/j;", "", "Landroid/content/Context;", "context", "", "currentDeviceWidth", "", "uiDesignWidth", "revolutionScale", "sysDensityDpiScale", "a", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f196669a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f196669a = new j();
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final float a(@NotNull Context context, int currentDeviceWidth, float uiDesignWidth, float revolutionScale, float sysDensityDpiScale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(currentDeviceWidth), Float.valueOf(uiDesignWidth), Float.valueOf(revolutionScale), Float.valueOf(sysDensityDpiScale))).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("GlobalDensityComputer2", 1, "[computeDensity]: currentDeviceWidth is " + currentDeviceWidth + ", revolutionScale is " + revolutionScale + ", sysDensityDpiScale is " + sysDensityDpiScale);
        return ((revolutionScale * sysDensityDpiScale) * currentDeviceWidth) / uiDesignWidth;
    }
}
