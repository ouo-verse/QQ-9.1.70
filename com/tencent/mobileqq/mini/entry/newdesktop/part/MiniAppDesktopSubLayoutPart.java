package com.tencent.mobileqq.mini.entry.newdesktop.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopEffect;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemTouchForDragListener;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppItemCallback;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppItemClickLaunchUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 E2\u00020\u0001:\u0001EB\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140 2\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\u001e\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140 H\u0002J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u001eH\u0002J\u0018\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0002J\u0018\u00107\u001a\u00020\u001e2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0002J\u0006\u00108\u001a\u00020#J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020:H\u0016J\u001a\u0010;\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0002J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00140 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140 H\u0002J\b\u0010@\u001a\u00020\u001eH\u0002J \u0010A\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140 2\b\b\u0002\u0010\"\u001a\u00020#H\u0002J\b\u0010B\u001a\u00020\u001eH\u0002J\b\u0010C\u001a\u00020\u001eH\u0016J\b\u0010D\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopSubLayoutPart;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopAbstractPart;", "()V", "mDragListener", "Landroid/view/View$OnDragListener;", "mLocationFromPosition", "", "mLocationTime", "", "mLocationToPosition", "mSubLayoutBackBtn", "Landroid/widget/ImageView;", "mSubLayoutRoot", "Landroid/widget/LinearLayout;", "mSubLayoutRv", "Landroidx/recyclerview/widget/RecyclerView;", "mSubLayoutRvAdapter", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppSubLayoutRvAdapter;", "mSubLayoutRvDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/ArrayList;", "mSubLayoutTitleRl", "Landroid/widget/RelativeLayout;", "mSubLayoutTitleTv", "Landroid/widget/TextView;", "mSubRvOnItemListener", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppInnerRvItemTouchForDragListener;", HttpMsg.MTYPE, "bindView", "", "dataList", "", "type", "isForceRefresh", "", "closeSubLayout", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "compatibleNavigationBarShow", "findIndexFromMineRv", "fromDesktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getLogTag", "", "handleUiState", "uiState", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "initMiniAppSubPageUI", "myMiniAppSubPageDragDrop", "itemView", "event", "Landroid/view/DragEvent;", "myMiniAppSubPageDragListener", "view", "myMiniAppSubPageDragLocation", "onBackPressed", "onPostThemeChanged", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnPostThemeChanged;", "openSubLayout", QQWinkConstants.TAB_EFFECT, "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$SetSubLayoutDesktopDataList;", "recentMiniAppSubPageDragListener", "remoteGdtMiniAppItem", "setCloseMiniAppSubPageState", "setDataList", "setDragListenerForSubRv", "setLiveDataObserver", "setSubRvOnItemListener", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDesktopSubLayoutPart extends MiniAppDesktopAbstractPart {
    private static final String ANIMATION_ALPHA = "alpha";
    private static final long ANIMATION_DURATION = 400;
    private static final String ANIMATION_TRANSLATION_X = "translationX";
    private static final long REFRESH_TIME_INTERVAL = 300;
    private View.OnDragListener mDragListener;
    private long mLocationTime;
    private ImageView mSubLayoutBackBtn;
    private LinearLayout mSubLayoutRoot;
    private RecyclerView mSubLayoutRv;
    private MiniAppSubLayoutRvAdapter mSubLayoutRvAdapter;
    private RelativeLayout mSubLayoutTitleRl;
    private TextView mSubLayoutTitleTv;
    private MiniAppInnerRvItemTouchForDragListener mSubRvOnItemListener;
    private int mType = -1;
    private ArrayList<DesktopItemInfo> mSubLayoutRvDataList = new ArrayList<>();
    private int mLocationToPosition = -1;
    private int mLocationFromPosition = -1;

    private final void bindView(List<DesktopItemInfo> dataList, int type, boolean isForceRefresh) {
        QLog.i(getTAG(), 1, "SubLayout, RV bindView, type=" + type);
        this.mType = type;
        this.mSubLayoutRvDataList.clear();
        this.mSubLayoutRvDataList.addAll(dataList);
        setDataList(this.mSubLayoutRvDataList, isForceRefresh);
    }

    private final void closeSubLayout(View rootView) {
        LinearLayout linearLayout = this.mSubLayoutRoot;
        Intrinsics.checkNotNull(rootView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, ANIMATION_TRANSLATION_X, 0.0f, rootView.getWidth());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSubLayoutRoot, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat2.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopSubLayoutPart$closeSubLayout$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                QLog.d(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, " --rightOutAnim onAnimationRepeat-- ");
                MiniAppDesktopSubLayoutPart.this.setCloseMiniAppSubPageState();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                QLog.d(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, " --rightOutAnim onAnimationStart-- ");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    private final void compatibleNavigationBarShow() {
        RecyclerView recyclerView = null;
        if (ScreenUtil.checkNavigationBarShow(getContext())) {
            RecyclerView recyclerView2 = this.mSubLayoutRv;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setPadding(ViewUtils.dpToPx(21.0f), ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(21.0f), ViewUtils.dpToPx(100.0f));
            return;
        }
        RecyclerView recyclerView3 = this.mSubLayoutRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.setPadding(ViewUtils.dpToPx(21.0f), ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(21.0f), ViewUtils.dpToPx(80.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int findIndexFromMineRv(DesktopAppInfo fromDesktopAppInfo, List<DesktopItemInfo> dataList) {
        for (DesktopItemInfo desktopItemInfo : dataList) {
            if (desktopItemInfo instanceof DesktopAppInfo) {
                Boolean areItemsTheSame = desktopItemInfo.areItemsTheSame(fromDesktopAppInfo);
                Intrinsics.checkNotNullExpressionValue(areItemsTheSame, "item.areItemsTheSame(fromDesktopAppInfo)");
                if (areItemsTheSame.booleanValue()) {
                    return dataList.indexOf(desktopItemInfo);
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initMiniAppSubPageUI() {
        int roundToInt;
        if (getPartRootView() != null && !MiniAppUtils.isTeenagerMode()) {
            this.mSubLayoutRoot = (LinearLayout) getPartRootView().findViewById(R.id.req);
            View findViewById = getPartRootView().findViewById(R.id.rf_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_entry_sub_navbar_layout)");
            this.mSubLayoutTitleRl = (RelativeLayout) findViewById;
            View findViewById2 = getPartRootView().findViewById(R.id.rhu);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.mini_app_sub_title)");
            this.mSubLayoutTitleTv = (TextView) findViewById2;
            View findViewById3 = getPartRootView().findViewById(R.id.rh6);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_operation_app_back_view)");
            this.mSubLayoutBackBtn = (ImageView) findViewById3;
            View findViewById4 = getPartRootView().findViewById(R.id.rfb);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026icroapp_sub_recyclerview)");
            this.mSubLayoutRv = (RecyclerView) findViewById4;
            LinearLayout linearLayout = this.mSubLayoutRoot;
            ImageView imageView = null;
            if (linearLayout != null) {
                linearLayout.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.qui_common_bg_bottom_light_bg, null));
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(ImmersiveUtils.getStatusBarHeight(getContext()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(46.0f));
            layoutParams.setMargins(0, roundToInt, 0, 0);
            RelativeLayout relativeLayout = this.mSubLayoutTitleRl;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutTitleRl");
                relativeLayout = null;
            }
            relativeLayout.setLayoutParams(layoutParams);
            this.mSubLayoutRvAdapter = new MiniAppSubLayoutRvAdapter(new MiniAppItemCallback(), new MiniAppSubLayoutRvDelegatesManager());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getPartHost().getHostActivity(), 4);
            gridLayoutManager.setOrientation(1);
            RecyclerView recyclerView = this.mSubLayoutRv;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(gridLayoutManager);
            RecyclerView recyclerView2 = this.mSubLayoutRv;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                recyclerView2 = null;
            }
            recyclerView2.setAdapter(this.mSubLayoutRvAdapter);
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppDesktopSubLayoutPart$initMiniAppSubPageUI$1(this, null), 3, null);
            LinearLayout linearLayout2 = this.mSubLayoutRoot;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiniAppDesktopSubLayoutPart.initMiniAppSubPageUI$lambda$1(view);
                    }
                });
            }
            ImageView imageView2 = this.mSubLayoutBackBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutBackBtn");
            } else {
                imageView = imageView2;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAppDesktopSubLayoutPart.initMiniAppSubPageUI$lambda$2(MiniAppDesktopSubLayoutPart.this, view);
                }
            });
            compatibleNavigationBarShow();
            return;
        }
        QLog.e(getTAG(), 1, "onInitView rootView is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMiniAppSubPageUI$lambda$2(MiniAppDesktopSubLayoutPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeSubLayout(this$0.getPartRootView());
    }

    private final void myMiniAppSubPageDragDrop(View itemView, DragEvent event) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        RecyclerView recyclerView = this.mSubLayoutRv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
            recyclerView = null;
        }
        View findChildViewUnder = recyclerView.findChildViewUnder(event.getX(), event.getY());
        if (findChildViewUnder != null) {
            RecyclerView recyclerView2 = this.mSubLayoutRv;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                recyclerView2 = null;
            }
            if (recyclerView2.getChildViewHolder(findChildViewUnder) != null) {
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                int fromPosition = ((MiniAppDragData) localState).getFromPosition();
                RecyclerView recyclerView3 = this.mSubLayoutRv;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                    recyclerView3 = null;
                }
                int adapterPosition = recyclerView3.getChildViewHolder(findChildViewUnder).getAdapterPosition();
                if (fromPosition >= 0 && fromPosition < this.mSubLayoutRvDataList.size() && adapterPosition >= 0 && adapterPosition < this.mSubLayoutRvDataList.size() && (lifecycleOwner = ViewTreeLifecycleOwner.get(itemView)) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                    BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppDesktopSubLayoutPart$myMiniAppSubPageDragDrop$1(this, fromPosition, adapterPosition, null), 3, null);
                }
                QLog.i(getTAG(), 1, "actionDrop fromPosition" + fromPosition + " toPosition:" + adapterPosition);
                return;
            }
        }
        QLog.i(getTAG(), 1, "view == null or holder == null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean myMiniAppSubPageDragListener(View view, DragEvent event) {
        switch (event.getAction()) {
            case 1:
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                if (((MiniAppDragData) localState).getStartRv().getId() != R.id.rht) {
                    return false;
                }
                this.mLocationTime = System.currentTimeMillis();
                return true;
            case 2:
                myMiniAppSubPageDragLocation(view, event);
                return true;
            case 3:
                myMiniAppSubPageDragDrop(view, event);
                return true;
            case 4:
                this.mLocationToPosition = -1;
                this.mLocationFromPosition = -1;
                return true;
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    private final void myMiniAppSubPageDragLocation(View itemView, DragEvent event) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (System.currentTimeMillis() - this.mLocationTime <= 800) {
            return;
        }
        RecyclerView recyclerView = this.mSubLayoutRv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
            recyclerView = null;
        }
        View findChildViewUnder = recyclerView.findChildViewUnder(event.getX(), event.getY());
        if (findChildViewUnder != null) {
            RecyclerView recyclerView2 = this.mSubLayoutRv;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                recyclerView2 = null;
            }
            if (recyclerView2.getChildViewHolder(findChildViewUnder) != null) {
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                int fromPosition = ((MiniAppDragData) localState).getFromPosition();
                RecyclerView recyclerView3 = this.mSubLayoutRv;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                    recyclerView3 = null;
                }
                int adapterPosition = recyclerView3.getChildViewHolder(findChildViewUnder).getAdapterPosition();
                if (fromPosition >= 0 && fromPosition < this.mSubLayoutRvDataList.size() && adapterPosition >= 0 && adapterPosition < this.mSubLayoutRvDataList.size() && (lifecycleOwner = ViewTreeLifecycleOwner.get(itemView)) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                    BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppDesktopSubLayoutPart$myMiniAppSubPageDragLocation$1(this, fromPosition, adapterPosition, null), 3, null);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(getTAG(), 1, "holder.adapterPosition" + fromPosition + " dragData.fromPosition\uff1a" + adapterPosition);
                }
                this.mLocationTime = System.currentTimeMillis();
                return;
            }
        }
        QLog.i(getTAG(), 1, "view == null or holder == null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSubLayout(View rootView, final MiniAppDesktopEffect.SetSubLayoutDesktopDataList effect) {
        LinearLayout linearLayout = this.mSubLayoutRoot;
        Intrinsics.checkNotNull(rootView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, ANIMATION_TRANSLATION_X, rootView.getWidth(), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSubLayoutRoot, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat2.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopSubLayoutPart$openSubLayout$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                QLog.d(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, " --rightInAnim onAnimationRepeat-- ");
                MiniAppDesktopSubLayoutPart.bindView$default(MiniAppDesktopSubLayoutPart.this, effect.getDesktopDataList(), effect.getType(), false, 4, null);
                MiniAppDesktopSubLayoutPart.this.getMMiniAppDesktopViewModel().updateSubLayoutOpenState(true);
                MiniProgramLpReportDC04239.reportMorePageExposure(effect.getType());
                MiniAppDesktopSubLayoutPart.this.setDragListenerForSubRv();
                MiniAppDesktopSubLayoutPart.this.setSubRvOnItemListener();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                LinearLayout linearLayout2;
                TextView textView;
                RecyclerView recyclerView;
                QLog.d(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, " --rightInAnim onAnimationStart-- ");
                linearLayout2 = MiniAppDesktopSubLayoutPart.this.mSubLayoutRoot;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                textView = MiniAppDesktopSubLayoutPart.this.mSubLayoutTitleTv;
                RecyclerView recyclerView2 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutTitleTv");
                    textView = null;
                }
                textView.setText(effect.getTitleName());
                recyclerView = MiniAppDesktopSubLayoutPart.this.mSubLayoutRv;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                } else {
                    recyclerView2 = recyclerView;
                }
                recyclerView2.setTag(Integer.valueOf(effect.getType()));
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recentMiniAppSubPageDragListener(DragEvent event) {
        int action = event.getAction();
        if (action != 1) {
            if (action != 4) {
                return false;
            }
            this.mLocationToPosition = -1;
            this.mLocationFromPosition = -1;
            return true;
        }
        Object localState = event.getLocalState();
        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
        if (((MiniAppDragData) localState).getStartRv().getId() != R.id.rht) {
            return false;
        }
        this.mLocationTime = System.currentTimeMillis();
        return true;
    }

    private final List<DesktopItemInfo> remoteGdtMiniAppItem(List<DesktopItemInfo> dataList) {
        Iterator<DesktopItemInfo> it = dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DesktopItemInfo next = it.next();
            if ((next instanceof DesktopAppInfo) && ((DesktopAppInfo) next).mMiniAppInfo.isGdtMiniAppAd) {
                it.remove();
                break;
            }
        }
        return dataList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCloseMiniAppSubPageState() {
        bindView$default(this, new ArrayList(), 1, false, 4, null);
        LinearLayout linearLayout = this.mSubLayoutRoot;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        getMMiniAppDesktopViewModel().updateSubLayoutOpenState(false);
    }

    private final void setDataList(List<DesktopItemInfo> dataList, boolean isForceRefresh) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(remoteGdtMiniAppItem(dataList));
        MiniAppSubLayoutRvAdapter miniAppSubLayoutRvAdapter = this.mSubLayoutRvAdapter;
        Intrinsics.checkNotNull(miniAppSubLayoutRvAdapter);
        miniAppSubLayoutRvAdapter.setItems(remoteGdtMiniAppItem(arrayList));
        if (isForceRefresh) {
            MiniAppSubLayoutRvAdapter miniAppSubLayoutRvAdapter2 = this.mSubLayoutRvAdapter;
            Intrinsics.checkNotNull(miniAppSubLayoutRvAdapter2);
            miniAppSubLayoutRvAdapter2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDragListenerForSubRv() {
        if (this.mDragListener == null) {
            this.mDragListener = new View.OnDragListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopSubLayoutPart$setDragListenerForSubRv$1
                @Override // android.view.View.OnDragListener
                public boolean onDrag(View view, DragEvent event) {
                    int i3;
                    int i16;
                    boolean myMiniAppSubPageDragListener;
                    boolean recentMiniAppSubPageDragListener;
                    if (view != null && event != null && event.getLocalState() != null && (event.getLocalState() instanceof MiniAppDragData)) {
                        if (event.getAction() != 2) {
                            QLog.i(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, "onDrag, viewId:" + view.getId() + ", action:" + MiniAppDragHelper.INSTANCE.getDragActionString(event.getAction()) + ", view:" + view + ", event:" + event);
                        }
                        i3 = MiniAppDesktopSubLayoutPart.this.mType;
                        if (i3 == 1) {
                            recentMiniAppSubPageDragListener = MiniAppDesktopSubLayoutPart.this.recentMiniAppSubPageDragListener(event);
                            return recentMiniAppSubPageDragListener;
                        }
                        i16 = MiniAppDesktopSubLayoutPart.this.mType;
                        if (i16 == 3) {
                            myMiniAppSubPageDragListener = MiniAppDesktopSubLayoutPart.this.myMiniAppSubPageDragListener(view, event);
                            return myMiniAppSubPageDragListener;
                        }
                    }
                    return false;
                }
            };
            RecyclerView recyclerView = this.mSubLayoutRv;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                recyclerView = null;
            }
            recyclerView.setOnDragListener(this.mDragListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$0(MiniAppDesktopSubLayoutPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppDesktopSubLayoutPart$setLiveDataObserver$1$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSubRvOnItemListener() {
        if (this.mSubRvOnItemListener == null) {
            RecyclerView recyclerView = this.mSubLayoutRv;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
                recyclerView = null;
            }
            MiniAppInnerRvItemTouchForDragListener miniAppInnerRvItemTouchForDragListener = new MiniAppInnerRvItemTouchForDragListener(recyclerView, new MiniAppInnerRvItemLongClickForDragListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopSubLayoutPart$setSubRvOnItemListener$1
                @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener
                public void onItemClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, "mSubLayoutRv, onItemClick");
                    if (fromPosition >= 0) {
                        arrayList = MiniAppDesktopSubLayoutPart.this.mSubLayoutRvDataList;
                        if (fromPosition < arrayList.size()) {
                            MiniAppItemClickLaunchUtils miniAppItemClickLaunchUtils = MiniAppItemClickLaunchUtils.INSTANCE;
                            arrayList2 = MiniAppDesktopSubLayoutPart.this.mSubLayoutRvDataList;
                            Object obj = arrayList2.get(fromPosition);
                            Intrinsics.checkNotNullExpressionValue(obj, "mSubLayoutRvDataList[fromPosition]");
                            Context context = rv5.getContext();
                            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                            MiniAppItemClickLaunchUtils.startMini$default(miniAppItemClickLaunchUtils, (DesktopItemInfo) obj, vh5, (Activity) context, MiniAppDesktopSubLayoutPart.this.getMMiniAppDesktopViewModel(), 0, 16, null);
                            return;
                        }
                    }
                    QLog.i(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, "onItemClick fromPosition:" + fromPosition + "is invalid!");
                }

                @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener
                public void onItemLongClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition, float rawX, float rawY) {
                    MiniAppSubLayoutRvAdapter miniAppSubLayoutRvAdapter;
                    MiniAppSubLayoutRvAdapter miniAppSubLayoutRvAdapter2;
                    MiniAppSubLayoutRvAdapter miniAppSubLayoutRvAdapter3;
                    MiniAppSubLayoutRvAdapter miniAppSubLayoutRvAdapter4;
                    List<DesktopItemInfo> items;
                    List<DesktopItemInfo> items2;
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, "mSubLayoutRv, onItemLongClick");
                    miniAppSubLayoutRvAdapter = MiniAppDesktopSubLayoutPart.this.mSubLayoutRvAdapter;
                    if (miniAppSubLayoutRvAdapter != null) {
                        miniAppSubLayoutRvAdapter2 = MiniAppDesktopSubLayoutPart.this.mSubLayoutRvAdapter;
                        DesktopItemInfo desktopItemInfo = null;
                        if ((miniAppSubLayoutRvAdapter2 != null ? miniAppSubLayoutRvAdapter2.getItems() : null) != null && fromPosition >= 0) {
                            miniAppSubLayoutRvAdapter3 = MiniAppDesktopSubLayoutPart.this.mSubLayoutRvAdapter;
                            Integer valueOf = (miniAppSubLayoutRvAdapter3 == null || (items2 = miniAppSubLayoutRvAdapter3.getItems()) == null) ? null : Integer.valueOf(items2.size());
                            Intrinsics.checkNotNull(valueOf);
                            if (fromPosition < valueOf.intValue()) {
                                MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
                                miniAppSubLayoutRvAdapter4 = MiniAppDesktopSubLayoutPart.this.mSubLayoutRvAdapter;
                                if (miniAppSubLayoutRvAdapter4 != null && (items = miniAppSubLayoutRvAdapter4.getItems()) != null) {
                                    desktopItemInfo = items.get(fromPosition);
                                }
                                Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
                                companion.startDrag(rv5, vh5, null, fromPosition, (DesktopAppInfo) desktopItemInfo, rawX, rawY);
                                return;
                            }
                        }
                    }
                    QLog.i(MiniAppDesktopSubLayoutPart.this.getTAG(), 1, "onItemLongClick fromPosition:" + fromPosition + "is invalid!");
                }
            });
            this.mSubRvOnItemListener = miniAppInnerRvItemTouchForDragListener;
            RecyclerView recyclerView3 = this.mSubLayoutRv;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubLayoutRv");
            } else {
                recyclerView2 = recyclerView3;
            }
            recyclerView2.addOnItemTouchListener(miniAppInnerRvItemTouchForDragListener);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppDesktopPart.MiniAppDesktopSubLayoutPart";
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void handleUiState(MiniAppDeskTopUIState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        boolean z16 = false;
        if (uiState instanceof MiniAppDeskTopUIState.CloseMiniAppSubPage) {
            LinearLayout linearLayout = this.mSubLayoutRoot;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                setCloseMiniAppSubPageState();
                return;
            }
            return;
        }
        if (uiState instanceof MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo) {
            LinearLayout linearLayout2 = this.mSubLayoutRoot;
            if (linearLayout2 != null && linearLayout2.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo updateDesktopMiniAppInfo = (MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo) uiState;
                if (updateDesktopMiniAppInfo.getDesktopData().get(Integer.valueOf(this.mType)) != null) {
                    QLog.d(getTAG(), 1, "SetDesktopData bindView!");
                    List<DesktopItemInfo> list = updateDesktopMiniAppInfo.getDesktopData().get(Integer.valueOf(this.mType));
                    Intrinsics.checkNotNull(list);
                    bindView(list, this.mType, true);
                    return;
                }
                return;
            }
            return;
        }
        if (uiState instanceof MiniAppDeskTopUIState.MyMiniAppDraggingTempSwitchPosition) {
            LinearLayout linearLayout3 = this.mSubLayoutRoot;
            if (linearLayout3 != null && linearLayout3.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                MiniAppDeskTopUIState.MyMiniAppDraggingTempSwitchPosition myMiniAppDraggingTempSwitchPosition = (MiniAppDeskTopUIState.MyMiniAppDraggingTempSwitchPosition) uiState;
                if (!(!myMiniAppDraggingTempSwitchPosition.getDeepCopyMyMiniAppInfo().isEmpty()) || FastClickUtils.isFastDoubleClick(getTAG(), 300L)) {
                    return;
                }
                QLog.d(getTAG(), 1, "SetDesktopData bindView!");
                bindView$default(this, myMiniAppDraggingTempSwitchPosition.getDeepCopyMyMiniAppInfo(), 3, false, 4, null);
            }
        }
    }

    public final boolean onBackPressed() {
        LinearLayout linearLayout = this.mSubLayoutRoot;
        if (!(linearLayout != null && linearLayout.getVisibility() == 0)) {
            return false;
        }
        closeSubLayout(getPartRootView());
        return true;
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartResume(Activity activity) {
        com.tencent.biz.richframework.part.b.d(this, activity);
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
        QLog.i(getTAG(), 1, "onPostThemeChanged!");
        LinearLayout linearLayout = this.mSubLayoutRoot;
        if (linearLayout != null) {
            boolean z16 = false;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                MiniAppSubLayoutRvAdapter miniAppSubLayoutRvAdapter = this.mSubLayoutRvAdapter;
                if (miniAppSubLayoutRvAdapter != null) {
                    miniAppSubLayoutRvAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
        QLog.i(getTAG(), 1, "onPostThemeChanged view is not init or not show!");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void setLiveDataObserver() {
        if (getPartRootView() == null) {
            QLog.w(getTAG(), 1, "setLiveDataObserver rootView is null");
        } else {
            getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.ab
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppDesktopSubLayoutPart.setLiveDataObserver$lambda$0(MiniAppDesktopSubLayoutPart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void bindView$default(MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart, List list, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        miniAppDesktopSubLayoutPart.bindView(list, i3, z16);
    }

    static /* synthetic */ void setDataList$default(MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        miniAppDesktopSubLayoutPart.setDataList(list, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMiniAppSubPageUI$lambda$1(View view) {
    }
}
