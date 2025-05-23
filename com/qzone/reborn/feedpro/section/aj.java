package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedpro/section/aj;", "Lne/a;", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "E", "Landroid/view/View;", "shareRoot", "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "G", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "titleTv", "H", "contentTv", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aj extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private View shareRoot;

    /* renamed from: F, reason: from kotlin metadata */
    private RFWSquareImageView coverImg;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneRichTextView titleTv;

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneRichTextView contentTv;

    /* JADX INFO: Access modifiers changed from: private */
    public static final List G(aj this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return xd.c.g(list, com.qzone.reborn.feedpro.utils.r.f54359a.b(this$0.getActivity()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H(aj this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return xd.c.g(list, com.qzone.reborn.feedpro.utils.r.f54359a.b(this$0.getActivity()), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProLeftPicRightTextSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.nno;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        com.qzone.reborn.feedpro.utils.ak.l(feedData, this.coverImg);
        com.qzone.reborn.feedpro.utils.ak.m(feedData, this.titleTv);
        com.qzone.reborn.feedpro.utils.ak.k(feedData, this.contentTv);
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
        this.shareRoot = containerView.findViewById(R.id.abg);
        this.coverImg = (RFWSquareImageView) containerView.findViewById(R.id.abe);
        this.titleTv = (QZoneRichTextView) containerView.findViewById(R.id.abh);
        this.contentTv = (QZoneRichTextView) containerView.findViewById(R.id.a__);
        QZoneRichTextView qZoneRichTextView = this.titleTv;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.feedpro.section.ah
                @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
                public final List a(List list) {
                    List G;
                    G = aj.G(aj.this, list);
                    return G;
                }
            });
            qZoneRichTextView.setLineSpace(ef.d.b(4));
            com.qzone.reborn.feedpro.utils.r rVar = com.qzone.reborn.feedpro.utils.r.f54359a;
            qZoneRichTextView.setTextColorLink(rVar.b(getActivity()));
            qZoneRichTextView.setTextColorLinkBackground(rVar.a(getActivity()));
        }
        QZoneRichTextView qZoneRichTextView2 = this.contentTv;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.feedpro.section.ai
                @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
                public final List a(List list) {
                    List H;
                    H = aj.H(aj.this, list);
                    return H;
                }
            });
            qZoneRichTextView2.setLineSpace(ef.d.b(4));
            com.qzone.reborn.feedpro.utils.r rVar2 = com.qzone.reborn.feedpro.utils.r.f54359a;
            qZoneRichTextView2.setTextColorLink(rVar2.b(getActivity()));
            qZoneRichTextView2.setTextColorLinkBackground(rVar2.a(getActivity()));
        }
    }
}
