package com.tencent.qqmusic.mediaplayer.codec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@TargetApi(23)
/* loaded from: classes23.dex */
public class MediaCodecDecoder extends BaseDecoder {
    private static final int CONTINUOUS_TIMEOUT_COUNT = 500;
    private static final String KEY_BIT_RATE = "bit-rate";
    private static final String KEY_PCM_ENCODING = "pcm-encoding";
    private static final String TAG = "MediaCodecDecoder";
    private static final long TIMEOUT_AUTO_SEEK_INTERVAL_MS = 5000;
    private static final int TIMEOUT_US = 1000;
    private final MediaExtractor mMediaExtractor = new MediaExtractor();
    private MediaCodec mMediaCodec = null;
    private AudioInformation mInfo = null;
    private boolean mDecoderFinished = false;
    private long mCurrentDecodeTime = 0;
    private volatile byte[] mRemainBuffer = null;
    private SeekTable mSeekTable = null;
    private long mFileSize = 0;

    @NonNull
    private WeakReference<AudioTrack> mAudioTrackRef = new WeakReference<>(null);

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class BufferTimeoutException extends Exception {
        public BufferTimeoutException() {
            super("buffer timeout exception");
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class NullInputBufferException extends Exception {
        public NullInputBufferException() {
            super("Null Input Buffer exception");
        }
    }

    private int decodeDataInternal(int i3, byte[] bArr) throws BufferTimeoutException {
        int processInputOutputBuffer;
        byte[] bArr2 = this.mRemainBuffer;
        int i16 = 0;
        if (bArr2 != null && bArr2.length > 0) {
            if (i3 >= bArr2.length) {
                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                int length = bArr2.length;
                this.mRemainBuffer = null;
                return length;
            }
            System.arraycopy(bArr2, 0, bArr, 0, i3);
            int length2 = bArr2.length - i3;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr2, i3, bArr3, 0, length2);
            this.mRemainBuffer = bArr3;
            return i3;
        }
        if (this.mMediaCodec != null) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int i17 = 0;
            int i18 = 0;
            while (!this.mDecoderFinished && i17 <= 0) {
                try {
                    processInputOutputBuffer = processInputOutputBuffer(bufferInfo);
                } catch (NullInputBufferException unused) {
                }
                if (processInputOutputBuffer != -3) {
                    if (processInputOutputBuffer != -2) {
                        if (processInputOutputBuffer != -1) {
                            ByteBuffer outputBuffer = this.mMediaCodec.getOutputBuffer(processInputOutputBuffer);
                            if (outputBuffer != null) {
                                i17 = Math.min(Math.min(i3, outputBuffer.remaining()), bArr.length);
                                outputBuffer.get(bArr, 0, i17);
                                int i19 = bufferInfo.size;
                                if (i19 > i3) {
                                    int i26 = i19 - i3;
                                    this.mRemainBuffer = new byte[i26];
                                    outputBuffer.get(this.mRemainBuffer, 0, i26);
                                }
                                outputBuffer.clear();
                                this.mMediaCodec.releaseOutputBuffer(processInputOutputBuffer, false);
                                long j3 = this.mCurrentDecodeTime;
                                this.mCurrentDecodeTime = bufferInfo.presentationTimeUs / 1000;
                                AudioInformation audioInformation = this.mInfo;
                                if (audioInformation != null && audioInformation.getBitDepth() == 0) {
                                    this.mInfo.setBitDept(AudioRecognition.calcBitDept(bufferInfo.size, this.mCurrentDecodeTime - j3, this.mInfo.getChannels(), this.mInfo.getSampleRate()));
                                }
                            }
                        } else {
                            i18++;
                            Logger.i(TAG, "dequeueOutputBuffer timed out!");
                            if (i18 == 500) {
                                throw new BufferTimeoutException();
                            }
                        }
                    } else {
                        MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
                        AudioTrack audioTrack = this.mAudioTrackRef.get();
                        if (audioTrack != null && outputFormat != null) {
                            audioTrack.setPlaybackRate(outputFormat.getInteger("sample-rate"));
                        }
                        Logger.i(TAG, "New format " + outputFormat);
                    }
                } else {
                    Logger.i(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                }
                if ((bufferInfo.flags & 4) != 0) {
                    this.mDecoderFinished = true;
                    this.mCurrentDecodeTime = getDuration();
                    Logger.i(TAG, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                }
            }
            i16 = i17;
        }
        return i16;
    }

    public static AudioFormat.AudioType getAudioType(String str) throws IOException {
        boolean z16;
        AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            z16 = true;
        } catch (Throwable th5) {
            Logger.e(TAG, "getAudioType", th5);
            z16 = false;
        }
        if (!z16) {
            return audioType;
        }
        FileDataSource fileDataSource = new FileDataSource(str);
        fileDataSource.open();
        AudioFormat.AudioType audioType2 = getAudioType(mediaExtractor, fileDataSource);
        fileDataSource.close();
        return audioType2;
    }

    private static MediaFormat getMediaFormatByExtractor(MediaExtractor mediaExtractor) {
        for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
            String string = trackFormat.getString("mime");
            if (!TextUtils.isEmpty(string) && string.startsWith("audio")) {
                return trackFormat;
            }
        }
        return null;
    }

