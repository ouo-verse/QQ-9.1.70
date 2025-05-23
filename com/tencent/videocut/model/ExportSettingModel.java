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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/videocut/model/ExportSettingModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/ExportSettingModel$Builder;", "resolutionLevel", "", "fpsValue", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/ExportSettingModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ExportSettingModel extends AndroidMessage<ExportSettingModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<ExportSettingModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ExportSettingModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer fpsValue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer resolutionLevel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/model/ExportSettingModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/ExportSettingModel;", "()V", "fpsValue", "", "Ljava/lang/Integer;", "resolutionLevel", "build", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/ExportSettingModel$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<ExportSettingModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public Integer fpsValue;

        @JvmField
        @Nullable
        public Integer resolutionLevel;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder fpsValue(@Nullable Integer fpsValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) fpsValue);
            }
            this.fpsValue = fpsValue;
            return this;
        }

        @NotNull
        public final Builder resolutionLevel(@Nullable Integer resolutionLevel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) resolutionLevel);
            }
            this.resolutionLevel = resolutionLevel;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public ExportSettingModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new ExportSettingModel(this.resolutionLevel, this.fpsValue, buildUnknownFields()) : (ExportSettingModel) iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/ExportSettingModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/ExportSettingModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58598);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ExportSettingModel.class);
        ProtoAdapter<ExportSettingModel> protoAdapter = new ProtoAdapter<ExportSettingModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.ExportSettingModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.ExportSettingModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ExportSettingModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (ExportSettingModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new ExportSettingModel(num, num2, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 1) {
                        num = ProtoAdapter.INT32.decode(reader);
                    } else if (nextTag != 2) {
                        reader.readUnknownField(nextTag);
                    } else {
                        num2 = ProtoAdapter.INT32.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull ExportSettingModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.resolutionLevel);
                protoAdapter2.encodeWithTag(writer, 2, value.fpsValue);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull ExportSettingModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                return protoAdapter2.encodedSizeWithTag(1, value.resolutionLevel) + protoAdapter2.encodedSizeWithTag(2, value.fpsValue) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ExportSettingModel redact(@NotNull ExportSettingModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (ExportSettingModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                return ExportSettingModel.copy$default(value, null, null, ByteString.EMPTY, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public ExportSettingModel() {
        this(null, null, null, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ ExportSettingModel copy$default(ExportSettingModel exportSettingModel, Integer num, Integer num2, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = exportSettingModel.resolutionLevel;
        }
        if ((i3 & 2) != 0) {
            num2 = exportSettingModel.fpsValue;
        }
        if ((i3 & 4) != 0) {
            byteString = exportSettingModel.unknownFields();
        }
        return exportSettingModel.copy(num, num2, byteString);
    }

    @NotNull
    public final ExportSettingModel copy(@Nullable Integer resolutionLevel, @Nullable Integer fpsValue, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ExportSettingModel) iPatchRedirector.redirect((short) 7, this, resolutionLevel, fpsValue, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new ExportSettingModel(resolutionLevel, fpsValue, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof ExportSettingModel)) {
            return false;
        }
        ExportSettingModel exportSettingModel = (ExportSettingModel) other;
        if (Intrinsics.areEqual(unknownFields(), exportSettingModel.unknownFields()) && Intrinsics.areEqual(this.resolutionLevel, exportSettingModel.resolutionLevel) && Intrinsics.areEqual(this.fpsValue, exportSettingModel.fpsValue)) {
            return true;
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
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.resolutionLevel;
            int i17 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            Integer num2 = this.fpsValue;
            if (num2 != null) {
                i17 = num2.hashCode();
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
        Integer num = this.resolutionLevel;
        if (num != null) {
            arrayList.add("resolutionLevel=" + num);
        }
        Integer num2 = this.fpsValue;
        if (num2 != null) {
            arrayList.add("fpsValue=" + num2);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ExportSettingModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ ExportSettingModel(Integer num, Integer num2, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) == 0 ? num2 : null, (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, num, num2, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.resolutionLevel = this.resolutionLevel;
        builder.fpsValue = this.fpsValue;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExportSettingModel(@Nullable Integer num, @Nullable Integer num2, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, num, num2, unknownFields);
        } else {
            this.resolutionLevel = num;
            this.fpsValue = num2;
        }
    }
}
