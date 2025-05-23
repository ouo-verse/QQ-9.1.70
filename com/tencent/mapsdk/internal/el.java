package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class el extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "layerid")
    public String f148197a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "type")
    public int f148198b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "local_data_ver")
    public int f148199c;

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "local_cfg_ver")
    public int f148200d;

    /* renamed from: e, reason: collision with root package name */
    @Json(ignore = true)
    public String f148201e;

    /* renamed from: f, reason: collision with root package name */
    @Json(name = "data_ver")
    private String f148202f;

    /* renamed from: g, reason: collision with root package name */
    @Json(name = "cfg_ver")
    private String f148203g;

    /* renamed from: h, reason: collision with root package name */
    @Json(name = "params")
    private String[] f148204h;

    /* renamed from: i, reason: collision with root package name */
    @Json(name = "url")
    private String f148205i;

    private void a(int i3) {
        if (i3 != this.f148199c) {
            this.f148201e = null;
        }
        this.f148199c = i3;
    }

    private String b() {
        return this.f148197a;
    }

    private String c() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f148199c);
        return sb5.toString();
    }

    private String d() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f148200d);
        return sb5.toString();
    }

    private boolean e() {
        String str = this.f148202f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f148199c);
        if (str.equals(sb5.toString())) {
            String str2 = this.f148203g;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.f148200d);
            if (str2.equals(sb6.toString())) {
                return false;
            }
            return true;
        }
        return true;
    }

    private eh f() {
        return eh.a(this.f148198b);
    }

    public final String toString() {
        return "DataLayer{layerId='" + this.f148197a + "', layerType='" + this.f148198b + "', remoteDataVersion='" + this.f148202f + "', dataVersion=" + this.f148199c + ", remoteStyleVersion='" + this.f148203g + "', styleVersion=" + this.f148200d + ", params=" + Arrays.toString(this.f148204h) + ", dataUrl='" + this.f148205i + "', decodeDataUrl='" + this.f148201e + "'}";
    }

    private void b(int i3) {
        if (i3 != this.f148200d) {
            this.f148201e = null;
        }
        this.f148200d = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a() {
        boolean z16;
        String str = this.f148202f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f148199c);
        boolean equals = str.equals(sb5.toString());
        if (equals) {
            String str2 = this.f148203g;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.f148200d);
            if (str2.equals(sb6.toString())) {
                z16 = false;
                if (z16) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(this.f148200d);
                    this.f148203g = sb7.toString();
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(this.f148199c);
                    this.f148202f = sb8.toString();
                    this.f148201e = null;
                }
                if (this.f148204h != null && this.f148201e == null && !TextUtils.isEmpty(this.f148205i)) {
                    this.f148201e = this.f148205i;
                    for (String str3 : this.f148204h) {
                        try {
                            Object fieldValueByJsonName = getFieldValueByJsonName(str3);
                            if (fieldValueByJsonName instanceof String) {
                                this.f148201e = this.f148201e.replaceAll("\\{" + str3 + "\\}", (String) fieldValueByJsonName);
                            }
                        } catch (IllegalAccessException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
                return this.f148201e;
            }
        }
        z16 = true;
        if (z16) {
        }
        if (this.f148204h != null) {
            this.f148201e = this.f148205i;
            while (r1 < r2) {
            }
        }
        return this.f148201e;
    }
}
