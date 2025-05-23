package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.highlight.CommentHighlightAbility;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.widget.CommentItemView;
import com.tencent.mobileqq.guild.feed.util.v;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J(\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014H\u0014J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0019H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/e;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/a;", "Ljl1/b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "", "", "", "r", "", "initListener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "payload", ReportConstant.COSTREPORT_PREFIX, "v", NodeProps.ON_CLICK, "", NodeProps.ON_LONG_CLICK, NodeProps.VISIBLE, "onVisibleChanged", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/widget/CommentItemView;", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/widget/CommentItemView;", "itemView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends a<jl1.b> implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommentItemView itemView;

    private final void initListener() {
        CommentItemView commentItemView = this.itemView;
        CommentItemView commentItemView2 = null;
        if (commentItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            commentItemView = null;
        }
        commentItemView.setOnClickListener(this);
        CommentItemView commentItemView3 = this.itemView;
        if (commentItemView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
        } else {
            commentItemView2 = commentItemView3;
        }
        commentItemView2.setOnLongClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        CommentItemView commentItemView;
        Map map;
        GProStComment commentData;
        CommentItemView commentItemView2 = this.itemView;
        String str = null;
        if (commentItemView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            commentItemView = null;
        } else {
            commentItemView = commentItemView2;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        map = MapsKt__MapsKt.toMap(r());
        com.tencent.mobileqq.guild.feed.report.d.d(commentItemView, "em_sgrp_comment_reply", clickPolicy, exposurePolicy, endExposurePolicy, map);
        CommentItemView commentItemView3 = this.itemView;
        if (commentItemView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            commentItemView3 = null;
        }
        jl1.b bVar = (jl1.b) this.mData;
        if (bVar != null && (commentData = bVar.getCommentData()) != null) {
            str = commentData.idd;
        }
        VideoReport.setElementReuseIdentifier(commentItemView3, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, Object> r() {
        String str;
        GProStComment commentData;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_type", (short) 1);
        jl1.b bVar = (jl1.b) this.mData;
        if (bVar != null && (commentData = bVar.getCommentData()) != null) {
            str = commentData.idd;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "mData?.commentData?.idd?:\"\"");
        }
        linkedHashMap.put("sgrp_target_comment_id", str);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        GProStComment commentData;
        vl1.a p16;
        vl1.a p17;
        EventCollector.getInstance().onViewClickedBefore(v3);
        CommentItemView commentItemView = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.w8m && !v.a().b(v3)) {
            int sendStatus = ((jl1.b) this.mData).getSendStatus();
            if (sendStatus != 0) {
                if (sendStatus == 2 && (p17 = p()) != null) {
                    T mData = this.mData;
                    Intrinsics.checkNotNullExpressionValue(mData, "mData");
                    p17.q6((hl1.g) mData, this.mPosition);
                }
            } else {
                jl1.b bVar = (jl1.b) this.mData;
                if (bVar != null && (commentData = bVar.getCommentData()) != null && (p16 = p()) != null) {
                    p16.H1(new ReplyCommentArgs(1, commentData, null, Integer.valueOf(this.mPosition), false, 16, null));
                }
                CommentItemView commentItemView2 = this.itemView;
                if (commentItemView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemView");
                } else {
                    commentItemView = commentItemView2;
                }
                VideoReport.reportEvent("dt_clck", commentItemView, r());
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.itemView = (CommentItemView) containerView;
        initListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        boolean z16 = false;
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard") && ((jl1.b) this.mData).getSendStatus() == 0) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.w8m) {
                vl1.a p16 = p();
                if (p16 != null) {
                    T mData = this.mData;
                    Intrinsics.checkNotNullExpressionValue(mData, "mData");
                    p16.A6((hl1.g) mData, this.mPosition);
                }
                z16 = true;
            }
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        String str;
        vl1.a p16;
        GProStComment commentData;
        super.onVisibleChanged(visible);
        if (visible) {
            jl1.b bVar = (jl1.b) this.mData;
            if (bVar != null && (commentData = bVar.getCommentData()) != null) {
                str = commentData.idd;
            } else {
                str = null;
            }
            if (str != null && (p16 = p()) != null) {
                p16.G0(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull jl1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        CommentHighlightAbility commentHighlightAbility = CommentHighlightAbility.f220918a;
        CommentItemView commentItemView = this.itemView;
        if (commentItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            commentItemView = null;
        }
        commentHighlightAbility.a(commentItemView);
        q();
    }
}
