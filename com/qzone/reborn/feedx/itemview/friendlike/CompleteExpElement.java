package com.qzone.reborn.feedx.itemview.friendlike;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "position", "Ljava/lang/String;", "()Ljava/lang/String;", "feedId", "<init>", "(ILjava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.reborn.feedx.itemview.friendlike.a, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class CompleteExpElement {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int position;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String feedId;

    public CompleteExpElement(int i3, String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.position = i3;
        this.feedId = feedId;
    }

    /* renamed from: a, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: b, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        return (this.position * 31) + this.feedId.hashCode();
    }

    public String toString() {
        return "CompleteExpElement(position=" + this.position + ", feedId=" + this.feedId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompleteExpElement)) {
            return false;
        }
        CompleteExpElement completeExpElement = (CompleteExpElement) other;
        return this.position == completeExpElement.position && Intrinsics.areEqual(this.feedId, completeExpElement.feedId);
    }
}
