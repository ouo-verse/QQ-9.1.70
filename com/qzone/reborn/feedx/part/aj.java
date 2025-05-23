package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xg.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016JJ\u0010\u0014\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JH\u0010\u001c\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/feedx/part/aj;", "Lcom/qzone/reborn/base/k;", "Lgf/i;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "forwardFeedData", "Lcom/qzone/proxy/feedcomponent/model/f;", "clickedPicture", "Landroid/widget/ImageView;", "coverImageView", "", "index", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isUseOriginalFeed", "N5", "Landroid/content/Context;", "context", "", "currentProgress", "feedPosition", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "videoView", "l2", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aj extends com.qzone.reborn.base.k implements gf.i {
    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, gf.i.class);
    }

    @Override // gf.i
    public void l2(BusinessFeedData feedData, BusinessFeedData forwardFeedData, ImageView coverImageView, Context context, long currentProgress, int feedPosition, QZoneVideoItemWidgetView videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        g.a aVar = new g.a();
        aVar.f447951a = coverImageView;
        aVar.f447952b = videoView;
        if (com.qzone.reborn.configx.g.f53821a.b().X()) {
            ho.i.l().B(feedData, context, 0, currentProgress, aVar, forwardFeedData);
        } else {
            xg.g.g(feedData, context, 0, currentProgress, aVar, forwardFeedData);
        }
        com.qzone.util.ap.f59791b.e(20, 16, feedPosition, feedData);
    }

    @Override // gf.i
    public void N5(BusinessFeedData feedData, BusinessFeedData forwardFeedData, com.qzone.proxy.feedcomponent.model.f clickedPicture, ImageView coverImageView, int index, Activity activity, boolean isUseOriginalFeed) {
        xg.f.j(activity, isUseOriginalFeed ? feedData : forwardFeedData, clickedPicture, coverImageView, forwardFeedData);
        if (feedData != null && feedData.isFriendPlayingRecomm()) {
            com.qzone.util.ap.f59791b.e(26, 1, index, feedData);
        } else {
            com.qzone.util.ap.f59791b.e(21, 1, index, feedData);
        }
    }
}
