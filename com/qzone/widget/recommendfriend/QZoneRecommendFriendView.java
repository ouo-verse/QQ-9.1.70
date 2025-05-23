package com.qzone.widget.recommendfriend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.feedx.util.k;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import fo.b;
import gp.c;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0014\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020!8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\"\u001a\u0004\b\f\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006="}, d2 = {"Lcom/qzone/widget/recommendfriend/QZoneRecommendFriendView;", "Landroid/widget/LinearLayout;", "", h.F, "g", "j", "i", "", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "dataList", "a", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "e", "()Landroid/widget/TextView;", "setRecommendTitleView", "(Landroid/widget/TextView;)V", "recommendTitleView", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "f", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "b", "()Lcom/qzone/reborn/widget/QZoneBlankStateView;", "setBlankStateView", "(Lcom/qzone/reborn/widget/QZoneBlankStateView;)V", "blankStateView", "Lgp/c;", "Lgp/c;", "()Lgp/c;", "setRecommendFriendAdapter", "(Lgp/c;)V", "recommendFriendAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "c", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "setConcatAdapter", "(Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;)V", "concatAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getRecommendList", "()Ljava/util/List;", "setRecommendList", "(Ljava/util/List;)V", "recommendList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneRecommendFriendView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public TextView recommendTitleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public QZoneBlankStateView blankStateView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public c recommendFriendAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public RFWConcatAdapter concatAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<? extends MayKnowRecommend> recommendList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneRecommendFriendView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void h() {
        setRecommendFriendAdapter(new c());
        setConcatAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{d()}));
        f().setAdapter(c());
        f().setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private final void j() {
        HashMap hashMap = new HashMap();
        hashMap.put(WidgetCacheConstellationData.NUM, Integer.valueOf(this.recommendList.size()));
        fo.c.o(e(), "em_qz_possible_acquaintance_module", new b().l(hashMap).k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_NONE));
    }

    public final void a(List<? extends MayKnowRecommend> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.recommendList = dataList;
        if (dataList.isEmpty()) {
            f().setVisibility(8);
            b().setVisibility(0);
            b().s0();
        } else {
            f().setVisibility(0);
            b().setVisibility(8);
            d().setItems(dataList);
            d().notifyDataSetChanged();
        }
        j();
    }

    public final QZoneBlankStateView b() {
        QZoneBlankStateView qZoneBlankStateView = this.blankStateView;
        if (qZoneBlankStateView != null) {
            return qZoneBlankStateView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blankStateView");
        return null;
    }

    public final RFWConcatAdapter c() {
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter != null) {
            return rFWConcatAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        return null;
    }

    public final c d() {
        c cVar = this.recommendFriendAdapter;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recommendFriendAdapter");
        return null;
    }

    public final TextView e() {
        TextView textView = this.recommendTitleView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recommendTitleView");
        return null;
    }

    public final RecyclerView f() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void i() {
        LayoutInflater.from(getContext()).inflate(R.layout.cnt, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.n_n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_recommend_friend_title)");
        setRecommendTitleView((TextView) findViewById);
        View findViewById2 = findViewById(R.id.n_g);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_recommend_friend_list)");
        setRecyclerView((RecyclerView) findViewById2);
        View findViewById3 = findViewById(R.id.n_8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_recommend_blank_view)");
        setBlankStateView((QZoneBlankStateView) findViewById3);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        h();
        g();
    }

    public final void setBlankStateView(QZoneBlankStateView qZoneBlankStateView) {
        Intrinsics.checkNotNullParameter(qZoneBlankStateView, "<set-?>");
        this.blankStateView = qZoneBlankStateView;
    }

    public final void setConcatAdapter(RFWConcatAdapter rFWConcatAdapter) {
        Intrinsics.checkNotNullParameter(rFWConcatAdapter, "<set-?>");
        this.concatAdapter = rFWConcatAdapter;
    }

    public final void setRecommendFriendAdapter(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.recommendFriendAdapter = cVar;
    }

    public final void setRecommendList(List<? extends MayKnowRecommend> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.recommendList = list;
    }

    public final void setRecommendTitleView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.recommendTitleView = textView;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneRecommendFriendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneRecommendFriendView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneRecommendFriendView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<? extends MayKnowRecommend> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.recommendList = emptyList;
        i();
    }

    private final void g() {
        b().setData(k.B(getContext(), l.a(R.string.wbc)));
    }
}
