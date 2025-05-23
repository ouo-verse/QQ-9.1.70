package com.tencent.localedit.andserver.processor.generator;

import android.content.Context;
import com.tencent.localedit.fakenative.localserver.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s11.a;
import s11.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class AdapterRegister implements a {
    private Map<String, List<n11.a>> mMap = new HashMap();

    public AdapterRegister() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e());
        this.mMap.put("default", arrayList);
    }

    @Override // s11.a
    public void onRegister(Context context, String str, b bVar) {
        List list = this.mMap.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        List<n11.a> list2 = this.mMap.get("default");
        if (list2 != null && !list2.isEmpty()) {
            list.addAll(list2);
        }
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bVar.a((n11.a) it.next());
            }
        }
    }
}
