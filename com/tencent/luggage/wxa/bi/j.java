package com.tencent.luggage.wxa.bi;

import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.tn.f0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f122895a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.md.c f122896b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122897c;

        public a(f0 f0Var, com.tencent.luggage.wxa.md.c cVar, int i3) {
            this.f122895a = f0Var;
            this.f122896b = cVar;
            this.f122897c = i3;
        }

        public static final void a(List list, f0 f0Var, String str) {
            int collectionSizeOrDefault;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(f0Var.getLong((String) it.next(), 0L)));
            }
            CollectionsKt___CollectionsKt.sorted(arrayList);
            f0Var.g((String) list.get(0));
            list.set(0, str);
            f0Var.putLong(str, System.currentTimeMillis());
        }

        @Override // java.lang.Runnable
        public final void run() {
            List list;
            String str;
            Set set;
            String str2 = null;
            Set stringSet = this.f122895a.getStringSet("VideoCastDeviceManager.saveDevice", null);
            if (stringSet != null) {
                list = CollectionsKt___CollectionsKt.toMutableList((Collection) stringSet);
            } else {
                list = null;
            }
            com.tencent.luggage.wxa.md.b c16 = this.f122896b.c();
            if (c16 != null) {
                str = c16.f134430j;
            } else {
                str = null;
            }
            if (list != null) {
                if (list.contains(str)) {
                    this.f122895a.putLong(str, System.currentTimeMillis());
                    return;
                }
                if (list.size() >= this.f122897c) {
                    a(list, this.f122895a, str);
                }
                com.tencent.luggage.wxa.md.b c17 = this.f122896b.c();
                if (c17 != null) {
                    str2 = c17.f134430j;
                }
                list.add(str2);
                f0 f0Var = this.f122895a;
                set = CollectionsKt___CollectionsKt.toSet(list);
                f0Var.putStringSet("VideoCastDeviceManager.saveDevice", set);
                this.f122895a.putLong(str, System.currentTimeMillis());
                return;
            }
            ArraySet arraySet = new ArraySet();
            arraySet.add(str);
            this.f122895a.putStringSet("VideoCastDeviceManager.saveDevice", arraySet);
            this.f122895a.putLong(str, System.currentTimeMillis());
        }
    }

    public static final boolean a(com.tencent.luggage.wxa.md.c cVar) {
        String str;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        f0 g16 = f0.g();
        com.tencent.luggage.wxa.md.b c16 = cVar.c();
        if (c16 != null) {
            str = c16.f134430j;
        } else {
            str = null;
        }
        if (g16.getLong(str, 0L) != 0) {
            return true;
        }
        return false;
    }

    public static final void b(com.tencent.luggage.wxa.md.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new a(f0.g(), cVar, 2));
    }
}
