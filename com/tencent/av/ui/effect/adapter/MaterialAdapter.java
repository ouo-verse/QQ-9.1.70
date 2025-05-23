package com.tencent.av.ui.effect.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.av.ui.effect.view.QavEffectMaterialItemView;
import com.tencent.av.ui.effect.view.QavVoiceChangeMaterialItemView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MaterialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements QavListItemBase.b, yq2.c {
    private AppInterface C;
    private hu.a D;
    private MaterialRecyclerView E;
    private int G;
    private boolean H;
    iw.b L;
    iw.a M;

    /* renamed from: m, reason: collision with root package name */
    private final WeakReference<Context> f75534m;
    private ArrayList<QavListItemBase.c> F = new ArrayList<>();
    protected volatile int I = -1;
    protected int J = -1;
    boolean K = true;
    long N = 0;
    private final QavListItemBase.a P = new c();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            iw.a aVar = MaterialAdapter.this.M;
            if (aVar != null) {
                aVar.c(0L);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f75541a;

        b(int i3) {
            this.f75541a = i3;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            boolean z16 = true;
            accessibilityNodeInfoCompat.setCheckable(true);
            if (this.f75541a != MaterialAdapter.this.I) {
                z16 = false;
            }
            accessibilityNodeInfoCompat.setChecked(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c implements QavListItemBase.a {
        c() {
        }

        @Override // com.tencent.av.ui.QavListItemBase.a
        public void a(long j3, int i3, QavListItemBase qavListItemBase) {
            boolean z16;
            if (System.currentTimeMillis() - MaterialAdapter.this.N < 500 && i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.w("MaterialAdapter", 1, "onItemClicked begin, position[" + i3 + "], mCurSelectedPosition[" + MaterialAdapter.this.I + "], ignore[" + z16 + "], seq[" + j3 + "]");
            }
            if (z16) {
                return;
            }
            QLog.w("MaterialAdapter", 1, "onItemClicked valid, position[" + i3 + "], mCurSelectedPosition[" + MaterialAdapter.this.I + "], seq[" + j3 + "]");
            MaterialAdapter.this.N = System.currentTimeMillis();
            MaterialAdapter.this.I = i3;
            MaterialAdapter materialAdapter = MaterialAdapter.this;
            materialAdapter.J = i3;
            materialAdapter.k0(j3, materialAdapter.I);
            MaterialAdapter materialAdapter2 = MaterialAdapter.this;
            if (materialAdapter2.M != null) {
                MaterialAdapter.this.M.d((QavListItemBase.c) materialAdapter2.F.get(i3));
            }
            MaterialAdapter.this.notifyDataSetChanged();
        }
    }

    public MaterialAdapter(AppInterface appInterface, Context context, ArrayList<QavListItemBase.c> arrayList, MaterialRecyclerView materialRecyclerView, int i3, boolean z16) {
        this.C = appInterface;
        this.f75534m = new WeakReference<>(context);
        this.E = materialRecyclerView;
        this.G = i3;
        this.D = (hu.a) ((VideoAppInterface) this.C).B(15);
        this.H = z16;
        A0(arrayList);
        this.E.setOnTouchListener(new a());
    }

    public void A0(ArrayList<QavListItemBase.c> arrayList) {
        this.F.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            this.F.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        ArrayList<QavListItemBase.c> arrayList = this.F;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.F.get(i3).f75029f == 2) {
            return 1;
        }
        return 0;
    }

    protected void k0(long j3, int i3) {
        if (i3 >= 0 && this.F.size() > i3) {
            QavListItemBase.c cVar = this.F.get(i3);
            if (!TextUtils.isEmpty(cVar.f75024a) && !cVar.f75024a.equals("0")) {
                if (cVar.f75027d) {
                    t0(j3, cVar);
                    return;
                }
                if (!cVar.f75028e && !TextUtils.isEmpty(cVar.f75024a)) {
                    iw.b bVar = this.L;
                    if (bVar != null) {
                        bVar.startDownloadTemplate(this.C, j3, cVar, this);
                        cVar.f75028e = true;
                        return;
                    }
                    throw new IllegalArgumentException("mIItemDownloadMgr is null, please call setItemDownloadMgr");
                }
                return;
            }
            t0(j3, cVar);
        }
    }

    public boolean l0(String str) {
        Iterator<QavListItemBase.c> it = this.F.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().f75024a)) {
                return true;
            }
        }
        return false;
    }

    public void m0(RecyclerView.ViewHolder viewHolder, QavListItemBase.c cVar, int i3) {
        boolean z16;
        boolean z17;
        String q16 = this.D.q();
        if (!TextUtils.isEmpty(q16)) {
            String str = this.F.get(i3).f75024a;
            z16 = str.equals(q16);
            if (PatternUtils.NO_MATCH.equals(str) && "0".equals(q16)) {
                z16 = true;
            }
            if (z16) {
                this.I = i3;
            }
        } else {
            z16 = false;
        }
        QavListItemBase qavListItemBase = (QavListItemBase) viewHolder.itemView;
        if (this.K && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        qavListItemBase.b(i3, z17, false, cVar, this.P);
    }

    public void n0(RecyclerView.ViewHolder viewHolder, QavListItemBase.c cVar, int i3) {
        boolean z16;
        boolean z17 = false;
        if (!TextUtils.isEmpty(this.D.p())) {
            z16 = this.F.get(i3).f75024a.equals(this.D.p());
            if (z16) {
                this.I = i3;
            }
        } else {
            z16 = false;
        }
        QavListItemBase qavListItemBase = (QavListItemBase) viewHolder.itemView;
        if (this.K && z16) {
            z17 = true;
        }
        qavListItemBase.b(i3, z17, false, cVar, this.P);
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
        if (i3 == 2) {
            if (this.G == 1 && this.H) {
                A0((ArrayList) this.D.v());
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (this.G == 1) {
                notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i3 == 4) {
            if (this.G == 202) {
                notifyDataSetChanged();
            }
        } else if (i3 == 6) {
            if (this.G == 3) {
                notifyDataSetChanged();
            }
        } else if (i3 == 7) {
            if (this.G == 4) {
                notifyDataSetChanged();
            }
        } else if (i3 == 8 && this.G == 5) {
            notifyDataSetChanged();
        }
    }

    public void o0(RecyclerView.ViewHolder viewHolder, QavListItemBase.c cVar, int i3) {
        boolean z16;
        boolean z17 = false;
        if (!TextUtils.isEmpty(this.D.r())) {
            z16 = cVar.f75024a.equals(this.D.r());
            if (z16) {
                this.I = i3;
            }
        } else {
            z16 = false;
        }
        QavListItemBase qavListItemBase = (QavListItemBase) viewHolder.itemView;
        if (this.K && z16) {
            z17 = true;
        }
        qavListItemBase.b(i3, z17, false, cVar, this.P);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        QavListItemBase.c cVar = this.F.get(i3);
        if (cVar == null) {
            QLog.e("MaterialAdapter", 1, "onBindViewHolder: itemInfo == null");
            return;
        }
        int i16 = this.G;
        if (i16 != 1) {
            if (i16 != 202) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        if (i16 == 5) {
                            p0(viewHolder, cVar, i3);
                        }
                    } else {
                        q0(viewHolder, cVar, i3);
                    }
                } else {
                    m0(viewHolder, cVar, i3);
                }
            } else {
                n0(viewHolder, cVar, i3);
            }
        } else {
            o0(viewHolder, cVar, i3);
        }
        View view = viewHolder.itemView;
        if (view != null) {
            view.setContentDescription(cVar.f75034k);
            ViewCompat.setAccessibilityDelegate(viewHolder.itemView, new b(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QavListItemBase qavEffectMaterialItemView;
        WeakReference<Context> weakReference = this.f75534m;
        if (weakReference != null && weakReference.get() != null) {
            if (i3 == 1) {
                qavEffectMaterialItemView = new QavVoiceChangeMaterialItemView(this.f75534m.get());
                qavEffectMaterialItemView.e(0, 0);
            } else {
                qavEffectMaterialItemView = new QavEffectMaterialItemView(this.f75534m.get());
                qavEffectMaterialItemView.e(0, 0);
            }
            return new jw.a(qavEffectMaterialItemView);
        }
        return new jw.a(new View(viewGroup.getContext()));
    }

    public void onDestroy() {
        ArrayList<QavListItemBase.c> arrayList = this.F;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void p0(RecyclerView.ViewHolder viewHolder, QavListItemBase.c cVar, int i3) {
        boolean z16;
        boolean z17 = false;
        if (!TextUtils.isEmpty(this.D.s())) {
            z16 = this.F.get(i3).f75024a.equals(this.D.s());
            if (z16) {
                this.I = i3;
            }
        } else {
            z16 = false;
        }
        QavListItemBase qavListItemBase = (QavListItemBase) viewHolder.itemView;
        if (this.K && z16) {
            z17 = true;
        }
        qavListItemBase.b(i3, z17, false, cVar, this.P);
    }

    public void q0(RecyclerView.ViewHolder viewHolder, QavListItemBase.c cVar, int i3) {
        boolean z16;
        boolean z17 = false;
        if (!TextUtils.isEmpty(this.D.t())) {
            z16 = this.F.get(i3).f75024a.equals(this.D.t());
            if (z16) {
                this.I = i3;
            }
        } else {
            z16 = false;
        }
        QavListItemBase qavListItemBase = (QavListItemBase) viewHolder.itemView;
        if (this.K && z16) {
            z17 = true;
        }
        qavListItemBase.b(i3, z17, false, cVar, this.P);
    }

    public void r0(final long j3, final String str, final boolean z16) {
        this.E.post(new Runnable() { // from class: com.tencent.av.ui.effect.adapter.MaterialAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                QavListItemBase.c cVar;
                int i3;
                int findFirstVisibleItemPosition = ((GridLayoutManager) MaterialAdapter.this.E.getLayoutManager()).findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = ((GridLayoutManager) MaterialAdapter.this.E.getLayoutManager()).findLastVisibleItemPosition();
                int i16 = 0;
                while (true) {
                    if (i16 < MaterialAdapter.this.F.size()) {
                        QavListItemBase.c cVar2 = (QavListItemBase.c) MaterialAdapter.this.F.get(i16);
                        if (cVar2 != null && cVar2.f75024a.equals(str)) {
                            cVar2.f75028e = false;
                            cVar2.f75027d = z16;
                            if (i16 >= findFirstVisibleItemPosition && i16 <= findLastVisibleItemPosition) {
                                View childAt = MaterialAdapter.this.E.getChildAt(i16 - findFirstVisibleItemPosition);
                                if ((childAt instanceof QavListItemBase) && MaterialAdapter.this.E.getAdapter().equals(MaterialAdapter.this)) {
                                    QavListItemBase qavListItemBase = (QavListItemBase) childAt;
                                    if (z16) {
                                        i3 = 1000;
                                    } else {
                                        i3 = -1;
                                    }
                                    qavListItemBase.f(i3);
                                }
                            }
                        } else {
                            i16++;
                        }
                    } else {
                        i16 = -1;
                        break;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("MaterialAdapter", 2, "onDownloadFinish, seq[" + j3 + "], id[" + str + "], suc[" + z16 + "], sel[" + MaterialAdapter.this.I + "]");
                }
                if (z16) {
                    if (MaterialAdapter.this.I == i16 && i16 != -1) {
                        cVar = (QavListItemBase.c) MaterialAdapter.this.F.get(i16);
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        MaterialAdapter.this.t0(j3, cVar);
                    }
                }
            }
        });
    }

    @Override // com.tencent.av.ui.QavListItemBase.b
    public void s(long j3, String str, boolean z16) {
        r0(j3, str, z16);
    }

    public void s0(String str, int i3) {
        y0(str, i3);
    }

    void t0(long j3, QavListItemBase.c cVar) {
        if (this.M == null) {
            return;
        }
        if (TextUtils.isEmpty(cVar.f75024a) || cVar.f75024a.equals("0") || cVar.f75027d) {
            this.M.b(j3, cVar);
        }
    }

    public void u0(String str, int i3) {
        s0(str, i3);
    }

    public void v0(iw.a aVar) {
        this.M = aVar;
    }

    public void w0(iw.b bVar) {
        this.L = bVar;
    }

    public void x0(boolean z16) {
        this.K = z16;
    }

    public void y0(final String str, final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.effect.adapter.MaterialAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                MaterialAdapter.this.z0(str, i3);
            }
        });
    }

    void z0(String str, int i3) {
        QavListItemBase.c cVar;
        QavListItemBase qavListItemBase;
        int findFirstVisibleItemPosition = ((GridLayoutManager) this.E.getLayoutManager()).findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = ((GridLayoutManager) this.E.getLayoutManager()).findLastVisibleItemPosition();
        int i16 = findFirstVisibleItemPosition;
        while (true) {
            cVar = null;
            r3 = null;
            QavListItemBase qavListItemBase2 = null;
            if (i16 > findLastVisibleItemPosition) {
                break;
            }
            if (i16 >= 0) {
                if (i16 >= this.F.size()) {
                    break;
                }
                QavListItemBase.c cVar2 = this.F.get(i16);
                if (cVar2 != null && cVar2.f75024a.equals(str)) {
                    View childAt = this.E.getChildAt(i16 - findFirstVisibleItemPosition);
                    if ((childAt instanceof QavListItemBase) && this.E.getAdapter().equals(this)) {
                        qavListItemBase2 = (QavListItemBase) childAt;
                    }
                    qavListItemBase = qavListItemBase2;
                    cVar = cVar2;
                }
            }
            i16++;
        }
        qavListItemBase = null;
        if (cVar == null && i3 == 101) {
            int size = this.F.size();
            int i17 = 0;
            while (true) {
                if (i17 >= findFirstVisibleItemPosition || i17 >= size) {
                    break;
                }
                QavListItemBase.c cVar3 = this.F.get(i17);
                if (cVar3 != null && cVar3.f75024a.equals(str)) {
                    i16 = i17;
                    cVar = cVar3;
                    break;
                }
                i17++;
            }
            if (cVar == null) {
                int i18 = findLastVisibleItemPosition + 1;
                while (true) {
                    if (i18 < size) {
                        QavListItemBase.c cVar4 = this.F.get(i18);
                        if (cVar4 != null && cVar4.f75024a.equals(str)) {
                            cVar = cVar4;
                            i16 = i18;
                            break;
                        }
                        i18++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (cVar != null) {
            if (QLog.isColorLevel()) {
                QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", Integer.valueOf(i16), cVar.f75024a, cVar.f75026c, Integer.valueOf(i3)));
            }
            if (i3 == -1) {
                cVar.f75028e = false;
            } else if (i3 == 101) {
                cVar.f75028e = false;
                cVar.f75027d = true;
            } else {
                if (i3 == 100) {
                    i3 = 99;
                }
                cVar.f75028e = true;
            }
            if (qavListItemBase != null) {
                qavListItemBase.f(i3);
            }
        }
    }
}
