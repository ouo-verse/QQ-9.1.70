package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public int findMatch(float f16, float f17) {
            for (int i3 = 0; i3 < this.mVariants.size(); i3++) {
                if (this.mVariants.get(i3).match(f16, f17)) {
                    return i3;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean match(float f16, float f17) {
            if (!Float.isNaN(this.mMinWidth) && f16 < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f17 < this.mMinHeight) {
                return false;
            }
            if (!Float.isNaN(this.mMaxWidth) && f16 > this.mMaxWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMaxHeight) && f17 > this.mMaxHeight) {
                return false;
            }
            return true;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    private void load(Context context, XmlPullParser xmlPullParser) {
        char c16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.StateSet_defaultState) {
                this.mDefaultState = obtainStyledAttributes.getResourceId(index, this.mDefaultState);
            }
        }
        obtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            State state = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            continue;
                        } else if ("StateSet".equals(xmlPullParser.getName())) {
                            return;
                        }
                    } else {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case 80204913:
                                if (name.equals("State")) {
                                    c16 = 2;
                                    break;
                                }
                                break;
                            case 1301459538:
                                if (name.equals("LayoutDescription")) {
                                    c16 = 0;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c16 = 1;
                                    break;
                                }
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c16 = 3;
                                    break;
                                }
                                break;
                        }
                        c16 = '\uffff';
                        if (c16 != 0 && c16 != 1) {
                            if (c16 != 2) {
                                if (c16 != 3) {
                                    Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                } else {
                                    Variant variant = new Variant(context, xmlPullParser);
                                    if (state != null) {
                                        state.add(variant);
                                    }
                                }
                            } else {
                                state = new State(context, xmlPullParser);
                                this.mStateList.put(state.mId, state);
                            }
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (XmlPullParserException e17) {
            e17.printStackTrace();
        }
    }

    public int convertToConstraintSet(int i3, int i16, float f16, float f17) {
        State state = this.mStateList.get(i16);
        if (state == null) {
            return i16;
        }
        if (f16 != -1.0f && f17 != -1.0f) {
            Iterator<Variant> it = state.mVariants.iterator();
            Variant variant = null;
            while (it.hasNext()) {
                Variant next = it.next();
                if (next.match(f16, f17)) {
                    if (i3 == next.mConstraintID) {
                        return i3;
                    }
                    variant = next;
                }
            }
            if (variant != null) {
                return variant.mConstraintID;
            }
            return state.mConstraintID;
        }
        if (state.mConstraintID == i3) {
            return i3;
        }
        Iterator<Variant> it5 = state.mVariants.iterator();
        while (it5.hasNext()) {
            if (i3 == it5.next().mConstraintID) {
                return i3;
            }
        }
        return state.mConstraintID;
    }

    public boolean needsToChange(int i3, float f16, float f17) {
        State state;
        int i16 = this.mCurrentStateId;
        if (i16 != i3) {
            return true;
        }
        if (i3 == -1) {
            state = this.mStateList.valueAt(0);
        } else {
            state = this.mStateList.get(i16);
        }
        State state2 = state;
        int i17 = this.mCurrentConstraintNumber;
        if ((i17 == -1 || !state2.mVariants.get(i17).match(f16, f17)) && this.mCurrentConstraintNumber != state2.findMatch(f16, f17)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i3, int i16, int i17) {
        return updateConstraints(-1, i3, i16, i17);
    }

    public int updateConstraints(int i3, int i16, float f16, float f17) {
        State state;
        if (i3 == i16) {
            if (i16 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.mCurrentStateId);
            }
            if (state == null) {
                return -1;
            }
            if (this.mCurrentConstraintNumber != -1 && state.mVariants.get(i3).match(f16, f17)) {
                return i3;
            }
            int findMatch = state.findMatch(f16, f17);
            if (i3 == findMatch) {
                return i3;
            }
            if (findMatch == -1) {
                return state.mConstraintID;
            }
            return state.mVariants.get(findMatch).mConstraintID;
        }
        State state2 = this.mStateList.get(i16);
        if (state2 == null) {
            return -1;
        }
        int findMatch2 = state2.findMatch(f16, f17);
        if (findMatch2 == -1) {
            return state2.mConstraintID;
        }
        return state2.mVariants.get(findMatch2).mConstraintID;
    }
}
