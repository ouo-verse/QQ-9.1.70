package com.qzone.reborn.feedx.widget.eventtag;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.util.n;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagBaseItemView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import gf.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0012B\u000f\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemVideoView;", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagBaseItemView;", "Landroid/view/View$OnClickListener;", "Lgf/r;", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "z0", "", "v0", "x0", "y0", "", "getLayoutId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "objData", c.G, "w0", "play", "pause", "a", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "d", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "mContainerView", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagVideoWidgetView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagVideoWidgetView;", "mVideoView", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "D", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mTitleRichView", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "E", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "mItemBottomView", UserInfo.SEX_FEMALE, "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "mVideoInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "G", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneEventTagItemVideoView extends QZoneEventTagBaseItemView implements View.OnClickListener, r {

    /* renamed from: C, reason: from kotlin metadata */
    private final QZoneEventTagVideoWidgetView mVideoView;

    /* renamed from: D, reason: from kotlin metadata */
    private final QZoneRichTextView mTitleRichView;

    /* renamed from: E, reason: from kotlin metadata */
    private final QZoneEventTagItemBottomView mItemBottomView;

    /* renamed from: F, reason: from kotlin metadata */
    private VideoInfo mVideoInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final RoundCorneredRelativeLayout mContainerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagItemVideoView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mvd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_event_tag_video_container)");
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) findViewById;
        this.mContainerView = roundCorneredRelativeLayout;
        View findViewById2 = findViewById(R.id.mvf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_event_tag_video_view)");
        this.mVideoView = (QZoneEventTagVideoWidgetView) findViewById2;
        View findViewById3 = findViewById(R.id.mve);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_event_tag_video_title)");
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) findViewById3;
        this.mTitleRichView = qZoneRichTextView;
        View findViewById4 = findViewById(R.id.mvc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026nt_tag_video_bottom_view)");
        this.mItemBottomView = (QZoneEventTagItemBottomView) findViewById4;
        QZoneEventTagBaseItemView.Companion companion = QZoneEventTagBaseItemView.INSTANCE;
        roundCorneredRelativeLayout.setRadius(companion.a(), companion.a(), companion.a(), companion.a());
        roundCorneredRelativeLayout.setOnClickListener(this);
        qZoneRichTextView.setOnClickListener(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private final void v0() {
        if (this.mVideoView.p0() == null) {
            QLog.e("QZoneEventTagItemVideoView", 1, "adjustViewLayoutParams params error");
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mVideoView.p0().getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "mVideoView.coverImageView.layoutParams");
        this.mContainerView.getLayoutParams().width = layoutParams.width;
        this.mContainerView.setMinimumHeight(QZoneEventTagBaseItemView.s0(this, layoutParams.height, 0, 2, null));
        int i3 = this.dataPosInList;
        CellSummary cellSummaryV2 = getData().getCellSummaryV2();
        String str = cellSummaryV2 != null ? cellSummaryV2.displayStr : null;
        VideoInfo videoInfo = this.mVideoInfo;
        Integer valueOf = videoInfo != null ? Integer.valueOf(videoInfo.width) : null;
        VideoInfo videoInfo2 = this.mVideoInfo;
        Integer valueOf2 = videoInfo2 != null ? Integer.valueOf(videoInfo2.height) : null;
        QLog.i("QZoneEventTagItemVideoView", 1, "adjustViewLayoutParams  | position = " + i3 + " | text = " + str + " | videoWidth = " + valueOf + " | videoHeight = " + valueOf2 + " | realWidth = " + getLayoutParams().width + " | realHeight = " + getLayoutParams().height);
    }

    private final void x0() {
        String e16 = n.e(getData());
        if (TextUtils.isEmpty(e16)) {
            this.mTitleRichView.setVisibility(8);
            RFWLog.e("QZoneEventTagItemVideoView", RFWLog.USR, "[bindTitleView] summaryText = null");
            return;
        }
        this.mTitleRichView.setVisibility(0);
        int color = getContext().getResources().getColor(R.color.qui_common_text_primary);
        this.mTitleRichView.setTextColor(color);
        this.mTitleRichView.setTextColorLink(color);
        this.mTitleRichView.setShowMore(false);
        this.mTitleRichView.setLineSpace(ImmersiveUtils.dpToPx(1.5f));
        this.mTitleRichView.setRichText(e16);
    }

    private final void y0() {
        if (this.mVideoInfo == null) {
            RFWLog.e("QZoneEventTagItemVideoView", RFWLog.USR, "[bindVideoView] videoInfo = null");
            return;
        }
        Object tag = this.mVideoView.getTag(R.id.nda);
        String str = tag instanceof String ? (String) tag : null;
        VideoInfo videoInfo = this.mVideoInfo;
        Intrinsics.checkNotNull(videoInfo);
        PictureUrl pictureUrl = videoInfo.coverUrl;
        String str2 = pictureUrl != null ? pictureUrl.url : null;
        if (str2 == null) {
            str2 = "";
        }
        if ((str == null || str.length() == 0) || !TextUtils.equals(str, str2)) {
            this.mVideoView.setFeedData(getData());
            this.mVideoView.setDataPosInList(this.dataPosInList);
            this.mVideoView.H0(this.mVideoInfo);
        }
    }

    private final VideoInfo z0() {
        VideoInfo videoInfo;
        ArrayList<PictureItem> arrayList;
        if (getData().getVideoInfo() != null) {
            videoInfo = getData().getVideoInfo();
        } else {
            CellPictureInfo pictureInfo = getData().getPictureInfo();
            if (!bl.b(pictureInfo != null ? pictureInfo.pics : null)) {
                CellPictureInfo pictureInfo2 = getData().getPictureInfo();
                boolean z16 = false;
                PictureItem pictureItem = (pictureInfo2 == null || (arrayList = pictureInfo2.pics) == null) ? null : arrayList.get(0);
                if (pictureItem != null && pictureItem.videoflag == 1) {
                    z16 = true;
                }
                if (z16) {
                    videoInfo = pictureItem.videodata;
                }
            }
            videoInfo = null;
        }
        return rh.c.f431447a.d(videoInfo);
    }

    @Override // gf.r
    public void a() {
        this.mVideoView.a();
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        return this.mVideoView;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.apw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        switch (view.getId()) {
            case R.id.mvd /* 1745224765 */:
            case R.id.mve /* 1745224766 */:
                u0(view);
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // gf.r
    public void pause() {
        this.mVideoView.pause();
    }

    @Override // gf.r
    public void play() {
        this.mVideoView.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData objData, int pos) {
        if (objData == null) {
            return;
        }
        this.mVideoInfo = z0();
        x0();
        y0();
        n0(this.mItemBottomView);
        v0();
        o0(this.mContainerView);
    }
}
