package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.event.WSClearModeEvent;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class s extends j {
    private ImageView P;
    protected TextView Q;
    protected TextView R;
    private boolean S;

    public s(Context context, au auVar) {
        super(context, auVar);
    }

    private void a0() {
        wz.b.b().a(new WSClearModeEvent(!this.S));
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.s(this.C.getFrom(), this.C.getPlayScene(), this.C.Th(), this.C.getPresenter().h0());
    }

    private void b0() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.f(this.C, c());
    }

    private void c0() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.g(this.C, z());
    }

    private void e0(boolean z16) {
        ImageView imageView = this.P;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(z16 ? R.drawable.gnq : R.drawable.gnr);
    }

    private void g0() {
        m(this.Q, K());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j
    public boolean I() {
        return super.I() && !this.S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j
    public boolean J() {
        return super.J() && !this.S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j
    public boolean K() {
        return super.K() && !this.S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j
    public boolean L() {
        return super.L() && !this.S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j
    public boolean M() {
        return super.M() && !this.S;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    /* renamed from: R */
    public void j(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        super.j(jVar);
    }

    public void Y() {
        t tVar = this.L;
        if (tVar != null) {
            tVar.x();
        }
    }

    public void d0(boolean z16) {
        this.S = z16;
        e0(z16);
        m(this.I, L());
        m(this.G, I());
        m(this.Q, K());
        m(this.R, J());
        t tVar = this.L;
        if (tVar != null) {
            tVar.P(M());
        }
    }

    public void f0() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.g d16;
        Drawable b16;
        String string;
        m(this.R, J());
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || (d16 = c16.d()) == null) {
            return;
        }
        if (d16.b().dramaInfo.isFollowed) {
            b16 = com.tencent.biz.pubaccount.weishi.util.ag.b(R.drawable.gnt);
            int i3 = this.M;
            b16.setBounds(0, 0, i3, i3);
            string = this.f80409d.getResources().getString(R.string.x85);
        } else {
            b16 = com.tencent.biz.pubaccount.weishi.util.ag.b(R.drawable.gnu);
            int i16 = this.M;
            b16.setBounds(0, 0, i16, i16);
            string = this.f80409d.getResources().getString(R.string.x89);
        }
        this.R.setCompoundDrawables(null, b16, null, null);
        this.R.setText(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void h() {
        super.h();
        g0();
        f0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id5 = view.getId();
        if (id5 == R.id.p3q) {
            b0();
        } else if (id5 == R.id.p8k) {
            a0();
        } else {
            if (id5 != R.id.p8m) {
                return;
            }
            c0();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.j, com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        super.s();
        TextView textView = (TextView) p(R.id.p8m);
        this.Q = textView;
        textView.setOnClickListener(this);
        Drawable b16 = com.tencent.biz.pubaccount.weishi.util.ag.b(R.drawable.ggs);
        int i3 = this.M;
        b16.setBounds(0, 0, i3, i3);
        this.Q.setCompoundDrawables(null, b16, null, null);
        TextView textView2 = (TextView) p(R.id.p3q);
        this.R = textView2;
        textView2.setOnClickListener(this);
    }

    public void Z(boolean z16) {
        if (z16) {
            ImageView imageView = (ImageView) ((ViewStub) p(R.id.f163279p92)).inflate();
            this.P = imageView;
            imageView.setOnClickListener(this);
        }
    }
}
