package com.tencent.tav.quick.export;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.quick.export.muxer.QuickMuxer;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SegmentCombiner {
    public static final String AUDIO_MIME_PREFIX = "audio/";
    private static final int MAX_BUFF_SIZE = 2073600;
    private static final int MAX_RETRY_TIMES = 3;
    public static final String MIME = "mime";
    private static final String TAG = QuickExporter.TAG + "_" + SegmentCombiner.class.getSimpleName();
    private static final boolean VERBOSE = false;
    public static final String VIDEO_MIME_PREFIX = "video/";
    private MediaFormat mAudioFormat;
    private VideoCombineListener mCombineListener;
    private String mDestPath;
    private MediaMuxer mMuxer;
    private String mOriginalVideoPath;
    private int mOutAudioTrackIndex;
    private int mOutVideoTrackIndex;
    private CountDownLatch mSegmentAllFinish;
    private int mSegmentSize;
    private MediaFormat mVideoFormat;
    private List<String> mVideoList;
    private boolean mIsMuxerStarted = false;
    private IMediaMuxer mSegmentMuxer = null;
    private long mFrameDurationUs = 33333;
    private MediaExtractor mAudioExtractor = null;
    private int mInAudioTrackIndex = -1;
    private boolean mHasAudioFormat = true;
    private volatile int mRetryTimes = 0;
    private boolean mIsCombineSuc = false;
    private volatile boolean mIsCombineRelease = false;
    private volatile boolean mIsCancelled = false;
    private ByteBuffer mReadBuf = ByteBuffer.allocate(MAX_BUFF_SIZE);

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface VideoCombineListener {
        void onCombineFinished(boolean z16);

        void onCombineProcessing(float f16);

        void onCombineStart();
    }

    public SegmentCombiner(List<String> list, String str, String str2, VideoCombineListener videoCombineListener, @NonNull CountDownLatch countDownLatch) {
        this.mSegmentAllFinish = null;
        this.mSegmentSize = 1;
        this.mVideoList = list;
        this.mSegmentSize = list.size();
        this.mOriginalVideoPath = str;
        this.mDestPath = str2;
        this.mCombineListener = videoCombineListener;
        this.mSegmentAllFinish = countDownLatch;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7 A[Catch: Exception -> 0x01af, TryCatch #0 {Exception -> 0x01af, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000d, B:104:0x0013, B:11:0x0017, B:13:0x001d, B:17:0x0027, B:19:0x002d, B:21:0x0031, B:23:0x0053, B:24:0x0056, B:26:0x005f, B:27:0x0065, B:31:0x006f, B:35:0x0077, B:38:0x0086, B:39:0x0093, B:42:0x00a2, B:46:0x00bd, B:49:0x00c7, B:51:0x00cd, B:52:0x00f6, B:55:0x0101, B:57:0x010f, B:58:0x0116, B:60:0x011e, B:61:0x0120, B:63:0x0114, B:66:0x008f, B:71:0x013a, B:73:0x0143, B:75:0x014d, B:85:0x0156, B:86:0x0161, B:90:0x0163, B:91:0x0187, B:93:0x0188, B:95:0x0191, B:96:0x019c, B:101:0x01a2), top: B:3:0x0003, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void combineVideoWithInnerMuxer() {
        long j3;
        int i3;
        MediaExtractor mediaExtractor;
        int i16;
        int readSampleData;
        Iterator<String> it;
        String str;
        while (true) {
            int i17 = 0;
            try {
                if (!neededRetry() || this.mIsCancelled) {
                    break;
                }
                if (!startInnerMuxer()) {
                    retry();
                } else {
                    Iterator<String> it5 = this.mVideoList.iterator();
                    try {
                        this.mSegmentAllFinish.await();
                        long j16 = 0;
                        long j17 = 0;
                        int i18 = 1;
                        while (it5.hasNext() && !this.mIsCancelled) {
                            String next = it5.next();
                            Logger.i(TAG, "Current combine video " + next);
                            MediaExtractor mediaExtractor2 = new MediaExtractor();
                            try {
                                mediaExtractor2.setDataSource(next);
                                int selectTrack = DecoderUtils.selectTrack(mediaExtractor2, "video/");
                                if (selectTrack >= 0) {
                                    mediaExtractor2.selectTrack(selectTrack);
                                    int i19 = 1;
                                    long j18 = 0;
                                    while (!this.mIsCancelled && i19 != 0 && i18 != 0) {
                                        if (this.mHasAudioFormat && i18 != 0) {
                                            if (i19 != 0) {
                                                j3 = j16;
                                                if (j17 - (j18 + j16) <= this.mFrameDurationUs) {
                                                }
                                            } else {
                                                j3 = j16;
                                            }
                                            i16 = this.mInAudioTrackIndex;
                                            i3 = this.mOutAudioTrackIndex;
                                            mediaExtractor = this.mAudioExtractor;
                                            this.mReadBuf.rewind();
                                            readSampleData = mediaExtractor.readSampleData(this.mReadBuf, i17);
                                            if (readSampleData >= 0) {
                                                if (i16 == selectTrack) {
                                                    Logger.d(TAG, "using videoExtractor end " + next);
                                                    it = it5;
                                                    i19 = i17;
                                                } else {
                                                    it = it5;
                                                    if (i16 == this.mInAudioTrackIndex) {
                                                        i18 = i17;
                                                    }
                                                }
                                                str = next;
                                            } else {
                                                if (mediaExtractor.getSampleTrackIndex() != i16) {
                                                    String str2 = TAG;
                                                    StringBuilder sb5 = new StringBuilder();
                                                    it = it5;
                                                    sb5.append("got sample from track ");
                                                    sb5.append(mediaExtractor.getSampleTrackIndex());
                                                    sb5.append(", expected ");
                                                    sb5.append(i16);
                                                    Logger.e(str2, sb5.toString());
                                                } else {
                                                    it = it5;
                                                }
                                                int i26 = i18;
                                                str = next;
                                                long sampleTime = mediaExtractor.getSampleTime();
                                                if (i16 == selectTrack) {
                                                    j18 = sampleTime;
                                                } else {
                                                    j17 = sampleTime;
                                                }
                                                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                                                long j19 = j17;
                                                bufferInfo.offset = 0;
                                                bufferInfo.size = readSampleData;
                                                if (i16 == selectTrack) {
                                                    bufferInfo.presentationTimeUs = j3 + sampleTime;
                                                } else {
                                                    bufferInfo.presentationTimeUs = sampleTime;
                                                }
                                                if ((mediaExtractor.getSampleFlags() & 1) != 0) {
                                                    bufferInfo.flags = 1;
                                                }
                                                this.mReadBuf.rewind();
                                                this.mMuxer.writeSampleData(i3, this.mReadBuf, bufferInfo);
                                                mediaExtractor.advance();
                                                i18 = i26;
                                                j17 = j19;
                                            }
                                            next = str;
                                            j16 = j3;
                                            it5 = it;
                                            i17 = 0;
                                        } else {
                                            j3 = j16;
                                        }
                                        i3 = this.mOutVideoTrackIndex;
                                        mediaExtractor = mediaExtractor2;
                                        i16 = selectTrack;
                                        this.mReadBuf.rewind();
                                        readSampleData = mediaExtractor.readSampleData(this.mReadBuf, i17);
                                        if (readSampleData >= 0) {
                                        }
                                        next = str;
                                        j16 = j3;
                                        it5 = it;
                                        i17 = 0;
                                    }
                                    Iterator<String> it6 = it5;
                                    long j26 = j16;
                                    int i27 = i18;
                                    if (!this.mHasAudioFormat) {
                                        j16 = j26 + j18;
                                    } else {
                                        if (j18 <= j17) {
                                            j18 = j17;
                                        }
                                        j16 = j18;
                                    }
                                    mediaExtractor2.release();
                                    i18 = i27;
                                    it5 = it6;
                                    i17 = 0;
                                } else {
                                    mediaExtractor2.release();
                                    throw new RuntimeException("Has not video track");
                                }
                            } catch (IOException e16) {
                                mediaExtractor2.release();
                                Logger.e(TAG, "video extractor set data source failed, videoPath " + next, e16);
                                throw new RuntimeException("video Extractor init error");
                            }
                        }
                        this.mAudioExtractor.release();
                        MediaMuxer mediaMuxer = this.mMuxer;
                        if (mediaMuxer != null) {
                            mediaMuxer.stop();
                            this.mMuxer.release();
                            this.mMuxer = null;
                        }
                        this.mIsCombineSuc = true;
                    } catch (InterruptedException e17) {
                        Logger.e(TAG, "segment countDownLatch wait error ", e17);
                        retry();
                    }
                }
            } catch (Exception e18) {
                Logger.e(TAG, "Combine Video failed " + e18.getMessage());
                this.mIsCombineSuc = false;
            }
        }
        if (this.mCombineListener != null && !this.mIsCombineRelease && !this.mIsCancelled) {
            Logger.i(TAG, "segment combiner  result: " + this.mIsCombineSuc);
            this.mCombineListener.onCombineFinished(this.mIsCombineSuc);
        }
        deleteSegVideos();
    }

    private void combineVideoWithOuterMuxer() {
        IMediaMuxer iMediaMuxer = this.mSegmentMuxer;
        if (iMediaMuxer != null && (iMediaMuxer instanceof QuickMuxer)) {
            MediaExtractor audioExtractor = ((QuickMuxer) iMediaMuxer).getAudioExtractor();
            if (audioExtractor == null) {
                Logger.e(TAG, "audioExtractor is null");
                return;
            }
            while (neededRetry() && !this.mIsCancelled) {
                while (!this.mIsCancelled) {
                    int audioTrackIndex = this.mSegmentMuxer.audioTrackIndex();
                    this.mReadBuf.rewind();
                    int readSampleData = audioExtractor.readSampleData(this.mReadBuf, 0);
                    if (readSampleData < 0) {
                        Logger.d(TAG, "quick muxer write audio size " + readSampleData);
                        break;
                    }
                    long sampleTime = audioExtractor.getSampleTime();
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    bufferInfo.offset = 0;
                    bufferInfo.size = readSampleData;
                    bufferInfo.presentationTimeUs = sampleTime;
                    if ((audioExtractor.getSampleFlags() & 1) != 0) {
                        bufferInfo.flags = 1;
                    }
                    this.mReadBuf.rewind();
                    this.mSegmentMuxer.writeSampleData(audioTrackIndex, this.mReadBuf, bufferInfo);
                    audioExtractor.advance();
                }
                try {
                    this.mSegmentMuxer.stop();
                    this.mSegmentMuxer.release();
                    this.mSegmentMuxer = null;
                    this.mIsCombineSuc = true;
                } catch (Exception e16) {
                    Logger.e(TAG, "combineVideoWithOuterMuxer failed ", e16);
                    retry();
                }
            }
            audioExtractor.release();
            return;
        }
        Logger.e(TAG, "mSegmentMuxer is null or not QuickMuxer");
    }

    private void deleteSegVideos() {
        Iterator<String> it = this.mVideoList.iterator();
        while (it.hasNext()) {
            new File(it.next()).delete();
        }
    }

    private boolean neededRetry() {
        if (this.mRetryTimes < 3 && !this.mIsCombineSuc) {
            return true;
        }
        return false;
    }

    private void retry() {
        this.mRetryTimes++;
    }

    private boolean startInnerMuxer() {
        if (this.mIsMuxerStarted) {
            return true;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.mAudioExtractor = mediaExtractor;
        try {
            mediaExtractor.setDataSource(this.mOriginalVideoPath);
            int selectTrack = DecoderUtils.selectTrack(this.mAudioExtractor, "audio/");
            this.mInAudioTrackIndex = selectTrack;
            if (selectTrack < 0) {
                this.mHasAudioFormat = false;
                Logger.e(TAG, "No audio track found in ");
            } else {
                this.mAudioExtractor.selectTrack(selectTrack);
                this.mAudioFormat = this.mAudioExtractor.getTrackFormat(this.mInAudioTrackIndex);
                this.mHasAudioFormat = true;
            }
            try {
                MediaMuxer mediaMuxer = new MediaMuxer(this.mDestPath, 0);
                this.mMuxer = mediaMuxer;
                MediaFormat mediaFormat = this.mVideoFormat;
                if (mediaFormat != null) {
                    this.mOutVideoTrackIndex = mediaMuxer.addTrack(mediaFormat);
                }
                if (this.mHasAudioFormat) {
                    this.mOutAudioTrackIndex = this.mMuxer.addTrack(this.mAudioFormat);
                }
                this.mMuxer.start();
                this.mIsMuxerStarted = true;
                return true;
            } catch (IOException e16) {
                Logger.e(TAG, "make media muxer failed ", e16);
                return false;
            }
        } catch (IOException e17) {
            Logger.e(TAG, "create input video media extractor failed " + e17.getMessage());
            return false;
        }
    }

    public void cancel() {
        Logger.i(TAG, "segment combiner canceled");
        this.mIsCancelled = true;
    }

    @SuppressLint({"WrongConstant"})
    public void combineVideo() {
        if (TextUtils.isEmpty(this.mOriginalVideoPath)) {
            this.mCombineListener.onCombineFinished(false);
        } else if (this.mSegmentSize == 1) {
            combineVideoWithOuterMuxer();
        } else {
            combineVideoWithInnerMuxer();
        }
    }

    public void release() {
        this.mRetryTimes = 3;
        this.mIsCombineRelease = true;
        String str = TAG;
        Logger.i(str, "combine release delete");
        if (this.mSegmentSize != 1) {
            deleteSegVideos();
            Logger.e(str, "combine release delete file delete");
        }
        this.mIsMuxerStarted = false;
        try {
            MediaExtractor mediaExtractor = this.mAudioExtractor;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
        } catch (Exception e16) {
            Logger.e(TAG, "SegCombiner mAudioExtractor release error", e16);
        }
        MediaMuxer mediaMuxer = this.mMuxer;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
            } catch (Exception e17) {
                Logger.e(TAG, "SegCombiner mMuxer top error", e17);
            }
            try {
                this.mMuxer.release();
            } catch (Exception e18) {
                Logger.e(TAG, "SegCombiner mMuxer release error", e18);
            }
        }
        IMediaMuxer iMediaMuxer = this.mSegmentMuxer;
        if (iMediaMuxer != null) {
            try {
                iMediaMuxer.stop();
            } catch (Exception e19) {
                Logger.e(TAG, "SegCombiner mSegmentMuxer top error", e19);
            }
            try {
                this.mSegmentMuxer.release();
            } catch (Exception e26) {
                Logger.e(TAG, "SegCombiner mSegmentMuxer release error", e26);
            }
        }
    }

    public void setSegmentMuxer(IMediaMuxer iMediaMuxer) {
        this.mSegmentMuxer = iMediaMuxer;
    }

    public void setVideoFormat(MediaFormat mediaFormat) {
        this.mVideoFormat = mediaFormat;
    }
}
