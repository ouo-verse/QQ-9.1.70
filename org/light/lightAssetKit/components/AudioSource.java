package org.light.lightAssetKit.components;

import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.AudioSourceType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AudioSource extends Component {
    private float volume = 1.0f;
    private float speed = 1.0f;
    private ArrayList<VolumeEffect> volumeEffects = new ArrayList<>();
    private String originLyricsPath = "";
    private String translatedLyricsPath = "";
    private AudioSourceType audioSourceType = AudioSourceType.Effect;
    private String src = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof AudioSource) {
            AudioSource audioSource = (AudioSource) componentBase;
            this.volume = audioSource.volume;
            this.speed = audioSource.speed;
            this.volumeEffects = audioSource.volumeEffects;
            this.originLyricsPath = audioSource.originLyricsPath;
            this.translatedLyricsPath = audioSource.translatedLyricsPath;
            this.audioSourceType = audioSource.audioSourceType;
            this.src = audioSource.src;
        }
        super.doUpdate(componentBase);
    }

    public AudioSourceType getAudioSourceType() {
        return this.audioSourceType;
    }

    public String getOriginLyricsPath() {
        return this.originLyricsPath;
    }

    public float getSpeed() {
        return this.speed;
    }

    public String getSrc() {
        return this.src;
    }

    public String getTranslatedLyricsPath() {
        return this.translatedLyricsPath;
    }

    public float getVolume() {
        return this.volume;
    }

    public ArrayList<VolumeEffect> getVolumeEffects() {
        return this.volumeEffects;
    }

    public void setAudioSourceType(AudioSourceType audioSourceType) {
        this.audioSourceType = audioSourceType;
        reportPropertyChange("audioSourceType", audioSourceType);
    }

    public void setOriginLyricsPath(String str) {
        this.originLyricsPath = str;
        reportPropertyChange("originLyricsPath", str);
    }

    public void setSpeed(float f16) {
        this.speed = f16;
        reportPropertyChange("speed", Float.valueOf(f16));
    }

    public void setSrc(String str) {
        this.src = str;
        reportPropertyChange("src", str);
    }

    public void setTranslatedLyricsPath(String str) {
        this.translatedLyricsPath = str;
        reportPropertyChange("translatedLyricsPath", str);
    }

    public void setVolume(float f16) {
        this.volume = f16;
        reportPropertyChange(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, Float.valueOf(f16));
    }

    public void setVolumeEffects(ArrayList<VolumeEffect> arrayList) {
        this.volumeEffects = arrayList;
        reportPropertyChange(JsonUtils.KEY_VOLUME_EFFECTS, arrayList);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "AudioSource";
    }
}
