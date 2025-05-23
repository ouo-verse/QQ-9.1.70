package com.tencent.richframework.widget.popupwindow;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes25.dex */
public class RFWSmartPopupWindow<T extends RFWSmartPopupWindow<T>> {
    private static final List<String> SHOWING_WINDOW_LIST = new CopyOnWriteArrayList();
    private int mAlign;
    private WeakReference<View> mAnchorView;

    @ColorInt
    private int mBubbleColor;

    @ColorInt
    private int[] mBubbleGradientColor;
    private RFWBubbleView mBubbleView;
    private View mContentView;

    @LayoutRes
    private int mContentViewLayoutId;
    private final Context mContext;
    protected int mContextHashCode;
    private long mDismissInterval;
    private boolean mEnableBubbleBound;
    private boolean mEnableBubbleShadow;
    private SizeListener mFirstShowSizeListener;
    private int mOffsetX;
    private int mOffsetY;
    private final AnchorRelativePopupWindow mPopupWindow;
    private int mPosition;
    private ScrollListener mScrollListener;
    private AttachStateChangeListener mStateChangeListener;
    private SizeListener mUpdateSizeListener;
    private boolean mEnableClickDismiss = true;
    private boolean mEnableDetachedListener = true;
    private final Runnable mDismissTask = new Runnable() { // from class: a04.c
        @Override // java.lang.Runnable
        public final void run() {
            RFWSmartPopupWindow.this.dismiss();
        }
    };
    private int mStatus = 2;
    private int mVertPos = 0;
    private int mHorizPos = 0;
    private final List<IStatusCallback> mCallbackList = new ArrayList();

    /* loaded from: classes25.dex */
    public interface IShowCondition {
    }

    /* loaded from: classes25.dex */
    public interface IStatusCallback {
        void onClick(View view);

        void onDismiss();

