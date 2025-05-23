package com.tencent.tavcut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aBW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010Jd\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u0010\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/tavcut/model/TextPlaceInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/TextPlaceInfo$Builder;", "key", "", "text", "fillColor", "", "maxLength", "layerWidth", "", "layerHeight", "replaceIndex", TemplateParser.KEY_ENTITY_ID, "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;IIFFIILokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TextPlaceInfo extends AndroidMessage<TextPlaceInfo, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<TextPlaceInfo> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TextPlaceInfo> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 8)
    @JvmField
    public final int entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    @JvmField
    public final int fillColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 6)
    @JvmField
    public final float layerHeight;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 5)
    @JvmField
    public final float layerWidth;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    @JvmField
    public final int maxLength;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 7)
    @JvmField
    public final int replaceIndex;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String text;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/model/TextPlaceInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "()V", TemplateParser.KEY_ENTITY_ID, "", "Ljava/lang/Integer;", "fillColor", "key", "", "layerHeight", "", "Ljava/lang/Float;", "layerWidth", "maxLength", "replaceIndex", "text", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<TextPlaceInfo, Builder> {

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public Integer fillColor;

        @JvmField
        @Nullable
        public String key;

        @JvmField
        @Nullable
        public Float layerHeight;

        @JvmField
        @Nullable
        public Float layerWidth;

        @JvmField
        @Nullable
        public Integer maxLength;

        @JvmField
        @Nullable
        public Integer replaceIndex;

        @JvmField
        @Nullable
        public String text;

        @NotNull
        public final Builder entityId(int entityId) {
            this.entityId = Integer.valueOf(entityId);
            return this;
        }

        @NotNull
        public final Builder fillColor(int fillColor) {
            this.fillColor = Integer.valueOf(fillColor);
            return this;
        }

        @NotNull
        public final Builder key(@Nullable String key) {
            this.key = key;
            return this;
        }

        @NotNull
        public final Builder layerHeight(float layerHeight) {
            this.layerHeight = Float.valueOf(layerHeight);
            return this;
        }

        @NotNull
        public final Builder layerWidth(float layerWidth) {
            this.layerWidth = Float.valueOf(layerWidth);
            return this;
        }

        @NotNull
        public final Builder maxLength(int maxLength) {
            this.maxLength = Integer.valueOf(maxLength);
            return this;
        }

        @NotNull
        public final Builder replaceIndex(int replaceIndex) {
            this.replaceIndex = Integer.valueOf(replaceIndex);
            return this;
        }

        @NotNull
        public final Builder text(@Nullable String text) {
            this.text = text;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public TextPlaceInfo build() {
            String str = this.key;
            String str2 = this.text;
            Integer num = this.fillColor;
            if (num != null) {
                int intValue = num.intValue();
                Integer num2 = this.maxLength;
                if (num2 != null) {
                    int intValue2 = num2.intValue();
                    Float f16 = this.layerWidth;
                    if (f16 != null) {
                        float floatValue = f16.floatValue();
                        Float f17 = this.layerHeight;
                        if (f17 != null) {
                            float floatValue2 = f17.floatValue();
                            Integer num3 = this.replaceIndex;
                            if (num3 != null) {
                                int intValue3 = num3.intValue();
                                Integer num4 = this.entityId;
                                if (num4 != null) {
                                    return new TextPlaceInfo(str, str2, intValue, intValue2, floatValue, floatValue2, intValue3, num4.intValue(), buildUnknownFields());
                                }
                                throw Internal.missingRequiredFields(num4, TemplateParser.KEY_ENTITY_ID);
                            }
                            throw Internal.missingRequiredFields(num3, "replaceIndex");
                        }
                        throw Internal.missingRequiredFields(f17, "layerHeight");
                    }
                    throw Internal.missingRequiredFields(f16, "layerWidth");
                }
                throw Internal.missingRequiredFields(num2, "maxLength");
            }
            throw Internal.missingRequiredFields(num, "fillColor");
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TextPlaceInfo.class);
        final String str = "type.googleapis.com/publisher.TextPlaceInfo";
        ProtoAdapter<TextPlaceInfo> protoAdapter = new ProtoAdapter<TextPlaceInfo>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.TextPlaceInfo$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TextPlaceInfo decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                String str2 = null;
                Float f16 = null;
                Float f17 = null;
                Integer num3 = null;
                Integer num4 = null;
                String str3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                        if (num != null) {
                            int intValue = num.intValue();
                            if (num2 != null) {
                                int intValue2 = num2.intValue();
                                if (f16 != null) {
                                    float floatValue = f16.floatValue();
                                    if (f17 != null) {
                                        float floatValue2 = f17.floatValue();
                                        if (num3 != null) {
                                            int intValue3 = num3.intValue();
                                            if (num4 != null) {
                                                return new TextPlaceInfo(str2, str3, intValue, intValue2, floatValue, floatValue2, intValue3, num4.intValue(), endMessageAndGetUnknownFields);
                                            }
                                            throw Internal.missingRequiredFields(num4, TemplateParser.KEY_ENTITY_ID);
                                        }
                                        throw Internal.missingRequiredFields(num3, "replaceIndex");
                                    }
                                    throw Internal.missingRequiredFields(f17, "layerHeight");
                                }
                                throw Internal.missingRequiredFields(f16, "layerWidth");
                            }
                            throw Internal.missingRequiredFields(num2, "maxLength");
                        }
                        throw Internal.missingRequiredFields(num, "fillColor");
                    }
                    switch (nextTag) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 4:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 5:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 6:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 7:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 8:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull TextPlaceInfo value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.key);
                protoAdapter2.encodeWithTag(writer, 2, value.text);
                ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
                protoAdapter3.encodeWithTag(writer, 3, Integer.valueOf(value.fillColor));
                protoAdapter3.encodeWithTag(writer, 4, Integer.valueOf(value.maxLength));
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                protoAdapter4.encodeWithTag(writer, 5, Float.valueOf(value.layerWidth));
                protoAdapter4.encodeWithTag(writer, 6, Float.valueOf(value.layerHeight));
                protoAdapter3.encodeWithTag(writer, 7, Integer.valueOf(value.replaceIndex));
                protoAdapter3.encodeWithTag(writer, 8, Integer.valueOf(value.entityId));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull TextPlaceInfo value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.key) + protoAdapter2.encodedSizeWithTag(2, value.text);
                ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(3, Integer.valueOf(value.fillColor)) + protoAdapter3.encodedSizeWithTag(4, Integer.valueOf(value.maxLength));
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(5, Float.valueOf(value.layerWidth)) + protoAdapter4.encodedSizeWithTag(6, Float.valueOf(value.layerHeight)) + protoAdapter3.encodedSizeWithTag(7, Integer.valueOf(value.replaceIndex)) + protoAdapter3.encodedSizeWithTag(8, Integer.valueOf(value.entityId)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TextPlaceInfo redact(@NotNull TextPlaceInfo value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return TextPlaceInfo.copy$default(value, null, null, 0, 0, 0.0f, 0.0f, 0, 0, ByteString.EMPTY, 255, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public /* synthetic */ TextPlaceInfo(String str, String str2, int i3, int i16, float f16, float f17, int i17, int i18, ByteString byteString, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? null : str, (i19 & 2) != 0 ? null : str2, i3, i16, f16, f17, i17, i18, (i19 & 256) != 0 ? ByteString.EMPTY : byteString);
    }

    public static /* synthetic */ TextPlaceInfo copy$default(TextPlaceInfo textPlaceInfo, String str, String str2, int i3, int i16, float f16, float f17, int i17, int i18, ByteString byteString, int i19, Object obj) {
        String str3;
        String str4;
        int i26;
        int i27;
        float f18;
        float f19;
        int i28;
        int i29;
        ByteString byteString2;
        if ((i19 & 1) != 0) {
            str3 = textPlaceInfo.key;
        } else {
            str3 = str;
        }
        if ((i19 & 2) != 0) {
            str4 = textPlaceInfo.text;
        } else {
            str4 = str2;
        }
        if ((i19 & 4) != 0) {
            i26 = textPlaceInfo.fillColor;
        } else {
            i26 = i3;
        }
        if ((i19 & 8) != 0) {
            i27 = textPlaceInfo.maxLength;
        } else {
            i27 = i16;
        }
        if ((i19 & 16) != 0) {
            f18 = textPlaceInfo.layerWidth;
        } else {
            f18 = f16;
        }
        if ((i19 & 32) != 0) {
            f19 = textPlaceInfo.layerHeight;
        } else {
            f19 = f17;
        }
        if ((i19 & 64) != 0) {
            i28 = textPlaceInfo.replaceIndex;
        } else {
            i28 = i17;
        }
        if ((i19 & 128) != 0) {
            i29 = textPlaceInfo.entityId;
        } else {
            i29 = i18;
        }
        if ((i19 & 256) != 0) {
            byteString2 = textPlaceInfo.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return textPlaceInfo.copy(str3, str4, i26, i27, f18, f19, i28, i29, byteString2);
    }

    @NotNull
    public final TextPlaceInfo copy(@Nullable String key, @Nullable String text, int fillColor, int maxLength, float layerWidth, float layerHeight, int replaceIndex, int entityId, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new TextPlaceInfo(key, text, fillColor, maxLength, layerWidth, layerHeight, replaceIndex, entityId, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TextPlaceInfo)) {
            return false;
        }
        TextPlaceInfo textPlaceInfo = (TextPlaceInfo) other;
        if (Intrinsics.areEqual(unknownFields(), textPlaceInfo.unknownFields()) && Intrinsics.areEqual(this.key, textPlaceInfo.key) && Intrinsics.areEqual(this.text, textPlaceInfo.text) && this.fillColor == textPlaceInfo.fillColor && this.maxLength == textPlaceInfo.maxLength && this.layerWidth == textPlaceInfo.layerWidth && this.layerHeight == textPlaceInfo.layerHeight && this.replaceIndex == textPlaceInfo.replaceIndex && this.entityId == textPlaceInfo.entityId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.key;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.text;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int floatToIntBits = ((((((((((((i18 + i17) * 37) + this.fillColor) * 37) + this.maxLength) * 37) + Float.floatToIntBits(this.layerWidth)) * 37) + Float.floatToIntBits(this.layerHeight)) * 37) + this.replaceIndex) * 37) + this.entityId;
            this.hashCode = floatToIntBits;
            return floatToIntBits;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.key != null) {
            arrayList.add("key=" + Internal.sanitize(this.key));
        }
        if (this.text != null) {
            arrayList.add("text=" + Internal.sanitize(this.text));
        }
        arrayList.add("fillColor=" + this.fillColor);
        arrayList.add("maxLength=" + this.maxLength);
        arrayList.add("layerWidth=" + this.layerWidth);
        arrayList.add("layerHeight=" + this.layerHeight);
        arrayList.add("replaceIndex=" + this.replaceIndex);
        arrayList.add("entityId=" + this.entityId);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TextPlaceInfo{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextPlaceInfo(@Nullable String str, @Nullable String str2, int i3, int i16, float f16, float f17, int i17, int i18, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.key = str;
        this.text = str2;
        this.fillColor = i3;
        this.maxLength = i16;
        this.layerWidth = f16;
        this.layerHeight = f17;
        this.replaceIndex = i17;
        this.entityId = i18;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.key = this.key;
        builder.text = this.text;
        builder.fillColor = Integer.valueOf(this.fillColor);
        builder.maxLength = Integer.valueOf(this.maxLength);
        builder.layerWidth = Float.valueOf(this.layerWidth);
        builder.layerHeight = Float.valueOf(this.layerHeight);
        builder.replaceIndex = Integer.valueOf(this.replaceIndex);
        builder.entityId = Integer.valueOf(this.entityId);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