    private boolean initAudioInformation(String str, int i3, MediaFormat mediaFormat, IDataSource iDataSource, AudioFormat.AudioType audioType) throws Exception {
        MediaFormat mediaFormat2;
        this.mMediaExtractor.selectTrack(i3);
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(str);
        this.mMediaCodec = createDecoderByType;
        createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        this.mMediaCodec.start();
        int i16 = -1;
        for (int i17 = 0; i17 < 500 && (i16 == -1 || i16 == -3); i17++) {
            try {
                i16 = processInputOutputBuffer(new MediaCodec.BufferInfo());
            } catch (NullInputBufferException unused) {
            }
            if (i16 == -2) {
                mediaFormat2 = this.mMediaCodec.getOutputFormat();
                break;
            }
        }
        mediaFormat2 = null;
        if (mediaFormat2 != null) {
            Logger.i(TAG, "format:" + mediaFormat + " outputFormat:" + mediaFormat2);
            String str2 = KEY_PCM_ENCODING;
            if (mediaFormat2.containsKey(str2)) {
                mediaFormat.setInteger(str2, mediaFormat2.getInteger(str2));
            }
            if (mediaFormat2.containsKey("sample-rate")) {
                mediaFormat.setInteger("sample-rate", mediaFormat2.getInteger("sample-rate"));
            }
            if (mediaFormat2.containsKey("channel-count")) {
                mediaFormat.setInteger("channel-count", mediaFormat2.getInteger("channel-count"));
            }
            setAudioInformationByMediaFormat(this.mInfo, mediaFormat, iDataSource.getSize());
            if (audioType == AudioFormat.AudioType.FLAC) {
                this.mSeekTable = new FlacSeekTable((int) this.mInfo.getSampleRate());
            } else if (audioType != AudioFormat.AudioType.M4A && audioType != AudioFormat.AudioType.MP4) {
                if (audioType == AudioFormat.AudioType.MP3) {
                    this.mSeekTable = new Mp3SeekTable();
                }
            } else {
                this.mSeekTable = new Mp4SeekTable();
            }
            SeekTable seekTable = this.mSeekTable;
            if (seekTable != null) {
                try {
                    seekTable.parse(iDataSource);
                } catch (InvalidBoxException e16) {
                    this.mSeekTable = null;
                    Logger.e(TAG, "seek table parse", e16);
                }
            }
            if (this.mInfo.getDuration() <= 0 || this.mInfo.getChannels() < 2) {
                return false;
            }
            return true;
        }
        this.mMediaCodec.release();
        return false;
    }

