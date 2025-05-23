package com.tencent.qqnt.qbasealbum.utils;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.TouchDelegate;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ0\u0010\u0012\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/d;", "", "", tl.h.F, "", "g", "f", "Landroid/content/Context;", "context", "", "dp", "b", "Landroid/view/View;", "touchView", "top", "bottom", "left", "right", "d", UserInfo.SEX_FEMALE, "density", "c", "I", "screenWidth", "screenHeight", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f361649a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static float density;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int screenWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int screenHeight;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        d dVar = new d();
        f361649a = dVar;
        density = -1.0f;
        screenWidth = -1;
        screenHeight = -1;
        dVar.h();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ int c(d dVar, Context context, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = com.tencent.qqnt.qbasealbum.inject.a.f361230a.a();
        }
        return dVar.b(context, f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view, int i3, int i16, int i17, int i18) {
        f361649a.d(view, i3, i16, i17, i18);
    }

    public final int b(@NotNull Context context, float dp5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, context, Float.valueOf(dp5))).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp5 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    public final void d(@Nullable final View touchView, final int top, final int bottom, final int left, final int right) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, touchView, Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(left), Integer.valueOf(right));
            return;
        }
        if (touchView == null) {
            return;
        }
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Object parent = touchView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(touchView, top, bottom, left, right);
                }
            });
            return;
        }
        Rect rect = new Rect();
        touchView.setEnabled(true);
        touchView.getHitRect(rect);
        rect.top -= top;
        rect.bottom += bottom;
        rect.left -= left;
        rect.right += right;
        if (QLog.isColorLevel()) {
            QLog.d("expandViewTouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
        }
        TouchDelegate touchDelegate = new TouchDelegate(rect, touchView);
        if (View.class.isInstance(touchView.getParent())) {
            Object parent2 = touchView.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            ((View) parent2).setTouchDelegate(touchDelegate);
        }
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return screenHeight;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return screenWidth;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        DisplayMetrics displayMetrics = com.tencent.qqnt.qbasealbum.inject.a.f361230a.a().getResources().getDisplayMetrics();
        density = displayMetrics.density;
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if (i3 < i16) {
            screenWidth = i3;
            screenHeight = i16;
        } else {
            screenHeight = i3;
            screenWidth = i16;
        }
    }
}
