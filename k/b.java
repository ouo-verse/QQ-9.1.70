package k;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.text.TextUtils;
import cn.wh.auth.server.ResultRequestService;
import cooperation.qzone.QzoneIPCModule;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    k.a f411298a;

    /* renamed from: b, reason: collision with root package name */
    Activity f411299b;

    /* renamed from: c, reason: collision with root package name */
    l.c f411300c;

    /* renamed from: d, reason: collision with root package name */
    final l.b f411301d = new l.b();

    /* renamed from: e, reason: collision with root package name */
    final Intent f411302e = new Intent();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements ResultRequestService.a {
        a() {
        }

        @Override // cn.wh.auth.server.ResultRequestService.a
        public void onActivityResult(int i3, int i16, Intent intent) {
            if (i16 == -1 && i3 == 111) {
                if (intent != null) {
                    b.this.f411301d.d(intent.getStringExtra(QzoneIPCModule.RESULT_CODE));
                    b.this.f411301d.e(intent.getStringExtra("resultDesc"));
                    b.this.f411301d.b().f(intent.getStringExtra("idCardAuthData"));
                    b.this.f411301d.b().d(intent.getStringExtra("certPwdData"));
                    b.this.f411301d.b().g(intent.getStringExtra("verifyData"));
                    b.this.f411301d.b().e(intent.getStringExtra("extrasData"));
                } else {
                    b.this.f411301d.d("C0412003");
                    b.this.f411301d.e("\u7528\u6237\u5df2\u53d6\u6d88");
                }
            } else {
                b.this.f411301d.d("C0405001");
                b.this.f411301d.e("\u6570\u636e\u5904\u7406\u5f02\u5e38");
            }
            b bVar = b.this;
            bVar.f411298a.a(bVar.f411301d);
        }
    }

    public b(Activity activity, l.c cVar) {
        this.f411299b = activity;
        this.f411300c = cVar;
        c();
    }

    private void c() {
        l.c cVar = this.f411300c;
        if (cVar == null) {
            this.f411301d.e("\u53c2\u6570\u683c\u5f0f\u5f02\u5e38");
            this.f411301d.d("C0401001");
            return;
        }
        String c16 = cVar.c();
        if (!TextUtils.isEmpty(c16) && (!c16.startsWith("{") || !c16.endsWith("}"))) {
            this.f411301d.e("\u53c2\u6570\u683c\u5f0f\u5f02\u5e38");
            this.f411301d.d("C0401001");
            return;
        }
        this.f411302e.setComponent(new ComponentName("cn.cyberIdentity.certification", "cn.wh.project.view.v.authorization.WAuthActivity"));
        this.f411302e.putExtra("extras", c16);
        this.f411302e.putExtra("orgID", this.f411300c.d());
        this.f411302e.putExtra("appID", this.f411300c.a());
        this.f411302e.putExtra("bizSeq", this.f411300c.b());
        this.f411302e.putExtra("type", this.f411300c.e() + "");
    }

    @Deprecated
    public void a(k.a aVar) {
        this.f411298a = aVar;
        if (!TextUtils.isEmpty(this.f411301d.a()) && !TextUtils.isEmpty(this.f411301d.c())) {
            aVar.a(this.f411301d);
            return;
        }
        Intent intent = new Intent(this.f411302e);
        intent.putExtra("packageName", b());
        intent.setFlags(8388608);
        if (this.f411299b.getPackageManager().resolveActivity(intent, 65536) == null) {
            this.f411301d.e("APP\u5c1a\u672a\u5b89\u88c5");
            this.f411301d.d("C0412002");
            this.f411298a.a(this.f411301d);
            return;
        }
        try {
            new ResultRequestService(this.f411299b).g(intent, new a());
        } catch (Exception e16) {
            e16.printStackTrace();
            this.f411301d.e("APP\u5c1a\u672a\u5b89\u88c5");
            this.f411301d.d("C0412002");
            this.f411298a.a(this.f411301d);
        }
    }

    final String b() {
        String packageName = this.f411299b.getApplicationContext().getPackageName();
        String nameForUid = this.f411299b.getPackageManager().getNameForUid(Binder.getCallingUid());
        if (nameForUid != null && nameForUid.equals(packageName)) {
            return packageName;
        }
        return "";
    }
}
