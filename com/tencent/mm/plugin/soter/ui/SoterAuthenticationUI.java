package com.tencent.mm.plugin.soter.ui;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.imsdk.BaseConstants;
import com.tencent.luggage.wxa.an.c;
import com.tencent.luggage.wxa.np.k;
import com.tencent.luggage.wxa.sp.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xp.e;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SoterAuthenticationUI extends AppCompatActivity {

    /* renamed from: k, reason: collision with root package name */
    public static MMAlertDialog f152518k;

    /* renamed from: l, reason: collision with root package name */
    public static c f152519l;

    /* renamed from: h, reason: collision with root package name */
    public ResultReceiver f152527h;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.an.c f152520a = null;

    /* renamed from: b, reason: collision with root package name */
    public ProgressDialog f152521b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f152522c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f152523d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f152524e = false;

    /* renamed from: f, reason: collision with root package name */
    public k f152525f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f152526g = null;

    /* renamed from: i, reason: collision with root package name */
    public c.a f152528i = new a();

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.sp.b f152529j = new b();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.an.c.a
        public void a(k kVar) {
            SoterAuthenticationUI.this.f152525f = kVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements com.tencent.luggage.wxa.sp.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.sp.b
        public void a(d dVar) {
            w.d("MicroMsg.SoterAuthenticationUI", "hy: init soter " + dVar.c());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f152532a;

        public /* synthetic */ c(SoterAuthenticationUI soterAuthenticationUI, a aVar) {
            this(soterAuthenticationUI);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            switch (i3) {
                case 0:
                    w.d("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
                    com.tencent.luggage.wxa.bn.d dVar = (com.tencent.luggage.wxa.bn.d) message.obj;
                    WeakReference weakReference = this.f152532a;
                    if (weakReference != null && weakReference.get() != null) {
                        ((SoterAuthenticationUI) this.f152532a.get()).d(dVar);
                        return;
                    } else {
                        w.f("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                case 1:
                    w.d("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
                    com.tencent.luggage.wxa.bn.d dVar2 = (com.tencent.luggage.wxa.bn.d) message.obj;
                    WeakReference weakReference2 = this.f152532a;
                    if (weakReference2 != null && weakReference2.get() != null) {
                        ((SoterAuthenticationUI) this.f152532a.get()).b(dVar2);
                        return;
                    } else {
                        w.f("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                case 2:
                    w.d("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
                    com.tencent.luggage.wxa.bn.d dVar3 = (com.tencent.luggage.wxa.bn.d) message.obj;
                    WeakReference weakReference3 = this.f152532a;
                    if (weakReference3 != null && weakReference3.get() != null) {
                        ((SoterAuthenticationUI) this.f152532a.get()).c(dVar3);
                        return;
                    } else {
                        w.f("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                case 3:
                    w.d("MicroMsg.SoterAuthenticationUI", "hy: request permission");
                    WeakReference weakReference4 = this.f152532a;
                    if (weakReference4 != null && weakReference4.get() != null) {
                        String[] stringArray = message.getData().getStringArray("permissions");
                        int i16 = message.getData().getInt(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE);
                        if (stringArray != null && stringArray.length > 1) {
                            ((SoterAuthenticationUI) this.f152532a.get()).requestPermissions(stringArray, i16);
                            return;
                        } else {
                            w.b("MicroMsg.SoterAuthenticationUI", "hy: permission null");
                            return;
                        }
                    }
                    w.f("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                    return;
                case 4:
                    w.d("MicroMsg.SoterAuthenticationUI", "hy: show progress");
                    WeakReference weakReference5 = this.f152532a;
                    if (weakReference5 != null && weakReference5.get() != null) {
                        ((SoterAuthenticationUI) this.f152532a.get()).e();
                        return;
                    } else {
                        w.f("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                case 5:
                    w.d("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
                    WeakReference weakReference6 = this.f152532a;
                    if (weakReference6 != null && weakReference6.get() != null) {
                        ((SoterAuthenticationUI) this.f152532a.get()).a();
                        return;
                    } else {
                        w.f("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                case 6:
                    w.d("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
                    WeakReference weakReference7 = this.f152532a;
                    if (weakReference7 != null && weakReference7.get() != null) {
                        MMAlertDialog unused = SoterAuthenticationUI.f152518k = (MMAlertDialog) message.obj;
                        return;
                    } else {
                        w.f("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                default:
                    w.b("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", Integer.valueOf(i3));
                    return;
            }
        }

        public c(SoterAuthenticationUI soterAuthenticationUI) {
            this.f152532a = null;
            this.f152532a = new WeakReference(soterAuthenticationUI);
        }

        public final void a() {
            WeakReference weakReference = this.f152532a;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
    }

    public final int a(int i3) {
        if (i3 == 0) {
            return 0;
        }
        switch (i3) {
            default:
                switch (i3) {
                    case BaseConstants.ERR_SVR_MSG_INVALID_TIMESTAMP /* 90006 */:
                    case BaseConstants.ERR_SVR_MSG_BODY_NOT_ARRAY /* 90007 */:
                    case 90011:
                        break;
                    case 90008:
                    case BaseConstants.ERR_SVR_MSG_ADMIN_REQUIRED /* 90009 */:
                    case BaseConstants.ERR_SVR_MSG_INVALID_JSON_FORMAT /* 90010 */:
                        return 3;
                    default:
                        return -1;
                }
            case 90001:
            case 90002:
            case BaseConstants.ERR_SVR_MSG_INVALID_TO_ACCOUNT /* 90003 */:
            case 90004:
                return 2;
        }
    }

    public final void d() {
        boolean b16 = com.tencent.luggage.wxa.qp.a.b();
        w.d("MicroMsg.SoterAuthenticationUI", "hy: isInit:" + b16);
        if (b16) {
            return;
        }
        w.d("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.f152520a.d());
        com.tencent.luggage.wxa.qp.a.a(getApplicationContext(), this.f152529j, new e.b().a(this.f152520a.d()).a());
        this.f152524e = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public final Bundle e(com.tencent.luggage.wxa.bn.d dVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(CheckForwardServlet.KEY_ERR_CODE, dVar.a());
        bundle.putString("err_msg", dVar.b());
        bundle.putByte("use_mode", dVar.e());
        bundle.putString("result_json", dVar.c());
        bundle.putString("result_json_signature", dVar.d());
        w.a("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", bundle.toString());
        return bundle;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return z.j();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        this.f152527h = (ResultReceiver) getIntent().getParcelableExtra("Soter_Result_Receiver");
        c cVar = f152519l;
        if (cVar != null) {
            cVar.a();
        }
        f152519l = new c(this, null);
        com.tencent.luggage.wxa.bn.c cVar2 = new com.tencent.luggage.wxa.bn.c();
        com.tencent.luggage.wxa.bn.d dVar = new com.tencent.luggage.wxa.bn.d();
        a(cVar2, dVar);
        if (dVar.a() != 0) {
            c(dVar);
            return;
        }
        this.f152522c = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.f152523d = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        com.tencent.luggage.wxa.an.c a16 = com.tencent.luggage.wxa.an.a.IML.a(this, cVar2, dVar, f152519l);
        this.f152520a = a16;
        if (a16 == null) {
            w.b("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            dVar.a(BaseConstants.ERR_SVR_MSG_INVALID_TO_ACCOUNT);
            dVar.a("no corresponding mode");
            c(dVar);
            return;
        }
        a16.a((com.tencent.luggage.wxa.wp.c) null);
        this.f152520a.b(null);
        this.f152520a.a(this.f152523d);
        this.f152520a.a(this.f152528i);
        d();
        this.f152526g = getIntent().getStringExtra("key_app_id");
        this.f152520a.a(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.tencent.luggage.wxa.an.c cVar = this.f152520a;
        if (cVar != null) {
            cVar.j();
        }
        ProgressDialog progressDialog = this.f152521b;
        if (progressDialog != null && progressDialog.isShowing()) {
            w.d("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
            this.f152521b.dismiss();
        }
        MMAlertDialog mMAlertDialog = f152518k;
        if (mMAlertDialog != null && mMAlertDialog.isShowing()) {
            w.d("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
            f152518k.dismiss();
        }
        f152519l.a();
        if (this.f152524e) {
            com.tencent.luggage.wxa.qp.a.c();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.tencent.luggage.wxa.an.c cVar = this.f152520a;
        if (cVar != null) {
            cVar.k();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        com.tencent.luggage.wxa.an.c cVar = this.f152520a;
        if (cVar != null) {
            cVar.a(i3, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.tencent.luggage.wxa.an.c cVar = this.f152520a;
        if (cVar != null) {
            cVar.l();
        }
        overridePendingTransition(0, 0);
    }

    public final void c(com.tencent.luggage.wxa.bn.d dVar) {
        this.f152527h.send(1, e(dVar));
        a(dVar);
        finish();
    }

    public final void b(com.tencent.luggage.wxa.bn.d dVar) {
        dVar.a(90008);
        dVar.a("user cancelled the authentication process");
        this.f152527h.send(0, e(dVar));
        a(dVar);
        finish();
    }

    public final void a(com.tencent.luggage.wxa.bn.c cVar, com.tencent.luggage.wxa.bn.d dVar) {
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (w0.c(stringExtra)) {
            w.b("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            dVar.a(BaseConstants.ERR_SVR_MSG_INVALID_TO_ACCOUNT);
            dVar.a("authen mode is null");
            return;
        }
        try {
            cVar.a(Byte.parseByte(w0.b(stringExtra.substring(2), "00"), 16));
            cVar.a(getIntent().getStringExtra("challenge"));
            cVar.b(getIntent().getStringExtra("auth_content"));
            if (!com.tencent.luggage.wxa.bn.b.c()) {
                w.b("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                dVar.a(90001);
                dVar.a("not support soter");
                return;
            }
            if (cVar.c() <= 0) {
                w.b("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                dVar.a(BaseConstants.ERR_SVR_MSG_INVALID_TO_ACCOUNT);
                dVar.a("resp model error");
                return;
            }
            if (w0.c(cVar.a())) {
                w.b("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                dVar.a(90004);
                dVar.a("challenge is null");
            } else if (cVar.a().length() >= 512) {
                w.b("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                dVar.a(90004);
                dVar.a("challenge is too long. 512 chars at most");
            } else if (w0.c(cVar.b())) {
                cVar.b(getString(R.string.f228006sk));
            } else if (cVar.b().length() > 42) {
                w.b("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                cVar.b(getString(R.string.f228006sk));
            }
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            w.b("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", stringExtra);
            dVar.a(BaseConstants.ERR_SVR_MSG_INVALID_TO_ACCOUNT);
            dVar.a("authen mode is illegal: number format error. found: " + stringExtra);
        }
    }

    public final void d(com.tencent.luggage.wxa.bn.d dVar) {
        Bundle e16 = e(dVar);
        k kVar = this.f152525f;
        if (kVar != null) {
            e16.putString("authkey_result_json", kVar.a());
            e16.putString("authkey_result_json_signature", this.f152525f.b());
        }
        this.f152527h.send(-1, e16);
        a(dVar);
        finish();
    }

    public final void e() {
        ProgressDialog progressDialog = this.f152521b;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f152521b = ProgressDialog.show(this, "", getString(R.string.f227996sj), true, false, null);
        }
    }

    public final void a(com.tencent.luggage.wxa.bn.d dVar) {
        if (dVar != null && this.f152522c == 1) {
            com.tencent.luggage.wxa.bn.a.a(this.f152526g, dVar.a(), a(dVar.a()));
        }
    }

    public final void a() {
        ProgressDialog progressDialog = this.f152521b;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.f152521b.dismiss();
    }
}
