package org.tencwebrtc;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoFileRenderer implements VideoSink {
    private static final String TAG = "VideoFileRenderer";
    private EglBase eglBase;
    private final HandlerThread fileThread;
    private final Handler fileThreadHandler;
    private int frameCount;
    private final int outputFileHeight;
    private final String outputFileName;
    private final int outputFileWidth;
    private final ByteBuffer outputFrameBuffer;
    private final int outputFrameSize;
    private final HandlerThread renderThread;
    private final Handler renderThreadHandler;
    private final FileOutputStream videoOutFile;
    private YuvConverter yuvConverter;

    public VideoFileRenderer(String str, int i3, int i16, final EglBase.Context context) throws IOException {
        if (i3 % 2 != 1 && i16 % 2 != 1) {
            this.outputFileName = str;
            this.outputFileWidth = i3;
            this.outputFileHeight = i16;
            int i17 = ((i3 * i16) * 3) / 2;
            this.outputFrameSize = i17;
            this.outputFrameBuffer = ByteBuffer.allocateDirect(i17);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            this.videoOutFile = fileOutputStream;
            fileOutputStream.write(("YUV4MPEG2 C420 W" + i3 + " H" + i16 + " Ip F30:1 A1:1\n").getBytes(Charset.forName("US-ASCII")));
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VideoFileRendererRenderThread");
            this.renderThread = baseHandlerThread;
            baseHandlerThread.start();
            Handler handler = new Handler(baseHandlerThread.getLooper());
            this.renderThreadHandler = handler;
            BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread("VideoFileRendererFileThread");
            this.fileThread = baseHandlerThread2;
            baseHandlerThread2.start();
            this.fileThreadHandler = new Handler(baseHandlerThread2.getLooper());
            ThreadUtils.invokeAtFrontUninterruptibly(handler, new Runnable() { // from class: org.tencwebrtc.VideoFileRenderer.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoFileRenderer.this.eglBase = g.c(context, EglBase.CONFIG_PIXEL_BUFFER);
                    VideoFileRenderer.this.eglBase.createDummyPbufferSurface();
                    VideoFileRenderer.this.eglBase.makeCurrent();
                    VideoFileRenderer.this.yuvConverter = new YuvConverter();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Does not support uneven width or height");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(CountDownLatch countDownLatch) {
        this.yuvConverter.release();
        this.eglBase.release();
        this.renderThread.quit();
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3() {
        try {
            this.videoOutFile.close();
            Logging.d(TAG, "Video written to disk as " + this.outputFileName + ". The number of frames is " + this.frameCount + " and the dimensions of the frames are " + this.outputFileWidth + HippyTKDListViewAdapter.X + this.outputFileHeight + ".");
            this.fileThread.quit();
        } catch (IOException e16) {
            throw new RuntimeException("Error closing output file", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderFrameOnRenderThread$1(VideoFrame.I420Buffer i420Buffer, VideoFrame videoFrame) {
        YuvHelper.I420Rotate(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), this.outputFrameBuffer, i420Buffer.getWidth(), i420Buffer.getHeight(), videoFrame.getRotation());
        i420Buffer.release();
        try {
            this.videoOutFile.write("FRAME\n".getBytes(Charset.forName("US-ASCII")));
            this.videoOutFile.write(this.outputFrameBuffer.array(), this.outputFrameBuffer.arrayOffset(), this.outputFrameSize);
            this.frameCount++;
        } catch (IOException e16) {
            throw new RuntimeException("Error writing video to disk", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderFrameOnRenderThread, reason: merged with bridge method [inline-methods] */
    public void lambda$onFrame$0(final VideoFrame videoFrame) {
        int i3;
        int i16;
        VideoFrame.Buffer buffer = videoFrame.getBuffer();
        if (videoFrame.getRotation() % 180 == 0) {
            i3 = this.outputFileWidth;
        } else {
            i3 = this.outputFileHeight;
        }
        int i17 = i3;
        if (videoFrame.getRotation() % 180 == 0) {
            i16 = this.outputFileHeight;
        } else {
            i16 = this.outputFileWidth;
        }
        int i18 = i16;
        float width = buffer.getWidth() / buffer.getHeight();
        float f16 = i17 / i18;
        int width2 = buffer.getWidth();
        int height = buffer.getHeight();
        if (f16 > width) {
            height = (int) (height * (width / f16));
        } else {
            width2 = (int) (width2 * (f16 / width));
        }
        VideoFrame.Buffer cropAndScale = buffer.cropAndScale((buffer.getWidth() - width2) / 2, (buffer.getHeight() - height) / 2, width2, height, i17, i18);
        videoFrame.release();
        final VideoFrame.I420Buffer i420 = cropAndScale.toI420();
        cropAndScale.release();
        this.fileThreadHandler.post(new Runnable() { // from class: org.tencwebrtc.ai
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.this.lambda$renderFrameOnRenderThread$1(i420, videoFrame);
            }
        });
    }

    @Override // org.tencwebrtc.VideoSink
    public void onFrame(final VideoFrame videoFrame) {
        videoFrame.retain();
        this.renderThreadHandler.post(new Runnable() { // from class: org.tencwebrtc.al
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.this.lambda$onFrame$0(videoFrame);
            }
        });
    }

    public void release() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.renderThreadHandler.post(new Runnable() { // from class: org.tencwebrtc.aj
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.this.lambda$release$2(countDownLatch);
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        this.fileThreadHandler.post(new Runnable() { // from class: org.tencwebrtc.ak
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.this.lambda$release$3();
            }
        });
        try {
            this.fileThread.join();
        } catch (InterruptedException e16) {
            Thread.currentThread().interrupt();
            Logging.e(TAG, "Interrupted while waiting for the write to disk to complete.", e16);
        }
    }
}
