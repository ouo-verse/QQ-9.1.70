package com.tencent.state.square;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u00c6\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/SquareGroupFragmentConfig;", "", "source", "", "titleTopMargin", "", "embedOnlinePanel", "", "friendStatusPanelData", "Lcom/tencent/state/square/FriendStatusPanelData;", "(Ljava/lang/String;IZLcom/tencent/state/square/FriendStatusPanelData;)V", "getEmbedOnlinePanel", "()Z", "getFriendStatusPanelData", "()Lcom/tencent/state/square/FriendStatusPanelData;", "getSource", "()Ljava/lang/String;", "getTitleTopMargin", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareGroupFragmentConfig {
    private final boolean embedOnlinePanel;
    private final FriendStatusPanelData friendStatusPanelData;
    private final String source;
    private final int titleTopMargin;

    public SquareGroupFragmentConfig() {
        this(null, 0, false, null, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTitleTopMargin() {
        return this.titleTopMargin;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEmbedOnlinePanel() {
        return this.embedOnlinePanel;
    }

    /* renamed from: component4, reason: from getter */
    public final FriendStatusPanelData getFriendStatusPanelData() {
        return this.friendStatusPanelData;
    }

    public final SquareGroupFragmentConfig copy(String source, int titleTopMargin, boolean embedOnlinePanel, FriendStatusPanelData friendStatusPanelData) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new SquareGroupFragmentConfig(source, titleTopMargin, embedOnlinePanel, friendStatusPanelData);
    }

    public final boolean getEmbedOnlinePanel() {
        return this.embedOnlinePanel;
    }

    public final FriendStatusPanelData getFriendStatusPanelData() {
        return this.friendStatusPanelData;
    }

    public final String getSource() {
        return this.source;
    }

    public final int getTitleTopMargin() {
        return this.titleTopMargin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.source;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.titleTopMargin) * 31;
        boolean z16 = this.embedOnlinePanel;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        FriendStatusPanelData friendStatusPanelData = this.friendStatusPanelData;
        return i16 + (friendStatusPanelData != null ? friendStatusPanelData.hashCode() : 0);
    }

    public String toString() {
        return "SquareGroupFragmentConfig(source=" + this.source + ", titleTopMargin=" + this.titleTopMargin + ", embedOnlinePanel=" + this.embedOnlinePanel + ", friendStatusPanelData=" + this.friendStatusPanelData + ")";
    }

    public SquareGroupFragmentConfig(String source, int i3, boolean z16, FriendStatusPanelData friendStatusPanelData) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.titleTopMargin = i3;
        this.embedOnlinePanel = z16;
        this.friendStatusPanelData = friendStatusPanelData;
    }

    public /* synthetic */ SquareGroupFragmentConfig(String str, int i3, boolean z16, FriendStatusPanelData friendStatusPanelData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? Integer.MIN_VALUE : i3, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? null : friendStatusPanelData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareGroupFragmentConfig)) {
            return false;
        }
        SquareGroupFragmentConfig squareGroupFragmentConfig = (SquareGroupFragmentConfig) other;
        return Intrinsics.areEqual(this.source, squareGroupFragmentConfig.source) && this.titleTopMargin == squareGroupFragmentConfig.titleTopMargin && this.embedOnlinePanel == squareGroupFragmentConfig.embedOnlinePanel && Intrinsics.areEqual(this.friendStatusPanelData, squareGroupFragmentConfig.friendStatusPanelData);
    }

    public static /* synthetic */ SquareGroupFragmentConfig copy$default(SquareGroupFragmentConfig squareGroupFragmentConfig, String str, int i3, boolean z16, FriendStatusPanelData friendStatusPanelData, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = squareGroupFragmentConfig.source;
        }
        if ((i16 & 2) != 0) {
            i3 = squareGroupFragmentConfig.titleTopMargin;
        }
        if ((i16 & 4) != 0) {
            z16 = squareGroupFragmentConfig.embedOnlinePanel;
        }
        if ((i16 & 8) != 0) {
            friendStatusPanelData = squareGroupFragmentConfig.friendStatusPanelData;
        }
        return squareGroupFragmentConfig.copy(str, i3, z16, friendStatusPanelData);
    }
}
