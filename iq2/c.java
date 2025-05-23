package iq2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.SearchTransAnimUtil;
import com.tencent.qphone.base.util.QLog;
import iq2.c;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static SoftReference<Bitmap> f408208a = new SoftReference<>(null);

    /* renamed from: b, reason: collision with root package name */
    private static long f408209b;

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
                f408208a = new SoftReference<>(createBitmap);
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
            Bitmap bitmap = f408208a.get();
            f408208a.clear();
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        } catch (Throwable th5) {
            QLog.e("IndexSearchTransAnimUtil", 2, HippyReporter.RemoveEngineReason.CLEAR_CACHE, th5);
        }
    }

    public static boolean g() {
        return f408208a.get() != null;
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
            QLog.d("IndexSearchTransAnimUtil", 2, str + " spend time: " + (System.currentTimeMillis() - f408209b));
        }
    }

    private static void j() {
        f408209b = System.currentTimeMillis();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f408210d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f408211e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f408212f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QUISearchBar f408213h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f408214i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Runnable f408215m;

        a(ViewGroup viewGroup, View view, int i3, QUISearchBar qUISearchBar, View view2, Runnable runnable) {
            this.f408210d = viewGroup;
            this.f408211e = view;
            this.f408212f = i3;
            this.f408213h = qUISearchBar;
            this.f408214i = view2;
            this.f408215m = runnable;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f408210d.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f408211e.setY(0.0f);
            this.f408211e.animate().translationY(-this.f408212f).alpha(0.5f).setDuration(250L).start();
            this.f408213h.animate().translationY(0.0f).setDuration(250L).start();
            this.f408214i.animate().alpha(1.0f).setDuration(250L).start();
            QUISearchBar qUISearchBar = this.f408213h;
            final View view = this.f408211e;
            final Runnable runnable = this.f408215m;
            SearchTransAnimUtil.doAnimToCurUITrans(qUISearchBar, 1, new Runnable() { // from class: iq2.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.b(view, runnable);
                }
            });
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(View view, Runnable runnable) {
            view.setVisibility(8);
            c.i("runEnterAnim");
            c.f(runnable);
        }
    }

    public static void k(ViewGroup viewGroup, QUISearchBar qUISearchBar, View view, Runnable runnable) {
        if (viewGroup != null && qUISearchBar != null && view != null) {
            Bitmap bitmap = f408208a.get();
            if (bitmap == null) {
                QLog.d("IndexSearchTransAnimUtil", 2, "bmp is null");
                f(runnable);
                return;
            }
            j();
            View view2 = new View(viewGroup.getContext());
            view2.setBackground(new BitmapDrawable(viewGroup.getResources(), bitmap));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bitmap.getWidth(), bitmap.getHeight());
            view2.setId(R.id.f61932zg);
            viewGroup.addView(view2, layoutParams);
            int i3 = layoutParams.height;
            qUISearchBar.setY((i3 - ViewUtils.getStatusBarHeight(viewGroup.getContext())) + 15.0f);
            view.setAlpha(0.0f);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new a(viewGroup, view2, i3, qUISearchBar, view, runnable));
            return;
        }
        QLog.e("IndexSearchTransAnimUtil", 2, "some view is null " + viewGroup + " ," + qUISearchBar + ", " + view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void l(final ViewGroup viewGroup, QUISearchBar qUISearchBar, View view, final Runnable runnable) {
        if (viewGroup == null || qUISearchBar == null || view == null) {
            return;
        }
        j();
        View findViewById = viewGroup.findViewById(R.id.f61932zg);
        if (findViewById == null) {
            f(runnable);
            return;
        }
        findViewById.setVisibility(0);
        view.animate().alpha(0.0f).setDuration(250L).start();
        findViewById.animate().translationY(0.0f).alpha(1.0f).setDuration(250L).start();
        qUISearchBar.animate().translationY((findViewById.getLayoutParams().height - ViewUtils.getStatusBarHeight(viewGroup.getContext())) + 15.0f).setDuration(250L).start();
        SearchTransAnimUtil.doAnimFromCurUITrans(qUISearchBar, 1, new Runnable() { // from class: iq2.a
            @Override // java.lang.Runnable
            public final void run() {
                c.h(viewGroup, runnable);
            }
        });
    }
}
