package org.tencwebrtc;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileVideoCapturer implements VideoCapturer {
    private static final String TAG = "FileVideoCapturer";
    private CapturerObserver capturerObserver;
    private final VideoReader videoReader;
    private final Timer timer = new BaseTimer();
    private final TimerTask tickTask = new TimerTask() { // from class: org.tencwebrtc.FileVideoCapturer.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FileVideoCapturer.this.tick();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface VideoReader {
        void close();

        VideoFrame getNextFrame();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class VideoReaderY4M implements VideoReader {
        private static final int FRAME_DELIMETER_LENGTH = 6;
        private static final String TAG = "VideoReaderY4M";
        private static final String Y4M_FRAME_DELIMETER = "FRAME";
        private final int frameHeight;
        private final int frameWidth;
        private final RandomAccessFile mediaFile;
        private final FileChannel mediaFileChannel;
        private final long videoStart;

        public VideoReaderY4M(String str) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            this.mediaFile = randomAccessFile;
            this.mediaFileChannel = randomAccessFile.getChannel();
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                int read = this.mediaFile.read();
                if (read != -1) {
                    if (read == 10) {
                        this.videoStart = this.mediaFileChannel.position();
                        String str2 = "";
                        int i3 = 0;
                        int i16 = 0;
                        for (String str3 : sb5.toString().split("[ ]")) {
                            char charAt = str3.charAt(0);
                            if (charAt != 'C') {
                                if (charAt != 'H') {
                                    if (charAt == 'W') {
                                        i3 = Integer.parseInt(str3.substring(1));
                                    }
                                } else {
                                    i16 = Integer.parseInt(str3.substring(1));
                                }
                            } else {
                                str2 = str3.substring(1);
                            }
                        }
                        Logging.d(TAG, "Color space: " + str2);
                        if (!str2.equals("420") && !str2.equals("420mpeg2")) {
                            throw new IllegalArgumentException("Does not support any other color space than I420 or I420mpeg2");
                        }
                        if (i3 % 2 != 1 && i16 % 2 != 1) {
                            this.frameWidth = i3;
                            this.frameHeight = i16;
                            Logging.d(TAG, "frame dim: (" + i3 + ", " + i16 + ")");
                            return;
                        }
                        throw new IllegalArgumentException("Does not support odd width or height");
                    }
                    sb5.append((char) read);
                } else {
                    throw new RuntimeException("Found end of file before end of header for file: " + str);
                }
            }
        }

        @Override // org.tencwebrtc.FileVideoCapturer.VideoReader
        public void close() {
            try {
                this.mediaFile.close();
            } catch (IOException e16) {
                Logging.e(TAG, "Problem closing file", e16);
            }
        }

        @Override // org.tencwebrtc.FileVideoCapturer.VideoReader
        public VideoFrame getNextFrame() {
            long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
            JavaI420Buffer allocate = JavaI420Buffer.allocate(this.frameWidth, this.frameHeight);
            ByteBuffer dataY = allocate.getDataY();
            ByteBuffer dataU = allocate.getDataU();
            ByteBuffer dataV = allocate.getDataV();
            int i3 = (this.frameHeight + 1) / 2;
            allocate.getStrideY();
            allocate.getStrideU();
            allocate.getStrideV();
            try {
                int i16 = FRAME_DELIMETER_LENGTH;
                ByteBuffer allocate2 = ByteBuffer.allocate(i16);
                if (this.mediaFileChannel.read(allocate2) < i16) {
                    this.mediaFileChannel.position(this.videoStart);
                    if (this.mediaFileChannel.read(allocate2) < i16) {
                        throw new RuntimeException("Error looping video");
                    }
                }
                String str = new String(allocate2.array(), Charset.forName("US-ASCII"));
                if (str.equals("FRAME\n")) {
                    this.mediaFileChannel.read(dataY);
                    this.mediaFileChannel.read(dataU);
                    this.mediaFileChannel.read(dataV);
                    return new VideoFrame(allocate, 0, nanos);
                }
                throw new RuntimeException("Frames should be delimited by FRAME plus newline, found delimter was: '" + str + "'");
            } catch (IOException e16) {
                throw new RuntimeException(e16);
            }
        }
    }

    public FileVideoCapturer(String str) throws IOException {
        try {
            this.videoReader = new VideoReaderY4M(str);
        } catch (IOException e16) {
            Logging.d(TAG, "Could not open video file: " + str);
            throw e16;
        }
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void dispose() {
        this.videoReader.close();
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.capturerObserver = capturerObserver;
    }

    @Override // org.tencwebrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void startCapture(int i3, int i16, int i17) {
        this.timer.schedule(this.tickTask, 0L, 1000 / i17);
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void stopCapture() throws InterruptedException {
        this.timer.cancel();
    }

    public void tick() {
        VideoFrame nextFrame = this.videoReader.getNextFrame();
        this.capturerObserver.onFrameCaptured(nextFrame);
        nextFrame.release();
    }

    @Override // org.tencwebrtc.VideoCapturer
    public void changeCaptureFormat(int i3, int i16, int i17) {
    }
}
