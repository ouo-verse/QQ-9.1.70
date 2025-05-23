package com.tencent.mobileqq.wink.h5native;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.videocut.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$FeedInfo", "", "", "toJsonStr", "component1", "component2", "id", WadlProxyConsts.CREATE_TIME, "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$FeedInfo;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getCreateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$FeedInfo, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class FeedInfo {

    @NotNull
    private final String createTime;

    @NotNull
    private final String id;

    public FeedInfo(@NotNull String id5, @NotNull String createTime) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        this.id = id5;
        this.createTime = createTime;
    }

    public static /* synthetic */ FeedInfo copy$default(FeedInfo feedInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = feedInfo.id;
        }
        if ((i3 & 2) != 0) {
            str2 = feedInfo.createTime;
        }
        return feedInfo.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final FeedInfo copy(@NotNull String id5, @NotNull String createTime) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        return new FeedInfo(id5, createTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedInfo)) {
            return false;
        }
        FeedInfo feedInfo = (FeedInfo) other;
        if (Intrinsics.areEqual(this.id, feedInfo.id) && Intrinsics.areEqual(this.createTime, feedInfo.createTime)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.createTime.hashCode();
    }

    @NotNull
    public final String toJsonStr() {
        String c16 = GsonUtils.f384219b.c(this);
        if (c16 == null) {
            return "";
        }
        return c16;
    }

    @NotNull
    public String toString() {
        return "FeedInfo(id=" + this.id + ", createTime=" + this.createTime + ")";
    }
}
