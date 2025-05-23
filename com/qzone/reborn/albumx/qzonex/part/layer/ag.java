package com.qzone.reborn.albumx.qzonex.part.layer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
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
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u001c\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R0\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00160'j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0016`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100\u00a8\u00066"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/ag;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "Lqj/l;", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "", "E9", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "action", "", "args", "handleBroadcastMessage", "", "D6", "onDoubleClick", "onDragClose", "", "isClickToExit", "onSingleClick", "onZoomScaleChangeEnd", "Lp9/b;", tl.h.F, "Lp9/b;", "getBuilder", "()Lp9/b;", "builder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isReadyToReportLayer", BdhLogUtil.LogTag.Tag_Conn, "I", "mediaSum", "D", "mediaPosition", "<init>", "(Lp9/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class ag extends b implements qj.l, ILayerOperationListener {

    /* renamed from: C, reason: from kotlin metadata */
    private int mediaSum;

    /* renamed from: D, reason: from kotlin metadata */
    private int mediaPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final p9.b builder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Object> pageParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isReadyToReportLayer;

    public ag(p9.b builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.pageParams = new HashMap<>();
    }

    private final int D9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        return (x95 == null || !x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) ? 0 : 1;
    }

    private final int E9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        return !Intrinsics.areEqual(String.valueOf(x95 != null ? x95.getUploadUid() : null), LoginData.getInstance().getUinString()) ? 1 : 0;
    }

    @Override // qj.l
    public Map<String, Object> D6() {
        String str;
        this.pageParams.clear();
        HashMap<String, Object> hashMap = this.pageParams;
        QZAlbumxLayerExtraInfoBean x95 = x9();
        if (x95 == null || (str = x95.getAlbumId()) == null) {
            str = "";
        }
        hashMap.put("albumid", str);
        this.pageParams.put("open_visit_state", Integer.valueOf(E9()));
        HashMap<String, Object> hashMap2 = this.pageParams;
        QZAlbumxLayerExtraInfoBean x96 = x9();
        hashMap2.put("framer_uin", String.valueOf(x96 != null ? x96.getUploadUid() : null));
        this.pageParams.put("open_visit_state", Integer.valueOf(E9()));
        this.pageParams.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, 2);
        this.pageParams.put("floating_layer_type", Integer.valueOf(D9()));
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
        fj.q qVar = fj.q.f399468a;
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        qVar.b(hashMap, "em_qz_page_turning_floating", rootView);
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
