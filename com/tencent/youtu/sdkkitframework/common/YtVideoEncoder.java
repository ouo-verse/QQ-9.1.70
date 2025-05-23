package com.tencent.youtu.sdkkitframework.common;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes27.dex */
public class YtVideoEncoder {
    static IPatchRedirector $redirector_ = null;
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = "YtVideoEncoder";
    private static MediaCodecInfo codecInfo = null;
    private static int colorFormat = 21;
    private int addedTrackCount;
    private boolean isEncodingStarted;
    private boolean isMediaMuxerStarted;
    private final Object mFrameSync;
    private CountDownLatch mNewFrameLatch;
    private boolean mNoMoreFrames;
    private File mOutputFile;
    private MediaMuxer mediaMuxer;
    private MediaFormat mediaMuxerFormat;
    private final Object mediaMuxerSync;
    private String outputFileString;
    private ConcurrentLinkedQueue<YTImageData> videoEncodeQueue;
    private MediaCodec videoEncoder;
    private int videoGenerateIndex;
    private int videoTrackIndex;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface VideoEncodeResultCode {
        public static final int VIDEO_ENCODE_FAIL = -2;
        public static final int VIDEO_ENCODE_SUCCESS = 0;
        public static final int VIDEO_MEDIA_NOT_HAS_USE = -1;
        public static final int VIDEO_START_SUCCESS = 0;
    }

