package i45;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes29.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f407216a;

    static {
        ArrayList arrayList = new ArrayList();
        f407216a = arrayList;
        arrayList.add(new d());
        f407216a.add(new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020 A[Catch: all -> 0x003f, TryCatch #1 {, blocks: (B:4:0x0003, B:20:0x000d, B:9:0x0020, B:10:0x0026, B:12:0x002c, B:14:0x0036, B:22:0x0012), top: B:3:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context) {
        int parseInt;
        synchronized (c.class) {
            String a16 = h45.c.a(context);
            if (!TextUtils.isEmpty(a16)) {
                try {
                    parseInt = Integer.parseInt(a16);
                } catch (Exception unused) {
                    e.b("VersionUpdateHelper", "parse encryptversion error:", true);
                }
                if (parseInt < 3) {
                    Iterator<a> it = f407216a.iterator();
                    while (it.hasNext()) {
                        it.next().a(context, parseInt, 3);
                    }
                }
                h45.c.i(context, String.valueOf(3));
            }
            parseInt = -1;
            if (parseInt < 3) {
            }
            h45.c.i(context, String.valueOf(3));
        }
    }
}
