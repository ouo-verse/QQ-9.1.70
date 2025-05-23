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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/videocut/model/CoverInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/CoverInfo$Builder;", "path", "", "timeAt", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/Long;Lokio/ByteString;)V", "Ljava/lang/Long;", "copy", "(Ljava/lang/String;Ljava/lang/Long;Lokio/ByteString;)Lcom/tencent/videocut/model/CoverInfo;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class CoverInfo extends AndroidMessage<CoverInfo, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<CoverInfo> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<CoverInfo> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @JvmField
    @Nullable
    public final Long timeAt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\nR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/videocut/model/CoverInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/CoverInfo;", "()V", "path", "", "timeAt", "", "Ljava/lang/Long;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/CoverInfo$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<CoverInfo, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public String path;

        @JvmField
        @Nullable
        public Long timeAt;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder path(@Nullable String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
            }
            this.path = path;
            return this;
        }

        @NotNull
        public final Builder timeAt(@Nullable Long timeAt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) timeAt);
            }
            this.timeAt = timeAt;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public CoverInfo build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new CoverInfo(this.path, this.timeAt, buildUnknownFields()) : (CoverInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/CoverInfo$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/CoverInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58566);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CoverInfo.class);
        ProtoAdapter<CoverInfo> protoAdapter = new ProtoAdapter<CoverInfo>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.CoverInfo$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.CoverInfo");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public CoverInfo decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (CoverInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = null;
                Long l3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new CoverInfo(str, l3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (nextTag != 2) {
                        reader.readUnknownField(nextTag);
                    } else {
                        l3 = ProtoAdapter.INT64.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull CoverInfo value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter.STRING.encodeWithTag(writer, 1, value.path);
                ProtoAdapter.INT64.encodeWithTag(writer, 2, value.timeAt);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull CoverInfo value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                return ProtoAdapter.STRING.encodedSizeWithTag(1, value.path) + ProtoAdapter.INT64.encodedSizeWithTag(2, value.timeAt) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public CoverInfo redact(@NotNull CoverInfo value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (CoverInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                return CoverInfo.copy$default(value, null, null, ByteString.EMPTY, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public CoverInfo() {
        this(null, null, null, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ CoverInfo copy$default(CoverInfo coverInfo, String str, Long l3, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = coverInfo.path;
        }
        if ((i3 & 2) != 0) {
            l3 = coverInfo.timeAt;
        }
        if ((i3 & 4) != 0) {
            byteString = coverInfo.unknownFields();
        }
        return coverInfo.copy(str, l3, byteString);
    }

    @NotNull
    public final CoverInfo copy(@Nullable String path, @Nullable Long timeAt, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CoverInfo) iPatchRedirector.redirect((short) 7, this, path, timeAt, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new CoverInfo(path, timeAt, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof CoverInfo)) {
            return false;
        }
        CoverInfo coverInfo = (CoverInfo) other;
        if (Intrinsics.areEqual(unknownFields(), coverInfo.unknownFields()) && Intrinsics.areEqual(this.path, coverInfo.path) && Intrinsics.areEqual(this.timeAt, coverInfo.timeAt)) {
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
            String str = this.path;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            Long l3 = this.timeAt;
            if (l3 != null) {
                i17 = l3.hashCode();
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
        String str = this.path;
        if (str != null) {
            arrayList.add("path=" + Internal.sanitize(str));
        }
        Long l3 = this.timeAt;
        if (l3 != null) {
            arrayList.add("timeAt=" + l3);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "CoverInfo{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ CoverInfo(String str, Long l3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) == 0 ? l3 : null, (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, l3, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.path = this.path;
        builder.timeAt = this.timeAt;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverInfo(@Nullable String str, @Nullable Long l3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, l3, unknownFields);
        } else {
            this.path = str;
            this.timeAt = l3;
        }
    }
}
