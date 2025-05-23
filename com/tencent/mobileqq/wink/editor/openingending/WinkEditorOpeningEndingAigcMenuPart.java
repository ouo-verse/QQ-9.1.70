package com.tencent.mobileqq.wink.editor.openingending;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.aigc.utils.WinkAIGCService;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcMenuPart;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.ai;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tav.core.AssetExtension;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J$\u0010\u0015\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0014J$\u0010\u0016\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0014J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0014J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010 \u001a\u00020\u0002R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010#R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?R\u001a\u0010D\u001a\u00020!8\u0014X\u0094D\u00a2\u0006\f\n\u0004\bA\u0010#\u001a\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "initData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ja", "Ka", "", "B9", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "Landroid/os/Bundle;", "args", "L9", "onInitView", "initAfterInflation", "Lkotlin/Function0;", "onStartAction", "onEndAction", "ua", "ta", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "bottomOffset", "topOffset", "ra", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Ia", "", "M", "Z", "isFirstShow", "Landroidx/recyclerview/widget/RecyclerView;", "N", "Landroidx/recyclerview/widget/RecyclerView;", "styleRecyclerView", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "P", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "aigcData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "itemWidth", "Lcom/tencent/mobileqq/wink/view/ai;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/view/ai;", "loadingDialog", ExifInterface.LATITUDE_SOUTH, "firstShow", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "T", "Lkotlin/Lazy;", "Ha", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "viewModel", "Lcom/tencent/mobileqq/wink/aigc/utils/WinkAIGCService;", "U", "Ga", "()Lcom/tencent/mobileqq/wink/aigc/utils/WinkAIGCService;", "aigcService", "V", "X9", "()Z", "autoAnimate", "<init>", "()V", "StyleListAdapter", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingAigcMenuPart extends WinkEditorMenuPart {

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private RecyclerView styleRecyclerView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private OpeningEndingAigcData aigcData;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.view.ai loadingDialog;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy aigcService;

    /* renamed from: V, reason: from kotlin metadata */
    private final boolean autoAnimate;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFirstShow = true;

    /* renamed from: Q, reason: from kotlin metadata */
    private int itemWidth = -1;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean firstShow = true;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\f2\u000e\u0010\n\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart$StyleListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart$StyleListAdapter$StyleViewHolder;", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "<init>", "(Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart;)V", "StyleViewHolder", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class StyleListAdapter extends RecyclerView.Adapter<StyleViewHolder> {

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J0\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart$StyleListAdapter$StyleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "", "y", "", "imagePath", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "styleMaterial", "imageUrl", "safeId", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "v", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "costTimeMs", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", AssetExtension.SCENE_THUMBNAIL, UserInfo.SEX_FEMALE, "selectedBorder", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "styleName", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart$StyleListAdapter;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public final class StyleViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            @NotNull
            private final ImageView thumbnail;

            /* renamed from: F, reason: from kotlin metadata */
            @NotNull
            private final ImageView selectedBorder;

            /* renamed from: G, reason: from kotlin metadata */
            @NotNull
            private final TextView styleName;
            final /* synthetic */ StyleListAdapter H;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StyleViewHolder(@NotNull StyleListAdapter styleListAdapter, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.H = styleListAdapter;
                View findViewById = itemView.findViewById(R.id.f97065jd);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.thumbnailImageView)");
                this.thumbnail = (ImageView) findViewById;
                View findViewById2 = itemView.findViewById(R.id.f82514h3);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.selectedBorder)");
                this.selectedBorder = (ImageView) findViewById2;
                View findViewById3 = itemView.findViewById(R.id.s6e);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.StyleNameTextView)");
                this.styleName = (TextView) findViewById3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void A(final View view, final String materialId, final long costTimeMs) {
                if (costTimeMs <= 0) {
                    return;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder.B(view, materialId, costTimeMs);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void B(View view, String materialId, long j3) {
                Intrinsics.checkNotNullParameter(view, "$view");
                Intrinsics.checkNotNullParameter(materialId, "$materialId");
                VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_AIGC_STYLE_ITEM);
                Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
                Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
                reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STYLE_ID, materialId);
                reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AIGC_TEMPLATE_CREATE_DURATION, Long.valueOf(j3));
                reportMap.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_AIGC_STYLE_ITEM);
                reportMap.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_OPENING_ENDING_EDIT_PAGE);
                VideoReport.reportEvent("ev_xsj_abnormal_clck", view, reportMap);
                VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            }

            private final void C() {
                String str;
                WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart = WinkEditorOpeningEndingAigcMenuPart.this;
                ai.b bVar = new ai.b(winkEditorOpeningEndingAigcMenuPart.getContext());
                Context context = WinkEditorOpeningEndingAigcMenuPart.this.getContext();
                if (context == null || (str = context.getString(R.string.f239577mu)) == null) {
                    str = "";
                }
                ai.b f16 = bVar.i(str).h(false).b(false).f(WinkEditorOpeningEndingAigcMenuPart.this.styleRecyclerView);
                final WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart2 = WinkEditorOpeningEndingAigcMenuPart.this;
                ai.b e16 = f16.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder.D(WinkEditorOpeningEndingAigcMenuPart.this, this);
                    }
                });
                final WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart3 = WinkEditorOpeningEndingAigcMenuPart.this;
                winkEditorOpeningEndingAigcMenuPart.loadingDialog = e16.d(new Callable() { // from class: com.tencent.mobileqq.wink.editor.openingending.z
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Boolean E;
                        E = WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder.E(WinkEditorOpeningEndingAigcMenuPart.this, this);
                        return E;
                    }
                }).a();
                com.tencent.mobileqq.wink.view.ai aiVar = WinkEditorOpeningEndingAigcMenuPart.this.loadingDialog;
                if (aiVar != null) {
                    aiVar.show();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void D(WinkEditorOpeningEndingAigcMenuPart this$0, StyleViewHolder this$1) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                this$0.Ha().a2();
                this$1.v();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Boolean E(WinkEditorOpeningEndingAigcMenuPart this$0, StyleViewHolder this$1) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                this$0.Ha().a2();
                this$1.v();
                return Boolean.TRUE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void u(StyleViewHolder this$0, int i3, MetaMaterial material, View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(material, "$material");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.y(it, i3, material);
                EventCollector.getInstance().onViewClicked(it);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void v() {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart = WinkEditorOpeningEndingAigcMenuPart.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder.w(WinkEditorOpeningEndingAigcMenuPart.this);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void w(WinkEditorOpeningEndingAigcMenuPart this$0) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                com.tencent.mobileqq.wink.view.ai aiVar = this$0.loadingDialog;
                if (aiVar != null) {
                    aiVar.dismiss();
                }
                this$0.loadingDialog = null;
            }

            @SuppressLint({"NotifyDataSetChanged"})
            private final void x(MetaMaterial styleMaterial, String imageUrl, String safeId, int position, View view) {
                C();
                WinkEditorOpeningEndingViewModel Ha = WinkEditorOpeningEndingAigcMenuPart.this.Ha();
                String z06 = com.tencent.mobileqq.wink.editor.c.z0(styleMaterial);
                StyleListAdapter styleListAdapter = this.H;
                Ha.j2(z06, imageUrl, safeId, new WinkEditorOpeningEndingAigcMenuPart$StyleListAdapter$StyleViewHolder$generateNewImage$1(this, view, styleMaterial, WinkEditorOpeningEndingAigcMenuPart.this, styleListAdapter, position));
            }

            private final void y(View view, int position, MetaMaterial metaMaterial) {
                OpeningEndingAigcData openingEndingAigcData = WinkEditorOpeningEndingAigcMenuPart.this.aigcData;
                if (openingEndingAigcData != null) {
                    StyleListAdapter styleListAdapter = this.H;
                    WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart = WinkEditorOpeningEndingAigcMenuPart.this;
                    if (openingEndingAigcData.getCurrentStyleIndex() != position) {
                        String str = openingEndingAigcData.getAigcImagePathMap().get(com.tencent.mobileqq.wink.editor.c.z0(metaMaterial));
                        if (str != null) {
                            if (z(str)) {
                                OpeningEndingAigcData openingEndingAigcData2 = winkEditorOpeningEndingAigcMenuPart.aigcData;
                                if (openingEndingAigcData2 != null) {
                                    openingEndingAigcData2.setCurrentStyleIndex(position);
                                }
                                styleListAdapter.notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        x(metaMaterial, openingEndingAigcData.getImageUploadUrl(), openingEndingAigcData.getSafeId(), position, view);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:13:0x004c A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final boolean z(String imagePath) {
                long j3;
                long durationUs;
                MediaClip Z1;
                WinkVideoTavCut winkVideoTavCut;
                List mutableListOf;
                List<MediaClip> g06;
                Object first;
                ResourceModel resourceModel;
                dr H9 = WinkEditorOpeningEndingAigcMenuPart.this.H9();
                if (H9 != null && (g06 = H9.g0()) != null) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) g06);
                    MediaClip mediaClip = (MediaClip) first;
                    if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
                        durationUs = resourceModel.selectDuration;
                        j3 = durationUs;
                        Z1 = WinkEditorOpeningEndingViewModel.Z1(WinkEditorOpeningEndingAigcMenuPart.this.Ha(), imagePath, null, null, null, j3, null, 32, null);
                        if (Z1 != null) {
                            dr H92 = WinkEditorOpeningEndingAigcMenuPart.this.H9();
                            if (H92 instanceof WinkVideoTavCut) {
                                winkVideoTavCut = (WinkVideoTavCut) H92;
                            } else {
                                winkVideoTavCut = null;
                            }
                            WinkVideoTavCut winkVideoTavCut2 = winkVideoTavCut;
                            if (winkVideoTavCut2 != null) {
                                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Z1);
                                WinkVideoTavCut.t3(winkVideoTavCut2, mutableListOf, false, false, 6, null);
                            }
                            dr H93 = WinkEditorOpeningEndingAigcMenuPart.this.H9();
                            if (H93 != null) {
                                H93.seek(0L);
                            }
                            return true;
                        }
                        return false;
                    }
                }
                dr H94 = WinkEditorOpeningEndingAigcMenuPart.this.H9();
                if (H94 != null) {
                    durationUs = H94.getDurationUs();
                    j3 = durationUs;
                    Z1 = WinkEditorOpeningEndingViewModel.Z1(WinkEditorOpeningEndingAigcMenuPart.this.Ha(), imagePath, null, null, null, j3, null, 32, null);
                    if (Z1 != null) {
                    }
                } else {
                    j3 = 0;
                    Z1 = WinkEditorOpeningEndingViewModel.Z1(WinkEditorOpeningEndingAigcMenuPart.this.Ha(), imagePath, null, null, null, j3, null, 32, null);
                    if (Z1 != null) {
                    }
                }
            }

            public final void t(final int position) {
                ArrayList<MetaMaterial> styleMaterials;
                final MetaMaterial metaMaterial;
                boolean z16;
                OpeningEndingAigcData openingEndingAigcData = WinkEditorOpeningEndingAigcMenuPart.this.aigcData;
                if (openingEndingAigcData != null && (styleMaterials = openingEndingAigcData.getStyleMaterials()) != null && (metaMaterial = styleMaterials.get(position)) != null) {
                    int i3 = -1;
                    if (WinkEditorOpeningEndingAigcMenuPart.this.itemWidth != -1) {
                        this.itemView.getLayoutParams().width = WinkEditorOpeningEndingAigcMenuPart.this.itemWidth;
                    }
                    this.styleName.setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
                    ViewUtilsKt.j(this.thumbnail, metaMaterial.thumbUrl);
                    OpeningEndingAigcData openingEndingAigcData2 = WinkEditorOpeningEndingAigcMenuPart.this.aigcData;
                    if (openingEndingAigcData2 != null && openingEndingAigcData2.getCurrentStyleIndex() == position) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.selectedBorder.setVisibility(0);
                        TextView textView = this.styleName;
                        Context context = WinkEditorOpeningEndingAigcMenuPart.this.getContext();
                        if (context != null) {
                            i3 = context.getColor(R.color.bfp);
                        }
                        textView.setTextColor(i3);
                    } else {
                        this.selectedBorder.setVisibility(8);
                        TextView textView2 = this.styleName;
                        Context context2 = WinkEditorOpeningEndingAigcMenuPart.this.getContext();
                        if (context2 != null) {
                            i3 = context2.getColor(R.color.bfq);
                        }
                        textView2.setTextColor(i3);
                    }
                    this.thumbnail.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.w
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder.u(WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder.this, position, metaMaterial, view);
                        }
                    });
                    if (WinkEditorOpeningEndingAigcMenuPart.this.firstShow && position == 0) {
                        long longExtra = WinkEditorOpeningEndingAigcMenuPart.this.getActivity().getIntent().getLongExtra(QQWinkConstants.OPENING_ENDING_AIGC_GENERATE_COSTTIME, 0L);
                        ImageView imageView = this.thumbnail;
                        String str = metaMaterial.f30533id;
                        Intrinsics.checkNotNullExpressionValue(str, "material.id");
                        A(imageView, str, longExtra);
                        WinkEditorOpeningEndingAigcMenuPart.this.firstShow = false;
                    }
                }
            }
        }

        public StyleListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<MetaMaterial> styleMaterials;
            OpeningEndingAigcData openingEndingAigcData = WinkEditorOpeningEndingAigcMenuPart.this.aigcData;
            if (openingEndingAigcData != null && (styleMaterials = openingEndingAigcData.getStyleMaterials()) != null) {
                return styleMaterials.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull StyleViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.t(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public StyleViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168938he4, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new StyleViewHolder(this, itemView);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ArrayList<MetaMaterial> styleMaterials;
            RecyclerView.Adapter adapter;
            int i3;
            ViewTreeObserver viewTreeObserver;
            RecyclerView recyclerView = WinkEditorOpeningEndingAigcMenuPart.this.styleRecyclerView;
            if (recyclerView != null && (viewTreeObserver = recyclerView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            int dpToPx = ImmersiveUtils.dpToPx(72.0f);
            float dpToPx2 = ImmersiveUtils.dpToPx(16.0f);
            OpeningEndingAigcData openingEndingAigcData = WinkEditorOpeningEndingAigcMenuPart.this.aigcData;
            if (openingEndingAigcData != null && (styleMaterials = openingEndingAigcData.getStyleMaterials()) != null) {
                int size = styleMaterials.size();
                Intrinsics.checkNotNull(WinkEditorOpeningEndingAigcMenuPart.this.getPartRootView());
                float width = ((r3.getWidth() - (ImmersiveUtils.dpToPx(4.0f) * 2)) - (size * dpToPx)) / (size + 1);
                if (width >= dpToPx2) {
                    dpToPx2 = width;
                }
                int i16 = (int) dpToPx2;
                WinkEditorOpeningEndingAigcMenuPart.this.itemWidth = dpToPx + i16;
                RecyclerView recyclerView2 = WinkEditorOpeningEndingAigcMenuPart.this.styleRecyclerView;
                ViewGroup.MarginLayoutParams marginLayoutParams = null;
                if (recyclerView2 != null) {
                    ViewGroup.LayoutParams layoutParams = recyclerView2.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    }
                    if (marginLayoutParams == null) {
                        ViewGroup.LayoutParams layoutParams2 = recyclerView2.getLayoutParams();
                        int i17 = -2;
                        if (layoutParams2 != null) {
                            i3 = layoutParams2.width;
                        } else {
                            i3 = -2;
                        }
                        ViewGroup.LayoutParams layoutParams3 = recyclerView2.getLayoutParams();
                        if (layoutParams3 != null) {
                            i17 = layoutParams3.height;
                        }
                        marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i17);
                    }
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.leftMargin = (i16 / 2) + ImmersiveUtils.dpToPx(4.0f);
                }
                RecyclerView recyclerView3 = WinkEditorOpeningEndingAigcMenuPart.this.styleRecyclerView;
                if (recyclerView3 != null && (adapter = recyclerView3.getAdapter()) != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    public WinkEditorOpeningEndingAigcMenuPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorOpeningEndingViewModel>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcMenuPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorOpeningEndingViewModel invoke() {
                Activity activity = WinkEditorOpeningEndingAigcMenuPart.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                ViewModel viewModel = new ViewModelProvider((FragmentActivity) activity).get(WinkEditorOpeningEndingViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider((activ\u2026ingViewModel::class.java)");
                return (WinkEditorOpeningEndingViewModel) viewModel;
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIGCService>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcMenuPart$aigcService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkAIGCService invoke() {
                WinkAIGCService winkAIGCService = new WinkAIGCService();
                winkAIGCService.e();
                return winkAIGCService;
            }
        });
        this.aigcService = lazy2;
    }

    private final WinkAIGCService Ga() {
        return (WinkAIGCService) this.aigcService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditorOpeningEndingViewModel Ha() {
        return (WinkEditorOpeningEndingViewModel) this.viewModel.getValue();
    }

    private final void Ja(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f897750o);
        this.styleRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(new StyleListAdapter());
        }
        Ka();
    }

    private final void Ka() {
        ViewTreeObserver viewTreeObserver;
        RecyclerView recyclerView = this.styleRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.styleRecyclerView;
        if (recyclerView2 != null && (viewTreeObserver = recyclerView2.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new a());
        }
    }

    private final void initData() {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        OpeningEndingAigcData openingEndingAigcData = (OpeningEndingAigcData) getActivity().getIntent().getSerializableExtra(QQWinkConstants.OPENING_ENDING_AIGC_DATA);
        this.aigcData = openingEndingAigcData;
        if (openingEndingAigcData != null && (recyclerView = this.styleRecyclerView) != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zzb;
    }

    public final void Ia() {
        getActivity().getIntent().putExtra(QQWinkConstants.OPENING_ENDING_AIGC_DATA, this.aigcData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
        dr H9 = H9();
        if (H9 != null) {
            H9.play();
        }
        if (this.isFirstShow) {
            dr H92 = H9();
            if (H92 != null) {
                H92.j();
            }
            this.isFirstShow = false;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    /* renamed from: X9, reason: from getter */
    protected boolean getAutoAnimate() {
        return this.autoAnimate;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.OPENING_ENDING_AIGC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        Ja(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Ka();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initData();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        Ga().h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ta(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
        super.ta(onStartAction, onEndAction);
        onStartAction.invoke();
        onEndAction.invoke();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    protected void ua(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
        super.ta(onStartAction, onEndAction);
        onStartAction.invoke();
        onEndAction.invoke();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ra(int bottomOffset, int topOffset) {
    }
}
