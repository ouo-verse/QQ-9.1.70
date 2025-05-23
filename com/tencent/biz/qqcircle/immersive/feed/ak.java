package com.tencent.biz.qqcircle.immersive.feed;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.HotEventInfoKt;
import com.tencent.biz.qqcircle.beans.QCircleHotEventPolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleHotEventRankInitBean;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StHotTagInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\bH\u0002J,\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J4\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u001a\u0010 \u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0012H\u0016R\u0016\u0010$\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010#\u00a8\u00063"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ak;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lfeedcloud/FeedCloudMeta$StHotTagInfo;", "hotEventInfo", "feed", "", "i1", "Lcooperation/qqcircle/report/QCircleLpReportDc05507$DataBuilder;", "kotlin.jvm.PlatformType", "m1", "", "actionType", "subActionType", "builder", "o1", "Landroid/view/View;", "view", "", "eid", "", "params", "p1", "eventId", "rank", "name", QQWinkConstants.TAB_SUBTITLE, "l1", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "position", ICustomDataEditor.NUMBER_PARAM_1, "w0", "I", "Landroid/view/View;", "floatTitleView", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "hotEventTv", "K", "rankTv", "L", "desTv", "M", "rankLayout", "<init>", "()V", "N", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ak extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata */
    private View floatTitleView;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView hotEventTv;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView rankTv;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView desTv;

    /* renamed from: M, reason: from kotlin metadata */
    private View rankLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ak$a;", "", "Le30/b;", "feedBlockData", "Lfeedcloud/FeedCloudMeta$StHotTagInfo;", "a", "", "DC_ACTION_TYPE_HOT_EVENT", "I", "DC_ACTION_TYPE_RANK", "DC_SUB_ACTION_CLICK", "DC_SUB_ACTION_EXPOSURE", "", "DT_ELEMENT_ID_HOT_EVENT", "Ljava/lang/String;", "DT_ELEMENT_ID_RANK", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.ak$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FeedCloudMeta$StHotTagInfo a(@NotNull e30.b feedBlockData) {
            Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
            QQCircleFeedBase$StFeedBusiReqData busiData = QCirclePluginUtil.getBusiData(feedBlockData);
            Intrinsics.checkNotNullExpressionValue(busiData, "getBusiData(feedBlockData)");
            FeedCloudMeta$StHotTagInfo feedCloudMeta$StHotTagInfo = busiData.hotTagInfo;
            if (feedCloudMeta$StHotTagInfo != null) {
                return feedCloudMeta$StHotTagInfo.get();
            }
            return null;
        }

        Companion() {
        }
    }

    private final void i1(final FeedCloudMeta$StHotTagInfo hotEventInfo, final FeedCloudMeta$StFeed feed) {
        QLog.d(getTAG(), 1, "show hotEventEntrance, hotEventInfo=" + hotEventInfo);
        View view = this.floatTitleView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
            view = null;
        }
        view.setVisibility(0);
        Drawable drawable = ResourcesCompat.getDrawable(m0().getResources(), R.drawable.nrq, null);
        if (drawable != null) {
            drawable.setBounds(0, 0, ImmersiveUtils.dpToPx(17.5f), ImmersiveUtils.dpToPx(17.5f));
        }
        TextView textView = this.hotEventTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotEventTv");
            textView = null;
        }
        textView.setCompoundDrawables(drawable, null, null, null);
        TextView textView2 = this.hotEventTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotEventTv");
            textView2 = null;
        }
        textView2.setText(hotEventInfo.title.get());
        TextView textView3 = this.rankTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankTv");
            textView3 = null;
        }
        textView3.setText(m0().getResources().getString(R.string.f183563ji, Integer.valueOf(hotEventInfo.rank.get())));
        TextView textView4 = this.desTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("desTv");
            textView4 = null;
        }
        textView4.setText(hotEventInfo.subTitle.get());
        String str = hotEventInfo.f398452id.get();
        Intrinsics.checkNotNullExpressionValue(str, "hotEventInfo.id.get()");
        int i3 = hotEventInfo.rank.get();
        String str2 = hotEventInfo.title.get();
        Intrinsics.checkNotNullExpressionValue(str2, "hotEventInfo.title.get()");
        String str3 = hotEventInfo.subTitle.get();
        Intrinsics.checkNotNullExpressionValue(str3, "hotEventInfo.subTitle.get()");
        Map<String, String> l16 = l1(str, i3, str2, str3);
        TextView textView5 = this.hotEventTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotEventTv");
            textView5 = null;
        }
        p1(textView5, QCircleDaTongConstant.ElementId.EM_XSJ_HOT_TOPIC, l16);
        View view3 = this.rankLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankLayout");
            view3 = null;
        }
        p1(view3, "em_xsj_hot_list", l16);
        TextView textView6 = this.hotEventTv;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotEventTv");
            textView6 = null;
        }
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                ak.j1(FeedCloudMeta$StHotTagInfo.this, this, feed, view4);
            }
        });
        View view4 = this.rankLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankLayout");
        } else {
            view2 = view4;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                ak.k1(FeedCloudMeta$StHotTagInfo.this, this, feed, view5);
            }
        });
        QCircleLpReportDc05507.DataBuilder m16 = m1(hotEventInfo, feed);
        Intrinsics.checkNotNullExpressionValue(m16, "getCommon5507DataBuilder(hotEventInfo, feed)");
        o1(601, 1, m16);
        QCircleLpReportDc05507.DataBuilder m17 = m1(hotEventInfo, feed);
        Intrinsics.checkNotNullExpressionValue(m17, "getCommon5507DataBuilder(hotEventInfo, feed)");
        o1(602, 1, m17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(FeedCloudMeta$StHotTagInfo hotEventInfo, ak this$0, FeedCloudMeta$StFeed feedCloudMeta$StFeed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(hotEventInfo, "$hotEventInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.launcher.c.j0(view.getContext(), new QCircleHotEventPolymerizationBean(HotEventInfoKt.toHotEventInfo(hotEventInfo)));
        QCircleLpReportDc05507.DataBuilder m16 = this$0.m1(hotEventInfo, feedCloudMeta$StFeed);
        Intrinsics.checkNotNullExpressionValue(m16, "getCommon5507DataBuilder(hotEventInfo, feed)");
        this$0.o1(601, 2, m16);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(FeedCloudMeta$StHotTagInfo hotEventInfo, ak this$0, FeedCloudMeta$StFeed feedCloudMeta$StFeed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(hotEventInfo, "$hotEventInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.launcher.c.P(view.getContext(), new QCircleHotEventRankInitBean(HotEventInfoKt.toHotEventInfo(hotEventInfo)));
        QCircleLpReportDc05507.DataBuilder m16 = this$0.m1(hotEventInfo, feedCloudMeta$StFeed);
        Intrinsics.checkNotNullExpressionValue(m16, "getCommon5507DataBuilder(hotEventInfo, feed)");
        this$0.o1(602, 2, m16);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Map<String, String> l1(String eventId, int rank, String name, String subTitle) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TOPIC_ID, eventId), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TOPIC_NAME, name), TuplesKt.to("xsj_hot_topic_index", String.valueOf(rank)), TuplesKt.to("xsj_hot_topic_vv", subTitle));
        return mapOf;
    }

    private final QCircleLpReportDc05507.DataBuilder m1(FeedCloudMeta$StHotTagInfo hotEventInfo, FeedCloudMeta$StFeed feed) {
        return ua0.c.c(feed).setPageId(y0()).setExt2(hotEventInfo.f398452id.get()).setExt4(String.valueOf(hotEventInfo.rank.get()));
    }

    private final void o1(int actionType, int subActionType, QCircleLpReportDc05507.DataBuilder builder) {
        builder.setActionType(actionType);
        builder.setSubActionType(subActionType);
        builder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05507.report(builder);
    }

    private final void p1(View view, String eid, Map<String, String> params) {
        VideoReport.setElementId(view, eid);
        VideoReport.setElementParams(view, params);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        ((ViewStub) rootView.findViewById(R.id.f43801ng)).inflate();
        View findViewById = rootView.findViewById(R.id.vaz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.float_title_layout)");
        this.floatTitleView = findViewById;
        View view = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
            findViewById = null;
        }
        View findViewById2 = findViewById.findViewById(R.id.jq_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "floatTitleView.findViewById(R.id.title_tv)");
        this.hotEventTv = (TextView) findViewById2;
        View view2 = this.floatTitleView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.f70453lh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "floatTitleView.findViewById(R.id.rank_tv)");
        this.rankTv = (TextView) findViewById3;
        View view3 = this.floatTitleView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.bgr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "floatTitleView.findViewById(R.id.desc_tv)");
        this.desTv = (TextView) findViewById4;
        View view4 = this.floatTitleView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
            view4 = null;
        }
        View findViewById5 = view4.findViewById(R.id.f70193ks);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "floatTitleView.findViewB\u2026d(R.id.rank_click_layout)");
        this.rankLayout = findViewById5;
        View view5 = this.floatTitleView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
            view5 = null;
        }
        ViewGroup.LayoutParams layoutParams = view5.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            int a16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.i.INSTANCE.a() - DisplayUtil.getTopHeight(m0());
            View view6 = this.floatTitleView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
                view6 = null;
            }
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, a16, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view6.setLayoutParams(marginLayoutParams);
        }
        View view7 = this.floatTitleView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
        } else {
            view = view7;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        Companion companion = INSTANCE;
        e30.b mFeedBlockData = this.E;
        Intrinsics.checkNotNullExpressionValue(mFeedBlockData, "mFeedBlockData");
        FeedCloudMeta$StHotTagInfo a16 = companion.a(mFeedBlockData);
        boolean z16 = false;
        if (a16 != null && a16.has()) {
            z16 = true;
        }
        if (!z16) {
            View view = this.floatTitleView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatTitleView");
                view = null;
            }
            view.setVisibility(8);
            QLog.d(getTAG(), 1, "hotEventInfo is null, hide hotEventEntrance");
            return;
        }
        i1(a16, data);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildHotEventFloatTitlePresenter";
    }
}
