package com.tencent.mobileqq.troop.appscenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J8\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J@\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016JH\u0010!\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J(\u0010#\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0013H\u0016R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010%\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/view/TroopAppsFlingBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "Ljava/lang/reflect/Field;", "flingRunnableField", "scrollerField", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "stopAppbarLayoutFling", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "child", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Landroid/view/View;", "directTargetChild", "target", "", "nestedScrollAxes", "type", "onStartNestedScroll", "coordinatorLayout", "dx", "dy", "", "consumed", "onNestedPreScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "abl", "onStopNestedScroll", "isFlinging", "Z", "shouldBlockNestedScroll", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAppsFlingBehavior extends AppBarLayout.Behavior {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopAppsFlingBehavior";
    private static final int TYPE_FLING = 1;
    private boolean isFlinging;
    private boolean shouldBlockNestedScroll;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/view/TroopAppsFlingBehavior$a;", "", "", "TAG", "Ljava/lang/String;", "", "TYPE_FLING", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.view.TroopAppsFlingBehavior$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26502);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopAppsFlingBehavior(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attrs);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0019 A[Catch: NoSuchFieldException -> 0x0014, TRY_LEAVE, TryCatch #0 {NoSuchFieldException -> 0x0014, blocks: (B:21:0x0009, B:23:0x000f, B:5:0x0019), top: B:20:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Field flingRunnableField() {
        Class superclass;
        Class cls;
        Class superclass2 = TroopAppsFlingBehavior.class.getSuperclass();
        if (superclass2 != null) {
            try {
                Class superclass3 = superclass2.getSuperclass();
                if (superclass3 != null) {
                    superclass = superclass3.getSuperclass();
                    if (superclass != null) {
                        return null;
                    }
                    return superclass.getDeclaredField("flingRunnable");
                }
            } catch (NoSuchFieldException e16) {
                e16.printStackTrace();
                QLog.e(TAG, 1, "flingRunnableField find 28 " + e16.getMessage());
                if (superclass2 != null) {
                    cls = superclass2.getSuperclass();
                } else {
                    cls = null;
                }
                if (cls == null) {
                    return null;
                }
                return cls.getDeclaredField("mFlingRunnable");
            }
        }
        superclass = null;
        if (superclass != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0019 A[Catch: NoSuchFieldException -> 0x0014, TRY_LEAVE, TryCatch #0 {NoSuchFieldException -> 0x0014, blocks: (B:21:0x0009, B:23:0x000f, B:5:0x0019), top: B:20:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Field scrollerField() {
        Class superclass;
        Class cls;
        Class superclass2 = TroopAppsFlingBehavior.class.getSuperclass();
        if (superclass2 != null) {
            try {
                Class superclass3 = superclass2.getSuperclass();
                if (superclass3 != null) {
                    superclass = superclass3.getSuperclass();
                    if (superclass != null) {
                        return null;
                    }
                    return superclass.getDeclaredField("scroller");
                }
            } catch (NoSuchFieldException e16) {
                e16.printStackTrace();
                QLog.e(TAG, 1, "scrollerField find 28 " + e16.getMessage());
                if (superclass2 != null) {
                    cls = superclass2.getSuperclass();
                } else {
                    cls = null;
                }
                if (cls == null) {
                    return null;
                }
                return cls.getDeclaredField("mScroller");
            }
        }
        superclass = null;
        if (superclass != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030 A[Catch: IllegalAccessException -> 0x005a, NoSuchFieldException -> 0x0075, TryCatch #2 {IllegalAccessException -> 0x005a, NoSuchFieldException -> 0x0075, blocks: (B:3:0x0007, B:5:0x0011, B:7:0x0016, B:10:0x001c, B:12:0x0022, B:14:0x002a, B:16:0x0030, B:17:0x0036, B:19:0x003a, B:21:0x0040, B:23:0x004b, B:25:0x0050, B:27:0x0056), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: IllegalAccessException -> 0x005a, NoSuchFieldException -> 0x0075, TryCatch #2 {IllegalAccessException -> 0x005a, NoSuchFieldException -> 0x0075, blocks: (B:3:0x0007, B:5:0x0011, B:7:0x0016, B:10:0x001c, B:12:0x0022, B:14:0x002a, B:16:0x0030, B:17:0x0036, B:19:0x003a, B:21:0x0040, B:23:0x004b, B:25:0x0050, B:27:0x0056), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[Catch: IllegalAccessException -> 0x005a, NoSuchFieldException -> 0x0075, TryCatch #2 {IllegalAccessException -> 0x005a, NoSuchFieldException -> 0x0075, blocks: (B:3:0x0007, B:5:0x0011, B:7:0x0016, B:10:0x001c, B:12:0x0022, B:14:0x002a, B:16:0x0030, B:17:0x0036, B:19:0x003a, B:21:0x0040, B:23:0x004b, B:25:0x0050, B:27:0x0056), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void stopAppbarLayoutFling(AppBarLayout appBarLayout) {
        Runnable runnable;
        Object obj;
        OverScroller overScroller;
        try {
            Field flingRunnableField = flingRunnableField();
            Field scrollerField = scrollerField();
            if (flingRunnableField != null) {
                flingRunnableField.setAccessible(true);
            }
            if (scrollerField != null) {
                scrollerField.setAccessible(true);
            }
            if (flingRunnableField != null && flingRunnableField.get(this) != null) {
                Object obj2 = flingRunnableField.get(this);
                if (obj2 instanceof Runnable) {
                    runnable = (Runnable) obj2;
                    if (scrollerField == null) {
                        obj = scrollerField.get(this);
                    } else {
                        obj = null;
                    }
                    if (!(obj instanceof OverScroller)) {
                        overScroller = (OverScroller) obj;
                    } else {
                        overScroller = null;
                    }
                    if (runnable != null) {
                        QLog.i(TAG, 1, "has flingRunnable");
                        appBarLayout.removeCallbacks(runnable);
                        if (flingRunnableField != null) {
                            flingRunnableField.set(this, null);
                        }
                    }
                    if (overScroller == null && !overScroller.isFinished()) {
                        overScroller.abortAnimation();
                        return;
                    }
                }
            }
            runnable = null;
            if (scrollerField == null) {
            }
            if (!(obj instanceof OverScroller)) {
            }
            if (runnable != null) {
            }
            if (overScroller == null) {
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, "stopAppbarLayoutFling " + e16.getMessage());
        } catch (NoSuchFieldException e17) {
            QLog.e(TAG, 1, "stopAppbarLayoutFling " + e17.getMessage());
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NotNull CoordinatorLayout parent, @NotNull AppBarLayout child, @NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, parent, child, ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        QLog.i(TAG, 1, "onInterceptTouchEvent:" + child.p());
        this.shouldBlockNestedScroll = this.isFlinging;
        if (ev5.getActionMasked() == 0) {
            stopAppbarLayoutFling(child);
        }
        return super.onInterceptTouchEvent(parent, (View) child, ev5);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull AppBarLayout child, @NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, coordinatorLayout, child, target, Integer.valueOf(dx5), Integer.valueOf(dy5), consumed, Integer.valueOf(type));
            return;
        }
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (type == 1) {
            this.isFlinging = true;
        }
        if (this.shouldBlockNestedScroll) {
            return;
        }
        super.onNestedPreScroll(coordinatorLayout, child, target, dx5, dy5, consumed, type);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull AppBarLayout child, @NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, coordinatorLayout, child, target, Integer.valueOf(dxConsumed), Integer.valueOf(dyConsumed), Integer.valueOf(dxUnconsumed), Integer.valueOf(dyUnconsumed), Integer.valueOf(type));
            return;
        }
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (this.shouldBlockNestedScroll) {
            return;
        }
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NotNull CoordinatorLayout parent, @NotNull AppBarLayout child, @NotNull View directTargetChild, @NotNull View target, int nestedScrollAxes, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, parent, child, directTargetChild, target, Integer.valueOf(nestedScrollAxes), Integer.valueOf(type))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        stopAppbarLayoutFling(child);
        return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull AppBarLayout abl, @NotNull View target, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, coordinatorLayout, abl, target, Integer.valueOf(type));
            return;
        }
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(abl, "abl");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onStopNestedScroll(coordinatorLayout, abl, target, type);
        this.isFlinging = false;
        this.shouldBlockNestedScroll = false;
    }
}
