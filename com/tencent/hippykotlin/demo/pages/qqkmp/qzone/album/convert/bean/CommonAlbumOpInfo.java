package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumOpInfo;", "", "()V", "lastDeleteCount", "", "getLastDeleteCount", "()I", "setLastDeleteCount", "(I)V", "lastDeleteTime", "getLastDeleteTime", "setLastDeleteTime", "prohibitModifyAlbumType", "", "getProhibitModifyAlbumType", "()Z", "setProhibitModifyAlbumType", "(Z)V", "recentlyUpdated", "getRecentlyUpdated", "setRecentlyUpdated", "toString", "", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonAlbumOpInfo {
    public static final int $stable = 8;
    private int lastDeleteCount;
    private int lastDeleteTime;
    private boolean prohibitModifyAlbumType;
    private boolean recentlyUpdated;

    public final int getLastDeleteCount() {
        return this.lastDeleteCount;
    }

    public final int getLastDeleteTime() {
        return this.lastDeleteTime;
    }

    public final boolean getProhibitModifyAlbumType() {
        return this.prohibitModifyAlbumType;
    }

    public final boolean getRecentlyUpdated() {
        return this.recentlyUpdated;
    }

    public final void setLastDeleteCount(int i3) {
        this.lastDeleteCount = i3;
    }

    public final void setLastDeleteTime(int i3) {
        this.lastDeleteTime = i3;
    }

    public final void setProhibitModifyAlbumType(boolean z16) {
        this.prohibitModifyAlbumType = z16;
    }

    public final void setRecentlyUpdated(boolean z16) {
        this.recentlyUpdated = z16;
    }

    public String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CommonAlbumOpInfo(lastDeleteTime:");
        m3.append(this.lastDeleteTime);
        m3.append("| lastDeleteCount:");
        m3.append(this.lastDeleteCount);
        m3.append("| recentlyUpdated:");
        m3.append(this.recentlyUpdated);
        m3.append("| prohibitModifyAlbumType:");
        m3.append(this.prohibitModifyAlbumType);
        m3.append("| )");
        return m3.toString();
    }
}
