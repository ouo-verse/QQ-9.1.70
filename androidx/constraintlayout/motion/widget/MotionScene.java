package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private boolean mRtl;
    private MotionLayout.MotionTracker mVelocityTracker;
    StateSet mStateSet = null;
    Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private Transition mDefaultTransition = null;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean DEBUG_DESKTOP = false;
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mIgnoreTouch = false;
    private boolean mMotionOutsideRegion = false;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private int getId(Context context, String str) {
        int i3;
        if (str.contains("/")) {
            i3 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e(TAG, "error in parsing id");
            return i3;
        }
        return i3;
    }

    private int getIndex(Transition transition) {
        int i3 = transition.mId;
        if (i3 != -1) {
            for (int i16 = 0; i16 < this.mTransitionList.size(); i16++) {
                if (this.mTransitionList.get(i16).mId == i3) {
                    return i16;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("The transition must have an id");
    }

    private int getRealID(int i3) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        if (stateSet != null && (stateGetConstraintID = stateSet.stateGetConstraintID(i3, -1, -1)) != -1) {
            return stateGetConstraintID;
        }
        return i3;
    }

    private boolean hasCycleDependency(int i3) {
        int i16 = this.mDeriveMap.get(i3);
        int size = this.mDeriveMap.size();
        while (i16 > 0) {
            if (i16 == i3) {
                return true;
            }
            int i17 = size - 1;
            if (size < 0) {
                return true;
            }
            i16 = this.mDeriveMap.get(i16);
            size = i17;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker != null) {
            return true;
        }
        return false;
    }

    private void load(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            int eventType = xml.getEventType();
            Transition transition = null;
            while (true) {
                char c16 = 1;
                if (eventType != 1) {
                    if (eventType != 0) {
                        if (eventType == 2) {
                            String name = xml.getName();
                            if (this.DEBUG_DESKTOP) {
                                System.out.println("parsing = " + name);
                            }
                            switch (name.hashCode()) {
                                case -1349929691:
                                    if (name.equals("ConstraintSet")) {
                                        c16 = 5;
                                        break;
                                    }
                                    break;
                                case -1239391468:
                                    if (name.equals("KeyFrameSet")) {
                                        c16 = 6;
                                        break;
                                    }
                                    break;
                                case 269306229:
                                    if (name.equals("Transition")) {
                                        break;
                                    }
                                    break;
                                case 312750793:
                                    if (name.equals("OnClick")) {
                                        c16 = 3;
                                        break;
                                    }
                                    break;
                                case 327855227:
                                    if (name.equals("OnSwipe")) {
                                        c16 = 2;
                                        break;
                                    }
                                    break;
                                case 793277014:
                                    if (name.equals(TAG)) {
                                        c16 = 0;
                                        break;
                                    }
                                    break;
                                case 1382829617:
                                    if (name.equals("StateSet")) {
                                        c16 = 4;
                                        break;
                                    }
                                    break;
                            }
                            c16 = '\uffff';
                            switch (c16) {
                                case 0:
                                    parseMotionSceneTags(context, xml);
                                    break;
                                case 1:
                                    ArrayList<Transition> arrayList = this.mTransitionList;
                                    transition = new Transition(this, context, xml);
                                    arrayList.add(transition);
                                    if (this.mCurrentTransition == null && !transition.mIsAbstract) {
                                        this.mCurrentTransition = transition;
                                        if (transition.mTouchResponse != null) {
                                            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                                        }
                                    }
                                    if (!transition.mIsAbstract) {
                                        break;
                                    } else {
                                        if (transition.mConstraintSetEnd == -1) {
                                            this.mDefaultTransition = transition;
                                        } else {
                                            this.mAbstractTransitionList.add(transition);
                                        }
                                        this.mTransitionList.remove(transition);
                                        break;
                                    }
                                case 2:
                                    if (transition == null) {
                                        Log.v(TAG, " OnSwipe (" + context.getResources().getResourceEntryName(i3) + ".xml:" + xml.getLineNumber() + ")");
                                    }
                                    transition.mTouchResponse = new TouchResponse(context, this.mMotionLayout, xml);
                                    break;
                                case 3:
                                    transition.addOnClick(context, xml);
                                    break;
                                case 4:
                                    this.mStateSet = new StateSet(context, xml);
                                    break;
                                case 5:
                                    parseConstraintSet(context, xml);
                                    break;
                                case 6:
                                    transition.mKeyFramesList.add(new KeyFrames(context, xml));
                                    break;
                                default:
                                    Log.v(TAG, "WARNING UNKNOWN ATTRIBUTE " + name);
                                    break;
                            }
                        }
                    } else {
                        xml.getName();
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (XmlPullParserException e17) {
            e17.printStackTrace();
        }
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i3 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < attributeCount; i17++) {
            String attributeName = xmlPullParser.getAttributeName(i17);
            String attributeValue = xmlPullParser.getAttributeValue(i17);
            if (this.DEBUG_DESKTOP) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            if (!attributeName.equals("deriveConstraintsFrom")) {
                if (attributeName.equals("id")) {
                    i3 = getId(context, attributeValue);
                    this.mConstraintSetIdMap.put(stripID(attributeValue), Integer.valueOf(i3));
                }
            } else {
                i16 = getId(context, attributeValue);
            }
        }
        if (i3 != -1) {
            if (this.mMotionLayout.mDebugPath != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (i16 != -1) {
                this.mDeriveMap.put(i3, i16);
            }
            this.mConstraintSetMap.put(i3, constraintSet);
        }
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i3) {
        int i16 = this.mDeriveMap.get(i3);
        if (i16 > 0) {
            readConstraintChain(this.mDeriveMap.get(i3));
            ConstraintSet constraintSet = this.mConstraintSetMap.get(i3);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i16);
            if (constraintSet2 == null) {
                Log.e(TAG, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i16));
                return;
            }
            constraintSet.readFallback(constraintSet2);
            this.mDeriveMap.put(i3, -1);
        }
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i3) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mOnClicks.size() > 0) {
                Iterator it5 = next.mOnClicks.iterator();
                while (it5.hasNext()) {
                    ((Transition.TransitionOnClick) it5.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it6 = this.mAbstractTransitionList.iterator();
        while (it6.hasNext()) {
            Transition next2 = it6.next();
            if (next2.mOnClicks.size() > 0) {
                Iterator it7 = next2.mOnClicks.iterator();
                while (it7.hasNext()) {
                    ((Transition.TransitionOnClick) it7.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it8 = this.mTransitionList.iterator();
        while (it8.hasNext()) {
            Transition next3 = it8.next();
            if (next3.mOnClicks.size() > 0) {
                Iterator it9 = next3.mOnClicks.iterator();
                while (it9.hasNext()) {
                    ((Transition.TransitionOnClick) it9.next()).addOnClickListeners(motionLayout, i3, next3);
                }
            }
        }
        Iterator<Transition> it10 = this.mAbstractTransitionList.iterator();
        while (it10.hasNext()) {
            Transition next4 = it10.next();
            if (next4.mOnClicks.size() > 0) {
                Iterator it11 = next4.mOnClicks.iterator();
                while (it11.hasNext()) {
                    ((Transition.TransitionOnClick) it11.next()).addOnClickListeners(motionLayout, i3, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean autoTransition(MotionLayout motionLayout, int i3) {
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mAutoTransition != 0 && this.mCurrentTransition != next) {
                if (i3 == next.mConstraintSetStart && (next.mAutoTransition == 4 || next.mAutoTransition == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (i3 == next.mConstraintSetEnd && (next.mAutoTransition == 3 || next.mAutoTransition == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i3, float f16, float f17, MotionEvent motionEvent) {
        float f18;
        if (i3 != -1) {
            List<Transition> transitionsWithState = getTransitionsWithState(i3);
            RectF rectF = new RectF();
            float f19 = 0.0f;
            Transition transition = null;
            for (Transition transition2 : transitionsWithState) {
                if (!transition2.mDisable && transition2.mTouchResponse != null) {
                    transition2.mTouchResponse.setRTL(this.mRtl);
                    RectF touchRegion = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                        RectF touchRegion2 = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion2 == null || motionEvent == null || touchRegion2.contains(motionEvent.getX(), motionEvent.getY())) {
                            float dot = transition2.mTouchResponse.dot(f16, f17);
                            if (transition2.mConstraintSetEnd == i3) {
                                f18 = -1.0f;
                            } else {
                                f18 = 1.1f;
                            }
                            float f26 = dot * f18;
                            if (f26 > f19) {
                                transition = transition2;
                                f19 = f26;
                            }
                        }
                    }
                }
            }
            return transition;
        }
        return this.mCurrentTransition;
    }

    public void disableAutoTransition(boolean z16) {
        this.mDisableAutoTransition = z16;
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + str);
            System.out.println("size " + this.mConstraintSetMap.size());
        }
        for (int i3 = 0; i3 < this.mConstraintSetMap.size(); i3++) {
            int keyAt = this.mConstraintSetMap.keyAt(i3);
            String resourceName = context.getResources().getResourceName(keyAt);
            if (this.DEBUG_DESKTOP) {
                System.out.println("Id for <" + i3 + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = this.mConstraintSetMap.keyAt(i3);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mDuration;
        }
        return this.mDefaultDuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mConstraintSetEnd;
        }
        return -1;
    }

    public Interpolator getInterpolator() {
        int i3 = this.mCurrentTransition.mDefaultInterpolator;
        if (i3 != -2) {
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    return null;
                                }
                                return new BounceInterpolator();
                            }
                            return new AnticipateInterpolator();
                        }
                        return new DecelerateInterpolator();
                    }
                    return new AccelerateInterpolator();
                }
                return new AccelerateDecelerateInterpolator();
            }
            final Easing interpolator = Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f16) {
                    return (float) interpolator.get(f16);
                }
            };
        }
        return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Key getKeyFrame(Context context, int i3, int i16, int i17) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            for (Integer num : keyFrames.getKeys()) {
                if (i16 == num.intValue()) {
                    Iterator<Key> it5 = keyFrames.getKeyFramesForView(num.intValue()).iterator();
                    while (it5.hasNext()) {
                        Key next = it5.next();
                        if (next.mFramePosition == i17 && next.mType == i3) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                Iterator it = transition2.mKeyFramesList.iterator();
                while (it.hasNext()) {
                    ((KeyFrames) it.next()).addFrames(motionController);
                }
                return;
            }
            return;
        }
        Iterator it5 = transition.mKeyFramesList.iterator();
        while (it5.hasNext()) {
            ((KeyFrames) it5.next()).addFrames(motionController);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
        }
        return false;
    }

    public float getPathPercent(View view, int i3) {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getProgressDirection(float f16, float f17) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            return this.mCurrentTransition.mTouchResponse.getProgressDirection(f16, f17);
        }
        return 0.0f;
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mConstraintSetStart;
        }
        return -1;
    }

    public Transition getTransitionById(int i3) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mId == i3) {
                return next;
            }
        }
        return null;
    }

    int getTransitionDirection(int i3) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mConstraintSetStart == i3) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i3) {
        int realID = getRealID(i3);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mConstraintSetStart == realID || next.mConstraintSetEnd == realID) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasKeyFramePosition(View view, int i3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            Iterator<Key> it5 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it5.hasNext()) {
                if (it5.next().mFramePosition == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public int lookUpConstraintId(String str) {
        return this.mConstraintSetIdMap.get(str).intValue();
    }

    public String lookUpConstraintName(int i3) {
        for (Map.Entry<String, Integer> entry : this.mConstraintSetIdMap.entrySet()) {
            if (entry.getValue().intValue() == i3) {
                return entry.getKey();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processScrollMove(float f16, float f17) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollMove(f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processScrollUp(float f16, float f17) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollUp(f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processTouchEvent(MotionEvent motionEvent, int i3, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i3 != -1) {
            int action = motionEvent.getAction();
            boolean z16 = false;
            if (action != 0) {
                if (action == 2 && !this.mIgnoreTouch) {
                    float rawY = motionEvent.getRawY() - this.mLastTouchY;
                    float rawX = motionEvent.getRawX() - this.mLastTouchX;
                    if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.mLastTouchDown) == null) {
                        return;
                    }
                    Transition bestTransitionFor = bestTransitionFor(i3, rawX, rawY, motionEvent2);
                    if (bestTransitionFor != null) {
                        motionLayout.setTransition(bestTransitionFor);
                        RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion != null && !touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            z16 = true;
                        }
                        this.mMotionOutsideRegion = z16;
                        this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                    }
                }
            } else {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo != null && !limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = true;
                        return;
                    }
                    RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mMotionOutsideRegion = true;
                    } else {
                        this.mMotionOutsideRegion = false;
                    }
                    this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                    return;
                }
                return;
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null && !this.mMotionOutsideRegion) {
            this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i3, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() == 1 && (motionTracker = this.mVelocityTracker) != null) {
            motionTracker.recycle();
            this.mVelocityTracker = null;
            int i16 = motionLayout.mCurrentState;
            if (i16 != -1) {
                autoTransition(motionLayout, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readFallback(MotionLayout motionLayout) {
        for (int i3 = 0; i3 < this.mConstraintSetMap.size(); i3++) {
            int keyAt = this.mConstraintSetMap.keyAt(i3);
            if (hasCycleDependency(keyAt)) {
                Log.e(TAG, "Cannot be derived from yourself");
                return;
            }
            readConstraintChain(keyAt);
        }
        for (int i16 = 0; i16 < this.mConstraintSetMap.size(); i16++) {
            this.mConstraintSetMap.valueAt(i16).readFallback(motionLayout);
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i3, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i3, constraintSet);
    }

    public void setDuration(int i3) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i3);
        } else {
            this.mDefaultDuration = i3;
        }
    }

    public void setKeyframe(View view, int i3, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            Iterator<Key> it5 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it5.hasNext()) {
                if (it5.next().mFramePosition == i3) {
                    if (obj != null) {
                        ((Float) obj).floatValue();
                    }
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean z16) {
        this.mRtl = z16;
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != (-1)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTransition(int i3, int i16) {
        int i17;
        int i18;
        StateSet stateSet = this.mStateSet;
        if (stateSet != null) {
            i17 = stateSet.stateGetConstraintID(i3, -1, -1);
            if (i17 == -1) {
                i17 = i3;
            }
            i18 = this.mStateSet.stateGetConstraintID(i16, -1, -1);
        } else {
            i17 = i3;
        }
        i18 = i16;
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if ((next.mConstraintSetEnd == i18 && next.mConstraintSetStart == i17) || (next.mConstraintSetEnd == i16 && next.mConstraintSetStart == i3)) {
                this.mCurrentTransition = next;
                if (next == null || next.mTouchResponse == null) {
                    return;
                }
                this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                return;
            }
        }
        Transition transition = this.mDefaultTransition;
        Iterator<Transition> it5 = this.mAbstractTransitionList.iterator();
        while (it5.hasNext()) {
            Transition next2 = it5.next();
            if (next2.mConstraintSetEnd == i16) {
                transition = next2;
            }
        }
        Transition transition2 = new Transition(this, transition);
        transition2.mConstraintSetStart = i17;
        transition2.mConstraintSetEnd = i18;
        if (i17 != -1) {
            this.mTransitionList.add(transition2);
        }
        this.mCurrentTransition = transition2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setupTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supportTouch() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mTouchResponse != null) {
                return true;
            }
        }
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            return true;
        }
        return false;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        if (motionLayout == this.mMotionLayout && motionLayout.mScene == this) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int i3) {
        return getConstraintSet(i3, -1, -1);
    }

    ConstraintSet getConstraintSet(int i3, int i16, int i17) {
        int stateGetConstraintID;
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + i3);
            System.out.println("size " + this.mConstraintSetMap.size());
        }
        StateSet stateSet = this.mStateSet;
        if (stateSet != null && (stateGetConstraintID = stateSet.stateGetConstraintID(i3, i16, i17)) != -1) {
            i3 = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i3) == null) {
            Log.e(TAG, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i3) + " In MotionScene");
            SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.mConstraintSetMap.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionScene(Context context, MotionLayout motionLayout, int i3) {
        this.mMotionLayout = motionLayout;
        load(context, i3);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i16 = R.id.motion_base;
        sparseArray.put(i16, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(i16));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i3 = 0; i3 < indexCount; i3++) {
                    int index = obtainStyledAttributes.getIndex(i3);
                    if (index == R.styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            public void addOnClickListeners(MotionLayout motionLayout, int i3, Transition transition) {
                boolean z16;
                boolean z17;
                boolean z18;
                boolean z19;
                int i16 = this.mTargetId;
                MotionLayout motionLayout2 = motionLayout;
                if (i16 != -1) {
                    motionLayout2 = motionLayout.findViewById(i16);
                }
                if (motionLayout2 != null) {
                    int i17 = transition.mConstraintSetStart;
                    int i18 = transition.mConstraintSetEnd;
                    if (i17 == -1) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    int i19 = this.mMode;
                    boolean z26 = false;
                    if ((i19 & 1) != 0 && i3 == i17) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if ((i19 & 256) != 0 && i3 == i17) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    boolean z27 = z16 | z17;
                    if ((i19 & 1) != 0 && i3 == i17) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    boolean z28 = z18 | z27;
                    if ((i19 & 16) != 0 && i3 == i18) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    boolean z29 = z28 | z19;
                    if ((i19 & 4096) != 0 && i3 == i18) {
                        z26 = true;
                    }
                    if (z29 | z26) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    return;
                }
                Log.e(MotionScene.TAG, "OnClick could not find id " + this.mTargetId);
            }

            boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 != transition) {
                    int i3 = transition2.mConstraintSetEnd;
                    int i16 = this.mTransition.mConstraintSetStart;
                    if (i16 == -1) {
                        if (motionLayout.mCurrentState != i3) {
                            return true;
                        }
                        return false;
                    }
                    int i17 = motionLayout.mCurrentState;
                    if (i17 == i16 || i17 == i3) {
                        return true;
                    }
                    return false;
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                boolean z16;
                boolean z17;
                boolean z18;
                EventCollector.getInstance().onViewClickedBefore(view);
                MotionLayout motionLayout = this.mTransition.mMotionScene.mMotionLayout;
                if (motionLayout.isInteractionEnabled()) {
                    if (this.mTransition.mConstraintSetStart == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.mTransition.mConstraintSetEnd);
                        } else {
                            Transition transition = new Transition(this.mTransition.mMotionScene, this.mTransition);
                            transition.mConstraintSetStart = currentState;
                            transition.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                            motionLayout.setTransition(transition);
                            motionLayout.transitionToEnd();
                        }
                    } else {
                        Transition transition2 = this.mTransition.mMotionScene.mCurrentTransition;
                        int i3 = this.mMode;
                        boolean z19 = false;
                        if ((i3 & 1) == 0 && (i3 & 256) == 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if ((i3 & 16) == 0 && (i3 & 4096) == 0) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (z16 && z17) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            Transition transition3 = this.mTransition.mMotionScene.mCurrentTransition;
                            Transition transition4 = this.mTransition;
                            if (transition3 != transition4) {
                                motionLayout.setTransition(transition4);
                            }
                            if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                                z17 = false;
                            }
                            if (isTransitionViable(transition2, motionLayout)) {
                                if (z19 && (this.mMode & 1) != 0) {
                                    motionLayout.setTransition(this.mTransition);
                                    motionLayout.transitionToEnd();
                                } else if (z17 && (this.mMode & 16) != 0) {
                                    motionLayout.setTransition(this.mTransition);
                                    motionLayout.transitionToStart();
                                } else if (z19 && (this.mMode & 256) != 0) {
                                    motionLayout.setTransition(this.mTransition);
                                    motionLayout.setProgress(1.0f);
                                } else if (z17 && (this.mMode & 4096) != 0) {
                                    motionLayout.setTransition(this.mTransition);
                                    motionLayout.setProgress(0.0f);
                                }
                            }
                        }
                        z19 = z16;
                        if (isTransitionViable(transition2, motionLayout)) {
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i3 = this.mTargetId;
                if (i3 == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i3);
                if (findViewById == null) {
                    Log.e(MotionScene.TAG, " (*)  could not find id " + this.mTargetId);
                    return;
                }
                findViewById.setOnClickListener(null);
            }
        }

        Transition(MotionScene motionScene, Transition transition) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, this.mConstraintSetEnd);
                    if (TtmlNode.TAG_LAYOUT.equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    if (TtmlNode.TAG_LAYOUT.equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i16 = typedArray.peekValue(index).type;
                    if (i16 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i16 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string.indexOf("/") > 0) {
                            this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                            this.mDefaultInterpolator = -2;
                        } else {
                            this.mDefaultInterpolator = -1;
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    this.mDuration = typedArray.getInt(index, this.mDuration);
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public String debugString(Context context) {
            String resourceEntryName;
            if (this.mConstraintSetStart == -1) {
                resourceEntryName = "null";
            } else {
                resourceEntryName = context.getResources().getResourceEntryName(this.mConstraintSetStart);
            }
            if (this.mConstraintSetEnd == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i3) {
            if ((i3 & this.mTransitionFlags) != 0) {
                return true;
            }
            return false;
        }

        public void setAutoTransition(int i3) {
            this.mAutoTransition = i3;
        }

        public void setDuration(int i3) {
            this.mDuration = i3;
        }

        public void setEnable(boolean z16) {
            this.mDisable = !z16;
        }

        public void setPathMotionArc(int i3) {
            this.mPathMotionArc = i3;
        }

        public void setStagger(float f16) {
            this.mStagger = f16;
        }

        public Transition(int i3, MotionScene motionScene, int i16, int i17) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = i3;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i16;
            this.mConstraintSetEnd = i17;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }

    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
