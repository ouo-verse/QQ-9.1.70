package com.tencent.mobileqq.wink.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ds;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NotifyDataSetChanged"})
/* loaded from: classes21.dex */
public abstract class AbsWinkMaterialPanelContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected WinkEditorViewModel.EditMode F;
    protected ApplyMaterialTask G;
    protected d H;
    protected e I;
    private QQToast.IToastValidListener J;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    protected RecyclerView f326742d;

    /* renamed from: f, reason: collision with root package name */
    private List<MetaMaterial> f326744f;

    /* renamed from: m, reason: collision with root package name */
    private int f326747m;

    /* renamed from: h, reason: collision with root package name */
    protected int f326745h = -1;

    /* renamed from: i, reason: collision with root package name */
    protected int f326746i = -1;
    private boolean C = false;
    protected boolean D = false;
    private boolean E = false;
    private boolean K = true;

    /* renamed from: e, reason: collision with root package name */
    private List<MetaMaterial> f326743e = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f326763a;

        static {
            int[] iArr = new int[ApplyMaterialTask.Status.values().length];
            f326763a = iArr;
            try {
                iArr[ApplyMaterialTask.Status.SUCCEEDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f326763a[ApplyMaterialTask.Status.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f326763a[ApplyMaterialTask.Status.ONGOING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes21.dex */
    public interface c {
        void b(int i3, @Nullable MetaMaterial metaMaterial);
    }

    /* loaded from: classes21.dex */
    public interface d extends c {
        void a(int i3, @Nullable MetaMaterial metaMaterial);
    }

    /* loaded from: classes21.dex */
    public interface e {
        void a(int i3, @Nullable MetaMaterial metaMaterial);
    }

    public AbsWinkMaterialPanelContentAdapter(@NonNull Context context, WinkEditorViewModel.EditMode editMode) {
        this.F = editMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(final MetaMaterial metaMaterial, final int i3, final int i16, ApplyMaterialTask.Status status, int i17) {
        com.tencent.mobileqq.wink.flow.c.c("onDownloadMaterial", metaMaterial, String.format("callback: %s-%s", status, Integer.valueOf(i17)));
        int i18 = b.f326763a[status.ordinal()];
        if (i18 != 1) {
            if (i18 != 2) {
                if (i18 == 3) {
                    com.tencent.mobileqq.wink.editor.c.s1(metaMaterial, (int) (i17 * 0.6d));
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AbsWinkMaterialPanelContentAdapter.this.notifyItemChanged(i3, 1);
                        }
                    });
                    return;
                }
                return;
            }
            X(i3, metaMaterial);
            L(ApplyMaterialTask.Status.FAILED, i16, i3, metaMaterial);
            M(metaMaterial, QQWinkConstants.CostCode.RESULT_FAIL);
            return;
        }
        M(metaMaterial, "0");
        j73.a.f409615a.b(metaMaterial, new ResDownLoadListener() { // from class: com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.3
            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onDownloadFinish(boolean z16) {
                if (!z16) {
                    AbsWinkMaterialPanelContentAdapter.this.X(i3, metaMaterial);
                    AbsWinkMaterialPanelContentAdapter.this.L(ApplyMaterialTask.Status.FAILED, i16, i3, metaMaterial);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            AbsWinkMaterialPanelContentAdapter.this.notifyItemChanged(i3, 40);
                        }
                    });
                    com.tencent.mobileqq.wink.editor.c.s1(metaMaterial, 100);
                    AbsWinkMaterialPanelContentAdapter.this.L(ApplyMaterialTask.Status.SUCCEEDED, i16, i3, metaMaterial);
                }
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onProgressUpdate(int i19) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(final MetaMaterial metaMaterial, final int i3, final int i16, ApplyMaterialTask.Status status, int i17) {
        if (i17 % 20 == 0) {
            com.tencent.mobileqq.wink.flow.c.c("onPreExecute", metaMaterial, String.format("callback: %s-%s", status, Integer.valueOf(i17)));
        }
        ApplyMaterialTask.Status status2 = ApplyMaterialTask.Status.SUCCEEDED;
        if (status == status2) {
            boolean d06 = this.G.d0(i3, metaMaterial);
            com.tencent.mobileqq.wink.flow.c.c("isApplyMaterialLocal", metaMaterial, String.valueOf(d06));
            if (d06) {
                boolean z16 = this.G.z(i3, metaMaterial);
                com.tencent.mobileqq.wink.flow.c.c("isMaterialReady", metaMaterial, String.valueOf(z16));
                if (!z16 && com.tencent.mobileqq.wink.editor.c.x(metaMaterial) != 100) {
                    if (com.tencent.mobileqq.wink.editor.c.x(metaMaterial) < 0) {
                        this.G.Y(i3, metaMaterial);
                        com.tencent.mobileqq.wink.flow.c.c("onDownloadMaterial", metaMaterial, "start");
                        com.tencent.mobileqq.wink.flow.c.d(metaMaterial, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.wink.view.e
                            @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask.a
                            public final void a(ApplyMaterialTask.Status status3, int i18) {
                                AbsWinkMaterialPanelContentAdapter.this.G(metaMaterial, i3, i16, status3, i18);
                            }
                        });
                        return;
                    }
                    com.tencent.mobileqq.wink.flow.c.c("executeApplyMaterialTask", metaMaterial, String.format("run into wrong branch: isMaterialReady=%s, downloadProgress=%s", Boolean.valueOf(this.G.z(i3, metaMaterial)), Integer.valueOf(com.tencent.mobileqq.wink.editor.c.x(metaMaterial))));
                    return;
                }
                L(status2, i16, i3, metaMaterial);
                return;
            }
            com.tencent.mobileqq.wink.flow.c.c("onApplyMaterialOnline", metaMaterial, "start");
            this.G.Q(i3, metaMaterial);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(final MetaMaterial metaMaterial, final ApplyMaterialTask.Status status, final int i3, final int i16, final ApplyMaterialTask.Status status2, int i17) {
        if (i17 % 20 == 0) {
            com.tencent.mobileqq.wink.flow.c.c("onPostDownloadMaterial", metaMaterial, String.format("callback: %s-%s", status2, Integer.valueOf(i17)));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                if (status == ApplyMaterialTask.Status.FAILED) {
                    AbsWinkMaterialPanelContentAdapter.this.X(i3, metaMaterial);
                    return;
                }
                int i18 = b.f326763a[status2.ordinal()];
                if (i18 != 1) {
                    if (i18 == 2) {
                        AbsWinkMaterialPanelContentAdapter.this.X(i3, metaMaterial);
                    }
                } else if (AbsWinkMaterialPanelContentAdapter.this.f326747m == i16) {
                    com.tencent.mobileqq.wink.flow.c.c("onApplyMaterialLocal", metaMaterial, "start");
                    AbsWinkMaterialPanelContentAdapter.this.b0(i3, true);
                    AbsWinkMaterialPanelContentAdapter.this.G.g(i3, metaMaterial);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(int i3) {
        if (this.J != null) {
            QQToast.makeText(RFWApplication.getApplication(), R.string.ynb, 1).showByQueue(this.J);
        } else {
            QQToast.makeText(RFWApplication.getApplication(), R.string.ynb, 1).show();
        }
        notifyItemChanged(i3, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(int i3, int i16, boolean z16) {
        RecyclerView recyclerView = this.f326742d;
        if (recyclerView == null || i3 == i16) {
            return;
        }
        if (((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation() == 0) {
            com.tencent.mobileqq.wink.utils.b.f(this.f326742d, i3, i16, z16, false);
        } else {
            com.tencent.mobileqq.wink.utils.b.i(this.f326742d, i3, i16, z16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final ApplyMaterialTask.Status status, final int i3, final int i16, final MetaMaterial metaMaterial) {
        com.tencent.mobileqq.wink.flow.c.c("onPostDownloadMaterial", metaMaterial, "start");
        this.G.F1(status, i16, metaMaterial, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.wink.view.d
            @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask.a
            public final void a(ApplyMaterialTask.Status status2, int i17) {
                AbsWinkMaterialPanelContentAdapter.this.I(metaMaterial, status, i16, i3, status2, i17);
            }
        });
    }

    private void M(MetaMaterial metaMaterial, String str) {
        if (metaMaterial != null) {
            long c16 = y53.e.d().c(metaMaterial.f30533id);
            z93.c f16 = Wink.INSTANCE.f();
            if (c16 > 0 && f16 != null) {
                WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
                builder.eventId("P_MATERIAL_DOWNLOAD_FINISH").ext1(metaMaterial.f30533id).ext3(String.valueOf(c16)).retCode(str);
                f16.a(builder.getReportData(), 1);
                return;
            }
            w53.b.f("AbsWinkMaterialPanelContentAdapter", "reportMaterialDownloadCost time < 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(final int i3, MetaMaterial metaMaterial) {
        com.tencent.mobileqq.wink.editor.c.s1(metaMaterial, -1);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.a
            @Override // java.lang.Runnable
            public final void run() {
                AbsWinkMaterialPanelContentAdapter.this.J(i3);
            }
        });
    }

    private void z(final int i3, final int i16, final MetaMaterial metaMaterial) {
        if (this.G == null) {
            return;
        }
        com.tencent.mobileqq.wink.flow.c.c("onPreExecute", metaMaterial, "start");
        if (metaMaterial != null) {
            y53.e.d().f(metaMaterial.f30533id);
            this.G.p3(i3, metaMaterial, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.wink.view.c
                @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask.a
                public final void a(ApplyMaterialTask.Status status, int i17) {
                    AbsWinkMaterialPanelContentAdapter.this.H(metaMaterial, i3, i16, status, i17);
                }
            });
        } else {
            w53.b.c("AbsWinkMaterialPanelContentAdapter", "executeApplyMaterialTask: null material");
        }
    }

    public MetaMaterial A(String str) {
        if (!TextUtils.isEmpty(str) && this.f326743e != null) {
            for (int i3 = 0; i3 < this.f326743e.size(); i3++) {
                if (this.f326743e.get(i3) != null && str.equals(this.f326743e.get(i3).f30533id)) {
                    return this.f326743e.get(i3);
                }
            }
        }
        return null;
    }

    public List<MetaMaterial> B() {
        return this.f326743e;
    }

    public int C(String str) {
        if (str != null && this.f326743e != null) {
            for (int i3 = 0; i3 < this.f326743e.size(); i3++) {
                if (this.f326743e.get(i3) != null && str.equals(this.f326743e.get(i3).f30533id)) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    public int D() {
        return this.f326745h;
    }

    public MetaMaterial E() {
        int i3;
        List<MetaMaterial> list = this.f326743e;
        if (list != null && (i3 = this.f326745h) >= 0 && i3 < list.size()) {
            return this.f326743e.get(this.f326745h);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(int i3, @Nullable MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return;
        }
        if (!y(i3, metaMaterial) && i3 == this.f326745h && !this.C) {
            return;
        }
        e eVar = this.I;
        if (eVar != null) {
            eVar.a(i3, metaMaterial);
        }
        this.C = false;
        int c16 = ds.c();
        this.f326747m = c16;
        this.f326746i = i3;
        if (!WinkEditorResourceManager.a1().q(metaMaterial)) {
            com.tencent.mobileqq.wink.editor.c.s1(metaMaterial, -1);
            z(i3, c16, metaMaterial);
        } else if (!this.G.d0(i3, metaMaterial)) {
            this.G.Q(i3, metaMaterial);
        } else {
            j73.a.f409615a.b(metaMaterial, new a(metaMaterial, c16, i3));
        }
    }

    public void N(MetaMaterial metaMaterial) {
        com.tencent.mobileqq.wink.utils.b.f(this.f326742d, this.f326745h, com.tencent.mobileqq.wink.editor.c.g(this.f326743e, metaMaterial), false, false);
    }

    public void O(String str) {
        com.tencent.mobileqq.wink.utils.b.i(this.f326742d, this.f326745h, com.tencent.mobileqq.wink.editor.c.h(this.f326743e, str), false, false);
    }

    public void P(int i3, @Nullable MetaMaterial metaMaterial) {
        F(i3, metaMaterial);
    }

    public boolean Q(String str) {
        List<MetaMaterial> list;
        w53.b.a("AbsWinkMaterialPanelContentAdapter", String.format("select material id: %s", str));
        if (!TextUtils.isEmpty(str) && this.f326743e != null) {
            if (A(str) == null && (list = this.f326744f) != null) {
                for (MetaMaterial metaMaterial : list) {
                    if (metaMaterial.f30533id.equals(str)) {
                        w53.b.f("AbsWinkMaterialPanelContentAdapter", "add mUnCategorizedMaterial " + str);
                        this.f326743e.add(0, metaMaterial);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f326743e.size(); i3++) {
                if (this.f326743e.get(i3) != null && str.equals(this.f326743e.get(i3).f30533id)) {
                    P(i3, this.f326743e.get(i3));
                    return true;
                }
            }
        }
        return false;
    }

    public void R(int i3) {
        this.f326745h = i3;
        notifyDataSetChanged();
    }

    public void S(ApplyMaterialTask applyMaterialTask) {
        this.G = applyMaterialTask;
    }

    public void T(boolean z16) {
        this.D = z16;
    }

    public void U(boolean z16) {
        this.E = z16;
    }

    public void V(d dVar) {
        this.H = dVar;
    }

    public void W(e eVar) {
        this.I = eVar;
    }

    public final void Y(List<MetaMaterial> list) {
        int size;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setMaterials size: ");
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        w53.b.a("AbsWinkMaterialPanelContentAdapter", sb5.toString());
        this.f326743e = list;
    }

    public void Z(boolean z16) {
        this.K = z16;
    }

    public void a0(int i3) {
        b0(i3, false);
    }

    public void b0(int i3, boolean z16) {
        c0(i3, z16, this.K);
    }

    public void c0(final int i3, final boolean z16, boolean z17) {
        RecyclerView recyclerView;
        if (QLog.isColorLevel()) {
            QLog.i("AbsWinkMaterialPanelContentAdapter", 2, getClass().getSimpleName() + " setSelectedIndex:" + i3);
        }
        final int i16 = this.f326745h;
        this.f326745h = i3;
        notifyDataSetChanged();
        if (z17 && i3 >= 0 && (recyclerView = this.f326742d) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.f326742d.post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    AbsWinkMaterialPanelContentAdapter.this.K(i16, i3, z16);
                }
            });
        }
    }

    public boolean d0(String str, boolean z16) {
        if (!TextUtils.isEmpty(str) && this.f326743e != null) {
            for (int i3 = 0; i3 < this.f326743e.size(); i3++) {
                if (this.f326743e.get(i3) != null && str.equals(this.f326743e.get(i3).f30533id)) {
                    b0(i3, z16);
                    return true;
                }
            }
        }
        return false;
    }

    public void e0(MetaMaterial metaMaterial) {
        this.f326745h = com.tencent.mobileqq.wink.editor.c.g(this.f326743e, metaMaterial);
        notifyDataSetChanged();
    }

    public void f0(QQToast.IToastValidListener iToastValidListener) {
        this.J = iToastValidListener;
    }

    public void g0(WinkEditorViewModel.EditMode editMode) {
        if (this.F == editMode) {
            return;
        }
        this.F = editMode;
        this.f326745h = -1;
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MetaMaterial> list = this.f326743e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void i0(List<MetaMaterial> list, List<MetaMaterial> list2) {
        this.f326743e = list;
        this.f326744f = list2;
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f326742d = recyclerView;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.f326743e.size() <= i3) {
            x(viewHolder, i3, com.tencent.mobileqq.wink.editor.c.f1());
        } else {
            MetaMaterial metaMaterial = this.f326743e.get(i3);
            x(viewHolder, i3, metaMaterial);
            d dVar = this.H;
            if (dVar != null) {
                dVar.a(i3, metaMaterial);
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f326742d = null;
    }

    protected abstract <T extends RecyclerView.ViewHolder> void x(T t16, int i3, @NonNull MetaMaterial metaMaterial);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y(int i3, MetaMaterial metaMaterial) {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f326759a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f326760b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f326761c;

        a(MetaMaterial metaMaterial, int i3, int i16) {
            this.f326759a = metaMaterial;
            this.f326760b = i3;
            this.f326761c = i16;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean z16) {
            if (!z16) {
                AbsWinkMaterialPanelContentAdapter.this.X(this.f326761c, this.f326759a);
                AbsWinkMaterialPanelContentAdapter.this.L(ApplyMaterialTask.Status.FAILED, this.f326760b, this.f326761c, this.f326759a);
            } else {
                com.tencent.mobileqq.wink.editor.c.s1(this.f326759a, 100);
                AbsWinkMaterialPanelContentAdapter.this.L(ApplyMaterialTask.Status.SUCCEEDED, this.f326760b, this.f326761c, this.f326759a);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int i3) {
        }
    }
}
