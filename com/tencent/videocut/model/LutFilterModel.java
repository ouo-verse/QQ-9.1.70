package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019BQ\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ]\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/videocut/model/LutFilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/LutFilterModel$Builder;", "name", "", ShortVideoConstants.PARAM_KEY_FILTER_ID, "filePath", "intensity", "", "categoryId", "themeId", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/videocut/model/LutFilterModel;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class LutFilterModel extends AndroidMessage<LutFilterModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<LutFilterModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LutFilterModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String categoryId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @NotNull
    public final String filePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String filterId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    @JvmField
    public final float intensity;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @Nullable
    public final String themeId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/videocut/model/LutFilterModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/LutFilterModel;", "()V", "categoryId", "", "filePath", ShortVideoConstants.PARAM_KEY_FILTER_ID, "intensity", "", "Ljava/lang/Float;", "name", "themeId", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/LutFilterModel$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<LutFilterModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public String categoryId;

        @JvmField
        @NotNull
        public String filePath;

        @JvmField
        @NotNull
        public String filterId;

        @JvmField
        @Nullable
        public Float intensity;

        @JvmField
        @Nullable
        public String name;

        @JvmField
        @Nullable
        public String themeId;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.filterId = "";
                this.filePath = "";
            }
        }

        @NotNull
        public final Builder categoryId(@Nullable String categoryId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) categoryId);
            }
            this.categoryId = categoryId;
            return this;
        }

        @NotNull
        public final Builder filePath(@Nullable String filePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) filePath);
            }
            if (filePath == null) {
                filePath = "";
            }
            this.filePath = filePath;
            return this;
        }

        @NotNull
        public final Builder filterId(@Nullable String filterId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) filterId);
            }
            if (filterId == null) {
                filterId = "";
            }
            this.filterId = filterId;
            return this;
        }

        @NotNull
        public final Builder intensity(@Nullable Float intensity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intensity);
            }
            this.intensity = intensity;
            return this;
        }

        @NotNull
        public final Builder name(@Nullable String name) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name);
            }
            this.name = name;
            return this;
        }

        @NotNull
        public final Builder themeId(@Nullable String themeId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) themeId);
            }
            this.themeId = themeId;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public LutFilterModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (LutFilterModel) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            String str = this.name;
            String str2 = this.filterId;
            String str3 = this.filePath;
            Float f16 = this.intensity;
            return new LutFilterModel(str, str2, str3, f16 != null ? f16.floatValue() : 0.0f, this.categoryId, this.themeId, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/LutFilterModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/LutFilterModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LutFilterModel.class);
        ProtoAdapter<LutFilterModel> protoAdapter = new ProtoAdapter<LutFilterModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.LutFilterModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.LutFilterModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public LutFilterModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (LutFilterModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = "";
                String str2 = null;
                Float f16 = null;
                String str3 = null;
                String str4 = null;
                String str5 = "";
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                str5 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 4:
                                f16 = ProtoAdapter.FLOAT.decode(reader);
                                break;
                            case 5:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 6:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        Float f17 = f16;
                        return new LutFilterModel(str2, str, str5, f17 != null ? f17.floatValue() : 0.0f, str3, str4, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull LutFilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.name);
                protoAdapter2.encodeWithTag(writer, 2, value.filterId);
                protoAdapter2.encodeWithTag(writer, 3, value.filePath);
                ProtoAdapter.FLOAT.encodeWithTag(writer, 4, Float.valueOf(value.intensity));
                protoAdapter2.encodeWithTag(writer, 5, value.categoryId);
                protoAdapter2.encodeWithTag(writer, 6, value.themeId);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull LutFilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return protoAdapter2.encodedSizeWithTag(1, value.name) + protoAdapter2.encodedSizeWithTag(2, value.filterId) + protoAdapter2.encodedSizeWithTag(3, value.filePath) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, Float.valueOf(value.intensity)) + protoAdapter2.encodedSizeWithTag(5, value.categoryId) + protoAdapter2.encodedSizeWithTag(6, value.themeId) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public LutFilterModel redact(@NotNull LutFilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (LutFilterModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                return LutFilterModel.copy$default(value, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public LutFilterModel() {
        this(null, null, null, 0.0f, null, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ LutFilterModel copy$default(LutFilterModel lutFilterModel, String str, String str2, String str3, Float f16, String str4, String str5, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = lutFilterModel.name;
        }
        if ((i3 & 2) != 0) {
            str2 = lutFilterModel.filterId;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = lutFilterModel.filePath;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            f16 = Float.valueOf(lutFilterModel.intensity);
        }
        Float f17 = f16;
        if ((i3 & 16) != 0) {
            str4 = lutFilterModel.categoryId;
        }
        String str8 = str4;
        if ((i3 & 32) != 0) {
            str5 = lutFilterModel.themeId;
        }
        String str9 = str5;
        if ((i3 & 64) != 0) {
            byteString = lutFilterModel.unknownFields();
        }
        return lutFilterModel.copy(str, str6, str7, f17, str8, str9, byteString);
    }

    @NotNull
    public final LutFilterModel copy(@Nullable String name, @Nullable String filterId, @Nullable String filePath, @Nullable Float intensity, @Nullable String categoryId, @Nullable String themeId, @NotNull ByteString unknownFields) {
        String str;
        String str2;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LutFilterModel) iPatchRedirector.redirect((short) 7, this, name, filterId, filePath, intensity, categoryId, themeId, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (filterId == null) {
            str = "";
        } else {
            str = filterId;
        }
        if (filePath == null) {
            str2 = "";
        } else {
            str2 = filePath;
        }
        if (intensity != null) {
            f16 = intensity.floatValue();
        } else {
            f16 = 0.0f;
        }
        return new LutFilterModel(name, str, str2, f16, categoryId, themeId, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof LutFilterModel)) {
            return false;
        }
        LutFilterModel lutFilterModel = (LutFilterModel) other;
        if (Intrinsics.areEqual(unknownFields(), lutFilterModel.unknownFields()) && Intrinsics.areEqual(this.name, lutFilterModel.name) && Intrinsics.areEqual(this.filterId, lutFilterModel.filterId) && Intrinsics.areEqual(this.filePath, lutFilterModel.filePath)) {
            if (this.intensity == lutFilterModel.intensity) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && Intrinsics.areEqual(this.categoryId, lutFilterModel.categoryId) && Intrinsics.areEqual(this.themeId, lutFilterModel.themeId)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.name;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = (((((((hashCode + i3) * 37) + this.filterId.hashCode()) * 37) + this.filePath.hashCode()) * 37) + Float.floatToIntBits(this.intensity)) * 37;
            String str2 = this.categoryId;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (hashCode2 + i16) * 37;
            String str3 = this.themeId;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int i26 = i19 + i18;
            this.hashCode = i26;
            return i26;
        }
        return i17;
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
        String str = this.name;
        if (str != null) {
            arrayList.add("name=" + Internal.sanitize(str));
        }
        String str2 = this.filterId;
        if (str2 != null) {
            arrayList.add("filterId=" + Internal.sanitize(str2));
        }
        String str3 = this.filePath;
        if (str3 != null) {
            arrayList.add("filePath=" + Internal.sanitize(str3));
        }
        arrayList.add("intensity=" + this.intensity);
        String str4 = this.categoryId;
        if (str4 != null) {
            arrayList.add("categoryId=" + Internal.sanitize(str4));
        }
        String str5 = this.themeId;
        if (str5 != null) {
            arrayList.add("themeId=" + Internal.sanitize(str5));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "LutFilterModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ LutFilterModel(String str, String str2, String str3, float f16, String str4, String str5, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? 0.0f : f16, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, Float.valueOf(f16), str4, str5, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.name = this.name;
        builder.filterId = this.filterId;
        builder.filePath = this.filePath;
        builder.intensity = Float.valueOf(this.intensity);
        builder.categoryId = this.categoryId;
        builder.themeId = this.themeId;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LutFilterModel(@Nullable String str, @NotNull String filterId, @NotNull String filePath, float f16, @Nullable String str2, @Nullable String str3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(filterId, "filterId");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, filterId, filePath, Float.valueOf(f16), str2, str3, unknownFields);
            return;
        }
        this.name = str;
        this.filterId = filterId;
        this.filePath = filePath;
        this.intensity = f16;
        this.categoryId = str2;
        this.themeId = str3;
    }
}
