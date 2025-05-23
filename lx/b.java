package lx;

import com.tencent.biz.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public j f415710a;

    /* renamed from: b, reason: collision with root package name */
    public b f415711b;

    public b(j jVar, b bVar) {
        this.f415710a = jVar;
        this.f415711b = bVar;
    }

    public static boolean g(int i3) {
        if ((i3 & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean h(int i3) {
        if ((i3 & 1) != 0) {
            return true;
        }
        return false;
    }

    public abstract JSONArray a(String str);

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract JSONObject e() throws JSONException;

    public abstract int f(String str, String str2);

    public int i(boolean z16, boolean z17) {
        int i3;
        if (z17) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        return (z16 ? 1 : 0) | i3;
    }
}
