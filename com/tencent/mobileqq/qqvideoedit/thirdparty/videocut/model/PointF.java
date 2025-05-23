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
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B%\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J/\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0014\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "", HippyTKDListViewAdapter.X, "y", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", UserInfo.SEX_FEMALE, "<init>", "(FFLokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PointF extends AndroidMessage<PointF, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<PointF> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PointF> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    @JvmField
    public final float x;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    @JvmField
    public final float y;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", "a", "", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "b", "y", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<PointF, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float x;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float y;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF build() {
            return new PointF(this.x, this.y, buildUnknownFields());
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<PointF> {
        b(FieldEncoding fieldEncoding, KClass<PointF> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.PointF");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            float f16 = 0.0f;
            float f17 = 0.0f;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            reader.readUnknownField(nextTag);
                        } else {
                            f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                        }
                    } else {
                        f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                    }
                } else {
                    return new PointF(f16, f17, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull PointF value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            protoAdapter.encodeWithTag(writer, 1, Float.valueOf(value.x));
            protoAdapter.encodeWithTag(writer, 2, Float.valueOf(value.y));
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull PointF value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            return protoAdapter.encodedSizeWithTag(1, Float.valueOf(value.x)) + protoAdapter.encodedSizeWithTag(2, Float.valueOf(value.y)) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public PointF redact(@NotNull PointF value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return PointF.copy$default(value, null, null, ByteString.EMPTY, 3, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PointF.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public PointF() {
        this(0.0f, 0.0f, null, 7, null);
    }

    public static /* synthetic */ PointF copy$default(PointF pointF, Float f16, Float f17, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = Float.valueOf(pointF.x);
        }
        if ((i3 & 2) != 0) {
            f17 = Float.valueOf(pointF.y);
        }
        if ((i3 & 4) != 0) {
            byteString = pointF.unknownFields();
        }
        return pointF.copy(f16, f17, byteString);
    }

    @NotNull
    public final PointF copy(@Nullable Float x16, @Nullable Float y16, @NotNull ByteString unknownFields) {
        float f16;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        float f17 = 0.0f;
        if (x16 != null) {
            f16 = x16.floatValue();
        } else {
            f16 = 0.0f;
        }
        if (y16 != null) {
            f17 = y16.floatValue();
        }
        return new PointF(f16, f17, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        if (other == this) {
            return true;
        }
        if (!(other instanceof PointF)) {
            return false;
        }
        PointF pointF = (PointF) other;
        if (Intrinsics.areEqual(unknownFields(), pointF.unknownFields())) {
            if (this.x == pointF.x) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.y == pointF.y) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + Float.floatToIntBits(this.x)) * 37) + Float.floatToIntBits(this.y);
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
        arrayList.add("x=" + this.x);
        arrayList.add("y=" + this.y);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "PointF{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ PointF(float f16, float f17, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.x = this.x;
        aVar.y = this.y;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointF(float f16, float f17, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.x = f16;
        this.y = f17;
    }
}
