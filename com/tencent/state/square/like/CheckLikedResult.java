package com.tencent.state.square.like;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/like/CheckLikedResult;", "", "()V", "likeType", "", "getLikeType", "()I", "setLikeType", "(I)V", "localLikedCount", "getLocalLikedCount", "setLocalLikedCount", "totalLikedCount", "getTotalLikedCount", "setTotalLikedCount", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CheckLikedResult {
    private int likeType = -1;
    private int localLikedCount;
    private int totalLikedCount;

    public final int getLikeType() {
        return this.likeType;
    }

    public final int getLocalLikedCount() {
        return this.localLikedCount;
    }

    public final int getTotalLikedCount() {
        return this.totalLikedCount;
    }

    public final void setLikeType(int i3) {
        this.likeType = i3;
    }

    public final void setLocalLikedCount(int i3) {
        this.localLikedCount = i3;
    }

    public final void setTotalLikedCount(int i3) {
        this.totalLikedCount = i3;
    }
}
