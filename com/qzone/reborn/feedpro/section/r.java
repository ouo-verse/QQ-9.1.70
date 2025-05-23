package com.qzone.reborn.feedpro.section;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/feedpro/section/r;", "Lne/a;", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", "E", "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "titleTv", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private RFWSquareImageView coverImg;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneRichTextView titleTv;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(r this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.m f16 = ho.i.f();
        Intrinsics.checkNotNullExpressionValue(f16, "detailPro()");
        ho.m.c(f16, this$0.getActivity(), this$0.getMFeedData(), null, 0, 12, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProForwardHandBlogSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.f162984no4;
    }

    @Override // ne.a
    protected boolean u() {
        return true;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        com.qzone.reborn.feedpro.utils.j.e(feedData, this.coverImg);
        com.qzone.reborn.feedpro.utils.j.f(feedData, this.titleTv);
        QZoneRichTextView qZoneRichTextView = this.titleTv;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.F(r.this, view);
                }
            });
        }
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.coverImg = (RFWSquareImageView) containerView.findViewById(R.id.f21019y);
        this.titleTv = (QZoneRichTextView) containerView.findViewById(R.id.f21029z);
    }
}
