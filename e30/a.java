package e30;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, Object> f395524a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected T f395525b;

    public a(T t16) {
        this.f395525b = t16;
    }

    public T a() {
        return this.f395525b;
    }

    public Object b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Object();
        }
        return this.f395524a.get(str);
    }

    public a<T> c(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.f395524a.put(str, obj);
        return this;
    }
}
