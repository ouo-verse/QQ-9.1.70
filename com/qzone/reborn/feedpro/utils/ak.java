package com.qzone.reborn.feedpro.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellShare;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u001a\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u001a5\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\r\"\u00020\u0006\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a$\u0010\u0013\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u001a$\u0010\u0015\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0014\u001a\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u001a\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u001a\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", "coverIv", "", "l", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "titleTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "blogContent", "k", "Landroid/content/Context;", "context", "", "richTextViews", "c", "(Landroid/content/Context;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;[Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;)V", "Landroid/view/View;", "root", "e", "Landroid/widget/ImageView;", tl.h.F, "j", "contentTv", "g", "Landroid/widget/TextView;", "extraTv", "i", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ak {
    public static final void c(final Context context, final CommonFeed commonFeed, QZoneRichTextView... richTextViews) {
        Intrinsics.checkNotNullParameter(richTextViews, "richTextViews");
        if (context == null || commonFeed == null) {
            return;
        }
        for (QZoneRichTextView qZoneRichTextView : richTextViews) {
            qZoneRichTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.utils.ai
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ak.d(CommonFeed.this, context, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if ((r2.length() == 0) == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(CommonFeed commonFeed, Context context, View view) {
        CommonCellShare cellShare = commonFeed.getCellShare();
        String actionUrl = cellShare != null ? cellShare.getActionUrl() : null;
        boolean z16 = true;
        QLog.i("shareAction", 1, "cell share action url is " + actionUrl);
        if (actionUrl != null) {
        }
        z16 = false;
        if (z16) {
            return;
        }
        ho.i.q(context, actionUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if ((r2.length() == 0) == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void f(CommonFeed commonFeed, Context context, View view) {
        CommonCellShare cellShare = commonFeed.getCellShare();
        String actionUrl = cellShare != null ? cellShare.getActionUrl() : null;
        boolean z16 = true;
        QLog.i("shareAction", 1, "cell share action url is " + actionUrl);
        if (actionUrl != null) {
        }
        z16 = false;
        if (z16) {
            return;
        }
        ho.i.q(context, actionUrl);
    }

    public static final void j(CommonFeed commonFeed, QZoneRichTextView qZoneRichTextView) {
        if (qZoneRichTextView == null) {
            return;
        }
        if (CommonFeedDataUtilKt.getFeedShareTitle(commonFeed).length() == 0) {
            qZoneRichTextView.setVisibility(8);
            return;
        }
        qZoneRichTextView.setTextBold(true);
        qZoneRichTextView.setVisibility(0);
        qZoneRichTextView.setMaxLine(1);
        qZoneRichTextView.setRichText(CommonFeedDataUtilKt.getFeedShareTitle(commonFeed));
    }

    public static final void m(CommonFeed commonFeed, QZoneRichTextView qZoneRichTextView) {
        if (qZoneRichTextView == null) {
            return;
        }
        if (CommonFeedDataUtilKt.getFeedShareTitle(commonFeed).length() == 0) {
            qZoneRichTextView.setVisibility(8);
        } else {
            qZoneRichTextView.setVisibility(0);
            qZoneRichTextView.setRichText(CommonFeedDataUtilKt.getFeedShareTitle(commonFeed));
        }
    }

    public static final void g(CommonFeed commonFeed, QZoneRichTextView qZoneRichTextView) {
        if (commonFeed == null || qZoneRichTextView == null) {
            return;
        }
        String feedShareSummary = CommonFeedDataUtilKt.getFeedShareSummary(commonFeed);
        if (feedShareSummary.length() == 0) {
            qZoneRichTextView.setVisibility(8);
            return;
        }
        qZoneRichTextView.setMaxLine(2);
        qZoneRichTextView.setRichText(feedShareSummary);
        qZoneRichTextView.setVisibility(0);
    }

    public static final void i(CommonFeed commonFeed, TextView textView) {
        if (commonFeed == null || textView == null) {
            return;
        }
        CommonCellShare cellShare = commonFeed.getCellShare();
        String additionalInfo = cellShare != null ? cellShare.getAdditionalInfo() : null;
        if (additionalInfo == null || additionalInfo.length() == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setMaxLines(1);
        textView.setText(additionalInfo);
        textView.setVisibility(0);
    }

    public static final void k(CommonFeed commonFeed, QZoneRichTextView qZoneRichTextView) {
        CharSequence trim;
        if (commonFeed == null || qZoneRichTextView == null) {
            return;
        }
        String feedShareSummary = CommonFeedDataUtilKt.getFeedShareSummary(commonFeed);
        trim = StringsKt__StringsKt.trim((CharSequence) feedShareSummary);
        if (trim.toString().length() == 0) {
            qZoneRichTextView.setVisibility(8);
            return;
        }
        QLog.i("QzoneFeedProShareExt", 2, "content is " + feedShareSummary + ", title is " + CommonFeedDataUtilKt.getFeedShareTitle(commonFeed));
        qZoneRichTextView.setRichText(feedShareSummary);
        qZoneRichTextView.setVisibility(0);
    }

    public static final void h(Context context, CommonFeed commonFeed, ImageView imageView) {
        List<CommonMedia> medias;
        CommonMedia commonMedia;
        if (commonFeed == null || imageView == null) {
            return;
        }
        CommonCellShare cellShare = commonFeed.getCellShare();
        CommonImage commonImage = null;
        if (ArrayUtils.isOutOfArrayIndex(0, cellShare != null ? cellShare.getMedias() : null)) {
            imageView.setVisibility(8);
            return;
        }
        CommonCellShare cellShare2 = commonFeed.getCellShare();
        if (cellShare2 != null && (medias = cellShare2.getMedias()) != null && (commonMedia = medias.get(0)) != null) {
            commonImage = commonMedia.getImage();
        }
        String i3 = xd.c.i(commonImage);
        if (i3.length() == 0) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        int k3 = pl.a.f426446a.k(context);
        int i16 = (int) (k3 * 0.5625f);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = k3;
        layoutParams.height = i16;
        imageView.setLayoutParams(layoutParams);
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(i3).setTargetView(imageView).setRequestWidth(k3).setRequestHeight(i16));
    }

    public static final void l(CommonFeed commonFeed, RFWSquareImageView rFWSquareImageView) {
        CommonCellShare cellShare;
        List<CommonMedia> medias;
        CommonMedia commonMedia;
        CommonCellShare cellShare2;
        if (rFWSquareImageView == null) {
            return;
        }
        CommonImage commonImage = null;
        if (ArrayUtils.isOutOfArrayIndex(0, (commonFeed == null || (cellShare2 = commonFeed.getCellShare()) == null) ? null : cellShare2.getMedias())) {
            rFWSquareImageView.setVisibility(4);
            return;
        }
        if (commonFeed != null && (cellShare = commonFeed.getCellShare()) != null && (medias = cellShare.getMedias()) != null && (commonMedia = medias.get(0)) != null) {
            commonImage = commonMedia.getImage();
        }
        String i3 = xd.c.i(commonImage);
        if (i3.length() == 0) {
            rFWSquareImageView.setVisibility(4);
        } else {
            rFWSquareImageView.setVisibility(0);
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(i3).setTargetView(rFWSquareImageView).setRequestWidth(ef.d.b(68)).setRequestHeight(ef.d.b(68)));
        }
    }

    public static final void e(final Context context, final CommonFeed commonFeed, View view) {
        if (context == null || commonFeed == null || view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.utils.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ak.f(CommonFeed.this, context, view2);
            }
        });
    }
}
