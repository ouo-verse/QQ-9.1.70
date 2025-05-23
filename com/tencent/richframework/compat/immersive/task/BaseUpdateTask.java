package com.tencent.richframework.compat.immersive.task;

import android.graphics.Color;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.richframework.compat.immersive.AutoImmersiveConfig;
import com.tencent.richframework.compat.immersive.color.ColorFetchUtil;
import com.tencent.richframework.compat.immersive.color.ColorFetcherManager;
import com.tencent.richframework.compat.immersive.color.IColorFetcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J<\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000bR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/richframework/compat/immersive/task/BaseUpdateTask;", "", "Landroid/view/View;", "view", "", "ignoreScrollView", "needFindChild", "", "targetViews", "Lcom/tencent/richframework/compat/immersive/color/IColorFetcher$Area;", GdtGetUserInfoHandler.KEY_AREA, "", "Ljava/lang/ref/WeakReference;", "colorViews", "Landroid/util/Pair;", "", "getBackgroundColor", "Landroid/view/Window;", "detectWindowWrf", "Ljava/lang/ref/WeakReference;", "getDetectWindowWrf", "()Ljava/lang/ref/WeakReference;", "setDetectWindowWrf", "(Ljava/lang/ref/WeakReference;)V", "isCancel", "Z", "()Z", "setCancel", "(Z)V", "window", "<init>", "(Landroid/view/Window;)V", "Companion", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class BaseUpdateTask {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float LIGHT_THRESHOLD = AutoImmersiveConfig.getLightThreshold();

    @NotNull
    private WeakReference<Window> detectWindowWrf;
    private volatile boolean isCancel;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/compat/immersive/task/BaseUpdateTask$Companion;", "", "()V", "LIGHT_THRESHOLD", "", "getLIGHT_THRESHOLD", "()F", "TAG", "", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public final float getLIGHT_THRESHOLD() {
            return BaseUpdateTask.LIGHT_THRESHOLD;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseUpdateTask(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        this.detectWindowWrf = new WeakReference<>(window);
    }

    @NotNull
    public final Pair<Boolean, Integer> getBackgroundColor(@NotNull List<? extends View> targetViews, @NotNull IColorFetcher.Area area, @NotNull List<WeakReference<View>> colorViews) {
        int i3;
        Integer num;
        Intrinsics.checkNotNullParameter(targetViews, "targetViews");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(colorViews, "colorViews");
        ArrayList arrayList = new ArrayList();
        int size = targetViews.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            View view = targetViews.get(size);
            IColorFetcher findTargetColorFetcher = ColorFetcherManager.INSTANCE.findTargetColorFetcher(view);
            if (findTargetColorFetcher != null) {
                Pair<Boolean, Integer> color = findTargetColorFetcher.getColor(view, area);
                Object obj = color.first;
                Intrinsics.checkNotNullExpressionValue(obj, "result.first");
                if (((Boolean) obj).booleanValue() && ((num = (Integer) color.second) == null || num.intValue() != 0)) {
                    int i16 = RFWLog.USR;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("in index:");
                    sb5.append(size);
                    sb5.append(" use colorFetcher:");
                    sb5.append(findTargetColorFetcher);
                    sb5.append(" findColor formView:");
                    sb5.append(view);
                    sb5.append(" color:");
                    Object obj2 = color.second;
                    Intrinsics.checkNotNullExpressionValue(obj2, "result.second");
                    sb5.append(Integer.toHexString(((Number) obj2).intValue()));
                    RFWLog.d("RFWAutoImmersiveConfig-BaseUpdateTask", i16, sb5.toString());
                    Object obj3 = color.second;
                    Intrinsics.checkNotNullExpressionValue(obj3, "result.second");
                    if (Color.alpha(((Number) obj3).intValue()) != 0) {
                        Object obj4 = color.second;
                        Intrinsics.checkNotNullExpressionValue(obj4, "result.second");
                        arrayList.add(obj4);
                        colorViews.add(new WeakReference<>(view));
                    }
                    Object obj5 = color.second;
                    Intrinsics.checkNotNullExpressionValue(obj5, "result.second");
                    if (Color.alpha(((Number) obj5).intValue()) == 255) {
                        RFWLog.e("RFWAutoImmersiveConfig-BaseUpdateTask", RFWLog.USR, "find color:" + ((Integer) color.second) + " alpha is 255, stop find");
                        break;
                    }
                } else {
                    RFWLog.e("RFWAutoImmersiveConfig-BaseUpdateTask", RFWLog.USR, "in index:" + size + " handle error: view:" + view + " colorFetcher:" + findTargetColorFetcher + " result:" + color);
                }
            }
        }
        if (arrayList.size() == 0) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        int intValue = ((Number) arrayList.get(0)).intValue();
        int size2 = arrayList.size();
        for (i3 = 1; i3 < size2; i3++) {
            intValue = ColorFetchUtil.INSTANCE.compositingColor(intValue, ((Number) arrayList.get(i3)).intValue());
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(intValue));
    }

    @NotNull
    public final WeakReference<Window> getDetectWindowWrf() {
        return this.detectWindowWrf;
    }

    /* renamed from: isCancel, reason: from getter */
    public final boolean getIsCancel() {
        return this.isCancel;
    }

    public final boolean needFindChild(@NotNull View view, boolean ignoreScrollView) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        if ((ignoreScrollView && ((view instanceof ScrollView) || (view instanceof RecyclerView))) || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return false;
        }
        return true;
    }

    public final void setCancel(boolean z16) {
        this.isCancel = z16;
    }
}
