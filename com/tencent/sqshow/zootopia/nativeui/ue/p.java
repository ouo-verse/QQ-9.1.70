package com.tencent.sqshow.zootopia.nativeui.ue;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.bb;
import uv4.be;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002Jf\u0010\u000f\u001a:\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\t2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J8\u0010\u0013\u001a\u00020\u00022\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011Jl\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\u000e2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0017j\b\u0012\u0004\u0012\u00020\u0006`\u0018J:\u0010\"\u001a\u00020\u001f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004JB\u0010%\u001a\u00020\u001f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010$\u001a\u00020#J\u001c\u0010*\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0&2\u0006\u0010)\u001a\u00020(\u00a8\u0006-"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/p;", "", "", "j", "", "", "Luv4/az;", "baseItemMap", "newItemMap", "Lkotlin/Pair;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "i", "newDressMap", "", "relateSlots", "f", "currentDressMap", "defaultDressMap", "allSlots", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newComeItems", "g", "Lqu4/j;", "newFaceInfo", "Lqu4/c;", "newColorInfo", "Lqu4/a;", "currentCharacter", "finalDressMap", "c", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "d", "", "itemUniqueIds", "Lm94/a;", IZplanHandleApi.BUSINESS_DRESS_INFO, "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class p {

    /* renamed from: a */
    public static final p f371394a = new p();

    p() {
    }

    private final void j() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.o
            @Override // java.lang.Runnable
            public final void run() {
                p.k();
            }
        });
    }

    public static final void k() {
        QQToast.makeText(BaseApplication.context, 0, "\u90e8\u5206\u88c5\u626e\u65e0\u6cd5\u540c\u65f6\u7a7f\u6234\uff0c\u5df2\u81ea\u52a8\u5378\u4e0b", 0).show();
    }

    public final qu4.a c(qu4.j newFaceInfo, qu4.c newColorInfo, qu4.a currentCharacter, Map<Integer, az> finalDressMap) {
        Intrinsics.checkNotNullParameter(currentCharacter, "currentCharacter");
        Intrinsics.checkNotNullParameter(finalDressMap, "finalDressMap");
        return d(newFaceInfo, newColorInfo, currentCharacter, finalDressMap, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n());
    }

    public final qu4.a d(qu4.j newFaceInfo, qu4.c newColorInfo, qu4.a currentCharacter, Map<Integer, az> finalDressMap, UEAvatarGender gender) {
        Intrinsics.checkNotNullParameter(currentCharacter, "currentCharacter");
        Intrinsics.checkNotNullParameter(finalDressMap, "finalDressMap");
        Intrinsics.checkNotNullParameter(gender, "gender");
        qu4.a a16 = bj3.a.a(finalDressMap.values());
        a16.f429576e = gender.getIndex();
        qu4.j jVar = a16.f429573b;
        Intrinsics.checkNotNullExpressionValue(jVar, "result.faceInfo");
        bj3.a.f(jVar, currentCharacter.f429573b);
        qu4.c cVar = a16.f429575d;
        Intrinsics.checkNotNullExpressionValue(cVar, "result.colorInfo");
        bj3.a.e(cVar, currentCharacter.f429575d);
        qu4.j jVar2 = a16.f429573b;
        Intrinsics.checkNotNullExpressionValue(jVar2, "result.faceInfo");
        bj3.a.f(jVar2, newFaceInfo);
        qu4.c cVar2 = a16.f429575d;
        Intrinsics.checkNotNullExpressionValue(cVar2, "result.colorInfo");
        bj3.a.e(cVar2, newColorInfo);
        return bj3.a.h(a16);
    }

    public final void f(HashMap<Integer, az> newDressMap, Set<Integer> relateSlots) {
        Intrinsics.checkNotNullParameter(newDressMap, "newDressMap");
        Intrinsics.checkNotNullParameter(relateSlots, "relateSlots");
        HashSet hashSet = new HashSet();
        Iterator<T> it = relateSlots.iterator();
        while (it.hasNext()) {
            az azVar = newDressMap.get(Integer.valueOf(((Number) it.next()).intValue()));
            if (azVar != null) {
                Intrinsics.checkNotNullExpressionValue(azVar, "newDressMap[slot] ?: return@forEach");
                hashSet.add(azVar.B);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<Integer, az>> it5 = newDressMap.entrySet().iterator();
        while (it5.hasNext()) {
            if (hashSet.contains(r94.b.a(it5.next().getValue()))) {
                it5.remove();
            }
        }
    }

    public final HashMap<Integer, az> g(Map<Integer, az> currentDressMap, Map<Integer, az> defaultDressMap, HashSet<Integer> allSlots, ArrayList<az> newComeItems) {
        az azVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(currentDressMap, "currentDressMap");
        Intrinsics.checkNotNullParameter(defaultDressMap, "defaultDressMap");
        Intrinsics.checkNotNullParameter(allSlots, "allSlots");
        Intrinsics.checkNotNullParameter(newComeItems, "newComeItems");
        HashSet hashSet = new HashSet();
        Iterator<az> it = currentDressMap.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(r94.b.k(it.next()));
        }
        HashMap<Integer, az> hashMap = new HashMap<>(currentDressMap);
        Set<Integer> keySet = currentDressMap.keySet();
        Iterator<Integer> it5 = allSlots.iterator();
        while (it5.hasNext()) {
            Integer next = it5.next();
            if (next == null || next.intValue() != 110) {
                if (currentDressMap.get(next) == null && (azVar = defaultDressMap.get(next)) != null) {
                    be beVar = azVar.f440290q;
                    if ((beVar != null ? beVar.f440325b : null) != null) {
                        int[] defaultDressSlots = beVar.f440325b;
                        Intrinsics.checkNotNullExpressionValue(defaultDressSlots, "defaultDressSlots");
                        int length = defaultDressSlots.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                z16 = true;
                                break;
                            }
                            if (keySet.contains(Integer.valueOf(defaultDressSlots[i3]))) {
                                z16 = false;
                                break;
                            }
                            i3++;
                        }
                        if (z16) {
                            bb bbVar = azVar.f440291r;
                            int i16 = bbVar != null ? bbVar.f440310a : 0;
                            if (i16 != 0 && hashSet.contains(Integer.valueOf(i16))) {
                                QLog.e("DressCalculateHelper_", 1, "fillDefaultDress defaultDress:" + r94.b.I(azVar) + " passed by mutexTag. mutexTag:" + i16 + ", mutexTagsOfCurrentMap:" + hashSet);
                            } else {
                                for (int i17 : defaultDressSlots) {
                                    hashMap.put(Integer.valueOf(i17), azVar);
                                }
                                newComeItems.add(azVar);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x016c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<HashMap<Integer, az>, HashSet<String>> i(Map<Integer, az> baseItemMap, Map<Integer, az> newItemMap) {
        boolean z16;
        boolean z17;
        List list;
        Object obj;
        Intrinsics.checkNotNullParameter(baseItemMap, "baseItemMap");
        Intrinsics.checkNotNullParameter(newItemMap, "newItemMap");
        HashMap<Integer, az> hashMap = new HashMap<>();
        HashSet hashSet = new HashSet();
        hashMap.putAll(baseItemMap);
        f(hashMap, r94.b.n(newItemMap.values()));
        Iterator<T> it = baseItemMap.values().iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            az azVar = (az) it.next();
            if (r94.b.G(azVar)) {
                az[] azVarArr = azVar.f440289p;
                Intrinsics.checkNotNullExpressionValue(azVarArr, "item.containStoreItems");
                int length = azVarArr.length;
                while (true) {
                    if (i3 < length) {
                        az subItem = azVarArr[i3];
                        Intrinsics.checkNotNullExpressionValue(subItem, "subItem");
                        az azVar2 = newItemMap.get(Integer.valueOf(r94.b.M(subItem)));
                        if (azVar2 != null && !Intrinsics.areEqual(azVar2.B, subItem.B)) {
                            hashSet.add(r94.b.a(azVar));
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        Iterator<Integer> it5 = newItemMap.keySet().iterator();
        while (it5.hasNext()) {
            int intValue = it5.next().intValue();
            az azVar3 = newItemMap.get(Integer.valueOf(intValue));
            if (azVar3 != null) {
                hashSet2.add(r94.b.a(azVar3));
                az azVar4 = baseItemMap.get(Integer.valueOf(intValue));
                if (azVar4 != null && !Intrinsics.areEqual(r94.b.a(azVar4), r94.b.a(azVar3))) {
                    hashSet.add(r94.b.a(azVar4));
                }
                hashMap.put(Integer.valueOf(intValue), azVar3);
                hashSet3.addAll(r94.b.k(azVar3));
            }
        }
        if (!hashSet3.isEmpty()) {
            z16 = false;
            for (az azVar5 : baseItemMap.values()) {
                bb bbVar = azVar5.f440291r;
                int i16 = bbVar != null ? bbVar.f440310a : 0;
                if (i16 != 0 && !hashSet2.contains(r94.b.a(azVar5)) && !hashSet.contains(r94.b.a(azVar5)) && hashSet3.contains(Integer.valueOf(i16))) {
                    QLog.e("DressCalculateHelper_", 1, "mergeDressMap id:" + r94.b.a(azVar5) + " removed by mutexTag. mutexTag:" + i16 + ", mutexTagsOfNewMap:" + hashSet3);
                    hashSet.add(r94.b.a(azVar5));
                    z16 = true;
                }
            }
        } else {
            z16 = false;
        }
        if (z16) {
            j();
        }
        Iterator<Map.Entry<Integer, az>> it6 = hashMap.entrySet().iterator();
        while (it6.hasNext()) {
            az azVar6 = hashMap.get(it6.next().getKey());
            if (azVar6 != null) {
                if (hashSet.contains(r94.b.a(azVar6))) {
                    it6.remove();
                } else if (r94.b.F(azVar6)) {
                    az[] azVarArr2 = azVar6.f440289p;
                    if (azVarArr2 != null) {
                        if (!(azVarArr2.length == 0)) {
                            z17 = false;
                            if (z17) {
                                Intrinsics.checkNotNullExpressionValue(azVarArr2, "itemValue.containStoreItems");
                                list = ArraysKt___ArraysKt.toList(azVarArr2);
                                Iterator it7 = list.iterator();
                                while (true) {
                                    if (!it7.hasNext()) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it7.next();
                                    az it8 = (az) obj;
                                    Intrinsics.checkNotNullExpressionValue(it8, "it");
                                    if (hashSet.contains(r94.b.a(it8))) {
                                        break;
                                    }
                                }
                                if (((az) obj) != null) {
                                    it6.remove();
                                }
                            }
                        }
                    }
                    z17 = true;
                    if (z17) {
                    }
                }
            }
        }
        QLog.i("DressCalculateHelper_", 1, "needRemoveItemId:" + hashSet);
        return new Pair<>(hashMap, hashSet);
    }

    public final qu4.a b(List<String> itemUniqueIds, m94.a r19) {
        Intrinsics.checkNotNullParameter(itemUniqueIds, "itemUniqueIds");
        Intrinsics.checkNotNullParameter(r19, "dressInfo");
        Map<Integer, az> b16 = r19.b();
        HashMap hashMap = new HashMap(r19.b());
        Iterator<T> it = b16.entrySet().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (r94.b.L((az) entry.getValue(), itemUniqueIds)) {
                hashMap.remove(entry.getKey());
                z16 = true;
            }
        }
        if (!z16) {
            return r19.getAvatarCharacter();
        }
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        return e(this, null, null, r19.getAvatarCharacter(), h(this, hashMap, cVar.p().b().b(), cVar.x(), null, 8, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HashMap h(p pVar, Map map, Map map2, HashSet hashSet, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            arrayList = new ArrayList();
        }
        return pVar.g(map, map2, hashSet, arrayList);
    }

    public static /* synthetic */ qu4.a e(p pVar, qu4.j jVar, qu4.c cVar, qu4.a aVar, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jVar = null;
        }
        if ((i3 & 2) != 0) {
            cVar = null;
        }
        return pVar.c(jVar, cVar, aVar, map);
    }
}
