package com.tencent.mobileqq.webview.config;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u00020\u0006H\u0016R$\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR0\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/webview/config/a;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObj", "", "a", "", "host", "", "sceneMask", "", "b", "toString", "", "d", "Ljava/util/List;", "ipsArray", "", "Lkotlin/Pair;", "e", "Ljava/util/Map;", "dnsMapping", "<init>", "()V", "f", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.webview.config.a, reason: from toString */
/* loaded from: classes35.dex */
public final class DnsMappingConfig implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private List<List<String>> ipsArray;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private Map<String, Pair<Integer, Integer>> dnsMapping;

    public final List<String> b(String host, int sceneMask) {
        Pair<Integer, Integer> pair;
        List<List<String>> list;
        Intrinsics.checkNotNullParameter(host, "host");
        try {
            Map<String, Pair<Integer, Integer>> map = this.dnsMapping;
            if (map == null || (pair = map.get(host)) == null || (pair.getSecond().intValue() & sceneMask) != sceneMask || (list = this.ipsArray) == null) {
                return null;
            }
            return list.get(pair.getFirst().intValue());
        } catch (Exception e16) {
            QLog.e("DnsMappingConfig", 1, "getDnsMapping exception. ", e16);
        }
        return null;
    }

    public String toString() {
        return "DnsMappingConfig(ipsArray=" + this.ipsArray + ", dnsMapping=" + this.dnsMapping + ')';
    }

    public final void a(JSONObject jsonObj) {
        List<String> split$default;
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("DnsMappingConfig", 2, "from json:" + jsonObj);
        }
        JSONArray optJSONArray = jsonObj.optJSONArray("map");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                Object obj = optJSONArray.get(i16);
                JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                if (jSONObject != null) {
                    String host = jSONObject.optString("host", "");
                    String ips = jSONObject.optString("ips", "");
                    int optInt = jSONObject.optInt("scene", 0);
                    if (optInt > 0) {
                        Intrinsics.checkNotNullExpressionValue(host, "host");
                        if (host.length() > 0) {
                            Intrinsics.checkNotNullExpressionValue(ips, "ips");
                            if (ips.length() > 0) {
                                if (this.ipsArray == null || this.dnsMapping == null) {
                                    this.ipsArray = new ArrayList();
                                    this.dnsMapping = new LinkedHashMap();
                                    i3 = 0;
                                }
                                split$default = StringsKt__StringsKt.split$default((CharSequence) ips, new String[]{"|"}, false, 0, 6, (Object) null);
                                List<List<String>> list = this.ipsArray;
                                Intrinsics.checkNotNull(list);
                                list.add(split$default);
                                Map<String, Pair<Integer, Integer>> map = this.dnsMapping;
                                Intrinsics.checkNotNull(map);
                                map.put(host, TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(optInt)));
                                i3++;
                            }
                        }
                    }
                }
            }
        }
    }
}
