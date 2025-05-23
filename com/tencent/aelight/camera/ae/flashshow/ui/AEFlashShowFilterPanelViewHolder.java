package com.tencent.aelight.camera.ae.flashshow.ui;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ui.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResManager;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.wink.view.WinkMaterialPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.List;

/* loaded from: classes32.dex */
public class AEFlashShowFilterPanelViewHolder extends com.tencent.aelight.camera.ae.camera.ui.a implements StartPointSeekBar.a, ApplyMaterialTask {
    private StartPointSeekBar C;
    private TextView D;
    private ViewGroup E;
    private LinearLayout F;
    private Handler G;
    private lq.b H;
    private com.tencent.aelight.camera.ae.flashshow.ui.e I;

    /* renamed from: h, reason: collision with root package name */
    private boolean f64513h;

    /* renamed from: i, reason: collision with root package name */
    private WinkMaterialPanel f64514i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.filter.e f64515m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements Observer<e.d> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(e.d dVar) {
            String str;
            AEFlashShowFilterPanelViewHolder.this.E(dVar.f64903b, dVar.f64902a);
            MetaMaterial value = AEFlashShowFilterPanelViewHolder.this.I.U1().getValue();
            if (value == null || (str = value.f30533id) == null || "".equals(str)) {
                return;
            }
            AEFlashShowFilterPanelViewHolder.this.E.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements Observer<MetaMaterial> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(MetaMaterial metaMaterial) {
            AEFlashShowFilterPanelViewHolder.this.I.P1(metaMaterial);
            AEFlashShowFilterPanelViewHolder.this.f64514i.o(metaMaterial);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<e.c> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(e.c cVar) {
            AEFlashShowFilterPanelViewHolder.this.F(cVar.f64899a, cVar.f64900b);
        }
    }

    public AEFlashShowFilterPanelViewHolder(ViewStub viewStub) {
        super(viewStub);
        this.f64513h = false;
        this.G = new Handler();
        this.f64513h = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101760", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f64514i.setClearButtonEnable(false);
        this.E.setVisibility(4);
        this.f64515m.a0(-1);
        this.I.b2(-1, new MetaMaterial());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
        if (x(metaMaterial) == null) {
            aVar.a(ApplyMaterialTask.Status.FAILED, -1);
        } else {
            w(metaMaterial, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(final List<MetaCategory> list, final List<MetaMaterial> list2) {
        this.G.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowFilterPanelViewHolder.5
            @Override // java.lang.Runnable
            public void run() {
                AEFlashShowFilterPanelViewHolder.this.f64514i.setup(AEFlashShowFilterPanelViewHolder.this.f64515m, list, list2);
                ay ayVar = (ay) com.tencent.aelight.camera.ae.control.a.b(4);
                if (ayVar.d() != null) {
                    AEFlashShowFilterPanelViewHolder.this.f64515m.Q(ayVar.d().getId());
                }
            }
        });
    }

    private void w(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
        String str = metaMaterial.f30533id;
        com.tencent.mobileqq.wink.flow.c.c("downloadLutResource", metaMaterial, "lutId = " + str);
        if (TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.wink.editor.filter.f.y(metaMaterial, true);
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            return;
        }
        String x16 = x(metaMaterial);
        com.tencent.mobileqq.wink.flow.c.c("downloadLutResource", metaMaterial, "lutPath = " + x16);
        if (!TextUtils.isEmpty(x16) && new File(x16).exists()) {
            com.tencent.mobileqq.wink.editor.filter.f.y(metaMaterial, true);
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        } else if (this.f64513h) {
            WinkEditorResManager.q().n(str, new d(metaMaterial, aVar));
        } else {
            WinkEditorResourceManager.a1().i(str, new e(metaMaterial, aVar));
        }
    }

    private String x(MetaMaterial metaMaterial) {
        String k3 = com.tencent.mobileqq.wink.editor.filter.f.k(metaMaterial);
        if (TextUtils.isEmpty(k3)) {
            if (this.f64513h) {
                k3 = WinkEditorResManager.q().o(metaMaterial) + File.separator + com.tencent.mobileqq.wink.editor.filter.f.l(metaMaterial) + ".png";
            } else {
                k3 = WinkEditorResourceManager.a1().m(metaMaterial) + File.separator + com.tencent.mobileqq.wink.editor.filter.f.l(metaMaterial) + ".png";
            }
            com.tencent.mobileqq.wink.editor.filter.f.B(metaMaterial, k3);
        }
        return k3;
    }

    public void A() {
        LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) this.H.b(65537, new Object[0]);
        if (lSMiddleCameraUnit == null) {
            return;
        }
        com.tencent.aelight.camera.ae.flashshow.ui.e eVar = (com.tencent.aelight.camera.ae.flashshow.ui.e) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(com.tencent.aelight.camera.ae.flashshow.ui.e.class);
        this.I = eVar;
        eVar.T1().observe(lSMiddleCameraUnit, new a());
        this.I.U1().observe(lSMiddleCameraUnit, new b());
        this.I.Q1().observe(lSMiddleCameraUnit, new c());
        this.I.Z1(Boolean.TRUE);
    }

    public void D(LSCaptureController lSCaptureController, final lq.b bVar) {
        m(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowFilterPanelViewHolder.1
            @Override // java.lang.Runnable
            public void run() {
                AEFlashShowFilterPanelViewHolder.this.H = bVar;
                AEFlashShowFilterPanelViewHolder.this.A();
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void F1(ApplyMaterialTask.Status status, int i3, final MetaMaterial metaMaterial, final ApplyMaterialTask.a aVar) {
        if (com.tencent.mobileqq.wink.editor.filter.f.q(metaMaterial)) {
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        } else if (com.tencent.mobileqq.wink.editor.filter.f.p(metaMaterial)) {
            w(metaMaterial, aVar);
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ba
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowFilterPanelViewHolder.this.C(metaMaterial, aVar);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void Q(int i3, MetaMaterial metaMaterial) {
        this.f64515m.a0(i3);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public boolean d0(int i3, MetaMaterial metaMaterial) {
        return com.tencent.mobileqq.wink.flow.c.a(metaMaterial);
    }

    public void f() {
        if (k()) {
            this.F.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void g(int i3, MetaMaterial metaMaterial) {
        com.tencent.aelight.camera.ae.report.b.b().W(metaMaterial.f30533id, this.I.S1(metaMaterial).f64902a);
        this.f64514i.setClearButtonEnable(true);
        this.I.b2(i3, metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void p3(int i3, MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
        com.tencent.mobileqq.wink.flow.c.f(aVar);
    }

    public void show() {
        i();
        this.F.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
    public void uc(StartPointSeekBar startPointSeekBar) {
        MetaMaterial value = this.I.U1().getValue();
        if (value != null) {
            com.tencent.aelight.camera.ae.report.b.b().W(value.f30533id, this.I.S1(value).f64902a);
        }
    }

    @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
    public void wd(StartPointSeekBar startPointSeekBar, int i3) {
        this.I.a2(i3);
        StartPointSeekBar.u(this.C, i3, this.D);
        LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) this.H.b(65537, new Object[0]);
        if (lSMiddleCameraUnit != null) {
            lSMiddleCameraUnit.Q2(1, null, i3, false);
        }
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public boolean z(int i3, MetaMaterial metaMaterial) {
        String O0;
        if (this.f64513h) {
            O0 = WinkEditorResManager.q().p(metaMaterial);
        } else {
            O0 = WinkEditorResourceManager.a1().O0(metaMaterial);
        }
        return com.tencent.mobileqq.wink.flow.c.b(metaMaterial) && !TextUtils.isEmpty(O0) && new File(O0).exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f64522a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ApplyMaterialTask.a f64523b;

        d(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
            this.f64522a = metaMaterial;
            this.f64523b = aVar;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int i3) {
            this.f64523b.a(ApplyMaterialTask.Status.ONGOING, i3);
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean z16) {
            if (z16) {
                com.tencent.mobileqq.wink.editor.filter.f.y(this.f64522a, true);
                this.f64523b.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            } else {
                this.f64523b.a(ApplyMaterialTask.Status.FAILED, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f64525a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ApplyMaterialTask.a f64526b;

        e(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
            this.f64525a = metaMaterial;
            this.f64526b = aVar;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            this.f64526b.a(ApplyMaterialTask.Status.ONGOING, i3);
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            if (z16) {
                com.tencent.mobileqq.wink.editor.filter.f.y(this.f64525a, true);
                this.f64526b.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            } else {
                this.f64526b.a(ApplyMaterialTask.Status.FAILED, -1);
            }
        }
    }

    private void y(View view) {
        this.E = (ViewGroup) view.findViewById(R.id.f81804f6);
        this.D = (TextView) view.findViewById(R.id.f10506650);
        StartPointSeekBar startPointSeekBar = (StartPointSeekBar) view.findViewById(R.id.f87684v1);
        this.C = startPointSeekBar;
        startPointSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.a
    protected void l(View view) {
        this.F = (LinearLayout) view.findViewById(R.id.v95);
        WinkMaterialPanel winkMaterialPanel = (WinkMaterialPanel) view.findViewById(R.id.yy7);
        this.f64514i = winkMaterialPanel;
        winkMaterialPanel.setOnClearButtonClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.az
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AEFlashShowFilterPanelViewHolder.this.B(view2);
            }
        });
        com.tencent.mobileqq.wink.editor.filter.e eVar = new com.tencent.mobileqq.wink.editor.filter.e(j().getContext(), null);
        this.f64515m = eVar;
        eVar.U(true);
        this.f64515m.S(this);
        y(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i3, int i16) {
        if (i16 > 100 || i16 < 0) {
            return;
        }
        this.C.setAbsoluteMinMaxValue(0.0d, 100.0d);
        this.C.setDefaultValue(i3);
        this.C.setSectionEnable(i3 < 100 && i3 > 0);
        this.C.setProgress(i16);
        LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) this.H.b(65537, new Object[0]);
        if (lSMiddleCameraUnit != null) {
            lSMiddleCameraUnit.Q2(1, null, i16, false);
        }
        StartPointSeekBar.u(this.C, i16, this.D);
    }

    @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
    public void Fd(StartPointSeekBar startPointSeekBar) {
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void Y(int i3, MetaMaterial metaMaterial) {
    }
}
