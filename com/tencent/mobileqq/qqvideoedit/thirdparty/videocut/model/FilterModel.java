package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"BS\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J_\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u0014\u0010\u0013\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;", TAVBaseAutomaticEffect.EFFECT_TYPE_LUT, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;", "color", "", "startTimeUs", "durationUs", "timeLineIndex", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "Ljava/lang/String;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;", "J", "Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;JJLjava/lang/Integer;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class FilterModel extends AndroidMessage<FilterModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<FilterModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<FilterModel> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ColorFilterModel#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final ColorFilterModel color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @JvmField
    public final long durationUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String id;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.LutFilterModel#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final LutFilterModel lut;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    public final long startTimeUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer timeLineIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "a", "", "Ljava/lang/String;", "id", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;", "b", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;", TAVBaseAutomaticEffect.EFFECT_TYPE_LUT, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;", "c", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;", "color", "", "d", "J", "startTimeUs", "e", "durationUs", "", "f", "Ljava/lang/Integer;", "timeLineIndex", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<FilterModel, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public LutFilterModel lut;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public ColorFilterModel color;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long startTimeUs;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long durationUs;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer timeLineIndex;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FilterModel build() {
            String str = this.id;
            if (str == null) {
                str = "";
            }
            return new FilterModel(str, this.lut, this.color, this.startTimeUs, this.durationUs, this.timeLineIndex, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<FilterModel> {
        b(FieldEncoding fieldEncoding, KClass<FilterModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.FilterModel");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FilterModel decode(@NotNull ProtoReader reader) {
            String str;
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            String str2 = null;
            Integer num = null;
            long j3 = 0;
            long j16 = 0;
            LutFilterModel lutFilterModel = null;
            ColorFilterModel colorFilterModel = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            lutFilterModel = LutFilterModel.ADAPTER.decode(reader);
                            break;
                        case 3:
                            colorFilterModel = ColorFilterModel.ADAPTER.decode(reader);
                            break;
                        case 4:
                            j3 = ProtoAdapter.INT64.decode(reader).longValue();
                            break;
                        case 5:
                            j16 = ProtoAdapter.INT64.decode(reader).longValue();
                            break;
                        case 6:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                    String str3 = str2;
                    if (str3 == null) {
                        str = "";
                    } else {
                        str = str3;
                    }
                    return new FilterModel(str, lutFilterModel, colorFilterModel, j3, j16, num, endMessageAndGetUnknownFields);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull FilterModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.id);
            LutFilterModel.ADAPTER.encodeWithTag(writer, 2, value.lut);
            ColorFilterModel.ADAPTER.encodeWithTag(writer, 3, value.color);
            ProtoAdapter<Long> protoAdapter = ProtoAdapter.INT64;
            protoAdapter.encodeWithTag(writer, 4, Long.valueOf(value.startTimeUs));
            protoAdapter.encodeWithTag(writer, 5, Long.valueOf(value.durationUs));
            ProtoAdapter.INT32.encodeWithTag(writer, 6, value.timeLineIndex);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull FilterModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, value.id) + LutFilterModel.ADAPTER.encodedSizeWithTag(2, value.lut) + ColorFilterModel.ADAPTER.encodedSizeWithTag(3, value.color);
            ProtoAdapter<Long> protoAdapter = ProtoAdapter.INT64;
            return encodedSizeWithTag + protoAdapter.encodedSizeWithTag(4, Long.valueOf(value.startTimeUs)) + protoAdapter.encodedSizeWithTag(5, Long.valueOf(value.durationUs)) + ProtoAdapter.INT32.encodedSizeWithTag(6, value.timeLineIndex) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public FilterModel redact(@NotNull FilterModel value) {
            LutFilterModel lutFilterModel;
            ColorFilterModel colorFilterModel;
            Intrinsics.checkNotNullParameter(value, "value");
            LutFilterModel lutFilterModel2 = value.lut;
            if (lutFilterModel2 != null) {
                lutFilterModel = LutFilterModel.ADAPTER.redact(lutFilterModel2);
            } else {
                lutFilterModel = null;
            }
            ColorFilterModel colorFilterModel2 = value.color;
            if (colorFilterModel2 != null) {
                colorFilterModel = ColorFilterModel.ADAPTER.redact(colorFilterModel2);
            } else {
                colorFilterModel = null;
            }
            return FilterModel.copy$default(value, null, lutFilterModel, colorFilterModel, null, null, null, ByteString.EMPTY, 57, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FilterModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public FilterModel() {
        this(null, null, null, 0L, 0L, null, null, 127, null);
    }

    public static /* synthetic */ FilterModel copy$default(FilterModel filterModel, String str, LutFilterModel lutFilterModel, ColorFilterModel colorFilterModel, Long l3, Long l16, Integer num, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = filterModel.id;
        }
        if ((i3 & 2) != 0) {
            lutFilterModel = filterModel.lut;
        }
        LutFilterModel lutFilterModel2 = lutFilterModel;
        if ((i3 & 4) != 0) {
            colorFilterModel = filterModel.color;
        }
        ColorFilterModel colorFilterModel2 = colorFilterModel;
        if ((i3 & 8) != 0) {
            l3 = Long.valueOf(filterModel.startTimeUs);
        }
        Long l17 = l3;
        if ((i3 & 16) != 0) {
            l16 = Long.valueOf(filterModel.durationUs);
        }
        Long l18 = l16;
        if ((i3 & 32) != 0) {
            num = filterModel.timeLineIndex;
        }
        Integer num2 = num;
        if ((i3 & 64) != 0) {
            byteString = filterModel.unknownFields();
        }
        return filterModel.copy(str, lutFilterModel2, colorFilterModel2, l17, l18, num2, byteString);
    }

    @NotNull
    public final FilterModel copy(@Nullable String id5, @Nullable LutFilterModel lut, @Nullable ColorFilterModel color, @Nullable Long startTimeUs, @Nullable Long durationUs, @Nullable Integer timeLineIndex, @NotNull ByteString unknownFields) {
        String str;
        long j3;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (id5 == null) {
            str = "";
        } else {
            str = id5;
        }
        long j16 = 0;
        if (startTimeUs != null) {
            j3 = startTimeUs.longValue();
        } else {
            j3 = 0;
        }
        if (durationUs != null) {
            j16 = durationUs.longValue();
        }
        return new FilterModel(str, lut, color, j3, j16, timeLineIndex, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof FilterModel)) {
            return false;
        }
        FilterModel filterModel = (FilterModel) other;
        if (Intrinsics.areEqual(unknownFields(), filterModel.unknownFields()) && Intrinsics.areEqual(this.id, filterModel.id) && Intrinsics.areEqual(this.lut, filterModel.lut) && Intrinsics.areEqual(this.color, filterModel.color) && this.startTimeUs == filterModel.startTimeUs && this.durationUs == filterModel.durationUs && Intrinsics.areEqual(this.timeLineIndex, filterModel.timeLineIndex)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37;
            LutFilterModel lutFilterModel = this.lut;
            int i18 = 0;
            if (lutFilterModel != null) {
                i3 = lutFilterModel.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            ColorFilterModel colorFilterModel = this.color;
            if (colorFilterModel != null) {
                i16 = colorFilterModel.hashCode();
            } else {
                i16 = 0;
            }
            int a16 = (((((i19 + i16) * 37) + androidx.fragment.app.a.a(this.startTimeUs)) * 37) + androidx.fragment.app.a.a(this.durationUs)) * 37;
            Integer num = this.timeLineIndex;
            if (num != null) {
                i18 = num.hashCode();
            }
            int i26 = a16 + i18;
            this.hashCode = i26;
            return i26;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        String str = this.id;
        if (str != null) {
            arrayList.add("id=" + Internal.sanitize(str));
        }
        LutFilterModel lutFilterModel = this.lut;
        if (lutFilterModel != null) {
            arrayList.add("lut=" + lutFilterModel);
        }
        ColorFilterModel colorFilterModel = this.color;
        if (colorFilterModel != null) {
            arrayList.add("color=" + colorFilterModel);
        }
        arrayList.add("startTimeUs=" + this.startTimeUs);
        arrayList.add("durationUs=" + this.durationUs);
        Integer num = this.timeLineIndex;
        if (num != null) {
            arrayList.add("timeLineIndex=" + num);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "FilterModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ FilterModel(String str, LutFilterModel lutFilterModel, ColorFilterModel colorFilterModel, long j3, long j16, Integer num, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : lutFilterModel, (i3 & 4) != 0 ? null : colorFilterModel, (i3 & 8) != 0 ? 0L : j3, (i3 & 16) == 0 ? j16 : 0L, (i3 & 32) == 0 ? num : null, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.lut = this.lut;
        aVar.color = this.color;
        aVar.startTimeUs = this.startTimeUs;
        aVar.durationUs = this.durationUs;
        aVar.timeLineIndex = this.timeLineIndex;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterModel(@NotNull String id5, @Nullable LutFilterModel lutFilterModel, @Nullable ColorFilterModel colorFilterModel, long j3, long j16, @Nullable Integer num, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.id = id5;
        this.lut = lutFilterModel;
        this.color = colorFilterModel;
        this.startTimeUs = j3;
        this.durationUs = j16;
        this.timeLineIndex = num;
    }
}
