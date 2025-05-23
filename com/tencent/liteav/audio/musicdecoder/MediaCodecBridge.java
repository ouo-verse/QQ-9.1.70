package com.tencent.liteav.audio.musicdecoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@JNINamespace("liteav::audio")
/* loaded from: classes7.dex */
public class MediaCodecBridge {
    private static final String TAG = "MediaCodecBridge";
    private static final long TIMEOUT_MS = 400;
    private boolean mDecodeEOS;
    private MediaFormat mFormat;
    private long mLongestDurationUs;
    private MediaCodec mMediaCodec;
    private MediaExtractor mMediaExtractor;
    private String mMime;
    private int mRawDataSize;
    private int mTrackCount;
    private int mTrackIndex;

    private ByteBuffer dequeueOutputBuffer() {
        ByteBuffer byteBuffer;
        if (this.mDecodeEOS) {
            return null;
        }
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(400L));
            if (dequeueOutputBuffer == -1) {
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                Log.i(TAG, "codec output buffers changed.", new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer == -2) {
                this.mFormat = this.mMediaCodec.getOutputFormat();
                Log.i(TAG, "codec output format changed: " + this.mFormat, new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer < 0) {
                Log.e(TAG, "unexpected result from dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)), new Object[0]);
                return null;
            }
            if ((bufferInfo.flags & 4) != 0) {
                Log.i(TAG, "Decode to EOS", new Object[0]);
                this.mDecodeEOS = true;
                return null;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                byteBuffer = this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer);
            } else {
                byteBuffer = this.mMediaCodec.getOutputBuffers()[dequeueOutputBuffer];
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
            allocateDirect.put(byteBuffer);
            this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
            return allocateDirect;
        } catch (Throwable th5) {
            Log.e(TAG, "Failed to dequeue output buffer", th5);
            return null;
        }
    }

    private ByteBuffer drainData() {
        for (int i3 = 0; i3 < 3; i3++) {
            ByteBuffer dequeueOutputBuffer = dequeueOutputBuffer();
            if (dequeueOutputBuffer != null) {
                return dequeueOutputBuffer;
            }
        }
        return null;
    }

    private long getDuration(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return -1L;
        }
        try {
            return mediaFormat.getLong("durationUs");
        } catch (Throwable th5) {
            Log.e(TAG, "getDuration failed. ".concat(String.valueOf(th5)), new Object[0]);
            return -1L;
        }
    }

    private boolean initMediaCodec() {
        if (!TextUtils.isEmpty(this.mMime) && this.mFormat != null) {
            try {
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.mMime);
                this.mMediaCodec = createDecoderByType;
                createDecoderByType.configure(this.mFormat, (Surface) null, (MediaCrypto) null, 0);
                return true;
            } catch (Throwable th5) {
                th5.printStackTrace();
                this.mMediaCodec = null;
            }
        }
        return false;
    }

    private boolean initMediaExtractor(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mDecodeEOS = false;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(str);
            this.mTrackCount = this.mMediaExtractor.getTrackCount();
            for (int i3 = 0; i3 < this.mTrackCount; i3++) {
                MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i3);
                String string = trackFormat.getString("mime");
                if (!TextUtils.isEmpty(string) && string.startsWith("audio/")) {
                    long duration = getDuration(trackFormat);
                    if (this.mLongestDurationUs < duration) {
                        this.mLongestDurationUs = duration;
                    }
                }
            }
            int i16 = this.mTrackIndex;
            if (i16 != 0) {
                return selectTrack(i16);
            }
            for (int i17 = 0; i17 < this.mTrackCount; i17++) {
                if (selectTrack(i17)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            Log.e(TAG, "initMediaExtractor: ", th5);
            this.mMediaExtractor = null;
            this.mFormat = null;
            this.mMime = null;
            return false;
        }
    }

    private boolean selectTrack(int i3) {
        MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i3);
        String string = trackFormat.getString("mime");
        if (!TextUtils.isEmpty(string) && string.startsWith("audio/")) {
            this.mMediaExtractor.selectTrack(i3);
            this.mTrackIndex = i3;
            this.mFormat = trackFormat;
            this.mMime = string;
            return true;
        }
        return false;
    }

    public long getLongestDuration() {
        return this.mLongestDurationUs;
    }

    public MediaFormat getOutputFormat() {
        return this.mFormat;
    }

    public int getTotalRawDataSize() {
        return this.mRawDataSize;
    }

    public int getTrackCount() {
        return this.mTrackCount;
    }

    public boolean initAndStart(String str) {
        if (this.mMediaCodec != null || !initMediaExtractor(str) || !initMediaCodec()) {
            return false;
        }
        try {
            this.mMediaCodec.start();
            return true;
        } catch (Throwable th5) {
            Log.e(TAG, "Cannot start the audio codec", th5);
            return false;
        }
    }

    public boolean isDecodeEnd() {
        return this.mDecodeEOS;
    }

    public ByteBuffer processFrame() {
        int dequeueInputBuffer;
        int i3;
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(400L)) < 0) {
            return null;
        }
        ByteBuffer byteBuffer = this.mMediaCodec.getInputBuffers()[dequeueInputBuffer];
        if (byteBuffer != null) {
            i3 = this.mMediaExtractor.readSampleData(byteBuffer, 0);
        } else {
            i3 = -1;
        }
        int i16 = i3;
        if (i16 <= 0) {
            this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else {
            this.mRawDataSize += i16;
            this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i16, this.mMediaExtractor.getSampleTime(), 0);
            this.mMediaExtractor.advance();
        }
        return drainData();
    }

    public boolean seekTo(long j3) {
        MediaExtractor mediaExtractor;
        if (this.mMediaCodec == null || (mediaExtractor = this.mMediaExtractor) == null || j3 > this.mLongestDurationUs) {
            return false;
        }
        mediaExtractor.seekTo(j3, 2);
        return true;
    }

    public void setMusicTrack(int i3) {
        int i16 = this.mTrackIndex;
        if (i16 == i3) {
            return;
        }
        this.mMediaExtractor.unselectTrack(i16);
        if (!selectTrack(i3)) {
            return;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mMediaCodec.release();
            this.mMediaCodec = null;
        }
        if (!initMediaCodec()) {
            return;
        }
        try {
            this.mMediaCodec.start();
        } catch (Throwable th5) {
            Log.e(TAG, "Cannot start the audio codec", th5);
        }
    }

    public void stop() {
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mMediaExtractor = null;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mMediaCodec.release();
            this.mMediaCodec = null;
        }
        this.mDecodeEOS = false;
    }
}
