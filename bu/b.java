package bu;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f29138b;

    /* renamed from: a, reason: collision with root package name */
    private String f29139a;

    b() {
    }

    public static b a() {
        if (f29138b == null) {
            synchronized (b.class) {
                if (f29138b == null) {
                    f29138b = new b();
                    f29138b.c();
                }
            }
        }
        return f29138b;
    }

    public String b() {
        String str;
        synchronized (b.class) {
            if (this.f29139a == null) {
                String e16 = a.e("/sdcard/Android/data/com.tencent.mobileqq/", "QavSdkConfig.txt");
                if (TextUtils.isEmpty(e16)) {
                    e16 = "";
                }
                this.f29139a = e16;
            }
            str = this.f29139a;
        }
        return str;
    }

    private void c() {
    }
}
