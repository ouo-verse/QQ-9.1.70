package com.tencent.qqmini.minigame.helper;

import android.app.Activity;
import com.tencent.qqmini.minigame.ui.b;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Activity f346476a;

    /* renamed from: b, reason: collision with root package name */
    private c f346477b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.qqmini.minigame.ui.b f346478c;

    /* renamed from: d, reason: collision with root package name */
    private String f346479d;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements b.a {
        a() {
        }

        @Override // com.tencent.qqmini.minigame.ui.b.a
        public void onConfirmResult(boolean z16) {
            if (z16) {
                b.this.e();
            } else if (b.this.f346477b != null) {
                b.this.f346477b.a(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface c {
        void a(boolean z16);
    }

    public b(Activity activity, c cVar, String str) {
        this.f346479d = str;
        this.f346476a = activity;
        this.f346477b = cVar;
    }

    private boolean d() {
        Activity activity = this.f346476a;
        if (activity == null) {
            return false;
        }
        int checkSelfPermission = activity.checkSelfPermission(this.f346479d);
        QMLog.i("PermissionHelper", "checkPermission,   isHasPermission: " + checkSelfPermission);
        if (checkSelfPermission != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        QMLog.i("minisdkPermissionHelper", "audio permission:" + this.f346479d);
        ((IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class)).requestForPermission(this.f346476a, this.f346479d, new C9392b());
    }

    public boolean c(String str, String str2, String str3, String str4) {
        if (d()) {
            c cVar = this.f346477b;
            if (cVar != null) {
                cVar.a(true);
            }
            return true;
        }
        if (this.f346478c == null) {
            this.f346478c = new com.tencent.qqmini.minigame.ui.b(this.f346476a);
        }
        this.f346478c.N(str, str2, str3, str4, new a());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.minigame.helper.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C9392b implements RequestPermissionCallback {
        C9392b() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onFail() {
            QMLog.d("PermissionHelper", "request system permission user denied");
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onSuccess() {
            QMLog.d("PermissionHelper", "request system permission user granted");
            if (b.this.f346477b != null) {
                b.this.f346477b.a(true);
            }
            QMLog.i("PermissionHelper", "audio permission:true");
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onPartialGrant() {
        }
    }
}
