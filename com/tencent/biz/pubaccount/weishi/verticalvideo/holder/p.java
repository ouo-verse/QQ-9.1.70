package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class p extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> implements View.OnClickListener {
    private static final int G = ba.f81728c;
    private TextView C;
    private ImageView D;
    private WSVerticalPageFragment E;
    private stSimpleMetaFeed F;

    public p(Context context, au auVar) {
        super(context);
        if (auVar != null) {
            this.E = auVar.f82128e;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        if (c() == null || c().e() == null) {
            return;
        }
        this.F = c().e();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || c16.e() == null) {
            return;
        }
        stSimpleMetaPerson stsimplemetaperson = c16.e().poster;
        if (stsimplemetaperson != null && !TextUtils.isEmpty(stsimplemetaperson.nick)) {
            this.C.setVisibility(0);
            this.C.setText(String.format("@%s", stsimplemetaperson.nick));
            int l3 = com.tencent.biz.pubaccount.weishi.util.r.l(stsimplemetaperson.medal);
            this.C.setCompoundDrawablePadding(G);
            if (l3 != -1) {
                this.C.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, e().getDrawable(l3), (Drawable) null);
                return;
            } else {
                this.C.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
        }
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwq;
    }

    public void u(int i3) {
        this.D.setVisibility(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getId() == R.id.f116756zl) {
            this.E.getPresenter().X("nickname", this.E, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (TextView) p(R.id.f116756zl);
        this.D = (ImageView) p(R.id.y_l);
        this.C.setOnClickListener(this);
        this.D.setImageResource(R.drawable.f159768gh1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
