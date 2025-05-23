package com.tencent.mapsdk.internal;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sx extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "name")
    public String f150413a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "style")
    public int f150414b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "scene")
    public int f150415c;

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "version")
    public int f150416d;

    /* renamed from: e, reason: collision with root package name */
    @Json(name = "url")
    public String f150417e;

    /* renamed from: f, reason: collision with root package name */
    @Json(name = DownloaderConstant.KEY_RANGE)
    public int[] f150418f;

    private String a() {
        return this.f150413a;
    }

    private int b() {
        return this.f150414b;
    }

    private int c() {
        return this.f150415c;
    }

    private int d() {
        return this.f150416d;
    }

    private String e() {
        return this.f150417e;
    }

    private int[] f() {
        return this.f150418f;
    }

    public final String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer("WorldMapTileSrc{");
        stringBuffer.append("mName='");
        stringBuffer.append(this.f150413a);
        stringBuffer.append('\'');
        stringBuffer.append(", mStyle=");
        stringBuffer.append(this.f150414b);
        stringBuffer.append(", mScene=");
        stringBuffer.append(this.f150415c);
        stringBuffer.append(", mVersion=");
        stringBuffer.append(this.f150416d);
        stringBuffer.append(", mUrl='");
        stringBuffer.append(this.f150417e);
        stringBuffer.append('\'');
        stringBuffer.append(", mRanges=");
        if (this.f150418f == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append('[');
            for (int i3 = 0; i3 < this.f150418f.length; i3++) {
                if (i3 == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                stringBuffer.append(str);
                stringBuffer.append(this.f150418f[i3]);
            }
            stringBuffer.append(']');
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    private void a(String str) {
        this.f150413a = str;
    }

    private void b(int i3) {
        this.f150415c = i3;
    }

    private void c(int i3) {
        this.f150416d = i3;
    }

    private void a(int i3) {
        this.f150414b = i3;
    }

    private void b(String str) {
        this.f150417e = str;
    }

    private void a(int[] iArr) {
        this.f150418f = iArr;
    }

    private String a(int i3, int i16, int i17, String str) {
        String replaceFirst;
        String str2 = this.f150417e;
        int[] iArr = this.f150418f;
        if (iArr.length == 0) {
            replaceFirst = str2.replaceFirst("\\{range\\}", "");
        } else {
            replaceFirst = str2.replaceFirst("\\{range\\}", Integer.toString(a(i3 + i16, iArr.length)));
        }
        return replaceFirst.replaceFirst("\\{z\\}", Integer.toString(i17)).replaceFirst("\\{x\\}", Integer.toString(i3)).replaceFirst("\\{y\\}", Integer.toString(i16)).replaceFirst("\\{style\\}", Integer.toString(this.f150414b)).replaceFirst("\\{scene\\}", Integer.toString(this.f150415c)).replaceFirst("\\{version\\}", Integer.toString(this.f150416d)).replaceFirst("\\{ch\\}", str);
    }

    public static int a(int i3, int i16) {
        int i17 = i3 % i16;
        return i17 * i16 < 0 ? i17 + i16 : i17;
    }
}
