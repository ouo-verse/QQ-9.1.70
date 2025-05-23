package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class s extends AbsWSVerticalPagePresenter {
    private jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> P;
    private int Q;
    private String R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ jz.c f82276d;

        a(jz.c cVar) {
            this.f82276d = cVar;
        }

        @Override // jz.c
        public void d0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
            jz.c cVar = this.f82276d;
            if (cVar != null) {
                cVar.d0(list, z16, z17, null);
            }
        }

        @Override // jz.c
        public void i(int i3, String str, boolean z16, boolean z17) {
            jz.c cVar = this.f82276d;
            if (cVar != null) {
                cVar.i(-1, "task failed.", z16, z17);
            }
        }
    }

    public s(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    private jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> T1(jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> cVar) {
        jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> cVar2 = this.P;
        if (cVar2 != null) {
            return cVar2;
        }
        a aVar = new a(cVar);
        this.P = aVar;
        return aVar;
    }

    private String U1() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null) {
            return O0.mg();
        }
        return "";
    }

    private void V1(boolean z16, boolean z17) {
        w00.e.b().a(getFrom(), U1()).a(new w00.c(z17, z16, this.R, new ArrayList(), 10014, this.Q));
    }

    private String getFrom() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (!(O0 instanceof WSVerticalPageFragment)) {
            return "works_in_profile";
        }
        int i3 = ((WSVerticalPageFragment) O0).getArguments().getInt(MiniAppPlugin.ATTR_PAGE_TYPE, 1);
        this.Q = i3;
        if (i3 == 1) {
            return "works_in_profile";
        }
        return "praise_in_profile";
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        return w00.e.b().a(getFrom(), U1()).getDataList();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean V() {
        boolean V = super.V();
        w00.e.b().a(getFrom(), U1()).c(T1(this));
        return V;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void c() {
        super.c();
        w00.e.b().a(getFrom(), U1()).b(T1(this));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void handleIntent(Bundle bundle) {
        super.handleIntent(bundle);
        if (bundle == null) {
            return;
        }
        this.Q = bundle.getInt(MiniAppPlugin.ATTR_PAGE_TYPE, 1);
        this.R = bundle.getString("person_id");
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int p(int i3) {
        return i3 + 1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void s0() {
        super.s0();
        yz.i.f451583a.n(new yz.g(this.R, this.Q, w00.e.b().a(getFrom(), U1())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void x0(String str, WSVerticalPageFragment wSVerticalPageFragment, stSimpleMetaFeed stsimplemetafeed) {
        if (!TextUtils.equals(this.R, stsimplemetafeed.poster.f25130id)) {
            super.x0(str, wSVerticalPageFragment, stsimplemetafeed);
        } else {
            if (wSVerticalPageFragment == null || wSVerticalPageFragment.getQBaseActivity() == null) {
                return;
            }
            wSVerticalPageFragment.getQBaseActivity().doOnBackPressed();
            G1(str, wSVerticalPageFragment, stsimplemetafeed, 2);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(boolean z16, boolean z17, String str) {
        if (z17) {
            return false;
        }
        V1(z16, false);
        return true;
    }
}
