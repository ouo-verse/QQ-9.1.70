package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.hn.yb;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends FrameLayout {
    public View C;
    public boolean D;
    public l E;
    public MMAlertDialog F;
    public View.OnClickListener G;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.id.e f151927a;

    /* renamed from: b, reason: collision with root package name */
    public ViewGroup f151928b;

    /* renamed from: c, reason: collision with root package name */
    public RemoteDebugMoveView f151929c;

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f151930d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f151931e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f151932f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f151933g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f151934h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f151935i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f151936j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f151937k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f151938l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f151939m;

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC7055a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f151940a;

        public RunnableC7055a(String str) {
            this.f151940a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f151940a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f151929c.a(a.this.getWidth(), a.this.getHeight());
            a aVar = a.this;
            aVar.addView(aVar.f151929c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f151928b == null) {
                w.f("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
                return;
            }
            if (a.this.d()) {
                a.this.setVisibility(0);
                if (a.this.f151928b.indexOfChild(a.this) == -1) {
                    a.this.f151928b.addView(a.this);
                }
                a.this.f151928b.bringChildToFront(a.this);
                a aVar = a.this;
                aVar.setBackgroundColor(aVar.getContext().getResources().getColor(R.color.f157169kb));
                return;
            }
            a aVar2 = a.this;
            aVar2.setBackgroundColor(aVar2.getContext().getResources().getColor(R.color.ajr));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.a(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (a.this.E != null) {
                a.this.E.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f151927a.A()) {
                a.this.f151939m.setImageResource(R.drawable.j_x);
                a.this.f151932f.setText(a.this.getContext().getString(R.string.f170373z14));
            } else if (a.this.f151927a.C()) {
                a.this.f151939m.setImageResource(R.drawable.j_x);
                a.this.f151932f.setText(a.this.getContext().getString(R.string.z16));
            } else {
                a.this.f151939m.setImageResource(R.drawable.j_w);
                a.this.f151932f.setText(a.this.getContext().getString(R.string.f170372z13));
            }
            a.this.j();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j();
            a.this.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f151950a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ yb f151951b;

        public j(int i3, yb ybVar) {
            this.f151950a = i3;
            this.f151951b = ybVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c("cmdId " + this.f151950a + ", errCode " + this.f151951b.f129091d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f151953a;

        public k(String str) {
            this.f151953a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c(this.f151953a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface l {
        void a();
    }

    public a(Context context, com.tencent.luggage.wxa.id.e eVar, l lVar) {
        super(context);
        this.f151930d = new LinkedList();
        this.D = false;
        this.G = new e();
        this.f151927a = eVar;
        this.E = lVar;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(getContext().getResources().getColor(R.color.ajr));
        setId(R.id.sqt);
    }

    public void a(int i3) {
    }

    @Override // android.view.View
    public void bringToFront() {
        if (this.f151928b == null) {
            w.f("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
        }
    }

    public void k() {
        c0.a(new g());
    }

    public void l() {
        c0.a(new i());
    }

    public final void m() {
        this.f151933g.setText(getContext().getString(R.string.z18, Integer.valueOf(this.f151927a.r().size()), Integer.valueOf(this.f151927a.m().size()), Long.valueOf(this.f151927a.o())));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (d()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void c() {
        this.f151935i.setOnClickListener(this.G);
        this.f151936j.setOnClickListener(this.G);
        this.f151934h.setOnClickListener(this.G);
    }

    public final boolean d() {
        return this.f151927a.A() || this.f151927a.B() || this.f151927a.z();
    }

    public void e() {
        h();
        k();
    }

    public void f() {
        e();
        c0.a(new h());
    }

    public void g() {
        if (this.D) {
            this.C.setVisibility(0);
            if (this.f151930d.size() > 0) {
                this.f151937k.setVisibility(0);
            } else {
                this.f151937k.setVisibility(8);
            }
            this.f151935i.setVisibility(8);
        } else {
            this.C.setVisibility(8);
            this.f151937k.setVisibility(8);
            this.f151935i.setVisibility(0);
        }
        invalidate();
    }

    public void h() {
        c0.a(new d());
    }

    public final void i() {
        MMAlertDialog mMAlertDialog = this.F;
        if (mMAlertDialog == null || !mMAlertDialog.isShowing()) {
            Context context = getContext();
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                return;
            }
            MMAlertDialog create = new MMAlertDialog.Builder(context).setTitle(context.getString(R.string.z1_)).setMsg("").setPositiveBtnText(R.string.f170648xe).setPositiveBtnListener(new f()).setNegativeBtnText(R.string.f170647xd).create();
            this.F = create;
            create.show();
        }
    }

    public final void j() {
        if (!this.f151927a.y() && this.f151927a.C()) {
            this.f151938l.setImageResource(R.drawable.j_x);
            this.f151931e.setText(getContext().getString(R.string.z1b));
        } else {
            this.f151938l.setImageResource(R.drawable.j_w);
            this.f151931e.setText(getContext().getString(R.string.z1a));
        }
    }

    public void b() {
        RemoteDebugMoveView remoteDebugMoveView = (RemoteDebugMoveView) LayoutInflater.from(getContext()).inflate(R.layout.dyf, (ViewGroup) null);
        this.f151929c = remoteDebugMoveView;
        this.f151932f = (TextView) remoteDebugMoveView.findViewById(R.id.ssb);
        this.f151931e = (TextView) this.f151929c.findViewById(R.id.ssk);
        this.f151933g = (TextView) this.f151929c.findViewById(R.id.ssf);
        this.f151934h = (TextView) this.f151929c.findViewById(R.id.ssh);
        this.f151935i = (TextView) this.f151929c.findViewById(R.id.sse);
        this.f151936j = (TextView) this.f151929c.findViewById(R.id.ss_);
        this.f151937k = (TextView) this.f151929c.findViewById(R.id.ssd);
        this.f151939m = (ImageView) this.f151929c.findViewById(R.id.ssa);
        this.f151938l = (ImageView) this.f151929c.findViewById(R.id.ssi);
        this.C = this.f151929c.findViewById(R.id.ssc);
        g();
        c();
    }

    public void d(String str) {
        c0.a(new RunnableC7055a(str));
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        this.f151928b = gVar.K();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        gVar.a((View) this);
        b();
        postDelayed(new c(), 100L);
    }

    public final void c(String str) {
        this.f151930d.add(0, str);
        while (this.f151930d.size() > 10) {
            this.f151930d.removeLast();
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it = this.f151930d.iterator();
        while (it.hasNext()) {
            sb5.append((String) it.next());
            sb5.append("\n");
        }
        this.f151937k.setText(sb5.toString());
        if (this.D) {
            this.f151937k.setVisibility(0);
        } else {
            this.f151937k.setVisibility(8);
        }
    }

    public void a() {
        setVisibility(8);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
            removeAllViews();
        }
        this.f151928b = null;
    }

    public void a(View view) {
        if (view.getId() == R.id.sse) {
            this.D = true;
            g();
            this.f151929c.a();
        } else if (view.getId() == R.id.ss_) {
            this.D = false;
            g();
        } else if (view.getId() == R.id.ssh) {
            i();
        }
    }

    public void b(String str) {
        if (w0.c(str)) {
            return;
        }
        c0.a(new k(str));
    }

    public void a(int i3, yb ybVar) {
        c0.a(new j(i3, ybVar));
    }

    public final void a(String str) {
        Context context = getContext();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        MMAlertDialog create = new MMAlertDialog.Builder(context).setTitle("").setMsg(context.getString(R.string.f170374z15, str)).setPositiveBtnText(R.string.f170648xe).setPositiveBtnListener(new b()).create();
        create.setCancelable(true);
        create.show();
    }
}
