package com.tencent.mobileqq.guild.feed.feedsquare.data;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004\u001a\f\u0010\u0007\u001a\u00020\u0004*\u0004\u0018\u00010\u0001\u001a\f\u0010\b\u001a\u00020\u0004*\u0004\u0018\u00010\u0001\u001a\f\u0010\t\u001a\u00020\u0004*\u0004\u0018\u00010\u0001\u001a\f\u0010\n\u001a\u00020\u0004*\u0004\u0018\u00010\u0001\u00a8\u0006\u000b"}, d2 = {"Lij1/g;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "b", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "", "isLocalFeedId", "a", "c", "d", "f", "e", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {
    @Nullable
    public static final GuildFeedPublishInfo a(@Nullable GuildTaskProgressState guildTaskProgressState, boolean z16) {
        GuildFeedPublishState guildFeedPublishState;
        if (guildTaskProgressState != null) {
            if (kn1.c.c(guildTaskProgressState)) {
                guildFeedPublishState = GuildFeedPublishState.STATE_SUCCESS;
            } else if (kn1.c.a(guildTaskProgressState)) {
                guildFeedPublishState = GuildFeedPublishState.STATE_PUBLISH_FAIL;
            } else if (kn1.c.b(guildTaskProgressState)) {
                guildFeedPublishState = GuildFeedPublishState.STATE_PUBLISHING;
            } else {
                guildFeedPublishState = GuildFeedPublishState.STATE_SUCCESS;
            }
            String mainTaskId = guildTaskProgressState.getMainTaskId();
            Intrinsics.checkNotNullExpressionValue(mainTaskId, "mainTaskId");
            return new GuildFeedPublishInfo(guildFeedPublishState, mainTaskId, z16);
        }
        return null;
    }

    @Nullable
    public static final GuildFeedPublishInfo b(@Nullable ij1.g gVar) {
        GuildFeedPublishState guildFeedPublishState;
        if (gVar != null && gVar.p() != null) {
            GuildTaskProgressState p16 = gVar.p();
            Intrinsics.checkNotNullExpressionValue(p16, "this.taskProgressState");
            if (kn1.c.c(p16)) {
                guildFeedPublishState = GuildFeedPublishState.STATE_SUCCESS;
            } else {
                GuildTaskProgressState p17 = gVar.p();
                Intrinsics.checkNotNullExpressionValue(p17, "this.taskProgressState");
                if (kn1.c.a(p17)) {
                    guildFeedPublishState = GuildFeedPublishState.STATE_PUBLISH_FAIL;
                } else {
                    GuildTaskProgressState p18 = gVar.p();
                    Intrinsics.checkNotNullExpressionValue(p18, "this.taskProgressState");
                    if (kn1.c.b(p18)) {
                        guildFeedPublishState = GuildFeedPublishState.STATE_PUBLISHING;
                    } else {
                        guildFeedPublishState = GuildFeedPublishState.STATE_SUCCESS;
                    }
                }
            }
            String mainTaskId = gVar.p().getMainTaskId();
            Intrinsics.checkNotNullExpressionValue(mainTaskId, "this.taskProgressState.mainTaskId");
            GProStFeed b16 = gVar.b();
            Intrinsics.checkNotNullExpressionValue(b16, "this.sourceData");
            return new GuildFeedPublishInfo(guildFeedPublishState, mainTaskId, com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(b16));
        }
        return null;
    }

    public static final boolean c(@Nullable GuildFeedPublishInfo guildFeedPublishInfo) {
        if (guildFeedPublishInfo == null) {
            return false;
        }
        if (guildFeedPublishInfo.getMainStatus() == GuildFeedPublishState.STATE_SUCCESS && !guildFeedPublishInfo.isLocalFeed()) {
            return false;
        }
        return true;
    }

    public static final boolean d(@Nullable GuildFeedPublishInfo guildFeedPublishInfo) {
        if (guildFeedPublishInfo == null || guildFeedPublishInfo.getMainStatus() != GuildFeedPublishState.STATE_PUBLISH_FAIL || !guildFeedPublishInfo.isLocalFeed()) {
            return true;
        }
        return false;
    }

    public static final boolean e(@Nullable GuildFeedPublishInfo guildFeedPublishInfo) {
        if (guildFeedPublishInfo == null || guildFeedPublishInfo.getMainStatus() != GuildFeedPublishState.STATE_PUBLISH_FAIL || guildFeedPublishInfo.isLocalFeed()) {
            return false;
        }
        return true;
    }

    public static final boolean f(@Nullable GuildFeedPublishInfo guildFeedPublishInfo) {
        if (guildFeedPublishInfo == null) {
            return true;
        }
        if (guildFeedPublishInfo.getMainStatus() == GuildFeedPublishState.STATE_SUCCESS && !guildFeedPublishInfo.isLocalFeed()) {
            return true;
        }
        return false;
    }
}
