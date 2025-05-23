package com.tencent.mobileqq.guild.contentshare;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uid", "nick", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.contentshare.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class AnchorInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nick;

    public AnchorInfo(@NotNull String uid, @NotNull String nick) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        this.uid = uid;
        this.nick = nick;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnchorInfo)) {
            return false;
        }
        AnchorInfo anchorInfo = (AnchorInfo) other;
        if (Intrinsics.areEqual(this.uid, anchorInfo.uid) && Intrinsics.areEqual(this.nick, anchorInfo.nick)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.uid.hashCode() * 31) + this.nick.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnchorInfo(uid=" + this.uid + ", nick=" + this.nick + ')';
    }
}
