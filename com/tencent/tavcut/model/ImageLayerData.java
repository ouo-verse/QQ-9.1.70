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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ@\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/tavcut/model/ImageLayerData;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/ImageLayerData$Builder;", "layerIndex", "", "layerName", "", "layerType", "layerMarkList", "", "Lcom/tencent/tavcut/model/LayerMarkData;", "unknownFields", "Lokio/ByteString;", "(ILjava/lang/String;ILjava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class ImageLayerData extends AndroidMessage<ImageLayerData, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<ImageLayerData> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ImageLayerData> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 1)
    @JvmField
    public final int layerIndex;

    @WireField(adapter = "com.tencent.tavcut.model.LayerMarkData#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    @JvmField
    @NotNull
    public final List<LayerMarkData> layerMarkList;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String layerName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    @JvmField
    public final int layerType;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/model/ImageLayerData$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/ImageLayerData;", "()V", "layerIndex", "", "Ljava/lang/Integer;", "layerMarkList", "", "Lcom/tencent/tavcut/model/LayerMarkData;", "layerName", "", "layerType", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<ImageLayerData, Builder> {

        @JvmField
        @Nullable
        public Integer layerIndex;

        @JvmField
        @NotNull
        public List<LayerMarkData> layerMarkList;

        @JvmField
        @Nullable
        public String layerName;

        @JvmField
        @Nullable
        public Integer layerType;

        public Builder() {
            List<LayerMarkData> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.layerMarkList = emptyList;
        }

        @NotNull
        public final Builder layerIndex(int layerIndex) {
            this.layerIndex = Integer.valueOf(layerIndex);
            return this;
        }

        @NotNull
        public final Builder layerMarkList(@NotNull List<LayerMarkData> layerMarkList) {
            Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
            Internal.checkElementsNotNull(layerMarkList);
            this.layerMarkList = layerMarkList;
            return this;
        }

        @NotNull
        public final Builder layerName(@Nullable String layerName) {
            this.layerName = layerName;
            return this;
        }

        @NotNull
        public final Builder layerType(int layerType) {
            this.layerType = Integer.valueOf(layerType);
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public ImageLayerData build() {
            Integer num = this.layerIndex;
            if (num != null) {
                int intValue = num.intValue();
                String str = this.layerName;
                Integer num2 = this.layerType;
                if (num2 != null) {
                    return new ImageLayerData(intValue, str, num2.intValue(), this.layerMarkList, buildUnknownFields());
                }
                throw Internal.missingRequiredFields(num2, "layerType");
            }
            throw Internal.missingRequiredFields(num, "layerIndex");
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ImageLayerData.class);
        final String str = "type.googleapis.com/publisher.ImageLayerData";
        ProtoAdapter<ImageLayerData> protoAdapter = new ProtoAdapter<ImageLayerData>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.ImageLayerData$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ImageLayerData decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                String str2 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        break;
                    }
                    if (nextTag == 1) {
                        num = ProtoAdapter.INT32.decode(reader);
                    } else if (nextTag == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (nextTag == 3) {
                        num2 = ProtoAdapter.INT32.decode(reader);
                    } else if (nextTag != 4) {
                        reader.readUnknownField(nextTag);
                    } else {
                        arrayList.add(LayerMarkData.ADAPTER.decode(reader));
                    }
                }
                ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                if (num != null) {
                    int intValue = num.intValue();
                    if (num2 != null) {
                        return new ImageLayerData(intValue, str2, num2.intValue(), arrayList, endMessageAndGetUnknownFields);
                    }
                    throw Internal.missingRequiredFields(num2, "layerType");
                }
                throw Internal.missingRequiredFields(num, "layerIndex");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull ImageLayerData value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, Integer.valueOf(value.layerIndex));
                ProtoAdapter.STRING.encodeWithTag(writer, 2, value.layerName);
                protoAdapter2.encodeWithTag(writer, 3, Integer.valueOf(value.layerType));
                LayerMarkData.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.layerMarkList);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull ImageLayerData value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                return protoAdapter2.encodedSizeWithTag(1, Integer.valueOf(value.layerIndex)) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.layerName) + protoAdapter2.encodedSizeWithTag(3, Integer.valueOf(value.layerType)) + LayerMarkData.ADAPTER.asRepeated().encodedSizeWithTag(4, value.layerMarkList) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ImageLayerData redact(@NotNull ImageLayerData value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return ImageLayerData.copy$default(value, 0, null, 0, Internal.m87redactElements(value.layerMarkList, LayerMarkData.ADAPTER), ByteString.EMPTY, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public /* synthetic */ ImageLayerData(int i3, String str, int i16, List list, ByteString byteString, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? null : str, i16, (i17 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 16) != 0 ? ByteString.EMPTY : byteString);
    }

    public static /* synthetic */ ImageLayerData copy$default(ImageLayerData imageLayerData, int i3, String str, int i16, List list, ByteString byteString, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = imageLayerData.layerIndex;
        }
        if ((i17 & 2) != 0) {
            str = imageLayerData.layerName;
        }
        String str2 = str;
        if ((i17 & 4) != 0) {
            i16 = imageLayerData.layerType;
        }
        int i18 = i16;
        if ((i17 & 8) != 0) {
            list = imageLayerData.layerMarkList;
        }
        List list2 = list;
        if ((i17 & 16) != 0) {
            byteString = imageLayerData.unknownFields();
        }
        return imageLayerData.copy(i3, str2, i18, list2, byteString);
    }

    @NotNull
    public final ImageLayerData copy(int layerIndex, @Nullable String layerName, int layerType, @NotNull List<LayerMarkData> layerMarkList, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new ImageLayerData(layerIndex, layerName, layerType, layerMarkList, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ImageLayerData)) {
            return false;
        }
        ImageLayerData imageLayerData = (ImageLayerData) other;
        if (Intrinsics.areEqual(unknownFields(), imageLayerData.unknownFields()) && this.layerIndex == imageLayerData.layerIndex && Intrinsics.areEqual(this.layerName, imageLayerData.layerName) && this.layerType == imageLayerData.layerType && Intrinsics.areEqual(this.layerMarkList, imageLayerData.layerMarkList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.layerIndex) * 37;
            String str = this.layerName;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((((hashCode + i3) * 37) + this.layerType) * 37) + this.layerMarkList.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        arrayList.add("layerIndex=" + this.layerIndex);
        if (this.layerName != null) {
            arrayList.add("layerName=" + Internal.sanitize(this.layerName));
        }
        arrayList.add("layerType=" + this.layerType);
        if (!this.layerMarkList.isEmpty()) {
            arrayList.add("layerMarkList=" + this.layerMarkList);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ImageLayerData{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.layerIndex = Integer.valueOf(this.layerIndex);
        builder.layerName = this.layerName;
        builder.layerType = Integer.valueOf(this.layerType);
        builder.layerMarkList = this.layerMarkList;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLayerData(int i3, @Nullable String str, int i16, @NotNull List<LayerMarkData> layerMarkList, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.layerIndex = i3;
        this.layerName = str;
        this.layerType = i16;
        this.layerMarkList = layerMarkList;
    }
}
