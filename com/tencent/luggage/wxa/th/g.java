package com.tencent.luggage.wxa.th;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.th.h;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f141342e = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final List f141343d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a(v unzipDir) {
            Intrinsics.checkNotNullParameter(unzipDir, "unzipDir");
            if (unzipDir.p()) {
                return new g(unzipDir);
            }
            return null;
        }

        public final g a(JSONObject json) {
            IntRange until;
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONArray jSONArray = json.getJSONArray("subMetas");
                until = RangesKt___RangesKt.until(0, jSONArray.length());
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
                ArrayList<JSONObject> arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    arrayList.add(jSONArray.getJSONObject(((IntIterator) it).nextInt()));
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                for (JSONObject it5 : arrayList) {
                    h.a aVar = h.f141344c;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    h a16 = aVar.a(it5);
                    Intrinsics.checkNotNull(a16);
                    arrayList2.add(a16);
                }
                String name = json.getString("name");
                long j3 = json.getLong("lastModified");
                Intrinsics.checkNotNullExpressionValue(name, "name");
                return new g(name, j3, arrayList2, null);
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "DirMetaData#fromJsonFile, fail since " + e16);
                return null;
            }
        }
    }

    public /* synthetic */ g(String str, long j3, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, list);
    }

    @Override // com.tencent.luggage.wxa.th.h
    public JSONObject c() {
        try {
            JSONObject c16 = super.c();
            if (c16 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f141343d.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(((h) it.next()).c());
            }
            c16.put("subMetas", jSONArray);
            return c16;
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "DirMetaData#toJson, fail since " + e16);
            return null;
        }
    }

    public final List d() {
        return this.f141343d;
    }

    public g(String str, long j3, List list) {
        super(str, j3);
        this.f141343d = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g(v unzipDir) {
        this(r0, r1, r3);
        Intrinsics.checkNotNullParameter(unzipDir, "unzipDir");
        String i3 = unzipDir.i();
        Intrinsics.checkNotNullExpressionValue(i3, "unzipDir.name");
        long r16 = unzipDir.r();
        v[] u16 = unzipDir.u();
        Intrinsics.checkNotNull(u16);
        ArrayList arrayList = new ArrayList(u16.length);
        for (v it : u16) {
            h.a aVar = h.f141344c;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(aVar.a(it));
        }
    }
}
