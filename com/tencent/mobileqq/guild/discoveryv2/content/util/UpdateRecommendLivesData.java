package com.tencent.mobileqq.guild.discoveryv2.content.util;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/UpdateRecommendLivesData;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProHotLiveCard;", "(Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class UpdateRecommendLivesData extends SimpleBaseEvent {

    @NotNull
    private final ArrayList<IGProHotLiveCard> data;

    public UpdateRecommendLivesData(@NotNull ArrayList<IGProHotLiveCard> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateRecommendLivesData copy$default(UpdateRecommendLivesData updateRecommendLivesData, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = updateRecommendLivesData.data;
        }
        return updateRecommendLivesData.copy(arrayList);
    }

    @NotNull
    public final ArrayList<IGProHotLiveCard> component1() {
        return this.data;
    }

    @NotNull
    public final UpdateRecommendLivesData copy(@NotNull ArrayList<IGProHotLiveCard> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new UpdateRecommendLivesData(data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof UpdateRecommendLivesData) && Intrinsics.areEqual(this.data, ((UpdateRecommendLivesData) other).data)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<IGProHotLiveCard> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "UpdateRecommendLivesData(data=" + this.data + ")";
    }
}
