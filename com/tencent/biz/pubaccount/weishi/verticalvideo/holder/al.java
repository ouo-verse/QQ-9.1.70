package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class al extends c implements View.OnClickListener {
    private KandianUrlImageView C;
    private View D;
    private TextView E;
    private ez.a F;
    private WSVerticalPageFragment G;
    private boolean H;

    public al(Context context, au auVar) {
        super(context);
        if (auVar != null) {
            this.G = auVar.f82128e;
        }
    }

    private void w() {
        if (this.H) {
            return;
        }
        this.H = true;
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.V(this.G.getFrom(), this.G.getPlayScene(), c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean y() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar;
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16;
        stSimpleMetaFeed e16;
        WSVerticalPageFragment wSVerticalPageFragment = this.G;
        if (wSVerticalPageFragment == null || wSVerticalPageFragment.getAdapter() == null || this.G.getAdapter().z() == null || (jVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.G.getAdapter().z().f82129f) == null || (c16 = c()) == null || (e16 = c16.e()) == null || c16.f() == null) {
            return false;
        }
        return TextUtils.equals(jVar.e().f25129id, e16.f25129id);
    }

    private void z() {
        int x16 = x();
        ez.a aVar = this.F;
        boolean z16 = true;
        if (aVar != null && !TextUtils.isEmpty(aVar.c()) && !TextUtils.isEmpty(this.F.a()) && x16 == 1) {
            z16 = false;
        }
        com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalItemWidgetController", "[updateWidgetBtnContent] des : " + c().e().feed_desc + ", isGone :" + z16);
        this.C.setImageBitmap(null);
        if (z16) {
            this.D.setVisibility(8);
            return;
        }
        this.D.setVisibility(0);
        String c16 = this.F.c();
        String a16 = this.F.a();
        com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalItemWidgetController", "[updateWidgetBtnContent] text:" + c16 + ", iconUrl:" + a16);
        this.E.setText(c16);
        WSPicLoader.g().w(this.C, a16, null);
        if (y()) {
            w();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null) {
            this.F = c16.f();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        z();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.f11697707) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.j(this.G, c());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.f168558fx1;
    }

    public int x() {
        ez.a aVar = this.F;
        if (aVar != null) {
            return aVar.d();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int i3) {
        this.H = false;
        if (this.D.getVisibility() == 0) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.V(this.G.getFrom(), this.G.getPlayScene(), c());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        View p16 = p(R.id.f11697707);
        this.D = p16;
        p16.setOnClickListener(this);
        this.C = (KandianUrlImageView) p(R.id.f11699709);
        this.E = (TextView) p(R.id.f11698708);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int i3) {
    }
}
