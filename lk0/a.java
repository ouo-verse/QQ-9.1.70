package lk0;

import android.support.annotation.NonNull;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements Map<String, Object>, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Map<String, Object> f414907d;

    public a() {
        this.f414907d = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a();
        aVar.f414907d.putAll(this.f414907d);
        return aVar;
    }

    @Override // java.util.Map
    public void clear() {
        this.f414907d.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f414907d.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f414907d.containsValue(obj);
    }

    @Override // java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        return this.f414907d.put(str, obj);
    }

    @Override // java.util.Map
    @NonNull
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f414907d.entrySet();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.f414907d.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f414907d.isEmpty();
    }

    @Override // java.util.Map
    @NonNull
    public Set<String> keySet() {
        return this.f414907d.keySet();
    }

    @Override // java.util.Map
    public void putAll(@NonNull Map<? extends String, ? extends Object> map) {
        this.f414907d.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.f414907d.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f414907d.size();
    }

    @Override // java.util.Map
    @NonNull
    public Collection<Object> values() {
        return this.f414907d.values();
    }

    public a(@NonNull JSONObject jSONObject) {
        this();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                put(str, jSONObject.get(str));
            } catch (JSONException unused) {
            }
        }
    }
}
