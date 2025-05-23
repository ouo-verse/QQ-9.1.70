package com.tencent.tavcut.core.render.builder.light.model;

import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u0010,\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u0010\u00100\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u00c6\u0003J\u0096\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u00020\u0003H\u00d6\u0001J\t\u00107\u001a\u00020\bH\u00d6\u0001R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b#\u0010\u0015R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u00a8\u00068"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/AudioSource;", "", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "key", "speed", "", "version", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/tavcut/core/render/builder/light/model/VolumeEffect;", "audioSourceType", "src", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getAudioSourceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getComponentID", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEntityId", "getKey", "()Ljava/lang/String;", "getSpeed", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getSrc", "getType", "getVersion", "getVolume", "getVolumeEffects", "()Ljava/util/List;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tencent/tavcut/core/render/builder/light/model/AudioSource;", "equals", "other", "hashCode", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class AudioSource {

    @Nullable
    private final Integer audioSourceType;

    @Nullable
    private final Integer componentID;

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final Integer entityId;

    @Nullable
    private final String key;

    @Nullable
    private final Float speed;

    @Nullable
    private final String src;

    @Nullable
    private final String type;

    @Nullable
    private final Integer version;

    @Nullable
    private final Float volume;

    @NotNull
    private final List<VolumeEffect> volumeEffects;

    public AudioSource() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getEntityId() {
        return this.entityId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getAudioSourceType() {
        return this.audioSourceType;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getComponentID() {
        return this.componentID;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Float getSpeed() {
        return this.speed;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Float getVolume() {
        return this.volume;
    }

    @NotNull
    public final List<VolumeEffect> component9() {
        return this.volumeEffects;
    }

    @NotNull
    public final AudioSource copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable String key, @Nullable Float speed, @Nullable Integer version, @Nullable Float volume, @NotNull List<VolumeEffect> volumeEffects, @Nullable Integer audioSourceType, @Nullable String src) {
        Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
        return new AudioSource(entityId, componentID, enabled, type, key, speed, version, volume, volumeEffects, audioSourceType, src);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AudioSource) {
                AudioSource audioSource = (AudioSource) other;
                if (!Intrinsics.areEqual(this.entityId, audioSource.entityId) || !Intrinsics.areEqual(this.componentID, audioSource.componentID) || !Intrinsics.areEqual(this.enabled, audioSource.enabled) || !Intrinsics.areEqual(this.type, audioSource.type) || !Intrinsics.areEqual(this.key, audioSource.key) || !Intrinsics.areEqual((Object) this.speed, (Object) audioSource.speed) || !Intrinsics.areEqual(this.version, audioSource.version) || !Intrinsics.areEqual((Object) this.volume, (Object) audioSource.volume) || !Intrinsics.areEqual(this.volumeEffects, audioSource.volumeEffects) || !Intrinsics.areEqual(this.audioSourceType, audioSource.audioSourceType) || !Intrinsics.areEqual(this.src, audioSource.src)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getAudioSourceType() {
        return this.audioSourceType;
    }

    @Nullable
    public final Integer getComponentID() {
        return this.componentID;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Integer getEntityId() {
        return this.entityId;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final Float getSpeed() {
        return this.speed;
    }

    @Nullable
    public final String getSrc() {
        return this.src;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }

    @Nullable
    public final Float getVolume() {
        return this.volume;
    }

    @NotNull
    public final List<VolumeEffect> getVolumeEffects() {
        return this.volumeEffects;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        Integer num = this.entityId;
        int i37 = 0;
        if (num != null) {
            i3 = num.hashCode();
        } else {
            i3 = 0;
        }
        int i38 = i3 * 31;
        Integer num2 = this.componentID;
        if (num2 != null) {
            i16 = num2.hashCode();
        } else {
            i16 = 0;
        }
        int i39 = (i38 + i16) * 31;
        Boolean bool = this.enabled;
        if (bool != null) {
            i17 = bool.hashCode();
        } else {
            i17 = 0;
        }
        int i46 = (i39 + i17) * 31;
        String str = this.type;
        if (str != null) {
            i18 = str.hashCode();
        } else {
            i18 = 0;
        }
        int i47 = (i46 + i18) * 31;
        String str2 = this.key;
        if (str2 != null) {
            i19 = str2.hashCode();
        } else {
            i19 = 0;
        }
        int i48 = (i47 + i19) * 31;
        Float f16 = this.speed;
        if (f16 != null) {
            i26 = f16.hashCode();
        } else {
            i26 = 0;
        }
        int i49 = (i48 + i26) * 31;
        Integer num3 = this.version;
        if (num3 != null) {
            i27 = num3.hashCode();
        } else {
            i27 = 0;
        }
        int i56 = (i49 + i27) * 31;
        Float f17 = this.volume;
        if (f17 != null) {
            i28 = f17.hashCode();
        } else {
            i28 = 0;
        }
        int i57 = (i56 + i28) * 31;
        List<VolumeEffect> list = this.volumeEffects;
        if (list != null) {
            i29 = list.hashCode();
        } else {
            i29 = 0;
        }
        int i58 = (i57 + i29) * 31;
        Integer num4 = this.audioSourceType;
        if (num4 != null) {
            i36 = num4.hashCode();
        } else {
            i36 = 0;
        }
        int i59 = (i58 + i36) * 31;
        String str3 = this.src;
        if (str3 != null) {
            i37 = str3.hashCode();
        }
        return i59 + i37;
    }

    @NotNull
    public String toString() {
        return "AudioSource(entityId=" + this.entityId + ", componentID=" + this.componentID + ", enabled=" + this.enabled + ", type=" + this.type + ", key=" + this.key + ", speed=" + this.speed + ", version=" + this.version + ", volume=" + this.volume + ", volumeEffects=" + this.volumeEffects + ", audioSourceType=" + this.audioSourceType + ", src=" + this.src + ")";
    }

    public AudioSource(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Float f16, @Nullable Integer num3, @Nullable Float f17, @NotNull List<VolumeEffect> volumeEffects, @Nullable Integer num4, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.key = str2;
        this.speed = f16;
        this.version = num3;
        this.volume = f17;
        this.volumeEffects = volumeEffects;
        this.audioSourceType = num4;
        this.src = str3;
    }

    public /* synthetic */ AudioSource(Integer num, Integer num2, Boolean bool, String str, String str2, Float f16, Integer num3, Float f17, List list, Integer num4, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : f16, (i3 & 64) != 0 ? null : num3, (i3 & 128) != 0 ? null : f17, (i3 & 256) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 512) != 0 ? null : num4, (i3 & 1024) == 0 ? str3 : null);
    }
}
