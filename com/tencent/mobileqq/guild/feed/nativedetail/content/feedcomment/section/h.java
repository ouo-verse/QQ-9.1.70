package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J(\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/h;", "Lhl1/b;", "Ljl1/f;", "Lvl1/b;", "u", "", ReportConstant.COSTREPORT_PREFIX, "", "", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "v", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "commentTv", "Landroid/widget/RadioGroup;", "e", "Landroid/widget/RadioGroup;", "rankingContainer", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends hl1.b<jl1.f> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView commentTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RadioGroup rankingContainer;

    private final void q() {
        Map emptyMap;
        RadioGroup radioGroup = this.rankingContainer;
        if (radioGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingContainer");
            radioGroup = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        emptyMap = MapsKt__MapsKt.emptyMap();
        com.tencent.mobileqq.guild.feed.report.d.e(radioGroup, "em_sgrp_forum_sort", clickPolicy, exposurePolicy, endExposurePolicy, emptyMap, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.g
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map r16;
                r16 = h.r(h.this, str);
                return r16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map r(h this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.t();
    }

    private final int s() {
        vl1.b u16 = u();
        if (u16 != null) {
            return u16.y0();
        }
        return 1;
    }

    private final Map<String, Integer> t() {
        Map<String, Integer> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_sort_type", Integer.valueOf(s())));
        return mutableMapOf;
    }

    private final vl1.b u() {
        return (vl1.b) SectionIOCKt.getIocInterface(this, vl1.b.class);
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
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.w8p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d_feed_detail_comment_tv)");
        this.commentTv = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.w8v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ed_detail_sort_container)");
        RadioGroup radioGroup = (RadioGroup) findViewById2;
        this.rankingContainer = radioGroup;
        if (radioGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingContainer");
            radioGroup = null;
        }
        radioGroup.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull jl1.f data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView textView = this.commentTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTv");
            textView = null;
        }
        textView.setText("\u8bc4\u8bba " + bl1.b.h(bl1.b.f28597a, data.getTotalNum(), null, null, 6, null));
        q();
    }
}
