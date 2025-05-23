package com.tencent.tavcut.composition.model.component;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ8\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Rect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Rect$Builder;", "left", "", "top", "right", "bottom", "unknownFields", "Lokio/ByteString;", "(FFFFLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class Rect extends AndroidMessage<Rect, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Rect> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Rect> CREATOR;
    public static final float DEFAULT_BOTTOM = 0.0f;
    public static final float DEFAULT_LEFT = 0.0f;
    public static final float DEFAULT_RIGHT = 0.0f;
    public static final float DEFAULT_TOP = 0.0f;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 4)
    @JvmField
    public final float bottom;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 1)
    @JvmField
    public final float left;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 3)
    @JvmField
    public final float right;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 2)
    @JvmField
    public final float top;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Rect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Rect;", "()V", "bottom", "", "Ljava/lang/Float;", "left", "right", "top", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<Rect, Builder> {

        @JvmField
        @Nullable
        public Float bottom;

        @JvmField
        @Nullable
        public Float left;

        @JvmField
        @Nullable
        public Float right;

        @JvmField
        @Nullable
        public Float top;

        @NotNull
        public final Builder bottom(float bottom) {
            this.bottom = Float.valueOf(bottom);
            return this;
        }

        @NotNull
        public final Builder left(float left) {
            this.left = Float.valueOf(left);
            return this;
        }

        @NotNull
        public final Builder right(float right) {
            this.right = Float.valueOf(right);
            return this;
        }

        @NotNull
        public final Builder top(float top) {
            this.top = Float.valueOf(top);
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public Rect build() {
            Float f16 = this.left;
            if (f16 != null) {
                float floatValue = f16.floatValue();
                Float f17 = this.top;
                if (f17 != null) {
                    float floatValue2 = f17.floatValue();
                    Float f18 = this.right;
                    if (f18 != null) {
                        float floatValue3 = f18.floatValue();
                        Float f19 = this.bottom;
                        if (f19 != null) {
                            return new Rect(floatValue, floatValue2, floatValue3, f19.floatValue(), buildUnknownFields());
                        }
                        throw Internal.missingRequiredFields(f19, "bottom");
                    }
                    throw Internal.missingRequiredFields(f18, "right");
                }
                throw Internal.missingRequiredFields(f17, "top");
            }
            throw Internal.missingRequiredFields(f16, "left");
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Rect.class);
        final String str = "type.googleapis.com/publisher.Rect";
        ProtoAdapter<Rect> protoAdapter = new ProtoAdapter<Rect>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.Rect$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Rect decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Float f16 = null;
                Float f17 = null;
                Float f18 = null;
                Float f19 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        break;
                    }
                    if (nextTag == 1) {
                        f16 = ProtoAdapter.FLOAT.decode(reader);
                    } else if (nextTag == 2) {
                        f17 = ProtoAdapter.FLOAT.decode(reader);
                    } else if (nextTag == 3) {
                        f18 = ProtoAdapter.FLOAT.decode(reader);
                    } else if (nextTag != 4) {
                        reader.readUnknownField(nextTag);
                    } else {
                        f19 = ProtoAdapter.FLOAT.decode(reader);
                    }
                }
                ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                if (f16 != null) {
                    float floatValue = f16.floatValue();
                    if (f17 != null) {
                        float floatValue2 = f17.floatValue();
                        if (f18 != null) {
                            float floatValue3 = f18.floatValue();
                            if (f19 != null) {
                                return new Rect(floatValue, floatValue2, floatValue3, f19.floatValue(), endMessageAndGetUnknownFields);
                            }
                            throw Internal.missingRequiredFields(f19, "bottom");
                        }
                        throw Internal.missingRequiredFields(f18, "right");
                    }
                    throw Internal.missingRequiredFields(f17, "top");
                }
                throw Internal.missingRequiredFields(f16, "left");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Rect value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
                protoAdapter2.encodeWithTag(writer, 1, Float.valueOf(value.left));
                protoAdapter2.encodeWithTag(writer, 2, Float.valueOf(value.top));
                protoAdapter2.encodeWithTag(writer, 3, Float.valueOf(value.right));
                protoAdapter2.encodeWithTag(writer, 4, Float.valueOf(value.bottom));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Rect value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
                return protoAdapter2.encodedSizeWithTag(1, Float.valueOf(value.left)) + protoAdapter2.encodedSizeWithTag(2, Float.valueOf(value.top)) + protoAdapter2.encodedSizeWithTag(3, Float.valueOf(value.right)) + protoAdapter2.encodedSizeWithTag(4, Float.valueOf(value.bottom)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Rect redact(@NotNull Rect value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return Rect.copy$default(value, 0.0f, 0.0f, 0.0f, 0.0f, ByteString.EMPTY, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public /* synthetic */ Rect(float f16, float f17, float f18, float f19, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, f17, f18, f19, (i3 & 16) != 0 ? ByteString.EMPTY : byteString);
    }

    public static /* synthetic */ Rect copy$default(Rect rect, float f16, float f17, float f18, float f19, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = rect.left;
        }
        if ((i3 & 2) != 0) {
            f17 = rect.top;
        }
        float f26 = f17;
        if ((i3 & 4) != 0) {
            f18 = rect.right;
        }
        float f27 = f18;
        if ((i3 & 8) != 0) {
            f19 = rect.bottom;
        }
        float f28 = f19;
        if ((i3 & 16) != 0) {
            byteString = rect.unknownFields();
        }
        return rect.copy(f16, f26, f27, f28, byteString);
    }

    @NotNull
    public final Rect copy(float left, float top, float right, float bottom, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new Rect(left, top, right, bottom, unknownFields);
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
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Rect{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rect(float f16, float f17, float f18, float f19, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.left = f16;
        this.top = f17;
        this.right = f18;
        this.bottom = f19;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.left = Float.valueOf(this.left);
        builder.top = Float.valueOf(this.top);
        builder.right = Float.valueOf(this.right);
        builder.bottom = Float.valueOf(this.bottom);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
