package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/f;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/n;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "source", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.f, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class TopicFeedsLordMoreIntent extends n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String source;

    public TopicFeedsLordMoreIntent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TopicFeedsLordMoreIntent) && Intrinsics.areEqual(this.source, ((TopicFeedsLordMoreIntent) other).source)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.source.hashCode();
    }

    @NotNull
    public String toString() {
        return "TopicFeedsLordMoreIntent(source=" + this.source + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicFeedsLordMoreIntent(@NotNull String source) {
        super(null);
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public /* synthetic */ TopicFeedsLordMoreIntent(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
