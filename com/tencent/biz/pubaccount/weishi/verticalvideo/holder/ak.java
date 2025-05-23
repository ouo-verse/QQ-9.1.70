package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.view.ViewStub;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ak extends c {
    private al C;
    private ViewStub D;
    private final au E;

    public ak(Context context, au auVar) {
        super(context);
        this.E = auVar;
    }

    private void w(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        if (this.C == null) {
            al alVar = new al(this.f80409d, this.E);
            this.C = alVar;
            alVar.r(this.D);
        }
        this.C.j(jVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        al alVar = this.C;
        if (alVar != null) {
            alVar.i();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.f168557fx0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int i3) {
        al alVar = this.C;
        if (alVar != null) {
            alVar.u(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int i3) {
        al alVar = this.C;
        if (alVar != null) {
            alVar.v(i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void j(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        super.j(jVar);
        w(jVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.D = (ViewStub) p(R.id.f11695705);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }
}
