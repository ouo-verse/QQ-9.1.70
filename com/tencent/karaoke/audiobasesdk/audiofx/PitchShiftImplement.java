package com.tencent.karaoke.audiobasesdk.audiofx;

/* loaded from: classes7.dex */
public class PitchShiftImplement {
    public static final int PITCH_TYPE_DEFAULT = 0;
    public static final int PITCH_TYPE_RUBBER = 1;
    private PitchInterface mPitchImp;

    public boolean init(int i3, int i16, int i17) {
        boolean init;
        if (i17 == 1) {
            KaraAudioRubber karaAudioRubber = new KaraAudioRubber();
            init = karaAudioRubber.init(i3, i16);
            if (init) {
                karaAudioRubber.setPitchShift(0);
                this.mPitchImp = karaAudioRubber;
            }
        } else {
            PitchShift pitchShift = new PitchShift();
            init = pitchShift.init(i3, i16);
            if (init) {
                pitchShift.setPitchShift(0);
                this.mPitchImp = pitchShift;
            }
        }
        return init;
    }

    public int process(byte[] bArr, int i3) {
        PitchInterface pitchInterface = this.mPitchImp;
        if (pitchInterface != null) {
            return pitchInterface.process(bArr, i3);
        }
        return -10;
    }

    public int processLast(byte[] bArr, int i3) {
        PitchInterface pitchInterface = this.mPitchImp;
        if (pitchInterface != null) {
            return pitchInterface.processLast(bArr, i3);
        }
        return -10;
    }

    public void release() {
        PitchInterface pitchInterface = this.mPitchImp;
        if (pitchInterface != null) {
            pitchInterface.release();
            this.mPitchImp = null;
        }
    }

    public int seek() {
        PitchInterface pitchInterface = this.mPitchImp;
        if (pitchInterface != null) {
            return pitchInterface.seek();
        }
        return -1;
    }

    public void setPitchShift(int i3) {
        PitchInterface pitchInterface = this.mPitchImp;
        if (pitchInterface != null) {
            pitchInterface.setPitchShift(i3);
        }
    }
}
