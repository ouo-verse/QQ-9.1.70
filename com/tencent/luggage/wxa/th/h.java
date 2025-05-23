package com.tencent.luggage.wxa.th;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public static final a f141344c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f141345a;

    /* renamed from: b, reason: collision with root package name */
    public final long f141346b;

    public h(String name, long j3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f141345a = name;
        this.f141346b = j3;
    }

    public final long a() {
        return this.f141346b;
    }

    public final String b() {
        return this.f141345a;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.f141345a);
            jSONObject.put("lastModified", this.f141346b);
            return jSONObject;
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "FileMetaData#toJson, fail since " + e16);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a(v unzipFile) {
            Intrinsics.checkNotNullParameter(unzipFile, "unzipFile");
            if (!unzipFile.p()) {
                return new h(unzipFile);
            }
            g a16 = g.f141342e.a(unzipFile);
            Intrinsics.checkNotNull(a16);
            return a16;
        }

        public final h b(JSONObject jSONObject) {
            try {
                String name = jSONObject.getString("name");
                long j3 = jSONObject.getLong("lastModified");
                Intrinsics.checkNotNullExpressionValue(name, "name");
                return new h(name, j3);
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "FileMetaData#fromJsonFile, fail since " + e16);
                return null;
            }
        }

        public final h a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return json.has("subMetas") ? g.f141342e.a(json) : b(json);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h(v unzipFile) {
        this(r0, unzipFile.r());
        Intrinsics.checkNotNullParameter(unzipFile, "unzipFile");
        String i3 = unzipFile.i();
        Intrinsics.checkNotNullExpressionValue(i3, "unzipFile.name");
    }
}
