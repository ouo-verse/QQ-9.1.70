package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void animateAddImpl(final RecyclerView.ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.mAddAnimations.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new VpaListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ViewCompat.setAlpha(view, 1.0f);
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchAddFinished(viewHolder);
                DefaultItemAnimator.this.mAddAnimations.remove(viewHolder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchAddStarting(viewHolder);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateChangeImpl(final ChangeInfo changeInfo) {
        View view;
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        final View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            final ViewPropertyAnimatorCompat duration = ViewCompat.animate(view).setDuration(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            duration.translationX(changeInfo.toX - changeInfo.fromX);
            duration.translationY(changeInfo.toY - changeInfo.fromY);
            duration.alpha(0.0f).setListener(new VpaListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view3) {
                    duration.setListener(null);
                    ViewCompat.setAlpha(view3, 1.0f);
                    ViewCompat.setTranslationX(view3, 0.0f);
                    ViewCompat.setTranslationY(view3, 0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    DefaultItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                }

                @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view3) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view2);
            this.mChangeAnimations.add(changeInfo.newHolder);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new VpaListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view3) {
                    animate.setListener(null);
                    ViewCompat.setAlpha(view2, 1.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    ViewCompat.setTranslationY(view2, 0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    DefaultItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                }

                @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view3) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateMoveImpl(final RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        View view = viewHolder.itemView;
        final int i19 = i17 - i3;
        final int i26 = i18 - i16;
        if (i19 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i26 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        this.mMoveAnimations.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new VpaListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view2) {
                if (i19 != 0) {
                    ViewCompat.setTranslationX(view2, 0.0f);
                }
                if (i26 != 0) {
                    ViewCompat.setTranslationY(view2, 0.0f);
                }
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchMoveFinished(viewHolder);
                DefaultItemAnimator.this.mMoveAnimations.remove(viewHolder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view2) {
                DefaultItemAnimator.this.dispatchMoveStarting(viewHolder);
            }
        }).start();
    }

    private void animateRemoveImpl(final RecyclerView.ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.mRemoveAnimations.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new VpaListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                animate.setListener(null);
                ViewCompat.setAlpha(view, 1.0f);
                DefaultItemAnimator.this.dispatchRemoveFinished(viewHolder);
                DefaultItemAnimator.this.mRemoveAnimations.remove(viewHolder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // android.support.v7.widget.DefaultItemAnimator.VpaListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchRemoveStarting(viewHolder);
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

    @Override // android.support.v7.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        ViewCompat.setAlpha(viewHolder.itemView, 0.0f);
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i3, i16, i17, i18);
        }
        float translationX = ViewCompat.getTranslationX(viewHolder.itemView);
        float translationY = ViewCompat.getTranslationY(viewHolder.itemView);
        float alpha = ViewCompat.getAlpha(viewHolder.itemView);
        resetAnimation(viewHolder);
        int i19 = (int) ((i17 - i3) - translationX);
        int i26 = (int) ((i18 - i16) - translationY);
        ViewCompat.setTranslationX(viewHolder.itemView, translationX);
        ViewCompat.setTranslationY(viewHolder.itemView, translationY);
        ViewCompat.setAlpha(viewHolder.itemView, alpha);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            ViewCompat.setTranslationX(viewHolder2.itemView, -i19);
            ViewCompat.setTranslationY(viewHolder2.itemView, -i26);
            ViewCompat.setAlpha(viewHolder2.itemView, 0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(viewHolder, viewHolder2, i3, i16, i17, i18));
        return true;
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
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

    @Override // android.support.v7.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
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

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
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

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
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
        if (!isRunning()) {
            return;
        }
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

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        long j3;
        long j16;
        boolean z16 = !this.mPendingRemovals.isEmpty();
        boolean z17 = !this.mPendingMoves.isEmpty();
        boolean z18 = !this.mPendingChanges.isEmpty();
        boolean z19 = !this.mPendingAdditions.isEmpty();
        if (!z16 && !z17 && !z19 && !z18) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
        while (it.hasNext()) {
            animateRemoveImpl(it.next());
        }
        this.mPendingRemovals.clear();
        if (z17) {
            final ArrayList<MoveInfo> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingMoves);
            this.mMovesList.add(arrayList);
            this.mPendingMoves.clear();
            Runnable runnable = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        MoveInfo moveInfo = (MoveInfo) it5.next();
                        DefaultItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                    }
                    arrayList.clear();
                    DefaultItemAnimator.this.mMovesList.remove(arrayList);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList.get(0).holder.itemView, runnable, getRemoveDuration());
            } else {
                runnable.run();
            }
        }
        if (z18) {
            final ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.mPendingChanges);
            this.mChangesList.add(arrayList2);
            this.mPendingChanges.clear();
            Runnable runnable2 = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        DefaultItemAnimator.this.animateChangeImpl((ChangeInfo) it5.next());
                    }
                    arrayList2.clear();
                    DefaultItemAnimator.this.mChangesList.remove(arrayList2);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList2.get(0).oldHolder.itemView, runnable2, getRemoveDuration());
            } else {
                runnable2.run();
            }
        }
        if (z19) {
            final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(arrayList3);
            this.mPendingAdditions.clear();
            Runnable runnable3 = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.3
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        DefaultItemAnimator.this.animateAddImpl((RecyclerView.ViewHolder) it5.next());
                    }
                    arrayList3.clear();
                    DefaultItemAnimator.this.mAdditionsList.remove(arrayList3);
                }
            };
            if (!z16 && !z17 && !z18) {
                runnable3.run();
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
            ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable3, j3 + Math.max(j16, j17));
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
        ViewCompat.setTranslationX(viewHolder.itemView, 0.0f);
        ViewCompat.setTranslationY(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z16);
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        VpaListenerAdapter() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
        }
    }
}
