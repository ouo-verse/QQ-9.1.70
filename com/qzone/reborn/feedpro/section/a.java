package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.widget.media.QUIPlayIconView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/feedpro/section/a;", "Lne/a;", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "E", "Landroid/view/View;", "shareRoot", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "coverIv", "Lcom/tencent/widget/media/QUIPlayIconView;", "G", "Lcom/tencent/widget/media/QUIPlayIconView;", "playIcon", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "H", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "titleTv", "I", "contentTv", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "extraInfoTv", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private View shareRoot;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView coverIv;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIPlayIconView playIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneRichTextView titleTv;

    /* renamed from: I, reason: from kotlin metadata */
    private QZoneRichTextView contentTv;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView extraInfoTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProHandBlogSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.nnw;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        com.qzone.reborn.feedpro.utils.ak.h(getActivity(), feedData, this.coverIv);
        com.qzone.reborn.feedpro.utils.ak.j(feedData, this.titleTv);
        com.qzone.reborn.feedpro.utils.ak.g(feedData, this.contentTv);
        com.qzone.reborn.feedpro.utils.ak.i(feedData, this.extraInfoTv);
        com.qzone.reborn.feedpro.utils.ak.e(getActivity(), feedData, this.shareRoot);
        Activity activity = getActivity();
        QZoneRichTextView qZoneRichTextView = this.titleTv;
        Intrinsics.checkNotNull(qZoneRichTextView);
        QZoneRichTextView qZoneRichTextView2 = this.contentTv;
        Intrinsics.checkNotNull(qZoneRichTextView2);
        com.qzone.reborn.feedpro.utils.ak.c(activity, feedData, qZoneRichTextView, qZoneRichTextView2);
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.shareRoot = containerView.findViewById(R.id.f207599);
        this.coverIv = (ImageView) containerView.findViewById(R.id.f207397);
        this.playIcon = (QUIPlayIconView) containerView.findViewById(R.id.f207195);
        this.titleTv = (QZoneRichTextView) containerView.findViewById(R.id.f20769_);
        this.contentTv = (QZoneRichTextView) containerView.findViewById(R.id.f207296);
        this.extraInfoTv = (TextView) containerView.findViewById(R.id.f207498);
        QZoneRichTextView qZoneRichTextView = this.titleTv;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setLineSpace(ef.d.b(3));
        }
        QZoneRichTextView qZoneRichTextView2 = this.contentTv;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setLineSpace(ef.d.b(3));
        }
    }
}
