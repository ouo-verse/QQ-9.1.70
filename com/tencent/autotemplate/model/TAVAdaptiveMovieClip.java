package com.tencent.autotemplate.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVAdaptiveMovieClip {
    static IPatchRedirector $redirector_;
    private transient float duration;
    private transient String fileDir;

    @SerializedName("filePath")
    private String fileName;

    @SerializedName("startOffset")
    private float startOffset;

    @SerializedName(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME)
    private float volume;

    @SerializedName(JsonUtils.KEY_VOLUME_EFFECTS)
    private List<TAVVolumeAutomaticEffect> volumeEffects;

    public TAVAdaptiveMovieClip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.startOffset = 0.0f;
        this.volume = 1.0f;
        this.volumeEffects = new ArrayList();
    }

    private TAVMovieTrackResource convertToMovieTrackResource() {
        String fullPath = getFullPath();
        if (TextUtils.isEmpty(fullPath)) {
            return null;
        }
        TAVMovieTrackResource tAVMovieTrackResource = new TAVMovieTrackResource(fullPath);
        tAVMovieTrackResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
        float timeSeconds = tAVMovieTrackResource.getTimeRange().getDuration().getTimeSeconds() * 1000.0f;
        float f16 = this.startOffset;
        float f17 = timeSeconds - f16;
        float f18 = this.duration;
        if (f17 < f18) {
            f18 = timeSeconds - f16;
        }
        tAVMovieTrackResource.setTimeRange(new CMTimeRange(new CMTime(this.startOffset / 1000.0f), new CMTime(f18 / 1000.0f)));
        return tAVMovieTrackResource;
    }

    private String getFullPath() {
        if (!TextUtils.isEmpty(this.fileName) && new File(this.fileName).exists()) {
            return this.fileName;
        }
        if (!TextUtils.isEmpty(this.fileDir) && !TextUtils.isEmpty(this.fileName)) {
            return this.fileDir + "/" + this.fileName;
        }
        return null;
    }

    public TAVMovieClip convertToMovieClip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TAVMovieClip) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        TAVMovieClip tAVMovieClip = new TAVMovieClip();
        tAVMovieClip.setResource(convertToMovieTrackResource());
        if (tAVMovieClip.getResource() == null || tAVMovieClip.getResource().getStatus() == TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusError) {
            return null;
        }
        tAVMovieClip.getAudioConfiguration().setVolume(this.volume);
        if (!tAVMovieClip.getResource().getTimeRange().isLegal()) {
            return null;
        }
        return tAVMovieClip;
    }

    public float getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return this.duration;
    }

    public String getFileDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.fileDir;
    }

    public String getFileName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.fileName;
    }

    public float getStartOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.startOffset;
    }

    public float getVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.volume;
    }

    public List<TAVVolumeAutomaticEffect> getVolumeEffects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.volumeEffects;
    }

    public void setDuration(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.duration = f16;
        }
    }

    public void setFileDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.fileDir = str;
        }
    }

    public void setFileName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.fileName = str;
        }
    }

    public void setStartOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.startOffset = f16;
        }
    }

    public void setVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.volume = f16;
        }
    }

    public void setVolumeEffects(List<TAVVolumeAutomaticEffect> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
        } else {
            this.volumeEffects = list;
        }
    }
}
