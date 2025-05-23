package com.tencent.biz.pubaccount.weishi;

import UserGrowth.eConfigBit;
import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import UserGrowth.stUserConfigRsp;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f82531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.net.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(com.tencent.biz.pubaccount.weishi.net.l lVar) {
            if (lVar.d()) {
                Object obj = lVar.f80999l;
                if (obj instanceof stUserConfigRsp) {
                    com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "doTask: UserConfig response :  code = " + ((stUserConfigRsp) obj).code);
                    return;
                }
                com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "doTask: UserConfig response : response is not instanceof stUserConfigRsp");
                return;
            }
            com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "doTask: UserConfig response : !task.succeeded()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f82532d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f82533e;

        b(Context context, String str) {
            this.f82532d = context;
            this.f82533e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "jump to miniApp to set auth switch");
            bb.N(this.f82532d, "2");
            WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.f82533e, "authorized_window", 1000007);
            x.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f82535d;

        c(String str) {
            this.f82535d = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "dialog cancel");
            WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.f82535d, "authorized_window", 1000001);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f82537d;

        d(String str) {
            this.f82537d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "dialog click ok");
            WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.f82537d, "authorized_window", 1000001);
            x.this.c();
        }
    }

    private Dialog b(Context context, String str) {
        Dialog dialog = new Dialog(context, R.style.b0z);
        dialog.setContentView(R.layout.fvs);
        View findViewById = dialog.findViewById(R.id.f164985ui0);
        findViewById.findViewById(R.id.f125357lu).setOnClickListener(new b(context, str));
        dialog.setOnCancelListener(new c(str));
        findViewById.findViewById(R.id.f125347lt).setOnClickListener(new d(str));
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "dialog dismiss");
        Dialog dialog = this.f82531a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f82531a.dismiss();
    }

    private static void d() {
        com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "doTask: UserConfig request");
        com.tencent.biz.pubaccount.weishi.net.g.b().g(new com.tencent.biz.pubaccount.weishi.net.l(new i10.k(eConfigBit.eShowConfirmWindow), null, new a(), 4010));
    }

    public static boolean e() {
        stUserAuth o16 = iz.a.g().o();
        com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "\u5224\u65ad\u662f\u5426\u9700\u8981\u5f39\u7a97");
        if (o16 == null) {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "\u6ca1\u6709\u6388\u6743\u5f39\u7a97\u7ed3\u6784\u4f53");
            return false;
        }
        stSchema stschema = o16.schema;
        if (stschema == null) {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "user_auth.schema == null");
            return false;
        }
        if (stschema.type == 1 && !TextUtils.isEmpty(stschema.miniAppSchema)) {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", o16.toString());
            return o16.show_confirm;
        }
        com.tencent.biz.pubaccount.weishi.util.x.i("WSUserAuthDialog", "\u4e0b\u53d1scheme\u4e0d\u5408\u6cd5\uff0c\u4e0d\u5c55\u793a\u5f39\u7a97");
        return false;
    }

    public void f(Context context, String str) {
        Dialog b16 = b(context, str);
        this.f82531a = b16;
        if (b16 != null) {
            b16.setCanceledOnTouchOutside(true);
            this.f82531a.show();
        }
    }

    public static void g(Context context, String str) {
        if (context == null) {
            return;
        }
        WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", str, "authorized_window", 0);
        d();
        new x().f(context, str);
    }
}
