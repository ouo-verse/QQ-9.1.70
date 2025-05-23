package fz1;

import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private c f400964a;

    /* renamed from: b, reason: collision with root package name */
    private List<e> f400965b;

    public a(c cVar, @NonNull List<e> list) {
        this.f400964a = cVar;
        this.f400965b = list;
    }

    public int a() {
        c cVar = this.f400964a;
        if (cVar == null) {
            return 0;
        }
        return cVar.b();
    }

    public List<e> b() {
        return this.f400965b;
    }

    public c c() {
        return this.f400964a;
    }
}
