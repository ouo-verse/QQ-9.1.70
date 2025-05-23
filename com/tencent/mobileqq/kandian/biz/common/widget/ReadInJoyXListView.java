package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.kandian.base.utils.e;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.ReadInJoyOverScrollViewListener;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ReadInJoyXListView extends ReadInJoyBaseListView implements ReadInJoyOverScrollViewListener {
    private Handler I;
    private boolean J;
    protected boolean K;
    private boolean L;
    protected int M;
    protected int N;
    public int P;
    public int Q;
    public float[] R;
    public float[] S;
    public long T;
    public long U;
    protected boolean V;
    private IAnimManager W;

    /* renamed from: a0, reason: collision with root package name */
    private View f239317a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f239318b0;

    /* renamed from: c0, reason: collision with root package name */
    private IAnimManager.OnRefreshPullDistanceListener f239319c0;

    /* renamed from: d0, reason: collision with root package name */
    private ThreadLocal<Integer> f239320d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f239321e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f239322f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f239323g0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView$2, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f239324d;
        final /* synthetic */ ReadInJoyXListView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.n0(this.f239324d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends ThreadLocal<Integer> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer initialValue() {
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ReadInJoyXListView> f239327d;

        public b(ReadInJoyXListView readInJoyXListView) {
            this.f239327d = new WeakReference<>(readInJoyXListView);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            WeakReference<ReadInJoyXListView> weakReference = this.f239327d;
            if (weakReference == null || weakReference.get() == null) {
                return true;
            }
            this.f239327d.get().i0();
            return true;
        }
    }

    public ReadInJoyXListView(Context context) {
        this(context, null);
    }

    private void h0(int i3) {
        if (this.L) {
            if (this.mFirstPosition == 0) {
                QLog.d("ReadInJoyXListView", 2, "scroll2Top : stop on top,refresh ! from : " + i3);
                n0(1);
                this.L = false;
                return;
            }
            QLog.d("ReadInJoyXListView", 2, "scroll2Top : not on top, jump to top and refresh. from : " + i3);
            if (i3 != 3) {
                this.L = false;
                if (getAdapter() instanceof HeaderViewListAdapter) {
                    setAdapter(((HeaderViewListAdapter) getAdapter()).getWrappedAdapter());
                } else {
                    setAdapter(getAdapter());
                }
                n0(1);
                return;
            }
            k0();
        }
    }

    private void j0() {
        IAnimManager iAnimManager = this.W;
        if (iAnimManager != null && !this.f239318b0) {
            this.f239317a0 = iAnimManager.getRefreshView(this);
            setOverScrollHeader(this.W.getRefreshView(this));
            setOverScrollListener(this);
            setOverScrollHeight(this.W.getPullRefreshAreaHeight());
        }
    }

    private void m0(final boolean z16) {
        this.J = z16;
        e.a().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("ReadInJoyXListView", 1, "[setIsTopRefreshIng], isTopRefreshIng = " + z16);
                if (z16) {
                    ReadInJoyXListView.this.setLayerType(1, null);
                } else {
                    ReadInJoyXListView readInJoyXListView = ReadInJoyXListView.this;
                    readInJoyXListView.setLayerType(readInJoyXListView.f239321e0, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(int i3) {
        if (!this.J && !this.f239318b0) {
            this.f239320d0.set(Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView
    public void d0(Context context, AttributeSet attributeSet) {
        super.d0(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j52.a.f409456u4);
        this.K = obtainStyledAttributes.getBoolean(j52.a.f409472w4, false);
        obtainStyledAttributes.recycle();
        this.N = (int) ah.L();
        this.f239321e0 = getLayerType();
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.Q = pointToPosition((int) motionEvent.getX(), ((int) motionEvent.getY()) + getScrollY());
                this.S[0] = motionEvent.getX();
                this.S[1] = motionEvent.getY();
                this.U = System.currentTimeMillis();
            }
        } else {
            this.P = pointToPosition((int) motionEvent.getX(), ((int) motionEvent.getY()) + getScrollY());
            this.R[0] = motionEvent.getX();
            this.R[1] = motionEvent.getY();
            this.T = System.currentTimeMillis();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void i0() {
        IAnimManager iAnimManager;
        m0(false);
        springBackOverScrollHeaderView();
        if (!this.J && (iAnimManager = this.W) != null && !this.V) {
            iAnimManager.endOfRefresh();
        }
    }

    @Override // com.tencent.widget.ListView
    public void initPaddingManual() {
        super.initPaddingManual();
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyXListView", 2, "initPaddingManual  mPaddingTop=" + getPaddingTop() + ",mListPadding.top=" + this.mListPadding.top);
        }
        if (this.mListPadding.top == 0 && getPaddingTop() > 0) {
            this.mListPadding.top = getPaddingTop();
        }
        if (this.mListPadding.bottom == 0 && getPaddingBottom() > 0) {
            this.mListPadding.bottom = getPaddingBottom();
        }
        if (this.mListPadding.left == 0 && getPaddingLeft() > 0) {
            this.mListPadding.left = getPaddingLeft();
        }
        if (this.mListPadding.right == 0 && getPaddingRight() > 0) {
            this.mListPadding.right = getPaddingRight();
        }
    }

    public void k0() {
        l0(1);
    }

    public void l0(int i3) {
        if (this.J) {
            return;
        }
        smoothScrollBy(0, 0);
        setSelection(0);
        n0(i3);
        QLog.d("ReadInJoyXListView", 2, "scroll2TopAndRefresh needScroll : true");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.widget.AbsListView
    protected void onAttachChildView(View view) {
        if (view instanceof w52.a) {
            w52.a aVar = (w52.a) view;
            if (!aVar.isResumed()) {
                aVar.a(true);
                aVar.onViewResume();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.widget.AbsListView
    protected void onDetachChildView(View view) {
        if (view instanceof w52.a) {
            w52.a aVar = (w52.a) view;
            if (aVar.isResumed()) {
                aVar.a(false);
                aVar.onViewPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.I = new Handler(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.f239323g0) {
            this.f239323g0 = false;
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onNotCompleteVisable(int i3, View view, ListView listView) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        super.onScroll(absListView, i3, i16, i17);
        if (i3 == 0) {
            getChildAt(0);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        super.onScrollStateChanged(absListView, i3);
        if (i3 == 0) {
            h0(3);
        }
    }

    @Override // com.tencent.widget.ReadInJoyOverScrollViewListener
    public void onScrollView(View view, ListView listView, int i3) {
        IAnimManager iAnimManager;
        if (listView == this && (iAnimManager = this.W) != null && view == iAnimManager.getRefreshView(this) && !this.V) {
            this.W.onTouchPullDistance(i3, this.mTouchMode);
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.L) {
            QLog.d("ReadInJoyXListView", 2, "scroll2Top catch user touch event!");
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                this.f239314i = ((int) motionEvent.getRawY()) - this.M;
            }
        } else {
            this.M = (int) motionEvent.getRawY();
        }
        IAnimManager iAnimManager = this.W;
        if (iAnimManager != null && iAnimManager.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewCompleteVisable(int i3, View view, ListView listView) {
        IAnimManager iAnimManager;
        if (listView == this && (iAnimManager = this.W) != null && view == iAnimManager.getRefreshView(this) && !this.J && !this.V) {
            this.W.onPullRefreshing(100, false);
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
        IAnimManager iAnimManager;
        if (listView != this) {
            return true;
        }
        int intValue = this.f239320d0.get().intValue();
        boolean z16 = false;
        this.f239320d0.set(0);
        if (!this.J && (iAnimManager = this.W) != null && view == iAnimManager.getRefreshView(this) && !this.V) {
            IAnimManager iAnimManager2 = this.W;
            if (intValue != 0) {
                z16 = true;
            }
            iAnimManager2.onPullRefreshComplete(z16);
        }
        return true;
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        IAnimManager iAnimManager;
        if (!this.J && (iAnimManager = this.W) != null && view == iAnimManager.getRefreshView(this) && !this.V) {
            this.W.onPullRefreshCancel();
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.View
    public void onWindowFocusChanged(boolean z16) {
        if (!z16) {
            h0(1);
        }
    }

    public void setNeedShowHeaderView(boolean z16) {
        this.K = z16;
        j0();
    }

    public void setRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener onRefreshPullDistanceListener) {
        this.f239319c0 = onRefreshPullDistanceListener;
        IAnimManager iAnimManager = this.W;
        if (iAnimManager != null) {
            iAnimManager.setRefreshPullDistanceListener(onRefreshPullDistanceListener);
        }
    }

    public ReadInJoyXListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = 0;
        this.N = 0;
        this.P = -1;
        this.Q = -1;
        this.R = new float[2];
        this.S = new float[2];
        this.T = 0L;
        this.U = 0L;
        this.V = false;
        this.f239318b0 = false;
        this.f239320d0 = new a();
        this.f239321e0 = 0;
        this.f239322f0 = -1;
        this.f239323g0 = true;
    }

    @Override // com.tencent.widget.ReadInJoyOverScrollViewListener
    public void onNotCompleteVisable(int i3, View view, ListView listView, int i16) {
        IAnimManager iAnimManager;
        if (listView == this && (iAnimManager = this.W) != null && view == iAnimManager.getRefreshView(this) && !this.V) {
            this.W.onPullRefreshing(i16, this.J);
        }
    }

    public ReadInJoyXListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = 0;
        this.N = 0;
        this.P = -1;
        this.Q = -1;
        this.R = new float[2];
        this.S = new float[2];
        this.T = 0L;
        this.U = 0L;
        this.V = false;
        this.f239318b0 = false;
        this.f239320d0 = new a();
        this.f239321e0 = 0;
        this.f239322f0 = -1;
        this.f239323g0 = true;
    }
}
