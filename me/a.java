package me;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lme/a;", "Lne/a;", "Landroid/view/View$OnClickListener;", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "E", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mAdBottomLeftText", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mAdBottomLabelLayout", "Lyd/a;", "G", "Lyd/a;", "mAdFeedData", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends ne.a implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneRichTextView mAdBottomLeftText;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mAdBottomLabelLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private yd.a mAdFeedData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QZoneAdFeedBottomLeftSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            FeedElement feedElement = FeedElement.RECOMM_ACTION_LEFT_TEXT;
            int id5 = v3.getId();
            int i3 = (id5 == R.id.mlw || id5 == R.id.mly) ? 7 : 1000;
            Activity activity = getActivity();
            if (activity != null) {
                g6.c.f401419a.g(activity, v3, this.mAdFeedData, feedElement, i3, getMPosition(), null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // ne.a
    protected int q() {
        return R.id.nmk;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mAdBottomLeftText = (QZoneRichTextView) containerView.findViewById(R.id.mly);
        this.mAdBottomLabelLayout = (TextView) containerView.findViewById(R.id.mlw);
        QZoneRichTextView qZoneRichTextView = this.mAdBottomLeftText;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setOnClickListener(this);
        }
        TextView textView = this.mAdBottomLabelLayout;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        int color = containerView.getResources().getColor(R.color.qui_common_text_secondary);
        QZoneRichTextView qZoneRichTextView2 = this.mAdBottomLeftText;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setTextColor(color);
        }
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        String str;
        if (feedData == null) {
            return;
        }
        yd.a h16 = xd.c.h(feedData);
        this.mAdFeedData = h16;
        int i3 = 8;
        if (qe.b.f428879a.h(h16)) {
            View mContainerView = getMContainerView();
            if (mContainerView == null) {
                return;
            }
            mContainerView.setVisibility(8);
            return;
        }
        View mContainerView2 = getMContainerView();
        int i16 = 0;
        if (mContainerView2 != null) {
            mContainerView2.setVisibility(0);
        }
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> i17 = yd.b.i(this.mAdFeedData);
        boolean z16 = !i17.isEmpty();
        String j3 = yd.b.j(this.mAdFeedData);
        TextView textView = this.mAdBottomLabelLayout;
        if (textView != null) {
            textView.setVisibility(z16 ? 0 : 8);
        }
        QZoneRichTextView qZoneRichTextView = this.mAdBottomLeftText;
        if (qZoneRichTextView != null) {
            if (!z16) {
                if (j3.length() > 0) {
                    i3 = 0;
                }
            }
            qZoneRichTextView.setVisibility(i3);
        }
        QZoneRichTextView qZoneRichTextView2 = this.mAdBottomLeftText;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setText(j3);
        }
        if (z16) {
            String str2 = "";
            for (Object obj : i17) {
                int i18 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label label = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label) obj;
                if (i16 <= 0) {
                    str = "";
                } else {
                    str = " \u00b7 ";
                }
                str2 = ((Object) str2) + str + label.content.get();
                i16 = i18;
            }
            TextView textView2 = this.mAdBottomLabelLayout;
            if (textView2 == null) {
                return;
            }
            textView2.setText(str2);
        }
    }
}
