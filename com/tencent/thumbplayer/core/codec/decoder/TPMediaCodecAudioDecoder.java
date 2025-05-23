package com.tencent.thumbplayer.core.codec.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.codec.common.TPDecoderUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@RequiresApi(api = 16)
/* loaded from: classes26.dex */
public class TPMediaCodecAudioDecoder extends TPBaseMediaCodecDecoder {
    private static final String TAG = "TPMediaCodecAudioDecoder";
    private int mAudioFormat;
    private int mChannelCount;
    private int mChannelMask;
    private byte[] mCsd0Data;
    private boolean mEnableAudioPassThrough;
    private boolean mIsAdts;
    private ArrayList<String> mMimeCandidates;
    private int mSampleRate;

    public TPMediaCodecAudioDecoder(int i3) {
        super(i3);
        this.mMimeCandidates = new ArrayList<>();
        this.mSampleRate = 0;
        this.mChannelCount = 0;
        this.mChannelMask = 0;
        this.mAudioFormat = 0;
        this.mCsd0Data = null;
        this.mIsAdts = false;
        this.mEnableAudioPassThrough = false;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void configCodec(@NonNull TMediaCodec tMediaCodec, @NonNull String str) {
        TPNativeLog.printLog(2, TAG, "configCodec: ");
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(str, this.mSampleRate, this.mChannelCount);
        byte[] bArr = this.mCsd0Data;
        if (bArr != null) {
            createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        }
        if (this.mIsAdts) {
            TPNativeLog.printLog(2, TAG, "configCodec: set is adts");
            createAudioFormat.setInteger("is-adts", 1);
        }
        tMediaCodec.configure(createAudioFormat, (Surface) null, this.mMediaCrypto, 0);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    String getCodecName(@NonNull String str, boolean z16) {
        return TPDecoderUtils.getDecoderName(str, z16);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int getMediaType() {
        return 1;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i3, int i16, int i17, Surface surface, int i18, int i19, int i26) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void processOutputBuffer(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo, @NonNull TPFrameInfo tPFrameInfo) {
        byte[] bArr;
        tPFrameInfo.sampleRate = this.mSampleRate;
        tPFrameInfo.channelCount = this.mChannelCount;
        tPFrameInfo.channelMask = this.mChannelMask;
        tPFrameInfo.format = this.mAudioFormat;
        ByteBuffer outputBuffer = tMediaCodec.getOutputBuffer(i3);
        if (outputBuffer != null) {
            int i16 = bufferInfo.size;
            bArr = new byte[i16];
            outputBuffer.get(bArr, bufferInfo.offset, i16);
        } else {
            bArr = null;
        }
        tPFrameInfo.data = bArr;
        if (bufferInfo.flags == 4 && bufferInfo.size <= 0) {
            TPNativeLog.printLog(2, TAG, "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
            tPFrameInfo.errCode = 2;
        }
        tMediaCodec.releaseOutputBuffer(i3, false);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void processOutputConfigData(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo, @NonNull TPFrameInfo tPFrameInfo) {
        tMediaCodec.releaseOutputBuffer(i3, false);
        tPFrameInfo.errCode = 1;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void processOutputFormatChanged(@NonNull MediaFormat mediaFormat) {
        int i3;
        int i16;
        try {
            if (mediaFormat.containsKey("sample-rate")) {
                this.mSampleRate = mediaFormat.getInteger("sample-rate");
            }
            if (mediaFormat.containsKey("channel-count")) {
                this.mChannelCount = mediaFormat.getInteger("channel-count");
            }
            if (mediaFormat.containsKey("channel-mask")) {
                this.mChannelMask = mediaFormat.getInteger("channel-mask");
            }
            if (Build.VERSION.SDK_INT >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i16 = mediaFormat.getInteger("pcm-encoding");
                try {
                    TPNativeLog.printLog(2, TAG, "processOutputFormatChanged: MediaFormat.KEY_PCM_ENCODING: " + i16);
                } catch (Exception e16) {
                    i3 = i16;
                    e = e16;
                    TPNativeLog.printLog(0, TAG, "processOutputFormatChanged got one exception: " + getStackTrace(e));
                    i16 = i3;
                    TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + ", mChannelMask: " + this.mChannelMask + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i16);
                }
            } else {
                i16 = 2;
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 2;
        }
        TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + ", mChannelMask: " + this.mChannelMask + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i16);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int setOperateRate(float f16) {
        return super.setOperateRate(f16);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamBool(int i3, boolean z16) {
        if (i3 == 2) {
            this.mIsAdts = z16;
            return true;
        }
        if (i3 == 3) {
            this.mEnableAudioPassThrough = z16;
            TPNativeLog.printLog(2, getLogTag(), "setParamBool mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
            return true;
        }
        return super.setParamBool(i3, z16);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamBytes(int i3, byte[] bArr) {
        if (i3 == 200) {
            this.mCsd0Data = bArr;
        }
        return super.setParamBytes(i3, bArr);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamObject(int i3, Object obj) {
        return super.setParamObject(i3, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    public ArrayList<String> getMimeCandidates() {
        return this.mMimeCandidates;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i3, int i16, int i17, int i18) {
        TPNativeLog.printLog(2, TAG, "initDecoder, mimeType:" + str + " sampleRate:" + i3 + " channelCount:" + i16 + " drmType:" + i17 + " audioFormat:" + i18);
        this.mSampleRate = i3;
        this.mChannelCount = i16;
        this.mDrmType = i17;
        this.mAudioFormat = i18;
        this.mMimeCandidates.clear();
        this.mMimeCandidates.add(str);
        buildMediaCryptoIfNeeded();
        return true;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void processMediaCodecException(Exception exc) {
    }
}
