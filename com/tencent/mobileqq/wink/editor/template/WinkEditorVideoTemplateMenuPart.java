package com.tencent.mobileqq.wink.editor.template;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.editor.cx;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuItem;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart;
import com.tencent.mobileqq.wink.editor.template.event.WinkTemplateLoadingDialogDismissEvent;
import com.tencent.mobileqq.wink.editor.template.g;
import com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanel;
import com.tencent.mobileqq.wink.editor.view.d;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.wink.event.TemplateSelectEvent;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.reddot.WinkMaterialRedDotManager;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes21.dex */
public class WinkEditorVideoTemplateMenuPart extends WinkEditorMenuPart {
    private WinkEditorTemplatePanel M;
    private QCircleCommonLoadingDialog N;
    private x S;
    private MusicVolumeControlViewModel T;
    private b63.a U;
    private com.tencent.mobileqq.wink.editor.music.ui.a V;
    private TextView X;
    private TextView Y;
    private LinearLayout Z;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f322283c0;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.view.d f322285e0;
    private boolean P = false;
    private boolean Q = false;
    private MetaMaterial R = null;
    private String W = "";

    /* renamed from: a0, reason: collision with root package name */
    private String f322281a0 = "";

    /* renamed from: b0, reason: collision with root package name */
    private MetaMaterial f322282b0 = null;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f322284d0 = true;

