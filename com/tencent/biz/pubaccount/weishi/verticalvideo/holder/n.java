package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;
import r10.i;

/* compiled from: P */
/* loaded from: classes32.dex */
public class n extends c implements View.OnClickListener {
    private FeedRichTextView C;
    private TextView D;
    private stSimpleMetaFeed E;
    private WSVerticalPageFragment F;
    private r10.i G;

    public n(Context context, au auVar) {
        super(context);
        if (auVar != null) {
            this.F = auVar.f82128e;
        }
        r10.i iVar = new r10.i(this.f80409d, auVar);
        this.G = iVar;
        iVar.O(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A() {
        if (((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i).f() != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.i.d(this.F, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i, "videotag_rich", 1, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.C.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null && (c16.e() instanceof stSimpleMetaFeed)) {
            stSimpleMetaFeed e16 = c16.e();
            H(e16.feed_desc);
            J(e16.material_desc);
        }
    }

    private void H(String str) {
        if (TextUtils.isEmpty(str)) {
            this.C.setVisibility(8);
        } else {
            this.C.setVisibility(0);
            this.C.setText(str);
        }
    }

    private void I() {
        int b16 = r10.a.f430463a.b();
        if (b16 != 1) {
            if (b16 != 2) {
                return;
            }
            this.G.Q(ba.f81743r);
        } else if (TextUtils.isEmpty(this.C.getText())) {
            this.G.Q(ba.f81740o);
        } else {
            this.G.Q(this.C.getHeight());
        }
    }

    private void J(String str) {
        if (TextUtils.isEmpty(str)) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
            this.D.setText(str);
        }
    }

    private void y() {
        r10.i iVar = this.G;
        if (iVar == null || !iVar.getIsShowScrollComment()) {
            return;
        }
        this.C.setVisibility(4);
    }

    private void z() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.i(this.F, this.E);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.h0(this.F.getFrom(), this.F.getPlayScene(), this.E, this.F.getPresenter().h0());
        com.tencent.biz.pubaccount.weishi.report.dc898.d.i();
    }

    public void C() {
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.z(null);
        }
    }

    public void D() {
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.J();
        }
    }

    public void E() {
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.M();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void j(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        super.j(jVar);
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.j(c());
        }
    }

    public void K() {
        if (this.G == null) {
            return;
        }
        I();
        this.G.T();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.i();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null && (c16.e() instanceof stSimpleMetaFeed)) {
            this.E = c16.e();
        }
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.g();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        G();
        y();
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.h();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.f116806zq) {
            com.tencent.biz.pubaccount.weishi.util.x.b("WSVerticalItemBottomContentController", "\u8df3\u8f6c\u5230\u5fae\u89c6\u7aef\u5185");
            z();
        } else if (view.getId() == R.id.f116796zp) {
            A();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwp;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int i3) {
        G();
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.H(i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int i3) {
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.I(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements i.b {
        a() {
        }

        @Override // r10.i.b
        public void a(boolean z16) {
            if (z16) {
                n.this.B();
            } else {
                n.this.G();
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (FeedRichTextView) p(R.id.f116796zp);
        TextView textView = (TextView) p(R.id.f116806zq);
        this.D = textView;
        textView.setOnClickListener(this);
        r10.i iVar = this.G;
        if (iVar != null) {
            iVar.A(this.f80410e);
        }
        this.C.setOnClickListener(this);
    }
}
