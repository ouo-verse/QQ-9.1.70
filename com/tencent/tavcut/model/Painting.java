package com.tencent.tavcut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Size;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dBW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J]\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/tavcut/model/Painting;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/Painting$Builder;", "renderSize", "Lcom/tencent/tavcut/composition/model/component/Size;", "screenTransform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "backgroundFillMode", "Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;", "pagPath", "", "backgroundColor", "fillScale", "", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/tavcut/composition/model/component/Size;Lcom/tencent/tavcut/composition/model/component/ScreenTransform;Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lokio/ByteString;)V", "Ljava/lang/Float;", "copy", "(Lcom/tencent/tavcut/composition/model/component/Size;Lcom/tencent/tavcut/composition/model/component/ScreenTransform;Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/tavcut/model/Painting;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class Painting extends AndroidMessage<Painting, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Painting> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Painting> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String backgroundColor;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.BackgroundFillMode#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final BackgroundFillMode backgroundFillMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    @Nullable
    public final Float fillScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String pagPath;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Size#ADAPTER", tag = 1)
    @JvmField
    @Nullable
    public final Size renderSize;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.ScreenTransform#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final ScreenTransform screenTransform;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/model/Painting$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/Painting;", "()V", "backgroundColor", "", "backgroundFillMode", "Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;", "fillScale", "", "Ljava/lang/Float;", "pagPath", "renderSize", "Lcom/tencent/tavcut/composition/model/component/Size;", "screenTransform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "build", "(Ljava/lang/Float;)Lcom/tencent/tavcut/model/Painting$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<Painting, Builder> {

        @JvmField
        @Nullable
        public String backgroundColor;

        @JvmField
        @Nullable
        public BackgroundFillMode backgroundFillMode;

        @JvmField
        @Nullable
        public Float fillScale;

        @JvmField
        @Nullable
        public String pagPath;

        @JvmField
        @Nullable
        public Size renderSize;

        @JvmField
        @Nullable
        public ScreenTransform screenTransform;

        @NotNull
        public final Builder backgroundColor(@Nullable String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        @NotNull
        public final Builder backgroundFillMode(@Nullable BackgroundFillMode backgroundFillMode) {
            this.backgroundFillMode = backgroundFillMode;
            return this;
        }

        @NotNull
        public final Builder fillScale(@Nullable Float fillScale) {
            this.fillScale = fillScale;
            return this;
        }

        @NotNull
        public final Builder pagPath(@Nullable String pagPath) {
            this.pagPath = pagPath;
            return this;
        }

        @NotNull
        public final Builder renderSize(@Nullable Size renderSize) {
            this.renderSize = renderSize;
            return this;
        }

        @NotNull
        public final Builder screenTransform(@Nullable ScreenTransform screenTransform) {
            this.screenTransform = screenTransform;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public Painting build() {
            return new Painting(this.renderSize, this.screenTransform, this.backgroundFillMode, this.pagPath, this.backgroundColor, this.fillScale, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Painting.class);
        final String str = "type.googleapis.com/publisher.Painting";
        ProtoAdapter<Painting> protoAdapter = new ProtoAdapter<Painting>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.Painting$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Painting decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Size size = null;
                ScreenTransform screenTransform = null;
                BackgroundFillMode backgroundFillMode = null;
                String str2 = null;
                String str3 = null;
                Float f16 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new Painting(size, screenTransform, backgroundFillMode, str2, str3, f16, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            size = Size.ADAPTER.decode(reader);
                            break;
                        case 2:
                            screenTransform = ScreenTransform.ADAPTER.decode(reader);
                            break;
                        case 3:
                            try {
                                backgroundFillMode = BackgroundFillMode.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Painting value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                Size.ADAPTER.encodeWithTag(writer, 1, value.renderSize);
                ScreenTransform.ADAPTER.encodeWithTag(writer, 2, value.screenTransform);
                BackgroundFillMode.ADAPTER.encodeWithTag(writer, 3, value.backgroundFillMode);
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 4, value.pagPath);
                protoAdapter2.encodeWithTag(writer, 5, value.backgroundColor);
                ProtoAdapter.FLOAT.encodeWithTag(writer, 6, value.fillScale);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Painting value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                int encodedSizeWithTag = Size.ADAPTER.encodedSizeWithTag(1, value.renderSize) + ScreenTransform.ADAPTER.encodedSizeWithTag(2, value.screenTransform) + BackgroundFillMode.ADAPTER.encodedSizeWithTag(3, value.backgroundFillMode);
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(4, value.pagPath) + protoAdapter2.encodedSizeWithTag(5, value.backgroundColor) + ProtoAdapter.FLOAT.encodedSizeWithTag(6, value.fillScale) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Painting redact(@NotNull Painting value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                Size size = value.renderSize;
                Size redact = size != null ? Size.ADAPTER.redact(size) : null;
                ScreenTransform screenTransform = value.screenTransform;
                return Painting.copy$default(value, redact, screenTransform != null ? ScreenTransform.ADAPTER.redact(screenTransform) : null, null, null, null, null, ByteString.EMPTY, 60, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public Painting() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Painting copy$default(Painting painting, Size size, ScreenTransform screenTransform, BackgroundFillMode backgroundFillMode, String str, String str2, Float f16, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            size = painting.renderSize;
        }
        if ((i3 & 2) != 0) {
            screenTransform = painting.screenTransform;
        }
        ScreenTransform screenTransform2 = screenTransform;
        if ((i3 & 4) != 0) {
            backgroundFillMode = painting.backgroundFillMode;
        }
        BackgroundFillMode backgroundFillMode2 = backgroundFillMode;
        if ((i3 & 8) != 0) {
            str = painting.pagPath;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            str2 = painting.backgroundColor;
        }
        String str4 = str2;
        if ((i3 & 32) != 0) {
            f16 = painting.fillScale;
        }
        Float f17 = f16;
        if ((i3 & 64) != 0) {
            byteString = painting.unknownFields();
        }
        return painting.copy(size, screenTransform2, backgroundFillMode2, str3, str4, f17, byteString);
    }

    @NotNull
    public final Painting copy(@Nullable Size renderSize, @Nullable ScreenTransform screenTransform, @Nullable BackgroundFillMode backgroundFillMode, @Nullable String pagPath, @Nullable String backgroundColor, @Nullable Float fillScale, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new Painting(renderSize, screenTransform, backgroundFillMode, pagPath, backgroundColor, fillScale, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Painting)) {
            return false;
        }
        Painting painting = (Painting) other;
        if (Intrinsics.areEqual(unknownFields(), painting.unknownFields()) && Intrinsics.areEqual(this.renderSize, painting.renderSize) && Intrinsics.areEqual(this.screenTransform, painting.screenTransform) && this.backgroundFillMode == painting.backgroundFillMode && Intrinsics.areEqual(this.pagPath, painting.pagPath) && Intrinsics.areEqual(this.backgroundColor, painting.backgroundColor) && Intrinsics.areEqual(this.fillScale, painting.fillScale)) {
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
            Size size = this.renderSize;
            int i27 = 0;
            if (size != null) {
                i3 = size.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            ScreenTransform screenTransform = this.screenTransform;
            if (screenTransform != null) {
                i16 = screenTransform.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            BackgroundFillMode backgroundFillMode = this.backgroundFillMode;
            if (backgroundFillMode != null) {
                i17 = backgroundFillMode.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str = this.pagPath;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            String str2 = this.backgroundColor;
            if (str2 != null) {
                i19 = str2.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            Float f16 = this.fillScale;
            if (f16 != null) {
                i27 = f16.hashCode();
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
        if (this.renderSize != null) {
            arrayList.add("renderSize=" + this.renderSize);
        }
        if (this.screenTransform != null) {
            arrayList.add("screenTransform=" + this.screenTransform);
        }
        if (this.backgroundFillMode != null) {
            arrayList.add("backgroundFillMode=" + this.backgroundFillMode);
        }
        if (this.pagPath != null) {
            arrayList.add("pagPath=" + Internal.sanitize(this.pagPath));
        }
        if (this.backgroundColor != null) {
            arrayList.add("backgroundColor=" + Internal.sanitize(this.backgroundColor));
        }
        if (this.fillScale != null) {
            arrayList.add("fillScale=" + this.fillScale);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Painting{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ Painting(Size size, ScreenTransform screenTransform, BackgroundFillMode backgroundFillMode, String str, String str2, Float f16, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : size, (i3 & 2) != 0 ? null : screenTransform, (i3 & 4) != 0 ? null : backgroundFillMode, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) == 0 ? f16 : null, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.renderSize = this.renderSize;
        builder.screenTransform = this.screenTransform;
        builder.backgroundFillMode = this.backgroundFillMode;
        builder.pagPath = this.pagPath;
        builder.backgroundColor = this.backgroundColor;
        builder.fillScale = this.fillScale;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Painting(@Nullable Size size, @Nullable ScreenTransform screenTransform, @Nullable BackgroundFillMode backgroundFillMode, @Nullable String str, @Nullable String str2, @Nullable Float f16, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.renderSize = size;
        this.screenTransform = screenTransform;
        this.backgroundFillMode = backgroundFillMode;
        this.pagPath = str;
        this.backgroundColor = str2;
        this.fillScale = f16;
    }
}
