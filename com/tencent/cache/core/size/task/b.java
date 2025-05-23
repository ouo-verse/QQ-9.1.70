package com.tencent.cache.core.size.task;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.util.TableInfo;
import com.tencent.cache.api.h;
import com.tencent.cache.core.size.graph.b;
import com.tencent.cache.core.size.graph.d;
import com.tencent.cache.core.size.graph.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b extends Lambda implements Function0<Object> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f98822a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f98823b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f98824c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(boolean z16, Object obj, boolean z17) {
        super(0);
        this.f98822a = z16;
        this.f98823b = obj;
        this.f98824c = z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), obj, Boolean.valueOf(z17));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x0589 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0440  */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke() {
        String str;
        Object obj;
        long j3;
        String str2;
        long j16;
        long j17;
        double averageOfInt;
        Set set;
        boolean z16;
        ArrayDeque arrayDeque;
        ArrayDeque arrayDeque2;
        long j18;
        boolean z17;
        ArrayDeque arrayDeque3;
        d dVar;
        Object obj2;
        boolean z18;
        Object target;
        String str3;
        String str4;
        int i3;
        String str5;
        String str6;
        boolean z19;
        boolean z26;
        boolean z27;
        Object obj3;
        long j19;
        int i16;
        String str7;
        boolean z28;
        ArrayDeque arrayDeque4;
        ArrayDeque arrayDeque5;
        ArrayDeque arrayDeque6;
        d dVar2;
        long j26;
        Collection<Field> emptyList;
        Iterator<Field> it;
        Iterator<Field> it5;
        Collection<Field> collection;
        ArrayDeque arrayDeque7;
        ArrayDeque arrayDeque8;
        com.tencent.cache.core.size.graph.c a16;
        int e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        d dVar3 = c.f98825a;
        boolean z29 = this.f98822a;
        Object root = this.f98823b;
        boolean z36 = this.f98824c;
        dVar3.getClass();
        Intrinsics.checkNotNullParameter(root, "root");
        if (z29 && (e16 = com.tencent.cache.api.util.c.e(com.tencent.cache.api.util.c.f98640a, root.getClass(), false, z36, false, 8, null)) != 0) {
            j17 = e16;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            String a17 = dVar3.a(root);
            ArrayDeque arrayDeque9 = new ArrayDeque();
            ArrayDeque arrayDeque10 = new ArrayDeque();
            ArrayDeque arrayDeque11 = new ArrayDeque();
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            arrayDeque9.push(root);
            arrayDeque10.push("root");
            arrayDeque11.push(0);
            long j27 = 0;
            boolean z37 = true;
            while (true) {
                if (arrayDeque9.isEmpty()) {
                    str = "ObjectGraphWalker";
                    obj = root;
                    j3 = j27;
                    str2 = "walk though ";
                    j16 = currentTimeMillis;
                    break;
                }
                j16 = currentTimeMillis;
                Object ref = arrayDeque9.pop();
                String str8 = (String) arrayDeque10.pop();
                ArrayDeque arrayDeque12 = arrayDeque10;
                Integer num = (Integer) arrayDeque11.pop();
                int size = arrayDeque9.size();
                ArrayDeque arrayDeque13 = arrayDeque9;
                Class<?> refClass = ref.getClass();
                if (newSetFromMap.add(ref)) {
                    com.tencent.cache.core.size.graph.b bVar = com.tencent.cache.core.size.graph.b.f98791b;
                    Set set2 = newSetFromMap;
                    long j28 = j27;
                    if (((int) j27) > com.tencent.cache.core.manager.api.c.f98725d.d().C()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        com.tencent.cache.core.util.b bVar2 = com.tencent.cache.core.util.b.f98833f;
                        if (bVar2.f()) {
                            bVar2.d("ObjectGraphWalker", 3, "walk though " + a17 + ", matched size limit, subType:" + ref.getClass().getSimpleName());
                        }
                        str = "ObjectGraphWalker";
                        obj = root;
                        str2 = "walk though ";
                        j3 = j28;
                    } else {
                        com.tencent.cache.api.util.c cVar = com.tencent.cache.api.util.c.f98640a;
                        Intrinsics.checkNotNullExpressionValue(ref, "ref");
                        set = set2;
                        ArrayDeque arrayDeque14 = arrayDeque11;
                        arrayDeque = arrayDeque12;
                        d dVar4 = dVar3;
                        z17 = z29;
                        z16 = z36;
                        obj2 = root;
                        int e17 = com.tencent.cache.api.util.c.e(cVar, ref, false, z36, false, 8, null);
                        if (e17 != 0) {
                            long j29 = e17 + j28;
                            com.tencent.cache.core.util.b bVar3 = com.tencent.cache.core.util.b.f98833f;
                            if (bVar3.f() && bVar.b(refClass)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("walk though ");
                                sb5.append(a17);
                                sb5.append(", ");
                                sb5.append("get shallowSize, depth:");
                                sb5.append(num);
                                StringBuilder a18 = h.a(sb5, ", field:", str8, ", subType:");
                                a18.append(refClass.getSimpleName());
                                a18.append(", ");
                                a18.append("size:");
                                a18.append(size);
                                a18.append(", isCached:false, shallowSize:");
                                a18.append(e17);
                                a18.append(", retainedSize:");
                                a18.append(j29);
                                bVar3.d("ObjectGraphWalker", 3, a18.toString());
                            }
                            j27 = j29;
                            newSetFromMap = set;
                            z36 = z16;
                            currentTimeMillis = j16;
                            dVar3 = dVar4;
                            z29 = z17;
                            arrayDeque9 = arrayDeque13;
                            root = obj2;
                            arrayDeque11 = arrayDeque14;
                            arrayDeque10 = arrayDeque;
                        } else {
                            j18 = j28;
                            try {
                                a16 = com.tencent.cache.core.size.graph.c.f98797e.a(ref.getClass());
                            } catch (Throwable th5) {
                                th = th5;
                                target = ref;
                            }
                            if (a16 != null) {
                                target = ref;
                                try {
                                } catch (Throwable th6) {
                                    th = th6;
                                    str3 = ", retainedSize:";
                                    com.tencent.cache.core.util.b bVar4 = com.tencent.cache.core.util.b.f98833f;
                                    str4 = "size:";
                                    i3 = size;
                                    StringBuilder sb6 = new StringBuilder();
                                    str5 = ", subType:";
                                    sb6.append("byPassIfFlyweight fail, ");
                                    sb6.append("type:");
                                    sb6.append(target.getClass());
                                    sb6.append(", ");
                                    sb6.append(th.getMessage());
                                    str6 = "ObjectGraphWalker";
                                    bVar4.h(str6, 1, sb6.toString());
                                    z19 = false;
                                    if (!z19) {
                                    }
                                    arrayDeque3 = arrayDeque13;
                                    dVar = dVar4;
                                    arrayDeque2 = arrayDeque14;
                                    j27 = j18;
                                    newSetFromMap = set;
                                    z36 = z16;
                                    currentTimeMillis = j16;
                                    arrayDeque11 = arrayDeque2;
                                    z29 = z17;
                                    dVar3 = dVar;
                                    root = obj2;
                                    arrayDeque9 = arrayDeque3;
                                    arrayDeque10 = arrayDeque;
                                }
                                if (a16.a(target)) {
                                    str4 = "size:";
                                    str5 = ", subType:";
                                    str3 = ", retainedSize:";
                                    i3 = size;
                                    str6 = "ObjectGraphWalker";
                                    z19 = true;
                                    if (!z19) {
                                        e<Class<?>, b.a> eVar = com.tencent.cache.core.size.graph.b.f98790a;
                                        Class<?> rootClass = obj2.getClass();
                                        Intrinsics.checkNotNullParameter(rootClass, "rootClass");
                                        Intrinsics.checkNotNullParameter(refClass, "refClass");
                                        if (!Intrinsics.areEqual(Thread.class, refClass) && !Context.class.isAssignableFrom(refClass) && !RecyclerView.class.isAssignableFrom(refClass) && !Handler.Callback.class.isAssignableFrom(refClass) && (z37 || !rootClass.isAssignableFrom(refClass))) {
                                            z26 = true;
                                        } else {
                                            z26 = false;
                                        }
                                        if (z26) {
                                            com.tencent.cache.core.size.graph.a aVar = com.tencent.cache.core.size.graph.a.f98789b;
                                            Intrinsics.checkNotNullParameter(target, "requestObj");
                                            e<Class<?>, Long> eVar2 = com.tencent.cache.core.size.graph.a.f98788a;
                                            Class<?> cls = target.getClass();
                                            eVar2.a();
                                            String str9 = str6;
                                            if (eVar2.f98801a.get(new e.b(cls, null)) != null) {
                                                z27 = true;
                                            } else {
                                                z27 = false;
                                            }
                                            if (z17) {
                                                i16 = (int) aVar.a(target);
                                                obj3 = target;
                                            } else {
                                                d dVar5 = c.f98825a;
                                                Intrinsics.checkNotNullParameter(target, "target");
                                                try {
                                                    j19 = c.f98826b.a(target);
                                                    obj3 = target;
                                                } catch (Throwable th7) {
                                                    obj3 = target;
                                                    com.tencent.cache.core.util.b.f98833f.b("SizeCalculator", 1, "getSize fail, ", th7);
                                                    j19 = 0;
                                                }
                                                i16 = (int) j19;
                                            }
                                            long j36 = i16 + j18;
                                            com.tencent.cache.core.util.b bVar5 = com.tencent.cache.core.util.b.f98833f;
                                            if (bVar5.f() && com.tencent.cache.core.size.graph.b.f98791b.b(refClass)) {
                                                StringBuilder sb7 = new StringBuilder();
                                                sb7.append("walk though ");
                                                sb7.append(a17);
                                                sb7.append(", ");
                                                sb7.append("get shallowSize, depth:");
                                                sb7.append(num);
                                                StringBuilder a19 = h.a(sb7, ", field:", str8, str5);
                                                a19.append(refClass.getSimpleName());
                                                a19.append(", ");
                                                a19.append(str4);
                                                a19.append(i3);
                                                a19.append(", isCached:");
                                                a19.append(z27);
                                                a19.append(", shallowSize:");
                                                a19.append(i16);
                                                a19.append(str3);
                                                a19.append(j36);
                                                str7 = str9;
                                                bVar5.d(str7, 3, a19.toString());
                                            } else {
                                                str7 = str9;
                                            }
                                            int intValue = num.intValue() + 1;
                                            e<Class<?>, b.a> eVar3 = com.tencent.cache.core.size.graph.b.f98790a;
                                            if (intValue > com.tencent.cache.core.manager.api.c.f98725d.d().x()) {
                                                z28 = true;
                                            } else {
                                                z28 = false;
                                            }
                                            if (z28) {
                                                j26 = j36;
                                                arrayDeque4 = arrayDeque13;
                                                arrayDeque5 = arrayDeque14;
                                                arrayDeque6 = arrayDeque;
                                            } else {
                                                Class<?> cls2 = obj3.getClass();
                                                if (cls2.isArray()) {
                                                    Class<?> componentType = cls2.getComponentType();
                                                    Intrinsics.checkNotNullExpressionValue(componentType, "refClass.componentType");
                                                    if (!componentType.isPrimitive()) {
                                                        int length = Array.getLength(obj3);
                                                        int i17 = 0;
                                                        while (i17 < length) {
                                                            Object obj4 = obj3;
                                                            Object obj5 = Array.get(obj4, i17);
                                                            ArrayDeque arrayDeque15 = arrayDeque13;
                                                            if (obj5 != null) {
                                                                arrayDeque15.push(obj5);
                                                                arrayDeque7 = arrayDeque14;
                                                                arrayDeque7.push(Integer.valueOf(intValue));
                                                                arrayDeque8 = arrayDeque;
                                                                arrayDeque8.push(TableInfo.Index.DEFAULT_PREFIX + i17);
                                                            } else {
                                                                arrayDeque7 = arrayDeque14;
                                                                arrayDeque8 = arrayDeque;
                                                            }
                                                            i17++;
                                                            obj3 = obj4;
                                                            arrayDeque13 = arrayDeque15;
                                                            arrayDeque14 = arrayDeque7;
                                                            arrayDeque = arrayDeque8;
                                                        }
                                                        arrayDeque4 = arrayDeque13;
                                                        arrayDeque5 = arrayDeque14;
                                                        arrayDeque6 = arrayDeque;
                                                        j26 = j36;
                                                    }
                                                }
                                                arrayDeque4 = arrayDeque13;
                                                Object obj6 = obj3;
                                                arrayDeque5 = arrayDeque14;
                                                arrayDeque6 = arrayDeque;
                                                e<Class<?>, SoftReference<Collection<Field>>> eVar4 = d.f98799a;
                                                eVar4.a();
                                                SoftReference<Collection<Field>> softReference = eVar4.f98801a.get(new e.b(cls2, null));
                                                if (softReference != null && (collection = softReference.get()) != null) {
                                                    emptyList = collection;
                                                    j26 = j36;
                                                    dVar2 = dVar4;
                                                } else {
                                                    dVar2 = dVar4;
                                                    try {
                                                        Collection<Field> b16 = dVar2.b(cls2);
                                                        SoftReference<Collection<Field>> softReference2 = new SoftReference<>(b16);
                                                        eVar4.a();
                                                        j26 = j36;
                                                        try {
                                                            eVar4.f98801a.put(new e.b(cls2, eVar4.f98802b), softReference2);
                                                            emptyList = b16;
                                                        } catch (Throwable unused) {
                                                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                                                            it = emptyList.iterator();
                                                            while (it.hasNext()) {
                                                            }
                                                            dVar4 = dVar2;
                                                            arrayDeque9 = arrayDeque4;
                                                            arrayDeque11 = arrayDeque5;
                                                            arrayDeque10 = arrayDeque6;
                                                            z37 = false;
                                                            newSetFromMap = set;
                                                            z36 = z16;
                                                            currentTimeMillis = j16;
                                                            dVar3 = dVar4;
                                                            z29 = z17;
                                                            root = obj2;
                                                            j27 = j26;
                                                        }
                                                    } catch (Throwable unused2) {
                                                        j26 = j36;
                                                    }
                                                }
                                                it = emptyList.iterator();
                                                while (it.hasNext()) {
                                                    Field next = it.next();
                                                    try {
                                                        com.tencent.cache.core.util.b bVar6 = com.tencent.cache.core.util.b.f98833f;
                                                        if (bVar6.f() && com.tencent.cache.core.size.graph.b.f98791b.b(cls2)) {
                                                            Object[] objArr = new Object[1];
                                                            StringBuilder sb8 = new StringBuilder();
                                                            sb8.append("walk though ");
                                                            sb8.append(a17);
                                                            sb8.append(", ");
                                                            it5 = it;
                                                            try {
                                                                sb8.append("get field, name:");
                                                                sb8.append(next.getName());
                                                                sb8.append(", value:");
                                                                sb8.append(dVar2.a(next.get(obj6)));
                                                                objArr[0] = sb8.toString();
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                com.tencent.cache.core.util.b bVar7 = com.tencent.cache.core.util.b.f98833f;
                                                                StringBuilder sb9 = new StringBuilder();
                                                                sb9.append("walk though ");
                                                                sb9.append(a17);
                                                                d dVar6 = dVar2;
                                                                sb9.append(", get field error, ");
                                                                sb9.append("name:");
                                                                sb9.append(next.getName());
                                                                sb9.append(", type:");
                                                                Class<?> type = next.getType();
                                                                Intrinsics.checkNotNullExpressionValue(type, "field.type");
                                                                sb9.append(type.getSimpleName());
                                                                sb9.append(", ");
                                                                sb9.append(th.getMessage());
                                                                bVar7.j(str7, 1, sb9.toString());
                                                                it = it5;
                                                                dVar2 = dVar6;
                                                            }
                                                            try {
                                                                bVar6.d(str7, 3, objArr);
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                com.tencent.cache.core.util.b bVar72 = com.tencent.cache.core.util.b.f98833f;
                                                                StringBuilder sb92 = new StringBuilder();
                                                                sb92.append("walk though ");
                                                                sb92.append(a17);
                                                                d dVar62 = dVar2;
                                                                sb92.append(", get field error, ");
                                                                sb92.append("name:");
                                                                sb92.append(next.getName());
                                                                sb92.append(", type:");
                                                                Class<?> type2 = next.getType();
                                                                Intrinsics.checkNotNullExpressionValue(type2, "field.type");
                                                                sb92.append(type2.getSimpleName());
                                                                sb92.append(", ");
                                                                sb92.append(th.getMessage());
                                                                bVar72.j(str7, 1, sb92.toString());
                                                                it = it5;
                                                                dVar2 = dVar62;
                                                            }
                                                        } else {
                                                            it5 = it;
                                                        }
                                                        if (com.tencent.cache.core.manager.api.c.f98725d.d().q() && (obj6 instanceof View) && (Intrinsics.areEqual(next.getName(), "mContext") || Intrinsics.areEqual(next.getName(), "mResources"))) {
                                                            if (bVar6.f() && com.tencent.cache.core.size.graph.b.f98791b.b(cls2)) {
                                                                bVar6.d(str7, 3, "walk though " + a17 + ", ignore field, name:" + next.getName());
                                                            }
                                                        } else {
                                                            Object obj7 = next.get(obj6);
                                                            if (obj7 != null) {
                                                                arrayDeque4.push(obj7);
                                                                arrayDeque5.push(Integer.valueOf(intValue));
                                                                arrayDeque6.push(next.getName());
                                                            }
                                                        }
                                                        it = it5;
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                        it5 = it;
                                                    }
                                                }
                                                dVar4 = dVar2;
                                            }
                                            arrayDeque9 = arrayDeque4;
                                            arrayDeque11 = arrayDeque5;
                                            arrayDeque10 = arrayDeque6;
                                            z37 = false;
                                            newSetFromMap = set;
                                            z36 = z16;
                                            currentTimeMillis = j16;
                                            dVar3 = dVar4;
                                            z29 = z17;
                                            root = obj2;
                                            j27 = j26;
                                        }
                                    }
                                    arrayDeque3 = arrayDeque13;
                                    dVar = dVar4;
                                    arrayDeque2 = arrayDeque14;
                                }
                            } else {
                                target = ref;
                            }
                            str4 = "size:";
                            str5 = ", subType:";
                            str3 = ", retainedSize:";
                            i3 = size;
                            z19 = false;
                            str6 = "ObjectGraphWalker";
                            if (!z19) {
                            }
                            arrayDeque3 = arrayDeque13;
                            dVar = dVar4;
                            arrayDeque2 = arrayDeque14;
                        }
                    }
                } else {
                    set = newSetFromMap;
                    z16 = z36;
                    arrayDeque = arrayDeque12;
                    arrayDeque2 = arrayDeque11;
                    j18 = j27;
                    z17 = z29;
                    arrayDeque3 = arrayDeque13;
                    dVar = dVar3;
                    obj2 = root;
                    com.tencent.cache.core.util.b bVar8 = com.tencent.cache.core.util.b.f98833f;
                    if (bVar8.f() && com.tencent.cache.core.size.graph.b.f98791b.b(refClass)) {
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("walk though ");
                        sb10.append(a17);
                        sb10.append(", ");
                        sb10.append("get shallowSize, depth:");
                        sb10.append(num);
                        StringBuilder a26 = h.a(sb10, ", field:", str8, ", subType:");
                        a26.append(refClass.getSimpleName());
                        a26.append(", ");
                        a26.append("size:");
                        a26.append(size);
                        a26.append(", retainedSize:");
                        a26.append(j18);
                        a26.append(", added");
                        bVar8.d("ObjectGraphWalker", 3, a26.toString());
                    }
                }
                j27 = j18;
                newSetFromMap = set;
                z36 = z16;
                currentTimeMillis = j16;
                arrayDeque11 = arrayDeque2;
                z29 = z17;
                dVar3 = dVar;
                root = obj2;
                arrayDeque9 = arrayDeque3;
                arrayDeque10 = arrayDeque;
            }
            com.tencent.cache.core.util.b bVar9 = com.tencent.cache.core.util.b.f98833f;
            if (bVar9.f()) {
                bVar9.d(str, 3, str2 + a17 + " complete, retainedSize:" + j3);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - j16;
            b.a a27 = com.tencent.cache.core.size.graph.b.f98791b.a(obj.getClass());
            int i18 = (int) j3;
            if (a27.f98792a == -1) {
                a27.f98793b.add(Integer.valueOf(i18));
                com.tencent.cache.core.manager.api.c cVar2 = com.tencent.cache.core.manager.api.c.f98725d;
                if (currentTimeMillis2 > cVar2.d().j() || a27.f98793b.size() >= cVar2.d().B()) {
                    averageOfInt = CollectionsKt___CollectionsKt.averageOfInt(a27.f98793b);
                    a27.f98792a = (int) averageOfInt;
                    a27.f98793b.clear();
                }
            }
            j17 = j3;
        }
        return Long.valueOf(j17);
    }
}
