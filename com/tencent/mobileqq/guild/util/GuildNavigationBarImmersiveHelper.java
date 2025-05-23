package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.util.Consumer;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.util.GuildNavigationBarImmersiveHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.compat.immersive.NavigationBarInfo;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.compat.immersive.WindowNavigationBarInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00049:;<B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J:\u0010\u0016\u001a\u00020\u00042\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0018H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0014\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0001H\u0002J<\u0010$\u001a\u00020\t2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0007H\u0002J<\u0010%\u001a\u00020\t2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0007H\u0002J<\u0010&\u001a\u00020\t2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0014\u0010'\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001c\u0010+\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010*\u001a\u00020\tH\u0007J\u001c\u0010-\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010,\u001a\u00020\tH\u0007J&\u00100\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\tH\u0007J\u001c\u00102\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u00101\u001a\u00020\tH\u0007J\u0010\u00103\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0017\u001a\u00020\u0014R0\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001f0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001f`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildNavigationBarImmersiveHelper;", "", "Landroid/view/Window;", "window", "", "K", "B", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "navigationBarHeight", "navigationBarLeft", "navigationBarRight", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "", "Lcom/tencent/richframework/compat/immersive/NavigationBarInfo;", "Lkotlin/collections/HashMap;", "map", "Landroidx/core/util/Consumer;", "Landroid/view/View;", "runnable", "H", "view", "Ljava/lang/Runnable;", "I", "Landroid/app/Activity;", "r", "w", "Landroid/content/Context;", "context", "Lcom/tencent/richframework/compat/immersive/WindowNavigationBarInfo;", HippyTKDListViewAdapter.X, SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "v", "forceUpdate", ReportConstant.COSTREPORT_PREFIX, "t", "u", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "J", "heightWithoutNavigationBarHeight", "k", "paddingBottomWithoutNavigationBarHeight", "o", "paddingLeftWithoutNavigationBarHeight", "paddingRightWithoutNavigationBarHeight", "i", "marginBottomWithoutNavigationBarHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "b", "Ljava/util/HashMap;", "windowHashMap", "<init>", "()V", "AdjustHeightRunnable", "MarginRunnable", "PaddingBothSidesRunnable", "PaddingBottomRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNavigationBarImmersiveHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildNavigationBarImmersiveHelper f235359a = new GuildNavigationBarImmersiveHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, WindowNavigationBarInfo> windowHashMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildNavigationBarImmersiveHelper$AdjustHeightRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "d", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "viewWeakReference", "", "e", "I", "getHeight", "()I", "height", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class AdjustHeightRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<View> viewWeakReference;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int height;

        public AdjustHeightRunnable(@NotNull WeakReference<View> viewWeakReference, int i3) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            this.viewWeakReference = viewWeakReference;
            this.height = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            GuildNavigationBarImmersiveHelper guildNavigationBarImmersiveHelper;
            WindowNavigationBarInfo z16;
            boolean z17;
            View view = this.viewWeakReference.get();
            if (view != null && (z16 = (guildNavigationBarImmersiveHelper = GuildNavigationBarImmersiveHelper.f235359a).z(view)) != null) {
                int i3 = this.height;
                if (i3 != Integer.MIN_VALUE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        i3 = layoutParams.height;
                    } else {
                        i3 = Integer.MIN_VALUE;
                    }
                }
                if (i3 >= 0) {
                    int s16 = guildNavigationBarImmersiveHelper.s(z16.getHeightHashMap(), view, z17);
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = i3 + s16;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildNavigationBarImmersiveHelper$MarginRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "d", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "viewWeakReference", "", "e", "I", "getMarginBottom", "()I", NodeProps.MARGIN_BOTTOM, "<init>", "(Ljava/lang/ref/WeakReference;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class MarginRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<View> viewWeakReference;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int marginBottom;

        public MarginRunnable(@NotNull WeakReference<View> viewWeakReference, int i3) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            this.viewWeakReference = viewWeakReference;
            this.marginBottom = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MarginRunnable this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.run();
        }

        @Override // java.lang.Runnable
        public void run() {
            GuildNavigationBarImmersiveHelper guildNavigationBarImmersiveHelper;
            WindowNavigationBarInfo z16;
            boolean z17;
            View view = this.viewWeakReference.get();
            if (view != null && (z16 = (guildNavigationBarImmersiveHelper = GuildNavigationBarImmersiveHelper.f235359a).z(view)) != null) {
                if (this.marginBottom != Integer.MIN_VALUE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                int s16 = guildNavigationBarImmersiveHelper.s(z16.getMarginHashMap(), view, z17);
                if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (z17) {
                        marginLayoutParams.bottomMargin = this.marginBottom + s16;
                    } else {
                        marginLayoutParams.bottomMargin += s16;
                    }
                    view.setLayoutParams(marginLayoutParams);
                    return;
                }
                if (view.getLayoutParams() == null && view.getParent() == null) {
                    view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.aj
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildNavigationBarImmersiveHelper.MarginRunnable.b(GuildNavigationBarImmersiveHelper.MarginRunnable.this);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B%\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildNavigationBarImmersiveHelper$PaddingBothSidesRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "d", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "viewWeakReference", "", "e", "I", "getPaddingLeft", "()I", NodeProps.PADDING_LEFT, "f", "getPaddingRight", NodeProps.PADDING_RIGHT, "<init>", "(Ljava/lang/ref/WeakReference;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class PaddingBothSidesRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<View> viewWeakReference;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int paddingLeft;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int paddingRight;

        public PaddingBothSidesRunnable(@NotNull WeakReference<View> viewWeakReference, int i3, int i16) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            this.viewWeakReference = viewWeakReference;
            this.paddingLeft = i3;
            this.paddingRight = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            GuildNavigationBarImmersiveHelper guildNavigationBarImmersiveHelper;
            WindowNavigationBarInfo z16;
            boolean z17;
            int paddingLeft;
            int paddingRight;
            View view = this.viewWeakReference.get();
            if (view != null && (z16 = (guildNavigationBarImmersiveHelper = GuildNavigationBarImmersiveHelper.f235359a).z(view)) != null) {
                boolean z18 = true;
                if (this.paddingLeft != Integer.MIN_VALUE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                int t16 = guildNavigationBarImmersiveHelper.t(z16.getLeftSidePaddingHashMap(), view, z17);
                if (this.paddingRight == Integer.MIN_VALUE) {
                    z18 = false;
                }
                int u16 = guildNavigationBarImmersiveHelper.u(z16.getRightSidePaddingHashMap(), view, z18);
                if (z17) {
                    paddingLeft = this.paddingLeft;
                } else {
                    paddingLeft = view.getPaddingLeft();
                }
                int i3 = paddingLeft + t16;
                if (z18) {
                    paddingRight = this.paddingRight;
                } else {
                    paddingRight = view.getPaddingRight();
                }
                view.setPadding(i3, view.getPaddingTop(), paddingRight + u16, view.getPaddingBottom());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildNavigationBarImmersiveHelper$PaddingBottomRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "d", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "viewWeakReference", "", "e", "I", "getPaddingBottom", "()I", NodeProps.PADDING_BOTTOM, "<init>", "(Ljava/lang/ref/WeakReference;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class PaddingBottomRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<View> viewWeakReference;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int paddingBottom;

        public PaddingBottomRunnable(@NotNull WeakReference<View> viewWeakReference, int i3) {
            Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
            this.viewWeakReference = viewWeakReference;
            this.paddingBottom = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            GuildNavigationBarImmersiveHelper guildNavigationBarImmersiveHelper;
            WindowNavigationBarInfo z16;
            boolean z17;
            View view = this.viewWeakReference.get();
            if (view != null && (z16 = (guildNavigationBarImmersiveHelper = GuildNavigationBarImmersiveHelper.f235359a).z(view)) != null) {
                if (this.paddingBottom != Integer.MIN_VALUE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                int s16 = guildNavigationBarImmersiveHelper.s(z16.getPaddingBottomHashMap(), view, z17);
                if (z17) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), this.paddingBottom + s16);
                } else {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom() + s16);
                }
            }
        }
    }

    GuildNavigationBarImmersiveHelper() {
    }

    private final boolean A(Window window) {
        if (window != null && windowHashMap.containsKey(v(window))) {
            return true;
        }
        return false;
    }

    private final void B(Window window) {
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

    private final void C(Window window, int navigationBarHeight, int navigationBarLeft, int navigationBarRight) {
        if (!A(window)) {
            return;
        }
        B(window);
        WindowNavigationBarInfo windowNavigationBarInfo = windowHashMap.get(v(window));
        if (windowNavigationBarInfo != null) {
            if (navigationBarHeight == windowNavigationBarInfo.getNaviBarHeight() && navigationBarRight == windowNavigationBarInfo.getNaviBarRight() && navigationBarLeft == windowNavigationBarInfo.getNaviBarLeft()) {
                return;
            }
            Logger.f235387a.d().d("GuildNavigationBarImmersiveHelper", 1, "onWindowInsetsChanged,current naviHeight: " + navigationBarHeight + ",navigationBarRight:" + navigationBarRight + ", navigationBarLeft:" + navigationBarLeft);
            if (navigationBarHeight != windowNavigationBarInfo.getNaviBarHeight()) {
                windowNavigationBarInfo.setNaviBarHeight(navigationBarHeight);
                H(windowNavigationBarInfo.getHeightHashMap(), new Consumer() { // from class: com.tencent.mobileqq.guild.util.af
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        GuildNavigationBarImmersiveHelper.D((View) obj);
                    }
                });
                H(windowNavigationBarInfo.getPaddingBottomHashMap(), new Consumer() { // from class: com.tencent.mobileqq.guild.util.ag
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        GuildNavigationBarImmersiveHelper.E((View) obj);
                    }
                });
                H(windowNavigationBarInfo.getMarginHashMap(), new Consumer() { // from class: com.tencent.mobileqq.guild.util.ah
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        GuildNavigationBarImmersiveHelper.F((View) obj);
                    }
                });
            }
            if (navigationBarRight != windowNavigationBarInfo.getNaviBarRight() || navigationBarLeft != windowNavigationBarInfo.getNaviBarLeft()) {
                windowNavigationBarInfo.setNaviBarRight(navigationBarRight);
                windowNavigationBarInfo.setNaviBarLeft(navigationBarLeft);
                HashMap<String, NavigationBarInfo> hashMap = new HashMap<>();
                hashMap.putAll(windowNavigationBarInfo.getLeftSidePaddingHashMap());
                hashMap.putAll(windowNavigationBarInfo.getRightSidePaddingHashMap());
                H(hashMap, new Consumer() { // from class: com.tencent.mobileqq.guild.util.ai
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        GuildNavigationBarImmersiveHelper.G((View) obj);
                    }
                });
            }
            Iterator<T> it = windowNavigationBarInfo.getNavigationBarHeightCallback().iterator();
            while (it.hasNext()) {
                ((RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback) it.next()).onChange(navigationBarHeight, navigationBarLeft, navigationBarRight);
            }
            Iterator<T> it5 = windowNavigationBarInfo.getRunnable().iterator();
            while (it5.hasNext()) {
                ((Runnable) it5.next()).run();
            }
            windowNavigationBarInfo.getRunnable().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(View view) {
        l(f235359a, view, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(View view) {
        p(f235359a, view, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(View view) {
        n(f235359a, view, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(View view) {
        j(f235359a, view, 0, 0, 6, null);
    }

    private final void H(HashMap<String, NavigationBarInfo> map, Consumer<View> runnable) {
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

    private final void I(View view, Runnable runnable) {
        Activity r16 = r(view);
        if (r16 != null) {
            HashMap<String, WindowNavigationBarInfo> hashMap = windowHashMap;
            Window window = r16.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            WindowNavigationBarInfo windowNavigationBarInfo = hashMap.get(v(window));
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

    private final void K(final Window window) {
        ViewCompat.setOnApplyWindowInsetsListener(window.getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.util.ae
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat L;
                L = GuildNavigationBarImmersiveHelper.L(window, view, windowInsetsCompat);
                return L;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat L(Window window, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(window, "$window");
        int systemBars = WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout();
        Insets insetsIgnoringVisibility = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "insetsCompat.getInsetsIg\u2026Compat.Type.systemBars())");
        Insets min = Insets.min(windowInsetsCompat.getInsets(systemBars), insetsIgnoringVisibility);
        Intrinsics.checkNotNullExpressionValue(min, "min(insetsCompat.getInse\u2026sTypes), stableBarInsets)");
        int i3 = min.bottom;
        int i16 = min.right;
        f235359a.C(window, i3, min.left, i16);
        return windowInsetsCompat;
    }

    public static /* synthetic */ void j(GuildNavigationBarImmersiveHelper guildNavigationBarImmersiveHelper, View view, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        if ((i17 & 4) != 0) {
            i16 = Integer.MIN_VALUE;
        }
        guildNavigationBarImmersiveHelper.i(view, i3, i16);
    }

    public static /* synthetic */ void l(GuildNavigationBarImmersiveHelper guildNavigationBarImmersiveHelper, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        guildNavigationBarImmersiveHelper.k(view, i3);
    }

    public static /* synthetic */ void n(GuildNavigationBarImmersiveHelper guildNavigationBarImmersiveHelper, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        guildNavigationBarImmersiveHelper.m(view, i3);
    }

    public static /* synthetic */ void p(GuildNavigationBarImmersiveHelper guildNavigationBarImmersiveHelper, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        guildNavigationBarImmersiveHelper.o(view, i3);
    }

    private final Activity q(View view) {
        Context context;
        ViewGroup viewGroup;
        View childAt;
        if (Intrinsics.areEqual(view.getClass().getName(), "com.android.internal.policy.DecorView")) {
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null || (childAt = viewGroup.getChildAt(0)) == null || (context = childAt.getContext()) == null) {
                context = view.getContext();
            }
        } else {
            context = view.getContext();
        }
        if (!(context instanceof Activity)) {
            return null;
        }
        return (Activity) context;
    }

    private final Activity r(View view) {
        Activity y16 = y(view.getContext());
        if (y16 == null) {
            View rootView = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
            return q(rootView);
        }
        return y16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s(HashMap<String, NavigationBarInfo> map, View view, boolean forceUpdate) {
        NavigationBarInfo navigationBarInfo = map.get(v(view));
        int w3 = w(view);
        map.put(v(view), new NavigationBarInfo(new WeakReference(view), w3));
        if (!forceUpdate && navigationBarInfo != null) {
            return w3 - navigationBarInfo.getHeight();
        }
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t(HashMap<String, NavigationBarInfo> map, View view, boolean forceUpdate) {
        int i3;
        NavigationBarInfo navigationBarInfo = map.get(v(view));
        WindowNavigationBarInfo z16 = z(view);
        if (z16 != null) {
            i3 = z16.getNaviBarLeft();
        } else {
            i3 = 0;
        }
        map.put(v(view), new NavigationBarInfo(new WeakReference(view), i3));
        if (!forceUpdate && navigationBarInfo != null) {
            return i3 - navigationBarInfo.getHeight();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int u(HashMap<String, NavigationBarInfo> map, View view, boolean forceUpdate) {
        int i3;
        NavigationBarInfo navigationBarInfo = map.get(v(view));
        WindowNavigationBarInfo z16 = z(view);
        if (z16 != null) {
            i3 = z16.getNaviBarRight();
        } else {
            i3 = 0;
        }
        map.put(v(view), new NavigationBarInfo(new WeakReference(view), i3));
        if (!forceUpdate && navigationBarInfo != null) {
            return i3 - navigationBarInfo.getHeight();
        }
        return i3;
    }

    private final String v(Object any) {
        return String.valueOf(any.hashCode());
    }

    private final int w(View view) {
        WindowNavigationBarInfo x16 = x(r(view));
        if (x16 != null) {
            return x16.getNaviBarHeight();
        }
        return 0;
    }

    private final WindowNavigationBarInfo x(Context context) {
        Activity y16 = y(context);
        if (y16 == null) {
            return null;
        }
        HashMap<String, WindowNavigationBarInfo> hashMap = windowHashMap;
        Window window = y16.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "realContext.window");
        return hashMap.get(v(window));
    }

    private final Activity y(Context context) {
        while (true) {
            boolean z16 = context instanceof Activity;
            if (z16 || (context instanceof ContextThemeWrapper)) {
                if (z16) {
                    Activity activity = (Activity) context;
                    if (activity.getParent() != null) {
                        context = activity.getParent();
                    } else {
                        return activity;
                    }
                } else if (context instanceof ContextThemeWrapper) {
                    ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context;
                    if (contextThemeWrapper.getBaseContext() instanceof Activity) {
                        Context baseContext = contextThemeWrapper.getBaseContext();
                        Intrinsics.checkNotNull(baseContext, "null cannot be cast to non-null type android.app.Activity");
                        return (Activity) baseContext;
                    }
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public final void J(@Nullable Window window) {
        if (window != null) {
            HashMap<String, WindowNavigationBarInfo> hashMap = windowHashMap;
            if (!hashMap.containsKey(v(window))) {
                RFWLog.d("GuildNavigationBarImmersiveHelper", RFWLog.USR, "setNavigationBarImmersive, window:", window);
                hashMap.put(v(window), new WindowNavigationBarInfo());
                K(window);
                B(window);
            }
        }
    }

    @JvmOverloads
    public final void i(@Nullable View view, int paddingLeftWithoutNavigationBarHeight, int paddingRightWithoutNavigationBarHeight) {
        if (view != null) {
            f235359a.I(view, new PaddingBothSidesRunnable(new WeakReference(view), paddingLeftWithoutNavigationBarHeight, paddingRightWithoutNavigationBarHeight));
        }
    }

    @JvmOverloads
    public final void k(@Nullable View view, int heightWithoutNavigationBarHeight) {
        if (view == null) {
            RFWLog.e("GuildNavigationBarImmersiveHelper", RFWLog.USR, "adjustViewHeight, view is null");
        } else {
            I(view, new AdjustHeightRunnable(new WeakReference(view), heightWithoutNavigationBarHeight));
        }
    }

    @JvmOverloads
    public final void m(@Nullable View view, int marginBottomWithoutNavigationBarHeight) {
        if (view == null) {
            RFWLog.e("GuildNavigationBarImmersiveHelper", RFWLog.USR, "adjustViewMargin, view is null");
        } else {
            I(view, new MarginRunnable(new WeakReference(view), marginBottomWithoutNavigationBarHeight));
        }
    }

    @JvmOverloads
    public final void o(@Nullable View view, int paddingBottomWithoutNavigationBarHeight) {
        if (view != null) {
            f235359a.I(view, new PaddingBottomRunnable(new WeakReference(view), paddingBottomWithoutNavigationBarHeight));
        }
    }

    @Nullable
    public final WindowNavigationBarInfo z(@NotNull View view) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        Activity r16 = r(view);
        if (r16 != null && (window = r16.getWindow()) != null) {
            return windowHashMap.get(f235359a.v(window));
        }
        return null;
    }
}
