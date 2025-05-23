package com.tencent.mobileqq.guild.discovery.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.discovery.widget.GDiscoveryLoadingView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ao;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\"\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001e\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryStatusView;", "Landroid/widget/FrameLayout;", "", "errorTextWithValidNet", "d", UinConfigManager.KEY_ADS, "", "showRefreshBtn", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "b", "", "i", "isError", "g", "e", "f", "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryStatusView$a;", "onRefreshBtnClickListener", "setOnRefreshListener", "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryLoadingView;", "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryLoadingView;", "discoverLoadingView", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "scanningLightView", "Landroid/widget/FrameLayout;", "discoverExceptionViewContainer", tl.h.F, "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryStatusView$a;", "listener", "Z", "isUseTokenStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GDiscoveryStatusView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GDiscoveryLoadingView discoverLoadingView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ScanningLightView scanningLightView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout discoverExceptionViewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a listener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isUseTokenStyle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryStatusView$a;", "", "", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void onRefresh();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GDiscoveryStatusView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final QUIEmptyState b(String notice, boolean showRefreshBtn) {
        int i3;
        if (NetworkUtil.isNetSupport(null)) {
            i3 = 8;
        } else {
            i3 = 5;
        }
        QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(getContext()).setImageType(i3).setTitle(notice).setHalfScreenState(true).setBackgroundColorType(0);
        if (showRefreshBtn) {
            String string = getContext().getString(R.string.f143170lc);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ld_dicovery_mine_refresh)");
            backgroundColorType.setButton(string, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discovery.widget.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GDiscoveryStatusView.c(GDiscoveryStatusView.this, view);
                }
            });
        }
        QUIEmptyState build = backgroundColorType.build();
        build.onThemeChanged();
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GDiscoveryStatusView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.listener;
        if (aVar != null) {
            aVar.onRefresh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String d(String errorTextWithValidNet) {
        boolean z16;
        if (NetworkUtil.isNetSupport(null)) {
            if (errorTextWithValidNet.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String string = getResources().getString(R.string.f143160lb);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026_dicovery_mine_load_fail)");
                return string;
            }
            return errorTextWithValidNet;
        }
        String string2 = getContext().getString(R.string.f143160lb);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_dicovery_mine_load_fail)");
        return string2;
    }

    public static /* synthetic */ void h(GDiscoveryStatusView gDiscoveryStatusView, boolean z16, String str, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        gDiscoveryStatusView.g(z16, str, z17);
    }

    public final void e() {
        setVisibility(8);
        ScanningLightView scanningLightView = this.scanningLightView;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(8);
        }
        ScanningLightView scanningLightView2 = this.scanningLightView;
        if (scanningLightView2 != null) {
            scanningLightView2.setLayerType(0, null);
        }
        GDiscoveryLoadingView gDiscoveryLoadingView = this.discoverLoadingView;
        if (gDiscoveryLoadingView != null) {
            gDiscoveryLoadingView.b();
        }
        FrameLayout frameLayout = this.discoverExceptionViewContainer;
        if (frameLayout != null) {
            Intrinsics.checkNotNull(frameLayout);
            if (frameLayout.getChildCount() > 0) {
                FrameLayout frameLayout2 = this.discoverExceptionViewContainer;
                Intrinsics.checkNotNull(frameLayout2);
                frameLayout2.removeAllViews();
            }
        }
    }

    public final void f() {
        FrameLayout frameLayout = this.discoverExceptionViewContainer;
        if (frameLayout != null) {
            Intrinsics.checkNotNull(frameLayout);
            if (frameLayout.getChildCount() > 0) {
                FrameLayout frameLayout2 = this.discoverExceptionViewContainer;
                Intrinsics.checkNotNull(frameLayout2);
                View childAt = frameLayout2.getChildAt(0);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.tencent.biz.qui.quiemptystate.QUIEmptyState");
                ((QUIEmptyState) childAt).onThemeChanged();
            }
        }
    }

    public final void g(boolean isError, @NotNull String errorTextWithValidNet, boolean showRefreshBtn) {
        Intrinsics.checkNotNullParameter(errorTextWithValidNet, "errorTextWithValidNet");
        setVisibility(0);
        if (this.discoverExceptionViewContainer == null) {
            this.discoverExceptionViewContainer = (FrameLayout) findViewById(R.id.w5e);
        }
        if (isError) {
            QUIEmptyState b16 = b(d(errorTextWithValidNet), showRefreshBtn);
            FrameLayout frameLayout = this.discoverExceptionViewContainer;
            if (frameLayout != null) {
                Intrinsics.checkNotNull(frameLayout);
                if (frameLayout.getChildCount() > 0) {
                    FrameLayout frameLayout2 = this.discoverExceptionViewContainer;
                    Intrinsics.checkNotNull(frameLayout2);
                    frameLayout2.removeAllViews();
                }
            }
            FrameLayout frameLayout3 = this.discoverExceptionViewContainer;
            if (frameLayout3 != null) {
                frameLayout3.addView(b16);
            }
            GDiscoveryLoadingView gDiscoveryLoadingView = this.discoverLoadingView;
            if (gDiscoveryLoadingView != null) {
                gDiscoveryLoadingView.b();
            }
            ScanningLightView scanningLightView = this.scanningLightView;
            if (scanningLightView != null) {
                scanningLightView.setVisibility(8);
            }
            ScanningLightView scanningLightView2 = this.scanningLightView;
            if (scanningLightView2 != null) {
                scanningLightView2.setLayerType(0, null);
                return;
            }
            return;
        }
        FrameLayout frameLayout4 = this.discoverExceptionViewContainer;
        if (frameLayout4 != null) {
            Intrinsics.checkNotNull(frameLayout4);
            if (frameLayout4.getChildCount() > 0) {
                FrameLayout frameLayout5 = this.discoverExceptionViewContainer;
                Intrinsics.checkNotNull(frameLayout5);
                frameLayout5.removeAllViews();
            }
        }
        ScanningLightView scanningLightView3 = this.scanningLightView;
        if (scanningLightView3 != null) {
            if (this.isUseTokenStyle) {
                scanningLightView3.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
                scanningLightView3.setLightColorRes(R.color.qui_common_fill_light_secondary);
            }
            scanningLightView3.setVisibility(0);
            scanningLightView3.setLayerType(2, null);
        }
        GDiscoveryLoadingView gDiscoveryLoadingView2 = this.discoverLoadingView;
        if (gDiscoveryLoadingView2 != null) {
            gDiscoveryLoadingView2.d();
        }
        GDiscoveryLoadingView gDiscoveryLoadingView3 = this.discoverLoadingView;
        if (gDiscoveryLoadingView3 != null) {
            gDiscoveryLoadingView3.e();
        }
    }

    public final void i() {
        this.isUseTokenStyle = true;
        findViewById(R.id.if5).setBackground(null);
    }

    public final void setOnRefreshListener(@NotNull a onRefreshBtnClickListener) {
        Intrinsics.checkNotNullParameter(onRefreshBtnClickListener, "onRefreshBtnClickListener");
        this.listener = onRefreshBtnClickListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GDiscoveryStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GDiscoveryStatusView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GDiscoveryStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.isUseTokenStyle = true;
        ao.g(LayoutInflater.from(context), this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.Y1);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026ble.GDiscoveryStatusView)");
        int resourceId = obtainStyledAttributes.getResourceId(up1.a.Z1, 0);
        if (resourceId != 0) {
            ScanningLightView scanningLightView = (ScanningLightView) findViewById(R.id.wxn);
            scanningLightView.setImageResource(resourceId);
            this.scanningLightView = scanningLightView;
        } else {
            int i16 = up1.a.f439417a2;
            GDiscoveryLoadingView.GLightLoadingType gLightLoadingType = GDiscoveryLoadingView.GLightLoadingType.TYPE_DISCOVERY_MINE;
            GDiscoveryLoadingView.GLightLoadingType a16 = GDiscoveryLoadingView.GLightLoadingType.INSTANCE.a(obtainStyledAttributes.getResourceId(i16, gLightLoadingType.getLayoutResId()));
            gLightLoadingType = a16 != null ? a16 : gLightLoadingType;
            GDiscoveryLoadingView gDiscoveryLoadingView = (GDiscoveryLoadingView) findViewById(R.id.w4z);
            this.discoverLoadingView = gDiscoveryLoadingView;
            if (gLightLoadingType == GDiscoveryLoadingView.GLightLoadingType.TYPE_DISCOVERY_RECOMMEND_GUILD_GROUP_DETAIL) {
                if (gDiscoveryLoadingView != null) {
                    arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(gLightLoadingType);
                    gDiscoveryLoadingView.c(arrayListOf2);
                }
            } else if (gDiscoveryLoadingView != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(gLightLoadingType, gLightLoadingType, gLightLoadingType, gLightLoadingType);
                gDiscoveryLoadingView.c(arrayListOf);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