    /* renamed from: f0, reason: collision with root package name */
    private final Runnable f322286f0 = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.ap
        @Override // java.lang.Runnable
        public final void run() {
            WinkEditorVideoTemplateMenuPart.this.Wb();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements g.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unit d(WinkDc5507ReportData.a aVar) {
            aVar.b(1009);
            aVar.j(2);
            return Unit.INSTANCE;
        }

        @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.e
        public void a(int i3, @Nullable MetaMaterial metaMaterial) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, 0);
            WinkEditorVideoTemplateMenuPart.this.M.g0(i3, metaMaterial);
            w53.b.f(WinkEditorVideoTemplateMenuPart.this.TAG, "onItemSelect visible = " + WinkEditorVideoTemplateMenuPart.this.visible);
            t53.a.a(WinkEditorVideoTemplateMenuPart.this.getActivity().getIntent(), "template", metaMaterial.f30533id, new Function1() { // from class: com.tencent.mobileqq.wink.editor.template.ay
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit d16;
                    d16 = WinkEditorVideoTemplateMenuPart.b.d((WinkDc5507ReportData.a) obj);
                    return d16;
                }
            });
        }

        @Override // com.tencent.mobileqq.wink.editor.template.g.a
        public void b(int i3, @Nullable MetaMaterial metaMaterial) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("back_to_template_menu_part", true);
            WinkEditorVideoTemplateMenuPart.this.winkEditorViewModel.u5(MenuType.TEMPLATE_TEXT_LIST, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class e implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        private final int f322298a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f322299b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f322300c;

        /* loaded from: classes21.dex */
        class a implements ResDownLoadListener {
            a() {
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onDownloadFinish(boolean z16) {
                if (!z16) {
                    WinkEditorVideoTemplateMenuPart.this.Sb();
                    WinkEditorVideoTemplateMenuPart.this.xb();
                } else {
                    WinkEditorResourceManager.a1().i0(e.this.f322300c);
                    e eVar = e.this;
                    WinkEditorVideoTemplateMenuPart.this.Tb(eVar.f322300c);
                }
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onProgressUpdate(int i3) {
                e.this.d(i3, true);
            }
        }

        e(String[] strArr, MetaMaterial metaMaterial) {
            int i3;
            this.f322299b = strArr;
            this.f322300c = metaMaterial;
            if (strArr != null) {
                i3 = strArr.length;
            } else {
                i3 = 0;
            }
            this.f322298a = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3) {
            if (WinkEditorVideoTemplateMenuPart.this.N != null && WinkEditorVideoTemplateMenuPart.this.N.k0() <= 95) {
                WinkEditorVideoTemplateMenuPart.this.N.setProgress(i3);
            }
            if (WinkEditorVideoTemplateMenuPart.this.winkEditorViewModel.getIsSchemaTemplate() && WinkEditorVideoTemplateMenuPart.this.R.f30533id.equals(WinkEditorVideoTemplateMenuPart.this.W)) {
                WinkEditorVideoTemplateMenuPart.this.winkEditorViewModel.h5(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i3, boolean z16) {
            int i16;
            final int i17;
            if (this.f322298a > 0) {
                i16 = 20;
            } else {
                i16 = 0;
            }
            if (i3 > 0 && i3 <= 100) {
                if (WinkEditorVideoTemplateMenuPart.this.R == null || WinkEditorVideoTemplateMenuPart.this.R.f30533id.equals(this.f322300c.f30533id)) {
                    if (z16) {
                        i17 = ((int) ((i16 / 100.0f) * i3)) + (100 - i16);
                    } else {
                        i17 = (int) (((100 - i16) / 100.0f) * i3);
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.ba
                        @Override // java.lang.Runnable
                        public final void run() {
                            WinkEditorVideoTemplateMenuPart.e.this.c(i17);
                        }
                    });
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            if (WinkEditorVideoTemplateMenuPart.this.P) {
                WinkEditorVideoTemplateMenuPart.this.P = false;
                return;
            }
            if (!z16) {
                WinkEditorVideoTemplateMenuPart.this.Sb();
                WinkEditorVideoTemplateMenuPart.this.xb();
            } else if (this.f322298a <= 0) {
                WinkEditorVideoTemplateMenuPart.this.Tb(this.f322300c);
            } else {
                WinkEditorResourceManager.a1().h0(this.f322300c, new a());
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            d(i3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public interface g {
        void onCancel();

        void onConfirm();
    }

    private void Ab() {
        this.M.setOnClearButtonClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorVideoTemplateMenuPart.this.Gb(view);
            }
        });
        this.M.setOnFilterBtnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorVideoTemplateMenuPart.this.bc(view);
            }
        });
        this.M.setApplyMaterialTask(sb());
        this.M.setItemSelectListener(new b());
    }

    private void Bb(View view) {
        this.X = (TextView) view.findViewById(R.id.uca);
        this.Y = (TextView) view.findViewById(R.id.f100465sk);
        this.Z = (LinearLayout) view.findViewById(R.id.f25800bt);
        if (cx.INSTANCE.f()) {
            this.V = (com.tencent.mobileqq.wink.editor.music.ui.a) view.getRootView().findViewById(R.id.zjq);
        } else {
            this.V = (com.tencent.mobileqq.wink.editor.music.ui.a) view.getRootView().findViewById(R.id.zjp);
        }
        this.M = (WinkEditorTemplatePanel) view.findViewById(R.id.yy7);
        Ab();
        if (this.winkEditorViewModel.u4()) {
            this.Z.setVisibility(8);
            this.M.setFilterBtnVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Cb(g gVar, DialogInterface dialogInterface, int i3) {
        if (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.isUserOpCloseSmartClip) {
            com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.isUserOpCloseSmartClip = false;
        }
        gVar.onConfirm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eb() {
        wb();
        this.winkEditorViewModel.W4(false);
        this.Q = false;
        WinkEditorTemplatePanel winkEditorTemplatePanel = this.M;
        if (winkEditorTemplatePanel != null) {
            winkEditorTemplatePanel.setDisableClick(false);
        }
        this.winkEditorViewModel.h5(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fb() {
        wb();
        this.winkEditorViewModel.W4(false);
        this.Q = false;
        WinkEditorTemplatePanel winkEditorTemplatePanel = this.M;
        if (winkEditorTemplatePanel != null) {
            winkEditorTemplatePanel.setDisableClick(false);
        }
        this.winkEditorViewModel.h5(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gb(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.Q) {
            nb(new a(), null, getContext().getString(R.string.f215215v0));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hb(Long l3) {
        cc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ib(List list) {
        Yb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jb(Boolean bool) {
        Yb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kb(Pair pair) {
        w53.b.a(this.TAG, "getNotifyTypeChildClear = " + pair);
        if (!MenuType.VIDEO_TEMPLATE.equals((MenuType) pair.getFirst())) {
            return;
        }
        this.M.q((List) pair.getSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lb() {
        this.M.Q();
        this.M.d0();
        dc(null);
        QQToast.makeText(getContext(), 1, getContext().getString(R.string.f215185ux), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Mb(WinkDc5507ReportData.a aVar) {
        aVar.b(1009);
        aVar.j(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nb(MetaMaterial metaMaterial) {
        WinkEditorTemplatePanel winkEditorTemplatePanel = this.M;
        if (winkEditorTemplatePanel != null) {
            winkEditorTemplatePanel.setSelectedMaterial(metaMaterial);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ob(MetaMaterial metaMaterial) {
        View T = this.M.T(metaMaterial);
        if (T != null) {
            com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(getHostFragment().requireContext());
            r16.o0(getContext().getResources().getString(R.string.f215585w0));
            r16.m0(3);
            r16.k0(0);
            r16.R(0);
            r16.S(T);
            r16.s0();
            com.tencent.mobileqq.wink.utils.ar.f326685a.m("ae_key_editable_template_text_showed", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pb() {
        this.P = true;
        this.Q = false;
        this.winkEditorViewModel.W4(false);
        WinkEditorTemplatePanel winkEditorTemplatePanel = this.M;
        if (winkEditorTemplatePanel != null) {
            winkEditorTemplatePanel.setDisableClick(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qb(String str) {
        aa().onBottomPanelTabRhythmSwitch(str);
        if (str != null && !str.equals(AECameraPrefsUtil.f318480r)) {
            this.M.setFilterButtonChecked(true);
        } else {
            this.M.setFilterButtonChecked(false);
        }
        this.f322285e0.b();
    }

    private void Rb(List<MetaCategory> list) {
        int h16;
        ob();
        String i3 = this.M.i();
        boolean z16 = false;
        if (i3 == null) {
            this.M.u(0, true);
            return;
        }
        int h17 = this.M.h(i3);
        if (h17 != -1) {
            this.M.u(h17, true);
            return;
        }
        for (MetaCategory metaCategory : list) {
            if (z16 && (h16 = this.M.h(metaCategory.f30532id)) != -1) {
                this.M.u(h16, true);
                return;
            } else if (i3.equals(metaCategory.f30532id)) {
                z16 = true;
            }
        }
        this.M.u(-1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sb() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.ao
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorVideoTemplateMenuPart.this.Lb();
            }
        });
        cu.F(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tb(MetaMaterial metaMaterial) {
        x xVar = this.S;
        ArrayList<String> arrayList = null;
        if (xVar != null) {
            ArrayList<String> O1 = xVar.O1(metaMaterial);
            if (!this.S.T1(O1)) {
                arrayList = O1;
            }
        }
        ms.a.f(this.TAG, "bundle load onTemplateDownloadSuccess");
        this.f322282b0 = metaMaterial;
        if (arrayList != null && !arrayList.isEmpty()) {
            ac();
            Xb(-1);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(it.next(), new d(metaMaterial));
            }
            return;
        }
        Xb(100);
        xb();
        Vb(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vb(final MetaMaterial metaMaterial) {
        ms.a.f(this.TAG, "bundle load onTemplateDownloadSuccess");
        com.tencent.videocut.utils.thread.c.f384289c.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.an
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorVideoTemplateMenuPart.this.Nb(metaMaterial);
            }
        });
        com.tencent.mobileqq.wink.editor.c.D1(metaMaterial, WinkEditorResourceManager.a1().m(metaMaterial));
        dc(metaMaterial);
        String businessName = this.winkEditorViewModel.getBusinessName();
        if (!TextUtils.isEmpty(businessName)) {
            y53.e.d().a(businessName, metaMaterial.f30533id, new WinkPublishQualityReportData.Builder().eventId("P_MATERIAL_COST_END").ext1(metaMaterial.f30533id).ext2("video").retCode("0").getReportData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wb() {
        if (H9() != null && H9().getIsInit()) {
            if (!TextUtils.isEmpty(this.f322281a0)) {
                this.M.l0(this.f322281a0);
                return;
            }
            WinkEditorTemplatePanel winkEditorTemplatePanel = this.M;
            if (winkEditorTemplatePanel != null) {
                winkEditorTemplatePanel.n0();
                if (com.tencent.mobileqq.wink.edit.manager.h.d().g()) {
                    this.winkEditorViewModel.R4(false);
                }
                WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_DAPIAN_TEMPLATE_CATEGORY, "\u63a8\u8350");
                WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_DAPIAN_TEMPLATE_NAME, "recommend");
                return;
            }
            return;
        }
        w53.b.g(this.TAG, "selectRecommendMaterialDelay: tavcut is null or not init");
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f322286f0, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xb(final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.4
            @Override // java.lang.Runnable
            public void run() {
                if (WinkEditorVideoTemplateMenuPart.this.N != null && WinkEditorVideoTemplateMenuPart.this.N.isShowing()) {
                    if (i3 == -1) {
                        int k06 = WinkEditorVideoTemplateMenuPart.this.N.k0();
                        if (k06 == 0) {
                            WinkEditorVideoTemplateMenuPart.this.N.setProgress(70);
                            return;
                        } else {
                            if (k06 < 90) {
                                WinkEditorVideoTemplateMenuPart.this.N.setProgress(k06 + 10);
                                return;
                            }
                            return;
                        }
                    }
                    WinkEditorVideoTemplateMenuPart.this.N.setProgress(i3);
                }
            }
        });
    }

    private void Yb() {
        dr H9 = H9();
        if (!(H9 instanceof WinkVideoTavCut) || this.M == null || !F9().kl(MenuItem.VIDEO_TEMPLATE)) {
            return;
        }
        if (((WinkVideoTavCut) H9).I1().isEmpty()) {
            this.M.setEditableOverlay(null);
            return;
        }
        final MetaMaterial V = this.M.V();
        if (V != null) {
            this.M.setEditableOverlay(V);
        }
        if (this.visible && !com.tencent.mobileqq.wink.utils.ar.f326685a.c("ae_key_editable_template_text_showed", false)) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.aq
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorVideoTemplateMenuPart.this.Ob(V);
                }
            }, 300L);
        }
    }

    private void Zb() {
        QCircleCommonLoadingDialog.c e16 = new QCircleCommonLoadingDialog.c(getContext()).n(true).e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.am
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorVideoTemplateMenuPart.this.Pb();
            }
        });
        if (this.winkEditorViewModel.u4()) {
            e16.p(getContext().getString(R.string.f215815wm));
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getContext().getString(R.string.f215635w5));
            arrayList.add(getContext().getString(R.string.f215655w7));
            arrayList.add(getContext().getString(R.string.f215645w6));
            arrayList.add(getContext().getString(R.string.f215625w4));
            e16.q(arrayList);
        }
        QCircleCommonLoadingDialog a16 = e16.a();
        this.N = a16;
        a16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac() {
        ms.a.a(this.TAG, "showLoadingForDownload");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.N;
        if (qCircleCommonLoadingDialog == null || !qCircleCommonLoadingDialog.isShowing()) {
            this.Q = true;
            this.M.setDisableClick(true);
            this.winkEditorViewModel.W4(true);
            this.P = false;
            Zb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.S.M1()) {
            this.M.w(false);
            this.S.a2(true);
        }
        Context context = view.getContext();
        ArrayList<String> allBottomPanelRhythmTypes = aa().getAllBottomPanelRhythmTypes();
        String bottomPanelSelectRhythmType = aa().getBottomPanelSelectRhythmType();
        if (view == this.M.e()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        d.a aVar = new d.a(context, allBottomPanelRhythmTypes, bottomPanelSelectRhythmType, i3);
        com.tencent.mobileqq.wink.editor.view.d dVar = new com.tencent.mobileqq.wink.editor.view.d(view.getContext());
        this.f322285e0 = dVar;
        dVar.d(aVar);
        aVar.l0(new d.a.c() { // from class: com.tencent.mobileqq.wink.editor.template.ah
            @Override // com.tencent.mobileqq.wink.editor.view.d.a.c
            public final void onClick(String str) {
                WinkEditorVideoTemplateMenuPart.this.Qb(str);
            }
        });
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] c16 = this.f322285e0.c();
        this.f322285e0.j(view, (((iArr[0] + view.getWidth()) - c16[0]) - (view.getWidth() / 2)) + com.tencent.mobileqq.util.x.c(view.getContext(), 17.5f), (iArr[1] - c16[1]) - com.tencent.mobileqq.util.x.c(view.getContext(), 28.0f), -1L);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void cc() {
        dr H9 = H9();
        if ((H9 instanceof WinkVideoTavCut) && H9.getCurrentPlayer() != null) {
            TextView textView = this.X;
            if (textView != null) {
                textView.setText(com.tencent.mobileqq.wink.editor.music.a.d(H9.getCurrentPlayer().getCurrentPlayUs()));
            }
            TextView textView2 = this.Y;
            if (textView2 != null) {
                textView2.setText(com.tencent.mobileqq.wink.editor.music.a.d(H9.getDurationUs()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(MetaMaterial metaMaterial) {
        boolean z16;
        if (getHostFragment() == null) {
            return;
        }
        if (metaMaterial != null) {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(metaMaterial.f30533id);
        }
        if (ub() != null && ub().getIsOriginalVolumeChangedManually()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.S.c2(metaMaterial, this.winkEditorViewModel.getIsFromTemplateColl(), z16, getContext(), this.f322283c0);
        dr H9 = H9();
        if (H9 instanceof WinkVideoTavCut) {
            H9.pause();
        }
        if (this.U == null) {
            this.U = (b63.a) getViewModel(b63.a.class);
        }
        if (TextUtils.isEmpty(TagRetriever.f326413a.i(getActivity().getIntent()))) {
            if (metaMaterial != null) {
                if (!TextUtils.isEmpty(com.tencent.mobileqq.wink.editor.c.q(metaMaterial)) && com.tencent.mobileqq.wink.model.b.f324006a.d()) {
                    this.U.N1(new InteractiveModel(com.tencent.mobileqq.wink.editor.c.q(metaMaterial)));
                    return;
                } else {
                    this.U.N1(null);
                    return;
                }
            }
            this.U.N1(null);
        }
    }

    private void ec(MetaMaterial metaMaterial) {
        if (this.S == null) {
            this.S = (x) getViewModel(x.class);
        }
        ArrayList<String> O1 = this.S.O1(metaMaterial);
        this.f322282b0 = metaMaterial;
        if (this.S.T1(O1)) {
            xb();
            dc(metaMaterial);
        }
        for (String str : O1) {
            if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(str)) {
                ms.a.a(this.TAG, "bundle load  fetchSingleBundle \uff1a" + str);
                ac();
                Xb(-1);
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(str, new f(metaMaterial));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(com.tencent.mobileqq.wink.editor.model.b bVar) {
        boolean z16;
        WinkEditorTemplatePanel winkEditorTemplatePanel;
        w53.b.a(this.TAG, "updateWinkMaterialPanel");
        if (bVar == null) {
            return;
        }
        I9();
        if (!this.winkEditorViewModel.getIsAutoTemplate() && TextUtils.isEmpty(this.W)) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        List<MetaCategory> a16 = aa().getWinkMaterialVOByTypes(AECameraPrefsUtil.f318480r).a();
        WinkEditorTemplatePanel winkEditorTemplatePanel2 = this.M;
        if (winkEditorTemplatePanel2 != null) {
            winkEditorTemplatePanel2.setup(bVar.a(), bVar.b(), bVar.c(), z17, aa().isSwitchType, aa().getBottomPanelSelectRhythmType(), a16, this.winkEditorViewModel.u4());
        }
        if (aa().isSwitchType) {
            Rb(a16);
            WinkEditorTemplatePanel winkEditorTemplatePanel3 = this.M;
            if (winkEditorTemplatePanel3 != null) {
                winkEditorTemplatePanel3.u0();
                return;
            }
            return;
        }
        WinkEditorTemplatePanel winkEditorTemplatePanel4 = this.M;
        if (winkEditorTemplatePanel4 != null) {
            winkEditorTemplatePanel4.u0();
        }
        if (!TextUtils.isEmpty(this.W) && (winkEditorTemplatePanel = this.M) != null && winkEditorTemplatePanel.V() == null) {
            this.M.l0(this.W);
        }
        if (!aa().isSwitchType) {
            ob();
            List<MetaCategory> a17 = bVar.a();
            List<MetaMaterial> b16 = bVar.b();
            if (a17 != null && b16 != null && !this.winkEditorViewModel.k3() && this.winkEditorViewModel.getIsAutoTemplate() && bVar.a().size() > 0) {
                Wb();
            }
        }
    }

    private void initViewModel() {
        aa().getTemplatesLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.template.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorVideoTemplateMenuPart.this.gc((com.tencent.mobileqq.wink.editor.model.b) obj);
            }
        });
        this.winkEditorViewModel.B2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.template.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorVideoTemplateMenuPart.this.Hb((Long) obj);
            }
        });
        this.winkEditorViewModel.n3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.template.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorVideoTemplateMenuPart.this.Ib((List) obj);
            }
        });
        x xVar = (x) getViewModel(x.class);
        this.S = xVar;
        xVar.R1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.template.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorVideoTemplateMenuPart.this.Jb((Boolean) obj);
            }
        });
        this.U = (b63.a) getViewModel(b63.a.class);
        WinkMaterialRedDotManager.f326249a.b().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.template.ax
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorVideoTemplateMenuPart.this.Kb((Pair) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb(final g gVar, String str, String str2) {
        dr H9 = H9();
        if (H9 == null) {
            return;
        }
        if (H9.f().isEmpty() && H9.y().isEmpty() && H9.X().isEmpty()) {
            gVar.onConfirm();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setTitle(str);
        createCustomDialog.setMessage(str2);
        createCustomDialog.setPositiveButton(getContext().getString(R.string.a8j), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.ai
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorVideoTemplateMenuPart.Cb(WinkEditorVideoTemplateMenuPart.g.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.aj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorVideoTemplateMenuPart.g.this.onCancel();
            }
        });
        try {
            if (!createCustomDialog.isShowing()) {
                createCustomDialog.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void ob() {
        dr H9 = H9();
        if (H9 != null) {
            H9.g();
        }
    }

    private void pb() {
        ImageView e16;
        if (this.winkEditorViewModel.u4()) {
            return;
        }
        if (!this.S.M1()) {
            this.M.w(true);
        }
        if (this.S.L1() || (e16 = this.M.e()) == null) {
            return;
        }
        Context context = e16.getContext();
        com.tencent.mobileqq.wink.editor.view.d dVar = new com.tencent.mobileqq.wink.editor.view.d(context);
        dVar.g(context.getString(R.string.f215875ws));
        int[] iArr = new int[2];
        e16.getLocationOnScreen(iArr);
        int[] c16 = dVar.c();
        dVar.j(e16, com.tencent.mobileqq.util.x.c(e16.getContext(), 19.5f) + (((iArr[0] + e16.getWidth()) - c16[0]) - (e16.getWidth() / 2)), (iArr[1] - c16[1]) - com.tencent.mobileqq.util.x.c(e16.getContext(), 24.5f), 3000L);
    }

    private void qb() {
        com.tencent.mobileqq.wink.editor.view.d dVar = this.f322285e0;
        if (dVar != null) {
            dVar.b();
            this.f322285e0 = null;
        }
    }

    private void rb() {
        Activity activity = getActivity();
        if (this.N != null && activity != null && !activity.isFinishing()) {
            this.N.dismiss();
        }
    }

    private com.tencent.mobileqq.wink.flow.b sb() {
        return new c();
    }

    private MetaMaterial tb() {
        MetaMaterial metaMaterial = (MetaMaterial) getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        String stringExtra = getActivity().getIntent().getStringExtra("local_template_path");
        this.f322281a0 = getActivity().getIntent().getStringExtra("lib_template_id");
        if (metaMaterial == null && !TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.f322281a0)) {
            MetaMaterial P1 = WinkEditorResourceManager.a1().P1(this.f322281a0);
            WinkEditorResourceManager.a1().j0(this.f322281a0);
            return P1;
        }
        return metaMaterial;
    }

    private MusicVolumeControlViewModel ub() {
        Fragment hostFragment = getHostFragment();
        if (this.T == null && hostFragment != null && hostFragment.getActivity() != null) {
            this.T = (MusicVolumeControlViewModel) new ViewModelProvider(hostFragment.getActivity()).get(MusicVolumeControlViewModel.class);
        }
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WinkEditorResourceDownloader.d vb(@NonNull MetaMaterial metaMaterial) {
        return new e(WinkEditorResourceManager.a1().T0(metaMaterial), metaMaterial);
    }

    private void wb() {
        SimpleEventBus.getInstance().dispatchEvent(new WinkTemplateLoadingDialogDismissEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xb() {
        ms.a.a(this.TAG, "hideLoadingForDownload");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.ak
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorVideoTemplateMenuPart.this.Eb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        ms.a.a(this.TAG, "hideLoadingForDownloadDelay");
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.al
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorVideoTemplateMenuPart.this.Fb();
            }
        }, 10L);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f1172170u;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle bundle) {
        WinkEditorTemplatePanel winkEditorTemplatePanel;
        if (bundle == null || !bundle.getBoolean(QQWinkConstants.IS_AUTO_TEMPLATE, false)) {
            super.L9(bundle);
        }
        if (this.f322284d0 && (winkEditorTemplatePanel = this.M) != null && winkEditorTemplatePanel.V() != null) {
            WinkEditorTemplatePanel winkEditorTemplatePanel2 = this.M;
            winkEditorTemplatePanel2.setSelectedMaterial(winkEditorTemplatePanel2.V());
        }
        this.f322284d0 = false;
        cc();
        WinkEditorTemplatePanel winkEditorTemplatePanel3 = this.M;
        if (winkEditorTemplatePanel3 != null) {
            winkEditorTemplatePanel3.t();
        }
        com.tencent.mobileqq.wink.report.e.f326265a.y();
        t53.a.c(getActivity().getIntent(), new Function1() { // from class: com.tencent.mobileqq.wink.editor.template.ag
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Mb;
                Mb = WinkEditorVideoTemplateMenuPart.Mb((WinkDc5507ReportData.a) obj);
                return Mb;
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        super.M9();
        MetaMaterial tb5 = tb();
        if (tb5 != null) {
            com.tencent.mobileqq.wink.editor.c.D1(tb5, WinkEditorResourceManager.a1().m(tb5));
            ec(tb5);
            dr H9 = H9();
            if (H9 != null) {
                H9.j();
            }
        }
        initViewModel();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NonNull
    public MenuType ba() {
        return MenuType.VIDEO_TEMPLATE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(View view) {
        super.initAfterInflation(view);
        Bb(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        super.onDismiss();
        WinkEditorTemplatePanel winkEditorTemplatePanel = this.M;
        if (winkEditorTemplatePanel != null) {
            winkEditorTemplatePanel.R();
            this.M.s();
        }
        qb();
        com.tencent.mobileqq.wink.report.e.f326265a.y();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        super.onPartDestroy(activity);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f322286f0);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        WinkEditorTemplatePanel winkEditorTemplatePanel;
        WinkEditorTemplatePanel winkEditorTemplatePanel2;
        super.onReceiveEvent(simpleBaseEvent);
        boolean z16 = false;
        if (simpleBaseEvent instanceof ReceiveSchemaEvent) {
            HashMap hashMap = (HashMap) ((ReceiveSchemaEvent) simpleBaseEvent).getAttrs();
            if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("template") && !TextUtils.isEmpty((CharSequence) hashMap.get("template"))) {
                if (getHostFragment() != null && getHostFragment().getActivity() != null) {
                    MediaPickerScene mediaPickerScene = (MediaPickerScene) getActivity().getIntent().getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
                    if (mediaPickerScene != null && (mediaPickerScene.equals(MediaPickerScene.TEXT_VIDEO) || mediaPickerScene.equals(MediaPickerScene.TEMPLATE_ZSHOW) || mediaPickerScene.equals(MediaPickerScene.TEMPLATE_ZSHOW_REPLACE))) {
                        return;
                    }
                    I9();
                    String str = (String) hashMap.get("template");
                    this.W = str;
                    if (!TextUtils.isEmpty(str) && "1".equals(hashMap.get(QCircleScheme.AttrQQPublish.HIDE_PLAYER_UNTIL_TEMPLATE_FINISH))) {
                        z16 = true;
                    }
                    this.f322283c0 = z16;
                    this.winkEditorViewModel.h5(true);
                    this.M.l0(this.W);
                    return;
                }
                ms.a.c(this.TAG, "initAfterInflation getactivity() failed");
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof TemplateSelectEvent) {
            TemplateSelectEvent templateSelectEvent = (TemplateSelectEvent) simpleBaseEvent;
            MetaMaterial material = templateSelectEvent.getMaterial();
            boolean needRender = templateSelectEvent.getNeedRender();
            if (aa().isSwitchType && material != null && (winkEditorTemplatePanel2 = this.M) != null) {
                this.M.m0(winkEditorTemplatePanel2.S(material.f30533id));
                aa().isSwitchType = false;
                return;
            }
            if (material != null) {
                if (needRender) {
                    String str2 = material.f30533id;
                    if (str2 != null && (winkEditorTemplatePanel = this.M) != null) {
                        winkEditorTemplatePanel.l0(str2);
                    }
                } else {
                    WinkEditorTemplatePanel winkEditorTemplatePanel3 = this.M;
                    if (winkEditorTemplatePanel3 != null) {
                        winkEditorTemplatePanel3.setSelectedMaterial(material);
                        this.M.setClearButtonEnable(true);
                    }
                }
                Yb();
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof WinkTemplateLoadingDialogDismissEvent) {
            rb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void pa() {
        super.pa();
        pb();
        com.tencent.mobileqq.wink.report.e.f326265a.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c extends com.tencent.mobileqq.wink.flow.b {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes21.dex */
        public class b implements ResDownLoadListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MetaMaterial f322294a;

            b(MetaMaterial metaMaterial) {
                this.f322294a = metaMaterial;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(int i3) {
                if (WinkEditorVideoTemplateMenuPart.this.N != null && WinkEditorVideoTemplateMenuPart.this.N.k0() <= 95) {
                    WinkEditorVideoTemplateMenuPart.this.N.setProgress(i3);
                }
                if (WinkEditorVideoTemplateMenuPart.this.winkEditorViewModel.getIsSchemaTemplate() && WinkEditorVideoTemplateMenuPart.this.R != null && WinkEditorVideoTemplateMenuPart.this.R.f30533id.equals(WinkEditorVideoTemplateMenuPart.this.W)) {
                    WinkEditorVideoTemplateMenuPart.this.winkEditorViewModel.h5(false);
                }
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onDownloadFinish(boolean z16) {
                if (!z16) {
                    WinkEditorVideoTemplateMenuPart.this.Sb();
                    WinkEditorVideoTemplateMenuPart.this.xb();
                } else {
                    WinkEditorResourceManager.a1().i0(this.f322294a);
                    WinkEditorVideoTemplateMenuPart.this.Tb(this.f322294a);
                }
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onProgressUpdate(final int i3) {
                if (i3 > 0 && i3 <= 100) {
                    if (WinkEditorVideoTemplateMenuPart.this.R == null || WinkEditorVideoTemplateMenuPart.this.R.f30533id.equals(this.f322294a.f30533id)) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.az
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkEditorVideoTemplateMenuPart.c.b.this.b(i3);
                            }
                        });
                    }
                }
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i3, @NonNull MetaMaterial metaMaterial) {
            WinkEditorVideoTemplateMenuPart.this.M.setClearButtonEnable(true);
            if (TextUtils.isEmpty(metaMaterial.packageUrl)) {
                WinkEditorVideoTemplateMenuPart.this.M.d0();
                return;
            }
            if (!FileUtils.fileExists(WinkEditorResourceManager.a1().m(metaMaterial))) {
                if (WinkEditorVideoTemplateMenuPart.this.f322283c0 && (WinkEditorVideoTemplateMenuPart.this.H9() instanceof WinkVideoTavCut)) {
                    ((WinkVideoTavCut) WinkEditorVideoTemplateMenuPart.this.H9()).L1(false);
                }
                if (NetworkUtil.isNetworkAvailable()) {
                    WinkEditorVideoTemplateMenuPart.this.R = metaMaterial;
                    WinkEditorVideoTemplateMenuPart.this.ac();
                    WinkEditorResourceManager.a1().f(metaMaterial, WinkEditorVideoTemplateMenuPart.this.vb(metaMaterial));
                    return;
                } else {
                    QQToast.makeText(WinkEditorVideoTemplateMenuPart.this.getContext(), 1, WinkEditorVideoTemplateMenuPart.this.getContext().getString(R.string.ynb), 0).show();
                    WinkEditorVideoTemplateMenuPart.this.M.Q();
                    WinkEditorVideoTemplateMenuPart.this.M.d0();
                    WinkEditorVideoTemplateMenuPart.this.dc(null);
                    return;
                }
            }
            if (WinkEditorResourceManager.a1().o2(metaMaterial)) {
                WinkEditorResourceManager.a1().i0(metaMaterial);
                WinkEditorVideoTemplateMenuPart.this.Tb(metaMaterial);
            } else {
                WinkEditorResourceManager.a1().h0(metaMaterial, new b(metaMaterial));
                WinkEditorVideoTemplateMenuPart.this.ac();
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void Q(int i3, @NonNull MetaMaterial metaMaterial) {
            if (WinkEditorVideoTemplateMenuPart.this.Q) {
                return;
            }
            String string = WinkEditorVideoTemplateMenuPart.this.getContext().getString(R.string.f215195uy);
            if (WinkEditorVideoTemplateMenuPart.this.winkEditorViewModel.u4()) {
                string = WinkEditorVideoTemplateMenuPart.this.getContext().getString(R.string.f216305xy);
            }
            WinkEditorVideoTemplateMenuPart.this.nb(new a(i3, metaMaterial), WinkEditorVideoTemplateMenuPart.this.getContext().getString(R.string.f215205uz), string);
        }

        /* loaded from: classes21.dex */
        class a implements g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f322291a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MetaMaterial f322292b;

            a(int i3, MetaMaterial metaMaterial) {
                this.f322291a = i3;
                this.f322292b = metaMaterial;
            }

            @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.g
            public void onConfirm() {
                c.this.b(this.f322291a, this.f322292b);
            }

            @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.g
            public void onCancel() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements g {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.g
        public void onConfirm() {
            WinkEditorVideoTemplateMenuPart.this.M.setClearButtonEnable(false);
            WinkEditorVideoTemplateMenuPart.this.M.Q();
            WinkEditorVideoTemplateMenuPart.this.dc(null);
            WinkEditorVideoTemplateMenuPart.this.V.a();
        }

        @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.g
        public void onCancel() {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class d implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f322296d;

        d(MetaMaterial metaMaterial) {
            this.f322296d = metaMaterial;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aEResInfo, String str, boolean z16, int i3) {
            ms.a.f(WinkEditorVideoTemplateMenuPart.this.TAG, "bundle load template onDownLoadSuccess" + aEResInfo.agentType + " errorType " + i3);
            if (i3 != 0 && i3 != 1) {
                WinkEditorVideoTemplateMenuPart.this.xb();
                return;
            }
            if (WinkEditorVideoTemplateMenuPart.this.f322282b0 != null && WinkEditorVideoTemplateMenuPart.this.S != null) {
                if (WinkEditorVideoTemplateMenuPart.this.S.T1(WinkEditorVideoTemplateMenuPart.this.S.O1(WinkEditorVideoTemplateMenuPart.this.f322282b0))) {
                    WinkEditorVideoTemplateMenuPart.this.Xb(100);
                    WinkEditorVideoTemplateMenuPart.this.yb();
                    WinkEditorVideoTemplateMenuPart.this.Vb(this.f322296d);
                    return;
                }
                WinkEditorVideoTemplateMenuPart.this.Xb(-1);
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aEResInfo, long j3, long j16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class f implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f322303d;

        f(MetaMaterial metaMaterial) {
            this.f322303d = metaMaterial;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aEResInfo, String str, boolean z16, int i3) {
            ms.a.a(WinkEditorVideoTemplateMenuPart.this.TAG, "bundle load onAEDownloadFinish " + aEResInfo.agentType + " errorType " + i3);
            if (i3 != 0 && i3 != 1) {
                WinkEditorVideoTemplateMenuPart.this.xb();
                return;
            }
            if (WinkEditorVideoTemplateMenuPart.this.f322282b0 != null && WinkEditorVideoTemplateMenuPart.this.S != null) {
                if (WinkEditorVideoTemplateMenuPart.this.S.T1(WinkEditorVideoTemplateMenuPart.this.S.O1(WinkEditorVideoTemplateMenuPart.this.f322282b0))) {
                    WinkEditorVideoTemplateMenuPart.this.Xb(100);
                    WinkEditorVideoTemplateMenuPart.this.yb();
                    WinkEditorVideoTemplateMenuPart.this.dc(this.f322303d);
                    return;
                }
                WinkEditorVideoTemplateMenuPart.this.Xb(-1);
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aEResInfo, long j3, long j16) {
        }
    }
}
