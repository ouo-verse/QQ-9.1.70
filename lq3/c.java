package lq3;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.open.base.f;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    protected static final String f415414b = "lq3.c";

    /* renamed from: c, reason: collision with root package name */
    protected static c f415415c;

    /* renamed from: a, reason: collision with root package name */
    protected volatile WeakReference<SharedPreferences> f415416a = null;

    public static synchronized c c() {
        c cVar;
        synchronized (c.class) {
            if (f415415c == null) {
                f415415c = new c();
            }
            cVar = f415415c;
        }
        return cVar;
    }

    public String a(String str) {
        return b(str, null);
    }

    public String b(String str, Bundle bundle) {
        if (this.f415416a == null || this.f415416a.get() == null) {
            this.f415416a = new WeakReference<>(b.a(com.tencent.open.adapter.a.f().e(), "OpenSettings"));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                f.c(f415414b, "Get host error. url=" + str);
                return str;
            }
            SharedPreferences sharedPreferences = this.f415416a.get();
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(host, null);
                if (string != null && !host.equals(string)) {
                    if (bundle != null) {
                        bundle.putString(MosaicConstants$JsProperty.PROP_ENV, sharedPreferences.getString("OpenEnvironment", "formal"));
                    }
                    String replace = str.replace(host, string);
                    f.a(f415414b, "return environment url : " + replace);
                    return replace;
                }
                f.a(f415414b, "host=" + host + ", envHost=" + string);
                return str;
            }
            return str;
        } catch (Exception e16) {
            e16.printStackTrace();
            f.c(f415414b, "getEnvUrl error. url=" + str);
            return str;
        }
    }
}
