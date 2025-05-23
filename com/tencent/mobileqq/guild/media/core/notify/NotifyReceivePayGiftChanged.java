package com.tencent.mobileqq.guild.media.core.notify;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/ag;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getTinyId", "()Ljava/lang/String;", "tinyId", "e", "getContent", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.notify.ag, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class NotifyReceivePayGiftChanged implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    public NotifyReceivePayGiftChanged() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyReceivePayGiftChanged)) {
            return false;
        }
        NotifyReceivePayGiftChanged notifyReceivePayGiftChanged = (NotifyReceivePayGiftChanged) other;
        if (Intrinsics.areEqual(this.tinyId, notifyReceivePayGiftChanged.tinyId) && Intrinsics.areEqual(this.content, notifyReceivePayGiftChanged.content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.tinyId.hashCode() * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "NotifyReceivePayGiftChanged(tinyId=" + this.tinyId + ", content=" + this.content + ")";
    }

    public NotifyReceivePayGiftChanged(@NotNull String tinyId, @NotNull String content) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(content, "content");
        this.tinyId = tinyId;
        this.content = content;
    }

    public /* synthetic */ NotifyReceivePayGiftChanged(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }
}
