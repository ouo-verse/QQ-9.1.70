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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB_\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJu\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/videocut/model/ColorFilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/ColorFilterModel$Builder;", "sharpness", "", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "unknownFields", "Lokio/ByteString;", "(IIIIIIIILokio/ByteString;)V", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/ColorFilterModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ColorFilterModel extends AndroidMessage<ColorFilterModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<ColorFilterModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ColorFilterModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    public final int brightness;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    public final int contrast;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    public final int highlights;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @JvmField
    public final int hue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    @JvmField
    public final int saturation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    public final int shadows;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    public final int sharpness;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    @JvmField
    public final int temperature;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/videocut/model/ColorFilterModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/ColorFilterModel;", "()V", "brightness", "", "Ljava/lang/Integer;", "contrast", "highlights", "hue", "saturation", "shadows", "sharpness", "temperature", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/ColorFilterModel$Builder;", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<ColorFilterModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public Integer brightness;

        @JvmField
        @Nullable
        public Integer contrast;

        @JvmField
        @Nullable
        public Integer highlights;

        @JvmField
        @Nullable
        public Integer hue;

        @JvmField
        @Nullable
        public Integer saturation;

        @JvmField
        @Nullable
        public Integer shadows;

        @JvmField
        @Nullable
        public Integer sharpness;

        @JvmField
        @Nullable
        public Integer temperature;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder brightness(@Nullable Integer brightness) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) brightness);
            }
            this.brightness = brightness;
            return this;
        }

        @NotNull
        public final Builder contrast(@Nullable Integer contrast) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) contrast);
            }
            this.contrast = contrast;
            return this;
        }

        @NotNull
        public final Builder highlights(@Nullable Integer highlights) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) highlights);
            }
            this.highlights = highlights;
            return this;
        }

        @NotNull
        public final Builder hue(@Nullable Integer hue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) hue);
            }
            this.hue = hue;
            return this;
        }

        @NotNull
        public final Builder saturation(@Nullable Integer saturation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) saturation);
            }
            this.saturation = saturation;
            return this;
        }

        @NotNull
        public final Builder shadows(@Nullable Integer shadows) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) shadows);
            }
            this.shadows = shadows;
            return this;
        }

        @NotNull
        public final Builder sharpness(@Nullable Integer sharpness) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sharpness);
            }
            this.sharpness = sharpness;
            return this;
        }

        @NotNull
        public final Builder temperature(@Nullable Integer temperature) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) temperature);
            }
            this.temperature = temperature;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public ColorFilterModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (ColorFilterModel) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            Integer num = this.sharpness;
            int intValue = num != null ? num.intValue() : 0;
            Integer num2 = this.brightness;
            int intValue2 = num2 != null ? num2.intValue() : 0;
            Integer num3 = this.contrast;
            int intValue3 = num3 != null ? num3.intValue() : 0;
            Integer num4 = this.hue;
            int intValue4 = num4 != null ? num4.intValue() : 0;
            Integer num5 = this.highlights;
            int intValue5 = num5 != null ? num5.intValue() : 0;
            Integer num6 = this.shadows;
            int intValue6 = num6 != null ? num6.intValue() : 0;
            Integer num7 = this.saturation;
            int intValue7 = num7 != null ? num7.intValue() : 0;
            Integer num8 = this.temperature;
            return new ColorFilterModel(intValue, intValue2, intValue3, intValue4, intValue5, intValue6, intValue7, num8 != null ? num8.intValue() : 0, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/ColorFilterModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/ColorFilterModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ColorFilterModel.class);
        ProtoAdapter<ColorFilterModel> protoAdapter = new ProtoAdapter<ColorFilterModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.ColorFilterModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.ColorFilterModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ColorFilterModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (ColorFilterModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Integer num3 = null;
                Integer num4 = null;
                Integer num5 = null;
                Integer num6 = null;
                Integer num7 = null;
                Integer num8 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                num = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 2:
                                num2 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 3:
                                num3 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 4:
                                num4 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 5:
                                num5 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 6:
                                num6 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 7:
                                num7 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 8:
                                num8 = ProtoAdapter.INT32.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        Integer num9 = num;
                        Integer num10 = num2;
                        Integer num11 = num3;
                        Integer num12 = num4;
                        Integer num13 = num5;
                        Integer num14 = num6;
                        Integer num15 = num7;
                        Integer num16 = num8;
                        return new ColorFilterModel(num9 != null ? num9.intValue() : 0, num10 != null ? num10.intValue() : 0, num11 != null ? num11.intValue() : 0, num12 != null ? num12.intValue() : 0, num13 != null ? num13.intValue() : 0, num14 != null ? num14.intValue() : 0, num15 != null ? num15.intValue() : 0, num16 != null ? num16.intValue() : 0, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull ColorFilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, Integer.valueOf(value.sharpness));
                protoAdapter2.encodeWithTag(writer, 2, Integer.valueOf(value.brightness));
                protoAdapter2.encodeWithTag(writer, 3, Integer.valueOf(value.contrast));
                protoAdapter2.encodeWithTag(writer, 4, Integer.valueOf(value.hue));
                protoAdapter2.encodeWithTag(writer, 5, Integer.valueOf(value.highlights));
                protoAdapter2.encodeWithTag(writer, 6, Integer.valueOf(value.shadows));
                protoAdapter2.encodeWithTag(writer, 7, Integer.valueOf(value.saturation));
                protoAdapter2.encodeWithTag(writer, 8, Integer.valueOf(value.temperature));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull ColorFilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                return protoAdapter2.encodedSizeWithTag(1, Integer.valueOf(value.sharpness)) + protoAdapter2.encodedSizeWithTag(2, Integer.valueOf(value.brightness)) + protoAdapter2.encodedSizeWithTag(3, Integer.valueOf(value.contrast)) + protoAdapter2.encodedSizeWithTag(4, Integer.valueOf(value.hue)) + protoAdapter2.encodedSizeWithTag(5, Integer.valueOf(value.highlights)) + protoAdapter2.encodedSizeWithTag(6, Integer.valueOf(value.shadows)) + protoAdapter2.encodedSizeWithTag(7, Integer.valueOf(value.saturation)) + protoAdapter2.encodedSizeWithTag(8, Integer.valueOf(value.temperature)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ColorFilterModel redact(@NotNull ColorFilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (ColorFilterModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                return ColorFilterModel.copy$default(value, null, null, null, null, null, null, null, null, ByteString.EMPTY, 255, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public ColorFilterModel() {
        this(0, 0, 0, 0, 0, 0, 0, 0, null, 511, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ ColorFilterModel copy$default(ColorFilterModel colorFilterModel, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, ByteString byteString, int i3, Object obj) {
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        Integer num15;
        Integer num16;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            num9 = Integer.valueOf(colorFilterModel.sharpness);
        } else {
            num9 = num;
        }
        if ((i3 & 2) != 0) {
            num10 = Integer.valueOf(colorFilterModel.brightness);
        } else {
            num10 = num2;
        }
        if ((i3 & 4) != 0) {
            num11 = Integer.valueOf(colorFilterModel.contrast);
        } else {
            num11 = num3;
        }
        if ((i3 & 8) != 0) {
            num12 = Integer.valueOf(colorFilterModel.hue);
        } else {
            num12 = num4;
        }
        if ((i3 & 16) != 0) {
            num13 = Integer.valueOf(colorFilterModel.highlights);
        } else {
            num13 = num5;
        }
        if ((i3 & 32) != 0) {
            num14 = Integer.valueOf(colorFilterModel.shadows);
        } else {
            num14 = num6;
        }
        if ((i3 & 64) != 0) {
            num15 = Integer.valueOf(colorFilterModel.saturation);
        } else {
            num15 = num7;
        }
        if ((i3 & 128) != 0) {
            num16 = Integer.valueOf(colorFilterModel.temperature);
        } else {
            num16 = num8;
        }
        if ((i3 & 256) != 0) {
            byteString2 = colorFilterModel.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return colorFilterModel.copy(num9, num10, num11, num12, num13, num14, num15, num16, byteString2);
    }

    @NotNull
    public final ColorFilterModel copy(@Nullable Integer sharpness, @Nullable Integer brightness, @Nullable Integer contrast, @Nullable Integer hue, @Nullable Integer highlights, @Nullable Integer shadows, @Nullable Integer saturation, @Nullable Integer temperature, @NotNull ByteString unknownFields) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ColorFilterModel) iPatchRedirector.redirect((short) 7, this, sharpness, brightness, contrast, hue, highlights, shadows, saturation, temperature, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (sharpness != null) {
            i3 = sharpness.intValue();
        } else {
            i3 = 0;
        }
        if (brightness != null) {
            i16 = brightness.intValue();
        } else {
            i16 = 0;
        }
        if (contrast != null) {
            i17 = contrast.intValue();
        } else {
            i17 = 0;
        }
        if (hue != null) {
            i18 = hue.intValue();
        } else {
            i18 = 0;
        }
        if (highlights != null) {
            i19 = highlights.intValue();
        } else {
            i19 = 0;
        }
        if (shadows != null) {
            i26 = shadows.intValue();
        } else {
            i26 = 0;
        }
        if (saturation != null) {
            i27 = saturation.intValue();
        } else {
            i27 = 0;
        }
        if (temperature != null) {
            i28 = temperature.intValue();
        } else {
            i28 = 0;
        }
        return new ColorFilterModel(i3, i16, i17, i18, i19, i26, i27, i28, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof ColorFilterModel)) {
            return false;
        }
        ColorFilterModel colorFilterModel = (ColorFilterModel) other;
        if (Intrinsics.areEqual(unknownFields(), colorFilterModel.unknownFields()) && this.sharpness == colorFilterModel.sharpness && this.brightness == colorFilterModel.brightness && this.contrast == colorFilterModel.contrast && this.hue == colorFilterModel.hue && this.highlights == colorFilterModel.highlights && this.shadows == colorFilterModel.shadows && this.saturation == colorFilterModel.saturation && this.temperature == colorFilterModel.temperature) {
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
            int hashCode = (((((((((((((((unknownFields().hashCode() * 37) + this.sharpness) * 37) + this.brightness) * 37) + this.contrast) * 37) + this.hue) * 37) + this.highlights) * 37) + this.shadows) * 37) + this.saturation) * 37) + this.temperature;
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
        arrayList.add("sharpness=" + this.sharpness);
        arrayList.add("brightness=" + this.brightness);
        arrayList.add("contrast=" + this.contrast);
        arrayList.add("hue=" + this.hue);
        arrayList.add("highlights=" + this.highlights);
        arrayList.add("shadows=" + this.shadows);
        arrayList.add("saturation=" + this.saturation);
        arrayList.add("temperature=" + this.temperature);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ColorFilterModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ ColorFilterModel(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, ByteString byteString, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this((i29 & 1) != 0 ? 0 : i3, (i29 & 2) != 0 ? 0 : i16, (i29 & 4) != 0 ? 0 : i17, (i29 & 8) != 0 ? 0 : i18, (i29 & 16) != 0 ? 0 : i19, (i29 & 32) != 0 ? 0 : i26, (i29 & 64) != 0 ? 0 : i27, (i29 & 128) != 0 ? 0 : i28, (i29 & 256) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), byteString, Integer.valueOf(i29), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.sharpness = Integer.valueOf(this.sharpness);
        builder.brightness = Integer.valueOf(this.brightness);
        builder.contrast = Integer.valueOf(this.contrast);
        builder.hue = Integer.valueOf(this.hue);
        builder.highlights = Integer.valueOf(this.highlights);
        builder.shadows = Integer.valueOf(this.shadows);
        builder.saturation = Integer.valueOf(this.saturation);
        builder.temperature = Integer.valueOf(this.temperature);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorFilterModel(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), unknownFields);
            return;
        }
        this.sharpness = i3;
        this.brightness = i16;
        this.contrast = i17;
        this.hue = i18;
        this.highlights = i19;
        this.shadows = i26;
        this.saturation = i27;
        this.temperature = i28;
    }
}
