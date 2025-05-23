package com.tencent.mobileqq.guild.discoveryv2.content.util;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u00c6\u0003J\u0017\u0010\u0005\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u001b\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/DeleteRecommendData;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "component1", "data", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "getData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class DeleteRecommendData extends SimpleBaseEvent {

    @NotNull
    private final l<?> data;

    public DeleteRecommendData(@NotNull l<?> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeleteRecommendData copy$default(DeleteRecommendData deleteRecommendData, l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            lVar = deleteRecommendData.data;
        }
        return deleteRecommendData.copy(lVar);
    }

    @NotNull
    public final l<?> component1() {
        return this.data;
    }

    @NotNull
    public final DeleteRecommendData copy(@NotNull l<?> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DeleteRecommendData(data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof DeleteRecommendData) && Intrinsics.areEqual(this.data, ((DeleteRecommendData) other).data)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final l<?> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "DeleteRecommendData(data=" + this.data + ")";
    }
}
