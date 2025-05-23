package com.tencent.tav.core;

import com.tencent.tav.core.AudioMixInputParameters;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioMix<InputParameters extends AudioMixInputParameters> {
    protected List<InputParameters> inputParameters;

    public AudioMix(List<InputParameters> list) {
        this.inputParameters = list;
    }

    public List<InputParameters> getInputParameters() {
        return this.inputParameters;
    }

    public InputParameters getInputParametersWithTrackID(int i3) {
        for (InputParameters inputparameters : this.inputParameters) {
            if (inputparameters.getTrackID() == i3) {
                return inputparameters;
            }
        }
        return null;
    }

    public void release() {
        for (InputParameters inputparameters : this.inputParameters) {
            if (inputparameters != null && inputparameters.getAudioTapProcessor() != null) {
                inputparameters.getAudioTapProcessor().release();
            }
        }
    }

    public String toString() {
        return "AudioMix{inputParameters=" + this.inputParameters + '}';
    }
}
