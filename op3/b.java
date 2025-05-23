package op3;

import android.content.Context;
import com.tencent.smtt.sdk.CookieSyncManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private CookieSyncManager f423299a;

    /* renamed from: b, reason: collision with root package name */
    private android.webkit.CookieSyncManager f423300b;

    public b(Context context) {
        this.f423299a = CookieSyncManager.createInstance(context);
        this.f423300b = android.webkit.CookieSyncManager.createInstance(context);
    }

    public void a() {
        CookieSyncManager cookieSyncManager = this.f423299a;
        if (cookieSyncManager != null) {
            cookieSyncManager.sync();
        }
        android.webkit.CookieSyncManager cookieSyncManager2 = this.f423300b;
        if (cookieSyncManager2 != null) {
            cookieSyncManager2.sync();
        }
    }
}
