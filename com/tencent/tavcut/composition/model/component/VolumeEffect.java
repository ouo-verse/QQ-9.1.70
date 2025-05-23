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
import java.util.ArrayList;
import kotlin.Metadata;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cBW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ]\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect$Builder;", "startOffset", "", "endOffset", "duration", "start", "", "end", "interpolationType", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Long;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class VolumeEffect extends AndroidMessage<VolumeEffect, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<VolumeEffect> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<VolumeEffect> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    @JvmField
    @Nullable
    public final Long duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    @JvmField
    @Nullable
    public final Float end;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @JvmField
    @Nullable
    public final Long endOffset;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @Nullable
    public final String interpolationType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    @JvmField
    @Nullable
    public final Float start;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    @JvmField
    @Nullable
    public final Long startOffset;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/VolumeEffect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "()V", "duration", "", "Ljava/lang/Long;", "end", "", "Ljava/lang/Float;", "endOffset", "interpolationType", "", "start", "startOffset", "build", "(Ljava/lang/Long;)Lcom/tencent/tavcut/composition/model/component/VolumeEffect$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/VolumeEffect$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<VolumeEffect, Builder> {

        @JvmField
        @Nullable
        public Long duration;

        @JvmField
        @Nullable
        public Float end;

        @JvmField
        @Nullable
        public Long endOffset;

        @JvmField
        @Nullable
        public String interpolationType;

        @JvmField
        @Nullable
        public Float start;

        @JvmField
        @Nullable
        public Long startOffset;

        @NotNull
        public final Builder duration(@Nullable Long duration) {
            this.duration = duration;
            return this;
        }

        @NotNull
        public final Builder end(@Nullable Float end) {
            this.end = end;
            return this;
        }

        @NotNull
        public final Builder endOffset(@Nullable Long endOffset) {
            this.endOffset = endOffset;
            return this;
        }

        @NotNull
        public final Builder interpolationType(@Nullable String interpolationType) {
            this.interpolationType = interpolationType;
            return this;
        }

        @NotNull
        public final Builder start(@Nullable Float start) {
            this.start = start;
            return this;
        }

        @NotNull
        public final Builder startOffset(@Nullable Long startOffset) {
            this.startOffset = startOffset;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public VolumeEffect build() {
            return new VolumeEffect(this.startOffset, this.endOffset, this.duration, this.start, this.end, this.interpolationType, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VolumeEffect.class);
        final String str = "type.googleapis.com/publisher.VolumeEffect";
        ProtoAdapter<VolumeEffect> protoAdapter = new ProtoAdapter<VolumeEffect>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.VolumeEffect$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public VolumeEffect decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Long l3 = null;
                Long l16 = null;
                Long l17 = null;
                Float f16 = null;
                Float f17 = null;
                String str2 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new VolumeEffect(l3, l16, l17, f16, f17, str2, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            l3 = ProtoAdapter.INT64.decode(reader);
                            break;
                        case 2:
                            l16 = ProtoAdapter.INT64.decode(reader);
                            break;
                        case 3:
                            l17 = ProtoAdapter.INT64.decode(reader);
                            break;
                        case 4:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 5:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 6:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull VolumeEffect value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                protoAdapter2.encodeWithTag(writer, 1, value.startOffset);
                protoAdapter2.encodeWithTag(writer, 2, value.endOffset);
                protoAdapter2.encodeWithTag(writer, 3, value.duration);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                protoAdapter3.encodeWithTag(writer, 4, value.start);
                protoAdapter3.encodeWithTag(writer, 5, value.end);
                ProtoAdapter.STRING.encodeWithTag(writer, 6, value.interpolationType);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull VolumeEffect value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.startOffset) + protoAdapter2.encodedSizeWithTag(2, value.endOffset) + protoAdapter2.encodedSizeWithTag(3, value.duration);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.start) + protoAdapter3.encodedSizeWithTag(5, value.end) + ProtoAdapter.STRING.encodedSizeWithTag(6, value.interpolationType) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public VolumeEffect redact(@NotNull VolumeEffect value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return VolumeEffect.copy$default(value, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public VolumeEffect() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ VolumeEffect copy$default(VolumeEffect volumeEffect, Long l3, Long l16, Long l17, Float f16, Float f17, String str, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = volumeEffect.startOffset;
        }
        if ((i3 & 2) != 0) {
            l16 = volumeEffect.endOffset;
        }
        Long l18 = l16;
        if ((i3 & 4) != 0) {
            l17 = volumeEffect.duration;
        }
        Long l19 = l17;
        if ((i3 & 8) != 0) {
            f16 = volumeEffect.start;
        }
        Float f18 = f16;
        if ((i3 & 16) != 0) {
            f17 = volumeEffect.end;
        }
        Float f19 = f17;
        if ((i3 & 32) != 0) {
            str = volumeEffect.interpolationType;
        }
        String str2 = str;
        if ((i3 & 64) != 0) {
            byteString = volumeEffect.unknownFields();
        }
        return volumeEffect.copy(l3, l18, l19, f18, f19, str2, byteString);
    }

    @NotNull
    public final VolumeEffect copy(@Nullable Long startOffset, @Nullable Long endOffset, @Nullable Long duration, @Nullable Float start, @Nullable Float end, @Nullable String interpolationType, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new VolumeEffect(startOffset, endOffset, duration, start, end, interpolationType, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof VolumeEffect)) {
            return false;
        }
        VolumeEffect volumeEffect = (VolumeEffect) other;
        if (Intrinsics.areEqual(unknownFields(), volumeEffect.unknownFields()) && Intrinsics.areEqual(this.startOffset, volumeEffect.startOffset) && Intrinsics.areEqual(this.endOffset, volumeEffect.endOffset) && Intrinsics.areEqual(this.duration, volumeEffect.duration) && Intrinsics.areEqual(this.start, volumeEffect.start) && Intrinsics.areEqual(this.end, volumeEffect.end) && Intrinsics.areEqual(this.interpolationType, volumeEffect.interpolationType)) {
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
        int i26 = this.hashCode;
        if (i26 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Long l3 = this.startOffset;
            int i27 = 0;
            if (l3 != null) {
                i3 = l3.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            Long l16 = this.endOffset;
            if (l16 != null) {
                i16 = l16.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            Long l17 = this.duration;
            if (l17 != null) {
                i17 = l17.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            Float f16 = this.start;
            if (f16 != null) {
                i18 = f16.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            Float f17 = this.end;
            if (f17 != null) {
                i19 = f17.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            String str = this.interpolationType;
            if (str != null) {
                i27 = str.hashCode();
            }
            int i39 = i38 + i27;
            this.hashCode = i39;
            return i39;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.startOffset != null) {
            arrayList.add("startOffset=" + this.startOffset);
        }
        if (this.endOffset != null) {
            arrayList.add("endOffset=" + this.endOffset);
        }
        if (this.duration != null) {
            arrayList.add("duration=" + this.duration);
        }
        if (this.start != null) {
            arrayList.add("start=" + this.start);
        }
        if (this.end != null) {
            arrayList.add("end=" + this.end);
        }
        if (this.interpolationType != null) {
            arrayList.add("interpolationType=" + Internal.sanitize(this.interpolationType));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "VolumeEffect{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ VolumeEffect(Long l3, Long l16, Long l17, Float f16, Float f17, String str, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? null : l16, (i3 & 4) != 0 ? null : l17, (i3 & 8) != 0 ? null : f16, (i3 & 16) != 0 ? null : f17, (i3 & 32) == 0 ? str : null, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.startOffset = this.startOffset;
        builder.endOffset = this.endOffset;
        builder.duration = this.duration;
        builder.start = this.start;
        builder.end = this.end;
        builder.interpolationType = this.interpolationType;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VolumeEffect(@Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @Nullable Float f16, @Nullable Float f17, @Nullable String str, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.startOffset = l3;
        this.endOffset = l16;
        this.duration = l17;
        this.start = f16;
        this.end = f17;
        this.interpolationType = str;
    }
}
