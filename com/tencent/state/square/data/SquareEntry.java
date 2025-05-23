package com.tencent.state.square.data;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003Ja\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\tH\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/square/data/SquareEntry;", "", TagName.ENTRY_NAME, "", "enable", "", "icon", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "entryType", "", "jumpType", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "Lcom/tencent/state/square/data/SquareHippyInfo;", "redDotInfo", "Lcom/tencent/state/square/data/SquareRedDotInfo;", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IILcom/tencent/state/square/data/SquareHippyInfo;Lcom/tencent/state/square/data/SquareRedDotInfo;)V", "getEnable", "()Z", "getEntryName", "()Ljava/lang/String;", "getEntryType", "()I", "getHippyInfo", "()Lcom/tencent/state/square/data/SquareHippyInfo;", "getIcon", "getJumpType", "getLink", "getRedDotInfo", "()Lcom/tencent/state/square/data/SquareRedDotInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareEntry {
    private final boolean enable;
    private final String entryName;
    private final int entryType;
    private final SquareHippyInfo hippyInfo;
    private final String icon;
    private final int jumpType;
    private final String link;
    private final SquareRedDotInfo redDotInfo;

    public SquareEntry(String entryName, boolean z16, String str, String str2, int i3, int i16, SquareHippyInfo squareHippyInfo, SquareRedDotInfo squareRedDotInfo) {
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        this.entryName = entryName;
        this.enable = z16;
        this.icon = str;
        this.link = str2;
        this.entryType = i3;
        this.jumpType = i16;
        this.hippyInfo = squareHippyInfo;
        this.redDotInfo = squareRedDotInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final String getEntryName() {
        return this.entryName;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component5, reason: from getter */
    public final int getEntryType() {
        return this.entryType;
    }

    /* renamed from: component6, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    /* renamed from: component7, reason: from getter */
    public final SquareHippyInfo getHippyInfo() {
        return this.hippyInfo;
    }

    /* renamed from: component8, reason: from getter */
    public final SquareRedDotInfo getRedDotInfo() {
        return this.redDotInfo;
    }

    public final SquareEntry copy(String entryName, boolean enable, String icon, String link, int entryType, int jumpType, SquareHippyInfo hippyInfo, SquareRedDotInfo redDotInfo) {
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        return new SquareEntry(entryName, enable, icon, link, entryType, jumpType, hippyInfo, redDotInfo);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getEntryName() {
        return this.entryName;
    }

    public final int getEntryType() {
        return this.entryType;
    }

    public final SquareHippyInfo getHippyInfo() {
        return this.hippyInfo;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final String getLink() {
        return this.link;
    }

    public final SquareRedDotInfo getRedDotInfo() {
        return this.redDotInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.entryName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z16 = this.enable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        String str2 = this.icon;
        int hashCode2 = (i16 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.link;
        int hashCode3 = (((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.entryType) * 31) + this.jumpType) * 31;
        SquareHippyInfo squareHippyInfo = this.hippyInfo;
        int hashCode4 = (hashCode3 + (squareHippyInfo != null ? squareHippyInfo.hashCode() : 0)) * 31;
        SquareRedDotInfo squareRedDotInfo = this.redDotInfo;
        return hashCode4 + (squareRedDotInfo != null ? squareRedDotInfo.hashCode() : 0);
    }

    public String toString() {
        return "SquareEntry(entryName=" + this.entryName + ", enable=" + this.enable + ", icon=" + this.icon + ", link=" + this.link + ", entryType=" + this.entryType + ", jumpType=" + this.jumpType + ", hippyInfo=" + this.hippyInfo + ", redDotInfo=" + this.redDotInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareEntry)) {
            return false;
        }
        SquareEntry squareEntry = (SquareEntry) other;
        return Intrinsics.areEqual(this.entryName, squareEntry.entryName) && this.enable == squareEntry.enable && Intrinsics.areEqual(this.icon, squareEntry.icon) && Intrinsics.areEqual(this.link, squareEntry.link) && this.entryType == squareEntry.entryType && this.jumpType == squareEntry.jumpType && Intrinsics.areEqual(this.hippyInfo, squareEntry.hippyInfo) && Intrinsics.areEqual(this.redDotInfo, squareEntry.redDotInfo);
    }
}
