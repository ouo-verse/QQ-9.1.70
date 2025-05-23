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
import com.tencent.qqmini.miniapp.widget.CanvasView;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB=\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016JG\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "", CanvasView.ACTION_ROTATE, "scale", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", "anchorPoint", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "<init>", "(FFLcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class Transform extends AndroidMessage<Transform, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Transform> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Transform> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PointF#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final PointF anchorPoint;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF#ADAPTER", tag = 4)
    @JvmField
    @Nullable
    public final SizeF renderSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    @JvmField
    public final float rotate;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    @JvmField
    public final float scale;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", "a", "", UserInfo.SEX_FEMALE, CanvasView.ACTION_ROTATE, "b", "scale", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", "c", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", "anchorPoint", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "d", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<Transform, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float rotate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float scale;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public PointF anchorPoint;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public SizeF renderSize;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Transform build() {
            return new Transform(this.rotate, this.scale, this.anchorPoint, this.renderSize, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<Transform> {
        b(FieldEncoding fieldEncoding, KClass<Transform> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.Transform");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Transform decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            PointF pointF = null;
            float f16 = 0.0f;
            float f17 = 0.0f;
            SizeF sizeF = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    reader.readUnknownField(nextTag);
                                } else {
                                    sizeF = SizeF.ADAPTER.decode(reader);
                                }
                            } else {
                                pointF = PointF.ADAPTER.decode(reader);
                            }
                        } else {
                            f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                        }
                    } else {
                        f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                    }
                } else {
                    return new Transform(f16, f17, pointF, sizeF, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull Transform value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            protoAdapter.encodeWithTag(writer, 1, Float.valueOf(value.rotate));
            protoAdapter.encodeWithTag(writer, 2, Float.valueOf(value.scale));
            PointF.ADAPTER.encodeWithTag(writer, 3, value.anchorPoint);
            SizeF.ADAPTER.encodeWithTag(writer, 4, value.renderSize);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull Transform value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Float> protoAdapter = ProtoAdapter.FLOAT;
            return protoAdapter.encodedSizeWithTag(1, Float.valueOf(value.rotate)) + protoAdapter.encodedSizeWithTag(2, Float.valueOf(value.scale)) + PointF.ADAPTER.encodedSizeWithTag(3, value.anchorPoint) + SizeF.ADAPTER.encodedSizeWithTag(4, value.renderSize) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Transform redact(@NotNull Transform value) {
            PointF pointF;
            SizeF sizeF;
            Intrinsics.checkNotNullParameter(value, "value");
            PointF pointF2 = value.anchorPoint;
            if (pointF2 != null) {
                pointF = PointF.ADAPTER.redact(pointF2);
            } else {
                pointF = null;
            }
            SizeF sizeF2 = value.renderSize;
            if (sizeF2 != null) {
                sizeF = SizeF.ADAPTER.redact(sizeF2);
            } else {
                sizeF = null;
            }
            return Transform.copy$default(value, null, null, pointF, sizeF, ByteString.EMPTY, 3, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Transform.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public Transform() {
        this(0.0f, 0.0f, null, null, null, 31, null);
    }

    public static /* synthetic */ Transform copy$default(Transform transform, Float f16, Float f17, PointF pointF, SizeF sizeF, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = Float.valueOf(transform.rotate);
        }
        if ((i3 & 2) != 0) {
            f17 = Float.valueOf(transform.scale);
        }
        Float f18 = f17;
        if ((i3 & 4) != 0) {
            pointF = transform.anchorPoint;
        }
        PointF pointF2 = pointF;
        if ((i3 & 8) != 0) {
            sizeF = transform.renderSize;
        }
        SizeF sizeF2 = sizeF;
        if ((i3 & 16) != 0) {
            byteString = transform.unknownFields();
        }
        return transform.copy(f16, f18, pointF2, sizeF2, byteString);
    }

    @NotNull
    public final Transform copy(@Nullable Float rotate, @Nullable Float scale, @Nullable PointF anchorPoint, @Nullable SizeF renderSize, @NotNull ByteString unknownFields) {
        float f16;
        float f17;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (rotate != null) {
            f16 = rotate.floatValue();
        } else {
            f16 = 0.0f;
        }
        if (scale != null) {
            f17 = scale.floatValue();
        } else {
            f17 = 0.0f;
        }
        return new Transform(f16, f17, anchorPoint, renderSize, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        if (other == this) {
            return true;
        }
        if (!(other instanceof Transform)) {
            return false;
        }
        Transform transform = (Transform) other;
        if (Intrinsics.areEqual(unknownFields(), transform.unknownFields())) {
            if (this.rotate == transform.rotate) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.scale == transform.scale) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && Intrinsics.areEqual(this.anchorPoint, transform.anchorPoint) && Intrinsics.areEqual(this.renderSize, transform.renderSize)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + Float.floatToIntBits(this.rotate)) * 37) + Float.floatToIntBits(this.scale)) * 37;
            PointF pointF = this.anchorPoint;
            int i17 = 0;
            if (pointF != null) {
                i3 = pointF.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            SizeF sizeF = this.renderSize;
            if (sizeF != null) {
                i17 = sizeF.hashCode();
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
        arrayList.add("rotate=" + this.rotate);
        arrayList.add("scale=" + this.scale);
        PointF pointF = this.anchorPoint;
        if (pointF != null) {
            arrayList.add("anchorPoint=" + pointF);
        }
        SizeF sizeF = this.renderSize;
        if (sizeF != null) {
            arrayList.add("renderSize=" + sizeF);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Transform{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ Transform(float f16, float f17, PointF pointF, SizeF sizeF, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) == 0 ? f17 : 0.0f, (i3 & 4) != 0 ? null : pointF, (i3 & 8) != 0 ? null : sizeF, (i3 & 16) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.rotate = this.rotate;
        aVar.scale = this.scale;
        aVar.anchorPoint = this.anchorPoint;
        aVar.renderSize = this.renderSize;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transform(float f16, float f17, @Nullable PointF pointF, @Nullable SizeF sizeF, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.rotate = f16;
        this.scale = f17;
        this.anchorPoint = pointF;
        this.renderSize = sizeF;
    }
}
