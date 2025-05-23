package bn0;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public String f28680a;

    /* renamed from: b, reason: collision with root package name */
    public String f28681b;

    /* renamed from: c, reason: collision with root package name */
    public b f28682c;

    /* renamed from: d, reason: collision with root package name */
    public d f28683d;

    /* renamed from: e, reason: collision with root package name */
    public e f28684e;

    public boolean a() {
        if (TextUtils.equals(this.f28680a, "qqadapi") && !TextUtils.isEmpty(this.f28681b)) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (a() && TextUtils.equals(this.f28681b, "handle_click") && this.f28684e != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (a() && TextUtils.equals(this.f28681b, "open_web_page") && this.f28683d != null) {
            return true;
        }
        return false;
    }
}
