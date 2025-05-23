package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rz {

    /* renamed from: a, reason: collision with root package name */
    final Map<String, a> f150162a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final bk f150163b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final oc f150164a;

        /* renamed from: b, reason: collision with root package name */
        final Detail f150165b;

        a(oc ocVar, Detail detail) {
            this.f150164a = ocVar;
            this.f150165b = detail;
        }
    }

    public rz(bk bkVar) {
        this.f150163b = bkVar;
    }

    private Map<String, a> b() {
        return this.f150162a;
    }

    private void c() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(@NonNull List<Detail> list) {
        int i3;
        if (this.f150163b == null || list.isEmpty()) {
            return;
        }
        for (Detail detail : list) {
            String str = detail.basic.icon_normal;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1 && (i3 = lastIndexOf + 1) <= str.length()) {
                String substring = str.substring(i3);
                LogUtil.a(ky.f149108n, "type:" + detail.basic.type + ", coord:" + detail.basic.coord_lat + ", " + detail.basic.coord_lon + ", minScale:" + detail.basic.min_scale + ", maxScale:" + detail.basic.max_scale);
                a aVar = this.f150162a.get(detail.basic.eventid);
                if (aVar == null) {
                    Basic basic = detail.basic;
                    oe oeVar = new oe(basic.coord_lat, basic.coord_lon, substring);
                    Basic basic2 = detail.basic;
                    oeVar.anchor(basic2.anchor_x, basic2.anchor_y);
                    oeVar.minScaleLevel(detail.basic.min_scale);
                    oeVar.maxScaleLevel(detail.basic.max_scale);
                    oeVar.avoidAnnotation(true);
                    oeVar.avoidOtherMarker(true);
                    oeVar.displayLevel(2);
                    this.f150162a.put(detail.basic.eventid, new a((oc) this.f150163b.a((bk) oeVar), detail));
                } else {
                    oe oeVar2 = (oe) aVar.f150164a.f149454d;
                    Basic basic3 = detail.basic;
                    oeVar2.position(basic3.coord_lat, basic3.coord_lon);
                    oeVar2.iconName(substring);
                    oeVar2.avoidAnnotation(true);
                    oeVar2.avoidOtherMarker(true);
                    Basic basic4 = detail.basic;
                    oeVar2.anchor(basic4.anchor_x, basic4.anchor_y);
                    oeVar2.minScaleLevel(detail.basic.min_scale);
                    oeVar2.maxScaleLevel(detail.basic.max_scale);
                    oeVar2.displayLevel(2);
                    aVar.f150164a.a((oc) oeVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(@NonNull List<Detail> list) {
        if (list.isEmpty()) {
            return;
        }
        for (Detail detail : list) {
            a aVar = this.f150162a.get(detail.basic.eventid);
            if (aVar != null) {
                aVar.f150164a.remove();
                this.f150162a.remove(detail.basic.eventid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Iterator<String> it = this.f150162a.keySet().iterator();
        while (it.hasNext()) {
            a aVar = this.f150162a.get(it.next());
            if (aVar != null) {
                aVar.f150164a.remove();
            }
        }
        this.f150162a.clear();
    }
}