        void onShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class ScrollListener implements ViewTreeObserver.OnScrollChangedListener {
        private final WeakReference<View> mTargetView;
        private final WeakReference<RFWSmartPopupWindow> mTip;

        public ScrollListener(RFWSmartPopupWindow rFWSmartPopupWindow, View view) {
            this.mTip = new WeakReference<>(rFWSmartPopupWindow);
            this.mTargetView = new WeakReference<>(view);
        }

        private void removeListener() {
            if (this.mTargetView.get() != null && this.mTargetView.get().getViewTreeObserver() != null) {
                RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[onScrollChanged] remove listener. ");
                this.mTargetView.get().getViewTreeObserver().removeOnScrollChangedListener(this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (this.mTip.get() != null) {
                this.mTip.get().updatePopupWindow();
            } else {
                removeListener();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class SizeListener implements ViewTreeObserver.OnPreDrawListener {
        private final boolean mIsUpdate;
        private final WeakReference<View> mTargetView;
        private final WeakReference<RFWSmartPopupWindow> mTip;

        public SizeListener(RFWSmartPopupWindow rFWSmartPopupWindow, View view, boolean z16) {
            this.mTip = new WeakReference<>(rFWSmartPopupWindow);
            this.mTargetView = new WeakReference<>(view);
            this.mIsUpdate = z16;
        }

        private void removeListener() {
            if (this.mTargetView.get() != null && this.mTargetView.get().getViewTreeObserver() != null) {
                RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[onSizeReady] remove listener. ");
                this.mTargetView.get().getViewTreeObserver().removeOnPreDrawListener(this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.mTip.get() == null) {
                removeListener();
                return true;
            }
            if (this.mIsUpdate) {
                this.mTip.get().onUpdateSizeReady();
            } else {
                this.mTip.get().onSizeReady();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RFWSmartPopupWindow(Context context) {
        this.mContext = context;
        this.mPopupWindow = new AnchorRelativePopupWindow(context);
        configureDefault();
    }

    private void addStateChangeListenerIfNeed() {
        if (this.mEnableDetachedListener && getAnchorView() != null) {
            getAnchorView().addOnAttachStateChangeListener(this.mStateChangeListener);
        }
    }

    private void adjustBubbleArrowPos(int[] iArr) {
        if (this.mBubbleView != null && getAnchorView() != null) {
            int width = (((getAnchorView().getWidth() / 2) - iArr[0]) - (this.mBubbleView.getArrowWidth() / 2)) - this.mContentView.getPaddingLeft();
            int arrowWidth = ((((-getAnchorView().getHeight()) / 2) - iArr[1]) - (this.mBubbleView.getArrowWidth() / 2)) - this.mContentView.getPaddingTop();
            int i3 = this.mPosition;
            if (i3 != 0 && i3 != 1) {
                this.mBubbleView.setArrowOffsetY(arrowWidth);
            } else {
                this.mBubbleView.setArrowOffsetX(width);
            }
        }
    }

    private void adjustBubblePadding(@NonNull View view) {
        int dip2px = DisplayUtil.dip2px(view.getContext(), 6.0f) + 12;
        int i3 = this.mVertPos;
        if (i3 == 1) {
            view.setPadding(12, 12, 12, dip2px);
            return;
        }
        if (i3 == 2) {
            view.setPadding(12, dip2px, 12, 12);
            return;
        }
        int i16 = this.mHorizPos;
        if (i16 == 1) {
            view.setPadding(12, 12, dip2px, 12);
        } else if (i16 == 2) {
            view.setPadding(dip2px, 12, 12, 12);
        }
    }

    private void clearCallBacks() {
        List<IStatusCallback> list = this.mCallbackList;
        if (list != null) {
            list.clear();
        }
    }

    private void configureDefault() {
        if (this.mContext == null) {
            return;
        }
        RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[configureDefault] ");
        this.mVertPos = 2;
        this.mHorizPos = 3;
        this.mPosition = 1;
        this.mAlign = 1;
        this.mDismissInterval = 3000L;
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.mPopupWindow.setOutsideTouchable(true);
        this.mContextHashCode = this.mContext.hashCode();
    }

    private void createViewListener() {
        if (this.mScrollListener == null) {
            this.mScrollListener = new ScrollListener(this, getAnchorView());
        }
        if (this.mEnableDetachedListener && this.mStateChangeListener == null) {
            this.mStateChangeListener = new AttachStateChangeListener(this, getAnchorView());
        }
    }

    private void finalShow() {
        this.mStatus = 2;
        try {
            if (getAnchorView() == null) {
                RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "finalShow anchor is null. ");
                return;
            }
            if (hasShowingTip()) {
                RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "show | has showing tip. key: " + generateWindowKey());
                return;
            }
            recordShowingTip();
            createViewListener();
            getAnchorView().getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
            addStateChangeListenerIfNeed();
            initDismissListeners();
            inflateContentView();
            showContentInner();
            handleShowCallbacks();
            if (this.mDismissInterval > 0) {
                RFWThreadManager.getUIHandler().postDelayed(this.mDismissTask, this.mDismissInterval);
            }
        } catch (Exception e16) {
            RFWLog.fatal("RFWSmartPopupWindow", RFWLog.USR, e16);
        }
    }

    private void finalUpdateWindow() {
        if (this.mPopupWindow != null && getAnchorView() != null && this.mContentView != null) {
            int[] measureAndGetDropDownTrans = this.mPopupWindow.measureAndGetDropDownTrans(getAnchorView(), this.mVertPos, this.mHorizPos, this.mOffsetX, this.mOffsetY);
            int[] iArr = new int[2];
            RFWSmartPopupWindowHelper.findRealTransition(getAnchorView(), this.mContentView.getMeasuredWidth(), this.mContentView.getMeasuredHeight(), measureAndGetDropDownTrans[0], measureAndGetDropDownTrans[1], iArr);
            adjustBubbleArrowPos(iArr);
            try {
                this.mPopupWindow.update(getAnchorView(), iArr[0], iArr[1], -1, -1);
            } catch (Exception e16) {
                RFWLog.fatal("RFWSmartPopupWindow", RFWLog.USR, new NullPointerException("finalUpdateWindow failed. " + e16));
            }
        }
    }

    public static RFWSmartPopupWindow from(Context context) {
        return new RFWSmartPopupWindow(context);
    }

    private View getAnchorView() {
        WeakReference<View> weakReference = this.mAnchorView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickCallbacks(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        for (IStatusCallback iStatusCallback : this.mCallbackList) {
            if (iStatusCallback != null) {
                iStatusCallback.onClick(view);
            }
        }
        if (this.mEnableClickDismiss) {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void handleDismissCallbacks() {
        for (IStatusCallback iStatusCallback : this.mCallbackList) {
            if (iStatusCallback != null) {
                iStatusCallback.onDismiss();
            }
        }
    }

    private void handleScrollEvent() {
        if (getAnchorView() != null && this.mPopupWindow != null) {
            if (getAnchorView().isAttachedToWindow() && getAnchorView().getWindowToken() != null) {
                if (!getAnchorView().getLocalVisibleRect(new Rect())) {
                    RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[handleScrollEvent] anchor is not on screen. ");
                    dismiss();
                    return;
                }
                int[] iArr = new int[2];
                getAnchorView().getLocationInWindow(iArr);
                if (iArr[0] == 0 && iArr[1] == 0) {
                    RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[handleScrollEvent] anchor is invalid. ");
                    return;
                } else {
                    finalUpdateWindow();
                    return;
                }
            }
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[handleScrollEvent] anchor is not attach to window. ");
            dismiss();
            return;
        }
        RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[handleScrollEvent] anchor or popupWindow are null. ");
    }

    private void handleShowCallbacks() {
        for (IStatusCallback iStatusCallback : this.mCallbackList) {
            if (iStatusCallback != null) {
                iStatusCallback.onShow();
            }
        }
    }

    private boolean hasShowingTip() {
        return SHOWING_WINDOW_LIST.contains(generateWindowKey());
    }

    private void inflateContentView() {
        if (this.mContentViewLayoutId == 0) {
            return;
        }
        if (this.mContentView != null) {
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "inflater error. custom view already exist.");
            return;
        }
        try {
            this.mContentView = LayoutInflater.from(this.mContext).inflate(this.mContentViewLayoutId, (ViewGroup) null, false);
        } catch (Exception e16) {
            RFWLog.fatal("RFWSmartPopupWindow", RFWLog.USR, e16);
        }
    }

    private void initDismissListeners() {
        final String generateWindowKey = generateWindowKey();
        this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: a04.a
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                RFWSmartPopupWindow.this.lambda$initDismissListeners$0(generateWindowKey);
            }
        });
    }

    private boolean isNeedWaitSizeReady(@NonNull View view) {
        boolean z16;
        boolean z17;
        if (view.getHeight() == 0 && view.getWidth() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || z16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDismissListeners$0(String str) {
        SHOWING_WINDOW_LIST.remove(str);
        handleDismissCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSizeReady() {
        if (getAnchorView() != null && !isNeedWaitSizeReady(getAnchorView())) {
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[onSizeReady] anchor | w: " + getAnchorView().getWidth() + ", h: " + getAnchorView().getHeight());
            getAnchorView().getViewTreeObserver().removeOnPreDrawListener(this.mFirstShowSizeListener);
            finalShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateSizeReady() {
        if (getAnchorView() != null && this.mPopupWindow != null && !isNeedWaitSizeReady(getAnchorView())) {
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[onUpdateSizeReady] anchor | w: " + getAnchorView().getWidth() + ", h: " + getAnchorView().getHeight());
            getAnchorView().getViewTreeObserver().removeOnPreDrawListener(this.mUpdateSizeListener);
            finalUpdateWindow();
        }
    }

    private void recordShowingTip() {
        SHOWING_WINDOW_LIST.add(generateWindowKey());
    }

    private void removeAllListener() {
        if (getAnchorView() == null) {
            return;
        }
        getAnchorView().getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
        getAnchorView().getViewTreeObserver().removeOnPreDrawListener(this.mFirstShowSizeListener);
        getAnchorView().getViewTreeObserver().removeOnPreDrawListener(this.mUpdateSizeListener);
        getAnchorView().removeOnAttachStateChangeListener(this.mStateChangeListener);
    }

    private void showContentInner() {
        View anchorView = getAnchorView();
        if (anchorView != null && this.mPopupWindow != null && this.mContentView != null) {
            int width = anchorView.getWidth();
            int height = anchorView.getHeight();
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "anchor w | " + width + ", h | " + height);
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: a04.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RFWSmartPopupWindow.this.handleClickCallbacks(view);
                }
            });
            transformPosAlign();
            wrapBubbleBackground();
            this.mPopupWindow.setContentView(this.mContentView);
            int[] measureAndGetDropDownTrans = this.mPopupWindow.measureAndGetDropDownTrans(anchorView, this.mVertPos, this.mHorizPos, this.mOffsetX, this.mOffsetY);
            int[] iArr = new int[2];
            RFWSmartPopupWindowHelper.findRealTransition(anchorView, this.mContentView.getMeasuredWidth(), this.mContentView.getMeasuredHeight(), measureAndGetDropDownTrans[0], measureAndGetDropDownTrans[1], iArr);
            adjustBubbleArrowPos(iArr);
            this.mPopupWindow.showOnAnchor(anchorView, iArr[0], iArr[1]);
        }
    }

    private void showImmediately() {
        View anchorView = getAnchorView();
        if (anchorView == null) {
            RFWLog.fatal("RFWSmartPopupWindow", RFWLog.USR, new NullPointerException("show | anchor = null"));
            return;
        }
        if (isNeedWaitSizeReady(anchorView)) {
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "anchor seems not inflated. w | " + anchorView.getWidth() + ", h | " + anchorView.getHeight());
            this.mFirstShowSizeListener = new SizeListener(this, getAnchorView(), false);
            anchorView.getViewTreeObserver().addOnPreDrawListener(this.mFirstShowSizeListener);
            this.mStatus = 1;
            return;
        }
        finalShow();
    }

    private void transformPosAlign() {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18 = this.mPosition;
        int i19 = 3;
        if (i18 != 0) {
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 == 3) {
                        this.mHorizPos = 2;
                    }
                } else {
                    this.mHorizPos = 1;
                }
            } else {
                this.mVertPos = 2;
            }
        } else {
            this.mVertPos = 1;
        }
        int i26 = 0;
        if (i18 != 0 && i18 != 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        int i27 = this.mAlign;
        if (i27 != 0) {
            if (i27 != 1) {
                if (i27 == 2) {
                    int i28 = 4;
                    if (z16) {
                        i17 = 4;
                    } else {
                        i17 = this.mHorizPos;
                    }
                    this.mHorizPos = i17;
                    if (z16) {
                        i28 = this.mVertPos;
                    }
                    this.mVertPos = i28;
                    return;
                }
                return;
            }
            if (z16) {
                i16 = 3;
            } else {
                i16 = this.mHorizPos;
            }
            this.mHorizPos = i16;
            if (z16) {
                i19 = this.mVertPos;
            }
            this.mVertPos = i19;
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = this.mHorizPos;
        }
        this.mHorizPos = i3;
        if (z16) {
            i26 = this.mVertPos;
        }
        this.mVertPos = i26;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePopupWindow() {
        if (!isShowing()) {
            return;
        }
        handleScrollEvent();
    }

    private void wrapBubbleBackground() {
        if ((this.mBubbleGradientColor == null && this.mBubbleColor == 0) || this.mContext == null) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        RFWBubbleView rFWBubbleView = new RFWBubbleView(this.mContext);
        this.mBubbleView = rFWBubbleView;
        rFWBubbleView.addView(this.mContentView);
        frameLayout.addView(this.mBubbleView);
        this.mContentView = frameLayout;
        adjustBubblePadding(frameLayout);
        int i3 = this.mBubbleColor;
        if (i3 != 0) {
            this.mBubbleView.setBubbleColor(i3);
        } else {
            int[] iArr = this.mBubbleGradientColor;
            if (iArr != null) {
                this.mBubbleView.setBubbleColors(iArr);
            }
        }
        this.mBubbleView.setEnableShadow(this.mEnableBubbleShadow);
        this.mBubbleView.setEnableBound(this.mEnableBubbleBound);
        this.mBubbleView.setArrowPosition(this.mPosition);
    }

    public T addStatusCallback(IStatusCallback iStatusCallback) {
        this.mCallbackList.add(iStatusCallback);
        return this;
    }

    public void dismiss() {
        removeAllListener();
        if (this.mPopupWindow == null) {
            RFWLog.fatal("RFWSmartPopupWindow", RFWLog.USR, new NullPointerException("mPopupWindow == null"));
            clearCallBacks();
            return;
        }
        RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "dismiss after " + this.mDismissInterval + ", hashcode: " + this.mContextHashCode);
        RFWThreadManager.getUIHandler().removeCallbacks(this.mDismissTask);
        this.mPopupWindow.dismiss();
        clearCallBacks();
    }

    protected String generateWindowKey() {
        String valueOf = String.valueOf(this.mContextHashCode);
        RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "generateTipKey: " + valueOf);
        return valueOf;
    }

    public boolean isShowing() {
        AnchorRelativePopupWindow anchorRelativePopupWindow = this.mPopupWindow;
        if (anchorRelativePopupWindow == null) {
            RFWLog.fatal("RFWSmartPopupWindow", RFWLog.USR, new NullPointerException("mPopupWindow == null"));
            return false;
        }
        return anchorRelativePopupWindow.isShowing();
    }

    public T setAlignment(int i3) {
        this.mAlign = i3;
        return this;
    }

    public T setAnchor(View view) {
        this.mAnchorView = new WeakReference<>(view);
        return this;
    }

    public T setBubbleBackground(@ColorInt int i3) {
        this.mBubbleColor = i3;
        return this;
    }

    public T setContentView(@NonNull View view) {
        this.mContentView = view;
        return this;
    }

    public T setDismissInterval(long j3) {
        this.mDismissInterval = j3;
        return this;
    }

    public T setEnableClickDismiss(boolean z16) {
        this.mEnableClickDismiss = z16;
        return this;
    }

    public T setFocusable(boolean z16) {
        this.mPopupWindow.setFocusable(z16);
        return this;
    }

    public T setOffsetDp(float f16, float f17) {
        Context context = this.mContext;
        if (context == null) {
            return this;
        }
        this.mOffsetX = DisplayUtil.dip2px(context, f16);
        this.mOffsetY = DisplayUtil.dip2px(this.mContext, f17);
        return this;
    }

    public T setPosition(int i3) {
        this.mPosition = i3;
        return this;
    }

    public T setTouchOutsideDismiss(boolean z16) {
        this.mPopupWindow.setOutsideTouchable(z16);
        return this;
    }

    public void show() {
        showImmediately();
    }

    public T setContentView(@LayoutRes int i3) {
        if (this.mContext != null && this.mContentView == null) {
            this.mContentViewLayoutId = i3;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class AttachStateChangeListener implements View.OnAttachStateChangeListener {
        private final WeakReference<View> mTargetView;
        private final WeakReference<RFWSmartPopupWindow> mTip;

        public AttachStateChangeListener(RFWSmartPopupWindow rFWSmartPopupWindow, View view) {
            this.mTip = new WeakReference<>(rFWSmartPopupWindow);
            this.mTargetView = new WeakReference<>(view);
        }

        private void removeListener() {
            if (this.mTargetView.get() == null) {
                return;
            }
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[onViewDetachedFromWindow] remove listener.");
            this.mTargetView.get().removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (this.mTip.get() == null) {
                RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[onViewDetachedFromWindow] tip is null.");
                removeListener();
            } else {
                RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "[onViewDetachedFromWindow] dismiss tip. ");
                this.mTip.get().dismiss();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
