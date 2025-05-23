package h10;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.animation.Animator;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.common.util.g;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi.view.RoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.mobileqq.widget.f;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqnt.kernel.nativeinterface.RichErrorCode;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import l00.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends BaseViewHolder<a00.b> {
    private static final int H = r.H(5.0f);
    private static final int I = r.H(2.0f);
    private FrameLayout C;
    private LottieAnimationView D;
    private stSimpleMetaFeed E;
    private a00.b F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private h10.a f404050d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f404051e;

    /* renamed from: f, reason: collision with root package name */
    private RoundImageView f404052f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f404053h;

    /* renamed from: i, reason: collision with root package name */
    private RoundTextView f404054i;

    /* renamed from: m, reason: collision with root package name */
    private LottieAnimationView f404055m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.b(b.this.getContext())) {
                b.this.s();
                WSFollowBeaconReport.r(b.this.G + 1, RichErrorCode.KUNKNOW, b.this.E, b.this.F.g(), b.this.F.d());
            } else {
                ToastUtil.a().b(R.string.f242037th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: h10.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class ViewOnClickListenerC10408b implements View.OnClickListener {
        ViewOnClickListenerC10408b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c implements b.InterfaceC10696b {
        c() {
        }

        @Override // l00.b.InterfaceC10696b
        public void onFailure() {
            b.this.D.setVisibility(8);
            b.this.C.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        stSimpleMetaPerson p16 = p();
        h10.a aVar = this.f404050d;
        if (aVar == null || p16 == null || this.F == null) {
            return;
        }
        r.A(aVar.p(), p16.avatarSchema, 0, p16);
        WSFollowBeaconReport.s(this.G + 1, this.E, this.F.g(), this.F.d());
    }

    public static b n(ViewGroup viewGroup, h10.a aVar) {
        return new b(viewGroup, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        stSimpleMetaFeed stsimplemetafeed = this.E;
        if (stsimplemetafeed != null && stsimplemetafeed.poster != null && !this.f404055m.isAnimating()) {
            jz.g.e().c(this.E.poster.f25130id, 1);
        } else {
            x.b("WSFollowFriendFeedHolder", "[showFollowAction] is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f404055m.addAnimatorListener(new d());
        this.f404055m.playAnimation();
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        l00.b.c().b(this.D);
    }

    public stSimpleMetaPerson p() {
        stSimpleMetaFeed stsimplemetafeed = this.E;
        if (stsimplemetafeed != null) {
            return stsimplemetafeed.poster;
        }
        return null;
    }

    public void r() {
        stSimpleMetaPerson p16 = p();
        if (r.u(p16)) {
            l00.b.c().f(this.D, p16.avatar, new c());
        }
    }

    public void t() {
        a00.b bVar = this.F;
        if (bVar == null) {
            x.b("WSFollowFriendFeedHolder", "[reportExposure] mCurrentItemData is null");
        } else {
            WSFollowBeaconReport.q(this.G + 1, this.E, bVar.g(), this.F.d());
        }
    }

    public void w() {
        stSimpleMetaPerson stsimplemetaperson;
        stSimpleMetaFeed stsimplemetafeed = this.E;
        if (stsimplemetafeed == null || (stsimplemetaperson = stsimplemetafeed.poster) == null) {
            return;
        }
        if (r.r(stsimplemetaperson.followStatus)) {
            this.f404055m.setVisibility(8);
        } else {
            this.f404055m.setVisibility(0);
        }
    }

    public void l(a00.b bVar, int i3) {
        if (bVar == null || bVar.a().size() < 1) {
            return;
        }
        this.F = bVar;
        stSimpleMetaFeed stsimplemetafeed = bVar.a().get(0);
        this.E = stsimplemetafeed;
        if (stsimplemetafeed == null) {
            return;
        }
        this.G = i3;
        u(bVar.d());
        v(bVar.g());
        stSimpleMetaPerson stsimplemetaperson = this.E.poster;
        if (stsimplemetaperson != null) {
            if (this.f404055m.isAnimating()) {
                this.f404055m.cancelAnimation();
            }
            if (r.r(stsimplemetaperson.followStatus)) {
                this.f404055m.setVisibility(8);
            } else {
                this.f404055m.setFrame(1);
                this.f404055m.setVisibility(0);
            }
            WSPicLoader.g().m(this.f404051e, this.E, true, WSPublicAccReport.SOP_NAME_FOCUS, this.G);
            WSPicLoader.g().j(getContext(), this.f404052f, stsimplemetaperson.avatar);
            this.f404053h.setText(stsimplemetaperson.nick);
        }
        if (r.u(stsimplemetaperson)) {
            this.D.setVisibility(0);
            this.C.setVisibility(8);
        } else {
            this.D.setVisibility(8);
            this.C.setVisibility(0);
        }
    }

    public void v(boolean z16) {
        String str;
        if (z16) {
            str = "#67FFFFFF";
        } else {
            str = "#FF7A46FF";
        }
        this.f404052f.setBorderColor(Color.parseColor(str));
    }

    b(ViewGroup viewGroup, h10.a aVar) {
        super(viewGroup, R.layout.fx8);
        this.f404050d = aVar;
        q();
    }

    private void q() {
        this.f404051e = (RoundCornerImageView) getView(R.id.f125267ll);
        this.f404052f = (RoundImageView) getView(R.id.f125277lm);
        this.f404053h = (TextView) getView(R.id.f125487m7);
        this.f404054i = (RoundTextView) getView(R.id.f125307lp);
        this.C = (FrameLayout) getView(R.id.f125127l8);
        this.D = (LottieAnimationView) getView(R.id.f125167lb);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getView(R.id.f125157la);
        this.f404055m = lottieAnimationView;
        lottieAnimationView.setOnClickListener(new a());
        this.D.setOnClickListener(new ViewOnClickListenerC10408b());
        this.f404055m.setAnimation("wsfollow/followbtn.json");
        this.f404051e.setCorner(H);
        this.f404052f.setBorderInnerPadding(5);
        this.f404052f.setBorderWidth(I);
        this.f404052f.setBorderColor(Color.parseColor("#D9D9D9"));
        this.f404054i.setRoundBgColor(getContext().getResources().getColor(R.color.f158017al3));
    }

    private void u(int i3) {
        if (i3 <= 1) {
            this.f404054i.setVisibility(8);
        } else {
            this.f404054i.setVisibility(0);
            this.f404054i.setText(String.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class d extends f {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.f404055m.removeAnimatorListener(this);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.o();
            b.this.f404055m.setVisibility(8);
            b.this.f404055m.removeAnimatorListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
