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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aBW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ]\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/CustomGraph;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/CustomGraph$Builder;", TemplateParser.KEY_COMPONENT_ID, "", NodeProps.ENABLED, "", TemplateParser.KEY_ENTITY_ID, "resourcePath", "", "type", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/CustomGraph;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class CustomGraph extends AndroidMessage<CustomGraph, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<CustomGraph> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<CustomGraph> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String resourcePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/CustomGraph$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/CustomGraph;", "()V", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "resourcePath", "", "type", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/CustomGraph$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/CustomGraph$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<CustomGraph, Builder> {

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
        public String resourcePath;

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
        public final Builder resourcePath(@Nullable String resourcePath) {
            this.resourcePath = resourcePath;
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
        public CustomGraph build() {
            return new CustomGraph(this.componentID, this.enabled, this.entityId, this.resourcePath, this.type, this.version, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CustomGraph.class);
        final String str = "type.googleapis.com/publisher.CustomGraph";
        ProtoAdapter<CustomGraph> protoAdapter = new ProtoAdapter<CustomGraph>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.CustomGraph$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public CustomGraph decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Boolean bool = null;
                Integer num2 = null;
                String str2 = null;
                String str3 = null;
                Integer num3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new CustomGraph(num, bool, num2, str2, str3, num3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 2:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 3:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull CustomGraph value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.enabled);
                protoAdapter2.encodeWithTag(writer, 3, value.entityId);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.encodeWithTag(writer, 4, value.resourcePath);
                protoAdapter3.encodeWithTag(writer, 5, value.type);
                protoAdapter2.encodeWithTag(writer, 6, value.version);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull CustomGraph value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(2, value.enabled) + protoAdapter2.encodedSizeWithTag(3, value.entityId);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.resourcePath) + protoAdapter3.encodedSizeWithTag(5, value.type) + protoAdapter2.encodedSizeWithTag(6, value.version) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public CustomGraph redact(@NotNull CustomGraph value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return CustomGraph.copy$default(value, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public CustomGraph() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CustomGraph copy$default(CustomGraph customGraph, Integer num, Boolean bool, Integer num2, String str, String str2, Integer num3, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = customGraph.componentID;
        }
        if ((i3 & 2) != 0) {
            bool = customGraph.enabled;
        }
        Boolean bool2 = bool;
        if ((i3 & 4) != 0) {
            num2 = customGraph.entityId;
        }
        Integer num4 = num2;
        if ((i3 & 8) != 0) {
            str = customGraph.resourcePath;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            str2 = customGraph.type;
        }
        String str4 = str2;
        if ((i3 & 32) != 0) {
            num3 = customGraph.version;
        }
        Integer num5 = num3;
        if ((i3 & 64) != 0) {
            byteString = customGraph.unknownFields();
        }
        return customGraph.copy(num, bool2, num4, str3, str4, num5, byteString);
    }

    @NotNull
    public final CustomGraph copy(@Nullable Integer componentID, @Nullable Boolean enabled, @Nullable Integer entityId, @Nullable String resourcePath, @Nullable String type, @Nullable Integer version, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new CustomGraph(componentID, enabled, entityId, resourcePath, type, version, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof CustomGraph)) {
            return false;
        }
        CustomGraph customGraph = (CustomGraph) other;
        if (Intrinsics.areEqual(unknownFields(), customGraph.unknownFields()) && Intrinsics.areEqual(this.componentID, customGraph.componentID) && Intrinsics.areEqual(this.enabled, customGraph.enabled) && Intrinsics.areEqual(this.entityId, customGraph.entityId) && Intrinsics.areEqual(this.resourcePath, customGraph.resourcePath) && Intrinsics.areEqual(this.type, customGraph.type) && Intrinsics.areEqual(this.version, customGraph.version)) {
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
            Integer num = this.componentID;
            int i27 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i16 = bool.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            Integer num2 = this.entityId;
            if (num2 != null) {
                i17 = num2.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str = this.resourcePath;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            String str2 = this.type;
            if (str2 != null) {
                i19 = str2.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            Integer num3 = this.version;
            if (num3 != null) {
                i27 = num3.hashCode();
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
        if (this.componentID != null) {
            arrayList.add("componentID=" + this.componentID);
        }
        if (this.enabled != null) {
            arrayList.add("enabled=" + this.enabled);
        }
        if (this.entityId != null) {
            arrayList.add("entityId=" + this.entityId);
        }
        if (this.resourcePath != null) {
            arrayList.add("resourcePath=" + Internal.sanitize(this.resourcePath));
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "CustomGraph{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ CustomGraph(Integer num, Boolean bool, Integer num2, String str, String str2, Integer num3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) == 0 ? num3 : null, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.entityId = this.entityId;
        builder.resourcePath = this.resourcePath;
        builder.type = this.type;
        builder.version = this.version;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomGraph(@Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2, @Nullable String str, @Nullable String str2, @Nullable Integer num3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.componentID = num;
        this.enabled = bool;
        this.entityId = num2;
        this.resourcePath = str;
        this.type = str2;
        this.version = num3;
    }
}
