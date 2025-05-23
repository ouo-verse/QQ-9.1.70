package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.WSNumUtil;
import com.tencent.biz.pubaccount.weishi.util.az;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class t extends c implements View.OnClickListener {
    protected TextView C;
    protected ImageView D;
    protected WSRoundedImageView E;
    private boolean F;
    private boolean G;
    private boolean H;
    private String I;
    private String J;
    private WSVerticalPageFragment K;
    private IFaceDecoder L;
    private QQAppInterface M;
    protected final int N;

    public t(Context context, au auVar) {
        super(context);
        this.J = "-1";
        this.N = com.tencent.biz.pubaccount.weishi.verticalvideo.a.f81840a.a();
        if (auVar != null) {
            this.K = auVar.f82128e;
        }
        E();
    }

    private stSimpleMetaFeed A() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || c16.e() == null) {
            return null;
        }
        return c16.e();
    }

    private Map<String, String> C() {
        HashMap hashMap = new HashMap();
        hashMap.put("icon_type", this.J);
        hashMap.put(AudienceReportConst.USER_QQ, this.I);
        return hashMap;
    }

    private int D() {
        stShareInfo stshareinfo;
        stSimpleMetaFeed A = A();
        if (A == null || (stshareinfo = A.share_info) == null) {
            return 0;
        }
        return stshareinfo.share_num;
    }

    private void E() {
        QQAppInterface t16 = bb.t();
        this.M = t16;
        if (t16 == null) {
            return;
        }
        this.L = ((IQQAvatarService) t16.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.M);
    }

    private void F(Map<String, String> map, int i3) {
        L(map, i3);
        m(this.D, true);
        m(this.E, false);
        this.D.clearAnimation();
        this.E.clearAnimation();
        this.H = false;
    }

    private void G() {
        WSVerticalPageFragment wSVerticalPageFragment = this.K;
        if (wSVerticalPageFragment == null || wSVerticalPageFragment.getPresenter() == null) {
            return;
        }
        Map<String, String> h06 = this.K.getPresenter().h0();
        h06.putAll(C());
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.b0(this.K.getFrom(), this.K.getPlayScene(), A(), h06);
    }

    private void J(j10.a aVar) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        aVar.f409070h = c16 != null ? c16.g() : 1.0f;
    }

    private void K(Bitmap bitmap) {
        G();
        com.tencent.biz.pubaccount.weishi.util.h.d(this.D, false, new a(bitmap));
    }

    private void L(Map<String, String> map, int i3) {
        stSimpleMetaFeed A = A();
        Map<String, String> h06 = this.K.getPresenter().h0();
        if (map != null) {
            h06.putAll(map);
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.c0(this.K.getFrom(), this.K.getPlayScene(), 1000001, A, h06);
        com.tencent.biz.pubaccount.weishi.report.dc898.d.h();
        j10.a aVar = new j10.a();
        aVar.f409063a = A();
        aVar.f409065c = 3;
        aVar.f409066d = d();
        aVar.f409067e = com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.K.getFrom());
        aVar.f409068f = this.K.getPlayScene();
        aVar.f409069g = "forward";
        J(aVar);
        aVar.f409071i = h06;
        aVar.f409074l = i3;
        aVar.f409075m = this.K.getPresenter().hashCode();
        aVar.b(this.K);
        az.A(this.f80409d, aVar);
    }

    private void O() {
        this.D.clearAnimation();
        this.E.clearAnimation();
        m(this.C, false);
        m(this.D, false);
        m(this.E, false);
    }

    private void Q() {
        m(this.C, true);
        if (this.H) {
            m(this.D, false);
            m(this.E, true);
            com.tencent.biz.pubaccount.weishi.util.h.b(this.E);
        } else {
            m(this.D, true);
            m(this.E, false);
        }
    }

    private void R() {
        if (this.F) {
            m(this.C, true);
            m(this.D, true);
            if (D() > 0) {
                WSNumUtil.d(this.C, D(), "0");
            } else {
                this.C.setText(R.string.x_4);
            }
        } else {
            m(this.C, false);
            m(this.D, false);
        }
        m(this.E, false);
    }

    public static t y(Context context, au auVar) {
        return new t(context, auVar);
    }

    private Bitmap z(String str, int i3, byte b16) {
        Bitmap bitmapFromCache = this.L.getBitmapFromCache(i3, str);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        this.L.cancelPendingRequests();
        if (!this.L.isPausing()) {
            this.L.requestDecodeFace(str, i3, true, b16);
        }
        return com.tencent.biz.pubaccount.weishi.util.u.a();
    }

    public void I(boolean z16) {
        this.F = z16;
    }

    public void M() {
        F(C(), 2);
    }

    public void P(boolean z16) {
        this.F = z16;
        if (z16) {
            Q();
        } else {
            O();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        R();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.p4q || id5 == R.id.p5w || id5 == R.id.p8t) {
            F(C(), 1);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int i3) {
        H();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int i3) {
        H();
    }

    public void x() {
        RecentUser B;
        QQAppInterface qQAppInterface = this.M;
        if (qQAppInterface == null || this.G || !this.F) {
            return;
        }
        List<RecentUser> recentList = qQAppInterface.getRecentUserProxy().getRecentList(true);
        int b16 = com.tencent.biz.pubaccount.weishi.verticalvideo.c.f81916a.b();
        int i3 = 4;
        if (b16 != 1) {
            if (b16 != 2) {
                if (b16 == 3) {
                    for (int i16 = 0; i16 < recentList.size(); i16++) {
                        B = recentList.get(i16);
                        int i17 = B.type;
                        if (i17 == 0) {
                            this.J = "1";
                        } else {
                            if (i17 == 1) {
                                this.J = "2";
                                break;
                            }
                        }
                    }
                }
                i3 = 1;
                B = null;
            } else {
                B = B(recentList, 0);
                this.J = "1";
            }
            i3 = 1;
            break;
        }
        B = B(recentList, 1);
        this.J = "2";
        this.G = true;
        this.H = true;
        if (B == null) {
            this.I = "";
            this.J = "-1";
            K(null);
        } else {
            String str = B.uin;
            this.I = str;
            K(z(str, i3, (byte) 0));
        }
    }

    private RecentUser B(List<RecentUser> list, int i3) {
        for (int i16 = 0; i16 < list.size(); i16++) {
            RecentUser recentUser = list.get(i16);
            if (recentUser.type == i3) {
                return recentUser;
            }
        }
        return null;
    }

    private void H() {
        this.G = false;
        this.H = false;
        this.I = "";
        this.J = "-1";
        m(this.C, this.F);
        m(this.D, this.F);
        m(this.E, false);
        this.D.clearAnimation();
        this.E.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void f() {
        this.G = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Bitmap bitmap) {
        if (bitmap != null) {
            this.E.setImageBitmap(bitmap);
        } else {
            WSPicLoader.g().w(this.E, com.tencent.biz.pubaccount.weishi.verticalvideo.c.f81916a.c(), com.tencent.biz.pubaccount.weishi.util.r.i(R.drawable.qzone_icon_action_sheet_share_to_qzone));
        }
        com.tencent.biz.pubaccount.weishi.util.h.d(this.E, true, new b());
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        TextView textView = (TextView) p(R.id.p8t);
        this.C = textView;
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) p(R.id.p4q);
        this.D = imageView;
        imageView.setOnClickListener(this);
        this.D.setImageResource(R.drawable.ggx);
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        int i3 = this.N;
        layoutParams.width = i3;
        layoutParams.height = i3;
        WSRoundedImageView wSRoundedImageView = (WSRoundedImageView) p(R.id.p5w);
        this.E = wSRoundedImageView;
        wSRoundedImageView.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams2 = this.E.getLayoutParams();
        int i16 = this.N;
        layoutParams2.width = i16;
        layoutParams2.height = i16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bitmap f82154d;

        a(Bitmap bitmap) {
            this.f82154d = bitmap;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            t.this.D.setVisibility(4);
            t.this.N(this.f82154d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            t.this.E.setVisibility(0);
            com.tencent.biz.pubaccount.weishi.util.h.b(t.this.E);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
