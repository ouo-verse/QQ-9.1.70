package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes32.dex */
public class AEMaterialProviderView extends FrameLayout implements QIMSlidingTabView.c, ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, yq2.c {
    private AEMaterialPanel.e C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    public com.tencent.aelight.camera.aioeditor.capture.music.b H;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f62919d;

    /* renamed from: e, reason: collision with root package name */
    private QIMSlidingTabView f62920e;

    /* renamed from: f, reason: collision with root package name */
    private List<AEMaterialCategory> f62921f;

    /* renamed from: h, reason: collision with root package name */
    private QQViewPager f62922h;

    /* renamed from: i, reason: collision with root package name */
    private ad f62923i;

    /* renamed from: m, reason: collision with root package name */
    private AEMaterialManager f62924m;

    /* loaded from: classes32.dex */
    class a extends com.tencent.aelight.camera.aioeditor.capture.music.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.b
        public void c() {
            if (QLog.isColorLevel()) {
                QLog.d("AEMaterialProviderView", 2, "material list updated!");
            }
            if (AEMaterialProviderView.this.F) {
                return;
            }
            AEMaterialProviderView.this.m(true);
        }
    }

    public AEMaterialProviderView(Context context, AEMaterialPanel.e eVar) {
        super(context);
        this.f62921f = new CopyOnWriteArrayList();
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = 1;
        this.H = new a();
        this.f62919d = com.tencent.aelight.camera.aebase.a.a();
        this.C = eVar;
        g();
    }

    private AEMaterialCategory d(String str) {
        List<AEMaterialMetaData> list;
        if (this.f62921f != null && !TextUtils.isEmpty(str)) {
            for (AEMaterialCategory aEMaterialCategory : this.f62921f) {
                if (aEMaterialCategory != null && (list = aEMaterialCategory.f69044d) != null) {
                    for (AEMaterialMetaData aEMaterialMetaData : list) {
                        if (aEMaterialMetaData != null && str.equals(aEMaterialMetaData.f69050id)) {
                            return aEMaterialCategory;
                        }
                    }
                }
            }
        }
        return null;
    }

    private ArrayList<QIMSlidingTabView.d> e() {
        ArrayList<QIMSlidingTabView.d> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.f62921f.size(); i3++) {
            AEMaterialCategory aEMaterialCategory = this.f62921f.get(i3);
            if (aEMaterialCategory != null) {
                if (-1 == aEMaterialCategory.f69045e) {
                    this.G = i3;
                }
                QIMSlidingTabView.d dVar = new QIMSlidingTabView.d();
                dVar.f67316a = aEMaterialCategory.f69047h;
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    private void g() {
        LayoutInflater.from(getContext()).inflate(R.layout.f167495dm4, this);
        QIMSlidingTabView qIMSlidingTabView = (QIMSlidingTabView) findViewById(R.id.s2w);
        this.f62920e = qIMSlidingTabView;
        qIMSlidingTabView.setIndicateColor(getContext().getResources().getColor(R.color.f157748yb));
        this.f62920e.setTabCheckListener(this);
        this.f62920e.getViewTreeObserver().addOnScrollChangedListener(this);
        this.f62922h = (QQViewPager) findViewById(R.id.s4t);
        this.f62923i = new ad(getContext(), this.C);
        AEMaterialManager aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
        this.f62924m = aEMaterialManager;
        aEMaterialManager.N(false);
        this.f62923i.f(new ArrayList());
        this.f62922h.setOnPageChangeListener(this);
        this.f62922h.setAdapter(this.f62923i);
        this.f62919d.registObserver(this.H);
        m(true);
    }

    private boolean h() {
        QIMCameraCaptureActivity qIMCameraCaptureActivity;
        return (getContext() instanceof QIMCameraCaptureActivity) && (qIMCameraCaptureActivity = (QIMCameraCaptureActivity) getContext()) != null && gq.a.r(qIMCameraCaptureActivity.getIntent());
    }

    @Override // android.view.View
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String getTag() {
        return "AEMaterialProviderView";
    }

    public void i(int i3) {
        if (this.f62922h == null || this.f62920e == null) {
            return;
        }
        ms.a.f("AEMaterialProviderView", "locatePage: " + i3);
        this.f62922h.setCurrentItem(i3);
    }

    public void j() {
        AEMaterialManager aEMaterialManager = this.f62924m;
        if (aEMaterialManager != null) {
            aEMaterialManager.l();
            this.f62924m.m0(111);
            this.f62924m.m0(113);
            this.f62924m.m0(112);
        }
        AppInterface appInterface = this.f62919d;
        if (appInterface != null) {
            appInterface.unRegistObserver(this.H);
        }
    }

    public void k() {
        if (this.f62924m != null) {
            if ((getContext() instanceof Activity) && gq.a.r(((Activity) getContext()).getIntent())) {
                this.f62924m.p0();
            } else {
                this.f62924m.q0();
            }
        }
    }

    public void l(String str, String str2) {
        final int i3;
        AEMaterialCategory aEMaterialCategory;
        if (QLog.isColorLevel()) {
            QLog.d("AEMaterialProviderView", 2, "selectCategoryAndItem, categoryName=" + str + ", itemId=" + str2 + ", mTabListSize=" + this.f62921f.size());
        }
        if (this.f62921f.isEmpty()) {
            m(true);
        }
        final AEMaterialMetaData aEMaterialMetaData = null;
        int i16 = 0;
        if (!TextUtils.isEmpty(str)) {
            i3 = 0;
            while (true) {
                if (i3 >= this.f62921f.size()) {
                    aEMaterialCategory = null;
                    i3 = 0;
                    break;
                } else {
                    if (str != null && str.equals(this.f62921f.get(i3).f69047h)) {
                        aEMaterialCategory = this.f62921f.get(i3);
                        break;
                    }
                    i3++;
                }
            }
        } else {
            aEMaterialCategory = d(str2);
            i3 = this.f62921f.indexOf(aEMaterialCategory);
        }
        if (aEMaterialCategory == null) {
            ms.a.f("AEMaterialProviderView", "find category null");
            return;
        }
        int i17 = 0;
        while (true) {
            if (i17 >= aEMaterialCategory.f69044d.size()) {
                break;
            }
            AEMaterialMetaData aEMaterialMetaData2 = aEMaterialCategory.f69044d.get(i17);
            if (aEMaterialMetaData2.f69050id.equals(str2)) {
                i16 = i17;
                aEMaterialMetaData = aEMaterialMetaData2;
                break;
            }
            i17++;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialProviderView.2
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f("AEMaterialProviderView", "select category: " + i3);
                AEMaterialProviderView.this.f62922h.setCurrentItem(i3);
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d("AEMaterialProviderView", 2, "itemInfo= " + aEMaterialMetaData + ",index=" + i3 + ",pos=" + i16);
        }
        if (aEMaterialMetaData != null) {
            this.F = true;
            if (aEMaterialMetaData.isWsBanner()) {
                com.tencent.biz.qqstory.utils.l.g(getContext(), aEMaterialMetaData, 1);
            } else {
                postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialProviderView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AEGridView aEGridView = AEMaterialProviderView.this.f62923i.f63072f.get(Integer.valueOf(i3));
                        if (aEGridView != null) {
                            AEMaterialAdapter aEMaterialAdapter = (AEMaterialAdapter) aEGridView.getAdapter();
                            aEGridView.h(aEMaterialMetaData.position);
                            aEMaterialAdapter.z(aEMaterialMetaData);
                        } else if (QLog.isColorLevel()) {
                            QLog.d("AEMaterialProviderView", 2, "gridView is null");
                        }
                    }
                }, 200L);
            }
        }
    }

    public void m(boolean z16) {
        List<AEMaterialCategory> B;
        QQViewPager qQViewPager;
        if (h()) {
            B = this.f62924m.u();
        } else {
            B = this.f62924m.B(z16);
        }
        ms.a.a("AEMaterialProviderView", "### updateData: fromCircle = " + h() + " | totalList = " + B.toString());
        this.f62921f = new ArrayList(B);
        int i3 = this.G;
        int i16 = 0;
        if (!z16 && (qQViewPager = this.f62922h) != null && this.f62923i != null) {
            if (!this.E) {
                AEMaterialCategory d16 = this.f62923i.d(qQViewPager.getCurrentItem());
                if (d16 != null) {
                    int i17 = 0;
                    while (true) {
                        if (i17 < this.f62921f.size()) {
                            AEMaterialCategory aEMaterialCategory = this.f62921f.get(i17);
                            if (aEMaterialCategory != null && !TextUtils.isEmpty(aEMaterialCategory.f69047h) && aEMaterialCategory.f69047h.equals(d16.f69047h)) {
                                i3 = i17;
                                break;
                            }
                            i17++;
                        } else {
                            break;
                        }
                    }
                }
            }
            this.E = false;
        }
        ad adVar = this.f62923i;
        if (adVar != null) {
            adVar.f(this.f62921f);
            this.f62923i.notifyDataSetChanged();
        }
        QQViewPager qQViewPager2 = this.f62922h;
        if (qQViewPager2 != null) {
            qQViewPager2.setAdapter(this.f62923i);
        }
        QIMSlidingTabView qIMSlidingTabView = this.f62920e;
        if (qIMSlidingTabView != null) {
            qIMSlidingTabView.initTabItemsWithRedDot(e());
            this.f62920e.setTabCheckListener(this);
        }
        if (i3 < this.f62921f.size() || !QLog.isColorLevel()) {
            i16 = i3;
        } else {
            QLog.d("AEMaterialProviderView", 2, "resetPos " + i3 + " not exist, mTabList size = " + this.f62921f.size());
        }
        if (this.F || this.f62921f.size() <= 0 || this.f62922h == null || this.f62920e == null) {
            return;
        }
        i(i16);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        this.f62920e.onTabChecked(i3);
        ad adVar = this.f62923i;
        if (adVar != null) {
            adVar.e(i3);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.c
    public void onTabChecked(int i3) {
        this.f62922h.setCurrentItem(i3);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
