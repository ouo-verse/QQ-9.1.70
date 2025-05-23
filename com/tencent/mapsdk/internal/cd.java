package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class cd extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "domain1")
    public String f148027a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "dirNew")
    public String f148028b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "domain")
    public String f148029c;

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "fileversion")
    public int f148030d;

    /* renamed from: e, reason: collision with root package name */
    @Json(name = "updateData")
    public List<cb> f148031e;

    public final cb a(OfflineItem offlineItem) {
        List<cb> list = this.f148031e;
        if (list != null) {
            for (cb cbVar : list) {
                if (offlineItem.getPinyin().equals(cbVar.f147998c)) {
                    cbVar.f147996a = "https://" + this.f148029c + this.f148028b;
                    return cbVar;
                }
            }
        }
        return null;
    }
}
