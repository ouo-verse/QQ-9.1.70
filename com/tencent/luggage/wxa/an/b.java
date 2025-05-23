package com.tencent.luggage.wxa.an;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imsdk.BaseConstants;
import com.tencent.luggage.wxa.np.k;
import com.tencent.luggage.wxa.np.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xp.b;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.an.c {

    /* renamed from: g, reason: collision with root package name */
    public boolean f121574g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.up.a f121575h;

    /* renamed from: i, reason: collision with root package name */
    public MMAlertDialog f121576i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f121577j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f121578k;

    /* renamed from: l, reason: collision with root package name */
    public final int f121579l;

    /* renamed from: m, reason: collision with root package name */
    public int f121580m;

    /* renamed from: n, reason: collision with root package name */
    public final long f121581n;

    /* renamed from: o, reason: collision with root package name */
    public Animation f121582o;

    /* renamed from: p, reason: collision with root package name */
    public Animation f121583p;

    /* renamed from: q, reason: collision with root package name */
    public Handler f121584q;

    /* renamed from: r, reason: collision with root package name */
    public Runnable f121585r;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.sp.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.sp.b
        public void a(com.tencent.luggage.wxa.sp.c cVar) {
            w.d("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errcode: %d, errmsg: %s", Integer.valueOf(cVar.f135896a), cVar.f135897b);
            b.this.f();
            if (cVar.c()) {
                b.this.a(false);
                if (b.this.a() != null) {
                    b.this.a().a((k) cVar.d());
                }
            } else {
                com.tencent.luggage.wxa.bn.a.a(2, cVar.f135896a, 1L);
            }
            int i3 = cVar.f135896a;
            if (i3 == 1006) {
                w.b("MicroMsg.SoterControllerFingerprint", "hy: model is null");
                b.this.f121600b.a(BaseConstants.ERR_SVR_MSG_BODY_NOT_ARRAY);
                b.this.f121600b.a("auth key can not be retrieved");
                b.this.g();
                return;
            }
            if (i3 == 6) {
                w.e("MicroMsg.SoterControllerFingerprint", "alvinluo: gen auth key failed, remove auth key");
                com.tencent.luggage.wxa.qp.a.a(b.this.d());
                b.this.f121600b.a(BaseConstants.ERR_SVR_MSG_BODY_NOT_ARRAY);
                b.this.f121600b.a("auth key generate failed");
                b.this.g();
                return;
            }
            if (i3 == 1004) {
                w.d("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key");
                com.tencent.luggage.wxa.qp.a.a(b.this.d());
                b.this.f121600b.a(BaseConstants.ERR_SVR_MSG_BODY_NOT_ARRAY);
                b.this.f121600b.a("auth key update error");
                b.this.g();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.an.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6022b implements Runnable {
        public RunnableC6022b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f121575h = new com.tencent.luggage.wxa.up.a();
            b.this.q();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.sp.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.sp.a f121589a;

            public a(com.tencent.luggage.wxa.sp.a aVar) {
                this.f121589a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = (l) this.f121589a.d();
                b.this.f121600b.a(0);
                b.this.f121600b.a("OK");
                b.this.f121600b.a((byte) 1);
                b.this.f121600b.b(lVar.a());
                b.this.f121600b.c(lVar.b());
                b.this.h();
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.sp.b
        public void a(com.tencent.luggage.wxa.sp.a aVar) {
            w.d("MicroMsg.SoterControllerFingerprint", "alvinluo request authentication result errCode: %d, errMsg: %s", Integer.valueOf(aVar.f135896a), aVar.f135897b);
            b.this.f121574g = false;
            if (aVar.c()) {
                b.this.f121584q.postDelayed(new a(aVar), 500L);
                return;
            }
            com.tencent.luggage.wxa.bn.a.a(3, aVar.f135896a, 1L);
            int i3 = aVar.f135896a;
            if (i3 == 1007 || i3 == 1015) {
                w.d("MicroMsg.SoterControllerFingerprint", "hy: start authen error, maybe key invalid. remove former key and give suggestion");
                com.tencent.luggage.wxa.qp.a.a(b.this.d());
                b.this.f121600b.a(BaseConstants.ERR_SVR_MSG_BODY_NOT_ARRAY);
                b.this.f121600b.a("start fingerprint authen failed");
            } else if (i3 == 1021) {
                b.this.f121600b.a(BaseConstants.ERR_SVR_MSG_INVALID_JSON_FORMAT);
                b.this.f121600b.a("authenticate freeze. please try again later");
            } else {
                b.this.f121600b.a(BaseConstants.ERR_SVR_MSG_BODY_NOT_ARRAY);
                b.this.f121600b.a("authenticate error: " + aVar.f135897b);
            }
            b.this.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements DialogInterface.OnShowListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            b.this.f121576i.getButton(-2).setTextColor(z.c().getResources().getColor(R.color.bae));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            w.d("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
            if (b.this.f121575h != null) {
                b.this.f121575h.a();
            }
            b.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements DialogInterface.OnCancelListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            w.d("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
            b.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f121578k.setTextColor(b.this.f121578k.getResources().getColor(R.color.f157177bv4));
            b.this.f121578k.setText(b.this.f121578k.getResources().getString(R.string.f228026sm));
            b.this.f121577j.setImageResource(R.drawable.oio);
        }
    }

    public b(WeakReference weakReference, com.tencent.luggage.wxa.bn.c cVar, com.tencent.luggage.wxa.bn.d dVar, Handler handler) {
        super(weakReference, cVar, dVar, handler);
        this.f121574g = false;
        this.f121575h = null;
        this.f121576i = null;
        this.f121577j = null;
        this.f121578k = null;
        this.f121579l = 3;
        this.f121580m = 0;
        this.f121581n = 500L;
        this.f121582o = null;
        this.f121583p = null;
        this.f121584q = new Handler(Looper.getMainLooper());
        this.f121585r = new i();
    }

    @Override // com.tencent.luggage.wxa.an.c
    public void k() {
        com.tencent.luggage.wxa.up.a aVar;
        if (this.f121574g && (aVar = this.f121575h) != null) {
            aVar.a();
        }
        MMAlertDialog mMAlertDialog = this.f121576i;
        if (mMAlertDialog != null && mMAlertDialog.isShowing()) {
            this.f121576i.dismiss();
        }
    }

    @Override // com.tencent.luggage.wxa.an.c
    public void l() {
        if (this.f121574g) {
            m();
        }
    }

    public final boolean m() {
        i();
        w.d("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        a aVar = new a();
        w.d("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + d());
        int d16 = d();
        c();
        b();
        com.tencent.luggage.wxa.qp.a.a(aVar, false, true, d16, null, null);
        return false;
    }

    public final boolean n() {
        return false;
    }

    public final void o() {
        WeakReference weakReference = this.f121601c;
        if (weakReference != null && weakReference.get() != null) {
            if (this.f121576i == null) {
                MMAlertDialog create = a((Activity) this.f121601c.get()).create();
                this.f121576i = create;
                create.setOnShowListener(new e());
                a(this.f121576i);
                this.f121576i.setCanceledOnTouchOutside(false);
            }
            if (!this.f121576i.isShowing() && this.f121601c.get() != null && !((Activity) this.f121601c.get()).isFinishing() && !((Activity) this.f121601c.get()).isDestroyed()) {
                this.f121576i.show();
                return;
            }
            return;
        }
        w.b("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
        this.f121600b.a(BaseConstants.ERR_SVR_MSG_BODY_NOT_ARRAY);
        this.f121600b.a("internal error occurred: ui released");
        g();
    }

    public final void p() {
        this.f121578k.removeCallbacks(this.f121585r);
        this.f121577j.setImageResource(R.drawable.oiq);
        TextView textView = this.f121578k;
        textView.setTextColor(textView.getResources().getColor(R.color.f157978ct1));
        TextView textView2 = this.f121578k;
        textView2.setText(textView2.getResources().getString(R.string.f228036sn));
    }

    public final void q() {
        this.f121575h = new com.tencent.luggage.wxa.up.a();
        com.tencent.luggage.wxa.qp.a.a(new c(), new b.C6925b().a(d()).a(z.c()).a(this.f121575h).a(this.f121599a.a()).a((com.tencent.luggage.wxa.wp.d) null).a(new d()).a());
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.up.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f121574g = false;
                b.this.a(true);
            }
        }

        public d() {
        }

        @Override // com.tencent.luggage.wxa.up.b
        public void a() {
            w.d("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
            b.this.f121574g = false;
            b.this.f121575h = null;
            b.this.p();
        }

        @Override // com.tencent.luggage.wxa.up.b
        public void b() {
            w.e("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
            b.this.f121574g = true;
        }

        @Override // com.tencent.luggage.wxa.up.b
        public void c() {
            w.f("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
            b.this.a(z.c().getString(R.string.f228016sl));
            b.this.f121584q.postDelayed(new a(), 500L);
        }

        @Override // com.tencent.luggage.wxa.up.b
        public void d() {
            w.e("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
            b.this.f121575h = null;
        }

        @Override // com.tencent.luggage.wxa.up.b
        public void b(int i3, CharSequence charSequence) {
            w.d("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", Integer.valueOf(i3), charSequence);
        }

        @Override // com.tencent.luggage.wxa.up.b
        public void a(int i3, CharSequence charSequence) {
            w.b("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", Integer.valueOf(i3), charSequence);
        }
    }

    @Override // com.tencent.luggage.wxa.an.c
    public void a(Bundle bundle) {
        if (!com.tencent.luggage.wxa.jp.a.c(z.c())) {
            this.f121600b.a(90011);
            this.f121600b.a("no fingerprint enrolled");
            g();
        }
        try {
            if (z.c().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                a(new String[]{"android.permission.USE_FINGERPRINT"}, 0);
            } else {
                this.f121574g = true;
            }
        } catch (NoSuchMethodError unused) {
            w.d("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.f121574g = true;
        }
    }

    @Override // com.tencent.luggage.wxa.an.c
    public void a(int i3, String[] strArr, int[] iArr) {
        if (i3 == 0) {
            if (strArr.length >= 1 && iArr.length >= 1 && "android.permission.USE_FINGERPRINT".equals(strArr[0]) && iArr[0] == 0) {
                w.d("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
                m();
                this.f121574g = true;
            } else {
                w.f("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
                this.f121600b.a(90002);
                this.f121600b.a("user not grant to use fingerprint");
                g();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.an.c
    public void j() {
    }

    public final void a(boolean z16) {
        MMAlertDialog mMAlertDialog = this.f121576i;
        if (mMAlertDialog == null || !mMAlertDialog.isShowing()) {
            o();
        }
        if (z16 && !n()) {
            w.d("MicroMsg.SoterControllerFingerprint", "hy: req restart after fail, but no need");
        } else {
            if (this.f121575h != null) {
                w.b("MicroMsg.SoterControllerFingerprint", "alvinluo mFingerprintCanceller not null, cancel and start auth by delaying 500ms.");
                this.f121575h.a();
                this.f121584q.postDelayed(new RunnableC6022b(), 500L);
                return;
            }
            q();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f121596a;

        public h(CharSequence charSequence) {
            this.f121596a = charSequence;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.f121578k.post(b.this.f121585r);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.f121577j.setImageResource(R.drawable.oip);
            b.this.f121578k.setText(this.f121596a);
            b.this.f121578k.setTextColor(b.this.f121578k.getResources().getColor(R.color.cye));
            b.this.f121578k.removeCallbacks(b.this.f121585r);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    public MMAlertDialog.Builder a(Activity activity) {
        MMAlertDialog.Builder builder = new MMAlertDialog.Builder(activity);
        View inflate = activity.getLayoutInflater().inflate(R.layout.e7j, (ViewGroup) null, false);
        this.f121577j = (ImageView) inflate.findViewById(R.id.v6h);
        this.f121578k = (TextView) inflate.findViewById(R.id.v6i);
        ((TextView) inflate.findViewById(R.id.v6g)).setText(this.f121599a.b());
        builder.setView(inflate);
        builder.setCancelable(true);
        builder.setNegativeBtnText(R.string.f227986si).setNegativeBtnListener(new f());
        builder.setOnCancelListener(new g());
        return builder;
    }

    public final void a(CharSequence charSequence) {
        if (this.f121582o == null) {
            this.f121582o = a(this.f121577j.getContext(), -1L);
        }
        if (this.f121583p == null) {
            this.f121583p = a(this.f121577j.getContext(), -1L);
        }
        this.f121582o.setAnimationListener(new h(charSequence));
        this.f121578k.startAnimation(this.f121582o);
        this.f121577j.startAnimation(this.f121583p);
    }

    public static Animation a(Context context, long j3) {
        if (context == null) {
            w.b("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f154475lr);
        if (j3 > 0) {
            loadAnimation.setDuration(j3);
        }
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        return loadAnimation;
    }
}
