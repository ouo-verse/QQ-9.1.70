package com.vivo.push.f;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class l extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.t tVar = (com.vivo.push.b.t) vVar;
        ArrayList<String> d16 = tVar.d();
        List<String> e16 = tVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i3 = tVar.i();
        com.vivo.push.util.u.c("OnDelTagsTask", "doTask,\u5220\u9664\u6210\u529f\u7684\u6807\u7b7e = " + d16 + " \u5220\u9664\u5931\u8d25\u7684= " + e16 + " \u9519\u8bef\u7801= " + i3);
        String h16 = tVar.h();
        if (d16 != null) {
            for (String str : d16) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e16 != null) {
            for (String str2 : e16) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            com.vivo.push.util.u.c("OnDelTagsTask", "doTask1,\u5220\u9664\u6210\u529f\u7684\u522b\u540d = " + arrayList + " \u5220\u9664\u5931\u8d25\u7684\u522b\u540d= " + arrayList3 + " \u9519\u8bef\u7801= " + i3);
            if (arrayList.size() > 0) {
                com.vivo.push.m.a();
                com.vivo.push.m.b(arrayList);
            }
            com.vivo.push.m.a().a(tVar.h(), i3);
            com.vivo.push.t.b(new m(this, i3, arrayList, arrayList3, h16));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            com.vivo.push.util.u.c("OnDelTagsTask", "doTask1,\u5220\u9664\u6210\u529f\u7684\u6807\u7b7e = " + arrayList + " \u5220\u9664\u5931\u8d25\u7684\u6807\u7b7e= " + arrayList3 + " \u9519\u8bef\u7801= " + i3);
            if (arrayList2.size() > 0) {
                com.vivo.push.m.a().c(arrayList2);
            }
            com.vivo.push.m.a().a(tVar.h(), i3);
            com.vivo.push.t.b(new n(this, i3, arrayList2, arrayList4, h16));
        }
    }
}
