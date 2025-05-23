package com.tencent.biz.qqcircle.helpers;

import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.richframework.video.player.process.QFSPlayerOptionsExchangeUrlProcess;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.libra.request.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0006J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/QCirclePublicAccountHelper;", "", "()V", "exchangeUrl", "", "fileId", "", "playUrl", "duration", "", "isQUIC", "", "getImageCacheStatusCode", "", "url", "hasLocalCache", "vid", "loadImage", "", "loadVideo", "needExchangeUrl", "removeHistoryPreloadRecord", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QCirclePublicAccountHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void exchangeUrl$lambda$4(ArrayList resultList, CountDownLatch countDownLatch, String fileId, String playUrl, long j3, boolean z16, RFWPlayerOptions rFWPlayerOptions, boolean z17) {
        String str;
        Intrinsics.checkNotNullParameter(resultList, "$resultList");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        Intrinsics.checkNotNullParameter(fileId, "$fileId");
        Intrinsics.checkNotNullParameter(playUrl, "$playUrl");
        String str2 = null;
        if (rFWPlayerOptions != null) {
            str = rFWPlayerOptions.getFileId();
        } else {
            str = null;
        }
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "options?.fileId ?: fileId");
            fileId = str;
        }
        resultList.add(fileId);
        if (rFWPlayerOptions != null) {
            str2 = rFWPlayerOptions.getRealPlayUrl();
        }
        if (str2 != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "options?.realPlayUrl ?: playUrl");
            playUrl = str2;
        }
        resultList.add(playUrl);
        resultList.add(Long.valueOf(j3));
        resultList.add(Boolean.valueOf(z16));
        countDownLatch.countDown();
    }

    @WorkerThread
    @NotNull
    public final List<Object> exchangeUrl(@NotNull final String fileId, @NotNull final String playUrl, final long duration, final boolean isQUIC) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(playUrl, "playUrl");
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = new FeedCloudMeta$StVideo();
        feedCloudMeta$StVideo.fileId.set(fileId);
        feedCloudMeta$StVideo.playUrl.set(playUrl);
        feedCloudMeta$StVideo.duration.set((int) duration);
        feedCloudMeta$StVideo.isQuic.set(isQUIC ? 1 : 0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ArrayList arrayList = new ArrayList();
        RFWPlayerOptions obtain = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        obtain.setStVideo(gb0.b.k(feedCloudMeta$StVideo));
        obtain.setPlayUrl(playUrl);
        obtain.setFileId(fileId);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(QFSPlayerOptionsExchangeUrlProcess.f92033a);
        RFWPlayerOptionsProcessManager.g().startProcess(linkedList, obtain, new RFWPlayerOptionsProcessManager.IProcessCallBack() { // from class: com.tencent.biz.qqcircle.helpers.c
            @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
            public final void onFinish(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
                QCirclePublicAccountHelper.exchangeUrl$lambda$4(arrayList, countDownLatch, fileId, playUrl, duration, isQUIC, rFWPlayerOptions, z16);
            }
        });
        countDownLatch.await(10L, TimeUnit.SECONDS);
        return arrayList;
    }

    public final int getImageCacheStatusCode(@NotNull String url) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        String picLocalPath = QCircleFeedPicLoader.g().getPicLocalPath(Option.obtain().setUrl(url));
        if (picLocalPath != null && picLocalPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !new File(picLocalPath).exists()) {
            return 1;
        }
        return 2;
    }

    public final boolean hasLocalCache(@NotNull String playUrl, @NotNull String vid) {
        Intrinsics.checkNotNullParameter(playUrl, "playUrl");
        Intrinsics.checkNotNullParameter(vid, "vid");
        return RFWVideoUtils.checkCacheExist(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), playUrl, vid);
    }

    public final void loadImage(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(url));
    }

    public final void loadVideo(@NotNull String fileId, @NotNull String playUrl, long duration, boolean isQUIC) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(playUrl, "playUrl");
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = new FeedCloudMeta$StVideo();
        feedCloudMeta$StVideo.fileId.set(fileId);
        feedCloudMeta$StVideo.playUrl.set(playUrl);
        feedCloudMeta$StVideo.duration.set((int) duration);
        feedCloudMeta$StVideo.isQuic.set(isQUIC ? 1 : 0);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.video.set(feedCloudMeta$StVideo);
        RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).preloadVideo(gb0.b.n(feedCloudMeta$StFeed, false), QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE);
    }

    public final boolean needExchangeUrl(@NotNull String playUrl) {
        Intrinsics.checkNotNullParameter(playUrl, "playUrl");
        return RFWVideoUtils.checkVideoUrlIsNeedChange(playUrl);
    }

    public final void removeHistoryPreloadRecord(@NotNull String playUrl, @NotNull String vid) {
        Intrinsics.checkNotNullParameter(playUrl, "playUrl");
        Intrinsics.checkNotNullParameter(vid, "vid");
        RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).removeHistoryPreloadRecord(vid);
    }
}
