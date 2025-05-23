package nd4;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nd4.f;
import nd4.g;
import nd4.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected w f419973a;

    /* renamed from: b, reason: collision with root package name */
    protected v f419974b;

    /* renamed from: c, reason: collision with root package name */
    protected m f419975c;

    /* renamed from: d, reason: collision with root package name */
    private c f419976d;

    /* renamed from: e, reason: collision with root package name */
    private ld4.a f419977e;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(@NonNull w wVar) {
        this.f419973a = wVar;
    }

    private boolean a(Map<String, String> map) {
        return u.b(this.f419973a.a(), map);
    }

    private boolean b(Map<String, Float> map) {
        List<z> c16 = this.f419973a.c();
        if (c16.size() != map.size()) {
            return false;
        }
        if (c16.size() == 0) {
            return true;
        }
        Iterator<z> it = c16.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next().b())) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    protected abstract String c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f419973a.b();
    }

    protected void e(String str) {
        ld4.a aVar = this.f419977e;
        if (aVar == null) {
            return;
        }
        aVar.i(c(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(Map<String, String> map, Map<String, Float> map2) {
        if (!a(map)) {
            e(String.format("\u76d1\u63a7\u9879\uff1a%s\uff0c\u6ce8\u518c\u7684\u7ef4\u5ea6\u5217\u8868\u4e0e\u5b9e\u9645\u7684\u7ef4\u5ea6\u5217\u8868\u4e0d\u4e00\u81f4\uff0c\u8bf7\u91cd\u65b0\u786e\u8ba4", d()));
            return false;
        }
        if (!b(map2)) {
            e(String.format("\u76d1\u63a7\u9879\uff1a%s\uff0c\u6ce8\u518c\u7684\u6307\u6807\u5217\u8868\u4e0e\u5b9e\u9645\u7684\u6307\u6807\u5217\u8868\u4e0d\u4e00\u81f4\uff0c\u8bf7\u91cd\u65b0\u786e\u8ba4", d()));
            return false;
        }
        ArrayList arrayList = new ArrayList(this.f419976d.a());
        for (String str : this.f419973a.a()) {
            arrayList.add(new f.b().d(str).e(map.get(str)).c());
        }
        ArrayList arrayList2 = new ArrayList();
        for (z zVar : this.f419973a.c()) {
            String b16 = zVar.b();
            arrayList2.add(new j.a().h(b16).e(zVar.a()).i(map2.get(b16).floatValue()).g(1).f());
        }
        this.f419974b.e(new g.b().h(this.f419973a.b()).e(arrayList).f(arrayList2).j(System.currentTimeMillis()).g());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(@NonNull v vVar, @NonNull m mVar) {
        this.f419974b = vVar;
        this.f419975c = mVar;
        this.f419977e = mVar.f420010a;
        this.f419976d = mVar.f420012c;
    }
}
