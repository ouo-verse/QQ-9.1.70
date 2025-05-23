package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B9\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016JG\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0014\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "left", "top", "right", "bottom", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;", "I", "<init>", "(IIIILokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class Rect extends AndroidMessage<Rect, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Rect> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Rect> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @JvmField
    public final int bottom;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    public final int left;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    public final int right;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    public final int top;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0016\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;", "a", "", "I", "left", "b", "top", "c", "right", "d", "bottom", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<Rect, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public int left;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public int top;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public int right;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public int bottom;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect build() {
            return new Rect(this.left, this.top, this.right, this.bottom, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<Rect> {
        b(FieldEncoding fieldEncoding, KClass<Rect> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.Rect");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    reader.readUnknownField(nextTag);
                                } else {
                                    i18 = ProtoAdapter.INT32.decode(reader).intValue();
                                }
                            } else {
                                i17 = ProtoAdapter.INT32.decode(reader).intValue();
                            }
                        } else {
                            i16 = ProtoAdapter.INT32.decode(reader).intValue();
                        }
                    } else {
                        i3 = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                } else {
                    return new Rect(i3, i16, i17, i18, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull Rect value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
            protoAdapter.encodeWithTag(writer, 1, Integer.valueOf(value.left));
            protoAdapter.encodeWithTag(writer, 2, Integer.valueOf(value.top));
            protoAdapter.encodeWithTag(writer, 3, Integer.valueOf(value.right));
            protoAdapter.encodeWithTag(writer, 4, Integer.valueOf(value.bottom));
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull Rect value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
            return protoAdapter.encodedSizeWithTag(1, Integer.valueOf(value.left)) + protoAdapter.encodedSizeWithTag(2, Integer.valueOf(value.top)) + protoAdapter.encodedSizeWithTag(3, Integer.valueOf(value.right)) + protoAdapter.encodedSizeWithTag(4, Integer.valueOf(value.bottom)) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Rect redact(@NotNull Rect value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Rect.copy$default(value, null, null, null, null, ByteString.EMPTY, 15, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Rect.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public Rect() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public static /* synthetic */ Rect copy$default(Rect rect, Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = Integer.valueOf(rect.left);
        }
        if ((i3 & 2) != 0) {
            num2 = Integer.valueOf(rect.top);
        }
        Integer num5 = num2;
        if ((i3 & 4) != 0) {
            num3 = Integer.valueOf(rect.right);
        }
        Integer num6 = num3;
        if ((i3 & 8) != 0) {
            num4 = Integer.valueOf(rect.bottom);
        }
        Integer num7 = num4;
        if ((i3 & 16) != 0) {
            byteString = rect.unknownFields();
        }
        return rect.copy(num, num5, num6, num7, byteString);
    }

    @NotNull
    public final Rect copy(@Nullable Integer left, @Nullable Integer top, @Nullable Integer right, @Nullable Integer bottom, @NotNull ByteString unknownFields) {
        int i3;
        int i16;
        int i17;
        int i18;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (left != null) {
            i3 = left.intValue();
        } else {
            i3 = 0;
        }
        if (top != null) {
            i16 = top.intValue();
        } else {
            i16 = 0;
        }
        if (right != null) {
            i17 = right.intValue();
        } else {
            i17 = 0;
        }
        if (bottom != null) {
            i18 = bottom.intValue();
        } else {
            i18 = 0;
        }
        return new Rect(i3, i16, i17, i18, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) other;
        if (Intrinsics.areEqual(unknownFields(), rect.unknownFields()) && this.left == rect.left && this.top == rect.top && this.right == rect.right && this.bottom == rect.bottom) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.left) * 37) + this.top) * 37) + this.right) * 37) + this.bottom;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        arrayList.add("left=" + this.left);
        arrayList.add("top=" + this.top);
        arrayList.add("right=" + this.right);
        arrayList.add("bottom=" + this.bottom);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Rect{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ Rect(int i3, int i16, int i17, int i18, ByteString byteString, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) == 0 ? i18 : 0, (i19 & 16) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.left = this.left;
        aVar.top = this.top;
        aVar.right = this.right;
        aVar.bottom = this.bottom;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rect(int i3, int i16, int i17, int i18, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.left = i3;
        this.top = i16;
        this.right = i17;
        this.bottom = i18;
    }
}