    private boolean initMediaCodecAndFormat(IDataSource iDataSource) throws Exception {
        for (int i3 = 0; i3 < this.mMediaExtractor.getTrackCount(); i3++) {
            MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i3);
            String string = trackFormat.getString("mime");
            if (!TextUtils.isEmpty(string) && string.startsWith("audio")) {
                this.mInfo = new AudioInformation();
                AudioFormat.AudioType audioType = iDataSource.getAudioType();
                this.mInfo.setAudioType(audioType);
                setAudioType(audioType);
                return initAudioInformation(string, i3, trackFormat, iDataSource, audioType);
            }
        }
        return false;
    }

    private int processInputOutputBuffer(MediaCodec.BufferInfo bufferInfo) throws NullInputBufferException {
        int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(1000L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer inputBuffer = this.mMediaCodec.getInputBuffer(dequeueInputBuffer);
            if (inputBuffer != null) {
                int readSampleData = this.mMediaExtractor.readSampleData(inputBuffer, 0);
                if (readSampleData < 0) {
                    Logger.i(TAG, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                } else {
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mMediaExtractor.getSampleTime(), 0);
                    this.mMediaExtractor.advance();
                }
            } else {
                throw new NullInputBufferException();
            }
        }
        return this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 1000L);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(1:3)(2:36|(1:38)(1:39))|4|(2:6|(1:8)(1:28))(2:29|(2:31|(1:33)(1:34))(1:35))|9|(7:11|(1:13)(1:26)|15|16|(1:(1:19))(1:23)|20|21)|27|15|16|(0)(0)|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007f, code lost:
    
        if (r5 != 4) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void setAudioInformationByMediaFormat(AudioInformation audioInformation, MediaFormat mediaFormat, long j3) {
        int i3;
        long j16;
        int i16;
        int integer = mediaFormat.getInteger("sample-rate");
        int integer2 = mediaFormat.getInteger("channel-count");
        int i17 = 0;
        if (mediaFormat.containsKey("bitrate")) {
            i3 = mediaFormat.getInteger("bitrate") / 1000;
        } else if (mediaFormat.containsKey(KEY_BIT_RATE)) {
            i3 = mediaFormat.getInteger(KEY_BIT_RATE) / 1000;
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            if (mediaFormat.containsKey("durationUs")) {
                j16 = mediaFormat.getLong("durationUs") / 1000;
            } else {
                j16 = (int) ((j3 / i3) * 8);
            }
        } else if (mediaFormat.containsKey("durationUs")) {
            long j17 = mediaFormat.getLong("durationUs") / 1000;
            if (j17 > 0) {
                i3 = (int) ((j3 / j17) * 8);
                j16 = j17;
            } else {
                j16 = j17;
                i3 = 0;
            }
        } else {
            j16 = 0;
        }
        String str = KEY_PCM_ENCODING;
        if (mediaFormat.containsKey(str)) {
            int integer3 = mediaFormat.getInteger(str);
            if (integer3 != 3) {
                i16 = 4;
            } else {
                i16 = 1;
            }
            i17 = mediaFormat.getInteger("bitrate-mode");
            if (i17 == 1) {
                if (i17 == 2) {
                    audioInformation.setCbr(1);
                }
            } else {
                audioInformation.setCbr(3);
            }
            audioInformation.setSampleRate(integer);
            audioInformation.setChannels(integer2);
            audioInformation.setDuration(j16);
            audioInformation.setBitrate(i3);
            audioInformation.setBitDept(i16);
        }
        i16 = 2;
        i17 = mediaFormat.getInteger("bitrate-mode");
        if (i17 == 1) {
        }
        audioInformation.setSampleRate(integer);
        audioInformation.setChannels(integer2);
        audioInformation.setDuration(j16);
        audioInformation.setBitrate(i3);
        audioInformation.setBitDept(i16);
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int decodeData(int i3, byte[] bArr) {
        long currentTime;
        try {
            return decodeDataInternal(i3, bArr);
        } catch (BufferTimeoutException unused) {
            do {
                currentTime = getCurrentTime() + 5000;
                Logger.i(TAG, "decodeData buffer timeout, seekTime:" + currentTime);
                seekTo((int) Math.min(getDuration(), currentTime));
                try {
                    return decodeDataInternal(i3, bArr);
                } catch (BufferTimeoutException unused2) {
                    if (currentTime < getDuration()) {
                        return -1;
                    }
                }
            } while (currentTime < getDuration());
            return -1;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public AudioInformation getAudioInformation() {
        return this.mInfo;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getBytePositionOfTime(long j3) {
        int bitrate = this.mInfo.getBitrate();
        SeekTable seekTable = this.mSeekTable;
        if (seekTable != null) {
            return seekTable.seek(j3);
        }
        if (bitrate > 0) {
            return j3 * bitrate;
        }
        if (getDuration() <= 0) {
            return 0L;
        }
        return (this.mFileSize * j3) / getDuration();
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getCurrentTime() {
        return this.mCurrentDecodeTime;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getDuration() {
        AudioInformation audioInformation = this.mInfo;
        if (audioInformation != null) {
            return audioInformation.getDuration();
        }
        return 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int getErrorCodeMask() {
        return -1;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getMinBufferSize() {
        int i3;
        AudioInformation audioInformation = this.mInfo;
        if (audioInformation != null) {
            int bitDepth = audioInformation.getBitDepth();
            if (bitDepth == 1) {
                i3 = 3;
            } else if (bitDepth == 4) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            return AudioTrack.getMinBufferSize((int) this.mInfo.getSampleRate(), 12, i3);
        }
        return 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public List<NativeLibs> getNativeLibs() {
        return new ArrayList();
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(INativeDataSource iNativeDataSource) {
        return -1;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int release() {
        this.mMediaExtractor.release();
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.release();
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int seekTo(int i3) {
        this.mMediaCodec.flush();
        this.mRemainBuffer = null;
        this.mMediaExtractor.seekTo(i3 * 1000, 2);
        this.mCurrentDecodeTime = i3;
        return i3;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public void setAudioTrack(AudioTrack audioTrack) {
        this.mAudioTrackRef = new WeakReference<>(audioTrack);
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(String str, boolean z16) {
        return init(new FileDataSource(str));
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    @TargetApi(23)
    public int init(final IDataSource iDataSource) {
        if (iDataSource == null) {
            return -1;
        }
        try {
            iDataSource.open();
            this.mMediaExtractor.setDataSource(new MediaDataSource() { // from class: com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder.1
                @Override // android.media.MediaDataSource
                public long getSize() throws IOException {
                    return iDataSource.getSize();
                }

                @Override // android.media.MediaDataSource
                public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
                    return iDataSource.readAt(j3, bArr, i3, i16);
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                }
            });
            this.mFileSize = iDataSource.getSize();
            return initMediaCodecAndFormat(iDataSource) ? 0 : -1;
        } catch (Throwable th5) {
            Logger.e(TAG, "init", th5);
            return -1;
        }
    }

    @TargetApi(16)
    private static AudioFormat.AudioType getAudioType(MediaExtractor mediaExtractor, IDataSource iDataSource) {
        AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
        MediaFormat mediaFormatByExtractor = getMediaFormatByExtractor(mediaExtractor);
        if (mediaFormatByExtractor == null) {
            return audioType;
        }
        String string = mediaFormatByExtractor.getString("mime");
        if (TextUtils.isEmpty(string) || !string.startsWith("audio")) {
            return audioType;
        }
        char c16 = '\uffff';
        switch (string.hashCode()) {
            case -1003765268:
                if (string.equals("audio/vorbis")) {
                    c16 = 0;
                    break;
                }
                break;
            case -53558318:
                if (string.equals("audio/mp4a-latm")) {
                    c16 = 1;
                    break;
                }
                break;
            case 187094639:
                if (string.equals("audio/raw")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1504619009:
                if (string.equals("audio/flac")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1504831518:
                if (string.equals("audio/mpeg")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return AudioFormat.AudioType.OGG;
            case 1:
                return FfmpegRecognition.isM4a(iDataSource) ? AudioFormat.AudioType.M4A : audioType;
            case 2:
                if (FLACRecognition.isFlac(iDataSource)) {
                    return AudioFormat.AudioType.FLAC;
                }
                return WavRecognition.isWav(iDataSource) ? AudioFormat.AudioType.WAV : audioType;
            case 3:
                return AudioFormat.AudioType.FLAC;
            case 4:
                return AudioFormat.AudioType.MP3;
            default:
                return audioType;
        }
    }
}
