package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ad extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f63070d;

    /* renamed from: e, reason: collision with root package name */
    private List<AEMaterialCategory> f63071e;

    /* renamed from: h, reason: collision with root package name */
    private AEMaterialPanel.e f63073h;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<Integer, AEGridView> f63072f = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private AEMaterialManager f63074i = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements AEGridView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AEMaterialAdapter f63075a;

        a(AEMaterialAdapter aEMaterialAdapter) {
            this.f63075a = aEMaterialAdapter;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView.b
        public void a(boolean z16, int i3) {
            this.f63075a.w(z16, i3);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView.b
        public void b(int[] iArr) {
            this.f63075a.D(iArr);
        }
    }

    public ad(Context context, AEMaterialPanel.e eVar) {
        this.f63070d = context;
        this.f63073h = eVar;
    }

    private void g(AEMaterialAdapter aEMaterialAdapter, int i3) {
        this.f63074i.g(aEMaterialAdapter, 112);
        this.f63074i.g(aEMaterialAdapter, 113);
        this.f63074i.g(aEMaterialAdapter, 1024);
        this.f63074i.g(aEMaterialAdapter, 114);
        this.f63074i.g(aEMaterialAdapter, 111);
        this.f63074i.g(aEMaterialAdapter, 115);
        if (i3 == 0) {
            this.f63074i.g(aEMaterialAdapter, 111);
        }
    }

    public AEMaterialCategory d(int i3) {
        List<AEMaterialCategory> list = this.f63071e;
        if (list == null || list.size() <= i3 || i3 < 0) {
            return null;
        }
        return this.f63071e.get(i3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView(this.f63072f.get(Integer.valueOf(i3)));
        AEGridView aEGridView = this.f63072f.get(Integer.valueOf(i3));
        if (aEGridView != null) {
            this.f63074i.n0((AEMaterialAdapter) aEGridView.getAdapter());
        }
    }

    public void e(int i3) {
        AEMaterialAdapter aEMaterialAdapter;
        List<AEMaterialCategory> list;
        ms.a.a("PtvTemplateViewPagerAdapter", "dtexpose reportTabFirstExpose");
        AEGridView aEGridView = this.f63072f.get(Integer.valueOf(i3));
        if (aEGridView == null || (aEMaterialAdapter = (AEMaterialAdapter) aEGridView.getAdapter()) == null || (list = this.f63071e) == null || list.get(i3) == null) {
            return;
        }
        aEMaterialAdapter.x(this.f63071e.get(i3).f69044d);
    }

    public void f(List<AEMaterialCategory> list) {
        this.f63071e = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f63071e.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        AEMaterialAdapter aEMaterialAdapter;
        AEGridView aEGridView = this.f63072f.get(Integer.valueOf(i3));
        if (aEGridView == null) {
            aEGridView = new AEGridView(this.f63070d);
            aEMaterialAdapter = new AEMaterialAdapter(this.f63070d, aEGridView, this.f63073h, i3 == 0);
            g(aEMaterialAdapter, i3);
            aEGridView.c(new a(aEMaterialAdapter));
            r1 = i3 == 1;
            this.f63072f.put(Integer.valueOf(i3), aEGridView);
        } else {
            aEMaterialAdapter = (AEMaterialAdapter) aEGridView.getAdapter();
            g(aEMaterialAdapter, i3);
        }
        aEMaterialAdapter.C(this.f63071e.get(i3).f69044d);
        if (r1) {
            ms.a.a("PtvTemplateViewPagerAdapter", "dtexpose isFirstTabExpose");
            aEMaterialAdapter.x(this.f63071e.get(i3).f69044d);
        }
        aEGridView.setAdapter(aEMaterialAdapter);
        viewGroup.addView(aEGridView);
        if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + aEMaterialAdapter);
        }
        return aEGridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }
}
