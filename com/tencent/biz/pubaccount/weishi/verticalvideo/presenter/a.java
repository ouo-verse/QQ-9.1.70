package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a extends AbsWSVerticalPagePresenter {
    private WeakReference<com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a> P;
    private boolean Q;

    public a(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
        Z1(O0().De());
    }

    private com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1() {
        WeakReference<com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a> weakReference = this.P;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void X1() {
        x.j("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnLoadGridDataMoreFromServer]");
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (T1 == null) {
            return;
        }
        T1.h(!a2());
    }

    private void Y1() {
        x.j("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnLoadGridDataRefreshFromServer]");
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (T1 == null) {
            return;
        }
        T1.A0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void A0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super.A0(list, hVar);
        x.j("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][fillData]");
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (T1 == null) {
            return;
        }
        T1.c(list);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void H(boolean z16, boolean z17, String str) {
        super.H(z16, z17, str);
        if (this.E) {
            X1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void K1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super.K1(list, hVar);
        x.j("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][setData]");
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (T1 == null) {
            return;
        }
        T1.setData(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void Q1(int i3, String str) {
        super.Q1(i3, str);
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (T1 == null) {
            return;
        }
        T1.onError();
        T1.h(!a2());
        T1.A0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        x.j("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][onPageSelected]");
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (T1 == null || !T1.isShowing()) {
            return;
        }
        T1.d();
    }

    public Map<String, String> U1(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        return new HashMap();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean V() {
        boolean V = super.V();
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (T1 != null && T1.isShowing()) {
            T1.dismiss();
        }
        return V;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void V0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        x.j("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnSuccess]");
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (z17 || z16) {
            Y1();
        }
        c2(z17, T1);
        super.V0(list, z16, z17, obj);
        if (z17 || !z16) {
            X1();
        }
        if (z17 && T1 != null && this.Q) {
            T1.show();
        }
    }

    public String V1() {
        return "";
    }

    public abstract String W1();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void X0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super.X0(list, hVar);
        x.j("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][insertDataToTop]");
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a T1 = T1();
        if (T1 == null) {
            return;
        }
        T1.T(list);
    }

    public abstract boolean a2();

    public abstract boolean b2();

    protected void c2(boolean z16, com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a aVar) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> T9 = O0.T9();
        if (aVar == null || !z16 || T9 == null || T9.size() <= 0) {
            return;
        }
        T9.get(0).setChecked(true);
        aVar.c(T9);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void handleIntent(Bundle bundle) {
        super.handleIntent(bundle);
        this.Q = bundle.getBoolean("auto_show_panel", true);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void p0(String str) {
        super.p0(str);
        if (this.E) {
            Y1();
        }
    }

    public void Z1(com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.f(this);
        this.P = new WeakReference<>(aVar);
        aVar.f(this);
    }
}
