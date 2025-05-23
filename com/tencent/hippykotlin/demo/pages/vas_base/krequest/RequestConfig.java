package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.Adapter;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Custom;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class RequestConfig {
    public final Adapter adapter;
    public String baseURL;
    public Map<String, String> cookies;
    public final List<Custom> custom;
    public e data;
    public Map<String, String> headers;
    public Method method;
    public Map<String, String> params;
    public int timeout;
    public String url;

    public RequestConfig() {
        this(null, null, null, null, null, 0, null, 1023);
    }

    public final int hashCode() {
        int hashCode = (this.custom.hashCode() + ((this.cookies.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.timeout, (this.data.hashCode() + ((this.params.hashCode() + ((this.headers.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.baseURL, (this.method.hashCode() + (this.url.hashCode() * 31)) * 31, 31)) * 31)) * 31)) * 31, 31)) * 31)) * 31;
        Adapter adapter = this.adapter;
        return hashCode + (adapter == null ? 0 : adapter.hashCode());
    }

    public final String toString() {
        String trimIndent;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\n            baseURL: ");
        m3.append(this.baseURL);
        m3.append(",\n            url: ");
        m3.append(this.url);
        m3.append(",\n            method: ");
        m3.append(this.method.name());
        m3.append(",\n            headers: ");
        m3.append(this.headers);
        m3.append(",\n            params: ");
        m3.append(this.params);
        m3.append(",\n            data: ");
        m3.append(this.data);
        m3.append(",\n            cookies: ");
        m3.append(this.cookies);
        m3.append(",\n        ");
        trimIndent = StringsKt__IndentKt.trimIndent(m3.toString());
        return trimIndent;
    }

    public RequestConfig(String str, Method method, String str2, Map<String, String> map, Map<String, String> map2, e eVar, int i3, Map<String, String> map3, List<Custom> list, Adapter adapter) {
        this.url = str;
        this.method = method;
        this.baseURL = str2;
        this.headers = map;
        this.params = map2;
        this.data = eVar;
        this.timeout = i3;
        this.cookies = map3;
        this.custom = list;
        this.adapter = adapter;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestConfig)) {
            return false;
        }
        RequestConfig requestConfig = (RequestConfig) obj;
        return Intrinsics.areEqual(this.url, requestConfig.url) && this.method == requestConfig.method && Intrinsics.areEqual(this.baseURL, requestConfig.baseURL) && Intrinsics.areEqual(this.headers, requestConfig.headers) && Intrinsics.areEqual(this.params, requestConfig.params) && Intrinsics.areEqual(this.data, requestConfig.data) && this.timeout == requestConfig.timeout && Intrinsics.areEqual(this.cookies, requestConfig.cookies) && Intrinsics.areEqual(this.custom, requestConfig.custom) && Intrinsics.areEqual(this.adapter, requestConfig.adapter);
    }

    public /* synthetic */ RequestConfig(String str, String str2, Map map, Map map2, e eVar, int i3, Map map3, int i16) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? Method.GET : null, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? new LinkedHashMap() : map, (i16 & 16) != 0 ? new LinkedHashMap() : map2, (i16 & 32) != 0 ? new e() : eVar, (i16 & 64) != 0 ? 0 : i3, (i16 & 128) != 0 ? new LinkedHashMap() : map3, (i16 & 256) != 0 ? new ArrayList() : null, null);
    }
}
