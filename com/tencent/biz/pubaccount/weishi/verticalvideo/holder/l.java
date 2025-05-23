package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stFeedBarInfo;
import UserGrowth.stSimpleMetaFeed;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l extends c {
    private View C;
    private TextView D;
    protected WSVerticalPageFragment E;
    private stSimpleMetaFeed F;
    private String G;
    private String H;
    private int I;
    private int J;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            l.this.E();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            String str;
            super.onAnimationStart(animator);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("collection animator start: ");
            if (l.this.F == null) {
                str = "null";
            } else {
                str = l.this.F.feed_desc;
            }
            sb5.append(str);
            com.tencent.biz.pubaccount.weishi.util.x.b("AbsWsUIGroup", sb5.toString());
        }
    }

    public l(Context context, au auVar) {
        super(context);
        this.I = -1;
        this.J = -1;
        if (auVar != null) {
            this.E = auVar.f82128e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        String str;
        stFeedBarInfo stfeedbarinfo = this.F.feedBarInfo;
        if (stfeedbarinfo == null) {
            return;
        }
        Map<String, String> h06 = this.E.getPresenter().h0();
        if (C()) {
            str = "1";
        } else {
            str = "0";
        }
        h06.put("bar_status", str);
        WSVerticalPageFragment wSVerticalPageFragment = this.E;
        com.tencent.biz.pubaccount.weishi.util.n.d(wSVerticalPageFragment, this.F, stfeedbarinfo.jump, wSVerticalPageFragment.Ec(), h06);
    }

    private boolean D() {
        stFeedBarInfo stfeedbarinfo;
        stSimpleMetaFeed stsimplemetafeed = this.F;
        return (stsimplemetafeed == null || (stfeedbarinfo = stsimplemetafeed.feedBarInfo) == null || stfeedbarinfo.switchOpen != 1 || TextUtils.isEmpty(stfeedbarinfo.text)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        String str;
        Map<String, String> h06 = this.E.getPresenter().h0();
        if (C()) {
            str = "1";
        } else {
            str = "0";
        }
        h06.put("bar_status", str);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.x(this.E.getFrom(), this.E.getPlayScene(), this.F, h06);
    }

    private void F(String str) {
        String b16 = bb.b(str);
        if (TextUtils.isEmpty(b16)) {
            this.C.setBackgroundColor(com.tencent.biz.pubaccount.weishi.util.r.g(R.color.f156808bw));
        } else {
            this.C.setBackgroundColor(Color.parseColor(b16));
        }
    }

    private boolean G() {
        View view = this.C;
        return (view == null || view.getVisibility() != 0 || C()) ? false : true;
    }

    public int A() {
        int i3 = this.I;
        if (i3 == -1) {
            return 2000;
        }
        return i3 * 1000;
    }

    public boolean C() {
        return c() != null && c().c();
    }

    public void H() {
        if (!G()) {
            com.tencent.biz.pubaccount.weishi.util.x.f("AbsWsUIGroup", "fail to meet the requirement of playing collection animation");
            return;
        }
        if (c() != null) {
            c().m(true);
        }
        String b16 = bb.b(this.G);
        String b17 = bb.b(this.H);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.C, "backgroundColor", ba.w(b16) ? Color.parseColor(b16) : Integer.MIN_VALUE, ba.w(b17) ? Color.parseColor(b17) : -2139470081);
        ofInt.addListener(new b());
        ofInt.setDuration(500L);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.start();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null) {
            this.F = c16.e();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        if (D()) {
            this.C.setVisibility(0);
            this.D.setText(this.F.feedBarInfo.text);
            stFeedBarInfo stfeedbarinfo = this.F.feedBarInfo;
            this.I = stfeedbarinfo.changeTime;
            this.J = stfeedbarinfo.progressPercentage;
            this.G = stfeedbarinfo.beginColor;
            this.H = stfeedbarinfo.endColor;
            if (C()) {
                F(this.H);
                return;
            } else {
                F(this.G);
                return;
            }
        }
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int i3) {
        if (D()) {
            E();
        }
    }

    public int z() {
        int i3 = this.J;
        if (i3 == -1) {
            return 20;
        }
        return i3;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        View p16 = p(R.id.f116716zh);
        this.C = p16;
        p16.setOnClickListener(new a());
        this.D = (TextView) p(R.id.f116736zj);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int i3) {
    }
}
