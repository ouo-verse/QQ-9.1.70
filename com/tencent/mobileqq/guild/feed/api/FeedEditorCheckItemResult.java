package com.tencent.mobileqq.guild.feed.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "what", "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "<init>", "(ILjava/lang/Object;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.api.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedEditorCheckItemResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int what;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object payload;

    public FeedEditorCheckItemResult(int i3, @Nullable Object obj) {
        this.what = i3;
        this.payload = obj;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Object getPayload() {
        return this.payload;
    }

    /* renamed from: b, reason: from getter */
    public final int getWhat() {
        return this.what;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedEditorCheckItemResult)) {
            return false;
        }
        FeedEditorCheckItemResult feedEditorCheckItemResult = (FeedEditorCheckItemResult) other;
        if (this.what == feedEditorCheckItemResult.what && Intrinsics.areEqual(this.payload, feedEditorCheckItemResult.payload)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.what * 31;
        Object obj = this.payload;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "FeedEditorCheckItemResult(what=" + this.what + ", payload=" + this.payload + ')';
    }
}
