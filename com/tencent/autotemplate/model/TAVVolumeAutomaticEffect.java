package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVVolumeAutomaticEffect {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TAVVolumeAutomaticEffect";

    @SerializedName("duration")
    private float duration;

    @SerializedName("endOffset")
    private float endOffset;

    @SerializedName("startOffset")
    private float startOffset;

    @SerializedName("volumeRange")
    private TAVVolumeRange volumeRange;

    public TAVVolumeAutomaticEffect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.startOffset = -1.0f;
            this.endOffset = -1.0f;
        }
    }

    public TAVAudioConfiguration.VolumeEdge convertToAudioVolumeEdge(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TAVAudioConfiguration.VolumeEdge) iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        }
        float f17 = this.duration;
        float f18 = this.startOffset;
        if (f18 <= -1.0f || this.endOffset != -1.0f) {
            if (f18 == -1.0f && this.endOffset > -1.0f) {
                f18 = f16 - f17;
            } else {
                if (f18 > -1.0f) {
                    float f19 = this.endOffset;
                    if (f19 > -1.0f) {
                        f17 = (f16 - f18) - f19;
                    }
                }
                Logger.e(TAG, "effect's startOffset and endOffset is wrong.");
                return null;
            }
        }
        if (f17 <= 0.0f) {
            return null;
        }
        return new TAVAudioConfiguration.VolumeEdge(new CMTimeRange(new CMTime(f18 / 1000.0f), new CMTime(f17 / 1000.0f)), getStartVolume(), getEndVolume());
    }

    public float getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.duration;
    }

    public float getEndOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.endOffset;
    }

    public float getEndVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        TAVVolumeRange tAVVolumeRange = this.volumeRange;
        if (tAVVolumeRange != null) {
            return tAVVolumeRange.end;
        }
        return 0.0f;
    }

    public float getStartOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return this.startOffset;
    }

    public float getStartVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        TAVVolumeRange tAVVolumeRange = this.volumeRange;
        if (tAVVolumeRange != null) {
            return tAVVolumeRange.start;
        }
        return 0.0f;
    }

    public void setDuration(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.duration = f16;
        }
    }

    public void setEndOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.endOffset = f16;
        }
    }

    public void setEndVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            return;
        }
        if (this.volumeRange == null) {
            this.volumeRange = new TAVVolumeRange();
        }
        this.volumeRange.end = f16;
    }

    public void setStartOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.startOffset = f16;
        }
    }

    public void setStartVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        if (this.volumeRange == null) {
            this.volumeRange = new TAVVolumeRange();
        }
        this.volumeRange.start = f16;
    }
}
