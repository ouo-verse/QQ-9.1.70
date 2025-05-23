package com.tencent.mobileqq.login.relogin.anim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.login.relogin.fragment.SplashLoginSuccessAnimator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J7\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00022\n\u0010\u000e\u001a\u00020\r\"\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/anim/a;", "", "Landroid/view/View;", "view", "", "startX", "startY", "", "onlyBackground", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;", "a", "(Landroid/view/View;IIZ)Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;", "viewGroup", "", "childArr", "totalViewSize", "c", "(Landroid/view/View;[IZ)Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f242420a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23071);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f242420a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ SplashLoginSuccessAnimator.a b(a aVar, View view, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        if ((i17 & 8) != 0) {
            z16 = false;
        }
        return aVar.a(view, i3, i16, z16);
    }

    public static /* synthetic */ SplashLoginSuccessAnimator.a d(a aVar, View view, int[] iArr, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return aVar.c(view, iArr, z16);
    }

    @Nullable
    public final SplashLoginSuccessAnimator.a a(@NotNull View view, int startX, int startY, boolean onlyBackground) {
        int i3;
        int i16;
        int i17;
        int i18;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SplashLoginSuccessAnimator.a) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(startX), Integer.valueOf(startY), Boolean.valueOf(onlyBackground));
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable drawable = imageView.getDrawable();
                if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                    ImageView.ScaleType scaleType = imageView.getScaleType();
                    Intrinsics.checkNotNullExpressionValue(scaleType, "view.scaleType");
                    return new SplashLoginSuccessAnimator.a(bitmap, iArr[0], iArr[1], imageView.getWidth(), imageView.getHeight(), 0.0f, null, scaleType, 96, null);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            if (onlyBackground) {
                Drawable background = view.getBackground();
                if (background != null) {
                    background.draw(canvas);
                }
            } else {
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                view.draw(canvas);
            }
            if (startX > 0 && startX > (i18 = iArr[0]) && startX < i18 + view.getWidth()) {
                i3 = startX - iArr[0];
                iArr[0] = startX;
            } else {
                i3 = 0;
            }
            if (startY > 0 && startY > (i17 = iArr[1]) && startY < i17 + view.getHeight()) {
                i16 = startY - iArr[1];
                iArr[1] = startY;
            } else {
                i16 = 0;
            }
            if (i3 <= 0 && i16 <= 0) {
                return new SplashLoginSuccessAnimator.a(createBitmap, iArr[0], iArr[1], view.getWidth(), view.getHeight(), 0.0f, null, null, 224, null);
            }
            Rect rect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, i3, i16, rect.width() - i3, rect.height() - i16);
            createBitmap.recycle();
            return new SplashLoginSuccessAnimator.a(createBitmap2, iArr[0], iArr[1], rect.width() - i3, rect.height() - i16, 0.0f, null, null, 224, null);
        }
        QLog.i("CaptureUtils", 1, "captureView view size error: " + view);
        return null;
    }

    @Nullable
    public final SplashLoginSuccessAnimator.a c(@NotNull View viewGroup, @NotNull int[] childArr, boolean totalViewSize) {
        int coerceAtMost;
        int coerceAtMost2;
        int coerceAtLeast;
        int coerceAtLeast2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SplashLoginSuccessAnimator.a) iPatchRedirector.redirect((short) 3, this, viewGroup, childArr, Boolean.valueOf(totalViewSize));
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(childArr, "childArr");
        if (viewGroup.getWidth() > 0 && viewGroup.getHeight() > 0) {
            int[] iArr = new int[2];
            viewGroup.getLocationInWindow(iArr);
            ArrayList<View> arrayList = new ArrayList();
            for (int i3 : childArr) {
                View findViewById = viewGroup.findViewById(i3);
                if (findViewById != null) {
                    arrayList.add(findViewById);
                }
            }
            if (arrayList.isEmpty()) {
                QLog.e("CaptureUtils", 1, "captureViewGroup child view is empty");
                return null;
            }
            if (totalViewSize) {
                Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                for (View view : arrayList) {
                    canvas.save();
                    canvas.translate(view.getLeft(), view.getTop());
                    view.draw(canvas);
                    canvas.restore();
                }
                return new SplashLoginSuccessAnimator.a(createBitmap, iArr[0], iArr[1], viewGroup.getWidth(), viewGroup.getHeight(), 0.0f, null, null, 224, null);
            }
            Rect rect = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
            for (View view2 : arrayList) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(view2.getLeft(), rect.left);
                rect.left = coerceAtMost;
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(view2.getTop(), rect.top);
                rect.top = coerceAtMost2;
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(view2.getRight(), rect.right);
                rect.right = coerceAtLeast;
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(view2.getBottom(), rect.bottom);
                rect.bottom = coerceAtLeast2;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            for (View view3 : arrayList) {
                canvas2.save();
                canvas2.translate(view3.getLeft() - rect.left, view3.getTop() - rect.top);
                view3.draw(canvas2);
                canvas2.restore();
            }
            return new SplashLoginSuccessAnimator.a(createBitmap2, iArr[0] + rect.left, iArr[1] + rect.top, rect.width(), rect.height(), 0.0f, null, null, 224, null);
        }
        QLog.e("CaptureUtils", 1, "captureViewGroup view size is error: " + viewGroup.getWidth() + ", " + viewGroup.getHeight());
        return null;
    }
}
