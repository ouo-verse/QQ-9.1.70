package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.qqsettingme.api.ILebaDataServicesApi;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cv;
import com.tencent.mobileqq.utils.ei;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQTabHost extends TabHost implements FrameFragment.c, FrameFragment.d {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.tab.d f316097d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.fpsreport.a f316098e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f316099f;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements TabHost.OnTabChangeListener {
        a() {
        }

        @Override // android.widget.TabHost.OnTabChangeListener
        public void onTabChanged(String str) {
            QQTabHost.this.e(str);
            QQTabHost.this.f316097d.onTabChanged(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b implements FrameFragment.e {

        /* renamed from: a, reason: collision with root package name */
        private final TabHost.TabSpec f316101a;

        /* renamed from: b, reason: collision with root package name */
        private final View f316102b;

        public b(TabHost.TabSpec tabSpec, View view) {
            this.f316101a = tabSpec;
            this.f316102b = view;
        }

        @Override // com.tencent.mobileqq.app.FrameFragment.e
        public View a() {
            return this.f316102b;
        }

        @Override // com.tencent.mobileqq.app.FrameFragment.e
        public String getTag() {
            return this.f316101a.getTag();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QQTabHost(Context context) {
        super(context);
        this.f316099f = false;
        setWillNotDraw(false);
        if (context instanceof com.tencent.mobileqq.fpsreport.a) {
            this.f316098e = (com.tencent.mobileqq.fpsreport.a) context;
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    @Deprecated
    public /* bridge */ /* synthetic */ View a() {
        return super.getTabContentView();
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void c(FrameFragment.e eVar) {
        addTab(((b) eVar).f316101a);
    }

    @Override // android.widget.TabHost, com.tencent.mobileqq.app.FrameFragment.c
    public void clearAllTabs() {
        QLog.i("FrameUtil.QQTabHost", 1, "clearAllTabs  this:" + System.identityHashCode(this));
        super.clearAllTabs();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f316099f) {
            ei.a(null, "Recent_Draw");
        }
        cv.d("QQTabHost draw start.");
        super.draw(canvas);
        cv.d("QQTabHost draw end.");
        if (this.f316099f) {
            this.f316099f = false;
            ei.a("Recent_Draw", null);
            com.tencent.mobileqq.fpsreport.a aVar = this.f316098e;
            if (aVar != null) {
                aVar.onDrawComplete();
            }
        }
    }

    public void e(String str) {
        if ((com.tencent.mobileqq.activity.home.impl.b.B.equals(str) || com.tencent.mobileqq.activity.home.impl.b.C.equals(str)) && ((ILebaDataServicesApi) QRoute.api(ILebaDataServicesApi.class)).redTouchContainerNewGuide().booleanValue()) {
            ((ILebaDataServicesApi) QRoute.api(ILebaDataServicesApi.class)).hiddeNewGuide();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.f316099f) {
            ei.a(null, "Recent_OnLayout");
        }
        cv.d("QQTabHost onLayout start.");
        super.onLayout(z16, i3, i16, i17, i18);
        cv.d("QQTabHost onLayout end.");
        if (this.f316099f) {
            ei.a("Recent_OnLayout", null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        cv.d("QQTabHost onMeasure start.");
        super.onMeasure(i3, i16);
        cv.d("QQTabHost onMeasure end.");
    }

    @Override // android.widget.TabHost, android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z16) {
        if (((ITabFrameController) QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.QQTabHost", 2, " QQTabHost onTouchModeChanged isInTouchMode:" + z16);
                return;
            }
            return;
        }
        super.onTouchModeChanged(z16);
    }

    @Override // android.widget.TabHost, com.tencent.mobileqq.app.FrameFragment.d
    public void setCurrentTab(int i3) {
        setCurrentTab(i3, true);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void setFirstDrawTrue() {
        this.f316099f = true;
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void setOnDrawCompleteListener(com.tencent.mobileqq.fpsreport.a aVar) {
        this.f316098e = aVar;
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.d
    public void setOnTabSelectionListener(com.tencent.mobileqq.tab.d dVar) {
        this.f316097d = dVar;
        setOnTabChangedListener(new a());
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void setup(FrameFragment frameFragment) {
        super.setup();
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.d
    public void setCurrentTab(int i3, boolean z16) {
        int tabCount = getTabWidget().getTabCount();
        if (i3 < 0 || i3 >= tabCount) {
            return;
        }
        int currentTab = getCurrentTab();
        try {
            super.setCurrentTab(i3);
        } catch (Exception e16) {
            QLog.e("FrameUtil.QQTabHost", 1, "android tab host set current tab error : ", e16);
        }
        com.tencent.mobileqq.tab.d dVar = this.f316097d;
        if (dVar != null && z16) {
            dVar.a(currentTab, i3);
        }
        try {
            throw new RuntimeException();
        } catch (Exception e17) {
            QLog.d("FrameUtil.QQTabHost", 2, "QQTabHost setCurrentTab, index=" + i3, e17);
        }
    }

    public QQTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316099f = false;
        setWillNotDraw(false);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void b(int i3) {
    }
}
