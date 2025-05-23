package com.qzone.reborn.feedx.widget.eventtag;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.reborn.feedx.util.n;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagBaseItemView;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0006H\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemTextView;", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagBaseItemView;", "Landroid/view/View$OnClickListener;", "", "v0", "x0", "", "getLayoutId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "objData", c.G, "w0", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mTitleRichView", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "mTitleArea", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "D", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "mContainerView", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "E", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "mItemBottomView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneEventTagItemTextView extends QZoneEventTagBaseItemView implements View.OnClickListener {
    private static final int G = ar.e(40.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private final ViewGroup mTitleArea;

    /* renamed from: D, reason: from kotlin metadata */
    private final RoundCorneredRelativeLayout mContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneEventTagItemBottomView mItemBottomView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final QZoneRichTextView mTitleRichView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagItemTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mus);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_event_tag_item_title)");
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) findViewById;
        this.mTitleRichView = qZoneRichTextView;
        View findViewById2 = findViewById(R.id.mut);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_event_tag_item_title_area)");
        this.mTitleArea = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.mv7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_event_tag_text_container)");
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) findViewById3;
        this.mContainerView = roundCorneredRelativeLayout;
        View findViewById4 = findViewById(R.id.mv6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026ent_tag_text_bottom_view)");
        this.mItemBottomView = (QZoneEventTagItemBottomView) findViewById4;
        QZoneEventTagBaseItemView.Companion companion = QZoneEventTagBaseItemView.INSTANCE;
        roundCorneredRelativeLayout.setRadius(companion.a(), companion.a(), companion.a(), companion.a());
        roundCorneredRelativeLayout.setOnClickListener(this);
        qZoneRichTextView.setOnClickListener(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private final void v0() {
        ViewGroup.LayoutParams layoutParams = this.mTitleArea.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "mTitleArea.layoutParams");
        rh.c cVar = rh.c.f431447a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        layoutParams.width = cVar.g(context);
        this.mTitleArea.setLayoutParams(layoutParams);
        this.mTitleArea.setMinimumHeight((int) (layoutParams.width * 0.76836157f));
        this.mContainerView.getLayoutParams().width = layoutParams.width;
        this.mContainerView.setMinimumHeight(this.mTitleArea.getMinimumHeight());
        int i3 = this.dataPosInList;
        CellSummary cellSummaryV2 = getData().getCellSummaryV2();
        String str = cellSummaryV2 != null ? cellSummaryV2.displayStr : null;
        QLog.i("QZoneEventTagItemTextView", 1, "adjustViewLayoutParams  | position = " + i3 + " | text = " + str + " | realWidth = " + layoutParams.width + " | realHeight = " + layoutParams.height);
    }

    private final void x0() {
        String e16 = n.e(getData());
        if (TextUtils.isEmpty(e16)) {
            RFWLog.e("QZoneEventTagItemTextView", RFWLog.USR, "[bindTitleView] summaryText = null");
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

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ak_;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        int id5 = view.getId();
        if (id5 == R.id.mus || id5 == R.id.mv7) {
            u0(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData objData, int pos) {
        if (objData == null) {
            return;
        }
        x0();
        n0(this.mItemBottomView);
        v0();
        o0(this.mContainerView);
    }
}
