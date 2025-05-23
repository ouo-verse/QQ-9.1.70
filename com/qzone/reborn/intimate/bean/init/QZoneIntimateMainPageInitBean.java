package com.qzone.reborn.intimate.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "()V", "activateSpaceBean", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "getActivateSpaceBean", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "setActivateSpaceBean", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;)V", "adId", "", "getAdId", "()Ljava/lang/String;", "setAdId", "(Ljava/lang/String;)V", "from", "getFrom", "setFrom", "isDraft", "", "()Z", "setDraft", "(Z)V", "isFromQRCode", "setFromQRCode", "isMember", "setMember", "jumpSchema", "getJumpSchema", "setJumpSchema", "scene", "", "getScene", "()I", "setScene", "(I)V", "spaceId", "getSpaceId", "setSpaceId", "tabId", "getTabId", "setTabId", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateMainPageInitBean extends QZoneIntimateInitBean {
    private QZoneIntimateActivateSpaceBean activateSpaceBean;
    private boolean isDraft;
    private boolean isFromQRCode;
    private boolean isMember;
    private int tabId;
    private String spaceId = "";
    private String from = "";
    private String jumpSchema = "";
    private String adId = "";
    private int scene = 1;

    public final QZoneIntimateActivateSpaceBean getActivateSpaceBean() {
        return this.activateSpaceBean;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final int getScene() {
        return this.scene;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getTabId() {
        return this.tabId;
    }

    /* renamed from: isDraft, reason: from getter */
    public final boolean getIsDraft() {
        return this.isDraft;
    }

    /* renamed from: isFromQRCode, reason: from getter */
    public final boolean getIsFromQRCode() {
        return this.isFromQRCode;
    }

    /* renamed from: isMember, reason: from getter */
    public final boolean getIsMember() {
        return this.isMember;
    }

    public final void setActivateSpaceBean(QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean) {
        this.activateSpaceBean = qZoneIntimateActivateSpaceBean;
    }

    public final void setAdId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adId = str;
    }

    public final void setDraft(boolean z16) {
        this.isDraft = z16;
    }

    public final void setFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from = str;
    }

    public final void setFromQRCode(boolean z16) {
        this.isFromQRCode = z16;
    }

    public final void setJumpSchema(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpSchema = str;
    }

    public final void setMember(boolean z16) {
        this.isMember = z16;
    }

    public final void setScene(int i3) {
        this.scene = i3;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void setTabId(int i3) {
        this.tabId = i3;
    }
}
