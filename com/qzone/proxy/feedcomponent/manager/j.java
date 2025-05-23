package com.qzone.proxy.feedcomponent.manager;

import com.qzone.proxy.feedcomponent.util.JsonORM;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.Arrays;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    @JsonORM.Column(key = "http.proxyHost")
    public String f50221b;

    /* renamed from: c, reason: collision with root package name */
    @JsonORM.Column(key = "http.proxyPort")
    public String f50222c;

    /* renamed from: d, reason: collision with root package name */
    @JsonORM.Column(key = "http.nonProxyHosts")
    public String f50223d;

    /* renamed from: e, reason: collision with root package name */
    @JsonORM.Column(key = "https.nroxyHost")
    public String f50224e;

    /* renamed from: f, reason: collision with root package name */
    @JsonORM.Column(key = "https.nroxyPort")
    public String f50225f;

    /* renamed from: g, reason: collision with root package name */
    @JsonORM.Column(key = "https.nonProxyHosts")
    public String f50226g;

    /* renamed from: h, reason: collision with root package name */
    @JsonORM.Column(key = IjkMediaMeta.IJKM_KEY_STREAMS)
    public a[] f50227h;

    /* renamed from: j, reason: collision with root package name */
    @JsonORM.Column(key = "directIPList")
    public String[] f50229j;

    /* renamed from: a, reason: collision with root package name */
    @JsonORM.Column(key = "debugDataSourceType")
    public int f50220a = -1;

    /* renamed from: i, reason: collision with root package name */
    @JsonORM.Column(key = QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE)
    public int f50228i = -1;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {
    }

    public String toString() {
        String str;
        String str2 = j.class.getSimpleName() + "{debugDataSourceType=" + this.f50220a + ",httpProxyHost=" + this.f50221b + ",httpProxyPort=" + this.f50222c + ",httpNonProxyHosts=" + this.f50223d + ",httpsProxyHost=" + this.f50224e + ",httpsProxyPort=" + this.f50225f + ",httpsNonProxyHosts=" + this.f50226g;
        if (this.f50227h != null) {
            String str3 = str2 + ",streams=[";
            if (this.f50227h.length <= 0) {
                str2 = str3 + "],";
            } else {
                new StringBuilder().append(str3);
                a aVar = this.f50227h[0];
                throw null;
            }
        }
        String str4 = str2 + "networkType=" + this.f50228i;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str4);
        sb5.append("directIPList=");
        String[] strArr = this.f50229j;
        if (strArr != null) {
            str = Arrays.toString(strArr);
        } else {
            str = "";
        }
        sb5.append(str);
        return sb5.toString() + "}";
    }
}
