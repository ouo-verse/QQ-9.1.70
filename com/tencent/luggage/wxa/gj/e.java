package com.tencent.luggage.wxa.gj;

import com.tencent.luggage.wxa.rc.o;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.rc.y;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.ej.d {

    /* renamed from: a, reason: collision with root package name */
    public o f126772a = null;

    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 7;
    }

    @Override // com.tencent.luggage.wxa.ej.d
    public String a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        String str;
        o a16 = a(cVar.a());
        if (a16 != null) {
            str = a16.a(hVar.optString("path"));
        } else {
            w.b("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
            str = null;
        }
        w.a("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", hVar.optString("path"), str);
        HashMap hashMap = new HashMap();
        hashMap.put("fullPath", str);
        return cVar.b(hashMap);
    }

    public final o a(com.tencent.luggage.wxa.ic.l lVar) {
        if (this.f126772a == null) {
            com.tencent.luggage.wxa.ic.g runtime = lVar.getRuntime();
            if (lVar.getRuntime().P() instanceof y) {
                LinkedList b16 = ((y) runtime.P()).b();
                int i3 = 0;
                while (true) {
                    if (i3 >= b16.size()) {
                        break;
                    }
                    r rVar = (r) b16.get(i3);
                    if (rVar instanceof o) {
                        this.f126772a = (o) rVar;
                        break;
                    }
                    i3++;
                }
            } else {
                throw new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
            }
        }
        return this.f126772a;
    }
}
