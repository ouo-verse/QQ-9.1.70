package com.tencent.biz.pubaccount.weishi.holder;

import UserGrowth.stFeed;
import UserGrowth.stMagicBrand;
import UserGrowth.stQQGroupInfo;
import UserGrowth.stSchema;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.weishi.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.util.WSNumUtil;
import com.tencent.biz.pubaccount.weishi.util.az;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.m;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.biz.pubaccount.weishi.view.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import l00.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSFollowFeedHolder extends com.tencent.biz.pubaccount.weishi.holder.f<stFeed> implements View.OnClickListener {

    /* renamed from: t0, reason: collision with root package name */
    private static final int f80752t0 = r.H(0.5f);
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private FeedRichTextView I;
    private ViewGroup J;
    private KandianUrlImageView K;
    private ImageView L;
    private TextView M;
    private TextView N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private FrameLayout S;
    private FrameLayout T;
    private FeedRichTextView U;
    private FeedRichTextView V;
    private ImageView W;
    private ImageView X;
    private ImageView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private ViewStub f80753a0;

    /* renamed from: b0, reason: collision with root package name */
    private ViewStub f80754b0;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f80755c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f80756d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f80757e0;

    /* renamed from: f0, reason: collision with root package name */
    private stFeed f80758f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.f f80759g0;

    /* renamed from: h, reason: collision with root package name */
    private WSRoundedImageView f80760h;

    /* renamed from: h0, reason: collision with root package name */
    private ArrayList<stSimpleComment> f80761h0;

    /* renamed from: i, reason: collision with root package name */
    private LottieAnimationView f80762i;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f80763i0;

    /* renamed from: j0, reason: collision with root package name */
    private GestureDetector f80764j0;

    /* renamed from: k0, reason: collision with root package name */
    private jz.g f80765k0;

    /* renamed from: l0, reason: collision with root package name */
    private zz.a f80766l0;

    /* renamed from: m, reason: collision with root package name */
    private TextView f80767m;

    /* renamed from: m0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.follow.joingroup.d f80768m0;

    /* renamed from: n0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.view.d f80769n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f80770o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f80771p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f80772q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f80773r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f80774s0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaPerson f80775d;

        a(stSimpleMetaPerson stsimplemetaperson) {
            this.f80775d = stsimplemetaperson;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (!com.tencent.biz.common.util.g.b(WSFollowFeedHolder.this.getContext())) {
                ToastUtil.a().b(R.string.f242037th);
                return;
            }
            WSFollowFeedHolder.this.f80765k0.c(this.f80775d.f25130id, 2);
            this.f80775d.followStatus = 2;
            WSFollowFeedHolder.this.G.setVisibility(0);
            WSFollowFeedHolder.this.H.setVisibility(4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements b.InterfaceC10696b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaPerson f80777a;

        b(stSimpleMetaPerson stsimplemetaperson) {
            this.f80777a = stsimplemetaperson;
        }

        @Override // l00.b.InterfaceC10696b
        public void onFailure() {
            WSFollowFeedHolder.this.b0(this.f80777a, r.s(this.f80777a.relation_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            x.b("WSFollowFeedHolder", "VideoLayout onDoubleTap");
            WSFollowFeedHolder.this.g0(motionEvent);
            WSFollowFeedHolder.this.z0(true);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            x.b("WSFollowFeedHolder", "VideoLayout onSingleTapConfirmed");
            WSFollowFeedHolder.this.i0();
            WSFollowFeedHolder.this.z0(false);
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            WSFollowFeedHolder.this.f80764j0.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            WSFollowFeedHolder.this.f80764j0.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements WSPicLoader.d {
        h() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.image.WSPicLoader.d
        public void a(Drawable drawable) {
            ba.A(WSFollowFeedHolder.this.f80760h, drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i implements d.b {
        i() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.d.b
        public void a(Object obj) {
            if (!bb.E() && (obj instanceof stSchema)) {
                r.C(WSFollowFeedHolder.this.f80759g0.p(), (stSchema) obj, 700, WSFollowFeedHolder.this.Q(), "bottom_label");
                WSFollowFeedHolder.this.y0("bottom_label", 2);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.d.b
        public void b(Object obj) {
            if (bb.E() || !(obj instanceof stSchema) || WSFollowFeedHolder.this.f80758f0.feed == null || WSFollowFeedHolder.this.f80758f0.feed.magicBrand == null) {
                return;
            }
            r.C(WSFollowFeedHolder.this.f80759g0.p(), (stSchema) obj, 700, WSFollowFeedHolder.this.Q(), "bottom_label");
            WSFollowFeedHolder wSFollowFeedHolder = WSFollowFeedHolder.this;
            wSFollowFeedHolder.y0("bottom_label", wSFollowFeedHolder.f80758f0.feed.magicBrand.type);
        }
    }

    private void A() {
        P0();
        O0();
        S0();
        N0();
    }

    private void A0() {
        com.tencent.biz.pubaccount.weishi.holder.f fVar;
        com.tencent.biz.pubaccount.weishi.player.e eVar;
        WSFollowFragment M;
        com.tencent.biz.pubaccount.weishi.f fVar2 = this.f80759g0;
        if (fVar2 == null || (fVar = fVar2.f80706e) == null || (eVar = fVar.f80802e) == null || (M = M()) == null || M.ci()) {
            return;
        }
        WSFollowBeaconReport.C(eVar);
        M.ri(true);
    }

    private void B(ArrayList<stSimpleComment> arrayList) {
        stSimpleComment stsimplecomment;
        if (K() == 0) {
            r.F(8, this.S, this.T, this.Z);
            this.N.setText(R.string.f241787st);
            return;
        }
        this.f80761h0 = arrayList;
        WSNumUtil.d(this.N, K(), "0");
        if (arrayList.size() > 0 && (stsimplecomment = arrayList.get(0)) != null) {
            this.U.setText(r.c(stsimplecomment.poster.nick, stsimplecomment.wording, stsimplecomment.posterId));
            this.U.setOnTouchListener(new m());
            this.W.setSelected(stsimplecomment.isDing == 1);
            r.F(0, this.S);
        }
        if (arrayList.size() > 1) {
            stSimpleComment stsimplecomment2 = arrayList.get(1);
            if (stsimplecomment2 != null) {
                this.V.setText(r.c(stsimplecomment2.poster.nick, stsimplecomment2.wording, stsimplecomment2.posterId));
                this.V.setOnTouchListener(new m());
                this.X.setSelected(stsimplecomment2.isDing == 1);
                r.F(0, this.T);
            }
        } else {
            r.F(8, this.T);
        }
        this.Z.setText(getContext().getString(R.string.f161391xl) + this.f80758f0.feed.total_comment_num + getContext().getString(R.string.f161401xm));
        this.Z.setVisibility(0);
    }

    private void D(String str) {
        if (TextUtils.isEmpty(str)) {
            r.F(8, this.I);
        } else {
            r.F(0, this.I);
            this.I.setText(str);
        }
    }

    private void E(stSimpleMetaFeed stsimplemetafeed) {
        k00.d f16 = k00.c.f(stsimplemetafeed, this.f80756d0.getPaint(), Q());
        if (TextUtils.isEmpty(f16.f411332c)) {
            this.f80755c0.setVisibility(8);
            return;
        }
        this.f80755c0.setVisibility(0);
        this.f80756d0.setWidth(f16.f411331b);
        this.f80756d0.setText(f16.f411330a);
        this.f80756d0.setOnTouchListener(new k00.a(f16.f411330a));
        this.f80757e0.setText(f16.f411332c);
    }

    private void F0() {
        if (this.f80758f0 != null) {
            j10.a aVar = new j10.a();
            aVar.f409063a = this.f80758f0.feed;
            aVar.f409065c = 20;
            aVar.f409066d = Q();
            aVar.f409067e = WSPublicAccReport.SOP_NAME_FOCUS;
            aVar.f409069g = "dynamics_more_operations" + Q();
            az.A(getContext(), aVar);
            o0("more_operations");
        }
    }

    private void G() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.height = r.f(ba.p(), this.f80758f0.feed.video);
        this.K.setLayoutParams(layoutParams);
        this.J.setLayoutParams(layoutParams);
        this.K.setVisibility(0);
        WSPicLoader.g().l(this.K, this.f80758f0.feed, getContext().getResources().getDrawable(R.color.f157202bw1), WSPublicAccReport.SOP_NAME_FOCUS, false, Q());
        Q0();
    }

    private void H0(boolean z16) {
        WSFollowFragment wSFollowFragment;
        com.tencent.biz.pubaccount.weishi.f fVar = this.f80759g0;
        if (fVar == null || (wSFollowFragment = fVar.f80705d) == null) {
            return;
        }
        stSimpleMetaFeed stsimplemetafeed = this.f80758f0.feed;
        WsCommentPresenter wsCommentPresenter = wSFollowFragment.S;
        if (wsCommentPresenter == null) {
            x.l("comment", "need create presenter , holder hashCode:" + hashCode());
            return;
        }
        x.l("comment", "\u590d\u7528 presenter 2222222222222222222222222222222222, holder hashCode:" + hashCode());
        if (z16) {
            com.tencent.biz.pubaccount.weishi.report.b.k(wsCommentPresenter.R(), com.tencent.biz.pubaccount.weishi.report.b.c(wsCommentPresenter.R()) + Q(), 1000001, stsimplemetafeed);
        } else {
            com.tencent.biz.pubaccount.weishi.report.b.l(wsCommentPresenter.R(), Q(), 1000001, stsimplemetafeed);
        }
        wsCommentPresenter.v0(getPosition()).m0(WSPublicAccReport.SOP_NAME_FOCUS, "").t0(6).r0(stsimplemetafeed).w0();
        wz.b.b().a(new WSCommentShowEvent(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        WSProfileFragment.ri(getContext(), str, "at_nick");
        stFeed stfeed = this.f80758f0;
        com.tencent.biz.pubaccount.weishi.report.b.v("comment_at_out", WSPublicAccReport.SOP_NAME_FOCUS, "", str, i3, stfeed != null ? stfeed.feed : null, null);
    }

    private void I0() {
        stSimpleMetaFeed stsimplemetafeed;
        if (!com.tencent.biz.common.util.g.b(getContext())) {
            ToastUtil.a().b(R.string.f242037th);
            return;
        }
        stFeed stfeed = this.f80758f0;
        if (stfeed != null && (stsimplemetafeed = stfeed.feed) != null && stsimplemetafeed.poster != null) {
            if (this.f80765k0 == null) {
                this.f80765k0 = jz.g.e();
            }
            stSimpleMetaPerson stsimplemetaperson = this.f80758f0.feed.poster;
            if (r.r(stsimplemetaperson.followStatus)) {
                p0("follow", com.tencent.biz.pubaccount.weishi.report.d.f81506r);
                r.G(getContext(), new a(stsimplemetaperson), null);
                return;
            }
            p0("follow", com.tencent.biz.pubaccount.weishi.report.d.f81505q);
            this.f80765k0.c(stsimplemetaperson.f25130id, 1);
            stsimplemetaperson.followStatus = 1;
            this.G.setVisibility(8);
            this.H.setVisibility(0);
            return;
        }
        x.b("WSFollowFeedHolder", "[showFollowAction] is null");
    }

    public static WSFollowFeedHolder J(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        return new WSFollowFeedHolder(viewGroup, fVar);
    }

    private int K() {
        stSimpleMetaFeed stsimplemetafeed;
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null) {
            return 0;
        }
        return stsimplemetafeed.total_comment_num;
    }

    private void K0() {
        String str;
        com.tencent.biz.pubaccount.weishi.holder.f Xh = this.f80759g0.f80705d.Xh(this, true, true);
        if (Xh == null || this != this.f80759g0.f80706e) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSFollowFeedHolder.java][tryPlayNextVideoOnDelete] playVideo:");
        l lVar = Xh.f80801d;
        if (lVar != null) {
            str = lVar.f81175j;
        } else {
            str = "videoInfo is null!";
        }
        sb5.append(str);
        x.j("WSFollowFeedHolder", sb5.toString());
        this.f80759g0.A(Xh);
    }

    private WSFollowFragment M() {
        com.tencent.biz.pubaccount.weishi.f fVar = this.f80759g0;
        if (fVar != null) {
            return fVar.f80705d;
        }
        return null;
    }

    private int N() {
        stSimpleMetaFeed stsimplemetafeed;
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null) {
            return 0;
        }
        return stsimplemetafeed.ding_count;
    }

    private void N0() {
        boolean T = T();
        if (this.f80768m0 == null && T) {
            com.tencent.biz.pubaccount.weishi.follow.joingroup.d dVar = new com.tencent.biz.pubaccount.weishi.follow.joingroup.d(this.f80759g0.p(), this);
            this.f80768m0 = dVar;
            dVar.r(this.f80754b0);
        }
        if (T) {
            this.f80768m0.x();
            this.f80754b0.setVisibility(0);
        } else {
            ViewStub viewStub = this.f80754b0;
            if (viewStub != null) {
                viewStub.setVisibility(8);
            }
        }
    }

    private GradientDrawable O() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ba.f81741p);
        gradientDrawable.setColor(Color.parseColor("#40000000"));
        return gradientDrawable;
    }

    private void P0() {
        int i3;
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || stfeed.feed == null) {
            return;
        }
        this.f80769n0.k(new i());
        stSimpleMetaFeed stsimplemetafeed = this.f80758f0.feed;
        stMagicBrand stmagicbrand = stsimplemetafeed.magicBrand;
        ArrayList<stMagicBrand> arrayList = stsimplemetafeed.brands;
        if (arrayList != null && arrayList.size() > 0) {
            this.f80772q0 = true;
            this.f80769n0.i(R.drawable.f162663od3, arrayList.get(0).text, arrayList.get(0).schema);
        } else {
            this.f80772q0 = false;
            this.f80769n0.e();
        }
        if (stmagicbrand != null && !TextUtils.isEmpty(stmagicbrand.text)) {
            if (stmagicbrand.type == 3) {
                this.f80774s0 = true;
                this.f80773r0 = false;
                i3 = R.drawable.ocx;
            } else {
                this.f80774s0 = false;
                this.f80773r0 = true;
                i3 = R.drawable.ocy;
            }
            this.f80769n0.j(i3, stmagicbrand.text, stmagicbrand.schema);
            return;
        }
        this.f80774s0 = false;
        this.f80773r0 = false;
        this.f80769n0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Q() {
        return jz.f.d().f411219f.get(getLayoutPosition()) + 1;
    }

    private void Q0() {
        if (Z()) {
            this.Y.setImageResource(R.drawable.f160354jd4);
            this.Y.setSelected(this.f80759g0.E());
            boolean z16 = this.f80759g0.f80705d.ui() && X();
            this.f80771p0 = z16;
            this.Y.setBackgroundDrawable(z16 ? null : O());
            if (this.f80771p0) {
                V();
                this.f80753a0.setVisibility(0);
                return;
            } else {
                this.f80753a0.setVisibility(8);
                return;
            }
        }
        this.f80771p0 = false;
        this.Y.setImageResource(R.drawable.jd5);
        this.Y.setBackgroundDrawable(null);
        this.f80753a0.setVisibility(8);
    }

    private int R() {
        stSimpleMetaFeed stsimplemetafeed;
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null) {
            return 0;
        }
        return stsimplemetafeed.share_info.share_num;
    }

    private void S() {
        WSPlayerManager P = P();
        if (P == null) {
            return;
        }
        if (Z()) {
            e0(P);
            k0();
        } else {
            f0(P);
        }
    }

    private void S0() {
        if (R() > 0) {
            WSNumUtil.d(this.P, R(), "0");
        } else {
            this.P.setText(R.string.f242067tk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T() {
        stSimpleMetaFeed stsimplemetafeed;
        ArrayList<stQQGroupInfo> arrayList;
        stFeed L = L();
        return (L == null || (stsimplemetafeed = L.feed) == null || (arrayList = stsimplemetafeed.qqGroups) == null || arrayList.size() <= 0) ? false : true;
    }

    private void V() {
        if (this.f80766l0 == null && this.f80759g0.f80705d.ui()) {
            zz.a aVar = new zz.a(getContext(), this);
            this.f80766l0 = aVar;
            aVar.r(this.f80753a0);
        }
    }

    private boolean X() {
        return this.f80759g0.r() == this.f80758f0.feed;
    }

    private boolean Y() {
        stSimpleMetaFeed stsimplemetafeed;
        stSimpleMetaPerson stsimplemetaperson;
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null || (stsimplemetaperson = stsimplemetafeed.poster) == null) {
            return false;
        }
        return r.r(stsimplemetaperson.followStatus);
    }

    private boolean Z() {
        return this.f80759g0.f80705d.di();
    }

    private boolean a0() {
        stSimpleMetaFeed stsimplemetafeed;
        stFeed stfeed = this.f80758f0;
        return (stfeed == null || (stsimplemetafeed = stfeed.feed) == null || stsimplemetafeed.is_ding != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(stSimpleMetaPerson stsimplemetaperson, boolean z16) {
        this.f80760h.setVisibility(0);
        this.f80762i.setVisibility(8);
        WSPicLoader.g().k(getContext(), this.f80760h, stsimplemetaperson.avatar, new h());
        this.C.setVisibility(8);
        r.x(this.C, stsimplemetaperson.medal, z16);
    }

    private void c0() {
        jz.f.d().n(this.f80758f0);
        this.f80759g0.getDataList().remove(this.f80758f0);
        this.f80759g0.notifyItemRemoved(getAdapterPosition());
        ToastUtil.a().b(R.string.f241797su);
        K0();
    }

    private void d0() {
        if (bb.E()) {
            return;
        }
        k00.e.e().b(this.f80758f0.feed, -1, null, this.Q, this.f80763i0, this.J, true);
        v0();
    }

    private void f0(WSPlayerManager wSPlayerManager) {
        com.tencent.biz.pubaccount.weishi.f fVar = this.f80759g0;
        if (fVar.f80706e == this) {
            if (wSPlayerManager.E0()) {
                wSPlayerManager.K0();
            } else {
                wSPlayerManager.O0();
                A0();
            }
        } else {
            fVar.A(this);
        }
        x0(d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(MotionEvent motionEvent) {
        stSimpleMetaFeed stsimplemetafeed;
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null) {
            return;
        }
        k00.e.e().c(stsimplemetafeed, -1, (int) motionEvent.getX(), (int) motionEvent.getY(), null, this.Q, this.f80763i0, this.J, true);
    }

    private void l0(stSimpleComment stsimplecomment, ImageView imageView) {
        boolean z16 = stsimplecomment.isDing == 1;
        x.l("comment", "\u70b9\u8d5e\u524d isDing\uff1a" + z16 + ",mComment.isDing:" + stsimplecomment.isDing + ",mComment.dingNum:" + stsimplecomment.dingNum);
        J0(z16, imageView);
        if (!z16) {
            x.l("comment", "\u6267\u884c\u70b9\u8d5e ...............");
            stsimplecomment.dingNum++;
        } else {
            long j3 = stsimplecomment.dingNum;
            if (j3 > 1) {
                x.l("comment", "\u6267\u884c\u70b9\u8d5e-1 ...............");
                stsimplecomment.dingNum--;
            } else {
                stsimplecomment.dingNum = j3 - 1;
                x.l("comment", "\u6267\u884c\u53d6\u6d88\u70b9\u8d5e ...............");
            }
        }
        stsimplecomment.isDing = (stsimplecomment.isDing + 1) % 2;
        x.l("comment", "\u70b9\u8d5e\u540e mComment.isDing\uff1a" + stsimplecomment.isDing + ",mComment.dingNum:" + stsimplecomment.dingNum);
        WsCommentPresenter wsCommentPresenter = this.f80759g0.f80705d.S;
        if (wsCommentPresenter == null) {
            return;
        }
        wsCommentPresenter.D().s(this.f80758f0.feed, stsimplecomment);
        int i3 = com.tencent.biz.qqstory.utils.l.c(getContext()) ? 1000003 : 1000002;
        wsCommentPresenter.o0(true);
        x.f("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
        com.tencent.biz.pubaccount.weishi.report.b.j("dynamics_comment_like" + Q(), wsCommentPresenter.R(), i3, this.f80758f0.feed);
    }

    private void n0() {
        String str;
        HashMap hashMap = new HashMap();
        stFeed stfeed = this.f80758f0;
        stSimpleMetaFeed stsimplemetafeed = stfeed != null ? stfeed.feed : null;
        if (r.u(stsimplemetafeed != null ? stsimplemetafeed.poster : null)) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_livenow", str);
        WSFollowBeaconReport.j("profile", Q(), com.tencent.biz.pubaccount.weishi.report.d.f81489a, hashMap, stsimplemetafeed);
    }

    private void o0(String str) {
        p0(str, com.tencent.biz.pubaccount.weishi.report.d.f81489a);
    }

    private void p0(String str, String str2) {
        int Q = Q();
        stFeed stfeed = this.f80758f0;
        WSFollowBeaconReport.i(str, Q, str2, stfeed != null ? stfeed.feed : null);
    }

    private void q0(String str, String str2, Map<String, String> map) {
        int Q = Q();
        stFeed stfeed = this.f80758f0;
        WSFollowBeaconReport.j(str, Q, str2, map, stfeed != null ? stfeed.feed : null);
    }

    private void v0() {
        stSimpleMetaFeed stsimplemetafeed;
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null) {
            return;
        }
        if (stsimplemetafeed.is_ding == 1) {
            p0("video", com.tencent.biz.pubaccount.weishi.report.d.f81495g);
        } else {
            p0("video", com.tencent.biz.pubaccount.weishi.report.d.f81496h);
        }
    }

    private void x0(boolean z16) {
        if (z16) {
            p0("pausebutton", com.tencent.biz.pubaccount.weishi.report.d.f81508t);
        } else {
            p0("pausebutton", com.tencent.biz.pubaccount.weishi.report.d.f81507s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(String str, int i3) {
        boolean c16 = com.tencent.biz.qqstory.utils.l.c(getContext());
        HashMap hashMap = new HashMap();
        hashMap.put("label_type", String.valueOf(i3));
        if (c16) {
            q0(str, com.tencent.biz.pubaccount.weishi.report.d.f81491c, hashMap);
        } else {
            q0(str, com.tencent.biz.pubaccount.weishi.report.d.f81490b, hashMap);
        }
    }

    public void B0() {
        this.f80759g0.f80705d.qi();
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void bindData(stFeed stfeed) {
        stSimpleMetaFeed stsimplemetafeed;
        super.bindData(stfeed);
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null) {
            return;
        }
        this.f80758f0 = stfeed;
        F(stsimplemetafeed.poster);
        D(stfeed.feed.feed_desc);
        G();
        A();
        B(stfeed.feed.simpleComments);
        E(stfeed.feed);
    }

    public void C0(boolean z16) {
        com.tencent.biz.pubaccount.weishi.view.d dVar = this.f80769n0;
        if (dVar == null) {
            return;
        }
        if (z16) {
            dVar.g();
        } else {
            dVar.h();
        }
    }

    public void D0(boolean z16) {
        com.tencent.biz.pubaccount.weishi.view.d dVar = this.f80769n0;
        if (dVar == null) {
            return;
        }
        if (z16) {
            P0();
            this.f80769n0.l();
        } else {
            dVar.m();
        }
    }

    public void E0(boolean z16) {
        if (this.Y == null || Z()) {
            return;
        }
        this.Y.setSelected(z16);
    }

    public boolean G0() {
        return this.f80759g0.f80705d.ui();
    }

    public void H(int i3, int i16) {
        bb.a(this.K, i3, i16);
    }

    public stFeed L() {
        return this.f80758f0;
    }

    public void L0(stSimpleMetaFeed stsimplemetafeed) {
        if (this.f80758f0.feed.f25129id.equals(stsimplemetafeed.f25129id)) {
            x.f("comment", "\u6dfb\u52a0\u8bc4\u8bba\u540e\u5339\u914d\u6b63\u786e, \u6dfb\u52a0\u524d\u8bc4\u8bbasize:" + stsimplemetafeed.comments.size());
        }
        String j3 = r.j(R.string.f161381xk, Integer.valueOf(this.f80758f0.feed.total_comment_num));
        x.f("comment", "updateCommentSize, comment size: " + this.f80758f0.feed.total_comment_num);
        this.Z.setText(j3);
        B(stsimplemetafeed.simpleComments);
    }

    public void M0() {
        if (Y()) {
            this.G.setVisibility(8);
            this.H.setVisibility(0);
            this.E.setVisibility(0);
            this.F.setVisibility(4);
            return;
        }
        this.G.setVisibility(0);
        this.H.setVisibility(4);
        this.E.setVisibility(8);
        this.F.setVisibility(0);
    }

    public void O0() {
        this.Q.setVisibility(0);
        this.f80763i0.setVisibility(8);
        this.Q.setSelected(a0());
        if (N() > 0) {
            WSNumUtil.d(this.R, N(), "0");
        } else {
            this.R.setText(R.string.f242027tg);
        }
    }

    public WSPlayerManager P() {
        return this.f80759g0.t();
    }

    public void R0(boolean z16) {
        ImageView imageView = this.Y;
        if (imageView == null) {
            return;
        }
        imageView.setSelected(z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.holder.f
    public ViewGroup b() {
        return this.J;
    }

    public void e0(WSPlayerManager wSPlayerManager) {
        w0(wSPlayerManager.C0());
        boolean z16 = !wSPlayerManager.C0();
        this.f80759g0.D(z16);
        wz.b.b().a(new WSPlayerMuteEvent(z16));
    }

    public void j0() {
        stSimpleMetaFeed stsimplemetafeed;
        stSimpleMetaPerson stsimplemetaperson;
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null || (stsimplemetaperson = stsimplemetafeed.poster) == null || !r.u(stsimplemetaperson)) {
            return;
        }
        l00.b.c().f(this.f80762i, stsimplemetaperson.avatar, new b(stsimplemetaperson));
    }

    public void k0() {
        zz.a aVar = this.f80766l0;
        if (aVar == null || !this.f80771p0) {
            return;
        }
        aVar.x();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x.b("WSFollowFeedHolder", "[onClick] view: " + view);
        stSimpleMetaPerson stsimplemetaperson = (L() == null || L().feed == null) ? null : L().feed.poster;
        switch (view.getId()) {
            case R.id.xu7 /* 2131373588 */:
            case R.id.xu9 /* 2131373590 */:
            case R.id.xul /* 2131373603 */:
            case R.id.xut /* 2131373611 */:
                r.A(this.f80759g0.p(), (stSchema) this.f80760h.getTag(), 700, stsimplemetaperson);
                n0();
                return;
            case R.id.xu8 /* 2131373589 */:
            case R.id.xua /* 2131373592 */:
            case R.id.xug /* 2131373598 */:
            case R.id.xui /* 2131373600 */:
            case R.id.xum /* 2131373604 */:
            case R.id.xun /* 2131373605 */:
            case R.id.xuo /* 2131373606 */:
            case R.id.xup /* 2131373607 */:
            case R.id.xuq /* 2131373608 */:
            case R.id.xuu /* 2131373612 */:
            case R.id.xuv /* 2131373613 */:
            case R.id.xux /* 2131373615 */:
            case R.id.f165857xv1 /* 2131373619 */:
            case R.id.f165858xv2 /* 2131373620 */:
            default:
                return;
            case R.id.xu_ /* 2131373591 */:
            case R.id.f165859xv3 /* 2131373621 */:
                H0(true);
                return;
            case R.id.xub /* 2131373593 */:
                ArrayList<stSimpleComment> arrayList = this.f80761h0;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                l0(this.f80761h0.get(0), this.W);
                return;
            case R.id.xuc /* 2131373594 */:
                ArrayList<stSimpleComment> arrayList2 = this.f80761h0;
                if (arrayList2 == null || arrayList2.size() <= 1) {
                    return;
                }
                l0(this.f80761h0.get(1), this.X);
                return;
            case R.id.xud /* 2131373595 */:
            case R.id.xue /* 2131373596 */:
            case R.id.xuf /* 2131373597 */:
                H0(false);
                return;
            case R.id.xuh /* 2131373599 */:
                c0();
                o0("close");
                return;
            case R.id.xuj /* 2131373601 */:
            case R.id.xuk /* 2131373602 */:
                I0();
                return;
            case R.id.xur /* 2131373609 */:
            case R.id.xus /* 2131373610 */:
                d0();
                return;
            case R.id.xuw /* 2131373614 */:
                r.A(this.f80759g0.p(), (stSchema) this.f80760h.getTag(), 700, stsimplemetaperson);
                o0("nickname");
                return;
            case R.id.xuy /* 2131373616 */:
                S();
                return;
            case R.id.xuz /* 2131373617 */:
            case R.id.f165856xv0 /* 2131373618 */:
                F0();
                return;
        }
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    public void onViewDetachedFromWindow() {
        stSimpleMetaFeed stsimplemetafeed;
        super.onViewDetachedFromWindow();
        stFeed stfeed = this.f80758f0;
        if (stfeed == null || (stsimplemetafeed = stfeed.feed) == null) {
            return;
        }
        k00.e.e().g(stsimplemetafeed.f25129id);
        l00.b.c().b(this.f80762i);
    }

    public void r0() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder.12
            @Override // java.lang.Runnable
            public void run() {
                WSFollowBeaconReport.m(WSFollowFeedHolder.this.Q(), WSFollowFeedHolder.this.f80758f0 != null ? WSFollowFeedHolder.this.f80758f0.feed : null, WSFollowFeedHolder.this.F.getVisibility() == 0, WSFollowFeedHolder.this.f80772q0, WSFollowFeedHolder.this.f80773r0, WSFollowFeedHolder.this.f80774s0, WSFollowFeedHolder.this.f80768m0 != null && WSFollowFeedHolder.this.T(), WSFollowFeedHolder.this.I.i(), WSFollowFeedHolder.this.I.h());
            }
        }, 500L);
    }

    public void s0() {
        int Q = Q();
        String str = com.tencent.biz.pubaccount.weishi.report.d.f81489a;
        stFeed stfeed = this.f80758f0;
        WSFollowBeaconReport.j("qqgroup", Q, str, null, stfeed != null ? stfeed.feed : null);
    }

    public void u0() {
        int Q = Q();
        stFeed stfeed = this.f80758f0;
        WSFollowBeaconReport.k("qqgroup_float", Q, stfeed != null ? stfeed.feed : null);
    }

    private void U() {
        r.E(this, this.f80760h, this.D, this.f80767m, this.C, this.f80762i);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.f80764j0 = new GestureDetector(getContext(), new c());
        this.K.setOnTouchListener(new d());
        this.J.setOnTouchListener(new e());
        this.U.setOnElementClickListener(new f());
        this.V.setOnElementClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        WSFollowFragment.f80369k0 = true;
        if (this.f80759g0.f80705d.S == null) {
            x.l("comment", "need create presenter ,holder hashCode:" + hashCode());
            return;
        }
        x.l("comment", "\u590d\u7528 presenter 33333333333333333, holder hashCode:" + hashCode());
        if (!d() && !c()) {
            this.f80759g0.t().Y0();
        }
        Activity p16 = this.f80759g0.p();
        if (p16 == null) {
            return;
        }
        a.b.d(new k(p16, "follow_tab", WSPublicAccReport.SOP_NAME_FOCUS).K(M()).M(getLayoutPosition()).S(4097));
        this.K.setVisibility(0);
        E0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(boolean z16) {
        if (z16) {
            p0("like", com.tencent.biz.pubaccount.weishi.report.d.f81497i);
        } else {
            o0("video");
        }
    }

    WSFollowFeedHolder(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        super(viewGroup, R.layout.f168562fx2);
        this.f80770o0 = false;
        this.f80759g0 = fVar;
        W();
        U();
    }

    private void F(stSimpleMetaPerson stsimplemetaperson) {
        if (stsimplemetaperson == null) {
            return;
        }
        this.f80760h.setTag(stsimplemetaperson.avatarSchema);
        boolean s16 = r.s(stsimplemetaperson.relation_type);
        this.f80767m.setVisibility(s16 ? 0 : 8);
        if (r.u(stsimplemetaperson)) {
            this.C.setVisibility(8);
            this.f80760h.setVisibility(8);
            this.f80762i.setVisibility(0);
        } else {
            b0(stsimplemetaperson, s16);
        }
        this.D.setText(r.y(stsimplemetaperson.nick));
        this.E.setText(r.z(this.f80758f0.feed.createTime));
        this.G.setVisibility(r.r(stsimplemetaperson.followStatus) ? 8 : 0);
        this.H.setVisibility(4);
        this.F.setVisibility(this.G.getVisibility());
        if (Y()) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
    }

    private void W() {
        this.f80760h = (WSRoundedImageView) getView(R.id.xu7);
        this.f80762i = (LottieAnimationView) getView(R.id.xu9);
        this.f80760h.setStrokeWidth(f80752t0);
        this.f80760h.setStrokeColor(Color.parseColor("#D9D9D9"));
        this.f80767m = (TextView) getView(R.id.xul);
        this.C = (TextView) getView(R.id.xut);
        this.D = (TextView) getView(R.id.xuw);
        this.E = (TextView) getView(R.id.f165857xv1);
        this.F = (TextView) getView(R.id.xuh);
        this.G = (TextView) getView(R.id.xuk);
        this.H = (TextView) getView(R.id.xuj);
        this.I = (FeedRichTextView) getView(R.id.xui);
        this.J = (ViewGroup) getView(R.id.f165858xv2);
        this.K = (KandianUrlImageView) getView(R.id.xug);
        this.Y = (ImageView) getView(R.id.xuy);
        this.f80753a0 = (ViewStub) getView(R.id.xuv);
        this.f80754b0 = (ViewStub) getView(R.id.xvp);
        this.L = (ImageView) getView(R.id.xuz);
        this.M = (TextView) getView(R.id.xu_);
        this.N = (TextView) getView(R.id.f165859xv3);
        this.P = (TextView) getView(R.id.f165856xv0);
        this.Q = (TextView) getView(R.id.xur);
        this.R = (TextView) getView(R.id.f165860xv4);
        this.f80763i0 = (TextView) getView(R.id.xus);
        this.S = (FrameLayout) getView(R.id.f165854xu3);
        this.T = (FrameLayout) getView(R.id.f165855xu4);
        this.U = (FeedRichTextView) getView(R.id.xud);
        this.V = (FeedRichTextView) getView(R.id.xue);
        this.W = (ImageView) getView(R.id.xub);
        this.X = (ImageView) getView(R.id.xuc);
        this.Z = (TextView) getView(R.id.xuf);
        this.f80755c0 = (LinearLayout) getView(R.id.xvt);
        this.f80756d0 = (TextView) getView(R.id.xvu);
        this.f80757e0 = (TextView) getView(R.id.xvv);
        this.f80769n0 = new com.tencent.biz.pubaccount.weishi.view.d(getView(R.id.f760840p));
        this.U.setRichTextDisplayType(1);
        this.V.setRichTextDisplayType(1);
    }

    public void J0(boolean z16, ImageView imageView) {
        if (!z16) {
            imageView.setSelected(true);
        } else {
            imageView.setSelected(false);
        }
    }

    private void w0(boolean z16) {
        p0("mutebutton", String.valueOf(z16 ? 1007008 : 1007009));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements FeedRichTextView.a {
        f() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.a
        public void b(String str) {
            WSFollowFeedHolder.this.I(str, 0);
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.a
        public void a(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements FeedRichTextView.a {
        g() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.a
        public void b(String str) {
            WSFollowFeedHolder.this.I(str, 1);
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.a
        public void a(String str) {
        }
    }

    public void m0(int i3) {
    }
}
