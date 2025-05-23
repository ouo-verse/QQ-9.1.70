package com.tencent.mobileqq.guild.feed.detail.task;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u001f\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/FeedGalleryPagerResult;", "", "", "toJson", "", "component1", "component2", "curMediaIndex", "firstFeedId", "copy", "toString", "hashCode", "other", "", "equals", "I", "getCurMediaIndex", "()I", "Ljava/lang/String;", "getFirstFeedId", "()Ljava/lang/String;", "setFirstFeedId", "(Ljava/lang/String;)V", "<init>", "(ILjava/lang/String;)V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class FeedGalleryPagerResult {

    @SerializedName("curMediaIndex")
    private final int curMediaIndex;

    @SerializedName("firstFeedId")
    @Nullable
    private String firstFeedId;

    public FeedGalleryPagerResult(int i3, @Nullable String str) {
        this.curMediaIndex = i3;
        this.firstFeedId = str;
    }

    public static /* synthetic */ FeedGalleryPagerResult copy$default(FeedGalleryPagerResult feedGalleryPagerResult, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = feedGalleryPagerResult.curMediaIndex;
        }
        if ((i16 & 2) != 0) {
            str = feedGalleryPagerResult.firstFeedId;
        }
        return feedGalleryPagerResult.copy(i3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCurMediaIndex() {
        return this.curMediaIndex;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getFirstFeedId() {
        return this.firstFeedId;
    }

    @NotNull
    public final FeedGalleryPagerResult copy(int curMediaIndex, @Nullable String firstFeedId) {
        return new FeedGalleryPagerResult(curMediaIndex, firstFeedId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedGalleryPagerResult)) {
            return false;
        }
        FeedGalleryPagerResult feedGalleryPagerResult = (FeedGalleryPagerResult) other;
        if (this.curMediaIndex == feedGalleryPagerResult.curMediaIndex && Intrinsics.areEqual(this.firstFeedId, feedGalleryPagerResult.firstFeedId)) {
            return true;
        }
        return false;
    }

    public final int getCurMediaIndex() {
        return this.curMediaIndex;
    }

    @Nullable
    public final String getFirstFeedId() {
        return this.firstFeedId;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.curMediaIndex * 31;
        String str = this.firstFeedId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return i3 + hashCode;
    }

    public final void setFirstFeedId(@Nullable String str) {
        this.firstFeedId = str;
    }

    @NotNull
    public final String toJson() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
        return json;
    }

    @NotNull
    public String toString() {
        return "FeedGalleryPagerResult(curMediaIndex=" + this.curMediaIndex + ", firstFeedId=" + this.firstFeedId + ")";
    }

    public /* synthetic */ FeedGalleryPagerResult(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : str);
    }
}
