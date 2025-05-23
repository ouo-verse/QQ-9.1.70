package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStGPS;", "gps", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStGPS;", "getGps", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStGPS;", "setGps", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStGPS;)V", "", "location", "Ljava/lang/String;", "getLocation", "()Ljava/lang/String;", "setLocation", "(Ljava/lang/String;)V", "lbsId", "getLbsId", "setLbsId", "address", "getAddress", "setAddress", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStLBS {
    public static final int $stable = 8;
    private CommonStGPS gps = new CommonStGPS();
    private String location = "";
    private String lbsId = "";
    private String address = "";

    public final String getAddress() {
        return this.address;
    }

    public final CommonStGPS getGps() {
        return this.gps;
    }

    public final String getLbsId() {
        return this.lbsId;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setGps(CommonStGPS commonStGPS) {
        this.gps = commonStGPS;
    }

    public final void setLbsId(String str) {
        this.lbsId = str;
    }

    public final void setLocation(String str) {
        this.location = str;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.v("gps", this.gps.toJSONObject());
        eVar.v("location", this.location);
        eVar.v("lbsId", this.lbsId);
        eVar.v("address", this.address);
        return eVar;
    }
}
