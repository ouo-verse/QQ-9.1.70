package com.tencent.mobileqq.kandian.biz.video.playfeeds.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.biz.video.OrientationDetector;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class VideoFeedsRecyclerView extends RecyclerViewWithHeaderFooter implements a.e, OrientationDetector.b {
    private static int V;
    private static int W;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private int J;
    private float K;
    private boolean L;
    private int M;
    private View N;
    private View P;
    private RecyclerView.ViewHolder Q;
    private com.tencent.widget.pull2refresh.a R;
    private OrientationDetector S;
    private List<com.tencent.mobileqq.kandian.base.view.widget.a> T;
    private RecyclerView.OnScrollListener U;

    /* renamed from: d, reason: collision with root package name */
    private long f239748d;

    /* renamed from: e, reason: collision with root package name */
    private float f239749e;

    /* renamed from: f, reason: collision with root package name */
    private int f239750f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f239751h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f239752i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f239753m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            int i29;
            VideoFeedsRecyclerView.this.removeOnLayoutChangeListener(this);
            boolean z16 = false;
            if (VideoFeedsRecyclerView.this.P != null && VideoFeedsRecyclerView.this.H) {
                if (VideoFeedsRecyclerView.this.I != 0) {
                    int unused = VideoFeedsRecyclerView.this.I;
                    i29 = 0;
                } else {
                    i29 = (int) (VideoFeedsRecyclerView.this.getHeight() * 0.3d);
                }
                ViewGroup.LayoutParams layoutParams = VideoFeedsRecyclerView.this.P.getLayoutParams();
                layoutParams.height = i29;
                VideoFeedsRecyclerView.this.P.setLayoutParams(layoutParams);
            }
            if (VideoFeedsRecyclerView.this.I == 0) {
                View findViewByPosition = VideoFeedsRecyclerView.this.getLayoutManager().findViewByPosition(1);
                if (findViewByPosition != null && findViewByPosition.getHeight() > 0 && VideoFeedsRecyclerView.this.G) {
                    VideoFeedsRecyclerView.this.o((int) ((VideoFeedsRecyclerView.this.getHeight() / 2.0f) - (findViewByPosition.getHeight() / 2.0f)));
                    if (VideoFeedsRecyclerView.this.R.l0(1) && VideoFeedsRecyclerView.this.R.Q() != 1) {
                        z16 = true;
                    }
                    if (!z16 && VideoFeedsRecyclerView.this.T != null && VideoFeedsRecyclerView.this.R.Q() != 1) {
                        VideoFeedsRecyclerView videoFeedsRecyclerView = VideoFeedsRecyclerView.this;
                        videoFeedsRecyclerView.onPagerChanged(videoFeedsRecyclerView.getChildViewHolder(findViewByPosition));
                        return;
                    }
                    return;
                }
                return;
            }
            if (VideoFeedsRecyclerView.this.I == 1) {
                VideoFeedsRecyclerView videoFeedsRecyclerView2 = VideoFeedsRecyclerView.this;
                videoFeedsRecyclerView2.o(videoFeedsRecyclerView2.M);
            }
        }
    }

    public VideoFeedsRecyclerView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i3) {
        View view = this.N;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i3;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    private void t() {
        addOnScrollListener(this.U);
        u();
        setOverScrollMode(2);
        setItemAnimator(null);
        setHasFixedSize(true);
        setItemViewCacheSize(0);
        setClipChildren(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        V = super.getMinFlingVelocity() * 3;
        W = super.getMinFlingVelocity() * 3;
    }

    private void u() {
        View view = new View(getContext());
        view.setId(R.id.hyg);
        view.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
        this.N = view;
        addHeaderView(view);
        View view2 = new View(getContext());
        view2.setId(R.id.hyf);
        view2.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
        this.P = view2;
        addFooterView(view2);
    }

    private void v(int i3, boolean z16) {
        if (!this.f239753m && !this.f239751h && this.Q != null) {
            this.f239753m = true;
            OrientationDetector orientationDetector = this.S;
            if (orientationDetector != null && this.E) {
                if (i3 == 0) {
                    Context l3 = orientationDetector.l();
                    if (l3 instanceof Activity) {
                        ((Activity) l3).setRequestedOrientation(0);
                    }
                } else {
                    Context l16 = orientationDetector.l();
                    if (l16 instanceof Activity) {
                        ((Activity) l16).setRequestedOrientation(8);
                    }
                }
            }
            List<com.tencent.mobileqq.kandian.base.view.widget.a> list = this.T;
            if (list != null) {
                Iterator<com.tencent.mobileqq.kandian.base.view.widget.a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().L2(this.Q, true);
                }
            }
            if (z16) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setFillAfter(true);
                startAnimation(alphaAnimation);
            }
        }
    }

    private void w(int i3, boolean z16) {
        if (this.f239753m && !this.f239751h && this.Q != null) {
            this.f239753m = false;
            OrientationDetector orientationDetector = this.S;
            if (orientationDetector != null && this.E) {
                Context l3 = orientationDetector.l();
                if (l3 instanceof Activity) {
                    ((Activity) l3).setRequestedOrientation(1);
                }
            }
            List<com.tencent.mobileqq.kandian.base.view.widget.a> list = this.T;
            if (list != null) {
                Iterator<com.tencent.mobileqq.kandian.base.view.widget.a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().L2(this.Q, false);
                }
            }
            if (z16) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setFillAfter(true);
                startAnimation(alphaAnimation);
            }
        }
    }

    private void x() {
        com.tencent.widget.pull2refresh.a aVar = new com.tencent.widget.pull2refresh.a(this.I, this.K);
        this.R = aVar;
        aVar.e0(this.J);
        this.R.d0(this.f239750f + 1);
        this.R.b0(1);
        this.R.a0(this);
        this.R.B(this);
        this.R.c0(true);
        addOnLayoutChangeListener(new b());
    }

    @Override // com.tencent.widget.pull2refresh.a.e
    public void b(RecyclerView.ViewHolder viewHolder) {
        if (this.T != null) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoFeedsRecyclerView", 2, "onPagerIdle: pagerSnapOnCenterViewChanged position=" + viewHolder.getLayoutPosition() + ", this=" + this);
            }
            Iterator<com.tencent.mobileqq.kandian.base.view.widget.a> it = this.T.iterator();
            while (it.hasNext()) {
                it.next().Lg(viewHolder);
            }
        }
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter
    public int getFooterViewsCount() {
        return super.getFooterViewsCount() + this.f239750f;
    }

    @Override // android.support.v7.widget.RecyclerView
    public int getMinFlingVelocity() {
        if (getLayoutManager().canScrollVertically()) {
            return V;
        }
        return W;
    }

    public void n(com.tencent.mobileqq.kandian.base.view.widget.a aVar) {
        if (this.T == null) {
            this.T = new ArrayList();
        }
        this.T.add(aVar);
    }

    @Override // com.tencent.widget.pull2refresh.a.e
    public void onFooterRebound() {
        List<com.tencent.mobileqq.kandian.base.view.widget.a> list = this.T;
        if (list != null) {
            Iterator<com.tencent.mobileqq.kandian.base.view.widget.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().s();
            }
        }
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter, android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f239748d = System.currentTimeMillis();
        if (this.R.W() || this.f239753m) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f239749e = motionEvent.getY();
            this.F = false;
        }
        if (motionEvent.getAction() == 2 && !this.F && this.Q != null) {
            int c16 = x.c(getContext(), 25.0f);
            if (Math.abs(this.f239749e - motionEvent.getY()) > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                float f16 = c16;
                if (this.f239749e < f16 || Math.abs(getHeight() - this.f239749e) < f16) {
                    this.F = true;
                    return false;
                }
            }
        }
        if (!this.f239752i) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.OrientationDetector.b
    public void onOrientationChanged(int i3) {
        if (!this.f239751h && this.D && this.Q != null) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoFeedsRecyclerView", 2, "onOrientationChanged: requestOrientation=" + i3 + ", userOrientation=" + this.C);
            }
            int i16 = this.C;
            if (i16 != -1 && i16 != i3) {
                return;
            }
            this.C = -1;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 8) {
                        if (i3 == 9) {
                            w(i3, true);
                            return;
                        }
                        return;
                    }
                    v(i3, true);
                    return;
                }
                w(i3, true);
                return;
            }
            v(i3, true);
        }
    }

    @Override // com.tencent.widget.pull2refresh.a.e
    public void onPagerChanged(RecyclerView.ViewHolder viewHolder) {
        this.Q = viewHolder;
        if (this.T != null) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoFeedsRecyclerView", 2, "onPagerChanged: pagerSnapOnCenterViewChanged position=" + viewHolder.getLayoutPosition() + ", this=" + this);
            }
            Iterator<com.tencent.mobileqq.kandian.base.view.widget.a> it = this.T.iterator();
            while (it.hasNext()) {
                it.next().Y9(viewHolder);
            }
        }
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter, android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.R.W()) {
            return true;
        }
        if (this.f239753m || this.F) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        List<com.tencent.mobileqq.kandian.base.view.widget.a> list = this.T;
        if (list != null) {
            list.clear();
            this.T = null;
        }
        OrientationDetector orientationDetector = this.S;
        if (orientationDetector != null) {
            orientationDetector.j();
        }
    }

    public View q() {
        if (getLayoutManager() instanceof LinearLayoutManager) {
            return this.R.O((LinearLayoutManager) getLayoutManager());
        }
        return null;
    }

    public RecyclerView.ViewHolder r() {
        return this.Q;
    }

    public int s() {
        return this.R.Q();
    }

    @Override // android.support.v7.widget.RecyclerView
    public void scrollToPosition(int i3) {
        super.scrollToPosition(getHeaderViewsCount() + i3);
        this.R.Z();
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter, com.tencent.widget.pull2refresh.RecyclerViewCompat, android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        super.setAdapter(adapter);
        if (adapter2 != getAdapter() && getAdapter() != null && getLayoutManager() != null) {
            x();
        }
    }

    public void setEnableFooterView(boolean z16) {
        this.H = z16;
    }

    public void setEnableHeaderView(boolean z16) {
        this.G = z16;
    }

    public void setExtraFooterCount(int i3) {
        this.f239750f = i3;
    }

    public void setHeaderHeight(int i3) {
        this.M = i3;
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter, android.support.v7.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
        super.setLayoutManager(layoutManager);
        if (layoutManager2 != getLayoutManager() && getLayoutManager() != null && getAdapter() != null) {
            x();
        }
    }

    public void setNeedDetectOrientation(Activity activity, boolean z16) {
        this.D = z16;
        if (z16 && this.S == null) {
            this.S = new OrientationDetector(activity, this);
        }
    }

    public void setScrollable(boolean z16) {
        this.f239752i = z16;
    }

    public void setSnapOffset(int i3) {
        this.J = i3;
        com.tencent.widget.pull2refresh.a aVar = this.R;
        if (aVar != null) {
            aVar.e0(i3);
        }
    }

    public void setSnapOnFling(boolean z16) {
        this.L = z16;
        this.R.f0(z16);
    }

    public void setSnapOnIdle(boolean z16) {
        this.R.g0(z16);
    }

    public boolean y() {
        return this.R.k0();
    }

    public VideoFeedsRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoFeedsRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f239751h = false;
        this.f239752i = true;
        this.f239753m = false;
        this.C = -1;
        this.D = false;
        this.E = true;
        this.G = true;
        this.H = true;
        this.L = true;
        this.M = 0;
        this.U = new a();
        t();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j52.a.M6, i3, 0);
        this.I = obtainStyledAttributes.getInt(j52.a.N6, 0);
        this.J = obtainStyledAttributes.getDimensionPixelSize(j52.a.O6, 0);
        this.K = obtainStyledAttributes.getFloat(j52.a.P6, 25.0f);
        obtainStyledAttributes.recycle();
    }

    public void setNeedDetectOrientation(Activity activity, boolean z16, boolean z17) {
        this.E = z17;
        setNeedDetectOrientation(activity, z16);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            boolean z16;
            VideoFeedsRecyclerView videoFeedsRecyclerView = VideoFeedsRecyclerView.this;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            videoFeedsRecyclerView.f239751h = z16;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        }
    }
}
