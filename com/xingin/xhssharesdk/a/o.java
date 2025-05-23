package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.d;
import com.xingin.xhssharesdk.a.p;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class o extends p<Object, Object> {
    public o(int i3) {
        super(i3, 0);
    }

    @Override // com.xingin.xhssharesdk.a.p
    public final void g() {
        Iterable entrySet;
        if (!this.f389958h) {
            for (int i3 = 0; i3 < this.f389956e.size(); i3++) {
                ((d.a) this.f389956e.get(i3).getKey()).a();
            }
            if (this.f389957f.isEmpty()) {
                entrySet = p.a.f389961b;
            } else {
                entrySet = this.f389957f.entrySet();
            }
            Iterator it = entrySet.iterator();
            while (it.hasNext()) {
                ((d.a) ((Map.Entry) it.next()).getKey()).a();
            }
        }
        super.g();
    }

    @Override // com.xingin.xhssharesdk.a.p, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((d.a) obj, obj2);
    }
}
