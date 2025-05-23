package com.tencent.mobileqq.wink.editor.filter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.edit.bean.AEFilterExtendBean;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterMenuPart;
import com.tencent.mobileqq.wink.editor.filter.ak;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.view.WinkFilterApplyTipView;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.wink.view.WinkMaterialPanel;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.tav.player.PlayerDefaultConfigs;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.utils.LiveDataExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.light.AudioOutputConfig;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.VideoOutputConfig;
import org.light.lightAssetKit.Entity;

/* loaded from: classes21.dex */
public class WinkEditorFilterMenuPart extends WinkEditorMenuPart implements ApplyMaterialTask {
    private WinkMaterialPanel M;
    private com.tencent.mobileqq.wink.editor.filter.e N;
    private View P;
    private StartPointSeekBar Q;
    private TextView R;
    private MetaMaterial S;
    private WinkFilterApplyTipView T;
    private MetaMaterial U;
    private af V;
    private WinkEditorSmartFilterViewModel W;
    private String X;
    private MetaMaterial Y;
    private MetaMaterial Z;

    /* renamed from: a0, reason: collision with root package name */
    private p f320311a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f320312b0;

    /* renamed from: c0, reason: collision with root package name */
    private RecyclerView f320313c0;

    /* renamed from: d0, reason: collision with root package name */
    private ak f320314d0;

    /* renamed from: e0, reason: collision with root package name */
    private QUIButton f320315e0;

    /* renamed from: f0, reason: collision with root package name */
    private QUIButton f320316f0;

    /* renamed from: g0, reason: collision with root package name */
    private final List<Runnable> f320317g0 = new ArrayList();

    /* renamed from: h0, reason: collision with root package name */
    private boolean f320318h0 = true;

    /* renamed from: i0, reason: collision with root package name */
    private int f320319i0 = 4;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f320320j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    private IPlayer.PlayerListener f320321k0 = new b();

    /* renamed from: l0, reason: collision with root package name */
    private WinkImageTavCut.b f320322l0 = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterMenuPart$5, reason: invalid class name */
    /* loaded from: classes21.dex */
    public class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(dr.WinkTavCutParams winkTavCutParams) {
            boolean z16;
            WinkEditorFilterMenuPart winkEditorFilterMenuPart = WinkEditorFilterMenuPart.this;
            if (winkTavCutParams.getEditMode() == WinkEditorViewModel.EditMode.Image) {
                z16 = true;
            } else {
                z16 = false;
            }
            winkEditorFilterMenuPart.Db(z16);
        }

