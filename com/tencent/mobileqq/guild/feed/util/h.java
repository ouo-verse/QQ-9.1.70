package com.tencent.mobileqq.guild.feed.util;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPAtContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextAtContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextEmojiContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextGroupContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTopicContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTotalPrefer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a\f\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u0000\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\f*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\u000f*\u00020\u000e\u001a\n\u0010\u0013\u001a\u00020\u0012*\u00020\u0011\u001a\n\u0010\u0015\u001a\u00020\u0014*\u00020\u0000\u001a\n\u0010\u0016\u001a\u00020\u0014*\u00020\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "", "preferStatus", "", "preferCount", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "g", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichText;", tl.h.F, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", "e", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStChannelInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPRichTextContent;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPAtContent;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextAtContent;", "a", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "d", "i", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h {
    @NotNull
    public static final GProStRichTextAtContent a(@NotNull IGProMVPAtContent iGProMVPAtContent) {
        Intrinsics.checkNotNullParameter(iGProMVPAtContent, "<this>");
        GProStRichTextAtContent gProStRichTextAtContent = new GProStRichTextAtContent();
        int type = iGProMVPAtContent.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    gProStRichTextAtContent.type = 4;
                    gProStRichTextAtContent.guildInfo.name = iGProMVPAtContent.getText();
                } else {
                    gProStRichTextAtContent.type = 2;
                    gProStRichTextAtContent.roleGroupId.name = iGProMVPAtContent.getRoleGroup().getName();
                }
            } else {
                gProStRichTextAtContent.type = 3;
                gProStRichTextAtContent.guildInfo.name = iGProMVPAtContent.getAtAllText();
            }
        } else {
            gProStRichTextAtContent.type = 1;
            gProStRichTextAtContent.user.nick = iGProMVPAtContent.getUser().getNick();
            gProStRichTextAtContent.user.idd = String.valueOf(iGProMVPAtContent.getUser().getTinyid());
        }
        return gProStRichTextAtContent;
    }

    @NotNull
    public static final GProStChannelInfo b(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        GProStChannelInfo gProStChannelInfo = new GProStChannelInfo();
        GProStChannelSign gProStChannelSign = gProStChannelInfo.sign;
        gProStChannelSign.guildId = iGProContentRecommendFeed.getGuildInfo().getGuildId();
        gProStChannelSign.channelId = iGProContentRecommendFeed.getGuildInfo().getChannelId();
        gProStChannelSign.url = iGProContentRecommendFeed.getGuildInfo().getGuildIcon();
        gProStChannelSign.joinGuildSig = iGProContentRecommendFeed.getGuildInfo().getJoinGuildSig();
        return gProStChannelInfo;
    }

    @Nullable
    public static final GProStRichText c(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        boolean z16;
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        ArrayList<IGProMVPRichTextContent> contents = iGProContentRecommendFeed.getRichText().getContents();
        if (contents != null && !contents.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        GProStRichText gProStRichText = new GProStRichText();
        ArrayList<GProStRichTextContent> arrayList = gProStRichText.contents;
        ArrayList<IGProMVPRichTextContent> contents2 = iGProContentRecommendFeed.getRichText().getContents();
        Intrinsics.checkNotNullExpressionValue(contents2, "richText.contents");
        for (IGProMVPRichTextContent it : contents2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(f(it));
        }
        return gProStRichText;
    }

    @NotNull
    public static final GuildFeedRichMediaData d(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
        GProStImage gProStImage = new GProStImage();
        gProStImage.width = iGProContentRecommendFeed.getImage().getWidth();
        gProStImage.height = iGProContentRecommendFeed.getImage().getHeight();
        gProStImage.picUrl = iGProContentRecommendFeed.getImage().getUrl();
        guildFeedRichMediaData.setImage(gProStImage);
        guildFeedRichMediaData.setType(0);
        return guildFeedRichMediaData;
    }

    @Nullable
    public static final GProStUser e(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        if (iGProContentRecommendFeed.getPoster() == null) {
            return null;
        }
        GProStUser gProStUser = new GProStUser();
        gProStUser.idd = String.valueOf(iGProContentRecommendFeed.getPoster().getTinyId());
        gProStUser.nick = iGProContentRecommendFeed.getPoster().getNick();
        gProStUser.icon.iconUrl = iGProContentRecommendFeed.getPoster().getAvatar();
        return gProStUser;
    }

    @NotNull
    public static final GProStRichTextContent f(@NotNull IGProMVPRichTextContent iGProMVPRichTextContent) {
        Intrinsics.checkNotNullParameter(iGProMVPRichTextContent, "<this>");
        GProStRichTextContent gProStRichTextContent = new GProStRichTextContent();
        int type = iGProMVPRichTextContent.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        if (type != 5) {
                            if (type != 8) {
                                if (type == 9) {
                                    gProStRichTextContent.type = 9;
                                    GProStRichTextGroupContent gProStRichTextGroupContent = gProStRichTextContent.groupContent;
                                    gProStRichTextGroupContent.groupCode = iGProMVPRichTextContent.getGroupContent().getGroupCode();
                                    gProStRichTextGroupContent.groupName = iGProMVPRichTextContent.getGroupContent().getGroupName();
                                    gProStRichTextGroupContent.groupMemberNum = iGProMVPRichTextContent.getGroupContent().getGroupMemberNum();
                                    gProStRichTextGroupContent.groupAvatar = iGProMVPRichTextContent.getGroupContent().getGroupAvatar();
                                    gProStRichTextGroupContent.groupJoinAuth = iGProMVPRichTextContent.getGroupContent().getGroupJoinAuth().toString();
                                }
                            } else {
                                gProStRichTextContent.type = 8;
                                GProStRichTextTopicContent gProStRichTextTopicContent = gProStRichTextContent.topicContent;
                                gProStRichTextTopicContent.topicId = iGProMVPRichTextContent.getTopicContent().getTopicId();
                                gProStRichTextTopicContent.topicName = iGProMVPRichTextContent.getTopicContent().getTopicName();
                                gProStRichTextTopicContent.showStatus = iGProMVPRichTextContent.getTopicContent().getShowStatus();
                                gProStRichTextTopicContent.schema = iGProMVPRichTextContent.getTopicContent().getSchema();
                            }
                        } else {
                            gProStRichTextContent.type = 5;
                            gProStRichTextContent.channelContent.channelInfo.name = iGProMVPRichTextContent.getChannelContent().getChannelName();
                        }
                    } else {
                        gProStRichTextContent.type = 4;
                        GProStRichTextEmojiContent gProStRichTextEmojiContent = gProStRichTextContent.emojiContent;
                        gProStRichTextEmojiContent.idd = iGProMVPRichTextContent.getEmojiContent().getId();
                        gProStRichTextEmojiContent.type = iGProMVPRichTextContent.getEmojiContent().getType();
                    }
                } else {
                    gProStRichTextContent.type = 3;
                    GProStRichTextURLContent gProStRichTextURLContent = gProStRichTextContent.urlContent;
                    gProStRichTextURLContent.displayText = iGProMVPRichTextContent.getUrlContent().getDisplayText();
                    gProStRichTextURLContent.url = iGProMVPRichTextContent.getUrlContent().getUrl();
                    gProStRichTextURLContent.type = iGProMVPRichTextContent.getUrlContent().getType();
                    gProStRichTextURLContent.iconType = iGProMVPRichTextContent.getUrlContent().getIconType();
                }
            } else {
                gProStRichTextContent.type = 2;
                IGProMVPAtContent atContent = iGProMVPRichTextContent.getAtContent();
                Intrinsics.checkNotNullExpressionValue(atContent, "atContent");
                gProStRichTextContent.atContent = a(atContent);
            }
        } else {
            gProStRichTextContent.type = 1;
            gProStRichTextContent.textContent.text = iGProMVPRichTextContent.getTextContent().getText();
        }
        return gProStRichTextContent;
    }

    @NotNull
    public static final GProStFeed g(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed, int i3, long j3) {
        int i16;
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        GProStFeed gProStFeed = new GProStFeed();
        gProStFeed.idd = iGProContentRecommendFeed.getIdd();
        GProStRichText h16 = h(iGProContentRecommendFeed);
        if (h16 != null) {
            gProStFeed.title = h16;
        }
        GProStUser e16 = e(iGProContentRecommendFeed);
        if (e16 != null) {
            gProStFeed.poster = e16;
        }
        GProStRichText c16 = c(iGProContentRecommendFeed);
        if (c16 != null) {
            gProStFeed.contents = c16;
        }
        gProStFeed.createTime = iGProContentRecommendFeed.getCreateTime();
        gProStFeed.channelInfo = b(iGProContentRecommendFeed);
        GProTotalPrefer gProTotalPrefer = gProStFeed.totalPrefer;
        gProTotalPrefer.preferStatus = i3;
        gProTotalPrefer.preferCountWithoutLike = (int) j3;
        gProStFeed.commentCount = (int) iGProContentRecommendFeed.getFeedStat().getTotalCommentCount();
        gProStFeed.share.sharedCount = (int) iGProContentRecommendFeed.getFeedStat().getShareCount();
        if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(iGProContentRecommendFeed.getFeedType())) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        gProStFeed.feedType = i16;
        return gProStFeed;
    }

    @Nullable
    public static final GProStRichText h(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        if (TextUtils.isEmpty(iGProContentRecommendFeed.getTitle())) {
            return null;
        }
        GProStRichText gProStRichText = new GProStRichText();
        ArrayList<GProStRichTextContent> arrayList = new ArrayList<>();
        GProStRichTextContent gProStRichTextContent = new GProStRichTextContent();
        GProStRichTextTextContent gProStRichTextTextContent = new GProStRichTextTextContent();
        gProStRichTextTextContent.text = iGProContentRecommendFeed.getTitle();
        gProStRichTextContent.textContent = gProStRichTextTextContent;
        arrayList.add(gProStRichTextContent);
        gProStRichText.contents = arrayList;
        return gProStRichText;
    }

    @NotNull
    public static final GuildFeedRichMediaData i(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        Object first;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        ArrayList<IGProVideo> videos = iGProContentRecommendFeed.getVideos();
        Intrinsics.checkNotNullExpressionValue(videos, "this.videos");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) videos);
        IGProVideo iGProVideo = (IGProVideo) first;
        GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
        GProStVideo gProStVideo = new GProStVideo();
        gProStVideo.width = iGProVideo.getWidth();
        gProStVideo.height = iGProVideo.getHeight();
        gProStVideo.playUrl = iGProVideo.getPlayUrl();
        gProStVideo.fileSize = iGProVideo.getFileSize();
        gProStVideo.duration = iGProVideo.getDuration();
        gProStVideo.videoPrior = iGProVideo.getPrior();
        gProStVideo.videoRate = iGProVideo.getRate();
        GProStImage gProStImage = gProStVideo.cover;
        IGProImage cover = iGProVideo.getCover();
        gProStImage.width = cover.getWidth();
        gProStImage.height = cover.getHeight();
        gProStImage.picUrl = cover.getUrl();
        ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
        ArrayList<IGProThumbImage> thumbImages = cover.getThumbImages();
        Intrinsics.checkNotNullExpressionValue(thumbImages, "gproCover.thumbImages");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(thumbImages, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (IGProThumbImage iGProThumbImage : thumbImages) {
            GProStImageUrl gProStImageUrl = new GProStImageUrl();
            gProStImageUrl.width = iGProThumbImage.getWidth();
            gProStImageUrl.height = iGProThumbImage.getHeight();
            gProStImageUrl.levelType = iGProThumbImage.getLevel();
            gProStImageUrl.url = iGProThumbImage.getUrl();
            arrayList2.add(gProStImageUrl);
        }
        arrayList.addAll(arrayList2);
        gProStVideo.fileId = iGProVideo.getFileId();
        guildFeedRichMediaData.setVideo(gProStVideo);
        guildFeedRichMediaData.setType(1);
        return guildFeedRichMediaData;
    }
}
