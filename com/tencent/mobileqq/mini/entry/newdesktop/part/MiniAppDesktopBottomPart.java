package com.tencent.mobileqq.mini.entry.newdesktop.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
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
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopEffect;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.az;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010+\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010'\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u00103\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u00105\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u0015H\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010:\u001a\u0002092\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u000209H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopBottomPart;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopAbstractPart;", "()V", "mAddSubLayout", "Landroid/widget/LinearLayout;", "mCollapseDesktopImage", "Landroid/widget/ImageView;", "mDeleteAndAddSubLayout", "mDeleteAndAddSubLayoutType", "", "mDeleteSubLayout", "mDeleteTv", "Landroid/widget/TextView;", "mDesktopDeleteLayout", "Landroid/widget/RelativeLayout;", "mDesktopDeleteMirrorView", "Landroid/view/View;", "mMoreAddTv", "mMoreDeleteTv", "mMoveUpGuide", "actionDragEnterAddMiniApp", "", "event", "Landroid/view/DragEvent;", "compatibleNavigationBar", "getBottomPartPageType", "getLogTag", "", "initBottomUI", "initCollapseDesktopBlurView", "mainPageDragDrop", "view", "mainPageDragEnded", "mainPageDragEntered", "mainPageDragExited", "mainPageDragStart", "animationListener", "Landroid/view/animation/Animation$AnimationListener;", "onAccountChanged", "uiState", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnAccountChanged;", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onPartPause", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "onPartResume", "onPostThemeChanged", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnPostThemeChanged;", "recentMiniAppSubPageDragDrop", "recentMiniAppSubPageDragEnded", "recentMiniAppSubPageDragEntered", "recentMiniAppSubPageDragExited", "recentMiniAppSubPageDragLocation", "setDraggingListener", "setLiveDataObserver", "setMainPageDraggingListener", "", "setRecentMiniAppSubPageDraggingListener", "studyModeChange", "isStudyMode", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDesktopBottomPart extends MiniAppDesktopAbstractPart {
    private static final int BOTTOM_PART_MAIN_DESKTOP_APP_PAGE = 0;
    private static final int BOTTOM_PART_SUB_RECENT_APP_PAGE = 1;
    private static final int SUB_LAYOUT_ADD_TYPE = 2;
    private static final int SUB_LAYOUT_DELETE_TYPE = 1;
    private static final int SUB_LAYOUT_NONE_TYPE = -1;
    private LinearLayout mAddSubLayout;
    private ImageView mCollapseDesktopImage;
    private LinearLayout mDeleteAndAddSubLayout;
    private int mDeleteAndAddSubLayoutType = -1;
    private LinearLayout mDeleteSubLayout;
    private TextView mDeleteTv;
    private RelativeLayout mDesktopDeleteLayout;
    private View mDesktopDeleteMirrorView;
    private TextView mMoreAddTv;
    private TextView mMoreDeleteTv;
    private RelativeLayout mMoveUpGuide;

    private final void actionDragEnterAddMiniApp(DragEvent event) {
        LinearLayout linearLayout = this.mAddSubLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddSubLayout");
            linearLayout = null;
        }
        linearLayout.setBackgroundResource(R.drawable.jy5);
        TextView textView2 = this.mMoreAddTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreAddTv");
            textView2 = null;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.f213415q5));
        TextView textView3 = this.mMoreAddTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreAddTv");
        } else {
            textView = textView3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jxz, 0, 0);
        MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        companion.updateDragShadow((MiniAppDragData) localState, R.drawable.ho9, 0);
    }

    private final void compatibleNavigationBar() {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
            relativeLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        View view = this.mDesktopDeleteMirrorView;
        ViewGroup.LayoutParams layoutParams3 = view != null ? view.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        if (az.e(getContext())) {
            layoutParams2.bottomMargin = r3;
            layoutParams4.bottomMargin = r3;
        } else {
            layoutParams2.bottomMargin = 0;
            layoutParams4.bottomMargin = 0;
        }
        RelativeLayout relativeLayout3 = this.mDesktopDeleteLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.setLayoutParams(layoutParams2);
        View view2 = this.mDesktopDeleteMirrorView;
        if (view2 == null) {
            return;
        }
        view2.setLayoutParams(layoutParams4);
    }

    private final int getBottomPartPageType(DragEvent event) {
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        MiniAppDragData miniAppDragData = (MiniAppDragData) localState;
        return (miniAppDragData.getStartRv().getId() == R.id.rfb && Intrinsics.areEqual(miniAppDragData.getStartRv().getTag(), (Object) 1)) ? 1 : 0;
    }

    private final void initBottomUI() {
        View findViewById = getPartRootView().findViewById(R.id.rcv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.delete_layout)");
        this.mDesktopDeleteLayout = (RelativeLayout) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.ret);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.ll_more_delete_add)");
        this.mDeleteAndAddSubLayout = (LinearLayout) findViewById2;
        View findViewById3 = getPartRootView().findViewById(R.id.rer);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.ll_more_add)");
        this.mAddSubLayout = (LinearLayout) findViewById3;
        View findViewById4 = getPartRootView().findViewById(R.id.res);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.ll_more_delete)");
        this.mDeleteSubLayout = (LinearLayout) findViewById4;
        View findViewById5 = getPartRootView().findViewById(R.id.rgx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.mini_app_move_up_guide)");
        this.mMoveUpGuide = (RelativeLayout) findViewById5;
        View findViewById6 = getPartRootView().findViewById(R.id.rcu);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.deleteText)");
        this.mDeleteTv = (TextView) findViewById6;
        View findViewById7 = getPartRootView().findViewById(R.id.f163703rk0);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.more_add)");
        this.mMoreAddTv = (TextView) findViewById7;
        View findViewById8 = getPartRootView().findViewById(R.id.f163704rk1);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.more_delete)");
        this.mMoreDeleteTv = (TextView) findViewById8;
        this.mDesktopDeleteMirrorView = getPartRootView().findViewById(R.id.rcw);
        this.mCollapseDesktopImage = (ImageView) getPartRootView().findViewById(R.id.rgy);
        RelativeLayout relativeLayout = this.mMoveUpGuide;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoveUpGuide");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        setDraggingListener();
        RelativeLayout relativeLayout3 = this.mMoveUpGuide;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoveUpGuide");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppDesktopBottomPart.initBottomUI$lambda$1(MiniAppDesktopBottomPart.this, view);
            }
        });
        compatibleNavigationBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBottomUI$lambda$1(MiniAppDesktopBottomPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPartHost partHost = this$0.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost");
        ((MiniAppDesktopPartHost) partHost).hideMiniAppEntry(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initCollapseDesktopBlurView() {
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        RelativeLayout relativeLayout = this.mMoveUpGuide;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoveUpGuide");
            relativeLayout = null;
        }
        com.tencent.mobileqq.qui.b.d(bVar, relativeLayout, 0, 2, null);
        ImageView imageView = this.mCollapseDesktopImage;
        RFWNavigationBarImmersiveHelper.ImmersiveType immersiveType = RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE;
        bVar.a(imageView, immersiveType);
        bVar.a(getPartRootView().findViewById(R.id.rf9), immersiveType);
    }

    private final void mainPageDragDrop(final View view, DragEvent event) {
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        final MiniAppDragData miniAppDragData = (MiniAppDragData) localState;
        miniAppDragData.getStartViewHolder().itemView.setVisibility(0);
        if (MiniAppDragHelper.INSTANCE.isNeedStartDragViewVisible().compareAndSet(true, false)) {
            QLog.i(getTAG(), 1, "MiniAppDragHelper.isNeedStartDragViewVisible.compareAndSet(true, false)");
        }
        getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopBottomPart$mainPageDragDrop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDesktopEffect invoke() {
                return new MiniAppDesktopEffect.OnBottomPartDragDropDelete(MiniAppDragData.this.getStartRv().getId(), view.getId(), MiniAppDragData.this.getFromPosition(), MiniAppDragData.this.getFromDesktopAppInfo());
            }
        });
    }

    private final void mainPageDragEnded(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        TextView textView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        MiniAppDragData miniAppDragData = (MiniAppDragData) localState;
        MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
        if (companion.isNeedStartDragViewVisible().compareAndSet(true, false)) {
            QLog.i(getTAG(), 1, "MiniAppDragHelper.isNeedStartDragViewVisible.compareAndSet(true, false)");
        } else {
            miniAppDragData.getStartViewHolder().itemView.setVisibility(0);
        }
        RelativeLayout relativeLayout2 = this.mDesktopDeleteLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
            relativeLayout2 = null;
        }
        relativeLayout2.setBackgroundResource(R.drawable.jy8);
        TextView textView2 = this.mDeleteTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteTv");
            textView2 = null;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.o6v));
        TextView textView3 = this.mDeleteTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteTv");
        } else {
            textView = textView3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ho6, 0, 0, 0);
        Object localState2 = event.getLocalState();
        Intrinsics.checkNotNull(localState2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        companion.updateDragShadow((MiniAppDragData) localState2, -1, 4);
        this.mDeleteAndAddSubLayoutType = -1;
    }

    private final void mainPageDragEntered(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        TextView textView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
            relativeLayout = null;
        }
        relativeLayout.setBackgroundResource(R.drawable.hce);
        TextView textView2 = this.mDeleteTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteTv");
            textView2 = null;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ho7, 0, 0, 0);
        TextView textView3 = this.mDeleteTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteTv");
        } else {
            textView = textView3;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.o6w));
        MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        companion.updateDragShadow((MiniAppDragData) localState, R.drawable.ho8, 0);
    }

    private final void mainPageDragExited(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        TextView textView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
            relativeLayout = null;
        }
        relativeLayout.setBackgroundResource(R.drawable.jy8);
        TextView textView2 = this.mDeleteTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteTv");
            textView2 = null;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.o6v));
        TextView textView3 = this.mDeleteTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteTv");
        } else {
            textView = textView3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ho6, 0, 0, 0);
        MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        companion.updateDragShadow((MiniAppDragData) localState, -1, 4);
    }

    private final void mainPageDragStart(Animation.AnimationListener animationListener) {
        int dpToPx;
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout3 = this.mDesktopDeleteLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        if (relativeLayout2.getHeight() > 0) {
            dpToPx = relativeLayout2.getHeight();
        } else {
            dpToPx = ViewUtils.dpToPx(65.0f);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, dpToPx, 0.0f);
        translateAnimation.setAnimationListener(animationListener);
        translateAnimation.setDuration(200L);
        relativeLayout2.setAnimation(translateAnimation);
        translateAnimation.start();
    }

    private final void recentMiniAppSubPageDragDrop(final View view, DragEvent event) {
        if (MiniAppDragHelper.INSTANCE.isNeedStartDragViewVisible().compareAndSet(true, false)) {
            QLog.i(getTAG(), 1, "MiniAppDragHelper.isNeedStartDragViewVisible.compareAndSet(true, false)");
        }
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        final MiniAppDragData miniAppDragData = (MiniAppDragData) localState;
        miniAppDragData.getStartViewHolder().itemView.setVisibility(0);
        if (this.mDeleteAndAddSubLayoutType == 2) {
            getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopBottomPart$recentMiniAppSubPageDragDrop$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MiniAppDesktopEffect invoke() {
                    return new MiniAppDesktopEffect.OnBottomPartDragDropAdd(MiniAppDragData.this.getFromDesktopAppInfo());
                }
            });
        } else {
            getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopBottomPart$recentMiniAppSubPageDragDrop$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MiniAppDesktopEffect invoke() {
                    return new MiniAppDesktopEffect.OnBottomPartDragDropDelete(MiniAppDragData.this.getStartRv().getId(), view.getId(), MiniAppDragData.this.getFromPosition(), MiniAppDragData.this.getFromDesktopAppInfo());
                }
            });
        }
    }

    private final void recentMiniAppSubPageDragEnded(DragEvent event) {
        RelativeLayout relativeLayout = this.mDesktopDeleteLayout;
        TextView textView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        MiniAppDragData miniAppDragData = (MiniAppDragData) localState;
        MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
        if (companion.isNeedStartDragViewVisible().compareAndSet(false, true)) {
            QLog.i(getTAG(), 1, "MiniAppDragHelper.isNeedStartDragViewVisible.compareAndSet(false, true)");
        } else {
            miniAppDragData.getStartViewHolder().itemView.setVisibility(0);
        }
        LinearLayout linearLayout = this.mAddSubLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddSubLayout");
            linearLayout = null;
        }
        linearLayout.setBackgroundResource(R.drawable.f161025jy4);
        TextView textView2 = this.mMoreAddTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreAddTv");
            textView2 = null;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.nx5));
        TextView textView3 = this.mMoreAddTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreAddTv");
            textView3 = null;
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jxy, 0, 0);
        LinearLayout linearLayout2 = this.mDeleteSubLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteSubLayout");
            linearLayout2 = null;
        }
        linearLayout2.setBackgroundResource(R.drawable.f161023jy2);
        TextView textView4 = this.mMoreDeleteTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreDeleteTv");
            textView4 = null;
        }
        textView4.setText(HardCodeUtil.qqStr(R.string.o6v));
        TextView textView5 = this.mMoreDeleteTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreDeleteTv");
        } else {
            textView = textView5;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
        Object localState2 = event.getLocalState();
        Intrinsics.checkNotNull(localState2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        companion.updateDragShadow((MiniAppDragData) localState2, -1, 4);
        this.mDeleteAndAddSubLayoutType = -1;
    }

    private final void recentMiniAppSubPageDragEntered(DragEvent event) {
        LinearLayout linearLayout = this.mDeleteSubLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteSubLayout");
            linearLayout = null;
        }
        linearLayout.setBackgroundResource(R.drawable.f161024jy3);
        TextView textView2 = this.mMoreDeleteTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreDeleteTv");
            textView2 = null;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.o6w));
        TextView textView3 = this.mMoreDeleteTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreDeleteTv");
        } else {
            textView = textView3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho7, 0, 0);
        MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        companion.updateDragShadow((MiniAppDragData) localState, R.drawable.ho8, 0);
    }

    private final void recentMiniAppSubPageDragExited(DragEvent event) {
        LinearLayout linearLayout = this.mAddSubLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddSubLayout");
            linearLayout = null;
        }
        linearLayout.setBackgroundResource(R.drawable.f161025jy4);
        TextView textView2 = this.mMoreAddTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreAddTv");
            textView2 = null;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.nx5));
        TextView textView3 = this.mMoreAddTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreAddTv");
            textView3 = null;
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jxy, 0, 0);
        LinearLayout linearLayout2 = this.mDeleteSubLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteSubLayout");
            linearLayout2 = null;
        }
        linearLayout2.setBackgroundResource(R.drawable.f161023jy2);
        TextView textView4 = this.mMoreDeleteTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreDeleteTv");
            textView4 = null;
        }
        textView4.setText(HardCodeUtil.qqStr(R.string.o6v));
        TextView textView5 = this.mMoreDeleteTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreDeleteTv");
        } else {
            textView = textView5;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
        MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        companion.updateDragShadow((MiniAppDragData) localState, -1, 4);
    }

    private final void recentMiniAppSubPageDragLocation(View view, DragEvent event) {
        int width = view.getWidth() / 2;
        TextView textView = null;
        if (event.getX() > 0.0f && event.getX() < width) {
            LinearLayout linearLayout = this.mDeleteSubLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDeleteSubLayout");
                linearLayout = null;
            }
            linearLayout.setBackgroundResource(R.drawable.f161023jy2);
            TextView textView2 = this.mMoreDeleteTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreDeleteTv");
                textView2 = null;
            }
            textView2.setText(HardCodeUtil.qqStr(R.string.o6v));
            TextView textView3 = this.mMoreDeleteTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreDeleteTv");
            } else {
                textView = textView3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ho6, 0, 0);
            this.mDeleteAndAddSubLayoutType = 2;
            actionDragEnterAddMiniApp(event);
            return;
        }
        LinearLayout linearLayout2 = this.mAddSubLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddSubLayout");
            linearLayout2 = null;
        }
        linearLayout2.setBackgroundResource(R.drawable.f161025jy4);
        TextView textView4 = this.mMoreAddTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreAddTv");
            textView4 = null;
        }
        textView4.setText(HardCodeUtil.qqStr(R.string.nx5));
        TextView textView5 = this.mMoreAddTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreAddTv");
        } else {
            textView = textView5;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jxy, 0, 0);
        this.mDeleteAndAddSubLayoutType = 1;
        recentMiniAppSubPageDragEntered(event);
    }

    private final void setDraggingListener() {
        View view = this.mDesktopDeleteMirrorView;
        if (view != null) {
            view.setOnDragListener(new View.OnDragListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.d
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view2, DragEvent dragEvent) {
                    boolean draggingListener$lambda$2;
                    draggingListener$lambda$2 = MiniAppDesktopBottomPart.setDraggingListener$lambda$2(MiniAppDesktopBottomPart.this, view2, dragEvent);
                    return draggingListener$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setDraggingListener$lambda$2(MiniAppDesktopBottomPart this$0, View view, DragEvent dragEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view == null || dragEvent == null || dragEvent.getLocalState() == null || !(dragEvent.getLocalState() instanceof MiniAppDragData)) {
            return false;
        }
        int bottomPartPageType = this$0.getBottomPartPageType(dragEvent);
        if (bottomPartPageType == 0) {
            return this$0.setMainPageDraggingListener(view, dragEvent);
        }
        if (bottomPartPageType != 1) {
            return false;
        }
        return this$0.setRecentMiniAppSubPageDraggingListener(view, dragEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$0(MiniAppDesktopBottomPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppDesktopBottomPart$setLiveDataObserver$1$1(this$0, null), 3, null);
    }

    private final boolean setMainPageDraggingListener(View view, DragEvent event) {
        if (event.getAction() != 2) {
            QLog.i(getTAG(), 1, "\u4e3b\u9875\u5e95\u90e8\u533a\u57df viewId:" + view.getId() + ", action:" + MiniAppDragHelper.INSTANCE.getDragActionString(event.getAction()) + ", view:" + view + ", event:" + event);
        }
        switch (event.getAction()) {
            case 1:
                mainPageDragStart(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopBottomPart$setMainPageDraggingListener$1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        LinearLayout linearLayout;
                        RelativeLayout relativeLayout;
                        linearLayout = MiniAppDesktopBottomPart.this.mDeleteAndAddSubLayout;
                        RelativeLayout relativeLayout2 = null;
                        if (linearLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDeleteAndAddSubLayout");
                            linearLayout = null;
                        }
                        linearLayout.setVisibility(8);
                        relativeLayout = MiniAppDesktopBottomPart.this.mDesktopDeleteLayout;
                        if (relativeLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
                        } else {
                            relativeLayout2 = relativeLayout;
                        }
                        relativeLayout2.setBackgroundResource(R.drawable.hcd);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                return true;
            case 3:
                mainPageDragDrop(view, event);
            case 2:
                return true;
            case 4:
                mainPageDragEnded(event);
                return true;
            case 5:
                mainPageDragEntered(event);
                return true;
            case 6:
                mainPageDragExited(event);
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x004e. Please report as an issue. */
    private final boolean setRecentMiniAppSubPageDraggingListener(View view, DragEvent event) {
        if (event.getAction() != 2) {
            QLog.i(getTAG(), 1, "\u5e95\u90e8\u533a\u57df viewId:" + view.getId() + ", action:" + MiniAppDragHelper.INSTANCE.getDragActionString(event.getAction()) + ", view:" + view + ", event:" + event);
        }
        switch (event.getAction()) {
            case 1:
                mainPageDragStart(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopBottomPart$setRecentMiniAppSubPageDraggingListener$1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        LinearLayout linearLayout;
                        RelativeLayout relativeLayout;
                        linearLayout = MiniAppDesktopBottomPart.this.mDeleteAndAddSubLayout;
                        RelativeLayout relativeLayout2 = null;
                        if (linearLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDeleteAndAddSubLayout");
                            linearLayout = null;
                        }
                        linearLayout.setVisibility(0);
                        relativeLayout = MiniAppDesktopBottomPart.this.mDesktopDeleteLayout;
                        if (relativeLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDesktopDeleteLayout");
                        } else {
                            relativeLayout2 = relativeLayout;
                        }
                        relativeLayout2.setBackgroundResource(0);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                return true;
            case 2:
                recentMiniAppSubPageDragLocation(view, event);
                return true;
            case 3:
                recentMiniAppSubPageDragDrop(view, event);
                return true;
            case 4:
                recentMiniAppSubPageDragEnded(event);
                return true;
            case 6:
                recentMiniAppSubPageDragExited(event);
            case 5:
                return true;
            default:
                return false;
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppDesktopPart.MiniAppDesktopBottomPart";
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void onAccountChanged(MiniAppDeskTopUIState.OnAccountChanged uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        QLog.i(getTAG(), 1, "onAccountChanged");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e(getTAG(), 1, "onInitView rootView is null!");
        } else {
            initBottomUI();
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.i(getTAG(), 1, "onPartPause");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.i(getTAG(), 1, "onPartResume");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void onPostThemeChanged(MiniAppDeskTopUIState.OnPostThemeChanged uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        QLog.i(getTAG(), 1, "onPostThemeChanged");
        initCollapseDesktopBlurView();
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void setLiveDataObserver() {
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopBottomPart.setLiveDataObserver$lambda$0(MiniAppDesktopBottomPart.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void studyModeChange(boolean isStudyMode) {
        QLog.i(getTAG(), 1, "studyModeChange");
    }
}
