package bc2;

import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f28261a;

    public c() {
        Bundle a16 = b.f28251i.a();
        this.f28261a = a16;
        a16.putString("tid", "personal_live_base");
        a16.putString("bid", "b_sng_im_personal_live");
        a16.putString("KEY_START_SRC", "default");
    }

    public c a(String str, int i3) {
        this.f28261a.putString(str, String.valueOf(i3));
        return this;
    }

    public c b(String str, String str2) {
        if (str2 == null) {
            str2 = "null";
        }
        this.f28261a.putString(str, str2.replace(ContainerUtils.FIELD_DELIMITER, "_"));
        return this;
    }

    public c c(int i3) {
        return a("obj1", i3);
    }

    public c d(String str) {
        return b("obj2", str);
    }

    public c e(String str) {
        return b("obj3", str);
    }

    public void f() {
        b.f28251i.e(this.f28261a);
    }

    public c g(String str) {
        this.f28261a.putString("action", str);
        return this;
    }

    public c h(String str) {
        this.f28261a.putString("module", str);
        return this;
    }

    public c i(String str) {
        this.f28261a.putString("source", str);
        return this;
    }

    public String toString() {
        return "ReportTask{map=" + this.f28261a + '}';
    }
}
