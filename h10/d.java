package h10;

import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import UserGrowth.stSimpleMetaPerson;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.mobileqq.R;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import jz.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends BaseViewHolder<stSimpleMetaPerson> implements View.OnClickListener {
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private g L;
    private LinearLayout M;
    private Drawable N;

    /* renamed from: d, reason: collision with root package name */
    private e f404062d;

    /* renamed from: e, reason: collision with root package name */
    private stSimpleMetaPerson f404063e;

    /* renamed from: f, reason: collision with root package name */
    private int f404064f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f404065h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f404066i;

    /* renamed from: m, reason: collision with root package name */
    private WSRoundedImageView f404067m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (!com.tencent.biz.common.util.g.b(d.this.getContext())) {
                ToastUtil.a().b(R.string.f242037th);
                return;
            }
            d.this.L.c(d.this.f404063e.f25130id, 2);
            d.this.f404063e.followStatus = 2;
            d.this.J.setVisibility(0);
            d.this.K.setVisibility(8);
            WSFollowBeaconReport.w("follow", d.this.f404064f + 1, d.this.f404063e.f25130id, com.tencent.biz.pubaccount.weishi.report.d.f81506r);
        }
    }

    public static d j(ViewGroup viewGroup, e eVar) {
        return new d(viewGroup, eVar);
    }

    private void l() {
        this.E.setOnClickListener(this);
        this.f404066i.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.f404066i.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.I.setOnClickListener(this);
    }

    private void n(TextView textView, TextView textView2, stMetaNumericSys stmetanumericsys) {
        if (stmetanumericsys == null) {
            textView.setText("");
            textView2.setText("");
        } else if (stmetanumericsys.feed_num > 0) {
            textView.setText("\u4f5c\u54c1");
            textView2.setText(String.valueOf(stmetanumericsys.feed_num));
        } else if (stmetanumericsys.fans_num > 0) {
            textView.setText("\u7c89\u4e1d\u6570");
            textView2.setText(String.valueOf(stmetanumericsys.fans_num));
        } else {
            textView.setText("");
            textView2.setText("");
        }
    }

    private void p(stSimpleMetaPerson stsimplemetaperson) {
        WSFollowBeaconReport.x(this.f404064f + 1, stsimplemetaperson);
    }

    private void q() {
        stSimpleMetaPerson stsimplemetaperson;
        e eVar = this.f404062d;
        if (eVar == null || (stsimplemetaperson = this.f404063e) == null) {
            return;
        }
        eVar.j(stsimplemetaperson);
        WSFollowBeaconReport.w("close", this.f404064f + 1, this.f404063e.f25130id, com.tencent.biz.pubaccount.weishi.report.d.f81489a);
    }

    private void r() {
        if (!com.tencent.biz.common.util.g.b(getContext())) {
            ToastUtil.a().b(R.string.f242037th);
            return;
        }
        if (this.L == null) {
            this.L = g.e();
        }
        if (r.r(this.f404063e.followStatus)) {
            r.G(getContext(), new a(), null);
            return;
        }
        this.L.c(this.f404063e.f25130id, 1);
        this.f404063e.followStatus = 1;
        this.J.setVisibility(8);
        this.K.setVisibility(0);
        WSFollowBeaconReport.w("follow", this.f404064f + 1, this.f404063e.f25130id, com.tencent.biz.pubaccount.weishi.report.d.f81505q);
    }

    public void h(stSimpleMetaPerson stsimplemetaperson, int i3) {
        super.bindData(stsimplemetaperson);
        this.f404063e = stsimplemetaperson;
        if (stsimplemetaperson == null) {
            return;
        }
        this.f404064f = i3;
        WSPicLoader.g().w(this.f404067m, stsimplemetaperson.avatar, this.N);
        boolean s16 = r.s(stsimplemetaperson.relation_type);
        this.C.setVisibility(s16 ? 0 : 8);
        this.D.setVisibility(8);
        r.x(this.D, stsimplemetaperson.medal, s16);
        this.F.setText(r.y(stsimplemetaperson.nick));
        n(this.G, this.H, stsimplemetaperson.nueric);
        this.I.setText(stsimplemetaperson.recommendReason);
        s();
    }

    public stSimpleMetaPerson k() {
        return this.f404063e;
    }

    public void o() {
        x.b("WSRecommendFollowHolder", "[reportExposure]");
        stSimpleMetaPerson stsimplemetaperson = this.f404063e;
        if (stsimplemetaperson == null) {
            x.f("WSRecommendFollowHolder", "[reportExposure] mCurrentPerson is null");
        } else {
            p(stsimplemetaperson);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x.b("WSRecommendFollowHolder", "[onClick] view: " + view);
        switch (view.getId()) {
            case R.id.xuj /* 2131373601 */:
            case R.id.xuk /* 2131373602 */:
                r();
                return;
            case R.id.xx5 /* 2131373721 */:
                i(2);
                return;
            case R.id.xx6 /* 2131373722 */:
                q();
                return;
            case R.id.xx9 /* 2131373725 */:
                i(1);
                return;
            case R.id.xx_ /* 2131373726 */:
            case R.id.xxb /* 2131373728 */:
                i(0);
                return;
            default:
                return;
        }
    }

    public void s() {
        stSimpleMetaPerson stsimplemetaperson = this.f404063e;
        if (stsimplemetaperson == null) {
            return;
        }
        if (r.r(stsimplemetaperson.followStatus)) {
            this.J.setVisibility(8);
            this.K.setVisibility(0);
        } else {
            this.J.setVisibility(0);
            this.K.setVisibility(8);
        }
    }

    public d(ViewGroup viewGroup, e eVar) {
        super(viewGroup, R.layout.fx9);
        this.f404062d = eVar;
        this.N = getContext().getResources().getDrawable(R.drawable.f160830com);
        m();
        l();
    }

    private void i(int i3) {
        if (i3 == 1) {
            WSFollowBeaconReport.w("nickname", this.f404064f + 1, this.f404063e.f25130id, com.tencent.biz.pubaccount.weishi.report.d.f81489a);
        } else if (i3 == 2) {
            WSFollowBeaconReport.w("profile", this.f404064f + 1, this.f404063e.f25130id, com.tencent.biz.pubaccount.weishi.report.d.f81489a);
        }
        e eVar = this.f404062d;
        if (eVar != null) {
            eVar.o(this.f404063e);
        }
    }

    private void m() {
        this.f404065h = (RelativeLayout) getView(R.id.xxd);
        this.f404066i = (RelativeLayout) getView(R.id.xx5);
        this.f404067m = (WSRoundedImageView) getView(R.id.f165872xx4);
        this.C = (TextView) getView(R.id.xx7);
        this.D = (TextView) getView(R.id.xx8);
        this.E = (TextView) getView(R.id.xx6);
        this.F = (TextView) getView(R.id.xx9);
        this.M = (LinearLayout) getView(R.id.xx_);
        this.G = (TextView) getView(R.id.xxc);
        this.H = (TextView) getView(R.id.xxa);
        this.I = (TextView) getView(R.id.xxb);
        this.J = (TextView) getView(R.id.xuk);
        this.K = (TextView) getView(R.id.xuj);
    }
}
