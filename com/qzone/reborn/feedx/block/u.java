package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.reborn.QzoneConciseHeaderView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u0019\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J$\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0014J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010#\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010$\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010%\u001a\u00020\fR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/feedx/block/u;", "Lcom/qzone/reborn/base/m;", "", "radius", "colorRes", "Landroid/graphics/drawable/GradientDrawable;", "o0", "inColor", "outColor", "", "Landroid/graphics/drawable/Drawable;", "p0", "", "n0", "q0", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "block", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "i", "onBindViewHolder", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "r0", "s0", "Lgf/o;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgf/o;", "mQZoneFrameZPlanIoc", "Lcom/qzone/reborn/QzoneConciseHeaderView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/QzoneConciseHeaderView;", "mConciseHeaderView", "<init>", "(Landroid/os/Bundle;Lgf/o;)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class u extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private QzoneConciseHeaderView mConciseHeaderView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private gf.o mQZoneFrameZPlanIoc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/feedx/block/u$b", "Lcom/qzone/reborn/feedx/viewmodel/g;", "", "p4", "Lcom/qzone/common/business/result/QZoneResult;", "result", "i5", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends com.qzone.reborn.feedx.viewmodel.g {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i5(QZoneResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QzoneConciseHeaderView qzoneConciseHeaderView = u.this.mConciseHeaderView;
            if (qzoneConciseHeaderView != null) {
                qzoneConciseHeaderView.z0();
            }
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void p4() {
            u.this.q0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(Bundle bundle, gf.o mQZoneFrameZPlanIoc) {
        super(bundle);
        Intrinsics.checkNotNullParameter(mQZoneFrameZPlanIoc, "mQZoneFrameZPlanIoc");
        this.mQZoneFrameZPlanIoc = mQZoneFrameZPlanIoc;
    }

    private final void n0() {
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.qzone.reborn.feedx.viewmodel.QZoneFriendFeedxDataViewModel");
        ((com.qzone.reborn.feedx.viewmodel.q) viewModel).k2(new b());
    }

    private final Drawable p0(int inColor, int outColor, float radius) {
        return com.tencent.qqnt.util.c.f362979a.a(new int[]{inColor}, outColor, new float[]{radius, radius, radius, radius, 0.0f, 0.0f, 0.0f, 0.0f});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        try {
            QzoneConciseHeaderView qzoneConciseHeaderView = this.mConciseHeaderView;
            if (qzoneConciseHeaderView != null) {
                qzoneConciseHeaderView.refresh();
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ILebaHelperService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
                ((ILebaHelperService) runtimeService).notifyPluginListChanged();
            }
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneFeedxZPlanHeaderBlock", 1, th5);
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> block) {
        if (this.mConciseHeaderView == null) {
            QzoneConciseHeaderView qzoneConciseHeaderView = new QzoneConciseHeaderView(getActivity());
            this.mConciseHeaderView = qzoneConciseHeaderView;
            qzoneConciseHeaderView.v0(this.mQZoneFrameZPlanIoc);
            r0(ef.d.b(16));
        }
        n0();
        QzoneConciseHeaderView qzoneConciseHeaderView2 = this.mConciseHeaderView;
        Intrinsics.checkNotNull(qzoneConciseHeaderView2);
        return qzoneConciseHeaderView2;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder, i3);
        QzoneConciseHeaderView qzoneConciseHeaderView = this.mConciseHeaderView;
        if (qzoneConciseHeaderView != null) {
            qzoneConciseHeaderView.setRefreshParent();
        }
        q0();
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        QzoneConciseHeaderView qzoneConciseHeaderView = this.mConciseHeaderView;
        if (qzoneConciseHeaderView != null) {
            qzoneConciseHeaderView.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        QzoneConciseHeaderView qzoneConciseHeaderView = this.mConciseHeaderView;
        if (qzoneConciseHeaderView != null) {
            qzoneConciseHeaderView.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        QzoneConciseHeaderView qzoneConciseHeaderView = this.mConciseHeaderView;
        if (qzoneConciseHeaderView != null) {
            qzoneConciseHeaderView.y0();
        }
    }

    public final void r0(int radius) {
        if (QQTheme.isVasTheme()) {
            QzoneConciseHeaderView qzoneConciseHeaderView = this.mConciseHeaderView;
            if (qzoneConciseHeaderView == null) {
                return;
            }
            qzoneConciseHeaderView.setBackground(null);
            return;
        }
        MainResourceConfig.Companion companion = MainResourceConfig.INSTANCE;
        if (companion.i() && !((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin())) {
            MainResourceConfig g16 = companion.g();
            QzoneConciseHeaderView qzoneConciseHeaderView2 = this.mConciseHeaderView;
            View r06 = qzoneConciseHeaderView2 != null ? qzoneConciseHeaderView2.r0() : null;
            if (r06 != null) {
                int color = getContext().getColor(R.color.qui_common_fill_light_primary);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                r06.setBackground(p0(color, g16.o(context), radius));
            }
            QzoneConciseHeaderView qzoneConciseHeaderView3 = this.mConciseHeaderView;
            if (qzoneConciseHeaderView3 != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                qzoneConciseHeaderView3.setBackground(new ColorDrawable(g16.o(context2)));
            }
            BlockContainer blockContainer = getBlockContainer();
            if (blockContainer != null) {
                blockContainer.setBackground(o0(radius, R.color.qui_common_bg_bottom_standard));
            }
            BlockContainer blockContainer2 = getBlockContainer();
            NestScrollRecyclerView recyclerView = blockContainer2 != null ? blockContainer2.getRecyclerView() : null;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setBackground(null);
            return;
        }
        QzoneConciseHeaderView qzoneConciseHeaderView4 = this.mConciseHeaderView;
        if (qzoneConciseHeaderView4 != null) {
            qzoneConciseHeaderView4.setBackground(o0(radius, R.color.qui_common_fill_light_primary));
        }
        BlockContainer blockContainer3 = getBlockContainer();
        if (blockContainer3 != null) {
            blockContainer3.setBackground(o0(radius, R.color.qui_common_bg_bottom_standard));
        }
        BlockContainer blockContainer4 = getBlockContainer();
        NestScrollRecyclerView recyclerView2 = blockContainer4 != null ? blockContainer4.getRecyclerView() : null;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setBackground(o0(radius, R.color.qui_common_bg_bottom_standard));
    }

    public final void s0() {
        QzoneConciseHeaderView qzoneConciseHeaderView = this.mConciseHeaderView;
        if (qzoneConciseHeaderView != null) {
            qzoneConciseHeaderView.t();
        }
    }

    private final GradientDrawable o0(int radius, int colorRes) {
        float f16 = radius;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getContext().getColor(colorRes));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
    }
}
