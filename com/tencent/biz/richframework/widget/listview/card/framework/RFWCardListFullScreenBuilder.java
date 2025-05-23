package com.tencent.biz.richframework.widget.listview.card.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.widget.listview.card.RFWCardExtension;
import com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder;
import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardReport;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardStateListener;
import com.tencent.biz.richframework.widget.listview.card.framework.adapter.RFWCardListFullScreenAdapter;
import com.tencent.biz.richframework.widget.listview.card.framework.animation.RFWCardAnimator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCardListFullScreenBuilder {
    private FrameLayout bigCardListLayout;
    private RFWCardExtension cardExtension;
    private RFWCardAnimator cardListAnimator;
    private final Context context;
    private List<? extends RFWCardModel> dataList;
    private RecyclerView inStepListView;
    private LinearLayoutManager layoutManager;
    private FrameLayout maskLayout;
    private boolean isFullScreenShow = false;
    private boolean isFullScreenExit = false;

    public RFWCardListFullScreenBuilder(Context context) {
        this.context = context;
    }

    private void addListViewToRoot() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        this.bigCardListLayout.addView(this.inStepListView, layoutParams);
        this.bigCardListLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.richframework.widget.listview.card.framework.RFWCardListFullScreenBuilder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                RFWCardListFullScreenBuilder.this.onFullScreenLayoutExit();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        ((ViewGroup) ((Activity) this.context).getWindow().getDecorView().getRootView()).addView(this.bigCardListLayout);
        if (RFWCardLogger.isColorLevel()) {
            RFWCardLogger.info("QUICardListFullScreenFactory", RFWCardLogger.USR, "addListViewToRoot success");
        }
    }

    @NotNull
    private RecyclerView createFullScreenCardListView(ArrayList<RFWCardModel> arrayList) {
        RFWCardViewBuilder rFWCardViewBuilder;
        RecyclerView recyclerView = new RecyclerView(this.context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(this.layoutManager);
        RFWCardListFullScreenAdapter rFWCardListFullScreenAdapter = new RFWCardListFullScreenAdapter(this.context);
        rFWCardListFullScreenAdapter.setCardExtension(this.cardExtension);
        rFWCardListFullScreenAdapter.setData(arrayList);
        recyclerView.setAdapter(rFWCardListFullScreenAdapter);
        recyclerView.setOverScrollMode(2);
        RFWCardExtension rFWCardExtension = this.cardExtension;
        if (rFWCardExtension != null && (rFWCardViewBuilder = rFWCardExtension.cardViewBuilder) != null) {
            recyclerView.addItemDecoration(rFWCardViewBuilder.itemDecoration);
        }
        new PagerSnapHelper().attachToRecyclerView(recyclerView);
        if (RFWCardLogger.isColorLevel()) {
            RFWCardLogger.info("QUICardListFullScreenFactory", RFWCardLogger.USR, "createFullScreenCardListView success");
        }
        return recyclerView;
    }

    private void createFullScreenLayout() {
        IRFWCardReport iRFWCardReport;
        this.bigCardListLayout = new FrameLayout(this.context);
        this.bigCardListLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        RFWCardExtension rFWCardExtension = this.cardExtension;
        if (rFWCardExtension != null && (iRFWCardReport = rFWCardExtension.report) != null) {
            iRFWCardReport.onFullScreenPageRegister(this.bigCardListLayout);
        }
        this.maskLayout = new FrameLayout(this.context);
        this.maskLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.maskLayout.setBackground(new ColorDrawable(-1946157056));
        this.bigCardListLayout.addView(this.maskLayout);
        if (RFWCardLogger.isColorLevel()) {
            RFWCardLogger.info("QUICardListFullScreenFactory", RFWCardLogger.USR, "createFullScreenLayout success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFullScreenExitInner() {
        RFWCardStateListener rFWCardStateListener;
        FrameLayout frameLayout = this.bigCardListLayout;
        if (frameLayout == null) {
            return;
        }
        ViewParent parent = frameLayout.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.bigCardListLayout);
            this.isFullScreenShow = false;
        }
        RFWCardExtension rFWCardExtension = this.cardExtension;
        if (rFWCardExtension != null && (rFWCardStateListener = rFWCardExtension.stateListener) != null) {
            rFWCardStateListener.onChange(0);
        }
        if (RFWCardLogger.isColorLevel()) {
            RFWCardLogger.info("QUICardListFullScreenFactory", RFWCardLogger.USR, "onFullScreenExitInner success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFullScreenLayoutExit() {
        LinearLayoutManager linearLayoutManager;
        if (!this.isFullScreenExit && !RFWCardAnimator.ANIMATION_LOCK.get()) {
            this.isFullScreenExit = true;
            RFWCardAnimator rFWCardAnimator = this.cardListAnimator;
            if (rFWCardAnimator != null && (linearLayoutManager = this.layoutManager) != null) {
                rFWCardAnimator.onDismiss(this.inStepListView, linearLayoutManager.findFirstCompletelyVisibleItemPosition());
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.biz.richframework.widget.listview.card.framework.RFWCardListFullScreenBuilder.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RFWCardListFullScreenBuilder.this.onFullScreenExitInner();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.bigCardListLayout.startAnimation(alphaAnimation);
        }
    }

    private void playExpandAnimation(int i3, ArrayList<RFWCardModel> arrayList) {
        RFWCardViewBuilder rFWCardViewBuilder;
        this.inStepListView.setVisibility(4);
        RFWCardAnimator data = new RFWCardAnimator(this.context).setData(arrayList);
        RFWCardExtension rFWCardExtension = this.cardExtension;
        if (rFWCardExtension == null) {
            rFWCardViewBuilder = null;
        } else {
            rFWCardViewBuilder = rFWCardExtension.cardViewBuilder;
        }
        RFWCardAnimator animationListener = data.setCardViewBuilder(rFWCardViewBuilder).setAnimationMode(0).setAnimationListener(new RFWCardAnimator.ExpandAnimationListener() { // from class: com.tencent.biz.richframework.widget.listview.card.framework.RFWCardListFullScreenBuilder.2
            @Override // com.tencent.biz.richframework.widget.listview.card.framework.animation.RFWCardAnimator.ExpandAnimationListener
            public void onFinish() {
                RFWCardListFullScreenBuilder.this.inStepListView.setVisibility(0);
            }
        });
        this.cardListAnimator = animationListener;
        animationListener.onStart(i3);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setFillAfter(true);
        this.maskLayout.startAnimation(alphaAnimation);
    }

    private void scrollCardListToTargetPosition(int i3) {
        if (i3 > 0 && i3 < this.dataList.size() - 1) {
            int i16 = this.context.getResources().getDisplayMetrics().widthPixels;
            RFWCardViewBuilder rFWCardViewBuilder = this.cardExtension.cardViewBuilder;
            this.layoutManager.scrollToPositionWithOffset(i3, ((i16 - ((int) rFWCardViewBuilder.largeCardWidth)) - ((int) rFWCardViewBuilder.largeCardMargin)) / 2);
            return;
        }
        this.layoutManager.scrollToPosition(i3);
    }

    public boolean onBackPressed() {
        if (!this.isFullScreenShow) {
            return false;
        }
        onFullScreenLayoutExit();
        return true;
    }

    public RFWCardListFullScreenBuilder onFullScreenViewCreate(int i3) {
        RFWCardStateListener rFWCardStateListener;
        synchronized (this) {
            if (this.isFullScreenShow) {
                RFWCardLogger.debug("QUICardListFullScreenFactory", "fullScreen is showing, disable another show!");
                return this;
            }
            this.isFullScreenShow = true;
            RFWCardExtension rFWCardExtension = this.cardExtension;
            if (rFWCardExtension != null && (rFWCardStateListener = rFWCardExtension.stateListener) != null) {
                rFWCardStateListener.onChange(1);
            }
            ArrayList<RFWCardModel> arrayList = new ArrayList<>(this.dataList);
            createFullScreenLayout();
            this.inStepListView = createFullScreenCardListView(arrayList);
            addListViewToRoot();
            playExpandAnimation(i3, arrayList);
            scrollCardListToTargetPosition(i3);
            return this;
        }
    }

    public RFWCardListFullScreenBuilder setCardExtension(RFWCardExtension rFWCardExtension) {
        this.cardExtension = rFWCardExtension;
        return this;
    }

    public RFWCardListFullScreenBuilder setData(List<? extends RFWCardModel> list) {
        this.dataList = list;
        return this;
    }
}
