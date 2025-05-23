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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eBo\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011Ju\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "src", "strength", "", "version", "intensity", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LUTFilter extends AndroidMessage<LUTFilter, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<LUTFilter> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LUTFilter> CREATOR;

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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
    @JvmField
    @Nullable
    public final Float intensity;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    @Nullable
    public final Float strength;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0015J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "()V", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "intensity", "", "Ljava/lang/Float;", "src", "", "strength", "type", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<LUTFilter, Builder> {

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
        public Float intensity;

        @JvmField
        @Nullable
        public String src;

        @JvmField
        @Nullable
        public Float strength;

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
        public final Builder intensity(@Nullable Float intensity) {
            this.intensity = intensity;
            return this;
        }

        @NotNull
        public final Builder src(@Nullable String src) {
            this.src = src;
            return this;
        }

        @NotNull
        public final Builder strength(@Nullable Float strength) {
            this.strength = strength;
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
        public LUTFilter build() {
            return new LUTFilter(this.entityId, this.componentID, this.enabled, this.type, this.src, this.strength, this.version, this.intensity, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LUTFilter.class);
        final String str = "type.googleapis.com/publisher.LUTFilter";
        ProtoAdapter<LUTFilter> protoAdapter = new ProtoAdapter<LUTFilter>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.LUTFilter$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public LUTFilter decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                String str3 = null;
                Float f16 = null;
                Integer num3 = null;
                Float f17 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new LUTFilter(num, num2, bool, str2, str3, f16, num3, f17, reader.endMessageAndGetUnknownFields(beginMessage));
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
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull LUTFilter value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.encodeWithTag(writer, 4, value.type);
                protoAdapter3.encodeWithTag(writer, 5, value.src);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                protoAdapter4.encodeWithTag(writer, 6, value.strength);
                protoAdapter2.encodeWithTag(writer, 7, value.version);
                protoAdapter4.encodeWithTag(writer, 8, value.intensity);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull LUTFilter value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.type) + protoAdapter3.encodedSizeWithTag(5, value.src);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(6, value.strength) + protoAdapter2.encodedSizeWithTag(7, value.version) + protoAdapter4.encodedSizeWithTag(8, value.intensity) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public LUTFilter redact(@NotNull LUTFilter value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return LUTFilter.copy$default(value, null, null, null, null, null, null, null, null, ByteString.EMPTY, 255, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public LUTFilter() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ LUTFilter copy$default(LUTFilter lUTFilter, Integer num, Integer num2, Boolean bool, String str, String str2, Float f16, Integer num3, Float f17, ByteString byteString, int i3, Object obj) {
        Integer num4;
        Integer num5;
        Boolean bool2;
        String str3;
        String str4;
        Float f18;
        Integer num6;
        Float f19;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            num4 = lUTFilter.entityId;
        } else {
            num4 = num;
        }
        if ((i3 & 2) != 0) {
            num5 = lUTFilter.componentID;
        } else {
            num5 = num2;
        }
        if ((i3 & 4) != 0) {
            bool2 = lUTFilter.enabled;
        } else {
            bool2 = bool;
        }
        if ((i3 & 8) != 0) {
            str3 = lUTFilter.type;
        } else {
            str3 = str;
        }
        if ((i3 & 16) != 0) {
            str4 = lUTFilter.src;
        } else {
            str4 = str2;
        }
        if ((i3 & 32) != 0) {
            f18 = lUTFilter.strength;
        } else {
            f18 = f16;
        }
        if ((i3 & 64) != 0) {
            num6 = lUTFilter.version;
        } else {
            num6 = num3;
        }
        if ((i3 & 128) != 0) {
            f19 = lUTFilter.intensity;
        } else {
            f19 = f17;
        }
        if ((i3 & 256) != 0) {
            byteString2 = lUTFilter.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return lUTFilter.copy(num4, num5, bool2, str3, str4, f18, num6, f19, byteString2);
    }

    @NotNull
    public final LUTFilter copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable String src, @Nullable Float strength, @Nullable Integer version, @Nullable Float intensity, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new LUTFilter(entityId, componentID, enabled, type, src, strength, version, intensity, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof LUTFilter)) {
            return false;
        }
        LUTFilter lUTFilter = (LUTFilter) other;
        if (Intrinsics.areEqual(unknownFields(), lUTFilter.unknownFields()) && Intrinsics.areEqual(this.entityId, lUTFilter.entityId) && Intrinsics.areEqual(this.componentID, lUTFilter.componentID) && Intrinsics.areEqual(this.enabled, lUTFilter.enabled) && Intrinsics.areEqual(this.type, lUTFilter.type) && Intrinsics.areEqual(this.src, lUTFilter.src) && Intrinsics.areEqual(this.strength, lUTFilter.strength) && Intrinsics.areEqual(this.version, lUTFilter.version) && Intrinsics.areEqual(this.intensity, lUTFilter.intensity)) {
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
            String str2 = this.src;
            if (str2 != null) {
                i19 = str2.hashCode();
            } else {
                i19 = 0;
            }
            int i46 = (i39 + i19) * 37;
            Float f16 = this.strength;
            if (f16 != null) {
                i26 = f16.hashCode();
            } else {
                i26 = 0;
            }
            int i47 = (i46 + i26) * 37;
            Integer num3 = this.version;
            if (num3 != null) {
                i27 = num3.hashCode();
            } else {
                i27 = 0;
            }
            int i48 = (i47 + i27) * 37;
            Float f17 = this.intensity;
            if (f17 != null) {
                i29 = f17.hashCode();
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
        if (this.src != null) {
            arrayList.add("src=" + Internal.sanitize(this.src));
        }
        if (this.strength != null) {
            arrayList.add("strength=" + this.strength);
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        if (this.intensity != null) {
            arrayList.add("intensity=" + this.intensity);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "LUTFilter{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ LUTFilter(Integer num, Integer num2, Boolean bool, String str, String str2, Float f16, Integer num3, Float f17, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : f16, (i3 & 64) != 0 ? null : num3, (i3 & 128) == 0 ? f17 : null, (i3 & 256) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.src = this.src;
        builder.strength = this.strength;
        builder.version = this.version;
        builder.intensity = this.intensity;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LUTFilter(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Float f16, @Nullable Integer num3, @Nullable Float f17, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.src = str2;
        this.strength = f16;
        this.version = num3;
        this.intensity = f17;
    }
}
