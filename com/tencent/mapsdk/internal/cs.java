package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.net.http.HttpProxyRule;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class cs extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "privacy_protection")
    public boolean f148072a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "http_proxy")
    public List<HttpProxyRule> f148073b;
}
