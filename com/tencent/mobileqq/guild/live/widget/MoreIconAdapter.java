package com.tencent.mobileqq.guild.live.widget;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.z;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0015\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040%\u00a2\u0006\u0004\b-\u0010.J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J0\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/live/widget/MoreIconAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/live/widget/MoreIconViewHolder;", "holder", "Lcom/tencent/mobileqq/guild/live/widget/s;", "data", "", "positon", "", "q0", "n0", "iconRes", "Lcom/airbnb/lottie/LottieAnimationView;", "animView", "y0", "", "content", "Landroid/view/View;", "view", "B0", "p1", "s0", "", "t0", "r0", "elementId", "", "", "params", "z0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "w0", "u0", "x0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "datas", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "stopShareAnimFunc", "<init>", "(Ljava/util/List;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MoreIconAdapter extends RecyclerView.Adapter<MoreIconViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> stopShareAnimFunc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MoreIcon> datas;

    public MoreIconAdapter(@NotNull List<MoreIcon> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this.datas = datas;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void A0(MoreIconAdapter moreIconAdapter, MoreIconViewHolder moreIconViewHolder, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        moreIconAdapter.z0(moreIconViewHolder, str, map);
    }

    private final void B0(String content, View view) {
        int i3;
        Map mapOf;
        Map mapOf2;
        if (Intrinsics.areEqual(content, cw.h(R.string.f147990yd))) {
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_notice_status", Integer.valueOf(t0() ? 1 : 0)));
            VideoReport.reportEvent("clck", view, mapOf2);
        } else if (Intrinsics.areEqual(content, cw.h(R.string.f148000ye))) {
            if (r0()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_sub_channel_shortcut_switch", Integer.valueOf(i3)));
            VideoReport.reportEvent("clck", view, mapOf);
        }
    }

    private final void n0(final MoreIconViewHolder holder, final MoreIcon data, final int positon) {
        holder.getIcon().setVisibility(8);
        holder.l().setVisibility(0);
        holder.l().setAnimation(data.getAnimateJson());
        holder.l().addAnimatorListener(new b(holder));
        holder.l().playAnimation();
        this.stopShareAnimFunc = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.live.widget.MoreIconAdapter$animShareIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                Map mapOf;
                list = MoreIconAdapter.this.datas;
                ((MoreIcon) list.get(positon)).g(false);
                LottieAnimationView l3 = holder.l();
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", 5));
                VideoReport.reportEvent("imp_end", l3, mapOf);
                MoreIconAdapter.this.notifyItemChanged(positon);
            }
        };
        ThreadUtils.c(5000L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.live.widget.MoreIconAdapter$animShareIcon$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0 function0;
                function0 = MoreIconAdapter.this.stopShareAnimFunc;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoreIconAdapter.o0(MoreIcon.this, this, holder, view);
            }
        });
        y0(data.getIconRes(), holder.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(MoreIcon data, MoreIconAdapter this$0, MoreIconViewHolder holder, View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (data.getAnimating()) {
            final Function0<Unit> function0 = this$0.stopShareAnimFunc;
            if (function0 != null) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        MoreIconAdapter.p0(Function0.this);
                    }
                });
            }
            this$0.stopShareAnimFunc = null;
            LottieAnimationView l3 = holder.l();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", 5));
            VideoReport.reportEvent("clck", l3, mapOf);
            holder.l().cancelAnimation();
        } else {
            String content = data.getContent();
            View view2 = holder.itemView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) view2).getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "holder.itemView as ViewGroup).getChildAt(0)");
            this$0.B0(content, childAt);
        }
        data.f().invoke(holder);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void q0(MoreIconViewHolder holder, MoreIcon data, int positon) {
        if (data.getIconRes() == R.drawable.guild_live_topbar_share_icon) {
            n0(holder, data, positon);
        }
    }

    private final boolean r0() {
        AppInterface l3 = ch.l();
        if (l3 == null) {
            return false;
        }
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface\n           \u2026va, ProcessConstant.MAIN)");
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        return ((IGPSService) runtimeService).isQQMsgListChannel(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId());
    }

    private final void s0(MoreIconViewHolder holder, int p16) {
        int i3;
        Map<String, ? extends Object> mapOf;
        Map<String, ? extends Object> mapOf2;
        String content = this.datas.get(p16).getContent();
        if (Intrinsics.areEqual(content, cw.h(R.string.f141060fn))) {
            A0(this, holder, "em_sgrp_announcement_entrance", null, 4, null);
            return;
        }
        if (Intrinsics.areEqual(content, cw.h(R.string.f147990yd))) {
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_notice_status", Integer.valueOf(t0() ? 1 : 0)));
            z0(holder, "em_sgrp_notice", mapOf2);
            return;
        }
        if (Intrinsics.areEqual(content, cw.h(R.string.f148000ye))) {
            if (r0()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_sub_channel_shortcut_switch", Integer.valueOf(i3)));
            z0(holder, "em_sgrp_add_shortcut", mapOf);
            return;
        }
        if (Intrinsics.areEqual(content, cw.h(R.string.f147960ya))) {
            A0(this, holder, "em_stream_aio_button", null, 4, null);
            return;
        }
        if (Intrinsics.areEqual(content, cw.h(R.string.f147970yb))) {
            A0(this, holder, "em_stream_aio_fwindow", null, 4, null);
        } else if (Intrinsics.areEqual(content, cw.h(R.string.f147980yc))) {
            A0(this, holder, "em_sgrp_stream_revenue", null, 4, null);
        } else if (Intrinsics.areEqual(content, cw.h(R.string.f147330wl))) {
            A0(this, holder, "em_stream_aio_manage", null, 4, null);
        }
    }

    private final boolean t0() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (gLiveChannelCore.s().getChannelInfo() == null) {
            return false;
        }
        IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
        Intrinsics.checkNotNull(channelInfo);
        if (channelInfo.getFinalMsgNotify() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(MoreIconAdapter this$0, MoreIcon data, MoreIconViewHolder holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        String content = data.getContent();
        View view2 = holder.itemView;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) view2).getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "holder.itemView as ViewGroup).getChildAt(0)");
        this$0.B0(content, childAt);
        data.f().invoke(holder);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y0(int iconRes, LottieAnimationView animView) {
        Map mapOf;
        if (iconRes == R.drawable.guild_live_topbar_share_icon) {
            ch.Y0(animView, "em_sgrp_share_guild_secondary_breathe_logo", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", 5));
            VideoReport.reportEvent("imp", animView, mapOf);
        }
    }

    private final void z0(MoreIconViewHolder holder, String elementId, Map<String, ? extends Object> params) {
        VideoReport.setPageId(holder.itemView, "pg_sgrp_stream_aio");
        VideoReport.setPageParams(holder.itemView, new PageParams(new z().b()));
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) view).getChildAt(0);
        VideoReport.setElementId(childAt, elementId);
        VideoReport.reportEvent("imp", childAt, params);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.datas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final MoreIconViewHolder holder, int positon) {
        float f16;
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MoreIcon moreIcon = this.datas.get(positon);
        holder.getIcon().setImageResource(moreIcon.getIconRes());
        holder.m().setText(moreIcon.getContent());
        ImageView icon = holder.getIcon();
        float f17 = 1.0f;
        if (moreIcon.getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String()) {
            f16 = 1.0f;
        } else {
            f16 = 0.5f;
        }
        icon.setAlpha(f16);
        TextView m3 = holder.m();
        if (!moreIcon.getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String()) {
            f17 = 0.5f;
        }
        m3.setAlpha(f17);
        s0(holder, positon);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoreIconAdapter.v0(MoreIconAdapter.this, moreIcon, holder, view);
            }
        };
        holder.m().setOnClickListener(onClickListener);
        holder.getIcon().setOnClickListener(onClickListener);
        if (moreIcon.getAnimating()) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("MoreIconAdapter", 2, "animateMoreShareIcon");
            }
            if (moreIcon.getAnimateJson().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                q0(holder, moreIcon, positon);
                return;
            }
            return;
        }
        if (!holder.l().isAnimating()) {
            return;
        }
        holder.l().cancelAnimation();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public MoreIconViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ewx, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026em_layout, parent, false)");
        return new MoreIconViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull MoreIconViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        VideoReport.reportEvent("imp_end", ((ViewGroup) view).getChildAt(0), null);
        super.onViewDetachedFromWindow(holder);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/live/widget/MoreIconAdapter$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MoreIconViewHolder f227036d;

        b(MoreIconViewHolder moreIconViewHolder) {
            this.f227036d = moreIconViewHolder;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            this.f227036d.getIcon().setVisibility(0);
            this.f227036d.l().setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
