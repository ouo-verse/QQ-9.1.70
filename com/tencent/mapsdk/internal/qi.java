package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonParser;
import java.security.SecureRandom;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class qi implements JsonParser {

    /* renamed from: a, reason: collision with root package name */
    public String f149817a;

    /* renamed from: b, reason: collision with root package name */
    public String f149818b;

    /* renamed from: c, reason: collision with root package name */
    public int f149819c;

    /* renamed from: d, reason: collision with root package name */
    public int f149820d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f149821e;

    /* renamed from: f, reason: collision with root package name */
    private String f149822f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f149823g;

    /* renamed from: h, reason: collision with root package name */
    private JSONObject f149824h;

    public final String a(int i3, int i16, int i17) {
        int i18;
        String[] strArr = this.f149823g;
        if (strArr != null && strArr.length != 0) {
            String replace = this.f149822f.replace("{x}", String.valueOf(i3)).replace("{y}", String.valueOf(i16)).replace("{z}", String.valueOf(i17));
            for (String str : this.f149823g) {
                Object opt = this.f149824h.opt(str);
                if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    int length = jSONArray.length() - 0;
                    if (length > 0) {
                        i18 = new SecureRandom().nextInt(length) + 0;
                    } else {
                        i18 = 0;
                    }
                    replace = replace.replace("{" + str + "}", jSONArray.optString(i18, ""));
                } else if ((opt instanceof String) || (opt instanceof Number)) {
                    replace = replace.replace("{" + str + "}", String.valueOf(opt));
                }
            }
            return replace;
        }
        return this.f149822f;
    }

    @Override // com.tencent.map.tools.json.JsonParser
    public void parse(JSONObject jSONObject) {
        this.f149824h = jSONObject;
        if (jSONObject != null) {
            this.f149817a = jSONObject.optString("layerid");
            this.f149818b = jSONObject.optString("version");
            this.f149822f = jSONObject.optString("url");
            this.f149819c = jSONObject.optInt("zoom_max", 20);
            this.f149820d = jSONObject.optInt("zoom_min", 1);
            JSONArray optJSONArray = jSONObject.optJSONArray("params");
            if (optJSONArray != null) {
                this.f149823g = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.f149823g[i3] = optJSONArray.optString(i3);
                }
            }
        }
    }

    public String toString() {
        String obj;
        StringBuffer stringBuffer = new StringBuffer("CustomLayerModel{");
        stringBuffer.append("mLayerId='");
        stringBuffer.append(this.f149817a);
        stringBuffer.append('\'');
        stringBuffer.append(", mVersion='");
        stringBuffer.append(this.f149818b);
        stringBuffer.append('\'');
        stringBuffer.append(", mMaxZoomLevel=");
        stringBuffer.append(this.f149819c);
        stringBuffer.append(", mMinZoomLevel=");
        stringBuffer.append(this.f149820d);
        stringBuffer.append(", mUrl='");
        stringBuffer.append(this.f149822f);
        stringBuffer.append('\'');
        stringBuffer.append(", mParamsHolders=");
        String[] strArr = this.f149823g;
        if (strArr == null) {
            obj = "null";
        } else {
            obj = Arrays.asList(strArr).toString();
        }
        stringBuffer.append(obj);
        stringBuffer.append(", mVersionUpdated=");
        stringBuffer.append(this.f149821e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
