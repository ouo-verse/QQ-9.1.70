package com.tencent.richframework.bubble.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.bubble.bean.RFWTipsBaseConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class RFWTipsBaseController implements View.OnClickListener {
    protected RFWTipsBaseConfig mConfig;
    protected Runnable mDismissRunnable;
    protected boolean mIsStartShow;
    protected PopupWindow mPopupWindow;
    protected View mRootView;
    protected ScrollListener mScrollListener;
    protected WeakReference<View> mTargetView;
    protected List<TipsStatusCallBack> mCallBackList = new ArrayList();
    protected Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class ScrollListener implements ViewTreeObserver.OnScrollChangedListener {
        WeakReference<RFWTipsBaseController> mController;

        ScrollListener(RFWTipsBaseController rFWTipsBaseController) {
            this.mController = new WeakReference<>(rFWTipsBaseController);
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            WeakReference<RFWTipsBaseController> weakReference = this.mController;
            if (weakReference != null && weakReference.get() != null) {
                this.mController.get().updatePopupWindow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class TipsDismissRunnable implements Runnable {
        WeakReference<RFWTipsBaseController> mController;

        TipsDismissRunnable(RFWTipsBaseController rFWTipsBaseController) {
            this.mController = new WeakReference<>(rFWTipsBaseController);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<RFWTipsBaseController> weakReference = this.mController;
            if (weakReference != null && weakReference.get() != null) {
                this.mController.get().handleDissmiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class TipsShowRunnable implements Runnable {
        WeakReference<RFWTipsBaseController> mController;

        TipsShowRunnable(RFWTipsBaseController rFWTipsBaseController) {
            this.mController = new WeakReference<>(rFWTipsBaseController);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<RFWTipsBaseController> weakReference = this.mController;
            if (weakReference != null && weakReference.get() != null) {
                this.mController.get().handShow();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface TipsStatusCallBack {
        void click(View view);

        void dismiss();

        void show();
    }

    public RFWTipsBaseController(View view, RFWTipsBaseConfig rFWTipsBaseConfig) {
        this.mTargetView = new WeakReference<>(view);
        this.mConfig = rFWTipsBaseConfig;
    }

    private boolean activityIsFinishing(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handShow() {
        WeakReference<View> weakReference;
        if (this.mPopupWindow != null && (weakReference = this.mTargetView) != null && weakReference.get() != null) {
            Rect rect = new Rect();
            setStartShow(true);
            if (!this.mTargetView.get().getLocalVisibleRect(rect)) {
                handleDismissCallBack();
                QLog.d("RFWTipsBaseController", 1, "view is not visible");
                return;
            }
            int[] showXY = getShowXY(this.mTargetView.get(), this.mPopupWindow);
            if (showXY != null && showXY.length >= 2 && showXY[0] >= 0 && showXY[1] >= 0) {
                this.mScrollListener = new ScrollListener(this);
                if (activityIsFinishing(getContext())) {
                    QLog.d("RFWTipsBaseController", 1, "activity is finishing or destroyed");
                    return;
                }
                this.mPopupWindow.showAtLocation(this.mTargetView.get(), getGravity(), showXY[0], showXY[1]);
                if (this.mTargetView.get().getViewTreeObserver() != null) {
                    this.mTargetView.get().getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
                }
                handleShowCallBack();
                return;
            }
            QLog.d("RFWTipsBaseController", 1, "view is not visible");
            handleDismissCallBack();
        }
    }

    private void handleClickCallBack(View view) {
        List<TipsStatusCallBack> list = this.mCallBackList;
        if (list != null && list.size() != 0) {
            ListIterator<TipsStatusCallBack> listIterator = this.mCallBackList.listIterator();
            while (listIterator.hasNext()) {
                TipsStatusCallBack next = listIterator.next();
                if (next != null) {
                    next.click(view);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDismissCallBack() {
        List<TipsStatusCallBack> list = this.mCallBackList;
        if (list != null && list.size() != 0) {
            ListIterator<TipsStatusCallBack> listIterator = this.mCallBackList.listIterator();
            while (listIterator.hasNext()) {
                TipsStatusCallBack next = listIterator.next();
                if (next != null) {
                    next.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDissmiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing() && !activityIsFinishing(getContext())) {
            this.mPopupWindow.dismiss();
        }
    }

    private void handleShowCallBack() {
        List<TipsStatusCallBack> list = this.mCallBackList;
        if (list != null && list.size() != 0) {
            ListIterator<TipsStatusCallBack> listIterator = this.mCallBackList.listIterator();
            while (listIterator.hasNext()) {
                TipsStatusCallBack next = listIterator.next();
                if (next != null) {
                    next.show();
                }
            }
        }
    }

    private void setStartShow(boolean z16) {
        this.mIsStartShow = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePopupWindow() {
        WeakReference<View> weakReference = this.mTargetView;
        if (weakReference != null && weakReference.get() != null && this.mPopupWindow != null) {
            int[] showXY = getShowXY(this.mTargetView.get(), this.mPopupWindow);
            if (showXY != null && showXY.length >= 2 && showXY[0] >= 0 && showXY[1] >= 0) {
                int measuredHeight = this.mPopupWindow.getContentView().getMeasuredHeight();
                this.mPopupWindow.update(showXY[0], showXY[1], this.mPopupWindow.getContentView().getMeasuredWidth(), measuredHeight);
            } else {
                QLog.d("RFWTipsBaseController", 1, "view is not visible");
                dismiss();
            }
        }
    }

    public void addTipsStatusCallBack(TipsStatusCallBack tipsStatusCallBack) {
        this.mCallBackList.add(tipsStatusCallBack);
    }

    protected abstract boolean clickPopupWindowDismiss();

    public void dismiss() {
        WeakReference<View> weakReference;
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing() && (weakReference = this.mTargetView) != null && weakReference.get() != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
            this.mTargetView.get().removeCallbacks(this.mDismissRunnable);
            if (this.mTargetView.get().getViewTreeObserver() != null) {
                this.mTargetView.get().getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
            }
        }
    }

    public RFWTipsBaseConfig getConfig() {
        return this.mConfig;
    }

    public Context getContext() {
        WeakReference<View> weakReference = this.mTargetView;
        if (weakReference != null && weakReference.get() != null) {
            return this.mTargetView.get().getContext();
        }
        return null;
    }

    public long getDuration() {
        RFWTipsBaseConfig rFWTipsBaseConfig = this.mConfig;
        if (rFWTipsBaseConfig != null && rFWTipsBaseConfig.getDuration() != 0) {
            return this.mConfig.getDuration();
        }
        return 3000L;
    }

    protected abstract int getGravity();

    protected abstract int getLayoutId();

    protected boolean getOutsideTouchable() {
        return true;
    }

    public PopupWindow getPopupWindow() {
        return this.mPopupWindow;
    }

    protected int getPopupWindowHeight() {
        return -2;
    }

    protected int getPopupWindowWidth() {
        return -2;
    }

    public int getPriority() {
        RFWTipsBaseConfig rFWTipsBaseConfig = this.mConfig;
        if (rFWTipsBaseConfig != null && rFWTipsBaseConfig.getPriority() != 0) {
            return this.mConfig.getPriority();
        }
        return 100;
    }

    protected abstract int[] getShowXY(View view, PopupWindow popupWindow);

    protected void initPopupWindow() {
        WeakReference<View> weakReference = this.mTargetView;
        if (weakReference == null) {
            return;
        }
        View view = weakReference.get();
        if (view == null) {
            QLog.d("RFWTipsBaseController", 1, "anchorView is not null");
            return;
        }
        Context context = view.getContext();
        if (this.mPopupWindow == null) {
            this.mRootView = LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(this.mRootView, getPopupWindowWidth(), getPopupWindowHeight());
            this.mPopupWindow = popupWindow;
            popupWindow.setOutsideTouchable(getOutsideTouchable());
            this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.richframework.bubble.controller.RFWTipsBaseController.1
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    RFWTipsBaseController.this.handleDismissCallBack();
                }
            });
            View view2 = this.mRootView;
            if (view2 != null) {
                view2.setOnClickListener(this);
            }
        }
        View view3 = this.mRootView;
        if (view3 != null) {
            initView(view3);
        }
        this.mPopupWindow.getContentView().measure(0, 0);
    }

    protected abstract void initView(View view);

    public boolean isEnded() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return true;
        }
        if (this.mIsStartShow && !popupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (clickPopupWindowDismiss()) {
            dismiss();
        }
        handleClickCallBack(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void startShowTip() {
        initPopupWindow();
        if (this.mPopupWindow == null) {
            QLog.d("RFWTipsBaseController", 1, "PopupWindow is not null");
            return;
        }
        this.mHandler.post(new TipsShowRunnable(this));
        TipsDismissRunnable tipsDismissRunnable = new TipsDismissRunnable(this);
        this.mDismissRunnable = tipsDismissRunnable;
        this.mHandler.postDelayed(tipsDismissRunnable, getDuration());
    }
}
