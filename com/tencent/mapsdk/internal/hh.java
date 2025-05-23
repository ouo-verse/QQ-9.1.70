package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hh extends hj {

    /* renamed from: a, reason: collision with root package name */
    private static final String f148655a = "PromoteImageRecord";

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "promote_images")
    private List<a> f148656b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a extends hj {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "image_id")
        String f148657a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "showCount")
        int f148658b;

        public a() {
        }

        static /* synthetic */ int a(a aVar) {
            int i3 = aVar.f148658b;
            aVar.f148658b = i3 + 1;
            return i3;
        }

        a(long j3) {
            super(j3);
        }
    }

    public hh() {
    }

    public final void a(String str) {
        boolean z16;
        if (this.f148656b == null) {
            this.f148656b = new ArrayList();
        }
        Iterator<a> it = this.f148656b.iterator();
        while (true) {
            if (it.hasNext()) {
                a next = it.next();
                if (next.f148657a.equals(str)) {
                    a.a(next);
                    LogUtil.b(f148655a, "statisticData promoteRecord[" + str + "]... showInc:" + next.f148658b);
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            a aVar = new a(System.currentTimeMillis());
            aVar.f148657a = str;
            a.a(aVar);
            LogUtil.b(f148655a, "statisticData promoteRecord[" + str + "]... showInc:" + aVar.f148658b);
            this.f148656b.add(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hh(long j3) {
        super(j3);
    }
}
