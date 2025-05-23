package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderGridAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.capture.data.e;
import com.tencent.aelight.camera.aioeditor.capture.data.h;
import com.tencent.aelight.camera.aioeditor.capture.data.j;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import fr.f;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes32.dex */
public class ComboProviderView extends ProviderView implements QIMSlidingTabView.c, BounceViewPager.b, AdapterView.OnItemClickListener, Handler.Callback, d.c {
    BounceViewPager N;
    com.tencent.aelight.camera.aioeditor.capture.adapter.a P;
    ArrayList<FilterCategory> Q;
    public Handler R;
    public m.b S;
    e T;
    public int U;

    /* loaded from: classes32.dex */
    class a extends e {
        a() {
        }
    }

    public ComboProviderView(Context context) {
        super(context);
        this.R = new Handler(Looper.getMainLooper(), this);
        this.T = new a();
        this.U = 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void A() {
        m.n();
        m.J(true);
        super.A();
        if (f.d().h(5)) {
            ((d) f.c(5)).J(this.K, (Activity) getContext());
        }
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
            QLog.d("ComboProviderView", 2, "category= " + i3 + " categoryName= " + str + ",itemId=" + str2);
        }
        if (this.Q == null) {
            if (QLog.isColorLevel()) {
                QLog.e("ComboProviderView", 2, "selectCategoryAndItem when mTagInfos null " + i3 + " " + str2);
                return;
            }
            return;
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
            QLog.d("ComboProviderView", 2, "itemInfo= " + qIMFilterCategoryItem + ",index=" + i17 + ",pos=" + i16);
        }
        if (qIMFilterCategoryItem == null) {
            return;
        }
        if (qIMFilterCategoryItem.n()) {
            l.g(this.f67276d, qIMFilterCategoryItem, 2);
            return;
        }
        postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.view.ComboProviderView.2
            @Override // java.lang.Runnable
            public void run() {
                ComboProviderView comboProviderView = ComboProviderView.this;
                GridView gridView = comboProviderView.P.f66611f.get(comboProviderView.E());
                if (gridView != null) {
                    gridView.setSelection(i16);
                    gridView.smoothScrollToPosition(i16 / gridView.getNumColumns());
                    if (QLog.isColorLevel()) {
                        QLog.d("ComboProviderView", 2, "positon= " + i16);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ComboProviderView", 2, "gridView is null");
                }
            }
        }, 500L);
        d dVar = (d) f.c(5);
        Bundle bundle = new Bundle();
        bundle.putInt("apply_source", 1);
        bundle.putInt("capture_scene", this.K);
        h r16 = dVar.r(qIMFilterCategoryItem);
        int i19 = r16.f66706e;
        if (i19 == 1 || i19 == 2) {
            c.c(r16).g();
        }
        dVar.l(qIMFilterCategoryItem, (Activity) getContext(), bundle);
        I();
        if (QLog.isColorLevel()) {
            QLog.i("ComboProviderView", 2, "selectFilterItem state = " + qIMFilterCategoryItem);
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
        int k3 = m.n().k();
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            QIMSlidingTabView.d dVar = new QIMSlidingTabView.d();
            dVar.f67316a = this.Q.get(i3).f66686e;
            m.n();
            dVar.f67317b = m.F(2, this.Q.get(i3).f66685d, "");
            arrayList.add(dVar);
            if (k3 != -1 && k3 == this.Q.get(i3).f66685d) {
                this.U = i3;
                m.n().Y(7, 0, null);
            }
        }
        return arrayList;
    }

    public void H(QIMFilterCategoryItem qIMFilterCategoryItem) {
        int i3 = qIMFilterCategoryItem.f66701i;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 >= this.Q.size()) {
                i17 = 0;
                break;
            } else if (this.Q.get(i17).f66685d == i3) {
                break;
            } else {
                i17++;
            }
        }
        if (this.N.getCurrentItem() != i17) {
            this.N.setCurrentItem(i17);
        }
        Iterator<QIMFilterCategoryItem> it = this.Q.get(i17).f66687f.iterator();
        while (it.hasNext() && !it.next().f66697d.equals(qIMFilterCategoryItem.f66697d)) {
            i16++;
        }
        GridView d16 = this.P.d(this.N.getCurrentItem());
        if (d16 != null) {
            d16.setSelection(i16);
            ((ComboProviderGridAdapter) d16.getAdapter()).a();
        }
    }

    public void I() {
        if (this.I) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QCombo", 2, "ComboProviderView updateComboState");
            }
            int size = this.P.f66611f.size();
            for (int i3 = 0; i3 < size; i3++) {
                ListAdapter adapter = this.P.f66611f.get(this.P.f66611f.keyAt(i3)).getAdapter();
                if (adapter instanceof ComboProviderGridAdapter) {
                    ((ComboProviderGridAdapter) adapter).notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void e(m.a aVar) {
        setup(aVar.c(this.K));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void j(h hVar, boolean z16, int i3, Bundle bundle) {
        I();
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        String str;
        String str2;
        ProviderView.a aVar;
        int E = E();
        QIMFilterCategoryItem qIMFilterCategoryItem = this.Q.get(E).f66687f.get(i3);
        if (qIMFilterCategoryItem.n()) {
            l.g(this.f67276d, qIMFilterCategoryItem, 2);
            return;
        }
        if (j3 > 0 && (aVar = this.M) != null) {
            aVar.b0(-1, qIMFilterCategoryItem);
        }
        d dVar = (d) f.c(5);
        if (dVar.z().b(qIMFilterCategoryItem.f66697d, getContext())) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("apply_source", 1);
        bundle.putInt("capture_scene", this.K);
        h r16 = dVar.r(qIMFilterCategoryItem);
        int i16 = r16.f66706e;
        if (i16 == 1 || i16 == 2) {
            c.c(r16).g();
        }
        dVar.l(qIMFilterCategoryItem, (Activity) getContext(), bundle);
        if (SlideShowPhotoListManager.n().m() == 22 && (str2 = qIMFilterCategoryItem.D) != null && str2.isEmpty()) {
            LpReportInfo_pf00064.allReport(680, 6, 1);
        }
        if (SlideShowPhotoListManager.n().m() == 22 && (str = qIMFilterCategoryItem.D) != null && !str.isEmpty()) {
            LpReportInfo_pf00064.allReport(680, 6, 2);
        }
        I();
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "onItemClick combo " + E + "," + i3 + ", combo " + r16);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "onItemClick state = " + qIMFilterCategoryItem);
        }
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
        this.S = bVar;
        this.Q = bVar.f66515a;
        this.C.initTabItemsWithRedDot(F());
        com.tencent.aelight.camera.aioeditor.capture.adapter.a aVar = new com.tencent.aelight.camera.aioeditor.capture.adapter.a(this.f67276d, this.K);
        this.P = aVar;
        aVar.e(this);
        this.P.f(this.Q);
        this.N.setAdapter(this.P);
        this.P.notifyDataSetChanged();
        int size = this.Q.size();
        int i3 = this.U;
        if (size > i3) {
            this.N.setCurrentItem(i3);
            this.C.onTabChecked(this.U);
        }
        I();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void u() {
        super.u();
        if (this.S != null) {
            d dVar = (d) f.c(5);
            Activity activity = (Activity) getContext();
            m.b c16 = dVar.I.c(this.K);
            QIMFilterCategoryItem qIMFilterCategoryItem = c16.f66519e;
            if (qIMFilterCategoryItem != null) {
                dVar.r(qIMFilterCategoryItem).g(activity, this.K);
            }
            m.n().U(c16.f66519e, activity, this.K);
            I();
        }
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
        com.tencent.aelight.camera.aioeditor.capture.adapter.a aVar = new com.tencent.aelight.camera.aioeditor.capture.adapter.a(this.f67276d, this.K);
        this.P = aVar;
        aVar.e(this);
        this.P.f(new ArrayList<>());
        this.N.g(this);
        this.N.setAdapter(this.P);
        l(this.N);
        this.f67277e.registObserver(this.T);
        d dVar = (d) f.c(5);
        dVar.k(this);
        dVar.z().e(this.K);
        if (QLog.isDevelopLevel()) {
            QLog.d("QCombo", 2, "ComboProviderView onCreate");
        }
        m.a aVar2 = dVar.I;
        if (aVar2 != null) {
            setup(aVar2.c(this.K));
        }
        PasterDataManager pasterDataManager = (PasterDataManager) f.d().g(4);
        pasterDataManager.h();
        pasterDataManager.u(true, (Activity) getContext());
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void w() {
        super.w();
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.R = null;
        }
        AppInterface appInterface = this.f67277e;
        if (appInterface != null) {
            appInterface.unRegistObserver(this.T);
        }
        BounceViewPager bounceViewPager = this.N;
        if (bounceViewPager != null) {
            bounceViewPager.h(this);
        }
        if (f.d().h(5)) {
            ((d) f.c(5)).G(this);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void y() {
        super.y();
        QIMFilterCategoryItem qIMFilterCategoryItem = ((d) f.c(5)).z().C;
        if (qIMFilterCategoryItem != null) {
            H(qIMFilterCategoryItem);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void z() {
        super.z();
        I();
    }

    private void G(Bundle bundle) {
        QIMFilterCategoryItem qIMFilterCategoryItem;
        Bundle bundle2 = bundle != null ? bundle.getBundle(ComboProviderView.class.getSimpleName()) : null;
        if (bundle2 == null || (qIMFilterCategoryItem = (QIMFilterCategoryItem) bundle2.getParcelable("select_filter_item")) == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ComboProviderView", 2, "restore " + qIMFilterCategoryItem.f66697d);
        }
        d dVar = (d) f.c(5);
        int i3 = this.K;
        if ((i3 == 2 || i3 == 1) && m.n().f66502i[this.K] == null) {
            m.n().f66502i[this.K] = dVar.r(qIMFilterCategoryItem);
        }
        m.a aVar = dVar.I;
        if (aVar != null) {
            this.S = aVar.c(this.K);
        }
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

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void d(j jVar, boolean z16, int i3, Bundle bundle) {
    }
}
