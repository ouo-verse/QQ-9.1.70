package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJE\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/videocut/model/Transform;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/Transform$Builder;", CanvasView.ACTION_ROTATE, "", "scale", "anchorPoint", "Lcom/tencent/videocut/model/PointF;", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "unknownFields", "Lokio/ByteString;", "(FFLcom/tencent/videocut/model/PointF;Lcom/tencent/videocut/model/SizeF;Lokio/ByteString;)V", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/tencent/videocut/model/PointF;Lcom/tencent/videocut/model/SizeF;Lokio/ByteString;)Lcom/tencent/videocut/model/Transform;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class Transform extends AndroidMessage<Transform, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Transform> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Transform> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.tencent.videocut.model.PointF#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final PointF anchorPoint;

    @WireField(adapter = "com.tencent.videocut.model.SizeF#ADAPTER", tag = 4)
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
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/videocut/model/Transform$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/Transform;", "()V", "anchorPoint", "Lcom/tencent/videocut/model/PointF;", "renderSize", "Lcom/tencent/videocut/model/SizeF;", CanvasView.ACTION_ROTATE, "", "scale", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/Transform$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<Transform, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public PointF anchorPoint;

        @JvmField
        @Nullable
        public SizeF renderSize;

        @JvmField
        public float rotate;

        @JvmField
        public float scale;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder anchorPoint(@Nullable PointF anchorPoint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) anchorPoint);
            }
            this.anchorPoint = anchorPoint;
            return this;
        }

        @NotNull
        public final Builder renderSize(@Nullable SizeF renderSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) renderSize);
            }
            this.renderSize = renderSize;
            return this;
        }

        @NotNull
        public final Builder rotate(@Nullable Float rotate) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rotate);
            }
            if (rotate != null) {
                f16 = rotate.floatValue();
            } else {
                f16 = 0.0f;
            }
            this.rotate = f16;
            return this;
        }

        @NotNull
        public final Builder scale(@Nullable Float scale) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) scale);
            }
            if (scale != null) {
                f16 = scale.floatValue();
            } else {
                f16 = 0.0f;
            }
            this.scale = f16;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public Transform build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? new Transform(this.rotate, this.scale, this.anchorPoint, this.renderSize, buildUnknownFields()) : (Transform) iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/Transform$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/Transform;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59356);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Transform.class);
        ProtoAdapter<Transform> protoAdapter = new ProtoAdapter<Transform>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.Transform$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.Transform");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Transform decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Transform) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                PointF pointF = null;
                float f16 = 0.0f;
                float f17 = 0.0f;
                SizeF sizeF = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new Transform(f16, f17, pointF, sizeF, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 1) {
                        f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                    } else if (nextTag == 2) {
                        f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                    } else if (nextTag == 3) {
                        pointF = PointF.ADAPTER.decode(reader);
                    } else if (nextTag != 4) {
                        reader.readUnknownField(nextTag);
                    } else {
                        sizeF = SizeF.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Transform value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
                protoAdapter2.encodeWithTag(writer, 1, Float.valueOf(value.rotate));
                protoAdapter2.encodeWithTag(writer, 2, Float.valueOf(value.scale));
                PointF.ADAPTER.encodeWithTag(writer, 3, value.anchorPoint);
                SizeF.ADAPTER.encodeWithTag(writer, 4, value.renderSize);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Transform value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
                return protoAdapter2.encodedSizeWithTag(1, Float.valueOf(value.rotate)) + protoAdapter2.encodedSizeWithTag(2, Float.valueOf(value.scale)) + PointF.ADAPTER.encodedSizeWithTag(3, value.anchorPoint) + SizeF.ADAPTER.encodedSizeWithTag(4, value.renderSize) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Transform redact(@NotNull Transform value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (Transform) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                PointF pointF = value.anchorPoint;
                PointF redact = pointF != null ? PointF.ADAPTER.redact(pointF) : null;
                SizeF sizeF = value.renderSize;
                return Transform.copy$default(value, null, null, redact, sizeF != null ? SizeF.ADAPTER.redact(sizeF) : null, ByteString.EMPTY, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public Transform() {
        this(0.0f, 0.0f, null, null, null, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Transform) iPatchRedirector.redirect((short) 7, this, rotate, scale, anchorPoint, renderSize, unknownFields);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
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
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? null : pointF, (i3 & 8) != 0 ? null : sizeF, (i3 & 16) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), pointF, sizeF, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.rotate = this.rotate;
        builder.scale = this.scale;
        builder.anchorPoint = this.anchorPoint;
        builder.renderSize = this.renderSize;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transform(float f16, float f17, @Nullable PointF pointF, @Nullable SizeF sizeF, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), pointF, sizeF, unknownFields);
            return;
        }
        this.rotate = f16;
        this.scale = f17;
        this.anchorPoint = pointF;
        this.renderSize = sizeF;
    }
}
