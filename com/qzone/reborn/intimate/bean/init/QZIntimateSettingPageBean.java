package com.qzone.reborn.intimate.bean.init;

import com.qzone.reborn.intimate.bean.QZIntimateSettingItemBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000b\"\u0004\b,\u0010\r\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZIntimateSettingPageBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "()V", "anniversary", "", "getAnniversary", "()J", "setAnniversary", "(J)V", "isEnableSyncQZoneAlbum", "", "()Z", "setEnableSyncQZoneAlbum", "(Z)V", "isNeedShowSyncLoverSpaceEntrance", "setNeedShowSyncLoverSpaceEntrance", "isSpaceDataReady", "setSpaceDataReady", "isSpacePrivate", "setSpacePrivate", "migrateAuthUrl", "", "getMigrateAuthUrl", "()Ljava/lang/String;", "setMigrateAuthUrl", "(Ljava/lang/String;)V", "settingList", "", "Lcom/qzone/reborn/intimate/bean/QZIntimateSettingItemBean;", "getSettingList", "()Ljava/util/List;", "setSettingList", "(Ljava/util/List;)V", "spaceId", "getSpaceId", "setSpaceId", "spaceType", "", "getSpaceType", "()I", "setSpaceType", "(I)V", "supportModifyAnniversary", "getSupportModifyAnniversary", "setSupportModifyAnniversary", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZIntimateSettingPageBean extends QZoneIntimateInitBean {
    private long anniversary;
    private boolean isEnableSyncQZoneAlbum;
    private boolean isNeedShowSyncLoverSpaceEntrance;
    private boolean isSpaceDataReady;
    private boolean isSpacePrivate;
    private int spaceType;
    private boolean supportModifyAnniversary;
    private String spaceId = "";
    private String migrateAuthUrl = "";
    private List<QZIntimateSettingItemBean> settingList = new ArrayList();

    public final long getAnniversary() {
        return this.anniversary;
    }

    public final String getMigrateAuthUrl() {
        return this.migrateAuthUrl;
    }

    public final List<QZIntimateSettingItemBean> getSettingList() {
        return this.settingList;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public final boolean getSupportModifyAnniversary() {
        return this.supportModifyAnniversary;
    }

    /* renamed from: isEnableSyncQZoneAlbum, reason: from getter */
    public final boolean getIsEnableSyncQZoneAlbum() {
        return this.isEnableSyncQZoneAlbum;
    }

    /* renamed from: isNeedShowSyncLoverSpaceEntrance, reason: from getter */
    public final boolean getIsNeedShowSyncLoverSpaceEntrance() {
        return this.isNeedShowSyncLoverSpaceEntrance;
    }

    /* renamed from: isSpaceDataReady, reason: from getter */
    public final boolean getIsSpaceDataReady() {
        return this.isSpaceDataReady;
    }

    /* renamed from: isSpacePrivate, reason: from getter */
    public final boolean getIsSpacePrivate() {
        return this.isSpacePrivate;
    }

    public final void setAnniversary(long j3) {
        this.anniversary = j3;
    }

    public final void setEnableSyncQZoneAlbum(boolean z16) {
        this.isEnableSyncQZoneAlbum = z16;
    }

    public final void setMigrateAuthUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.migrateAuthUrl = str;
    }

    public final void setNeedShowSyncLoverSpaceEntrance(boolean z16) {
        this.isNeedShowSyncLoverSpaceEntrance = z16;
    }

    public final void setSettingList(List<QZIntimateSettingItemBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.settingList = list;
    }

    public final void setSpaceDataReady(boolean z16) {
        this.isSpaceDataReady = z16;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void setSpacePrivate(boolean z16) {
        this.isSpacePrivate = z16;
    }

    public final void setSpaceType(int i3) {
        this.spaceType = i3;
    }

    public final void setSupportModifyAnniversary(boolean z16) {
        this.supportModifyAnniversary = z16;
    }
}
