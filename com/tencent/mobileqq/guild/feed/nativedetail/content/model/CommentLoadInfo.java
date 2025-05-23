package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "listSize", "b", "Z", "()Z", "isFinish", "<init>", "(IZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.model.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class CommentLoadInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int listSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFinish;

    public CommentLoadInfo(int i3, boolean z16) {
        this.listSize = i3;
        this.isFinish = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getListSize() {
        return this.listSize;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentLoadInfo)) {
            return false;
        }
        CommentLoadInfo commentLoadInfo = (CommentLoadInfo) other;
        if (this.listSize == commentLoadInfo.listSize && this.isFinish == commentLoadInfo.isFinish) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.listSize * 31;
        boolean z16 = this.isFinish;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "CommentLoadInfo(listSize=" + this.listSize + ", isFinish=" + this.isFinish + ")";
    }
}
