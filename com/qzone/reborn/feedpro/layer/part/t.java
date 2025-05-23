package com.qzone.reborn.feedpro.layer.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b8\u00109J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u001c\u0010\u0017\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100$j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010*\u00a8\u0006:"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/t;", "Lcom/qzone/reborn/feedpro/layer/part/c;", "Lqj/l;", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "", "", "", "D6", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "action", "args", "handleBroadcastMessage", "onDoubleClick", "onDragClose", "", "isClickToExit", "onSingleClick", "onZoomScaleChangeEnd", "Lge/f;", "i", "Lge/f;", "getBuilder", "()Lge/f;", "builder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, BdhLogUtil.LogTag.Tag_Conn, "Z", "isReadyToReportLayer", "", "D", "I", "mediaSum", "E", "mediaPosition", "Lke/d;", UserInfo.SEX_FEMALE, "Lke/d;", "viewModel", "G", "hasInitReport", "<init>", "(Lge/f;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class t extends c implements qj.l, ILayerOperationListener {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isReadyToReportLayer;

    /* renamed from: D, reason: from kotlin metadata */
    private int mediaSum;

    /* renamed from: E, reason: from kotlin metadata */
    private int mediaPosition;

    /* renamed from: F, reason: from kotlin metadata */
    private ke.d viewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasInitReport;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ge.f builder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Object> pageParams;

    public t(ge.f builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.pageParams = new HashMap<>();
    }

    @Override // qj.l
    public Map<String, Object> D6() {
        String str;
        CommonUnionID T1;
        String feedId;
        this.pageParams.clear();
        HashMap<String, Object> hashMap = this.pageParams;
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        String str2 = "";
        if (x95 == null || (str = x95.getAlbumId()) == null) {
            str = "";
        }
        hashMap.put("albumid", str);
        this.pageParams.put("open_visit_state", Integer.valueOf(F9()));
        HashMap<String, Object> hashMap2 = this.pageParams;
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        hashMap2.put("framer_uin", String.valueOf(x96 != null ? Long.valueOf(x96.getOwnerUin()) : null));
        this.pageParams.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, Integer.valueOf(this.builder.getBizId()));
        this.pageParams.put("floating_layer_type", Integer.valueOf(D9()));
        this.pageParams.put(QZoneDTLoginReporter.PAGE_STYLE, 1);
        HashMap<String, Object> hashMap3 = this.pageParams;
        ke.d dVar = this.viewModel;
        if (dVar != null && (T1 = dVar.T1()) != null && (feedId = T1.getFeedId()) != null) {
            str2 = feedId;
        }
        hashMap3.put("feedid", str2);
        return this.pageParams;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "COMMON_ALBUM_LAYER_READY_REPORT")) {
            this.isReadyToReportLayer = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.viewModel = (ke.d) getViewModel(ke.d.class);
        Context context = rootView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        VideoReport.addToDetectionWhitelist((Activity) context);
        if (!this.builder.getIsNeedToReportPgExposure()) {
            VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_NONE);
        }
        RFWLayerIOCUtil.registerLayerOperationListener(rootView, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        tk.j jVar = tk.j.f436437a;
        this.mediaSum = jVar.b(layerState);
        this.mediaPosition = jVar.a(layerState);
        if (this.hasInitReport) {
            return;
        }
        this.hasInitReport = true;
        fo.c.i(getPartRootView(), D6(), "pg_qz_dynamic_floating_layer");
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.i, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this, qj.l.class);
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        RFWLayerIOCUtil.registerLayerOperationListener(rootView, this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        VideoReport.setPageParams(getPartRootView(), new fo.a().d("QZoneBaseLayerFragment", D6()));
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onSingleClick(boolean isClickToExit) {
        HashMap hashMap = new HashMap();
        hashMap.put("pic_cnt", Integer.valueOf(this.mediaSum));
        hashMap.put("is_last_page", Integer.valueOf(this.mediaPosition == this.mediaSum ? 1 : 0));
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        je.b.b(hashMap, "em_qz_page_turning_floating", rootView);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onDoubleClick() {
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onDragClose() {
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onZoomScaleChangeEnd() {
    }
}
