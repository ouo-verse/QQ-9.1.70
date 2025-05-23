package my3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private my3.a f417806a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f417807a = new b();
    }

    b() {
        my3.a aVar = new my3.a();
        this.f417806a = aVar;
        aVar.n();
    }

    public static b b() {
        return a.f417807a;
    }

    public my3.a a() {
        return this.f417806a;
    }

    public my3.a c(String str) {
        if (str != null) {
            QLog.d("CrashConfigLoader", 2, "[config] parse: invoked. ", " content: ", str);
            try {
                my3.a a16 = my3.a.a(new JSONObject(str));
                this.f417806a.o(a16);
                return a16;
            } catch (JSONException e16) {
                QLog.e("CrashConfigLoader", 1, "[parse] config parse error: " + e16.toString());
                return null;
            }
        }
        return null;
    }

    public void d() {
        my3.a aVar = (my3.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("crash_report_config");
        if (aVar != null) {
            QLog.d("CrashConfigLoader", 1, "updateConfig " + aVar.toString());
            this.f417806a.o(aVar);
        }
    }
}
