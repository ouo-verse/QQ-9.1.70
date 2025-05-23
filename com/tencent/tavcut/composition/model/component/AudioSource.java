package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable;
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
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u009d\u0001\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\tH\u0016R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/AudioSource;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "key", "speed", "", "version", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "audioSourceType", "src", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/AudioSource;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class AudioSource extends AndroidMessage<AudioSource, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<AudioSource> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AudioSource> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @JvmField
    @Nullable
    public final Integer audioSourceType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    @Nullable
    public final Float speed;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @JvmField
    @Nullable
    public final String src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    @JvmField
    @Nullable
    public final Integer version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
    @JvmField
    @Nullable
    public final Float volume;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.VolumeEffect#ADAPTER", label = WireField.Label.REPEATED, tag = 9)
    @JvmField
    @NotNull
    public final List<VolumeEffect> volumeEffects;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0018J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\rJ\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0018J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u001bJ\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "()V", "audioSourceType", "", "Ljava/lang/Integer;", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "key", "", "speed", "", "Ljava/lang/Float;", "src", "type", "version", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "build", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/AudioSource$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<AudioSource, Builder> {

        @JvmField
        @Nullable
        public Integer audioSourceType;

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public String key;

        @JvmField
        @Nullable
        public Float speed;

        @JvmField
        @Nullable
        public String src;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer version;

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
        public final Builder audioSourceType(@Nullable Integer audioSourceType) {
            this.audioSourceType = audioSourceType;
            return this;
        }

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder enabled(@Nullable Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        @NotNull
        public final Builder entityId(@Nullable Integer entityId) {
            this.entityId = entityId;
            return this;
        }

        @NotNull
        public final Builder key(@Nullable String key) {
            this.key = key;
            return this;
        }

        @NotNull
        public final Builder speed(@Nullable Float speed) {
            this.speed = speed;
            return this;
        }

        @NotNull
        public final Builder src(@Nullable String src) {
            this.src = src;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder version(@Nullable Integer version) {
            this.version = version;
            return this;
        }

        @NotNull
        public final Builder volume(@Nullable Float volume) {
            this.volume = volume;
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
        public AudioSource build() {
            return new AudioSource(this.entityId, this.componentID, this.enabled, this.type, this.key, this.speed, this.version, this.volume, this.volumeEffects, this.audioSourceType, this.src, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AudioSource.class);
        final String str = "type.googleapis.com/publisher.AudioSource";
        ProtoAdapter<AudioSource> protoAdapter = new ProtoAdapter<AudioSource>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.AudioSource$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public AudioSource decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                String str3 = null;
                Float f16 = null;
                Integer num3 = null;
                Float f17 = null;
                Integer num4 = null;
                String str4 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new AudioSource(num, num2, bool, str2, str3, f16, num3, f17, arrayList, num4, str4, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 2:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 3:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 7:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 8:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 9:
                            arrayList.add(VolumeEffect.ADAPTER.decode(reader));
                            break;
                        case 10:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 11:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull AudioSource value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.encodeWithTag(writer, 4, value.type);
                protoAdapter3.encodeWithTag(writer, 5, value.key);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                protoAdapter4.encodeWithTag(writer, 6, value.speed);
                protoAdapter2.encodeWithTag(writer, 7, value.version);
                protoAdapter4.encodeWithTag(writer, 8, value.volume);
                VolumeEffect.ADAPTER.asRepeated().encodeWithTag(writer, 9, value.volumeEffects);
                protoAdapter2.encodeWithTag(writer, 10, value.audioSourceType);
                protoAdapter3.encodeWithTag(writer, 11, value.src);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull AudioSource value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.type) + protoAdapter3.encodedSizeWithTag(5, value.key);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(6, value.speed) + protoAdapter2.encodedSizeWithTag(7, value.version) + protoAdapter4.encodedSizeWithTag(8, value.volume) + VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(9, value.volumeEffects) + protoAdapter2.encodedSizeWithTag(10, value.audioSourceType) + protoAdapter3.encodedSizeWithTag(11, value.src) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public AudioSource redact(@NotNull AudioSource value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return AudioSource.copy$default(value, null, null, null, null, null, null, null, null, Internal.m87redactElements(value.volumeEffects, VolumeEffect.ADAPTER), null, null, ByteString.EMPTY, 1791, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public AudioSource() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ AudioSource copy$default(AudioSource audioSource, Integer num, Integer num2, Boolean bool, String str, String str2, Float f16, Integer num3, Float f17, List list, Integer num4, String str3, ByteString byteString, int i3, Object obj) {
        Integer num5;
        Integer num6;
        Boolean bool2;
        String str4;
        String str5;
        Float f18;
        Integer num7;
        Float f19;
        List list2;
        Integer num8;
        String str6;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            num5 = audioSource.entityId;
        } else {
            num5 = num;
        }
        if ((i3 & 2) != 0) {
            num6 = audioSource.componentID;
        } else {
            num6 = num2;
        }
        if ((i3 & 4) != 0) {
            bool2 = audioSource.enabled;
        } else {
            bool2 = bool;
        }
        if ((i3 & 8) != 0) {
            str4 = audioSource.type;
        } else {
            str4 = str;
        }
        if ((i3 & 16) != 0) {
            str5 = audioSource.key;
        } else {
            str5 = str2;
        }
        if ((i3 & 32) != 0) {
            f18 = audioSource.speed;
        } else {
            f18 = f16;
        }
        if ((i3 & 64) != 0) {
            num7 = audioSource.version;
        } else {
            num7 = num3;
        }
        if ((i3 & 128) != 0) {
            f19 = audioSource.volume;
        } else {
            f19 = f17;
        }
        if ((i3 & 256) != 0) {
            list2 = audioSource.volumeEffects;
        } else {
            list2 = list;
        }
        if ((i3 & 512) != 0) {
            num8 = audioSource.audioSourceType;
        } else {
            num8 = num4;
        }
        if ((i3 & 1024) != 0) {
            str6 = audioSource.src;
        } else {
            str6 = str3;
        }
        if ((i3 & 2048) != 0) {
            byteString2 = audioSource.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return audioSource.copy(num5, num6, bool2, str4, str5, f18, num7, f19, list2, num8, str6, byteString2);
    }

    @NotNull
    public final AudioSource copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable String key, @Nullable Float speed, @Nullable Integer version, @Nullable Float volume, @NotNull List<VolumeEffect> volumeEffects, @Nullable Integer audioSourceType, @Nullable String src, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new AudioSource(entityId, componentID, enabled, type, key, speed, version, volume, volumeEffects, audioSourceType, src, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AudioSource)) {
            return false;
        }
        AudioSource audioSource = (AudioSource) other;
        if (Intrinsics.areEqual(unknownFields(), audioSource.unknownFields()) && Intrinsics.areEqual(this.entityId, audioSource.entityId) && Intrinsics.areEqual(this.componentID, audioSource.componentID) && Intrinsics.areEqual(this.enabled, audioSource.enabled) && Intrinsics.areEqual(this.type, audioSource.type) && Intrinsics.areEqual(this.key, audioSource.key) && Intrinsics.areEqual(this.speed, audioSource.speed) && Intrinsics.areEqual(this.version, audioSource.version) && Intrinsics.areEqual(this.volume, audioSource.volume) && Intrinsics.areEqual(this.volumeEffects, audioSource.volumeEffects) && Intrinsics.areEqual(this.audioSourceType, audioSource.audioSourceType) && Intrinsics.areEqual(this.src, audioSource.src)) {
            return true;
        }
        return false;
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
        int i36 = this.hashCode;
        if (i36 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityId;
            int i37 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i38 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i39 = (i38 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i46 = (i39 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i47 = (i46 + i18) * 37;
            String str2 = this.key;
            if (str2 != null) {
                i19 = str2.hashCode();
            } else {
                i19 = 0;
            }
            int i48 = (i47 + i19) * 37;
            Float f16 = this.speed;
            if (f16 != null) {
                i26 = f16.hashCode();
            } else {
                i26 = 0;
            }
            int i49 = (i48 + i26) * 37;
            Integer num3 = this.version;
            if (num3 != null) {
                i27 = num3.hashCode();
            } else {
                i27 = 0;
            }
            int i56 = (i49 + i27) * 37;
            Float f17 = this.volume;
            if (f17 != null) {
                i28 = f17.hashCode();
            } else {
                i28 = 0;
            }
            int hashCode2 = (((i56 + i28) * 37) + this.volumeEffects.hashCode()) * 37;
            Integer num4 = this.audioSourceType;
            if (num4 != null) {
                i29 = num4.hashCode();
            } else {
                i29 = 0;
            }
            int i57 = (hashCode2 + i29) * 37;
            String str3 = this.src;
            if (str3 != null) {
                i37 = str3.hashCode();
            }
            int i58 = i57 + i37;
            this.hashCode = i58;
            return i58;
        }
        return i36;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.entityId != null) {
            arrayList.add("entityId=" + this.entityId);
        }
        if (this.componentID != null) {
            arrayList.add("componentID=" + this.componentID);
        }
        if (this.enabled != null) {
            arrayList.add("enabled=" + this.enabled);
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.key != null) {
            arrayList.add("key=" + Internal.sanitize(this.key));
        }
        if (this.speed != null) {
            arrayList.add("speed=" + this.speed);
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        if (this.volume != null) {
            arrayList.add("volume=" + this.volume);
        }
        if (!this.volumeEffects.isEmpty()) {
            arrayList.add("volumeEffects=" + this.volumeEffects);
        }
        if (this.audioSourceType != null) {
            arrayList.add("audioSourceType=" + this.audioSourceType);
        }
        if (this.src != null) {
            arrayList.add("src=" + Internal.sanitize(this.src));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "AudioSource{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ AudioSource(Integer num, Integer num2, Boolean bool, String str, String str2, Float f16, Integer num3, Float f17, List list, Integer num4, String str3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : f16, (i3 & 64) != 0 ? null : num3, (i3 & 128) != 0 ? null : f17, (i3 & 256) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 512) != 0 ? null : num4, (i3 & 1024) == 0 ? str3 : null, (i3 & 2048) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.key = this.key;
        builder.speed = this.speed;
        builder.version = this.version;
        builder.volume = this.volume;
        builder.volumeEffects = this.volumeEffects;
        builder.audioSourceType = this.audioSourceType;
        builder.src = this.src;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioSource(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Float f16, @Nullable Integer num3, @Nullable Float f17, @NotNull List<VolumeEffect> volumeEffects, @Nullable Integer num4, @Nullable String str3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
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
}
