package com.qzone.reborn.feedpro.section;

import android.view.View;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellForwardInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0014J\b\u0010\u0016\u001a\u00020\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/feedpro/section/u;", "Lne/a;", "Landroidx/lifecycle/Observer;", "Lzd/b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellForwardInfo;", "cellForwardInfo", "", "H", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "forwardList", "", "totalForwardNum", "", "I", "showSize", "K", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "L", "J", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "data", "M", "E", "Landroid/view/View;", "forwardListContainer", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "forwardListTv", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class u extends ne.a implements Observer<zd.b> {

    /* renamed from: E, reason: from kotlin metadata */
    private View forwardListContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneRichTextView forwardListTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedpro/section/u$b", "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "cell", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/text/CellTextView$OnTextOperater;", JsonRuleKey.OPERATOR, "", NodeProps.ON_LONG_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TextCellLayout.OnCellClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f54236b;

        b(View view) {
            this.f54236b = view;
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell cell, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QZoneRichTextView qZoneRichTextView = u.this.forwardListTv;
            if (qZoneRichTextView != null) {
                qZoneRichTextView.k(cell);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Long uin = cell != null ? cell.getUin() : null;
            linkedHashMap.put("touin", Long.valueOf(uin == null ? 0L : uin.longValue()));
            fo.b l3 = new fo.b().l(linkedHashMap);
            View view2 = new View(this.f54236b.getContext());
            fo.c.l(view2, u.this.forwardListTv);
            fo.c.b("dt_clck", view2, "em_qz_feed_share_nickname", l3);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater operator) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(operator, "operator");
            return false;
        }
    }

    private final String I(List<CommonUser> forwardList, int totalForwardNum) {
        if (forwardList.isEmpty()) {
            return totalForwardNum + "\u4eba\u8f6c\u53d1\u4e86";
        }
        StringBuilder sb5 = new StringBuilder();
        int min = Math.min(forwardList.size(), 5);
        for (int i3 = 0; i3 < min; i3++) {
            sb5.append(com.qzone.reborn.feedpro.utils.u.f54367a.b(forwardList.get(i3), false, false));
            if (i3 < min - 1) {
                sb5.append("{text:");
                sb5.append("\u3001");
                sb5.append(",color:");
                sb5.append(Integer.toHexString(com.qzone.reborn.feedpro.utils.r.f54359a.b(getActivity())));
                sb5.append(",useDefaultFont:1,useSuperFont:0,useLinkTextColor:1}");
            }
        }
        if (totalForwardNum > min) {
            J();
        }
        return sb5.toString() + " " + K(min, totalForwardNum);
    }

    private final void J() {
        fo.c.o(this.forwardListTv, "em_qz_feed_share_more", new fo.b().l(new LinkedHashMap()).i(CommonFeedExtKt.getFeedUniqueKey(getMFeedData())).k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_ALL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List N(u this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return xd.c.f(list, com.qzone.reborn.feedpro.utils.r.f54359a.b(this$0.getActivity()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L(this$0.getMFeedData());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProForwardListSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.f162981no1;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.forwardListContainer = containerView.findViewById(R.id.f20969t);
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) containerView.findViewById(R.id.f20979u);
        this.forwardListTv = qZoneRichTextView;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setLineSpace(com.qzone.reborn.util.r.f59560a.e(3));
        }
        QZoneRichTextView qZoneRichTextView2 = this.forwardListTv;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setTextSize(com.qzone.reborn.util.r.f59560a.d(Float.valueOf(14.0f)));
        }
        QZoneRichTextView qZoneRichTextView3 = this.forwardListTv;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.feedpro.section.s
                @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
                public final List a(List list) {
                    List N;
                    N = u.N(u.this, list);
                    return N;
                }
            });
        }
        QZoneRichTextView qZoneRichTextView4 = this.forwardListTv;
        if (qZoneRichTextView4 != null) {
            qZoneRichTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.O(u.this, view);
                }
            });
        }
        QZoneRichTextView qZoneRichTextView5 = this.forwardListTv;
        if (qZoneRichTextView5 != null) {
            qZoneRichTextView5.setTextColorLink(com.qzone.reborn.feedpro.utils.r.f54359a.b(getActivity()));
        }
        QZoneRichTextView qZoneRichTextView6 = this.forwardListTv;
        if (qZoneRichTextView6 != null) {
            qZoneRichTextView6.setTextColorLinkBackground(com.qzone.reborn.feedpro.utils.r.f54359a.a(getActivity()));
        }
        QZoneRichTextView qZoneRichTextView7 = this.forwardListTv;
        if (qZoneRichTextView7 != null) {
            qZoneRichTextView7.setOnCellClickListener(new b(containerView));
        }
    }

    private final void H(CommonCellForwardInfo cellForwardInfo) {
        if (cellForwardInfo != null && !cellForwardInfo.getForwardList().isEmpty()) {
            View view = this.forwardListContainer;
            if (view != null) {
                view.setVisibility(0);
            }
            String I = I(cellForwardInfo.getForwardList(), cellForwardInfo.getRetweetCount());
            QZoneRichTextView qZoneRichTextView = this.forwardListTv;
            if (qZoneRichTextView != null) {
                qZoneRichTextView.setRichText(I);
                return;
            }
            return;
        }
        View view2 = this.forwardListContainer;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    private final void L(CommonFeed feedData) {
        CommonCellForwardInfo cellForwardInfo;
        String jumpUrl;
        if (feedData == null || (cellForwardInfo = feedData.getCellForwardInfo()) == null || (jumpUrl = cellForwardInfo.getJumpUrl()) == null) {
            return;
        }
        ho.i.q(getActivity(), jumpUrl);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void onChanged(zd.b data) {
        H(data != null ? data.getCellForward() : null);
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (feedData != null) {
            H(feedData.getCellForwardInfo());
        }
        ze.a.a().observerGlobalState(new zd.b(f(), CommonFeedExtKt.getFeedUniqueKey(feedData), feedData != null ? feedData.getCellForwardInfo() : null, Boolean.FALSE), this);
    }

    private final String K(int showSize, int totalForwardNum) {
        if (totalForwardNum <= 2) {
            return "\u8f6c\u53d1\u4e86";
        }
        if (showSize < totalForwardNum) {
            return "\u7b49" + totalForwardNum + "\u4eba\u8f6c\u53d1\u4e86";
        }
        return totalForwardNum + "\u4eba\u8f6c\u53d1\u4e86";
    }
}
