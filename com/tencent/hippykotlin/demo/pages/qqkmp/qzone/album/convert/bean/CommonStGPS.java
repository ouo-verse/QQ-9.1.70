package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStGPS;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "", QCircleSchemeAttr.Polymerize.LAT, "J", "getLat", "()J", "setLat", "(J)V", "lon", "getLon", "setLon", "eType", "getEType", "setEType", QCircleSchemeAttr.Polymerize.ALT, "getAlt", "setAlt", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStGPS {
    public static final int $stable = 8;
    private long alt;
    private long eType;
    private long lat;
    private long lon;

    public final long getAlt() {
        return this.alt;
    }

    public final long getEType() {
        return this.eType;
    }

    public final long getLat() {
        return this.lat;
    }

    public final long getLon() {
        return this.lon;
    }

    public final void setAlt(long j3) {
        this.alt = j3;
    }

    public final void setEType(long j3) {
        this.eType = j3;
    }

    public final void setLat(long j3) {
        this.lat = j3;
    }

    public final void setLon(long j3) {
        this.lon = j3;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.u(QCircleSchemeAttr.Polymerize.LAT, this.lat);
        eVar.u("lon", this.lon);
        eVar.u("eType", this.eType);
        eVar.u(QCircleSchemeAttr.Polymerize.ALT, this.alt);
        return eVar;
    }
}
