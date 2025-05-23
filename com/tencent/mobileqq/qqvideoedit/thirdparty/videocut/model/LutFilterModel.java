package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dBS\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J_\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "name", ShortVideoConstants.PARAM_KEY_FILTER_ID, "filePath", "", "intensity", "categoryId", "themeId", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;", "Ljava/lang/String;", UserInfo.SEX_FEMALE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LutFilterModel extends AndroidMessage<LutFilterModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<LutFilterModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LutFilterModel> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String categoryId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @NotNull
    public final String filePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String filterId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    @JvmField
    public final float intensity;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @Nullable
    public final String themeId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;", "a", "", "Ljava/lang/String;", "name", "b", ShortVideoConstants.PARAM_KEY_FILTER_ID, "c", "filePath", "", "d", "Ljava/lang/Float;", "intensity", "e", "categoryId", "f", "themeId", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<LutFilterModel, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String filterId = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String filePath = "";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Float intensity;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String categoryId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String themeId;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LutFilterModel build() {
            float f16;
            String str = this.name;
            String str2 = this.filterId;
            String str3 = this.filePath;
            Float f17 = this.intensity;
            if (f17 != null) {
                f16 = f17.floatValue();
            } else {
                f16 = 0.0f;
            }
            return new LutFilterModel(str, str2, str3, f16, this.categoryId, this.themeId, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/LutFilterModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<LutFilterModel> {
        b(FieldEncoding fieldEncoding, KClass<LutFilterModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.LutFilterModel");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LutFilterModel decode(@NotNull ProtoReader reader) {
            float f16;
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = "";
            String str5 = str4;
            Float f17 = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 5:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                    String str6 = str;
                    String str7 = str4;
                    String str8 = str5;
                    Float f18 = f17;
                    if (f18 != null) {
                        f16 = f18.floatValue();
                    } else {
                        f16 = 0.0f;
                    }
                    return new LutFilterModel(str6, str7, str8, f16, str2, str3, endMessageAndGetUnknownFields);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull LutFilterModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.name);
            protoAdapter.encodeWithTag(writer, 2, value.filterId);
            protoAdapter.encodeWithTag(writer, 3, value.filePath);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 4, Float.valueOf(value.intensity));
            protoAdapter.encodeWithTag(writer, 5, value.categoryId);
            protoAdapter.encodeWithTag(writer, 6, value.themeId);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull LutFilterModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, value.name) + protoAdapter.encodedSizeWithTag(2, value.filterId) + protoAdapter.encodedSizeWithTag(3, value.filePath) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, Float.valueOf(value.intensity)) + protoAdapter.encodedSizeWithTag(5, value.categoryId) + protoAdapter.encodedSizeWithTag(6, value.themeId) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public LutFilterModel redact(@NotNull LutFilterModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return LutFilterModel.copy$default(value, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LutFilterModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public LutFilterModel() {
        this(null, null, null, 0.0f, null, null, null, 127, null);
    }

    public static /* synthetic */ LutFilterModel copy$default(LutFilterModel lutFilterModel, String str, String str2, String str3, Float f16, String str4, String str5, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = lutFilterModel.name;
        }
        if ((i3 & 2) != 0) {
            str2 = lutFilterModel.filterId;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = lutFilterModel.filePath;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            f16 = Float.valueOf(lutFilterModel.intensity);
        }
        Float f17 = f16;
        if ((i3 & 16) != 0) {
            str4 = lutFilterModel.categoryId;
        }
        String str8 = str4;
        if ((i3 & 32) != 0) {
            str5 = lutFilterModel.themeId;
        }
        String str9 = str5;
        if ((i3 & 64) != 0) {
            byteString = lutFilterModel.unknownFields();
        }
        return lutFilterModel.copy(str, str6, str7, f17, str8, str9, byteString);
    }

    @NotNull
    public final LutFilterModel copy(@Nullable String name, @Nullable String filterId, @Nullable String filePath, @Nullable Float intensity, @Nullable String categoryId, @Nullable String themeId, @NotNull ByteString unknownFields) {
        String str;
        String str2;
        float f16;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (filterId == null) {
            str = "";
        } else {
            str = filterId;
        }
        if (filePath == null) {
            str2 = "";
        } else {
            str2 = filePath;
        }
        if (intensity != null) {
            f16 = intensity.floatValue();
        } else {
            f16 = 0.0f;
        }
        return new LutFilterModel(name, str, str2, f16, categoryId, themeId, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (other == this) {
            return true;
        }
        if (!(other instanceof LutFilterModel)) {
            return false;
        }
        LutFilterModel lutFilterModel = (LutFilterModel) other;
        if (Intrinsics.areEqual(unknownFields(), lutFilterModel.unknownFields()) && Intrinsics.areEqual(this.name, lutFilterModel.name) && Intrinsics.areEqual(this.filterId, lutFilterModel.filterId) && Intrinsics.areEqual(this.filePath, lutFilterModel.filePath)) {
            if (this.intensity == lutFilterModel.intensity) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && Intrinsics.areEqual(this.categoryId, lutFilterModel.categoryId) && Intrinsics.areEqual(this.themeId, lutFilterModel.themeId)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.name;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = (((((((hashCode + i3) * 37) + this.filterId.hashCode()) * 37) + this.filePath.hashCode()) * 37) + Float.floatToIntBits(this.intensity)) * 37;
            String str2 = this.categoryId;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (hashCode2 + i16) * 37;
            String str3 = this.themeId;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int i26 = i19 + i18;
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
        String str = this.name;
        if (str != null) {
            arrayList.add("name=" + Internal.sanitize(str));
        }
        String str2 = this.filterId;
        if (str2 != null) {
            arrayList.add("filterId=" + Internal.sanitize(str2));
        }
        String str3 = this.filePath;
        if (str3 != null) {
            arrayList.add("filePath=" + Internal.sanitize(str3));
        }
        arrayList.add("intensity=" + this.intensity);
        String str4 = this.categoryId;
        if (str4 != null) {
            arrayList.add("categoryId=" + Internal.sanitize(str4));
        }
        String str5 = this.themeId;
        if (str5 != null) {
            arrayList.add("themeId=" + Internal.sanitize(str5));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "LutFilterModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ LutFilterModel(String str, String str2, String str3, float f16, String str4, String str5, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) == 0 ? str3 : "", (i3 & 8) != 0 ? 0.0f : f16, (i3 & 16) != 0 ? null : str4, (i3 & 32) == 0 ? str5 : null, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.name = this.name;
        aVar.filterId = this.filterId;
        aVar.filePath = this.filePath;
        aVar.intensity = Float.valueOf(this.intensity);
        aVar.categoryId = this.categoryId;
        aVar.themeId = this.themeId;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LutFilterModel(@Nullable String str, @NotNull String filterId, @NotNull String filePath, float f16, @Nullable String str2, @Nullable String str3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(filterId, "filterId");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.name = str;
        this.filterId = filterId;
        this.filePath = filePath;
        this.intensity = f16;
        this.categoryId = str2;
        this.themeId = str3;
    }
}
