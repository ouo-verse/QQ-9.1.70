package com.tencent.now.linkpkanchorplay.AcceptInvite;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import com.tencent.component.core.event.EventCenter;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.AcceptInvite.view.AcceptInviteDialog;
import com.tencent.now.linkpkanchorplay.AcceptInvite.view.ReceiveInviteBubbleView;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import g55.ag;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AcceptInviteHelper implements ThreadCenter.HandlerKeyable {
    private FragmentManager C;
    private ViewGroup D;
    private ReceiveInviteBubbleView E;

    /* renamed from: e, reason: collision with root package name */
    private int f338098e;

    /* renamed from: m, reason: collision with root package name */
    private Context f338102m;

    /* renamed from: d, reason: collision with root package name */
    private String f338097d = "";

    /* renamed from: f, reason: collision with root package name */
    private e55.a f338099f = null;

    /* renamed from: h, reason: collision with root package name */
    private int f338100h = 15;

    /* renamed from: i, reason: collision with root package name */
    private Eventor f338101i = new Eventor();
    private AnimatorSet F = new AnimatorSet();
    private Runnable G = new Runnable() { // from class: com.tencent.now.linkpkanchorplay.AcceptInvite.AcceptInviteHelper.4
        @Override // java.lang.Runnable
        public void run() {
            if (AcceptInviteHelper.this.f338099f == null) {
                AegisLogger.e("PK_Biz|AcceptInviteHelper", "mAutoHideRunnable", "run but mAnchorInfo is null!");
                return;
            }
            AcceptInviteHelper acceptInviteHelper = AcceptInviteHelper.this;
            acceptInviteHelper.f338100h--;
            if (AcceptInviteHelper.this.f338100h <= 0) {
                AegisLogger.i("PK_Biz|AcceptInviteHelper", "mAutoHideRunnable doRefuse");
                AcceptInviteHelper.this.k();
            } else {
                AcceptInviteHelper acceptInviteHelper2 = AcceptInviteHelper.this;
                ThreadCenter.postDelayedUITask(acceptInviteHelper2, acceptInviteHelper2.G, 1000L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements AcceptInviteDialog.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AcceptInviteDialog f338103a;

        a(AcceptInviteDialog acceptInviteDialog) {
            this.f338103a = acceptInviteDialog;
        }

        @Override // com.tencent.now.linkpkanchorplay.AcceptInvite.view.AcceptInviteDialog.c
        public void onDismiss() {
            if (this.f338103a.uh() > 0) {
                AcceptInviteHelper.this.f338100h = this.f338103a.uh();
                AcceptInviteHelper.this.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements OnEvent<d.ResponseInviteEvent> {
        b() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(d.ResponseInviteEvent responseInviteEvent) {
            AegisLogger.i("PK_Biz|AcceptInviteHelper", "recv ResponseInviteEvent, op=" + responseInviteEvent.getOpType() + ", inviteMsg=" + responseInviteEvent.getInviteMsg());
            AcceptInviteHelper.this.i();
        }
    }

    public AcceptInviteHelper(Context context, FragmentManager fragmentManager, ViewGroup viewGroup) {
        this.f338102m = null;
        this.f338102m = context;
        this.C = fragmentManager;
        this.D = viewGroup;
        l();
    }

    private void h() {
        AnimatorSet animatorSet = this.F;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.F.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        gm3.a aVar = new gm3.a();
        aVar.S1(this.f338097d, this.f338099f);
        aVar.Q1(false);
    }

    private void l() {
        this.f338101i.addOnEvent(new b());
    }

    private void m() {
        h();
        q();
    }

    private void n(ag agVar) {
        Context context = this.f338102m;
        UIUtil.h(context.getString(R.string.yve, fn3.c.d(context, agVar.f401298d)), false, 0);
        if (2 == agVar.f401300f) {
            m();
        }
        i();
    }

    private void o(ReceiveInviteBubbleView receiveInviteBubbleView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(receiveInviteBubbleView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(receiveInviteBubbleView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(receiveInviteBubbleView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = this.F;
        if (animatorSet == null) {
            this.F = new AnimatorSet();
        } else {
            animatorSet.cancel();
        }
        ofFloat.setDuration(500L);
        ofFloat2.setDuration(5000L);
        ofFloat3.setDuration(500L);
        ofFloat3.addListener(new c());
        this.F.playSequentially(ofFloat, ofFloat2, ofFloat3);
        this.F.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ReceiveInviteBubbleView receiveInviteBubbleView = this.E;
        if (receiveInviteBubbleView != null) {
            receiveInviteBubbleView.setVisibility(8);
            this.D.removeView(this.E);
            this.E = null;
            this.F = null;
        }
    }

    private void s(ag agVar, int[] iArr) {
        if (agVar.f401299e == 1) {
            if (this.E == null) {
                this.E = new ReceiveInviteBubbleView(this.f338102m);
            }
            this.E.setVisibility(0);
            this.E.setNickName(agVar.f401296b.f395729a.f395737c);
            this.E.setInviteBizType(agVar.f401298d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            int i3 = iArr[0];
            layoutParams.bottomMargin = iArr[1];
            layoutParams.leftMargin = i3;
            this.E.setLayoutParams(layoutParams);
            this.D.addView(this.E);
            this.D.setVisibility(0);
            o(this.E);
        }
    }

    public void g() {
        ThreadCenter.postDelayedUITask(this, this.G, 1000L);
    }

    public void i() {
        AegisLogger.i("PK_Biz|AcceptInviteHelper", QCircleLpReportDc05507.KEY_CLEAR);
        ThreadCenter.clear(this);
        this.f338097d = "";
        this.f338099f = null;
        this.f338100h = 15;
    }

    public void j() {
        h();
        i();
        this.f338101i.removeAll();
    }

    public void p(ag agVar, int[] iArr) {
        if (!TextUtils.isEmpty(this.f338097d) && agVar.f401299e == 1) {
            AegisLogger.i("PK_Biz|AcceptInviteHelper", "ignore ReceiveInviteEvent, inviteMsg=" + agVar);
            return;
        }
        EventCenter.post(new d.ReceiveInviteEvent(agVar));
        this.f338097d = agVar.f401295a;
        this.f338099f = agVar.f401296b;
        this.f338098e = agVar.f401298d;
        AegisLogger.i("PK_Biz|AcceptInviteHelper", "processReceiveInvite, inviteMsg=" + agVar);
        int i3 = agVar.f401299e;
        if (i3 == 1) {
            int i16 = agVar.f401300f;
            if (1 == i16) {
                r();
                return;
            } else {
                if (2 == i16) {
                    s(agVar, iArr);
                    g();
                    return;
                }
                return;
            }
        }
        if (i3 == 4) {
            n(agVar);
        }
    }

    public AcceptInviteDialog r() {
        q();
        ThreadCenter.removeUITask(this, this.G);
        AcceptInviteDialog acceptInviteDialog = new AcceptInviteDialog(this.f338097d, this.f338098e, this.f338099f, this.f338100h);
        acceptInviteDialog.show(this.C, "pk_accept_invite_dialog");
        acceptInviteDialog.vh(new a(acceptInviteDialog));
        return acceptInviteDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AcceptInviteHelper.this.q();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
