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

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aBY\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016JX\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "ratio16to9", "ratio9to16", "ratio1to1", "ratio3to4", "ratio4to3", "ratio1to2", "Lokio/ByteString;", "unknownFields", "copy", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class BackgroundResPack extends AndroidMessage<BackgroundResPack, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<BackgroundResPack> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<BackgroundResPack> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String ratio16to9;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @Nullable
    public final String ratio1to1;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @Nullable
    public final String ratio1to2;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String ratio3to4;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String ratio4to3;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String ratio9to16;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack;", "a", "", "Ljava/lang/String;", "ratio16to9", "b", "ratio9to16", "c", "ratio1to1", "d", "ratio3to4", "e", "ratio4to3", "f", "ratio1to2", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<BackgroundResPack, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String ratio16to9;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String ratio9to16;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String ratio1to1;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String ratio3to4;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String ratio4to3;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String ratio1to2;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackgroundResPack build() {
            return new BackgroundResPack(this.ratio16to9, this.ratio9to16, this.ratio1to1, this.ratio3to4, this.ratio4to3, this.ratio1to2, buildUnknownFields());
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<BackgroundResPack> {
        b(FieldEncoding fieldEncoding, KClass<BackgroundResPack> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.BackgroundResPack");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackgroundResPack decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    return new BackgroundResPack(str, str2, str3, str4, str5, str6, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull BackgroundResPack value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.ratio16to9);
            protoAdapter.encodeWithTag(writer, 2, value.ratio9to16);
            protoAdapter.encodeWithTag(writer, 3, value.ratio1to1);
            protoAdapter.encodeWithTag(writer, 4, value.ratio3to4);
            protoAdapter.encodeWithTag(writer, 5, value.ratio4to3);
            protoAdapter.encodeWithTag(writer, 6, value.ratio1to2);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull BackgroundResPack value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, value.ratio16to9) + protoAdapter.encodedSizeWithTag(2, value.ratio9to16) + protoAdapter.encodedSizeWithTag(3, value.ratio1to1) + protoAdapter.encodedSizeWithTag(4, value.ratio3to4) + protoAdapter.encodedSizeWithTag(5, value.ratio4to3) + protoAdapter.encodedSizeWithTag(6, value.ratio1to2) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BackgroundResPack redact(@NotNull BackgroundResPack value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return BackgroundResPack.copy$default(value, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BackgroundResPack.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public BackgroundResPack() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ BackgroundResPack copy$default(BackgroundResPack backgroundResPack, String str, String str2, String str3, String str4, String str5, String str6, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = backgroundResPack.ratio16to9;
        }
        if ((i3 & 2) != 0) {
            str2 = backgroundResPack.ratio9to16;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = backgroundResPack.ratio1to1;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            str4 = backgroundResPack.ratio3to4;
        }
        String str9 = str4;
        if ((i3 & 16) != 0) {
            str5 = backgroundResPack.ratio4to3;
        }
        String str10 = str5;
        if ((i3 & 32) != 0) {
            str6 = backgroundResPack.ratio1to2;
        }
        String str11 = str6;
        if ((i3 & 64) != 0) {
            byteString = backgroundResPack.unknownFields();
        }
        return backgroundResPack.copy(str, str7, str8, str9, str10, str11, byteString);
    }

    @NotNull
    public final BackgroundResPack copy(@Nullable String ratio16to9, @Nullable String ratio9to16, @Nullable String ratio1to1, @Nullable String ratio3to4, @Nullable String ratio4to3, @Nullable String ratio1to2, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new BackgroundResPack(ratio16to9, ratio9to16, ratio1to1, ratio3to4, ratio4to3, ratio1to2, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof BackgroundResPack)) {
            return false;
        }
        BackgroundResPack backgroundResPack = (BackgroundResPack) other;
        if (Intrinsics.areEqual(unknownFields(), backgroundResPack.unknownFields()) && Intrinsics.areEqual(this.ratio16to9, backgroundResPack.ratio16to9) && Intrinsics.areEqual(this.ratio9to16, backgroundResPack.ratio9to16) && Intrinsics.areEqual(this.ratio1to1, backgroundResPack.ratio1to1) && Intrinsics.areEqual(this.ratio3to4, backgroundResPack.ratio3to4) && Intrinsics.areEqual(this.ratio4to3, backgroundResPack.ratio4to3) && Intrinsics.areEqual(this.ratio1to2, backgroundResPack.ratio1to2)) {
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
            String str = this.ratio16to9;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str2 = this.ratio9to16;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            String str3 = this.ratio1to1;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str4 = this.ratio3to4;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            String str5 = this.ratio4to3;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            String str6 = this.ratio1to2;
            if (str6 != null) {
                i27 = str6.hashCode();
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
        String str = this.ratio16to9;
        if (str != null) {
            arrayList.add("ratio16to9=" + Internal.sanitize(str));
        }
        String str2 = this.ratio9to16;
        if (str2 != null) {
            arrayList.add("ratio9to16=" + Internal.sanitize(str2));
        }
        String str3 = this.ratio1to1;
        if (str3 != null) {
            arrayList.add("ratio1to1=" + Internal.sanitize(str3));
        }
        String str4 = this.ratio3to4;
        if (str4 != null) {
            arrayList.add("ratio3to4=" + Internal.sanitize(str4));
        }
        String str5 = this.ratio4to3;
        if (str5 != null) {
            arrayList.add("ratio4to3=" + Internal.sanitize(str5));
        }
        String str6 = this.ratio1to2;
        if (str6 != null) {
            arrayList.add("ratio1to2=" + Internal.sanitize(str6));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "BackgroundResPack{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ BackgroundResPack(String str, String str2, String str3, String str4, String str5, String str6, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) == 0 ? str6 : null, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.ratio16to9 = this.ratio16to9;
        aVar.ratio9to16 = this.ratio9to16;
        aVar.ratio1to1 = this.ratio1to1;
        aVar.ratio3to4 = this.ratio3to4;
        aVar.ratio4to3 = this.ratio4to3;
        aVar.ratio1to2 = this.ratio1to2;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundResPack(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.ratio16to9 = str;
        this.ratio9to16 = str2;
        this.ratio1to1 = str3;
        this.ratio3to4 = str4;
        this.ratio4to3 = str5;
        this.ratio1to2 = str6;
    }
}
