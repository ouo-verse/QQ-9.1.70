package com.tencent.mobileqq.guild.feed.api;

import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001H&J\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMediaUploadServiceApi;", "", "Lmqq/app/api/IRuntimeService;", "", "fileId", "Lcom/tencent/mobileqq/guild/data/g;", "mediaInfo", "", "createUploadMediaTask", "pauseUploadMediaTask", "resumeUploadMediaTask", "removeUploadMediaTask", "localMediaInfo", "extraInfo", "restoreUploadMediaTask", "", "fileIdSet", "", "Lcom/tencent/mobileqq/guild/data/o;", "batchGetUploadMediaTaskInfoList", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface IGuildFeedMediaUploadServiceApi extends IRuntimeService {
    @NotNull
    Map<String, o> batchGetUploadMediaTaskInfoList(@NotNull Set<String> fileIdSet);

    boolean createUploadMediaTask(@NotNull String fileId, @NotNull com.tencent.mobileqq.guild.data.g mediaInfo);

    boolean pauseUploadMediaTask(@NotNull String fileId);

    boolean removeUploadMediaTask(@NotNull String fileId);

    boolean restoreUploadMediaTask(@NotNull String fileId, @NotNull com.tencent.mobileqq.guild.data.g localMediaInfo, @Nullable Object extraInfo);

    boolean resumeUploadMediaTask(@NotNull String fileId);

    /* synthetic */ void subscribeTaskChangeListener(@NotNull f fVar, @NotNull String str);

    /* synthetic */ void unsubscribeAllTaskChangeListener(@NotNull f fVar);

    /* synthetic */ void unsubscribeTaskChangeListener(@NotNull f fVar, @NotNull String str);
}
