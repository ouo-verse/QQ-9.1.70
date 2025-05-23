package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.widget.internal.LoadingLayout;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.widget.AdapterView;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.util.QZLog;
import d5.ae;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes37.dex */
public class QZonePullToRefreshListView extends FeedListView implements OverScrollViewListener, d5.m<BusinessFeedData> {
    private static boolean T = true;
    private int C;
    private e D;
    private c E;
    private ep.a F;
    private ArrayList<a> G;
    private SmoothScrollRunnable H;
    private d5.e I;
    private ae J;
    private float K;
    private float L;
    private float M;
    private float N;
    private b P;
    private boolean Q;
    private FrameLayout R;
    private boolean S;

    /* renamed from: d, reason: collision with root package name */
    private boolean f60474d;

    /* renamed from: e, reason: collision with root package name */
    private int f60475e;

    /* renamed from: f, reason: collision with root package name */
    private int f60476f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f60477h;

    /* renamed from: i, reason: collision with root package name */
    private long f60478i;

    /* renamed from: m, reason: collision with root package name */
    private final int f60479m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public final class SmoothScrollRunnable implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final int f60481e;

        /* renamed from: f, reason: collision with root package name */
        private final int f60482f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f60483h = true;

        /* renamed from: i, reason: collision with root package name */
        private long f60484i = -1;

        /* renamed from: m, reason: collision with root package name */
        private int f60485m = -1;

        /* renamed from: d, reason: collision with root package name */
        private final Interpolator f60480d = new OvershootInterpolator(0.0f);

