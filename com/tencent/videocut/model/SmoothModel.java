package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.aio.widget.textView.param.a;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010JL\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016R\u0010\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/videocut/model/SmoothModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/SmoothModel$Builder;", "enableSharp", "", "sharpenType", "", "sharpenStrength", "", "id", "", "startOffsetUs", "", "durationUs", "unknownFields", "Lokio/ByteString;", "(ZIFLjava/lang/String;JJLokio/ByteString;)V", "copy", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class SmoothModel extends AndroidMessage<SmoothModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<SmoothModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<SmoothModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    @JvmField
    public final long durationUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    @JvmField
    public final boolean enableSharp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    @JvmField
    @NotNull
    public final String id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    @JvmField
    public final float sharpenStrength;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    @JvmField
    public final int sharpenType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    @JvmField
    public final long startOffsetUs;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/videocut/model/SmoothModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/SmoothModel;", "()V", "durationUs", "", "enableSharp", "", "id", "", "sharpenStrength", "", "sharpenType", "", "startOffsetUs", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<SmoothModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        public long durationUs;

        @JvmField
        public boolean enableSharp;

        @JvmField
        @NotNull
        public String id;

        @JvmField
        public float sharpenStrength;

        @JvmField
        public int sharpenType;

        @JvmField
        public long startOffsetUs;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.id = "";
            }
        }

        @NotNull
        public final Builder durationUs(long durationUs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, durationUs);
            }
            this.durationUs = durationUs;
            return this;
        }

        @NotNull
        public final Builder enableSharp(boolean enableSharp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, enableSharp);
            }
            this.enableSharp = enableSharp;
            return this;
        }

        @NotNull
        public final Builder id(@NotNull String id5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) id5);
            }
            Intrinsics.checkNotNullParameter(id5, "id");
            this.id = id5;
            return this;
        }

        @NotNull
        public final Builder sharpenStrength(float sharpenStrength) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, this, Float.valueOf(sharpenStrength));
            }
            this.sharpenStrength = sharpenStrength;
            return this;
        }

        @NotNull
        public final Builder sharpenType(int sharpenType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, sharpenType);
            }
            this.sharpenType = sharpenType;
            return this;
        }

        @NotNull
        public final Builder startOffsetUs(long startOffsetUs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, startOffsetUs);
            }
            this.startOffsetUs = startOffsetUs;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public SmoothModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? new SmoothModel(this.enableSharp, this.sharpenType, this.sharpenStrength, this.id, this.startOffsetUs, this.durationUs, buildUnknownFields()) : (SmoothModel) iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/model/SmoothModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/SmoothModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "serialVersionUID", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59045);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SmoothModel.class);
        final Syntax syntax = Syntax.PROTO_3;
        ProtoAdapter<SmoothModel> protoAdapter = new ProtoAdapter<SmoothModel>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.tencent.videocut.model.SmoothModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/model.SmoothModel", syntax, (Object) null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, fieldEncoding, orCreateKotlinClass, syntax);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public SmoothModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (SmoothModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = "";
                long j3 = 0;
                long j16 = 0;
                boolean z16 = false;
                int i3 = 0;
                float f16 = 0.0f;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                z16 = ProtoAdapter.BOOL.decode(reader).booleanValue();
                                break;
                            case 2:
                                i3 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 3:
                                f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            case 4:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 5:
                                j3 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 6:
                                j16 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        return new SmoothModel(z16, i3, f16, str, j3, j16, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull SmoothModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                boolean z16 = value.enableSharp;
                if (z16) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 1, Boolean.valueOf(z16));
                }
                int i3 = value.sharpenType;
                if (i3 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(i3));
                }
                float f16 = value.sharpenStrength;
                if (!(f16 == 0.0f)) {
                    ProtoAdapter.FLOAT.encodeWithTag(writer, 3, Float.valueOf(f16));
                }
                if (!Intrinsics.areEqual(value.id, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.id);
                }
                long j3 = value.startOffsetUs;
                if (j3 != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 5, Long.valueOf(j3));
                }
                long j16 = value.durationUs;
                if (j16 != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 6, Long.valueOf(j16));
                }
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull SmoothModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                int size = value.unknownFields().size();
                boolean z16 = value.enableSharp;
                if (z16) {
                    size += ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(z16));
                }
                int i3 = value.sharpenType;
                if (i3 != 0) {
                    size += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(i3));
                }
                float f16 = value.sharpenStrength;
                if (!(f16 == 0.0f)) {
                    size += ProtoAdapter.FLOAT.encodedSizeWithTag(3, Float.valueOf(f16));
                }
                if (!Intrinsics.areEqual(value.id, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(4, value.id);
                }
                long j3 = value.startOffsetUs;
                if (j3 != 0) {
                    size += ProtoAdapter.INT64.encodedSizeWithTag(5, Long.valueOf(j3));
                }
                long j16 = value.durationUs;
                return j16 != 0 ? size + ProtoAdapter.INT64.encodedSizeWithTag(6, Long.valueOf(j16)) : size;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public SmoothModel redact(@NotNull SmoothModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (SmoothModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                return SmoothModel.copy$default(value, false, 0, 0.0f, null, 0L, 0L, ByteString.EMPTY, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public SmoothModel() {
        this(false, 0, 0.0f, null, 0L, 0L, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ SmoothModel copy$default(SmoothModel smoothModel, boolean z16, int i3, float f16, String str, long j3, long j16, ByteString byteString, int i16, Object obj) {
        boolean z17;
        int i17;
        float f17;
        String str2;
        long j17;
        long j18;
        ByteString byteString2;
        if ((i16 & 1) != 0) {
            z17 = smoothModel.enableSharp;
        } else {
            z17 = z16;
        }
        if ((i16 & 2) != 0) {
            i17 = smoothModel.sharpenType;
        } else {
            i17 = i3;
        }
        if ((i16 & 4) != 0) {
            f17 = smoothModel.sharpenStrength;
        } else {
            f17 = f16;
        }
        if ((i16 & 8) != 0) {
            str2 = smoothModel.id;
        } else {
            str2 = str;
        }
        if ((i16 & 16) != 0) {
            j17 = smoothModel.startOffsetUs;
        } else {
            j17 = j3;
        }
        if ((i16 & 32) != 0) {
            j18 = smoothModel.durationUs;
        } else {
            j18 = j16;
        }
        if ((i16 & 64) != 0) {
            byteString2 = smoothModel.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return smoothModel.copy(z17, i17, f17, str2, j17, j18, byteString2);
    }

    @NotNull
    public final SmoothModel copy(boolean enableSharp, int sharpenType, float sharpenStrength, @NotNull String id5, long startOffsetUs, long durationUs, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SmoothModel) iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(enableSharp), Integer.valueOf(sharpenType), Float.valueOf(sharpenStrength), id5, Long.valueOf(startOffsetUs), Long.valueOf(durationUs), unknownFields);
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new SmoothModel(enableSharp, sharpenType, sharpenStrength, id5, startOffsetUs, durationUs, unknownFields);
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
        if (!(other instanceof SmoothModel)) {
            return false;
        }
        SmoothModel smoothModel = (SmoothModel) other;
        if (!Intrinsics.areEqual(unknownFields(), smoothModel.unknownFields()) || this.enableSharp != smoothModel.enableSharp || this.sharpenType != smoothModel.sharpenType) {
            return false;
        }
        if (this.sharpenStrength == smoothModel.sharpenStrength) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual(this.id, smoothModel.id) && this.startOffsetUs == smoothModel.startOffsetUs && this.durationUs == smoothModel.durationUs) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((((((unknownFields().hashCode() * 37) + a.a(this.enableSharp)) * 37) + this.sharpenType) * 37) + Float.floatToIntBits(this.sharpenStrength)) * 37) + this.id.hashCode()) * 37) + androidx.fragment.app.a.a(this.startOffsetUs)) * 37) + androidx.fragment.app.a.a(this.durationUs);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
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
        arrayList.add("enableSharp=" + this.enableSharp);
        arrayList.add("sharpenType=" + this.sharpenType);
        arrayList.add("sharpenStrength=" + this.sharpenStrength);
        arrayList.add("id=" + Internal.sanitize(this.id));
        arrayList.add("startOffsetUs=" + this.startOffsetUs);
        arrayList.add("durationUs=" + this.durationUs);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "SmoothModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ SmoothModel(boolean z16, int i3, float f16, String str, long j3, long j16, ByteString byteString, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? 0.0f : f16, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? 0L : j3, (i16 & 32) != 0 ? 0L : j16, (i16 & 64) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Float.valueOf(f16), str, Long.valueOf(j3), Long.valueOf(j16), byteString, Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.enableSharp = this.enableSharp;
        builder.sharpenType = this.sharpenType;
        builder.sharpenStrength = this.sharpenStrength;
        builder.id = this.id;
        builder.startOffsetUs = this.startOffsetUs;
        builder.durationUs = this.durationUs;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothModel(boolean z16, int i3, float f16, @NotNull String id5, long j3, long j16, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Float.valueOf(f16), id5, Long.valueOf(j3), Long.valueOf(j16), unknownFields);
            return;
        }
        this.enableSharp = z16;
        this.sharpenType = i3;
        this.sharpenStrength = f16;
        this.id = id5;
        this.startOffsetUs = j3;
        this.durationUs = j16;
    }
}