        @Override // java.lang.Runnable
        public void run() {
            WinkEditorFilterMenuPart.this.winkEditorViewModel.p3().observe(WinkEditorFilterMenuPart.this.getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.filter.ae
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorFilterMenuPart.AnonymousClass5.this.b((dr.WinkTavCutParams) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private MetaMaterial f320323d;

        a() {
            this.f320323d = WinkEditorFilterMenuPart.this.U;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            WinkEditorFilterMenuPart.this.f320311a0.g();
            WinkEditorFilterMenuPart.this.W.v2();
            if (WinkEditorFilterMenuPart.this.N != null) {
                WinkEditorFilterMenuPart.this.N.s0();
            }
            WinkEditorFilterMenuPart.this.cc(this.f320323d, false);
            if (WinkEditorFilterMenuPart.this.N != null && this.f320323d != null) {
                WinkEditorFilterMenuPart.this.N.P(com.tencent.mobileqq.wink.editor.c.K(this.f320323d), this.f320323d);
            } else {
                WinkEditorFilterMenuPart winkEditorFilterMenuPart = WinkEditorFilterMenuPart.this;
                winkEditorFilterMenuPart.xb(winkEditorFilterMenuPart.H9());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                com.tencent.mobileqq.wink.report.e.f326265a.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == WinkEditorFilterMenuPart.this.f320315e0.getId() && WinkEditorFilterMenuPart.this.V.getFilterRangeMode() != 100) {
                WinkEditorFilterMenuPart.this.rc(100, true);
                if (WinkEditorFilterMenuPart.this.H9() != null) {
                    WinkEditorFilterMenuPart.this.H9().play();
                }
                WinkEditorFilterMenuPart winkEditorFilterMenuPart = WinkEditorFilterMenuPart.this;
                winkEditorFilterMenuPart.tc(winkEditorFilterMenuPart.U);
                WinkEditorFilterMenuPart.this.qc(null, true, false);
                WinkEditorFilterMenuPart.this.N.u0();
                WinkEditorFilterMenuPart.this.H9().i0(WinkEditorFilterMenuPart.this.V.S1(), WinkEditorFilterMenuPart.this.U, false);
            } else if (view.getId() == WinkEditorFilterMenuPart.this.f320316f0.getId() && WinkEditorFilterMenuPart.this.V.getFilterRangeMode() != 101) {
                WinkEditorFilterMenuPart.this.N.u0();
                WinkEditorFilterMenuPart.this.bc();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes21.dex */
    class f implements WinkImageTavCut.b {
        f() {
        }

        @Override // com.tencent.mobileqq.wink.editor.WinkImageTavCut.b
        public void a(int i3) {
            dr H9 = WinkEditorFilterMenuPart.this.H9();
            if (H9 != null && (H9 instanceof WinkImageTavCut)) {
                WinkEditorFilterMenuPart.this.Ib(H9, false);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.WinkImageTavCut.b
        public boolean b() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class h implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f320332a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ApplyMaterialTask.a f320333b;

        h(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
            this.f320332a = metaMaterial;
            this.f320333b = aVar;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            if (z16) {
                com.tencent.mobileqq.wink.editor.filter.f.y(this.f320332a, true);
                this.f320333b.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            } else {
                this.f320333b.a(ApplyMaterialTask.Status.FAILED, -1);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            this.f320333b.a(ApplyMaterialTask.Status.ONGOING, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class i implements ak.b {
        i() {
        }

        @Override // com.tencent.mobileqq.wink.editor.filter.ak.b
        public void a(@NonNull an anVar) {
            WinkEditorFilterMenuPart winkEditorFilterMenuPart = WinkEditorFilterMenuPart.this;
            winkEditorFilterMenuPart.ic(winkEditorFilterMenuPart.f320313c0, WinkEditorFilterMenuPart.this.f320314d0.l0(anVar));
            WinkEditorFilterMenuPart.this.V.b2(anVar);
            if (WinkEditorFilterMenuPart.this.V.getFilterRangeMode() == 101) {
                MetaMaterial A = WinkEditorFilterMenuPart.this.N.A(anVar.getFilterId());
                WinkEditorFilterMenuPart winkEditorFilterMenuPart2 = WinkEditorFilterMenuPart.this;
                winkEditorFilterMenuPart2.dc(A, winkEditorFilterMenuPart2.Bb(anVar.getId()));
            }
            if (WinkEditorFilterMenuPart.this.H9() != null) {
                WinkEditorFilterMenuPart.this.H9().seek(anVar.getStartTime() + 100);
                WinkEditorFilterMenuPart.this.H9().play();
            }
        }
    }

    private void Ab() {
        LiveDataExtKt.a(this.winkEditorViewModel.Q2(), getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.filter.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFilterMenuPart.this.Mb((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FilterModel Bb(String str) {
        if (H9() == null) {
            return null;
        }
        for (MediaClip mediaClip : H9().a0()) {
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null && str != null && str.equals(resourceModel.id)) {
                return mediaClip.filter;
            }
        }
        return null;
    }

    private MetaMaterial Cb() {
        if (H9() instanceof WinkImageTavCut) {
            return this.Z;
        }
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Db(final boolean z16) {
        aa().getFilterMaterialVOLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.filter.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFilterMenuPart.this.Nb(z16, (com.tencent.mobileqq.wink.editor.model.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WinkFilterUIData Eb() {
        if (C9() != null && (C9() instanceof WinkFilterUIData)) {
            return (WinkFilterUIData) C9();
        }
        return null;
    }

    private p Fb() {
        if (this.f320311a0 == null) {
            p pVar = new p(getActivity());
            this.f320311a0 = pVar;
            pVar.l(new a());
        }
        return this.f320311a0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.wink.editor.filter.h Gb() {
        MetaMaterial Cb = Cb();
        if (Cb != null && com.tencent.mobileqq.wink.editor.filter.f.r(Cb)) {
            return this.W;
        }
        return this.V;
    }

    private com.tencent.mobileqq.wink.editor.filter.h Hb(MetaMaterial metaMaterial) {
        if (metaMaterial != null && com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial)) {
            return this.W;
        }
        return this.V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib(dr drVar, boolean z16) {
        final MetaMaterial metaMaterial;
        WinkEditData h06 = drVar.h0();
        if (h06 == null) {
            return;
        }
        Map<String, MetaMaterial> filterMaterialMap = h06.getFilterMaterialMap();
        if (filterMaterialMap != null && !filterMaterialMap.isEmpty()) {
            metaMaterial = filterMaterialMap.values().iterator().next();
        } else {
            metaMaterial = null;
        }
        ms.a.a(this.TAG, "[handleInitFilter] material=" + metaMaterial + "adapter=" + this.N);
        kc(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.ac
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFilterMenuPart.this.Ob(metaMaterial);
            }
        }, z16);
    }

    private void Jb(@NonNull View view) {
        this.f320312b0 = view.findViewById(R.id.v5x);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f165207v61);
        this.f320313c0 = recyclerView;
        recyclerView.addOnScrollListener(new d());
        this.f320315e0 = (QUIButton) view.findViewById(R.id.f164295sm0);
        this.f320316f0 = (QUIButton) view.findViewById(R.id.f9033527);
        e eVar = new e();
        this.f320315e0.setOnClickListener(eVar);
        this.f320316f0.setOnClickListener(eVar);
        ub(this.f320315e0, WinkDaTongReportConstant.ElementId.EM_XSJ_FULL_CLIP);
        ub(this.f320316f0, WinkDaTongReportConstant.ElementId.EM_XSJ_CURRENT_CLIP);
    }

    private void Kb(View view) {
        this.P = view.findViewById(R.id.f81804f6);
        this.R = (TextView) view.findViewById(R.id.f10506650);
        StartPointSeekBar startPointSeekBar = (StartPointSeekBar) view.findViewById(R.id.f87684v1);
        this.Q = startPointSeekBar;
        startPointSeekBar.setSectionEnable(true);
        this.Q.setOnSeekBarChangeListener(new g());
    }

    private Boolean Lb() {
        int i3;
        if (H9() instanceof WinkVideoTavCut) {
            WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) H9();
            if (winkVideoTavCut != null) {
                List<MediaClip> a06 = winkVideoTavCut.a0();
                boolean z16 = true;
                if (a06.size() <= 1) {
                    return Boolean.FALSE;
                }
                Iterator<MediaClip> it = a06.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResourceModel resourceModel = it.next().resource;
                    if (resourceModel != null && resourceModel.type != MediaType.IMAGE) {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    return Boolean.FALSE;
                }
                String templatePath = winkVideoTavCut.getTemplatePath();
                if (templatePath == null) {
                    return Boolean.TRUE;
                }
                LightAsset Load = LightAsset.Load(templatePath, 0);
                w53.b.a(this.TAG, "getClipPlaceHolders: lightAsset errorCode: ${lightAsset?.errorCode}");
                MovieController assetForMovie = LightEngine.make(new VideoOutputConfig(PlayerDefaultConfigs.DEFAULT_FRAME_RATE, 0), new AudioOutputConfig(), new RendererConfig()).setAssetForMovie(Load);
                if (assetForMovie == null) {
                    return Boolean.TRUE;
                }
                for (ClipPlaceHolder clipPlaceHolder : assetForMovie.getClipPlaceHolders()) {
                    if (clipPlaceHolder.contentDuration == 0) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mb(Boolean bool) {
        boolean z16;
        this.f320318h0 = bool.booleanValue();
        if (this.winkEditorViewModel.getEditMode() == WinkEditorViewModel.EditMode.Image) {
            z16 = true;
        } else {
            z16 = false;
        }
        Db(z16);
        ThreadManagerV2.getUIHandlerV2().post(new AnonymousClass5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nb(boolean z16, com.tencent.mobileqq.wink.editor.model.b bVar) {
        if (bVar.a().isEmpty() && bVar.b().isEmpty()) {
            return;
        }
        com.tencent.mobileqq.wink.editor.model.b hc5 = hc(bVar, z16, this.f320318h0);
        this.M.setup(this.N, hc5.a(), hc5.b());
        this.V.c2(hc5.b());
        Iterator<Runnable> it = this.f320317g0.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.f320317g0.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ob(MetaMaterial metaMaterial) {
        if (this.V.getCurFilterMaterial() != metaMaterial) {
            com.tencent.mobileqq.wink.editor.filter.e eVar = this.N;
            if (eVar != null) {
                if (metaMaterial != null) {
                    eVar.Q(metaMaterial.f30533id);
                    for (int i3 = 0; i3 < this.N.B().size(); i3++) {
                        if (this.N.B().get(i3) != null && metaMaterial.equals(this.N.B().get(i3).f30533id)) {
                            this.N.a0(i3);
                            return;
                        }
                    }
                    return;
                }
                this.W.k0(H9());
                this.V.k0(H9());
                return;
            }
            return;
        }
        com.tencent.mobileqq.wink.editor.filter.e eVar2 = this.N;
        if (eVar2 != null && metaMaterial != null) {
            eVar2.d0(metaMaterial.f30533id, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pb(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Gb().k0(H9());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qb(com.tencent.mobileqq.wink.editor.filter.g gVar) {
        if (H9() != null) {
            FilterModel filterModel = null;
            if (this.V.getFilterRangeMode() == 101) {
                if (gVar != null) {
                    filterModel = gVar.getFilterModel();
                }
                qc(filterModel, false, true);
            } else if (gVar == null) {
                H9().i0(null, null, false);
            } else {
                H9().i0(gVar.getFilterModel(), gVar.getMetaMaterial(), gVar.getOnlyIntensity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rb(MetaMaterial metaMaterial) {
        cc(metaMaterial, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sb(Pair pair) {
        dr H9 = H9();
        if (H9 != null) {
            if (pair == null) {
                H9.i0(null, null, false);
                cc(null, true);
            } else {
                H9.i0((FilterModel) pair.getFirst(), (MetaMaterial) pair.getSecond(), false);
                cc((MetaMaterial) pair.getSecond(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Tb(Integer num) {
        switch (num.intValue()) {
            case 100:
                ms.a.a("autofilter", "detect success!!");
                Fb().r(true);
                return;
            case 101:
                ms.a.a("autofilter", "all success!!");
                Fb().p();
                return;
            case 102:
                Fb().g();
                Fb().h();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vb(MetaMaterial metaMaterial) {
        if (metaMaterial != null && !com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial)) {
            com.tencent.mobileqq.wink.editor.filter.e eVar = this.N;
            eVar.S = true;
            eVar.P(com.tencent.mobileqq.wink.editor.c.K(metaMaterial), metaMaterial);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wb(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
        File file = new File(WinkEditorResourceManager.a1().O0(metaMaterial));
        if (file.exists()) {
            if (gc(metaMaterial, FileUtils.readFileContent(file))) {
                yb(metaMaterial, aVar);
                return;
            } else {
                aVar.a(ApplyMaterialTask.Status.FAILED, -1);
                return;
            }
        }
        aVar.a(ApplyMaterialTask.Status.FAILED, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xb() {
        QQToast.makeText(getContext(), 0, "\u6b63\u5728\u4e0b\u8f7d\u667a\u80fd\u6ee4\u955c\u5305\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yb() {
        if (this.N != null && WinkEditorResourceManager.a1().o()) {
            this.N.Q(this.X);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zb(MetaMaterial metaMaterial) {
        com.tencent.mobileqq.wink.editor.filter.e eVar = this.N;
        if (eVar != null && metaMaterial != null) {
            MetaMaterial A = eVar.A(metaMaterial.f30533id);
            if (A != null) {
                com.tencent.mobileqq.wink.editor.filter.f.A(A, com.tencent.mobileqq.wink.editor.filter.f.i(metaMaterial));
                this.N.Q(A.f30533id);
                return;
            }
            return;
        }
        ms.a.f(this.TAG, "mMaterialPanelContentAdapter is:" + this.N);
    }

    private void ac() {
        this.V.M1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.filter.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFilterMenuPart.this.Qb((g) obj);
            }
        });
        this.V.Q1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.filter.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFilterMenuPart.this.Rb((MetaMaterial) obj);
            }
        });
        this.W.h2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.filter.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFilterMenuPart.this.Sb((Pair) obj);
            }
        });
        this.W.j2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.filter.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFilterMenuPart.this.Tb((Integer) obj);
            }
        });
        this.V.P1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.filter.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFilterMenuPart.this.Vb((MetaMaterial) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc() {
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial != null && com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial)) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f239427mf, 0).show();
            return;
        }
        this.V.b2(this.f320314d0.m0());
        rc(101, true);
        if (this.V.getCurFilterModel() != null) {
            qc(this.V.getCurFilterModel(), true, false);
            H9().i0(null, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(MetaMaterial metaMaterial, boolean z16) {
        com.tencent.mobileqq.wink.editor.filter.e eVar;
        if (Eb() != null) {
            Eb().selectMaterial(metaMaterial);
        }
        MetaMaterial Cb = Cb();
        mc(metaMaterial);
        this.U = metaMaterial;
        tc(metaMaterial);
        rc(this.V.getFilterRangeMode(), true);
        if (metaMaterial == null) {
            this.M.setClearButtonEnable(false);
            this.N.a0(-1);
            if (this.P.getVisibility() != 8) {
                this.P.setVisibility(8);
            }
            MetaMaterial metaMaterial2 = this.S;
            if (metaMaterial2 != null && Cb != null && z16) {
                this.T.l(metaMaterial2);
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial) && (eVar = this.N) != null) {
            eVar.v0(true);
            this.N.notifyDataSetChanged();
        }
        this.M.setClearButtonEnable(true);
        if (this.P.getVisibility() != 0) {
            this.P.setVisibility(0);
        }
        int i3 = com.tencent.mobileqq.wink.editor.filter.f.i(metaMaterial);
        this.Q.setDefaultValue(com.tencent.mobileqq.wink.editor.filter.f.g(metaMaterial));
        this.Q.setProgress(i3);
        StartPointSeekBar.v(this.Q, i3 + "%", this.R);
        this.M.o(metaMaterial);
        this.T.l(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(MetaMaterial metaMaterial, FilterModel filterModel) {
        LutFilterModel lutFilterModel;
        this.U = metaMaterial;
        this.V.Z1(metaMaterial);
        this.V.a2(filterModel);
        this.M.setClearButtonEnable(true);
        if (this.P.getVisibility() != 0) {
            this.P.setVisibility(0);
        }
        if (metaMaterial != null) {
            com.tencent.mobileqq.wink.editor.filter.e eVar = this.N;
            eVar.a0(eVar.C(metaMaterial.f30533id));
            if (filterModel != null && (lutFilterModel = filterModel.lut) != null) {
                int i3 = (int) lutFilterModel.intensity;
                this.Q.setDefaultValue(com.tencent.mobileqq.wink.editor.filter.f.g(metaMaterial));
                this.Q.setProgress(i3);
                StartPointSeekBar.v(this.Q, i3 + "%", this.R);
            }
            this.M.o(metaMaterial);
            return;
        }
        this.V.k0(H9());
    }

    private void ec() {
        MetaMaterial metaMaterial = this.Y;
        if (metaMaterial != null && com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial)) {
            cc(null, false);
        }
    }

    private boolean gc(MetaMaterial metaMaterial, String str) {
        try {
            AEFilterExtendBean aEFilterExtendBean = (AEFilterExtendBean) new Gson().fromJson(str, AEFilterExtendBean.class);
            if (aEFilterExtendBean != null) {
                com.tencent.mobileqq.wink.editor.filter.f.w(metaMaterial, true);
                com.tencent.mobileqq.wink.editor.filter.f.u(metaMaterial, aEFilterExtendBean.getDefaultEffectAlpha());
                if (!TextUtils.isEmpty(aEFilterExtendBean.getLutID())) {
                    com.tencent.mobileqq.wink.editor.filter.f.C(metaMaterial, aEFilterExtendBean.getLutID());
                }
                com.tencent.mobileqq.wink.editor.filter.f.z(metaMaterial, aEFilterExtendBean.getGlowStrength());
                if (!TextUtils.isEmpty(aEFilterExtendBean.getMotionID())) {
                    com.tencent.mobileqq.wink.editor.filter.f.D(metaMaterial, aEFilterExtendBean.getMotionID());
                }
                com.tencent.mobileqq.wink.editor.filter.f.s(metaMaterial, aEFilterExtendBean.getAdjustParams());
                return true;
            }
            return false;
        } catch (JsonSyntaxException e16) {
            ms.a.c(this.TAG, "parse effect json exception: " + e16.toString());
            return false;
        }
    }

    private com.tencent.mobileqq.wink.editor.model.b hc(com.tencent.mobileqq.wink.editor.model.b bVar, boolean z16, boolean z17) {
        ArrayList arrayList = new ArrayList();
        ArrayList<MetaCategory> arrayList2 = new ArrayList();
        if (!z16 && z17) {
            arrayList2.add(com.tencent.mobileqq.wink.editor.filter.f.b());
        }
        arrayList2.addAll(bVar.a());
        int i3 = 0;
        for (MetaCategory metaCategory : arrayList2) {
            ArrayList<MetaMaterial> arrayList3 = metaCategory.materials;
            if (arrayList3 != null) {
                Iterator<MetaMaterial> it = arrayList3.iterator();
                while (it.hasNext()) {
                    MetaMaterial next = it.next();
                    com.tencent.mobileqq.wink.editor.c.o1(next, metaCategory.f30532id);
                    com.tencent.mobileqq.wink.editor.c.p1(next, metaCategory.name);
                    if (z16) {
                        if (com.tencent.mobileqq.wink.editor.filter.f.n(next) || this.f320319i0 < com.tencent.mobileqq.wink.editor.filter.f.h(next)) {
                            it.remove();
                        }
                    } else if (com.tencent.mobileqq.wink.editor.filter.f.o(next) || this.f320319i0 < com.tencent.mobileqq.wink.editor.filter.f.m(next)) {
                        it.remove();
                    }
                }
                Iterator<MetaMaterial> it5 = metaCategory.materials.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next2 = it5.next();
                    com.tencent.mobileqq.wink.editor.c.y1(next2, i3);
                    arrayList.add(next2);
                    i3++;
                }
            }
        }
        return new com.tencent.mobileqq.wink.editor.model.b(arrayList2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic(RecyclerView recyclerView, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (i3 >= findLastCompletelyVisibleItemPosition) {
                int i16 = i3 + 1;
                if (i16 < layoutManager.getItemCount()) {
                    recyclerView.smoothScrollToPosition(i16);
                } else {
                    recyclerView.smoothScrollToPosition(i3);
                }
            }
            if (i3 < findFirstCompletelyVisibleItemPosition) {
                recyclerView.smoothScrollToPosition(i3);
            }
            w53.b.a(this.TAG, "last" + findLastCompletelyVisibleItemPosition + ",first:" + findFirstCompletelyVisibleItemPosition + ",index" + i3);
        }
    }

    private void jc() {
        if (this.f320314d0 != null) {
            this.f320313c0.setAdapter(null);
            this.f320314d0.release();
            this.f320314d0 = null;
        }
    }

    private void kc(Runnable runnable, boolean z16) {
        com.tencent.mobileqq.wink.editor.filter.e eVar = this.N;
        if (eVar != null && eVar.getItemCount() > 0 && !z16) {
            runnable.run();
        } else {
            this.f320317g0.add(runnable);
        }
    }

    private void mc(MetaMaterial metaMaterial) {
        if (H9() instanceof WinkImageTavCut) {
            this.Z = metaMaterial;
        } else {
            this.Y = metaMaterial;
        }
    }

    private void oc(QUIButton qUIButton, Boolean bool, Boolean bool2) {
        qUIButton.setThemeId(1002);
        if (bool.booleanValue()) {
            qUIButton.setType(0);
            return;
        }
        qUIButton.setType(1);
        if (bool2.booleanValue()) {
            qUIButton.setBackgroundDisabled();
        } else {
            qUIButton.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(FilterModel filterModel, boolean z16, boolean z17) {
        List<MediaClip> g26;
        if (H9() != null && (g26 = this.V.g2(H9().a0(), filterModel, z16)) != null && (H9() instanceof WinkVideoTavCut)) {
            ((WinkVideoTavCut) H9()).l3(g26, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(int i3, boolean z16) {
        boolean z17;
        boolean z18;
        if (Eb() != null && z16) {
            Eb().saveFilterRangeMode(i3);
        }
        this.V.d2(i3);
        this.N.X = i3;
        QUIButton qUIButton = this.f320315e0;
        boolean z19 = true;
        if (i3 == 100) {
            z17 = true;
        } else {
            z17 = false;
        }
        oc(qUIButton, Boolean.valueOf(z17), Boolean.FALSE);
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial != null && com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial)) {
            z18 = true;
        } else {
            z18 = false;
        }
        Boolean valueOf = Boolean.valueOf(z18);
        QUIButton qUIButton2 = this.f320316f0;
        if (i3 != 101) {
            z19 = false;
        }
        oc(qUIButton2, Boolean.valueOf(z19), valueOf);
    }

    private void sc() {
        Map<String, String> map;
        LutFilterModel lutFilterModel;
        List<MediaClip> a06 = H9().a0();
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        for (MediaClip mediaClip : a06) {
            if (mediaClip != null) {
                an anVar = new an(mediaClip.resource);
                if (this.V.getFilterRangeMode() == 101) {
                    FilterModel filterModel = mediaClip.filter;
                    if (filterModel != null && (lutFilterModel = filterModel.lut) != null) {
                        anVar.k(lutFilterModel.filterId, lutFilterModel.name, Integer.valueOf((int) lutFilterModel.intensity));
                    }
                } else {
                    MetaMaterial metaMaterial = this.U;
                    if (metaMaterial != null && (map = metaMaterial.additionalFields) != null) {
                        anVar.k(metaMaterial.f30533id, map.get("name"), Integer.valueOf(com.tencent.mobileqq.wink.editor.filter.f.i(this.U)));
                    }
                }
                anVar.n(j3);
                j3 += mediaClip.resource.scaleDuration;
                arrayList.add(anVar);
            }
        }
        this.V.e2(a06);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.f320313c0.setLayoutManager(linearLayoutManager);
        jc();
        ak akVar = new ak(getContext(), arrayList);
        this.f320314d0 = akVar;
        akVar.w0(new i());
        this.f320313c0.setAdapter(this.f320314d0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc(MetaMaterial metaMaterial) {
        if (this.f320312b0 != null && this.f320314d0 != null) {
            if (this.V.getFilterRangeMode() == 100) {
                int itemCount = this.f320314d0.getItemCount();
                for (int i3 = 0; i3 < itemCount; i3++) {
                    this.f320314d0.x0(metaMaterial, i3);
                }
                return;
            }
            an mCurrentVideoItem = this.V.getMCurrentVideoItem();
            ak akVar = this.f320314d0;
            akVar.x0(metaMaterial, akVar.l0(mCurrentVideoItem));
        }
    }

    private void ub(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    private void uc() {
        if (this.V.getFilterRangeMode() == 101 && H9() != null) {
            List<MediaClip> a06 = H9().a0();
            if (a06.size() >= 1 && a06.get(0) != null) {
                if (a06.get(0).filter != null && a06.get(0).filter.lut != null) {
                    dc(this.N.A(a06.get(0).filter.lut.filterId), a06.get(0).filter);
                    qc(null, true, false);
                    H9().i0(this.V.S1(), this.U, false);
                } else {
                    dc(null, null);
                }
            }
            rc(102, true);
        }
    }

    private void vb() {
        dr H9 = H9();
        if (H9 != null && (H9 instanceof WinkImageTavCut)) {
            ((WinkImageTavCut) H9).C0(this.f320322l0);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private void wb() {
        WinkEditorSmartFilterViewModel winkEditorSmartFilterViewModel;
        com.tencent.mobileqq.wink.editor.filter.e eVar;
        if ((H9() instanceof WinkVideoTavCut) && (winkEditorSmartFilterViewModel = this.W) != null && winkEditorSmartFilterViewModel.p2(H9()) && (eVar = this.N) != null) {
            eVar.v0(false);
            this.N.notifyDataSetChanged();
        }
    }

    private void yb(@NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
        String l3 = com.tencent.mobileqq.wink.editor.filter.f.l(metaMaterial);
        com.tencent.mobileqq.wink.flow.c.c("downloadLutResource", metaMaterial, "lutId = " + l3);
        if (TextUtils.isEmpty(l3)) {
            com.tencent.mobileqq.wink.editor.filter.f.y(metaMaterial, true);
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            return;
        }
        String f16 = WinkEditorResourceManager.a1().f1(metaMaterial);
        com.tencent.mobileqq.wink.flow.c.c("downloadLutResource", metaMaterial, "lutPath = " + f16);
        if (!TextUtils.isEmpty(f16) && new File(f16).exists()) {
            com.tencent.mobileqq.wink.editor.filter.f.y(metaMaterial, true);
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        } else {
            WinkEditorResourceManager.a1().i(l3, new h(metaMaterial, aVar));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.v5t;
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void F1(ApplyMaterialTask.Status status, int i3, @NonNull final MetaMaterial metaMaterial, @NonNull final ApplyMaterialTask.a aVar) {
        if (com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial)) {
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            return;
        }
        if (com.tencent.mobileqq.wink.editor.filter.f.q(metaMaterial)) {
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        } else if (com.tencent.mobileqq.wink.editor.filter.f.p(metaMaterial)) {
            yb(metaMaterial, aVar);
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.u
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFilterMenuPart.this.Wb(metaMaterial, aVar);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        super.J9(editMode);
        com.tencent.mobileqq.wink.editor.filter.e eVar = this.N;
        if (eVar != null) {
            eVar.g0(editMode);
        }
        vb();
        dr H9 = H9();
        if (H9 == null) {
            return;
        }
        Ib(H9, true);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle bundle) {
        super.L9(bundle);
        this.f320320j0 = true;
        wb();
        int D = this.N.D();
        if (D >= 0) {
            this.N.a0(D);
        }
        if (Lb().booleanValue()) {
            if (H9() != null) {
                H9().addPlayerListener(this.f320321k0);
            }
            if (this.V.getFilterRangeMode() == 102) {
                this.V.d2(100);
            }
            rc(this.V.getFilterRangeMode(), true);
            this.f320312b0.setVisibility(0);
            sc();
            return;
        }
        rc(102, true);
        this.f320312b0.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        super.M9();
        dr H9 = H9();
        if (H9 instanceof WinkVideoTavCut) {
            ((WinkVideoTavCut) H9).m0(new c(H9));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(WinkEditUIData winkEditUIData) {
        String str;
        if (!(winkEditUIData instanceof WinkFilterUIData)) {
            return;
        }
        WinkFilterUIData winkFilterUIData = (WinkFilterUIData) winkEditUIData;
        int filterRangeMode = winkFilterUIData.getFilterRangeMode();
        final MetaMaterial materialFromDraft = winkFilterUIData.getMaterialFromDraft();
        String str2 = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("recoveryUIDraft:material:");
        if (materialFromDraft != null) {
            str = materialFromDraft.f30533id;
        } else {
            str = "NONE";
        }
        sb5.append(str);
        ms.a.f(str2, sb5.toString());
        if (filterRangeMode != 101) {
            if (filterRangeMode == 100) {
                rc(filterRangeMode, false);
            }
            kc(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.w
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFilterMenuPart.this.Zb(materialFromDraft);
                }
            }, false);
            return;
        }
        rc(filterRangeMode, false);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void Q(int i3, @NonNull MetaMaterial metaMaterial) {
        this.N.a0(i3);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NonNull
    public MenuType ba() {
        return MenuType.FILTER;
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public boolean d0(int i3, @NonNull MetaMaterial metaMaterial) {
        return com.tencent.mobileqq.wink.flow.c.a(metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void g(int i3, @NonNull MetaMaterial metaMaterial) {
        boolean z16;
        an m06;
        MetaMaterial metaMaterial2;
        dr H9 = H9();
        if (H9 == null) {
            return;
        }
        if ((H9 instanceof WinkVideoTavCut) && (metaMaterial2 = this.Y) != null && com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial2) && com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial) && this.W.p2(H9)) {
            Fb().j();
            Fb().m();
        }
        com.tencent.mobileqq.wink.editor.filter.h Hb = Hb(metaMaterial);
        ak akVar = this.f320314d0;
        if (akVar != null && (m06 = akVar.m0()) != null && m06.getFilterId() != null && metaMaterial.f30533id.equals(m06.getFilterId()) && this.V.getFilterRangeMode() == 101) {
            com.tencent.mobileqq.wink.editor.filter.f.A(metaMaterial, m06.getIntensity());
        }
        Hb.d0(H9, metaMaterial, z16);
        if (com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial)) {
            this.V.Z1(metaMaterial);
        }
        this.V.X1(i3);
        String str = this.winkEditorViewModel.getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String();
        if (!TextUtils.isEmpty(str)) {
            y53.e.d().a(str, metaMaterial.f30533id, new WinkPublishQualityReportData.Builder().eventId("P_MATERIAL_COST_END").retCode("0").ext1(metaMaterial.f30533id).ext2("video").getReportData());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NonNull View view) {
        super.initAfterInflation(view);
        this.V = (af) getViewModel(af.class);
        this.W = (WinkEditorSmartFilterViewModel) getViewModel(WinkEditorSmartFilterViewModel.class);
        WinkMaterialPanel winkMaterialPanel = (WinkMaterialPanel) view.findViewById(R.id.yy7);
        this.M = winkMaterialPanel;
        winkMaterialPanel.setOnClearButtonClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.filter.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkEditorFilterMenuPart.this.Pb(view2);
            }
        });
        com.tencent.mobileqq.wink.editor.filter.e eVar = new com.tencent.mobileqq.wink.editor.filter.e(getContext(), this.winkEditorViewModel.getEditMode());
        this.N = eVar;
        eVar.S(this);
        Jb(view);
        Kb(view);
        Ab();
        ac();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void la() {
        com.tencent.mobileqq.wink.report.e.f326265a.y();
    }

    public void nc() {
        if (this.V.getFilterRangeMode() != 101) {
            return;
        }
        sc();
        if (!Lb().booleanValue()) {
            uc();
            if (H9() != null) {
                H9().removePlayerListener(this.f320321k0);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
        if (this.N != null && !TextUtils.isEmpty(this.X)) {
            this.N.Q(this.X);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        super.onDismiss();
        jc();
        this.f320320j0 = false;
        if (this.V.getFilterRangeMode() != 102 && H9() != null) {
            H9().play();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NonNull View view) {
        super.onInitView(view);
        if (getPartRootView() != null) {
            this.visible = false;
            getPartRootView().setVisibility(4);
        }
        this.T = (WinkFilterApplyTipView) view.findViewById(R.id.f115946xe);
        initAfterInflation(view);
        this.S = com.tencent.mobileqq.wink.editor.filter.f.a();
        O9(new WinkFilterUIData(this));
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        super.onPartDestroy(activity);
        jc();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        HashMap hashMap;
        super.onReceiveEvent(simpleBaseEvent);
        if ((simpleBaseEvent instanceof ReceiveSchemaEvent) && (hashMap = (HashMap) ((ReceiveSchemaEvent) simpleBaseEvent).getAttrs()) != null && !hashMap.isEmpty() && hashMap.containsKey("filter") && !TextUtils.isEmpty((CharSequence) hashMap.get("filter"))) {
            this.X = (String) hashMap.get("filter");
            kc(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.v
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFilterMenuPart.this.Yb();
                }
            }, true);
        }
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void p3(int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
        if (com.tencent.mobileqq.wink.editor.filter.f.r(metaMaterial) && !WinkEditorSmartFilterViewModel.INSTANCE.c()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.t
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFilterMenuPart.this.Xb();
                }
            });
            this.N.w0();
        } else {
            com.tencent.mobileqq.wink.flow.c.f(aVar);
        }
    }

    public void xb(dr drVar) {
        ec();
        this.V.k0(drVar);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public boolean z(int i3, @NonNull MetaMaterial metaMaterial) {
        return Hb(metaMaterial).W(H9(), metaMaterial);
    }

    /* loaded from: classes21.dex */
    class c implements ICutStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ dr f320326a;

        c(dr drVar) {
            this.f320326a = drVar;
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity entity) {
            if (WinkEditorFilterMenuPart.this.W != null && WinkEditorFilterMenuPart.this.Gb() == WinkEditorFilterMenuPart.this.W) {
                WinkEditorFilterMenuPart.this.W.u2(this.f320326a);
            }
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
        }
    }

    /* loaded from: classes21.dex */
    class b implements IPlayer.PlayerListener {
        b() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long j3, long j16) {
            int r06;
            an mCurrentVideoItem;
            if (WinkEditorFilterMenuPart.this.f320314d0 != null && WinkEditorFilterMenuPart.this.H9() != null && WinkEditorFilterMenuPart.this.f320320j0) {
                if ((WinkEditorFilterMenuPart.this.V.getFilterRangeMode() == 100 || !WinkEditorFilterMenuPart.this.f320320j0 || WinkEditorFilterMenuPart.this.f320314d0.m0() == null) && (r06 = WinkEditorFilterMenuPart.this.f320314d0.r0(j3, j16, WinkEditorFilterMenuPart.this.V.getFilterRangeMode())) >= 0) {
                    WinkEditorFilterMenuPart winkEditorFilterMenuPart = WinkEditorFilterMenuPart.this;
                    winkEditorFilterMenuPart.ic(winkEditorFilterMenuPart.f320313c0, r06);
                }
                an m06 = WinkEditorFilterMenuPart.this.f320314d0.m0();
                if (m06 != WinkEditorFilterMenuPart.this.V.getMCurrentVideoItem()) {
                    WinkEditorFilterMenuPart.this.V.b2(m06);
                    if (WinkEditorFilterMenuPart.this.V.getFilterRangeMode() == 101 && m06 != null) {
                        WinkEditorFilterMenuPart.this.f320314d0.t0(m06);
                    }
                }
                if (WinkEditorFilterMenuPart.this.V.getFilterRangeMode() != 101 || !WinkEditorFilterMenuPart.this.f320320j0 || (mCurrentVideoItem = WinkEditorFilterMenuPart.this.V.getMCurrentVideoItem()) == null) {
                    return;
                }
                long startTime = (mCurrentVideoItem.getStartTime() + mCurrentVideoItem.getDuration()) - j3;
                if (startTime <= JsonGrayBusiId.UI_RESERVE_100000_110000 && startTime > 0) {
                    w53.b.a(WinkEditorFilterMenuPart.this.TAG, "range current currentDurationUs:" + j3 + "," + (mCurrentVideoItem.getStartTime() + mCurrentVideoItem.getDuration()) + "," + WinkEditorFilterMenuPart.this.visible);
                    if (WinkEditorFilterMenuPart.this.f320320j0) {
                        WinkEditorFilterMenuPart.this.H9().pause();
                        return;
                    } else {
                        WinkEditorFilterMenuPart.this.H9().play();
                        return;
                    }
                }
                if (startTime <= 0) {
                    w53.b.a(WinkEditorFilterMenuPart.this.TAG, "range current currentDurationUs:" + j3 + "," + (mCurrentVideoItem.getStartTime() + mCurrentVideoItem.getDuration()));
                    WinkEditorFilterMenuPart.this.H9().seek((mCurrentVideoItem.getStartTime() + mCurrentVideoItem.getDuration()) - 50000);
                }
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NonNull IPlayer iPlayer) {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @NonNull IPlayer iPlayer) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class g implements StartPointSeekBar.a {
        g() {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void wd(StartPointSeekBar startPointSeekBar, int i3) {
            StartPointSeekBar.v(startPointSeekBar, i3 + "%", WinkEditorFilterMenuPart.this.R);
            WinkEditorFilterMenuPart.this.Gb().n0(WinkEditorFilterMenuPart.this.H9(), i3);
            if (WinkEditorFilterMenuPart.this.U != null) {
                com.tencent.mobileqq.wink.editor.filter.f.A(WinkEditorFilterMenuPart.this.U, i3);
                if (WinkEditorFilterMenuPart.this.Eb() != null) {
                    WinkEditorFilterMenuPart.this.Eb().selectMaterial(WinkEditorFilterMenuPart.this.U);
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void Fd(StartPointSeekBar startPointSeekBar) {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void uc(StartPointSeekBar startPointSeekBar) {
        }
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void Y(int i3, @NonNull MetaMaterial metaMaterial) {
    }
}