        public SmoothScrollRunnable(int i3, int i16) {
            this.f60482f = i3;
            this.f60481e = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f60484i == -1) {
                this.f60484i = System.currentTimeMillis();
            } else {
                int round = this.f60482f - Math.round((this.f60482f - this.f60481e) * this.f60480d.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f60484i) * 1000) / 300, 1000L), 0L)) / 1000.0f));
                this.f60485m = round;
                QZonePullToRefreshListView.this.scrollTo(0, round);
            }
            if (!this.f60483h || this.f60481e == this.f60485m) {
                return;
            }
            QZonePullToRefreshListView.this.postDelayed(this, 10L);
        }

        public void stop() {
            this.f60483h = false;
            QZonePullToRefreshListView.this.removeCallbacks(this);
        }
    }

    /* loaded from: classes37.dex */
    public interface a {
        boolean dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes37.dex */
    public interface b {
        void V9();
    }

    /* loaded from: classes37.dex */
    public interface c {
        void Y();

        void onPullEnd();

        void onPullStart();

        void onRefresh();
    }

    /* loaded from: classes37.dex */
    public interface d {
    }

    /* loaded from: classes37.dex */
    public interface e {
        void onScrollChanged(int i3, int i16, int i17, int i18);
    }

    public QZonePullToRefreshListView(Context context) {
        this(context, null);
    }

    private boolean b0(int i3) {
        if (getFirstVisiblePosition() == 0 && getChildCount() > 0 && getChildAt(0) != null) {
            if ((k0() ? f0() : 0) - getTop() < i3) {
                return false;
            }
        }
        return true;
    }

    private FrameLayout d0() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        if (layoutParams == null) {
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.aug)));
        } else {
            layoutParams.width = -1;
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.aug);
        }
        frameLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.common_list_overscoll_top_bg));
        return frameLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p0() {
        float scrollFriction;
        float config;
        float scrollFriction2 = ViewConfiguration.getScrollFriction();
        if (QZoneHelper.getDevicePerformanceLevelInfo() == 1) {
            scrollFriction = ViewConfiguration.getScrollFriction();
            config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SUPER_HIGH_PHONE_FRICITION, 3.0f);
        } else if (QZoneHelper.getDevicePerformanceLevelInfo() == 2) {
            scrollFriction = ViewConfiguration.getScrollFriction();
            config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_HIGH_PHONE_FRICITION, 2.0f);
        } else if (QZoneHelper.getDevicePerformanceLevelInfo() == 3) {
            scrollFriction = ViewConfiguration.getScrollFriction();
            config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MIDDLE_PHONE_FRICITION, 1.0f);
        } else {
            if (QZoneHelper.getDevicePerformanceLevelInfo() == 4) {
                scrollFriction = ViewConfiguration.getScrollFriction();
                config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MIDDLE_PHONE_FRICITION, 0.75f);
            }
            if (scrollFriction2 <= 0.0f) {
                j0().setFriction(scrollFriction2);
                return;
            }
            return;
        }
        scrollFriction2 = scrollFriction * config;
        if (scrollFriction2 <= 0.0f) {
        }
    }

    public static void setGlobalGestureEnable(boolean z16) {
        T = z16;
    }

    @Override // d5.m
    public void a(View view) {
        j0().removeFooterView(view);
    }

    @Override // d5.m
    public View b(int i3) {
        ListView j06 = j0();
        if (j06 == null) {
            return null;
        }
        return j06.getChildAt(i3);
    }

    public boolean c0() {
        ListAdapter wrappedAdapter;
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof BaseAdapter)) {
            return adapter.isEmpty();
        }
        if (adapter == null || !(adapter instanceof HeaderViewListAdapter) || (wrappedAdapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter()) == null) {
            return true;
        }
        return wrappedAdapter.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Q || this.P == null || getAdapter() == null || getAdapter().getCount() <= getFooterViewsCount() + getHeaderViewsCount()) {
            return;
        }
        this.Q = true;
        this.P.V9();
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ArrayList<a> arrayList = this.G;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.dispatchTouchEvent(motionEvent);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    protected int f0() {
        d5.e eVar = this.I;
        if (eVar == null) {
            return 0;
        }
        return eVar.a();
    }

    public ep.a g0() {
        return this.F;
    }

    public int h0() {
        return getPaddingTop();
    }

    @Override // d5.m
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public BusinessFeedData t(int i3) {
        ListView j06 = j0();
        if (j06 == null) {
            return null;
        }
        return (BusinessFeedData) j06.getItemAtPosition(i3);
    }

    public boolean k0() {
        return this.f60474d;
    }

    public void l0() {
        c cVar = this.E;
        if (cVar != null) {
            cVar.Y();
        }
    }

    public void m0() {
        if (QZLog.isColorLevel()) {
            QZLog.d(AdapterView.TAG, 2, "pullToRefresh");
        }
        ep.a aVar = this.F;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void n0() {
        ArrayList<a> arrayList = this.G;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // d5.m
    public int o() {
        return getBottom();
    }

    public void o0() {
        if (QZLog.isColorLevel()) {
            QZLog.d(AdapterView.TAG, 2, "releaseToRefresh");
        }
        ep.a aVar = this.F;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f60477h) {
            this.f60477h = false;
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!T) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.L = 0.0f;
            this.K = 0.0f;
            this.M = motionEvent.getX();
            this.N = motionEvent.getY();
        } else if (action == 2) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            this.K += Math.abs(x16 - this.M);
            float abs = this.L + Math.abs(y16 - this.N);
            this.L = abs;
            this.M = x16;
            this.N = y16;
            if (this.K > abs) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onNotCompleteVisable(int i3, View view, ListView listView) {
        if (QZLog.isColorLevel()) {
            QZLog.d(AdapterView.TAG, 2, "onNotCompleteVisable");
        }
        m0();
        c cVar = this.E;
        if (cVar != null) {
            cVar.onPullStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        if (!this.f60474d || this.D == null) {
            return;
        }
        if (Math.abs(i16) > Math.abs(this.f60475e)) {
            i16 = this.f60475e;
        }
        this.D.onScrollChanged(i3, i16, i17, i18);
    }

    @Override // com.tencent.widget.ListView, com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        super.onThemeChanged();
        j0().setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_page_background_color));
    }

    @Override // cooperation.qzone.api.FeedListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return T && super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewCompleteVisable(int i3, View view, ListView listView) {
        o0();
        if (QZLog.isColorLevel()) {
            QZLog.d(AdapterView.TAG, 2, "onViewCompleteVisable");
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
        if (QZLog.isColorLevel()) {
            QZLog.d(AdapterView.TAG, 2, "onViewCompleteVisableAndReleased");
        }
        c cVar = this.E;
        if (cVar != null) {
            cVar.onRefresh();
            this.E.onPullEnd();
            ep.a aVar = this.F;
            if (aVar != null) {
                aVar.b();
            }
        }
        return this.S;
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        if (QZLog.isColorLevel()) {
            QZLog.d(AdapterView.TAG, 2, "onViewNotCompleteVisableAndReleased");
        }
    }

    @Override // d5.m
    public void q(View view) {
        j0().addFooterView(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q0(Context context, TypedArray typedArray) {
        ep.a e06 = e0(context, typedArray);
        this.F = e06;
        setOverScrollHeader(e06.getView());
        this.f60475e = 0;
        int i3 = this.f60479m;
        this.f60476f = i3;
        setOverScrollHeight(i3);
        setPadding(0, this.f60475e, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView
    public void reportScrollStateChange(int i3) {
        super.reportScrollStateChange(i3);
    }

    public void s0(String str) {
        c cVar = this.E;
        if (cVar != null) {
            cVar.Y();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        super.scrollBy(i3, i16);
    }

    @Override // cooperation.qzone.api.FeedListView
    public void scrollToTop() {
        abordFling();
        setSelection(0);
        if (this.S) {
            t0(-getOverScrollHeight());
            return;
        }
        int scrollY = getScrollY() + getOverScrollHeight();
        if (b0(scrollY)) {
            scrollTo(0, scrollY);
        }
        t0(0);
    }

    @Inject
    @Named("PullToRefreshListViewCoverImp")
    public void setCoverInf(d5.e eVar) {
        this.I = eVar;
    }

    public void setCoverMode(boolean z16) {
        this.f60474d = z16;
        if (z16) {
            int f06 = f0();
            this.f60475e = f06;
            this.f60476f = Math.abs(f06);
            this.R = d0();
            LayoutInflater.from(getContext()).inflate(R.layout.bqf, this.R);
            setOverScrollHeader(this.R);
            setOverScrollHeight(this.f60479m);
            setPadding(0, this.f60475e, 0, 0);
            return;
        }
        q0(getContext(), null);
    }

    public void setDispatchTouchEventListener(a aVar) {
        ArrayList<a> arrayList = this.G;
        if (arrayList != null) {
            arrayList.add(aVar);
        }
    }

    public void setLastUpdateTimeStamp(String str) {
        if (QZLog.isColorLevel()) {
            QZLog.d(AdapterView.TAG, 2, "setLastUpdateTimeStamp");
        }
        ep.a aVar = this.F;
        if (aVar != null) {
            aVar.setSubHeaderText(str);
        }
    }

    public void setListViewBGFeedNormal() {
        if (c0()) {
            j0().setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_page_background_color));
        }
    }

    public void setOnFirstDrawListner(b bVar) {
        this.P = bVar;
    }

    public final void setOnRefreshListener(c cVar) {
        this.E = cVar;
    }

    public final void setOnScrollChangedListener(d dVar) {
    }

    public void setRefreshing(boolean z16) {
        if (!this.S) {
            c cVar = this.E;
            if (cVar != null) {
                cVar.onRefresh();
                return;
            }
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(AdapterView.TAG, 2, "setRefreshing");
        }
        c cVar2 = this.E;
        if (cVar2 != null) {
            cVar2.onPullStart();
            this.E.onRefresh();
            ep.a aVar = this.F;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void setReleaseHold(boolean z16) {
        this.S = z16;
    }

    public void setScrollHeaderTransparent() {
        FrameLayout frameLayout = this.R;
        if (frameLayout != null) {
            frameLayout.setBackgroundDrawable(null);
            ImageView imageView = (ImageView) this.R.findViewById(R.id.g5u);
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
        }
    }

    @Inject
    @Named("BaseFragmentToastImp")
    public void setToastInf(ae aeVar) {
        this.J = aeVar;
    }

    public void t0(int i3) {
        SmoothScrollRunnable smoothScrollRunnable = this.H;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i3) {
            SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(getScrollY(), i3);
            this.H = smoothScrollRunnable2;
            post(smoothScrollRunnable2);
        }
    }

    @Override // d5.m
    public boolean u() {
        return j0() != null;
    }

    public QZonePullToRefreshListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.listViewStyle);
    }

    @Override // d5.m
    public void s(d5.d<View> dVar) {
        for (int i3 = 0; i3 < getCount() && !dVar.accept(getChildAt(i3)); i3++) {
        }
    }

    public final void setOnScrollChangedListener(e eVar) {
        this.D = eVar;
    }

    public void setStartTime(long j3) {
        this.f60477h = true;
        this.f60478i = j3;
    }

    public QZonePullToRefreshListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60477h = false;
        this.f60478i = 0L;
        this.f60479m = (int) getResources().getDimension(R.dimen.auf);
        this.C = 1;
        this.G = new ArrayList<>();
        this.Q = false;
        this.S = false;
        com.qzone.app.f.b(this);
        setNeedCheckSpringback(true);
        setOverScrollListener(this);
        p0();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullToRefresh);
        setCoverMode(obtainStyledAttributes.getBoolean(5, false));
        obtainStyledAttributes.recycle();
    }

    protected ep.a e0(Context context, TypedArray typedArray) {
        if (typedArray == null) {
            return new LoadingLayout(context);
        }
        return new LoadingLayout(context, typedArray);
    }

    public void r0(String str, String str2) {
        ae aeVar;
        if (str2 != null && !TextUtils.isEmpty(str2) && (aeVar = this.J) != null) {
            aeVar.c(str2, 1);
        }
        c cVar = this.E;
        if (cVar != null) {
            cVar.Y();
        }
    }

    public void setSupportPullDown(boolean z16) {
        if (!z16) {
            setOverScrollHeader(null);
            setOverScrollMode(2);
        } else if (getOverScrollHeaderView() == null) {
            setOverScrollMode(0);
            setCoverMode(false);
        }
    }

    public void setCoverMode(boolean z16, int i3) {
        this.f60474d = z16;
        if (z16) {
            this.f60475e = i3;
            this.f60476f = Math.abs(i3);
            LoadingLayout loadingLayout = new LoadingLayout(getContext());
            loadingLayout.g();
            setOverScrollHeader(loadingLayout);
            setOverScrollHeight(this.f60479m);
            setPadding(0, this.f60475e, 0, 0);
            return;
        }
        q0(getContext(), null);
    }

    public ListView j0() {
        return this;
    }

    public void setEmptyEnabled(boolean z16) {
    }

    public void setListViewBG() {
    }

    public void setOnDownListener() {
    }

    public void setSupportPullUp(boolean z16) {
    }
}
