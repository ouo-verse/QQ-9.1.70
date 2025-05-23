package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0002&\tB1\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0015\u0012\b\b\u0002\u0010\"\u001a\u00020\u0015\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildViewPagerContainer;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/GestureDetectorCompat;", "c", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "b", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "disallowIntercept", "requestDisallowInterceptTouchEvent", "dispatchTouchEvent", "d", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetector", "Lkotlin/Pair;", "", "e", "Lkotlin/Pair;", "velocities", "f", "Landroidx/recyclerview/widget/RecyclerView;", h.F, "Landroidx/viewpager2/widget/ViewPager2;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildViewPagerContainer extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetectorCompat gestureDetector;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> velocities;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager2;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J,\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildViewPagerContainer$b;", "T", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "velocityX", "velocityY", "", "onFling", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "a", "()Ljava/lang/ref/WeakReference;", "setWeakRef", "(Ljava/lang/ref/WeakReference;)V", "weakRef", "host", "<init>", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static class b<T> extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<T> weakRef;

        public b(T t16) {
            this.weakRef = new WeakReference<>(t16);
        }

        @NotNull
        protected final WeakReference<T> a() {
            return this.weakRef;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            return super.onFling(e16, e26, velocityX, velocityY);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J,\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/widget/GuildViewPagerContainer$c", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildViewPagerContainer$b;", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildViewPagerContainer;", "Landroid/view/MotionEvent;", "e1", "e2", "", "velocityX", "velocityY", "", "onFling", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends b<GuildViewPagerContainer> {
        c(GuildViewPagerContainer guildViewPagerContainer) {
            super(guildViewPagerContainer);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.widget.GuildViewPagerContainer.b, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            GuildViewPagerContainer guildViewPagerContainer = a().get();
            if (guildViewPagerContainer == null) {
                return false;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildViewPagerContainer", "onFling " + velocityX + " " + velocityY);
            }
            guildViewPagerContainer.velocities = TuplesKt.to(Integer.valueOf((int) Math.abs(velocityX)), Integer.valueOf((int) Math.abs(velocityY)));
            return super.onFling(e16, e26, velocityX, velocityY);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildViewPagerContainer(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final GestureDetectorCompat c() {
        return new GestureDetectorCompat(getContext(), new c(this), new Handler(Looper.getMainLooper()));
    }

    public final void b(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.viewPager2 = viewPager2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        Integer num;
        Float f16;
        this.gestureDetector.onTouchEvent(ev5);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Float f17 = null;
            if (ev5 != null) {
                num = Integer.valueOf(ev5.getAction());
            } else {
                num = null;
            }
            if (ev5 != null) {
                f16 = Float.valueOf(ev5.getX());
            } else {
                f16 = null;
            }
            if (ev5 != null) {
                f17 = Float.valueOf(ev5.getY());
            }
            Log.d("GuildViewPagerContainer", "dispatchTouchEvent " + num + " " + f16 + " " + f17);
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        Integer num;
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(ev5);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            if (ev5 != null) {
                num = Integer.valueOf(ev5.getAction());
            } else {
                num = null;
            }
            Log.d("GuildViewPagerContainer", "onInterceptTouchEvent " + num + " -> " + onInterceptTouchEvent);
        }
        return onInterceptTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildViewPagerContainer", "requestDisallowInterceptTouchEvent " + disallowIntercept);
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildViewPagerContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildViewPagerContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildViewPagerContainer(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildViewPagerContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gestureDetector = c();
        this.velocities = TuplesKt.to(0, 0);
    }
}
