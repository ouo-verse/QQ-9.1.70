package com.tencent.mobileqq.aio.notification.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent3;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001\u0005B\u001d\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016J@\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J8\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J0\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0003H\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016R\"\u0010%\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R*\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010<\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u0016\u0010>\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00103R\u0016\u0010@\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00103R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00103R\u0016\u0010D\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010 \u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationScrollLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", "", "dy", "a", "", "b", "c", "Landroid/view/View;", "child", "target", "axes", "type", "", "onStartNestedScroll", "onNestedScrollAccepted", "onStopNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "consumed", "onNestedScroll", "dx", "onNestedPreScroll", "", "velocityX", "velocityY", "onNestedPreFling", "d", "I", "getMaxScrollY", "()I", "setMaxScrollY", "(I)V", "maxScrollY", "e", "getMinFlingVelocity", "setMinFlingVelocity", "minFlingVelocity", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getOnScrollEnd", "()Lkotlin/jvm/functions/Function0;", "setOnScrollEnd", "(Lkotlin/jvm/functions/Function0;)V", TkdListView.EVENT_TYPE_SCROLL_END, tl.h.F, "Z", "getScrollEnable", "()Z", "setScrollEnable", "(Z)V", "scrollEnable", "i", "getResetScrollYOnEnd", "setResetScrollYOnEnd", "resetScrollYOnEnd", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hadScrollEnd", BdhLogUtil.LogTag.Tag_Conn, "isFirstTouchEvent", "D", "canConsumeScrollEvent", "E", "scrollDistance", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", UserInfo.SEX_FEMALE, "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationScrollLayout extends FrameLayout implements NestedScrollingParent3 {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFirstTouchEvent;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean canConsumeScrollEvent;

    /* renamed from: E, reason: from kotlin metadata */
    private int scrollDistance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int maxScrollY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int minFlingVelocity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onScrollEnd;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean scrollEnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean resetScrollYOnEnd;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hadScrollEnd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationScrollLayout$a;", "", "", "DEFAULT_FLING_VELOCITY", "I", "", "TAG", "Ljava/lang/String;", "TOP_TO_DOWN", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.list.AIONotificationScrollLayout$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIONotificationScrollLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) context);
    }

    private final int a(int dy5) {
        if (dy5 > 0) {
            if (this.hadScrollEnd) {
                return 0;
            }
            return dy5;
        }
        return Math.max(dy5, -getScrollY());
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.canConsumeScrollEvent = false;
            scrollTo(0, 0);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (getScrollY() != 0) {
            AIONotificationUIUtils.f192828a.X(this, 0, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NotNull View target, float velocityX, float velocityY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, target, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (this.hadScrollEnd) {
            return true;
        }
        if (getScrollY() > 0) {
            if (this.canConsumeScrollEvent && this.scrollDistance > this.maxScrollY / 2) {
                Function0<Unit> function0 = this.onScrollEnd;
                if (function0 != null) {
                    function0.invoke();
                }
                this.hadScrollEnd = true;
                target.stopNestedScroll();
            }
            return true;
        }
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, target, Integer.valueOf(dx5), Integer.valueOf(dy5), consumed, Integer.valueOf(type));
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        this.scrollDistance += dy5;
        if (getScrollY() > 0) {
            consumed[1] = dy5;
            scrollBy(0, a(dy5));
            if (getScrollY() >= this.maxScrollY) {
                Function0<Unit> function0 = this.onScrollEnd;
                if (function0 != null) {
                    function0.invoke();
                }
                this.hadScrollEnd = true;
                target.stopNestedScroll();
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            Intrinsics.checkNotNullParameter(target, "target");
        } else {
            iPatchRedirector.redirect((short) 19, this, target, Integer.valueOf(dxConsumed), Integer.valueOf(dyConsumed), Integer.valueOf(dxUnconsumed), Integer.valueOf(dyUnconsumed), Integer.valueOf(type));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int axes, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, child, target, Integer.valueOf(axes), Integer.valueOf(type));
        } else {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(target, "target");
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int axes, int type) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, child, target, Integer.valueOf(axes), Integer.valueOf(type))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!this.scrollEnable) {
            return false;
        }
        if (type == 0) {
            this.hadScrollEnd = false;
        }
        if (type == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isFirstTouchEvent = z16;
        this.scrollDistance = 0;
        if (axes == 2 && getScrollY() < this.maxScrollY) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NotNull View target, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) target, type);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (this.resetScrollYOnEnd) {
            c();
        }
    }

    public final void setMaxScrollY(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.maxScrollY = i3;
        }
    }

    public final void setMinFlingVelocity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.minFlingVelocity = i3;
        }
    }

    public final void setOnScrollEnd(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) function0);
        } else {
            this.onScrollEnd = function0;
        }
    }

    public final void setResetScrollYOnEnd(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.resetScrollYOnEnd = z16;
        }
    }

    public final void setScrollEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.scrollEnable = z16;
        }
    }

    public /* synthetic */ AIONotificationScrollLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NotNull int[] consumed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, target, Integer.valueOf(dxConsumed), Integer.valueOf(dyConsumed), Integer.valueOf(dxUnconsumed), Integer.valueOf(dyUnconsumed), Integer.valueOf(type), consumed);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (dyUnconsumed > 0) {
            if (this.isFirstTouchEvent) {
                this.canConsumeScrollEvent = true;
            }
            if (this.canConsumeScrollEvent) {
                scrollBy(0, a(dyUnconsumed));
                consumed[1] = dyUnconsumed;
            }
        }
        this.isFirstTouchEvent = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIONotificationScrollLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.maxScrollY = Integer.MAX_VALUE;
        this.minFlingVelocity = 500;
        this.resetScrollYOnEnd = true;
    }
}
