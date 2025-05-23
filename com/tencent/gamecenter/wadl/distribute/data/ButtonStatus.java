package com.tencent.gamecenter.wadl.distribute.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonStatus;", "", "followStatus", "", "subscribeStatus", "downloadTaskStatus", "(III)V", "getDownloadTaskStatus", "()I", "setDownloadTaskStatus", "(I)V", "getFollowStatus", "setFollowStatus", "getSubscribeStatus", "setSubscribeStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class ButtonStatus {
    private volatile int downloadTaskStatus;
    private volatile int followStatus;
    private volatile int subscribeStatus;

    public ButtonStatus(int i3, int i16, int i17) {
        this.followStatus = i3;
        this.subscribeStatus = i16;
        this.downloadTaskStatus = i17;
    }

    public static /* synthetic */ ButtonStatus copy$default(ButtonStatus buttonStatus, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = buttonStatus.followStatus;
        }
        if ((i18 & 2) != 0) {
            i16 = buttonStatus.subscribeStatus;
        }
        if ((i18 & 4) != 0) {
            i17 = buttonStatus.downloadTaskStatus;
        }
        return buttonStatus.copy(i3, i16, i17);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFollowStatus() {
        return this.followStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSubscribeStatus() {
        return this.subscribeStatus;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDownloadTaskStatus() {
        return this.downloadTaskStatus;
    }

    @NotNull
    public final ButtonStatus copy(int followStatus, int subscribeStatus, int downloadTaskStatus) {
        return new ButtonStatus(followStatus, subscribeStatus, downloadTaskStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonStatus)) {
            return false;
        }
        ButtonStatus buttonStatus = (ButtonStatus) other;
        if (this.followStatus == buttonStatus.followStatus && this.subscribeStatus == buttonStatus.subscribeStatus && this.downloadTaskStatus == buttonStatus.downloadTaskStatus) {
            return true;
        }
        return false;
    }

    public final int getDownloadTaskStatus() {
        return this.downloadTaskStatus;
    }

    public final int getFollowStatus() {
        return this.followStatus;
    }

    public final int getSubscribeStatus() {
        return this.subscribeStatus;
    }

    public int hashCode() {
        return (((this.followStatus * 31) + this.subscribeStatus) * 31) + this.downloadTaskStatus;
    }

    public final void setDownloadTaskStatus(int i3) {
        this.downloadTaskStatus = i3;
    }

    public final void setFollowStatus(int i3) {
        this.followStatus = i3;
    }

    public final void setSubscribeStatus(int i3) {
        this.subscribeStatus = i3;
    }

    @NotNull
    public String toString() {
        return "ButtonStatus(followStatus=" + this.followStatus + ", subscribeStatus=" + this.subscribeStatus + ", downloadTaskStatus=" + this.downloadTaskStatus + ")";
    }
}
