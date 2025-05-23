package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.capture.data.h;
import com.tencent.aelight.camera.aioeditor.capture.data.j;
import com.tencent.aelight.camera.aioeditor.capture.music.g;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import fr.f;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class QIMFilterProviderView extends ProviderView implements QIMSlidingTabView.c, BounceViewPager.b, AdapterView.OnItemClickListener, d.c {
    BounceViewPager N;
    com.tencent.aelight.camera.aioeditor.capture.adapter.c P;
    public ArrayList<FilterCategory> Q;
    public int R;
    public m.b S;
    public int T;

    public QIMFilterProviderView(Context context) {
        super(context);
        this.R = 0;
        this.T = 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void A() {
        super.A();
        ((d) f.c(5)).G(this);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void C(Bundle bundle) {
        super.C(bundle);
        G(bundle);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void D(int i3, String str, String str2) {
        QIMFilterCategoryItem qIMFilterCategoryItem;
        if (QLog.isColorLevel()) {
            QLog.d("FilterProviderView", 2, "category= " + i3 + " categoryName= " + str + ",itemId=" + str2);
        }
        final int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 >= this.Q.size()) {
                i17 = 0;
                break;
            } else if ((i3 != -1 && this.Q.get(i17).f66685d == i3) || (str != null && str.equals(this.Q.get(i17).f66686e))) {
                break;
            } else {
                i17++;
            }
        }
        r().onTabChecked(i17);
        FilterCategory filterCategory = this.Q.get(E());
        int i18 = 0;
        while (true) {
            if (i18 >= filterCategory.f66687f.size()) {
                qIMFilterCategoryItem = null;
                break;
            }
            qIMFilterCategoryItem = filterCategory.f66687f.get(i18);
            if (qIMFilterCategoryItem.f66697d.equals(str2)) {
                i16 = i18;
                break;
            }
            i18++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FilterProviderView", 2, "itemInfo= " + qIMFilterCategoryItem + ",index=" + i17 + ",pos=" + i16);
        }
        if (qIMFilterCategoryItem != null) {
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView.1
                @Override // java.lang.Runnable
                public void run() {
                    QIMFilterProviderView qIMFilterProviderView = QIMFilterProviderView.this;
                    GridView gridView = qIMFilterProviderView.P.f66623f.get(qIMFilterProviderView.E());
                    if (gridView != null) {
                        gridView.setSelection(i16);
                        gridView.smoothScrollToPosition(i16 / gridView.getNumColumns());
                    } else if (QLog.isColorLevel()) {
                        QLog.d("FilterProviderView", 2, "gridView is null ");
                    }
                }
            }, 200L);
            d dVar = (d) f.c(5);
            Bundle bundle = new Bundle();
            bundle.putInt("apply_source", 1);
            bundle.putInt("capture_scene", this.K);
            dVar.m(qIMFilterCategoryItem, (Activity) getContext(), bundle);
            H();
        }
    }

    public int E() {
        BounceViewPager bounceViewPager = this.N;
        if (bounceViewPager == null) {
            return 0;
        }
        return bounceViewPager.getCurrentItem();
    }

    public ArrayList<QIMSlidingTabView.d> F() {
        ArrayList<QIMSlidingTabView.d> arrayList = new ArrayList<>();
        int j3 = m.n().j();
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            QIMSlidingTabView.d dVar = new QIMSlidingTabView.d();
            dVar.f67316a = this.Q.get(i3).f66686e;
            m.n();
            dVar.f67317b = m.F(2, this.Q.get(i3).f66685d, "");
            arrayList.add(dVar);
            if (j3 != -1 && j3 == this.Q.get(i3).f66685d) {
                this.T = i3;
                m.n().Y(5, 0, null);
            }
        }
        return arrayList;
    }

    public void H() {
        if (this.I) {
            if (QLog.isColorLevel()) {
                QLog.i("QCombo", 2, "FilterProviderView updateSelectedState");
            }
            int size = this.P.f66623f.size();
            for (int i3 = 0; i3 < size; i3++) {
                ListAdapter adapter = this.P.f66623f.get(this.P.f66623f.keyAt(i3)).getAdapter();
                if (adapter instanceof com.tencent.aelight.camera.aioeditor.capture.adapter.b) {
                    ((com.tencent.aelight.camera.aioeditor.capture.adapter.b) adapter).notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void d(j jVar, boolean z16, int i3, Bundle bundle) {
        int i16;
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.j(true);
        }
        H();
        if (z16) {
            g gVar = (g) f.d().g(8);
            if (this.K == 0) {
                i16 = com.tencent.mobileqq.filter.f.f209752b;
            } else {
                i16 = com.tencent.mobileqq.filter.f.f209753c;
            }
            gVar.C(i16);
            gVar.F();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void e(m.a aVar) {
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onComboFilterDataUpdated data:");
            sb5.append(aVar == null);
            QLog.d("FilterProviderView", 2, sb5.toString());
        }
        if (aVar != null) {
            setup(aVar.c(this.K));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void j(h hVar, boolean z16, int i3, Bundle bundle) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "fp onComboApply combo " + hVar.f66709i + " filter ");
        }
        H();
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageSelected(int i3) {
        this.C.onTabChecked(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    protected int p() {
        return R.layout.ap7;
    }

    public void setup(m.b bVar) {
        QIMSlidingTabView qIMSlidingTabView = this.C;
        if (qIMSlidingTabView == null) {
            return;
        }
        this.S = bVar;
        this.Q = bVar.f66516b;
        qIMSlidingTabView.initTabItemsWithRedDot(F());
        com.tencent.aelight.camera.aioeditor.capture.adapter.c cVar = new com.tencent.aelight.camera.aioeditor.capture.adapter.c(this.f67276d, this.K);
        this.P = cVar;
        cVar.d(this);
        this.P.e(this.Q);
        this.N.setAdapter(this.P);
        this.P.notifyDataSetChanged();
        int size = this.Q.size();
        int i3 = this.T;
        if (size > i3) {
            this.N.setCurrentItem(i3);
            this.C.onTabChecked(this.T);
        }
        this.P.notifyDataSetChanged();
        H();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void u() {
        m.a aVar;
        super.u();
        m.b bVar = this.S;
        d dVar = (d) f.c(5);
        if (bVar == null && (aVar = dVar.I) != null) {
            bVar = aVar.c(this.K);
        }
        if (bVar == null || bVar.f66520f == null) {
            return;
        }
        dVar.s(bVar.f66520f).g((Activity) getContext(), this.K);
        m.n().V(bVar.f66520f, (Activity) getContext(), this.K);
        m.n().L(bVar.f66520f, this.K);
        H();
        onItemClick(null, null, 0, 0L);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void v(Bundle bundle) {
        super.v(bundle);
        this.C.setTabCheckListener(this);
        View view = this.D;
        if (view == null) {
            this.N = (BounceViewPager) LayoutInflater.from(getContext()).inflate(R.layout.ap7, (ViewGroup) this, false);
        } else {
            this.N = (BounceViewPager) view;
        }
        com.tencent.aelight.camera.aioeditor.capture.adapter.c cVar = new com.tencent.aelight.camera.aioeditor.capture.adapter.c(this.f67276d, this.K);
        this.P = cVar;
        cVar.d(this);
        this.P.e(new ArrayList<>());
        this.N.g(this);
        this.N.setAdapter(this.P);
        l(this.N);
        d dVar = (d) f.c(5);
        dVar.k(this);
        if (QLog.isDevelopLevel()) {
            QLog.d("QCombo", 2, "FilterProviderView onCreate");
        }
        m.a aVar = dVar.I;
        if (aVar == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("FilterProviderView", 2, "filterProviderView get data is null");
                return;
            }
            return;
        }
        setup(aVar.c(this.K));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void w() {
        super.w();
        BounceViewPager bounceViewPager = this.N;
        if (bounceViewPager != null) {
            bounceViewPager.h(this);
        }
        m.n();
        m.J(true);
        if (f.d().h(5)) {
            d dVar = (d) f.c(5);
            dVar.L[this.K].c();
            dVar.G(this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FilterProviderView", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void x() {
        super.x();
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.j(false);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void y() {
        super.y();
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.j(true);
            this.M.p();
        }
        H();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void z() {
        super.z();
        ((d) f.c(5)).k(this);
    }

    private void G(Bundle bundle) {
        Bundle bundle2 = bundle != null ? bundle.getBundle(QIMFilterProviderView.class.getSimpleName()) : null;
        if (bundle2 != null) {
            if (m.n().f66501h[this.K] != null) {
                m.n().f66501h[this.K].K = 1;
            }
            QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) bundle2.getParcelable("selected_filter_item");
            if (qIMFilterCategoryItem != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("FilterProviderView", 2, "restore " + qIMFilterCategoryItem.f66697d);
                }
                qIMFilterCategoryItem.K = 1;
            }
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        QIMFilterCategoryItem qIMFilterCategoryItem;
        ProviderView.a aVar;
        Object tag = view != null ? view.getTag() : null;
        if (tag != null && (tag instanceof QIMFilterCategoryItem)) {
            qIMFilterCategoryItem = (QIMFilterCategoryItem) tag;
        } else {
            ArrayList<FilterCategory> arrayList = this.Q;
            if (arrayList == null || (qIMFilterCategoryItem = arrayList.get(E()).f66687f.get(i3)) == null) {
                return;
            }
        }
        if (qIMFilterCategoryItem.n()) {
            l.g(this.f67276d, qIMFilterCategoryItem, 2);
            return;
        }
        if (j3 > 0 && (aVar = this.M) != null) {
            aVar.b0(-1, qIMFilterCategoryItem);
        }
        d dVar = (d) f.c(5);
        Bundle bundle = new Bundle();
        bundle.putInt("apply_source", 1);
        bundle.putInt("capture_scene", this.K);
        dVar.m(qIMFilterCategoryItem, (Activity) getContext(), bundle);
        ((d) f.c(5)).J(this.K, (Activity) this.f67276d);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.c
    public void onTabChecked(int i3) {
        if (i3 < 0 || i3 > this.Q.size()) {
            return;
        }
        this.N.setCurrentItem(i3);
        m.n().Y(2, this.Q.get(i3).f66685d, "");
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void f(h hVar) {
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
