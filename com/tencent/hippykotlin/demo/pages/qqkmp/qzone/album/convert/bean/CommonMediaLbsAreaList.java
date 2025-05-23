package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsAreaList;", "", "()V", "albumLbs", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsArea;", "getAlbumLbs", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsArea;", "setAlbumLbs", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsArea;)V", "endDescription", "", "getEndDescription", "()Ljava/lang/String;", "setEndDescription", "(Ljava/lang/String;)V", "lbsAreas", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLbsAreas", "()Ljava/util/ArrayList;", "setLbsAreas", "(Ljava/util/ArrayList;)V", "startDescription", "getStartDescription", "setStartDescription", "startShootTime", "", "getStartShootTime", "()J", "setStartShootTime", "(J)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonMediaLbsAreaList {
    public static final int $stable = 8;
    private long startShootTime;
    private CommonMediaLbsArea albumLbs = new CommonMediaLbsArea();
    private String startDescription = "";
    private String endDescription = "";
    private ArrayList<CommonMediaLbsArea> lbsAreas = new ArrayList<>();

    public final CommonMediaLbsArea getAlbumLbs() {
        return this.albumLbs;
    }

    public final String getEndDescription() {
        return this.endDescription;
    }

    public final ArrayList<CommonMediaLbsArea> getLbsAreas() {
        return this.lbsAreas;
    }

    public final String getStartDescription() {
        return this.startDescription;
    }

    public final long getStartShootTime() {
        return this.startShootTime;
    }

    public final void setAlbumLbs(CommonMediaLbsArea commonMediaLbsArea) {
        this.albumLbs = commonMediaLbsArea;
    }

    public final void setEndDescription(String str) {
        this.endDescription = str;
    }

    public final void setLbsAreas(ArrayList<CommonMediaLbsArea> arrayList) {
        this.lbsAreas = arrayList;
    }

    public final void setStartDescription(String str) {
        this.startDescription = str;
    }

    public final void setStartShootTime(long j3) {
        this.startShootTime = j3;
    }
}
