package com.tencent.mobileqq.proavatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ2\u0010\n\u001a\u00020\t2\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010\f\u001a\u00020\t2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/proavatar/j;", "Lcom/tencent/qqnt/avatar/core/b;", "", "Lcom/tencent/qqnt/avatar/layer/d;", "", "list", "", "", "map", "Lcom/tencent/qqnt/avatar/core/c;", "b", "raw", "a", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class j implements com.tencent.qqnt.avatar.core.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f259629a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17491);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f259629a = new j();
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qqnt.avatar.core.c b(List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> list, Map<Integer, Integer> map) {
        List list2;
        Map map2;
        list2 = CollectionsKt___CollectionsKt.toList(list);
        map2 = MapsKt__MapsKt.toMap(map);
        return new com.tencent.qqnt.avatar.core.c(list2, map2);
    }

    @Override // com.tencent.qqnt.avatar.core.b
    @NotNull
    public com.tencent.qqnt.avatar.core.c a(@NotNull Map<Integer, ? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> raw) {
        List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> list;
        Map<Integer, Integer> map;
        boolean z16;
        List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> list2;
        Map<Integer, Integer> map2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.core.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) raw);
        }
        Intrinsics.checkNotNullParameter(raw, "raw");
        HashSet hashSet = new HashSet(raw.keySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            linkedHashMap.put(key, 2);
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.qqnt.avatar.layer.d<? extends Object> dVar = raw.get(5);
        if (dVar != null) {
            com.tencent.qqnt.avatar.layer.d<? extends Object> dVar2 = raw.get(0);
            if (dVar2 != null) {
                arrayList.add(0, dVar2);
            }
            arrayList.add(dVar);
            linkedHashMap.put(5, 0);
            return b(arrayList, linkedHashMap);
        }
        com.tencent.qqnt.avatar.layer.d<? extends Object> dVar3 = raw.get(3);
        if (dVar3 != null) {
            arrayList.add(dVar3);
            linkedHashMap.put(3, 0);
            com.tencent.qqnt.avatar.layer.d<? extends Object> dVar4 = raw.get(2);
            if (dVar4 != null) {
                arrayList.add(0, dVar4);
                linkedHashMap.put(2, 0);
                list2 = CollectionsKt___CollectionsKt.toList(arrayList);
                map2 = MapsKt__MapsKt.toMap(linkedHashMap);
                return b(list2, map2);
            }
            com.tencent.qqnt.avatar.layer.d<? extends Object> dVar5 = raw.get(1);
            if (dVar5 != null) {
                arrayList.add(0, dVar5);
                linkedHashMap.put(1, 0);
            } else {
                com.tencent.qqnt.avatar.layer.d<? extends Object> dVar6 = raw.get(4);
                if (dVar6 != null) {
                    arrayList.add(0, dVar6);
                    linkedHashMap.put(4, 0);
                }
            }
            com.tencent.qqnt.avatar.layer.d<? extends Object> dVar7 = raw.get(0);
            if (dVar7 != null) {
                com.tencent.qqnt.avatar.layer.c c16 = dVar7.c();
                if (c16 != null && c16.a()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.clear();
                    linkedHashMap.put(0, 1);
                } else {
                    arrayList.add(0, dVar7);
                }
                return b(arrayList, linkedHashMap);
            }
        }
        arrayList.clear();
        com.tencent.qqnt.avatar.layer.d<? extends Object> dVar8 = raw.get(2);
        if (dVar8 != null) {
            arrayList.add(0, dVar8);
            linkedHashMap.put(2, 0);
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            map = MapsKt__MapsKt.toMap(linkedHashMap);
            return b(list, map);
        }
        com.tencent.qqnt.avatar.layer.d<? extends Object> dVar9 = raw.get(1);
        if (dVar9 != null) {
            arrayList.add(0, dVar9);
        } else {
            com.tencent.qqnt.avatar.layer.d<? extends Object> dVar10 = raw.get(4);
            if (dVar10 != null) {
                arrayList.add(0, dVar10);
                linkedHashMap.put(4, 0);
                return b(arrayList, linkedHashMap);
            }
        }
        com.tencent.qqnt.avatar.layer.d<? extends Object> dVar11 = raw.get(0);
        if (dVar11 != null) {
            arrayList.add(0, dVar11);
        }
        return b(arrayList, linkedHashMap);
    }
}
