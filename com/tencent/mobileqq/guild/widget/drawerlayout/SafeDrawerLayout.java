package com.tencent.mobileqq.guild.widget.drawerlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.drawerlayout.SafeDrawerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u0001:\u0001\fB\u001d\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J0\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0014J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0006R$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u00102\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u001c\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/drawerlayout/SafeDrawerLayout;", "Landroidx/drawerlayout/widget/DrawerLayout;", "", "e", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "changed", "", "l", "t", "r", "b", "onLayout", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/view/View;", "drawerView", "animate", "closeDrawer", "openDrawer", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, IGuildSpeechApi.KEY_NEED_INTERCEPT, "d", "<set-?>", "Z", "c", "()Z", "isFirstLayout", "Landroid/view/View;", "", "Lcom/tencent/mobileqq/guild/widget/drawerlayout/SafeDrawerLayout$b$a;", "f", "Ljava/util/List;", "pendingDrawerActions", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "onLayoutRunnable", "", "i", UserInfo.SEX_FEMALE, "startX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startY", BdhLogUtil.LogTag.Tag_Conn, "I", "touchSlop", "D", "needInterceptTouchEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SafeDrawerLayout extends DrawerLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int touchSlop;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean needInterceptTouchEvent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View drawerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Companion.DrawerAction> pendingDrawerActions;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable onLayoutRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float startX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float startY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/widget/drawerlayout/SafeDrawerLayout$a", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "Landroid/view/View;", "drawerView", "", "slideOffset", "", "onDrawerSlide", "onDrawerOpened", "onDrawerClosed", "", "newState", "onDrawerStateChanged", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements DrawerLayout.DrawerListener {
        a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(@NotNull View drawerView) {
            Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(@NotNull View drawerView) {
            Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(@NotNull View drawerView, float slideOffset) {
            Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int newState) {
            View view = SafeDrawerLayout.this.drawerView;
            if (view == null) {
                return;
            }
            Logger logger = Logger.f235387a;
            SafeDrawerLayout safeDrawerLayout = SafeDrawerLayout.this;
            logger.d().i("SafeDrawerLayout", 1, "isDrawerOpen = " + safeDrawerLayout.isDrawerOpen(view));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SafeDrawerLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e() {
        if (this.onLayoutRunnable == null) {
            this.onLayoutRunnable = new Runnable() { // from class: p12.a
                @Override // java.lang.Runnable
                public final void run() {
                    SafeDrawerLayout.f(SafeDrawerLayout.this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SafeDrawerLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<Companion.DrawerAction> list = this$0.pendingDrawerActions;
        this$0.pendingDrawerActions = new ArrayList();
        for (Companion.DrawerAction drawerAction : list) {
            if (drawerAction.getIsOpen()) {
                super.openDrawer(drawerAction.getView(), drawerAction.getAnimate());
            } else {
                super.closeDrawer(drawerAction.getView(), drawerAction.getAnimate());
            }
        }
        this$0.onLayoutRunnable = null;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsFirstLayout() {
        return this.isFirstLayout;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void closeDrawer(@NotNull View drawerView, boolean animate) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        this.drawerView = drawerView;
        Logger.f235387a.d().i("SafeDrawerLayout", 1, "closeDrawer(" + drawerView + ", " + animate + "), isFirstLayout = " + getIsFirstLayout() + ", attached = " + isAttachedToWindow());
        if (!this.isFirstLayout) {
            super.closeDrawer(drawerView, animate);
        } else {
            this.pendingDrawerActions.add(new Companion.DrawerAction(drawerView, animate, false));
            e();
        }
    }

    public final void d(boolean needIntercept) {
        this.needInterceptTouchEvent = needIntercept;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.isFirstLayout = true;
        Logger.f235387a.d().i("SafeDrawerLayout", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isFirstLayout = true;
        Logger.f235387a.d().i("SafeDrawerLayout", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (!this.needInterceptTouchEvent) {
            return super.onInterceptTouchEvent(ev5);
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action == 2) {
                float x16 = ev5.getX() - this.startX;
                float y16 = ev5.getY() - this.startY;
                double degrees = Math.toDegrees((float) Math.atan2(Math.abs(y16), Math.abs(x16)));
                if (Math.abs(y16) >= this.touchSlop && degrees >= 45.0d) {
                    return false;
                }
                return super.onInterceptTouchEvent(ev5);
            }
        } else {
            this.startX = ev5.getX();
            this.startY = ev5.getY();
        }
        return super.onInterceptTouchEvent(ev5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
        if (this.isFirstLayout) {
            Logger.f235387a.d().i("SafeDrawerLayout", 1, "onLayout isFirstLayout: " + getIsFirstLayout() + " -> false");
            this.isFirstLayout = false;
            Runnable runnable = this.onLayoutRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        try {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(300, 1073741824);
                }
            } else {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824);
            }
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            if (mode2 != Integer.MIN_VALUE) {
                if (mode2 == 0) {
                    heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(300, 1073741824);
                }
            } else {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 1073741824);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } catch (Exception e16) {
            QLog.d("SafeDrawerLayout", 1, "measure error:" + e16);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void openDrawer(@NotNull View drawerView, boolean animate) {
        boolean z16;
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        this.drawerView = drawerView;
        if (getMeasuredWidth() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.f235387a.d().i("SafeDrawerLayout", 1, "openDrawer(" + drawerView + ", " + animate + "), isFirstLayout = " + getIsFirstLayout() + ", attached = " + isAttachedToWindow() + ", (measureZero " + z16 + ')');
        if (!this.isFirstLayout) {
            super.openDrawer(drawerView, animate);
        } else {
            this.pendingDrawerActions.add(new Companion.DrawerAction(drawerView, animate, true));
            e();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SafeDrawerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isFirstLayout = true;
        this.pendingDrawerActions = new ArrayList();
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        addDrawerListener(new a());
    }

    public /* synthetic */ SafeDrawerLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
