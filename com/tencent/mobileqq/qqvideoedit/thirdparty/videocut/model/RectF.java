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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB9\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016JG\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0014\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "", "left", "top", "right", "bottom", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", UserInfo.SEX_FEMALE, "<init>", "(FFFFLokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RectF extends AndroidMessage<RectF, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<RectF> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<RectF> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    @JvmField
    public final float bottom;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    @JvmField
    public final float left;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    @JvmField
    public final float right;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    @JvmField
    public final float top;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0016\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "a", "", UserInfo.SEX_FEMALE, "left", "b", "top", "c", "right", "d", "bottom", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<RectF, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float left;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float top;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float right;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float bottom;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RectF build() {
            return new RectF(this.left, this.top, this.right, this.bottom, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<RectF> {
        b(FieldEncoding fieldEncoding, KClass<RectF> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.RectF");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RectF decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            float f16 = 0.0f;
            float f17 = 0.0f;
            float f18 = 0.0f;
            float f19 = 0.0f;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    reader.readUnknownField(nextTag);
                                } else {
                                    f19 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                }
                            } else {
                                f18 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            }
                        } else {
                            f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                        }
                    } else {
                        f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                    }
                } else {
                    return new RectF(f16, f17, f18, f19, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull RectF value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            protoAdapter.encodeWithTag(writer, 1, Float.valueOf(value.left));
            protoAdapter.encodeWithTag(writer, 2, Float.valueOf(value.top));
            protoAdapter.encodeWithTag(writer, 3, Float.valueOf(value.right));
            protoAdapter.encodeWithTag(writer, 4, Float.valueOf(value.bottom));
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull RectF value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            return protoAdapter.encodedSizeWithTag(1, Float.valueOf(value.left)) + protoAdapter.encodedSizeWithTag(2, Float.valueOf(value.top)) + protoAdapter.encodedSizeWithTag(3, Float.valueOf(value.right)) + protoAdapter.encodedSizeWithTag(4, Float.valueOf(value.bottom)) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RectF redact(@NotNull RectF value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return RectF.copy$default(value, null, null, null, null, ByteString.EMPTY, 15, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RectF.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public RectF() {
        this(0.0f, 0.0f, 0.0f, 0.0f, null, 31, null);
    }

    public static /* synthetic */ RectF copy$default(RectF rectF, Float f16, Float f17, Float f18, Float f19, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = Float.valueOf(rectF.left);
        }
        if ((i3 & 2) != 0) {
            f17 = Float.valueOf(rectF.top);
        }
        Float f26 = f17;
        if ((i3 & 4) != 0) {
            f18 = Float.valueOf(rectF.right);
        }
        Float f27 = f18;
        if ((i3 & 8) != 0) {
            f19 = Float.valueOf(rectF.bottom);
        }
        Float f28 = f19;
        if ((i3 & 16) != 0) {
            byteString = rectF.unknownFields();
        }
        return rectF.copy(f16, f26, f27, f28, byteString);
    }

    @NotNull
    public final RectF copy(@Nullable Float left, @Nullable Float top, @Nullable Float right, @Nullable Float bottom, @NotNull ByteString unknownFields) {
        float f16;
        float f17;
        float f18;
        float f19;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (left != null) {
            f16 = left.floatValue();
        } else {
            f16 = 0.0f;
        }
        if (top != null) {
            f17 = top.floatValue();
        } else {
            f17 = 0.0f;
        }
        if (right != null) {
            f18 = right.floatValue();
        } else {
            f18 = 0.0f;
        }
        if (bottom != null) {
            f19 = bottom.floatValue();
        } else {
            f19 = 0.0f;
        }
        return new RectF(f16, f17, f18, f19, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (other == this) {
            return true;
        }
        if (!(other instanceof RectF)) {
            return false;
        }
        RectF rectF = (RectF) other;
        if (Intrinsics.areEqual(unknownFields(), rectF.unknownFields())) {
            if (this.left == rectF.left) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.top == rectF.top) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (this.right == rectF.right) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        if (this.bottom == rectF.bottom) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + Float.floatToIntBits(this.left)) * 37) + Float.floatToIntBits(this.top)) * 37) + Float.floatToIntBits(this.right)) * 37) + Float.floatToIntBits(this.bottom);
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
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "RectF{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ RectF(float f16, float f17, float f18, float f19, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) == 0 ? f19 : 0.0f, (i3 & 16) != 0 ? ByteString.EMPTY : byteString);
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
    public RectF(float f16, float f17, float f18, float f19, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.left = f16;
        this.top = f17;
        this.right = f18;
        this.bottom = f19;
    }
}
