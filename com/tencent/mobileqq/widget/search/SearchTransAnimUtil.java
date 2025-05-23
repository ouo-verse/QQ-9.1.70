package com.tencent.mobileqq.widget.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SearchTransAnimUtil {
    public static final int ANIM_TIME = 250;
    private static final String TAG = "SearchTransAnimUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f317277d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f317278e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SparseArray f317279f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f317280h;

        a(ViewPropertyAnimator viewPropertyAnimator, AtomicInteger atomicInteger, SparseArray sparseArray, Runnable runnable) {
            this.f317277d = viewPropertyAnimator;
            this.f317278e = atomicInteger;
            this.f317279f = sparseArray;
            this.f317280h = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f317277d.setListener(null);
            if (this.f317278e.incrementAndGet() == this.f317279f.size()) {
                SearchTransAnimUtil.doAfterAnimRunnable(this.f317280h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f317281d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f317282e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SparseArray f317283f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f317284h;

        b(ViewPropertyAnimator viewPropertyAnimator, AtomicInteger atomicInteger, SparseArray sparseArray, Runnable runnable) {
            this.f317281d = viewPropertyAnimator;
            this.f317282e = atomicInteger;
            this.f317283f = sparseArray;
            this.f317284h = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f317281d.setListener(null);
            if (this.f317282e.incrementAndGet() == this.f317283f.size()) {
                SearchTransAnimUtil.doAfterAnimRunnable(this.f317284h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doAfterAnimRunnable(@Nullable Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void doAnimFromCurUITrans(@NonNull QUISearchBar qUISearchBar, int i3, @Nullable Runnable runnable) {
        float f16;
        if (qUISearchBar.getCurStyle() == i3) {
            return;
        }
        SparseArray<SearchAnimProp> animViewPropList = qUISearchBar.findQUISearchBarStyler().getAnimViewPropList();
        SparseArray<SearchAnimProp> animViewPropList2 = qUISearchBar.findQUISearchBarStyler(i3).getAnimViewPropList();
        if (animViewPropList != null && animViewPropList2 != null) {
            qUISearchBar.getInputWidget().setText("");
            qUISearchBar.getInputWidget().setCursorVisible(false);
            AtomicInteger atomicInteger = new AtomicInteger(0);
            for (int i16 = 0; i16 < animViewPropList.size(); i16++) {
                SearchAnimProp valueAt = animViewPropList.valueAt(i16);
                SearchAnimProp searchAnimProp = animViewPropList2.get(valueAt.vId);
                View findViewById = qUISearchBar.findViewById(searchAnimProp.vId);
                if (findViewById != null && (valueAt.isVisible || searchAnimProp.isVisible)) {
                    ViewPropertyAnimator duration = findViewById.animate().setDuration(250L);
                    if (!valueAt.isVisible || !searchAnimProp.isVisible) {
                        if (searchAnimProp.isVisible) {
                            f16 = 1.0f;
                        } else {
                            f16 = 0.0f;
                        }
                        duration.alpha(f16);
                    }
                    int i17 = valueAt.width;
                    int i18 = searchAnimProp.width;
                    if (i17 != i18 && i17 != -1 && i18 != -1) {
                        duration.scaleX((i18 * 1.0f) / i17);
                    }
                    int i19 = valueAt.height;
                    int i26 = searchAnimProp.height;
                    if (i19 != i26 && i19 != -1 && i26 != -1) {
                        duration.scaleY((i26 * 1.0f) / i19);
                    }
                    if (valueAt.f317275x != searchAnimProp.f317275x) {
                        duration.translationX(r7 - r6);
                    }
                    if (valueAt.f317276y != searchAnimProp.f317276y) {
                        duration.translationY(r4 - r3);
                    }
                    duration.setListener(new b(duration, atomicInteger, animViewPropList, runnable));
                    duration.start();
                } else {
                    atomicInteger.incrementAndGet();
                }
            }
        }
    }

    public static void doAnimToCurUITrans(@NonNull QUISearchBar qUISearchBar, int i3, @Nullable Runnable runnable) {
        float f16;
        if (qUISearchBar.getCurStyle() == i3) {
            return;
        }
        SparseArray<SearchAnimProp> animViewPropList = qUISearchBar.findQUISearchBarStyler(i3).getAnimViewPropList();
        SparseArray<SearchAnimProp> animViewPropList2 = qUISearchBar.findQUISearchBarStyler().getAnimViewPropList();
        if (animViewPropList != null && animViewPropList2 != null) {
            qUISearchBar.getInputWidget().setText("");
            qUISearchBar.getInputWidget().setCursorVisible(false);
            AtomicInteger atomicInteger = new AtomicInteger(0);
            for (int i16 = 0; i16 < animViewPropList.size(); i16++) {
                SearchAnimProp valueAt = animViewPropList.valueAt(i16);
                SearchAnimProp searchAnimProp = animViewPropList2.get(valueAt.vId);
                View findViewById = qUISearchBar.findViewById(searchAnimProp.vId);
                if (findViewById != null && (valueAt.isVisible || searchAnimProp.isVisible)) {
                    try {
                        initStartAnimState(valueAt, searchAnimProp, findViewById);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, e16, new Object[0]);
                    }
                    ViewPropertyAnimator duration = findViewById.animate().setDuration(250L);
                    if (!valueAt.isVisible || !searchAnimProp.isVisible) {
                        if (searchAnimProp.isVisible) {
                            f16 = 1.0f;
                        } else {
                            f16 = 0.0f;
                        }
                        duration.alpha(f16);
                    }
                    if (valueAt.width != searchAnimProp.width) {
                        duration.scaleX(1.0f);
                    }
                    if (valueAt.height != searchAnimProp.height) {
                        duration.scaleY(1.0f);
                    }
                    if (valueAt.f317275x != searchAnimProp.f317275x) {
                        duration.translationX(0.0f);
                    }
                    if (valueAt.f317276y != searchAnimProp.f317276y) {
                        duration.translationY(0.0f);
                    }
                    duration.setListener(new a(duration, atomicInteger, animViewPropList, runnable));
                    duration.start();
                } else {
                    atomicInteger.incrementAndGet();
                }
            }
        }
    }

    private static void initStartAnimState(SearchAnimProp searchAnimProp, SearchAnimProp searchAnimProp2, View view) {
        float f16 = 0.0f;
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        if (!searchAnimProp.isVisible || !searchAnimProp2.isVisible) {
            view.setVisibility(0);
            if (!searchAnimProp2.isVisible) {
                f16 = 1.0f;
            }
            view.setAlpha(f16);
        }
        int i3 = searchAnimProp.width;
        int i16 = searchAnimProp2.width;
        if (i3 != i16 && i3 != -1 && i16 > 0) {
            view.setScaleX((i3 * 1.0f) / i16);
        }
        int i17 = searchAnimProp.height;
        int i18 = searchAnimProp2.height;
        if (i17 != i18 && i17 != -1 && i18 > 0) {
            view.setScaleY((i17 * 1.0f) / i18);
        }
        int i19 = searchAnimProp.f317275x;
        if (i19 != searchAnimProp2.f317275x) {
            view.setX(i19);
        }
        int i26 = searchAnimProp.f317276y;
        if (i26 != searchAnimProp2.f317276y) {
            view.setY(i26);
        }
    }
}
