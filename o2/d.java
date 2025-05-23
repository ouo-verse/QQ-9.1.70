package o2;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d extends b {

    /* renamed from: g, reason: collision with root package name */
    private Map<String, a> f421777g = new HashMap();

    public Integer i(String str) {
        if (this.f421777g.get(str) == null) {
            return null;
        }
        return this.f421777g.get(str).a();
    }

    public d j(Map<String, a> map) {
        this.f421777g = map;
        return this;
    }
}
