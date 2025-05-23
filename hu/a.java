package hu;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.c;
import com.tencent.av.business.processor.BaseConfigFileProcessor;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import yq2.b;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends com.tencent.av.business.manager.a {
    private String C;
    private List<QavListItemBase.c> D;
    private String E;
    private String F;
    private String G;
    private String H;
    private boolean I;
    private HashMap<Integer, BaseConfigFileProcessor<? extends c>> J;

    /* renamed from: h, reason: collision with root package name */
    private final Object f406272h;

    /* renamed from: i, reason: collision with root package name */
    private b f406273i;

    /* renamed from: m, reason: collision with root package name */
    private int f406274m;

    public a(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.f406272h = new Object();
        this.f406274m = 1;
        this.D = new ArrayList(19);
        this.I = false;
        this.J = new HashMap<>();
    }

    private QavListItemBase.c u(String str, List<hw.a> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (hw.a aVar : list) {
                List<QavListItemBase.c> list2 = aVar.f406501d;
                if (list2 != null && list2.size() > 0) {
                    for (QavListItemBase.c cVar : aVar.f406501d) {
                        if (str.equals(cVar.f75024a)) {
                            return cVar;
                        }
                    }
                }
            }
        }
        return null;
    }

    private void x() {
        if (this.I) {
            return;
        }
        this.J.put(1, new com.tencent.av.business.processor.b(this.f73316e));
        this.J.put(2, new com.tencent.av.business.processor.a(this.f73316e));
        this.J.put(4, new com.tencent.av.business.processor.c(this.f73316e));
        this.I = true;
    }

    public void A() {
        b bVar = this.f406273i;
        if (bVar != null) {
            bVar.c(6, null);
        }
    }

    public void B() {
        b bVar = this.f406273i;
        if (bVar != null) {
            bVar.c(1, null);
        }
    }

    public void C() {
        b bVar = this.f406273i;
        if (bVar != null) {
            bVar.c(2, null);
        }
    }

    public void D() {
        b bVar = this.f406273i;
        if (bVar != null) {
            bVar.c(7, null);
        }
    }

    public synchronized void E(yq2.c cVar) {
        b bVar = this.f406273i;
        if (bVar != null) {
            bVar.e(cVar);
        }
    }

    public void F(Context context, String str, List<QavListItemBase.c> list) {
        if (list != null && !list.isEmpty()) {
            synchronized (this.f406272h) {
                StringBuilder sb5 = new StringBuilder();
                for (QavListItemBase.c cVar : list) {
                    if (!TextUtils.isEmpty(cVar.f75024a) && !cVar.f75024a.equals("0")) {
                        sb5.append(cVar.f75024a);
                        sb5.append("$");
                    }
                }
                if (TextUtils.isEmpty(sb5.toString())) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EffectMaterialManager", 2, "saveRecentMaterial list=" + sb5.toString());
                }
                ea.V0(context, this.f73316e.getCurrentAccountUin()).edit().putString(str, sb5.toString()).commit();
            }
        }
    }

    public void G(int i3) {
        this.f406274m = i3;
    }

    public void H(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("EffectMaterialManager", 2, "setCurrentSelectDoublePendantMaterialId id : " + str);
        }
        this.E = str;
    }

    public void I(String str) {
        this.F = str;
    }

    public void J(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("EffectMaterialManager", 2, "setCurrentSelectPendantMaterialId id : " + str);
        }
        this.C = str;
    }

    public void K(String str) {
        this.G = str;
    }

    public void L(List<QavListItemBase.c> list) {
        this.D = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void g() {
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void h(String str, boolean z16) {
        super.h(str, z16);
        QLog.d("EffectMaterialManager", 1, "[onDestroyUI] isQuit:" + z16);
        b bVar = this.f406273i;
        if (bVar != null) {
            bVar.b();
            this.f406273i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public boolean i(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void j(long j3, int i3, String str, String str2) {
        if (i3 == 3) {
            G(1);
        }
    }

    public synchronized void l(yq2.c cVar, int i3) {
        if (this.f406273i == null) {
            this.f406273i = new b();
        }
        this.f406273i.a(cVar, i3);
    }

    public boolean m(ArrayList<QavListItemBase.c> arrayList, QavListItemBase.c cVar) {
        if (cVar == null) {
            return true;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<QavListItemBase.c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f75024a.equals(cVar.f75024a)) {
                    return true;
                }
            }
        }
        return false;
    }

    public BaseConfigFileProcessor<? extends c> n(int i3) {
        if (!this.I) {
            x();
        }
        BaseConfigFileProcessor<? extends c> baseConfigFileProcessor = this.J.get(Integer.valueOf(i3));
        if (baseConfigFileProcessor == null) {
            QLog.e("EffectMaterialManager", 1, "getConfigFileProcessor: invalid processor");
        }
        return baseConfigFileProcessor;
    }

    public int o() {
        return this.f406274m;
    }

    public String p() {
        if (QLog.isDevelopLevel()) {
            QLog.i("EffectMaterialManager", 2, "getCurrentSelectDoublePendantMaterialId id : " + this.E);
        }
        return this.E;
    }

    public String q() {
        return this.F;
    }

    public String r() {
        if (QLog.isDevelopLevel()) {
            QLog.i("EffectMaterialManager", 2, "getCurrentSelectPendantMaterialId id : " + this.C);
        }
        return this.C;
    }

    public String s() {
        return this.H;
    }

    public String t() {
        return this.G;
    }

    public List<QavListItemBase.c> v() {
        return this.D;
    }

    public boolean w(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    public ArrayList<QavListItemBase.c> y(Context context, String str, List<hw.a> list) {
        String[] split;
        String string = ea.V0(context, this.f73316e.getCurrentAccountUin()).getString(str, null);
        if (QLog.isColorLevel()) {
            QLog.i("EffectMaterialManager", 2, "loadRecentMaterial list = " + string);
        }
        if (TextUtils.isEmpty(string) || (split = string.split("\\$")) == null || split.length <= 0) {
            return null;
        }
        ArrayList<QavListItemBase.c> arrayList = new ArrayList<>();
        synchronized (this.f406272h) {
            for (String str2 : split) {
                QavListItemBase.c u16 = u(str2, list);
                if (u16 != null && !m(arrayList, u16) && !u16.f75024a.equals("0")) {
                    arrayList.add(u16);
                }
            }
        }
        return arrayList;
    }

    public void z() {
        b bVar = this.f406273i;
        if (bVar != null) {
            bVar.c(4, null);
        }
    }
}
