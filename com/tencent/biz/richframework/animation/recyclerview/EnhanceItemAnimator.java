package com.tencent.biz.richframework.animation.recyclerview;

import android.view.KeyEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.richframework.animation.support.AnimatorCompatHelper;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EnhanceItemAnimator extends SimpleItemAnimator {
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();
    private ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();
    private ArrayList<ChangeInfo> mPendingChanges = new ArrayList<>();
    private ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();
    private ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();
    private ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
            this(viewHolder, viewHolder2);
            this.fromX = i3;
            this.fromY = i16;
            this.toX = i17;
            this.toY = i18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
            this.holder = viewHolder;
            this.fromX = i3;
            this.fromY = i16;
            this.toX = i17;
            this.toY = i18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        VpaListenerAdapter() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateAddImpl(final RecyclerView.ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.mAddAnimations.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).translationX(0.0f).translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new VpaListenerAdapter() { // from class: com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ViewCompat.setAlpha(view, 1.0f);
                ViewCompat.setTranslationX(view, 0.0f);
                ViewCompat.setTranslationY(view, 0.0f);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                animate.setListener(null);
                EnhanceItemAnimator.this.dispatchAddFinished(viewHolder);
                EnhanceItemAnimator.this.mAddAnimations.remove(viewHolder);
                EnhanceItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                EnhanceItemAnimator.this.dispatchAddStarting(viewHolder);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void animateChangeImpl(final ChangeInfo changeInfo) {
        View view;
        final View view2;
        final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = null;
        if (viewHolder == 0) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        } else {
            view2 = null;
        }
        if (view != null) {
            if (viewHolder instanceof EnhanceHolderAnimationInterface) {
                viewPropertyAnimatorCompat = ((EnhanceHolderAnimationInterface) viewHolder).getHolderChangeAnimation(changeInfo, getChangeDuration(), true);
            } else {
                viewPropertyAnimatorCompat = null;
            }
            this.mChangeAnimations.add(changeInfo.oldHolder);
            if (viewPropertyAnimatorCompat == null) {
                viewPropertyAnimatorCompat = ViewCompat.animate(view).setDuration(getChangeDuration());
                viewPropertyAnimatorCompat.translationX(changeInfo.toX - changeInfo.fromX);
                viewPropertyAnimatorCompat.scaleY(1.0f);
                viewPropertyAnimatorCompat.scaleX(1.0f);
                viewPropertyAnimatorCompat.translationY(changeInfo.toY - changeInfo.fromY);
                viewPropertyAnimatorCompat.alpha(0.0f);
            }
            viewPropertyAnimatorCompat.setListener(new VpaListenerAdapter() { // from class: com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view3) {
                    viewPropertyAnimatorCompat.setListener(null);
                    ViewCompat.setAlpha(view3, 1.0f);
                    ViewCompat.setTranslationX(view3, 0.0f);
                    ViewCompat.setTranslationY(view3, 0.0f);
                    ViewCompat.setScaleX(view3, 1.0f);
                    ViewCompat.setScaleY(view3, 1.0f);
                    EnhanceItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    EnhanceItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
                    EnhanceItemAnimator.this.dispatchFinishedWhenDone();
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view3) {
                    EnhanceItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }
            }).start();
        }
        if (view2 != null) {
            if (viewHolder instanceof EnhanceHolderAnimationInterface) {
                viewPropertyAnimatorCompat2 = ((EnhanceHolderAnimationInterface) viewHolder).getHolderChangeAnimation(changeInfo, getChangeDuration(), false);
            }
            this.mChangeAnimations.add(changeInfo.newHolder);
            if (viewPropertyAnimatorCompat2 == null) {
                viewPropertyAnimatorCompat2 = ViewCompat.animate(view2);
                viewPropertyAnimatorCompat2.translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(getChangeDuration()).alpha(1.0f);
            }
            viewPropertyAnimatorCompat2.setListener(new VpaListenerAdapter() { // from class: com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view3) {
                    viewPropertyAnimatorCompat2.setListener(null);
                    ViewCompat.setAlpha(view2, 1.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    ViewCompat.setTranslationY(view2, 0.0f);
                    ViewCompat.setScaleX(view2, 1.0f);
                    ViewCompat.setScaleY(view2, 1.0f);
                    EnhanceItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    EnhanceItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
                    EnhanceItemAnimator.this.dispatchFinishedWhenDone();
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view3) {
                    EnhanceItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void animateMoveImpl(final RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        View view = viewHolder.itemView;
        final int i19 = i17 - i3;
        final int i26 = i18 - i16;
        if (i19 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i26 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        MoveInfo moveInfo = new MoveInfo(viewHolder, i3, i16, i17, i18);
        if (viewHolder instanceof EnhanceHolderAnimationInterface) {
            viewPropertyAnimatorCompat = ((EnhanceHolderAnimationInterface) viewHolder).getHolderMoveAnimation(moveInfo, getMoveDuration());
        } else {
            viewPropertyAnimatorCompat = null;
        }
        if (viewPropertyAnimatorCompat == null) {
            viewPropertyAnimatorCompat = ViewCompat.animate(view).setDuration(getMoveDuration());
        }
        final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
        this.mMoveAnimations.add(viewHolder);
        viewPropertyAnimatorCompat2.setListener(new VpaListenerAdapter() { // from class: com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view2) {
                if (i19 != 0) {
                    ViewCompat.setTranslationX(view2, 0.0f);
                }
                if (i26 != 0) {
                    ViewCompat.setTranslationY(view2, 0.0f);
                }
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                viewPropertyAnimatorCompat2.setListener(null);
                EnhanceItemAnimator.this.dispatchMoveFinished(viewHolder);
                EnhanceItemAnimator.this.mMoveAnimations.remove(viewHolder);
                EnhanceItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view2) {
                EnhanceItemAnimator.this.dispatchMoveStarting(viewHolder);
            }
        }).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void animateRemoveImpl(final RecyclerView.ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        View view = viewHolder.itemView;
        if (viewHolder instanceof EnhanceHolderAnimationInterface) {
            viewPropertyAnimatorCompat = ((EnhanceHolderAnimationInterface) viewHolder).getHolderRemoveAnimation(viewHolder);
        } else {
            viewPropertyAnimatorCompat = null;
        }
        if (viewPropertyAnimatorCompat == null) {
            viewPropertyAnimatorCompat = ViewCompat.animate(view).setDuration(getRemoveDuration());
            viewPropertyAnimatorCompat.setDuration(getRemoveDuration()).alpha(0.0f);
        }
        this.mRemoveAnimations.add(viewHolder);
        viewPropertyAnimatorCompat.setListener(new VpaListenerAdapter() { // from class: com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                viewPropertyAnimatorCompat.setListener(null);
                ViewCompat.setAlpha(view2, 1.0f);
                EnhanceItemAnimator.this.dispatchRemoveFinished(viewHolder);
                EnhanceItemAnimator.this.mRemoveAnimations.remove(viewHolder);
                EnhanceItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view2) {
                EnhanceItemAnimator.this.dispatchRemoveStarting(viewHolder);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    private void endChangeAnimation(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        if (viewHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            endChangeAnimationIfNecessary(changeInfo, viewHolder2);
        }
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        AnimatorCompatHelper.clearInterpolator(viewHolder.itemView);
        endAnimation(viewHolder);
    }

    private void runAddAndRemovePendingAnimations(boolean z16, boolean z17, boolean z18, boolean z19) {
        long j3;
        long j16;
        if (z19) {
            final ArrayList<RecyclerView.ViewHolder> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(arrayList);
            this.mPendingAdditions.clear();
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        EnhanceItemAnimator.this.animateAddImpl((RecyclerView.ViewHolder) it.next());
                    }
                    arrayList.clear();
                    EnhanceItemAnimator.this.mAdditionsList.remove(arrayList);
                }
            };
            if (!z16 && !z17 && !z18) {
                runnable.run();
                return;
            }
            long j17 = 0;
            if (z16) {
                j3 = getRemoveDuration();
            } else {
                j3 = 0;
            }
            if (z17) {
                j16 = getMoveDuration();
            } else {
                j16 = 0;
            }
            if (z18) {
                j17 = getChangeDuration();
            }
            ViewCompat.postOnAnimationDelayed(arrayList.get(0).itemView, runnable, j3 + Math.max(j16, j17));
        }
    }

    private void runChangesPendingAnimations(boolean z16, boolean z17) {
        if (z17) {
            final ArrayList<ChangeInfo> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingChanges);
            this.mChangesList.add(arrayList);
            this.mPendingChanges.clear();
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        EnhanceItemAnimator.this.animateChangeImpl((ChangeInfo) it.next());
                    }
                    arrayList.clear();
                    EnhanceItemAnimator.this.mChangesList.remove(arrayList);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList.get(0).oldHolder.itemView, runnable, getRemoveDuration());
            } else {
                runnable.run();
            }
        }
    }

    private void runMovePendingAnimations(boolean z16, boolean z17) {
        if (z17) {
            final ArrayList<MoveInfo> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingMoves);
            this.mMovesList.add(arrayList);
            this.mPendingMoves.clear();
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.3
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        MoveInfo moveInfo = (MoveInfo) it.next();
                        EnhanceItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                    }
                    arrayList.clear();
                    EnhanceItemAnimator.this.mMovesList.remove(arrayList);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList.get(0).holder.itemView, runnable, getRemoveDuration());
            } else {
                runnable.run();
            }
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        if (Boolean.TRUE.equals(viewHolder.itemView.getTag(R.id.f74303vw))) {
            ViewCompat.setAlpha(viewHolder.itemView, 0.0f);
        }
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
        boolean z16;
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i3, i16, i17, i18);
        }
        ChangeInfo changeInfo = new ChangeInfo(viewHolder, viewHolder2, i3, i16, i17, i18);
        float translationX = ViewCompat.getTranslationX(viewHolder.itemView);
        float translationY = ViewCompat.getTranslationY(viewHolder.itemView);
        float alpha = ViewCompat.getAlpha(viewHolder.itemView);
        int i19 = (int) ((i17 - i3) - translationX);
        int i26 = (int) ((i18 - i16) - translationY);
        resetAnimation(viewHolder);
        ViewCompat.setTranslationX(viewHolder.itemView, translationX);
        ViewCompat.setTranslationY(viewHolder.itemView, translationY);
        ViewCompat.setAlpha(viewHolder.itemView, alpha);
        if (viewHolder2 != 0) {
            resetAnimation(viewHolder2);
            if (viewHolder2 instanceof EnhanceHolderAnimationInterface) {
                z16 = ((EnhanceHolderAnimationInterface) viewHolder2).onPreAnimateChange(changeInfo);
            } else {
                z16 = false;
            }
            if (!z16) {
                ViewCompat.setTranslationX(viewHolder2.itemView, -i19);
                ViewCompat.setTranslationY(viewHolder2.itemView, -i26);
                ViewCompat.setScaleX(viewHolder2.itemView, 1.0f);
                ViewCompat.setScaleY(viewHolder2.itemView, 1.0f);
                ViewCompat.setAlpha(viewHolder2.itemView, 0.0f);
            }
        }
        this.mPendingChanges.add(changeInfo);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        return super.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        View view = viewHolder.itemView;
        int translationX = (int) (i3 + ViewCompat.getTranslationX(view));
        int translationY = (int) (i16 + ViewCompat.getTranslationY(viewHolder.itemView));
        resetAnimation(viewHolder);
        int i19 = i17 - translationX;
        int i26 = i18 - translationY;
        if (i19 == 0 && i26 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i19 != 0) {
            ViewCompat.setTranslationX(view, -i19);
        }
        if (i26 != 0) {
            ViewCompat.setTranslationY(view, -i26);
        }
        this.mPendingMoves.add(new MoveInfo(viewHolder, translationX, translationY, i17, i18));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        if (list.isEmpty() && !super.canReuseUpdatedViewHolder(viewHolder, list)) {
            return false;
        }
        return true;
    }

    void cancelAll(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(list.get(size).itemView).cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewCompat.animate(view).cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mPendingMoves.get(size).holder == viewHolder) {
                ViewCompat.setTranslationY(view, 0.0f);
                ViewCompat.setTranslationX(view, 0.0f);
                dispatchMoveFinished(viewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, viewHolder);
        if (this.mPendingRemovals.remove(viewHolder)) {
            ViewCompat.setAlpha(view, 1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            ViewCompat.setAlpha(view, 1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList<ChangeInfo> arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList<MoveInfo> arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).holder == viewHolder) {
                    ViewCompat.setTranslationY(view, 0.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(viewHolder)) {
                ViewCompat.setAlpha(view, 1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(viewHolder);
        this.mAddAnimations.remove(viewHolder);
        this.mChangeAnimations.remove(viewHolder);
        this.mMoveAnimations.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.mPendingMoves.get(size);
            View view = moveInfo.holder.itemView;
            ViewCompat.setTranslationY(view, 0.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.mPendingAdditions.get(size3);
            ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
            dispatchAddFinished(viewHolder);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<MoveInfo> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = arrayList.get(size6);
                    View view2 = moveInfo2.holder.itemView;
                    ViewCompat.setTranslationY(view2, 0.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                    ViewCompat.setAlpha(viewHolder2.itemView, 1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<ChangeInfo> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public void onChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z16) {
        KeyEvent.Callback callback = viewHolder.itemView;
        if (callback instanceof EnhanceItemAnimationInterface) {
            ((EnhanceItemAnimationInterface) callback).onChangeFinished(z16);
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public void onChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z16) {
        KeyEvent.Callback callback = viewHolder.itemView;
        if (callback instanceof EnhanceItemAnimationInterface) {
            ((EnhanceItemAnimationInterface) callback).onChangeStarting(z16);
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public void onMoveFinished(RecyclerView.ViewHolder viewHolder) {
        KeyEvent.Callback callback = viewHolder.itemView;
        if (callback instanceof EnhanceItemAnimationInterface) {
            ((EnhanceItemAnimationInterface) callback).onMoveFinished();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public void onMoveStarting(RecyclerView.ViewHolder viewHolder) {
        KeyEvent.Callback callback = viewHolder.itemView;
        if (callback instanceof EnhanceItemAnimationInterface) {
            ((EnhanceItemAnimationInterface) callback).onMoveStarting();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z16 = !this.mPendingRemovals.isEmpty();
        boolean z17 = !this.mPendingMoves.isEmpty();
        boolean z18 = !this.mPendingChanges.isEmpty();
        boolean z19 = !this.mPendingAdditions.isEmpty();
        if (z16 || z17 || z19 || z18) {
            Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            runMovePendingAnimations(z16, z17);
            runChangesPendingAnimations(z16, z18);
            runAddAndRemovePendingAnimations(z16, z17, z18, z19);
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z16 = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else {
            if (changeInfo.oldHolder != viewHolder) {
                return false;
            }
            changeInfo.oldHolder = null;
            z16 = true;
        }
        ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
        ViewCompat.setScaleX(viewHolder.itemView, 1.0f);
        ViewCompat.setScaleY(viewHolder.itemView, 1.0f);
        ViewCompat.setTranslationX(viewHolder.itemView, 0.0f);
        ViewCompat.setTranslationY(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z16);
        return true;
    }
}
