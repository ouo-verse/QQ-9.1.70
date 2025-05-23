package com.tencent.tavcut.model;

import android.os.Parcelable;
import androidx.fragment.app.a;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012Jd\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/tavcut/model/PagEffectData;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/PagEffectData$Builder;", "filePath", "", "width", "", "height", "durationUs", "", "textLayerList", "", "Lcom/tencent/tavcut/model/TextLayerData;", "imageLayerList", "Lcom/tencent/tavcut/model/ImageLayerData;", "timeStretchMode", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;IIJLjava/util/List;Ljava/util/List;ILokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class PagEffectData extends AndroidMessage<PagEffectData, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<PagEffectData> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PagEffectData> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 4)
    @JvmField
    public final long durationUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String filePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    @JvmField
    public final int height;

    @WireField(adapter = "com.tencent.tavcut.model.ImageLayerData#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    @JvmField
    @NotNull
    public final List<ImageLayerData> imageLayerList;

    @WireField(adapter = "com.tencent.tavcut.model.TextLayerData#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    @JvmField
    @NotNull
    public final List<TextLayerData> textLayerList;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 7)
    @JvmField
    public final int timeStretchMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 2)
    @JvmField
    public final int width;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\f\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/tavcut/model/PagEffectData$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/PagEffectData;", "()V", "durationUs", "", "Ljava/lang/Long;", "filePath", "", "height", "", "Ljava/lang/Integer;", "imageLayerList", "", "Lcom/tencent/tavcut/model/ImageLayerData;", "textLayerList", "Lcom/tencent/tavcut/model/TextLayerData;", "timeStretchMode", "width", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<PagEffectData, Builder> {

        @JvmField
        @Nullable
        public Long durationUs;

        @JvmField
        @Nullable
        public String filePath;

        @JvmField
        @Nullable
        public Integer height;

        @JvmField
        @NotNull
        public List<ImageLayerData> imageLayerList;

        @JvmField
        @NotNull
        public List<TextLayerData> textLayerList;

        @JvmField
        @Nullable
        public Integer timeStretchMode;

        @JvmField
        @Nullable
        public Integer width;

        public Builder() {
            List<TextLayerData> emptyList;
            List<ImageLayerData> emptyList2;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.textLayerList = emptyList;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.imageLayerList = emptyList2;
        }

        @NotNull
        public final Builder durationUs(long durationUs) {
            this.durationUs = Long.valueOf(durationUs);
            return this;
        }

        @NotNull
        public final Builder filePath(@Nullable String filePath) {
            this.filePath = filePath;
            return this;
        }

        @NotNull
        public final Builder height(int height) {
            this.height = Integer.valueOf(height);
            return this;
        }

        @NotNull
        public final Builder imageLayerList(@NotNull List<ImageLayerData> imageLayerList) {
            Intrinsics.checkParameterIsNotNull(imageLayerList, "imageLayerList");
            Internal.checkElementsNotNull(imageLayerList);
            this.imageLayerList = imageLayerList;
            return this;
        }

        @NotNull
        public final Builder textLayerList(@NotNull List<TextLayerData> textLayerList) {
            Intrinsics.checkParameterIsNotNull(textLayerList, "textLayerList");
            Internal.checkElementsNotNull(textLayerList);
            this.textLayerList = textLayerList;
            return this;
        }

        @NotNull
        public final Builder timeStretchMode(int timeStretchMode) {
            this.timeStretchMode = Integer.valueOf(timeStretchMode);
            return this;
        }

        @NotNull
        public final Builder width(int width) {
            this.width = Integer.valueOf(width);
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public PagEffectData build() {
            String str = this.filePath;
            Integer num = this.width;
            if (num != null) {
                int intValue = num.intValue();
                Integer num2 = this.height;
                if (num2 != null) {
                    int intValue2 = num2.intValue();
                    Long l3 = this.durationUs;
                    if (l3 != null) {
                        long longValue = l3.longValue();
                        List<TextLayerData> list = this.textLayerList;
                        List<ImageLayerData> list2 = this.imageLayerList;
                        Integer num3 = this.timeStretchMode;
                        if (num3 != null) {
                            return new PagEffectData(str, intValue, intValue2, longValue, list, list2, num3.intValue(), buildUnknownFields());
                        }
                        throw Internal.missingRequiredFields(num3, "timeStretchMode");
                    }
                    throw Internal.missingRequiredFields(l3, "durationUs");
                }
                throw Internal.missingRequiredFields(num2, "height");
            }
            throw Internal.missingRequiredFields(num, "width");
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PagEffectData.class);
        final String str = "type.googleapis.com/publisher.PagEffectData";
        ProtoAdapter<PagEffectData> protoAdapter = new ProtoAdapter<PagEffectData>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.PagEffectData$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PagEffectData decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                long beginMessage = reader.beginMessage();
                String str2 = null;
                Integer num = null;
                Integer num2 = null;
                Long l3 = null;
                Integer num3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                        if (num != null) {
                            int intValue = num.intValue();
                            if (num2 != null) {
                                int intValue2 = num2.intValue();
                                if (l3 != null) {
                                    long longValue = l3.longValue();
                                    if (num3 != null) {
                                        return new PagEffectData(str2, intValue, intValue2, longValue, arrayList, arrayList2, num3.intValue(), endMessageAndGetUnknownFields);
                                    }
                                    throw Internal.missingRequiredFields(num3, "timeStretchMode");
                                }
                                throw Internal.missingRequiredFields(l3, "durationUs");
                            }
                            throw Internal.missingRequiredFields(num2, "height");
                        }
                        throw Internal.missingRequiredFields(num, "width");
                    }
                    switch (nextTag) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 3:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 4:
                            l3 = ProtoAdapter.INT64.decode(reader);
                            break;
                        case 5:
                            arrayList.add(TextLayerData.ADAPTER.decode(reader));
                            break;
                        case 6:
                            arrayList2.add(ImageLayerData.ADAPTER.decode(reader));
                            break;
                        case 7:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull PagEffectData value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter.STRING.encodeWithTag(writer, 1, value.filePath);
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 2, Integer.valueOf(value.width));
                protoAdapter2.encodeWithTag(writer, 3, Integer.valueOf(value.height));
                ProtoAdapter.INT64.encodeWithTag(writer, 4, Long.valueOf(value.durationUs));
                TextLayerData.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.textLayerList);
                ImageLayerData.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.imageLayerList);
                protoAdapter2.encodeWithTag(writer, 7, Integer.valueOf(value.timeStretchMode));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull PagEffectData value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, value.filePath);
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(2, Integer.valueOf(value.width)) + protoAdapter2.encodedSizeWithTag(3, Integer.valueOf(value.height)) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(value.durationUs)) + TextLayerData.ADAPTER.asRepeated().encodedSizeWithTag(5, value.textLayerList) + ImageLayerData.ADAPTER.asRepeated().encodedSizeWithTag(6, value.imageLayerList) + protoAdapter2.encodedSizeWithTag(7, Integer.valueOf(value.timeStretchMode)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PagEffectData redact(@NotNull PagEffectData value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return PagEffectData.copy$default(value, null, 0, 0, 0L, Internal.m87redactElements(value.textLayerList, TextLayerData.ADAPTER), Internal.m87redactElements(value.imageLayerList, ImageLayerData.ADAPTER), 0, ByteString.EMPTY, 79, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PagEffectData(String str, int i3, int i16, long j3, List list, List list2, int i17, ByteString byteString, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, i3, i16, j3, r8, r9, i17, (i18 & 128) != 0 ? ByteString.EMPTY : byteString);
        List list3;
        List list4;
        List emptyList;
        List emptyList2;
        String str2 = (i18 & 1) != 0 ? null : str;
        if ((i18 & 16) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list3 = emptyList2;
        } else {
            list3 = list;
        }
        if ((i18 & 32) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
    }

    public static /* synthetic */ PagEffectData copy$default(PagEffectData pagEffectData, String str, int i3, int i16, long j3, List list, List list2, int i17, ByteString byteString, int i18, Object obj) {
        String str2;
        int i19;
        int i26;
        long j16;
        List list3;
        List list4;
        int i27;
        ByteString byteString2;
        if ((i18 & 1) != 0) {
            str2 = pagEffectData.filePath;
        } else {
            str2 = str;
        }
        if ((i18 & 2) != 0) {
            i19 = pagEffectData.width;
        } else {
            i19 = i3;
        }
        if ((i18 & 4) != 0) {
            i26 = pagEffectData.height;
        } else {
            i26 = i16;
        }
        if ((i18 & 8) != 0) {
            j16 = pagEffectData.durationUs;
        } else {
            j16 = j3;
        }
        if ((i18 & 16) != 0) {
            list3 = pagEffectData.textLayerList;
        } else {
            list3 = list;
        }
        if ((i18 & 32) != 0) {
            list4 = pagEffectData.imageLayerList;
        } else {
            list4 = list2;
        }
        if ((i18 & 64) != 0) {
            i27 = pagEffectData.timeStretchMode;
        } else {
            i27 = i17;
        }
        if ((i18 & 128) != 0) {
            byteString2 = pagEffectData.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return pagEffectData.copy(str2, i19, i26, j16, list3, list4, i27, byteString2);
    }

    @NotNull
    public final PagEffectData copy(@Nullable String filePath, int width, int height, long durationUs, @NotNull List<TextLayerData> textLayerList, @NotNull List<ImageLayerData> imageLayerList, int timeStretchMode, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(textLayerList, "textLayerList");
        Intrinsics.checkParameterIsNotNull(imageLayerList, "imageLayerList");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new PagEffectData(filePath, width, height, durationUs, textLayerList, imageLayerList, timeStretchMode, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PagEffectData)) {
            return false;
        }
        PagEffectData pagEffectData = (PagEffectData) other;
        if (Intrinsics.areEqual(unknownFields(), pagEffectData.unknownFields()) && Intrinsics.areEqual(this.filePath, pagEffectData.filePath) && this.width == pagEffectData.width && this.height == pagEffectData.height && this.durationUs == pagEffectData.durationUs && Intrinsics.areEqual(this.textLayerList, pagEffectData.textLayerList) && Intrinsics.areEqual(this.imageLayerList, pagEffectData.imageLayerList) && this.timeStretchMode == pagEffectData.timeStretchMode) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.filePath;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = ((((((((((((hashCode + i3) * 37) + this.width) * 37) + this.height) * 37) + a.a(this.durationUs)) * 37) + this.textLayerList.hashCode()) * 37) + this.imageLayerList.hashCode()) * 37) + this.timeStretchMode;
            this.hashCode = a16;
            return a16;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.filePath != null) {
            arrayList.add("filePath=" + Internal.sanitize(this.filePath));
        }
        arrayList.add("width=" + this.width);
        arrayList.add("height=" + this.height);
        arrayList.add("durationUs=" + this.durationUs);
        if (!this.textLayerList.isEmpty()) {
            arrayList.add("textLayerList=" + this.textLayerList);
        }
        if (!this.imageLayerList.isEmpty()) {
            arrayList.add("imageLayerList=" + this.imageLayerList);
        }
        arrayList.add("timeStretchMode=" + this.timeStretchMode);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "PagEffectData{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.filePath = this.filePath;
        builder.width = Integer.valueOf(this.width);
        builder.height = Integer.valueOf(this.height);
        builder.durationUs = Long.valueOf(this.durationUs);
        builder.textLayerList = this.textLayerList;
        builder.imageLayerList = this.imageLayerList;
        builder.timeStretchMode = Integer.valueOf(this.timeStretchMode);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagEffectData(@Nullable String str, int i3, int i16, long j3, @NotNull List<TextLayerData> textLayerList, @NotNull List<ImageLayerData> imageLayerList, int i17, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(textLayerList, "textLayerList");
        Intrinsics.checkParameterIsNotNull(imageLayerList, "imageLayerList");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.filePath = str;
        this.width = i3;
        this.height = i16;
        this.durationUs = j3;
        this.textLayerList = textLayerList;
        this.imageLayerList = imageLayerList;
        this.timeStretchMode = i17;
    }
}
