package com.tencent.qui.quiblurview;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qui/quiblurview/c;", "", "Landroid/content/Context;", "context", "", "c", "", "a", "b", "Ljava/lang/Boolean;", "isDeviceRecommendedForBlur", "getOverwriteDeviceRecommendedForBlur", "()Ljava/lang/Boolean;", "setOverwriteDeviceRecommendedForBlur", "(Ljava/lang/Boolean;)V", "overwriteDeviceRecommendedForBlur", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Boolean isDeviceRecommendedForBlur;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean overwriteDeviceRecommendedForBlur;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final c f363628c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8461);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f363628c = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    private final long a(Context context) {
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        return 0L;
    }

    private final boolean c(Context context) {
        boolean z16;
        b c16 = QQBlurDeviceConfigHolder.INSTANCE.a().c();
        long a16 = f363628c.a(context);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= c16.b() && a16 >= c16.c() * 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        ud0.d.g("QQBlurHelper", ud0.d.f438811e, "[isDeviceRecommendedForBlurReal] result=" + z16 + " sdk=" + i3 + " memorySize=" + a16 + " apiLevel=" + c16.b() + " memorySizeInGigaByte=" + c16.c());
        return z16;
    }

    public final boolean b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean bool = overwriteDeviceRecommendedForBlur;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean bool2 = isDeviceRecommendedForBlur;
        if (bool2 != null) {
            Intrinsics.checkNotNull(bool2);
            return bool2.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(c(context));
        isDeviceRecommendedForBlur = valueOf;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.booleanValue();
    }
}
