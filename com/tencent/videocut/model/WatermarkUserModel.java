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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bBs\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010Jt\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/videocut/model/WatermarkUserModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/WatermarkUserModel$Builder;", "nickName", "", "logoPath", "settlementTimeLabel", "gender", "locationLabel", "describeLabel", "constellationLabel", "monthLabel", "dayLabel", "ageLabel", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class WatermarkUserModel extends AndroidMessage<WatermarkUserModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<WatermarkUserModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WatermarkUserModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    @JvmField
    @NotNull
    public final String ageLabel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    @JvmField
    @NotNull
    public final String constellationLabel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    @JvmField
    @NotNull
    public final String dayLabel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    @JvmField
    @NotNull
    public final String describeLabel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    @JvmField
    @NotNull
    public final String gender;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    @JvmField
    @NotNull
    public final String locationLabel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    @JvmField
    @NotNull
    public final String logoPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    @JvmField
    @NotNull
    public final String monthLabel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    @JvmField
    @NotNull
    public final String nickName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    @JvmField
    @NotNull
    public final String settlementTimeLabel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/videocut/model/WatermarkUserModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/WatermarkUserModel;", "()V", "ageLabel", "", "constellationLabel", "dayLabel", "describeLabel", "gender", "locationLabel", "logoPath", "monthLabel", "nickName", "settlementTimeLabel", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<WatermarkUserModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public String ageLabel;

        @JvmField
        @NotNull
        public String constellationLabel;

        @JvmField
        @NotNull
        public String dayLabel;

        @JvmField
        @NotNull
        public String describeLabel;

        @JvmField
        @NotNull
        public String gender;

        @JvmField
        @NotNull
        public String locationLabel;

        @JvmField
        @NotNull
        public String logoPath;

        @JvmField
        @NotNull
        public String monthLabel;

        @JvmField
        @NotNull
        public String nickName;

        @JvmField
        @NotNull
        public String settlementTimeLabel;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.nickName = "";
            this.logoPath = "";
            this.settlementTimeLabel = "";
            this.gender = "";
            this.locationLabel = "";
            this.describeLabel = "";
            this.constellationLabel = "";
            this.monthLabel = "";
            this.dayLabel = "";
            this.ageLabel = "";
        }

        @NotNull
        public final Builder ageLabel(@NotNull String ageLabel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) ageLabel);
            }
            Intrinsics.checkNotNullParameter(ageLabel, "ageLabel");
            this.ageLabel = ageLabel;
            return this;
        }

        @NotNull
        public final Builder constellationLabel(@NotNull String constellationLabel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) constellationLabel);
            }
            Intrinsics.checkNotNullParameter(constellationLabel, "constellationLabel");
            this.constellationLabel = constellationLabel;
            return this;
        }

        @NotNull
        public final Builder dayLabel(@NotNull String dayLabel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dayLabel);
            }
            Intrinsics.checkNotNullParameter(dayLabel, "dayLabel");
            this.dayLabel = dayLabel;
            return this;
        }

        @NotNull
        public final Builder describeLabel(@NotNull String describeLabel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) describeLabel);
            }
            Intrinsics.checkNotNullParameter(describeLabel, "describeLabel");
            this.describeLabel = describeLabel;
            return this;
        }

        @NotNull
        public final Builder gender(@NotNull String gender) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) gender);
            }
            Intrinsics.checkNotNullParameter(gender, "gender");
            this.gender = gender;
            return this;
        }

        @NotNull
        public final Builder locationLabel(@NotNull String locationLabel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) locationLabel);
            }
            Intrinsics.checkNotNullParameter(locationLabel, "locationLabel");
            this.locationLabel = locationLabel;
            return this;
        }

        @NotNull
        public final Builder logoPath(@NotNull String logoPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) logoPath);
            }
            Intrinsics.checkNotNullParameter(logoPath, "logoPath");
            this.logoPath = logoPath;
            return this;
        }

        @NotNull
        public final Builder monthLabel(@NotNull String monthLabel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) monthLabel);
            }
            Intrinsics.checkNotNullParameter(monthLabel, "monthLabel");
            this.monthLabel = monthLabel;
            return this;
        }

        @NotNull
        public final Builder nickName(@NotNull String nickName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nickName);
            }
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            this.nickName = nickName;
            return this;
        }

        @NotNull
        public final Builder settlementTimeLabel(@NotNull String settlementTimeLabel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) settlementTimeLabel);
            }
            Intrinsics.checkNotNullParameter(settlementTimeLabel, "settlementTimeLabel");
            this.settlementTimeLabel = settlementTimeLabel;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public WatermarkUserModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? new WatermarkUserModel(this.nickName, this.logoPath, this.settlementTimeLabel, this.gender, this.locationLabel, this.describeLabel, this.constellationLabel, this.monthLabel, this.dayLabel, this.ageLabel, buildUnknownFields()) : (WatermarkUserModel) iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/model/WatermarkUserModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/WatermarkUserModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "serialVersionUID", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59494);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WatermarkUserModel.class);
        final Syntax syntax = Syntax.PROTO_3;
        ProtoAdapter<WatermarkUserModel> protoAdapter = new ProtoAdapter<WatermarkUserModel>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.tencent.videocut.model.WatermarkUserModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/model.WatermarkUserModel", syntax, (Object) null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, fieldEncoding, orCreateKotlinClass, syntax);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public WatermarkUserModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (WatermarkUserModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = "";
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                String str9 = str8;
                String str10 = str9;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 4:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 5:
                                str5 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 6:
                                str6 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 7:
                                str7 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 8:
                                str8 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 9:
                                str9 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 10:
                                str10 = ProtoAdapter.STRING.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        return new WatermarkUserModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull WatermarkUserModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                if (!Intrinsics.areEqual(value.nickName, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.nickName);
                }
                if (!Intrinsics.areEqual(value.logoPath, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.logoPath);
                }
                if (!Intrinsics.areEqual(value.settlementTimeLabel, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.settlementTimeLabel);
                }
                if (!Intrinsics.areEqual(value.gender, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.gender);
                }
                if (!Intrinsics.areEqual(value.locationLabel, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.locationLabel);
                }
                if (!Intrinsics.areEqual(value.describeLabel, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.describeLabel);
                }
                if (!Intrinsics.areEqual(value.constellationLabel, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.constellationLabel);
                }
                if (!Intrinsics.areEqual(value.monthLabel, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.monthLabel);
                }
                if (!Intrinsics.areEqual(value.dayLabel, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 9, value.dayLabel);
                }
                if (!Intrinsics.areEqual(value.ageLabel, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 10, value.ageLabel);
                }
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull WatermarkUserModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                int size = value.unknownFields().size();
                if (!Intrinsics.areEqual(value.nickName, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.nickName);
                }
                if (!Intrinsics.areEqual(value.logoPath, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(2, value.logoPath);
                }
                if (!Intrinsics.areEqual(value.settlementTimeLabel, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(3, value.settlementTimeLabel);
                }
                if (!Intrinsics.areEqual(value.gender, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(4, value.gender);
                }
                if (!Intrinsics.areEqual(value.locationLabel, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(5, value.locationLabel);
                }
                if (!Intrinsics.areEqual(value.describeLabel, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(6, value.describeLabel);
                }
                if (!Intrinsics.areEqual(value.constellationLabel, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(7, value.constellationLabel);
                }
                if (!Intrinsics.areEqual(value.monthLabel, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(8, value.monthLabel);
                }
                if (!Intrinsics.areEqual(value.dayLabel, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(9, value.dayLabel);
                }
                return !Intrinsics.areEqual(value.ageLabel, "") ? size + ProtoAdapter.STRING.encodedSizeWithTag(10, value.ageLabel) : size;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public WatermarkUserModel redact(@NotNull WatermarkUserModel value) {
                WatermarkUserModel copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (WatermarkUserModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                copy = value.copy((r24 & 1) != 0 ? value.nickName : null, (r24 & 2) != 0 ? value.logoPath : null, (r24 & 4) != 0 ? value.settlementTimeLabel : null, (r24 & 8) != 0 ? value.gender : null, (r24 & 16) != 0 ? value.locationLabel : null, (r24 & 32) != 0 ? value.describeLabel : null, (r24 & 64) != 0 ? value.constellationLabel : null, (r24 & 128) != 0 ? value.monthLabel : null, (r24 & 256) != 0 ? value.dayLabel : null, (r24 & 512) != 0 ? value.ageLabel : null, (r24 & 1024) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public WatermarkUserModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @NotNull
    public final WatermarkUserModel copy(@NotNull String nickName, @NotNull String logoPath, @NotNull String settlementTimeLabel, @NotNull String gender, @NotNull String locationLabel, @NotNull String describeLabel, @NotNull String constellationLabel, @NotNull String monthLabel, @NotNull String dayLabel, @NotNull String ageLabel, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (WatermarkUserModel) iPatchRedirector.redirect((short) 7, this, nickName, logoPath, settlementTimeLabel, gender, locationLabel, describeLabel, constellationLabel, monthLabel, dayLabel, ageLabel, unknownFields);
        }
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(logoPath, "logoPath");
        Intrinsics.checkNotNullParameter(settlementTimeLabel, "settlementTimeLabel");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(locationLabel, "locationLabel");
        Intrinsics.checkNotNullParameter(describeLabel, "describeLabel");
        Intrinsics.checkNotNullParameter(constellationLabel, "constellationLabel");
        Intrinsics.checkNotNullParameter(monthLabel, "monthLabel");
        Intrinsics.checkNotNullParameter(dayLabel, "dayLabel");
        Intrinsics.checkNotNullParameter(ageLabel, "ageLabel");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new WatermarkUserModel(nickName, logoPath, settlementTimeLabel, gender, locationLabel, describeLabel, constellationLabel, monthLabel, dayLabel, ageLabel, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof WatermarkUserModel)) {
            return false;
        }
        WatermarkUserModel watermarkUserModel = (WatermarkUserModel) other;
        if (Intrinsics.areEqual(unknownFields(), watermarkUserModel.unknownFields()) && Intrinsics.areEqual(this.nickName, watermarkUserModel.nickName) && Intrinsics.areEqual(this.logoPath, watermarkUserModel.logoPath) && Intrinsics.areEqual(this.settlementTimeLabel, watermarkUserModel.settlementTimeLabel) && Intrinsics.areEqual(this.gender, watermarkUserModel.gender) && Intrinsics.areEqual(this.locationLabel, watermarkUserModel.locationLabel) && Intrinsics.areEqual(this.describeLabel, watermarkUserModel.describeLabel) && Intrinsics.areEqual(this.constellationLabel, watermarkUserModel.constellationLabel) && Intrinsics.areEqual(this.monthLabel, watermarkUserModel.monthLabel) && Intrinsics.areEqual(this.dayLabel, watermarkUserModel.dayLabel) && Intrinsics.areEqual(this.ageLabel, watermarkUserModel.ageLabel)) {
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
            int hashCode = (((((((((((((((((((unknownFields().hashCode() * 37) + this.nickName.hashCode()) * 37) + this.logoPath.hashCode()) * 37) + this.settlementTimeLabel.hashCode()) * 37) + this.gender.hashCode()) * 37) + this.locationLabel.hashCode()) * 37) + this.describeLabel.hashCode()) * 37) + this.constellationLabel.hashCode()) * 37) + this.monthLabel.hashCode()) * 37) + this.dayLabel.hashCode()) * 37) + this.ageLabel.hashCode();
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
        arrayList.add("nickName=" + Internal.sanitize(this.nickName));
        arrayList.add("logoPath=" + Internal.sanitize(this.logoPath));
        arrayList.add("settlementTimeLabel=" + Internal.sanitize(this.settlementTimeLabel));
        arrayList.add("gender=" + Internal.sanitize(this.gender));
        arrayList.add("locationLabel=" + Internal.sanitize(this.locationLabel));
        arrayList.add("describeLabel=" + Internal.sanitize(this.describeLabel));
        arrayList.add("constellationLabel=" + Internal.sanitize(this.constellationLabel));
        arrayList.add("monthLabel=" + Internal.sanitize(this.monthLabel));
        arrayList.add("dayLabel=" + Internal.sanitize(this.dayLabel));
        arrayList.add("ageLabel=" + Internal.sanitize(this.ageLabel));
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "WatermarkUserModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ WatermarkUserModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "" : str10, (i3 & 1024) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.nickName = this.nickName;
        builder.logoPath = this.logoPath;
        builder.settlementTimeLabel = this.settlementTimeLabel;
        builder.gender = this.gender;
        builder.locationLabel = this.locationLabel;
        builder.describeLabel = this.describeLabel;
        builder.constellationLabel = this.constellationLabel;
        builder.monthLabel = this.monthLabel;
        builder.dayLabel = this.dayLabel;
        builder.ageLabel = this.ageLabel;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatermarkUserModel(@NotNull String nickName, @NotNull String logoPath, @NotNull String settlementTimeLabel, @NotNull String gender, @NotNull String locationLabel, @NotNull String describeLabel, @NotNull String constellationLabel, @NotNull String monthLabel, @NotNull String dayLabel, @NotNull String ageLabel, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(logoPath, "logoPath");
        Intrinsics.checkNotNullParameter(settlementTimeLabel, "settlementTimeLabel");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(locationLabel, "locationLabel");
        Intrinsics.checkNotNullParameter(describeLabel, "describeLabel");
        Intrinsics.checkNotNullParameter(constellationLabel, "constellationLabel");
        Intrinsics.checkNotNullParameter(monthLabel, "monthLabel");
        Intrinsics.checkNotNullParameter(dayLabel, "dayLabel");
        Intrinsics.checkNotNullParameter(ageLabel, "ageLabel");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, nickName, logoPath, settlementTimeLabel, gender, locationLabel, describeLabel, constellationLabel, monthLabel, dayLabel, ageLabel, unknownFields);
            return;
        }
        this.nickName = nickName;
        this.logoPath = logoPath;
        this.settlementTimeLabel = settlementTimeLabel;
        this.gender = gender;
        this.locationLabel = locationLabel;
        this.describeLabel = describeLabel;
        this.constellationLabel = constellationLabel;
        this.monthLabel = monthLabel;
        this.dayLabel = dayLabel;
        this.ageLabel = ageLabel;
    }
}
