package com.tencent.mobileqq.tvideo.floatingwindow;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\bR\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/tvideo/floatingwindow/d;", "", "Landroid/view/View;", "floatingWindowView", "Landroid/widget/PopupWindow;", "k", "Landroid/widget/ImageView;", "targetView", "", "l", tl.h.F, "popupWindow", "e", "", "f", "g", "Landroidx/lifecycle/Observer;", "", "b", "Landroidx/lifecycle/Observer;", "watchDurationObserver", "c", "Z", "waiteShow", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f304435a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Observer<Integer> watchDurationObserver;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean waiteShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/tvideo/floatingwindow/d$a", "Lcom/tencent/mobileqq/tvideo/floatingwindow/e;", "", "duration", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends e {
        a(ImageView imageView) {
            super(imageView);
        }

        public void a(int duration) {
            if (duration >= 10 && ScreenUtils.isPortrait()) {
                if (d.watchDurationObserver != null) {
                    MutableLiveData<Integer> c16 = fy2.b.f400938a.c();
                    Observer<? super Integer> observer = d.watchDurationObserver;
                    Intrinsics.checkNotNull(observer);
                    c16.removeObserver(observer);
                }
                View view = this.f304438d.get();
                if (view != null) {
                    d.f304435a.h(view);
                }
            }
        }

        @Override // androidx.lifecycle.Observer
        public /* bridge */ /* synthetic */ void onChanged(Integer num) {
            a(num.intValue());
        }
    }

    d() {
    }

    private final void e(PopupWindow popupWindow) {
        if (popupWindow != null) {
            try {
                popupWindow.dismiss();
            } catch (Exception e16) {
                QLog.e("TVideoFloatingWindowGuideHelper", 2, "dismiss Exception: " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final View targetView) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.b
            @Override // java.lang.Runnable
            public final void run() {
                d.i(targetView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        final PopupWindow k3 = f304435a.k(targetView);
        waiteShow = false;
        k.a().j("tvideo_floating_window_guide_key", true);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.c
            @Override // java.lang.Runnable
            public final void run() {
                d.j(k3);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(PopupWindow popupWindow) {
        f304435a.e(popupWindow);
    }

    @SuppressLint({"InflateParams"})
    private final PopupWindow k(View floatingWindowView) {
        PopupWindow popupWindow = null;
        try {
            View inflate = LayoutInflater.from(floatingWindowView.getContext()).inflate(R.layout.i2d, (ViewGroup) null);
            PopupWindow popupWindow2 = new PopupWindow(inflate, -2, -2, true);
            try {
                popupWindow2.setFocusable(true);
                popupWindow2.setOutsideTouchable(true);
                inflate.measure(0, 0);
                popupWindow2.showAsDropDown(floatingWindowView, (-(inflate.getMeasuredWidth() - floatingWindowView.getMeasuredWidth())) / 2, (-floatingWindowView.getHeight()) / 4);
                popupWindow2.update();
                return popupWindow2;
            } catch (Exception e16) {
                e = e16;
                popupWindow = popupWindow2;
                QLog.e("TVideoFloatingWindowGuideHelper", 2, "Exception: " + e);
                return popupWindow;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @JvmStatic
    public static final void l(@NotNull ImageView targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        d dVar = f304435a;
        if (!dVar.f() || waiteShow) {
            return;
        }
        waiteShow = true;
        fy2.b bVar = fy2.b.f400938a;
        if (bVar.b() >= 10) {
            dVar.h(targetView);
            return;
        }
        watchDurationObserver = new a(targetView);
        MutableLiveData<Integer> c16 = bVar.c();
        Observer<Integer> observer = watchDurationObserver;
        Intrinsics.checkNotNull(observer);
        c16.observeForever(observer);
    }

    public final boolean f() {
        if (k.a().c("tvideo_floating_window_guide_key", false) || !com.tencent.mobileqq.tvideo.floatingwindow.a.a().e()) {
            return false;
        }
        return true;
    }

    public final void g() {
        if (waiteShow) {
            waiteShow = false;
            if (watchDurationObserver != null) {
                MutableLiveData<Integer> c16 = fy2.b.f400938a.c();
                Observer<Integer> observer = watchDurationObserver;
                Intrinsics.checkNotNull(observer);
                c16.removeObserver(observer);
            }
        }
    }
}
