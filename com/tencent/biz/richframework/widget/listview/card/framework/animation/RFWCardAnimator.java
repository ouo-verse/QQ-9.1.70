package com.tencent.biz.richframework.widget.listview.card.framework.animation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;
import com.tencent.biz.richframework.widget.listview.card.framework.RFWCardLogger;
import com.tencent.biz.richframework.widget.listview.card.framework.adapter.RFWCardListAdapter;
import com.tencent.biz.richframework.widget.listview.card.framework.adapter.RFWCardListFullScreenAdapter;
import com.tencent.biz.richframework.widget.listview.card.framework.animation.RFWCardAnimator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCardAnimator {
    public static final AtomicBoolean ANIMATION_LOCK = new AtomicBoolean(false);
    private RFWCardViewBuilder cardViewBuilder;
    private final Context context;
    private List<RFWCardModel> dataList;
    private ExpandAnimationListener expandAnimationListener;
    private View fullScreenView;
    private List<VisibleItemViewHolder> visibleItemViewHolders;
    private final List<View> fakeViewList = new ArrayList();
    private final List<RFWCardListFullScreenAdapter.ViewHolder> animationItemViewHolders = new ArrayList();
    private int animationMode = 0;
    private long markTimeStamp = 0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ExpandAnimationListener {
        void onFinish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class VisibleItemViewHolder {
        private final Context context;
        public View itemView;
        public int position;
        public int realPosition;

        /* renamed from: x, reason: collision with root package name */
        public int f95574x;

        /* renamed from: y, reason: collision with root package name */
        public int f95575y;

        public VisibleItemViewHolder(Context context, View view, int i3, int i16, int i17, int i18) {
            this.context = context;
            this.itemView = view;
            this.position = i3;
            this.realPosition = i3 - i16;
            this.f95574x = i17;
            this.f95575y = i18;
        }

        public boolean isViewVisibleInScreen() {
            Context context;
            if (this.itemView == null || (context = this.context) == null) {
                return true;
            }
            int i3 = context.getResources().getDisplayMetrics().widthPixels;
            int measuredWidth = this.itemView.getMeasuredWidth();
            int i16 = this.f95574x;
            if (i16 <= i3 && i16 + measuredWidth >= 0) {
                return true;
            }
            return false;
        }
    }

    public RFWCardAnimator(Context context) {
        this.context = context;
        ANIMATION_LOCK.set(false);
    }

    private List<VisibleItemViewHolder> findVisibleItemView() {
        int i3;
        ArrayList arrayList = new ArrayList();
        int size = this.dataList.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            View view = this.dataList.get(i17).cardView;
            if (view != null) {
                Object tag = view.getTag();
                if (tag instanceof RFWCardListAdapter.ViewHolder) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int i18 = ((RFWCardListAdapter.ViewHolder) tag).position;
                    if (i18 == 0) {
                        i3 = iArr[0] + ((int) this.cardViewBuilder.firstCardMargin);
                    } else {
                        i3 = iArr[0];
                    }
                    int i19 = i3;
                    int i26 = iArr[1];
                    if (i19 != 0 && i26 != 0) {
                        VisibleItemViewHolder visibleItemViewHolder = new VisibleItemViewHolder(this.context, view, i18, i18 - i16, i19, i26);
                        i16++;
                        if (visibleItemViewHolder.isViewVisibleInScreen()) {
                            arrayList.add(visibleItemViewHolder);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static int getWindowHeight(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        return ((Activity) context).getWindow().getDecorView().getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$measureTargetViewLocation$1(View view, VisibleItemViewHolder visibleItemViewHolder, float f16, float f17) {
        playAnimationInner(view, visibleItemViewHolder.realPosition, view.getX(), f16, view.getY(), f17);
        View view2 = this.fullScreenView;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        RFWCardLogger.debug("QUICardListAnimator", "[ReMeasure]card_animation_time_diff=" + (System.currentTimeMillis() - this.markTimeStamp) + ", position=" + visibleItemViewHolder.realPosition);
        this.markTimeStamp = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onStart$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void measureTargetViewLocation(int i3) {
        long j3 = this.context.getResources().getDisplayMetrics().widthPixels;
        int windowHeight = getWindowHeight(this.context);
        if (windowHeight == 0) {
            windowHeight = this.context.getResources().getDisplayMetrics().heightPixels;
        }
        RFWCardViewBuilder rFWCardViewBuilder = this.cardViewBuilder;
        float f16 = (((float) (j3 - ((int) (rFWCardViewBuilder.largeCardWidth + rFWCardViewBuilder.largeCardMargin)))) / 2.0f) + 27.0f;
        final float f17 = ((float) (windowHeight - ((int) rFWCardViewBuilder.largeCardHeight))) / 2.0f;
        this.markTimeStamp = System.currentTimeMillis();
        for (final VisibleItemViewHolder visibleItemViewHolder : this.visibleItemViewHolders) {
            final View view = this.fakeViewList.get(visibleItemViewHolder.realPosition);
            final float f18 = ((visibleItemViewHolder.position - i3) * r5) + f16;
            view.post(new Runnable() { // from class: com.tencent.biz.richframework.widget.listview.card.framework.animation.a
                @Override // java.lang.Runnable
                public final void run() {
                    RFWCardAnimator.this.lambda$measureTargetViewLocation$1(view, visibleItemViewHolder, f18, f17);
                }
            });
            if (RFWCardLogger.isColorLevel()) {
                RFWCardLogger.info("QUICardListAnimator", RFWCardLogger.CLR, "ReMeasure, targetX=" + f18 + ", targetY=" + f17);
            }
        }
    }

    private float[] obtainAnimationFromToXY(float f16, float f17, float f18, float f19) {
        float f26 = f17 - f16;
        float f27 = f19 - f18;
        float[] fArr = {0.0f, f26, 0.0f, f27};
        if (this.animationMode == 1) {
            fArr[0] = f26;
            fArr[1] = 0.0f;
            fArr[2] = f27;
            fArr[3] = 0.0f;
        }
        RFWCardLogger.debug("QUICardListAnimator", "obtainAnimationFromToXY, fromX=" + fArr[0] + ", targetX=" + fArr[1] + ", fromY=" + fArr[2] + ", targetY=" + fArr[3]);
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDismissInner() {
        try {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.context).getWindow().getDecorView().getRootView();
            Iterator<View> it = this.fakeViewList.iterator();
            while (it.hasNext()) {
                viewGroup.removeView(it.next());
            }
        } catch (Exception e16) {
            RFWCardLogger.error("QUICardListAnimator", RFWCardLogger.USR, "onDismissInner error!", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLayoutDuringAnimation(int i3, float f16) {
        if (i3 < this.animationItemViewHolders.size()) {
            this.animationItemViewHolders.get(i3).onLayoutDuringAnimation(f16);
        }
    }

    private void playAnimationInner(final View view, final int i3, float f16, float f17, float f18, float f19) {
        float[] obtainAnimationFromToXY = obtainAnimationFromToXY(f16, f17, f18, f19);
        TranslateAnimation translateAnimation = new TranslateAnimation(obtainAnimationFromToXY[0], obtainAnimationFromToXY[1], obtainAnimationFromToXY[2], obtainAnimationFromToXY[3]) { // from class: com.tencent.biz.richframework.widget.listview.card.framework.animation.RFWCardAnimator.1
            @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
            protected void applyTransformation(float f26, Transformation transformation) {
                super.applyTransformation(f26, transformation);
                RFWCardAnimator rFWCardAnimator = RFWCardAnimator.this;
                int i16 = i3;
                if (rFWCardAnimator.animationMode != 0) {
                    f26 = 1.0f - f26;
                }
                rFWCardAnimator.onLayoutDuringAnimation(i16, f26);
            }
        };
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.biz.richframework.widget.listview.card.framework.animation.RFWCardAnimator.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (RFWCardAnimator.this.animationMode == 0) {
                    RFWCardAnimator.this.onLayoutDuringAnimation(i3, 1.0f);
                    if (RFWCardAnimator.this.expandAnimationListener != null) {
                        RFWCardAnimator.this.expandAnimationListener.onFinish();
                    }
                } else {
                    RFWCardAnimator.this.onLayoutDuringAnimation(i3, 0.0f);
                }
                RFWCardAnimator.this.onDismissInner();
                RFWCardAnimator.ANIMATION_LOCK.set(false);
                if (RFWCardLogger.isColorLevel()) {
                    RFWCardLogger.info("QUICardListAnimator", RFWCardLogger.CLR, "onAnimationEnd, position=" + i3);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(translateAnimation);
    }

    public void onDismiss(RecyclerView recyclerView, int i3) {
        List<VisibleItemViewHolder> list;
        if (this.fakeViewList.size() > 0 && (list = this.visibleItemViewHolders) != null && list.size() > 0) {
            View view = null;
            for (VisibleItemViewHolder visibleItemViewHolder : this.visibleItemViewHolders) {
                if (visibleItemViewHolder.position == i3) {
                    view = visibleItemViewHolder.itemView;
                }
            }
            if (view == null) {
                onDismissInner();
                return;
            }
            this.fullScreenView = recyclerView;
            setAnimationMode(1);
            onStart(i3);
            return;
        }
        onDismissInner();
    }

    public void onStart(int i3) {
        float f16;
        AtomicBoolean atomicBoolean = ANIMATION_LOCK;
        if (atomicBoolean.get()) {
            if (RFWCardLogger.isColorLevel()) {
                RFWCardLogger.info("QUICardListAnimator", RFWCardLogger.CLR, "onStart abort, animation lock!");
                return;
            }
            return;
        }
        atomicBoolean.set(true);
        if (this.visibleItemViewHolders == null) {
            this.visibleItemViewHolders = findVisibleItemView();
        }
        if (this.visibleItemViewHolders.size() <= 0) {
            atomicBoolean.set(false);
            if (RFWCardLogger.isColorLevel()) {
                RFWCardLogger.info("QUICardListAnimator", RFWCardLogger.CLR, "onStart abort, none visible card!");
                return;
            }
            return;
        }
        this.fakeViewList.clear();
        this.animationItemViewHolders.clear();
        RFWCardLogger.info("QUICardListAnimator", RFWCardLogger.USR, "onStart, position=" + i3 + ", visible_card_number=" + this.visibleItemViewHolders.size() + ", mode=" + this.animationMode);
        for (VisibleItemViewHolder visibleItemViewHolder : this.visibleItemViewHolders) {
            RFWCardModel deepClone = this.dataList.get(visibleItemViewHolder.position).deepClone();
            View inflate = LayoutInflater.from(this.context).inflate(this.cardViewBuilder.largeCardResId, (ViewGroup) null);
            this.fakeViewList.add(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: te0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RFWCardAnimator.lambda$onStart$0(view);
                }
            });
            inflate.setTag(deepClone);
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.context).getWindow().getDecorView().getRootView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = visibleItemViewHolder.f95574x;
            layoutParams.topMargin = visibleItemViewHolder.f95575y;
            inflate.setVisibility(4);
            viewGroup.addView(inflate, layoutParams);
            RFWCardListFullScreenAdapter.ViewHolder viewHolder = new RFWCardListFullScreenAdapter.ViewHolder(inflate, this.cardViewBuilder, 1);
            viewHolder.bindData(this.dataList.get(visibleItemViewHolder.position), visibleItemViewHolder.position, false);
            if (this.animationMode == 0) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            viewHolder.onLayoutDuringAnimation(f16);
            this.animationItemViewHolders.add(viewHolder);
        }
        measureTargetViewLocation(i3);
    }

    public RFWCardAnimator setAnimationListener(ExpandAnimationListener expandAnimationListener) {
        this.expandAnimationListener = expandAnimationListener;
        return this;
    }

    public RFWCardAnimator setAnimationMode(int i3) {
        this.animationMode = i3;
        return this;
    }

    public RFWCardAnimator setCardViewBuilder(RFWCardViewBuilder rFWCardViewBuilder) {
        this.cardViewBuilder = rFWCardViewBuilder;
        return this;
    }

    public RFWCardAnimator setData(List<RFWCardModel> list) {
        this.dataList = list;
        return this;
    }
}
