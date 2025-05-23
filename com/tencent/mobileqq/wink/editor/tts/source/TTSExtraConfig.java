package com.tencent.mobileqq.wink.editor.tts.source;

import androidx.annotation.Keep;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.AudioConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.VoiceConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J+\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/tts/source/TTSExtraConfig;", "", "audioConfig", "Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/AudioConfig;", "voiceConfig", "Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/VoiceConfig;", "needAudioRawData", "", "(Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/AudioConfig;Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/VoiceConfig;Z)V", "getAudioConfig", "()Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/AudioConfig;", "setAudioConfig", "(Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/AudioConfig;)V", "getNeedAudioRawData", "()Z", "setNeedAudioRawData", "(Z)V", "getVoiceConfig", "()Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/VoiceConfig;", "setVoiceConfig", "(Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/VoiceConfig;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class TTSExtraConfig {

    @Nullable
    private AudioConfig audioConfig;
    private boolean needAudioRawData;

    @Nullable
    private VoiceConfig voiceConfig;

    public TTSExtraConfig() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ TTSExtraConfig copy$default(TTSExtraConfig tTSExtraConfig, AudioConfig audioConfig, VoiceConfig voiceConfig, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            audioConfig = tTSExtraConfig.audioConfig;
        }
        if ((i3 & 2) != 0) {
            voiceConfig = tTSExtraConfig.voiceConfig;
        }
        if ((i3 & 4) != 0) {
            z16 = tTSExtraConfig.needAudioRawData;
        }
        return tTSExtraConfig.copy(audioConfig, voiceConfig, z16);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final AudioConfig getAudioConfig() {
        return this.audioConfig;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final VoiceConfig getVoiceConfig() {
        return this.voiceConfig;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getNeedAudioRawData() {
        return this.needAudioRawData;
    }

    @NotNull
    public final TTSExtraConfig copy(@Nullable AudioConfig audioConfig, @Nullable VoiceConfig voiceConfig, boolean needAudioRawData) {
        return new TTSExtraConfig(audioConfig, voiceConfig, needAudioRawData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TTSExtraConfig)) {
            return false;
        }
        TTSExtraConfig tTSExtraConfig = (TTSExtraConfig) other;
        if (Intrinsics.areEqual(this.audioConfig, tTSExtraConfig.audioConfig) && Intrinsics.areEqual(this.voiceConfig, tTSExtraConfig.voiceConfig) && this.needAudioRawData == tTSExtraConfig.needAudioRawData) {
            return true;
        }
        return false;
    }

    @Nullable
    public final AudioConfig getAudioConfig() {
        return this.audioConfig;
    }

    public final boolean getNeedAudioRawData() {
        return this.needAudioRawData;
    }

    @Nullable
    public final VoiceConfig getVoiceConfig() {
        return this.voiceConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        AudioConfig audioConfig = this.audioConfig;
        int i3 = 0;
        if (audioConfig == null) {
            hashCode = 0;
        } else {
            hashCode = audioConfig.hashCode();
        }
        int i16 = hashCode * 31;
        VoiceConfig voiceConfig = this.voiceConfig;
        if (voiceConfig != null) {
            i3 = voiceConfig.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.needAudioRawData;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        return i17 + i18;
    }

    public final void setAudioConfig(@Nullable AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    public final void setNeedAudioRawData(boolean z16) {
        this.needAudioRawData = z16;
    }

    public final void setVoiceConfig(@Nullable VoiceConfig voiceConfig) {
        this.voiceConfig = voiceConfig;
    }

    @NotNull
    public String toString() {
        return "TTSExtraConfig(audioConfig=" + this.audioConfig + ", voiceConfig=" + this.voiceConfig + ", needAudioRawData=" + this.needAudioRawData + ")";
    }

    public TTSExtraConfig(@Nullable AudioConfig audioConfig, @Nullable VoiceConfig voiceConfig, boolean z16) {
        this.audioConfig = audioConfig;
        this.voiceConfig = voiceConfig;
        this.needAudioRawData = z16;
    }

    public /* synthetic */ TTSExtraConfig(AudioConfig audioConfig, VoiceConfig voiceConfig, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : audioConfig, (i3 & 2) != 0 ? null : voiceConfig, (i3 & 4) != 0 ? false : z16);
    }
}
