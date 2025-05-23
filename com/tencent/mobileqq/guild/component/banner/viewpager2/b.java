package com.tencent.mobileqq.guild.component.banner.viewpager2;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/viewpager2/b;", "", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "", "speed", "", "d", "b", "", "duration", "defaultMillisecondsPerInch", "a", "e", "c", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f215854a = new b();

    b() {
    }

    private final float a(ViewPager2 viewPager2, long duration, float defaultMillisecondsPerInch) {
        View view;
        int width;
        int a16;
        Iterator<View> it = ViewGroupKt.getChildren(viewPager2).iterator();
        while (true) {
            if (it.hasNext()) {
                view = it.next();
                if (view instanceof RecyclerView) {
                    break;
                }
            } else {
                view = null;
                break;
            }
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) view;
        if (viewPager2.getOrientation() == 1) {
            width = recyclerView.getHeight();
            a16 = h.b(recyclerView);
        } else {
            width = recyclerView.getWidth();
            a16 = h.a(recyclerView);
        }
        return ((((float) duration) * 0.3356f) * viewPager2.getResources().getDisplayMetrics().densityDpi) / ((width - a16) * defaultMillisecondsPerInch);
    }

    @JvmStatic
    public static final void b(@NotNull ViewPager2 viewPager2, float speed) {
        Field declaredField;
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        float f16 = 25.0f * speed;
        try {
            View childAt = viewPager2.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) childAt;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ProxySmoothScrollerLayoutManager) {
                ((ProxySmoothScrollerLayoutManager) layoutManager).t(f16);
                return;
            }
            Context context = viewPager2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "viewPager2.context");
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ProxySmoothScrollerLayoutManager proxySmoothScrollerLayoutManager = new ProxySmoothScrollerLayoutManager(context, (LinearLayoutManager) layoutManager2, f16);
            recyclerView.setLayoutManager(proxySmoothScrollerLayoutManager);
            Field declaredField2 = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
            declaredField2.setAccessible(true);
            declaredField2.set(layoutManager, recyclerView);
            Field declaredField3 = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField3.setAccessible(true);
            declaredField3.set(viewPager2, proxySmoothScrollerLayoutManager);
            Field declaredField4 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
            declaredField4.setAccessible(true);
            Object obj = declaredField4.get(viewPager2);
            if (obj != null && (declaredField = obj.getClass().getDeclaredField("mLayoutManager")) != null) {
                declaredField.setAccessible(true);
                declaredField.set(obj, proxySmoothScrollerLayoutManager);
            }
            Field declaredField5 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
            declaredField5.setAccessible(true);
            Object scrollerEventAdapter = declaredField5.get(viewPager2);
            if (scrollerEventAdapter != null) {
                Intrinsics.checkNotNullExpressionValue(scrollerEventAdapter, "scrollerEventAdapter");
                Field declaredField6 = scrollerEventAdapter.getClass().getDeclaredField("mLayoutManager");
                if (declaredField6 != null) {
                    Intrinsics.checkNotNullExpressionValue(declaredField6, "getDeclaredField(\"mLayoutManager\")");
                    declaredField6.setAccessible(true);
                    declaredField6.set(scrollerEventAdapter, proxySmoothScrollerLayoutManager);
                }
            }
            QLog.i("Guild.component.ViewPager2Utils", 1, "setSmoothScrollerToViewPager2 suc. speed:" + speed);
        } catch (Exception e16) {
            QLog.i("Guild.component.ViewPager2Utils", 1, "setSmoothScrollerToViewPager2 exception:" + e16.getMessage());
        }
    }

    @JvmStatic
    public static final void d(@NotNull ViewPager2 viewPager2, float speed) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        float f16 = 100.0f * speed;
        try {
            Field declaredField = viewPager2.getClass().getDeclaredField("mPagerSnapHelper");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager2);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.PagerSnapHelper");
            PagerSnapHelper pagerSnapHelper = (PagerSnapHelper) obj;
            if (pagerSnapHelper instanceof a) {
                ((a) pagerSnapHelper).c(f16);
                return;
            }
            pagerSnapHelper.attachToRecyclerView(null);
            View childAt = viewPager2.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) childAt;
            a aVar = new a(recyclerView, f16);
            declaredField.set(viewPager2, aVar);
            aVar.attachToRecyclerView(recyclerView);
            QLog.i("Guild.component.ViewPager2Utils", 1, "setPagerSnapHelper suc. speed:" + speed);
        } catch (Exception e16) {
            QLog.e("Guild.component.ViewPager2Utils", 1, "setPagerSnapHelper exception:" + e16.getMessage());
        }
    }

    public final void c(@NotNull ViewPager2 viewPager2, long duration) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        b(viewPager2, a(viewPager2, duration, 25.0f));
    }

    public final void e(@NotNull ViewPager2 viewPager2, long duration) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        d(viewPager2, a(viewPager2, duration, 100.0f));
    }
}
