package bj3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qu4.b;
import qu4.c;
import qu4.d;
import qu4.j;
import qu4.k;
import qu4.m;
import qu4.q;
import tl.h;
import uv4.am;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\t*\u00020\t\u001a\f\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u000b\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u0012\u001a\u00020\u0010*\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u001a\u0014\u0010\u0014\u001a\u00020\u000e*\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\u0017\u001a\u00020\u000e*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u001a\u0014\u0010\u0019\u001a\u00020\u000e*\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u001a\u0012\u0010\u001c\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a\u001a\n\u0010\u001e\u001a\u00020\u001d*\u00020\u001d\u00a8\u0006\u001f"}, d2 = {"", "Luv4/az;", "Lqu4/a;", "a", "", "l", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "Lqu4/j;", "j", "Lqu4/c;", "i", "subCharacter", "", "d", "Lqu4/b;", "subAvatarInfo", "c", "subFaceInfo", "f", "Lqu4/m;", "subMakeupInfo", "g", "subColorInfo", "e", "", "slotId", DomainData.DOMAIN_NAME, "Luv4/am;", "k", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {
    public static final qu4.a a(Collection<az> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        qu4.a m3 = m(new qu4.a());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            d(m3, b((az) it.next()));
        }
        return m3;
    }

    public static final qu4.a b(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        qu4.a m3 = m(new qu4.a());
        az[] containStoreItems = azVar.f440289p;
        Intrinsics.checkNotNullExpressionValue(containStoreItems, "containStoreItems");
        for (az subItem : containStoreItems) {
            Intrinsics.checkNotNullExpressionValue(subItem, "subItem");
            d(m3, b(subItem));
        }
        d(m3, azVar.f440297z);
        return m3;
    }

    public static final b c(b bVar, b bVar2) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        if (bVar2 != null) {
            q[] qVarArr = bVar2.f429578b;
            Intrinsics.checkNotNullExpressionValue(qVarArr, "subAvatarInfo.slotArr");
            if (!(qVarArr.length == 0)) {
                HashMap hashMap = new HashMap();
                q[] slotArr = bVar.f429578b;
                Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
                for (q it : slotArr) {
                    Integer valueOf = Integer.valueOf(it.f429639a);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    hashMap.put(valueOf, it);
                }
                q[] qVarArr2 = bVar2.f429578b;
                if (qVarArr2 != null) {
                    for (q it5 : qVarArr2) {
                        Integer valueOf2 = Integer.valueOf(it5.f429639a);
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        hashMap.put(valueOf2, it5);
                    }
                }
                Collection values = hashMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "map.values");
                Object[] array = values.toArray(new q[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                bVar.f429578b = (q[]) array;
            }
        }
        return bVar;
    }

    public static final void d(qu4.a aVar, qu4.a aVar2) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar2 == null) {
            return;
        }
        b bVar = aVar.f429572a;
        if (bVar == null) {
            bVar = new b();
        }
        c(bVar, aVar2.f429572a);
        j jVar = aVar.f429573b;
        if (jVar == null) {
            jVar = new j();
        }
        f(jVar, aVar2.f429573b);
        m mVar = aVar.f429574c;
        if (mVar == null) {
            mVar = new m();
        }
        g(mVar, aVar2.f429574c);
        c cVar = aVar.f429575d;
        if (cVar == null) {
            cVar = new c();
        }
        e(cVar, aVar2.f429575d);
        aVar.f429572a = bVar;
        aVar.f429573b = jVar;
        aVar.f429574c = mVar;
        aVar.f429575d = cVar;
    }

    public static final void e(c cVar, c cVar2) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar2 != null) {
            d[] dVarArr = cVar2.f429581b;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "subColorInfo.slotArr");
            if (dVarArr.length == 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            d[] slotArr = cVar.f429581b;
            Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
            for (d it : slotArr) {
                Integer valueOf = Integer.valueOf(it.f429583a);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put(valueOf, it);
            }
            d[] dVarArr2 = cVar2.f429581b;
            if (dVarArr2 != null) {
                for (d it5 : dVarArr2) {
                    Integer valueOf2 = Integer.valueOf(it5.f429583a);
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    hashMap.put(valueOf2, it5);
                }
            }
            Collection values = hashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "map.values");
            Object[] array = values.toArray(new d[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            cVar.f429581b = (d[]) array;
        }
    }

    public static final void f(j jVar, j jVar2) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        if (jVar2 != null) {
            k[] kVarArr = jVar2.f429607b;
            Intrinsics.checkNotNullExpressionValue(kVarArr, "subFaceInfo.slotArr");
            if (kVarArr.length == 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            k[] slotArr = jVar.f429607b;
            Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
            for (k it : slotArr) {
                Integer valueOf = Integer.valueOf(it.f429609a);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put(valueOf, it);
            }
            k[] kVarArr2 = jVar2.f429607b;
            if (kVarArr2 != null) {
                for (k it5 : kVarArr2) {
                    Integer valueOf2 = Integer.valueOf(it5.f429609a);
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    hashMap.put(valueOf2, it5);
                }
            }
            Collection values = hashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "map.values");
            Object[] array = values.toArray(new k[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            jVar.f429607b = (k[]) array;
        }
    }

    public static final void g(m mVar, m mVar2) {
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        if (mVar2 != null) {
            q[] qVarArr = mVar2.f429621b;
            Intrinsics.checkNotNullExpressionValue(qVarArr, "subMakeupInfo.slotArr");
            if (qVarArr.length == 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            q[] slotArr = mVar.f429621b;
            Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
            for (q it : slotArr) {
                Integer valueOf = Integer.valueOf(it.f429639a);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put(valueOf, it);
            }
            q[] qVarArr2 = mVar2.f429621b;
            if (qVarArr2 != null) {
                for (q it5 : qVarArr2) {
                    Integer valueOf2 = Integer.valueOf(it5.f429639a);
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    hashMap.put(valueOf2, it5);
                }
            }
            Collection values = hashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "map.values");
            Object[] array = values.toArray(new q[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            mVar.f429621b = (q[]) array;
        }
    }

    public static final qu4.a h(qu4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        qu4.a aVar2 = new qu4.a();
        MessageNano.mergeFrom(aVar2, byteArray);
        return aVar2;
    }

    public static final j j(j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        byte[] byteArray = MessageNano.toByteArray(jVar);
        j jVar2 = new j();
        MessageNano.mergeFrom(jVar2, byteArray);
        return jVar2;
    }

    public static final am k(am amVar) {
        Intrinsics.checkNotNullParameter(amVar, "<this>");
        byte[] byteArray = MessageNano.toByteArray(amVar);
        am amVar2 = new am();
        MessageNano.mergeFrom(amVar2, byteArray);
        return amVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x000e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean l(Collection<az> collection) {
        boolean z16;
        c cVar;
        d[] slotArr;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        boolean z17 = false;
        for (az azVar : collection) {
            if (r94.b.M(azVar) == 4) {
                qu4.a aVar = azVar.f440297z;
                if (aVar != null && (cVar = aVar.f429575d) != null && (slotArr = cVar.f429581b) != null) {
                    Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
                    if (!(slotArr.length == 0)) {
                        z16 = true;
                        if (z16) {
                            z17 = true;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
        }
        return z17;
    }

    public static final qu4.a m(qu4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        aVar.f429572a = new b();
        aVar.f429573b = new j();
        aVar.f429574c = new m();
        aVar.f429575d = new c();
        aVar.f429576e = UEAvatarGender.MALE.getIndex();
        return aVar;
    }

    public static final void n(c cVar, int i3) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        d[] slotArr = cVar.f429581b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        ArrayList arrayList = new ArrayList();
        for (d dVar : slotArr) {
            if (dVar.f429583a != i3) {
                arrayList.add(dVar);
            }
        }
        Object[] array = arrayList.toArray(new d[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        cVar.f429581b = (d[]) array;
    }

    public static final c i(c cVar) {
        if (cVar == null) {
            return new c();
        }
        byte[] byteArray = MessageNano.toByteArray(cVar);
        c cVar2 = new c();
        MessageNano.mergeFrom(cVar2, byteArray);
        return cVar2;
    }
}
