package com.tencent.richframework.compat.immersive.task;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/compat/immersive/task/StatusBarUpdateTask;", "Lcom/tencent/richframework/compat/immersive/task/BaseUpdateTask;", "Ljava/lang/Runnable;", "window", "Landroid/view/Window;", "(Landroid/view/Window;)V", "pointToViewListForStatusBar", "", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", HippyTKDListViewAdapter.X, "", "y", TencentLocation.RUN_MODE, "", "Companion", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class StatusBarUpdateTask extends BaseUpdateTask implements Runnable {
    private static final int STATUS_BAR_POINT_X = ImmersiveUtils.getScreenWidth() / 2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusBarUpdateTask(@NotNull Window window) {
        super(window);
        Intrinsics.checkNotNullParameter(window, "window");
    }

    private final List<View> pointToViewListForStatusBar(ViewGroup parentView, int x16, int y16) {
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
                    if (needFindChild(childView, false)) {
                        arrayList.addAll(pointToViewListForStatusBar((ViewGroup) childView, x16, y16));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        final boolean z16;
        final Window window = getDetectWindowWrf().get();
        if (window != null) {
            Intrinsics.checkNotNullExpressionValue(window, "detectWindowWrf.get() ?: return");
            if (getIsCancel()) {
                return;
            }
            final long nanoTime = System.nanoTime();
            View decorView = window.getDecorView();
            if (decorView != null) {
                ArrayList arrayList = new ArrayList(pointToViewListForStatusBar((ViewGroup) decorView, STATUS_BAR_POINT_X, 5));
                RFWLog.d("RFWAutoImmersiveConfig-StatusUpdateTask", RFWLog.USR, RFWStringBuilderUtils.getString("adjust StatusBarText findView ", arrayList, " costTime: ", Long.valueOf(System.nanoTime() - nanoTime)));
                final ArrayList arrayList2 = new ArrayList();
                final Pair<Boolean, Integer> backgroundColor = getBackgroundColor(arrayList, IColorFetcher.Area.TOP, arrayList2);
                RFWLog.i("RFWAutoImmersiveConfig-StatusUpdateTask", RFWLog.USR, "adjust StatusBarText  backgroundColorResult " + backgroundColor + " costTime: " + (System.nanoTime() - nanoTime));
                Object obj = backgroundColor.first;
                Intrinsics.checkNotNullExpressionValue(obj, "backgroundColorResult.first");
                if (((Boolean) obj).booleanValue()) {
                    ColorFetchUtil colorFetchUtil = ColorFetchUtil.INSTANCE;
                    Object obj2 = backgroundColor.second;
                    Intrinsics.checkNotNullExpressionValue(obj2, "backgroundColorResult.second");
                    final double calculateLuminance = colorFetchUtil.calculateLuminance(((Number) obj2).intValue());
                    if (calculateLuminance > BaseUpdateTask.INSTANCE.getLIGHT_THRESHOLD()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    RFWAutoImmersiveHelper.runInMain$default(RFWAutoImmersiveHelper.INSTANCE, new Runnable() { // from class: com.tencent.richframework.compat.immersive.task.StatusBarUpdateTask$run$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            WindowColorFetcherState colorFetcherState = RFWAutoImmersiveHelper.INSTANCE.getColorFetcherState(window);
                            colorFetcherState.setWindowWrf(new WeakReference<>(window));
                            colorFetcherState.setStatusBarColorResult(backgroundColor);
                            colorFetcherState.setHasSetStatusBarTextColor(true);
                            colorFetcherState.setStatusAreaViews(arrayList2);
                            RFWImmersiveUtils.setStatusBarTextColor(window, z16);
                            int i3 = RFWLog.USR;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("adjust StatusBarText color: ");
                            Object obj3 = backgroundColor.second;
                            Intrinsics.checkNotNullExpressionValue(obj3, "backgroundColorResult.second");
                            sb5.append(Integer.toHexString(((Number) obj3).intValue()));
                            sb5.append(" luminance");
                            sb5.append(calculateLuminance);
                            sb5.append(" useDarkText:");
                            sb5.append(z16);
                            sb5.append(" setStatusTextColorNew costTime: ");
                            sb5.append(System.nanoTime() - nanoTime);
                            RFWLog.i("RFWAutoImmersiveConfig-StatusUpdateTask", i3, sb5.toString());
                        }
                    }, 0L, 0, 6, null);
                    return;
                }
                RFWAutoImmersiveHelper.runInMain$default(RFWAutoImmersiveHelper.INSTANCE, new Runnable() { // from class: com.tencent.richframework.compat.immersive.task.StatusBarUpdateTask$run$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindowColorFetcherState colorFetcherState = RFWAutoImmersiveHelper.INSTANCE.getColorFetcherState(window);
                        colorFetcherState.setWindowWrf(new WeakReference<>(window));
                        colorFetcherState.setStatusBarColorResult(backgroundColor);
                        colorFetcherState.setHasSetStatusBarTextColor(true);
                        colorFetcherState.setStatusAreaViews(new ArrayList());
                    }
                }, 0L, 0, 6, null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }
}
