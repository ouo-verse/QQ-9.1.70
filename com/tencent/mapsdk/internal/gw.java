package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gw extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "styles")
    private List<a> f148601a;

    public gw() {
        this.f148601a = new ArrayList();
    }

    public final int a(int i3) {
        for (a aVar : this.f148601a) {
            if (aVar.f148602a == i3) {
                int i16 = aVar.f148603b + 1;
                aVar.f148603b = i16;
                return i16;
            }
        }
        this.f148601a.add(new a(this.f148681g, i3));
        return 1;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "id")
        int f148602a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "showCount")
        int f148603b;

        public a() {
            this.f148602a = 0;
            this.f148603b = 0;
        }

        private static /* synthetic */ int b(a aVar) {
            int i3 = aVar.f148603b + 1;
            aVar.f148603b = i3;
            return i3;
        }

        a(long j3, int i3) {
            super(j3);
            this.f148602a = i3;
            this.f148603b = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gw(long j3) {
        super(j3);
        this.f148601a = new ArrayList();
    }
}
