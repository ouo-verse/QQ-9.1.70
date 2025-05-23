package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.ab;
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

/* loaded from: classes32.dex */
public class AEFilterProviderView extends ProviderView implements ab.b, d.c {
    private AEProviderContainerView N;
    private RecyclerView P;
    private ab Q;
    public int R;
    public int S;
    public m.b T;
    public ArrayList<FilterCategory> U;
    private com.tencent.aelight.camera.aioeditor.capture.data.d V;

    public AEFilterProviderView(Context context) {
        super(context);
        this.R = 0;
        this.S = 0;
    }

    public static void G(String str) {
        AECameraPrefsUtil.f().p(AECameraConstants.AE_FILTER_ID, str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, "saveFilterPref(ae_filter_id, " + str + ")");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void A() {
        super.A();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = this.V;
        if (dVar != null) {
            dVar.G(this);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void C(Bundle bundle) {
        super.C(bundle);
        F(bundle);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void D(int i3, String str, String str2) {
        QIMFilterCategoryItem qIMFilterCategoryItem;
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, "category= " + i3 + " categoryName= " + str + ",itemId=" + str2);
        }
        FilterCategory filterCategory = this.U.get(this.S);
        final int i16 = 0;
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
            QLog.d("AEFilterProviderView", 2, "itemInfo= " + qIMFilterCategoryItem + ",index=" + this.S + ",pos=" + i16);
        }
        if (qIMFilterCategoryItem != null) {
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AEFilterProviderView.this.P != null) {
                        AEFilterProviderView.this.P.smoothScrollToPosition(i16);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("AEFilterProviderView", 2, "gridView is null ");
                    }
                }
            }, 200L);
            if (this.V != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("apply_source", 1);
                bundle.putInt("capture_scene", this.K);
                this.V.m(qIMFilterCategoryItem, (Activity) getContext(), bundle);
            }
            if (!this.N.r()) {
                G(qIMFilterCategoryItem.f66697d);
            }
            this.Q.notifyDataSetChanged();
        }
    }

    public void H(m.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("AEFilterProviderView", 2, "filters setup()");
        }
        this.T = bVar;
        ArrayList<FilterCategory> arrayList = bVar.f66516b;
        this.U = arrayList;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = this.S;
            if (size > i3) {
                this.Q.setData(this.U.get(i3).f66687f);
            }
        }
        this.Q.notifyDataSetChanged();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void d(com.tencent.aelight.camera.aioeditor.capture.data.j jVar, boolean z16, int i3, Bundle bundle) {
        int i16;
        this.Q.notifyDataSetChanged();
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
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void e(m.a aVar) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onComboFilterDataUpdated data:");
            sb5.append(aVar == null);
            QLog.d("AEFilterProviderView", 2, sb5.toString());
        }
        if (aVar != null) {
            H(aVar.c(this.K));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void j(com.tencent.aelight.camera.aioeditor.capture.data.h hVar, boolean z16, int i3, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i("QCombo", 2, "fp onComboApply combo " + hVar.f66709i + " filter ");
        }
        this.Q.notifyDataSetChanged();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    protected int p() {
        return R.layout.ap7;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void u() {
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar;
        m.a aVar;
        super.u();
        if (this.T == null && (dVar = this.V) != null && (aVar = dVar.I) != null) {
            this.T = aVar.c(this.K);
        }
        m.b bVar = this.T;
        if (bVar == null || bVar.f66520f == null) {
            return;
        }
        Activity activity = (Activity) getContext();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar2 = this.V;
        if (dVar2 != null) {
            dVar2.s(this.T.f66520f).g(activity, this.K);
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().V(this.T.f66520f, (Activity) getContext(), this.K);
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().L(this.T.f66520f, this.K);
        this.Q.notifyDataSetChanged();
        onItemClick(null, 0);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void v(Bundle bundle) {
        super.v(bundle);
        this.N = (AEProviderContainerView) ((Activity) getContext()).findViewById(R.id.rom);
        if (this.D == null) {
            this.D = LayoutInflater.from(getContext()).inflate(R.layout.dlj, (ViewGroup) this, true);
        }
        this.P = (RecyclerView) this.D.findViewById(R.id.rtd);
        this.P.setLayoutManager(new LinearLayoutManager(this.f67276d, 0, false));
        ab abVar = new ab(this.f67276d, this.K);
        this.Q = abVar;
        this.P.setAdapter(abVar);
        this.Q.s(this);
        if (fr.f.d().h(5)) {
            com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
            this.V = dVar;
            if (dVar != null) {
                dVar.k(this);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "FilterProviderView onCreate");
        }
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar2 = this.V;
        m.a aVar = dVar2 != null ? dVar2.I : null;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AEFilterProviderView", 2, "filterProviderView get data is null");
                return;
            }
            return;
        }
        H(aVar.c(this.K));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void w() {
        super.w();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = this.V;
        if (dVar != null) {
            dVar.L[this.K].c();
            this.V.G(this);
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
        this.Q.notifyDataSetChanged();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void z() {
        super.z();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = this.V;
        if (dVar != null) {
            dVar.k(this);
        }
    }

    private void F(Bundle bundle) {
        Bundle bundle2 = bundle != null ? bundle.getBundle(AEFilterProviderView.class.getSimpleName()) : null;
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

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.ab.b
    public void onItemClick(View view, int i3) {
        Object tag = view != null ? view.getTag() : null;
        QIMFilterCategoryItem qIMFilterCategoryItem = tag != null ? (QIMFilterCategoryItem) tag : null;
        if (qIMFilterCategoryItem == null) {
            return;
        }
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
            aVar.b0(-1, qIMFilterCategoryItem);
        }
        if (this.V != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("apply_source", 1);
            bundle.putInt("capture_scene", this.K);
            if (AEFilterManagerHolder.getAEFilterManager() != null && !AEFilterManagerHolder.getAEFilterManager().U) {
                bundle.putBoolean("capture_force_enable", true);
            }
            this.V.m(qIMFilterCategoryItem, (Activity) getContext(), bundle);
        }
        if (!this.N.r()) {
            G(qIMFilterCategoryItem.f66697d);
        }
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = this.V;
        if (dVar != null) {
            dVar.J(this.K, (Activity) this.f67276d);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void f(com.tencent.aelight.camera.aioeditor.capture.data.h hVar) {
    }
}
