package ij1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b<T> implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    protected ConcurrentHashMap<String, Object> f407798d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    protected T f407799e;

    /* renamed from: f, reason: collision with root package name */
    protected String f407800f;

    public b(T t16) {
        this.f407799e = t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // 
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b<T> clone() throws CloneNotSupportedException {
        return (b) super.clone();
    }

    public T b() {
        return this.f407799e;
    }

    public String c() {
        return this.f407800f;
    }

    public Object d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return this.f407798d.get(str);
    }

    public void e(String str) {
        this.f407800f = str;
    }

    public void f(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f407798d.put(str, obj);
    }
}
