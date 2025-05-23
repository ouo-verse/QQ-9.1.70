package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.feed.util.az;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.winkpublish.MediaInfo;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import com.tencent.mobileqq.winkpublish.result.VideoResult;
import com.tencent.qphone.base.util.QLog;
import ij1.GuildImageResult;
import ij1.GuildMediaInfo;
import ij1.GuildMediaUploadTaskInfo;
import ij1.GuildVideoResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0004\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0007\u001a\f\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\n\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\r\u001a\n\u0010\u0012\u001a\u00020\u0011*\u00020\u0010\u001a\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013\u001a\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018\u001a\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013\"\u0015\u0010 \u001a\u00020\u0000*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0015\u0010$\u001a\u00020!*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006%"}, d2 = {"", "stringType", "", "k", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "Lij1/m;", "d", "Lcom/tencent/mobileqq/winkpublish/MediaInfo;", "Lij1/k;", "b", "Lcom/tencent/mobileqq/winkpublish/result/MediaUploadResult;", "Lij1/l;", "c", "Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "Lij1/j;", "a", "Lcom/tencent/mobileqq/winkpublish/result/VideoResult;", "Lij1/r;", "e", "Lcom/tencent/mobileqq/guild/data/g;", "mediaInfo", "", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "j", "", "originalPic", "Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "g", "Lkotlin/Pair;", tl.h.F, "f", "(Lcom/tencent/mobileqq/winkpublish/TaskInfo;)Ljava/lang/String;", "fileId", "", "i", "(Lij1/m;)J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l {
    @NotNull
    public static final GuildImageResult a(@NotNull ImageResult imageResult) {
        Intrinsics.checkNotNullParameter(imageResult, "<this>");
        return new GuildImageResult(imageResult.getOriginUrl(), imageResult.getOriginWidth(), imageResult.getOriginHeight());
    }

    @NotNull
    public static final GuildMediaInfo b(@NotNull MediaInfo mediaInfo) {
        ij1.l lVar;
        Intrinsics.checkNotNullParameter(mediaInfo, "<this>");
        String mediaPath = mediaInfo.getMediaPath();
        MediaUploadResult uploadResult = mediaInfo.getUploadResult();
        if (uploadResult != null) {
            lVar = c(uploadResult);
        } else {
            lVar = null;
        }
        return new GuildMediaInfo(mediaPath, lVar);
    }

    @Nullable
    public static final ij1.l c(@NotNull MediaUploadResult mediaUploadResult) {
        Intrinsics.checkNotNullParameter(mediaUploadResult, "<this>");
        if (mediaUploadResult instanceof ImageResult) {
            return a((ImageResult) mediaUploadResult);
        }
        if (mediaUploadResult instanceof VideoResult) {
            return e((VideoResult) mediaUploadResult);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        if (r2 != null) goto L27;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final GuildMediaUploadTaskInfo d(@NotNull TaskInfo taskInfo) {
        String coverUrl;
        Object firstOrNull;
        boolean z16;
        Integer intOrNull;
        int i3;
        int i16;
        Object firstOrNull2;
        MediaUploadResult uploadResult;
        Intrinsics.checkNotNullParameter(taskInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<MediaInfo> it = taskInfo.getMediaInfos().iterator();
        while (it.hasNext()) {
            arrayList.add(b(it.next()));
        }
        String f16 = f(taskInfo);
        int state = taskInfo.getState();
        int type = taskInfo.getType();
        String clientKey = taskInfo.getClientKey();
        String traceId = taskInfo.getTraceId();
        int uploadProgress = taskInfo.getUploadProgress();
        List<MediaInfo> mediaInfos = taskInfo.getMediaInfos();
        MediaUploadResult mediaUploadResult = null;
        if (!taskInfo.isVideoTask()) {
            mediaInfos = null;
        }
        if (mediaInfos != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mediaInfos);
            MediaInfo mediaInfo = (MediaInfo) firstOrNull2;
            if (mediaInfo != null && (uploadResult = mediaInfo.getUploadResult()) != null) {
                if (uploadResult instanceof VideoResult) {
                    mediaUploadResult = uploadResult;
                }
                VideoResult videoResult = (VideoResult) mediaUploadResult;
                if (videoResult != null) {
                    ImageResult coverResult = videoResult.getCoverResult();
                    if (coverResult != null) {
                        coverUrl = coverResult.getOriginUrl();
                    }
                }
            }
        }
        coverUrl = taskInfo.getCoverUrl();
        String str = coverUrl;
        int businessType = taskInfo.getBusinessType();
        String feedId = taskInfo.getFeedId();
        long feedTime = taskInfo.getFeedTime();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        GuildMediaInfo guildMediaInfo = (GuildMediaInfo) firstOrNull;
        if (taskInfo.getErrCode().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(taskInfo.getErrCode());
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = -1;
            }
            i16 = i3;
        } else {
            i16 = 0;
        }
        return new GuildMediaUploadTaskInfo(f16, state, type, clientKey, traceId, uploadProgress, str, businessType, feedId, feedTime, guildMediaInfo, i16, taskInfo.getErrMsg(), taskInfo.getTransParams(), 0L, 0L, taskInfo.getTaskId(), 0L, null, false, false, null, 4112384, null);
    }

    @NotNull
    public static final GuildVideoResult e(@NotNull VideoResult videoResult) {
        GuildImageResult guildImageResult;
        Intrinsics.checkNotNullParameter(videoResult, "<this>");
        String videoId = videoResult.getVideoId();
        ImageResult coverResult = videoResult.getCoverResult();
        if (coverResult != null) {
            guildImageResult = a(coverResult);
        } else {
            guildImageResult = null;
        }
        return new GuildVideoResult(videoId, guildImageResult);
    }

    @NotNull
    public static final String f(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "<this>");
        return taskInfo.getClientKey();
    }

    @NotNull
    public static final List<ImageParams> g(@NotNull com.tencent.mobileqq.guild.data.g mediaInfo, boolean z16) {
        int i3;
        List<ImageParams> listOf;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Pair<Integer, Integer> h16 = h(mediaInfo);
        int intValue = h16.component1().intValue();
        int intValue2 = h16.component2().intValue();
        String path = mediaInfo.getPath();
        if (z16) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        int i16 = i3;
        long fileSize = mediaInfo.getFileSize();
        int mediaOriginWidth = mediaInfo.getMediaOriginWidth();
        int mediaOriginHeight = mediaInfo.getMediaOriginHeight();
        long length = new File(mediaInfo.getPath()).length();
        String mimeType = mediaInfo.getMimeType();
        if (mimeType == null) {
            mimeType = "";
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ImageParams(path, i16, intValue, intValue2, fileSize, mediaOriginWidth, mediaOriginHeight, length, mimeType, null, 512, null));
        return listOf;
    }

    @NotNull
    public static final Pair<Integer, Integer> h(@NotNull com.tencent.mobileqq.guild.data.g mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaInfo.getMediaWidth() != 0 && mediaInfo.getMediaHeight() != 0) {
            return new Pair<>(Integer.valueOf(mediaInfo.getMediaWidth()), Integer.valueOf(mediaInfo.getMediaHeight()));
        }
        return az.f223861a.f(mediaInfo.getPath());
    }

    public static final long i(@NotNull GuildMediaUploadTaskInfo guildMediaUploadTaskInfo) {
        Intrinsics.checkNotNullParameter(guildMediaUploadTaskInfo, "<this>");
        return guildMediaUploadTaskInfo.getInternalId();
    }

    @NotNull
    public static final List<VideoParams> j(@NotNull com.tencent.mobileqq.guild.data.g mediaInfo) {
        boolean z16;
        Object m476constructorimpl;
        List<VideoParams> listOf;
        List<VideoParams> emptyList;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        az azVar = az.f223861a;
        String e16 = azVar.e("GuildUploadBaseTask", mediaInfo);
        if (e16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("GuildUploadBaseTask", 1, "[getVideoList]:  videoCover still empty");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(azVar.f(e16));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        Pair pair = (Pair) m476constructorimpl;
        if (pair == null) {
            pair = TuplesKt.to(-1, -1);
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new VideoParams(mediaInfo.getPath(), mediaInfo.getMediaWidth(), mediaInfo.getMediaHeight(), mediaInfo.getFileSize(), mediaInfo.getMediaOriginBitrate(), e16, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue(), mediaInfo.getMDuration(), mediaInfo.getRotation(), mediaInfo.getMimeType(), false, false, null, null, null, 63488, null));
        return listOf;
    }

    public static final int k(@Nullable String str) {
        if (Intrinsics.areEqual(str, "video")) {
            return 2;
        }
        if (Intrinsics.areEqual(str, "pic")) {
            return 1;
        }
        return 0;
    }
}
