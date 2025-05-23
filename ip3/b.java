package ip3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/OpenSdkApi/Inject_web_view_open_sdk_api.yml", version = 1)
    private static ArrayList<Class<? extends a>> f408135b;

    /* renamed from: c, reason: collision with root package name */
    private static b f408136c;

    /* renamed from: a, reason: collision with root package name */
    private a f408137a;

    static {
        ArrayList<Class<? extends a>> arrayList = new ArrayList<>();
        f408135b = arrayList;
        arrayList.add(jp3.a.class);
    }

    public b() {
        try {
            this.f408137a = f408135b.get(0).newInstance();
        } catch (Exception e16) {
            QLog.i("WebViewOpenSdkApi", 1, "newInstance error:" + e16);
        }
    }

    public static b h() {
        if (f408136c == null) {
            synchronized (b.class) {
                if (f408136c == null) {
                    f408136c = new b();
                }
            }
        }
        return f408136c;
    }

    public void a(String str, String str2, boolean z16) {
        if (b()) {
            return;
        }
        this.f408137a.f(str, str2, z16);
    }

    protected boolean b() {
        if (this.f408137a == null) {
            QLog.i("WebViewOpenSdkApi", 1, "api instance is null,return");
            return true;
        }
        return false;
    }

    public Object c(Activity activity, AppRuntime appRuntime, Object obj, Intent intent) {
        if (b()) {
            return null;
        }
        return this.f408137a.e(activity, appRuntime, obj, intent);
    }

    public void d(Activity activity, Bundle bundle) {
        if (b()) {
            return;
        }
        this.f408137a.a(activity, bundle);
    }

    public void e(Bundle bundle, Activity activity, String str, String str2) {
        if (b()) {
            return;
        }
        this.f408137a.c(bundle, activity, str, str2);
    }

    public void f(String str, String str2, String str3, String str4, long j3, Activity activity, String str5) {
        if (b()) {
            return;
        }
        this.f408137a.b(str, str2, str3, str4, j3, activity, str5);
    }

    public Object g(String str) {
        if (b()) {
            return null;
        }
        return this.f408137a.g(str);
    }

    public boolean i(String str) {
        if (b()) {
            return false;
        }
        return this.f408137a.h(str);
    }

    public void j(Context context, Object obj) {
        if (b()) {
            return;
        }
        this.f408137a.d(context, obj);
    }
}
