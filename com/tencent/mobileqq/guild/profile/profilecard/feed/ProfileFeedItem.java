package com.tencent.mobileqq.guild.profile.profilecard.feed;

import android.text.SpannableStringBuilder;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import fh1.MineFeedImageInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\"\u001a\u00020\u001e\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0014\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\t\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "feedId", "b", "I", "getFeedType", "()I", "feedType", "Landroid/text/SpannableStringBuilder;", "c", "Landroid/text/SpannableStringBuilder;", "()Landroid/text/SpannableStringBuilder;", "feedText", "", "Lfh1/d;", "d", "Ljava/util/List;", "()Ljava/util/List;", "imageInfoList", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "<init>", "(Ljava/lang/String;ILandroid/text/SpannableStringBuilder;Ljava/util/List;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.profile.profilecard.feed.g, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ProfileFeedItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int feedType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SpannableStringBuilder feedText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MineFeedImageInfo> imageInfoList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GProStFeed feed;

    public ProfileFeedItem(@NotNull String feedId, int i3, @NotNull SpannableStringBuilder feedText, @NotNull List<MineFeedImageInfo> imageInfoList, @NotNull GProStFeed feed) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(feedText, "feedText");
        Intrinsics.checkNotNullParameter(imageInfoList, "imageInfoList");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feedId = feedId;
        this.feedType = i3;
        this.feedText = feedText;
        this.imageInfoList = imageInfoList;
        this.feed = feed;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GProStFeed getFeed() {
        return this.feed;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final SpannableStringBuilder getFeedText() {
        return this.feedText;
    }

    @NotNull
    public final List<MineFeedImageInfo> c() {
        return this.imageInfoList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileFeedItem)) {
            return false;
        }
        ProfileFeedItem profileFeedItem = (ProfileFeedItem) other;
        if (Intrinsics.areEqual(this.feedId, profileFeedItem.feedId) && this.feedType == profileFeedItem.feedType && Intrinsics.areEqual(this.feedText, profileFeedItem.feedText) && Intrinsics.areEqual(this.imageInfoList, profileFeedItem.imageInfoList) && Intrinsics.areEqual(this.feed, profileFeedItem.feed)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.feedId.hashCode() * 31) + this.feedType) * 31) + this.feedText.hashCode()) * 31) + this.imageInfoList.hashCode()) * 31) + this.feed.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.feedId;
        int i3 = this.feedType;
        SpannableStringBuilder spannableStringBuilder = this.feedText;
        return "ProfileFeedItem(feedId=" + str + ", feedType=" + i3 + ", feedText=" + ((Object) spannableStringBuilder) + ", imageInfoList=" + this.imageInfoList + ", feed=" + this.feed + ")";
    }
}