    public YtVideoEncoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.videoEncodeQueue = new ConcurrentLinkedQueue<>();
        this.isMediaMuxerStarted = false;
        this.mFrameSync = new Object();
        this.mediaMuxerSync = new Object();
        this.videoGenerateIndex = 0;
        this.addedTrackCount = 0;
        this.mNoMoreFrames = false;
        this.isEncodingStarted = false;
    }

    private long computePresentationTime(long j3, int i3) {
        return ((j3 * 1000000) / i3) + 132;
    }

    private static boolean findColorFormats(int i3, int[] iArr) {
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private ByteBuffer getInputBuffer(int i3) {
        return this.videoEncoder.getInputBuffer(i3);
    }

    public static int getMediaCodecInfo() {
        try {
            int codecCount = MediaCodecList.getCodecCount();
            codecInfo = null;
            for (int i3 = 0; i3 < codecCount && codecInfo == null; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                if (codecInfoAt.isEncoder()) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    boolean z16 = false;
                    for (int i16 = 0; i16 < supportedTypes.length && !z16; i16++) {
                        if (supportedTypes[i16].equals("video/avc")) {
                            z16 = true;
                        }
                    }
                    if (z16) {
                        codecInfo = codecInfoAt;
                    }
                }
            }
            MediaCodecInfo mediaCodecInfo = codecInfo;
            if (mediaCodecInfo == null) {
                return -1;
            }
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            YtLogger.o(TAG, "codecInfoName:" + codecInfo.getName() + " colorFormat:" + Arrays.toString(capabilitiesForType.colorFormats));
            if (findColorFormats(21, capabilitiesForType.colorFormats)) {
                colorFormat = 21;
                return 0;
            }
            if (!findColorFormats(19, capabilitiesForType.colorFormats)) {
                return -1;
            }
            colorFormat = 19;
            return 0;
        } catch (Exception e16) {
            YtLogger.e(TAG, "get color format type error", e16);
            return -1;
        }
    }

    private ByteBuffer getOutputBuffer(int i3) {
        return this.videoEncoder.getOutputBuffer(i3);
    }

    private void release() {
        synchronized (this.mediaMuxerSync) {
            if (this.videoEncoder != null) {
                String str = TAG;
                YtLogger.d(str, "reset media codec");
                this.videoEncoder.reset();
                YtLogger.d(str, "stop media codec");
                this.videoEncoder.stop();
                YtLogger.d(str, "Release media codec");
                this.videoEncoder.release();
                this.videoEncoder = null;
                YtLogger.d(str, "RELEASE Video CODEC");
            }
            if (this.mediaMuxer != null) {
                String str2 = TAG;
                YtLogger.d(str2, "Stop media muxer");
                this.mediaMuxer.stop();
                YtLogger.d(str2, "Release media muxer");
                this.mediaMuxer.release();
                this.mediaMuxer = null;
                this.isMediaMuxerStarted = false;
                YtLogger.d(str2, "RELEASE MUXER");
            }
            this.mediaMuxerFormat = null;
        }
    }

    private void startMediaMuxer(MediaFormat mediaFormat) {
        synchronized (this.mediaMuxerSync) {
            if (this.isMediaMuxerStarted) {
                MediaFormat mediaFormat2 = this.mediaMuxerFormat;
                if (mediaFormat2 != null && mediaFormat != null && mediaFormat2.toString().equals(mediaFormat.toString())) {
                    return;
                }
                try {
                    this.mediaMuxer.stop();
                } catch (Exception e16) {
                    YtLogger.e(TAG, "media muxer stop failed:", e16);
                }
                this.mediaMuxer.release();
                this.mediaMuxer = null;
                this.isMediaMuxerStarted = false;
                try {
                    this.mediaMuxer = new MediaMuxer(this.outputFileString, 0);
                } catch (Exception e17) {
                    YtLogger.e(TAG, "Unable to get path for ", e17);
                    return;
                }
            }
            this.mediaMuxerFormat = mediaFormat;
            this.videoTrackIndex = this.mediaMuxer.addTrack(mediaFormat);
            int i3 = this.addedTrackCount + 1;
            this.addedTrackCount = i3;
            if (i3 >= 1) {
                YtLogger.d(TAG, "Media muxer is starting...");
                this.mediaMuxer.start();
                this.isMediaMuxerStarted = true;
                this.mediaMuxerSync.notifyAll();
            }
        }
    }

    public void abortEncoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.isEncodingStarted = false;
        if (this.mOutputFile != null) {
            YtLogger.d(TAG, "Clean up record file");
            this.mOutputFile.delete();
            this.mOutputFile = null;
        }
        if (this.videoEncoder != null && this.mediaMuxer != null) {
            YtLogger.i(TAG, "Aborting encoding");
            release();
            this.mNoMoreFrames = true;
            this.videoEncodeQueue = new ConcurrentLinkedQueue<>();
            synchronized (this.mFrameSync) {
                CountDownLatch countDownLatch = this.mNewFrameLatch;
                if (countDownLatch != null && countDownLatch.getCount() > 0) {
                    this.mNewFrameLatch.countDown();
                }
            }
            return;
        }
        YtLogger.i(TAG, "Failed to abort encoding since it never started");
    }

    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mOutputFile != null) {
            YtLogger.d(TAG, "Clean up record file");
            this.mOutputFile.delete();
            this.mOutputFile = null;
        }
        if (this.isEncodingStarted) {
            try {
                this.videoEncoder.stop();
                this.videoEncoder.release();
            } catch (IllegalStateException e16) {
                YtLogger.e(TAG, "restart:stop video error", e16);
            }
        }
        if (this.mediaMuxer != null) {
            this.mediaMuxer = null;
        }
        this.videoEncodeQueue.clear();
        this.isEncodingStarted = false;
    }

    public void encode(int i3) {
        CountDownLatch countDownLatch;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (this.isEncodingStarted) {
            YtLogger.d(TAG, "Encoder started");
            if (this.mNoMoreFrames && this.videoEncodeQueue.size() == 0) {
                return;
            }
            YTImageData poll = this.videoEncodeQueue.poll();
            if (poll == null) {
                synchronized (this.mFrameSync) {
                    countDownLatch = new CountDownLatch(1);
                    this.mNewFrameLatch = countDownLatch;
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e16) {
                    YtLogger.e(TAG, "Queueing frame", e16);
                }
                poll = this.videoEncodeQueue.poll();
            }
            if (poll == null) {
                YtLogger.e(TAG, "encode data is Null!!: ", null);
                return;
            }
            int dequeueInputBuffer = this.videoEncoder.dequeueInputBuffer(200000L);
            long computePresentationTime = computePresentationTime(this.videoGenerateIndex, i3);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer inputBuffer = getInputBuffer(dequeueInputBuffer);
                inputBuffer.clear();
                inputBuffer.put(poll.imgData);
                this.videoEncoder.queueInputBuffer(dequeueInputBuffer, 0, poll.imgData.length, computePresentationTime, 0);
                this.videoGenerateIndex++;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.videoEncoder.dequeueOutputBuffer(bufferInfo, 200000L);
            if (dequeueOutputBuffer == -1) {
                YtLogger.e(TAG, "No output from encoder available", null);
                return;
            }
            if (dequeueOutputBuffer == -2) {
                startMediaMuxer(this.videoEncoder.getOutputFormat());
                return;
            }
            if (dequeueOutputBuffer < 0) {
                YtLogger.e(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer, null);
                return;
            }
            if (bufferInfo.size != 0) {
                ByteBuffer outputBuffer = getOutputBuffer(dequeueOutputBuffer);
                if (outputBuffer == null) {
                    YtLogger.e(TAG, "encoderOutputBuffer " + dequeueOutputBuffer + " was null", null);
                    return;
                }
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                YtLogger.d(TAG, "media muxer write video data outputindex " + this.videoGenerateIndex);
                synchronized (this.mediaMuxer) {
                    this.mediaMuxer.writeSampleData(this.videoTrackIndex, outputBuffer, bufferInfo);
                }
                this.videoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                return;
            }
            return;
        }
        throw new Exception("encode not started");
    }

    public MediaCodecInfo getCodecInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MediaCodecInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return codecInfo;
    }

    public int getColorFormat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return colorFormat;
    }

    public String getSupportCodecJSONStr() {
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            MediaCodecInfo mediaCodecInfo = codecInfo;
            if (mediaCodecInfo == null) {
                name = "codecInfo null";
            } else {
                name = mediaCodecInfo.getName();
            }
            jSONObject.put("codec_info:", name);
            jSONObject.put("color_format:", colorFormat);
        } catch (JSONException e16) {
            YtLogger.e(TAG, "video encode make json error:", e16);
        }
        return jSONObject.toString();
    }

    public boolean isEncodingStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isEncodingStarted;
    }

    public void queueFrame(YTImageData yTImageData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) yTImageData);
            return;
        }
        if (!this.isEncodingStarted) {
            return;
        }
        if (this.videoEncoder != null && this.mediaMuxer != null) {
            YtLogger.d(TAG, "Queueing frame");
            this.videoEncodeQueue.add(yTImageData);
            synchronized (this.mFrameSync) {
                CountDownLatch countDownLatch = this.mNewFrameLatch;
                if (countDownLatch != null && countDownLatch.getCount() > 0) {
                    this.mNewFrameLatch.countDown();
                }
            }
            return;
        }
        Log.d(TAG, "Failed to queue frame. Encoding not started");
    }

    public void startEncoding(int i3, int i16, File file, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), file, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            return;
        }
        this.mOutputFile = file;
        file.delete();
        this.outputFileString = file.getCanonicalPath();
        String str = TAG;
        YtLogger.o(str, "found codec: " + codecInfo.getName() + "|colorFormat:" + colorFormat + "|width=" + i3 + "|height=" + i16 + "|videoRotation=" + i26);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i3, i16);
        createVideoFormat.setInteger("color-format", colorFormat);
        createVideoFormat.setInteger("frame-rate", i18);
        createVideoFormat.setInteger("bitrate", i17);
        createVideoFormat.setInteger("i-frame-interval", i19);
        createVideoFormat.setInteger("width", i3);
        createVideoFormat.setInteger("height", i16);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.videoEncoder = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.videoEncoder.start();
        if (this.mediaMuxer == null) {
            MediaMuxer mediaMuxer = new MediaMuxer(this.outputFileString, 0);
            this.mediaMuxer = mediaMuxer;
            if (i26 == 0) {
                i27 = 90;
            }
            mediaMuxer.setOrientationHint(i27);
        }
        YtLogger.i(str, "Initialization complete. Starting encoder...");
        this.isEncodingStarted = true;
    }

    public void stopEncoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.isEncodingStarted = false;
        if (this.videoEncoder != null && this.mediaMuxer != null) {
            YtLogger.i(TAG, "Stopping encoding");
            this.mNoMoreFrames = true;
            synchronized (this.mFrameSync) {
                CountDownLatch countDownLatch = this.mNewFrameLatch;
                if (countDownLatch != null && countDownLatch.getCount() > 0) {
                    this.mNewFrameLatch.countDown();
                }
            }
            release();
            return;
        }
        Log.i(TAG, "Failed to stop encoding since it never started");
    }
}
