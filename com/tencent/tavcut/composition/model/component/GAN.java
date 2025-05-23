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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0085\u0001\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/GAN;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/GAN$Builder;", TemplateParser.KEY_COMPONENT_ID, "", NodeProps.ENABLED, "", TemplateParser.KEY_ENTITY_ID, "factor", "inputResources", "", "", "level", "resourcePath", "version", "type", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/GAN;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class GAN extends AndroidMessage<GAN, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<GAN> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<GAN> CREATOR;

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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @JvmField
    @Nullable
    public final Integer factor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    @JvmField
    @NotNull
    public final List<String> inputResources;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @JvmField
    @Nullable
    public final String resourcePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0015J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\f\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/GAN$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/GAN;", "()V", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "factor", "inputResources", "", "", "level", "resourcePath", "type", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/GAN$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/GAN$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<GAN, Builder> {

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
        public Integer factor;

        @JvmField
        @NotNull
        public List<String> inputResources;

        @JvmField
        @Nullable
        public Integer level;

        @JvmField
        @Nullable
        public String resourcePath;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer version;

        public Builder() {
            List<String> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.inputResources = emptyList;
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
        public final Builder factor(@Nullable Integer factor) {
            this.factor = factor;
            return this;
        }

        @NotNull
        public final Builder inputResources(@NotNull List<String> inputResources) {
            Intrinsics.checkParameterIsNotNull(inputResources, "inputResources");
            Internal.checkElementsNotNull(inputResources);
            this.inputResources = inputResources;
            return this;
        }

        @NotNull
        public final Builder level(@Nullable Integer level) {
            this.level = level;
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
        public GAN build() {
            return new GAN(this.componentID, this.enabled, this.entityId, this.factor, this.inputResources, this.level, this.resourcePath, this.version, this.type, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GAN.class);
        final String str = "type.googleapis.com/publisher.GAN";
        ProtoAdapter<GAN> protoAdapter = new ProtoAdapter<GAN>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.GAN$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public GAN decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Boolean bool = null;
                Integer num2 = null;
                Integer num3 = null;
                Integer num4 = null;
                String str2 = null;
                Integer num5 = null;
                String str3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new GAN(num, bool, num2, num3, arrayList, num4, str2, num5, str3, reader.endMessageAndGetUnknownFields(beginMessage));
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
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 5:
                            arrayList.add(ProtoAdapter.STRING.decode(reader));
                            break;
                        case 6:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 7:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            num5 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 9:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull GAN value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.enabled);
                protoAdapter2.encodeWithTag(writer, 3, value.entityId);
                protoAdapter2.encodeWithTag(writer, 4, value.factor);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.asRepeated().encodeWithTag(writer, 5, value.inputResources);
                protoAdapter2.encodeWithTag(writer, 6, value.level);
                protoAdapter3.encodeWithTag(writer, 7, value.resourcePath);
                protoAdapter2.encodeWithTag(writer, 8, value.version);
                protoAdapter3.encodeWithTag(writer, 9, value.type);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull GAN value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(2, value.enabled) + protoAdapter2.encodedSizeWithTag(3, value.entityId) + protoAdapter2.encodedSizeWithTag(4, value.factor);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter3.asRepeated().encodedSizeWithTag(5, value.inputResources) + protoAdapter2.encodedSizeWithTag(6, value.level) + protoAdapter3.encodedSizeWithTag(7, value.resourcePath) + protoAdapter2.encodedSizeWithTag(8, value.version) + protoAdapter3.encodedSizeWithTag(9, value.type) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public GAN redact(@NotNull GAN value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return GAN.copy$default(value, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 511, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public GAN() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ GAN copy$default(GAN gan, Integer num, Boolean bool, Integer num2, Integer num3, List list, Integer num4, String str, Integer num5, String str2, ByteString byteString, int i3, Object obj) {
        Integer num6;
        Boolean bool2;
        Integer num7;
        Integer num8;
        List list2;
        Integer num9;
        String str3;
        Integer num10;
        String str4;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            num6 = gan.componentID;
        } else {
            num6 = num;
        }
        if ((i3 & 2) != 0) {
            bool2 = gan.enabled;
        } else {
            bool2 = bool;
        }
        if ((i3 & 4) != 0) {
            num7 = gan.entityId;
        } else {
            num7 = num2;
        }
        if ((i3 & 8) != 0) {
            num8 = gan.factor;
        } else {
            num8 = num3;
        }
        if ((i3 & 16) != 0) {
            list2 = gan.inputResources;
        } else {
            list2 = list;
        }
        if ((i3 & 32) != 0) {
            num9 = gan.level;
        } else {
            num9 = num4;
        }
        if ((i3 & 64) != 0) {
            str3 = gan.resourcePath;
        } else {
            str3 = str;
        }
        if ((i3 & 128) != 0) {
            num10 = gan.version;
        } else {
            num10 = num5;
        }
        if ((i3 & 256) != 0) {
            str4 = gan.type;
        } else {
            str4 = str2;
        }
        if ((i3 & 512) != 0) {
            byteString2 = gan.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return gan.copy(num6, bool2, num7, num8, list2, num9, str3, num10, str4, byteString2);
    }

    @NotNull
    public final GAN copy(@Nullable Integer componentID, @Nullable Boolean enabled, @Nullable Integer entityId, @Nullable Integer factor, @NotNull List<String> inputResources, @Nullable Integer level, @Nullable String resourcePath, @Nullable Integer version, @Nullable String type, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(inputResources, "inputResources");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new GAN(componentID, enabled, entityId, factor, inputResources, level, resourcePath, version, type, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof GAN)) {
            return false;
        }
        GAN gan = (GAN) other;
        if (Intrinsics.areEqual(unknownFields(), gan.unknownFields()) && Intrinsics.areEqual(this.componentID, gan.componentID) && Intrinsics.areEqual(this.enabled, gan.enabled) && Intrinsics.areEqual(this.entityId, gan.entityId) && Intrinsics.areEqual(this.factor, gan.factor) && Intrinsics.areEqual(this.inputResources, gan.inputResources) && Intrinsics.areEqual(this.level, gan.level) && Intrinsics.areEqual(this.resourcePath, gan.resourcePath) && Intrinsics.areEqual(this.version, gan.version) && Intrinsics.areEqual(this.type, gan.type)) {
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
            Integer num = this.componentID;
            int i29 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i36 = (hashCode + i3) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i16 = bool.hashCode();
            } else {
                i16 = 0;
            }
            int i37 = (i36 + i16) * 37;
            Integer num2 = this.entityId;
            if (num2 != null) {
                i17 = num2.hashCode();
            } else {
                i17 = 0;
            }
            int i38 = (i37 + i17) * 37;
            Integer num3 = this.factor;
            if (num3 != null) {
                i18 = num3.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode2 = (((i38 + i18) * 37) + this.inputResources.hashCode()) * 37;
            Integer num4 = this.level;
            if (num4 != null) {
                i19 = num4.hashCode();
            } else {
                i19 = 0;
            }
            int i39 = (hashCode2 + i19) * 37;
            String str = this.resourcePath;
            if (str != null) {
                i26 = str.hashCode();
            } else {
                i26 = 0;
            }
            int i46 = (i39 + i26) * 37;
            Integer num5 = this.version;
            if (num5 != null) {
                i27 = num5.hashCode();
            } else {
                i27 = 0;
            }
            int i47 = (i46 + i27) * 37;
            String str2 = this.type;
            if (str2 != null) {
                i29 = str2.hashCode();
            }
            int i48 = i47 + i29;
            this.hashCode = i48;
            return i48;
        }
        return i28;
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
        if (this.factor != null) {
            arrayList.add("factor=" + this.factor);
        }
        if (!this.inputResources.isEmpty()) {
            arrayList.add("inputResources=" + Internal.sanitize(this.inputResources));
        }
        if (this.level != null) {
            arrayList.add("level=" + this.level);
        }
        if (this.resourcePath != null) {
            arrayList.add("resourcePath=" + Internal.sanitize(this.resourcePath));
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "GAN{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ GAN(Integer num, Boolean bool, Integer num2, Integer num3, List list, Integer num4, String str, Integer num5, String str2, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 32) != 0 ? null : num4, (i3 & 64) != 0 ? null : str, (i3 & 128) != 0 ? null : num5, (i3 & 256) == 0 ? str2 : null, (i3 & 512) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.entityId = this.entityId;
        builder.factor = this.factor;
        builder.inputResources = this.inputResources;
        builder.level = this.level;
        builder.resourcePath = this.resourcePath;
        builder.version = this.version;
        builder.type = this.type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GAN(@Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2, @Nullable Integer num3, @NotNull List<String> inputResources, @Nullable Integer num4, @Nullable String str, @Nullable Integer num5, @Nullable String str2, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(inputResources, "inputResources");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.componentID = num;
        this.enabled = bool;
        this.entityId = num2;
        this.factor = num3;
        this.inputResources = inputResources;
        this.level = num4;
        this.resourcePath = str;
        this.version = num5;
        this.type = str2;
    }
}
