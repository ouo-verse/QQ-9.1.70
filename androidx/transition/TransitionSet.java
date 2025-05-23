package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    private ArrayList<Transition> mTransitions;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            int i3 = transitionSet.mCurrentListeners - 1;
            transitionSet.mCurrentListeners = i3;
            if (i3 == 0) {
                transitionSet.mStarted = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            if (!transitionSet.mStarted) {
                transitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    private void addTransitionInternal(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        addTransitionInternal(transition);
        long j3 = this.mDuration;
        if (j3 >= 0) {
            transition.setDuration(j3);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            Transition transition = this.mTransitions.get(i3);
            if (startDelay > 0 && (this.mPlayTogether || i3 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z16) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).excludeTarget(view, z16);
        }
        return super.excludeTarget(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).forceToEnd(viewGroup);
        }
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int i3) {
        if (i3 >= 0 && i3 < this.mTransitions.size()) {
            return this.mTransitions.get(i3);
        }
        return null;
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).pause(view);
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).resume(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (!this.mPlayTogether) {
            for (int i3 = 1; i3 < this.mTransitions.size(); i3++) {
                Transition transition = this.mTransitions.get(i3 - 1);
                final Transition transition2 = this.mTransitions.get(i3);
                transition.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void onTransitionEnd(@NonNull Transition transition3) {
                        transition2.runAnimators();
                        transition3.removeListener(this);
                    }
                });
            }
            Transition transition3 = this.mTransitions.get(0);
            if (transition3 != null) {
                transition3.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z16) {
        super.setCanRemoveViews(z16);
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).setCanRemoveViews(z16);
        }
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).setEpicenterCallback(epicenterCallback);
        }
    }

    @NonNull
    public TransitionSet setOrdering(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                this.mPlayTogether = false;
            } else {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i3);
            }
        } else {
            this.mPlayTogether = true;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
                this.mTransitions.get(i3).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).setPropagation(transitionPropagation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public String toString(String str) {
        String transition = super.toString(str);
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(transition);
            sb5.append("\n");
            sb5.append(this.mTransitions.get(i3).toString(str + "  "));
            transition = sb5.toString();
        }
        return transition;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo41clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo41clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            transitionSet.addTransitionInternal(this.mTransitions.get(i3).mo41clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setDuration(long j3) {
        ArrayList<Transition> arrayList;
        super.setDuration(j3);
        if (this.mDuration >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mTransitions.get(i3).setDuration(j3);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mTransitions.get(i3).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTransitions.get(i3).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long j3) {
        return (TransitionSet) super.setStartDelay(j3);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull Class cls) {
        return addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull Class cls) {
        return removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z16) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).excludeTarget(str, z16);
        }
        return super.excludeTarget(str, z16);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int i3) {
        for (int i16 = 0; i16 < this.mTransitions.size(); i16++) {
            this.mTransitions.get(i16).removeTarget(i3);
        }
        return (TransitionSet) super.removeTarget(i3);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int i3, boolean z16) {
        for (int i16 = 0; i16 < this.mTransitions.size(); i16++) {
            this.mTransitions.get(i16).excludeTarget(i3, z16);
        }
        return super.excludeTarget(i3, z16);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int i3) {
        for (int i16 = 0; i16 < this.mTransitions.size(); i16++) {
            this.mTransitions.get(i16).addTarget(i3);
        }
        return (TransitionSet) super.addTarget(i3);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z16) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).excludeTarget(cls, z16);
        }
        return super.excludeTarget(cls, z16);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> cls) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> cls) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        for (int i3 = 0; i3 < this.mTransitions.size(); i3++) {
            this.mTransitions.get(i3).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
