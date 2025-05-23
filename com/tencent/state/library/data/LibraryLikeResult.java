package com.tencent.state.library.data;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/library/data/LibraryLikeResult;", "", "likeNum", "", "(J)V", "getLikeNum", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class LibraryLikeResult {
    private final long likeNum;

    public LibraryLikeResult(long j3) {
        this.likeNum = j3;
    }

    /* renamed from: component1, reason: from getter */
    public final long getLikeNum() {
        return this.likeNum;
    }

    public final LibraryLikeResult copy(long likeNum) {
        return new LibraryLikeResult(likeNum);
    }

    public final long getLikeNum() {
        return this.likeNum;
    }

    public int hashCode() {
        return c.a(this.likeNum);
    }

    public String toString() {
        return "LibraryLikeResult(likeNum=" + this.likeNum + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof LibraryLikeResult) && this.likeNum == ((LibraryLikeResult) other).likeNum;
        }
        return true;
    }

    public static /* synthetic */ LibraryLikeResult copy$default(LibraryLikeResult libraryLikeResult, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = libraryLikeResult.likeNum;
        }
        return libraryLikeResult.copy(j3);
    }
}
