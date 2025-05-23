package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.profilecard.AbsHandleEventListener;
import com.tencent.mobileqq.profilecard.bussiness.instep.IBusinessZPlanHandleEventListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class PullToZoomHeaderListView extends XListView {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_OVER_SCROLL_Y_DISTANCE = 200;
    private static final String TAG = "PullToZoomHeaderListView";
    private final ArrayList<IBusinessZPlanHandleEventListener> mBusinessZPlanHandleEventListeners;
    private int mDownPositionX;
    private int mDownPositionY;
    private AbsHandleEventListener mHandleEventListener;
    private boolean mHandlerEventEnableX;
    private ImageView mHeaderImage;
    private int mHeaderImageHeight;
    private View mHeaderMask;
    private boolean mIsAbsHandled;
    private int mMaxOverScrollY;
    private IProfileBaseView mProfileBaseView;
    private int mTouchSlop;

    public PullToZoomHeaderListView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void init() {
        this.mMaxOverScrollY = (int) (getResources().getDisplayMetrics().density * 200.0f);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("init mMaxOverScrollY=%s", Integer.valueOf(this.mMaxOverScrollY)));
        }
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void resetZPlanHandleParams() {
        setEnabled(true);
        this.mIsAbsHandled = false;
    }

    private void setChildUnPressed(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null) {
                childAt.setPressed(false);
                if (childAt instanceof ViewGroup) {
                    setChildUnPressed((ViewGroup) childAt);
                }
            }
        }
    }

    private void updateHeaderImage() {
        if (this.mHeaderImage != null && this.mHeaderImageHeight > 0) {
            int scrollY = getScrollY();
            int left = this.mHeaderImage.getLeft();
            int top = this.mHeaderImage.getTop();
            int right = this.mHeaderImage.getRight();
            int bottom = this.mHeaderImage.getBottom();
            if (scrollY >= 0) {
                scrollY = 0;
            }
            if (scrollY != top) {
                this.mHeaderImage.layout(left, scrollY, right, bottom);
                View view = this.mHeaderMask;
                if (view != null) {
                    view.layout(left, scrollY, right, bottom);
                }
                IProfileBaseView iProfileBaseView = this.mProfileBaseView;
                if (iProfileBaseView != null) {
                    iProfileBaseView.updateClipTop(scrollY);
                }
            }
        }
    }

    public void addBusinessHandleEvent(IBusinessZPlanHandleEventListener iBusinessZPlanHandleEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iBusinessZPlanHandleEventListener);
        } else if (!this.mBusinessZPlanHandleEventListeners.contains(iBusinessZPlanHandleEventListener)) {
            this.mBusinessZPlanHandleEventListeners.add(iBusinessZPlanHandleEventListener);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            updateHeaderImage();
            super.computeScroll();
        }
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AbsHandleEventListener absHandleEventListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mHandleEventListener == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked() & 255;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        resetZPlanHandleParams();
                    }
                } else {
                    int y16 = (int) motionEvent.getY();
                    int x16 = (int) motionEvent.getX();
                    if ((Math.abs(y16 - this.mDownPositionY) > this.mTouchSlop || (this.mHandlerEventEnableX && Math.abs(x16 - this.mDownPositionX) > this.mTouchSlop)) && (absHandleEventListener = this.mHandleEventListener) != null) {
                        boolean handleEvent = absHandleEventListener.handleEvent(motionEvent);
                        this.mIsAbsHandled = handleEvent;
                        if (handleEvent) {
                            setEnabled(false);
                            traverseBusinessHandleEvent(motionEvent);
                            return true;
                        }
                        setEnabled(true);
                    }
                }
            }
            AbsHandleEventListener absHandleEventListener2 = this.mHandleEventListener;
            if (absHandleEventListener2 != null) {
                absHandleEventListener2.handleEvent(motionEvent);
            }
            if (this.mIsAbsHandled) {
                setChildUnPressed(this);
                resetZPlanHandleParams();
                traverseBusinessHandleEvent(motionEvent);
                return true;
            }
            resetZPlanHandleParams();
        } else {
            this.mIsAbsHandled = false;
            this.mDownPositionY = (int) motionEvent.getY();
            this.mDownPositionX = (int) motionEvent.getX();
            AbsHandleEventListener absHandleEventListener3 = this.mHandleEventListener;
            if (absHandleEventListener3 != null) {
                absHandleEventListener3.handleEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.mHandleEventListener = null;
            this.mBusinessZPlanHandleEventListeners.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        ImageView imageView = this.mHeaderImage;
        if (imageView != null && this.mHeaderImageHeight == 0) {
            this.mHeaderImageHeight = imageView.getHeight();
            ViewGroup viewGroup = (ViewGroup) this.mHeaderImage.getParent();
            while (viewGroup != null) {
                viewGroup.setClipChildren(false);
                viewGroup.setClipToPadding(false);
                if (viewGroup != this) {
                    try {
                        viewGroup = (ViewGroup) viewGroup.getParent();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "onLayout setClipChildren fail!", e16);
                        }
                        viewGroup = null;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16))).booleanValue();
        }
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, this.mMaxOverScrollY, z16);
    }

    public void setHandleEvent(AbsHandleEventListener absHandleEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) absHandleEventListener);
        } else {
            this.mHandleEventListener = absHandleEventListener;
        }
    }

    public void setHandleEventEnableX(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.mHandlerEventEnableX = z16;
        }
    }

    public void setHeaderImage(ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) imageView);
        } else {
            this.mHeaderImage = imageView;
            this.mHeaderImageHeight = 0;
        }
    }

    public void setHeaderMask(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.mHeaderMask = view;
        }
    }

    public void setProfileBaseView(IProfileBaseView iProfileBaseView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iProfileBaseView);
        } else {
            this.mProfileBaseView = iProfileBaseView;
        }
    }

    public void traverseBusinessHandleEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent);
            return;
        }
        Iterator<IBusinessZPlanHandleEventListener> it = this.mBusinessZPlanHandleEventListeners.iterator();
        while (it.hasNext()) {
            it.next().handleZPlanEvent(motionEvent);
        }
    }

    public PullToZoomHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PullToZoomHeaderListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mHandlerEventEnableX = false;
        this.mBusinessZPlanHandleEventListeners = new ArrayList<>();
        init();
    }
}
