package com.tencent.mobileqq.qcircle.api.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qcircle.api.event.QCircleActivityFocusChangeEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSeekAreaEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import uq3.o;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleSeekAreaFrameLayout extends FrameLayout implements SimpleEventReceiver {
    private static final int CLICK_EVENT_TIME = 500;
    private static final int INTERCEPT_TYPE_CANCEL = 3;
    private static final int INTERCEPT_TYPE_CLICK = 2;
    private static final int INTERCEPT_TYPE_NONE = 0;
    private static final int INTERCEPT_TYPE_SLIDE = 1;
    private static final int MOCK_DELAY_TIME = 50;
    private static final String TAG = "QCircleSeekAreaFrameLayout";
    private MotionEvent mDownEvent;
    private final Rect mGlobalRect;
    private boolean mLastMoveFlag;
    private long mLastUpEventTime;
    private int mLoopCheckCount;
    private long mLoopCheckTime;
    private MotionEvent mMockDownEvent;
    private MotionEvent mMockUpEvent;
    private b mPreClickListener;
    private float mSeekBarLastTouchX;
    private float mSeekBarLastTouchY;
    private final int mTouchSlop;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(float f16, float f17, a aVar);
    }

    public QCircleSeekAreaFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMockLoop(MotionEvent motionEvent) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_check_mock_click_loop", true)) {
            return false;
        }
        if (this.mLoopCheckCount == 0) {
            this.mLoopCheckTime = motionEvent.getDownTime();
        } else if (motionEvent.getDownTime() - this.mLoopCheckTime > 500) {
            this.mLoopCheckCount = 0;
            this.mLoopCheckTime = motionEvent.getDownTime();
        }
        int i3 = this.mLoopCheckCount + 1;
        this.mLoopCheckCount = i3;
        if (i3 > 4) {
            return true;
        }
        return false;
    }

    private boolean enableActivityDispatch() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_activity_dispatch_mock_click_event", true);
    }

    private void getGlobalRect() {
        Rect rect = this.mGlobalRect;
        if (rect.top == 0) {
            getGlobalVisibleRect(rect);
            QLog.d(TAG, 1, "getGlobalRect:" + this.mGlobalRect.top);
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            QLog.d(TAG, 1, "getLocationInWindow:" + iArr[0] + APLogFileUtil.SEPARATOR_LOG + iArr[1]);
            int[] iArr2 = new int[2];
            getLocationOnScreen(iArr2);
            QLog.d(TAG, 1, "getLocationOnScreen:" + iArr2[0] + APLogFileUtil.SEPARATOR_LOG + iArr2[1]);
        }
    }

    private boolean isXScroll(float f16, float f17) {
        if (Math.abs(f16) >= Math.abs(f17)) {
            return true;
        }
        return false;
    }

    private void mockClickEvent(final MotionEvent motionEvent, final MotionEvent motionEvent2) {
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.helper.QCircleSeekAreaFrameLayout.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qcircle.api.helper.QCircleSeekAreaFrameLayout$1$a */
            /* loaded from: classes16.dex */
            class a implements a {
                a() {
                }

                @Override // com.tencent.mobileqq.qcircle.api.helper.QCircleSeekAreaFrameLayout.a
                public void a() {
                    e();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void e() {
                if (!QCircleSeekAreaFrameLayout.this.checkMockLoop(motionEvent)) {
                    QCircleSeekAreaFrameLayout.this.mockDown(motionEvent);
                    QCircleSeekAreaFrameLayout.this.mockUp(motionEvent2);
                    motionEvent.recycle();
                    motionEvent2.recycle();
                    return;
                }
                QLog.d(QCircleSeekAreaFrameLayout.TAG, 1, "[disPatchEvent] checkMockLoop: true");
            }

            @Override // java.lang.Runnable
            public void run() {
                if (motionEvent != null && motionEvent2 != null) {
                    if (QCircleSeekAreaFrameLayout.this.mPreClickListener == null) {
                        e();
                    } else {
                        QCircleSeekAreaFrameLayout.this.mPreClickListener.a(motionEvent.getRawX(), motionEvent.getRawY(), new a());
                    }
                }
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mockDown(MotionEvent motionEvent) {
        float x16;
        if (motionEvent != null) {
            getGlobalRect();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (QCircleHostGlobalInfo.isNowFlatState()) {
                x16 = motionEvent.getRawX();
            } else {
                x16 = motionEvent.getX();
            }
            this.mMockDownEvent = MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 0, x16, motionEvent.getY() + this.mGlobalRect.top, 0);
            QLog.d(TAG, 1, "mockDown:" + uptimeMillis + " | x:" + motionEvent.getX() + " | rawX:" + motionEvent.getRawX() + " | y:" + motionEvent.getY() + APLogFileUtil.SEPARATOR_LOG + this.mGlobalRect.top);
            if (enableActivityDispatch() && (getContext() instanceof Activity)) {
                ((Activity) getContext()).dispatchTouchEvent(this.mMockDownEvent);
            } else {
                getRootView().dispatchTouchEvent(this.mMockDownEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mockUp(MotionEvent motionEvent) {
        float x16;
        if (motionEvent != null && this.mMockDownEvent != null) {
            getGlobalRect();
            if (QCircleHostGlobalInfo.isNowFlatState()) {
                x16 = motionEvent.getRawX();
            } else {
                x16 = motionEvent.getX();
            }
            this.mMockUpEvent = MotionEvent.obtain(this.mMockDownEvent.getDownTime(), SystemClock.uptimeMillis(), 1, x16, this.mGlobalRect.top + motionEvent.getY(), 0);
            QLog.d(TAG, 1, "mockUp: x:" + motionEvent.getX() + " | rawX:" + motionEvent.getRawX() + " | y:" + motionEvent.getY() + APLogFileUtil.SEPARATOR_LOG + this.mGlobalRect.top);
            if (enableActivityDispatch() && (getContext() instanceof Activity)) {
                ((Activity) getContext()).dispatchTouchEvent(this.mMockUpEvent);
            } else {
                getRootView().dispatchTouchEvent(this.mMockUpEvent);
            }
            if (o.Q0()) {
                this.mMockDownEvent = null;
            }
        }
    }

    private void onFocusChange(boolean z16) {
        if (o.S0() && !z16) {
            mockUp(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        }
    }

    private void updateSeekBarEvent(MotionEvent motionEvent) {
        QCircleSeekAreaEvent qCircleSeekAreaEvent = new QCircleSeekAreaEvent(motionEvent);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 1, "updateSeekBarEvent, hashcode: " + motionEvent.hashCode() + ", seekEvent hashcode: " + qCircleSeekAreaEvent.hashCode());
        }
        SimpleEventBus.getInstance().dispatchEvent(qCircleSeekAreaEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != this.mMockDownEvent && motionEvent != this.mMockUpEvent) {
            int action = motionEvent.getAction();
            char c16 = 0;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            QLog.d(TAG, 1, "dispatchTouchEvent action cancel");
                            if (o.S0()) {
                                c16 = 3;
                            }
                        }
                    } else {
                        float x16 = motionEvent.getX() - this.mSeekBarLastTouchX;
                        float y16 = motionEvent.getY() - this.mSeekBarLastTouchY;
                        if ((Math.abs(x16) > this.mTouchSlop && isXScroll(x16, y16)) || this.mLastMoveFlag) {
                            this.mLastMoveFlag = true;
                            c16 = 1;
                        }
                    }
                } else {
                    float x17 = motionEvent.getX() - this.mSeekBarLastTouchX;
                    float y17 = motionEvent.getY() - this.mSeekBarLastTouchY;
                    if (Math.abs(x17) > this.mTouchSlop && isXScroll(x17, y17)) {
                        c16 = 1;
                    } else if ((System.currentTimeMillis() - this.mLastUpEventTime >= 500 || !this.mLastMoveFlag) && Math.abs(x17) < this.mTouchSlop) {
                        this.mLastMoveFlag = false;
                        c16 = 2;
                    } else {
                        c16 = 3;
                    }
                    this.mSeekBarLastTouchX = 0.0f;
                    this.mSeekBarLastTouchY = 0.0f;
                    this.mLastUpEventTime = System.currentTimeMillis();
                }
            } else {
                this.mSeekBarLastTouchX = motionEvent.getX();
                this.mSeekBarLastTouchY = motionEvent.getY();
                this.mDownEvent = MotionEvent.obtain(motionEvent);
                this.mGlobalRect.top = 0;
            }
            if (c16 == 1) {
                updateSeekBarEvent(motionEvent);
            } else if (c16 == 2) {
                updateSeekBarEvent(MotionEvent.obtain(motionEvent.getDownTime(), SystemClock.uptimeMillis(), 3, motionEvent.getX(), motionEvent.getY(), 0));
                mockClickEvent(this.mDownEvent, MotionEvent.obtain(motionEvent));
            } else if (c16 == 3) {
                updateSeekBarEvent(MotionEvent.obtain(motionEvent.getDownTime(), SystemClock.uptimeMillis(), 3, motionEvent.getX(), motionEvent.getY(), 0));
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        QLog.d(TAG, 2, "dispatchTouchEvent not reWrite mock");
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleActivityFocusChangeEvent.class);
        return arrayList;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.d(TAG, 1, "onConfigurationChanged");
        this.mGlobalRect.top = 0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != this.mMockDownEvent && motionEvent != this.mMockUpEvent) {
            return true;
        }
        QLog.d(TAG, 2, "onInterceptTouchEvent not intercept mock");
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleActivityFocusChangeEvent) {
            onFocusChange(((QCircleActivityFocusChangeEvent) simpleBaseEvent).hasFocus());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != this.mMockDownEvent && motionEvent != this.mMockUpEvent) {
            return true;
        }
        QLog.d(TAG, 2, "onTouchEvent not intercept mock");
        return false;
    }

    public void setPreClickListener(b bVar) {
        this.mPreClickListener = bVar;
    }

    public QCircleSeekAreaFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleSeekAreaFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, 0);
        this.mSeekBarLastTouchX = 0.0f;
        this.mSeekBarLastTouchY = 0.0f;
        this.mGlobalRect = new Rect();
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
