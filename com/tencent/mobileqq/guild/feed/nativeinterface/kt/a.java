package com.tencent.mobileqq.guild.feed.nativeinterface.kt;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.guild.api.media.album.c;
import com.tencent.mobileqq.guild.feed.util.GuildFeedMediaUtils;
import com.tencent.mobileqq.guild.feed.util.bc;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedMetaData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTopicContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTotalPrefer;
import fm1.e;
import fm1.i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pm1.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u001a\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u001a,\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003\u001a\"\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003\u001a\f\u0010\u0014\u001a\u00020\u0013*\u00020\u0000H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0000*\u00020\u0000H\u0002\u001a\u001c\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002\u001a\n\u0010\u001d\u001a\u00020\u0003*\u00020\u0000\u001a\u0012\u0010\u001f\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000\u001a\n\u0010 \u001a\u00020\u0001*\u00020\u0019\u001a\f\u0010!\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\f\u0010#\u001a\u00020\u0003*\u00020\"H\u0002\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "", "j", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "taskPublishTimeNs", h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSimpleProfile;", "simpleProfile", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", PhotoCategorySummaryInfo.AVATAR_URL, "channelName", "f", "guildId", "channelId", "tid", "g", "", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "jsonFeed", "isShortFeed", "o", "Lorg/json/JSONObject;", "thirdBarObj", "", "p", "l", "stFeed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", DomainData.DOMAIN_NAME, "Lfm1/i;", "i", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(GProStFeed gProStFeed) {
        Iterator<GProStRichTextContent> it = gProStFeed.contents.contents.iterator();
        while (it.hasNext()) {
            GProStRichTextContent next = it.next();
            if (next.type == 3) {
                switch (next.urlContent.type) {
                    case 1:
                        return 5;
                    case 2:
                        return 6;
                    case 3:
                        return 7;
                    case 6:
                        return 8;
                    case 7:
                    case 8:
                    case 9:
                        return 9;
                }
            }
        }
        if (gProStFeed.images.isEmpty() && gProStFeed.videos.isEmpty()) {
            return 1;
        }
        if (gProStFeed.images.size() == 1 && gProStFeed.videos.isEmpty()) {
            return 2;
        }
        if (gProStFeed.images.isEmpty() && gProStFeed.videos.size() == 1) {
            return 3;
        }
        return 4;
    }

    @NotNull
    public static final GProStFeed f(@NotNull GProStFeed gProStFeed, @NotNull IGProSimpleProfile simpleProfile, @Nullable IGProGuildRoleInfo iGProGuildRoleInfo, @NotNull String avatarUrl, @NotNull String channelName) {
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        Intrinsics.checkNotNullParameter(simpleProfile, "simpleProfile");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        GProStUser gProStUser = gProStFeed.poster;
        Intrinsics.checkNotNullExpressionValue(gProStUser, "this.poster");
        b.e(gProStUser, simpleProfile, iGProGuildRoleInfo, avatarUrl);
        gProStFeed.channelInfo.name = channelName;
        return gProStFeed;
    }

    @NotNull
    public static final GProStFeed g(@NotNull GProStFeed gProStFeed, @NotNull String guildId, @NotNull String channelId, @NotNull String tid) {
        String str;
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tid, "tid");
        GProStUser gProStUser = gProStFeed.poster;
        Intrinsics.checkNotNullExpressionValue(gProStUser, "this.poster");
        b.d(gProStUser, guildId, channelId, tid);
        GProStChannelInfo gProStChannelInfo = gProStFeed.channelInfo;
        IGProChannelInfo B = ch.B(channelId);
        if (B == null || (str = B.getChannelName()) == null) {
            str = "";
        }
        gProStChannelInfo.name = str;
        return gProStFeed;
    }

    @NotNull
    public static final GProStFeed h(@NotNull GProStFeed gProStFeed, @NotNull String taskId, long j3) {
        boolean z16;
        boolean z17;
        long j16;
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        String str = gProStFeed.idd;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "local_feedId_" + taskId;
        }
        gProStFeed.idd = str;
        Long valueOf = Long.valueOf(gProStFeed.createTimeNs);
        if (valueOf.longValue() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!Boolean.valueOf(z17).booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            j16 = valueOf.longValue();
        } else {
            j16 = j3;
        }
        gProStFeed.createTimeNs = j16;
        long j17 = 1000;
        gProStFeed.createTime = ((j16 / j17) / j17) / j17;
        gProStFeed.meta.lastModifiedTime = ((j3 / j17) / j17) / j17;
        gProStFeed.clientTaskId = taskId;
        if (bc.i(taskId)) {
            GProTotalPrefer gProTotalPrefer = gProStFeed.totalPrefer;
            gProTotalPrefer.preferStatus = 1;
            gProTotalPrefer.preferCountWithoutLike = 1;
        } else {
            GProTotalPrefer gProTotalPrefer2 = gProStFeed.totalPrefer;
            gProTotalPrefer2.preferStatus = 2;
            gProTotalPrefer2.preferCountWithoutLike = 0;
        }
        return gProStFeed;
    }

    private static final String i(i iVar) {
        if (iVar instanceof e) {
            return ((e) iVar).getSvrUrl();
        }
        return n(iVar.getVideoPlayUrl());
    }

    public static final boolean j(@NotNull GProStFeed gProStFeed) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        String idd = gProStFeed.idd;
        Intrinsics.checkNotNullExpressionValue(idd, "idd");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(idd, "local_feedId", false, 2, null);
        return startsWith$default;
    }

    public static final boolean k(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (jSONObject.optInt(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, 1) == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String l(@NotNull GProStFeed gProStFeed) {
        Long l3;
        Integer num;
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        int hashCode = gProStFeed.hashCode();
        String str = gProStFeed.idd;
        long j3 = gProStFeed.createTimeNs;
        GProFeedMetaData gProFeedMetaData = gProStFeed.meta;
        Integer num2 = null;
        if (gProFeedMetaData != null) {
            l3 = Long.valueOf(gProFeedMetaData.lastModifiedTime);
        } else {
            l3 = null;
        }
        int size = gProStFeed.contents.contents.size();
        String str2 = gProStFeed.clientTaskId;
        ArrayList<GProStImage> arrayList = gProStFeed.images;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        ArrayList<GProStVideo> arrayList2 = gProStFeed.videos;
        if (arrayList2 != null) {
            num2 = Integer.valueOf(arrayList2.size());
        }
        return "GProStFeed(hashCode=" + hashCode + " id=" + str + ", createTimeNs=" + j3 + ", lastModifyTime=" + l3 + " contents=" + size + " clientTaskId=" + str2 + ", images=" + num + ", videos=" + num2 + ")";
    }

    public static final void m(@NotNull GProStFeed gProStFeed, @NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        gProStFeed.contents = stFeed.contents;
        gProStFeed.videos = stFeed.videos;
        gProStFeed.images = stFeed.images;
        gProStFeed.title = stFeed.title;
        gProStFeed.contentWithStyle = stFeed.contentWithStyle;
        gProStFeed.patternInfo = stFeed.patternInfo;
        gProStFeed.summary = stFeed.summary;
        gProStFeed.clientTaskId = stFeed.clientTaskId;
        gProStFeed.meta.lastModifiedTime = stFeed.meta.lastModifiedTime;
    }

    @NotNull
    public static final String n(@NotNull String str) {
        String removePrefix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        removePrefix = StringsKt__StringsKt.removePrefix(str, (CharSequence) "https://qun.qq.com/guildFeedPublish/localMedia");
        return removePrefix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
    
        if (r6 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final GProStFeed o(GProStFeed gProStFeed, String str, boolean z16) {
        boolean z17;
        boolean startsWith$default;
        String str2;
        String picUrl;
        try {
            if (!z16) {
                ArrayList<GProStImage> images = gProStFeed.images;
                Intrinsics.checkNotNullExpressionValue(images, "images");
                for (GProStImage gProStImage : images) {
                    String str3 = gProStImage.picUrl;
                    Intrinsics.checkNotNullExpressionValue(str3, "it.picUrl");
                    gProStImage.picUrl = n(str3);
                }
                ArrayList<GProStVideo> videos = gProStFeed.videos;
                Intrinsics.checkNotNullExpressionValue(videos, "videos");
                for (GProStVideo gProStVideo : videos) {
                    String str4 = gProStVideo.playUrl;
                    Intrinsics.checkNotNullExpressionValue(str4, "it.playUrl");
                    gProStVideo.playUrl = n(str4);
                    GProStImage gProStImage2 = gProStVideo.cover;
                    if (gProStImage2 != null) {
                        if (gProStImage2 != null && (picUrl = gProStImage2.picUrl) != null) {
                            Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
                            str2 = n(picUrl);
                        }
                        str2 = "";
                        gProStImage2.picUrl = str2;
                    }
                }
            } else {
                om1.b bVar = new om1.b();
                b.a.a(new rm1.b(), new JSONObject(str), bVar, null, 4, null);
                gProStFeed.images.clear();
                gProStFeed.videos.clear();
                int i3 = 0;
                for (Object obj : bVar.b()) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    i iVar = (i) obj;
                    if (iVar.getType() == c.b()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        ArrayList<GProStVideo> arrayList = gProStFeed.videos;
                        GProStVideo gProStVideo2 = new GProStVideo();
                        gProStVideo2.fileId = iVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String();
                        gProStVideo2.duration = (int) iVar.getVideoDuration();
                        gProStVideo2.width = iVar.getWidth();
                        gProStVideo2.height = iVar.getHeight();
                        gProStVideo2.playUrl = i(iVar);
                        GProStImage gProStImage3 = new GProStImage();
                        String imageUrl = iVar.getImageUrl();
                        String str5 = null;
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(imageUrl, "http", false, 2, null);
                        if (!startsWith$default) {
                            imageUrl = GuildFeedMediaUtils.c(gProStVideo2.playUrl);
                        }
                        gProStImage3.picUrl = imageUrl;
                        if (imageUrl == null) {
                            imageUrl = "";
                        }
                        gProStImage3.picUrl = imageUrl;
                        gProStImage3.width = iVar.getWidth();
                        gProStImage3.height = iVar.getHeight();
                        gProStVideo2.cover = gProStImage3;
                        gProStVideo2.displayIndex = i3;
                        Logger.a d16 = Logger.f235387a.d();
                        String str6 = gProStVideo2.playUrl;
                        GProStImage gProStImage4 = gProStVideo2.cover;
                        if (gProStImage4 != null) {
                            str5 = gProStImage4.picUrl;
                        }
                        d16.d("FakeStFeedEx", 1, "i=" + i3 + ", video: url: " + str6 + ", cover: " + str5);
                        arrayList.add(gProStVideo2);
                    } else {
                        ArrayList<GProStImage> arrayList2 = gProStFeed.images;
                        GProStImage gProStImage5 = new GProStImage();
                        gProStImage5.picUrl = n(iVar.getVideoPlayUrl());
                        gProStImage5.width = iVar.getWidth();
                        gProStImage5.height = iVar.getHeight();
                        gProStImage5.picId = iVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String();
                        gProStImage5.isGif = iVar.getIsGif();
                        gProStImage5.displayIndex = i3;
                        Logger.f235387a.d().d("FakeStFeedEx", 1, "i=" + i3 + ", image: url: " + gProStImage5.picUrl);
                        arrayList2.add(gProStImage5);
                    }
                    i3 = i16;
                }
            }
        } catch (Exception e16) {
            QLog.e("FakeStFeedEx", 1, "restore media content failed", e16);
        }
        return gProStFeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GProStFeed gProStFeed, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject.optString("button_scheme");
        GProThirdBar gProThirdBar = new GProThirdBar();
        gProThirdBar.f359315id = optString;
        gProThirdBar.buttonScheme = optString2;
        gProStFeed.thirdBar = gProThirdBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GProStFeed q(GProStFeed gProStFeed) {
        ArrayList<GProStRichTextContent> arrayList = gProStFeed.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "contents.contents");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            GProStRichTextTopicContent topicContent = ((GProStRichTextContent) it.next()).topicContent;
            if (topicContent != null) {
                Intrinsics.checkNotNullExpressionValue(topicContent, "topicContent");
                if (topicContent.showStatus == 0) {
                    topicContent.showStatus = 1;
                }
            }
        }
        return gProStFeed;
    }
}
