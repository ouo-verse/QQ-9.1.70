package com.tencent.mobileqq.matchfriend.reborn.media.square.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.media.gallery.part.a;
import com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.QQStrangerBigPicLayerTitlePart;
import com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.QQStrangerBigPicLayerToolBarPart;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.gallery.QQLayerFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/square/gallery/QQStrangerBigPicLayerFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "fromStatus", "", "ph", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "", "getPlayScene", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "", "D", "Z", "isFromFeedDetailPage", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerBigPicLayerFragment extends QQLayerFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFromFeedDetailPage;

    private final void ph(View rootView, String fromStatus) {
        Map mapOf;
        VideoReport.setPageId(rootView, "pg_kl_dynamic_pic_view");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(this.isFromFeedDetailPage ? 2 : 1)));
        VideoReport.setPageParams(getView(), new PageParams((Map<String, ?>) mapOf));
        VideoReport.reportEvent(fromStatus, rootView, mapOf);
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new a());
        arrayList.add(new QQStrangerBigPicLayerTitlePart());
        arrayList.add(new QQStrangerBigPicLayerToolBarPart());
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 167;
    }

    @Override // com.tencent.richframework.gallery.RFWLayerFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.rootView;
        if (view != null) {
            ph(view, "dt_pgout");
        }
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.rootView = view;
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) {
            return;
        }
        this.isFromFeedDetailPage = extras.getBoolean("qqstranger_is_from_detail_page", false);
        ph(view, "dt_pgin");
    }
}
