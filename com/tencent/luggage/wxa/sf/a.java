package com.tencent.luggage.wxa.sf;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnumTableID;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: l, reason: collision with root package name */
    public static a f140322l = new a();

    /* renamed from: e, reason: collision with root package name */
    public e0 f140327e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f140328f;

    /* renamed from: g, reason: collision with root package name */
    public Activity f140329g;

    /* renamed from: h, reason: collision with root package name */
    public ResultReceiver f140330h;

    /* renamed from: i, reason: collision with root package name */
    public WeUIProgresssDialog f140331i;

    /* renamed from: a, reason: collision with root package name */
    public int f140323a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f140324b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f140325c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f140326d = false;

    /* renamed from: j, reason: collision with root package name */
    public MMAlertDialog f140332j = null;

    /* renamed from: k, reason: collision with root package name */
    public final Handler f140333k = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sf.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6716a implements e0.a {
        public C6716a() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", Integer.valueOf(a.this.f140323a));
            a.b(a.this);
            if (a.this.f140323a > 10) {
                w.d("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", 10);
                a.this.c();
                a.this.b();
                return false;
            }
            if (!com.tencent.luggage.wxa.tf.d.d()) {
                return true;
            }
            w.d("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
            a.this.c();
            a.this.a(true);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo user click cancel button of NFC tips dialog.");
            a.this.b(13001, "system NFC switch not opened");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
            a.this.b(13001, "system NFC switch not opened");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements LuggageActivityHelper.d {
        public e() {
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public void a(int i3, Intent intent) {
            a.f140322l.a(1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentName f140339a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.sf.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6717a implements LuggageActivityHelper.d {
            public C6717a() {
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.d
            public void a(int i3, Intent intent) {
                a.f140322l.a(2);
            }
        }

        public f(ComponentName componentName) {
            this.f140339a = componentName;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f140326d = true;
            Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
            intent.putExtra("category", "payment");
            intent.putExtra(HippyQQConstants.URL_COMPONENT_NAME, this.f140339a);
            if (a.this.f140329g != null && intent.resolveActivity(a.this.f140329g.getPackageManager()) != null) {
                LuggageActivityHelper.FOR(a.this.f140329g).startActivityForResult(intent, new C6717a());
                return;
            }
            w.b("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication can not find activity");
            if (a.this.f140329g != null) {
                a aVar = a.this;
                aVar.a(TVKEventId.PLAYER_STATE_IS_USE_PROXY, "not set default NFC application", aVar.f140329g.getString(R.string.f1639624j));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f140342a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f140343b;

        public g(int i3, String str) {
            this.f140342a = i3;
            this.f140343b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.a(this.f140342a, this.f140343b);
        }
    }

    public static /* synthetic */ int b(a aVar) {
        int i3 = aVar.f140323a;
        aVar.f140323a = i3 + 1;
        return i3;
    }

    public final void f() {
        if (this.f140329g == null) {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo jumpNFCSetting mHceActivity is null");
        } else {
            LuggageActivityHelper.FOR(this.f140329g).startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), new e());
        }
    }

    public final void g() {
        e0 e0Var = new e0(Looper.getMainLooper(), (e0.a) new C6716a(), true);
        this.f140327e = e0Var;
        e0Var.a(0L, 300L);
        j();
    }

    public void h() {
        this.f140325c = false;
        this.f140326d = false;
        this.f140324b = false;
    }

    public final void i() {
        Activity activity = this.f140329g;
        if (activity == null) {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
            return;
        }
        if (this.f140324b) {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
            a(13001, "system NFC switch not opened", this.f140329g.getString(R.string.f1639524i));
            return;
        }
        MMAlertDialog.Builder builder = new MMAlertDialog.Builder(activity);
        builder.setMsg(this.f140329g.getString(R.string.f1639724k)).setPositiveBtnText(this.f140329g.getString(R.string.f1639324g)).setPositiveBtnListener(new b());
        if (e()) {
            builder.setNegativeBtnText(this.f140329g.getString(R.string.f1638624_)).setNegativeBtnListener(new c());
        } else {
            builder.setPositiveBtnText(this.f140329g.getString(R.string.f1638724a));
        }
        builder.setOnCancelListener(new d());
        MMAlertDialog create = builder.create();
        this.f140332j = create;
        create.setCanceledOnTouchOutside(false);
        this.f140332j.show();
        this.f140324b = true;
    }

    public final void j() {
        Activity activity = this.f140329g;
        if (activity != null) {
            this.f140331i = WeUIProgresssDialog.show((Context) activity, (CharSequence) activity.getString(R.string.f1638824b), false, (DialogInterface.OnCancelListener) null);
        } else {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
        }
    }

    public void c() {
        MMAlertDialog mMAlertDialog = this.f140332j;
        if (mMAlertDialog != null && mMAlertDialog.isShowing()) {
            this.f140332j.dismiss();
            this.f140332j = null;
        }
        d();
    }

    public final void d() {
        WeUIProgresssDialog weUIProgresssDialog = this.f140331i;
        if (weUIProgresssDialog != null) {
            weUIProgresssDialog.dismiss();
            this.f140331i = null;
        }
    }

    public final boolean e() {
        if (this.f140329g == null) {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
            return false;
        }
        List list = (List) com.tencent.luggage.wxa.ia.a.a(this.f140329g.getPackageManager(), com.tencent.luggage.wxa.ja.b.a(65536, new com.tencent.luggage.wxa.ja.a()).a(new Intent("android.settings.NFC_SETTINGS")).a(), "com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/HCEActivityMgr", "isCanJumpNFCSetting", "()Z", "android/content/pm/PackageManager", "queryIntentActivities", "(Landroid/content/Intent;I)Ljava/util/List;");
        if (list != null && list.size() > 0) {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo NFC activity not null, activities size: " + list.size());
            for (int i3 = 0; i3 < list.size(); i3++) {
                w.d("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", ((ResolveInfo) list.get(i3)).activityInfo.name);
            }
            return true;
        }
        w.b("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
        return false;
    }

    public void b(ComponentName componentName) {
        w.d("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
        if (componentName == null) {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent paymentServiceComponent is null");
        }
        this.f140328f = componentName;
    }

    public void a(Activity activity, ResultReceiver resultReceiver) {
        w.d("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
        if (activity == null || resultReceiver == null) {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
        }
        this.f140329g = activity;
        this.f140330h = resultReceiver;
    }

    public final void b() {
        if (!com.tencent.luggage.wxa.tf.d.c()) {
            a(1, GProEnumTableID.ENUMTABLEIDQGROUPFEEDACTOPT, "not support NFC");
            return;
        }
        if (!com.tencent.luggage.wxa.tf.d.b()) {
            a(1, TVKEventId.PLAYER_STATE_UPDATE_VIEW, "not support HCE");
        } else if (!com.tencent.luggage.wxa.tf.d.d()) {
            i();
        } else {
            a(true);
        }
    }

    public void a(int i3) {
        if (i3 == 1) {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
            this.f140325c = true;
        } else if (i3 == 2) {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
        }
    }

    public void a() {
        if (this.f140325c) {
            g();
        } else {
            b();
        }
    }

    public final void b(int i3, String str) {
        a(i3, str);
    }

    public final void a(boolean z16) {
        Activity activity = this.f140329g;
        if (activity == null) {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
            return;
        }
        CardEmulation cardEmulation = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(activity));
        w.d("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.f140328f);
        if (cardEmulation.isDefaultServiceForCategory(this.f140328f, "payment")) {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
            a(0, "NFC switch has opened and now is NFC default application");
        } else {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", Boolean.valueOf(z16));
            if (z16) {
                a(this.f140328f);
            }
        }
    }

    public final void a(ComponentName componentName) {
        if (this.f140329g == null) {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
            return;
        }
        w.d("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", Boolean.valueOf(this.f140326d));
        if (this.f140326d) {
            w.d("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
            a(TVKEventId.PLAYER_STATE_IS_USE_PROXY, "not set default NFC application", this.f140329g.getString(R.string.f1639624j));
        } else {
            this.f140333k.postDelayed(new f(componentName), 200L);
        }
    }

    public final void a(int i3, String str, String str2) {
        c();
        Activity activity = this.f140329g;
        if (activity == null) {
            w.b("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
            return;
        }
        MMAlertDialog.Builder builder = new MMAlertDialog.Builder(activity);
        builder.setTitle("");
        builder.setMsg(str2);
        builder.setPositiveBtnText(this.f140329g.getString(R.string.f1638724a)).setPositiveBtnListener(new g(i3, str));
        builder.setCancelable(true);
        MMAlertDialog create = builder.create();
        this.f140332j = create;
        create.setCanceledOnTouchOutside(false);
        this.f140332j.show();
    }

    public final void a(int i3, int i16, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i16);
        bundle.putString("errMsg", str);
        this.f140330h.send(10001, bundle);
    }

    public final void a(int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i3);
        bundle.putString("errMsg", str);
        this.f140330h.send(10001, bundle);
    }
}
