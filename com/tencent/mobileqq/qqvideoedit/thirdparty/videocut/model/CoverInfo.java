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

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B)\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J/\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "path", "", "timeAt", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/Long;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;", "Ljava/lang/String;", "Ljava/lang/Long;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class CoverInfo extends AndroidMessage<CoverInfo, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<CoverInfo> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<CoverInfo> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @JvmField
    @Nullable
    public final Long timeAt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;", "a", "", "Ljava/lang/String;", "path", "", "b", "Ljava/lang/Long;", "timeAt", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<CoverInfo, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String path;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Long timeAt;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoverInfo build() {
            return new CoverInfo(this.path, this.timeAt, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<CoverInfo> {
        b(FieldEncoding fieldEncoding, KClass<CoverInfo> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.CoverInfo");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoverInfo decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            String str = null;
            Long l3 = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            reader.readUnknownField(nextTag);
                        } else {
                            l3 = ProtoAdapter.INT64.decode(reader);
                        }
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                } else {
                    return new CoverInfo(str, l3, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull CoverInfo value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.path);
            ProtoAdapter.INT64.encodeWithTag(writer, 2, value.timeAt);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull CoverInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.path) + ProtoAdapter.INT64.encodedSizeWithTag(2, value.timeAt) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public CoverInfo redact(@NotNull CoverInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return CoverInfo.copy$default(value, null, null, ByteString.EMPTY, 3, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CoverInfo.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public CoverInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CoverInfo copy$default(CoverInfo coverInfo, String str, Long l3, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = coverInfo.path;
        }
        if ((i3 & 2) != 0) {
            l3 = coverInfo.timeAt;
        }
        if ((i3 & 4) != 0) {
            byteString = coverInfo.unknownFields();
        }
        return coverInfo.copy(str, l3, byteString);
    }

    @NotNull
    public final CoverInfo copy(@Nullable String path, @Nullable Long timeAt, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new CoverInfo(path, timeAt, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof CoverInfo)) {
            return false;
        }
        CoverInfo coverInfo = (CoverInfo) other;
        if (Intrinsics.areEqual(unknownFields(), coverInfo.unknownFields()) && Intrinsics.areEqual(this.path, coverInfo.path) && Intrinsics.areEqual(this.timeAt, coverInfo.timeAt)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.path;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            Long l3 = this.timeAt;
            if (l3 != null) {
                i17 = l3.hashCode();
            }
            int i19 = i18 + i17;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        String str = this.path;
        if (str != null) {
            arrayList.add("path=" + Internal.sanitize(str));
        }
        Long l3 = this.timeAt;
        if (l3 != null) {
            arrayList.add("timeAt=" + l3);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "CoverInfo{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ CoverInfo(String str, Long l3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.path = this.path;
        aVar.timeAt = this.timeAt;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverInfo(@Nullable String str, @Nullable Long l3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.path = str;
        this.timeAt = l3;
    }
}
