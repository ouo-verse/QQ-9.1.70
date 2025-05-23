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
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ8\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Quat;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Quat$Builder;", HippyTKDListViewAdapter.X, "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "unknownFields", "Lokio/ByteString;", "(FFFFLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class Quat extends AndroidMessage<Quat, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Quat> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Quat> CREATOR;
    public static final float DEFAULT_W = 0.0f;
    public static final float DEFAULT_X = 0.0f;
    public static final float DEFAULT_Y = 0.0f;
    public static final float DEFAULT_Z = 0.0f;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 4)
    @JvmField
    public final float w;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 1)
    @JvmField
    public final float x;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 2)
    @JvmField
    public final float y;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REQUIRED, tag = 3)
    @JvmField
    public final float z;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Quat$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Quat;", "()V", "w", "", "Ljava/lang/Float;", HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<Quat, Builder> {

        @JvmField
        @Nullable
        public Float w;

        @JvmField
        @Nullable
        public Float x;

        @JvmField
        @Nullable
        public Float y;

        @JvmField
        @Nullable
        public Float z;

        @NotNull
        public final Builder w(float w3) {
            this.w = Float.valueOf(w3);
            return this;
        }

        @NotNull
        public final Builder x(float x16) {
            this.x = Float.valueOf(x16);
            return this;
        }

        @NotNull
        public final Builder y(float y16) {
            this.y = Float.valueOf(y16);
            return this;
        }

        @NotNull
        public final Builder z(float z16) {
            this.z = Float.valueOf(z16);
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public Quat build() {
            Float f16 = this.x;
            if (f16 != null) {
                float floatValue = f16.floatValue();
                Float f17 = this.y;
                if (f17 != null) {
                    float floatValue2 = f17.floatValue();
                    Float f18 = this.z;
                    if (f18 != null) {
                        float floatValue3 = f18.floatValue();
                        Float f19 = this.w;
                        if (f19 != null) {
                            return new Quat(floatValue, floatValue2, floatValue3, f19.floatValue(), buildUnknownFields());
                        }
                        throw Internal.missingRequiredFields(f19, "w");
                    }
                    throw Internal.missingRequiredFields(f18, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW);
                }
                throw Internal.missingRequiredFields(f17, "y");
            }
            throw Internal.missingRequiredFields(f16, HippyTKDListViewAdapter.X);
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Quat.class);
        final String str = "type.googleapis.com/publisher.Quat";
        ProtoAdapter<Quat> protoAdapter = new ProtoAdapter<Quat>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.Quat$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Quat decode(@NotNull ProtoReader reader) {
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
                                return new Quat(floatValue, floatValue2, floatValue3, f19.floatValue(), endMessageAndGetUnknownFields);
                            }
                            throw Internal.missingRequiredFields(f19, "w");
                        }
                        throw Internal.missingRequiredFields(f18, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW);
                    }
                    throw Internal.missingRequiredFields(f17, "y");
                }
                throw Internal.missingRequiredFields(f16, HippyTKDListViewAdapter.X);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Quat value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
                protoAdapter2.encodeWithTag(writer, 1, Float.valueOf(value.x));
                protoAdapter2.encodeWithTag(writer, 2, Float.valueOf(value.y));
                protoAdapter2.encodeWithTag(writer, 3, Float.valueOf(value.z));
                protoAdapter2.encodeWithTag(writer, 4, Float.valueOf(value.w));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Quat value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
                return protoAdapter2.encodedSizeWithTag(1, Float.valueOf(value.x)) + protoAdapter2.encodedSizeWithTag(2, Float.valueOf(value.y)) + protoAdapter2.encodedSizeWithTag(3, Float.valueOf(value.z)) + protoAdapter2.encodedSizeWithTag(4, Float.valueOf(value.w)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Quat redact(@NotNull Quat value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return Quat.copy$default(value, 0.0f, 0.0f, 0.0f, 0.0f, ByteString.EMPTY, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public /* synthetic */ Quat(float f16, float f17, float f18, float f19, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, f17, f18, f19, (i3 & 16) != 0 ? ByteString.EMPTY : byteString);
    }

    public static /* synthetic */ Quat copy$default(Quat quat, float f16, float f17, float f18, float f19, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = quat.x;
        }
        if ((i3 & 2) != 0) {
            f17 = quat.y;
        }
        float f26 = f17;
        if ((i3 & 4) != 0) {
            f18 = quat.z;
        }
        float f27 = f18;
        if ((i3 & 8) != 0) {
            f19 = quat.w;
        }
        float f28 = f19;
        if ((i3 & 16) != 0) {
            byteString = quat.unknownFields();
        }
        return quat.copy(f16, f26, f27, f28, byteString);
    }

    @NotNull
    public final Quat copy(float x16, float y16, float z16, float w3, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new Quat(x16, y16, z16, w3, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Quat)) {
            return false;
        }
        Quat quat = (Quat) other;
        if (Intrinsics.areEqual(unknownFields(), quat.unknownFields()) && this.x == quat.x && this.y == quat.y && this.z == quat.z && this.w == quat.w) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + Float.floatToIntBits(this.x)) * 37) + Float.floatToIntBits(this.y)) * 37) + Float.floatToIntBits(this.z)) * 37) + Float.floatToIntBits(this.w);
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
        arrayList.add("z=" + this.z);
        arrayList.add("w=" + this.w);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Quat{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Quat(float f16, float f17, float f18, float f19, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.x = f16;
        this.y = f17;
        this.z = f18;
        this.w = f19;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.x = Float.valueOf(this.x);
        builder.y = Float.valueOf(this.y);
        builder.z = Float.valueOf(this.z);
        builder.w = Float.valueOf(this.w);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
