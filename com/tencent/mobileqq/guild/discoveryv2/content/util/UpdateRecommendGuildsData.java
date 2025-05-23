package com.tencent.mobileqq.guild.discoveryv2.content.util;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/UpdateRecommendGuildsData;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSelectedGuildCard;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class UpdateRecommendGuildsData extends SimpleBaseEvent {

    @NotNull
    private final ArrayList<IGProSelectedGuildCard> data;

    public UpdateRecommendGuildsData(@NotNull ArrayList<IGProSelectedGuildCard> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateRecommendGuildsData copy$default(UpdateRecommendGuildsData updateRecommendGuildsData, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = updateRecommendGuildsData.data;
        }
        return updateRecommendGuildsData.copy(arrayList);
    }

    @NotNull
    public final ArrayList<IGProSelectedGuildCard> component1() {
        return this.data;
    }

    @NotNull
    public final UpdateRecommendGuildsData copy(@NotNull ArrayList<IGProSelectedGuildCard> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new UpdateRecommendGuildsData(data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof UpdateRecommendGuildsData) && Intrinsics.areEqual(this.data, ((UpdateRecommendGuildsData) other).data)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<IGProSelectedGuildCard> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "UpdateRecommendGuildsData(data=" + this.data + ")";
    }
}
