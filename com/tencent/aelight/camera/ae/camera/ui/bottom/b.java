package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView;
import com.tencent.aelight.camera.ae.camera.ui.bottom.c;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.FileMsg;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends AEBottomListPart implements AEBottomListScrollView.a {
    private View I;
    private boolean J;
    private int K;
    private AEVideoStoryTopBarViewModel L;
    private boolean M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements AEBottomListAdapter.a {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.a
        public void a() {
            Intent intent = new Intent();
            intent.setAction("ae_editor_bottom_tab_show_hide");
            intent.putExtra("is_show", false);
            b.this.f62495d.z().sendBroadcast(intent);
            ((com.tencent.aelight.camera.ae.part.b) b.this).mPartManager.q(131076, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.bottom.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0541b implements Observer<AEVideoStoryTopBarViewModel.Ratio> {
        C0541b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.Ratio ratio) {
            AEBottomListAdapter.L(VideoStoryPiecesPart.U0(ratio).f65910g);
            b.this.f62499i.notifyDataSetChanged();
        }
    }

    public b(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.J = false;
        this.K = 0;
        this.M = false;
    }

    private void u0() {
        AEBottomListScrollView aEBottomListScrollView = (AEBottomListScrollView) this.mRootView.findViewById(R.id.s08);
        this.f62498h = aEBottomListScrollView;
        aEBottomListScrollView.setSlideOnFling(true);
        this.f62498h.setItemTransitionTimeMillis(100);
        this.f62498h.setSlideOnFlingThreshold(1000);
        this.f62498h.setOffscreenItems(10);
        this.f62498h.setOnItemChangedListener(this);
        this.f62498h.setScrollStateChangeListener(this);
        this.f62498h.setAEEditMaterialSelectedListener(this);
        this.f62498h.setItemTransformer(new c.a().c(1.0f).b(1.3839f).a());
        AEBottomListAdapter aEBottomListAdapter = new AEBottomListAdapter(this.f62495d, this.f62498h, this.f62500m);
        this.f62499i = aEBottomListAdapter;
        aEBottomListAdapter.N(new a());
        this.f62498h.setAdapter(this.f62499i);
        this.I = this.mRootView.findViewById(R.id.rv_);
        AEMaterialManager aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1);
        this.C = aEMaterialManager;
        aEMaterialManager.g(this, 113);
        this.C.g(this, 112);
        g0();
        Z();
    }

    private void w0(boolean z16) {
        View view = this.I;
        if (view == null) {
            return;
        }
        view.setVisibility((this.J && z16) ? 0 : 8);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
    public boolean W() {
        return true;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart, com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.d
    /* renamed from: d0 */
    public void l(AEBottomListAdapter.b bVar, int i3) {
        super.l(bVar, i3);
        if (v0(bVar, i3)) {
            this.J = false;
            w0(false);
        } else {
            this.J = true;
            w0(true);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart, com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.d
    /* renamed from: e0 */
    public void j(AEBottomListAdapter.b bVar, int i3) {
        super.j(bVar, i3);
        f(false);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.a
    public void f(boolean z16) {
        com.tencent.aelight.camera.ae.part.c cVar = this.mPartManager;
        if (cVar != null) {
            if (z16) {
                cVar.q(FileMsg.TRANSFILE_TYPE_PTT_SLICE_TO_TEXT, new Object[0]);
            } else {
                cVar.q(FileMsg.TRANSFILE_TYPE_LIGHT_VIDEO, new Object[0]);
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart, com.tencent.aelight.camera.ae.part.b
    public void initView() {
        if (this.mRootView != null) {
            u0();
        }
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
    public void initViewModel() {
        super.initViewModel();
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) n.a(this.f62495d).get(AEVideoStoryTopBarViewModel.class);
        this.L = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.f63374m.observe(this.f62495d, new C0541b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
    public void k0(int i3) {
        if (this.M) {
            return;
        }
        this.J = i3 > 0;
        w0(true);
        super.k0(i3);
        this.K = i3;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
    protected void n0() {
        l0();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityPause() {
        super.onActivityPause();
        this.M = true;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart, com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        super.onActivityResume();
        this.M = false;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart, com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        super.send(i3, objArr);
        if (i3 == 786433) {
            this.f62498h.smoothScrollToPosition(0);
            return;
        }
        if (i3 == 786434) {
            w0(false);
            return;
        }
        if (i3 == 786435) {
            w0(true);
            return;
        }
        if (i3 != 131075) {
            if (i3 == 786436) {
                this.f62498h.smoothScrollToPosition(this.K);
            }
        } else {
            AEMaterialMetaData H = AEMaterialManager.H();
            if (H == null || H.equals(AEMaterialMetaData.MATERIAL_NONE)) {
                w0(false);
            }
        }
    }

    private boolean v0(AEBottomListAdapter.b bVar, int i3) {
        return (bVar == null || bVar.f62489d == null || i3 != 0) ? false : true;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart, com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.c
    /* renamed from: b0 */
    public void g(AEBottomListAdapter.b bVar, int i3) {
        if (bVar != null) {
            bVar.d(3);
            AEMaterialMetaData aEMaterialMetaData = bVar.f62489d;
            if (aEMaterialMetaData != null && !"call_material_id".equals(aEMaterialMetaData.f69050id)) {
                this.K = i3;
                if (W()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ext2", aEMaterialMetaData.f69050id);
                    com.tencent.aelight.camera.aebase.c.b(2, hashMap);
                }
            }
            if (aEMaterialMetaData != null && !"0".equals(aEMaterialMetaData.f69050id) && aEMaterialMetaData.editablewatermark) {
                f(true);
            }
            com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().l(aEMaterialMetaData);
            if (this.f62499i != null) {
                if (X(aEMaterialMetaData)) {
                    l.g(this.mActivity, aEMaterialMetaData, 1);
                } else {
                    this.f62499i.B(aEMaterialMetaData);
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
    protected void p0() {
        T(327684);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
    protected void r0() {
        T(327683);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
    protected void s0() {
        T(FileMsg.TRANSFILE_TYPE_ASSISTANT);
    }
}
