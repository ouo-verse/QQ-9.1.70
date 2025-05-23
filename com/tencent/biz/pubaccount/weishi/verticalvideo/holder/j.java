package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stCallWeishiButton;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.WSNumUtil;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalForDramaPresenter;
import com.tencent.mobileqq.R;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class j extends c implements View.OnClickListener {
    protected WSVerticalPageFragment C;
    private ImageView D;
    private ImageView E;
    private TextView F;
    protected TextView G;
    private ViewGroup H;
    protected ViewGroup I;
    private ViewStub J;
    private final au K;
    protected t L;
    protected final int M;
    private final ConcurrentHashMap<String, Bitmap> N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.image.b {
        a() {
        }

        @Override // iy.a
        public void a(URL url, Object obj) {
            j.this.E(url, obj);
        }

        @Override // com.tencent.biz.pubaccount.weishi.image.b, iy.a
        public void c(URL url, Throwable th5) {
            super.c(url, th5);
            com.tencent.biz.pubaccount.weishi.util.x.j("WSVerticalItemBasicOperationController", "onLoadFailed url:" + url);
        }
    }

    public j(Context context, au auVar) {
        super(context);
        this.M = com.tencent.biz.pubaccount.weishi.verticalvideo.a.f81840a.a();
        this.N = new ConcurrentHashMap<>();
        this.K = auVar;
        if (auVar != null) {
            this.C = auVar.f82128e;
            this.H = (ViewGroup) auVar.itemView;
        }
    }

    private Bitmap A() {
        String C = C("ding_alien_url_post");
        if (TextUtils.isEmpty(C)) {
            return null;
        }
        return this.N.get(C);
    }

    private Bitmap B() {
        String C = C("ding_alien_url_pre");
        if (TextUtils.isEmpty(C)) {
            return null;
        }
        return this.N.get(C);
    }

    private String C(String str) {
        Map<String, String> map;
        String str2;
        stSimpleMetaFeed z16 = z();
        return (z16 == null || (map = z16.map_ext) == null || (str2 = map.get(str)) == null) ? "" : str2;
    }

    private int D() {
        stSimpleMetaFeed z16 = z();
        if (z16 != null) {
            return z16.ding_count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(URL url, Object obj) {
        if (!(obj instanceof com.tencent.mobileqq.kandian.base.image.imageloader.a)) {
            com.tencent.biz.pubaccount.weishi.util.x.j("WSVerticalItemBasicOperationController", "handleOnLoadLikeIconSuccess url:" + url + ", closeableBitmap:" + obj);
            return;
        }
        Bitmap bitmap = ((com.tencent.mobileqq.kandian.base.image.imageloader.a) obj).get();
        if (bitmap == null) {
            com.tencent.biz.pubaccount.weishi.util.x.j("WSVerticalItemBasicOperationController", "handleOnLoadLikeIconSuccess bitmap is null! url:" + url);
            return;
        }
        if (url != null && !TextUtils.isEmpty(url.toString())) {
            this.N.put(url.toString(), bitmap);
        }
        if (x()) {
            X();
        }
    }

    private boolean F() {
        return (B() == null || A() == null) ? false : true;
    }

    private void G() {
        t y16 = t.y(this.f80409d, this.K);
        this.L = y16;
        y16.r(this.J);
    }

    private boolean H() {
        stSimpleMetaFeed z16 = z();
        return z16 != null && z16.is_ding == 1;
    }

    private void N(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        WSPicLoader.g().d(str, this.D.getWidth(), this.D.getHeight(), new a());
    }

    private void O() {
        WSVerticalPageFragment wSVerticalPageFragment = this.C;
        if (wSVerticalPageFragment == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.z(wSVerticalPageFragment.getFrom(), this.C.getPlayScene(), z(), this.C.getPresenter().h0());
        WsCommentPresenter Ue = this.C.Ue();
        if (Ue == null) {
            com.tencent.biz.pubaccount.weishi.util.x.l("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        } else {
            com.tencent.biz.pubaccount.weishi.util.x.l("comment", "\u590d\u7528 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            Ue.v0(d()).m0(com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.C.getFrom()), this.C.getPlayScene()).r0(z()).t0(1).w0();
        }
    }

    private void S() {
        this.D.setImageResource(R.drawable.gga);
        this.D.setSelected(H());
        this.E.setVisibility(8);
    }

    private void W() {
        if (x()) {
            return;
        }
        S();
        N(C("ding_alien_url_pre"));
        N(C("ding_alien_url_post"));
    }

    private void X() {
        if (F()) {
            WSNumUtil.e(this.F, D(), "0");
        } else if (D() > 0) {
            WSNumUtil.e(this.F, D(), "0");
        } else {
            this.F.setText(R.string.f169725x90);
        }
    }

    private boolean x() {
        Bitmap B = B();
        Bitmap A = A();
        if (B == null || A == null) {
            return false;
        }
        ImageView imageView = this.D;
        if (H()) {
            B = A;
        }
        imageView.setImageBitmap(B);
        return true;
    }

    private int y() {
        stSimpleMetaFeed z16 = z();
        if (z16 == null) {
            return 0;
        }
        com.tencent.biz.pubaccount.weishi.util.x.l("comment", "itemInfo hashCode:" + z16.hashCode());
        return z16.total_comment_num;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I() {
        stFloatingLayerCardStyle stfloatinglayercardstyle;
        stSimpleMetaFeed z16 = z();
        return !((z16 == null || (stfloatinglayercardstyle = z16.floatingLayerCardStyle) == null || !stfloatinglayercardstyle.commentHidden) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean J() {
        return (this.C.getPresenter() instanceof AbsWSVerticalForDramaPresenter) && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean K() {
        stCallWeishiButton stcallweishibutton;
        return (J() || c() == null || c().e() == null || (stcallweishibutton = c().e().weishiButton) == null || !stcallweishibutton.isShow) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean L() {
        stFloatingLayerCardStyle stfloatinglayercardstyle;
        stSimpleMetaFeed z16 = z();
        return !((z16 == null || (stfloatinglayercardstyle = z16.floatingLayerCardStyle) == null || !stfloatinglayercardstyle.dingHidden) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean M() {
        stFloatingLayerCardStyle stfloatinglayercardstyle;
        stSimpleMetaFeed z16 = z();
        return !((z16 == null || (stfloatinglayercardstyle = z16.floatingLayerCardStyle) == null || !stfloatinglayercardstyle.shareHidden) ? false : true);
    }

    public void P(MotionEvent motionEvent) {
        stSimpleMetaFeed z16 = z();
        if (F()) {
            k00.e.e().c(z16, d(), (int) motionEvent.getX(), (int) motionEvent.getY(), this.F, null, null, this.H, false);
        } else {
            k00.e.e().c(z16, d(), (int) motionEvent.getX(), (int) motionEvent.getY(), this.F, this.D, this.E, this.H, true);
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.A(this.C.getFrom(), this.C.getPlayScene(), z16, this.C.getPresenter().h0());
    }

    public void Q() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || c16.e() == null || bb.E()) {
            return;
        }
        stSimpleMetaFeed e16 = c16.e();
        if (F()) {
            k00.e.e().b(e16, d(), this.F, null, null, this.H, false);
        } else {
            k00.e.e().b(e16, d(), this.F, this.D, this.E, this.H, true);
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.M(this.C.getFrom(), this.C.getPlayScene(), e16.is_ding == 1, e16, this.C.getPresenter().h0());
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void j(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        super.j(jVar);
        t tVar = this.L;
        if (tVar != null) {
            tVar.I(M());
            this.L.j(jVar);
        }
    }

    public void T() {
        t tVar = this.L;
        if (tVar != null) {
            tVar.M();
        }
    }

    public void U() {
        m(this.G, I());
        if (y() > 0) {
            WSNumUtil.d(this.G, y(), "0");
        } else {
            this.G.setText(R.string.x7n);
        }
    }

    public void V() {
        if (!L()) {
            m(this.I, false);
            return;
        }
        m(this.I, true);
        X();
        W();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        stSimpleMetaFeed z16 = z();
        if (z16 != null) {
            k00.e.e().g(z16.f25129id);
        }
        t tVar = this.L;
        if (tVar != null) {
            tVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void h() {
        V();
        U();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.p8l) {
            O();
        } else {
            if (id5 != R.id.p8o) {
                return;
            }
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int i3) {
        t tVar = this.L;
        if (tVar != null) {
            tVar.u(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int i3) {
        t tVar = this.L;
        if (tVar != null) {
            tVar.v(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public stSimpleMetaFeed z() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || c16.e() == null) {
            return null;
        }
        return c16.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        ImageView imageView = (ImageView) p(R.id.p8q);
        this.D = imageView;
        imageView.setImageResource(R.drawable.gga);
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        int i3 = this.M;
        layoutParams.width = i3;
        layoutParams.height = i3;
        ImageView imageView2 = (ImageView) p(R.id.p8p);
        this.E = imageView2;
        imageView2.setImageResource(R.drawable.gnx);
        ViewGroup.LayoutParams layoutParams2 = this.E.getLayoutParams();
        int i16 = this.M;
        layoutParams2.width = i16;
        layoutParams2.height = i16;
        this.F = (TextView) p(R.id.p8r);
        ViewGroup viewGroup = (ViewGroup) p(R.id.p8o);
        this.I = viewGroup;
        viewGroup.setOnClickListener(this);
        TextView textView = (TextView) p(R.id.p8l);
        this.G = textView;
        textView.setOnClickListener(this);
        Drawable b16 = com.tencent.biz.pubaccount.weishi.util.ag.b(R.drawable.ggj);
        int i17 = this.M;
        b16.setBounds(0, 0, i17, i17);
        this.G.setCompoundDrawables(null, b16, null, null);
        this.J = (ViewStub) p(R.id.p6_);
        G();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }
}
