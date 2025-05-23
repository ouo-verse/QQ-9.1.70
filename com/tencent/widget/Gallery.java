package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import com.tencent.image.GifDrawable;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.QQUIAppSetting;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AdapterView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Gallery extends AbsSpinner implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, GestureDetector.OnDoubleTapListener {
    static IPatchRedirector $redirector_ = null;
    public static int AIO_IMAGE_MAX_SIZE = 0;
    public static final float DEFAULT_DOULE_CLICK_SCALE_FACTOR = 2.0f;
    private static final float HEIGHER_IMGE_FACTOR = 1.5f;
    public static final int ID_CHILD_ROTATEABLE = 2131296390;
    public static final int ID_DEFAULT_ROTATE = 2131296389;
    public static final int ID_DEFAULT_SCALE = 2131296385;
    public static final int ID_LONG_PIC_DOUBLE_TAP_ACTION = 2131296414;
    public static final int ID_LONG_PIC_SCALE = 2131296392;
    public static final int ID_MAX_SCALE = 2131296391;
    public static final int ID_SCALE_DISABLE = 2131296400;
    public static final int ID_USER_DEFINE_CHILDVIEW_MATCH_PARENT = 2131296433;
    public static final int ID_USER_DEFINE_DISABLE_SMALL_PIC_LOGIC = 2131296417;
    public static final int ID_USER_DEFINE_DOUBLE_TAP_SCALE = 2131296413;
    public static final int ID_USER_DEFINE_GRAVITY = 2131296415;
    public static final int ID_USER_DEFINE_HIGH_PIC_DOUBLE_TAP_SCALE = 2131296416;
    public static final int ID_USER_DEFINE_SCALE = 2131296386;
    public static final int ID_VIDEO_TAG = 2131296418;
    public static final int ID_VIEW_TRANSFORMED = 2131296412;
    public static float MAX_SCALE_DEFAULT = 0.0f;
    public static final int NOT_SUPPORT_REGION_DECODE = 102;
    public static final float QZONE_DEFAULT_SCALE = 1.0f;
    public static final int ROTATE_0 = 0;
    public static final int ROTATE_180 = 2;
    public static final int ROTATE_270 = 3;
    public static final int ROTATE_90 = 1;
    protected static final int SCROLL_STATE_IDLE = -1;
    protected static final int SCROLL_STATE_PAGING = 0;
    protected static final int SCROLL_STATE_SCROLLING = 1;
    protected static final int SCROLL_STATE_TOSLOT = 2;
    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    public static final int SUPPORT_REGION_DECODE = 101;
    private static final String TAG = "Gallery";
    public static final int TAG_MATRIX = 2131296388;
    private static final int ZERO = 0;
    private static int defaultminumangle = 0;
    private static final boolean localLOGV = false;
    protected static Rect tmp;
    private static RectF tmp2;
    float beginRotation;
    float beginScale;
    float beginSpan;
    boolean canRotating;

    /* renamed from: dx, reason: collision with root package name */
    private int f384567dx;

    /* renamed from: dy, reason: collision with root package name */
    private int f384568dy;
    float focusX;
    float focusY;
    private boolean interceptTouchEventReturn;
    private boolean isRotateEnable;
    boolean isRotating;
    long lastMoveTime;
    private int mAnimationDuration;
    public boolean mClearByTag;
    private AdapterView.AdapterContextMenuInfo mContextMenuInfo;
    private Runnable mDisableSuppressSelectionChangedRunnable;
    private boolean mDoubleTapEnable;
    private int mDownTouchPosition;
    private View mDownTouchView;
    private FlingRunnable mFlingRunnable;
    private GestureDetector mGestureDetector;
    private int mHeight;
    private int mHeightMultDensity;
    private boolean mIsDoubleTapping;
    private boolean mIsFirstScroll;
    public boolean mIsLayoutScale;
    private boolean mIsLeftEdge;
    private boolean mIsMultiTouch;
    public boolean mIsQzoneDefaultScale;
    private boolean mIsRightedge;
    protected boolean mIsScaling;
    long mLastTime;
    private int mLeftMost;
    private float mMaximumVelocity;
    private float mMaxumScale;
    private int mMinimumVelocity;
    private float mMinumScale;
    OnItemRotateListener mOnItemRotateListener;
    protected OnScollListener mOnScollListener;
    private boolean mOnSizeChanged;
    private boolean mReceivedInvokeKeyDown;
    private int mRightMost;
    private android.view.ScaleGestureDetector mScaleGestureDetector;
    private boolean mScaleGestureEnable;
    protected int mScrollDirection;
    protected int mScrollState;
    private boolean mScrollingRegion;
    protected View mSelectedChild;
    private boolean mShouldCallbackDuringFling;
    private boolean mShouldCallbackOnUnselectedItemClick;
    private boolean mShouldStopFling;
    private int mSpacing;
    private boolean mSupportMatchParent;
    private boolean mSuppressSelectionChanged;
    private VelocityTracker mVelocityTracker;
    private int mWidth;
    private int mWidthMultDensity;
    protected int scrollX;
    protected int scrollY;
    private Matrix tempMatrix;
    Point tmpP;
    double vectorRotation;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        static IPatchRedirector $redirector_;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemRotateListener {
        void onRotateFinished(View view, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScollListener {
        void onScrollEnd(int i3);

        void onScrollStart(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ScaleViewHolder {
        static IPatchRedirector $redirector_;
        int defaultRotate;
        float defaultScale;
        int gravity;
        boolean hasTransformed;
        boolean isHighPic;

        ScaleViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TransformationInfo {
        static IPatchRedirector $redirector_;
        private final Matrix mMatrix;
        boolean mMatrixDirty;
        private boolean mMatrixIsIdentity;

        @ViewDebug.ExportedProperty
        float mPivotX;

        @ViewDebug.ExportedProperty
        float mPivotY;

        @ViewDebug.ExportedProperty
        float mRotation;

        @ViewDebug.ExportedProperty
        float mScaleX;

        @ViewDebug.ExportedProperty
        float mScaleY;

        @ViewDebug.ExportedProperty
        float mTranslationX;

        @ViewDebug.ExportedProperty
        float mTranslationY;

        TransformationInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mMatrix = new Matrix();
            this.mMatrixDirty = false;
            this.mMatrixIsIdentity = true;
            this.mRotation = 0.0f;
            this.mTranslationX = 0.0f;
            this.mTranslationY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 83)) {
            redirector.redirect((short) 83);
            return;
        }
        AIO_IMAGE_MAX_SIZE = 135;
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            AIO_IMAGE_MAX_SIZE = (int) al.a(context, 135.0f);
        }
        tmp = new Rect();
        tmp2 = new RectF();
        MAX_SCALE_DEFAULT = 2.0f;
        defaultminumangle = 20;
    }

    public Gallery(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @TargetApi(11)
    private void applyTransformation(View view, View view2) {
        if (view != view2) {
            if (VersionUtils.isHoneycomb()) {
                setChildScale(view2, view.getPivotX(), view.getPivotY(), view.getScaleX());
            } else {
                view2.setTag(TAG_MATRIX, (TransformationInfo) view.getTag(TAG_MATRIX));
            }
        }
    }

    private void detachOffScreenChildren(boolean z16) {
        int i3;
        int i16;
        int childCount = getChildCount();
        int i17 = this.mFirstPosition;
        if (z16) {
            int paddingLeft = getPaddingLeft();
            i16 = 0;
            i3 = 0;
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                if (getChildBounds(childAt, tmp).right > paddingLeft) {
                    break;
                }
                i16++;
                int i19 = i17 + i18;
                this.mRecycler.put(i19, childAt);
                onViewDetached(i19, childAt, this, z16);
                onViewCreated(i19 + 1, this, z16, true);
                i3 = i18;
            }
        } else {
            int width = getWidth() - getPaddingRight();
            int i26 = 0;
            int i27 = 0;
            for (int i28 = childCount - 1; i28 >= 0; i28--) {
                View childAt2 = getChildAt(i28);
                if (getChildBounds(childAt2, tmp).left < width) {
                    break;
                }
                i27++;
                int i29 = i17 + i28;
                this.mRecycler.put(i29, childAt2);
                onViewDetached(i29, childAt2, this, z16);
                onViewCreated(i29 - 1, this, z16, true);
                i26 = i28;
            }
            i3 = i26;
            i16 = i27;
        }
        detachViewsFromParent(i3, i16);
        if (z16) {
            this.mFirstPosition += i16;
        }
    }

    private boolean dispatchLongPress(View view, int i3, long j3) {
        boolean z16;
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            z16 = onItemLongClickListener.onItemLongClick(this, this.mDownTouchView, i3, j3);
        } else {
            z16 = false;
        }
        if (!z16) {
            this.mContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i3, j3);
            z16 = super.showContextMenuForChild(this);
        }
        if (z16) {
            performHapticFeedback(0);
        }
        return z16;
    }

    private void dispatchPress(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchUnpress() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 0) {
                getChildAt(childCount).setPressed(false);
            } else {
                setPressed(false);
                return;
            }
        }
    }

    private void fillToGalleryLeft() {
        int right;
        if (getChildCount() >= 2) {
            return;
        }
        int i3 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        int i16 = this.mWidth;
        int i17 = 0;
        View childAt = getChildAt(0);
        if (childAt != null) {
            i17 = this.mFirstPosition - 1;
            right = getChildBounds(childAt, tmp).left - i3;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
        }
        while (right > paddingLeft && i17 >= 0) {
            makeAndAddView(i17, i17 - this.mSelectedPosition, right, false, null);
            OnScollListener onScollListener = this.mOnScollListener;
            if (onScollListener != null) {
                onScollListener.onScrollStart(i17);
            }
            this.mFirstPosition = i17;
            right -= i16 + i3;
            i17--;
        }
    }

    private void fillToGalleryRight() {
        int i3;
        int paddingLeft;
        int childCount = getChildCount();
        if (childCount >= 2) {
            return;
        }
        int i16 = this.mSpacing;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int i17 = this.mWidth;
        int i18 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i3 = this.mFirstPosition + childCount;
            paddingLeft = getChildBounds(childAt, tmp).right + i16;
        } else {
            i3 = this.mItemCount - 1;
            this.mFirstPosition = i3;
            paddingLeft = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (paddingLeft < right && i3 < i18) {
            makeAndAddView(i3, i3 - this.mSelectedPosition, paddingLeft, true, null);
            OnScollListener onScollListener = this.mOnScollListener;
            if (onScollListener != null) {
                onScollListener.onScrollStart(i3);
            }
            paddingLeft += i17 + i16;
            i3++;
        }
    }

    public static float getAIOImageScale(int i3, int i16, int i17, int i18) {
        float f16 = 1.0f;
        if (i3 == 0 || i16 == 0) {
            return 1.0f;
        }
        int i19 = (i16 * i17) / i3;
        int i26 = AIO_IMAGE_MAX_SIZE;
        if ((!isLongPhoto(i3, i16) || i3 > i17 || i16 > i18) && (i3 >= i26 || i16 >= i26)) {
            f16 = i18 >= i19 ? i17 / i3 : i18 / i16;
        }
        return Math.min(f16, 2.0f);
    }

    private int getCenterOfGallery() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private static int getCenterOfView(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private ScaleViewHolder getChildGravityAndScale(int i3, int i16, int i17, int i18, View view) {
        int i19;
        boolean z16;
        int i26;
        ScaleViewHolder scaleViewHolder = new ScaleViewHolder();
        boolean z17 = false;
        if (view.getTag(ID_DEFAULT_ROTATE) != null) {
            i19 = ((Integer) view.getTag(ID_DEFAULT_ROTATE)).intValue();
        } else {
            i19 = 0;
        }
        scaleViewHolder.defaultRotate = i19;
        if (view.getTag(ID_USER_DEFINE_GRAVITY) instanceof Integer) {
            scaleViewHolder.gravity = ((Integer) view.getTag(ID_USER_DEFINE_GRAVITY)).intValue();
        } else {
            scaleViewHolder.gravity = 17;
        }
        if (view.getTag(ID_USER_DEFINE_SCALE) != null) {
            scaleViewHolder.defaultScale = ((Float) view.getTag(ID_USER_DEFINE_SCALE)).floatValue();
            return scaleViewHolder;
        }
        if (i19 == 1 || i19 == 3) {
            i16 = i3;
            i3 = i16;
        }
        float aIOImageScale = getAIOImageScale(i3, i16, i17, i18);
        if (i16 >= i3 * 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && ((i3 > i17 || i16 > i18) && (i3 >= (i26 = AIO_IMAGE_MAX_SIZE) || i16 >= i26))) {
            scaleViewHolder.gravity = 49;
            scaleViewHolder.defaultScale = Math.min(i17 / i3, this.mMaxumScale);
            scaleViewHolder.isHighPic = true;
            view.setTag(ID_LONG_PIC_SCALE, Float.valueOf(aIOImageScale));
            if (isNeedSetLongPicAction()) {
                view.setTag(ID_LONG_PIC_DOUBLE_TAP_ACTION, Float.valueOf(scaleViewHolder.defaultScale));
            }
        } else {
            scaleViewHolder.gravity = 17;
            scaleViewHolder.isHighPic = false;
            scaleViewHolder.defaultScale = customScale(view, aIOImageScale, i3);
        }
        if (view.getTag(ID_VIEW_TRANSFORMED) != null && ((Boolean) view.getTag(ID_VIEW_TRANSFORMED)).booleanValue()) {
            z17 = true;
        }
        scaleViewHolder.hasTransformed = z17;
        return scaleViewHolder;
    }

    private Rect getChildLayout(int i3, int i16, int i17, int i18, boolean z16) {
        int i19;
        int i26;
        int i27;
        Rect rect = new Rect();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i28 = i17 & 112;
        if (i28 != 16) {
            if (i28 != 48) {
                if (i28 != 80) {
                    i19 = 0;
                } else {
                    i19 = (measuredHeight - this.mSpinnerPadding.bottom) - i16;
                }
            } else {
                i19 = this.mSpinnerPadding.top;
            }
        } else {
            Rect rect2 = this.mSpinnerPadding;
            int i29 = measuredHeight - rect2.bottom;
            int i36 = rect2.top;
            i19 = (((i29 - i36) - i16) / 2) + i36;
        }
        int i37 = i16 + i19;
        int i38 = i17 & 7;
        if (i38 != 3 && i38 != 5) {
            Rect rect3 = this.mSpinnerPadding;
            int i39 = (((measuredWidth - rect3.left) - rect3.right) - i3) / 2;
            if (z16) {
                i18 += i39;
                i27 = i3 + i18;
            } else {
                i26 = (i18 - i3) - i39;
                i18 -= i39;
                int i46 = i18;
                i18 = i26;
                i27 = i46;
            }
        } else {
            if (!z16) {
                i26 = i18 - i3;
                int i462 = i18;
                i18 = i26;
                i27 = i462;
            }
            i27 = i3 + i18;
        }
        rect.left = i18;
        rect.top = i19;
        rect.right = i27;
        rect.bottom = i37;
        return rect;
    }

    @TargetApi(11)
    private float[] getChildPivot(View view) {
        float f16;
        float f17;
        if (VersionUtils.isHoneycomb()) {
            f16 = view.getPivotX();
            f17 = view.getPivotY();
        } else {
            f16 = getChildTransformationInfo(view).mPivotX;
            f17 = getChildTransformationInfo(view).mPivotY;
        }
        return new float[]{f16, f17};
    }

    @TargetApi(11)
    private float getChildRotation(View view) {
        if (VersionUtils.isHoneycomb()) {
            return view.getRotation();
        }
        return getChildTransformationInfo(view).mRotation;
    }

    private TransformationInfo getChildTransformationInfo(View view) {
        TransformationInfo transformationInfo = (TransformationInfo) view.getTag(TAG_MATRIX);
        if (transformationInfo == null) {
            transformationInfo = new TransformationInfo();
            view.setTag(TAG_MATRIX, transformationInfo);
        }
        if (transformationInfo.mMatrixDirty) {
            updateMatrix(transformationInfo);
        }
        return transformationInfo;
    }

    @TargetApi(11)
    private float[] getChildTranslation(View view) {
        float f16;
        float f17;
        if (VersionUtils.isHoneycomb()) {
            f16 = view.getTranslationX();
            f17 = view.getTranslationY();
        } else {
            TransformationInfo childTransformationInfo = getChildTransformationInfo(view);
            f16 = childTransformationInfo.mTranslationX;
            f17 = childTransformationInfo.mTranslationY;
        }
        return new float[]{f16, f17};
    }

    @TargetApi(11)
    private Rect getImageSize(View view) {
        Matrix matrix;
        if (view == null) {
            return new Rect();
        }
        Rect rect = new Rect();
        tmp2.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        if (!VersionUtils.isHoneycomb()) {
            matrix = getChildTransformationInfo(view).mMatrix;
        } else {
            matrix = view.getMatrix();
        }
        matrix.mapRect(tmp2);
        tmp2.offset(view.getLeft(), view.getTop());
        tmp2.round(rect);
        return rect;
    }

    private double getRadian(float f16, float f17) {
        double d16;
        double atan = Math.atan(f17 / f16);
        if (f16 < 0.0f) {
            d16 = 3.141592653589793d;
        } else if (atan < 0.0d) {
            d16 = 6.283185307179586d;
        } else {
            return atan;
        }
        return atan + d16;
    }

    private static int getRotationFlag(int i3, int i16) {
        if (i3 < 0) {
            i3 += (((-i3) + 360) / 360) * 360;
        }
        if (i3 > 360) {
            i3 %= 360;
        }
        int i17 = defaultminumangle;
        if (i16 == 1 || i16 == 3) {
            i17 = 90 - i17;
        }
        int i18 = 180 - i17;
        int i19 = i17 + 180;
        int i26 = 360 - i17;
        if ((i3 >= 0 && i3 < i17) || i3 >= i26) {
            return 0;
        }
        if (i3 >= i17 && i3 < i18) {
            return 1;
        }
        if (i3 >= i18 && i3 < i19) {
            return 2;
        }
        if (i3 >= i19 && i3 < i26) {
            return 3;
        }
        return 0;
    }

    private static int getRotationInternal(int i3, int i16) {
        if (i3 < -45) {
            i3 += (((-i3) + 360) / 360) * 360;
        } else if (i3 >= 275) {
            i3 -= ((i3 + 360) / 360) * 360;
        }
        int i17 = i3 - (i16 * 90);
        if (i17 > 180) {
            return i3 - 360;
        }
        if (i17 < -180) {
            return i3 + 360;
        }
        return i3;
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    public static boolean isLongPhoto(long j3, long j16) {
        if (j3 < j16 * 3 && j16 < j3 * 3) {
            return false;
        }
        return true;
    }

    private void layoutAndScaleChild(int i3, int i16, int i17, boolean z16, View view) {
        boolean z17;
        boolean z18;
        this.mIsLayoutScale = true;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight != 0 && measuredWidth != 0) {
            ScaleViewHolder childGravityAndScale = getChildGravityAndScale(measuredWidth, measuredHeight, i3, i16, view);
            if (view.getWidth() == measuredWidth && view.getHeight() == measuredHeight) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (childGravityAndScale.defaultRotate * 90 != view.getRotation()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "imgSizeChanged in layoutAndScaleChild is " + Boolean.toString(z17) + " rotateChanged:" + z18);
            }
            int left = view.getLeft();
            layoutChild(view, childGravityAndScale.gravity, i17, z16);
            if (childGravityAndScale.isHighPic && canUpdateRegionRect()) {
                updateShowArea(true);
            }
            if (childGravityAndScale.hasTransformed && !z17 && !z18) {
                int left2 = left - view.getLeft();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "left diff is: " + Integer.toString(left2));
                }
                if (left2 != 0) {
                    setChildTranslation(view, left2, 0);
                }
            } else {
                float f16 = childGravityAndScale.defaultScale;
                if (f16 != 0.0f) {
                    setChildPivot(view, 0.0f, 0.0f);
                    setChildScale(view, f16);
                    setChildRotation(view, childGravityAndScale.defaultRotate * 90);
                    getChildBounds(view, tmp);
                    Rect childLayout = getChildLayout(tmp.width(), tmp.height(), childGravityAndScale.gravity, i17, z16);
                    int i18 = childLayout.left;
                    Rect rect = tmp;
                    setChildTranslation(view, i18 - rect.left, childLayout.top - rect.top);
                }
                view.setTag(ID_DEFAULT_SCALE, Float.valueOf(childGravityAndScale.defaultScale));
                view.setTag(ID_DEFAULT_ROTATE, Integer.valueOf(childGravityAndScale.defaultRotate));
            }
            this.mIsLayoutScale = false;
        }
    }

    private void layoutChild(View view, int i3, int i16, boolean z16) {
        Rect childLayout = getChildLayout(view.getMeasuredWidth(), view.getMeasuredHeight(), i3, i16, z16);
        view.layout(childLayout.left, childLayout.top, childLayout.right, childLayout.bottom);
    }

    private View makeAndAddView(int i3, int i16, int i17, boolean z16, View view) {
        View view2;
        if (!this.mDataChanged && (view2 = this.mRecycler.get(i3)) != null) {
            int left = view2.getLeft();
            this.mRightMost = Math.max(this.mRightMost, view2.getMeasuredWidth() + left);
            this.mLeftMost = Math.min(this.mLeftMost, left);
            setUpChild(view2, i16, i17, z16, true);
            return view2;
        }
        View view3 = this.mAdapter.getView(i3, null, this);
        onViewCreated(i3, this, z16, false);
        View view4 = view3;
        if (view3 == null) {
            Context context = getContext();
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.h7n));
            view4 = imageView;
        }
        setUpChild(view4, i16, i17, z16, false);
        if (view != null) {
            applyTransformation(view, view4);
        }
        return view4;
    }

    private void markViewTransformed(View view) {
        if (view == null) {
            return;
        }
        view.setTag(ID_VIEW_TRANSFORMED, Boolean.TRUE);
    }

    private void onFinishedMovement() {
        if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
            super.selectionChanged();
        }
        invalidate();
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetScrollState() {
        this.mScrollState = -1;
        this.mGestureDetector.setIsLongpressEnabled(true);
    }

    private void scrollIntoSlots() {
        scrollIntoSlots(0.0f);
    }

    @TargetApi(11)
    private void setChildPivot(View view, float f16, float f17) {
        if (view == null) {
            return;
        }
        if (VersionUtils.isHoneycomb()) {
            view.setPivotX(f16);
            view.setPivotY(f17);
            return;
        }
        TransformationInfo childTransformationInfo = getChildTransformationInfo(view);
        if (childTransformationInfo.mPivotX != f16 || childTransformationInfo.mPivotY != f17) {
            childTransformationInfo.mPivotX = f16;
            childTransformationInfo.mPivotY = f17;
            childTransformationInfo.mMatrixDirty = true;
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void setChildRotation(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setRotation(f16);
        markViewTransformed(view);
    }

    private void setChildScale(View view, float f16, float f17, float f18) {
        markViewTransformed(view);
        view.setPivotX(f16);
        view.setPivotY(f17);
        view.setScaleX(f18);
        view.setScaleY(f18);
        view.getMatrix();
        if (isHardwareAccelerated()) {
            return;
        }
        invalidate();
    }

    private void setChildTranslation(View view, int i3, int i16) {
        if (view == null) {
            return;
        }
        view.setTranslationX(view.getTranslationX() + i3);
        view.setTranslationY(view.getTranslationY() + i16);
        markViewTransformed(view);
    }

    @TargetApi(11)
    private void setPivot(float f16, float f17) {
        getChildBounds(this.mSelectedChild, tmp);
        getChildMatrix(this.mSelectedChild).invert(this.tempMatrix);
        float[] fArr = {f16 - this.mSelectedChild.getLeft(), f17 - this.mSelectedChild.getTop()};
        this.tempMatrix.mapPoints(fArr);
        int width = tmp.width() / 2;
        Rect rect = tmp;
        int i3 = width + rect.left;
        int height = (rect.height() / 2) + tmp.top;
        setChildPivot(this.mSelectedChild, fArr[0], fArr[1]);
        getChildBounds(this.mSelectedChild, tmp);
        int width2 = tmp.width() / 2;
        Rect rect2 = tmp;
        int i16 = i3 - (width2 + rect2.left);
        int height2 = height - ((rect2.height() / 2) + tmp.top);
        if (VersionUtils.isHoneycomb()) {
            setChildTranslation(this.mSelectedChild, i16, height2);
        } else {
            this.mSelectedChild.offsetLeftAndRight(i16);
            this.mSelectedChild.offsetTopAndBottom(height2);
        }
    }

    private void setSelectionToCenterChild() {
        int i3 = this.f384567dx;
        int i16 = 0;
        if (i3 > 0) {
            int childCount = getChildCount() - 1;
            this.f384567dx = getChildBounds(getChildAt(childCount), tmp).left;
            int i17 = this.mFirstPosition + childCount;
            this.f384568dy = 0;
            i16 = i17;
        } else if (i3 < 0) {
            int i18 = this.mFirstPosition;
            this.f384567dx = getChildBounds(getChildAt(0), tmp).left;
            this.f384568dy = 0;
            i16 = i18;
        }
        if (i16 != this.mSelectedPosition) {
            setSelectedPositionInt(i16);
            setNextSelectedPositionInt(i16);
            checkSelectionChanged();
        }
    }

    private void setUpChild(View view, int i3, int i16, boolean z16, boolean z17) {
        boolean z18;
        boolean z19;
        boolean z26;
        int i17;
        if (view == null) {
            return;
        }
        boolean z27 = true;
        if (i3 == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 != view.isSelected()) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z17 && !z19 && !view.isLayoutRequested()) {
            z26 = false;
        } else {
            z26 = true;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        if (z16) {
            i17 = -1;
        } else {
            i17 = 0;
        }
        addViewInLayout(view, i17, layoutParams, true);
        if (z19) {
            view.setSelected(z18);
        }
        if (z26) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            if (!this.mSupportMatchParent && (view.getTag(ID_USER_DEFINE_CHILDVIEW_MATCH_PARENT) == null || !((Boolean) view.getTag(ID_USER_DEFINE_CHILDVIEW_MATCH_PARENT)).booleanValue())) {
                z27 = false;
            }
            if (z27 && ((ViewGroup.LayoutParams) layoutParams).height == -1 && ((ViewGroup.LayoutParams) layoutParams).width == -1) {
                int width = getWidth();
                Rect rect = this.mSpinnerPadding;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((width - rect.left) - rect.right, 1073741824);
                int height = getHeight();
                Rect rect2 = this.mSpinnerPadding;
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((height - rect2.top) - rect2.bottom, 1073741824);
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            layoutAndScaleChild(this.mWidth, this.mHeight, i16, z16, view);
        }
    }

    private void updateMatrix(TransformationInfo transformationInfo) {
        if (transformationInfo != null && transformationInfo.mMatrixDirty) {
            transformationInfo.mMatrix.reset();
            transformationInfo.mMatrix.setTranslate(transformationInfo.mTranslationX, transformationInfo.mTranslationY);
            transformationInfo.mMatrix.preRotate(transformationInfo.mRotation, transformationInfo.mPivotX, transformationInfo.mPivotY);
            transformationInfo.mMatrix.preScale(transformationInfo.mScaleX, transformationInfo.mScaleY, transformationInfo.mPivotX, transformationInfo.mPivotY);
            transformationInfo.mMatrixDirty = false;
            transformationInfo.mMatrixIsIdentity = transformationInfo.mMatrix.isIdentity();
        }
    }

    private void updateSelectedItemMetadata() {
        View view = this.mSelectedChild;
        View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        this.mSelectedChild = childAt;
        if (childAt == null) {
            return;
        }
        childAt.setSelected(true);
        childAt.setFocusable(true);
        if (hasFocus()) {
            childAt.requestFocus();
        }
        if (view != null && view != childAt) {
            view.setSelected(false);
            view.setFocusable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShowArea(boolean z16) {
        updateShowArea(z16, 0);
    }

    protected int calculateDampingDeltaX(boolean z16, int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3))).intValue();
        }
        if (z16) {
            i16 = (this.mWidth - this.mSpinnerPadding.right) - tmp.right;
            if (i16 > 0) {
                return i3 / 4;
            }
            if (i3 < i16) {
                i17 = (i3 - i16) / 4;
            } else {
                return i3;
            }
        } else {
            i16 = this.mSpinnerPadding.left - tmp.left;
            if (i16 < 0) {
                return i3 / 4;
            }
            if (i3 > i16) {
                i17 = (i3 - i16) / 4;
            } else {
                return i3;
            }
        }
        return i17 + i16;
    }

    protected boolean canUpdateRegionRect() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Boolean) iPatchRedirector.redirect((short) 73, (Object) this)).booleanValue();
        }
        if (!VersionUtils.isHoneycomb() || (view = this.mSelectedChild) == null) {
            return false;
        }
        if (view.getWidth() * this.mSelectedChild.getHeight() < ((this.mWidthMultDensity * this.mHeightMultDensity) << 2)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) layoutParams)).booleanValue();
        }
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mSelectedPosition;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mItemCount;
    }

    protected float customScale(View view, float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Float) iPatchRedirector.redirect((short) 25, this, view, Float.valueOf(f16), Integer.valueOf(i3))).floatValue();
        }
        if (view.getTag(2131296418) != null) {
            z16 = ((Boolean) view.getTag(2131296418)).booleanValue();
        }
        if (this.mIsQzoneDefaultScale && !z16) {
            return Math.min(1.0f, f16);
        }
        return f16;
    }

    protected void disPatchToParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return keyEvent.dispatch(this, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
            return;
        }
        View view = this.mSelectedChild;
        if (view != null) {
            view.setPressed(z16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, z16);
        }
    }

    public void enableDoubleTap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, z16);
        } else {
            this.mDoubleTapEnable = z16;
        }
    }

    public void enableScaleGesture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, z16);
        } else {
            this.mScaleGestureEnable = z16;
        }
    }

    @Override // com.tencent.widget.AbsSpinner, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 12, (Object) this, (Object) layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(11)
    public Rect getChildBounds(View view, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Rect) iPatchRedirector.redirect((short) 22, (Object) this, (Object) view, (Object) rect);
        }
        if (view == null) {
            return new Rect();
        }
        tmp2.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        getChildMatrix(view).mapRect(tmp2);
        tmp2.offset(view.getLeft(), view.getTop());
        tmp2.round(rect);
        int width = rect.width();
        int i3 = this.mWidth;
        if (width < i3) {
            int width2 = (i3 - rect.width()) / 2;
            rect.set(rect.left - width2, rect.top, rect.right + ((this.mWidth - rect.width()) - width2), rect.bottom);
        }
        return rect;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Integer) iPatchRedirector.redirect((short) 57, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int i17 = this.mSelectedPosition - this.mFirstPosition;
        if (i17 < 0) {
            return i16;
        }
        if (i16 == i3 - 1) {
            return i17;
        }
        if (i16 >= i17) {
            return i16 + 1;
        }
        return i16;
    }

    @Override // com.tencent.widget.AbsSpinner
    int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    public Matrix getChildMatrix(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Matrix) iPatchRedirector.redirect((short) 27, (Object) this, (Object) view);
        }
        if (view == null) {
            return null;
        }
        if (!VersionUtils.isHoneycomb()) {
            return getChildTransformationInfo(view).mMatrix;
        }
        return view.getMatrix();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getChildMaxumScale(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Float) iPatchRedirector.redirect((short) 43, (Object) this, (Object) view)).floatValue();
        }
        return this.mMaxumScale;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(11)
    public float getChildScale(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Float) iPatchRedirector.redirect((short) 28, (Object) this, (Object) view)).floatValue();
        }
        if (VersionUtils.isHoneycomb()) {
            return view.getScaleX();
        }
        return getChildTransformationInfo(view).mScaleX;
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) view, (Object) transformation)).booleanValue();
        }
        TransformationInfo transformationInfo = (TransformationInfo) view.getTag(TAG_MATRIX);
        if (transformationInfo != null) {
            updateMatrix(transformationInfo);
            transformation.getMatrix().set(transformationInfo.mMatrix);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (ContextMenu.ContextMenuInfo) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return this.mContextMenuInfo;
    }

    protected int getLimitedMotionScrollAmount(boolean z16, int i3, int i16, Point point) {
        int i17;
        boolean z17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), point)).intValue();
        }
        if (z16) {
            i17 = this.mItemCount - 1;
        } else {
            i17 = 0;
        }
        if (i16 < 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        View childAt = getChildAt(i17 - this.mFirstPosition);
        if (childAt == null && (i18 = this.mScrollState) != 1 && ((z16 && this.mIsRightedge) || (!z16 && this.mIsLeftEdge))) {
            if (i18 != 0 && Math.abs(i3) <= Math.abs(i16)) {
                getChildBounds(this.mSelectedChild, tmp);
                if (tmp.height() <= this.mHeight) {
                    point.x = 0;
                    point.y = 0;
                    if (!z17) {
                        disPatchToParent();
                    }
                    return this.mScrollState;
                }
                this.mIsRightedge = false;
                this.mIsLeftEdge = false;
            } else {
                point.x = i3;
                point.y = 0;
                this.mScrollState = 0;
                return 0;
            }
        }
        if (this.mScrollState != 0) {
            this.mScrollState = 1;
        }
        if ((z16 && !this.mIsRightedge) || (!z16 && !this.mIsLeftEdge)) {
            childAt = this.mSelectedChild;
        }
        getChildBounds(childAt, tmp);
        int calculateDampingDeltaX = calculateDampingDeltaX(z16, i3);
        this.scrollX += calculateDampingDeltaX;
        this.scrollY += i16;
        int height = tmp.height();
        int i19 = this.mHeight;
        if (height < i19) {
            disPatchToParent();
            i16 = 0;
        } else if (z17) {
            int i26 = (i19 - this.mSpinnerPadding.bottom) - tmp.bottom;
            if (i26 > 0) {
                i16 /= 4;
            } else if (calculateDampingDeltaX < i26) {
                i16 = ((i16 - i26) / 6) + i26;
            }
        } else {
            int i27 = this.mSpinnerPadding.top - tmp.top;
            if (i27 < 0) {
                i16 /= 4;
                disPatchToParent();
            } else if (calculateDampingDeltaX > i27) {
                i16 = ((i16 - i27) / 6) + i27;
            }
        }
        int i28 = this.mWidth;
        if (calculateDampingDeltaX > i28) {
            calculateDampingDeltaX = i28;
        } else if (calculateDampingDeltaX < (-i28)) {
            calculateDampingDeltaX = -i28;
        }
        point.x = calculateDampingDeltaX;
        point.y = i16;
        return this.mScrollState;
    }

    public OnItemRotateListener getOnItemRotateListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (OnItemRotateListener) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        return this.mOnItemRotateListener;
    }

    public OnScollListener getOnScollListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (OnScollListener) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        return this.mOnScollListener;
    }

    public boolean isNeedSetLongPicAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return false;
    }

    public void isQzoneDefaultScale(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, z16);
        } else {
            this.mIsQzoneDefaultScale = z16;
        }
    }

    public boolean isRotateEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
        }
        return this.isRotateEnable;
    }

    public boolean isZoomed() {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Boolean) iPatchRedirector.redirect((short) 78, (Object) this)).booleanValue();
        }
        View view = this.mSelectedChild;
        if (view == null) {
            return false;
        }
        if (view.getTag(ID_LONG_PIC_SCALE) != null) {
            f16 = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_SCALE)).floatValue();
        } else if (this.mSelectedChild.getTag(ID_DEFAULT_SCALE) != null) {
            f16 = ((Float) this.mSelectedChild.getTag(ID_DEFAULT_SCALE)).floatValue();
        } else if (this.mSelectedChild.getTag(ID_USER_DEFINE_SCALE) instanceof Float) {
            f16 = ((Float) this.mSelectedChild.getTag(ID_USER_DEFINE_SCALE)).floatValue();
        } else {
            f16 = 1.0f;
        }
        if (Math.abs(getChildScale(this.mSelectedChild) - f16) < 1.0E-5d) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.widget.AbsSpinner
    void layout(int i3, boolean z16) {
        View view;
        boolean z17;
        View view2;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        int childCount = getChildCount();
        int i16 = this.mSelectedPosition - this.mFirstPosition;
        if (i16 >= 0 && i16 < childCount) {
            view = getChildAt(i16);
        } else {
            view = null;
        }
        int i17 = this.mNextSelectedPosition;
        if (i17 >= 0) {
            setSelectedPositionInt(i17);
        }
        recycleAllViews();
        detachAllViewsFromParent();
        if (this.mOnSizeChanged) {
            this.mRecycler.clear();
            this.f384568dy = 0;
            this.f384567dx = 0;
            view = null;
        }
        this.mRightMost = 0;
        this.mLeftMost = 0;
        this.mFirstPosition = this.mSelectedPosition;
        if (getAdapter().hasStableIds() && view != null && this.mSelectedRowId == this.mOldSelectedRowId) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i18 = this.mSelectedPosition;
        int i19 = this.f384567dx;
        if (z17) {
            view2 = view;
        } else {
            view2 = null;
        }
        makeAndAddView(i18, 0, i19, true, view2);
        if (this.f384567dx < 0) {
            fillToGalleryRight();
        } else {
            fillToGalleryLeft();
        }
        if (this.mShouldStopFling) {
            this.f384567dx = 0;
            this.f384568dy = 0;
        }
        if (this.mClearByTag) {
            this.mRecycler.clearByTag();
        } else {
            this.mRecycler.clear();
        }
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
    }

    boolean moveNext() {
        return false;
    }

    boolean movePrevious() {
        return false;
    }

    void onCancel() {
        onUp();
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mDoubleTapEnable) {
            return true;
        }
        this.mIsDoubleTapping = true;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (this.mSelectedChild != null) {
            setPivot(x16, y16);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return true;
    }

    public boolean onDown(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean z17 = false;
        if (this.mScrollState == 2) {
            this.mScrollState = 0;
        } else {
            resetScrollState();
        }
        this.mFlingRunnable.stop(false);
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        this.mDownTouchPosition = pointToPosition;
        if (pointToPosition >= 0) {
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            this.mDownTouchView = childAt;
            childAt.setPressed(true);
        }
        this.mIsFirstScroll = true;
        this.scrollX = 0;
        this.scrollY = 0;
        getChildBounds(this.mSelectedChild, tmp);
        int width = tmp.width();
        int i3 = this.mWidth;
        if (width == i3) {
            this.mIsRightedge = true;
            this.mIsLeftEdge = true;
        } else {
            Rect rect = tmp;
            if (rect.left == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsLeftEdge = z16;
            if (rect.right == i3) {
                z17 = true;
            }
            this.mIsRightedge = z17;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (!this.mShouldCallbackDuringFling) {
            removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
            if (!this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = true;
            }
        }
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float xVelocity = this.mVelocityTracker.getXVelocity();
        float yVelocity = this.mVelocityTracker.getYVelocity();
        if (getChildCount() <= 1) {
            getChildBounds(this.mSelectedChild, tmp);
            int i3 = this.mWidth;
            int i16 = this.mSpinnerPadding.left;
            Rect rect = tmp;
            int i17 = (i3 + i16) - rect.right;
            int i18 = i16 - rect.left;
            if (rect.height() < this.mHeight && tmp.width() <= this.mWidth) {
                scrollIntoSlots();
            } else {
                int height = tmp.height();
                int i19 = this.mHeight;
                if (height < i19) {
                    int i26 = this.mSpinnerPadding.top;
                    Rect rect2 = tmp;
                    int i27 = rect2.bottom;
                    int i28 = rect2.top;
                    int i29 = (i26 + (((i19 - i27) + i28) / 2)) - i28;
                    int i36 = (i19 - (((i19 - i27) + i28) / 2)) - i27;
                    float sqrt = (float) Math.sqrt((xVelocity * xVelocity) + (yVelocity * yVelocity));
                    float f18 = this.mMaximumVelocity;
                    if (sqrt > f18) {
                        xVelocity = (xVelocity * f18) / sqrt;
                        yVelocity = 0.0f;
                    }
                    this.mFlingRunnable.startUsingVelocity((int) xVelocity, (int) yVelocity, i17, i18, i29, i36);
                } else {
                    int i37 = this.mSpinnerPadding.top;
                    Rect rect3 = tmp;
                    int i38 = (i19 + i37) - rect3.bottom;
                    int i39 = i37 - rect3.top;
                    float sqrt2 = (float) Math.sqrt((xVelocity * xVelocity) + (yVelocity * yVelocity));
                    float f19 = this.mMaximumVelocity;
                    if (sqrt2 > f19) {
                        xVelocity = (xVelocity * f19) / sqrt2;
                        yVelocity = (yVelocity * f19) / sqrt2;
                    }
                    this.mFlingRunnable.startUsingVelocity((int) xVelocity, (int) yVelocity, i17, i18, i38, i39);
                }
            }
        } else if (xVelocity < 0.0f) {
            int i46 = getChildBounds(getChildAt(1), tmp).left;
            getChildBounds(getChildAt(0), tmp);
            if (i46 == 0) {
                return true;
            }
            int i47 = (int) xVelocity;
            int calcFlingDistance = this.mFlingRunnable.calcFlingDistance(i46, i47);
            int i48 = this.mSpinnerPadding.left;
            if (calcFlingDistance <= i48) {
                this.mFlingRunnable.startUsingVelocity(i47, 0, i48 - i46, Integer.MAX_VALUE, 0, 0);
            } else if (xVelocity < (-this.mMinimumVelocity)) {
                this.mFlingRunnable.startUsingDistance(i48 - i46, 0);
            } else {
                scrollIntoSlots();
            }
        } else {
            int i49 = this.mWidth + this.mSpinnerPadding.left;
            int i56 = getChildBounds(getChildAt(0), tmp).right;
            if (i56 == i49) {
                return true;
            }
            int i57 = (int) xVelocity;
            if (this.mFlingRunnable.calcFlingDistance(i56, i57) >= i49) {
                this.mFlingRunnable.startUsingVelocity(i57, 0, Integer.MIN_VALUE, i49 - i56, 0, 0);
            } else if (xVelocity > this.mMinimumVelocity) {
                this.mFlingRunnable.startUsingDistance(i49 - i56, 0);
            } else {
                scrollIntoSlots();
            }
        }
        if (this.mScrollState == 0) {
            this.mScrollState = 2;
        }
        if (this.mScrollingRegion) {
            this.mScrollingRegion = false;
        }
        return true;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z16, int i3, Rect rect) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, Boolean.valueOf(z16), Integer.valueOf(i3), rect);
            return;
        }
        super.onFocusChanged(z16, i3, rect);
        if (z16 && (view = this.mSelectedChild) != null) {
            view.requestFocus(i3);
            this.mSelectedChild.setSelected(true);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.interceptTouchEventReturn;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 != 66) {
            switch (i3) {
                case 21:
                    if (movePrevious()) {
                        playSoundEffect(1);
                    }
                    return true;
                case 22:
                    if (moveNext()) {
                        playSoundEffect(3);
                    }
                    return true;
            }
            return super.onKeyDown(i3, keyEvent);
        }
        this.mReceivedInvokeKeyDown = true;
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 != 23 && i3 != 66) {
            return super.onKeyUp(i3, keyEvent);
        }
        if (this.mReceivedInvokeKeyDown && this.mItemCount > 0) {
            dispatchPress(this.mSelectedChild);
            postDelayed(new Runnable() { // from class: com.tencent.widget.Gallery.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Gallery.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        Gallery.this.dispatchUnpress();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, ViewConfiguration.getPressedStateDuration());
            View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
            int i16 = this.mSelectedPosition;
            performItemClick(childAt, i16, this.mAdapter.getItemId(i16));
        }
        this.mReceivedInvokeKeyDown = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        float f16 = getResources().getDisplayMetrics().density;
        int right = getRight() - getLeft();
        Rect rect = this.mSpinnerPadding;
        this.mWidth = (right - rect.left) - rect.right;
        int bottom = getBottom() - getTop();
        Rect rect2 = this.mSpinnerPadding;
        this.mHeight = (bottom - rect2.top) - rect2.bottom;
        this.mWidthMultDensity = (int) Math.ceil(this.mWidth * f16);
        this.mHeightMultDensity = (int) Math.ceil(this.mHeight * f16);
        this.mInLayout = true;
        layout(0, false);
        this.mInLayout = false;
        this.mOnSizeChanged = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) motionEvent);
        } else {
            if (this.mIsMultiTouch) {
                return;
            }
            dispatchLongPress(this.mDownTouchView, this.mSelectedPosition, getItemIdAtPosition(this.mSelectedPosition));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsSpinner, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    @TargetApi(11)
    public boolean onScale(android.view.ScaleGestureDetector scaleGestureDetector) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        if (this.mSelectedChild == null || this.mScrollState == 0) {
            return false;
        }
        float focusX = scaleGestureDetector.getFocusX();
        float focusY = scaleGestureDetector.getFocusY();
        float f17 = focusX - this.focusX;
        float f18 = focusY - this.focusY;
        this.focusX = focusX;
        this.focusY = focusY;
        if (VersionUtils.isHoneycomb()) {
            setChildTranslation(this.mSelectedChild, (int) f17, (int) f18);
        } else {
            this.mSelectedChild.offsetLeftAndRight((int) f17);
            this.mSelectedChild.offsetTopAndBottom((int) f18);
        }
        setPivot(focusX, focusY);
        float currentSpan = scaleGestureDetector.getCurrentSpan() / this.beginSpan;
        float f19 = this.beginScale * currentSpan;
        if (this.mSelectedChild.getTag(ID_LONG_PIC_SCALE) != null) {
            f16 = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_SCALE)).floatValue();
        } else if (this.mSelectedChild.getTag(ID_DEFAULT_SCALE) != null) {
            f16 = ((Float) this.mSelectedChild.getTag(ID_DEFAULT_SCALE)).floatValue();
        } else {
            if (!QQUIAppSetting.isPublicVersion() && !QQUIAppSetting.isGrayVersion()) {
                throw new RuntimeException("gallery null scale");
            }
            f16 = 1.0f;
        }
        float f26 = 0.6f;
        if (f16 <= 1.0f) {
            f26 = 0.6f * f16 * f16 * 0.6f;
        }
        if (f19 < f26) {
            f19 = f26;
        } else {
            float f27 = this.mMaxumScale;
            if (f19 > f27 * 1.5f) {
                f19 = f27 * 1.5f;
            }
        }
        setChildScale(this.mSelectedChild, f19);
        Boolean bool = (Boolean) this.mSelectedChild.getTag(ID_CHILD_ROTATEABLE);
        if (this.isRotateEnable && this.canRotating && bool != null && bool.booleanValue()) {
            if (this.isRotating) {
                float radian = (float) (((getRadian(scaleGestureDetector.getCurrentSpanX(), scaleGestureDetector.getCurrentSpanY()) - this.vectorRotation) / 3.141592653589793d) * 180.0d);
                if (radian > 180.0f) {
                    radian -= 360.0f;
                }
                setChildRotation(this.mSelectedChild, radian + this.beginRotation);
            } else if (currentSpan <= 0.95f) {
                this.isRotating = true;
                float radian2 = (float) (((getRadian(scaleGestureDetector.getCurrentSpanX(), scaleGestureDetector.getCurrentSpanY()) - this.vectorRotation) / 3.141592653589793d) * 180.0d);
                if (radian2 > 180.0f) {
                    radian2 -= 360.0f;
                }
                setChildRotation(this.mSelectedChild, radian2 + this.beginRotation);
            } else if (currentSpan >= 1.05f) {
                this.canRotating = false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onScaleBegin(android.view.ScaleGestureDetector scaleGestureDetector) {
        float f16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        this.isRotating = false;
        if (this.mSelectedChild == null || this.mScrollState == 0) {
            return false;
        }
        if (!VersionUtils.isHoneycomb()) {
            View view = this.mSelectedChild;
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof URLDrawable) && (((URLDrawable) drawable).getCurrDrawable() instanceof GifDrawable)) {
                    return false;
                }
                this.vectorRotation = getRadian(scaleGestureDetector.getCurrentSpanX(), scaleGestureDetector.getCurrentSpanY());
                this.beginRotation = getChildRotation(this.mSelectedChild);
                if (this.mSelectedChild.getTag(ID_LONG_PIC_SCALE) == null) {
                    f16 = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_SCALE)).floatValue();
                } else if (this.mSelectedChild.getTag(ID_DEFAULT_SCALE) != null) {
                    f16 = ((Float) this.mSelectedChild.getTag(ID_DEFAULT_SCALE)).floatValue();
                } else {
                    f16 = 1.0f;
                }
                if (getChildScale(this.mSelectedChild) > f16 + 1.0E-5f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.canRotating = z16;
                float focusX = scaleGestureDetector.getFocusX();
                float focusY = scaleGestureDetector.getFocusY();
                this.mIsLeftEdge = false;
                this.mIsRightedge = false;
                setPivot(focusX, focusY);
                this.focusX = focusX;
                this.focusY = focusY;
                this.beginSpan = scaleGestureDetector.getCurrentSpan();
                this.beginScale = getChildScale(this.mSelectedChild);
                this.mIsScaling = true;
                if (canUpdateRegionRect()) {
                    updateShowArea(false);
                }
                return true;
            }
        }
        if (this.mSelectedChild.getTag(ID_SCALE_DISABLE) != null && (this.mSelectedChild.getTag(ID_SCALE_DISABLE) instanceof Boolean) && ((Boolean) this.mSelectedChild.getTag(ID_SCALE_DISABLE)).booleanValue()) {
            return false;
        }
        this.vectorRotation = getRadian(scaleGestureDetector.getCurrentSpanX(), scaleGestureDetector.getCurrentSpanY());
        this.beginRotation = getChildRotation(this.mSelectedChild);
        if (this.mSelectedChild.getTag(ID_LONG_PIC_SCALE) == null) {
        }
        if (getChildScale(this.mSelectedChild) > f16 + 1.0E-5f) {
        }
        this.canRotating = z16;
        float focusX2 = scaleGestureDetector.getFocusX();
        float focusY2 = scaleGestureDetector.getFocusY();
        this.mIsLeftEdge = false;
        this.mIsRightedge = false;
        setPivot(focusX2, focusY2);
        this.focusX = focusX2;
        this.focusY = focusY2;
        this.beginSpan = scaleGestureDetector.getCurrentSpan();
        this.beginScale = getChildScale(this.mSelectedChild);
        this.mIsScaling = true;
        if (canUpdateRegionRect()) {
        }
        return true;
    }

    public void onScaleEnd(android.view.ScaleGestureDetector scaleGestureDetector) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) scaleGestureDetector);
            return;
        }
        View view = this.mSelectedChild;
        if (view != null) {
            if (view.getTag(ID_LONG_PIC_SCALE) != null) {
                f16 = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_SCALE)).floatValue();
            } else if (this.mSelectedChild.getTag(ID_DEFAULT_SCALE) != null) {
                f16 = ((Float) this.mSelectedChild.getTag(ID_DEFAULT_SCALE)).floatValue();
            } else {
                f16 = 1.0f;
            }
            float childScale = getChildScale(this.mSelectedChild);
            if (childScale > f16 && childScale <= this.mMaxumScale) {
                if (canUpdateRegionRect()) {
                    updateShowArea(true);
                } else {
                    onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
                }
            } else {
                updateShowArea(false);
            }
        }
        resetScrollState();
        this.canRotating = true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.mShouldCallbackDuringFling) {
            if (this.mIsFirstScroll) {
                if (!this.mSuppressSelectionChanged) {
                    this.mSuppressSelectionChanged = true;
                }
                postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
            }
        } else if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
        }
        trackMotionScroll(((int) f16) * (-1), ((int) f17) * (-1), true);
        if (this.mSelectedChild != null && this.mScrollState == 1 && canUpdateRegionRect()) {
            if (!this.mScrollingRegion) {
                this.mScrollingRegion = true;
            }
            updateShowArea(true, 1);
        }
        this.mIsFirstScroll = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, Integer.valueOf(i3), view, regionDrawableData);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) motionEvent);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) motionEvent)).booleanValue();
        }
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter != null) {
            View view = this.mDownTouchView;
            int i3 = this.mSelectedPosition;
            performItemClick(view, i3, spinnerAdapter.getItemId(i3));
            return true;
        }
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onSizeChanged(i3, i16, i17, i18);
            this.mOnSizeChanged = true;
        }
    }

    protected void onSlotChanged(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, Integer.valueOf(i3), view, viewGroup);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mItemCount == 0) {
            return false;
        }
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        if (motionEvent.getPointerCount() > 1) {
            this.mIsMultiTouch = true;
            if (this.mScaleGestureEnable) {
                onTouchEvent = this.mScaleGestureDetector.onTouchEvent(motionEvent);
            }
            onTouchEvent = false;
        } else {
            if (!this.mIsScaling) {
                this.mIsMultiTouch = false;
                onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
            }
            onTouchEvent = false;
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            onUp();
            recycleVelocityTracker();
            this.mIsScaling = false;
        } else if (action == 3) {
            onCancel();
            recycleVelocityTracker();
            this.mIsScaling = false;
        }
        if ((action & 255) == 2) {
            this.lastMoveTime = AnimationUtils.currentAnimationTimeMillis();
        }
        return onTouchEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onUp() {
        boolean z16;
        float f16;
        int i3;
        int measuredHeight;
        int measuredWidth;
        boolean z17;
        boolean z18;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        if (!VersionUtils.isHoneycomb()) {
            View view = this.mSelectedChild;
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof URLDrawable) && (((URLDrawable) drawable).getCurrDrawable() instanceof GifDrawable)) {
                    z16 = true;
                    if (!this.mIsDoubleTapping && !z16) {
                        this.mIsLeftEdge = false;
                        this.mIsRightedge = false;
                        View view2 = this.mSelectedChild;
                        if (view2 != null) {
                            if (!(view2.getTag(ID_SCALE_DISABLE) instanceof Boolean) || !((Boolean) this.mSelectedChild.getTag(ID_SCALE_DISABLE)).booleanValue()) {
                                float childScale = getChildScale(this.mSelectedChild);
                                if (this.mSelectedChild.getTag(ID_LONG_PIC_SCALE) != null) {
                                    if (isNeedSetLongPicAction()) {
                                        f16 = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_DOUBLE_TAP_ACTION)).floatValue();
                                        if (Math.abs(childScale - f16) < 1.0E-5d) {
                                            f16 = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_SCALE)).floatValue();
                                        }
                                    } else {
                                        f16 = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_SCALE)).floatValue();
                                    }
                                } else if (this.mSelectedChild.getTag(ID_DEFAULT_SCALE) != null) {
                                    f16 = ((Float) this.mSelectedChild.getTag(ID_DEFAULT_SCALE)).floatValue();
                                } else {
                                    f16 = 1.0f;
                                }
                                if (Math.abs(childScale - f16) < 1.0E-5d) {
                                    int measuredWidth2 = getMeasuredWidth();
                                    int measuredHeight2 = getMeasuredHeight();
                                    if (this.mSelectedChild.getTag(ID_DEFAULT_ROTATE) != null) {
                                        i3 = ((Integer) this.mSelectedChild.getTag(ID_DEFAULT_ROTATE)).intValue();
                                    } else {
                                        i3 = 0;
                                    }
                                    if (i3 != 1 && i3 != 3) {
                                        measuredHeight = this.mSelectedChild.getMeasuredWidth();
                                        measuredWidth = this.mSelectedChild.getMeasuredHeight();
                                    } else {
                                        measuredHeight = this.mSelectedChild.getMeasuredHeight();
                                        measuredWidth = this.mSelectedChild.getMeasuredWidth();
                                    }
                                    if (measuredHeight <= measuredWidth2 && measuredWidth <= measuredHeight2) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    if (measuredWidth >= measuredHeight * 3) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z17 && (!(this.mSelectedChild.getTag(ID_USER_DEFINE_DISABLE_SMALL_PIC_LOGIC) instanceof Boolean) || !((Boolean) this.mSelectedChild.getTag(ID_USER_DEFINE_DISABLE_SMALL_PIC_LOGIC)).booleanValue())) {
                                        if (this.mSelectedChild.getTag(ID_USER_DEFINE_DOUBLE_TAP_SCALE) != null) {
                                            f17 = ((Float) this.mSelectedChild.getTag(ID_USER_DEFINE_DOUBLE_TAP_SCALE)).floatValue();
                                        } else {
                                            f17 = this.mMaxumScale;
                                        }
                                    } else if (z18) {
                                        f17 = Math.min(measuredWidth2 / measuredHeight, this.mMaxumScale);
                                        if (this.mSelectedChild.getTag(ID_USER_DEFINE_HIGH_PIC_DOUBLE_TAP_SCALE) instanceof Float) {
                                            f17 = ((Float) this.mSelectedChild.getTag(ID_USER_DEFINE_HIGH_PIC_DOUBLE_TAP_SCALE)).floatValue();
                                        }
                                    } else {
                                        Rect imageSize = getImageSize(this.mSelectedChild);
                                        int i16 = imageSize.right - imageSize.left;
                                        int i17 = imageSize.bottom - imageSize.top;
                                        if (i16 < measuredWidth2) {
                                            float f18 = measuredWidth2;
                                            if (i16 * 1.5f < f18) {
                                                f17 = f18 / measuredHeight;
                                            }
                                            f17 = f16 * 2.0f;
                                        } else {
                                            float f19 = measuredHeight2;
                                            if (i17 * 1.5f < f19) {
                                                f17 = f19 / measuredWidth;
                                            }
                                            f17 = f16 * 2.0f;
                                        }
                                    }
                                    f16 = Math.min(f17, this.mMaxumScale);
                                }
                                if (childScale < f16) {
                                    if (!canUpdateRegionRect()) {
                                        onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
                                    }
                                } else if (canUpdateRegionRect()) {
                                    updateShowArea(false);
                                }
                                scrollIntoSlots(f16);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (this.mFlingRunnable.mScroller.isFinished()) {
                        scrollIntoSlots();
                        if (this.mScrollState == 0) {
                            this.mScrollState = 2;
                        }
                    }
                    this.mIsDoubleTapping = false;
                    dispatchUnpress();
                    if (!this.mScrollingRegion) {
                        this.mScrollingRegion = false;
                        this.mScrollDirection = 0;
                        if (canUpdateRegionRect()) {
                            updateShowArea(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        z16 = false;
        if (!this.mIsDoubleTapping) {
        }
        if (this.mFlingRunnable.mScroller.isFinished()) {
        }
        this.mIsDoubleTapping = false;
        dispatchUnpress();
        if (!this.mScrollingRegion) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onUpForQzone(float f16, boolean z16) {
        boolean z17;
        float f17;
        int i3;
        int measuredHeight;
        int measuredWidth;
        boolean z18;
        boolean z19;
        float f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, Float.valueOf(f16), Boolean.valueOf(z16));
            return;
        }
        if (!VersionUtils.isHoneycomb()) {
            View view = this.mSelectedChild;
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof URLDrawable) && (((URLDrawable) drawable).getCurrDrawable() instanceof GifDrawable)) {
                    z17 = true;
                    if (!this.mIsDoubleTapping && !z17) {
                        this.mIsLeftEdge = false;
                        this.mIsRightedge = false;
                        View view2 = this.mSelectedChild;
                        if (view2 != null) {
                            if (!(view2.getTag(ID_SCALE_DISABLE) instanceof Boolean) || !((Boolean) this.mSelectedChild.getTag(ID_SCALE_DISABLE)).booleanValue()) {
                                if (this.mSelectedChild.getTag(ID_LONG_PIC_SCALE) != null) {
                                    f17 = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_SCALE)).floatValue();
                                } else if (this.mSelectedChild.getTag(ID_DEFAULT_SCALE) != null) {
                                    f17 = ((Float) this.mSelectedChild.getTag(ID_DEFAULT_SCALE)).floatValue();
                                } else {
                                    f17 = 1.0f;
                                }
                                float childScale = getChildScale(this.mSelectedChild);
                                int measuredWidth2 = getMeasuredWidth();
                                int measuredHeight2 = getMeasuredHeight();
                                if (this.mSelectedChild.getTag(ID_DEFAULT_ROTATE) != null) {
                                    i3 = ((Integer) this.mSelectedChild.getTag(ID_DEFAULT_ROTATE)).intValue();
                                } else {
                                    i3 = 0;
                                }
                                if (i3 != 1 && i3 != 3) {
                                    measuredHeight = this.mSelectedChild.getMeasuredWidth();
                                    measuredWidth = this.mSelectedChild.getMeasuredHeight();
                                } else {
                                    measuredHeight = this.mSelectedChild.getMeasuredHeight();
                                    measuredWidth = this.mSelectedChild.getMeasuredWidth();
                                }
                                if (measuredHeight <= measuredWidth2 && measuredWidth <= measuredHeight2) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (measuredWidth >= measuredHeight * 3) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (z18) {
                                    f18 = this.mMaxumScale;
                                } else if (z19) {
                                    f18 = Math.min(measuredWidth2 / measuredHeight, this.mMaxumScale);
                                } else {
                                    Rect imageSize = getImageSize(this.mSelectedChild);
                                    int i16 = imageSize.right - imageSize.left;
                                    int i17 = imageSize.bottom - imageSize.top;
                                    if (i16 < measuredWidth2) {
                                        float f19 = measuredWidth2;
                                        if (i16 * 1.5f < f19) {
                                            f18 = f19 / measuredHeight;
                                        }
                                        f18 = f17 * 2.0f;
                                    } else {
                                        float f26 = measuredHeight2;
                                        if (i17 * 1.5f < f26) {
                                            f18 = f26 / measuredWidth;
                                        }
                                        f18 = f17 * 2.0f;
                                    }
                                }
                                float min = Math.min(f16, f18);
                                if (childScale < min) {
                                    if (!canUpdateRegionRect()) {
                                        onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
                                    }
                                } else if (canUpdateRegionRect()) {
                                    updateShowArea(false);
                                }
                                scrollIntoSlots(min);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (this.mFlingRunnable.mScroller.isFinished()) {
                        scrollIntoSlots();
                        if (this.mScrollState == 0) {
                            this.mScrollState = 2;
                        }
                    }
                    this.mIsDoubleTapping = false;
                    dispatchUnpress();
                    if (!this.mScrollingRegion) {
                        this.mScrollingRegion = false;
                        this.mScrollDirection = 0;
                        if (canUpdateRegionRect()) {
                            updateShowArea(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        z17 = false;
        if (!this.mIsDoubleTapping) {
        }
        if (this.mFlingRunnable.mScroller.isFinished()) {
        }
        this.mIsDoubleTapping = false;
        dispatchUnpress();
        if (!this.mScrollingRegion) {
        }
    }

    protected void onViewContentMoved(boolean z16, int i3, Point point, int i16, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Integer.valueOf(i3), point, Integer.valueOf(i16), rect);
        }
    }

    protected void onViewCreated(int i3, ViewGroup viewGroup, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, Integer.valueOf(i3), viewGroup, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewDetached(int i3, View view, ViewGroup viewGroup, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, this, Integer.valueOf(i3), view, viewGroup, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onZoomBegin(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, this, Integer.valueOf(i3), view, viewGroup);
        }
    }

    @Override // com.tencent.widget.AbsSpinner
    public int pointToPosition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                getChildBounds(childAt, tmp);
                if (tmp.contains(i3, i16)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        } else {
            this.f384567dx = 0;
        }
    }

    public boolean resetScale(boolean z16) {
        Object tag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, z16)).booleanValue();
        }
        this.mIsLeftEdge = false;
        this.mIsRightedge = false;
        View view = this.mSelectedChild;
        if (view != null && (tag = view.getTag(ID_DEFAULT_SCALE)) != null && (tag instanceof Float)) {
            float floatValue = ((Float) tag).floatValue();
            if (getChildScale(this.mSelectedChild) >= floatValue && (Math.abs(r2 - floatValue) >= 1.0E-5d || z16)) {
                scrollIntoSlots(this.mMinumScale * floatValue);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.widget.AdapterView
    public void selectionChanged() {
        if (!this.mSuppressSelectionChanged) {
            super.selectionChanged();
        }
    }

    public void setAnimationDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mAnimationDuration = i3;
        }
    }

    public void setCallbackDuringFling(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mShouldCallbackDuringFling = z16;
        }
    }

    public void setCallbackOnUnselectedItemClick(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mShouldCallbackOnUnselectedItemClick = z16;
        }
    }

    public void setClearByTag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, z16);
        } else {
            this.mClearByTag = z16;
        }
    }

    public void setInterceptTouchEventReturn(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, z16);
        } else {
            this.interceptTouchEventReturn = z16;
        }
    }

    public void setMaxScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Float.valueOf(f16));
        } else {
            this.mMaxumScale = f16;
        }
    }

    public void setOnItemRotateListener(OnItemRotateListener onItemRotateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) onItemRotateListener);
        } else {
            this.mOnItemRotateListener = onItemRotateListener;
        }
    }

    public void setOnScollListener(OnScollListener onScollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) onScollListener);
        } else {
            this.mOnScollListener = onScollListener;
        }
    }

    public void setRotateEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, z16);
        } else {
            this.isRotateEnable = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.widget.AdapterView
    public void setSelectedPositionInt(int i3) {
        super.setSelectedPositionInt(i3);
        updateSelectedItemMetadata();
    }

    public void setSelectionToNothing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        checkSelectionChanged();
    }

    public void setSpacing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mSpacing = i3;
        }
    }

    public void setSupportMatchParent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, z16);
        } else {
            this.mSupportMatchParent = z16;
        }
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        if (isPressed() && (i3 = this.mSelectedPosition) >= 0) {
            return dispatchLongPress(getChildAt(i3 - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this, (Object) view)).booleanValue();
        }
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return dispatchLongPress(view, positionForView, this.mAdapter.getItemId(positionForView));
    }

    protected void trackMotionScroll(int i3, int i16, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (getChildCount() != 0) {
            if (i3 != 0 || i16 != 0) {
                if (i3 < 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (i3 == 0) {
                    this.mScrollDirection = 0;
                } else if (i3 < 0) {
                    this.mScrollDirection = 1;
                } else {
                    this.mScrollDirection = 2;
                }
                if (z16) {
                    getLimitedMotionScrollAmount(z17, i3, i16, this.tmpP);
                } else {
                    Point point = this.tmpP;
                    point.x = i3;
                    point.y = i16;
                }
                onViewContentMoved(z17, i3, this.tmpP, this.mWidth, this.mSpinnerPadding);
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    setChildTranslation(getChildAt(childCount), this.tmpP.x, 0);
                }
                int i17 = this.f384567dx;
                Point point2 = this.tmpP;
                this.f384567dx = i17 + point2.x;
                View view = this.mSelectedChild;
                if (view != null && this.mScrollState != 0) {
                    setChildTranslation(view, 0, point2.y);
                    this.f384568dy += this.tmpP.y;
                }
                detachOffScreenChildren(z17);
                View view2 = this.mSelectedChild;
                if (view2 == null || view2.getParent() != null) {
                    z18 = false;
                }
                if (z17 && this.mIsRightedge) {
                    fillToGalleryRight();
                } else if (!z17 && this.mIsLeftEdge) {
                    fillToGalleryLeft();
                }
                this.mRecycler.clear();
                if (z18) {
                    setSelectionToCenterChild();
                }
                onScrollChanged(0, 0, 0, 0);
                invalidate();
            }
        }
    }

    public Gallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.galleryStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 13, (Object) this, (Object) attributeSet);
    }

    public void scrollIntoSlots(float f16) {
        float floatValue;
        float f17;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16));
            return;
        }
        int childCount = getChildCount();
        if (childCount == 0 || this.mSelectedChild == null) {
            return;
        }
        View childAt = getChildAt(0);
        if (childCount == 1) {
            float childScale = getChildScale(this.mSelectedChild);
            int intValue = this.mSelectedChild.getTag(ID_DEFAULT_ROTATE) != null ? ((Integer) this.mSelectedChild.getTag(ID_DEFAULT_ROTATE)).intValue() : 0;
            if (this.mSelectedChild.getTag(ID_LONG_PIC_SCALE) instanceof Float) {
                floatValue = ((Float) this.mSelectedChild.getTag(ID_LONG_PIC_SCALE)).floatValue();
            } else if (!(this.mSelectedChild.getTag(ID_DEFAULT_SCALE) instanceof Float)) {
                return;
            } else {
                floatValue = ((Float) this.mSelectedChild.getTag(ID_DEFAULT_SCALE)).floatValue();
            }
            int childRotation = (int) getChildRotation(this.mSelectedChild);
            int rotationFlag = getRotationFlag(childRotation, intValue);
            float rotationInternal = getRotationInternal(childRotation, rotationFlag);
            float f18 = rotationFlag * 90;
            int measuredWidth = this.mSelectedChild.getMeasuredWidth();
            int measuredHeight = this.mSelectedChild.getMeasuredHeight();
            int measuredWidth2 = getMeasuredWidth();
            int measuredHeight2 = getMeasuredHeight();
            if (f16 != 0.0f) {
                f17 = f16;
            } else if (rotationFlag != intValue) {
                this.mSelectedChild.setTag(ID_DEFAULT_ROTATE, Integer.valueOf(rotationFlag));
                f17 = getChildGravityAndScale(measuredWidth, measuredHeight, measuredWidth2, measuredHeight2, this.mSelectedChild).defaultScale;
                this.mSelectedChild.setTag(ID_DEFAULT_SCALE, Float.valueOf(f17));
                OnItemRotateListener onItemRotateListener = this.mOnItemRotateListener;
                if (onItemRotateListener != null) {
                    onItemRotateListener.onRotateFinished(this.mSelectedChild, getSelectedItemPosition(), rotationFlag);
                }
            } else {
                f17 = Math.min(floatValue, this.mMinumScale);
                float max = Math.max(floatValue, this.mMaxumScale);
                if (Math.abs(childScale - floatValue) < 1.0E-5d) {
                    f17 = floatValue;
                } else if (childScale >= f17) {
                    f17 = childScale > max ? max : childScale;
                }
            }
            if (childScale == f17 && f18 == rotationInternal) {
                getChildBounds(childAt, tmp);
            } else {
                setChildScale(this.mSelectedChild, f17);
                setChildRotation(this.mSelectedChild, f18);
                getChildBounds(this.mSelectedChild, tmp);
                setChildScale(this.mSelectedChild, childScale);
                setChildRotation(this.mSelectedChild, rotationInternal);
            }
            Rect rect = tmp;
            int i17 = rect.right;
            int i18 = this.mWidth;
            int i19 = this.mSpinnerPadding.left;
            if (i17 < i18 + i19) {
                i3 = (i18 + i19) - i17;
            } else {
                int i26 = rect.left;
                i3 = i26 > i19 ? i19 - i26 : 0;
            }
            int height = rect.height();
            int i27 = this.mHeight;
            if (height < i27) {
                i16 = (this.mSpinnerPadding.top + ((i27 - tmp.height()) / 2)) - tmp.top;
            } else {
                Rect rect2 = tmp;
                int i28 = rect2.top;
                int i29 = this.mSpinnerPadding.top;
                if (i28 > i29) {
                    i16 = i29 - i28;
                } else {
                    int i36 = rect2.bottom;
                    if (i36 < i27 + i29) {
                        i16 = (i27 + i29) - i36;
                    }
                }
            }
            int i37 = i16;
            if (childScale == f17 && f18 == rotationInternal) {
                this.mFlingRunnable.startUsingDistance(i3, i37);
                return;
            } else {
                this.mFlingRunnable.startUsingDistance(i3, i37, childScale, f17, rotationInternal, f18);
                return;
            }
        }
        Rect rect3 = tmp;
        if (rect3.right + (this.mSpacing / 2) > this.mSpinnerPadding.left + (this.mWidth / 2)) {
            getChildBounds(childAt, rect3);
            this.mFlingRunnable.startUsingDistance((this.mSpinnerPadding.left + this.mWidth) - tmp.right, 0);
        } else {
            getChildBounds(childAt, rect3);
            this.mFlingRunnable.startUsingDistance((this.mSpinnerPadding.left - tmp.right) - this.mSpacing, 0);
        }
    }

    @Override // com.tencent.widget.AbsSpinner, com.tencent.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) spinnerAdapter);
        } else {
            super.setAdapter(spinnerAdapter);
            this.mSelectedChild = null;
        }
    }

    protected void updateShowArea(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        View view = this.mSelectedChild;
        if (view == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0) {
            return;
        }
        Rect rect = new Rect();
        getChildBounds(view, rect);
        if (rect.intersect(0, 0, measuredWidth, measuredHeight)) {
            rect.offset(-view.getLeft(), -view.getTop());
            getChildMatrix(view).invert(this.tempMatrix);
            RectF rectF = new RectF(rect);
            this.tempMatrix.mapRect(rectF);
            rectF.round(rect);
            tmp.set(0, 0, view.getWidth(), view.getHeight());
            rect.intersect(tmp);
            float childScale = getChildScale(view);
            RegionDrawableData regionDrawableData = new RegionDrawableData();
            regionDrawableData.mImageArea = tmp;
            regionDrawableData.mShowArea = rect;
            regionDrawableData.mScale = childScale;
            regionDrawableData.mState = i3;
            regionDrawableData.mShowRegion = z16;
            regionDrawableData.mScrollDirection = this.mScrollDirection;
            if (this.mSelectedChild.getTag(ID_LONG_PIC_SCALE) != null) {
                regionDrawableData.mDefaultScale = ((Float) view.getTag(ID_LONG_PIC_SCALE)).floatValue();
            } else if (view.getTag(ID_DEFAULT_SCALE) != null) {
                regionDrawableData.mDefaultScale = ((Float) view.getTag(ID_DEFAULT_SCALE)).floatValue();
            }
            onShowAreaChanged(this.mSelectedPosition, view, regionDrawableData);
        }
    }

    public Gallery(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mSpacing = 0;
        this.mAnimationDuration = 400;
        this.mFlingRunnable = new FlingRunnable();
        this.mDisableSuppressSelectionChangedRunnable = new Runnable() { // from class: com.tencent.widget.Gallery.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Gallery.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    Gallery.this.mSuppressSelectionChanged = false;
                    Gallery.this.selectionChanged();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.mShouldCallbackDuringFling = true;
        this.mShouldCallbackOnUnselectedItemClick = true;
        this.scrollX = 0;
        this.scrollY = 0;
        this.mIsScaling = false;
        this.mScrollState = -1;
        this.mIsLeftEdge = false;
        this.mIsRightedge = false;
        this.tmpP = new Point();
        this.mScrollingRegion = false;
        this.mMinumScale = 1.0f;
        this.mMaxumScale = MAX_SCALE_DEFAULT;
        this.mIsDoubleTapping = false;
        this.mIsMultiTouch = false;
        this.tempMatrix = new Matrix();
        this.mScaleGestureEnable = true;
        this.mDoubleTapEnable = true;
        this.mSupportMatchParent = false;
        this.mIsLayoutScale = false;
        this.mClearByTag = false;
        this.mIsQzoneDefaultScale = false;
        this.lastMoveTime = -1L;
        this.vectorRotation = 0.0d;
        this.beginRotation = 0.0f;
        this.isRotating = false;
        this.canRotating = true;
        this.interceptTouchEventReturn = true;
        this.isRotateEnable = false;
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        this.mGestureDetector.setOnDoubleTapListener(this);
        this.mScaleGestureDetector = new android.view.ScaleGestureDetector(context, this);
        if (!VersionUtils.isHoneycomb()) {
            setStaticTransformationsEnabled(true);
        }
        this.mMinimumVelocity = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = TypedValue.applyDimension(1, 2400.0f, context.getResources().getDisplayMetrics());
        setFadingEdgeLength(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class FlingRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private float mDeltaRotation;
        private float mDeltaScale;
        private float mDurationReciprocal;
        private int mLastFlingX;
        private int mLastFlingY;
        private boolean mScaling;
        private OverScroller mScroller;
        private float mStartRotation;
        private float mStartScale;
        private long mStartTime;

        public FlingRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Gallery.this);
                return;
            }
            OverScroller overScroller = new OverScroller(Gallery.this.getContext());
            this.mScroller = overScroller;
            overScroller.setFriction(0.04f);
        }

        private void endFling(boolean z16) {
            this.mScroller.forceFinished(true);
            this.mStartTime = -1L;
            Gallery gallery = Gallery.this;
            OnScollListener onScollListener = gallery.mOnScollListener;
            if (onScollListener != null) {
                onScollListener.onScrollEnd(gallery.mSelectedPosition);
            }
            Gallery gallery2 = Gallery.this;
            if (gallery2.mScrollState == 2) {
                gallery2.onSlotChanged(gallery2.mSelectedPosition, gallery2.getChildAt(0), Gallery.this);
                Gallery.this.resetScrollState();
            }
            Gallery.this.mScrollState = -1;
        }

        private float getInterpolation(float f16) {
            return AnimateUtils.viscousFluid(f16);
        }

        private void startCommon() {
            Gallery.this.removeCallbacks(this);
        }

        public int calcFlingDistance(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            this.mScroller.fling(i3, 0, i16, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            return this.mScroller.getFinalX();
        }

        @Override // java.lang.Runnable
        public void run() {
            float f16;
            float f17;
            float f18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            Gallery gallery = Gallery.this;
            if (gallery.mSelectedChild == null) {
                return;
            }
            boolean z16 = true;
            if (gallery.mItemCount != 0) {
                gallery.mShouldStopFling = false;
                OverScroller overScroller = this.mScroller;
                boolean computeScrollOffset = overScroller.computeScrollOffset();
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.mLastFlingX;
                int i16 = currY - this.mLastFlingY;
                if (this.mStartTime >= 0) {
                    int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
                    if (currentAnimationTimeMillis < Gallery.this.mAnimationDuration) {
                        float interpolation = getInterpolation(currentAnimationTimeMillis * this.mDurationReciprocal);
                        f17 = this.mStartScale + (this.mDeltaScale * interpolation);
                        f18 = this.mStartRotation + (interpolation * this.mDeltaRotation);
                    } else {
                        f17 = this.mDeltaScale + this.mStartScale;
                        f18 = this.mDeltaRotation + this.mStartRotation;
                    }
                    Gallery gallery2 = Gallery.this;
                    gallery2.setChildScale(gallery2.mSelectedChild, f17);
                    Gallery gallery3 = Gallery.this;
                    gallery3.setChildRotation(gallery3.mSelectedChild, f18);
                    if (!this.mScaling) {
                        this.mScaling = true;
                    }
                }
                Gallery.this.trackMotionScroll(i3, i16, false);
                if (computeScrollOffset && !Gallery.this.mShouldStopFling) {
                    this.mLastFlingX = currX;
                    this.mLastFlingY = currY;
                    Gallery.this.post(this);
                    Gallery gallery4 = Gallery.this;
                    if (gallery4.mScrollState == 1 && gallery4.canUpdateRegionRect()) {
                        Gallery.this.updateShowArea(true, 1);
                        return;
                    }
                    return;
                }
                if (this.mScaling) {
                    this.mScaling = false;
                    if (Gallery.this.canUpdateRegionRect()) {
                        if (Gallery.this.mSelectedChild.getTag(Gallery.ID_DEFAULT_SCALE) != null) {
                            f16 = ((Float) Gallery.this.mSelectedChild.getTag(Gallery.ID_DEFAULT_SCALE)).floatValue();
                        } else {
                            f16 = 1.0f;
                        }
                        Gallery gallery5 = Gallery.this;
                        float childScale = gallery5.getChildScale(gallery5.mSelectedChild);
                        Gallery gallery6 = Gallery.this;
                        if (childScale - f16 <= 1.0E-5d) {
                            z16 = false;
                        }
                        gallery6.updateShowArea(z16);
                    }
                } else {
                    Gallery gallery7 = Gallery.this;
                    if (gallery7.mScrollState == 1) {
                        gallery7.mScrollDirection = 0;
                        if (gallery7.canUpdateRegionRect()) {
                            Gallery.this.updateShowArea(true);
                        }
                    }
                }
                endFling(false);
                return;
            }
            endFling(true);
        }

        public void startUsingDistance(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == 0 && i16 == 0) {
                return;
            }
            startCommon();
            this.mLastFlingX = 0;
            this.mLastFlingY = 0;
            this.mScroller.startScroll(0, 0, i3, i16, Gallery.this.mAnimationDuration);
            Gallery.this.post(this);
            Gallery gallery = Gallery.this;
            OnScollListener onScollListener = gallery.mOnScollListener;
            if (onScollListener != null) {
                onScollListener.onScrollStart(gallery.mSelectedPosition);
            }
        }

        public void startUsingVelocity(int i3, int i16, int i17, int i18, int i19, int i26) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
                return;
            }
            if (i3 == 0 && i16 == 0) {
                return;
            }
            startCommon();
            this.mLastFlingX = 0;
            this.mLastFlingY = 0;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            Gallery gallery = Gallery.this;
            long j3 = gallery.lastMoveTime;
            if (currentAnimationTimeMillis - j3 > 15) {
                this.mScroller.fling(j3 + 15, 0, 0, i3, i16, i17, i18, i19, i26, gallery.mSpacing, Gallery.this.mSpacing);
            } else {
                this.mScroller.fling(0, 0, i3, i16, i17, i18, i19, i26, gallery.mSpacing, Gallery.this.mSpacing);
            }
            Gallery.this.post(this);
            Gallery gallery2 = Gallery.this;
            OnScollListener onScollListener = gallery2.mOnScollListener;
            if (onScollListener != null) {
                onScollListener.onScrollStart(gallery2.mSelectedPosition);
            }
        }

        public void stop(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                Gallery.this.removeCallbacks(this);
                endFling(z16);
            }
        }

        public void startUsingDistance(int i3, int i16, float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            if (i3 == 0 && i16 == 0 && f16 == f17 && f18 == f19) {
                return;
            }
            startCommon();
            this.mLastFlingX = 0;
            this.mLastFlingY = 0;
            this.mScroller.startScroll(0, 0, i3, i16, Gallery.this.mAnimationDuration);
            Gallery.this.post(this);
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStartScale = f16;
            this.mDeltaScale = f17 - f16;
            this.mDurationReciprocal = 1.0f / Gallery.this.mAnimationDuration;
            this.mStartRotation = f18;
            this.mDeltaRotation = f19 - f18;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildScale(View view, float f16) {
        if (view == null) {
            return;
        }
        markViewTransformed(view);
        view.setScaleX(f16);
        view.setScaleY(f16);
        if (isHardwareAccelerated()) {
            return;
        }
        invalidate();
    }
}
