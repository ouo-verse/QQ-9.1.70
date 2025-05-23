package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes32.dex */
public class DYAEFilterProviderView extends ProviderView implements DYAEEffectListHolder.b, d.c {
    private DYAEProviderContainerView N;
    private DYAEEffectListHolder P;
    public int Q;
    public m.b R;
    public ArrayList<FilterCategory> S;
    private String T;
    private com.tencent.aelight.camera.aioeditor.capture.data.d U;
    private AEPituCameraUnit V;
    private ac W;

    /* renamed from: a0, reason: collision with root package name */
    private b f62964a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements Observer<QIMFilterCategoryItem> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QIMFilterCategoryItem qIMFilterCategoryItem) {
            String str = DYAEFilterProviderView.this.T;
            if (qIMFilterCategoryItem != null) {
                str = qIMFilterCategoryItem.f66697d;
            }
            DYAEFilterProviderView.this.P.k(str, true);
            if (DYAEFilterProviderView.this.f62964a0 == null || DYAEFilterProviderView.this.f62964a0.f62968b == null || !TextUtils.equals(DYAEFilterProviderView.this.f62964a0.f62968b.f66697d, str)) {
                return;
            }
            DYAEFilterProviderView dYAEFilterProviderView = DYAEFilterProviderView.this;
            dYAEFilterProviderView.J(dYAEFilterProviderView.f62964a0.f62968b, DYAEFilterProviderView.this.f62964a0.f62967a);
            DYAEFilterProviderView.this.f62964a0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f62967a;

        /* renamed from: b, reason: collision with root package name */
        QIMFilterCategoryItem f62968b;

        b() {
        }
    }

    public DYAEFilterProviderView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(QIMFilterCategoryItem qIMFilterCategoryItem, int i3) {
        com.tencent.aelight.camera.ae.report.b.b().W(qIMFilterCategoryItem.f66697d, AEProviderViewModel.t2(qIMFilterCategoryItem));
        HashMap hashMap = new HashMap();
        String str = "none";
        if (i3 == 0) {
            AEBaseReportParam.U().Y0("none");
            hashMap.put("ext15", "none");
        } else {
            AEBaseReportParam.U().Y0(qIMFilterCategoryItem.f66697d);
            hashMap.put("ext15", qIMFilterCategoryItem.f66697d);
        }
        com.tencent.aelight.camera.aebase.c.b(11, hashMap);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("report filter click(");
            sb5.append(i3);
            sb5.append(", ");
            if (i3 != 0) {
                str = "" + qIMFilterCategoryItem.f66697d;
            }
            sb5.append(str);
            sb5.append(")");
            QLog.d("AEFilterProviderView", 2, sb5.toString());
        }
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.b0(i3, qIMFilterCategoryItem);
        }
        if (this.U != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("apply_source", 1);
            bundle.putInt("capture_scene", this.K);
            if (AEFilterManagerHolder.getAEFilterManager() != null && !AEFilterManagerHolder.getAEFilterManager().U) {
                bundle.putBoolean("capture_force_enable", true);
            }
            this.U.m(qIMFilterCategoryItem, (Activity) getContext(), bundle);
        }
        if (!this.N.X()) {
            P(qIMFilterCategoryItem.f66697d);
        }
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = this.U;
        if (dVar != null) {
            dVar.J(this.K, (Activity) this.f67276d);
        }
    }

    public static String L() {
        String j3 = AECameraPrefsUtil.f().j(AECameraConstants.DY_FILTER_ID, "", 0);
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, "getFilterId(dy_filter_id, " + j3 + ")");
        }
        return j3;
    }

    private void N() {
        ac acVar = (ac) com.tencent.aelight.camera.ae.n.a(this.V).get(ac.class);
        this.W = acVar;
        acVar.L1().observe(this.V, new a());
    }

    private void O() {
        if (this.W != null) {
            this.W.N1(com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().i(this.K));
        }
    }

    public static void P(String str) {
        AECameraPrefsUtil.f().p(AECameraConstants.DY_FILTER_ID, str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, "saveFilterPref(dy_filter_id, " + str + ")");
        }
    }

    private void Q(m.a aVar) {
        List<QIMFilterCategoryItem> list;
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, "filters setup()");
        }
        m.b c16 = aVar.c(this.K);
        this.R = c16;
        this.S = c16.f66516b;
        ArrayList arrayList = new ArrayList();
        ArrayList<FilterCategory> arrayList2 = this.S;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i3 = this.Q;
            if (size > i3 && (list = this.S.get(i3).f66687f) != null) {
                if (list.size() > 0) {
                    QIMFilterCategoryItem qIMFilterCategoryItem = list.get(0);
                    if (qIMFilterCategoryItem.k()) {
                        qIMFilterCategoryItem.f66700h = "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png";
                        this.T = qIMFilterCategoryItem.f66697d;
                    }
                }
                Iterator<QIMFilterCategoryItem> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new bp(it.next()));
                }
            }
        }
        this.P.j(arrayList);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void A() {
        super.A();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = this.U;
        if (dVar != null) {
            dVar.G(this);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void C(Bundle bundle) {
        super.C(bundle);
        M(bundle);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void D(int i3, String str, String str2) {
        QIMFilterCategoryItem qIMFilterCategoryItem;
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, "category= " + i3 + " categoryName= " + str + ",itemId=" + str2);
        }
        FilterCategory filterCategory = this.S.get(this.Q);
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 >= filterCategory.f66687f.size()) {
                qIMFilterCategoryItem = null;
                break;
            }
            qIMFilterCategoryItem = filterCategory.f66687f.get(i17);
            if (qIMFilterCategoryItem.f66697d.equals(str2)) {
                i16 = i17;
                break;
            }
            i17++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, "itemInfo= " + qIMFilterCategoryItem + ",index=" + this.Q + ",pos=" + i16);
        }
        if (qIMFilterCategoryItem != null) {
            final String str3 = qIMFilterCategoryItem.f66697d;
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView.2
                @Override // java.lang.Runnable
                public void run() {
                    DYAEFilterProviderView.this.P.g(str3, true);
                }
            }, 200L);
            if (this.U != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("apply_source", 1);
                bundle.putInt("capture_scene", this.K);
                this.U.m(qIMFilterCategoryItem, (Activity) getContext(), bundle);
            }
            if (!this.N.X()) {
                P(qIMFilterCategoryItem.f66697d);
            }
            this.P.c(true);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder.b
    public void b(bj bjVar, int i3) {
        if (bjVar instanceof bp) {
            QIMFilterCategoryItem filterItem = ((bp) bjVar).getFilterItem();
            b bVar = new b();
            this.f62964a0 = bVar;
            bVar.f62967a = i3;
            bVar.f62968b = filterItem;
            ac acVar = this.W;
            if (acVar != null) {
                acVar.N1(filterItem);
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void e(m.a aVar) {
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onComboFilterDataUpdated data:");
            sb5.append(aVar == null);
            QLog.d("AEFilterProviderView", 2, sb5.toString());
        }
        if (aVar != null) {
            Q(aVar);
        }
        O();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void j(com.tencent.aelight.camera.aioeditor.capture.data.h hVar, boolean z16, int i3, Bundle bundle) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "fp onComboApply combo " + hVar.f66709i + " filter ");
        }
        O();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    protected int p() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void u() {
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar;
        m.a aVar;
        super.u();
        if (this.R == null && (dVar = this.U) != null && (aVar = dVar.I) != null) {
            this.R = aVar.c(this.K);
        }
        m.b bVar = this.R;
        if (bVar == null || bVar.f66520f == null) {
            return;
        }
        Activity activity = (Activity) getContext();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar2 = this.U;
        if (dVar2 != null) {
            dVar2.s(this.R.f66520f).g(activity, this.K);
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().V(this.R.f66520f, (Activity) getContext(), this.K);
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().L(this.R.f66520f, this.K);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void v(Bundle bundle) {
        super.v(bundle);
        this.N = (DYAEProviderContainerView) ((Activity) getContext()).findViewById(R.id.rom);
        this.P = new DYAEEffectListHolder(this.f67276d, this.F, this, 0);
        if (fr.f.d().h(5)) {
            com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
            this.U = dVar;
            if (dVar != null) {
                dVar.k(this);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QCombo", 2, "FilterProviderView onCreate");
        }
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar2 = this.U;
        m.a aVar = dVar2 != null ? dVar2.I : null;
        if (aVar == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AEFilterProviderView", 2, "filterProviderView get data is null");
            }
        } else {
            Q(aVar);
        }
        O();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void w() {
        super.w();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = this.U;
        if (dVar != null) {
            dVar.L[this.K].c();
            this.U.G(this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
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
            aVar.p();
        }
        this.P.c(true);
        this.P.i();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void z() {
        super.z();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = this.U;
        if (dVar != null) {
            dVar.k(this);
        }
    }

    public DYAEFilterProviderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void K(com.tencent.aelight.camera.ae.part.c cVar) {
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        this.V = aEPituCameraUnit;
        if (aEPituCameraUnit != null) {
            N();
        }
    }

    public DYAEFilterProviderView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.Q = 0;
        this.f67276d = context;
    }

    private void M(Bundle bundle) {
        Bundle bundle2 = bundle != null ? bundle.getBundle(DYAEFilterProviderView.class.getSimpleName()) : null;
        if (bundle2 != null) {
            if (com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().f66501h[this.K] != null) {
                com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().f66501h[this.K].K = 1;
            }
            QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) bundle2.getParcelable("selected_filter_item");
            if (qIMFilterCategoryItem != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AEFilterProviderView", 2, "restore " + qIMFilterCategoryItem.f66697d);
                }
                qIMFilterCategoryItem.K = 1;
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void d(com.tencent.aelight.camera.aioeditor.capture.data.j jVar, boolean z16, int i3, Bundle bundle) {
        int i16;
        if (z16) {
            com.tencent.aelight.camera.aioeditor.capture.music.g gVar = (com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.d().g(8);
            if (this.K == 0) {
                i16 = com.tencent.mobileqq.filter.f.f209752b;
            } else {
                i16 = com.tencent.mobileqq.filter.f.f209753c;
            }
            gVar.C(i16);
            gVar.F();
        }
        O();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void f(com.tencent.aelight.camera.aioeditor.capture.data.h hVar) {
    }
}
