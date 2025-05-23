package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpecialActivityData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpecialActivityListData;
import com.tencent.mobileqq.guild.discoveryv2.content.view.specialactivity.SpecialActivityCardLinearLayout;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/be;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/u;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "p", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleView", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardLinearLayout;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardLinearLayout;", "activeLayout", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class be extends Section<SpecialActivityListData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView titleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SpecialActivityCardLinearLayout activeLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/be$b", "Lei1/a;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/t;", "specialActivityData", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ei1.a {
        b() {
        }

        @Override // ei1.a
        public void a(@NotNull View view, @NotNull SpecialActivityData specialActivityData) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(specialActivityData, "specialActivityData");
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_title", specialActivityData.getName()), TuplesKt.to("sgrp_url", specialActivityData.getJumpUrl()));
            VideoReport.setElementReuseIdentifier(view, specialActivityData.getName() + "_" + specialActivityData.getJumpUrl());
            bt.d(view, "em_sgrp_special_activity", mapOf, null, null, EndExposurePolicy.REPORT_NONE, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        ViewGroup.LayoutParams layoutParams2 = containerView.getLayoutParams();
        SpecialActivityCardLinearLayout specialActivityCardLinearLayout = null;
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        View findViewById = containerView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.title)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.sae);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.active_layout)");
        SpecialActivityCardLinearLayout specialActivityCardLinearLayout2 = (SpecialActivityCardLinearLayout) findViewById2;
        this.activeLayout = specialActivityCardLinearLayout2;
        if (specialActivityCardLinearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeLayout");
        } else {
            specialActivityCardLinearLayout = specialActivityCardLinearLayout2;
        }
        specialActivityCardLinearLayout.setControl(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull SpecialActivityListData data, int position, @Nullable List<Object> payload) {
        ViewGroup.LayoutParams layoutParams;
        StaggeredGridLayoutManager.LayoutParams layoutParams2;
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.mRootView;
        SpecialActivityCardLinearLayout specialActivityCardLinearLayout = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
        } else {
            layoutParams2 = null;
        }
        if (layoutParams2 != null) {
            layoutParams2.setFullSpan(true);
        }
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        textView.setText(data.getTitle());
        SpecialActivityCardLinearLayout specialActivityCardLinearLayout2 = this.activeLayout;
        if (specialActivityCardLinearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeLayout");
        } else {
            specialActivityCardLinearLayout = specialActivityCardLinearLayout2;
        }
        specialActivityCardLinearLayout.setData(data);
    }
}
