package com.tencent.mapsdk.internal;

import androidx.core.app.NotificationCompat;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.map.tools.json.annotation.Json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gu extends hj {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, a> f148594a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = LinkReportConstant$GlobalKey.CONNECT_TYPE)
    private int f148595b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "fails")
    private final List<a> f148596c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "rt")
        public int f148597a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = NotificationCompat.CATEGORY_ERROR)
        public int f148598b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "msg")
        public String f148599c;

        public a() {
            super(System.currentTimeMillis());
            this.f148597a = 0;
            this.f148598b = 0;
        }

        private static /* synthetic */ int a(a aVar) {
            int i3 = aVar.f148597a;
            aVar.f148597a = i3 + 1;
            return i3;
        }
    }

    public gu() {
        this.f148595b = 0;
        this.f148594a = new HashMap();
        this.f148596c = new ArrayList();
    }

    private boolean b() {
        if (!this.f148596c.isEmpty()) {
            return true;
        }
        return false;
    }

    private List<a> c() {
        return this.f148596c;
    }

    public final void a() {
        this.f148595b++;
    }

    private int a(int i3, String str) {
        String str2 = i3 + str;
        a aVar = this.f148594a.get(str2);
        if (aVar == null) {
            aVar = new a();
            this.f148594a.put(str2, aVar);
        }
        aVar.f148598b = i3;
        aVar.f148599c = str;
        int i16 = aVar.f148597a + 1;
        aVar.f148597a = i16;
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gu(long j3) {
        super(j3);
        this.f148595b = 0;
        this.f148594a = new HashMap();
        this.f148596c = new ArrayList();
    }
}
