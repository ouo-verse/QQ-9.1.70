package com.tencent.tavcut.model;

import android.os.Parcelable;
import androidx.fragment.app.a;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.VolumeEffect;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eBc\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014Jl\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/tavcut/model/AudioAsset;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/AudioAsset$Builder;", "assetId", "", "path", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "speed", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "startOffset", "", JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "type", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;FFJLjava/util/List;ILokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class AudioAsset extends AndroidMessage<AudioAsset, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<AudioAsset> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AudioAsset> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String assetId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 4)
    @JvmField
    public final float speed;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 6)
    @JvmField
    public final long startOffset;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.TimeRange#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final TimeRange timeRange;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 8)
    @JvmField
    public final int type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 5)
    @JvmField
    public final float volume;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.VolumeEffect#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    @JvmField
    @NotNull
    public final List<VolumeEffect> volumeEffects;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/tavcut/model/AudioAsset$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/AudioAsset;", "()V", "assetId", "", "path", "speed", "", "Ljava/lang/Float;", "startOffset", "", "Ljava/lang/Long;", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "type", "", "Ljava/lang/Integer;", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<AudioAsset, Builder> {

        @JvmField
        @Nullable
        public String assetId;

        @JvmField
        @Nullable
        public String path;

        @JvmField
        @Nullable
        public Float speed;

        @JvmField
        @Nullable
        public Long startOffset;

        @JvmField
        @Nullable
        public TimeRange timeRange;

        @JvmField
        @Nullable
        public Integer type;

        @JvmField
        @Nullable
        public Float volume;

        @JvmField
        @NotNull
        public List<VolumeEffect> volumeEffects;

        public Builder() {
            List<VolumeEffect> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.volumeEffects = emptyList;
        }

        @NotNull
        public final Builder assetId(@Nullable String assetId) {
            this.assetId = assetId;
            return this;
        }

        @NotNull
        public final Builder path(@Nullable String path) {
            this.path = path;
            return this;
        }

        @NotNull
        public final Builder speed(float speed) {
            this.speed = Float.valueOf(speed);
            return this;
        }

        @NotNull
        public final Builder startOffset(long startOffset) {
            this.startOffset = Long.valueOf(startOffset);
            return this;
        }

        @NotNull
        public final Builder timeRange(@Nullable TimeRange timeRange) {
            this.timeRange = timeRange;
            return this;
        }

        @NotNull
        public final Builder type(int type) {
            this.type = Integer.valueOf(type);
            return this;
        }

        @NotNull
        public final Builder volume(float volume) {
            this.volume = Float.valueOf(volume);
            return this;
        }

        @NotNull
        public final Builder volumeEffects(@NotNull List<VolumeEffect> volumeEffects) {
            Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
            Internal.checkElementsNotNull(volumeEffects);
            this.volumeEffects = volumeEffects;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public AudioAsset build() {
            String str = this.assetId;
            String str2 = this.path;
            TimeRange timeRange = this.timeRange;
            Float f16 = this.speed;
            if (f16 != null) {
                float floatValue = f16.floatValue();
                Float f17 = this.volume;
                if (f17 != null) {
                    float floatValue2 = f17.floatValue();
                    Long l3 = this.startOffset;
                    if (l3 != null) {
                        long longValue = l3.longValue();
                        List<VolumeEffect> list = this.volumeEffects;
                        Integer num = this.type;
                        if (num != null) {
                            return new AudioAsset(str, str2, timeRange, floatValue, floatValue2, longValue, list, num.intValue(), buildUnknownFields());
                        }
                        throw Internal.missingRequiredFields(num, "type");
                    }
                    throw Internal.missingRequiredFields(l3, "startOffset");
                }
                throw Internal.missingRequiredFields(f17, InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
            }
            throw Internal.missingRequiredFields(f16, "speed");
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AudioAsset.class);
        final String str = "type.googleapis.com/publisher.AudioAsset";
        ProtoAdapter<AudioAsset> protoAdapter = new ProtoAdapter<AudioAsset>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.AudioAsset$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public AudioAsset decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                String str2 = null;
                Float f16 = null;
                Float f17 = null;
                Long l3 = null;
                Integer num = null;
                String str3 = null;
                TimeRange timeRange = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                        if (f16 != null) {
                            float floatValue = f16.floatValue();
                            if (f17 != null) {
                                float floatValue2 = f17.floatValue();
                                if (l3 != null) {
                                    long longValue = l3.longValue();
                                    if (num != null) {
                                        return new AudioAsset(str2, str3, timeRange, floatValue, floatValue2, longValue, arrayList, num.intValue(), endMessageAndGetUnknownFields);
                                    }
                                    throw Internal.missingRequiredFields(num, "type");
                                }
                                throw Internal.missingRequiredFields(l3, "startOffset");
                            }
                            throw Internal.missingRequiredFields(f17, InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
                        }
                        throw Internal.missingRequiredFields(f16, "speed");
                    }
                    switch (nextTag) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            timeRange = TimeRange.ADAPTER.decode(reader);
                            break;
                        case 4:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 5:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 6:
                            l3 = ProtoAdapter.INT64.decode(reader);
                            break;
                        case 7:
                            arrayList.add(VolumeEffect.ADAPTER.decode(reader));
                            break;
                        case 8:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull AudioAsset value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.assetId);
                protoAdapter2.encodeWithTag(writer, 2, value.path);
                TimeRange.ADAPTER.encodeWithTag(writer, 3, value.timeRange);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                protoAdapter3.encodeWithTag(writer, 4, Float.valueOf(value.speed));
                protoAdapter3.encodeWithTag(writer, 5, Float.valueOf(value.volume));
                ProtoAdapter.INT64.encodeWithTag(writer, 6, Long.valueOf(value.startOffset));
                VolumeEffect.ADAPTER.asRepeated().encodeWithTag(writer, 7, value.volumeEffects);
                ProtoAdapter.INT32.encodeWithTag(writer, 8, Integer.valueOf(value.type));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull AudioAsset value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.assetId) + protoAdapter2.encodedSizeWithTag(2, value.path) + TimeRange.ADAPTER.encodedSizeWithTag(3, value.timeRange);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, Float.valueOf(value.speed)) + protoAdapter3.encodedSizeWithTag(5, Float.valueOf(value.volume)) + ProtoAdapter.INT64.encodedSizeWithTag(6, Long.valueOf(value.startOffset)) + VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(7, value.volumeEffects) + ProtoAdapter.INT32.encodedSizeWithTag(8, Integer.valueOf(value.type)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public AudioAsset redact(@NotNull AudioAsset value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                TimeRange timeRange = value.timeRange;
                return AudioAsset.copy$default(value, null, null, timeRange != null ? TimeRange.ADAPTER.redact(timeRange) : null, 0.0f, 0.0f, 0L, Internal.m87redactElements(value.volumeEffects, VolumeEffect.ADAPTER), 0, ByteString.EMPTY, 187, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AudioAsset(String str, String str2, TimeRange timeRange, float f16, float f17, long j3, List list, int i3, ByteString byteString, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r6, f16, f17, j3, r11, i3, (i16 & 256) != 0 ? ByteString.EMPTY : byteString);
        List list2;
        List emptyList;
        String str3 = (i16 & 1) != 0 ? null : str;
        String str4 = (i16 & 2) != 0 ? null : str2;
        TimeRange timeRange2 = (i16 & 4) != 0 ? null : timeRange;
        if ((i16 & 64) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }

    public static /* synthetic */ AudioAsset copy$default(AudioAsset audioAsset, String str, String str2, TimeRange timeRange, float f16, float f17, long j3, List list, int i3, ByteString byteString, int i16, Object obj) {
        String str3;
        String str4;
        TimeRange timeRange2;
        float f18;
        float f19;
        long j16;
        List list2;
        int i17;
        ByteString byteString2;
        if ((i16 & 1) != 0) {
            str3 = audioAsset.assetId;
        } else {
            str3 = str;
        }
        if ((i16 & 2) != 0) {
            str4 = audioAsset.path;
        } else {
            str4 = str2;
        }
        if ((i16 & 4) != 0) {
            timeRange2 = audioAsset.timeRange;
        } else {
            timeRange2 = timeRange;
        }
        if ((i16 & 8) != 0) {
            f18 = audioAsset.speed;
        } else {
            f18 = f16;
        }
        if ((i16 & 16) != 0) {
            f19 = audioAsset.volume;
        } else {
            f19 = f17;
        }
        if ((i16 & 32) != 0) {
            j16 = audioAsset.startOffset;
        } else {
            j16 = j3;
        }
        if ((i16 & 64) != 0) {
            list2 = audioAsset.volumeEffects;
        } else {
            list2 = list;
        }
        if ((i16 & 128) != 0) {
            i17 = audioAsset.type;
        } else {
            i17 = i3;
        }
        if ((i16 & 256) != 0) {
            byteString2 = audioAsset.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return audioAsset.copy(str3, str4, timeRange2, f18, f19, j16, list2, i17, byteString2);
    }

    @NotNull
    public final AudioAsset copy(@Nullable String assetId, @Nullable String path, @Nullable TimeRange timeRange, float speed, float volume, long startOffset, @NotNull List<VolumeEffect> volumeEffects, int type, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new AudioAsset(assetId, path, timeRange, speed, volume, startOffset, volumeEffects, type, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AudioAsset)) {
            return false;
        }
        AudioAsset audioAsset = (AudioAsset) other;
        if (Intrinsics.areEqual(unknownFields(), audioAsset.unknownFields()) && Intrinsics.areEqual(this.assetId, audioAsset.assetId) && Intrinsics.areEqual(this.path, audioAsset.path) && Intrinsics.areEqual(this.timeRange, audioAsset.timeRange) && this.speed == audioAsset.speed && this.volume == audioAsset.volume && this.startOffset == audioAsset.startOffset && Intrinsics.areEqual(this.volumeEffects, audioAsset.volumeEffects) && this.type == audioAsset.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.assetId;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.path;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            TimeRange timeRange = this.timeRange;
            if (timeRange != null) {
                i18 = timeRange.hashCode();
            }
            int floatToIntBits = ((((((((((i26 + i18) * 37) + Float.floatToIntBits(this.speed)) * 37) + Float.floatToIntBits(this.volume)) * 37) + a.a(this.startOffset)) * 37) + this.volumeEffects.hashCode()) * 37) + this.type;
            this.hashCode = floatToIntBits;
            return floatToIntBits;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.assetId != null) {
            arrayList.add("assetId=" + Internal.sanitize(this.assetId));
        }
        if (this.path != null) {
            arrayList.add("path=" + Internal.sanitize(this.path));
        }
        if (this.timeRange != null) {
            arrayList.add("timeRange=" + this.timeRange);
        }
        arrayList.add("speed=" + this.speed);
        arrayList.add("volume=" + this.volume);
        arrayList.add("startOffset=" + this.startOffset);
        if (!this.volumeEffects.isEmpty()) {
            arrayList.add("volumeEffects=" + this.volumeEffects);
        }
        arrayList.add("type=" + this.type);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "AudioAsset{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.assetId = this.assetId;
        builder.path = this.path;
        builder.timeRange = this.timeRange;
        builder.speed = Float.valueOf(this.speed);
        builder.volume = Float.valueOf(this.volume);
        builder.startOffset = Long.valueOf(this.startOffset);
        builder.volumeEffects = this.volumeEffects;
        builder.type = Integer.valueOf(this.type);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioAsset(@Nullable String str, @Nullable String str2, @Nullable TimeRange timeRange, float f16, float f17, long j3, @NotNull List<VolumeEffect> volumeEffects, int i3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.assetId = str;
        this.path = str2;
        this.timeRange = timeRange;
        this.speed = f16;
        this.volume = f17;
        this.startOffset = j3;
        this.volumeEffects = volumeEffects;
        this.type = i3;
    }
}
