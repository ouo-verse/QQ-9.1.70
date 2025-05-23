package com.tencent.videocut.model;

import android.os.Parcelable;
import androidx.fragment.app.a;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cBQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J]\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/videocut/model/FilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/FilterModel$Builder;", "id", "", TAVBaseAutomaticEffect.EFFECT_TYPE_LUT, "Lcom/tencent/videocut/model/LutFilterModel;", "color", "Lcom/tencent/videocut/model/ColorFilterModel;", "startTimeUs", "", "durationUs", "timeLineIndex", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Lcom/tencent/videocut/model/LutFilterModel;Lcom/tencent/videocut/model/ColorFilterModel;JJLjava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Lcom/tencent/videocut/model/LutFilterModel;Lcom/tencent/videocut/model/ColorFilterModel;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/FilterModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FilterModel extends AndroidMessage<FilterModel, Builder> {
    static IPatchRedirector $redirector_ = null;

    @JvmField
    @NotNull
    public static final ProtoAdapter<FilterModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<FilterModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long serialVersionUID = 2792826135857271306L;

    @WireField(adapter = "com.tencent.videocut.model.ColorFilterModel#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final ColorFilterModel color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @JvmField
    public final long durationUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String id;

    @WireField(adapter = "com.tencent.videocut.model.LutFilterModel#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final LutFilterModel lut;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    public final long startTimeUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer timeLineIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/videocut/model/FilterModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/FilterModel;", "()V", "color", "Lcom/tencent/videocut/model/ColorFilterModel;", "durationUs", "", "id", "", TAVBaseAutomaticEffect.EFFECT_TYPE_LUT, "Lcom/tencent/videocut/model/LutFilterModel;", "startTimeUs", "timeLineIndex", "", "Ljava/lang/Integer;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/FilterModel$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/FilterModel$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<FilterModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public ColorFilterModel color;

        @JvmField
        public long durationUs;

        @JvmField
        @Nullable
        public String id;

        @JvmField
        @Nullable
        public LutFilterModel lut;

        @JvmField
        public long startTimeUs;

        @JvmField
        @Nullable
        public Integer timeLineIndex;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder color(@Nullable ColorFilterModel color) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) color);
            }
            this.color = color;
            return this;
        }

        @NotNull
        public final Builder durationUs(@Nullable Long durationUs) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) durationUs);
            }
            if (durationUs != null) {
                j3 = durationUs.longValue();
            } else {
                j3 = 0;
            }
            this.durationUs = j3;
            return this;
        }

        @NotNull
        public final Builder id(@Nullable String id5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5);
            }
            this.id = id5;
            return this;
        }

        @NotNull
        public final Builder lut(@Nullable LutFilterModel lut) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) lut);
            }
            this.lut = lut;
            return this;
        }

        @NotNull
        public final Builder startTimeUs(@Nullable Long startTimeUs) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) startTimeUs);
            }
            if (startTimeUs != null) {
                j3 = startTimeUs.longValue();
            } else {
                j3 = 0;
            }
            this.startTimeUs = j3;
            return this;
        }

        @NotNull
        public final Builder timeLineIndex(@Nullable Integer timeLineIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) timeLineIndex);
            }
            this.timeLineIndex = timeLineIndex;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public FilterModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (FilterModel) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            String str = this.id;
            if (str == null) {
                str = "";
            }
            return new FilterModel(str, this.lut, this.color, this.startTimeUs, this.durationUs, this.timeLineIndex, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/model/FilterModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/FilterModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "serialVersionUID", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58632);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FilterModel.class);
        ProtoAdapter<FilterModel> protoAdapter = new ProtoAdapter<FilterModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.FilterModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.FilterModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public FilterModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (FilterModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = null;
                long j3 = 0;
                long j16 = 0;
                LutFilterModel lutFilterModel = null;
                ColorFilterModel colorFilterModel = null;
                Integer num = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                lutFilterModel = LutFilterModel.ADAPTER.decode(reader);
                                break;
                            case 3:
                                colorFilterModel = ColorFilterModel.ADAPTER.decode(reader);
                                break;
                            case 4:
                                j3 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 5:
                                j16 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 6:
                                num = ProtoAdapter.INT32.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        String str2 = str;
                        return new FilterModel(str2 == null ? "" : str2, lutFilterModel, colorFilterModel, j3, j16, num, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull FilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter.STRING.encodeWithTag(writer, 1, value.id);
                LutFilterModel.ADAPTER.encodeWithTag(writer, 2, value.lut);
                ColorFilterModel.ADAPTER.encodeWithTag(writer, 3, value.color);
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                protoAdapter2.encodeWithTag(writer, 4, Long.valueOf(value.startTimeUs));
                protoAdapter2.encodeWithTag(writer, 5, Long.valueOf(value.durationUs));
                ProtoAdapter.INT32.encodeWithTag(writer, 6, value.timeLineIndex);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull FilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, value.id) + LutFilterModel.ADAPTER.encodedSizeWithTag(2, value.lut) + ColorFilterModel.ADAPTER.encodedSizeWithTag(3, value.color);
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(4, Long.valueOf(value.startTimeUs)) + protoAdapter2.encodedSizeWithTag(5, Long.valueOf(value.durationUs)) + ProtoAdapter.INT32.encodedSizeWithTag(6, value.timeLineIndex) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public FilterModel redact(@NotNull FilterModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (FilterModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                LutFilterModel lutFilterModel = value.lut;
                LutFilterModel redact = lutFilterModel != null ? LutFilterModel.ADAPTER.redact(lutFilterModel) : null;
                ColorFilterModel colorFilterModel = value.color;
                return FilterModel.copy$default(value, null, redact, colorFilterModel != null ? ColorFilterModel.ADAPTER.redact(colorFilterModel) : null, null, null, null, ByteString.EMPTY, 57, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public FilterModel() {
        this(null, null, null, 0L, 0L, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ FilterModel copy$default(FilterModel filterModel, String str, LutFilterModel lutFilterModel, ColorFilterModel colorFilterModel, Long l3, Long l16, Integer num, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = filterModel.id;
        }
        if ((i3 & 2) != 0) {
            lutFilterModel = filterModel.lut;
        }
        LutFilterModel lutFilterModel2 = lutFilterModel;
        if ((i3 & 4) != 0) {
            colorFilterModel = filterModel.color;
        }
        ColorFilterModel colorFilterModel2 = colorFilterModel;
        if ((i3 & 8) != 0) {
            l3 = Long.valueOf(filterModel.startTimeUs);
        }
        Long l17 = l3;
        if ((i3 & 16) != 0) {
            l16 = Long.valueOf(filterModel.durationUs);
        }
        Long l18 = l16;
        if ((i3 & 32) != 0) {
            num = filterModel.timeLineIndex;
        }
        Integer num2 = num;
        if ((i3 & 64) != 0) {
            byteString = filterModel.unknownFields();
        }
        return filterModel.copy(str, lutFilterModel2, colorFilterModel2, l17, l18, num2, byteString);
    }

    @NotNull
    public final FilterModel copy(@Nullable String id5, @Nullable LutFilterModel lut, @Nullable ColorFilterModel color, @Nullable Long startTimeUs, @Nullable Long durationUs, @Nullable Integer timeLineIndex, @NotNull ByteString unknownFields) {
        String str;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FilterModel) iPatchRedirector.redirect((short) 7, this, id5, lut, color, startTimeUs, durationUs, timeLineIndex, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (id5 == null) {
            str = "";
        } else {
            str = id5;
        }
        long j16 = 0;
        if (startTimeUs != null) {
            j3 = startTimeUs.longValue();
        } else {
            j3 = 0;
        }
        if (durationUs != null) {
            j16 = durationUs.longValue();
        }
        return new FilterModel(str, lut, color, j3, j16, timeLineIndex, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof FilterModel)) {
            return false;
        }
        FilterModel filterModel = (FilterModel) other;
        if (Intrinsics.areEqual(unknownFields(), filterModel.unknownFields()) && Intrinsics.areEqual(this.id, filterModel.id) && Intrinsics.areEqual(this.lut, filterModel.lut) && Intrinsics.areEqual(this.color, filterModel.color) && this.startTimeUs == filterModel.startTimeUs && this.durationUs == filterModel.durationUs && Intrinsics.areEqual(this.timeLineIndex, filterModel.timeLineIndex)) {
            return true;
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
            int hashCode = ((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37;
            LutFilterModel lutFilterModel = this.lut;
            int i18 = 0;
            if (lutFilterModel != null) {
                i3 = lutFilterModel.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            ColorFilterModel colorFilterModel = this.color;
            if (colorFilterModel != null) {
                i16 = colorFilterModel.hashCode();
            } else {
                i16 = 0;
            }
            int a16 = (((((i19 + i16) * 37) + a.a(this.startTimeUs)) * 37) + a.a(this.durationUs)) * 37;
            Integer num = this.timeLineIndex;
            if (num != null) {
                i18 = num.hashCode();
            }
            int i26 = a16 + i18;
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
        String str = this.id;
        if (str != null) {
            arrayList.add("id=" + Internal.sanitize(str));
        }
        LutFilterModel lutFilterModel = this.lut;
        if (lutFilterModel != null) {
            arrayList.add("lut=" + lutFilterModel);
        }
        ColorFilterModel colorFilterModel = this.color;
        if (colorFilterModel != null) {
            arrayList.add("color=" + colorFilterModel);
        }
        arrayList.add("startTimeUs=" + this.startTimeUs);
        arrayList.add("durationUs=" + this.durationUs);
        Integer num = this.timeLineIndex;
        if (num != null) {
            arrayList.add("timeLineIndex=" + num);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "FilterModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ FilterModel(String str, LutFilterModel lutFilterModel, ColorFilterModel colorFilterModel, long j3, long j16, Integer num, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : lutFilterModel, (i3 & 4) != 0 ? null : colorFilterModel, (i3 & 8) != 0 ? 0L : j3, (i3 & 16) != 0 ? 0L : j16, (i3 & 32) != 0 ? null : num, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, lutFilterModel, colorFilterModel, Long.valueOf(j3), Long.valueOf(j16), num, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.id = this.id;
        builder.lut = this.lut;
        builder.color = this.color;
        builder.startTimeUs = this.startTimeUs;
        builder.durationUs = this.durationUs;
        builder.timeLineIndex = this.timeLineIndex;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterModel(@NotNull String id5, @Nullable LutFilterModel lutFilterModel, @Nullable ColorFilterModel colorFilterModel, long j3, long j16, @Nullable Integer num, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, lutFilterModel, colorFilterModel, Long.valueOf(j3), Long.valueOf(j16), num, unknownFields);
            return;
        }
        this.id = id5;
        this.lut = lutFilterModel;
        this.color = colorFilterModel;
        this.startTimeUs = j3;
        this.durationUs = j16;
        this.timeLineIndex = num;
    }
}
