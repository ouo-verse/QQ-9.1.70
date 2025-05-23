package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<TransitionValues> mEndValuesList;
    private EpicenterCallback mEpicenterCallback;
    private ArrayMap<String, String> mNameOverrides;
    TransitionPropagation mPropagation;
    private ArrayList<TransitionValues> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() { // from class: androidx.transition.Transition.1
        @Override // androidx.transition.PathMotion
        public Path getPath(float f16, float f17, float f18, float f19) {
            Path path = new Path();
            path.moveTo(f16, f17);
            path.lineTo(f18, f19);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    TransitionSet mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<TransitionListener> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class AnimationInfo {
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowIdImpl mWindowId;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.mView = view;
            this.mName = str;
            this.mValues = transitionValues;
            this.mWindowId = windowIdImpl;
            this.mTransition = transition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ArrayListManager {
        ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t16) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t16)) {
                arrayList.add(t16);
            }
            return arrayList;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t16) {
            if (arrayList != null) {
                arrayList.remove(t16);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(@NonNull Transition transition);
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface MatchOrder {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    public Transition() {
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i3 = 0; i3 < arrayMap.size(); i3++) {
            TransitionValues valueAt = arrayMap.valueAt(i3);
            if (isValidTarget(valueAt.view)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add(null);
            }
        }
        for (int i16 = 0; i16 < arrayMap2.size(); i16++) {
            TransitionValues valueAt2 = arrayMap2.valueAt(i16);
            if (isValidTarget(valueAt2.view)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.mViewValues.put(view, transitionValues);
        int id5 = view.getId();
        if (id5 >= 0) {
            if (transitionValuesMaps.mIdValues.indexOfKey(id5) >= 0) {
                transitionValuesMaps.mIdValues.put(id5, null);
            } else {
                transitionValuesMaps.mIdValues.put(id5, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (transitionValuesMaps.mNameValues.containsKey(transitionName)) {
                transitionValuesMaps.mNameValues.put(transitionName, null);
            } else {
                transitionValuesMaps.mNameValues.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.mItemIdValues.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = transitionValuesMaps.mItemIdValues.get(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.setHasTransientState(view2, false);
                        transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.setHasTransientState(view, true);
                transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i3) {
        int i16 = iArr[i3];
        for (int i17 = 0; i17 < i3; i17++) {
            if (iArr[i17] == i16) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z16) {
        if (view == null) {
            return;
        }
        int id5 = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id5))) {
            return;
        }
        ArrayList<View> arrayList2 = this.mTargetExcludes;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return;
        }
        ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.mTargetTypeExcludes.get(i3).isInstance(view)) {
                    return;
                }
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            TransitionValues transitionValues = new TransitionValues(view);
            if (z16) {
                captureStartValues(transitionValues);
            } else {
                captureEndValues(transitionValues);
            }
            transitionValues.mTargetedTransitions.add(this);
            capturePropagationValues(transitionValues);
            if (z16) {
                addViewValues(this.mStartValues, view, transitionValues);
            } else {
                addViewValues(this.mEndValues, view, transitionValues);
            }
        }
        if (view instanceof ViewGroup) {
            ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
            if (arrayList4 != null && arrayList4.contains(Integer.valueOf(id5))) {
                return;
            }
            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
            if (arrayList5 != null && arrayList5.contains(view)) {
                return;
            }
            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
            if (arrayList6 != null) {
                int size2 = arrayList6.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    if (this.mTargetTypeChildExcludes.get(i16).isInstance(view)) {
                        return;
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i17 = 0; i17 < viewGroup.getChildCount(); i17++) {
                captureHierarchy(viewGroup.getChildAt(i17), z16);
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i3, boolean z16) {
        if (i3 > 0) {
            if (z16) {
                return ArrayListManager.add(arrayList, Integer.valueOf(i3));
            }
            return ArrayListManager.remove(arrayList, Integer.valueOf(i3));
        }
        return arrayList;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t16, boolean z16) {
        if (t16 != null) {
            if (z16) {
                return ArrayListManager.add(arrayList, t16);
            }
            return ArrayListManager.remove(arrayList, t16);
        }
        return arrayList;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z16) {
        if (cls != null) {
            if (z16) {
                return ArrayListManager.add(arrayList, cls);
            }
            return ArrayListManager.remove(arrayList, cls);
        }
        return arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z16) {
        if (view != null) {
            if (z16) {
                return ArrayListManager.add(arrayList, view);
            }
            return ArrayListManager.remove(arrayList, view);
        }
        return arrayList;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        if (arrayMap == null) {
            ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
            sRunningAnimators.set(arrayMap2);
            return arrayMap2;
        }
        return arrayMap;
    }

    private static boolean isValidMatch(int i3) {
        if (i3 >= 1 && i3 <= 4) {
            return true;
        }
        return false;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View valueAt = sparseArray.valueAt(i3);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i3))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View keyAt = arrayMap.keyAt(size);
            if (keyAt != null && isValidTarget(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && isValidTarget(remove.view)) {
                this.mStartValuesList.add(arrayMap.removeAt(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View valueAt = longSparseArray.valueAt(i3);
            if (valueAt != null && isValidTarget(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i3))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i3 = 0; i3 < size; i3++) {
            View valueAt = arrayMap3.valueAt(i3);
            if (valueAt != null && isValidTarget(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i3))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.mViewValues);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.mViewValues);
        int i3 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i3 < iArr.length) {
                int i16 = iArr[i3];
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 == 4) {
                                matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.mItemIdValues, transitionValuesMaps2.mItemIdValues);
                            }
                        } else {
                            matchIds(arrayMap, arrayMap2, transitionValuesMaps.mIdValues, transitionValuesMaps2.mIdValues);
                        }
                    } else {
                        matchNames(arrayMap, arrayMap2, transitionValuesMaps.mNameValues, transitionValuesMaps2.mNameValues);
                    }
                } else {
                    matchInstances(arrayMap, arrayMap2);
                }
                i3++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i3 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i3] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i3] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i3] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i3] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                i3--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i3++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.mCurrentAnimators.remove(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.mCurrentAnimators.add(animator2);
                }
            });
            animate(animator);
        }
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View view) {
        this.mTargets.add(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((TransitionListener) arrayList2.get(i3)).onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] propagationProperties;
        if (this.mPropagation == null || transitionValues.values.isEmpty() || (propagationProperties = this.mPropagation.getPropagationProperties()) == null) {
            return;
        }
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < propagationProperties.length) {
                if (!transitionValues.values.containsKey(propagationProperties[i3])) {
                    break;
                } else {
                    i3++;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (!z16) {
            this.mPropagation.captureValues(transitionValues);
        }
    }

    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z16) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        ArrayMap<String, String> arrayMap;
        clearValues(z16);
        if ((this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) || (((arrayList = this.mTargetNames) != null && !arrayList.isEmpty()) || ((arrayList2 = this.mTargetTypes) != null && !arrayList2.isEmpty()))) {
            captureHierarchy(viewGroup, z16);
        } else {
            for (int i3 = 0; i3 < this.mTargetIds.size(); i3++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i3).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z16) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z16) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i16 = 0; i16 < this.mTargets.size(); i16++) {
                View view = this.mTargets.get(i16);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z16) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.mTargetedTransitions.add(this);
                capturePropagationValues(transitionValues2);
                if (z16) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        }
        if (!z16 && (arrayMap = this.mNameOverrides) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i17 = 0; i17 < size; i17++) {
                arrayList3.add(this.mStartValues.mNameValues.remove(this.mNameOverrides.keyAt(i17)));
            }
            for (int i18 = 0; i18 < size; i18++) {
                View view2 = (View) arrayList3.get(i18);
                if (view2 != null) {
                    this.mStartValues.mNameValues.put(this.mNameOverrides.valueAt(i18), view2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearValues(boolean z16) {
        if (z16) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
        } else {
            this.mEndValues.mViewValues.clear();
            this.mEndValues.mIdValues.clear();
            this.mEndValues.mItemIdValues.clear();
        }
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        boolean z16;
        Animator createAnimator;
        int i3;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        Animator animator2;
        TransitionValues transitionValues2;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j3 = Long.MAX_VALUE;
        int i16 = 0;
        while (i16 < size) {
            TransitionValues transitionValues3 = arrayList.get(i16);
            TransitionValues transitionValues4 = arrayList2.get(i16);
            if (transitionValues3 != null && !transitionValues3.mTargetedTransitions.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.mTargetedTransitions.contains(this)) {
                transitionValues4 = null;
            }
            if (transitionValues3 != null || transitionValues4 != null) {
                if (transitionValues3 != null && transitionValues4 != null && !isTransitionRequired(transitionValues3, transitionValues4)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && (createAnimator = createAnimator(viewGroup, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        view = transitionValues4.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues2 = new TransitionValues(view);
                            i3 = size;
                            TransitionValues transitionValues5 = transitionValuesMaps2.mViewValues.get(view);
                            if (transitionValues5 != null) {
                                int i17 = 0;
                                while (i17 < transitionProperties.length) {
                                    Map<String, Object> map = transitionValues2.values;
                                    String str = transitionProperties[i17];
                                    map.put(str, transitionValues5.values.get(str));
                                    i17++;
                                    transitionProperties = transitionProperties;
                                }
                            }
                            int size2 = runningAnimators.size();
                            int i18 = 0;
                            while (true) {
                                if (i18 < size2) {
                                    AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i18));
                                    if (animationInfo.mValues != null && animationInfo.mView == view && animationInfo.mName.equals(getName()) && animationInfo.mValues.equals(transitionValues2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i18++;
                                } else {
                                    animator2 = createAnimator;
                                    break;
                                }
                            }
                        } else {
                            i3 = size;
                            animator2 = createAnimator;
                            transitionValues2 = null;
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        i3 = size;
                        view = transitionValues3.view;
                        animator = createAnimator;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        TransitionPropagation transitionPropagation = this.mPropagation;
                        if (transitionPropagation != null) {
                            long startDelay = transitionPropagation.getStartDelay(viewGroup, this, transitionValues3, transitionValues4);
                            sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                            j3 = Math.min(startDelay, j3);
                        }
                        runningAnimators.put(animator, new AnimationInfo(view, getName(), this, ViewUtils.getWindowId(viewGroup), transitionValues));
                        this.mAnimators.add(animator);
                        j3 = j3;
                    }
                    i16++;
                    size = i3;
                }
            }
            i3 = size;
            i16++;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i19 = 0; i19 < sparseIntArray.size(); i19++) {
                Animator animator3 = this.mAnimators.get(sparseIntArray.keyAt(i19));
                animator3.setStartDelay((sparseIntArray.valueAt(i19) - j3) + animator3.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void end() {
        int i3 = this.mNumInstances - 1;
        this.mNumInstances = i3;
        if (i3 == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i16 = 0; i16 < size; i16++) {
                    ((TransitionListener) arrayList2.get(i16)).onTransitionEnd(this);
                }
            }
            for (int i17 = 0; i17 < this.mStartValues.mItemIdValues.size(); i17++) {
                View valueAt = this.mStartValues.mItemIdValues.valueAt(i17);
                if (valueAt != null) {
                    ViewCompat.setHasTransientState(valueAt, false);
                }
            }
            for (int i18 = 0; i18 < this.mEndValues.mItemIdValues.size(); i18++) {
                View valueAt2 = this.mEndValues.mItemIdValues.valueAt(i18);
                if (valueAt2 != null) {
                    ViewCompat.setHasTransientState(valueAt2, false);
                }
            }
            this.mEnded = true;
        }
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view, boolean z16) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z16);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z16) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z16);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            WindowIdImpl windowId = ViewUtils.getWindowId(viewGroup);
            ArrayMap arrayMap = new ArrayMap(runningAnimators);
            runningAnimators.clear();
            for (int i3 = size - 1; i3 >= 0; i3--) {
                AnimationInfo animationInfo = (AnimationInfo) arrayMap.valueAt(i3);
                if (animationInfo.mView != null && windowId != null && windowId.equals(animationInfo.mWindowId)) {
                    ((Animator) arrayMap.keyAt(i3)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransitionValues getMatchedTransitionValues(View view, boolean z16) {
        ArrayList<TransitionValues> arrayList;
        ArrayList<TransitionValues> arrayList2;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z16);
        }
        if (z16) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                TransitionValues transitionValues = arrayList.get(i3);
                if (transitionValues == null) {
                    return null;
                }
                if (transitionValues.view == view) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            return null;
        }
        if (z16) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return arrayList2.get(i3);
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    @NonNull
    public List<View> getTargets() {
        return this.mTargets;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View view, boolean z16) {
        TransitionValuesMaps transitionValuesMaps;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z16);
        }
        if (z16) {
            transitionValuesMaps = this.mStartValues;
        } else {
            transitionValuesMaps = this.mEndValues;
        }
        return transitionValuesMaps.mViewValues.get(view);
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!isValueChanged(transitionValues, transitionValues2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = transitionValues.values.keySet().iterator();
        while (it.hasNext()) {
            if (isValueChanged(transitionValues, transitionValues2, it.next())) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id5 = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id5))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.mTargetTypeExcludes.get(i3).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && ViewCompat.getTransitionName(view) != null && this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id5)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i16 = 0; i16 < this.mTargetTypes.size(); i16++) {
                if (this.mTargetTypes.get(i16).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        if (!this.mEnded) {
            ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            WindowIdImpl windowId = ViewUtils.getWindowId(view);
            for (int i3 = size - 1; i3 >= 0; i3--) {
                AnimationInfo valueAt = runningAnimators.valueAt(i3);
                if (valueAt.mView != null && windowId.equals(valueAt.mWindowId)) {
                    AnimatorUtils.pause(runningAnimators.keyAt(i3));
                }
            }
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    ((TransitionListener) arrayList2.get(i16)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        boolean z16;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdImpl windowId = ViewUtils.getWindowId(viewGroup);
        for (int i3 = size - 1; i3 >= 0; i3--) {
            Animator keyAt = runningAnimators.keyAt(i3);
            if (keyAt != null && (animationInfo = runningAnimators.get(keyAt)) != null && animationInfo.mView != null && windowId.equals(animationInfo.mWindowId)) {
                TransitionValues transitionValues = animationInfo.mValues;
                View view = animationInfo.mView;
                TransitionValues transitionValues2 = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues2 == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.mViewValues.get(view);
                }
                if ((transitionValues2 != null || matchedTransitionValues != null) && animationInfo.mTransition.isTransitionRequired(transitionValues, matchedTransitionValues)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (!keyAt.isRunning() && !keyAt.isStarted()) {
                        runningAnimators.remove(keyAt);
                    } else {
                        keyAt.cancel();
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view) {
        this.mTargets.remove(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdImpl windowId = ViewUtils.getWindowId(view);
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    AnimationInfo valueAt = runningAnimators.valueAt(i3);
                    if (valueAt.mView != null && windowId.equals(valueAt.mWindowId)) {
                        AnimatorUtils.resume(runningAnimators.keyAt(i3));
                    }
                }
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i16 = 0; i16 < size2; i16++) {
                        ((TransitionListener) arrayList2.get(i16)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z16) {
        this.mCanRemoveViews = z16;
    }

    @NonNull
    public Transition setDuration(long j3) {
        this.mDuration = j3;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (isValidMatch(iArr[i3])) {
                    if (alreadyContains(iArr, i3)) {
                        throw new IllegalArgumentException("matches contains a duplicate value");
                    }
                } else {
                    throw new IllegalArgumentException("matches contains invalid value");
                }
            }
            this.mMatchOrder = (int[]) iArr.clone();
            return;
        }
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    @NonNull
    public Transition setStartDelay(long j3) {
        this.mStartDelay = j3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((TransitionListener) arrayList2.get(i3)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    @NonNull
    public Transition addTarget(@IdRes int i3) {
        if (i3 != 0) {
            this.mTargetIds.add(Integer.valueOf(i3));
        }
        return this;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Transition mo41clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i3, boolean z16) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i3, z16);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i3, boolean z16) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i3, z16);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int i3) {
        if (i3 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i3));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + MsgSummary.STR_COLON;
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            for (int i3 = 0; i3 < this.mTargetIds.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargetIds.get(i3);
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i16 = 0; i16 < this.mTargets.size(); i16++) {
                if (i16 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i16);
            }
        }
        return str3 + ")";
    }

    @NonNull
    public Transition addTarget(@NonNull String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> cls, boolean z16) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z16);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z16) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z16);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z16) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z16);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, IQQGameCommApi.KEY_START_DELAY, 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(parseMatchOrder(namedString));
        }
        obtainStyledAttributes.recycle();
    }
}
