package com.tencent.mobileqq.troop.file.data;

import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes35.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public Map<UUID, com.tencent.mobileqq.troop.data.n> f295494a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public List<com.tencent.mobileqq.troop.data.n> f295495b = new ArrayList();

    public boolean a(com.tencent.mobileqq.troop.data.n nVar) {
        if (this.f295494a.put(nVar.f294915a, nVar) != null) {
            return false;
        }
        this.f295495b.add(nVar);
        return true;
    }

    public boolean b(com.tencent.mobileqq.troop.data.n nVar, TroopFileManager troopFileManager) {
        return a(nVar);
    }

    public com.tencent.mobileqq.troop.data.n c(int i3) {
        return this.f295495b.get(i3);
    }

    public com.tencent.mobileqq.troop.data.n d(UUID uuid) {
        com.tencent.mobileqq.troop.data.n remove = this.f295494a.remove(uuid);
        if (remove != null) {
            this.f295495b.remove(remove);
        }
        return remove;
    }

    public int e() {
        return this.f295495b.size();
    }

    public void f(Comparator<? super com.tencent.mobileqq.troop.data.n> comparator) {
        if (this.f295495b.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.troop.data.n nVar : this.f295495b) {
            if (nVar != null) {
                arrayList.add(nVar);
            }
        }
        Collections.sort(arrayList, comparator);
        this.f295495b.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f295495b.add((com.tencent.mobileqq.troop.data.n) it.next());
        }
    }
}
