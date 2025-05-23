package com.tencent.mapsdk.internal;

import androidx.core.app.NotificationCompat;
import com.tencent.ads.data.AdParam;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gn extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "logs")
    List<b> f148507a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "type")
        private String f148508a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = NotificationCompat.CATEGORY_ERROR)
        private int f148509b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "msg")
        private String f148510c;

        /* renamed from: d, reason: collision with root package name */
        @Json(name = "rt")
        private int f148511d;

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.gn$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public enum EnumC7040a {
            AUTH;


            /* renamed from: b, reason: collision with root package name */
            final String f148514b;

            EnumC7040a() {
                this.f148514b = r3;
            }

            private String a() {
                return this.f148514b;
            }
        }

        public a() {
        }

        public a(EnumC7040a enumC7040a, int i3, String str, int i16) {
            this.f148508a = enumC7040a.f148514b;
            this.f148509b = i3;
            this.f148510c = str;
            this.f148511d = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "report")
        public a f148515a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "key")
        private String f148516b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "key2")
        private String f148517c;

        /* renamed from: d, reason: collision with root package name */
        @Json(name = "pid")
        private String f148518d;

        /* renamed from: e, reason: collision with root package name */
        @Json(name = "pid2")
        private String f148519e;

        /* renamed from: f, reason: collision with root package name */
        @Json(name = "hm")
        private String f148520f;

        /* renamed from: g, reason: collision with root package name */
        @Json(name = "suid")
        private String f148521g;

        /* renamed from: h, reason: collision with root package name */
        @Json(name = "os")
        private String f148522h;

        /* renamed from: i, reason: collision with root package name */
        @Json(name = "psv")
        private String f148523i;

        /* renamed from: j, reason: collision with root package name */
        @Json(name = "ver")
        private String f148524j;

        /* renamed from: k, reason: collision with root package name */
        @Json(name = AdParam.PF)
        private String f148525k;

        /* renamed from: l, reason: collision with root package name */
        @Json(name = StartupSessionConstant.KNTMODULENAME)
        private String f148526l;

        /* renamed from: m, reason: collision with root package name */
        @Json(name = "time")
        private long f148527m;

        b() {
        }

        public b(b bVar) {
            this.f148516b = bVar.f148516b;
            this.f148517c = bVar.f148517c;
            this.f148518d = bVar.f148518d;
            this.f148519e = bVar.f148519e;
            this.f148520f = bVar.f148520f;
            this.f148521g = bVar.f148521g;
            this.f148522h = bVar.f148522h;
            this.f148523i = bVar.f148523i;
            this.f148524j = bVar.f148524j;
            this.f148525k = bVar.f148525k;
            this.f148526l = bVar.f148526l;
            this.f148527m = System.currentTimeMillis();
        }

        public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
            this.f148516b = str;
            this.f148517c = str2;
            this.f148518d = str3;
            this.f148519e = str4;
            this.f148520f = str5;
            this.f148521g = str6;
            this.f148522h = str7;
            this.f148523i = str8;
            this.f148524j = str9;
            this.f148525k = str10;
            this.f148526l = str11;
            this.f148527m = System.currentTimeMillis();
        }
    }

    private List<b> a() {
        return this.f148507a;
    }

    private boolean b() {
        List<b> list = this.f148507a;
        if (list != null) {
            return list.isEmpty();
        }
        return true;
    }

    private void c() {
        List<b> list = this.f148507a;
        if (list != null) {
            list.clear();
        }
    }

    public final synchronized void a(List<b> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (this.f148507a == null) {
                    this.f148507a = new ArrayList();
                }
                this.f148507a.addAll(list);
            }
        }
    }

    public final synchronized void a(b bVar) {
        if (this.f148507a == null) {
            this.f148507a = new ArrayList();
        }
        this.f148507a.add(bVar);
    }
}
