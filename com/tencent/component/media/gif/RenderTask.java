package com.tencent.component.media.gif;

import android.os.SystemClock;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.image.ImageTaskBuilder;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class RenderTask extends SafeRunnable {
    private int failCount;
    private long invalidationDelay;
    public int mCurrentIndex;
    private boolean mFailCountReported;
    protected final Runnable mNotifyListenersTask;
    protected boolean mReported;
    private boolean startCollectFailCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderTask(NewGifDrawable newGifDrawable) {
        super(newGifDrawable);
        this.mCurrentIndex = 0;
        this.mReported = false;
        this.failCount = 0;
        this.startCollectFailCount = false;
        this.mFailCountReported = false;
        this.invalidationDelay = 0L;
        this.mNotifyListenersTask = new Runnable() { // from class: com.tencent.component.media.gif.RenderTask.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<AnimationListener> it = RenderTask.this.mGifDrawable.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onAnimationCompleted();
                }
            }
        };
    }

    private void reportCostsTime(boolean z16, long j3, NewGifDrawable newGifDrawable) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("is_gif_playing", String.valueOf(z16 ? 1 : 0));
        hashMap.put("first_frame_render_cost", String.valueOf(j3));
        hashMap.put("networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
        if (z16) {
            ImageManagerEnv.g().reportImageTimeCostMTA(ImageManagerEnv.QZONE_GIF_PLAYING_REPORT, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "gif_play_first_frame_cost", (int) j3);
            ImageManagerEnv.getLogger().d("gifPlayingReport", "gif_play time:" + j3);
            hashMap.put("gif_play_first_frame_cost", String.valueOf(j3));
        } else {
            ImageManagerEnv.g().reportImageTimeCostMTA(ImageManagerEnv.QZONE_GIF_PLAYING_REPORT, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "normal_Play_first_frame_cost", (int) j3);
            ImageManagerEnv.getLogger().d("gifPlayingReport", "normal_Play time:" + j3);
            hashMap.put("normal_Play_first_frame_cost", String.valueOf(j3));
            hashMap.put("n_frameCount", String.valueOf(newGifDrawable.getNumberOfFrames()));
            hashMap.put("n_size", String.valueOf(newGifDrawable.getAllocationByteCount()));
        }
        ImageManagerEnv.g().statisticCollectorReport(ImageManagerEnv.QZONE_GIF_PLAYING_REPORT, hashMap);
    }

    private void reportFailCount(int i3, NewGifDrawable newGifDrawable) {
        if (newGifDrawable != null && newGifDrawable.getNumberOfFrames() != 0) {
            HashMap<String, String> hashMap = new HashMap<>();
            ImageManagerEnv.g().reportImageTimeCostMTA(ImageManagerEnv.QZONE_GIF_PLAYING_FAIL_COUNT_REPORT, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "gif_play_fail_count", i3);
            ImageManagerEnv.g().reportImageTimeCostMTA(ImageManagerEnv.QZONE_GIF_PLAYING_FAIL_COUNT_REPORT, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "gif_play_frame_count", newGifDrawable.getNumberOfFrames());
            hashMap.put("f_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
            hashMap.put("gif_play_fail_count", String.valueOf(i3));
            hashMap.put("f_frame_count", String.valueOf(newGifDrawable.getNumberOfFrames()));
            if (newGifDrawable.getNumberOfFrames() != 0) {
                hashMap.put("fail_frame", String.valueOf((i3 * 1.0d) / newGifDrawable.getNumberOfFrames()));
            }
            ImageManagerEnv.g().statisticCollectorReport(ImageManagerEnv.QZONE_GIF_PLAYING_FAIL_COUNT_REPORT, hashMap);
        }
    }

    @Override // com.tencent.component.media.gif.SafeRunnable
    public synchronized void doWork() {
        Long remove;
        long j3;
        if (this.mGifDrawable.getCurrentModel() == 4) {
            ImageManagerEnv.getLogger().d("NewGifDrawable", "doWork | ====mCurrentIndex:" + this.mGifDrawable.getCurrentFrameIndex() + " mGifDrawable.isEndDownload:" + this.mGifDrawable.isEndDownload + " mHashcode:" + this.mGifDrawable.mHashcode);
            NewGifDrawable newGifDrawable = this.mGifDrawable;
            NewGifDecoder.GifFrame nextForGifPlay = newGifDrawable.mGifDecoder.nextForGifPlay(newGifDrawable.mBuffer, newGifDrawable.isEndDownload);
            if (!this.mReported) {
                Long remove2 = ImageTaskBuilder.stampMap.remove(this.mGifDrawable.getUrl());
                Long remove3 = ImageTaskBuilder.stampMap2.remove(this.mGifDrawable.getUrl());
                if (remove2 != null) {
                    long currentTimeMillis = System.currentTimeMillis() - remove2.longValue();
                    if (remove3 != null) {
                        j3 = System.currentTimeMillis() - remove3.longValue();
                        ImageManagerEnv.getLogger().d("NewGifDrawable", "1 first_frame_render_cost2: " + j3);
                    } else {
                        j3 = 0;
                    }
                    ImageManagerEnv.getLogger().d("NewGifDrawable", "1 first_frame_render_cost: " + currentTimeMillis);
                    if (j3 != 0) {
                        currentTimeMillis = j3;
                    }
                    reportCostsTime(true, currentTimeMillis, this.mGifDrawable);
                    this.mReported = true;
                }
            }
            ImageManagerEnv.getLogger().d("NewGifDrawable", "doWork | ====invalidationDelay:" + nextForGifPlay.delay);
            if (nextForGifPlay.delay == -1) {
                if (this.startCollectFailCount) {
                    this.failCount++;
                }
                return;
            }
            if (!this.startCollectFailCount) {
                this.startCollectFailCount = true;
            }
            if (!this.mFailCountReported) {
                NewGifDrawable newGifDrawable2 = this.mGifDrawable;
                if (newGifDrawable2.isEndDownload) {
                    this.mFailCountReported = true;
                    reportFailCount(this.failCount, newGifDrawable2);
                }
            }
            NewGifDrawable newGifDrawable3 = this.mGifDrawable;
            newGifDrawable3.mIsRenderingTriggeredOnDraw = true;
            newGifDrawable3.mBuffer = nextForGifPlay.image;
            this.invalidationDelay = nextForGifPlay.delay;
        } else {
            NewGifDrawable newGifDrawable4 = this.mGifDrawable;
            newGifDrawable4.mIsRenderingTriggeredOnDraw = true;
            NewGifDecoder.GifFrame next = newGifDrawable4.mGifDecoder.next(newGifDrawable4.mBuffer);
            if (!this.mReported && (remove = ImageTaskBuilder.stampMap.remove(this.mGifDrawable.getUrl())) != null) {
                long currentTimeMillis2 = System.currentTimeMillis() - remove.longValue();
                ImageManagerEnv.getLogger().d("NewGifDrawable", "2 first_frame_render_cost: " + currentTimeMillis2);
                reportCostsTime(false, currentTimeMillis2, this.mGifDrawable);
                this.mReported = true;
            }
            NewGifDrawable newGifDrawable5 = this.mGifDrawable;
            newGifDrawable5.mBuffer = next.image;
            this.invalidationDelay = next.delay;
            this.mCurrentIndex = (this.mCurrentIndex + 1) % newGifDrawable5.getNumberOfFrames();
        }
        if (this.invalidationDelay >= 0) {
            this.mGifDrawable.mNextFrameRenderTime = SystemClock.uptimeMillis() + this.invalidationDelay;
            if (!this.mGifDrawable.mListeners.isEmpty() && this.mGifDrawable.getCurrentFrameIndex() == this.mGifDrawable.getNumberOfFrames() - 1) {
                NewGifDrawable newGifDrawable6 = this.mGifDrawable;
                newGifDrawable6.scheduleSelf(this.mNotifyListenersTask, newGifDrawable6.mNextFrameRenderTime);
            }
        } else {
            NewGifDrawable newGifDrawable7 = this.mGifDrawable;
            newGifDrawable7.mNextFrameRenderTime = Long.MIN_VALUE;
            newGifDrawable7.mIsRunning = false;
        }
        if (this.mGifDrawable.isVisible() && !this.mGifDrawable.mInvalidationHandler.hasMessages(0) && this.mGifDrawable.getCallback() != null) {
            this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
    }

    public long getFrameDelay() {
        return this.invalidationDelay;
    }

    public void waitFinish() {
    }
}
