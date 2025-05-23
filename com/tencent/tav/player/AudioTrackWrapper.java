package com.tencent.tav.player;

import android.media.AudioTrack;
import android.media.MediaFormat;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.tav.decoder.logger.Logger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioTrackWrapper {
    private static final String TAG = "AudioTrackWrapper";
    private AudioTrack mAudioTrack;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class AudioTrackConfig {
        int sampleRateInHz;
        int streamType = 3;
        int channelConfig = 12;
        int audioFormat = 2;
        int mode = 1;
        int bufferSizeInBytes = 8192;

        public AudioTrackConfig(int i3, int i16) {
            this.sampleRateInHz = getSampleRateInHz(i3, i16);
        }

        private int getSampleRateInHz(int i3, int i16) {
            if (i16 == 1) {
                return i3 / 2;
            }
            return i3;
        }

        public String toString() {
            return "AudioTrackConfig{streamType=" + this.streamType + ", sampleRateInHz=" + this.sampleRateInHz + ", channelConfig=" + this.channelConfig + ", audioFormat=" + this.audioFormat + ", bufferSizeInBytes=" + this.bufferSizeInBytes + ", mode=" + this.mode + '}';
        }
    }

    public AudioTrackWrapper(MediaFormat mediaFormat) {
        try {
            init(mediaFormat.getInteger("sample-rate"), mediaFormat.getInteger("channel-count"));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void init(int i3, int i16) throws Exception {
        if (i3 <= 0) {
            return;
        }
        AudioTrackConfig audioTrackConfig = new AudioTrackConfig(i3, i16);
        Log.d(TAG, "init:--> " + this);
        try {
            this.mAudioTrack = new ReportAudioTrack(audioTrackConfig.streamType, audioTrackConfig.sampleRateInHz, audioTrackConfig.channelConfig, audioTrackConfig.audioFormat, audioTrackConfig.bufferSizeInBytes, audioTrackConfig.mode);
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            this.mAudioTrack = null;
        }
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.play();
        }
    }

    public boolean allow() {
        if (this.mAudioTrack != null) {
            return true;
        }
        return false;
    }

    public void flush() {
        if (!allow()) {
            return;
        }
        try {
            AudioTrack audioTrack = this.mAudioTrack;
            if (audioTrack != null) {
                audioTrack.flush();
            }
        } catch (Exception e16) {
            Logger.e(TAG, "flush: ", e16);
        }
    }

    public void parse() {
        AudioTrack audioTrack;
        if (allow() && (audioTrack = this.mAudioTrack) != null && audioTrack.getPlayState() == 3) {
            this.mAudioTrack.pause();
        }
    }

    public void release() {
        if (!allow()) {
            return;
        }
        stop();
        this.mAudioTrack.release();
        Log.d(TAG, "release:--> " + this);
    }

    public void setVolume(float f16) {
        if (!allow()) {
            return;
        }
        this.mAudioTrack.setVolume(f16);
    }

    public void stop() {
        if (!allow()) {
            return;
        }
        if (this.mAudioTrack.getState() == 3 || this.mAudioTrack.getState() == 2) {
            this.mAudioTrack.stop();
        }
    }

    public void writeData(byte[] bArr, int i3, int i16) {
        AudioTrack audioTrack;
        if (allow() && (audioTrack = this.mAudioTrack) != null) {
            try {
                audioTrack.write(bArr, i3, i16);
                if (this.mAudioTrack.getPlayState() != 3) {
                    this.mAudioTrack.play();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public AudioTrackWrapper(int i3, int i16) {
        try {
            init(i3, i16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
