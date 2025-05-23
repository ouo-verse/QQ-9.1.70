package com.qzone.reborn.feedpro.section;

import android.view.View;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLikeMan;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLike;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u000e\u001a\u00020\r2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/feedpro/section/am;", "Lne/a;", "Landroidx/lifecycle/Observer;", "Lzd/c;", "Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "cellLike", "", "H", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLikeMan;", "likeMans", "", "totalLikeNum", "", "I", "L", "showSize", "K", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "M", "J", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "data", "N", "E", "Landroid/view/View;", "likeListContainer", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "likeListText", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class am extends ne.a implements Observer<zd.c> {

    /* renamed from: E, reason: from kotlin metadata */
    private View likeListContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneRichTextView likeListText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedpro/section/am$b", "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "cell", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/text/CellTextView$OnTextOperater;", JsonRuleKey.OPERATOR, "", NodeProps.ON_LONG_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TextCellLayout.OnCellClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f54194b;

        b(View view) {
            this.f54194b = view;
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell cell, View view) {
            Intrinsics.checkNotNullParameter(cell, "cell");
            Intrinsics.checkNotNullParameter(view, "view");
            QZoneRichTextView qZoneRichTextView = am.this.likeListText;
            if (qZoneRichTextView != null) {
                qZoneRichTextView.k(cell);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Long uin = cell.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "cell.uin");
            linkedHashMap.put("touin", uin);
            fo.b l3 = new fo.b().l(linkedHashMap);
            View view2 = new View(this.f54194b.getContext());
            fo.c.l(view2, am.this.likeListText);
            fo.c.b("dt_clck", view2, "em_qz_feed_likes_nickname", l3);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater operator) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(operator, "operator");
            return false;
        }
    }

    private final String I(List<CommonLikeMan> likeMans, int totalLikeNum) {
        if (likeMans.isEmpty()) {
            String string = BaseApplication.getContext().getString(R.string.f169535o40, Integer.valueOf(totalLikeNum));
            Intrinsics.checkNotNullExpressionValue(string, "getContext()\n           \u2026t_nickname, totalLikeNum)");
            return string;
        }
        StringBuilder sb5 = new StringBuilder();
        int min = Math.min(likeMans.size(), L());
        for (int i3 = 0; i3 < min; i3++) {
            CommonLikeMan commonLikeMan = likeMans.get(i3);
            if (commonLikeMan != null) {
                sb5.append(com.qzone.reborn.feedpro.utils.u.f54367a.b(commonLikeMan.getUser(), false, false));
                if (i3 < min - 1) {
                    sb5.append("{text:");
                    sb5.append("\u3001");
                    sb5.append(",color:");
                    sb5.append(Integer.toHexString(com.qzone.reborn.feedpro.utils.r.f54359a.b(getActivity())));
                    sb5.append(",useDefaultFont:1,useSuperFont:0,useLinkTextColor:1}");
                }
            }
        }
        if (totalLikeNum > min) {
            J();
        }
        return sb5.toString() + " " + K(totalLikeNum, min);
    }

    private final void J() {
        fo.c.o(this.likeListText, "em_qz_feed_likes_more", new fo.b().l(new LinkedHashMap()).i(CommonFeedExtKt.getFeedUniqueKey(getMFeedData())).k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_ALL));
    }

    private final int L() {
        return com.qzone.reborn.feedx.util.x.f55790a.c(n()) ? 15 : 10;
    }

    private final void M(CommonFeed feedData) {
        ho.i.h().b(getActivity(), feedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List O(am this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return xd.c.f(list, com.qzone.reborn.feedpro.utils.r.f54359a.b(this$0.getActivity()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(am this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M(this$0.getMFeedData());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProLikeListSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.no5;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.likeListContainer = containerView.findViewById(R.id.ac9);
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) containerView.findViewById(R.id.aol);
        this.likeListText = qZoneRichTextView;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setLineSpace(com.qzone.reborn.util.r.f59560a.e(3));
        }
        QZoneRichTextView qZoneRichTextView2 = this.likeListText;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setTextSize(com.qzone.reborn.util.r.f59560a.d(Float.valueOf(14.0f)));
        }
        QZoneRichTextView qZoneRichTextView3 = this.likeListText;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.feedpro.section.ak
                @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
                public final List a(List list) {
                    List O;
                    O = am.O(am.this, list);
                    return O;
                }
            });
        }
        QZoneRichTextView qZoneRichTextView4 = this.likeListText;
        if (qZoneRichTextView4 != null) {
            qZoneRichTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.al
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    am.P(am.this, view);
                }
            });
        }
        QZoneRichTextView qZoneRichTextView5 = this.likeListText;
        if (qZoneRichTextView5 != null) {
            qZoneRichTextView5.setTextColorLink(com.qzone.reborn.feedpro.utils.r.f54359a.b(getActivity()));
        }
        QZoneRichTextView qZoneRichTextView6 = this.likeListText;
        if (qZoneRichTextView6 != null) {
            qZoneRichTextView6.setTextColorLinkBackground(com.qzone.reborn.feedpro.utils.r.f54359a.a(getActivity()));
        }
        QZoneRichTextView qZoneRichTextView7 = this.likeListText;
        if (qZoneRichTextView7 != null) {
            qZoneRichTextView7.setOnCellClickListener(new b(containerView));
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onChanged(zd.c data) {
        H(data != null ? data.getCellLike() : null);
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (feedData != null) {
            H(feedData.getCellLike());
        }
        ze.a.a().observerGlobalState(new zd.c(f(), CommonFeedExtKt.getFeedUniqueKey(feedData), feedData != null ? feedData.getCellLike() : null), this);
    }

    private final void H(CommonCellLike cellLike) {
        if (cellLike != null && !cellLike.likeMans.isEmpty()) {
            View view = this.likeListContainer;
            if (view != null) {
                view.setVisibility(0);
            }
            A(new be.a(true));
            List<CommonLikeMan> list = cellLike.likeMans;
            Intrinsics.checkNotNullExpressionValue(list, "cellLike.likeMans");
            String I = I(list, cellLike.num);
            QZoneRichTextView qZoneRichTextView = this.likeListText;
            if (qZoneRichTextView != null) {
                qZoneRichTextView.setRichText(I);
                return;
            }
            return;
        }
        View view2 = this.likeListContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        A(new be.a(false));
    }

    private final String K(int totalLikeNum, int showSize) {
        if (totalLikeNum <= 2) {
            String string = BaseApplication.getContext().getString(R.string.o3u);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            MobileQQ.g\u2026one_feedx_like)\n        }");
            return string;
        }
        if (showSize < totalLikeNum) {
            String string2 = BaseApplication.getContext().getString(R.string.o48, Integer.valueOf(totalLikeNum));
            Intrinsics.checkNotNullExpressionValue(string2, "{\n            MobileQQ.g\u2026, totalLikeNum)\n        }");
            return string2;
        }
        String string3 = BaseApplication.getContext().getString(R.string.f169535o40, Integer.valueOf(totalLikeNum));
        Intrinsics.checkNotNullExpressionValue(string3, "{\n            MobileQQ.g\u2026, totalLikeNum)\n        }");
        return string3;
    }
}
