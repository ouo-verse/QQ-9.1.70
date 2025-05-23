package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    ConstraintSet mDefaultConstraintSet;
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
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            this.mConstraintID = -1;
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
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
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
        ConstraintSet mConstraintSet;
        int mId;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i3) {
        this.mConstraintLayout = constraintLayout;
        load(context, i3);
    }

    private void load(Context context, int i3) {
        char c16;
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            State state = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c16 = 4;
                                    break;
                                }
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    c16 = 2;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c16 = 1;
                                    break;
                                }
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    c16 = 0;
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
                                    if (c16 != 4) {
                                        Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                    } else {
                                        parseConstraintSet(context, xml);
                                    }
                                } else {
                                    Variant variant = new Variant(context, xml);
                                    if (state != null) {
                                        state.add(variant);
                                    }
                                }
                            } else {
                                state = new State(context, xml);
                                this.mStateList.put(state.mId, state);
                            }
                        }
                    }
                } else {
                    xml.getName();
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (XmlPullParserException e17) {
            e17.printStackTrace();
        }
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        int i3;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i16 = 0; i16 < attributeCount; i16++) {
            if ("id".equals(xmlPullParser.getAttributeName(i16))) {
                String attributeValue = xmlPullParser.getAttributeValue(i16);
                if (attributeValue.contains("/")) {
                    i3 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i3 = -1;
                }
                if (i3 == -1) {
                    if (attributeValue.length() > 1) {
                        i3 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(i3, constraintSet);
                return;
            }
        }
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

    public void updateConstraints(int i3, float f16, float f17) {
        ConstraintSet constraintSet;
        int i16;
        State state;
        int findMatch;
        ConstraintSet constraintSet2;
        int i17;
        int i18 = this.mCurrentStateId;
        if (i18 == i3) {
            if (i3 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(i18);
            }
            int i19 = this.mCurrentConstraintNumber;
            if ((i19 != -1 && state.mVariants.get(i19).match(f16, f17)) || this.mCurrentConstraintNumber == (findMatch = state.findMatch(f16, f17))) {
                return;
            }
            if (findMatch == -1) {
                constraintSet2 = this.mDefaultConstraintSet;
            } else {
                constraintSet2 = state.mVariants.get(findMatch).mConstraintSet;
            }
            if (findMatch == -1) {
                i17 = state.mConstraintID;
            } else {
                i17 = state.mVariants.get(findMatch).mConstraintID;
            }
            if (constraintSet2 == null) {
                return;
            }
            this.mCurrentConstraintNumber = findMatch;
            ConstraintsChangedListener constraintsChangedListener = this.mConstraintsChangedListener;
            if (constraintsChangedListener != null) {
                constraintsChangedListener.preLayoutChange(-1, i17);
            }
            constraintSet2.applyTo(this.mConstraintLayout);
            ConstraintsChangedListener constraintsChangedListener2 = this.mConstraintsChangedListener;
            if (constraintsChangedListener2 != null) {
                constraintsChangedListener2.postLayoutChange(-1, i17);
                return;
            }
            return;
        }
        this.mCurrentStateId = i3;
        State state2 = this.mStateList.get(i3);
        int findMatch2 = state2.findMatch(f16, f17);
        if (findMatch2 == -1) {
            constraintSet = state2.mConstraintSet;
        } else {
            constraintSet = state2.mVariants.get(findMatch2).mConstraintSet;
        }
        if (findMatch2 == -1) {
            i16 = state2.mConstraintID;
        } else {
            i16 = state2.mVariants.get(findMatch2).mConstraintID;
        }
        if (constraintSet == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i3 + ", dim =" + f16 + ", " + f17);
            return;
        }
        this.mCurrentConstraintNumber = findMatch2;
        ConstraintsChangedListener constraintsChangedListener3 = this.mConstraintsChangedListener;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.preLayoutChange(i3, i16);
        }
        constraintSet.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener constraintsChangedListener4 = this.mConstraintsChangedListener;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.postLayoutChange(i3, i16);
        }
    }
}
