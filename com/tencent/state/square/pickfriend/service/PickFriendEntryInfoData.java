package com.tencent.state.square.pickfriend.service;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/pickfriend/service/PickFriendEntryInfoData;", "", "iconUrl", "", "title", WadlProxyConsts.KEY_JUMP_URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getJumpUrl", "getTitle", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PickFriendEntryInfoData {
    private final String iconUrl;
    private final String jumpUrl;
    private String title;

    public PickFriendEntryInfoData(String iconUrl, String title, String jumpUrl) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.iconUrl = iconUrl;
        this.title = title;
        this.jumpUrl = jumpUrl;
    }

    /* renamed from: component1, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final PickFriendEntryInfoData copy(String iconUrl, String title, String jumpUrl) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new PickFriendEntryInfoData(iconUrl, title, jumpUrl);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.iconUrl;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.jumpUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "PickFriendEntryInfoData(iconUrl=" + this.iconUrl + ", title=" + this.title + ", jumpUrl=" + this.jumpUrl + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickFriendEntryInfoData)) {
            return false;
        }
        PickFriendEntryInfoData pickFriendEntryInfoData = (PickFriendEntryInfoData) other;
        return Intrinsics.areEqual(this.iconUrl, pickFriendEntryInfoData.iconUrl) && Intrinsics.areEqual(this.title, pickFriendEntryInfoData.title) && Intrinsics.areEqual(this.jumpUrl, pickFriendEntryInfoData.jumpUrl);
    }

    public static /* synthetic */ PickFriendEntryInfoData copy$default(PickFriendEntryInfoData pickFriendEntryInfoData, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pickFriendEntryInfoData.iconUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = pickFriendEntryInfoData.title;
        }
        if ((i3 & 4) != 0) {
            str3 = pickFriendEntryInfoData.jumpUrl;
        }
        return pickFriendEntryInfoData.copy(str, str2, str3);
    }
}
