package com.qzone.reborn.feedx.widget.eventtag;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.feedx.util.n;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagBaseItemView;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagItemPicView;
import com.qzone.reborn.feedx.widget.picmixvideo.b;
import com.qzone.reborn.util.m;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemPicView;", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagBaseItemView;", "Landroid/view/View$OnClickListener;", "", "w0", "A0", "y0", "", "getLayoutId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "objData", c.G, "x0", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mPictureView", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mTitleRichView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "D", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "mContainerView", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "E", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "mItemBottomView", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", UserInfo.SEX_FEMALE, "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "mPictureUrl", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneEventTagItemPicView extends QZoneEventTagBaseItemView implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final QZoneRichTextView mTitleRichView;

    /* renamed from: D, reason: from kotlin metadata */
    private final RoundCorneredRelativeLayout mContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    private final QZoneEventTagItemBottomView mItemBottomView;

    /* renamed from: F, reason: from kotlin metadata */
    private PictureUrl mPictureUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ImageView mPictureView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagItemPicView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.muz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_event_tag_picture)");
        this.mPictureView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.mux);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_event_tag_pic_container)");
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) findViewById2;
        this.mContainerView = roundCorneredRelativeLayout;
        View findViewById3 = findViewById(R.id.muy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_event_tag_pic_title)");
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) findViewById3;
        this.mTitleRichView = qZoneRichTextView;
        View findViewById4 = findViewById(R.id.muw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_event_tag_pic_bottom_view)");
        this.mItemBottomView = (QZoneEventTagItemBottomView) findViewById4;
        QZoneEventTagBaseItemView.Companion companion = QZoneEventTagBaseItemView.INSTANCE;
        roundCorneredRelativeLayout.setRadius(companion.a(), companion.a(), companion.a(), companion.a());
        roundCorneredRelativeLayout.setOnClickListener(this);
        qZoneRichTextView.setOnClickListener(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private final void A0() {
        String e16 = n.e(getData());
        if (TextUtils.isEmpty(e16)) {
            this.mTitleRichView.setVisibility(8);
            RFWLog.i("QZoneEventTagItemPicView", RFWLog.USR, "[bindTitleView] summaryText = null");
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

    private final void w0() {
        if (this.mPictureUrl == null) {
            QLog.e("QZoneEventTagItemPicView", 1, "adjustViewLayoutParams params error");
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mPictureView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "mPictureView.layoutParams");
        rh.c.f431447a.a(getContext(), layoutParams, this.mPictureUrl);
        this.mPictureView.setLayoutParams(layoutParams);
        this.mContainerView.getLayoutParams().width = layoutParams.width;
        this.mContainerView.setMinimumHeight(QZoneEventTagBaseItemView.s0(this, layoutParams.height, 0, 2, null));
        int i3 = this.dataPosInList;
        CellSummary cellSummaryV2 = getData().getCellSummaryV2();
        String str = cellSummaryV2 != null ? cellSummaryV2.displayStr : null;
        PictureUrl pictureUrl = this.mPictureUrl;
        Intrinsics.checkNotNull(pictureUrl);
        int i16 = pictureUrl.width;
        PictureUrl pictureUrl2 = this.mPictureUrl;
        Intrinsics.checkNotNull(pictureUrl2);
        QLog.i("QZoneEventTagItemPicView", 1, "adjustViewLayoutParams  | position = " + i3 + " | text = " + str + " | picWidth = " + i16 + " | picHeight = " + pictureUrl2.height + " | realWidth = " + layoutParams.width + " | realHeight = " + layoutParams.height);
    }

    private final void y0() {
        PictureUrl pictureUrl = this.mPictureUrl;
        String str = pictureUrl != null ? pictureUrl.url : null;
        if (TextUtils.isEmpty(str)) {
            this.mPictureView.setImageDrawable(m.f59551a.b(getContext()));
            RFWLog.e("QZoneEventTagItemPicView", RFWLog.USR, "[bindPictureView] pictureInfo coverUrl = null");
            return;
        }
        Object tag = this.mPictureView.getTag(R.id.n9a);
        String str2 = tag instanceof String ? (String) tag : null;
        if ((str2 == null || str2.length() == 0) || !TextUtils.equals(str2, str)) {
            final Option e16 = com.tencent.mobileqq.qzone.picload.c.e(str);
            e16.setTargetView(this.mPictureView);
            m mVar = m.f59551a;
            e16.setLoadingDrawable(mVar.b(getContext()));
            e16.setFailDrawable(mVar.a(getContext()));
            if (this.mPictureView.getLayoutParams() != null) {
                e16.setRequestWidth(this.mPictureView.getLayoutParams().width);
                e16.setRequestHeight(this.mPictureView.getLayoutParams().height);
            }
            com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: rh.a
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    QZoneEventTagItemPicView.z0(QZoneEventTagItemPicView.this, e16, loadState, option);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(QZoneEventTagItemPicView this$0, Option option, LoadState loadState, Option option2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess() && option2 != null) {
            this$0.mPictureView.setTag(R.id.n9a, option.getUrl());
            Animatable animatable = option2.getAnimatable();
            if (animatable != null) {
                animatable.stop();
                return;
            }
            return;
        }
        RFWLog.e("QZoneEventTagItemPicView", RFWLog.USR, "[bindPictureView] loadImage fail:" + loadState);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167265ab2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        switch (view.getId()) {
            case R.id.mux /* 1745224748 */:
            case R.id.muy /* 1745224749 */:
                u0(view);
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData objData, int pos) {
        if (objData == null) {
            return;
        }
        CellPictureInfo pictureInfo = objData.getPictureInfo();
        if (!bl.b(pictureInfo != null ? pictureInfo.pics : null)) {
            this.mPictureUrl = b.h(objData.getPictureInfo().pics.get(0));
        }
        w0();
        y0();
        A0();
        n0(this.mItemBottomView);
        o0(this.mContainerView);
    }
}
