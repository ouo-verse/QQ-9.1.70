package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.annotation.Json;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hc extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "ubs")
    public b f148622a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "ubds")
    private List<a> f148623b;

    /* renamed from: c, reason: collision with root package name */
    private long f148624c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "buildingId")
        String f148625a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "showCount")
        private int f148626b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "buttonClickCount")
        private int f148627c;

        /* renamed from: d, reason: collision with root package name */
        @Json(name = "buttonShowCount")
        private int f148628d;

        public a() {
            this.f148625a = "";
            this.f148626b = 0;
            this.f148627c = 0;
            this.f148628d = 0;
        }

        public final int b() {
            int i3 = this.f148627c + 1;
            this.f148627c = i3;
            return i3;
        }

        public final int c() {
            int i3 = this.f148628d + 1;
            this.f148628d = i3;
            return i3;
        }

        public final int a() {
            int i3 = this.f148626b + 1;
            this.f148626b = i3;
            return i3;
        }

        a(String str, long j3) {
            super(j3);
            this.f148626b = 0;
            this.f148627c = 0;
            this.f148628d = 0;
            this.f148625a = str;
        }
    }

    public hc() {
    }

    private long a() {
        return this.f148624c;
    }

    private b b() {
        return this.f148622a;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "showCount")
        private int f148629a;

        public b() {
            this.f148629a = 0;
        }

        public final int a() {
            int i3 = this.f148629a + 1;
            this.f148629a = i3;
            return i3;
        }

        b(long j3) {
            super(j3);
            this.f148629a = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hc(long j3, long j16) {
        super(j3);
        this.f148624c = j16;
        this.f148622a = new b(j3);
        this.f148623b = new ArrayList();
    }

    public final a a(String str) {
        for (a aVar : this.f148623b) {
            if (!TextUtils.isEmpty(aVar.f148625a) && aVar.f148625a.equals(str)) {
                return aVar;
            }
        }
        a aVar2 = new a(str, System.currentTimeMillis() - this.f148624c);
        this.f148623b.add(aVar2);
        return aVar2;
    }
}
