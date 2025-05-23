package com.tencent.qqnt.aio.utils;

import android.util.DisplayMetrics;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\r\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/utils/ViewUtils;", "", "", "e", "d", "dpValue", "b", "", "a", "pxValue", "f", "I", "screenWidth", "c", "screenHeight", "Landroid/util/DisplayMetrics;", "Lkotlin/Lazy;", "()Landroid/util/DisplayMetrics;", "displayMetrics", "densityDpi", UserInfo.SEX_FEMALE, "density", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ViewUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ViewUtils f352270a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int screenWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int screenHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy displayMetrics;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int densityDpi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final float density;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52491);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ViewUtils viewUtils = new ViewUtils();
        f352270a = viewUtils;
        screenWidth = -1;
        screenHeight = -1;
        lazy = LazyKt__LazyJVMKt.lazy(ViewUtils$displayMetrics$2.INSTANCE);
        displayMetrics = lazy;
        densityDpi = viewUtils.c().densityDpi;
        density = viewUtils.c().density;
    }

    ViewUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final DisplayMetrics c() {
        Object value = displayMetrics.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-displayMetrics>(...)");
        return (DisplayMetrics) value;
    }

    public final int a(float dpValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Float.valueOf(dpValue))).intValue();
        }
        return (int) ((dpValue * density) + 0.5f);
    }

    public final int b(int dpValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, dpValue)).intValue();
        }
        return a(dpValue);
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (screenHeight < 0) {
            if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
                screenHeight = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
            } else {
                screenHeight = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
            }
        }
        return screenHeight;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (screenWidth < 0) {
            if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
                screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
            } else {
                screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
            }
        }
        return screenWidth;
    }

    public final int f(int pxValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, pxValue)).intValue();
        }
        return (int) (pxValue / density);
    }
}
