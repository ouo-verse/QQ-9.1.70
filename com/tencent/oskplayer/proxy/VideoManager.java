package com.tencent.oskplayer.proxy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.DefaultBandwidthMeter;
import com.tencent.oskplayer.datasource.DownloadListener;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.datasource.VideoDownloadListener;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.QLog;
import com.tencent.oskplayer.util.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoManager {
    private static final String TAG = "VideoManager";
    private static volatile VideoManager instance;
    public static volatile int sElapsedMs;
    public static volatile long sEstimateBitrate;
    private VideoProxy proxy = new VideoProxy();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class IsStreamInfoCachedCallable implements Callable<Boolean> {
        private SegmentVideoInfo.StreamInfo mStreamInfo;

        public IsStreamInfoCachedCallable(SegmentVideoInfo.StreamInfo streamInfo) {
            this.mStreamInfo = streamInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            Iterator<SegmentVideoInfo.SegmentInfo> it = this.mStreamInfo.segmentInfos.iterator();
            while (it.hasNext()) {
                if (!VideoManager.this.proxy.isCached(it.next().url)) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }

    VideoManager() {
    }

    private void cancelAsync(String str, boolean z16) {
        this.proxy.cancelAsync(str, z16);
    }

    public static VideoManager getInstance() throws IllegalStateException {
        if (instance != null) {
            return instance;
        }
        throw new IllegalStateException("Video SDK has not been initialized! Call init() first!");
    }

    public static boolean hasInit() {
        if (instance != null) {
            return true;
        }
        return false;
    }

    public static void init(Context context) {
        if (instance == null) {
            synchronized (VideoManager.class) {
                if (instance == null) {
                    instance = new VideoManager();
                }
            }
        }
    }

    public void addCacheReadListener(String str, VideoProxy.CacheReadListener cacheReadListener) {
        this.proxy.addCacheReadListener(str, cacheReadListener);
    }

    public void addHttpErrorListener(String str, VideoProxy.HttpErrorListener httpErrorListener) {
        this.proxy.addHttpErrorListener(str, httpErrorListener);
    }

    public void addHttpRetryLogic(String str, HttpRetryLogic httpRetryLogic) {
        this.proxy.addHttpRetryLogic(str, httpRetryLogic);
    }

    public void addUuidErrorListener(String str, VideoProxy.HttpErrorListener httpErrorListener) {
        this.proxy.addUuidErrorListener(str, httpErrorListener);
    }

    public void cancelAllAsync() {
        this.proxy.cancelAllAsync();
    }

    public void cancelAllPreloadAsync() {
        this.proxy.cancelAllPreloadAsync(true);
    }

    public void cancelPreloadMedia() {
        this.proxy.cancelAllPreloadAsync(true);
    }

    public void clearCache() {
        try {
            this.proxy.clearCache();
        } catch (Exception e16) {
            PlayerUtils.log(6, TAG, "failed clear cache. msg=" + e16.getMessage());
        }
    }

    public void clearCacheByInfo(SegmentVideoInfo segmentVideoInfo) {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (segmentVideoInfo != null && segmentVideoInfo.getStreams() != null) {
            for (SegmentVideoInfo.StreamInfo streamInfo : segmentVideoInfo.getStreams().values()) {
                if (streamInfo != null && (arrayList = streamInfo.segmentInfos) != null) {
                    Iterator<SegmentVideoInfo.SegmentInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        SegmentVideoInfo.SegmentInfo next = it.next();
                        if (next != null && !TextUtils.isEmpty(next.url)) {
                            clearCacheByUrl(next.url);
                        }
                    }
                }
            }
        }
    }

    public void clearCacheByUrl(String str) {
        try {
            this.proxy.clearCacheByUrl(str);
        } catch (Exception e16) {
            PlayerUtils.log(6, TAG, "failed clear cache by url. url=" + str + " msg=" + e16.getMessage());
        }
    }

    public String downloadVideoSync(String str, VideoDownloadListener videoDownloadListener, boolean z16, HttpHeader httpHeader) {
        return this.proxy.downloadVideoSync(str, videoDownloadListener, z16, httpHeader);
    }

    public void downloadVideosAsync(List<String> list, int i3, boolean z16, VideoDownloadListener videoDownloadListener, HttpHeader httpHeader) {
        this.proxy.downloadVideosAsync(list, i3, z16, videoDownloadListener, httpHeader);
    }

    public long getCachedBytesFromEnd(String str) {
        return this.proxy.getCachedBytesFromEnd(str);
    }

    public long getCachedBytesFromStart(String str) {
        return this.proxy.getCachedBytesFromStart(str);
    }

    public double getCachedSizeRate(String str) {
        return this.proxy.getCachedSizeRate(str);
    }

    public long getDownloadBitrate() {
        return DefaultBandwidthMeter.getBitrate();
    }

    public String getLocalServerPrefix() {
        return this.proxy.getLocalServerPrefix();
    }

    public long getTotalLength(String str) {
        return this.proxy.getTotalLength(str);
    }

    public long getUnCachedSize(String str) {
        return this.proxy.getUnCachedSize(str);
    }

    public String getUrl(String str) {
        return this.proxy.getUrl(str);
    }

    public String getVideoKey(String str) {
        return PlayerUtils.parseVideoKey(str);
    }

    public VideoRequestManager getVideoRequestManager() {
        return this.proxy.getVideoRequestManager();
    }

    public boolean isCached(String str) {
        return this.proxy.isCached(str);
    }

    public boolean preload(String str, long j3, long j16, int i3, boolean z16, DownloadListener downloadListener) {
        boolean z17 = getCachedBytesFromStart(str) < j3;
        boolean z18 = !z16 && getCachedBytesFromEnd(str) <= 0;
        if (!z17 && !z18) {
            PlayerUtils.log(4, TAG, "preload_log \u4e0d\u9700\u8981\u9884\u52a0\u8f7d preloadSync skipped: url=" + str);
            return false;
        }
        if (PlayerUtils.isHLSStream(str)) {
            PlayerUtils.log(4, TAG, "preload_log preloadSync skipped m3u8 is not supported: url=" + str);
            return false;
        }
        try {
            this.proxy.preloadAsync(str, j3, j16, i3, z17, z18, null, downloadListener);
        } catch (Exception e16) {
            PlayerUtils.log(6, TAG, "preload_log preloadSync error: url=" + str + " msg=" + e16.getMessage());
        }
        return true;
    }

    public void preloadMedia(List<String> list, int i3, long j3, PreloadListener preloadListener) {
        this.proxy.preloadMedia(list, i3, j3, preloadListener);
    }

    public int probeContentFlag(String str) {
        return this.proxy.probeContentFlag(str);
    }

    public void removeCacheReadListener(String str) {
        this.proxy.removeCacheReadListener(str);
    }

    public void removeHttpErrorListener(String str) {
        this.proxy.removeHttpErrorListener(str);
    }

    public void removeHttpRetryLogic(String str) {
        this.proxy.removeHttpRetryLogic(str);
    }

    public void removeUuidErrorListener(String str) {
        this.proxy.removeUuidErrorListener(str);
    }

    public void setDataSourceBuilder(ITcDataSourceUtils iTcDataSourceUtils) {
        this.proxy.setDataSourceBuilder(iTcDataSourceUtils);
    }

    public void setLogger(QLog qLog) {
        PlayerConfig.g().setLogger(qLog);
    }

    public void cancelAsync(String str) {
        cancelAsync(str, true);
    }

    public String getUrl(String str, HttpHeader httpHeader) {
        return this.proxy.getUrl(str, httpHeader);
    }

    public boolean isCached(SegmentVideoInfo.StreamInfo streamInfo) {
        if (streamInfo == null || !streamInfo.isValid()) {
            return false;
        }
        if (PlayerUtils.isOnMainThread()) {
            Object submitTaskCatchAll = ThreadUtils.submitTaskCatchAll(new IsStreamInfoCachedCallable(streamInfo), 800, true, "isCached", TAG);
            if (submitTaskCatchAll != null) {
                return ((Boolean) submitTaskCatchAll).booleanValue();
            }
            return false;
        }
        Iterator<SegmentVideoInfo.SegmentInfo> it = streamInfo.segmentInfos.iterator();
        while (it.hasNext()) {
            if (!this.proxy.isCached(it.next().url)) {
                return false;
            }
        }
        return true;
    }

    public List<String> getUrl(List<String> list, List<HttpHeader> list2) {
        return this.proxy.getUrl(list, list2);
    }

    public String getUrl(String str, HttpHeader httpHeader, String str2) {
        return this.proxy.getUrl(str, httpHeader, str2);
    }

    public List<String> getUrl(List<String> list) {
        return this.proxy.getUrl(list);
    }

    public boolean preload(String str, long j3, long j16, int i3) {
        boolean z16 = getCachedBytesFromStart(str) < j3;
        boolean z17 = getCachedBytesFromEnd(str) <= 0;
        if (!z16 && !z17) {
            PlayerUtils.log(4, TAG, "preloadSync skipped: url=" + str);
            return false;
        }
        if (PlayerUtils.isHLSStream(str)) {
            PlayerUtils.log(4, TAG, "preloadSync skipped m3u8 is not supported: url=" + str);
            return false;
        }
        try {
            this.proxy.preloadAsync(str, j3, j16, i3, z16, z17, null, null);
        } catch (Exception e16) {
            PlayerUtils.log(6, TAG, "preloadSync error: url=" + str + " msg=" + e16.getMessage());
        }
        return true;
    }
}
