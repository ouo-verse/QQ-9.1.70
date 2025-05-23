package com.tencent.biz.qqcircle.immersive.gallery.itemview;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.feed.ad.x;
import com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryWaterfallFeedAdItemView;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q50.b;
import tl.h;
import uc0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u0001:\u0001?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010*R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/gallery/itemview/QFSGalleryWaterfallFeedAdItemView;", "Lcom/tencent/biz/qqcircle/immersive/gallery/itemview/QFSGalleryWaterfallFeedBaseItemView;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "z0", "u0", "B0", "s0", "w0", "y0", "q0", "Landroid/view/View;", "view", "A0", "", "getLogTag", "Landroid/widget/ImageView;", "l0", "", "getLayoutId", "Le30/b;", "objData", c.G, "bindData", "k0", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "mFeed", "Lcom/tencent/gdtad/aditem/GdtAd;", "e", "Lcom/tencent/gdtad/aditem/GdtAd;", "mGdtAd", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "mRoundContainer", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", "mCoverLayout", "i", "Landroid/widget/ImageView;", "mCoverImg", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "mTvTitle", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAvatar", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mNickName", "E", "mFeedBackView", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", UserInfo.SEX_FEMALE, "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "mFeedBackListener", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSGalleryWaterfallFeedAdItemView extends QFSGalleryWaterfallFeedBaseItemView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private QCircleAvatarView mAvatar;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TextView mNickName;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ImageView mFeedBackView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AdFeedbackDialogFragment.Listener mFeedBackListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd mGdtAd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RoundCorneredRelativeLayout mRoundContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout mCoverLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mCoverImg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QCircleAsyncTextView mTvTitle;

    private final void A0(View view) {
        j.f90213a.K(this.mGdtAd, view, this.dataPosInList, getQCircleExtraTypeInfo(), 99);
    }

    private final void B0() {
        float a16 = cx.a(8.0f);
        this.mRoundContainer.setRadius(a16, a16, a16, a16);
    }

    private final void q0(final FeedCloudMeta$StFeed feed) {
        this.mFeedBackView.setOnClickListener(new View.OnClickListener() { // from class: s40.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSGalleryWaterfallFeedAdItemView.r0(QFSGalleryWaterfallFeedAdItemView.this, feed, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(QFSGalleryWaterfallFeedAdItemView this$0, FeedCloudMeta$StFeed feed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        x.c(this$0, this$0.mGdtAd, feed, this$0.mFeedBackListener, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s0(FeedCloudMeta$StFeed feed) {
        Size m06 = m0();
        ViewGroup.LayoutParams layoutParams = this.mCoverLayout.getLayoutParams();
        layoutParams.width = m06.getWidth();
        layoutParams.height = m06.getHeight();
        this.mCoverImg.setBackgroundColor(-16777216);
        Option failedDrawableId = Option.obtain().setUrl(feed.cover.picUrl.get()).setTargetView(this.mCoverImg).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(m06.getWidth()).setRequestHeight(m06.getHeight()).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)).setFailedDrawableId(R.drawable.ojc);
        failedDrawableId.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        b.e().q(failedDrawableId, false);
        QCircleFeedPicLoader.g().loadImage(failedDrawableId);
    }

    private final void u0() {
        setOnClickListener(new View.OnClickListener() { // from class: s40.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSGalleryWaterfallFeedAdItemView.v0(QFSGalleryWaterfallFeedAdItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(QFSGalleryWaterfallFeedAdItemView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.A0(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void w0(FeedCloudMeta$StFeed feed) {
        this.mTvTitle.setPreloadParserInfo(a.c(this.mFeed, QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary), true));
        this.mTvTitle.setText(feed.content.get());
        this.mTvTitle.setOnClickListener(new View.OnClickListener() { // from class: s40.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSGalleryWaterfallFeedAdItemView.x0(QFSGalleryWaterfallFeedAdItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(QFSGalleryWaterfallFeedAdItemView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.A0(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void y0(FeedCloudMeta$StFeed feed) {
        this.mAvatar.setAvatar(feed.poster, n.a(getRootView().getContext(), R.dimen.f158711n0));
        this.mNickName.setText(feed.poster.nick.get());
    }

    private final void z0(FeedCloudMeta$StFeed feed) {
        B0();
        s0(feed);
        w0(feed);
        y0(feed);
        q0(feed);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168681gd1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSGalleryWaterfallFeedAdItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryWaterfallFeedBaseItemView
    public void k0() {
        super.k0();
        bz.d(this.mCoverLayout, m0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryWaterfallFeedBaseItemView
    @NotNull
    /* renamed from: l0, reason: from getter */
    public ImageView getMCoverImg() {
        return this.mCoverImg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable e30.b objData, int pos) {
        if (objData == null) {
            QLog.e("QFSGalleryWaterfallFeedAdItemView", 1, "bindData failed, objData is null");
            return;
        }
        FeedCloudMeta$StFeed c16 = u.c(objData);
        if (c16 == null) {
            QLog.e("QFSGalleryWaterfallFeedAdItemView", 1, "bindData failed, feed is null");
            return;
        }
        this.mFeed = c16;
        this.mGdtAd = new GdtAd(u.e(objData));
        z0(c16);
        u0();
    }
}
