package lz4;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.an;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    protected Context f415863a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, HashMap<String, kz4.d>> f415864b;

    public d(Context context) {
        this.f415863a = context;
    }

    public static String d(kz4.d dVar) {
        return String.valueOf(dVar.f413529a) + "#" + dVar.f413530b;
    }

    private String g(kz4.d dVar) {
        String str;
        int i3 = dVar.f413529a;
        String str2 = dVar.f413530b;
        if (i3 > 0 && !TextUtils.isEmpty(str2)) {
            str = String.valueOf(i3) + "#" + str2;
        } else {
            str = "";
        }
        File file = new File(this.f415863a.getFilesDir(), "perf");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    private String h(kz4.d dVar) {
        String g16 = g(dVar);
        if (TextUtils.isEmpty(g16)) {
            return null;
        }
        for (int i3 = 0; i3 < 20; i3++) {
            String str = g16 + i3;
            if (an.d(this.f415863a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // lz4.e
    public void a() {
        an.c(this.f415863a, "perf", "perfUploading");
        File[] f16 = an.f(this.f415863a, "perfUploading");
        if (f16 != null && f16.length > 0) {
            for (File file : f16) {
                if (file != null) {
                    List<String> c16 = g.c(this.f415863a, file.getAbsolutePath());
                    file.delete();
                    e(c16);
                }
            }
        }
    }

    @Override // lz4.f
    public void b() {
        HashMap<String, HashMap<String, kz4.d>> hashMap = this.f415864b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f415864b.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, kz4.d> hashMap2 = this.f415864b.get(it.next());
                if (hashMap2 != null && hashMap2.size() > 0) {
                    kz4.d[] dVarArr = new kz4.d[hashMap2.size()];
                    hashMap2.values().toArray(dVarArr);
                    f(dVarArr);
                }
            }
        }
        this.f415864b.clear();
    }

    @Override // lz4.b
    public void c(HashMap<String, HashMap<String, kz4.d>> hashMap) {
        this.f415864b = hashMap;
    }

    public void e(List<String> list) {
        throw null;
    }

    public void f(kz4.d[] dVarArr) {
        String h16 = h(dVarArr[0]);
        if (TextUtils.isEmpty(h16)) {
            return;
        }
        g.g(h16, dVarArr);
    }

    @Override // lz4.f
    public void b(kz4.d dVar) {
        if ((dVar instanceof kz4.c) && this.f415864b != null) {
            kz4.c cVar = (kz4.c) dVar;
            String d16 = d(cVar);
            String a16 = g.a(cVar);
            HashMap<String, kz4.d> hashMap = this.f415864b.get(d16);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            kz4.c cVar2 = (kz4.c) hashMap.get(a16);
            if (cVar2 != null) {
                cVar.f413527i += cVar2.f413527i;
                cVar.f413528j += cVar2.f413528j;
            }
            hashMap.put(a16, cVar);
            this.f415864b.put(d16, hashMap);
        }
    }
}
