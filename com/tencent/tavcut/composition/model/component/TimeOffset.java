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
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eBo\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011Ju\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TimeOffset;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/TimeOffset$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "startOffset", "", "duration", "loopCount", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/TimeOffset;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TimeOffset extends AndroidMessage<TimeOffset, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<TimeOffset> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TimeOffset> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    @JvmField
    @Nullable
    public final Long duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    @JvmField
    @Nullable
    public final Integer loopCount;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    @JvmField
    @Nullable
    public final Long startOffset;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0015J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0016J\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TimeOffset$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/TimeOffset;", "()V", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", "duration", "", "Ljava/lang/Long;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "loopCount", "startOffset", "type", "", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/TimeOffset$Builder;", "(Ljava/lang/Long;)Lcom/tencent/tavcut/composition/model/component/TimeOffset$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/TimeOffset$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<TimeOffset, Builder> {

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Long duration;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public Integer loopCount;

        @JvmField
        @Nullable
        public Long startOffset;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer version;

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder duration(@Nullable Long duration) {
            this.duration = duration;
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
        public final Builder loopCount(@Nullable Integer loopCount) {
            this.loopCount = loopCount;
            return this;
        }

        @NotNull
        public final Builder startOffset(@Nullable Long startOffset) {
            this.startOffset = startOffset;
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

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public TimeOffset build() {
            return new TimeOffset(this.entityId, this.componentID, this.enabled, this.type, this.startOffset, this.duration, this.loopCount, this.version, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TimeOffset.class);
        final String str = "type.googleapis.com/publisher.TimeOffset";
        ProtoAdapter<TimeOffset> protoAdapter = new ProtoAdapter<TimeOffset>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.TimeOffset$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TimeOffset decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                Long l3 = null;
                Long l16 = null;
                Integer num3 = null;
                Integer num4 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new TimeOffset(num, num2, bool, str2, l3, l16, num3, num4, reader.endMessageAndGetUnknownFields(beginMessage));
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
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                        case 6:
                            l3 = ProtoAdapter.INT64.decode(reader);
                            break;
                        case 7:
                            l16 = ProtoAdapter.INT64.decode(reader);
                            break;
                        case 8:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 9:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull TimeOffset value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter.STRING.encodeWithTag(writer, 4, value.type);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                protoAdapter3.encodeWithTag(writer, 6, value.startOffset);
                protoAdapter3.encodeWithTag(writer, 7, value.duration);
                protoAdapter2.encodeWithTag(writer, 8, value.loopCount);
                protoAdapter2.encodeWithTag(writer, 9, value.version);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull TimeOffset value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.type);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(6, value.startOffset) + protoAdapter3.encodedSizeWithTag(7, value.duration) + protoAdapter2.encodedSizeWithTag(8, value.loopCount) + protoAdapter2.encodedSizeWithTag(9, value.version) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TimeOffset redact(@NotNull TimeOffset value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return TimeOffset.copy$default(value, null, null, null, null, null, null, null, null, ByteString.EMPTY, 255, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public TimeOffset() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ TimeOffset copy$default(TimeOffset timeOffset, Integer num, Integer num2, Boolean bool, String str, Long l3, Long l16, Integer num3, Integer num4, ByteString byteString, int i3, Object obj) {
        Integer num5;
        Integer num6;
        Boolean bool2;
        String str2;
        Long l17;
        Long l18;
        Integer num7;
        Integer num8;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            num5 = timeOffset.entityId;
        } else {
            num5 = num;
        }
        if ((i3 & 2) != 0) {
            num6 = timeOffset.componentID;
        } else {
            num6 = num2;
        }
        if ((i3 & 4) != 0) {
            bool2 = timeOffset.enabled;
        } else {
            bool2 = bool;
        }
        if ((i3 & 8) != 0) {
            str2 = timeOffset.type;
        } else {
            str2 = str;
        }
        if ((i3 & 16) != 0) {
            l17 = timeOffset.startOffset;
        } else {
            l17 = l3;
        }
        if ((i3 & 32) != 0) {
            l18 = timeOffset.duration;
        } else {
            l18 = l16;
        }
        if ((i3 & 64) != 0) {
            num7 = timeOffset.loopCount;
        } else {
            num7 = num3;
        }
        if ((i3 & 128) != 0) {
            num8 = timeOffset.version;
        } else {
            num8 = num4;
        }
        if ((i3 & 256) != 0) {
            byteString2 = timeOffset.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return timeOffset.copy(num5, num6, bool2, str2, l17, l18, num7, num8, byteString2);
    }

    @NotNull
    public final TimeOffset copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable Long startOffset, @Nullable Long duration, @Nullable Integer loopCount, @Nullable Integer version, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new TimeOffset(entityId, componentID, enabled, type, startOffset, duration, loopCount, version, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TimeOffset)) {
            return false;
        }
        TimeOffset timeOffset = (TimeOffset) other;
        if (Intrinsics.areEqual(unknownFields(), timeOffset.unknownFields()) && Intrinsics.areEqual(this.entityId, timeOffset.entityId) && Intrinsics.areEqual(this.componentID, timeOffset.componentID) && Intrinsics.areEqual(this.enabled, timeOffset.enabled) && Intrinsics.areEqual(this.type, timeOffset.type) && Intrinsics.areEqual(this.startOffset, timeOffset.startOffset) && Intrinsics.areEqual(this.duration, timeOffset.duration) && Intrinsics.areEqual(this.loopCount, timeOffset.loopCount) && Intrinsics.areEqual(this.version, timeOffset.version)) {
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
        int i28 = this.hashCode;
        if (i28 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityId;
            int i29 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i36 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i37 = (i36 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i38 = (i37 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i39 = (i38 + i18) * 37;
            Long l3 = this.startOffset;
            if (l3 != null) {
                i19 = l3.hashCode();
            } else {
                i19 = 0;
            }
            int i46 = (i39 + i19) * 37;
            Long l16 = this.duration;
            if (l16 != null) {
                i26 = l16.hashCode();
            } else {
                i26 = 0;
            }
            int i47 = (i46 + i26) * 37;
            Integer num3 = this.loopCount;
            if (num3 != null) {
                i27 = num3.hashCode();
            } else {
                i27 = 0;
            }
            int i48 = (i47 + i27) * 37;
            Integer num4 = this.version;
            if (num4 != null) {
                i29 = num4.hashCode();
            }
            int i49 = i48 + i29;
            this.hashCode = i49;
            return i49;
        }
        return i28;
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
        if (this.startOffset != null) {
            arrayList.add("startOffset=" + this.startOffset);
        }
        if (this.duration != null) {
            arrayList.add("duration=" + this.duration);
        }
        if (this.loopCount != null) {
            arrayList.add("loopCount=" + this.loopCount);
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TimeOffset{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ TimeOffset(Integer num, Integer num2, Boolean bool, String str, Long l3, Long l16, Integer num3, Integer num4, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : l3, (i3 & 32) != 0 ? null : l16, (i3 & 64) != 0 ? null : num3, (i3 & 128) == 0 ? num4 : null, (i3 & 256) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.startOffset = this.startOffset;
        builder.duration = this.duration;
        builder.loopCount = this.loopCount;
        builder.version = this.version;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeOffset(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable Long l3, @Nullable Long l16, @Nullable Integer num3, @Nullable Integer num4, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.startOffset = l3;
        this.duration = l16;
        this.loopCount = num3;
        this.version = num4;
    }
}
