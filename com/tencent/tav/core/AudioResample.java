package com.tencent.tav.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.IAVResample;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.factory.AVResampleFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioResample {
    public final String TAG;

    @Nullable
    private IAVResample avResample;
    private final AudioInfo destAudioInfo;
    private ByteBuffer destBuffer;
    private AudioInfo srcAudioInfo;

    public AudioResample() {
        this(newDefaultDestAudioInfo());
    }

    private void checkReleaseResample() {
        IAVResample iAVResample = this.avResample;
        if (iAVResample != null) {
            iAVResample.release();
            this.avResample = null;
        }
    }

    private boolean compareAudioInfo(@NonNull AudioInfo audioInfo) {
        AudioInfo audioInfo2 = this.srcAudioInfo;
        if (audioInfo2 == null || audioInfo2.pcmEncoding != audioInfo.pcmEncoding || audioInfo2.channelCount != audioInfo.channelCount || audioInfo2.sampleRate != audioInfo.sampleRate) {
            return false;
        }
        return true;
    }

    @NonNull
    private static AudioInfo newDefaultDestAudioInfo() {
        AudioInfo audioInfo = new AudioInfo();
        audioInfo.channelCount = 1;
        audioInfo.sampleRate = 44100;
        audioInfo.pcmEncoding = 2;
        return audioInfo;
    }

    public AudioInfo getDestAudioInfo() {
        return this.destAudioInfo;
    }

    public void release() {
        Logger.d(this.TAG, "release() called");
        checkReleaseResample();
    }

    @Nullable
    public ByteBuffer resample(ByteBuffer byteBuffer, AudioInfo audioInfo) {
        String str;
        Logger.v(this.TAG, "resample() called with: srcBuffer = [" + byteBuffer + "], srcAudioInfo = [" + audioInfo + "]\uff0c thread = " + Thread.currentThread().getName());
        if (!compareAudioInfo(audioInfo)) {
            checkReleaseResample();
            AVResampleFactory aVResampleFactory = AVResampleFactory.getInstance();
            int i3 = audioInfo.sampleRate;
            int i16 = audioInfo.channelCount;
            AudioInfo audioInfo2 = this.destAudioInfo;
            IAVResample newAVResample = aVResampleFactory.newAVResample(i3, i16, audioInfo2.sampleRate, audioInfo2.channelCount);
            this.avResample = newAVResample;
            this.srcAudioInfo = audioInfo;
            if (newAVResample != null) {
                str = newAVResample.getClass().getName();
            } else {
                str = "null";
            }
            Logger.i(this.TAG, "resample: class = " + str + ", srcAudioInfo = " + audioInfo + ", thread = " + Thread.currentThread().getName());
        }
        IAVResample iAVResample = this.avResample;
        if (iAVResample == null) {
            return null;
        }
        byte[] resample = iAVResample.resample(byteBuffer, byteBuffer.limit());
        if (resample == null) {
            Logger.w(this.TAG, "outBytes == null\uff0csrcBuffer = " + byteBuffer);
            return null;
        }
        ByteBuffer byteBuffer2 = this.destBuffer;
        if (byteBuffer2 == null || resample.length > byteBuffer2.limit()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(resample.length);
            this.destBuffer = allocateDirect;
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.destBuffer.clear();
        this.destBuffer.put(resample);
        this.destBuffer.position(0);
        this.destBuffer.limit(resample.length);
        return this.destBuffer;
    }

    public AudioResample(AudioInfo audioInfo) {
        String str = "AudioResample@" + Integer.toHexString(hashCode());
        this.TAG = str;
        this.destAudioInfo = audioInfo;
        Logger.i(str, "AudioResample() called with: destAudioInfo = [" + audioInfo + "], thread = " + Thread.currentThread().getName());
    }
}
