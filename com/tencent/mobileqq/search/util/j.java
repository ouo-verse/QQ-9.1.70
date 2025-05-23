package com.tencent.mobileqq.search.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.j;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.SearchTransAnimUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static SoftReference<Bitmap> f285047a = new SoftReference<>(null);

    /* renamed from: b, reason: collision with root package name */
    private static long f285048b;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f285049d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f285050e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f285051f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QUISearchBar f285052h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f285053i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Runnable f285054m;

        a(FrameLayout frameLayout, View view, int i3, QUISearchBar qUISearchBar, View view2, Runnable runnable) {
            this.f285049d = frameLayout;
            this.f285050e = view;
            this.f285051f = i3;
            this.f285052h = qUISearchBar;
            this.f285053i = view2;
            this.f285054m = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(View view, Runnable runnable) {
            view.setVisibility(8);
            j.i("runEnterAnim");
            j.f(runnable);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f285049d.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f285050e.setY(0.0f);
            this.f285050e.animate().translationY(-this.f285051f).alpha(0.5f).setDuration(250L).start();
            this.f285052h.animate().translationY(0.0f).setDuration(250L).start();
            this.f285053i.animate().alpha(1.0f).setDuration(250L).start();
            QUISearchBar qUISearchBar = this.f285052h;
            final View view = this.f285050e;
            final Runnable runnable = this.f285054m;
            SearchTransAnimUtil.doAnimToCurUITrans(qUISearchBar, 1, new Runnable() { // from class: com.tencent.mobileqq.search.util.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.a.b(view, runnable);
                }
            });
            return false;
        }
    }

    public static void d(View view, View view2) {
        if (Build.VERSION.SDK_INT >= 26 && y.e() && !AppSetting.t(view.getContext())) {
            try {
                j();
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                view.draw(canvas);
                if (view2 != null) {
                    canvas.save();
                    view2.getLocationOnScreen(new int[2]);
                    canvas.translate(r7[0], r7[1]);
                    view2.draw(canvas);
                    canvas.restore();
                }
                f285047a = new SoftReference<>(createBitmap);
                i("captureView");
                return;
            } catch (Throwable th5) {
                QLog.e("IndexSearchTransAnimUtil", 2, "captureView", th5);
                return;
            }
        }
        QLog.d("IndexSearchTransAnimUtil", 2, "don't capture view");
    }

    private static void e() {
        try {
            Bitmap bitmap = f285047a.get();
            f285047a.clear();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } catch (Throwable th5) {
            QLog.e("IndexSearchTransAnimUtil", 2, HippyReporter.RemoveEngineReason.CLEAR_CACHE, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(@Nullable Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static boolean g() {
        if (f285047a.get() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(ViewGroup viewGroup, Runnable runnable) {
        i("runExitAnim");
        viewGroup.setVisibility(8);
        f(runnable);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("IndexSearchTransAnimUtil", 2, str + " spend time: " + (System.currentTimeMillis() - f285048b));
        }
    }

    private static void j() {
        f285048b = System.currentTimeMillis();
    }

    public static void k(FrameLayout frameLayout, QUISearchBar qUISearchBar, View view, @Nullable Runnable runnable) {
        if (frameLayout != null && qUISearchBar != null && view != null) {
            Bitmap bitmap = f285047a.get();
            if (bitmap == null) {
                QLog.d("IndexSearchTransAnimUtil", 2, "bmp is null");
                f(runnable);
                return;
            }
            j();
            View view2 = new View(frameLayout.getContext());
            view2.setBackground(new BitmapDrawable(frameLayout.getResources(), bitmap));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bitmap.getWidth(), bitmap.getHeight());
            view2.setId(R.id.f61932zg);
            frameLayout.addView(view2, layoutParams);
            int i3 = layoutParams.height;
            qUISearchBar.setY(i3 - ViewUtils.getStatusBarHeight(frameLayout.getContext()));
            view.setAlpha(0.0f);
            frameLayout.getViewTreeObserver().addOnPreDrawListener(new a(frameLayout, view2, i3, qUISearchBar, view, runnable));
            return;
        }
        QLog.e("IndexSearchTransAnimUtil", 2, "some view is null " + frameLayout + " ," + qUISearchBar + ", " + view);
    }

    public static void l(final ViewGroup viewGroup, QUISearchBar qUISearchBar, View view, final Runnable runnable) {
        if (viewGroup != null && qUISearchBar != null && view != null) {
            j();
            View findViewById = viewGroup.findViewById(R.id.f61932zg);
            if (findViewById == null) {
                f(runnable);
                return;
            }
            findViewById.setVisibility(0);
            view.animate().alpha(0.0f).setDuration(250L).start();
            findViewById.animate().translationY(0.0f).alpha(1.0f).setDuration(250L).start();
            qUISearchBar.animate().translationY(findViewById.getLayoutParams().height - ViewUtils.getStatusBarHeight(qUISearchBar.getContext())).setDuration(250L).start();
            SearchTransAnimUtil.doAnimFromCurUITrans(qUISearchBar, 1, new Runnable() { // from class: com.tencent.mobileqq.search.util.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.h(viewGroup, runnable);
                }
            });
        }
    }
}
