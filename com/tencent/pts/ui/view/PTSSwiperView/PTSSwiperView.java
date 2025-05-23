package com.tencent.pts.ui.view.PTSSwiperView;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.support.PagerSnapHelper;
import com.tencent.pts.support.RecyclerViewCompat;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSRecyclerViewAdapter;
import com.tencent.pts.ui.view.IView;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSSwiperView extends RelativeLayout implements IView {
    static IPatchRedirector $redirector_;
    private static final int K;
    private PTSNodeInfo C;
    private Rect D;
    private Context E;
    private boolean F;
    private int G;
    private int H;
    private boolean I;
    private Runnable J;

    /* renamed from: d, reason: collision with root package name */
    private c f342231d;

    /* renamed from: e, reason: collision with root package name */
    private d f342232e;

    /* renamed from: f, reason: collision with root package name */
    private PTSNodeSwiper f342233f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.pts.ui.view.PTSSwiperView.a f342234h;

    /* renamed from: i, reason: collision with root package name */
    private b f342235i;

    /* renamed from: m, reason: collision with root package name */
    private List<PTSNodeInfo> f342236m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements PagerSnapHelper.PagerEventListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSSwiperView.this);
            }
        }

        @Override // com.tencent.pts.support.PagerSnapHelper.PagerEventListener
        public void onFooterRebound() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.pts.support.PagerSnapHelper.PagerEventListener
        public void onPagerChanged(RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewHolder);
                return;
            }
            int q16 = PTSSwiperView.this.f342232e.q(PTSSwiperView.this.f342235i.getCurrentPosition());
            PTSSwiperView.this.f342234h.a(q16);
            PTSSwiperView.this.v(q16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class b extends PagerSnapHelper {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class c extends RecyclerViewCompat {
        static IPatchRedirector $redirector_;
        private PTSSwiperView C;

        /* renamed from: d, reason: collision with root package name */
        private boolean f342239d;

        /* renamed from: e, reason: collision with root package name */
        private Runnable f342240e;

        /* renamed from: f, reason: collision with root package name */
        private int f342241f;

        /* renamed from: h, reason: collision with root package name */
        private float f342242h;

        /* renamed from: i, reason: collision with root package name */
        private float f342243i;

        /* renamed from: m, reason: collision with root package name */
        private boolean f342244m;

        public c(PTSSwiperView pTSSwiperView) {
            super(pTSSwiperView.getContext());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSSwiperView);
                return;
            }
            this.f342239d = false;
            this.f342241f = 5000;
            this.C = pTSSwiperView;
        }

        private void f(ViewParent viewParent, float f16, float f17) {
            if (Math.abs(f17) > PTSSwiperView.K && Math.abs(f17) > Math.abs(f16)) {
                viewParent.requestDisallowInterceptTouchEvent(false);
                if (PTSLog.isColorLevel()) {
                    PTSLog.i("PTSSwiperView", "[dispatchTouchEvent] requestDisallowInterceptTouchEvent false");
                    return;
                }
                return;
            }
            viewParent.requestDisallowInterceptTouchEvent(true);
            if (PTSLog.isColorLevel()) {
                PTSLog.i("PTSSwiperView", "[dispatchTouchEvent] requestDisallowInterceptTouchEvent true");
            }
        }

        public void c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.f342239d = z16;
            }
        }

        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.f342241f = i3;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        
            if (r3 != 3) goto L37;
         */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            PTSSwiperView pTSSwiperView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
            }
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            ViewParent parent = getParent();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float f16 = x16 - this.f342242h;
                        float f17 = y16 - this.f342243i;
                        if (PTSLog.isColorLevel()) {
                            PTSLog.d("PTSSwiperView", "[dispatchTouchEvent] dx = " + f16 + ", dy = " + f17);
                        }
                        if (Math.abs(f16) > PTSSwiperView.K || Math.abs(f17) > PTSSwiperView.K) {
                            this.f342244m = true;
                        }
                        f(parent, f16, f17);
                    }
                }
                if (this.f342239d) {
                    postDelayed(this.f342240e, this.f342241f);
                }
                if (this.f342244m && (pTSSwiperView = this.C) != null) {
                    pTSSwiperView.u();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    PTSLog.i("PTSSwiperView", "[dispatchTouchEvent] requestDisallowInterceptTouchEvent false");
                }
            } else {
                this.f342242h = x16;
                this.f342243i = y16;
                this.f342244m = false;
                removeCallbacks(this.f342240e);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public void e(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
            } else {
                this.f342240e = runnable;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class d extends PTSRecyclerViewAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f342245d;

        public d(PTSAppInstance pTSAppInstance) {
            super(pTSAppInstance);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
            } else {
                this.f342245d = true;
            }
        }

        @Override // com.tencent.pts.ui.PTSRecyclerViewAdapter, android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            if (this.f342245d) {
                return Integer.MAX_VALUE;
            }
            return p();
        }

        @Override // com.tencent.pts.ui.PTSRecyclerViewAdapter, android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            return super.getItemViewType(q(i3));
        }

        public int p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return super.getItemCount();
        }

        public int q(int i3) {
            int p16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
            }
            if (this.f342245d && (p16 = p()) > 0) {
                return i3 % p16;
            }
            return i3;
        }

        public void r(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.f342245d = z16;
            }
        }

        @Override // com.tencent.pts.ui.PTSRecyclerViewAdapter, android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull PTSRecyclerViewAdapter.PTSViewHolder pTSViewHolder, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                super.onBindViewHolder(pTSViewHolder, q(i3));
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) pTSViewHolder, i3);
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(pTSViewHolder, i3, getItemId(i3));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            K = PTSDeviceUtil.dp2pxInt(3.0f);
        }
    }

    public PTSSwiperView(PTSNodeSwiper pTSNodeSwiper) {
        super(pTSNodeSwiper.getContext());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSNodeSwiper);
            return;
        }
        this.f342236m = new ArrayList();
        this.D = new Rect();
        this.F = false;
        this.G = 5000;
        this.H = 500;
        this.I = false;
        this.J = new Runnable() { // from class: com.tencent.pts.ui.view.PTSSwiperView.PTSSwiperView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PTSSwiperView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (PTSSwiperView.this.f342235i == null || PTSSwiperView.this.f342231d == null || !PTSSwiperView.this.F) {
                    return;
                }
                if (PTSSwiperView.this.f342231d.getGlobalVisibleRect(PTSSwiperView.this.D)) {
                    PTSNodeSwiper pTSNodeSwiper2 = PTSSwiperView.this.f342233f;
                    if (pTSNodeSwiper2 != null && pTSNodeSwiper2.getAppInstance() != null && pTSNodeSwiper2.getAppInstance().getContext() == null) {
                        PTSLog.i("PTSSwiperView", "mAutoPlayRunnable [run] context is null, stop scroll.");
                        return;
                    }
                    PTSSwiperView.this.f342235i.snapToNextPosition();
                    PTSSwiperView.this.f342231d.removeCallbacks(PTSSwiperView.this.J);
                    PTSSwiperView.this.f342231d.postDelayed(PTSSwiperView.this.J, PTSSwiperView.this.G);
                    return;
                }
                if (PTSLog.isColorLevel()) {
                    PTSLog.i("PTSSwiperView", "mAutoPlayRunnable [run] mRecyclerView is not visible.");
                }
                PTSSwiperView.this.f342231d.removeCallbacks(PTSSwiperView.this.J);
                PTSSwiperView.this.f342231d.postDelayed(PTSSwiperView.this.J, PTSSwiperView.this.G);
            }
        };
        r(pTSNodeSwiper);
    }

    private void r(PTSNodeSwiper pTSNodeSwiper) {
        this.f342233f = pTSNodeSwiper;
        Context context = pTSNodeSwiper.getContext();
        PTSAppInstance appInstance = pTSNodeSwiper.getAppInstance();
        this.E = context;
        this.f342232e = new d(appInstance);
        c cVar = new c(this);
        this.f342231d = cVar;
        cVar.setAdapter(this.f342232e);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f342231d.setLayoutManager(linearLayoutManager);
        addView(this.f342231d, new RelativeLayout.LayoutParams(-1, -1));
        o();
        b bVar = new b(null);
        this.f342235i = bVar;
        bVar.attachToRecyclerView(this.f342231d);
        this.f342235i.setEventListener(new a());
    }

    private void s(boolean z16) {
        PTSLog.i("PTSSwiperView", "[switchAutoPlay] autoPlay = " + z16 + ", size = " + this.f342236m.size());
        this.f342231d.removeCallbacks(this.J);
        if (!z16) {
            this.f342231d.stopScroll();
        }
        if (z16 && this.f342236m.size() > 1) {
            this.f342231d.postDelayed(this.J, this.G);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0032, code lost:
    
        if (r2.f342236m.size() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t(boolean z16) {
        boolean z17;
        PTSLog.i("PTSSwiperView", "[switchCircular] circular = " + z16 + ", size = " + this.f342236m.size());
        d dVar = this.f342232e;
        if (z16) {
            z17 = true;
        }
        z17 = false;
        dVar.r(z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        b bVar = this.f342235i;
        if (bVar != null && this.f342232e != null && this.f342233f != null && this.f342231d != null) {
            int q16 = this.f342232e.q(bVar.getCurrentPosition());
            if (q16 >= 0 && q16 < this.f342236m.size()) {
                PTSNodeInfo pTSNodeInfo = this.f342236m.get(q16);
                PTSAppInstance appInstance = this.f342233f.getAppInstance();
                if (pTSNodeInfo != null && appInstance != null) {
                    PTSLog.i("PTSSwiperView", "[triggerSwiperDrag], position = " + q16);
                    if (appInstance.isLiteAppInstance()) {
                        HashMap<String, String> eventInfo = pTSNodeInfo.getEventInfo();
                        String string = PTSValueConvertUtil.getString(pTSNodeInfo.getAttributes().get(PTSNodeAttributeConstant.EVENT_TYPE_PTS_ON_SWIPER_DRAG));
                        PTSAppInstance.PTSLiteAppInstance pTSLiteAppInstance = (PTSAppInstance.PTSLiteAppInstance) appInstance;
                        IPTSLiteEventListener liteEventListener = pTSLiteAppInstance.getLiteEventListener();
                        PTSLiteItemViewManager liteItemViewManager = pTSLiteAppInstance.getLiteItemViewManager();
                        if (liteEventListener != null) {
                            pTSLiteAppInstance.triggerLiteEvent(4, string, eventInfo, this.f342231d.getChildAt(q16), appInstance.getPtsComposer());
                            return;
                        } else {
                            if (liteItemViewManager != null) {
                                liteItemViewManager.triggerLiteEvent(4, string, eventInfo, this.f342231d.getChildAt(q16));
                                return;
                            }
                            return;
                        }
                    }
                    PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure], is not PTSLiteAppInstance.");
                    return;
                }
                PTSLog.i("PTSSwiperView", "[triggerSwiperDrag] failed, nodeInfo is null or ptsAppInstance is null.");
                return;
            }
            PTSLog.i("PTSSwiperView", "[triggerSwiperDrag] failed, position = " + q16);
            return;
        }
        PTSLog.i("PTSSwiperView", "[triggerSwiperDrag] failed, something is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3) {
        PTSNodeSwiper pTSNodeSwiper;
        if (i3 >= 0 && i3 < this.f342236m.size()) {
            PTSNodeInfo pTSNodeInfo = this.f342236m.get(i3);
            if (pTSNodeInfo != null && (pTSNodeSwiper = this.f342233f) != null && this.f342231d != null) {
                PTSAppInstance appInstance = pTSNodeSwiper.getAppInstance();
                if (appInstance == null) {
                    PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure] failed, ptsAppInstance is null.");
                    return;
                }
                PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure], position = " + i3);
                if (appInstance.isLiteAppInstance()) {
                    HashMap<String, String> eventInfo = pTSNodeInfo.getEventInfo();
                    String string = PTSValueConvertUtil.getString(pTSNodeInfo.getAttributes().get(PTSNodeAttributeConstant.EVENT_TYPE_PTS_ON_SWIPER_ITEM_EXPOSURE));
                    PTSAppInstance.PTSLiteAppInstance pTSLiteAppInstance = (PTSAppInstance.PTSLiteAppInstance) appInstance;
                    IPTSLiteEventListener liteEventListener = pTSLiteAppInstance.getLiteEventListener();
                    PTSLiteItemViewManager liteItemViewManager = pTSLiteAppInstance.getLiteItemViewManager();
                    if (liteEventListener != null) {
                        pTSLiteAppInstance.triggerLiteEvent(3, string, eventInfo, this.f342231d.getChildAt(i3), appInstance.getPtsComposer());
                        return;
                    } else {
                        if (liteItemViewManager != null) {
                            liteItemViewManager.triggerLiteEvent(3, string, eventInfo, this.f342231d.getChildAt(i3));
                            return;
                        }
                        return;
                    }
                }
                PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure], is not PTSLiteAppInstance.");
                return;
            }
            PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure] failed, nodeInfo is null or nodeSwiper is null, or recyclerView is null.");
            return;
        }
        PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure] failed, position = " + i3);
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f342234h = new PTSSwiperDotIndicator(this.E);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView((View) this.f342234h, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onAttachedToWindow();
            s(this.F);
        }
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSNodeInfo);
            return;
        }
        if (pTSNodeInfo == null) {
            return;
        }
        this.f342236m.clear();
        this.f342236m.addAll(pTSNodeInfo.getChildren());
        this.f342232e.setData(this.f342236m);
        s(this.F);
        t(this.I);
        post(new Runnable(pTSNodeInfo) { // from class: com.tencent.pts.ui.view.PTSSwiperView.PTSSwiperView.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PTSNodeInfo f342237d;

            {
                this.f342237d = pTSNodeInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PTSSwiperView.this, (Object) pTSNodeInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PTSNodeInfo pTSNodeInfo2 = PTSSwiperView.this.C;
                    PTSNodeInfo pTSNodeInfo3 = this.f342237d;
                    if (pTSNodeInfo2 != pTSNodeInfo3) {
                        PTSSwiperView.this.C = pTSNodeInfo3;
                        PTSSwiperView.this.f342231d.scrollToPosition(0);
                        PTSSwiperView.this.f342234h.a(0);
                        PTSLog.i("PTSSwiperView", "[onBindNodeInfo], snapToTargetPosition: 0");
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDetachedFromWindow();
            s(false);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if (i3 == 0 && this.F) {
            z16 = true;
        } else {
            z16 = false;
        }
        s(z16);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        if (z16 && PTSDeviceUtil.isVisibleOnScreen(this)) {
            z17 = true;
        } else {
            z17 = false;
        }
        s(z17);
    }

    public void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (this.f342234h != null) {
            if (str.equalsIgnoreCase("dot")) {
                return;
            } else {
                removeView((View) this.f342234h);
            }
        }
        if (str.equalsIgnoreCase("text")) {
            this.f342234h = new PTSSwiperTextIndicator(this.E);
        } else if (str.equalsIgnoreCase("dot")) {
            this.f342234h = new PTSSwiperDotIndicator(this.E);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView((View) this.f342234h, layoutParams);
    }

    public com.tencent.pts.ui.view.PTSSwiperView.a q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.pts.ui.view.PTSSwiperView.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f342234h;
    }

    public void setAutoPlay(boolean z16) {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        this.F = z16;
        this.f342231d.c(z16);
        c cVar = this.f342231d;
        if (this.F) {
            runnable = this.J;
        } else {
            runnable = null;
        }
        cVar.e(runnable);
    }

    public void setAutoPlayDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }

    public void setAutoPlayInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.G = i3;
            this.f342231d.d(i3);
        }
    }

    public void setCircular(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.I = z16;
            t(z16);
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f342234h.c(this.f342232e.p());
            this.f342234h.a(this.f342232e.p());
        }
    }
}
