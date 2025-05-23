package com.tencent.mobileqq.guild.home.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0003<=>B'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J0\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00103\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "", "k", "Landroid/view/View;", "child", "target", "", "axes", "type", "", "onStartNestedScroll", "dx", "dy", "", "consumed", "onNestedPreScroll", "onStopNestedScroll", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "enable", "j", "Landroid/view/WindowInsets;", "insets", "dispatchApplyWindowInsets", "d", "Z", "isTouch", "Lkotlin/collections/ArrayDeque;", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$c;", "e", "Lkotlin/collections/ArrayDeque;", "deque", "f", "dragMode", "Landroid/graphics/Rect;", h.F, "Landroid/graphics/Rect;", "prevSystemInsetsRect", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$b;", "i", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$b;", "getTouchEventAware", "()Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$b;", "setTouchEventAware", "(Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$b;)V", "touchEventAware", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getTouchEventDragAware", "setTouchEventDragAware", "touchEventDragAware", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class BetterCoordinatorLayout extends CoordinatorLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isTouch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayDeque<StartNestedEvent> deque;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean dragMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect prevSystemInsetsRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b touchEventAware;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b touchEventDragAware;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$b;", "", "Landroid/view/MotionEvent;", "ev", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "handled", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@NotNull MotionEvent ev5, @NotNull ViewGroup parent, boolean handled);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u000bB=\b\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u000b\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "a", "Ljava/lang/ref/WeakReference;", "b", "()Ljava/lang/ref/WeakReference;", "child", "c", "target", "I", "d", "()I", "targetId", "axes", "e", "type", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;III)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class StartNestedEvent {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final WeakReference<View> child;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final WeakReference<View> target;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int targetId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int axes;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$c$a;", "", "Landroid/view/View;", "child", "target", "", "axes", "type", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$c;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout$c$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final StartNestedEvent a(@NotNull View child, @NotNull View target, int axes, int type) {
                Intrinsics.checkNotNullParameter(child, "child");
                Intrinsics.checkNotNullParameter(target, "target");
                return new StartNestedEvent(new WeakReference(child), new WeakReference(target), System.identityHashCode(target), axes, type, null);
            }

            Companion() {
            }
        }

        public /* synthetic */ StartNestedEvent(WeakReference weakReference, WeakReference weakReference2, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(weakReference, weakReference2, i3, i16, i17);
        }

        /* renamed from: a, reason: from getter */
        public final int getAxes() {
            return this.axes;
        }

        @NotNull
        public final WeakReference<View> b() {
            return this.child;
        }

        @NotNull
        public final WeakReference<View> c() {
            return this.target;
        }

        /* renamed from: d, reason: from getter */
        public final int getTargetId() {
            return this.targetId;
        }

        /* renamed from: e, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartNestedEvent)) {
                return false;
            }
            StartNestedEvent startNestedEvent = (StartNestedEvent) other;
            if (Intrinsics.areEqual(this.child, startNestedEvent.child) && Intrinsics.areEqual(this.target, startNestedEvent.target) && this.targetId == startNestedEvent.targetId && this.axes == startNestedEvent.axes && this.type == startNestedEvent.type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.child.hashCode() * 31) + this.target.hashCode()) * 31) + this.targetId) * 31) + this.axes) * 31) + this.type;
        }

        @NotNull
        public String toString() {
            return "StartNestedEvent(child=" + this.child + ", target=" + this.target + ", targetId=" + this.targetId + ", axes=" + this.axes + ", type=" + this.type + ")";
        }

        StartNestedEvent(WeakReference<View> weakReference, WeakReference<View> weakReference2, int i3, int i16, int i17) {
            this.child = weakReference;
            this.target = weakReference2;
            this.targetId = i3;
            this.axes = i16;
            this.type = i17;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BetterCoordinatorLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void k() {
        StartNestedEvent removeLastOrNull = this.deque.removeLastOrNull();
        if (removeLastOrNull != null) {
            View view = removeLastOrNull.b().get();
            View view2 = removeLastOrNull.c().get();
            int identityHashCode = System.identityHashCode(view2);
            if (view != null && view2 != null) {
                int i3 = !this.isTouch ? 1 : 0;
                boolean onStartNestedScroll = super.onStartNestedScroll(view, view2, removeLastOrNull.getAxes(), i3);
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.BetterCoordinatorLayout", "reDispatchOnStartNestedScroll: " + identityHashCode + ", dequeSize=" + this.deque.size() + " type=" + removeLastOrNull.getType() + " -> " + i3 + " = " + onStartNestedScroll);
                    return;
                }
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.BetterCoordinatorLayout", "reDispatchOnStartNestedScroll: dequeSize=" + this.deque.size());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @NotNull
    public WindowInsets dispatchApplyWindowInsets(@NotNull WindowInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets systemWindowInsets = WindowInsetsCompat.toWindowInsetsCompat(insets).getSystemWindowInsets();
        Intrinsics.checkNotNullExpressionValue(systemWindowInsets, "toWindowInsetsCompat(insets).systemWindowInsets");
        Rect rect = this.prevSystemInsetsRect;
        if (rect.left != systemWindowInsets.left || rect.top != systemWindowInsets.top || rect.right != systemWindowInsets.right || rect.bottom != systemWindowInsets.bottom) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.NewHome.BetterCoordinatorLayout", 2, "dispatchApplyWindowInsets: " + this.prevSystemInsetsRect.toShortString() + " -> [" + systemWindowInsets.left + "," + systemWindowInsets.top + "][" + systemWindowInsets.right + "," + systemWindowInsets.bottom + "]");
            }
            this.prevSystemInsetsRect.set(systemWindowInsets.left, systemWindowInsets.top, systemWindowInsets.right, systemWindowInsets.bottom);
        }
        WindowInsets dispatchApplyWindowInsets = super.dispatchApplyWindowInsets(insets);
        Intrinsics.checkNotNullExpressionValue(dispatchApplyWindowInsets, "super.dispatchApplyWindowInsets(insets)");
        return dispatchApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean z17 = true;
        if (ev5.getActionMasked() != 0 && ev5.getActionMasked() != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isTouch = z16;
        if (!this.dragMode) {
            z17 = super.dispatchTouchEvent(ev5);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.BetterCoordinatorLayout", "dispatchTouchEvent: handled=" + z17 + " isTouch=" + this.isTouch + " ev=" + ev5);
            }
            b bVar = this.touchEventAware;
            if (bVar != null) {
                bVar.a(ev5, this, z17);
            }
        } else {
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.BetterCoordinatorLayout", "dispatchTouchEvent(won't dispatch): isTouch=" + this.isTouch + " ev=" + ev5);
            }
            b bVar2 = this.touchEventDragAware;
            if (bVar2 != null) {
                bVar2.a(ev5, this, true);
            }
        }
        return z17;
    }

    public final void j(boolean enable) {
        this.dragMode = enable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        int identityHashCode = System.identityHashCode(target);
        super.onNestedPreScroll(target, dx5, dy5, consumed, type);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.BetterCoordinatorLayout", "onNestedPreScroll: $[" + identityHashCode + "] " + type + " target:" + target);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int axes, int type) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        boolean onStartNestedScroll = super.onStartNestedScroll(child, target, axes, type);
        int identityHashCode = System.identityHashCode(target);
        int identityHashCode2 = System.identityHashCode(child);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.BetterCoordinatorLayout", "onStartNestedScroll: " + onStartNestedScroll + " [" + identityHashCode2 + "] [" + identityHashCode + "] " + type + " " + axes + " child:" + child + " target:" + target);
        }
        if (onStartNestedScroll) {
            this.deque.addLast(StartNestedEvent.INSTANCE.a(child, target, axes, type));
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.deque, " -> ", null, null, 0, null, new Function1<StartNestedEvent, CharSequence>() { // from class: com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout$onStartNestedScroll$chains$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull BetterCoordinatorLayout.StartNestedEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return String.valueOf(it.getTargetId());
                }
            }, 30, null);
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.BetterCoordinatorLayout", "onStartNestedScroll: add deque, chains= " + joinToString$default);
            }
        }
        return onStartNestedScroll;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NotNull View target, int type) {
        String joinToString$default;
        int i3;
        StartNestedEvent startNestedEvent;
        boolean z16;
        Intrinsics.checkNotNullParameter(target, "target");
        int identityHashCode = System.identityHashCode(target);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.BetterCoordinatorLayout", "onStopNestedScroll: [" + identityHashCode + "] " + type);
        }
        super.onStopNestedScroll(target, type);
        StartNestedEvent lastOrNull = this.deque.lastOrNull();
        if (lastOrNull != null) {
            if (lastOrNull.getTargetId() == identityHashCode) {
                this.deque.removeLast();
                k();
            } else {
                ArrayDeque<StartNestedEvent> arrayDeque = this.deque;
                ListIterator<StartNestedEvent> listIterator = arrayDeque.listIterator(arrayDeque.size());
                while (true) {
                    i3 = 0;
                    if (listIterator.hasPrevious()) {
                        startNestedEvent = listIterator.previous();
                        if (startNestedEvent.getTargetId() == identityHashCode) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        startNestedEvent = null;
                        break;
                    }
                }
                StartNestedEvent startNestedEvent2 = startNestedEvent;
                if (startNestedEvent2 == null) {
                    Logger logger2 = Logger.f235387a;
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.NewHome.BetterCoordinatorLayout", "onStopNestedScroll: [" + identityHashCode + "] not found " + type);
                    }
                    for (StartNestedEvent startNestedEvent3 : this.deque) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        StartNestedEvent startNestedEvent4 = startNestedEvent3;
                        Logger logger3 = Logger.f235387a;
                        if (QLog.isDevelopLevel()) {
                            Log.d("Guild.NewHome.BetterCoordinatorLayout", "onStopNestedScroll: [" + i3 + "]: " + startNestedEvent4);
                        }
                        i3 = i16;
                    }
                } else {
                    this.deque.remove(startNestedEvent2);
                    k();
                }
            }
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.deque, " -> ", null, null, 0, null, new Function1<StartNestedEvent, CharSequence>() { // from class: com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout$onStopNestedScroll$chains$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull BetterCoordinatorLayout.StartNestedEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it.getTargetId());
            }
        }, 30, null);
        Logger logger4 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.BetterCoordinatorLayout", "onStopNestedScroll: chains= " + joinToString$default);
        }
    }

    public final void setTouchEventAware(@Nullable b bVar) {
        this.touchEventAware = bVar;
    }

    public final void setTouchEventDragAware(@Nullable b bVar) {
        this.touchEventDragAware = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BetterCoordinatorLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BetterCoordinatorLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BetterCoordinatorLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.deque = new ArrayDeque<>();
        this.prevSystemInsetsRect = new Rect(-1, -1, -1, -1);
    }
}
