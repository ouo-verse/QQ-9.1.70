package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public class BaseActivityView extends FrameLayout {
    static IPatchRedirector $redirector_;
    QQProgressDialog C;
    private f D;
    protected IPhoneContactService E;
    private Drawable F;
    protected ImageView G;
    protected TextView H;
    protected TextView I;
    protected TextView J;
    protected View K;
    protected View L;
    private boolean M;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f183714d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f183715e;

    /* renamed from: f, reason: collision with root package name */
    private View f183716f;

    /* renamed from: h, reason: collision with root package name */
    private PhoneInnerFrame f183717h;

    /* renamed from: i, reason: collision with root package name */
    BaseActivity f183718i;

    /* renamed from: m, reason: collision with root package name */
    protected int f183719m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseActivityView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                BaseActivityView.this.d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseActivityView.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                BaseActivityView.this.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseActivityView.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                BaseActivityView.this.C = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseActivityView.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4 && BaseActivityView.this.E.isAutoUploadContacts() && NetworkUtil.isNetSupport(BaseActivityView.this.getContext())) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface e {
        TextView a();

        View b();

        TextView c();

        QQAppInterface getApp();

        View getRootView();

        ImageView u();

        TextView v();

        TextView x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class f extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<BaseActivityView> f183724a;

        public f(BaseActivityView baseActivityView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseActivityView);
            } else {
                this.f183724a = new WeakReference<>(baseActivityView);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            BaseActivityView baseActivityView = this.f183724a.get();
            if (baseActivityView == null) {
                return;
            }
            int i3 = message.what;
            boolean z16 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        baseActivityView.w();
                        return;
                    }
                    throw new RuntimeException("Unknown message: " + message.what);
                }
                baseActivityView.d();
                return;
            }
            int i16 = message.arg1;
            if (message.arg2 != 1) {
                z16 = false;
            }
            baseActivityView.b(i16, z16);
        }
    }

    public BaseActivityView(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, i3);
            return;
        }
        if (context instanceof BaseActivity) {
            this.f183718i = (BaseActivity) context;
        }
        this.f183719m = i3;
    }

    private int e() {
        return this.K.getHeight();
    }

    private void n(e eVar) {
        this.J = eVar.x();
        this.f183715e = eVar.a();
        this.K = eVar.b();
        this.L = eVar.getRootView();
        this.G = eVar.u();
        this.H = eVar.c();
        this.I = eVar.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.D.removeMessages(1);
        QQProgressDialog qQProgressDialog = this.C;
        if (qQProgressDialog != null) {
            qQProgressDialog.cancel();
            this.C = null;
        }
    }

    void b(int i3, boolean z16) {
        if (!f() && this.C == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getContext(), e());
            this.C = qQProgressDialog;
            qQProgressDialog.setOnDismissListener(new c());
            if (z16) {
                this.C.setOnKeyListener(new d());
            }
            this.C.setMessage(i3);
            this.C.setCanceledOnTouchOutside(false);
            this.C.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        View view = this.f183716f;
        if (view != null) {
            return view.findViewById(i3);
        }
        return findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.M = true;
            this.f183717h.o();
        }
    }

    protected boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.M;
    }

    public void g(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Intent intent, PhoneInnerFrame phoneInnerFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent, (Object) phoneInnerFrame);
            return;
        }
        this.D = new f(this);
        this.f183717h = phoneInnerFrame;
        e q16 = phoneInnerFrame.q();
        QQAppInterface app = q16.getApp();
        this.f183714d = app;
        this.E = (IPhoneContactService) app.getRuntimeService(IPhoneContactService.class);
        n(q16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f183717h.r(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            m(i3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (z16) {
            BounceScrollView bounceScrollView = (BounceScrollView) layoutInflater.inflate(R.layout.f167679e8, (ViewGroup) null);
            View inflate = layoutInflater.inflate(i3, (ViewGroup) null);
            this.f183716f = inflate;
            bounceScrollView.addView(inflate);
            addView(bounceScrollView);
            return;
        }
        layoutInflater.inflate(i3, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2);
        } else if (!f()) {
            DialogUtil.createCustomDialog(getContext(), 231, str, str2, new b(), null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.J.setVisibility(8);
        this.f183715e.setVisibility(0);
        int i3 = this.f183719m;
        if (i3 == 2) {
            this.H.setVisibility(0);
            this.H.setText(R.string.cancel);
            this.H.setContentDescription(HardCodeUtil.qqStr(R.string.jwf));
            this.G.setVisibility(8);
        } else if (i3 != 1) {
            if (i3 == 0) {
                this.H.setVisibility(0);
                this.G.setVisibility(8);
                this.G.setImageResource(R.drawable.icon_setup);
            } else if (i3 == 5) {
                this.H.setVisibility(8);
                this.G.setVisibility(8);
            } else {
                this.G.setVisibility(8);
                this.H.setVisibility(8);
            }
        }
        this.f183715e.setOnClickListener(new a());
        this.M = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.M = true;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else if (!f()) {
            r(i3);
            this.D.sendEmptyMessageDelayed(2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        } else {
            this.D.sendMessageDelayed(this.D.obtainMessage(1, i3, !z16 ? 1 : 0), j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            s(getResources().getString(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else if (!f()) {
            QQToast.makeText(getContext(), 0, str, 0).show(e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else {
            u(intent, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent, i3);
        } else {
            this.f183717h.x(intent, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.I != null && this.F == null) {
            this.F = getResources().getDrawable(R.drawable.common_loading6);
            this.I.setCompoundDrawablePadding(10);
            this.I.setCompoundDrawablesWithIntrinsicBounds(this.F, (Drawable) null, (Drawable) null, (Drawable) null);
            ((Animatable) this.F).start();
            this.D.removeMessages(3);
            this.D.sendEmptyMessageDelayed(3, 120000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (this.I != null && this.F != null) {
            this.D.removeMessages(3);
            ((Animatable) this.F).stop();
            this.F = null;
            this.I.setCompoundDrawables(null, null, null, null);
        }
    }
}
