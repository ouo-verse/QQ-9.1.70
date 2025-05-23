package com.tencent.mobileqq.guild.component.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pg1.BannerStyleManager;
import pg1.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\u00020\u0001:\u0001\u0011B\u001d\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0017J\u0012\u0010\u000f\u001a\u00020\u00042\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rJ\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\rJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010*\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b$\u0010(\u001a\u0004\b\"\u0010)R\u0017\u0010/\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010.R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00101R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00101R\u0014\u00108\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00101\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "Landroid/widget/FrameLayout;", "", "duration", "", "f", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "Landroid/view/View;", "child", "onViewAdded", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "loop", "setLoop", "auto", "setAutoLoop", "setAutoScroll", WidgetCacheConstellationData.INTERVAL, "setAutoLoopInterval", NodeProps.ENABLED, "a", "", "margin", "setPageMargin", "setAutoLoop2", "position", "c", "Landroidx/viewpager2/widget/ViewPager2;", "d", "Landroidx/viewpager2/widget/ViewPager2;", "e", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lpg1/e;", "Lpg1/e;", "()Lpg1/e;", "styleManager", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", h.F, "Z", "i", "autoLoop", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "userInputEnabled", BdhLogUtil.LogTag.Tag_Conn, "I", "touchSlop", "", "D", UserInfo.SEX_FEMALE, "touchDownX", "E", "touchDownY", "touchEventHandled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class BannerLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int touchSlop;

    /* renamed from: D, reason: from kotlin metadata */
    private float touchDownX;

    /* renamed from: E, reason: from kotlin metadata */
    private float touchDownY;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean touchEventHandled;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 viewPager2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BannerStyleManager styleManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean loop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean autoLoop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean userInputEnabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/component/banner/BannerLayout$a", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            info.setVisibleToUser(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f(long duration) {
        this.styleManager.n(duration);
    }

    public final void a(boolean enabled) {
        this.styleManager.b(enabled);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> b() {
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter = this.viewPager2.getAdapter();
        if (adapter instanceof g) {
            return ((g) adapter).m();
        }
        return adapter;
    }

    public final int c(int position) {
        Object adapter = this.viewPager2.getAdapter();
        if (adapter instanceof g) {
            return ((g) adapter).R(position);
        }
        return position;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final BannerStyleManager getStyleManager() {
        return this.styleManager;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        int i3;
        boolean z16;
        boolean z17;
        ViewParent parent;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.viewPager2.isUserInputEnabled()) {
            RecyclerView.Adapter adapter = this.viewPager2.getAdapter();
            boolean z18 = false;
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (i3 > 1) {
                if (ev5.getActionMasked() == 0) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    this.touchDownX = ev5.getX();
                    this.touchDownY = ev5.getY();
                    this.touchEventHandled = false;
                }
                if (this.touchEventHandled) {
                    return super.dispatchTouchEvent(ev5);
                }
                if (ev5.getActionMasked() == 2) {
                    RecyclerView.LayoutManager layoutManager = this.styleManager.getRecyclerView().getLayoutManager();
                    if (layoutManager != null && layoutManager.canScrollHorizontally()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 && Math.abs(ev5.getX() - this.touchDownX) > this.touchSlop) {
                        ViewParent parent3 = getParent();
                        if (parent3 != null) {
                            parent3.requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        RecyclerView.LayoutManager layoutManager2 = this.styleManager.getRecyclerView().getLayoutManager();
                        if (layoutManager2 != null && layoutManager2.canScrollVertically()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17 && Math.abs(ev5.getY() - this.touchDownY) > this.touchSlop && (parent = getParent()) != null) {
                            parent.requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                boolean dispatchTouchEvent = super.dispatchTouchEvent(ev5);
                if (this.viewPager2.getScrollState() == 1) {
                    z18 = true;
                }
                this.touchEventHandled = z18;
                return dispatchTouchEvent;
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final ViewPager2 getViewPager2() {
        return this.viewPager2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    @Keep
    public void onViewAdded(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onViewAdded(child);
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.BannerLayout", 1, "onViewAdded: " + child, null);
        if (child instanceof og1.b) {
            QLog.i("Guild.component.BannerLayout", 1, "bindIndicator automatically: " + child, null);
            com.tencent.mobileqq.guild.component.banner.a.f215813a.a(this.viewPager2, (og1.b) child);
        }
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.viewPager2.setAdapter(adapter);
        setLoop(this.loop);
        setAutoLoop(this.autoLoop);
    }

    public final void setAutoLoop(boolean auto) {
        this.styleManager.i(auto);
    }

    public final void setAutoLoop2(boolean auto) {
        this.autoLoop = auto;
    }

    public final void setAutoLoopInterval(long interval) {
        this.styleManager.j(interval);
    }

    public final void setAutoScroll(boolean auto) {
        this.styleManager.k(auto);
    }

    public final void setLoop(boolean loop) {
        this.styleManager.l(loop);
    }

    public final void setPageMargin(int margin) {
        this.styleManager.m(margin);
    }

    public /* synthetic */ BannerLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewPager2 viewPager2 = new ViewPager2(context);
        addView(viewPager2, -1, -1);
        this.viewPager2 = viewPager2;
        BannerStyleManager bannerStyleManager = new BannerStyleManager(viewPager2);
        this.styleManager = bannerStyleManager;
        this.recyclerView = bannerStyleManager.getRecyclerView();
        this.userInputEnabled = true;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.component.b.f215781y, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026eable.BannerLayout, 0, 0)");
        this.loop = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.guild.component.b.C, false);
        this.autoLoop = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.guild.component.b.f215788z, false);
        boolean z16 = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.guild.component.b.D, true);
        this.userInputEnabled = z16;
        a(z16);
        setAutoLoopInterval(obtainStyledAttributes.getInt(com.tencent.mobileqq.guild.component.b.A, 5000));
        boolean z17 = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.guild.component.b.B, false);
        obtainStyledAttributes.recycle();
        if (!z17) {
            f(300L);
        }
        bannerStyleManager.getRecyclerView().setAccessibilityDelegate(new a());
    }
}
