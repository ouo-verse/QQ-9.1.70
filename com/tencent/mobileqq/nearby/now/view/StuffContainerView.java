package com.tencent.mobileqq.nearby.now.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class StuffContainerView extends RelativeLayout implements View.OnClickListener {
    public h C;
    public com.tencent.mobileqq.nearby.now.d D;
    public IStoryPlayController E;
    public QQStoryVideoPlayerErrorView F;
    public boolean G;
    private long H;
    private int I;
    public com.tencent.mobileqq.nearby.now.a J;
    private long K;
    public ImageView L;

    /* renamed from: d, reason: collision with root package name */
    public Activity f252838d;

    /* renamed from: e, reason: collision with root package name */
    public AppInterface f252839e;

    /* renamed from: f, reason: collision with root package name */
    public CustomViewPager f252840f;

    /* renamed from: h, reason: collision with root package name */
    protected SplitedProgressBar f252841h;

    /* renamed from: i, reason: collision with root package name */
    protected f f252842i;

    /* renamed from: m, reason: collision with root package name */
    protected e f252843m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f fVar = StuffContainerView.this.f252842i;
            if (fVar != null) {
                fVar.onClose(0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f fVar = StuffContainerView.this.f252842i;
            if (fVar != null) {
                fVar.onClose(0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GestureDetector f252846d;

        c(GestureDetector gestureDetector) {
            this.f252846d = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f252846d.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements View.OnLayoutChangeListener {
        d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - StuffContainerView.this.K;
            if (StuffContainerView.this.K <= 0 || j3 >= 500) {
                StuffContainerView.this.K = currentTimeMillis;
                if (QLog.isColorLevel()) {
                    QLog.d("StuffContainerView", 2, "VideoInfoListenerImpl onLayoutChange");
                }
                IStoryPlayController iStoryPlayController = StuffContainerView.this.E;
                if (iStoryPlayController != null) {
                    iStoryPlayController.handleDeviceNavChange();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface e {
        void onFlingDown();

        void onFlingLeft();

        void onFlingRight();

        void onFlingUp();

        void onSingleTap();
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface f {
        void onClose(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
        g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (StuffContainerView.this.f252843m == null) {
                return super.onFling(motionEvent, motionEvent2, f16, f17);
            }
            if (motionEvent2 != null && motionEvent != null) {
                float y16 = motionEvent2.getY() - motionEvent.getY();
                float x16 = motionEvent2.getX() - motionEvent.getX();
                if (Math.abs(y16) > Math.abs(x16)) {
                    if (Math.abs(Math.asin(Math.abs(x16) / Math.sqrt((x16 * x16) + (y16 * y16)))) < 0.5235987755982988d) {
                        if (y16 < 0.0f) {
                            StuffContainerView.this.f252843m.onFlingUp();
                        } else {
                            StuffContainerView.this.f252843m.onFlingDown();
                        }
                    }
                } else if (x16 > 0.0f) {
                    StuffContainerView.this.f252843m.onFlingRight();
                } else {
                    StuffContainerView.this.f252843m.onFlingLeft();
                }
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            e eVar = StuffContainerView.this.f252843m;
            if (eVar != null) {
                eVar.onSingleTap();
                return false;
            }
            return false;
        }

        /* synthetic */ g(StuffContainerView stuffContainerView, a aVar) {
            this();
        }
    }

    public StuffContainerView(Context context) {
        this(context, null);
    }

    public VideoData c() {
        CustomViewPager customViewPager;
        h hVar = this.C;
        if (hVar != null && (customViewPager = this.f252840f) != null) {
            return hVar.f(customViewPager.getCurrentItem());
        }
        return null;
    }

    public void d(Context context) {
        View inflate = LayoutInflater.from(context).inflate(((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyNowVideoPlayerLayout(), (ViewGroup) this, true);
        this.f252840f = (CustomViewPager) inflate.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getVideoViewPager());
        this.f252841h = (SplitedProgressBar) inflate.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getVideoSplitProgressBar());
        QQStoryVideoPlayerErrorView qQStoryVideoPlayerErrorView = (QQStoryVideoPlayerErrorView) inflate.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getOutsideErrorView());
        this.F = qQStoryVideoPlayerErrorView;
        ViewGroup.LayoutParams layoutParams = qQStoryVideoPlayerErrorView.getLayoutParams();
        layoutParams.height = ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getScreenHeight(this.F.getContext());
        layoutParams.width = ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getScreenWidth(this.F.getContext());
        this.F.setLayoutParams(layoutParams);
        this.F.requestLayout();
        this.F.setOnClickListener(new a());
        ImageView imageView = (ImageView) inflate.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getCloseIcon());
        this.L = imageView;
        imageView.setOnClickListener(new b());
        this.D = new com.tencent.mobileqq.nearby.now.d(this.f252841h);
        GestureDetector gestureDetector = new GestureDetector(context, new g(this, null));
        this.f252840f.setClickable(true);
        this.f252840f.setOnTouchListener(new c(gestureDetector));
        ((Activity) getContext()).getWindow().getDecorView().addOnLayoutChangeListener(new d());
        this.H = System.currentTimeMillis();
    }

    public void e(Bundle bundle) {
        IStoryPlayController init = ((IStoryPlayController) QRoute.api(IStoryPlayController.class)).init(getContext(), this, this.C, bundle, this.F, this.f252839e, this.J);
        this.E = init;
        this.f252840f.setOnPageChangeListener((ViewPager.OnPageChangeListener) init);
        this.C.j(this.E, bundle);
        setGestureListener((e) this.E);
    }

    public void f(boolean z16) {
        h hVar = new h(getContext(), z16);
        this.C = hVar;
        hVar.f252888m = this.f252839e;
        this.f252840f.setPageMargin(1);
        this.f252840f.setAdapter(this.C);
    }

    public void g(int i3, int i16, Intent intent) {
        this.E.doOnActivityResult(i3, i16, intent);
    }

    public void h() {
        f fVar = this.f252842i;
        if (fVar != null) {
            fVar.onClose(0);
        }
    }

    public void i() {
        String str;
        long j3;
        this.E.doOnDestroy();
        this.H = System.currentTimeMillis() - this.H;
        int i3 = 1;
        int currentItem = this.f252840f.getCurrentItem() + 1;
        if (this.f252840f.getCurrentItem() >= this.C.getF373114d() - 1) {
            i3 = 0;
        }
        VideoData f16 = this.C.f(this.f252840f.getCurrentItem());
        if (f16 != null) {
            str = f16.f252695e;
        } else {
            str = "0";
        }
        if (f16 != null) {
            j3 = f16.D;
        } else {
            j3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Native_ShortVideo_Report", 2, "player quit report module=short_video, action=view_quit, obj1=" + currentItem + ", obj3=" + i3 + ", obj4=" + this.H + ", res2=" + str + ", anchor=" + j3);
        }
    }

    public void j() {
        this.G = false;
        this.E.doOnPause();
    }

    public void k() {
        this.G = true;
        this.E.doOnResume();
    }

    public void m(boolean z16) {
        int i3;
        SplitedProgressBar splitedProgressBar = this.f252841h;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        splitedProgressBar.setVisibility(i3);
    }

    public void n(Bundle bundle) {
        this.E.initialize(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f fVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == ((IResourceUtil) QRoute.api(IResourceUtil.class)).getCloseIcon() && (fVar = this.f252842i) != null) {
            fVar.onClose(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        return this.E.onKeyDown(i3, keyEvent);
    }

    public void setApp(AppInterface appInterface) {
        this.f252839e = appInterface;
    }

    public void setCallBack(com.tencent.mobileqq.nearby.now.a aVar) {
        this.J = aVar;
    }

    public void setCurrentItem(int i3, boolean z16) {
        this.f252840f.setCurrentItem(i3, z16);
    }

    public void setGestureListener(e eVar) {
        this.f252843m = eVar;
    }

    public void setOnCloseListener(f fVar) {
        this.f252842i = fVar;
        h hVar = this.C;
        if (hVar != null) {
            hVar.i(fVar);
        }
    }

    public void setStatusBarHeight(int i3) {
        this.I = i3;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f252841h.getLayoutParams();
        layoutParams.topMargin += i3;
        this.f252841h.setLayoutParams(layoutParams);
    }

    public StuffContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StuffContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = false;
        this.H = 0L;
        this.K = 0L;
        this.f252838d = (Activity) context;
        d(context);
    }

    public void l() {
    }
}
