package com.tencent.richframework.compat.immersive;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.util.Consumer;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.compat.immersive.view.RFWNavigationBarBackgroundView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001:\tVWXYZ[\\]^B\t\b\u0002\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J:\u0010\u0015\u001a\u00020\u00042\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010!\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0001H\u0002J<\u0010%\u001a\u00020\b2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010$\u001a\u00020 H\u0002J<\u0010&\u001a\u00020\b2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010$\u001a\u00020 H\u0002J<\u0010'\u001a\u00020\b2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010$\u001a\u00020 H\u0002J\u0012\u0010(\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010*\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010+\u001a\u00020 2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010+\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ+\u0010/\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0,\"\u00020-\u00a2\u0006\u0004\b/\u00100J\u001c\u00102\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00101\u001a\u00020\bH\u0007J\u001c\u00104\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00103\u001a\u00020\bH\u0007J&\u00107\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020\bH\u0007J\u001c\u00109\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00108\u001a\u00020\bH\u0007J(\u0010>\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<J\u0010\u0010?\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010@\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0010\u0010A\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0016\u001a\u00020\u0013J\u001e\u0010F\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010DH\u0007J\u0012\u0010G\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010H\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<J\u000e\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020IR0\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010NR\u0014\u0010O\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010PR\u0014\u0010R\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0014\u0010S\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010P\u00a8\u0006_"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper;", "", "Landroid/view/Window;", "window", "", "useSystemMethodGetInsets", "useOldMethodGetInsets", "innerSetNavigationBarImmersive", "", "navigationBarHeight", "navigationBarLeft", "navigationBarRight", "onWindowInsetsChanged", "Ljava/util/HashMap;", "", "Lcom/tencent/richframework/compat/immersive/NavigationBarInfo;", "Lkotlin/collections/HashMap;", "map", "Landroidx/core/util/Consumer;", "Landroid/view/View;", "runnable", TencentLocation.RUN_MODE, "view", "Ljava/lang/Runnable;", "runAfterConfirmedTheWindow", "Landroid/app/Activity;", "getActivityForView", "getNavigationBarHeight", "Landroid/content/Context;", "context", "Lcom/tencent/richframework/compat/immersive/WindowNavigationBarInfo;", "getNavigationBarWindowInfo", "", "needAdJust", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "getKey", "forceUpdate", "getChangeNavigationBarHeight", "getChangeNavigationBarLeft", "getChangeNavigationBarRight", "isOpenNavigationBarImmersive", "getActivityContext", "setNavigationBarImmersive", "hadSetNavigationBarImmersive", "", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;", "type", "adjustView", "(Landroid/view/View;[Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;)V", "heightWithoutNavigationBarHeight", "adjustViewHeight", "paddingBottomWithoutNavigationBarHeight", "adjustViewPaddingBottom", "paddingLeftWithoutNavigationBarHeight", "paddingRightWithoutNavigationBarHeight", "adjustViewBothSidesPadding", "marginBottomWithoutNavigationBarHeight", "adjustViewMarginBottom", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "callback", "registerNavigationBarCallBack", "getCurrentNavigationBarHeight", "tryRequestFitSystemWindows", "getWindowInfo", "Landroid/view/ViewGroup;", "parentView", "Landroid/graphics/drawable/Drawable;", "drawable", "fillNavigationBarBackgroundView", "getRealContext", "unregisterNavigationBarHeightCallBack", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarImmersiveDelegate;", "delegate", "setNaviBarImmersiveDelegate", "windowHashMap", "Ljava/util/HashMap;", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarImmersiveDelegate;", h.f248218g, "Z", "openBothSides", "useSystemMethod", "useThemeWrapper", "<init>", "()V", "AdjustHeightRunnable", "AdjustViewRunnable", "ImmersiveType", "InnerLifecycleObserver", "MarginRunnable", "NavigationBarHeightChangeCallback", "NavigationBarImmersiveDelegate", "PaddingBothSidesRunnable", "PaddingBottomRunnable", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWNavigationBarImmersiveHelper {
    private static NavigationBarImmersiveDelegate delegate;

    @NotNull
    public static final RFWNavigationBarImmersiveHelper INSTANCE = new RFWNavigationBarImmersiveHelper();
    private static final HashMap<String, WindowNavigationBarInfo> windowHashMap = new HashMap<>();
    private static final boolean isOpen = AutoImmersiveConfig.isOpenNavigationBarImmersive();
    private static final boolean openBothSides = RFWConfig.getConfigValue("navigation_bar_immersive_both_open", true);
    private static final boolean useSystemMethod = RFWConfig.getConfigValue("navigation_bar_immersive_user_system_method", true);
    private static final boolean useThemeWrapper = RFWConfig.getConfigValue("navigation_bar_user_theme_wrapper", true);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$AdjustHeightRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "", "height", "I", "getHeight", "()I", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class AdjustHeightRunnable implements Runnable {
        private final int height;

        @NotNull
        private final WeakReference<View> viewWeakReference;

        public AdjustHeightRunnable(@NotNull WeakReference<View> viewWeakReference, int i3) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            this.viewWeakReference = viewWeakReference;
            this.height = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            View view = this.viewWeakReference.get();
            if (view != null) {
                RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(view, "view");
                WindowNavigationBarInfo windowInfo = rFWNavigationBarImmersiveHelper.getWindowInfo(view);
                if (windowInfo != null) {
                    int i3 = this.height;
                    if (i3 != Integer.MIN_VALUE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams != null) {
                            i3 = layoutParams.height;
                        } else {
                            i3 = Integer.MIN_VALUE;
                        }
                    }
                    if (i3 >= 0) {
                        int changeNavigationBarHeight = rFWNavigationBarImmersiveHelper.getChangeNavigationBarHeight(windowInfo.getHeightHashMap(), view, z16);
                        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.height = i3 + changeNavigationBarHeight;
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$AdjustViewRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;", "types", "[Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;", "getTypes", "()[Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;", "<init>", "(Ljava/lang/ref/WeakReference;[Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;)V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    private static final class AdjustViewRunnable implements Runnable {

        @NotNull
        private final ImmersiveType[] types;

        @NotNull
        private final WeakReference<View> viewWeakReference;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes25.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ImmersiveType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[ImmersiveType.IMMERSIVE.ordinal()] = 1;
                iArr[ImmersiveType.ABOVE.ordinal()] = 2;
                iArr[ImmersiveType.SIDES.ordinal()] = 3;
            }
        }

        public AdjustViewRunnable(@NotNull WeakReference<View> viewWeakReference, @NotNull ImmersiveType... types) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            Intrinsics.checkNotNullParameter(types, "types");
            this.viewWeakReference = viewWeakReference;
            this.types = types;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.viewWeakReference.get();
            if (view != null) {
                for (ImmersiveType immersiveType : this.types) {
                    int i3 = WhenMappings.$EnumSwitchMapping$0[immersiveType.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                RFWNavigationBarImmersiveHelper.adjustViewBothSidesPadding$default(RFWNavigationBarImmersiveHelper.INSTANCE, view, 0, 0, 6, null);
                            }
                        } else {
                            RFWNavigationBarImmersiveHelper.adjustViewMarginBottom$default(RFWNavigationBarImmersiveHelper.INSTANCE, view, 0, 2, null);
                        }
                    } else {
                        RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
                        RFWNavigationBarImmersiveHelper.adjustViewHeight$default(rFWNavigationBarImmersiveHelper, view, 0, 2, null);
                        RFWNavigationBarImmersiveHelper.adjustViewPaddingBottom$default(rFWNavigationBarImmersiveHelper, view, 0, 2, null);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;", "", "(Ljava/lang/String;I)V", "IMMERSIVE", "SIDES", "ABOVE", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum ImmersiveType {
        IMMERSIVE,
        SIDES,
        ABOVE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$InnerLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "callback", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "getCallback", "()Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;)V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class InnerLifecycleObserver implements LifecycleObserver {

        @NotNull
        private final NavigationBarHeightChangeCallback callback;

        @NotNull
        private final Lifecycle lifecycle;

        public InnerLifecycleObserver(@NotNull Lifecycle lifecycle, @NotNull NavigationBarHeightChangeCallback callback) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.lifecycle = lifecycle;
            this.callback = callback;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            RFWLog.d("RFWNavigationImmersiveHelper", RFWLog.USR, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            this.lifecycle.removeObserver(this);
            RFWNavigationBarImmersiveHelper.INSTANCE.unregisterNavigationBarHeightCallBack(this.callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$MarginRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "", NodeProps.MARGIN_BOTTOM, "I", "getMarginBottom", "()I", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class MarginRunnable implements Runnable {
        private final int marginBottom;

        @NotNull
        private final WeakReference<View> viewWeakReference;

        public MarginRunnable(@NotNull WeakReference<View> viewWeakReference, int i3) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            this.viewWeakReference = viewWeakReference;
            this.marginBottom = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            final View view = this.viewWeakReference.get();
            if (view != null) {
                RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(view, "view");
                WindowNavigationBarInfo windowInfo = rFWNavigationBarImmersiveHelper.getWindowInfo(view);
                if (windowInfo != null) {
                    if (this.marginBottom != Integer.MIN_VALUE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    int changeNavigationBarHeight = rFWNavigationBarImmersiveHelper.getChangeNavigationBarHeight(windowInfo.getMarginHashMap(), view, z16);
                    if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            if (z16) {
                                marginLayoutParams.bottomMargin = this.marginBottom + changeNavigationBarHeight;
                            } else {
                                marginLayoutParams.bottomMargin += changeNavigationBarHeight;
                            }
                            view.setLayoutParams(marginLayoutParams);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                    if (view.getLayoutParams() == null && view.getParent() == null) {
                        view.post(new Runnable() { // from class: com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper$MarginRunnable$run$$inlined$let$lambda$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.run();
                            }
                        });
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "", "onChange", "", "naviHeight", "", "left", "right", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface NavigationBarHeightChangeCallback {
        void onChange(int naviHeight, int left, int right);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarImmersiveDelegate;", "", h.f248218g, "", "context", "Landroid/content/Context;", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface NavigationBarImmersiveDelegate {
        boolean isOpen(@Nullable Context context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$PaddingBothSidesRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "", NodeProps.PADDING_LEFT, "I", "getPaddingLeft", "()I", NodeProps.PADDING_RIGHT, "getPaddingRight", "<init>", "(Ljava/lang/ref/WeakReference;II)V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class PaddingBothSidesRunnable implements Runnable {
        private final int paddingLeft;
        private final int paddingRight;

        @NotNull
        private final WeakReference<View> viewWeakReference;

        public PaddingBothSidesRunnable(@NotNull WeakReference<View> viewWeakReference, int i3, int i16) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            this.viewWeakReference = viewWeakReference;
            this.paddingLeft = i3;
            this.paddingRight = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            int paddingLeft;
            int paddingRight;
            View view = this.viewWeakReference.get();
            if (view != null) {
                RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(view, "view");
                WindowNavigationBarInfo windowInfo = rFWNavigationBarImmersiveHelper.getWindowInfo(view);
                if (windowInfo != null) {
                    boolean z17 = true;
                    if (this.paddingLeft != Integer.MIN_VALUE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    int changeNavigationBarLeft = rFWNavigationBarImmersiveHelper.getChangeNavigationBarLeft(windowInfo.getLeftSidePaddingHashMap(), view, z16);
                    if (this.paddingRight == Integer.MIN_VALUE) {
                        z17 = false;
                    }
                    int changeNavigationBarRight = rFWNavigationBarImmersiveHelper.getChangeNavigationBarRight(windowInfo.getRightSidePaddingHashMap(), view, z17);
                    if (z16) {
                        paddingLeft = this.paddingLeft;
                    } else {
                        paddingLeft = view.getPaddingLeft();
                    }
                    int i3 = paddingLeft + changeNavigationBarLeft;
                    if (z17) {
                        paddingRight = this.paddingRight;
                    } else {
                        paddingRight = view.getPaddingRight();
                    }
                    view.setPadding(i3, view.getPaddingTop(), paddingRight + changeNavigationBarRight, view.getPaddingBottom());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$PaddingBottomRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "", NodeProps.PADDING_BOTTOM, "I", "getPaddingBottom", "()I", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class PaddingBottomRunnable implements Runnable {
        private final int paddingBottom;

        @NotNull
        private final WeakReference<View> viewWeakReference;

        public PaddingBottomRunnable(@NotNull WeakReference<View> viewWeakReference, int i3) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            this.viewWeakReference = viewWeakReference;
            this.paddingBottom = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            View view = this.viewWeakReference.get();
            if (view != null) {
                RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(view, "view");
                WindowNavigationBarInfo windowInfo = rFWNavigationBarImmersiveHelper.getWindowInfo(view);
                if (windowInfo != null) {
                    if (this.paddingBottom != Integer.MIN_VALUE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    int changeNavigationBarHeight = rFWNavigationBarImmersiveHelper.getChangeNavigationBarHeight(windowInfo.getPaddingBottomHashMap(), view, z16);
                    if (z16) {
                        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), this.paddingBottom + changeNavigationBarHeight);
                    } else {
                        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom() + changeNavigationBarHeight);
                    }
                }
            }
        }
    }

    RFWNavigationBarImmersiveHelper() {
    }

    public static /* synthetic */ void adjustViewBothSidesPadding$default(RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper, View view, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        if ((i17 & 4) != 0) {
            i16 = Integer.MIN_VALUE;
        }
        rFWNavigationBarImmersiveHelper.adjustViewBothSidesPadding(view, i3, i16);
    }

    public static /* synthetic */ void adjustViewHeight$default(RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        rFWNavigationBarImmersiveHelper.adjustViewHeight(view, i3);
    }

    public static /* synthetic */ void adjustViewMarginBottom$default(RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        rFWNavigationBarImmersiveHelper.adjustViewMarginBottom(view, i3);
    }

    public static /* synthetic */ void adjustViewPaddingBottom$default(RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        rFWNavigationBarImmersiveHelper.adjustViewPaddingBottom(view, i3);
    }

    private final Activity getActivityContext(View view) {
        Context context;
        View view2;
        View childAt;
        Context context2 = null;
        if (Intrinsics.areEqual(view.getClass().getName(), "com.android.internal.policy.DecorView")) {
            if (!(view instanceof ViewGroup)) {
                view2 = null;
            } else {
                view2 = view;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (viewGroup == null || (childAt = viewGroup.getChildAt(0)) == null || (context = childAt.getContext()) == null) {
                context = view.getContext();
            }
        } else {
            context = view.getContext();
        }
        if (context instanceof Activity) {
            context2 = context;
        }
        return (Activity) context2;
    }

    private final Activity getActivityForView(View view) {
        Activity realContext = getRealContext(view.getContext());
        if (realContext == null) {
            View rootView = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
            return getActivityContext(rootView);
        }
        return realContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getChangeNavigationBarHeight(HashMap<String, NavigationBarInfo> map, View view, boolean forceUpdate) {
        NavigationBarInfo navigationBarInfo = map.get(getKey(view));
        int navigationBarHeight = getNavigationBarHeight(view);
        map.put(getKey(view), new NavigationBarInfo(new WeakReference(view), navigationBarHeight));
        if (!forceUpdate && navigationBarInfo != null) {
            return navigationBarHeight - navigationBarInfo.getHeight();
        }
        return navigationBarHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getChangeNavigationBarLeft(HashMap<String, NavigationBarInfo> map, View view, boolean forceUpdate) {
        int i3;
        NavigationBarInfo navigationBarInfo = map.get(getKey(view));
        WindowNavigationBarInfo windowInfo = getWindowInfo(view);
        if (windowInfo != null) {
            i3 = windowInfo.getNaviBarLeft();
        } else {
            i3 = 0;
        }
        map.put(getKey(view), new NavigationBarInfo(new WeakReference(view), i3));
        if (!forceUpdate && navigationBarInfo != null) {
            return i3 - navigationBarInfo.getHeight();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getChangeNavigationBarRight(HashMap<String, NavigationBarInfo> map, View view, boolean forceUpdate) {
        int i3;
        NavigationBarInfo navigationBarInfo = map.get(getKey(view));
        WindowNavigationBarInfo windowInfo = getWindowInfo(view);
        if (windowInfo != null) {
            i3 = windowInfo.getNaviBarRight();
        } else {
            i3 = 0;
        }
        map.put(getKey(view), new NavigationBarInfo(new WeakReference(view), i3));
        if (!forceUpdate && navigationBarInfo != null) {
            return i3 - navigationBarInfo.getHeight();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getKey(Object any) {
        return String.valueOf(any.hashCode());
    }

    private final int getNavigationBarHeight(View view) {
        WindowNavigationBarInfo navigationBarWindowInfo = getNavigationBarWindowInfo(getActivityForView(view));
        if (navigationBarWindowInfo != null) {
            return navigationBarWindowInfo.getNaviBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowNavigationBarInfo getNavigationBarWindowInfo(Context context) {
        Activity realContext = getRealContext(context);
        if (realContext != null) {
            HashMap<String, WindowNavigationBarInfo> hashMap = windowHashMap;
            Window window = realContext.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "realContext.window");
            return hashMap.get(getKey(window));
        }
        return null;
    }

    private final void innerSetNavigationBarImmersive(Window window) {
        boolean isNavigationBarContrastEnforced;
        if (Build.VERSION.SDK_INT >= 29) {
            isNavigationBarContrastEnforced = window.isNavigationBarContrastEnforced();
            if (isNavigationBarContrastEnforced) {
                window.setNavigationBarContrastEnforced(false);
            }
        } else {
            RFWImmersiveUtils.clearFlags(window, 134217728);
            RFWImmersiveUtils.addFlags(window, Integer.MIN_VALUE);
        }
        ImmersiveUtils.setSystemUiVisibilityUsedOr(window, 512);
        if (window.getNavigationBarColor() != 0) {
            window.setNavigationBarColor(0);
        }
    }

    private final boolean isOpenNavigationBarImmersive(Context context) {
        NavigationBarImmersiveDelegate navigationBarImmersiveDelegate = delegate;
        if ((navigationBarImmersiveDelegate == null || (navigationBarImmersiveDelegate != null && navigationBarImmersiveDelegate.isOpen(context))) && isOpen) {
            return true;
        }
        return false;
    }

    private final boolean needAdJust(Context context) {
        if (context instanceof Activity) {
            HashMap<String, WindowNavigationBarInfo> hashMap = windowHashMap;
            Window window = ((Activity) context).getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "context.window");
            return hashMap.containsKey(getKey(window));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWindowInsetsChanged(Window window, int navigationBarHeight, int navigationBarLeft, int navigationBarRight) {
        if (!hadSetNavigationBarImmersive(window)) {
            return;
        }
        innerSetNavigationBarImmersive(window);
        WindowNavigationBarInfo windowNavigationBarInfo = windowHashMap.get(getKey(window));
        if (windowNavigationBarInfo != null) {
            if (navigationBarHeight == windowNavigationBarInfo.getNaviBarHeight() && navigationBarRight == windowNavigationBarInfo.getNaviBarRight() && navigationBarLeft == windowNavigationBarInfo.getNaviBarLeft()) {
                return;
            }
            RFWLog.d("RFWNavigationImmersiveHelper", RFWLog.USR, "onWindowInsetsChanged,current naviHeight:", Integer.valueOf(navigationBarHeight), ",navigationBarRight:", Integer.valueOf(navigationBarRight), ",navigationBarLeft:", Integer.valueOf(navigationBarLeft));
            if (navigationBarHeight != windowNavigationBarInfo.getNaviBarHeight()) {
                windowNavigationBarInfo.setNaviBarHeight(navigationBarHeight);
                run(windowNavigationBarInfo.getHeightHashMap(), new Consumer<View>() { // from class: com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper$onWindowInsetsChanged$1
                    @Override // androidx.core.util.Consumer
                    public final void accept(View view) {
                        RFWNavigationBarImmersiveHelper.adjustViewHeight$default(RFWNavigationBarImmersiveHelper.INSTANCE, view, 0, 2, null);
                    }
                });
                run(windowNavigationBarInfo.getPaddingBottomHashMap(), new Consumer<View>() { // from class: com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper$onWindowInsetsChanged$2
                    @Override // androidx.core.util.Consumer
                    public final void accept(View view) {
                        RFWNavigationBarImmersiveHelper.adjustViewPaddingBottom$default(RFWNavigationBarImmersiveHelper.INSTANCE, view, 0, 2, null);
                    }
                });
                run(windowNavigationBarInfo.getMarginHashMap(), new Consumer<View>() { // from class: com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper$onWindowInsetsChanged$3
                    @Override // androidx.core.util.Consumer
                    public final void accept(View view) {
                        RFWNavigationBarImmersiveHelper.adjustViewMarginBottom$default(RFWNavigationBarImmersiveHelper.INSTANCE, view, 0, 2, null);
                    }
                });
            }
            if (navigationBarRight != windowNavigationBarInfo.getNaviBarRight() || navigationBarLeft != windowNavigationBarInfo.getNaviBarLeft()) {
                windowNavigationBarInfo.setNaviBarRight(navigationBarRight);
                windowNavigationBarInfo.setNaviBarLeft(navigationBarLeft);
                HashMap<String, NavigationBarInfo> hashMap = new HashMap<>();
                hashMap.putAll(windowNavigationBarInfo.getLeftSidePaddingHashMap());
                hashMap.putAll(windowNavigationBarInfo.getRightSidePaddingHashMap());
                run(hashMap, new Consumer<View>() { // from class: com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper$onWindowInsetsChanged$4
                    @Override // androidx.core.util.Consumer
                    public final void accept(View view) {
                        RFWNavigationBarImmersiveHelper.adjustViewBothSidesPadding$default(RFWNavigationBarImmersiveHelper.INSTANCE, view, 0, 0, 6, null);
                    }
                });
            }
            Iterator<T> it = windowNavigationBarInfo.getNavigationBarHeightCallback().iterator();
            while (it.hasNext()) {
                ((NavigationBarHeightChangeCallback) it.next()).onChange(navigationBarHeight, navigationBarLeft, navigationBarRight);
            }
            Iterator<T> it5 = windowNavigationBarInfo.getRunnable().iterator();
            while (it5.hasNext()) {
                ((Runnable) it5.next()).run();
            }
            windowNavigationBarInfo.getRunnable().clear();
        }
    }

    private final void run(HashMap<String, NavigationBarInfo> map, Consumer<View> runnable) {
        Iterator<Map.Entry<String, NavigationBarInfo>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            View view = it.next().getValue().getViewWeakReference().get();
            if (view == null) {
                it.remove();
            } else {
                runnable.accept(view);
            }
        }
    }

    private final void runAfterConfirmedTheWindow(View view, Runnable runnable) {
        if (!isOpenNavigationBarImmersive(view.getContext())) {
            return;
        }
        Activity activityForView = getActivityForView(view);
        if (activityForView != null) {
            HashMap<String, WindowNavigationBarInfo> hashMap = windowHashMap;
            Window window = activityForView.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            WindowNavigationBarInfo windowNavigationBarInfo = hashMap.get(getKey(window));
            if (windowNavigationBarInfo == null) {
                view.post(runnable);
                return;
            } else if (windowNavigationBarInfo.getNaviBarHeight() == -1) {
                windowNavigationBarInfo.getRunnable().add(runnable);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        view.post(runnable);
    }

    private final void useOldMethodGetInsets(final Window window) {
        window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper$useOldMethodGetInsets$1
            @Override // android.view.View.OnApplyWindowInsetsListener
            @NotNull
            public final WindowInsets onApplyWindowInsets(@NotNull View v3, @NotNull WindowInsets insets) {
                boolean z16;
                int i3;
                boolean z17;
                Intrinsics.checkNotNullParameter(v3, "v");
                Intrinsics.checkNotNullParameter(insets, "insets");
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets);
                Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "WindowInsetsCompat.toWindowInsetsCompat(insets)");
                int i16 = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars()).bottom;
                RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
                z16 = RFWNavigationBarImmersiveHelper.openBothSides;
                int i17 = 0;
                if (z16) {
                    i3 = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars()).right;
                } else {
                    i3 = 0;
                }
                z17 = RFWNavigationBarImmersiveHelper.openBothSides;
                if (z17) {
                    i17 = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars()).left;
                }
                rFWNavigationBarImmersiveHelper.onWindowInsetsChanged(window, i16, i17, i3);
                return insets;
            }
        });
    }

    private final void useSystemMethodGetInsets(final Window window) {
        ViewCompat.setOnApplyWindowInsetsListener(window.getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper$useSystemMethodGetInsets$1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                boolean z16;
                int i3;
                boolean z17;
                int systemBars = WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout();
                Insets insetsIgnoringVisibility = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars());
                Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "insetsCompat.getInsetsIg\u2026Compat.Type.systemBars())");
                Insets min = Insets.min(windowInsetsCompat.getInsets(systemBars), insetsIgnoringVisibility);
                Intrinsics.checkNotNullExpressionValue(min, "Insets.min(insetsCompat.\u2026sTypes), stableBarInsets)");
                int i16 = min.bottom;
                RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
                z16 = RFWNavigationBarImmersiveHelper.openBothSides;
                int i17 = 0;
                if (z16) {
                    i3 = min.right;
                } else {
                    i3 = 0;
                }
                z17 = RFWNavigationBarImmersiveHelper.openBothSides;
                if (z17) {
                    i17 = min.left;
                }
                rFWNavigationBarImmersiveHelper.onWindowInsetsChanged(window, i16, i17, i3);
                return windowInsetsCompat;
            }
        });
    }

    public final void adjustView(@Nullable View view, @NotNull ImmersiveType... type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (view != null) {
            INSTANCE.runAfterConfirmedTheWindow(view, new AdjustViewRunnable(new WeakReference(view), (ImmersiveType[]) Arrays.copyOf(type, type.length)));
        }
    }

    @JvmOverloads
    public final void adjustViewBothSidesPadding(@Nullable View view, int paddingLeftWithoutNavigationBarHeight, int paddingRightWithoutNavigationBarHeight) {
        if (view != null) {
            INSTANCE.runAfterConfirmedTheWindow(view, new PaddingBothSidesRunnable(new WeakReference(view), paddingLeftWithoutNavigationBarHeight, paddingRightWithoutNavigationBarHeight));
        }
    }

    @JvmOverloads
    public final void adjustViewHeight(@Nullable View view, int heightWithoutNavigationBarHeight) {
        if (view == null) {
            RFWLog.e("RFWNavigationImmersiveHelper", RFWLog.USR, "adjustViewHeight, view is null");
        } else {
            runAfterConfirmedTheWindow(view, new AdjustHeightRunnable(new WeakReference(view), heightWithoutNavigationBarHeight));
        }
    }

    @JvmOverloads
    public final void adjustViewMarginBottom(@Nullable View view, int marginBottomWithoutNavigationBarHeight) {
        if (view == null) {
            RFWLog.e("RFWNavigationImmersiveHelper", RFWLog.USR, "adjustViewMargin, view is null");
        } else {
            runAfterConfirmedTheWindow(view, new MarginRunnable(new WeakReference(view), marginBottomWithoutNavigationBarHeight));
        }
    }

    @JvmOverloads
    public final void adjustViewPaddingBottom(@Nullable View view, int paddingBottomWithoutNavigationBarHeight) {
        if (view != null) {
            INSTANCE.runAfterConfirmedTheWindow(view, new PaddingBottomRunnable(new WeakReference(view), paddingBottomWithoutNavigationBarHeight));
        }
    }

    @JvmOverloads
    public final void fillNavigationBarBackgroundView(@Nullable ViewGroup parentView, @Nullable Drawable drawable) {
        if (parentView != null && isOpenNavigationBarImmersive(parentView.getContext())) {
            for (int childCount = parentView.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = parentView.getChildAt(childCount);
                if (childAt instanceof RFWNavigationBarBackgroundView) {
                    ((RFWNavigationBarBackgroundView) childAt).setBackground(drawable);
                    return;
                }
            }
            Context context = parentView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
            RFWNavigationBarBackgroundView rFWNavigationBarBackgroundView = new RFWNavigationBarBackgroundView(context);
            if (drawable != null) {
                rFWNavigationBarBackgroundView.setBackground(drawable);
                rFWNavigationBarBackgroundView.setHasFixedDrawable(true);
            }
            if (parentView instanceof FrameLayout) {
                parentView.addView(rFWNavigationBarBackgroundView, new FrameLayout.LayoutParams(-1, 0, 80));
            } else if (parentView instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
                layoutParams.addRule(12);
                rFWNavigationBarBackgroundView.setLayoutParams(layoutParams);
                parentView.addView(rFWNavigationBarBackgroundView, layoutParams);
            } else if (parentView instanceof ConstraintLayout) {
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, 0);
                layoutParams2.bottomToBottom = 0;
                parentView.addView(rFWNavigationBarBackgroundView, layoutParams2);
            } else if (parentView instanceof LinearLayout) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
                layoutParams3.gravity = 80;
                rFWNavigationBarBackgroundView.setLayoutParams(layoutParams3);
                parentView.addView(rFWNavigationBarBackgroundView, layoutParams3);
            } else {
                RFWLog.e("RFWNavigationImmersiveHelper", RFWLog.USR, "fillNavigationBarBackgroundView fail, parentView:" + parentView);
            }
            adjustViewHeight$default(this, rFWNavigationBarBackgroundView, 0, 2, null);
        }
    }

    public final int getCurrentNavigationBarHeight(@Nullable Context context) {
        Activity realContext = getRealContext(context);
        if (realContext == null) {
            return 0;
        }
        HashMap<String, WindowNavigationBarInfo> hashMap = windowHashMap;
        Window window = realContext.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "context.window");
        WindowNavigationBarInfo windowNavigationBarInfo = hashMap.get(getKey(window));
        if (windowNavigationBarInfo == null) {
            return 0;
        }
        return windowNavigationBarInfo.getNaviBarHeight();
    }

    @Nullable
    public final Activity getRealContext(@Nullable Context context) {
        while (true) {
            boolean z16 = context instanceof Activity;
            if (z16 || ((context instanceof ContextThemeWrapper) && useThemeWrapper)) {
                if (z16) {
                    Activity activity = (Activity) context;
                    if (activity.getParent() instanceof Activity) {
                        context = activity.getParent();
                    } else {
                        return activity;
                    }
                } else if (context instanceof ContextThemeWrapper) {
                    ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context;
                    if (contextThemeWrapper.getBaseContext() instanceof Activity) {
                        Context baseContext = contextThemeWrapper.getBaseContext();
                        if (baseContext != null) {
                            return (Activity) baseContext;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    @Nullable
    public final WindowNavigationBarInfo getWindowInfo(@NotNull View view) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        Activity activityForView = getActivityForView(view);
        if (activityForView != null && (window = activityForView.getWindow()) != null) {
            return windowHashMap.get(INSTANCE.getKey(window));
        }
        return null;
    }

    public final boolean hadSetNavigationBarImmersive(@Nullable Window window) {
        return window != null && windowHashMap.containsKey(getKey(window));
    }

    public final void registerNavigationBarCallBack(@Nullable final Context context, @Nullable final LifecycleOwner lifecycle, @Nullable final NavigationBarHeightChangeCallback callback) {
        final Activity realContext = getRealContext(context);
        if (!needAdJust(realContext)) {
            if (callback != null) {
                callback.onChange(0, 0, 0);
            }
        } else {
            Intrinsics.checkNotNull(realContext);
            Window window = realContext.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "realContext!!.window");
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "realContext!!.window.decorView");
            runAfterConfirmedTheWindow(decorView, new Runnable() { // from class: com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper$registerNavigationBarCallBack$1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle lifecycle2;
                    RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback navigationBarHeightChangeCallback;
                    HashMap hashMap;
                    String key;
                    WindowNavigationBarInfo navigationBarWindowInfo;
                    int i3;
                    int i16;
                    LifecycleOwner lifecycleOwner = LifecycleOwner.this;
                    if (lifecycleOwner != null && (lifecycle2 = lifecycleOwner.getLifecycle()) != null && (navigationBarHeightChangeCallback = callback) != null) {
                        RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
                        hashMap = RFWNavigationBarImmersiveHelper.windowHashMap;
                        Window window2 = realContext.getWindow();
                        Intrinsics.checkNotNullExpressionValue(window2, "realContext.window");
                        key = rFWNavigationBarImmersiveHelper.getKey(window2);
                        WindowNavigationBarInfo windowNavigationBarInfo = (WindowNavigationBarInfo) hashMap.get(key);
                        if (windowNavigationBarInfo != null) {
                            navigationBarWindowInfo = rFWNavigationBarImmersiveHelper.getNavigationBarWindowInfo(context);
                            RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback navigationBarHeightChangeCallback2 = callback;
                            int i17 = 0;
                            if (navigationBarWindowInfo != null) {
                                i3 = navigationBarWindowInfo.getNaviBarHeight();
                            } else {
                                i3 = 0;
                            }
                            if (navigationBarWindowInfo != null) {
                                i16 = navigationBarWindowInfo.getNaviBarLeft();
                            } else {
                                i16 = 0;
                            }
                            if (navigationBarWindowInfo != null) {
                                i17 = navigationBarWindowInfo.getNaviBarRight();
                            }
                            navigationBarHeightChangeCallback2.onChange(i3, i16, i17);
                            if (!windowNavigationBarInfo.getNavigationBarHeightCallback().contains(callback)) {
                                windowNavigationBarInfo.getNavigationBarHeightCallback().add(callback);
                                Intrinsics.checkNotNullExpressionValue(lifecycle2, "lifecycle");
                                lifecycle2.addObserver(new RFWNavigationBarImmersiveHelper.InnerLifecycleObserver(lifecycle2, navigationBarHeightChangeCallback));
                            }
                        }
                    }
                }
            });
        }
    }

    public final void setNaviBarImmersiveDelegate(@NotNull NavigationBarImmersiveDelegate delegate2) {
        Intrinsics.checkNotNullParameter(delegate2, "delegate");
        delegate = delegate2;
    }

    public final void setNavigationBarImmersive(@Nullable Window window) {
        if (window != null && isOpenNavigationBarImmersive(window.getContext())) {
            HashMap<String, WindowNavigationBarInfo> hashMap = windowHashMap;
            if (!hashMap.containsKey(getKey(window))) {
                RFWLog.d("RFWNavigationImmersiveHelper", RFWLog.USR, "setNavigationBarImmersive, window:", window);
                hashMap.put(getKey(window), new WindowNavigationBarInfo());
                if (useSystemMethod) {
                    useSystemMethodGetInsets(window);
                } else {
                    useOldMethodGetInsets(window);
                }
                innerSetNavigationBarImmersive(window);
            }
        }
    }

    public final void tryRequestFitSystemWindows(@Nullable View view) {
        if (view != null && hadSetNavigationBarImmersive(getActivityForView(view))) {
            view.requestFitSystemWindows();
        }
    }

    public final void unregisterNavigationBarHeightCallBack(@NotNull NavigationBarHeightChangeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        RFWLog.d("RFWNavigationImmersiveHelper", RFWLog.CLR, "unregisterNavigationBarHeightCallBack: ", Integer.valueOf(callback.hashCode()));
        Collection<WindowNavigationBarInfo> values = windowHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "windowHashMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((WindowNavigationBarInfo) it.next()).getNavigationBarHeightCallback().remove(callback);
        }
    }

    public final boolean hadSetNavigationBarImmersive(@Nullable Context context) {
        Activity realContext = getRealContext(context);
        return realContext != null && hadSetNavigationBarImmersive(realContext.getWindow());
    }
}
