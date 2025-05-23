package com.tencent.mobileqq.zplan.minixwconnected.report;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.zplan.minihome.MapMode;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ri3.MapModeInfo;
import ri3.c;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\"\u0010#J4\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007JH\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/report/ZPlanMiniHomeConnectReporter;", "", "Landroid/view/ViewGroup;", "page", "", "pageId", "event", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", h.F, "Landroid/view/View;", "view", "elementId", "params", "", "autoReport", IProfileProtocolConst.PARAM_IS_FRIEND, "e", "Landroidx/lifecycle/ViewModelStoreOwner;", "a", "Landroidx/lifecycle/ViewModelStoreOwner;", "d", "()Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Landroidx/lifecycle/ViewModelProvider$Factory;", "b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lri3/c;", "c", "Lkotlin/Lazy;", "()Lri3/c;", "mapModeInfoViewModel", "<init>", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMiniHomeConnectReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ViewModelStoreOwner owner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ViewModelProvider.Factory factory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy mapModeInfoViewModel;

    public ZPlanMiniHomeConnectReporter(ViewModelStoreOwner owner, ViewModelProvider.Factory factory) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.owner = owner;
        this.factory = factory;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter$mapModeInfoViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                ViewModelProvider.Factory factory2;
                ViewModelStoreOwner owner2 = ZPlanMiniHomeConnectReporter.this.getOwner();
                factory2 = ZPlanMiniHomeConnectReporter.this.factory;
                ViewModel viewModel = new ViewModelProvider(owner2, factory2).get(c.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner,\u2026tedViewModel::class.java)");
                return (c) viewModel;
            }
        });
        this.mapModeInfoViewModel = lazy;
    }

    private final c c() {
        return (c) this.mapModeInfoViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, View view, String elementId, boolean z16, String event, Map params) {
        Map mapOf;
        Map plus;
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(params, "$params");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_map_state", Integer.valueOf(i3)));
        VideoReport.setElementId(view, elementId);
        if (z16) {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        } else {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        }
        plus = MapsKt__MapsKt.plus(params, mapOf);
        VideoReport.reportEvent(event, view, plus);
    }

    /* renamed from: d, reason: from getter */
    public final ViewModelStoreOwner getOwner() {
        return this.owner;
    }

    public final void e(final View view, final String elementId, final String event, final Map<String, ? extends Object> params, final boolean autoReport, boolean isFriend) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        MapMode.Companion companion = MapMode.INSTANCE;
        MapModeInfo value = c().O1().getValue();
        final int b16 = companion.b(value != null ? value.getMode() : null, isFriend);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.minixwconnected.report.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanMiniHomeConnectReporter.g(b16, view, elementId, autoReport, event, params);
            }
        });
    }

    public final void h(ViewGroup page, String pageId, String event, Map<String, ? extends Object> pageParams) {
        Map mapOf;
        Map plus;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        VideoReport.setPageId(page, pageId);
        VideoReport.setPageParams(page, new PageParams(pageParams));
        VideoReport.setPageReportPolicy(page, PageReportPolicy.REPORT_NONE);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY));
        plus = MapsKt__MapsKt.plus(mapOf, pageParams);
        VideoReport.reportEvent(event, page, plus);
    }

    public static /* synthetic */ void f(ZPlanMiniHomeConnectReporter zPlanMiniHomeConnectReporter, View view, String str, String str2, Map map, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        Map map2 = map;
        if ((i3 & 16) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i3 & 32) != 0) {
            z17 = false;
        }
        zPlanMiniHomeConnectReporter.e(view, str, str2, map2, z18, z17);
    }
}
