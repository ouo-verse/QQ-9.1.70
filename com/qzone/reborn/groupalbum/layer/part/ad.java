package com.qzone.reborn.groupalbum.layer.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u001c\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00180)j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0018`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00105\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/ad;", "Lcom/qzone/reborn/groupalbum/layer/part/b;", "Lqj/l;", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "", "E9", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "data", "initIntentData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "action", "", "args", "handleBroadcastMessage", "", "D6", "onDoubleClick", "onDragClose", "", "isClickToExit", "onSingleClick", "onZoomScaleChangeEnd", "Lp9/b;", tl.h.F, "Lp9/b;", "getBuilder", "()Lp9/b;", "builder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "feedId", BdhLogUtil.LogTag.Tag_Conn, "groupId", "D", "Z", "isReadyToReportLayer", "E", "I", "mediaSum", UserInfo.SEX_FEMALE, "mediaPosition", "<init>", "(Lp9/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class ad extends b implements qj.l, ILayerOperationListener {

    /* renamed from: C, reason: from kotlin metadata */
    private String groupId;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isReadyToReportLayer;

    /* renamed from: E, reason: from kotlin metadata */
    private int mediaSum;

    /* renamed from: F, reason: from kotlin metadata */
    private int mediaPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final p9.b builder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Object> pageParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String feedId;

    public ad(p9.b builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.pageParams = new HashMap<>();
        this.feedId = "";
        this.groupId = "";
    }

    private final int D9() {
        GroupAlbumLayerExtraInfoBean x95 = x9();
        return (x95 == null || !x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) ? 0 : 1;
    }

    private final int E9() {
        GroupAlbumLayerExtraInfoBean x95 = x9();
        return !Intrinsics.areEqual(String.valueOf(x95 != null ? x95.getUploadUid() : null), LoginData.getInstance().getUinString()) ? 1 : 0;
    }

    @Override // qj.l
    public Map<String, Object> D6() {
        String str;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        this.pageParams.clear();
        this.pageParams.put("feedid", this.feedId);
        HashMap<String, Object> hashMap = this.pageParams;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null || (str = currentPicInfo.getUrl()) == null) {
            str = "";
        }
        hashMap.put("pic_url", str);
        HashMap<String, Object> hashMap2 = this.pageParams;
        GroupAlbumLayerExtraInfoBean x95 = x9();
        hashMap2.put("framer_uin", String.valueOf(x95 != null ? x95.getUploadUid() : null));
        this.pageParams.put("open_visit_state", Integer.valueOf(E9()));
        this.pageParams.put("group_uin", this.groupId);
        HashMap<String, Object> hashMap3 = this.pageParams;
        GroupAlbumLayerExtraInfoBean x96 = x9();
        hashMap3.put("albumid", String.valueOf(x96 != null ? x96.getAlbumId() : null));
        this.pageParams.put("floating_layer_type", Integer.valueOf(D9()));
        return this.pageParams;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "COMMON_ALBUM_LAYER_READY_REPORT")) {
            this.isReadyToReportLayer = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        if (data != null) {
            if (data.containsKey("key_feed_id")) {
                Object obj = data.get("key_feed_id");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.feedId = (String) obj;
            }
            if (data.containsKey(MiniAppTranRoomIdServlet.KEY_GROUP_ID)) {
                Object obj2 = data.get(MiniAppTranRoomIdServlet.KEY_GROUP_ID);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                this.groupId = (String) obj2;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Context context = rootView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        VideoReport.addToDetectionWhitelist((Activity) context);
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_NONE);
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
