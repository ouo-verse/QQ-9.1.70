package com.qzone.reborn.feedpro.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.util.ArrayUtils;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\t\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a,\u0010\n\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a,\u0010\f\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001aH\u0010\u0011\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006\u001a\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u001a\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0017"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "blogTitle", "", "position", "", "d", "c", "blogContent", "a", "forwardFeed", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView;", "blogPicView", "transCreatorKey", "b", "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", "coverIv", "e", "titleTv", "f", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/feedpro/utils/j$a", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QAdVrReportParams.ParamKey.MEDIA, "", "index", "Landroid/view/View;", "view", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements QzoneFeedProPicMixVideoView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonFeed f54336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonFeed f54337b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f54338c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f54339d;

        a(CommonFeed commonFeed, CommonFeed commonFeed2, Context context, int i3) {
            this.f54336a = commonFeed;
            this.f54337b = commonFeed2;
            this.f54338c = context;
            this.f54339d = i3;
        }

        @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView.b
        public void a(CommonMedia media, int index, View view) {
            ImageView imageView;
            ImageView mImageView;
            QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = view instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) view : null;
            if (qzoneFeedProMixBaseWidgetView == null || (mImageView = qzoneFeedProMixBaseWidgetView.getMImageView()) == null) {
                imageView = null;
            } else {
                mImageView.setTag(R.id.f100755tc, Integer.valueOf(this.f54339d));
                imageView = mImageView;
            }
            ie.b.f407555a.b(this.f54336a, this.f54337b, this.f54338c, imageView, index);
        }
    }

    public static final void f(CommonFeed commonFeed, QZoneRichTextView qZoneRichTextView) {
        if (qZoneRichTextView == null) {
            return;
        }
        if (CommonFeedDataUtilKt.getFeedTitle(commonFeed).length() == 0) {
            qZoneRichTextView.setVisibility(8);
        } else {
            qZoneRichTextView.setVisibility(0);
            qZoneRichTextView.setText(CommonFeedDataUtilKt.getFeedTitle(commonFeed));
        }
    }

    public static final void a(Context context, CommonFeed commonFeed, QZoneRichTextView qZoneRichTextView, int i3) {
        if (commonFeed == null || qZoneRichTextView == null) {
            return;
        }
        String feedContentSummary = CommonFeedDataUtilKt.getFeedContentSummary(commonFeed);
        if (feedContentSummary.length() == 0) {
            qZoneRichTextView.setVisibility(8);
        } else {
            qZoneRichTextView.setRichText(feedContentSummary);
            qZoneRichTextView.setVisibility(0);
        }
    }

    public static final void c(Context context, CommonFeed commonFeed, QZoneRichTextView qZoneRichTextView, int i3) {
        if (commonFeed == null || qZoneRichTextView == null) {
            return;
        }
        String feedTitle = CommonFeedDataUtilKt.getFeedTitle(commonFeed);
        if (feedTitle.length() == 0) {
            qZoneRichTextView.setVisibility(8);
        } else {
            qZoneRichTextView.setRichText(feedTitle);
            qZoneRichTextView.setVisibility(0);
        }
    }

    public static final void d(Context context, CommonFeed commonFeed, QZoneRichTextView qZoneRichTextView, int i3) {
        if (commonFeed == null || qZoneRichTextView == null) {
            return;
        }
        String str = xd.c.k(commonFeed) + CommonFeedDataUtilKt.getFeedTitle(commonFeed);
        if (str.length() == 0) {
            qZoneRichTextView.setVisibility(8);
        } else {
            qZoneRichTextView.setRichText(str);
            qZoneRichTextView.setVisibility(0);
        }
    }

    public static final void e(CommonFeed commonFeed, RFWSquareImageView rFWSquareImageView) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        CommonMedia commonMedia;
        CommonCellMedia cellMedia2;
        if (rFWSquareImageView == null) {
            return;
        }
        CommonImage commonImage = null;
        if (ArrayUtils.isOutOfArrayIndex(0, (commonFeed == null || (cellMedia2 = commonFeed.getCellMedia()) == null) ? null : cellMedia2.getMediaItems())) {
            rFWSquareImageView.setVisibility(8);
            return;
        }
        if (commonFeed != null && (cellMedia = commonFeed.getCellMedia()) != null && (mediaItems = cellMedia.getMediaItems()) != null && (commonMedia = mediaItems.get(0)) != null) {
            commonImage = commonMedia.getImage();
        }
        String i3 = xd.c.i(commonImage);
        if (i3.length() == 0) {
            rFWSquareImageView.setVisibility(8);
        } else {
            rFWSquareImageView.setVisibility(0);
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(i3).setTargetView(rFWSquareImageView).setRequestWidth(ef.d.b(68)).setRequestHeight(ef.d.b(68)));
        }
    }

    public static final void b(Context context, CommonFeed commonFeed, CommonFeed commonFeed2, QZoneRichTextView qZoneRichTextView, QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView, int i3, int i16) {
        CommonCellMedia cellMedia;
        if (qzoneFeedProPicMixVideoView == null || qZoneRichTextView == null) {
            return;
        }
        if (ArrayUtils.isOutOfArrayIndex(0, (commonFeed == null || (cellMedia = commonFeed.getCellMedia()) == null) ? null : cellMedia.getMediaItems())) {
            qZoneRichTextView.setMaxLine(6);
            qzoneFeedProPicMixVideoView.setVisibility(8);
        } else {
            qzoneFeedProPicMixVideoView.setVisibility(0);
            qzoneFeedProPicMixVideoView.setOnItemClickListener(new a(commonFeed, commonFeed2, context, i16));
            qZoneRichTextView.setMaxLine(6);
            qzoneFeedProPicMixVideoView.setData(commonFeed, i3);
        }
    }
}
