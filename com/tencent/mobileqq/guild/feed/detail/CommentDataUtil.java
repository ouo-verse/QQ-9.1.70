package com.tencent.mobileqq.guild.feed.detail;

import com.google.gson.Gson;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.detail.event.GuildDoCommentEvent;
import com.tencent.mobileqq.guild.feed.detail.task.CommentResult;
import com.tencent.mobileqq.guild.feed.util.ag;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bi;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import ij1.GuildImageResult;
import ij1.GuildMediaInfo;
import ij1.GuildMediaUploadTaskInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\"\u0010\b\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J0\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J8\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0012j\b\u0012\u0004\u0012\u00020\u0017`\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J\u001c\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J\u0010\u0010\u001f\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u001eH\u0007J\f\u0010 \u001a\u00020\u0010*\u00020\u0001H\u0007\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/CommentDataUtil;", "", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "", "Lij1/m;", "taskList", "", "mOriginalPic", "g", "Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "event", "richText", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "f", "", "text", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "b", "Lcom/tencent/mobileqq/guild/feed/detail/task/CommentResult;", "d", "", "retCode", "a", "", "i", tl.h.F, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CommentDataUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CommentDataUtil f218438a = new CommentDataUtil();

    CommentDataUtil() {
    }

    @JvmStatic
    @NotNull
    public static final CommentResult a(@NotNull CommentResult commentResult, long j3, @NotNull GuildFeedRichContentResultBean richText) {
        Intrinsics.checkNotNullParameter(commentResult, "<this>");
        Intrinsics.checkNotNullParameter(richText, "richText");
        commentResult.setStatus(3);
        commentResult.setResult(j3);
        commentResult.setJsonContent(richText);
        return commentResult;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<GProStImage> b(@NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean mOriginalPic) {
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        ArrayList<GProStImage> arrayList = new ArrayList<>();
        for (LocalMediaInfo localMediaInfo : localMediaInfos) {
            GProStImage gProStImage = new GProStImage();
            gProStImage.picUrl = localMediaInfo.path;
            gProStImage.width = localMediaInfo.mediaWidth;
            gProStImage.height = localMediaInfo.mediaHeight;
            gProStImage.isOrig = mOriginalPic;
            gProStImage.origSize = (int) new File(localMediaInfo.path).length();
            gProStImage.isGif = Intrinsics.areEqual(localMediaInfo.mMimeType, "image/gif");
            arrayList.add(gProStImage);
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedRichContentResultBean c(@NotNull String text, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean mOriginalPic) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(localMediaInfos, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (LocalMediaInfo localMediaInfo : localMediaInfos) {
            GuildFeedRichContentResultBean.ImageContent imageContent = new GuildFeedRichContentResultBean.ImageContent();
            imageContent.picUrl = localMediaInfo.path;
            imageContent.width = localMediaInfo.mediaWidth;
            imageContent.height = localMediaInfo.mediaHeight;
            imageContent.isOrig = mOriginalPic;
            imageContent.origSize = new File(localMediaInfo.path).length();
            imageContent.isGif = Intrinsics.areEqual(localMediaInfo.mMimeType, "image/gif");
            arrayList.add(imageContent);
        }
        GuildFeedRichContentResultBean g16 = ho1.c.g(text, arrayList);
        Intrinsics.checkNotNullExpressionValue(g16, "toGuildRichText(\n       \u2026         }\n            })");
        return g16;
    }

    @JvmStatic
    @NotNull
    public static final CommentResult d(@NotNull GuildDoCommentEvent event, @NotNull GuildFeedRichContentResultBean richText) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(richText, "richText");
        CommentResult commentResult = new CommentResult();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        commentResult.setUuid(uuid);
        commentResult.setType(1);
        commentResult.setStatus(1);
        commentResult.setJsonContent(richText);
        commentResult.setCreateTime(event.getCreateTime());
        if (!event.getIsComment()) {
            commentResult.setCommentID(event.getCommentID());
            commentResult.setReplyTargetID(event.getReplyTargetID());
            commentResult.setType(2);
        }
        return commentResult;
    }

    @JvmStatic
    @NotNull
    public static final GProStDoCommentReq e(@NotNull GuildDoCommentEvent event, @NotNull GuildFeedRichContentResultBean richText) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(richText, "richText");
        String json = new Gson().toJson(richText);
        QLog.d("CommentDataUtil", 1, "getStComment toJson result:" + json);
        GProStDoCommentReq gProStDoCommentReq = new GProStDoCommentReq();
        gProStDoCommentReq.jsonComment = json;
        gProStDoCommentReq.commentType = 1;
        GProStFeed gProStFeed = gProStDoCommentReq.feed;
        gProStFeed.idd = event.getFeedId();
        gProStFeed.createTime = event.getFeedCreateTime();
        gProStFeed.poster.idd = event.getPosterId();
        gProStFeed.channelInfo.sign.guildId = Long.parseLong(event.getGuildId());
        gProStFeed.channelInfo.sign.channelId = Long.parseLong(event.getChannelId());
        GProStComment gProStComment = gProStDoCommentReq.comment;
        gProStComment.postUser.idd = ax.u();
        gProStComment.createTime = event.getCreateTime();
        gProStDoCommentReq.from = 0;
        if (event.getBusinessType() == 7) {
            gProStDoCommentReq.needSyncGroup = bi.a();
        }
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        com.tencent.mobileqq.guild.feed.nativepublish.utils.k.a(event.getMReportMap(), gProStCommonExt);
        com.tencent.mobileqq.guild.feed.nativepublish.utils.k.b(gProStCommonExt);
        gProStDoCommentReq.extInfo = gProStCommonExt;
        QLog.d("CommentDataUtil", 1, "getStComment, need_sync_group = " + gProStDoCommentReq.needSyncGroup + ", from = " + gProStDoCommentReq.from);
        return gProStDoCommentReq;
    }

    @JvmStatic
    @NotNull
    public static final GProStDoReplyReq f(@NotNull GuildDoCommentEvent event, @NotNull GuildFeedRichContentResultBean richText) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(richText, "richText");
        String json = new Gson().toJson(richText);
        QLog.d("CommentDataUtil", 1, "getStComment toJson result:" + json);
        GProStDoReplyReq gProStDoReplyReq = new GProStDoReplyReq();
        gProStDoReplyReq.replyType = 1;
        GProStReply gProStReply = gProStDoReplyReq.reply;
        gProStReply.postUser.idd = ax.u();
        gProStReply.createTime = event.getCreateTime();
        gProStReply.targetUser.idd = event.getReplyTargetUserID();
        GProStComment gProStComment = gProStDoReplyReq.comment;
        gProStComment.idd = event.getCommentID();
        gProStComment.createTime = event.getCommentCreateTime();
        gProStComment.postUser.idd = event.getCommentPosterID();
        GProStFeed gProStFeed = gProStDoReplyReq.feed;
        gProStFeed.idd = event.getFeedId();
        gProStFeed.createTime = event.getFeedCreateTime();
        gProStFeed.poster.idd = event.getPosterId();
        gProStFeed.channelInfo.sign.guildId = Long.parseLong(event.getGuildId());
        gProStFeed.channelInfo.sign.channelId = Long.parseLong(event.getChannelId());
        if (event.getBusinessType() == 7) {
            gProStDoReplyReq.needSyncGroup = bi.a();
        }
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        com.tencent.mobileqq.guild.feed.nativepublish.utils.k.a(event.getMReportMap(), gProStCommonExt);
        com.tencent.mobileqq.guild.feed.nativepublish.utils.k.b(gProStCommonExt);
        gProStDoReplyReq.extInfo = gProStCommonExt;
        QLog.d("CommentDataUtil", 1, "getStReply, need_sync_group = " + gProStDoReplyReq.needSyncGroup + ", from = " + gProStDoReplyReq.from);
        gProStDoReplyReq.jsonReply = json;
        return gProStDoReplyReq;
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedRichContentResultBean g(@NotNull GuildFeedRichContentResultBean guildFeedRichContentResultBean, @NotNull Collection<GuildMediaUploadTaskInfo> taskList, boolean z16) {
        List zip;
        int collectionSizeOrDefault;
        ij1.l lVar;
        boolean z17;
        Intrinsics.checkNotNullParameter(guildFeedRichContentResultBean, "<this>");
        Intrinsics.checkNotNullParameter(taskList, "taskList");
        List<GuildFeedRichContentResultBean.ImageContent> images = guildFeedRichContentResultBean.images;
        Intrinsics.checkNotNullExpressionValue(images, "images");
        zip = CollectionsKt___CollectionsKt.zip(images, taskList);
        List<Pair> list = zip;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Pair pair : list) {
            GuildFeedRichContentResultBean.ImageContent imageContent = (GuildFeedRichContentResultBean.ImageContent) pair.component1();
            GuildMediaUploadTaskInfo guildMediaUploadTaskInfo = (GuildMediaUploadTaskInfo) pair.component2();
            GuildMediaInfo mediaInfo = guildMediaUploadTaskInfo.getMediaInfo();
            String str = null;
            if (mediaInfo != null) {
                lVar = mediaInfo.getUploadResult();
            } else {
                lVar = null;
            }
            if (lVar instanceof GuildImageResult) {
            }
            String url = guildMediaUploadTaskInfo.getUrl();
            imageContent.picUrl = url;
            imageContent.isOrig = z16;
            if (imageContent.isGif) {
                imageContent.picUrl = ag.b(url);
            }
            if (mediaInfo != null) {
                str = mediaInfo.getMediaPath();
            }
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                imageContent.origSize = guildMediaUploadTaskInfo.getOriginSize();
                imageContent.imageMD5 = guildMediaUploadTaskInfo.getMd5();
            }
            arrayList.add(imageContent);
        }
        guildFeedRichContentResultBean.images = arrayList;
        return guildFeedRichContentResultBean;
    }

    @JvmStatic
    @NotNull
    public static final String h(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return "[" + new Gson().toJson(obj) + "]";
    }

    @JvmStatic
    @NotNull
    public static final String i(@NotNull List<?> list) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", "[", "]", 0, null, new Function1<Object, CharSequence>() { // from class: com.tencent.mobileqq.guild.feed.detail.CommentDataUtil$toJsonArray$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@Nullable Object obj) {
                    String json = new Gson().toJson(obj);
                    Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(it)");
                    return json;
                }
            }, 24, null);
            return joinToString$default;
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }
}
