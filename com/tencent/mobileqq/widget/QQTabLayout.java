package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.google.android.material.tabs.TabLayout;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQTabLayout extends TabLayout implements FrameFragment.d, com.tencent.mobileqq.tab.b, com.tencent.mobileqq.tab.a {

    /* renamed from: t0, reason: collision with root package name */
    private com.tencent.mobileqq.tab.d f316103t0;

    /* renamed from: u0, reason: collision with root package name */
    private com.tencent.mobileqq.tab.c f316104u0;

    /* renamed from: v0, reason: collision with root package name */
    private final List<com.tencent.mobileqq.tab.e> f316105v0;

    /* renamed from: w0, reason: collision with root package name */
    private float f316106w0;

    /* renamed from: x0, reason: collision with root package name */
    private float f316107x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f316108y0;

    public QQTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316105v0 = new ArrayList();
        this.f316106w0 = 0.0f;
        this.f316107x0 = 0.0f;
        this.f316108y0 = false;
        setWillNotDraw(false);
    }

    @Override // com.google.android.material.tabs.TabLayout
    public boolean L(TabLayout.g gVar) {
        return super.L(gVar);
    }

    @Override // com.tencent.mobileqq.tab.b
    @UiThread
    public void a(@NonNull com.tencent.mobileqq.tab.e eVar) {
        this.f316105v0.add(eVar);
    }

    @Override // com.tencent.mobileqq.tab.b
    @UiThread
    public void b(@NonNull com.tencent.mobileqq.tab.e eVar) {
        this.f316105v0.remove(eVar);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.d
    public int getCurrentTab() {
        return A();
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.d
    public String getCurrentTabTag() {
        TabLayout.g B = B(A());
        if (B != null) {
            return (String) B.i();
        }
        return null;
    }

    @Override // com.google.android.material.tabs.TabLayout, android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.tencent.mobileqq.tab.c cVar;
        int action;
        if (QLog.isColorLevel() && ((action = motionEvent.getAction()) == 0 || action == 1 || action == 3)) {
            QLog.d("FrameUtil.QQTabLayout", 2, "QQTabLayout onInterceptTouchEvent. action=" + action + ",x=" + motionEvent.getRawX() + ",y=" + motionEvent.getRawY());
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            if (action2 == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                float f16 = this.f316107x0;
                if (y16 < f16 && f16 - y16 > 50.0f && f16 - y16 > Math.abs(this.f316106w0 - x16) && (cVar = this.f316104u0) != null && !this.f316108y0) {
                    this.f316108y0 = true;
                    cVar.a();
                }
            }
        } else {
            this.f316108y0 = false;
            this.f316106w0 = motionEvent.getX();
            this.f316107x0 = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.d
    public void setCurrentTab(int i3) {
        setCurrentTab(i3, true);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.d
    public void setCurrentTabByTag(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("FrameUtil.QQTabLayout", 1, "setCurrentTabByTag empty clazzName");
            return;
        }
        TabLayout.g B = B(A());
        if (B != null && str.equals(B.i())) {
            QLog.e("FrameUtil.QQTabLayout", 1, "setCurrentTabByTag \u5df2\u7ecf\u662f\u76ee\u6807Tab\uff0c\u4e0d\u9700\u8981\u8df3\u8f6c clsName=" + str);
            return;
        }
        int C = C();
        QLog.e("FrameUtil.QQTabLayout", 1, "setCurrentTabByTag count=" + C + ", clsName=" + str);
        for (int i3 = 0; i3 < C; i3++) {
            TabLayout.g B2 = B(i3);
            if (B2 != null && str.equals(B2.i())) {
                setCurrentTab(i3);
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.d
    public void setOnTabSelectionListener(com.tencent.mobileqq.tab.d dVar) {
        this.f316103t0 = dVar;
        f(new a());
    }

    @Override // com.tencent.mobileqq.tab.a
    public void setTabWidgetMoveListener(com.tencent.mobileqq.tab.c cVar) {
        this.f316104u0 = cVar;
    }

    @Override // android.view.View
    public void setTranslationY(float f16) {
        super.setTranslationY(f16);
        Iterator it = new ArrayList(this.f316105v0).iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.tab.e) it.next()).a(f16);
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.d
    public void setCurrentTab(int i3, boolean z16) {
        int C = C();
        QLog.d("FrameUtil.QQTabLayout", 1, "setCurrentTab count=" + C + ", index=" + i3);
        if (i3 < 0 || i3 >= C) {
            return;
        }
        int currentTab = getCurrentTab();
        try {
            TabLayout.g B = B(i3);
            if (B != null) {
                com.tencent.mobileqq.tab.d dVar = this.f316103t0;
                if (dVar != null) {
                    dVar.b(B.i().toString());
                }
                B.m();
            }
        } catch (Exception e16) {
            QLog.e("FrameUtil.QQTabLayout", 1, "android TabLayout set current tab error : ", e16);
        }
        com.tencent.mobileqq.tab.d dVar2 = this.f316103t0;
        if (dVar2 != null && z16) {
            dVar2.a(currentTab, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FrameUtil.QQTabLayout", 2, "TabLayout setCurrentTab index=" + i3, Log.getStackTraceString(new Throwable()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements TabLayout.d {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.g gVar) {
            QQTabLayout.this.f316103t0.onTabChanged(gVar.i().toString());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.g gVar) {
        }
    }
}
