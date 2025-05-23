package com.tencent.widget;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.ProxyDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.EstablishSetting;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes27.dex */
public class BubblePopupWindow implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final int[] ABOVE_ANCHOR_STATE_SET;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    private static final String TAG = "BubblePopupWindow";
    private FrameLayout framelayout;
    private boolean mAboveAnchor;
    private ImageView mAboveArrow;
    private boolean mAllowScrollingAnchorParent;
    private WeakReference<View> mAnchor;
    private int mAnchorOffset;
    private int mAnchorXoff;
    private int mAnchorYoff;
    private int mAnimationStyle;
    private Drawable mBackground;
    private ImageView mBottomArrow;
    private boolean mClipToScreen;
    private boolean mClippingEnabled;
    private int mContainerCenterX;
    private View mContentView;
    private Context mContext;
    private int mDisplayWidth;
    private int[] mDrawingLocation;
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private boolean mIgnoreCheekPress;
    private int mInputMethodMode;
    private boolean mIsDropdown;
    private boolean mIsShowing;
    private boolean mKeepAbove;
    private int mLastHeight;
    private int mLastWidth;
    private boolean mLayoutInScreen;
    private boolean mLayoutInsetDecor;
    private boolean mNotTouchModal;
    private int mOffsetWidth;
    private OnDismissListener mOnDismissListener;
    private List<OnDismissListener> mOnDismissListeners;
    private OnKeyBackListener mOnKeybackListener;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    private boolean mOutsideTouchable;
    private int mPopupHeight;
    private View mPopupView;
    private int mPopupWidth;
    private MyClipDrawable mPressedAboveArrow;
    private MyClipDrawable mPressedBackground;
    private MyClipDrawable mPressedBottomArrow;
    private QQMenuNoIconEmptyInterface mQQMenuNoIconEmptyInterface;
    private int[] mScreenLocation;
    private int mSoftInputMode;
    private int mSplitTouchEnabled;
    private Rect mTempRect;
    private View.OnTouchListener mTouchInterceptor;
    private boolean mTouchable;
    private int mWidth;
    private int mWidthMode;
    private int mWindowLayoutType;
    private WindowManager mWindowManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class MyClipDrawable extends ProxyDrawable {
        static IPatchRedirector $redirector_;
        int clipLeft;
        int clipRight;

        public MyClipDrawable(Drawable drawable) {
            super(drawable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BubblePopupWindow.this, (Object) drawable);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
                return;
            }
            Rect bounds = getBounds();
            if (this.clipRight > this.clipLeft) {
                int save = canvas.save();
                canvas.clipRect(this.clipLeft, 0, this.clipRight, bounds.height());
                this.mCurrDrawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }

        public void setClipRange(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.clipLeft = i3;
            this.clipRight = i16;
            invalidateSelf();
        }
    }

    /* loaded from: classes27.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* loaded from: classes27.dex */
    public interface OnKeyBackListener {
        void onKeyBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class PopupViewContainer extends FrameLayout {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "PopupWindow.PopupViewContainer";
        View pressedView;

        public PopupViewContainer(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BubblePopupWindow.this, (Object) context);
            } else {
                this.pressedView = null;
            }
        }

        private View findPressedView(View view) {
            if (view.isPressed()) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View findPressedView = findPressedView(viewGroup.getChildAt(i3));
                    if (findPressedView != null) {
                        return findPressedView;
                    }
                }
                return null;
            }
            return null;
        }

        private void getRectOnParent(View view, View view2, Rect rect) {
            if (view == view2) {
                return;
            }
            rect.top += view.getTop();
            rect.bottom += view.getTop();
            rect.left += view.getLeft();
            rect.right += view.getLeft();
            getRectOnParent((View) view.getParent(), view2, rect);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) keyEvent)).booleanValue();
            }
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    if (BubblePopupWindow.this.mOnKeybackListener != null) {
                        BubblePopupWindow.this.mOnKeybackListener.onKeyBack();
                    }
                    BubblePopupWindow.this.dismiss();
                    return true;
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            boolean z16;
            boolean z17;
            int i3;
            boolean z18;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (BubblePopupWindow.this.mTouchInterceptor != null && BubblePopupWindow.this.mTouchInterceptor.onTouch(this, motionEvent)) {
                return true;
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (BubblePopupWindow.this.mPopupView == null) {
                return dispatchTouchEvent;
            }
            View findPressedView = findPressedView(BubblePopupWindow.this.mContentView);
            if (this.pressedView == null && findPressedView == null) {
                z16 = false;
            } else {
                this.pressedView = findPressedView;
                if (findPressedView != null) {
                    findPressedView.scrollTo(0, 0);
                    this.pressedView.getDrawingRect(BubblePopupWindow.this.mTempRect);
                    getRectOnParent(this.pressedView, BubblePopupWindow.this.mContentView, BubblePopupWindow.this.mTempRect);
                    if (BubblePopupWindow.this.mTempRect.left == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (BubblePopupWindow.this.mTempRect.right == BubblePopupWindow.this.mContentView.getWidth()) {
                        i3 = BubblePopupWindow.this.mPopupView.getWidth();
                        z18 = true;
                    } else {
                        i3 = 0;
                        z18 = false;
                    }
                    if (z17 && z18) {
                        i16 = 0;
                    } else {
                        this.pressedView.getDrawingRect(BubblePopupWindow.this.mTempRect);
                        getRectOnParent(this.pressedView, BubblePopupWindow.this.framelayout, BubblePopupWindow.this.mTempRect);
                        if (!z17) {
                            i16 = BubblePopupWindow.this.mTempRect.left;
                        } else {
                            i16 = 0;
                        }
                        if (!z18) {
                            i3 = BubblePopupWindow.this.mTempRect.right;
                        }
                    }
                    BubblePopupWindow.this.mPressedBackground.setClipRange(i16, i3);
                    BubblePopupWindow.this.mPressedAboveArrow.setClipRange(i16 - BubblePopupWindow.this.mAboveArrow.getLeft(), i3 - BubblePopupWindow.this.mAboveArrow.getLeft());
                    BubblePopupWindow.this.mPressedBottomArrow.setClipRange(i16 - BubblePopupWindow.this.mBottomArrow.getLeft(), i3 - BubblePopupWindow.this.mBottomArrow.getLeft());
                    z16 = false;
                } else {
                    BubblePopupWindow.this.mPressedBackground.setClipRange(0, 0);
                    BubblePopupWindow.this.mPressedAboveArrow.setClipRange(0, 0);
                    BubblePopupWindow.this.mPressedBottomArrow.setClipRange(0, 0);
                    z16 = true;
                }
                BubblePopupWindow.this.framelayout.invalidate();
            }
            if (!z16 && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                BubblePopupWindow.this.mPressedBackground.setClipRange(0, 0);
                BubblePopupWindow.this.mPressedAboveArrow.setClipRange(0, 0);
                BubblePopupWindow.this.mPressedBottomArrow.setClipRange(0, 0);
                BubblePopupWindow.this.framelayout.invalidate();
            }
            return dispatchTouchEvent;
        }

        @Override // android.view.View
        @TargetApi(8)
        protected void onConfigurationChanged(Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            } else {
                super.onConfigurationChanged(configuration);
                BubblePopupWindow.this.dismiss();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (int[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            if (BubblePopupWindow.this.mAboveAnchor) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
                View.mergeDrawableStates(onCreateDrawableState, BubblePopupWindow.ABOVE_ANCHOR_STATE_SET);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i3);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
            }
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x16 < 0 || x16 >= getWidth() || y16 < 0 || y16 >= getHeight())) {
                BubblePopupWindow.this.dismiss();
                return true;
            }
            if (motionEvent.getAction() == 4) {
                BubblePopupWindow.this.dismiss();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else if (BubblePopupWindow.this.mContentView != null) {
                BubblePopupWindow.this.mContentView.sendAccessibilityEvent(i3);
            } else {
                super.sendAccessibilityEvent(i3);
            }
        }
    }

    /* loaded from: classes27.dex */
    public interface QQMenuNoIconEmptyInterface {
        void onMenuNoIconEmptyClick();
    }

    /* loaded from: classes27.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BubblePopupWindow.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view;
            WindowManager.LayoutParams layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (BubblePopupWindow.this.mAnchor != null) {
                view = (View) BubblePopupWindow.this.mAnchor.get();
            } else {
                view = null;
            }
            if (view == null || BubblePopupWindow.this.mPopupView == null || (layoutParams = (WindowManager.LayoutParams) BubblePopupWindow.this.mPopupView.getLayoutParams()) == null) {
                return;
            }
            BubblePopupWindow bubblePopupWindow = BubblePopupWindow.this;
            bubblePopupWindow.findAbovePosition(view, layoutParams, bubblePopupWindow.mAnchorXoff, BubblePopupWindow.this.mAnchorYoff);
            BubblePopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42914);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 69)) {
            redirector.redirect((short) 69);
        } else {
            ABOVE_ANCHOR_STATE_SET = new int[]{R.attr.state_above_anchor};
        }
    }

    public BubblePopupWindow(Context context) {
        this(context, (AttributeSet) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int computeAnimationResource() {
        int i3 = this.mAnimationStyle;
        if (i3 == -1) {
            if (this.mIsDropdown) {
                if (this.mAboveAnchor) {
                    return com.tencent.mobileqq.R.style.f173452dq;
                }
                return com.tencent.mobileqq.R.style.f173451dp;
            }
            return 0;
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x001f, code lost:
    
        r4 = r4 | 131072;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x001d, code lost:
    
        if (r3.mInputMethodMode == 2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r3.mInputMethodMode == 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int computeFlags(int i3) {
        int i16 = i3 & (-8815129);
        if (this.mIgnoreCheekPress) {
            i16 |= 32768;
        }
        if (!this.mFocusable) {
            i16 |= 8;
        }
        if (!this.mTouchable) {
            i16 |= 16;
        }
        if (this.mOutsideTouchable) {
            i16 |= 262144;
        }
        if (!this.mClippingEnabled) {
            i16 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i16 |= 8388608;
        }
        if (this.mLayoutInScreen) {
            i16 |= 256;
        }
        if (this.mLayoutInsetDecor) {
            i16 |= 65536;
        }
        if (this.mNotTouchModal) {
            return i16 | 32;
        }
        return i16;
    }

    private WindowManager.LayoutParams createPopupLayout(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i3 = this.mWidth;
        this.mLastWidth = i3;
        layoutParams.width = i3;
        int i16 = this.mHeight;
        this.mLastHeight = i16;
        layoutParams.height = i16;
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = computeFlags(layoutParams.flags);
        layoutParams.type = this.mWindowLayoutType;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.mSoftInputMode;
        return layoutParams;
    }

    private void findAbovePosition(WindowManager.LayoutParams layoutParams, int i3, int i16, View view, int i17, int i18) {
        boolean z16;
        boolean z17;
        boolean isInMultiWindowMode;
        int i19;
        View rootView = view.getRootView();
        layoutParams.x = i3;
        layoutParams.y = i16;
        if (this.mKeepAbove) {
            layoutParams.gravity = 51;
            z16 = false;
        } else {
            layoutParams.gravity = 83;
            z16 = true;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i26 = this.mPopupWidth;
        int i27 = this.mPopupHeight;
        if (i26 == -2 || i27 == -2) {
            this.mPopupView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (this.mPopupWidth == -2) {
                i26 = this.mPopupView.getMeasuredWidth();
            }
            if (this.mPopupHeight == -2) {
                i27 = this.mPopupView.getMeasuredHeight();
            }
        }
        if (i26 > 0) {
            layoutParams.x = i3 - (i26 / 2);
        }
        int i28 = rect.top;
        if (this.mAnchorOffset > 0) {
            i28 = 0;
        }
        if (this.mKeepAbove || (((i19 = i16 - i27) >= i28 && (i3 + i26) - rootView.getWidth() <= 0) || i19 >= i28)) {
            z17 = z16;
        } else {
            layoutParams.gravity = 51;
            z17 = false;
        }
        if (this.mClipToScreen) {
            int i29 = rect.right;
            int i36 = rect.left;
            int i37 = i29 - i36;
            int i38 = layoutParams.x;
            int i39 = i38 + i26;
            if (i39 > i37) {
                layoutParams.x = i38 - (i39 - i37);
            }
            if (layoutParams.x < i36) {
                layoutParams.x = i36;
                layoutParams.width = Math.min(layoutParams.width, i37);
            }
            if (z17) {
                int i46 = i16 - this.mPopupHeight;
                if (i46 < 0) {
                    layoutParams.y += i46;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y + this.mAnchorOffset, rect.top);
            }
            layoutParams.gravity |= 268435456;
        }
        if (z17) {
            layoutParams.y = rootView.getHeight() - layoutParams.y;
        }
        View view2 = this.mContentView;
        if ((view2 instanceof QQCustomMenuNoIconLayout) && ((QQCustomMenuNoIconLayout) view2).B()) {
            layoutMenuContainer(layoutParams, view, rootView, z17, i26, i27, rect, ((QQCustomMenuNoIconLayout) this.mContentView).q(), i17, i18);
        } else {
            updateAboveAnchor(z17, i3 - layoutParams.x);
        }
        if (Build.VERSION.SDK_INT < 24 || !(view.getContext() instanceof Activity)) {
            return;
        }
        isInMultiWindowMode = ((Activity) view.getContext()).isInMultiWindowMode();
        if (isInMultiWindowMode) {
            int[] iArr = new int[2];
            ((Activity) view.getContext()).getWindow().getDecorView().getLocationOnScreen(iArr);
            int i47 = iArr[1];
            if (i47 > 10) {
                layoutParams.y += i47;
            }
            int i48 = iArr[0];
            if (i48 > 10) {
                layoutParams.x -= i48;
            }
        }
    }

    @TargetApi(14)
    private void invokePopup(WindowManager.LayoutParams layoutParams) {
        Context context = this.mContext;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        if (VersionUtils.isIceScreamSandwich()) {
            this.mPopupView.setFitsSystemWindows(this.mLayoutInsetDecor);
        }
        if (this.mPopupView.getParent() == null) {
            this.mWindowManager.addView(this.mPopupView, layoutParams);
        }
    }

    private void layoutMenuContainer(WindowManager.LayoutParams layoutParams, View view, View view2, boolean z16, int i3, int i16, Rect rect, Integer num, int i17, int i18) {
        boolean z17;
        boolean z18;
        int height;
        if (((QQCustomMenuNoIconLayout) this.mContentView).C() && view.getResources().getConfiguration().orientation == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (z16 && iArr[1] - i16 < rect.top) {
            layoutParams.gravity = 51;
            z18 = false;
        } else {
            z18 = z16;
        }
        if (num != null && !z18 && iArr[1] + view.getHeight() + i16 > num.intValue()) {
            QLog.d(TAG, 2, "[menu] layoutMenuContainerX handle long view! Bottom: " + (iArr[1] + view.getHeight() + i16) + " containerBottom: " + num);
            layoutParams.y = num.intValue() - i16;
        } else {
            if (z18) {
                height = view2.getHeight() - iArr[1];
            } else {
                height = iArr[1] + view.getHeight();
            }
            layoutParams.y = height;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[menu] layoutMenuContainerY ViewY: ", Integer.valueOf(iArr[1]), " ViewB: ", Integer.valueOf(iArr[1] + view.getBottom()), " ViewT: ", Integer.valueOf(view.getTop()), " ViewH: ", Integer.valueOf(view.getHeight()), " ContainerBottom: ", num, " displayFrame: ", rect, " screenH: ", Integer.valueOf(ViewUtils.getScreenHeight()), " screenW: ", Integer.valueOf(ViewUtils.getScreenWidth()), " onTop: ", Boolean.valueOf(z18), " popupH: ", Integer.valueOf(i16), " ParamY: ", Integer.valueOf(layoutParams.y), " ViewH: ", Integer.valueOf(view.getHeight()), " RootH: ", Integer.valueOf(view2.getHeight()));
        }
        int width = (view.getWidth() / 2) + (iArr[0] - i17);
        this.mContainerCenterX = width;
        layoutMenuContainerX(layoutParams, width, z17, z18, i3, i17, i18);
    }

    private void layoutMenuContainerX(WindowManager.LayoutParams layoutParams, int i3, boolean z16, boolean z17, int i16, int i17, int i18) {
        int dpToPx;
        this.mOffsetWidth = i17;
        this.mDisplayWidth = i18;
        if (!EstablishSetting.isAllowLandscape(MobileQQ.sMobileQQ) && !EstablishSetting.isSplitViewMode(MobileQQ.sMobileQQ)) {
            if (z16) {
                dpToPx = (i18 - i16) / 2;
            } else {
                dpToPx = ViewUtils.dpToPx(15.0f);
            }
        } else {
            dpToPx = ViewUtils.dpToPx(15.0f);
        }
        int i19 = i3 + i17;
        int i26 = i19 - (i16 / 2);
        layoutParams.x = i26;
        int max = Math.max(dpToPx + i17, i26);
        layoutParams.x = max;
        layoutParams.x = Math.min(max, ((i18 - dpToPx) - i16) + i17);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[menu] layoutMenuContainerX ParamX: " + layoutParams.x + " centerX: " + i3 + " isMenusLineFull: " + z16 + " popupWidth: " + i16);
        }
        updateAboveAnchor(z17, i19 - layoutParams.x);
    }

    private void preparePopup(WindowManager.LayoutParams layoutParams, boolean z16) {
        int i3;
        int i16;
        LayerDrawable layerDrawable;
        LayerDrawable layerDrawable2;
        if (this.mContentView != null && this.mContext != null && this.mWindowManager != null) {
            PopupViewContainer popupViewContainer = new PopupViewContainer(this.mContext);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            if (z16) {
                frameLayout.setOnClickListener(this);
            }
            if (this.mContentView instanceof QQCustomMenuNoIconLayout) {
                this.framelayout = new FrameLayout(this.mContext);
                this.mPressedBackground = new MyClipDrawable(this.mContext.getResources().getDrawable(com.tencent.mobileqq.R.drawable.caz));
                this.framelayout.addView(this.mContentView, new FrameLayout.LayoutParams(-2, -2, 17));
                frameLayout.addView(this.framelayout, new FrameLayout.LayoutParams(-2, -2, 17));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 17);
                layoutParams2.setMargins(0, ViewUtils.dpToPx(9.0f), 0, ViewUtils.dpToPx(9.0f));
                popupViewContainer.addView(frameLayout, layoutParams2);
            } else {
                if (z16) {
                    i3 = Math.round(TypedValue.applyDimension(1, 5.0f, this.mContext.getResources().getDisplayMetrics()));
                    i16 = Math.round(TypedValue.applyDimension(1, 5.0f, this.mContext.getResources().getDisplayMetrics()));
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                frameLayout.setPadding(i3, Math.round(TypedValue.applyDimension(1, 8.0f, this.mContext.getResources().getDisplayMetrics())), i16, Math.round(TypedValue.applyDimension(1, 8.0f, this.mContext.getResources().getDisplayMetrics())));
                popupViewContainer.addView(frameLayout, -1, -1);
                FrameLayout frameLayout2 = new FrameLayout(this.mContext);
                this.framelayout = frameLayout2;
                frameLayout.addView(frameLayout2, -1, -1);
                Drawable drawable = this.mContext.getResources().getDrawable(com.tencent.mobileqq.R.drawable.cay);
                this.mPressedBackground = new MyClipDrawable(this.mContext.getResources().getDrawable(com.tencent.mobileqq.R.drawable.caz));
                this.framelayout.setBackgroundDrawable(new LayerDrawable(new Drawable[]{drawable, this.mPressedBackground}));
                this.framelayout.addView(this.mContentView, new FrameLayout.LayoutParams(-1, -1, 17));
            }
            this.mAboveArrow = new ImageView(this.mContext);
            ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2, 51);
            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
            if (this.mContentView instanceof QQCustomMenuNoIconLayout) {
                Resources resources = this.mContext.getResources();
                int i17 = com.tencent.mobileqq.R.drawable.mor;
                this.mPressedAboveArrow = new MyClipDrawable(resources.getDrawable(isNowThemeIsNight ? com.tencent.mobileqq.R.drawable.mor : com.tencent.mobileqq.R.drawable.mos));
                Drawable[] drawableArr = new Drawable[2];
                Resources resources2 = this.mContext.getResources();
                if (!isNowThemeIsNight) {
                    i17 = com.tencent.mobileqq.R.drawable.mos;
                }
                drawableArr[0] = resources2.getDrawable(i17);
                drawableArr[1] = this.mPressedAboveArrow;
                layerDrawable = new LayerDrawable(drawableArr);
            } else {
                this.mPressedAboveArrow = new MyClipDrawable(this.mContext.getResources().getDrawable(com.tencent.mobileqq.R.drawable.cax));
                layerDrawable = new LayerDrawable(new Drawable[]{this.mContext.getResources().getDrawable(com.tencent.mobileqq.R.drawable.caw), this.mPressedAboveArrow});
            }
            this.mAboveArrow.setBackgroundDrawable(layerDrawable);
            popupViewContainer.addView(this.mAboveArrow, layoutParams3);
            this.mBottomArrow = new ImageView(this.mContext);
            ViewGroup.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 83);
            if (this.mContentView instanceof QQCustomMenuNoIconLayout) {
                Resources resources3 = this.mContext.getResources();
                int i18 = com.tencent.mobileqq.R.drawable.moo;
                this.mPressedBottomArrow = new MyClipDrawable(resources3.getDrawable(isNowThemeIsNight ? com.tencent.mobileqq.R.drawable.moo : com.tencent.mobileqq.R.drawable.mop));
                Drawable[] drawableArr2 = new Drawable[2];
                Resources resources4 = this.mContext.getResources();
                if (!isNowThemeIsNight) {
                    i18 = com.tencent.mobileqq.R.drawable.mop;
                }
                drawableArr2[0] = resources4.getDrawable(i18);
                drawableArr2[1] = this.mPressedBottomArrow;
                layerDrawable2 = new LayerDrawable(drawableArr2);
            } else {
                this.mPressedBottomArrow = new MyClipDrawable(this.mContext.getResources().getDrawable(com.tencent.mobileqq.R.drawable.cav));
                layerDrawable2 = new LayerDrawable(new Drawable[]{this.mContext.getResources().getDrawable(com.tencent.mobileqq.R.drawable.cau), this.mPressedBottomArrow});
            }
            this.mBottomArrow.setBackgroundDrawable(layerDrawable2);
            popupViewContainer.addView(this.mBottomArrow, layoutParams4);
            this.mPopupView = popupViewContainer;
            this.mPopupWidth = layoutParams.width;
            this.mPopupHeight = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    private void registerForScrollChanged(View view, int i3, int i16) {
        unregisterForScrollChanged();
        this.mAnchor = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.mOnScrollChangedListener);
        }
        this.mAnchorXoff = i3;
        this.mAnchorYoff = i16;
    }

    private void unregisterForScrollChanged() {
        View view;
        WeakReference<View> weakReference = this.mAnchor;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
        }
        this.mAnchor = null;
    }

    private void updateAboveAnchor(boolean z16, int i3) {
        ImageView imageView;
        ImageView imageView2;
        this.mAboveAnchor = z16;
        if (!z16) {
            imageView = this.mAboveArrow;
        } else {
            imageView = this.mBottomArrow;
        }
        if (!z16) {
            imageView2 = this.mBottomArrow;
        } else {
            imageView2 = this.mAboveArrow;
        }
        int measuredWidth = imageView.getMeasuredWidth();
        imageView.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = i3 - (measuredWidth / 2);
        if (this.mAboveAnchor) {
            marginLayoutParams.bottomMargin = 1;
        } else {
            marginLayoutParams.topMargin = 1;
        }
        imageView2.setVisibility(4);
    }

    public void addOnDismissListener(OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) onDismissListener);
        } else {
            this.mOnDismissListeners.add(onDismissListener);
        }
    }

    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dismiss() called \n" + QLog.getStackTraceString(new RuntimeException()));
        }
        if (isShowing() && this.mPopupView != null) {
            this.mIsShowing = false;
            unregisterForScrollChanged();
            try {
                if (this.mPopupView.getParent() != null) {
                    this.mWindowManager.removeViewImmediate(this.mPopupView);
                }
            } finally {
                View view = this.mPopupView;
                View view2 = this.mContentView;
                if (view != view2 && (view instanceof ViewGroup)) {
                    ((ViewGroup) view).removeView(view2);
                }
                this.mPopupView = null;
                OnDismissListener onDismissListener = this.mOnDismissListener;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss();
                }
                for (OnDismissListener onDismissListener2 : this.mOnDismissListeners) {
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss();
                    }
                }
            }
        }
    }

    public int getAnimationStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mAnimationStyle;
    }

    public Drawable getBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mBackground;
    }

    public View getContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mContentView;
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    public int getInputMethodMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mInputMethodMode;
    }

    public int getMaxAvailableHeight(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 54)) ? getMaxAvailableHeight(view, 0) : ((Integer) iPatchRedirector.redirect((short) 54, (Object) this, (Object) view)).intValue();
    }

    public int getSoftInputMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.mSoftInputMode;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    public int getWindowLayoutType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        return this.mWindowLayoutType;
    }

    public boolean isAboveAnchor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this)).booleanValue();
        }
        return this.mAboveAnchor;
    }

    public boolean isClippingEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.mClippingEnabled;
    }

    public boolean isFocusable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.mFocusable;
    }

    public boolean isLayoutInScreenEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.mLayoutInScreen;
    }

    public boolean isOutsideTouchable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.mOutsideTouchable;
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return this.mIsShowing;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        int i3 = this.mSplitTouchEnabled;
        if (i3 < 0 && (context = this.mContext) != null) {
            if (context.getApplicationInfo().targetSdkVersion < 11) {
                return false;
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public boolean isTouchable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.mTouchable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) view);
        } else {
            dismiss();
            QQMenuNoIconEmptyInterface qQMenuNoIconEmptyInterface = this.mQQMenuNoIconEmptyInterface;
            if (qQMenuNoIconEmptyInterface != null) {
                qQMenuNoIconEmptyInterface.onMenuNoIconEmptyClick();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setAllowScrollingAnchorParent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        } else {
            this.mAllowScrollingAnchorParent = z16;
        }
    }

    public void setAnchorOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, i3);
        } else {
            this.mAnchorOffset = i3;
        }
    }

    public void setAnimationStyle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mAnimationStyle = i3;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
        } else {
            this.mBackground = drawable;
        }
    }

    public void setClipToScreenEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.mClipToScreen = z16;
            setClippingEnabled(!z16);
        }
    }

    public void setClippingEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.mClippingEnabled = z16;
        }
    }

    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        if (isShowing()) {
            return;
        }
        this.mContentView = view;
        if (this.mContext == null && view != null) {
            this.mContext = view.getContext();
        }
        if (this.mWindowManager == null && this.mContentView != null) {
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        }
    }

    public void setFocusable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.mFocusable = z16;
        }
    }

    public void setHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, i3);
        } else {
            this.mHeight = i3;
        }
    }

    public void setIgnoreCheekPress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.mIgnoreCheekPress = true;
        }
    }

    public void setInputMethodMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mInputMethodMode = i3;
        }
    }

    public void setKeepAbove(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.mKeepAbove = z16;
        }
    }

    public void setLayoutInScreenEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
        } else {
            this.mLayoutInScreen = z16;
        }
    }

    public void setLayoutInsetDecor(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.mLayoutInsetDecor = z16;
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) onDismissListener);
        } else {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void setOnKeybackListener(OnKeyBackListener onKeyBackListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) onKeyBackListener);
        } else {
            this.mOnKeybackListener = onKeyBackListener;
        }
    }

    public void setOutsideTouchable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mOutsideTouchable = z16;
        }
    }

    public void setQQMenuNoIconEmptyInterface(QQMenuNoIconEmptyInterface qQMenuNoIconEmptyInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) qQMenuNoIconEmptyInterface);
        } else {
            this.mQQMenuNoIconEmptyInterface = qQMenuNoIconEmptyInterface;
        }
    }

    public void setSoftInputMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mSoftInputMode = i3;
        }
    }

    public void setSplitTouchEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        } else {
            this.mSplitTouchEnabled = z16 ? 1 : 0;
        }
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onTouchListener);
        } else {
            this.mTouchInterceptor = onTouchListener;
        }
    }

    public void setTouchModal(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
        } else {
            this.mNotTouchModal = !z16;
        }
    }

    public void setTouchable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.mTouchable = z16;
        }
    }

    public void setWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        } else {
            this.mWidth = i3;
        }
    }

    public void setWindowLayoutMode(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mWidthMode = i3;
            this.mHeightMode = i16;
        }
    }

    public void setWindowLayoutType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, i3);
        } else {
            this.mWindowLayoutType = i3;
        }
    }

    public void showAsDropDown(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) {
            showAsDropDown(view, 0, 0);
        } else {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) view);
        }
    }

    public void showAtLocation(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) {
            showAtLocation(view, i3, i16, false, 0, ViewUtils.getScreenWidth());
        } else {
            iPatchRedirector.redirect((short) 49, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void update() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this);
            return;
        }
        if (!isShowing() || this.mContentView == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        int computeAnimationResource = computeAnimationResource();
        boolean z17 = true;
        if (computeAnimationResource != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = computeAnimationResource;
            z16 = true;
        } else {
            z16 = false;
        }
        int computeFlags = computeFlags(layoutParams.flags);
        if (computeFlags != layoutParams.flags) {
            layoutParams.flags = computeFlags;
        } else {
            z17 = z16;
        }
        if (z17) {
            this.mWindowManager.updateViewLayout(this.mPopupView, layoutParams);
        }
    }

    public void updateLocationX(int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
            return;
        }
        int x16 = (int) (i3 + (this.mContentView.getX() * 2.0f));
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        int i17 = this.mContainerCenterX;
        if (i17 > this.mDisplayWidth / 2) {
            layoutParams.x = (layoutParams.x + i16) - x16;
        }
        updateAboveAnchor(this.mAboveAnchor, (i17 + this.mOffsetWidth) - layoutParams.x);
        this.mWindowManager.removeView(this.mPopupView);
        this.mWindowManager.addView(this.mPopupView, layoutParams);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[menu] updateLocationX ParamX: " + layoutParams.x + " menuContainerWidth: " + x16 + " centerX: " + this.mContainerCenterX + " isMenusLineFull: " + z16);
        }
    }

    public BubblePopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.popupWindowStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public int getMaxAvailableHeight(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 55)) ? getMaxAvailableHeight(view, i3, false) : ((Integer) iPatchRedirector.redirect((short) 55, (Object) this, (Object) view, i3)).intValue();
    }

    public void showAsDropDown(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (isShowing() || this.mContentView == null) {
            return;
        }
        registerForScrollChanged(view, i3, i16);
        this.mIsShowing = true;
        this.mIsDropdown = true;
        WindowManager.LayoutParams createPopupLayout = createPopupLayout(view.getWindowToken());
        preparePopup(createPopupLayout);
        findAbovePosition(view, createPopupLayout, i3, i16);
        int i17 = this.mHeightMode;
        if (i17 < 0) {
            this.mLastHeight = i17;
            createPopupLayout.height = i17;
        }
        int i18 = this.mWidthMode;
        if (i18 < 0) {
            this.mLastWidth = i18;
            createPopupLayout.width = i18;
        }
        createPopupLayout.windowAnimations = computeAnimationResource();
        invokePopup(createPopupLayout);
    }

    public void showAtLocation(View view, int i3, int i16, boolean z16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showAtLocation() called with: parent = [" + view + "], x = [" + i3 + "], y = [" + i16 + "], isNoIcon = [" + z16 + "]");
        }
        if (isShowing() || this.mContentView == null) {
            return;
        }
        unregisterForScrollChanged();
        this.mIsShowing = true;
        this.mIsDropdown = true;
        WindowManager.LayoutParams createPopupLayout = createPopupLayout(view.getWindowToken());
        preparePopup(createPopupLayout, z16);
        findAbovePosition(createPopupLayout, i3, i16, view, i17, i18);
        int i19 = this.mHeightMode;
        if (i19 < 0) {
            this.mLastHeight = i19;
            createPopupLayout.height = i19;
        }
        int i26 = this.mWidthMode;
        if (i26 < 0) {
            this.mLastWidth = i26;
            createPopupLayout.width = i26;
        }
        createPopupLayout.windowAnimations = computeAnimationResource();
        invokePopup(createPopupLayout);
    }

    public BubblePopupWindow(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public int getMaxAvailableHeight(View view, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, this, view, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = this.mDrawingLocation;
        view.getLocationOnScreen(iArr);
        int i16 = rect.bottom;
        if (z16) {
            i16 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int max = Math.max((i16 - (iArr[1] + view.getHeight())) - i3, (iArr[1] - rect.top) + i3);
        Drawable drawable = this.mBackground;
        if (drawable == null) {
            return max;
        }
        drawable.getPadding(this.mTempRect);
        Rect rect2 = this.mTempRect;
        return max - (rect2.top + rect2.bottom);
    }

    public BubblePopupWindow(Context context, AttributeSet attributeSet, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mInputMethodMode = 0;
        this.mSoftInputMode = 1;
        this.mTouchable = true;
        this.mOutsideTouchable = false;
        this.mClippingEnabled = true;
        this.mSplitTouchEnabled = -1;
        this.mClipToScreen = true;
        this.mAllowScrollingAnchorParent = true;
        this.mLayoutInsetDecor = false;
        this.mKeepAbove = false;
        this.mDisplayWidth = ViewUtils.getScreenWidth();
        this.mAnchorOffset = 0;
        this.mDrawingLocation = new int[2];
        this.mScreenLocation = new int[2];
        this.mTempRect = new Rect();
        this.mWindowLayoutType = 1000;
        this.mOnDismissListeners = new ArrayList();
        this.mIgnoreCheekPress = false;
        this.mAnimationStyle = -1;
        this.mOnScrollChangedListener = new a();
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    public void update(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
            update(layoutParams.x, layoutParams.y, i3, i16, false);
        }
    }

    public void update(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 63)) {
            update(i3, i16, i17, i18, false);
        } else {
            iPatchRedirector.redirect((short) 63, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    public void update(int i3, int i16, int i17, int i18, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16));
            return;
        }
        if (i17 != -1) {
            this.mLastWidth = i17;
            setWidth(i17);
        }
        if (i18 != -1) {
            this.mLastHeight = i18;
            setHeight(i18);
        }
        if (!isShowing() || this.mContentView == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        int i19 = this.mWidthMode;
        if (i19 >= 0) {
            i19 = this.mLastWidth;
        }
        if (i17 != -1 && layoutParams.width != i19) {
            this.mLastWidth = i19;
            layoutParams.width = i19;
            z16 = true;
        }
        int i26 = this.mHeightMode;
        if (i26 >= 0) {
            i26 = this.mLastHeight;
        }
        if (i18 != -1 && layoutParams.height != i26) {
            this.mLastHeight = i26;
            layoutParams.height = i26;
            z16 = true;
        }
        if (layoutParams.x != i3) {
            layoutParams.x = i3;
            z16 = true;
        }
        if (layoutParams.y != i16) {
            layoutParams.y = i16;
            z16 = true;
        }
        int computeAnimationResource = computeAnimationResource();
        if (computeAnimationResource != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = computeAnimationResource;
            z16 = true;
        }
        int computeFlags = computeFlags(layoutParams.flags);
        if (computeFlags != layoutParams.flags) {
            layoutParams.flags = computeFlags;
        } else {
            z17 = z16;
        }
        if (z17) {
            this.mWindowManager.updateViewLayout(this.mPopupView, layoutParams);
        }
    }

    public BubblePopupWindow() {
        this((View) null, 0, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public BubblePopupWindow(View view) {
        this(view, 0, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
    }

    public BubblePopupWindow(int i3, int i16) {
        this((View) null, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public BubblePopupWindow(View view, int i3, int i16) {
        this(view, i3, i16, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public BubblePopupWindow(View view, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.mInputMethodMode = 0;
        this.mSoftInputMode = 1;
        this.mTouchable = true;
        this.mOutsideTouchable = false;
        this.mClippingEnabled = true;
        this.mSplitTouchEnabled = -1;
        this.mClipToScreen = true;
        this.mAllowScrollingAnchorParent = true;
        this.mLayoutInsetDecor = false;
        this.mKeepAbove = false;
        this.mDisplayWidth = ViewUtils.getScreenWidth();
        this.mAnchorOffset = 0;
        this.mDrawingLocation = new int[2];
        this.mScreenLocation = new int[2];
        this.mTempRect = new Rect();
        this.mWindowLayoutType = 1000;
        this.mOnDismissListeners = new ArrayList();
        this.mIgnoreCheekPress = false;
        this.mAnimationStyle = -1;
        this.mOnScrollChangedListener = new a();
        if (view != null) {
            Context context = view.getContext();
            this.mContext = context;
            this.mWindowManager = (WindowManager) context.getSystemService("window");
        }
        setContentView(view);
        setWidth(i3);
        setHeight(i16);
        setFocusable(z16);
    }

    public void update(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 65)) {
            update(view, false, 0, 0, true, i3, i16);
        } else {
            iPatchRedirector.redirect((short) 65, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void update(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 66)) {
            update(view, true, i3, i16, true, i17, i18);
        } else {
            iPatchRedirector.redirect((short) 66, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    private void update(View view, boolean z16, int i3, int i16, boolean z17, int i17, int i18) {
        int i19 = i17;
        int i26 = i18;
        if (!isShowing() || this.mContentView == null) {
            return;
        }
        WeakReference<View> weakReference = this.mAnchor;
        View view2 = view == null ? weakReference.get() : view;
        if (view2 == null) {
            return;
        }
        boolean z18 = z16 && !(this.mAnchorXoff == i3 && this.mAnchorYoff == i16);
        if (weakReference == null || weakReference.get() != view2 || (z18 && !this.mIsDropdown)) {
            registerForScrollChanged(view2, i3, i16);
        } else if (z18) {
            this.mAnchorXoff = i3;
            this.mAnchorYoff = i16;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        if (z17) {
            if (i19 == -1) {
                i19 = this.mPopupWidth;
            } else {
                this.mPopupWidth = i19;
            }
            if (i26 == -1) {
                i26 = this.mPopupHeight;
            } else {
                this.mPopupHeight = i26;
            }
        }
        int i27 = layoutParams.x;
        int i28 = layoutParams.y;
        if (z16) {
            findAbovePosition(view2, layoutParams, i3, i16);
        } else {
            findAbovePosition(view2, layoutParams, this.mAnchorXoff, this.mAnchorYoff);
        }
        int i29 = layoutParams.x;
        int i36 = layoutParams.y;
        update(i29, i36, i19, i26, (i27 == i29 && i28 == i36) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean findAbovePosition(View view, WindowManager.LayoutParams layoutParams, int i3, int i16) {
        boolean z16;
        boolean z17;
        view.getLocationInWindow(this.mDrawingLocation);
        View rootView = view.getRootView();
        int[] iArr = this.mDrawingLocation;
        layoutParams.x = iArr[0] + i3;
        layoutParams.y = iArr[1] + i16;
        layoutParams.gravity = 83;
        view.getLocationOnScreen(this.mScreenLocation);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        int i17 = this.mPopupWidth;
        int i18 = this.mPopupHeight;
        if (i17 == -2 || i18 == -2) {
            this.mPopupView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (this.mPopupWidth == -2) {
                i17 = this.mPopupView.getMeasuredWidth();
            }
            if (this.mPopupHeight == -2) {
                i18 = this.mPopupView.getMeasuredHeight();
            }
        }
        if (i17 > 0) {
            layoutParams.x = ((this.mScreenLocation[0] + (view.getWidth() / 2)) - (i17 / 2)) + i3;
        }
        if ((this.mScreenLocation[1] + i16) - i18 < rect.top || (layoutParams.x + i17) - rootView.getWidth() > 0) {
            if (this.mAllowScrollingAnchorParent) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, scrollX + i17 + i3, scrollY + i18 + view.getHeight() + i16), true);
                view.getLocationInWindow(this.mDrawingLocation);
                if (i17 > 0) {
                    layoutParams.x = ((this.mDrawingLocation[0] + (view.getWidth() / 2)) - (i17 / 2)) + i3;
                } else {
                    layoutParams.x = this.mDrawingLocation[0] + i3;
                }
                layoutParams.y = this.mDrawingLocation[1] + i16;
                view.getLocationOnScreen(this.mScreenLocation);
            }
            if ((this.mScreenLocation[1] + i16) - i18 < rect.top) {
                if (i18 + rect2.bottom + i16 > rect.bottom) {
                    layoutParams.y = rect2.top + (rect2.height() / 2) + i16;
                    z16 = true;
                } else {
                    layoutParams.y = this.mDrawingLocation[1] + view.getHeight() + i16;
                    layoutParams.gravity = 51;
                    z16 = false;
                }
                z17 = z16;
                if (this.mClipToScreen) {
                    int i19 = rect.right;
                    int i26 = rect.left;
                    int i27 = i19 - i26;
                    int i28 = layoutParams.x;
                    int i29 = i17 + i28;
                    if (i29 > i27) {
                        layoutParams.x = i28 - (i29 - i27);
                    }
                    if (layoutParams.x < i26) {
                        layoutParams.x = i26;
                        layoutParams.width = Math.min(layoutParams.width, i27);
                    }
                    if (z16 && !z17) {
                        int i36 = (this.mScreenLocation[1] + i16) - this.mPopupHeight;
                        if (i36 < 0) {
                            layoutParams.y += i36;
                        }
                    } else {
                        layoutParams.y = Math.max(layoutParams.y, rect.top);
                    }
                    layoutParams.gravity |= 268435456;
                }
                if (z16 && !z17) {
                    layoutParams.y = rootView.getHeight() - layoutParams.y;
                }
                int width = ((this.mScreenLocation[0] + (view.getWidth() / 2)) + i3) - layoutParams.x;
                if (!z16) {
                    layoutParams.y -= Math.round(TypedValue.applyDimension(1, 5.0f, this.mContext.getResources().getDisplayMetrics()));
                } else {
                    layoutParams.y -= Math.round(TypedValue.applyDimension(1, 3.0f, this.mContext.getResources().getDisplayMetrics()));
                }
                updateAboveAnchor(z16, width);
                return z16;
            }
            layoutParams.y = this.mDrawingLocation[1] + i16;
        }
        z17 = false;
        z16 = true;
        if (this.mClipToScreen) {
        }
        if (z16) {
            layoutParams.y = rootView.getHeight() - layoutParams.y;
        }
        int width2 = ((this.mScreenLocation[0] + (view.getWidth() / 2)) + i3) - layoutParams.x;
        if (!z16) {
        }
        updateAboveAnchor(z16, width2);
        return z16;
    }

    private void preparePopup(WindowManager.LayoutParams layoutParams) {
        preparePopup(layoutParams, false);
    }
}
