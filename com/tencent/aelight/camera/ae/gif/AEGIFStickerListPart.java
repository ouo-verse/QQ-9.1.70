package com.tencent.aelight.camera.ae.gif;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.data.AEGifCategoryWrapper;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.font.AEFontManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.AbsSlidingIndicator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sq.c;

/* loaded from: classes32.dex */
public class AEGIFStickerListPart extends com.tencent.aelight.camera.ae.part.b implements AbsSlidingIndicator.f {
    private Pair<String[], int[]> C;
    private List<AEGifCategoryWrapper> D;
    private RecyclerView E;
    private LinearLayoutManager F;
    private sq.c G;
    private List<AEMaterialWrapper> H;
    private String I;
    private String J;
    private String K;
    private Dialog L;
    private boolean M;
    private boolean N;
    private boolean P;

    /* renamed from: d, reason: collision with root package name */
    private Context f65298d;

    /* renamed from: e, reason: collision with root package name */
    private AEPituCameraUnit f65299e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f65300f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.a f65301h;

    /* renamed from: i, reason: collision with root package name */
    private AEVideoStoryGIFTplViewModel f65302i;

    /* renamed from: m, reason: collision with root package name */
    private SimpleSlidingIndicator f65303m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ms.a.a("AEGIFStickerListPart", "[mTakeSameLoadingDialog.onCancel]");
            AEGIFStickerListPart.this.K = null;
            AEGifMaterialManager.o().A();
        }
    }

    /* loaded from: classes32.dex */
    class b implements c.b {
        b() {
        }

        @Override // sq.c.b
        public void a(AEMaterialWrapper aEMaterialWrapper) {
            AEGIFStickerListPart.this.T(aEMaterialWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Observer<Boolean> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            AEGifMaterialManager.o().A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements jf0.c {
        h() {
        }

        @Override // jf0.c
        public void onStart() {
            AEGIFStickerListPart.this.f65303m.setVisibility(0);
            AEGIFStickerListPart.this.E.setVisibility(0);
        }
    }

    public AEGIFStickerListPart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.M = false;
        this.N = false;
        this.f65298d = view.getContext();
        this.f65299e = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<String[], int[]> L(List<AEGifCategoryWrapper> list) {
        String str;
        if (CollectionUtils.isEmpty(list)) {
            return new Pair<>(new String[0], new int[0]);
        }
        String[] strArr = new String[list.size()];
        int[] iArr = new int[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            AEGifCategoryWrapper aEGifCategoryWrapper = list.get(i3);
            if (aEGifCategoryWrapper != null && !TextUtils.isEmpty(aEGifCategoryWrapper.categoryName)) {
                str = aEGifCategoryWrapper.categoryName;
            } else {
                str = "";
            }
            strArr[i3] = str;
            iArr[i3] = i3;
        }
        return new Pair<>(strArr, iArr);
    }

    private Pair<Integer, Integer> M(List<AEGifCategoryWrapper> list) {
        AEGifCategoryWrapper aEGifCategoryWrapper;
        int i3;
        AEMaterialWrapper aEMaterialWrapper;
        if (TextUtils.isEmpty(this.K)) {
            ms.a.f("AEGIFStickerListPart", "[findLastSelectedPosition] mPendingApplyGIFId is empty");
            return null;
        }
        int i16 = -1;
        if (!TextUtils.isEmpty(this.I)) {
            i3 = 0;
            while (i3 < list.size()) {
                aEGifCategoryWrapper = list.get(i3);
                if (aEGifCategoryWrapper != null && !TextUtils.isEmpty(aEGifCategoryWrapper.categoryId) && aEGifCategoryWrapper.categoryId.equals(this.I)) {
                    break;
                }
                i3++;
            }
        }
        aEGifCategoryWrapper = null;
        i3 = -1;
        if (aEGifCategoryWrapper != null && !CollectionUtils.isEmpty(aEGifCategoryWrapper.materialWrapperList)) {
            for (int i17 = 0; i17 < aEGifCategoryWrapper.materialWrapperList.size(); i17++) {
                aEMaterialWrapper = aEGifCategoryWrapper.materialWrapperList.get(i17);
                if (aEMaterialWrapper != null && !TextUtils.isEmpty(aEMaterialWrapper.f63553a) && aEMaterialWrapper.f63553a.equals(this.K)) {
                    i16 = i17;
                    break;
                }
            }
        }
        aEMaterialWrapper = null;
        if (aEMaterialWrapper == null) {
            for (int i18 = 0; i18 < list.size(); i18++) {
                AEGifCategoryWrapper aEGifCategoryWrapper2 = list.get(i18);
                if (aEGifCategoryWrapper2 != null && !CollectionUtils.isEmpty(aEGifCategoryWrapper2.materialWrapperList)) {
                    int i19 = 0;
                    while (true) {
                        if (i19 >= aEGifCategoryWrapper2.materialWrapperList.size()) {
                            break;
                        }
                        AEMaterialWrapper aEMaterialWrapper2 = aEGifCategoryWrapper2.materialWrapperList.get(i19);
                        if (aEMaterialWrapper2 != null && !TextUtils.isEmpty(aEMaterialWrapper2.f63553a) && aEMaterialWrapper2.f63553a.equals(this.K)) {
                            i3 = i18;
                            i16 = i19;
                            aEMaterialWrapper = aEMaterialWrapper2;
                            break;
                        }
                        i19++;
                    }
                    if (aEMaterialWrapper != null) {
                        break;
                    }
                }
            }
        }
        if (aEMaterialWrapper != null) {
            ms.a.f("AEGIFStickerListPart", "[findLastSelectedPosition] found tabPosition=" + i3 + ", itemPosition=" + i16);
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
        }
        ms.a.f("AEGIFStickerListPart", "[findLastSelectedPosition] not found");
        return null;
    }

    private boolean N(String str, String str2) {
        return (TextUtils.isEmpty(str) || !AECaptureMode.GIF.name.equals(str) || TextUtils.isEmpty(str2)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Dialog dialog;
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || (dialog = this.L) == null || !dialog.isShowing()) {
            return;
        }
        ms.a.a("AEGIFStickerListPart", "[hideTakeSameLoading], dismiss dialog");
        this.L.dismiss();
    }

    private void P(Intent intent) {
        String stringExtra = intent.getStringExtra(IAECameraUnit.KEY_CURRENT_SELECT_ID);
        String stringExtra2 = intent.getStringExtra(IAECameraUnit.KEY_CURRENT_TAB);
        ms.a.a("AEGIFStickerListPart", "[initTakeSame], bottomTab=" + stringExtra2 + ", materialId=" + stringExtra);
        boolean N = N(stringExtra2, stringExtra);
        this.M = N;
        if (N) {
            this.K = stringExtra;
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q() {
        Boolean value;
        com.tencent.aelight.camera.ae.part.a aVar = this.f65301h;
        if (aVar == null || (value = aVar.N1().getValue()) == null) {
            return false;
        }
        return value.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, Integer> R(List<AEGifCategoryWrapper> list) {
        Object obj;
        if (list.size() == 0) {
            return null;
        }
        AEGifCategoryWrapper aEGifCategoryWrapper = list.get(0);
        if (CollectionUtils.isEmpty(aEGifCategoryWrapper.materialWrapperList)) {
            return null;
        }
        if (aEGifCategoryWrapper.materialWrapperList.get(0) != null && aEGifCategoryWrapper.materialWrapperList.get(0).f63559g != 1) {
            AEMaterialWrapper aEMaterialWrapper = new AEMaterialWrapper();
            aEMaterialWrapper.f63559g = 1;
            aEMaterialWrapper.f63553a = "none";
            aEGifCategoryWrapper.materialWrapperList.add(0, aEMaterialWrapper);
        }
        Pair<Integer, Integer> M = M(list);
        if (M != null && (obj = M.first) != null && M.second != null) {
            list.get(((Integer) obj).intValue()).selected = true;
        } else {
            list.get(0).selected = true;
        }
        return M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final String str) {
        AEVideoStoryGIFTplViewModel aEVideoStoryGIFTplViewModel = this.f65302i;
        if (aEVideoStoryGIFTplViewModel != null) {
            aEVideoStoryGIFTplViewModel.S1().postValue(str);
        }
        if (TextUtils.isEmpty(str) || AEFontManager.d().e(str) != Typeface.DEFAULT) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.9
            @Override // java.lang.Runnable
            public void run() {
                String D = AEEditorResourceManager.J().D(str, 1);
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                AEFontManager.d().c(str, D);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(AEMaterialWrapper aEMaterialWrapper) {
        this.f65302i.M1(aEMaterialWrapper);
        if (aEMaterialWrapper == null) {
            this.f65302i.N1(null);
            this.K = null;
            return;
        }
        this.K = aEMaterialWrapper.f63553a;
        int i3 = aEMaterialWrapper.f63558f;
        if (i3 == 0) {
            this.f65302i.P1(aEMaterialWrapper);
        } else {
            if (i3 != 2) {
                return;
            }
            this.f65302i.N1(aEMaterialWrapper);
        }
    }

    private void U() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.L == null) {
            ReportDialog reportDialog = new ReportDialog(this.mActivity, R.style.qZoneInputDialog);
            this.L = reportDialog;
            reportDialog.setCancelable(true);
            this.L.setCanceledOnTouchOutside(true);
            this.L.setContentView(R.layout.f168383uh);
            ((TextView) this.L.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.y8r);
            this.L.setOnCancelListener(new a());
        }
        if (this.L.isShowing()) {
            return;
        }
        ms.a.a("AEGIFStickerListPart", "[showTakeSameLoading], show dialog");
        this.L.show();
    }

    private void initViewModel() {
        com.tencent.aelight.camera.ae.mode.c cVar = (com.tencent.aelight.camera.ae.mode.c) n.a(this.f65299e).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.f65300f = cVar;
        cVar.f65622i.observe(this.f65299e, new c());
        this.f65300f.C.observe(this.f65299e, new d());
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) n.a(this.f65299e).get(com.tencent.aelight.camera.ae.part.a.class);
        this.f65301h = aVar;
        aVar.M1().observe(this.f65299e, new e());
        AEVideoStoryGIFTplViewModel aEVideoStoryGIFTplViewModel = (AEVideoStoryGIFTplViewModel) n.a(this.f65299e).get(AEVideoStoryGIFTplViewModel.class);
        this.f65302i = aEVideoStoryGIFTplViewModel;
        aEVideoStoryGIFTplViewModel.T1().observe(this.f65299e, new f());
        com.tencent.aelight.camera.ae.config.b.b().observe(this.f65299e, new g());
        com.tencent.aelight.camera.ae.config.b.c().observe(this.f65299e, new Observer<Boolean>() { // from class: com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.7
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(Boolean bool) {
                Object obj;
                Object obj2;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                AEGIFStickerListPart.this.O();
                List<AEGifCategoryWrapper> w3 = AEGifMaterialManager.o().w(2);
                if (w3.size() > 0) {
                    Pair R = AEGIFStickerListPart.this.R(w3);
                    final int i3 = 0;
                    final int intValue = (R == null || (obj2 = R.first) == null) ? 0 : ((Integer) obj2).intValue();
                    if (R != null && (obj = R.second) != null) {
                        i3 = ((Integer) obj).intValue();
                    }
                    AEGIFStickerListPart.this.I = w3.get(intValue).categoryId;
                    AEGIFStickerListPart.this.S(w3.get(intValue).fontId);
                    if (AEGIFStickerListPart.this.M) {
                        if (intValue == 0 && i3 == 0 && !AEGIFStickerListPart.this.N) {
                            QQToast.makeText(AEGIFStickerListPart.this.f65299e.z(), R.string.y0q, 1).show();
                        }
                        AEGIFStickerListPart.this.N = true;
                    }
                    AEGIFStickerListPart.this.D.clear();
                    AEGIFStickerListPart.this.D.addAll(w3);
                    AEGIFStickerListPart aEGIFStickerListPart = AEGIFStickerListPart.this;
                    aEGIFStickerListPart.C = aEGIFStickerListPart.L(w3);
                    AEGIFStickerListPart.this.f65303m.setTabData((String[]) AEGIFStickerListPart.this.C.first, (int[]) AEGIFStickerListPart.this.C.second);
                    AEGIFStickerListPart.this.f65303m.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AEGIFStickerListPart.this.f65303m.setCurrentPosition(intValue, false);
                        }
                    });
                    AEGIFStickerListPart.this.H.clear();
                    AEGIFStickerListPart.this.H.addAll(((AEGifCategoryWrapper) AEGIFStickerListPart.this.D.get(intValue)).materialWrapperList);
                    AEGIFStickerListPart.this.G.notifyDataSetChanged();
                    AEGIFStickerListPart.this.E.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AEGIFStickerListPart.this.G.z(i3);
                        }
                    });
                    AEMaterialWrapper aEMaterialWrapper = ((AEGifCategoryWrapper) AEGIFStickerListPart.this.D.get(intValue)).materialWrapperList.get(i3);
                    if (aEMaterialWrapper.f63559g == 1) {
                        AEGIFStickerListPart.this.T(null);
                    } else {
                        AEGIFStickerListPart.this.T(aEMaterialWrapper);
                    }
                    if (TextUtils.isEmpty(AEGIFStickerListPart.this.J) && intValue == 0) {
                        AEGIFStickerListPart aEGIFStickerListPart2 = AEGIFStickerListPart.this;
                        aEGIFStickerListPart2.J = ((AEGifCategoryWrapper) aEGIFStickerListPart2.D.get(intValue)).categoryId;
                        if (AEGIFStickerListPart.this.f65300f == null || !AEGIFStickerListPart.this.f65300f.N1()) {
                            return;
                        }
                        AEBaseReportParam.U().M0(AEGIFStickerListPart.this.J);
                        com.tencent.aelight.camera.ae.report.b.b().Z0();
                    }
                }
            }
        });
        if (this.M) {
            return;
        }
        AEGifMaterialManager.o().A();
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator.f
    public int I0(int i3, boolean z16) {
        AEGifCategoryWrapper aEGifCategoryWrapper = this.D.get(i3);
        if (TextUtils.isEmpty(this.J) || !this.J.equals(aEGifCategoryWrapper.categoryId)) {
            this.J = aEGifCategoryWrapper.categoryId;
            AEBaseReportParam.U().M0(this.J);
            com.tencent.aelight.camera.ae.report.b.b().Z0();
        }
        if (!z16) {
            return 0;
        }
        this.I = aEGifCategoryWrapper.categoryId;
        S(aEGifCategoryWrapper.fontId);
        this.H.clear();
        this.H.addAll(aEGifCategoryWrapper.materialWrapperList);
        this.G.A();
        this.G.notifyDataSetChanged();
        this.F.scrollToPositionWithOffset(0, 0);
        AEMaterialWrapper aEMaterialWrapper = CollectionUtils.isEmpty(aEGifCategoryWrapper.materialWrapperList) ? null : aEGifCategoryWrapper.materialWrapperList.get(0);
        T((aEMaterialWrapper == null || aEMaterialWrapper.f63559g != 1) ? aEMaterialWrapper : null);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        if (this.mRootView == null) {
            return;
        }
        this.P = i.b();
        this.D = new LinkedList();
        this.C = new Pair<>(new String[0], new int[0]);
        this.H = new LinkedList();
        SimpleSlidingIndicator simpleSlidingIndicator = (SimpleSlidingIndicator) this.mRootView.findViewById(R.id.rnb);
        this.f65303m = simpleSlidingIndicator;
        simpleSlidingIndicator.setOnTabListener(this);
        if (this.P) {
            this.f65303m.setCheckedTextColor(this.f65298d.getResources().getColor(R.color.f9108r));
            this.f65303m.setUnCheckedTextColor(this.f65298d.getResources().getColor(R.color.f9128t));
            this.f65303m.setIndicatorColor(this.f65298d.getResources().getColor(R.color.f9118s));
            this.f65303m.o(255);
        }
        this.E = (RecyclerView) this.mRootView.findViewById(R.id.rnc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f65298d, 0, false);
        this.F = linearLayoutManager;
        this.E.setLayoutManager(linearLayoutManager);
        this.E.setItemAnimator(null);
        sq.c cVar = new sq.c(this.mRootView.getContext(), this.H);
        this.G = cVar;
        cVar.D(new b());
        this.E.setAdapter(this.G);
        this.f65303m.setVisibility(8);
        this.E.setVisibility(8);
        P(this.mActivity.getIntent());
        initViewModel();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        super.onActivityResume();
        com.tencent.aelight.camera.ae.mode.c cVar = this.f65300f;
        if (cVar == null || !cVar.N1()) {
            return;
        }
        com.tencent.aelight.camera.ae.report.b.b().Y0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AEGIFStickerListPart.this.f65303m.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            AEGIFStickerListPart.this.f65303m.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) AEGIFStickerListPart.this.E.getLayoutParams();
            marginLayoutParams2.topMargin = 0;
            AEGIFStickerListPart.this.E.setLayoutParams(marginLayoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        ViewAnimator.j(this.f65303m, this.E).a(0.0f, 1.0f).c(300L).h(new h()).k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<AECaptureModeChangingEvent> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            if (aECaptureModeChangingEvent == null) {
                return;
            }
            AECaptureMode aECaptureMode = aECaptureModeChangingEvent.f65599b;
            if (aECaptureMode == AECaptureMode.NORMAL) {
                AEGIFStickerListPart.this.f65303m.setVisibility(8);
                AEGIFStickerListPart.this.E.setVisibility(8);
                return;
            }
            if (aECaptureMode == AECaptureMode.GIF) {
                AEGIFStickerListPart.this.V();
                AEFontManager.d().f();
                com.tencent.aelight.camera.ae.report.b.b().Y0();
                if (aECaptureModeChangingEvent.f65598a == null || TextUtils.isEmpty(AEGIFStickerListPart.this.J)) {
                    return;
                }
                AEBaseReportParam.U().M0(AEGIFStickerListPart.this.J);
                com.tencent.aelight.camera.ae.report.b.b().Z0();
                return;
            }
            if (aECaptureMode == AECaptureMode.PLAY) {
                AEGIFStickerListPart.this.f65303m.setVisibility(8);
                AEGIFStickerListPart.this.E.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            Intent intent = AEGIFStickerListPart.this.f65299e.z().getIntent();
            if (intent != null) {
                intent.getIntExtra(AECameraConstants.AECAMERA_MODE, 200);
            }
            if (AEGIFStickerListPart.this.f65300f.N1()) {
                AEGIFStickerListPart.this.f65303m.setVisibility(bool.booleanValue() ? 0 : 4);
                AEGIFStickerListPart.this.E.setVisibility(bool.booleanValue() ? 0 : 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<com.tencent.aelight.camera.ae.download.a> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.aelight.camera.ae.download.a aVar) {
            AEMaterialWrapper aEMaterialWrapper;
            if (aVar == null) {
                return;
            }
            boolean Q = AEGIFStickerListPart.this.Q();
            if (Q) {
                AEGIFStickerListPart.this.K = null;
            }
            Iterator it = AEGIFStickerListPart.this.H.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AEMaterialWrapper aEMaterialWrapper2 = (AEMaterialWrapper) it.next();
                if (aEMaterialWrapper2.f63553a.equals(aVar.f63646a.f30533id)) {
                    int i3 = aEMaterialWrapper2.f63558f;
                    int i16 = aVar.f63647b;
                    if (i3 != i16) {
                        aEMaterialWrapper2.f63558f = i16;
                        AEGIFStickerListPart.this.G.w(aEMaterialWrapper2, Q);
                    }
                    if (aEMaterialWrapper2.f63558f == 2 && aEMaterialWrapper2.f63553a.equals(AEGIFStickerListPart.this.G.v()) && !Q) {
                        AEGIFStickerListPart.this.f65302i.N1(aEMaterialWrapper2);
                    }
                }
            }
            for (AEGifCategoryWrapper aEGifCategoryWrapper : AEGIFStickerListPart.this.D) {
                if (aEGifCategoryWrapper != null && !CollectionUtils.isEmpty(aEGifCategoryWrapper.materialWrapperList)) {
                    Iterator<AEMaterialWrapper> it5 = aEGifCategoryWrapper.materialWrapperList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            aEMaterialWrapper = null;
                            break;
                        }
                        aEMaterialWrapper = it5.next();
                        if (aEMaterialWrapper != null && !TextUtils.isEmpty(aEMaterialWrapper.f63553a) && aEMaterialWrapper.f63553a.equals(aVar.f63646a.f30533id)) {
                            break;
                        }
                    }
                    if (aEMaterialWrapper != null) {
                        int i17 = aEMaterialWrapper.f63558f;
                        int i18 = aVar.f63647b;
                        if (i17 != i18) {
                            aEMaterialWrapper.f63558f = i18;
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }
}
