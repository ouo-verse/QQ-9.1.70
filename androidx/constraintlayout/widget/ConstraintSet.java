package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant;
    private boolean mValidate;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mForceId = true;
    private HashMap<Integer, Constraint> mConstraints = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Constraint {
        int mViewId;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFrom(int i3, ConstraintLayout.LayoutParams layoutParams) {
            this.mViewId = i3;
            Layout layout = this.layout;
            layout.leftToLeft = layoutParams.leftToLeft;
            layout.leftToRight = layoutParams.leftToRight;
            layout.rightToLeft = layoutParams.rightToLeft;
            layout.rightToRight = layoutParams.rightToRight;
            layout.topToTop = layoutParams.topToTop;
            layout.topToBottom = layoutParams.topToBottom;
            layout.bottomToTop = layoutParams.bottomToTop;
            layout.bottomToBottom = layoutParams.bottomToBottom;
            layout.baselineToBaseline = layoutParams.baselineToBaseline;
            layout.startToEnd = layoutParams.startToEnd;
            layout.startToStart = layoutParams.startToStart;
            layout.endToStart = layoutParams.endToStart;
            layout.endToEnd = layoutParams.endToEnd;
            layout.horizontalBias = layoutParams.horizontalBias;
            layout.verticalBias = layoutParams.verticalBias;
            layout.dimensionRatio = layoutParams.dimensionRatio;
            layout.circleConstraint = layoutParams.circleConstraint;
            layout.circleRadius = layoutParams.circleRadius;
            layout.circleAngle = layoutParams.circleAngle;
            layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout.orientation = layoutParams.orientation;
            layout.guidePercent = layoutParams.guidePercent;
            layout.guideBegin = layoutParams.guideBegin;
            layout.guideEnd = layoutParams.guideEnd;
            layout.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.verticalWeight = layoutParams.verticalWeight;
            layout.horizontalWeight = layoutParams.horizontalWeight;
            layout.verticalChainStyle = layoutParams.verticalChainStyle;
            layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout.constrainedWidth = layoutParams.constrainedWidth;
            layout.constrainedHeight = layoutParams.constrainedHeight;
            layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout.widthMax = layoutParams.matchConstraintMaxWidth;
            layout.heightMax = layoutParams.matchConstraintMaxHeight;
            layout.widthMin = layoutParams.matchConstraintMinWidth;
            layout.heightMin = layoutParams.matchConstraintMinHeight;
            layout.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout.mConstraintTag = layoutParams.constraintTag;
            layout.goneTopMargin = layoutParams.goneTopMargin;
            layout.goneBottomMargin = layoutParams.goneBottomMargin;
            layout.goneLeftMargin = layoutParams.goneLeftMargin;
            layout.goneRightMargin = layoutParams.goneRightMargin;
            layout.goneStartMargin = layoutParams.goneStartMargin;
            layout.goneEndMargin = layoutParams.goneEndMargin;
            layout.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper constraintHelper, int i3, Constraints.LayoutParams layoutParams) {
            fillFromConstraints(i3, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout = this.layout;
                layout.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str);
                if (constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
            this.mCustomConstraints.put(str, constraintAttribute2);
            return constraintAttribute2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorValue(String str, int i3) {
            get(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(String str, float f16) {
            get(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(String str, int i3) {
            get(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String str, String str2) {
            get(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.layout;
            layoutParams.leftToLeft = layout.leftToLeft;
            layoutParams.leftToRight = layout.leftToRight;
            layoutParams.rightToLeft = layout.rightToLeft;
            layoutParams.rightToRight = layout.rightToRight;
            layoutParams.topToTop = layout.topToTop;
            layoutParams.topToBottom = layout.topToBottom;
            layoutParams.bottomToTop = layout.bottomToTop;
            layoutParams.bottomToBottom = layout.bottomToBottom;
            layoutParams.baselineToBaseline = layout.baselineToBaseline;
            layoutParams.startToEnd = layout.startToEnd;
            layoutParams.startToStart = layout.startToStart;
            layoutParams.endToStart = layout.endToStart;
            layoutParams.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
            layoutParams.goneStartMargin = layout.goneStartMargin;
            layoutParams.goneEndMargin = layout.goneEndMargin;
            layoutParams.goneTopMargin = layout.goneTopMargin;
            layoutParams.goneBottomMargin = layout.goneBottomMargin;
            layoutParams.horizontalBias = layout.horizontalBias;
            layoutParams.verticalBias = layout.verticalBias;
            layoutParams.circleConstraint = layout.circleConstraint;
            layoutParams.circleRadius = layout.circleRadius;
            layoutParams.circleAngle = layout.circleAngle;
            layoutParams.dimensionRatio = layout.dimensionRatio;
            layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            layoutParams.verticalWeight = layout.verticalWeight;
            layoutParams.horizontalWeight = layout.horizontalWeight;
            layoutParams.verticalChainStyle = layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            layoutParams.constrainedWidth = layout.constrainedWidth;
            layoutParams.constrainedHeight = layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout.widthMax;
            layoutParams.matchConstraintMaxHeight = layout.heightMax;
            layoutParams.matchConstraintMinWidth = layout.widthMin;
            layoutParams.matchConstraintMinHeight = layout.heightMin;
            layoutParams.matchConstraintPercentWidth = layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout.heightPercent;
            layoutParams.orientation = layout.orientation;
            layoutParams.guidePercent = layout.guidePercent;
            layoutParams.guideBegin = layout.guideBegin;
            layoutParams.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.setMarginStart(layout.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Constraint m36clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            return constraint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(int i3, Constraints.LayoutParams layoutParams) {
            fillFrom(i3, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform = this.transform;
            transform.rotation = layoutParams.rotation;
            transform.rotationX = layoutParams.rotationX;
            transform.rotationY = layoutParams.rotationY;
            transform.scaleX = layoutParams.scaleX;
            transform.scaleY = layoutParams.scaleY;
            transform.transformPivotX = layoutParams.transformPivotX;
            transform.transformPivotY = layoutParams.transformPivotY;
            transform.translationX = layoutParams.translationX;
            transform.translationY = layoutParams.translationY;
            transform.translationZ = layoutParams.translationZ;
            transform.elevation = layoutParams.elevation;
            transform.applyElevation = layoutParams.applyElevation;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        private static final int UNUSED = 76;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public String mConstraintTag;
        public int mHeight;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public boolean mApply = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = -1;
        public int rightMargin = -1;
        public int topMargin = -1;
        public int bottomMargin = -1;
        public int endMargin = -1;
        public int startMargin = -1;
        public int goneLeftMargin = -1;
        public int goneTopMargin = -1;
        public int goneRightMargin = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneStartMargin = -1;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = -1;
        public int heightMax = -1;
        public int widthMin = -1;
        public int heightMin = -1;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
            mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R.styleable.Layout_barrierDirection, 72);
            mapToConstant.append(R.styleable.Layout_barrierMargin, 73);
            mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr != null) {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.mReferenceIds = null;
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
        }

        public void dump(MotionScene motionScene, StringBuilder sb5) {
            Field[] declaredFields = getClass().getDeclaredFields();
            sb5.append("\n");
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                Object lookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                                sb5.append("    ");
                                sb5.append(name);
                                sb5.append(" = \"");
                                sb5.append(lookUpConstraintName == null ? num : lookUpConstraintName);
                                sb5.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float f16 = (Float) obj;
                            if (f16.floatValue() != -1.0f) {
                                sb5.append("    ");
                                sb5.append(name);
                                sb5.append(" = \"");
                                sb5.append(f16);
                                sb5.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }

        void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i16 = mapToConstant.get(index);
                if (i16 != 80) {
                    if (i16 != 81) {
                        switch (i16) {
                            case 1:
                                this.baselineToBaseline = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                                break;
                            case 2:
                                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                                break;
                            case 3:
                                this.bottomToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                                break;
                            case 4:
                                this.bottomToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                                break;
                            case 5:
                                this.dimensionRatio = obtainStyledAttributes.getString(index);
                                break;
                            case 6:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 7:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 8:
                                this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                                break;
                            case 9:
                                this.endToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                                break;
                            case 10:
                                this.endToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                                break;
                            case 11:
                                this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                                break;
                            case 12:
                                this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                                break;
                            case 13:
                                this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                                break;
                            case 14:
                                this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                                break;
                            case 15:
                                this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                                break;
                            case 16:
                                this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                                break;
                            case 17:
                                this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                                break;
                            case 18:
                                this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                                break;
                            case 19:
                                this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                                break;
                            case 20:
                                this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                                break;
                            case 21:
                                this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                                break;
                            case 22:
                                this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                                break;
                            case 23:
                                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                                break;
                            case 24:
                                this.leftToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                                break;
                            case 25:
                                this.leftToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                                break;
                            case 26:
                                this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                                break;
                            case 27:
                                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                                break;
                            case 28:
                                this.rightToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                                break;
                            case 29:
                                this.rightToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                                break;
                            case 30:
                                this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                                break;
                            case 31:
                                this.startToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                                break;
                            case 32:
                                this.startToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                                break;
                            case 33:
                                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                                break;
                            case 34:
                                this.topToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                                break;
                            case 35:
                                this.topToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                                break;
                            case 36:
                                this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                                break;
                            case 37:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 38:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 39:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                                break;
                            case 40:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                                break;
                            default:
                                switch (i16) {
                                    case 54:
                                        this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                        break;
                                    case 55:
                                        this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                        break;
                                    case 56:
                                        this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        break;
                                    case 57:
                                        this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        break;
                                    case 58:
                                        this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        break;
                                    case 59:
                                        this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        break;
                                    default:
                                        switch (i16) {
                                            case 61:
                                                this.circleConstraint = ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                                break;
                                            case 62:
                                                this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                                break;
                                            case 63:
                                                this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                                break;
                                            default:
                                                switch (i16) {
                                                    case 69:
                                                        this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                        break;
                                                    case 70:
                                                        this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                        break;
                                                    case 71:
                                                        Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
                                                        break;
                                                    case 72:
                                                        this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                        break;
                                                    case 73:
                                                        this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                        break;
                                                    case 74:
                                                        this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                                        break;
                                                    case 75:
                                                        this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                        break;
                                                    case 76:
                                                        Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                                        break;
                                                    case 77:
                                                        this.mConstraintTag = obtainStyledAttributes.getString(index);
                                                        break;
                                                    default:
                                                        Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                    }
                } else {
                    this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Motion {
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 6;
        private static final int PATH_MOTION_ARC = 2;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public float mPathRotate = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animate_relativeTo, 5);
            mapToConstant.append(R.styleable.Motion_motionStagger, 6);
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
        }

        void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }

        void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R.styleable.Transform_android_elevation, 11);
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }

        void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animate_relativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (this.mSavedAttributes.containsKey(strArr[i3])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i3]);
                if (constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                this.mSavedAttributes.put(strArr[i3], new ConstraintAttribute(strArr[i3], attributeType));
            }
        }
    }

    private int[] convertReferenceString(View view, String str) {
        int i3;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i16 = 0;
        int i17 = 0;
        while (i16 < split.length) {
            String trim = split[i16].trim();
            try {
                i3 = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i3 = 0;
            }
            if (i3 == 0) {
                i3 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i3 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i3 = ((Integer) designInformation).intValue();
            }
            iArr[i17] = i3;
            i16++;
            i17++;
        }
        if (i17 != split.length) {
            return Arrays.copyOf(iArr, i17);
        }
        return iArr;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Constraint);
        populateConstraint(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint get(int i3) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i3))) {
            this.mConstraints.put(Integer.valueOf(i3), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lookupID(TypedArray typedArray, int i3, int i16) {
        int resourceId = typedArray.getResourceId(i3, i16);
        if (resourceId == -1) {
            return typedArray.getInt(i3, -1);
        }
        return resourceId;
    }

    private void populateConstraint(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.baselineToBaseline = lookupID(typedArray, index, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.bottomToBottom = lookupID(typedArray, index, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = lookupID(typedArray, index, layout4.bottomToTop);
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    Layout layout7 = constraint.layout;
                    layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                    break;
                case 9:
                    Layout layout8 = constraint.layout;
                    layout8.endToEnd = lookupID(typedArray, index, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = constraint.layout;
                    layout9.endToStart = lookupID(typedArray, index, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = constraint.layout;
                    layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = constraint.layout;
                    layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = constraint.layout;
                    layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = constraint.layout;
                    layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = constraint.layout;
                    layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = constraint.layout;
                    layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = constraint.layout;
                    layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = constraint.layout;
                    layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = constraint.layout;
                    layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = constraint.layout;
                    layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = constraint.layout;
                    layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = constraint.propertySet;
                    propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = constraint.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = constraint.layout;
                    layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = constraint.layout;
                    layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = constraint.layout;
                    layout23.leftToLeft = lookupID(typedArray, index, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = constraint.layout;
                    layout24.leftToRight = lookupID(typedArray, index, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = constraint.layout;
                    layout25.orientation = typedArray.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = constraint.layout;
                    layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = constraint.layout;
                    layout27.rightToLeft = lookupID(typedArray, index, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = constraint.layout;
                    layout28.rightToRight = lookupID(typedArray, index, layout28.rightToRight);
                    break;
                case 31:
                    Layout layout29 = constraint.layout;
                    layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                    break;
                case 32:
                    Layout layout30 = constraint.layout;
                    layout30.startToEnd = lookupID(typedArray, index, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = constraint.layout;
                    layout31.startToStart = lookupID(typedArray, index, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = constraint.layout;
                    layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = constraint.layout;
                    layout33.topToBottom = lookupID(typedArray, index, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = constraint.layout;
                    layout34.topToTop = lookupID(typedArray, index, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = constraint.layout;
                    layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    Layout layout36 = constraint.layout;
                    layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = constraint.layout;
                    layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = constraint.layout;
                    layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = constraint.layout;
                    layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.propertySet;
                    propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    Transform transform = constraint.transform;
                    transform.applyElevation = true;
                    transform.elevation = typedArray.getDimension(index, transform.elevation);
                    break;
                case 45:
                    Transform transform2 = constraint.transform;
                    transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = constraint.transform;
                    transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = constraint.transform;
                    transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = constraint.transform;
                    transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = constraint.transform;
                    transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = constraint.transform;
                    transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = constraint.transform;
                    transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = constraint.transform;
                    transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    Transform transform10 = constraint.transform;
                    transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                    break;
                case 54:
                    Layout layout40 = constraint.layout;
                    layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = constraint.layout;
                    layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = constraint.layout;
                    layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = constraint.layout;
                    layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = constraint.layout;
                    layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = constraint.layout;
                    layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = constraint.transform;
                    transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = constraint.layout;
                    layout46.circleConstraint = lookupID(typedArray, index, layout46.circleConstraint);
                    break;
                case 62:
                    Layout layout47 = constraint.layout;
                    layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = constraint.layout;
                    layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = constraint.motion;
                    motion.mAnimateRelativeTo = lookupID(typedArray, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        constraint.motion.mTransitionEasing = typedArray.getString(index);
                        break;
                    } else {
                        constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.motion;
                    motion2.mPathRotate = typedArray.getFloat(index, motion2.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.propertySet;
                    propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = constraint.layout;
                    layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = constraint.layout;
                    layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.layout;
                    layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = constraint.motion;
                    motion3.mPathMotionArc = typedArray.getInt(index, motion3.mPathMotionArc);
                    break;
                case 77:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.propertySet;
                    propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion4 = constraint.motion;
                    motion4.mMotionStagger = typedArray.getFloat(index, motion4.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = constraint.layout;
                    layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = constraint.layout;
                    layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
            }
        }
    }

    private String sideToString(int i3) {
        switch (i3) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private static String[] splitString(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        boolean z16 = false;
        for (int i16 = 0; i16 < charArray.length; i16++) {
            char c16 = charArray[i16];
            if (c16 == ',' && !z16) {
                arrayList.add(new String(charArray, i3, i16 - i3));
                i3 = i16 + 1;
            } else if (c16 == '\"') {
                z16 = !z16;
            }
        }
        arrayList.add(new String(charArray, i3, charArray.length - i3));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addColorAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i3, int i16, int i17) {
        int i18;
        int i19;
        if (i16 == 0) {
            i18 = 1;
        } else {
            i18 = 2;
        }
        connect(i3, 1, i16, i18, 0);
        if (i17 == 0) {
            i19 = 2;
        } else {
            i19 = 1;
        }
        connect(i3, 2, i17, i19, 0);
        if (i16 != 0) {
            connect(i16, 2, i3, 1, 0);
        }
        if (i17 != 0) {
            connect(i17, 1, i3, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i3, int i16, int i17) {
        int i18;
        int i19;
        if (i16 == 0) {
            i18 = 6;
        } else {
            i18 = 7;
        }
        connect(i3, 6, i16, i18, 0);
        if (i17 == 0) {
            i19 = 7;
        } else {
            i19 = 6;
        }
        connect(i3, 7, i17, i19, 0);
        if (i16 != 0) {
            connect(i16, 7, i3, 6, 0);
        }
        if (i17 != 0) {
            connect(i17, 6, i3, 7, 0);
        }
    }

    public void addToVerticalChain(int i3, int i16, int i17) {
        int i18;
        int i19;
        if (i16 == 0) {
            i18 = 3;
        } else {
            i18 = 4;
        }
        connect(i3, 3, i16, i18, 0);
        if (i17 == 0) {
            i19 = 4;
        } else {
            i19 = 3;
        }
        connect(i3, 4, i17, i19, 0);
        if (i16 != 0) {
            connect(i16, 4, i3, 3, 0);
        }
        if (i17 != 0) {
            connect(i17, 3, i3, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            int id5 = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id5))) {
                Log.v(TAG, "id unknown " + Debug.getName(childAt));
            } else {
                if (this.mForceId && id5 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.mConstraints.containsKey(Integer.valueOf(id5))) {
                    ConstraintAttribute.setAttributes(childAt, this.mConstraints.get(Integer.valueOf(id5)).mCustomConstraints);
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int id5 = constraintHelper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id5))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id5));
            if (constraintWidget instanceof HelperWidget) {
                constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyToInternal(ConstraintLayout constraintLayout, boolean z16) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            int id5 = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id5))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else {
                if (this.mForceId && id5 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id5 != -1) {
                    if (this.mConstraints.containsKey(Integer.valueOf(id5))) {
                        hashSet.remove(Integer.valueOf(id5));
                        Constraint constraint = this.mConstraints.get(Integer.valueOf(id5));
                        if (childAt instanceof Barrier) {
                            constraint.layout.mHelperType = 1;
                        }
                        int i16 = constraint.layout.mHelperType;
                        if (i16 != -1 && i16 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id5);
                            barrier.setType(constraint.layout.mBarrierDirection);
                            barrier.setMargin(constraint.layout.mBarrierMargin);
                            barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                            Layout layout = constraint.layout;
                            int[] iArr = layout.mReferenceIds;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = layout.mReferenceIdString;
                                if (str != null) {
                                    layout.mReferenceIds = convertReferenceString(barrier, str);
                                    barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.validate();
                        constraint.applyTo(layoutParams);
                        if (z16) {
                            ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                        }
                        childAt.setLayoutParams(layoutParams);
                        PropertySet propertySet = constraint.propertySet;
                        if (propertySet.mVisibilityMode == 0) {
                            childAt.setVisibility(propertySet.visibility);
                        }
                        childAt.setAlpha(constraint.propertySet.alpha);
                        childAt.setRotation(constraint.transform.rotation);
                        childAt.setRotationX(constraint.transform.rotationX);
                        childAt.setRotationY(constraint.transform.rotationY);
                        childAt.setScaleX(constraint.transform.scaleX);
                        childAt.setScaleY(constraint.transform.scaleY);
                        if (!Float.isNaN(constraint.transform.transformPivotX)) {
                            childAt.setPivotX(constraint.transform.transformPivotX);
                        }
                        if (!Float.isNaN(constraint.transform.transformPivotY)) {
                            childAt.setPivotY(constraint.transform.transformPivotY);
                        }
                        childAt.setTranslationX(constraint.transform.translationX);
                        childAt.setTranslationY(constraint.transform.translationY);
                        childAt.setTranslationZ(constraint.transform.translationZ);
                        Transform transform = constraint.transform;
                        if (transform.applyElevation) {
                            childAt.setElevation(transform.elevation);
                        }
                    } else {
                        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + id5);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            int i17 = constraint2.layout.mHelperType;
            if (i17 != -1 && i17 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                Layout layout2 = constraint2.layout;
                int[] iArr2 = layout2.mReferenceIds;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = layout2.mReferenceIdString;
                    if (str2 != null) {
                        layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                        barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                    }
                }
                barrier2.setType(constraint2.layout.mBarrierDirection);
                barrier2.setMargin(constraint2.layout.mBarrierMargin);
                ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                constraint2.applyTo(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (constraint2.layout.mIsGuideline) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                constraint2.applyTo(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void applyToLayoutParams(int i3, ConstraintLayout.LayoutParams layoutParams) {
        if (this.mConstraints.containsKey(Integer.valueOf(i3))) {
            this.mConstraints.get(Integer.valueOf(i3)).applyTo(layoutParams);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float f16) {
        if (i18 >= 0) {
            if (i27 >= 0) {
                if (f16 > 0.0f && f16 <= 1.0f) {
                    if (i17 != 1 && i17 != 2) {
                        if (i17 != 6 && i17 != 7) {
                            connect(i3, 3, i16, i17, i18);
                            connect(i3, 4, i19, i26, i27);
                            this.mConstraints.get(Integer.valueOf(i3)).layout.verticalBias = f16;
                            return;
                        } else {
                            connect(i3, 6, i16, i17, i18);
                            connect(i3, 7, i19, i26, i27);
                            this.mConstraints.get(Integer.valueOf(i3)).layout.horizontalBias = f16;
                            return;
                        }
                    }
                    connect(i3, 1, i16, i17, i18);
                    connect(i3, 2, i19, i26, i27);
                    this.mConstraints.get(Integer.valueOf(i3)).layout.horizontalBias = f16;
                    return;
                }
                throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
            }
            throw new IllegalArgumentException("margin must be > 0");
        }
        throw new IllegalArgumentException("margin must be > 0");
    }

    public void centerHorizontally(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float f16) {
        connect(i3, 1, i16, i17, i18);
        connect(i3, 2, i19, i26, i27);
        this.mConstraints.get(Integer.valueOf(i3)).layout.horizontalBias = f16;
    }

    public void centerHorizontallyRtl(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float f16) {
        connect(i3, 6, i16, i17, i18);
        connect(i3, 7, i19, i26, i27);
        this.mConstraints.get(Integer.valueOf(i3)).layout.horizontalBias = f16;
    }

    public void centerVertically(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float f16) {
        connect(i3, 3, i16, i17, i18);
        connect(i3, 4, i19, i26, i27);
        this.mConstraints.get(Integer.valueOf(i3)).layout.verticalBias = f16;
    }

    public void clear(int i3) {
        this.mConstraints.remove(Integer.valueOf(i3));
    }

    public void clone(Context context, int i3) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i3, (ViewGroup) null));
    }

    public void connect(int i3, int i16, int i17, int i18, int i19) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i3))) {
            this.mConstraints.put(Integer.valueOf(i3), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i3));
        switch (i16) {
            case 1:
                if (i18 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i17;
                    layout.leftToRight = -1;
                } else if (i18 == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i17;
                    layout2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(i18) + " undefined");
                }
                constraint.layout.leftMargin = i19;
                return;
            case 2:
                if (i18 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i17;
                    layout3.rightToRight = -1;
                } else if (i18 == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i17;
                    layout4.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
                }
                constraint.layout.rightMargin = i19;
                return;
            case 3:
                if (i18 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i17;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                } else if (i18 == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i17;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
                }
                constraint.layout.topMargin = i19;
                return;
            case 4:
                if (i18 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i17;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                } else if (i18 == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i17;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
                }
                constraint.layout.bottomMargin = i19;
                return;
            case 5:
                if (i18 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i17;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
            case 6:
                if (i18 == 6) {
                    Layout layout10 = constraint.layout;
                    layout10.startToStart = i17;
                    layout10.startToEnd = -1;
                } else if (i18 == 7) {
                    Layout layout11 = constraint.layout;
                    layout11.startToEnd = i17;
                    layout11.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
                }
                constraint.layout.startMargin = i19;
                return;
            case 7:
                if (i18 == 7) {
                    Layout layout12 = constraint.layout;
                    layout12.endToEnd = i17;
                    layout12.endToStart = -1;
                } else if (i18 == 6) {
                    Layout layout13 = constraint.layout;
                    layout13.endToStart = i17;
                    layout13.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
                }
                constraint.layout.endMargin = i19;
                return;
            default:
                throw new IllegalArgumentException(sideToString(i16) + " to " + sideToString(i18) + " unknown");
        }
    }

    public void constrainCircle(int i3, int i16, int i17, float f16) {
        Layout layout = get(i3).layout;
        layout.circleConstraint = i16;
        layout.circleRadius = i17;
        layout.circleAngle = f16;
    }

    public void constrainDefaultHeight(int i3, int i16) {
        get(i3).layout.heightDefault = i16;
    }

    public void constrainDefaultWidth(int i3, int i16) {
        get(i3).layout.widthDefault = i16;
    }

    public void constrainHeight(int i3, int i16) {
        get(i3).layout.mHeight = i16;
    }

    public void constrainMaxHeight(int i3, int i16) {
        get(i3).layout.heightMax = i16;
    }

    public void constrainMaxWidth(int i3, int i16) {
        get(i3).layout.widthMax = i16;
    }

    public void constrainMinHeight(int i3, int i16) {
        get(i3).layout.heightMin = i16;
    }

    public void constrainMinWidth(int i3, int i16) {
        get(i3).layout.widthMin = i16;
    }

    public void constrainPercentHeight(int i3, float f16) {
        get(i3).layout.heightPercent = f16;
    }

    public void constrainPercentWidth(int i3, float f16) {
        get(i3).layout.widthPercent = f16;
    }

    public void constrainWidth(int i3, int i16) {
        get(i3).layout.mWidth = i16;
    }

    public void constrainedHeight(int i3, boolean z16) {
        get(i3).layout.constrainedHeight = z16;
    }

    public void constrainedWidth(int i3, boolean z16) {
        get(i3).layout.constrainedWidth = z16;
    }

    public void create(int i3, int i16) {
        Layout layout = get(i3).layout;
        layout.mIsGuideline = true;
        layout.orientation = i16;
    }

    public void createBarrier(int i3, int i16, int i17, int... iArr) {
        Layout layout = get(i3).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i16;
        layout.mBarrierMargin = i17;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i3, int i16, int i17, int i18, int[] iArr, float[] fArr, int i19) {
        createHorizontalChain(i3, i16, i17, i18, iArr, fArr, i19, 1, 2);
    }

    public void createHorizontalChainRtl(int i3, int i16, int i17, int i18, int[] iArr, float[] fArr, int i19) {
        createHorizontalChain(i3, i16, i17, i18, iArr, fArr, i19, 6, 7);
    }

    public void createVerticalChain(int i3, int i16, int i17, int i18, int[] iArr, float[] fArr, int i19) {
        if (iArr.length >= 2) {
            if (fArr != null && fArr.length != iArr.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (fArr != null) {
                get(iArr[0]).layout.verticalWeight = fArr[0];
            }
            get(iArr[0]).layout.verticalChainStyle = i19;
            connect(iArr[0], 3, i3, i16, 0);
            for (int i26 = 1; i26 < iArr.length; i26++) {
                int i27 = i26 - 1;
                connect(iArr[i26], 3, iArr[i27], 4, 0);
                connect(iArr[i27], 4, iArr[i26], 3, 0);
                if (fArr != null) {
                    get(iArr[i26]).layout.verticalWeight = fArr[i26];
                }
            }
            connect(iArr[iArr.length - 1], 4, i17, i18, 0);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> keySet = this.mConstraints.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int i3 : iArr) {
                hashSet.add(Integer.valueOf(i3));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb5 = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            Constraint constraint = this.mConstraints.get(num);
            sb5.append("<Constraint id=");
            sb5.append(num);
            sb5.append(" \n");
            constraint.layout.dump(motionScene, sb5);
            sb5.append("/>\n");
        }
        System.out.println(sb5.toString());
    }

    public boolean getApplyElevation(int i3) {
        return get(i3).transform.applyElevation;
    }

    public Constraint getConstraint(int i3) {
        if (this.mConstraints.containsKey(Integer.valueOf(i3))) {
            return this.mConstraints.get(Integer.valueOf(i3));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int i3) {
        return get(i3).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i3) {
        return get(i3);
    }

    public int[] getReferencedIds(int i3) {
        int[] iArr = get(i3).layout.mReferenceIds;
        if (iArr == null) {
            return new int[0];
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int i3) {
        return get(i3).propertySet.visibility;
    }

    public int getVisibilityMode(int i3) {
        return get(i3).propertySet.mVisibilityMode;
    }

    public int getWidth(int i3) {
        return get(i3).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (XmlPullParserException e17) {
            e17.printStackTrace();
        }
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i3 = 0; i3 < split.length; i3++) {
            String[] split2 = split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                constraint.setColorValue(split2[0], Color.parseColor(split2[1]));
            } else {
                Log.w(TAG, " Unable to parse " + split[i3]);
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i3 = 0; i3 < split.length; i3++) {
            String[] split2 = split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                constraint.setFloatValue(split2[0], Float.parseFloat(split2[1]));
            } else {
                Log.w(TAG, " Unable to parse " + split[i3]);
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i3 = 0; i3 < split.length; i3++) {
            String[] split2 = split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                constraint.setFloatValue(split2[0], Integer.decode(split2[1]).intValue());
            } else {
                Log.w(TAG, " Unable to parse " + split[i3]);
            }
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        String[] splitString = splitString(str);
        for (int i3 = 0; i3 < splitString.length; i3++) {
            String[] split = splitString[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
            Log.w(TAG, " Unable to parse " + splitString[i3]);
            constraint.setStringValue(split[0], split[1]);
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.mConstraints.keySet()) {
            int intValue = num.intValue();
            Constraint constraint = constraintSet.mConstraints.get(num);
            if (!this.mConstraints.containsKey(Integer.valueOf(intValue))) {
                this.mConstraints.put(Integer.valueOf(intValue), new Constraint());
            }
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(intValue));
            Layout layout = constraint2.layout;
            if (!layout.mApply) {
                layout.copyFrom(constraint.layout);
            }
            PropertySet propertySet = constraint2.propertySet;
            if (!propertySet.mApply) {
                propertySet.copyFrom(constraint.propertySet);
            }
            Transform transform = constraint2.transform;
            if (!transform.mApply) {
                transform.copyFrom(constraint.transform);
            }
            Motion motion = constraint2.motion;
            if (!motion.mApply) {
                motion.copyFrom(constraint.motion);
            }
            for (String str : constraint.mCustomConstraints.keySet()) {
                if (!constraint2.mCustomConstraints.containsKey(str)) {
                    constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.mSavedAttributes.remove(str);
    }

    public void removeFromHorizontalChain(int i3) {
        if (this.mConstraints.containsKey(Integer.valueOf(i3))) {
            Layout layout = this.mConstraints.get(Integer.valueOf(i3)).layout;
            int i16 = layout.leftToRight;
            int i17 = layout.rightToLeft;
            if (i16 == -1 && i17 == -1) {
                int i18 = layout.startToEnd;
                int i19 = layout.endToStart;
                if (i18 != -1 || i19 != -1) {
                    if (i18 != -1 && i19 != -1) {
                        connect(i18, 7, i19, 6, 0);
                        connect(i19, 6, i16, 7, 0);
                    } else if (i16 != -1 || i19 != -1) {
                        int i26 = layout.rightToRight;
                        if (i26 != -1) {
                            connect(i16, 7, i26, 7, 0);
                        } else {
                            int i27 = layout.leftToLeft;
                            if (i27 != -1) {
                                connect(i19, 6, i27, 6, 0);
                            }
                        }
                    }
                }
                clear(i3, 6);
                clear(i3, 7);
                return;
            }
            if (i16 != -1 && i17 != -1) {
                connect(i16, 2, i17, 1, 0);
                connect(i17, 1, i16, 2, 0);
            } else if (i16 != -1 || i17 != -1) {
                int i28 = layout.rightToRight;
                if (i28 != -1) {
                    connect(i16, 2, i28, 2, 0);
                } else {
                    int i29 = layout.leftToLeft;
                    if (i29 != -1) {
                        connect(i17, 1, i29, 1, 0);
                    }
                }
            }
            clear(i3, 1);
            clear(i3, 2);
        }
    }

    public void removeFromVerticalChain(int i3) {
        if (this.mConstraints.containsKey(Integer.valueOf(i3))) {
            Layout layout = this.mConstraints.get(Integer.valueOf(i3)).layout;
            int i16 = layout.topToBottom;
            int i17 = layout.bottomToTop;
            if (i16 != -1 || i17 != -1) {
                if (i16 != -1 && i17 != -1) {
                    connect(i16, 4, i17, 3, 0);
                    connect(i17, 3, i16, 4, 0);
                } else if (i16 != -1 || i17 != -1) {
                    int i18 = layout.bottomToBottom;
                    if (i18 != -1) {
                        connect(i16, 4, i18, 4, 0);
                    } else {
                        int i19 = layout.topToTop;
                        if (i19 != -1) {
                            connect(i17, 3, i19, 3, 0);
                        }
                    }
                }
            }
        }
        clear(i3, 3);
        clear(i3, 4);
    }

    public void setAlpha(int i3, float f16) {
        get(i3).propertySet.alpha = f16;
    }

    public void setApplyElevation(int i3, boolean z16) {
        get(i3).transform.applyElevation = z16;
    }

    public void setBarrierType(int i3, int i16) {
        get(i3).layout.mHelperType = i16;
    }

    public void setColorValue(int i3, String str, int i16) {
        get(i3).setColorValue(str, i16);
    }

    public void setDimensionRatio(int i3, String str) {
        get(i3).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i3, int i16) {
        get(i3).layout.editorAbsoluteX = i16;
    }

    public void setEditorAbsoluteY(int i3, int i16) {
        get(i3).layout.editorAbsoluteY = i16;
    }

    public void setElevation(int i3, float f16) {
        get(i3).transform.elevation = f16;
        get(i3).transform.applyElevation = true;
    }

    public void setFloatValue(int i3, String str, float f16) {
        get(i3).setFloatValue(str, f16);
    }

    public void setForceId(boolean z16) {
        this.mForceId = z16;
    }

    public void setGoneMargin(int i3, int i16, int i17) {
        Constraint constraint = get(i3);
        switch (i16) {
            case 1:
                constraint.layout.goneLeftMargin = i17;
                return;
            case 2:
                constraint.layout.goneRightMargin = i17;
                return;
            case 3:
                constraint.layout.goneTopMargin = i17;
                return;
            case 4:
                constraint.layout.goneBottomMargin = i17;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.layout.goneStartMargin = i17;
                return;
            case 7:
                constraint.layout.goneEndMargin = i17;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i3, int i16) {
        get(i3).layout.guideBegin = i16;
        get(i3).layout.guideEnd = -1;
        get(i3).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i3, int i16) {
        get(i3).layout.guideEnd = i16;
        get(i3).layout.guideBegin = -1;
        get(i3).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i3, float f16) {
        get(i3).layout.guidePercent = f16;
        get(i3).layout.guideEnd = -1;
        get(i3).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i3, float f16) {
        get(i3).layout.horizontalBias = f16;
    }

    public void setHorizontalChainStyle(int i3, int i16) {
        get(i3).layout.horizontalChainStyle = i16;
    }

    public void setHorizontalWeight(int i3, float f16) {
        get(i3).layout.horizontalWeight = f16;
    }

    public void setIntValue(int i3, String str, int i16) {
        get(i3).setIntValue(str, i16);
    }

    public void setMargin(int i3, int i16, int i17) {
        Constraint constraint = get(i3);
        switch (i16) {
            case 1:
                constraint.layout.leftMargin = i17;
                return;
            case 2:
                constraint.layout.rightMargin = i17;
                return;
            case 3:
                constraint.layout.topMargin = i17;
                return;
            case 4:
                constraint.layout.bottomMargin = i17;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.layout.startMargin = i17;
                return;
            case 7:
                constraint.layout.endMargin = i17;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i3, int... iArr) {
        get(i3).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i3, float f16) {
        get(i3).transform.rotation = f16;
    }

    public void setRotationX(int i3, float f16) {
        get(i3).transform.rotationX = f16;
    }

    public void setRotationY(int i3, float f16) {
        get(i3).transform.rotationY = f16;
    }

    public void setScaleX(int i3, float f16) {
        get(i3).transform.scaleX = f16;
    }

    public void setScaleY(int i3, float f16) {
        get(i3).transform.scaleY = f16;
    }

    public void setStringValue(int i3, String str, String str2) {
        get(i3).setStringValue(str, str2);
    }

    public void setTransformPivot(int i3, float f16, float f17) {
        Transform transform = get(i3).transform;
        transform.transformPivotY = f17;
        transform.transformPivotX = f16;
    }

    public void setTransformPivotX(int i3, float f16) {
        get(i3).transform.transformPivotX = f16;
    }

    public void setTransformPivotY(int i3, float f16) {
        get(i3).transform.transformPivotY = f16;
    }

    public void setTranslation(int i3, float f16, float f17) {
        Transform transform = get(i3).transform;
        transform.translationX = f16;
        transform.translationY = f17;
    }

    public void setTranslationX(int i3, float f16) {
        get(i3).transform.translationX = f16;
    }

    public void setTranslationY(int i3, float f16) {
        get(i3).transform.translationY = f16;
    }

    public void setTranslationZ(int i3, float f16) {
        get(i3).transform.translationZ = f16;
    }

    public void setValidateOnParse(boolean z16) {
        this.mValidate = z16;
    }

    public void setVerticalBias(int i3, float f16) {
        get(i3).layout.verticalBias = f16;
    }

    public void setVerticalChainStyle(int i3, int i16) {
        get(i3).layout.verticalChainStyle = i16;
    }

    public void setVerticalWeight(int i3, float f16) {
        get(i3).layout.verticalWeight = f16;
    }

    public void setVisibility(int i3, int i16) {
        get(i3).propertySet.visibility = i16;
    }

    public void setVisibilityMode(int i3, int i16) {
        get(i3).propertySet.mVisibilityMode = i16;
    }

    private void createHorizontalChain(int i3, int i16, int i17, int i18, int[] iArr, float[] fArr, int i19, int i26, int i27) {
        if (iArr.length >= 2) {
            if (fArr != null && fArr.length != iArr.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (fArr != null) {
                get(iArr[0]).layout.horizontalWeight = fArr[0];
            }
            get(iArr[0]).layout.horizontalChainStyle = i19;
            connect(iArr[0], i26, i3, i16, -1);
            for (int i28 = 1; i28 < iArr.length; i28++) {
                int i29 = i28 - 1;
                connect(iArr[i28], i26, iArr[i29], i27, -1);
                connect(iArr[i29], i27, iArr[i28], i26, -1);
                if (fArr != null) {
                    get(iArr[i28]).layout.horizontalWeight = fArr[i28];
                }
            }
            connect(iArr[iArr.length - 1], i27, i17, i18, -1);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void clear(int i3, int i16) {
        if (this.mConstraints.containsKey(Integer.valueOf(i3))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i3));
            switch (i16) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.leftToRight = -1;
                    layout.leftToLeft = -1;
                    layout.leftMargin = -1;
                    layout.goneLeftMargin = -1;
                    return;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.rightToRight = -1;
                    layout2.rightToLeft = -1;
                    layout2.rightMargin = -1;
                    layout2.goneRightMargin = -1;
                    return;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.topToBottom = -1;
                    layout3.topToTop = -1;
                    layout3.topMargin = -1;
                    layout3.goneTopMargin = -1;
                    return;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = -1;
                    layout4.bottomToBottom = -1;
                    layout4.bottomMargin = -1;
                    layout4.goneBottomMargin = -1;
                    return;
                case 5:
                    constraint.layout.baselineToBaseline = -1;
                    return;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.startToEnd = -1;
                    layout5.startToStart = -1;
                    layout5.startMargin = -1;
                    layout5.goneStartMargin = -1;
                    return;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.endToStart = -1;
                    layout6.endToEnd = -1;
                    layout6.endMargin = -1;
                    layout6.goneEndMargin = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (Integer num : constraintSet.mConstraints.keySet()) {
            this.mConstraints.put(num, constraintSet.mConstraints.get(num).m36clone());
        }
    }

    public void centerHorizontally(int i3, int i16) {
        if (i16 == 0) {
            center(i3, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i3, i16, 2, 0, i16, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i3, int i16) {
        if (i16 == 0) {
            center(i3, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i3, i16, 7, 0, i16, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i3, int i16) {
        if (i16 == 0) {
            center(i3, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i3, i16, 4, 0, i16, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id5 = childAt.getId();
            if (this.mForceId && id5 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id5))) {
                this.mConstraints.put(Integer.valueOf(id5), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id5));
            constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
            constraint.fillFrom(id5, layoutParams);
            constraint.propertySet.visibility = childAt.getVisibility();
            constraint.propertySet.alpha = childAt.getAlpha();
            constraint.transform.rotation = childAt.getRotation();
            constraint.transform.rotationX = childAt.getRotationX();
            constraint.transform.rotationY = childAt.getRotationY();
            constraint.transform.scaleX = childAt.getScaleX();
            constraint.transform.scaleY = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                Transform transform = constraint.transform;
                transform.transformPivotX = pivotX;
                transform.transformPivotY = pivotY;
            }
            constraint.transform.translationX = childAt.getTranslationX();
            constraint.transform.translationY = childAt.getTranslationY();
            constraint.transform.translationZ = childAt.getTranslationZ();
            Transform transform2 = constraint.transform;
            if (transform2.applyElevation) {
                transform2.elevation = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                constraint.layout.mReferenceIds = barrier.getReferencedIds();
                constraint.layout.mBarrierDirection = barrier.getType();
                constraint.layout.mBarrierMargin = barrier.getMargin();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0182, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x009c. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void load(Context context, XmlPullParser xmlPullParser) {
        Constraint fillFromAttributeList;
        try {
            int eventType = xmlPullParser.getEventType();
            Constraint constraint = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    char c16 = 3;
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (name.equals("Layout")) {
                                    c16 = 5;
                                    break;
                                }
                                break;
                            case -1984451626:
                                if (name.equals("Motion")) {
                                    c16 = 6;
                                    break;
                                }
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    break;
                                }
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    c16 = 4;
                                    break;
                                }
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    c16 = 1;
                                    break;
                                }
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    c16 = 2;
                                    break;
                                }
                                break;
                            case 1791837707:
                                if (name.equals("CustomAttribute")) {
                                    c16 = 7;
                                    break;
                                }
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    c16 = 0;
                                    break;
                                }
                                break;
                        }
                        c16 = '\uffff';
                        switch (c16) {
                            case 0:
                                fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                constraint = fillFromAttributeList;
                                break;
                            case 1:
                                fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                Layout layout = fillFromAttributeList.layout;
                                layout.mIsGuideline = true;
                                layout.mApply = true;
                                constraint = fillFromAttributeList;
                                break;
                            case 2:
                                fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                fillFromAttributeList.layout.mHelperType = 1;
                                constraint = fillFromAttributeList;
                                break;
                            case 3:
                                if (constraint != null) {
                                    constraint.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                            case 4:
                                if (constraint != null) {
                                    constraint.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                            case 5:
                                if (constraint != null) {
                                    constraint.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                            case 6:
                                if (constraint != null) {
                                    constraint.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                            case 7:
                                if (constraint != null) {
                                    ConstraintAttribute.parse(context, xmlPullParser, constraint.mCustomConstraints);
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                        }
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name2 = xmlPullParser.getName();
                        if (TAG.equals(name2)) {
                            return;
                        }
                        if (name2.equalsIgnoreCase("Constraint")) {
                            this.mConstraints.put(Integer.valueOf(constraint.mViewId), constraint);
                            constraint = null;
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

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id5 = childAt.getId();
            if (this.mForceId && id5 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id5))) {
                this.mConstraints.put(Integer.valueOf(id5), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id5));
            if (!constraint.layout.mApply) {
                constraint.fillFrom(id5, layoutParams);
                if (childAt instanceof ConstraintHelper) {
                    constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                        constraint.layout.mBarrierDirection = barrier.getType();
                        constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                constraint.layout.mApply = true;
            }
            PropertySet propertySet = constraint.propertySet;
            if (!propertySet.mApply) {
                propertySet.visibility = childAt.getVisibility();
                constraint.propertySet.alpha = childAt.getAlpha();
                constraint.propertySet.mApply = true;
            }
            Transform transform = constraint.transform;
            if (!transform.mApply) {
                transform.mApply = true;
                transform.rotation = childAt.getRotation();
                constraint.transform.rotationX = childAt.getRotationX();
                constraint.transform.rotationY = childAt.getRotationY();
                constraint.transform.scaleX = childAt.getScaleX();
                constraint.transform.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    Transform transform2 = constraint.transform;
                    transform2.transformPivotX = pivotX;
                    transform2.transformPivotY = pivotY;
                }
                constraint.transform.translationX = childAt.getTranslationX();
                constraint.transform.translationY = childAt.getTranslationY();
                constraint.transform.translationZ = childAt.getTranslationZ();
                Transform transform3 = constraint.transform;
                if (transform3.applyElevation) {
                    transform3.elevation = childAt.getElevation();
                }
            }
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraints.getChildAt(i3);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id5 = childAt.getId();
            if (this.mForceId && id5 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id5))) {
                this.mConstraints.put(Integer.valueOf(id5), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id5));
            if (childAt instanceof ConstraintHelper) {
                constraint.fillFromConstraints((ConstraintHelper) childAt, id5, layoutParams);
            }
            constraint.fillFromConstraints(id5, layoutParams);
        }
    }

    public void connect(int i3, int i16, int i17, int i18) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i3))) {
            this.mConstraints.put(Integer.valueOf(i3), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i3));
        switch (i16) {
            case 1:
                if (i18 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i17;
                    layout.leftToRight = -1;
                    return;
                } else if (i18 == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i17;
                    layout2.leftToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + sideToString(i18) + " undefined");
                }
            case 2:
                if (i18 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i17;
                    layout3.rightToRight = -1;
                    return;
                } else if (i18 == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i17;
                    layout4.rightToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
                }
            case 3:
                if (i18 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i17;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    return;
                }
                if (i18 == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i17;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
            case 4:
                if (i18 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i17;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    return;
                }
                if (i18 == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i17;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
            case 5:
                if (i18 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i17;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
            case 6:
                if (i18 == 6) {
                    Layout layout10 = constraint.layout;
                    layout10.startToStart = i17;
                    layout10.startToEnd = -1;
                    return;
                } else if (i18 == 7) {
                    Layout layout11 = constraint.layout;
                    layout11.startToEnd = i17;
                    layout11.startToStart = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
                }
            case 7:
                if (i18 == 7) {
                    Layout layout12 = constraint.layout;
                    layout12.endToEnd = i17;
                    layout12.endToStart = -1;
                    return;
                } else if (i18 == 6) {
                    Layout layout13 = constraint.layout;
                    layout13.endToStart = i17;
                    layout13.endToEnd = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i18) + " undefined");
                }
            default:
                throw new IllegalArgumentException(sideToString(i16) + " to " + sideToString(i18) + " unknown");
        }
    }
}
