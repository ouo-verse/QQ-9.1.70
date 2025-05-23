package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.CapturerObserver;
import org.tencwebrtc.JavaI420Buffer;
import org.tencwebrtc.SurfaceTextureHelper;
import org.tencwebrtc.VideoCapturer;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CompressedVideoCapturer implements VideoCapturer {
    private static final String TAG = "FileVideoCapturer";
    public static BufferPool bufferPool = null;
    public static final int initialCapacity = 16;
    private static boolean mSinkReady = false;
    private CapturerObserver mCapturerObserver;
    private final VideoReader mVideoReader;
    private final Timer timer = new BaseTimer();
    private final ScheduledExecutorService scheduler = ProxyExecutors.newScheduledThreadPool(1);
    private final Runnable tickTask = new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.CompressedVideoCapturer.1
        @Override // java.lang.Runnable
        public void run() {
            if (CompressedVideoCapturer.mSinkReady) {
                CompressedVideoCapturer.this.tick();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface VideoReader {
        void close();

        VideoFrame getNextFrame();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class VideoReaderH264H265 implements VideoReader {
        private static final int NAL_HEADER_LENGTH = 4;
        private static final String TAG = "VideoReaderH264H265";
        private MediaExtractor mExtractor;
        private int mFrameHeight;
        private int mFrameWidth;

        public VideoReaderH264H265(String str) throws IOException {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mExtractor = mediaExtractor;
            try {
                mediaExtractor.setDataSource(str);
            } catch (IOException unused) {
                CGLog.e("Failed to setDataSource " + str);
            }
            int i3 = 0;
            while (true) {
                if (i3 < this.mExtractor.getTrackCount()) {
                    if (this.mExtractor.getTrackFormat(i3).getString("mime").startsWith("video/")) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                this.mExtractor.selectTrack(i3);
                MediaFormat trackFormat = this.mExtractor.getTrackFormat(i3);
                this.mFrameWidth = trackFormat.getInteger("width");
                this.mFrameHeight = trackFormat.getInteger("height");
            }
            CompressedVideoCapturer.bufferPool = new BufferPool(16, this.mFrameWidth, this.mFrameHeight);
        }

        @Override // com.tencent.gamematrix.gmcg.webrtc.CompressedVideoCapturer.VideoReader
        public void close() {
            try {
                this.mExtractor.release();
            } catch (Exception e16) {
                CGLog.e("Problem closing mExtractor: " + e16);
            }
        }

        @Override // com.tencent.gamematrix.gmcg.webrtc.CompressedVideoCapturer.VideoReader
        public VideoFrame getNextFrame() {
            boolean z16;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long nanos = timeUnit.toNanos(SystemClock.elapsedRealtime());
            JavaI420Buffer buffer = CompressedVideoCapturer.bufferPool.getBuffer(true);
            long nanos2 = timeUnit.toNanos(SystemClock.elapsedRealtime());
            ByteBuffer dataY = buffer.getDataY();
            dataY.position(0);
            int readSampleData = this.mExtractor.readSampleData(dataY, 0);
            if (readSampleData < 0) {
                CGLog.i("Reset video file to start");
                this.mExtractor.seekTo(0L, 2);
                readSampleData = this.mExtractor.readSampleData(dataY, 0);
                if (readSampleData < 0) {
                    CGLog.e("Failed to reset video file to start");
                }
            }
            long nanos3 = timeUnit.toNanos(SystemClock.elapsedRealtime());
            this.mExtractor.advance();
            if ((this.mExtractor.getSampleFlags() & 1) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            VideoFrame videoFrame = new VideoFrame(buffer, 0, nanos);
            videoFrame.setSize(readSampleData);
            videoFrame.setIsKeyFrame(z16);
            long nanos4 = timeUnit.toNanos(SystemClock.elapsedRealtime());
            byte[] bArr = new byte[dataY.remaining()];
            dataY.get(bArr);
            dataY.position(0);
            CGLog.i("Loopback, timing of getNextFrame, captureTimeNs=" + nanos + ", allocateNs=" + nanos2 + ", readSampleDataNs=" + nanos3 + ", videoFrameNs=" + nanos4 + ", getDataNs=" + timeUnit.toNanos(SystemClock.elapsedRealtime()));
            CGLog.i("Loopback, getNextFrame, isKeyFrame=" + z16 + ", sampleSize=" + readSampleData + ", captureTimeNs=" + nanos + ", videoFrame.size=" + videoFrame.getSize() + " " + Integer.toHexString(bArr[0]) + " " + Integer.toHexString(bArr[1]) + " " + Integer.toHexString(bArr[2]) + " " + Integer.toHexString(bArr[3]) + " " + Integer.toHexString(bArr[4]) + " " + Integer.toHexString(bArr[5]) + " " + Integer.toHexString(bArr[6]));
            return videoFrame;
        }
    }

    public CompressedVideoCapturer(String str) throws IOException {
        try {
            this.mVideoReader = new VideoReaderH264H265(str);
        } catch (Exception e16) {
            CGLog.i("Could not open video file: " + str + ", Exception:" + e16);
            throw e16;
        }
    }

    private void releaseAllBuffers() {
        while (true) {
            JavaI420Buffer buffer = bufferPool.getBuffer(false);
            if (buffer != null) {
                buffer.release();
            } else {
                return;
            }
        }
    }

    public static void setSinkReady(boolean z16) {
        mSinkReady = z16;
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.mCapturerObserver = capturerObserver;
    }

    @Override // org.tencwebrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void startCapture(int i3, int i16, int i17) {
        this.scheduler.scheduleAtFixedRate(this.tickTask, 0L, 1000000000 / i17, TimeUnit.NANOSECONDS);
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void stopCapture() throws InterruptedException {
        this.scheduler.shutdown();
        try {
            if (!this.scheduler.awaitTermination(800L, TimeUnit.MILLISECONDS)) {
                this.scheduler.shutdownNow();
            }
        } catch (InterruptedException unused) {
            this.scheduler.shutdownNow();
        }
        releaseAllBuffers();
    }

    public void tick() {
        this.mCapturerObserver.onFrameCaptured(this.mVideoReader.getNextFrame());
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void dispose() {
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void changeCaptureFormat(int i3, int i16, int i17) {
    }
}
