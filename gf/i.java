package gf;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JJ\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH&JH\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u0019"}, d2 = {"Lgf/i;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "forwardFeedData", "Lcom/qzone/proxy/feedcomponent/model/f;", "clickedPicture", "Landroid/widget/ImageView;", "coverImageView", "", "index", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isUseOriginalFeed", "", "N5", "Landroid/content/Context;", "context", "", "currentProgress", "feedPosition", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "videoView", "l2", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface i {
    void N5(BusinessFeedData feedData, BusinessFeedData forwardFeedData, com.qzone.proxy.feedcomponent.model.f clickedPicture, ImageView coverImageView, int index, Activity activity, boolean isUseOriginalFeed);

    void l2(BusinessFeedData feedData, BusinessFeedData forwardFeedData, ImageView coverImageView, Context context, long currentProgress, int feedPosition, QZoneVideoItemWidgetView videoView);
}
