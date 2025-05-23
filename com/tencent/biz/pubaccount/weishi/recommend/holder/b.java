package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class b extends com.tencent.biz.pubaccount.weishi.baseui.a<stSimpleMetaFeed> {
    private static final int F = ScreenUtil.dip2px(10.0f);
    private RelativeLayout C;
    private final com.tencent.biz.pubaccount.weishi.t D;
    protected stSimpleMetaFeed E;

    /* renamed from: i, reason: collision with root package name */
    private View f81438i;

    /* renamed from: m, reason: collision with root package name */
    private View f81439m;

    public b(Context context, View view, com.tencent.biz.pubaccount.weishi.t tVar) {
        super(context, view);
        this.D = tVar;
        h();
    }

    private void h() {
        g(R.id.xtg, new d10.f(this.f80416f, this.f80414d, i(), this.D));
        if (m()) {
            g(R.id.xtw, new d10.k(this.f80416f));
        }
        g(R.id.xtm, new d10.i(this.f80416f));
    }

    private void o() {
        this.f81438i.setVisibility(l() ? 0 : 8);
        this.f81438i.setBackgroundResource(j());
    }

    private void p() {
        this.f81439m.setVisibility(k() ? 0 : 8);
    }

    private void q() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (l()) {
            layoutParams.addRule(2, R.id.xth);
            int i3 = F;
            layoutParams.setMargins(i3, 0, i3, 0);
        } else {
            layoutParams.addRule(8, R.id.xtx);
            int i16 = F;
            layoutParams.setMargins(i16, 0, i16, i16);
        }
        this.C.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        this.f81438i = this.f80414d.findViewById(R.id.xth);
        this.f81439m = this.f80414d.findViewById(R.id.xti);
        this.C = (RelativeLayout) this.f80414d.findViewById(R.id.xty);
    }

    protected abstract int i();

    protected int j() {
        return R.drawable.f161254k82;
    }

    protected abstract boolean k();

    protected abstract boolean l();

    protected boolean m() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.a, com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void setData(stSimpleMetaFeed stsimplemetafeed) {
        this.E = stsimplemetafeed;
        o();
        p();
        q();
        super.setData(stsimplemetafeed);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int i3) {
    }
}
