package com.qq.e.comm.plugin.base.ad.b.b;

import com.qq.e.comm.plugin.base.ad.b.b.a;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {
    public static List<a> a(int i3, a.b bVar) {
        ArrayList arrayList = new ArrayList();
        if (i3 == 1) {
            arrayList.add(new d(bVar));
            arrayList.add(new b(bVar));
            arrayList.add(new f(bVar));
        } else if (i3 == 2) {
            arrayList.add(new f(bVar));
        }
        return arrayList;
    }

    public static a a(List<a> list, int i3) {
        if (i3 >= 0 && i3 < list.size()) {
            final a aVar = list.get(i3);
            if (aVar != null && aVar.a()) {
                aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.b.b.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b();
                    }
                });
                return aVar;
            }
            GDTLogger.d("loadview, invalid landingPageView");
            return null;
        }
        GDTLogger.d("loadview, illegal index or illegal landingPageList");
        return null;
    }
}
