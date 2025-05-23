package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi.util.az;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ax extends b {
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> F;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> G;
    private com.tencent.biz.pubaccount.weishi.verticalvideo.data.j H;
    private int I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ax.this.i() instanceof ah) {
                ((ah) ax.this.i()).F();
            }
        }
    }

    public ax(Context context, au auVar) {
        super(context, auVar);
    }

    private void s() {
        View view = this.D;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new a());
    }

    private void t() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1181273a);
        r rVar = new r(this.C, this.f82126m);
        this.G = rVar;
        rVar.r(viewStub);
    }

    private void u() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1182473m);
        Context context = this.C;
        WSVerticalPageFragment wSVerticalPageFragment = this.f82125i;
        af afVar = new af(context, wSVerticalPageFragment, wSVerticalPageFragment.getPresenter());
        this.F = afVar;
        afVar.r(viewStub);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        super.a();
        WSVerticalPageFragment wSVerticalPageFragment = this.f82125i;
        if (wSVerticalPageFragment != null && !TextUtils.equals(wSVerticalPageFragment.getFrom(), "aio_home_page")) {
            u();
        }
        t();
        s();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
        j10.a aVar = new j10.a();
        aVar.f409063a = r();
        aVar.f409065c = 3;
        aVar.f409066d = this.I;
        aVar.f409067e = com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f82125i.getFrom());
        aVar.f409068f = this.f82125i.getPlayScene();
        aVar.f409069g = "more_operations";
        aVar.b(this.f82125i);
        az.k(this.C, aVar);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.N(this.f82125i.getFrom(), this.f82125i.getPlayScene(), r());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void onPageSelected(int i3) {
        super.onPageSelected(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: q */
    public void setData(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        super.setData(jVar);
        this.H = jVar;
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.F;
        if (bVar != null) {
            bVar.j(jVar);
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar2 = this.G;
        if (bVar2 != null) {
            bVar2.j(jVar);
        }
    }

    public stSimpleMetaFeed r() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = this.H;
        if (jVar == null || !(jVar.e() instanceof stSimpleMetaFeed)) {
            return null;
        }
        return this.H.e();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void recycle() {
        super.recycle();
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.F;
        if (bVar != null) {
            bVar.i();
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar2 = this.G;
        if (bVar2 != null) {
            bVar2.i();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void setPosition(int i3) {
        super.setPosition(i3);
        this.I = i3;
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.F;
        if (bVar != null) {
            bVar.k(i3);
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar2 = this.G;
        if (bVar2 != null) {
            bVar2.k(i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int i3) {
    }
}
