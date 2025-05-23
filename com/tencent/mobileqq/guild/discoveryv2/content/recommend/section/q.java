package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedTopicData;
import com.tencent.mobileqq.guild.discoveryv2.content.view.RecommendTopicItemView;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTopicContent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u000f\u001a\u00020\u0007H\u0016J(\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/q;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/av;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFeedTopicData;", "Lcom/tencent/guild/aio/util/ex/c;", "data", "", "position", "", HippyTKDListViewAdapter.X, "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "onThemeChanged", "", "", "payload", "v", "", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mBg", tl.h.F, "mTitle", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "mTopicList", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class q extends av<RecommendFeedTopicData> implements com.tencent.guild.aio.util.ex.c {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mTopicList;
    private static final int C = QQGuildUIUtil.f(12.0f);

    private final void w() {
        ImageView imageView;
        String str;
        ImageView imageView2;
        String str2;
        com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
        ImageView imageView3 = this.mBg;
        LinearLayout linearLayout = null;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBg");
            imageView = null;
        } else {
            imageView = imageView3;
        }
        GuildThemeManager guildThemeManager = GuildThemeManager.f235286a;
        if (guildThemeManager.b()) {
            str = "https://downv6.qq.com/innovate/guild/sfeed/GuildRecommendTopicBgDark.png";
        } else {
            str = "https://downv6.qq.com/innovate/guild/sfeed/GuildRecommendTopicBgLight.png";
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, str, 0, 0, false, 28, null);
        ImageView imageView4 = this.mTitle;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            imageView2 = null;
        } else {
            imageView2 = imageView4;
        }
        if (guildThemeManager.b()) {
            str2 = "https://downv6.qq.com/innovate/guild/sfeed/GuildRecommendTopicTitleDark.png";
        } else {
            str2 = "https://downv6.qq.com/innovate/guild/sfeed/GuildRecommendTopicTitleLight.png";
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView2, str2, 0, 0, false, 28, null);
        LinearLayout linearLayout2 = this.mTopicList;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopicList");
        } else {
            linearLayout = linearLayout2;
        }
        for (View view : ViewGroupKt.getChildren(linearLayout)) {
            if (view instanceof RecommendTopicItemView) {
                ((RecommendTopicItemView) view).c();
            }
        }
    }

    private final void x(RecommendFeedTopicData data, int position) {
        ArrayList<IGProMVPTopicContent> list = data.getRecommendItem().getContentFeedTopic().getTopicContents();
        if (list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = this.mTopicList;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopicList");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        Intrinsics.checkNotNullExpressionValue(list, "list");
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final IGProMVPTopicContent topic = (IGProMVPTopicContent) obj;
            LinearLayout linearLayout2 = this.mTopicList;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopicList");
                linearLayout2 = null;
            }
            Context context = linearLayout2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mTopicList.context");
            Intrinsics.checkNotNullExpressionValue(topic, "topic");
            RecommendTopicItemView recommendTopicItemView = new RecommendTopicItemView(context, topic);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = C;
            recommendTopicItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.y(q.this, topic, view);
                }
            });
            LinearLayout linearLayout3 = this.mTopicList;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopicList");
                linearLayout3 = null;
            }
            linearLayout3.addView(recommendTopicItemView, layoutParams);
            String valueOf = String.valueOf(topic.hashCode());
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            Map<String, Object> v3 = RecommendReportHelperKt.v(data, position - q().d());
            v3.put("sgrp_topic_id", Long.valueOf(topic.getTopicId()));
            v3.put("sgrp_module_place", Integer.valueOf(i3));
            Unit unit = Unit.INSTANCE;
            com.tencent.mobileqq.guild.discoveryv2.util.b.b(recommendTopicItemView, "em_sgrp_discover_topic_module_list", valueOf, clickPolicy, exposurePolicy, null, v3, null, RecommendReportHelperKt.p(data, i3), 160, null);
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(q this$0, IGProMVPTopicContent topic, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = this$0.p();
        Intrinsics.checkNotNullExpressionValue(topic, "topic");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        p16.n(topic, it, ((RecommendFeedTopicData) this$0.mData).getRecommendExtData().getTraceId());
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.w6v);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ry_v2_recommend_topic_bg)");
            this.mBg = (ImageView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.w6x);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026v2_recommend_topic_title)");
            this.mTitle = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.w6w);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026_v2_recommend_topic_list)");
            this.mTopicList = (LinearLayout) findViewById3;
            getRootView().setOnLongClickListener(this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        boolean i3 = p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, this.mPosition);
        EventCollector.getInstance().onViewLongClicked(v3);
        return i3;
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendFeedTopicData data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        x(data, position);
        w();
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        com.tencent.mobileqq.guild.discoveryv2.util.b.b(rootView, RecommendReportHelperKt.b(data), String.valueOf(data.getItemId()), ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, RecommendReportHelperKt.v(data, position - q().d()), null, null, MsgConstant.KRMFILETHUMBSIZE384, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
    }
}
