package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/data/PosterMotionInfo;", "", "motionId", "", "background", "", "color", "ownerCoordinate", "Lcom/tencent/state/square/data/NickCoordinate;", "guestCoordinate", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/data/NickCoordinate;Lcom/tencent/state/square/data/NickCoordinate;)V", "getBackground", "()Ljava/lang/String;", "getColor", "getGuestCoordinate", "()Lcom/tencent/state/square/data/NickCoordinate;", "getMotionId", "()I", "getOwnerCoordinate", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PosterMotionInfo {
    private final String background;
    private final String color;
    private final NickCoordinate guestCoordinate;
    private final int motionId;
    private final NickCoordinate ownerCoordinate;

    public PosterMotionInfo() {
        this(0, null, null, null, null, 31, null);
    }

    public final String getBackground() {
        return this.background;
    }

    public final String getColor() {
        return this.color;
    }

    public final NickCoordinate getGuestCoordinate() {
        return this.guestCoordinate;
    }

    public final int getMotionId() {
        return this.motionId;
    }

    public final NickCoordinate getOwnerCoordinate() {
        return this.ownerCoordinate;
    }

    public PosterMotionInfo(int i3, String str, String str2, NickCoordinate ownerCoordinate, NickCoordinate guestCoordinate) {
        Intrinsics.checkNotNullParameter(ownerCoordinate, "ownerCoordinate");
        Intrinsics.checkNotNullParameter(guestCoordinate, "guestCoordinate");
        this.motionId = i3;
        this.background = str;
        this.color = str2;
        this.ownerCoordinate = ownerCoordinate;
        this.guestCoordinate = guestCoordinate;
    }

    public /* synthetic */ PosterMotionInfo(int i3, String str, String str2, NickCoordinate nickCoordinate, NickCoordinate nickCoordinate2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? new NickCoordinate(0, 0, 3, null) : nickCoordinate, (i16 & 16) != 0 ? new NickCoordinate(0, 0, 3, null) : nickCoordinate2);
    }
}
