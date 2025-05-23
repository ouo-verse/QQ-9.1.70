package com.tencent.mobileqq.guild.feed.preload.detail.data;

import androidx.annotation.Keep;
import androidx.fragment.app.a;
import com.tencent.mobileqq.app.AppConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\nH\u00c6\u0003J7\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00d6\u0001J\u0006\u0010\u001d\u001a\u00020\u001aJ\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheResponse;", "", "cacheList", "", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheData;", "costTime", "", "error", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/ResponseCode;", "taskType", "", "(Ljava/util/List;JLcom/tencent/mobileqq/guild/feed/preload/detail/data/ResponseCode;I)V", "getCacheList", "()Ljava/util/List;", "getCostTime", "()J", "getError", "()Lcom/tencent/mobileqq/guild/feed/preload/detail/data/ResponseCode;", "getTaskType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", AppConstants.Key.COLUMN_IS_VALID, "toString", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedDetailCacheResponse {

    @NotNull
    private final List<GuildFeedDetailCacheData> cacheList;
    private final long costTime;

    @NotNull
    private final ResponseCode error;
    private final int taskType;

    public GuildFeedDetailCacheResponse() {
        this(null, 0L, null, 0, 15, null);
    }

    public static /* synthetic */ GuildFeedDetailCacheResponse copy$default(GuildFeedDetailCacheResponse guildFeedDetailCacheResponse, List list, long j3, ResponseCode responseCode, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            list = guildFeedDetailCacheResponse.cacheList;
        }
        if ((i16 & 2) != 0) {
            j3 = guildFeedDetailCacheResponse.costTime;
        }
        long j16 = j3;
        if ((i16 & 4) != 0) {
            responseCode = guildFeedDetailCacheResponse.error;
        }
        ResponseCode responseCode2 = responseCode;
        if ((i16 & 8) != 0) {
            i3 = guildFeedDetailCacheResponse.taskType;
        }
        return guildFeedDetailCacheResponse.copy(list, j16, responseCode2, i3);
    }

    @NotNull
    public final List<GuildFeedDetailCacheData> component1() {
        return this.cacheList;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCostTime() {
        return this.costTime;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final ResponseCode getError() {
        return this.error;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTaskType() {
        return this.taskType;
    }

    @NotNull
    public final GuildFeedDetailCacheResponse copy(@NotNull List<GuildFeedDetailCacheData> cacheList, long costTime, @NotNull ResponseCode error, int taskType) {
        Intrinsics.checkNotNullParameter(cacheList, "cacheList");
        Intrinsics.checkNotNullParameter(error, "error");
        return new GuildFeedDetailCacheResponse(cacheList, costTime, error, taskType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedDetailCacheResponse)) {
            return false;
        }
        GuildFeedDetailCacheResponse guildFeedDetailCacheResponse = (GuildFeedDetailCacheResponse) other;
        if (Intrinsics.areEqual(this.cacheList, guildFeedDetailCacheResponse.cacheList) && this.costTime == guildFeedDetailCacheResponse.costTime && Intrinsics.areEqual(this.error, guildFeedDetailCacheResponse.error) && this.taskType == guildFeedDetailCacheResponse.taskType) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<GuildFeedDetailCacheData> getCacheList() {
        return this.cacheList;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    @NotNull
    public final ResponseCode getError() {
        return this.error;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public int hashCode() {
        return (((((this.cacheList.hashCode() * 31) + a.a(this.costTime)) * 31) + this.error.hashCode()) * 31) + this.taskType;
    }

    public final boolean isValid() {
        boolean z16;
        if (!this.cacheList.isEmpty()) {
            List<GuildFeedDetailCacheData> list = this.cacheList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!((GuildFeedDetailCacheData) it.next()).isValid()) {
                        z16 = false;
                        break;
                    }
                }
            }
            z16 = true;
            if (z16 && this.error.getCode() == 0) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "GuildFeedDetailCacheResponse(cacheList=" + this.cacheList + ", costTime=" + this.costTime + ", error=" + this.error + ", taskType=" + this.taskType + ")";
    }

    public GuildFeedDetailCacheResponse(@NotNull List<GuildFeedDetailCacheData> cacheList, long j3, @NotNull ResponseCode error, int i3) {
        Intrinsics.checkNotNullParameter(cacheList, "cacheList");
        Intrinsics.checkNotNullParameter(error, "error");
        this.cacheList = cacheList;
        this.costTime = j3;
        this.error = error;
        this.taskType = i3;
    }

    public /* synthetic */ GuildFeedDetailCacheResponse(List list, long j3, ResponseCode responseCode, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? new ResponseCode(0, null, 3, 0 == true ? 1 : 0) : responseCode, (i16 & 8) != 0 ? 2 : i3);
    }
}
