package com.tencent.mobileqq.mini.entry.expDesktop.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010,\u001a\u00020+2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010-\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u00101\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopBottomPart;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopAbstractPart;", "()V", "mAddSubLayout", "Landroid/widget/LinearLayout;", "mCollapseDesktopImage", "Landroid/widget/ImageView;", "mDeleteAndAddSubLayout", "mDeleteSubLayout", "mDeleteTv", "Landroid/widget/TextView;", "mDesktopDeleteLayout", "Landroid/widget/RelativeLayout;", "mDesktopDeleteMirrorView", "Landroid/view/View;", "mMoreAddTv", "mMoreDeleteTv", "mMoveUpGuide", "Landroid/widget/FrameLayout;", "mOperateType", "", "compatibleNavigationBar", "", "getLogTag", "", "initBottomUI", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onPairBtnDragEntered", "event", "Landroid/view/DragEvent;", "pairBtnDragDrop", "view", "pairBtnDragEnded", "pairBtnDragLocation", "pairBtnDragStart", "pairBtnPageDragExited", "reportBtnExpose", "reportDragOperate", "type", "setDraggingListener", "setLiveDataObserver", "setPairBtnDraggingListener", "", "setSingleBtnDraggingListener", "singleBtnDragDrop", "singleBtnDragEnded", "singleBtnDragEntered", "singleBtnDragExited", "singleBtnDragStart", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopBottomPart extends MiniAppExpDesktopAbstractPart {
    private static final int OPERATE_TYPE_ADD = 2;
    private static final int OPERATE_TYPE_DELETE = 1;
    private static final int OPERATE_TYPE_NOTHING = -1;
    private LinearLayout mAddSubLayout;
    private ImageView mCollapseDesktopImage;
    private LinearLayout mDeleteAndAddSubLayout;
    private LinearLayout mDeleteSubLayout;
    private TextView mDeleteTv;
    private RelativeLayout mDesktopDeleteLayout;
    private View mDesktopDeleteMirrorView;
    private TextView mMoreAddTv;
    private TextView mMoreDeleteTv;
    private FrameLayout mMoveUpGuide;
    private int mOperateType = -1;

    private final void compatibleNavigationBar() {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        ViewGroup.LayoutParams layoutParams = relativeLayout != null ? relativeLayout.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        View view = this.mDesktopDeleteMirrorView;
        ViewGroup.LayoutParams layoutParams3 = view != null ? view.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        int h16 = com.tencent.mobileqq.qui.b.f276860a.h(getContext());
        layoutParams2.bottomMargin = h16;
        layoutParams4.bottomMargin = h16;
        RelativeLayout relativeLayout2 = this.mDesktopDeleteLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setLayoutParams(layoutParams2);
        }
        View view2 = this.mDesktopDeleteMirrorView;
        if (view2 == null) {
            return;
        }
        view2.setLayoutParams(layoutParams4);
    }

    private final void initBottomUI() {
        this.mMoveUpGuide = (FrameLayout) getPartRootView().findViewById(R.id.rgx);
        this.mDesktopDeleteLayout = (RelativeLayout) getPartRootView().findViewById(R.id.rcv);
        this.mDeleteAndAddSubLayout = (LinearLayout) getPartRootView().findViewById(R.id.ret);
        this.mAddSubLayout = (LinearLayout) getPartRootView().findViewById(R.id.rer);
        this.mDeleteSubLayout = (LinearLayout) getPartRootView().findViewById(R.id.res);
        this.mDeleteTv = (TextView) getPartRootView().findViewById(R.id.rcu);
        this.mMoreAddTv = (TextView) getPartRootView().findViewById(R.id.f163703rk0);
        this.mMoreDeleteTv = (TextView) getPartRootView().findViewById(R.id.f163704rk1);
        this.mDesktopDeleteMirrorView = getPartRootView().findViewById(R.id.rcw);
        this.mCollapseDesktopImage = (ImageView) getPartRootView().findViewById(R.id.rgy);
        FrameLayout frameLayout = this.mMoveUpGuide;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        setDraggingListener();
        FrameLayout frameLayout2 = this.mMoveUpGuide;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAppExpDesktopBottomPart.initBottomUI$lambda$0(MiniAppExpDesktopBottomPart.this, view);
                }
            });
        }
        compatibleNavigationBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBottomUI$lambda$0(MiniAppExpDesktopBottomPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPartHost partHost = this$0.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
        ((MiniAppExpDesktopPartHost) partHost).hideMiniAppEntry(1);
    }

    private final void onPairBtnDragEntered(DragEvent event) {
        int i3 = this.mOperateType;
        if (i3 == 1) {
            LinearLayout linearLayout = this.mDeleteSubLayout;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.f161024jy3);
            }
            TextView textView = this.mMoreDeleteTv;
            if (textView != null) {
                textView.setText(HardCodeUtil.qqStr(R.string.o6w));
            }
            TextView textView2 = this.mMoreDeleteTv;
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho7, 0, 0);
            }
            MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
            Object localState = event.getLocalState();
            Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
            companion.updateDragShadow((MiniAppExpDragData) localState, R.drawable.ho8, 0);
            return;
        }
        if (i3 != 2) {
            MiniAppExpDragHelper.Companion companion2 = MiniAppExpDragHelper.INSTANCE;
            Object localState2 = event.getLocalState();
            Intrinsics.checkNotNull(localState2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
            companion2.updateDragShadow((MiniAppExpDragData) localState2, -1, 4);
            return;
        }
        LinearLayout linearLayout2 = this.mAddSubLayout;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundResource(R.drawable.jy5);
        }
        TextView textView3 = this.mMoreAddTv;
        if (textView3 != null) {
            textView3.setText(HardCodeUtil.qqStr(R.string.f213415q5));
        }
        TextView textView4 = this.mMoreAddTv;
        if (textView4 != null) {
            textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jxz, 0, 0);
        }
        MiniAppExpDragHelper.Companion companion3 = MiniAppExpDragHelper.INSTANCE;
        Object localState3 = event.getLocalState();
        Intrinsics.checkNotNull(localState3, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        companion3.updateDragShadow((MiniAppExpDragData) localState3, R.drawable.ho9, 0);
    }

    private final void pairBtnDragDrop(final View view, DragEvent event) {
        MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
        if (companion.isNeedStartDragViewVisible().compareAndSet(true, false)) {
            QLog.i(getTAG(), 1, "MiniAppExpDesktopDragHelper.isNeedStartDragViewVisible.compareAndSet(true, false)");
        }
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        final MiniAppExpDragData miniAppExpDragData = (MiniAppExpDragData) localState;
        companion.resetDraggingViewState(miniAppExpDragData);
        int i3 = this.mOperateType;
        if (i3 == 1) {
            getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopBottomPart$pairBtnDragDrop$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MiniAppExpDesktopEffect invoke() {
                    return new MiniAppExpDesktopEffect.OnBottomPartDragDropDelete(MiniAppExpDragData.this.getStartRv().getId(), view.getId(), MiniAppExpDragData.this.getFromPosition(), MiniAppExpDragData.this.getFromDesktopAppInfo());
                }
            });
        } else if (i3 != 2) {
            QLog.i(getTAG(), 1, "pairBtnDragDrop operate nothing");
        } else {
            getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopBottomPart$pairBtnDragDrop$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MiniAppExpDesktopEffect invoke() {
                    return new MiniAppExpDesktopEffect.OnBottomPartDragDropAdd(MiniAppExpDragData.this.getFromDesktopAppInfo());
                }
            });
        }
        reportDragOperate(this.mOperateType, event);
    }

    private final void pairBtnDragEnded(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        MiniAppExpDragData miniAppExpDragData = (MiniAppExpDragData) localState;
        MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
        if (companion.isNeedStartDragViewVisible().compareAndSet(false, true)) {
            QLog.i(getTAG(), 1, "MiniAppExpDesktopDragHelper.isNeedStartDragViewVisible.compareAndSet(false, true)");
        } else {
            companion.resetDraggingViewState(miniAppExpDragData);
        }
        LinearLayout linearLayout = this.mAddSubLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(R.drawable.f161025jy4);
        }
        TextView textView = this.mMoreAddTv;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.nx5));
        }
        TextView textView2 = this.mMoreAddTv;
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jxy, 0, 0);
        }
        LinearLayout linearLayout2 = this.mDeleteSubLayout;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundResource(R.drawable.f161023jy2);
        }
        TextView textView3 = this.mMoreDeleteTv;
        if (textView3 != null) {
            textView3.setText(HardCodeUtil.qqStr(R.string.o6v));
        }
        TextView textView4 = this.mMoreDeleteTv;
        if (textView4 != null) {
            textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
        }
        Object localState2 = event.getLocalState();
        Intrinsics.checkNotNull(localState2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        companion.updateDragShadow((MiniAppExpDragData) localState2, -1, 4);
        this.mOperateType = -1;
    }

    private final void pairBtnDragLocation(View view, DragEvent event) {
        int width = view.getWidth() / 2;
        if (event.getX() > 0.0f && event.getX() < width) {
            LinearLayout linearLayout = this.mDeleteSubLayout;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.f161023jy2);
            }
            TextView textView = this.mMoreDeleteTv;
            if (textView != null) {
                textView.setText(HardCodeUtil.qqStr(R.string.o6v));
            }
            TextView textView2 = this.mMoreDeleteTv;
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
            }
            if (this.mOperateType != 2) {
                MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                companion.doVibrator(context);
            }
            this.mOperateType = 2;
            onPairBtnDragEntered(event);
            return;
        }
        LinearLayout linearLayout2 = this.mAddSubLayout;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundResource(R.drawable.f161025jy4);
        }
        TextView textView3 = this.mMoreAddTv;
        if (textView3 != null) {
            textView3.setText(HardCodeUtil.qqStr(R.string.nx5));
        }
        TextView textView4 = this.mMoreAddTv;
        if (textView4 != null) {
            textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jxy, 0, 0);
        }
        if (this.mOperateType != 1) {
            MiniAppExpDragHelper.Companion companion2 = MiniAppExpDragHelper.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            companion2.doVibrator(context2);
        }
        this.mOperateType = 1;
        onPairBtnDragEntered(event);
    }

    private final void pairBtnDragStart(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        LinearLayout linearLayout = this.mDeleteAndAddSubLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        RelativeLayout relativeLayout2 = this.mDesktopDeleteLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(0);
        }
    }

    private final void pairBtnPageDragExited(DragEvent event) {
        LinearLayout linearLayout = this.mAddSubLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(R.drawable.f161025jy4);
        }
        TextView textView = this.mMoreAddTv;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.nx5));
        }
        TextView textView2 = this.mMoreAddTv;
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jxy, 0, 0);
        }
        LinearLayout linearLayout2 = this.mDeleteSubLayout;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundResource(R.drawable.f161023jy2);
        }
        TextView textView3 = this.mMoreDeleteTv;
        if (textView3 != null) {
            textView3.setText(HardCodeUtil.qqStr(R.string.o6v));
        }
        TextView textView4 = this.mMoreDeleteTv;
        if (textView4 != null) {
            textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
        }
        MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        companion.updateDragShadow((MiniAppExpDragData) localState, -1, 4);
    }

    private final void reportBtnExpose(DragEvent event) {
        Object localState = event.getLocalState();
        MiniAppExpDragData miniAppExpDragData = localState instanceof MiniAppExpDragData ? (MiniAppExpDragData) localState : null;
        if (miniAppExpDragData == null) {
            return;
        }
        DesktopAppInfo fromDesktopAppInfo = miniAppExpDragData.getFromDesktopAppInfo();
        DesktopAppInfo desktopAppInfo = fromDesktopAppInfo instanceof DesktopAppInfo ? fromDesktopAppInfo : null;
        if (desktopAppInfo != null) {
            MiniAppExpDesktop04239ReportHelper.reportWithAppInfo$default(MiniAppExpDesktop04239ReportHelper.INSTANCE, desktopAppInfo.mMiniAppInfo, null, "em_expo", MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XIALA_KUAIJIE, null, null, null, String.valueOf(miniAppExpDragData.getFromPosition() + 1), 114, null);
        }
    }

    private final void reportDragOperate(int type, DragEvent event) {
        String str;
        Object localState = event.getLocalState();
        String str2 = null;
        MiniAppExpDragData miniAppExpDragData = localState instanceof MiniAppExpDragData ? (MiniAppExpDragData) localState : null;
        if (miniAppExpDragData == null) {
            return;
        }
        if (type == 1) {
            str = MiniAppExpDesktop04239ReportHelper.RESERVES_ACTION_DELETE_MY_MINIAPP;
        } else if (type != 2) {
            str = "";
        } else {
            str = MiniAppExpDesktop04239ReportHelper.RESERVES_ACTION_ADD_MY_MINIAPP;
        }
        String str3 = str;
        DesktopAppInfo fromDesktopAppInfo = miniAppExpDragData.getFromDesktopAppInfo();
        if (!(fromDesktopAppInfo instanceof DesktopAppInfo)) {
            fromDesktopAppInfo = null;
        }
        if (fromDesktopAppInfo != null) {
            int i3 = fromDesktopAppInfo.mModuleType;
            if (i3 == 1) {
                str2 = "1";
            } else if (i3 == 3) {
                str2 = "2";
            }
            MiniAppExpDesktop04239ReportHelper.reportWithAppInfo$default(MiniAppExpDesktop04239ReportHelper.INSTANCE, fromDesktopAppInfo.mMiniAppInfo, null, str3, null, str2, null, null, String.valueOf(miniAppExpDragData.getFromPosition() + 1), 106, null);
        }
    }

    private final void setDraggingListener() {
        View view = this.mDesktopDeleteMirrorView;
        if (view != null) {
            view.setOnDragListener(new View.OnDragListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.c
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view2, DragEvent dragEvent) {
                    boolean draggingListener$lambda$2;
                    draggingListener$lambda$2 = MiniAppExpDesktopBottomPart.setDraggingListener$lambda$2(MiniAppExpDesktopBottomPart.this, view2, dragEvent);
                    return draggingListener$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setDraggingListener$lambda$2(MiniAppExpDesktopBottomPart this$0, View view, DragEvent dragEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view == null || dragEvent == null || dragEvent.getLocalState() == null || !(dragEvent.getLocalState() instanceof MiniAppExpDragData)) {
            return false;
        }
        Object localState = dragEvent.getLocalState();
        MiniAppExpDragData miniAppExpDragData = localState instanceof MiniAppExpDragData ? (MiniAppExpDragData) localState : null;
        if (miniAppExpDragData == null) {
            return false;
        }
        if (miniAppExpDragData.getFromDesktopAppInfo().mModuleType == 3) {
            return this$0.setSingleBtnDraggingListener(view, dragEvent);
        }
        return this$0.setPairBtnDraggingListener(view, dragEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$1(MiniAppExpDesktopBottomPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopBottomPart$setLiveDataObserver$1$1(this$0, null), 3, null);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final boolean setPairBtnDraggingListener(View view, DragEvent event) {
        QLog.d(getTAG(), 4, "setPairBtnDraggingListener event.action:" + event.getAction());
        switch (event.getAction()) {
            case 1:
                pairBtnDragStart(event);
                reportBtnExpose(event);
                return true;
            case 2:
                pairBtnDragLocation(view, event);
                return true;
            case 3:
                pairBtnDragDrop(view, event);
                return true;
            case 4:
                pairBtnDragEnded(event);
                return true;
            case 6:
                pairBtnPageDragExited(event);
            case 5:
                return true;
            default:
                return false;
        }
    }

    private final boolean setSingleBtnDraggingListener(View view, DragEvent event) {
        QLog.d(getTAG(), 4, "setSingleBtnDraggingListener event.action:" + event.getAction());
        switch (event.getAction()) {
            case 1:
                singleBtnDragStart(event);
                reportBtnExpose(event);
                return true;
            case 3:
                singleBtnDragDrop(view, event);
            case 2:
                return true;
            case 4:
                singleBtnDragEnded(event);
                return true;
            case 5:
                singleBtnDragEntered(event);
                return true;
            case 6:
                singleBtnDragExited(event);
                return true;
            default:
                return false;
        }
    }

    private final void singleBtnDragDrop(final View view, DragEvent event) {
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        final MiniAppExpDragData miniAppExpDragData = (MiniAppExpDragData) localState;
        MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
        companion.resetDraggingViewState(miniAppExpDragData);
        if (companion.isNeedStartDragViewVisible().compareAndSet(true, false)) {
            QLog.i(getTAG(), 1, "MiniAppExpDesktopDragHelper.isNeedStartDragViewVisible.compareAndSet(true, false)");
        }
        this.mOperateType = 1;
        getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopBottomPart$singleBtnDragDrop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppExpDesktopEffect invoke() {
                return new MiniAppExpDesktopEffect.OnBottomPartDragDropDelete(MiniAppExpDragData.this.getStartRv().getId(), view.getId(), MiniAppExpDragData.this.getFromPosition(), MiniAppExpDragData.this.getFromDesktopAppInfo());
            }
        });
        reportDragOperate(this.mOperateType, event);
    }

    private final void singleBtnDragEnded(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        MiniAppExpDragData miniAppExpDragData = (MiniAppExpDragData) localState;
        MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
        if (companion.isNeedStartDragViewVisible().compareAndSet(true, false)) {
            QLog.i(getTAG(), 1, "MiniAppExpDesktopDragHelper.isNeedStartDragViewVisible.compareAndSet(true, false)");
        } else {
            companion.resetDraggingViewState(miniAppExpDragData);
        }
        RelativeLayout relativeLayout2 = this.mDesktopDeleteLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.jy8);
        }
        TextView textView = this.mDeleteTv;
        if (textView != null) {
            textView.setCompoundDrawablePadding(com.tencent.biz.qui.quicommon.e.d(getContext(), 0.0f));
        }
        TextView textView2 = this.mDeleteTv;
        if (textView2 != null) {
            textView2.setText(HardCodeUtil.qqStr(R.string.o6v));
        }
        TextView textView3 = this.mDeleteTv;
        if (textView3 != null) {
            textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
        }
        Object localState2 = event.getLocalState();
        Intrinsics.checkNotNull(localState2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        companion.updateDragShadow((MiniAppExpDragData) localState2, -1, 4);
        this.mOperateType = -1;
    }

    private final void singleBtnDragEntered(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.hce);
        }
        TextView textView = this.mDeleteTv;
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho7, 0, 0);
        }
        TextView textView2 = this.mDeleteTv;
        if (textView2 != null) {
            textView2.setCompoundDrawablePadding(com.tencent.biz.qui.quicommon.e.d(getContext(), 0.0f));
        }
        TextView textView3 = this.mDeleteTv;
        if (textView3 != null) {
            textView3.setText(HardCodeUtil.qqStr(R.string.o6w));
        }
        MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.doVibrator(context);
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        companion.updateDragShadow((MiniAppExpDragData) localState, R.drawable.ho8, 0);
    }

    private final void singleBtnDragExited(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.jy8);
        }
        TextView textView = this.mDeleteTv;
        if (textView != null) {
            textView.setCompoundDrawablePadding(com.tencent.biz.qui.quicommon.e.d(getContext(), 0.0f));
        }
        TextView textView2 = this.mDeleteTv;
        if (textView2 != null) {
            textView2.setText(HardCodeUtil.qqStr(R.string.o6v));
        }
        TextView textView3 = this.mDeleteTv;
        if (textView3 != null) {
            textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
        }
        MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
        companion.updateDragShadow((MiniAppExpDragData) localState, -1, 4);
    }

    private final void singleBtnDragStart(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        LinearLayout linearLayout = this.mDeleteAndAddSubLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.mDesktopDeleteLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.hcd);
        }
        TextView textView = this.mDeleteTv;
        if (textView != null) {
            textView.setCompoundDrawablePadding(com.tencent.biz.qui.quicommon.e.d(getContext(), 0.0f));
        }
        TextView textView2 = this.mDeleteTv;
        if (textView2 != null) {
            textView2.setText(HardCodeUtil.qqStr(R.string.o6v));
        }
        TextView textView3 = this.mDeleteTv;
        if (textView3 != null) {
            textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppExpDesktopPart.MiniAppExpDesktopBottomPart";
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e(getTAG(), 1, "onInitView rootView is null!");
        } else {
            initBottomUI();
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartResume(Activity activity) {
        com.tencent.biz.richframework.part.b.d(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void setLiveDataObserver() {
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopBottomPart.setLiveDataObserver$lambda$1(MiniAppExpDesktopBottomPart.this);
            }
        });
    }
}
