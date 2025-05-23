package com.tencent.mobileqq.guild.home.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001(B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#B\u001b\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b\"\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/GuildHomeViewPager2NestedScrollableHost;", "Landroid/widget/FrameLayout;", "", "orientation", "", EventListener.KEY_DELTA, "", "b", "Landroid/view/MotionEvent;", "e", "", "f", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Landroidx/viewpager2/widget/ViewPager2;", "d", "Lkotlin/Lazy;", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager", "Landroid/view/View;", "c", "()Landroid/view/View;", "child", "()I", "touchSlop", h.F, "Z", "isChildHasSameDirection", "i", UserInfo.SEX_FEMALE, "initialX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "initialY", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeViewPager2NestedScrollableHost extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy parentViewPager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy child;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy touchSlop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isChildHasSameDirection;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float initialX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float initialY;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/GuildHomeViewPager2NestedScrollableHost$a;", "", "Landroid/view/View;", "view", "c", "Landroidx/viewpager2/widget/ViewPager2;", "d", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.GuildHomeViewPager2NestedScrollableHost$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View c(View view) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            while (!arrayList.isEmpty()) {
                Object remove = arrayList.remove(0);
                Intrinsics.checkNotNullExpressionValue(remove, "unvisited.removeAt(0)");
                View view2 = (View) remove;
                if (view2 instanceof ViewPager2) {
                    return view2;
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        arrayList.add(viewGroup.getChildAt(i3));
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x000d, code lost:
        
            r3 = null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ViewPager2 d(View view) {
            View view2;
            Object parent = view.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
                while (view2 != null && !(view2 instanceof ViewPager2)) {
                    Object parent2 = view2.getParent();
                    if (parent2 instanceof View) {
                        view2 = (View) parent2;
                    }
                }
                if (!(view2 instanceof ViewPager2)) {
                    return null;
                }
                return (ViewPager2) view2;
            }
            view2 = null;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeViewPager2NestedScrollableHost(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewPager2>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeViewPager2NestedScrollableHost$parentViewPager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ViewPager2 invoke() {
                ViewPager2 d16;
                d16 = GuildHomeViewPager2NestedScrollableHost.INSTANCE.d(GuildHomeViewPager2NestedScrollableHost.this);
                return d16;
            }
        });
        this.parentViewPager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeViewPager2NestedScrollableHost$child$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View c16;
                c16 = GuildHomeViewPager2NestedScrollableHost.INSTANCE.c(GuildHomeViewPager2NestedScrollableHost.this);
                return c16;
            }
        });
        this.child = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeViewPager2NestedScrollableHost$touchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(GuildHomeViewPager2NestedScrollableHost.this.getContext()).getScaledTouchSlop());
            }
        });
        this.touchSlop = lazy3;
        this.isChildHasSameDirection = true;
    }

    private final boolean b(int orientation, float delta) {
        int i3 = -((int) Math.signum(delta));
        if (orientation != 0) {
            if (orientation == 1) {
                View c16 = c();
                if (c16 == null) {
                    return false;
                }
                return c16.canScrollVertically(i3);
            }
            throw new IllegalArgumentException();
        }
        View c17 = c();
        if (c17 == null) {
            return false;
        }
        return c17.canScrollHorizontally(i3);
    }

    private final View c() {
        return (View) this.child.getValue();
    }

    private final ViewPager2 d() {
        return (ViewPager2) this.parentViewPager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int e() {
        return ((Number) this.touchSlop.getValue()).intValue();
    }

    private final void f(MotionEvent e16) {
        int i3;
        boolean z16;
        float f16;
        boolean z17;
        ViewPager2 d16 = d();
        if (d16 != null) {
            int orientation = d16.getOrientation();
            if (this.isChildHasSameDirection) {
                i3 = orientation;
            } else {
                i3 = orientation ^ 1;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("Guild.NewHome.subFrag.GuildHomeViewPager2NestedScrollableHost", 1, "handleInterceptTouchEvent childOrientation:" + i3 + " touchSlop:" + e());
            }
            float f17 = 1.0f;
            if (!b(i3, -1.0f) && !b(i3, 1.0f)) {
                return;
            }
            int action = e16.getAction();
            if (action != 0) {
                if (action == 2) {
                    float x16 = e16.getX() - this.initialX;
                    float y16 = e16.getY() - this.initialY;
                    if (orientation == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    float abs = Math.abs(x16);
                    if (z16) {
                        f16 = 0.5f;
                    } else {
                        f16 = 1.0f;
                    }
                    float f18 = abs * f16;
                    float abs2 = Math.abs(y16);
                    if (!z16) {
                        f17 = 0.5f;
                    }
                    float f19 = abs2 * f17;
                    if (QLog.isDebugVersion()) {
                        logger.d().d("Guild.NewHome.subFrag.GuildHomeViewPager2NestedScrollableHost", 1, "handleInterceptTouchEvent dx:" + x16 + " scaledDx:" + f18 + ", dy:" + y16 + " scaledDy:" + f19);
                    }
                    if (f18 > e() || f19 > e()) {
                        if (f18 > f19) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z16 == z17) {
                            if (!z16) {
                                x16 = y16;
                            }
                            if (b(orientation, x16)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                return;
                            } else {
                                getParent().requestDisallowInterceptTouchEvent(false);
                                return;
                            }
                        }
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.initialX = e16.getX();
            this.initialY = e16.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        f(e16);
        return super.onInterceptTouchEvent(e16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeViewPager2NestedScrollableHost(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewPager2>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeViewPager2NestedScrollableHost$parentViewPager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ViewPager2 invoke() {
                ViewPager2 d16;
                d16 = GuildHomeViewPager2NestedScrollableHost.INSTANCE.d(GuildHomeViewPager2NestedScrollableHost.this);
                return d16;
            }
        });
        this.parentViewPager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeViewPager2NestedScrollableHost$child$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View c16;
                c16 = GuildHomeViewPager2NestedScrollableHost.INSTANCE.c(GuildHomeViewPager2NestedScrollableHost.this);
                return c16;
            }
        });
        this.child = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeViewPager2NestedScrollableHost$touchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(GuildHomeViewPager2NestedScrollableHost.this.getContext()).getScaledTouchSlop());
            }
        });
        this.touchSlop = lazy3;
        this.isChildHasSameDirection = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.Y3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026ger2NestedScrollableHost)");
        this.isChildHasSameDirection = obtainStyledAttributes.getBoolean(up1.a.Z3, false);
        obtainStyledAttributes.recycle();
    }
}
