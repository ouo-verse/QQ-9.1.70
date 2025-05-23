package com.qzone.reborn.feedpro.section;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import com.tencent.util.ArrayUtils;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u00013B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0014J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J \u0010 \u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010+R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010-R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/feedpro/section/g;", "Lne/a;", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "", "H", "Ljava/util/UUID;", "uuid", "", "i", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "commonMedia", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "G", "", ViewStickEventHelper.IS_SHOW, "K", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProMixBaseWidgetView;", "view", "L", "", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "id", "generateTransAnimBean", "picId", "updateOriginContainer", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "E", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "blogTitle", UserInfo.SEX_FEMALE, "blogContent", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView;", "blogPicView", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "mSelectedVideoItemView", "I", "mTransCreatorKey", "J", "mSelectedIndex", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends ne.a implements RFWTransitionHelper.TransAnimCreator {

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneRichTextView blogTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneRichTextView blogContent;

    /* renamed from: G, reason: from kotlin metadata */
    private QzoneFeedProPicMixVideoView blogPicView;

    /* renamed from: H, reason: from kotlin metadata */
    private QzoneFeedProVideoItemWidgetView mSelectedVideoItemView;

    /* renamed from: I, reason: from kotlin metadata */
    private int mTransCreatorKey;

    /* renamed from: J, reason: from kotlin metadata */
    private int mSelectedIndex;

    private final RFWTransAnimBean G(UUID uuid, int i3, CommonMedia commonMedia) {
        RecyclerView A0;
        ImageView mImageView;
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.blogPicView;
        if (qzoneFeedProPicMixVideoView == null || (A0 = qzoneFeedProPicMixVideoView.A0()) == null || A0.getChildCount() <= i3) {
            return null;
        }
        View childAt = A0.getChildAt(i3);
        QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = childAt instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) childAt : null;
        if (qzoneFeedProMixBaseWidgetView == null || (mImageView = qzoneFeedProMixBaseWidgetView.getMImageView()) == null) {
            return null;
        }
        return RFWLayerLaunchUtil.getTransAnimBean(uuid, mImageView, je.a.x(commonMedia, getMFeedData()), true);
    }

    private final void H() {
        ho.m f16 = ho.i.f();
        Intrinsics.checkNotNullExpressionValue(f16, "detailPro()");
        ho.m.c(f16, getActivity(), getMFeedData(), null, 0, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K(boolean isShow) {
        QzoneFeedProVideoItemWidgetView qzoneFeedProVideoItemWidgetView = this.mSelectedVideoItemView;
        if (qzoneFeedProVideoItemWidgetView != null) {
            qzoneFeedProVideoItemWidgetView.g1().setVisibility(isShow ? 0 : 4);
            qzoneFeedProVideoItemWidgetView.setPlayIconVisible(isShow);
        }
    }

    private final void L(QzoneFeedProMixBaseWidgetView view) {
        this.mSelectedVideoItemView = view instanceof QzoneFeedProVideoItemWidgetView ? (QzoneFeedProVideoItemWidgetView) view : null;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public RFWTransAnimBean generateTransAnimBean(UUID uuid, String id5) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        int lastIndex;
        int coerceAtMost;
        Object last;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData == null || (cellMedia = mFeedData.getCellMedia()) == null || (mediaItems = cellMedia.getMediaItems()) == null) {
            return null;
        }
        int i3 = 0;
        if (ArrayUtils.isOutOfArrayIndex(0, mediaItems)) {
            return null;
        }
        for (Object obj : mediaItems) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CommonMedia commonMedia = (CommonMedia) obj;
            if (TextUtils.equals(je.a.C(commonMedia), id5)) {
                this.mSelectedIndex = i3;
                QLog.i("QzoneFeedProBlogSection", 1, " generateTransAnimBean data index:" + i3);
                return G(uuid, i3, commonMedia);
            }
            i3 = i16;
        }
        int i17 = this.mSelectedIndex;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(mediaItems);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i17, lastIndex);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) mediaItems);
        return G(uuid, coerceAtMost, (CommonMedia) last);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProBlogSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.nny;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(UUID uuid, String picId, boolean isShow) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        RecyclerView A0;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(picId, "picId");
        if (TextUtils.isEmpty(picId)) {
            K(isShow);
            return;
        }
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData == null || (cellMedia = mFeedData.getCellMedia()) == null || (mediaItems = cellMedia.getMediaItems()) == null) {
            return;
        }
        int i3 = 0;
        for (Object obj : mediaItems) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (TextUtils.equals(je.a.C((CommonMedia) obj), picId)) {
                QLog.i("QzoneFeedProBlogSection", 1, "data index:" + i3);
                QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.blogPicView;
                if (qzoneFeedProPicMixVideoView == null || (A0 = qzoneFeedProPicMixVideoView.A0()) == null || A0.getChildCount() <= i3) {
                    return;
                }
                View childAt = A0.getChildAt(i3);
                QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = childAt instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) childAt : null;
                if (qzoneFeedProMixBaseWidgetView != null) {
                    K(isShow);
                    L(qzoneFeedProMixBaseWidgetView);
                }
            }
            i3 = i16;
        }
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        QZoneRichTextView qZoneRichTextView = this.blogTitle;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setTextBold(true);
        }
        com.qzone.reborn.feedpro.utils.j.c(getActivity(), feedData, this.blogTitle, getMPosition());
        com.qzone.reborn.feedpro.utils.j.a(getActivity(), feedData, this.blogContent, getMPosition());
        com.qzone.reborn.feedpro.utils.j.b(getActivity(), feedData, getMForwardFeedData(), this.blogContent, this.blogPicView, getMPosition(), this.mTransCreatorKey);
        QZoneRichTextView qZoneRichTextView2 = this.blogTitle;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.I(g.this, view);
                }
            });
        }
        QZoneRichTextView qZoneRichTextView3 = this.blogContent;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.J(g.this, view);
                }
            });
        }
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mTransCreatorKey = RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(this);
        this.blogTitle = (QZoneRichTextView) containerView.findViewById(R.id.f20839g);
        this.blogContent = (QZoneRichTextView) containerView.findViewById(R.id.f20809d);
        this.blogPicView = (QzoneFeedProPicMixVideoView) containerView.findViewById(R.id.f20829f);
        if (containerView.getBackground() != null) {
            com.qzone.reborn.feedx.widget.i.a(containerView, QZoneCoverUtils.getSuperCoverTrans(null));
        }
        QZoneRichTextView qZoneRichTextView = this.blogTitle;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setLineSpace(ef.d.b(1));
        }
        QZoneRichTextView qZoneRichTextView2 = this.blogContent;
        if (qZoneRichTextView2 != null) {
            com.qzone.reborn.feedpro.utils.r rVar = com.qzone.reborn.feedpro.utils.r.f54359a;
            int b16 = rVar.b(qZoneRichTextView2.getContext());
            qZoneRichTextView2.setMaxLine(6);
            qZoneRichTextView2.setShowMore(true);
            qZoneRichTextView2.setShowMoreTextSize(ef.d.b(18));
            qZoneRichTextView2.setShowMoreTextUnClickable(true);
            qZoneRichTextView2.setShowMoreTextColor(b16);
            qZoneRichTextView2.setLineSpace(ef.d.b(4));
            qZoneRichTextView2.setTextColorLink(b16);
            qZoneRichTextView2.setTextColorLinkBackground(rVar.a(qZoneRichTextView2.getContext()));
        }
    }
}
