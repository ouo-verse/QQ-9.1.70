package com.tencent.guild.aio.msglist.markdown;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "content", "b", "I", "c", "()I", "setStart", "(I)V", "start", "setEnd", "end", "<init>", "(Ljava/lang/String;II)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.msglist.markdown.e, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class LinkSpanEntity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int start;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int end;

    public LinkSpanEntity(@NotNull String content, int i3, int i16) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.start = i3;
        this.end = i16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* renamed from: c, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkSpanEntity)) {
            return false;
        }
        LinkSpanEntity linkSpanEntity = (LinkSpanEntity) other;
        if (Intrinsics.areEqual(this.content, linkSpanEntity.content) && this.start == linkSpanEntity.start && this.end == linkSpanEntity.end) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.content.hashCode() * 31) + this.start) * 31) + this.end;
    }

    @NotNull
    public String toString() {
        return "LinkSpanEntity(content=" + this.content + ", start=" + this.start + ", end=" + this.end + ")";
    }
}
