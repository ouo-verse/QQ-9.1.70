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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB{\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0081\u0001\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Transition;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Transition$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "firstIndex", "lastIndex", "src", "duration", "", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/Transition;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class Transition extends AndroidMessage<Transition, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Transition> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Transition> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 8)
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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    @Nullable
    public final Integer firstIndex;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer lastIndex;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @JvmField
    @Nullable
    public final String src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0015J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0016J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0015J\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0015J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0015R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Transition$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Transition;", "()V", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", "duration", "", "Ljava/lang/Long;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "firstIndex", "lastIndex", "src", "", "type", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/Transition$Builder;", "(Ljava/lang/Long;)Lcom/tencent/tavcut/composition/model/component/Transition$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/Transition$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<Transition, Builder> {

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
        public Integer firstIndex;

        @JvmField
        @Nullable
        public Integer lastIndex;

        @JvmField
        @Nullable
        public String src;

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
        public final Builder firstIndex(@Nullable Integer firstIndex) {
            this.firstIndex = firstIndex;
            return this;
        }

        @NotNull
        public final Builder lastIndex(@Nullable Integer lastIndex) {
            this.lastIndex = lastIndex;
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

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public Transition build() {
            return new Transition(this.entityId, this.componentID, this.enabled, this.type, this.firstIndex, this.lastIndex, this.src, this.duration, this.version, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Transition.class);
        final String str = "type.googleapis.com/publisher.Transition";
        ProtoAdapter<Transition> protoAdapter = new ProtoAdapter<Transition>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.Transition$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Transition decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                Integer num3 = null;
                Integer num4 = null;
                String str3 = null;
                Long l3 = null;
                Integer num5 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new Transition(num, num2, bool, str2, num3, num4, str3, l3, num5, reader.endMessageAndGetUnknownFields(beginMessage));
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
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 6:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 7:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            l3 = ProtoAdapter.INT64.decode(reader);
                            break;
                        case 9:
                            num5 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Transition value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.encodeWithTag(writer, 4, value.type);
                protoAdapter2.encodeWithTag(writer, 5, value.firstIndex);
                protoAdapter2.encodeWithTag(writer, 6, value.lastIndex);
                protoAdapter3.encodeWithTag(writer, 7, value.src);
                ProtoAdapter.INT64.encodeWithTag(writer, 8, value.duration);
                protoAdapter2.encodeWithTag(writer, 9, value.version);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Transition value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.type) + protoAdapter2.encodedSizeWithTag(5, value.firstIndex) + protoAdapter2.encodedSizeWithTag(6, value.lastIndex) + protoAdapter3.encodedSizeWithTag(7, value.src) + ProtoAdapter.INT64.encodedSizeWithTag(8, value.duration) + protoAdapter2.encodedSizeWithTag(9, value.version) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Transition redact(@NotNull Transition value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return Transition.copy$default(value, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 511, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public Transition() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ Transition copy$default(Transition transition, Integer num, Integer num2, Boolean bool, String str, Integer num3, Integer num4, String str2, Long l3, Integer num5, ByteString byteString, int i3, Object obj) {
        Integer num6;
        Integer num7;
        Boolean bool2;
        String str3;
        Integer num8;
        Integer num9;
        String str4;
        Long l16;
        Integer num10;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            num6 = transition.entityId;
        } else {
            num6 = num;
        }
        if ((i3 & 2) != 0) {
            num7 = transition.componentID;
        } else {
            num7 = num2;
        }
        if ((i3 & 4) != 0) {
            bool2 = transition.enabled;
        } else {
            bool2 = bool;
        }
        if ((i3 & 8) != 0) {
            str3 = transition.type;
        } else {
            str3 = str;
        }
        if ((i3 & 16) != 0) {
            num8 = transition.firstIndex;
        } else {
            num8 = num3;
        }
        if ((i3 & 32) != 0) {
            num9 = transition.lastIndex;
        } else {
            num9 = num4;
        }
        if ((i3 & 64) != 0) {
            str4 = transition.src;
        } else {
            str4 = str2;
        }
        if ((i3 & 128) != 0) {
            l16 = transition.duration;
        } else {
            l16 = l3;
        }
        if ((i3 & 256) != 0) {
            num10 = transition.version;
        } else {
            num10 = num5;
        }
        if ((i3 & 512) != 0) {
            byteString2 = transition.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return transition.copy(num6, num7, bool2, str3, num8, num9, str4, l16, num10, byteString2);
    }

    @NotNull
    public final Transition copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable Integer firstIndex, @Nullable Integer lastIndex, @Nullable String src, @Nullable Long duration, @Nullable Integer version, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new Transition(entityId, componentID, enabled, type, firstIndex, lastIndex, src, duration, version, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Transition)) {
            return false;
        }
        Transition transition = (Transition) other;
        if (Intrinsics.areEqual(unknownFields(), transition.unknownFields()) && Intrinsics.areEqual(this.entityId, transition.entityId) && Intrinsics.areEqual(this.componentID, transition.componentID) && Intrinsics.areEqual(this.enabled, transition.enabled) && Intrinsics.areEqual(this.type, transition.type) && Intrinsics.areEqual(this.firstIndex, transition.firstIndex) && Intrinsics.areEqual(this.lastIndex, transition.lastIndex) && Intrinsics.areEqual(this.src, transition.src) && Intrinsics.areEqual(this.duration, transition.duration) && Intrinsics.areEqual(this.version, transition.version)) {
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
        int i29 = this.hashCode;
        if (i29 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityId;
            int i36 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i37 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i38 = (i37 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i39 = (i38 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i46 = (i39 + i18) * 37;
            Integer num3 = this.firstIndex;
            if (num3 != null) {
                i19 = num3.hashCode();
            } else {
                i19 = 0;
            }
            int i47 = (i46 + i19) * 37;
            Integer num4 = this.lastIndex;
            if (num4 != null) {
                i26 = num4.hashCode();
            } else {
                i26 = 0;
            }
            int i48 = (i47 + i26) * 37;
            String str2 = this.src;
            if (str2 != null) {
                i27 = str2.hashCode();
            } else {
                i27 = 0;
            }
            int i49 = (i48 + i27) * 37;
            Long l3 = this.duration;
            if (l3 != null) {
                i28 = l3.hashCode();
            } else {
                i28 = 0;
            }
            int i56 = (i49 + i28) * 37;
            Integer num5 = this.version;
            if (num5 != null) {
                i36 = num5.hashCode();
            }
            int i57 = i56 + i36;
            this.hashCode = i57;
            return i57;
        }
        return i29;
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
        if (this.firstIndex != null) {
            arrayList.add("firstIndex=" + this.firstIndex);
        }
        if (this.lastIndex != null) {
            arrayList.add("lastIndex=" + this.lastIndex);
        }
        if (this.src != null) {
            arrayList.add("src=" + Internal.sanitize(this.src));
        }
        if (this.duration != null) {
            arrayList.add("duration=" + this.duration);
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Transition{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ Transition(Integer num, Integer num2, Boolean bool, String str, Integer num3, Integer num4, String str2, Long l3, Integer num5, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : num3, (i3 & 32) != 0 ? null : num4, (i3 & 64) != 0 ? null : str2, (i3 & 128) != 0 ? null : l3, (i3 & 256) == 0 ? num5 : null, (i3 & 512) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.firstIndex = this.firstIndex;
        builder.lastIndex = this.lastIndex;
        builder.src = this.src;
        builder.duration = this.duration;
        builder.version = this.version;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transition(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str2, @Nullable Long l3, @Nullable Integer num5, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.firstIndex = num3;
        this.lastIndex = num4;
        this.src = str2;
        this.duration = l3;
        this.version = num5;
    }
}
