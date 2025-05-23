package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineCity;
import com.tencent.map.sdk.comps.offlinemap.OfflineNation;
import com.tencent.map.sdk.comps.offlinemap.OfflineProvince;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class bz extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "name")
    public String f147968a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "pinyin")
    public String f147969b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "cityList")
    public List<bz> f147970c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final OfflineCity a(OfflineProvince offlineProvince) {
        OfflineCity offlineCity = new OfflineCity();
        offlineCity.setName(this.f147968a);
        offlineCity.setPinyin(this.f147969b);
        offlineCity.setProvince(offlineProvince);
        return offlineCity;
    }

    private OfflineProvince a(List<OfflineCity> list) {
        OfflineProvince offlineProvince = new OfflineProvince();
        offlineProvince.setName(this.f147968a);
        offlineProvince.setPinyin(this.f147969b);
        offlineProvince.setCities(list);
        return offlineProvince;
    }

    private OfflineNation a() {
        OfflineNation offlineNation = new OfflineNation();
        offlineNation.setName(this.f147968a);
        offlineNation.setPinyin(this.f147969b);
        return offlineNation;
    }
}
