package com.tencent.richframework.compat.immersive.task;

import android.R;
import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.richframework.compat.immersive.RFWAutoImmersiveHelper;
import com.tencent.richframework.compat.immersive.WindowColorFetcherState;
import com.tencent.richframework.compat.immersive.color.ColorFetchUtil;
import com.tencent.richframework.compat.immersive.color.IColorFetcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/compat/immersive/task/NavigatorUpdateTask;", "Lcom/tencent/richframework/compat/immersive/task/BaseUpdateTask;", "Ljava/lang/Runnable;", "window", "Landroid/view/Window;", "(Landroid/view/Window;)V", "pointToViewListForNavigatorBar", "", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", HippyTKDListViewAdapter.X, "", "y", TencentLocation.RUN_MODE, "", "Companion", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class NavigatorUpdateTask extends BaseUpdateTask implements Runnable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/compat/immersive/task/NavigatorUpdateTask$Companion;", "", "()V", "TAG", "", "adjustBottomNavigatorIconColor", "", "window", "Landroid/view/Window;", "color", "", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public final void adjustBottomNavigatorIconColor(@Nullable Window window, int color) {
            boolean z16;
            if (ColorFetchUtil.INSTANCE.calculateLuminance(color) > BaseUpdateTask.INSTANCE.getLIGHT_THRESHOLD()) {
                z16 = true;
            } else {
                z16 = false;
            }
            RFWImmersiveUtils.setNavigationBarIconColor(window, z16);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigatorUpdateTask(@NotNull Window window) {
        super(window);
        Intrinsics.checkNotNullParameter(window, "window");
    }

    private final List<View> pointToViewListForNavigatorBar(ViewGroup parentView, int x16, int y16) {
        Rect rect = new Rect();
        int childCount = parentView.getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childView = parentView.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            if (childView.getVisibility() == 0 && childView.getAlpha() != 0.0f) {
                childView.getHitRect(rect);
                if (rect.contains(x16, y16)) {
                    arrayList.add(childView);
                    if (needFindChild(childView, true)) {
                        arrayList.addAll(pointToViewListForNavigatorBar((ViewGroup) childView, x16, childView.getHeight() - 1));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Window window = getDetectWindowWrf().get();
        if (window != null) {
            Intrinsics.checkNotNullExpressionValue(window, "detectWindowWrf.get() ?: return");
            long nanoTime = System.nanoTime();
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(R.id.content);
            if (viewGroup == null) {
                RFWLog.i("RFWAutoImmersiveConfig-NavigatorUpdateTask", RFWLog.USR, "can't find content view");
                return;
            }
            arrayList.addAll(pointToViewListForNavigatorBar(viewGroup, 1, viewGroup.getHeight() - 1));
            RFWLog.d("RFWAutoImmersiveConfig-NavigatorUpdateTask", RFWLog.USR, "findViews " + arrayList + " costTime: " + (System.nanoTime() - nanoTime));
            ArrayList arrayList2 = new ArrayList();
            Pair<Boolean, Integer> backgroundColor = getBackgroundColor(arrayList, IColorFetcher.Area.BOTTOM, arrayList2);
            RFWLog.i("RFWAutoImmersiveConfig-NavigatorUpdateTask", RFWLog.USR, "navigation backgroundColorResult " + backgroundColor + " costTime: " + (System.nanoTime() - nanoTime));
            Object obj = backgroundColor.first;
            Intrinsics.checkNotNullExpressionValue(obj, "backgroundColorResult.first");
            if (((Boolean) obj).booleanValue()) {
                window.addFlags(Integer.MIN_VALUE);
                int navigationBarColor = window.getNavigationBarColor();
                Integer num = (Integer) backgroundColor.second;
                if (num == null || navigationBarColor != num.intValue()) {
                    Object obj2 = backgroundColor.second;
                    Intrinsics.checkNotNullExpressionValue(obj2, "backgroundColorResult.second");
                    window.setNavigationBarColor(((Number) obj2).intValue());
                    Companion companion = INSTANCE;
                    Object obj3 = backgroundColor.second;
                    Intrinsics.checkNotNullExpressionValue(obj3, "backgroundColorResult.second");
                    companion.adjustBottomNavigatorIconColor(window, ((Number) obj3).intValue());
                    RFWLog.i("RFWAutoImmersiveConfig-NavigatorUpdateTask", RFWLog.USR, "setNavigationBarColor costTime: " + (System.nanoTime() - nanoTime));
                    WindowColorFetcherState colorFetcherState = RFWAutoImmersiveHelper.INSTANCE.getColorFetcherState(window);
                    colorFetcherState.setWindowWrf(new WeakReference<>(window));
                    colorFetcherState.setHasSetNavigatorBarColor(true);
                    colorFetcherState.setNavigatorColorResult(backgroundColor);
                    colorFetcherState.setNavigatorAreaViews(arrayList2);
                } else {
                    RFWLog.d("RFWAutoImmersiveConfig-NavigatorUpdateTask", RFWLog.USR, "the navigationColor is same, do nothing");
                    Companion companion2 = INSTANCE;
                    Object obj4 = backgroundColor.second;
                    Intrinsics.checkNotNullExpressionValue(obj4, "backgroundColorResult.second");
                    companion2.adjustBottomNavigatorIconColor(window, ((Number) obj4).intValue());
                }
            } else {
                RFWLog.i("RFWAutoImmersiveConfig-NavigatorUpdateTask", RFWLog.USR, "backgroundColorResult: false");
            }
            RFWLog.i("RFWAutoImmersiveConfig-NavigatorUpdateTask", RFWLog.USR, "total costTime: " + (System.nanoTime() - nanoTime));
        }
    }
}
