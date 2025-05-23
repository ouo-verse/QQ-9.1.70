package com.tencent.qqguild.base.aio.helpers;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.b;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 +2\u00020\u0001:\u0001\u0003B5\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012$\b\u0002\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00140\u0012\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00140\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R&\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqguild/base/aio/helpers/a;", "Lcom/tencent/aio/main/businesshelper/h;", "", "a", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/String;", "pageId", "Lkotlin/Function1;", "Lcom/tencent/aio/data/AIOParam;", "", "", "e", "Lkotlin/jvm/functions/Function1;", "provideFunc", "Landroidx/fragment/app/Fragment;", "f", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/view/View;", h.F, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "i", "Lcom/tencent/aio/data/AIOParam;", "aioParam", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/main/businesshelper/b;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "D", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    private b param;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<AIOParam, Map<String, Object>> provideFunc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Fragment fragment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AIOParam aioParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, Object> reportParams;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull String pageId, @NotNull Function1<? super AIOParam, ? extends Map<String, Object>> provideFunc) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(provideFunc, "provideFunc");
        this.pageId = pageId;
        this.provideFunc = provideFunc;
    }

    private final void a() {
        b bVar = this.param;
        View view = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        View requireView = bVar.a().c().requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "param.aioContext.fragment.requireView()");
        this.rootView = requireView;
        b bVar2 = this.param;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar2 = null;
        }
        Fragment c16 = bVar2.a().c();
        Intrinsics.checkNotNullExpressionValue(c16, "param.aioContext.fragment");
        this.fragment = c16;
        b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar3 = null;
        }
        AIOParam g16 = bVar3.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        this.aioParam = g16;
        Function1<AIOParam, Map<String, Object>> function1 = this.provideFunc;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioParam");
            g16 = null;
        }
        this.reportParams = function1.invoke(g16);
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        Fragment fragment = this.fragment;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment = null;
        }
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        String str = this.pageId;
        AIOParam aIOParam = this.aioParam;
        if (aIOParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioParam");
            aIOParam = null;
        }
        String g17 = com.tencent.guild.aio.util.a.g(aIOParam);
        Map<String, Object> map = this.reportParams;
        Object parent = view2.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        }
        if (view != null) {
            view2 = view;
        }
        VideoReport.addToDetectionWhitelist(requireActivity);
        VideoReport.setPageId(view2, str);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(view2, g17, map);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 18;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "Guild.DtPageReportHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{1, 9};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        View view = null;
        if (state == 1) {
            a();
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            VideoReport.reportEvent("pgin", view2, this.reportParams);
        }
        if (state == 9) {
            View view3 = this.rootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            } else {
                view = view3;
            }
            VideoReport.reportEvent("pgout", view, this.reportParams);
        }
    }
}
