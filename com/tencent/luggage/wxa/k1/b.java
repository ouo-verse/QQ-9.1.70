package com.tencent.luggage.wxa.k1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.luggage.wxa.hd.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements com.tencent.luggage.wxa.hd.a {

    /* renamed from: a, reason: collision with root package name */
    public final List f131413a = new LinkedList();

    public b() {
        a(new c());
    }

    @Override // com.tencent.luggage.wxa.hd.a
    public void a(String str, Map map, a.c cVar) {
        if (TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.a(null);
            }
        } else {
            for (a.InterfaceC6261a interfaceC6261a : this.f131413a) {
                if (interfaceC6261a.a(str)) {
                    interfaceC6261a.a(str, map, cVar);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.hd.a
    public Bitmap b(String str, Rect rect, a.b bVar) {
        if (str != null && str.length() != 0) {
            for (a.InterfaceC6261a interfaceC6261a : this.f131413a) {
                if (interfaceC6261a.a(str)) {
                    return interfaceC6261a.a(str, rect, bVar);
                }
            }
        }
        return null;
    }

    public final void a(a.InterfaceC6261a interfaceC6261a) {
        if (interfaceC6261a == null) {
            return;
        }
        this.f131413a.remove(interfaceC6261a);
        this.f131413a.add(interfaceC6261a);
    }
}
