package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.d;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.api.IArkQualityReport;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
class ArkSSODataRequest extends d {

    /* renamed from: f, reason: collision with root package name */
    private final WeakReference<AppRuntime> f179311f;

    /* renamed from: g, reason: collision with root package name */
    protected String f179312g;

    /* renamed from: h, reason: collision with root package name */
    protected a f179313h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f179322a;

        /* renamed from: b, reason: collision with root package name */
        String f179323b;

        /* renamed from: c, reason: collision with root package name */
        long f179324c = System.currentTimeMillis();

        a(String str, String str2) {
            this.f179322a = str;
            this.f179323b = str2;
        }

        int a() {
            return (int) (System.currentTimeMillis() - this.f179324c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArkSSODataRequest(AppRuntime appRuntime, String str) {
        this.f179311f = new WeakReference<>(appRuntime);
        this.f179312g = str;
    }

    @Override // com.tencent.mobileqq.activity.aio.item.d
    public void a() {
        this.f179455c = null;
        this.f179454b = -1;
        this.f179456d = null;
        this.f179313h = null;
        f(null);
    }

    @Override // com.tencent.mobileqq.activity.aio.item.d
    public boolean d(String str) {
        if (super.d(str)) {
            return true;
        }
        QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to open, url=%s", str));
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.item.d
    public boolean e(String str) {
        if (this.f179313h == null && !TextUtils.isEmpty(this.f179455c)) {
            a aVar = new a(h(this.f179455c), str);
            this.f179313h = aVar;
            if (TextUtils.isEmpty(aVar.f179322a)) {
                QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, cmd is empty, url=%s, reqData=%s", this.f179455c, str));
                i(this.f179313h);
                return true;
            }
            if (!k(this.f179313h, this.f179453a)) {
                QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, sso.sendAppMsg fail, url=%s, reqData=%s", this.f179455c, str));
                i(this.f179313h);
            }
            return true;
        }
        QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, running url=%s, req=%s", this.f179455c, str));
        return false;
    }

    protected String h(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 6 || !str.substring(0, 6).equalsIgnoreCase("sso://")) {
            return null;
        }
        int indexOf = str.indexOf(47, 6);
        if (indexOf == -1) {
            return str.substring(6);
        }
        return str.substring(6, indexOf);
    }

    void i(final a aVar) {
        final WeakReference weakReference = new WeakReference(this);
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(this.f179312g, new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest.2
            @Override // java.lang.Runnable
            public void run() {
                ArkSSODataRequest arkSSODataRequest = (ArkSSODataRequest) weakReference.get();
                if (arkSSODataRequest == null) {
                    return;
                }
                arkSSODataRequest.j(aVar, -1, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(a aVar, int i3, String str) {
        boolean z16;
        if (aVar != this.f179313h) {
            QLog.i("ArkApp.SSODataRequest", 1, String.format("# onComplete, req canceled, ret=%s, rsp=%s", Integer.valueOf(i3), str));
            return;
        }
        IArkQualityReport iArkQualityReport = (IArkQualityReport) QRoute.api(IArkQualityReport.class);
        AppRuntime appRuntime = this.f179311f.get();
        String str2 = this.f179312g;
        String str3 = aVar.f179322a;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        iArkQualityReport.reportAppSSOResult(appRuntime, str2, str3, z16, aVar.a());
        this.f179454b = i3;
        this.f179456d = str;
        this.f179313h = null;
        d.a aVar2 = this.f179457e;
        this.f179457e = null;
        if (aVar2 != null) {
            aVar2.onComplete();
        }
    }

    protected boolean k(final a aVar, int i3) {
        AppRuntime appRuntime = this.f179311f.get();
        if (appRuntime == null) {
            QLog.i("ArkApp.SSODataRequest", 1, String.format("# fail to send, app is null, url=%s, cmd=%s", this.f179455c, aVar.f179322a));
            return false;
        }
        IArkService iArkService = (IArkService) appRuntime.getRuntimeService(IArkService.class, "all");
        final WeakReference weakReference = new WeakReference(this);
        iArkService.sendAppMsg(aVar.f179322a, aVar.f179323b, this.f179453a, 0, new BusinessObserver() { // from class: com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest.1
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i16, boolean z16, Object obj) {
                final int i17;
                if (z16) {
                    i17 = 0;
                } else {
                    i17 = -1;
                }
                final String str = (String) obj;
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkSSODataRequest.this.f179312g, new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkSSODataRequest arkSSODataRequest = (ArkSSODataRequest) weakReference.get();
                        if (arkSSODataRequest == null) {
                            return;
                        }
                        arkSSODataRequest.j(aVar, i17, str);
                    }
                });
            }
        });
        return true;
    }
}
