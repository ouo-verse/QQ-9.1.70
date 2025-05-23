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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJa\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/RandomGroup;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/RandomGroup$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "randomType", "weights", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/RandomGroup;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class RandomGroup extends AndroidMessage<RandomGroup, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<RandomGroup> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<RandomGroup> CREATOR;

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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    @Nullable
    public final Integer randomType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 6)
    @JvmField
    @NotNull
    public final List<Integer> weights;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0012J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/RandomGroup$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/RandomGroup;", "()V", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "randomType", "type", "", "weights", "", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/RandomGroup$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/RandomGroup$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<RandomGroup, Builder> {

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
        public Integer randomType;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @NotNull
        public List<Integer> weights;

        public Builder() {
            List<Integer> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.weights = emptyList;
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
        public final Builder randomType(@Nullable Integer randomType) {
            this.randomType = randomType;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder weights(@NotNull List<Integer> weights) {
            Intrinsics.checkParameterIsNotNull(weights, "weights");
            Internal.checkElementsNotNull(weights);
            this.weights = weights;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public RandomGroup build() {
            return new RandomGroup(this.entityId, this.componentID, this.enabled, this.type, this.randomType, this.weights, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RandomGroup.class);
        final String str = "type.googleapis.com/publisher.RandomGroup";
        ProtoAdapter<RandomGroup> protoAdapter = new ProtoAdapter<RandomGroup>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.RandomGroup$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public RandomGroup decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                Integer num3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new RandomGroup(num, num2, bool, str2, num3, arrayList, reader.endMessageAndGetUnknownFields(beginMessage));
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
                            arrayList.add(ProtoAdapter.INT32.decode(reader));
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull RandomGroup value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter.STRING.encodeWithTag(writer, 4, value.type);
                protoAdapter2.encodeWithTag(writer, 5, value.randomType);
                protoAdapter2.asRepeated().encodeWithTag(writer, 6, value.weights);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull RandomGroup value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                return protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.type) + protoAdapter2.encodedSizeWithTag(5, value.randomType) + protoAdapter2.asRepeated().encodedSizeWithTag(6, value.weights) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public RandomGroup redact(@NotNull RandomGroup value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return RandomGroup.copy$default(value, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public RandomGroup() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ RandomGroup copy$default(RandomGroup randomGroup, Integer num, Integer num2, Boolean bool, String str, Integer num3, List list, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = randomGroup.entityId;
        }
        if ((i3 & 2) != 0) {
            num2 = randomGroup.componentID;
        }
        Integer num4 = num2;
        if ((i3 & 4) != 0) {
            bool = randomGroup.enabled;
        }
        Boolean bool2 = bool;
        if ((i3 & 8) != 0) {
            str = randomGroup.type;
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            num3 = randomGroup.randomType;
        }
        Integer num5 = num3;
        if ((i3 & 32) != 0) {
            list = randomGroup.weights;
        }
        List list2 = list;
        if ((i3 & 64) != 0) {
            byteString = randomGroup.unknownFields();
        }
        return randomGroup.copy(num, num4, bool2, str2, num5, list2, byteString);
    }

    @NotNull
    public final RandomGroup copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable Integer randomType, @NotNull List<Integer> weights, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(weights, "weights");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new RandomGroup(entityId, componentID, enabled, type, randomType, weights, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof RandomGroup)) {
            return false;
        }
        RandomGroup randomGroup = (RandomGroup) other;
        if (Intrinsics.areEqual(unknownFields(), randomGroup.unknownFields()) && Intrinsics.areEqual(this.entityId, randomGroup.entityId) && Intrinsics.areEqual(this.componentID, randomGroup.componentID) && Intrinsics.areEqual(this.enabled, randomGroup.enabled) && Intrinsics.areEqual(this.type, randomGroup.type) && Intrinsics.areEqual(this.randomType, randomGroup.randomType) && Intrinsics.areEqual(this.weights, randomGroup.weights)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityId;
            int i26 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            Integer num3 = this.randomType;
            if (num3 != null) {
                i26 = num3.hashCode();
            }
            int hashCode2 = ((i36 + i26) * 37) + this.weights.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i19;
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
        if (this.randomType != null) {
            arrayList.add("randomType=" + this.randomType);
        }
        if (!this.weights.isEmpty()) {
            arrayList.add("weights=" + this.weights);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "RandomGroup{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ RandomGroup(Integer num, Integer num2, Boolean bool, String str, Integer num3, List list, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) == 0 ? num3 : null, (i3 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.randomType = this.randomType;
        builder.weights = this.weights;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RandomGroup(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable Integer num3, @NotNull List<Integer> weights, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(weights, "weights");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.randomType = num3;
        this.weights = weights;
    }
}
