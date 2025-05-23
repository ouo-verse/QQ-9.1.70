package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLBS;", "", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "gps", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonGPS;", "getGps", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonGPS;", "setGps", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonGPS;)V", "id", "getId", "setId", "location", "getLocation", "setLocation", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonLBS {
    public static final int $stable = 8;
    private String address;
    private CommonGPS gps;
    private String id;
    private String location;

    public final String getAddress() {
        return this.address;
    }

    public final CommonGPS getGps() {
        return this.gps;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setGps(CommonGPS commonGPS) {
        this.gps = commonGPS;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setLocation(String str) {
        this.location = str;
    }
}
