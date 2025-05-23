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
import com.tencent.videocut.model.TemplateModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001a\u001b\u001c\u001dBc\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010Jd\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TemplateModel$Builder;", "id", "", "path", "name", "audioModel", "", "Lcom/tencent/videocut/model/AudioModel;", "fontInfo", "Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "aiInfo", "Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "AiInfo", "Builder", "Companion", "FontInfo", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TemplateModel extends AndroidMessage<TemplateModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<TemplateModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TemplateModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.tencent.videocut.model.TemplateModel$AiInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    @JvmField
    @NotNull
    public final List<AiInfo> aiInfo;

    @WireField(adapter = "com.tencent.videocut.model.AudioModel#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    @JvmField
    @NotNull
    public final List<AudioModel> audioModel;

    @WireField(adapter = "com.tencent.videocut.model.TemplateModel$FontInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    @JvmField
    @NotNull
    public final List<FontInfo> fontInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @Nullable
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String path;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TemplateModel$AiInfo$Builder;", "path", "", "agent", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class AiInfo extends AndroidMessage<AiInfo, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<AiInfo> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<AiInfo> CREATOR;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
        @JvmField
        @NotNull
        public final String agent;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        @JvmField
        @NotNull
        public final String path;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel$AiInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "()V", "agent", "", "path", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Builder extends Message.Builder<AiInfo, Builder> {
            static IPatchRedirector $redirector_;

            @JvmField
            @NotNull
            public String agent;

            @JvmField
            @NotNull
            public String path;

            public Builder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.path = "";
                    this.agent = "";
                }
            }

            @NotNull
            public final Builder agent(@Nullable String agent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) agent);
                }
                if (agent == null) {
                    agent = "";
                }
                this.agent = agent;
                return this;
            }

            @NotNull
            public final Builder path(@Nullable String path) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
                }
                if (path == null) {
                    path = "";
                }
                this.path = path;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public AiInfo build() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new AiInfo(this.path, this.agent, buildUnknownFields()) : (AiInfo) iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel$AiInfo$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59238);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
                return;
            }
            INSTANCE = new Companion(null);
            final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AiInfo.class);
            ProtoAdapter<AiInfo> protoAdapter = new ProtoAdapter<AiInfo>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.TemplateModel$AiInfo$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.TemplateModel.AiInfo");
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public TemplateModel.AiInfo decode(@NotNull ProtoReader reader) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return (TemplateModel.AiInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                    }
                    Intrinsics.checkNotNullParameter(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    String str = "";
                    String str2 = "";
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new TemplateModel.AiInfo(str, str2, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                        if (nextTag == 1) {
                            str = ProtoAdapter.STRING.decode(reader);
                        } else if (nextTag != 2) {
                            reader.readUnknownField(nextTag);
                        } else {
                            str2 = ProtoAdapter.STRING.decode(reader);
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull TemplateModel.AiInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(writer, "writer");
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    protoAdapter2.encodeWithTag(writer, 1, value.path);
                    protoAdapter2.encodeWithTag(writer, 2, value.agent);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull TemplateModel.AiInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    return protoAdapter2.encodedSizeWithTag(1, value.path) + protoAdapter2.encodedSizeWithTag(2, value.agent) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public TemplateModel.AiInfo redact(@NotNull TemplateModel.AiInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return (TemplateModel.AiInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    return TemplateModel.AiInfo.copy$default(value, null, null, ByteString.EMPTY, 3, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public AiInfo() {
            this(null, null, null, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this);
        }

        public static /* synthetic */ AiInfo copy$default(AiInfo aiInfo, String str, String str2, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = aiInfo.path;
            }
            if ((i3 & 2) != 0) {
                str2 = aiInfo.agent;
            }
            if ((i3 & 4) != 0) {
                byteString = aiInfo.unknownFields();
            }
            return aiInfo.copy(str, str2, byteString);
        }

        @NotNull
        public final AiInfo copy(@Nullable String path, @Nullable String agent, @NotNull ByteString unknownFields) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (AiInfo) iPatchRedirector.redirect((short) 7, this, path, agent, unknownFields);
            }
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            if (path == null) {
                path = "";
            }
            if (agent == null) {
                agent = "";
            }
            return new AiInfo(path, agent, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
            }
            if (other == this) {
                return true;
            }
            if (!(other instanceof AiInfo)) {
                return false;
            }
            AiInfo aiInfo = (AiInfo) other;
            if (Intrinsics.areEqual(unknownFields(), aiInfo.unknownFields()) && Intrinsics.areEqual(this.path, aiInfo.path) && Intrinsics.areEqual(this.agent, aiInfo.agent)) {
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
                int hashCode = (((unknownFields().hashCode() * 37) + this.path.hashCode()) * 37) + this.agent.hashCode();
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
            String str = this.path;
            if (str != null) {
                arrayList.add("path=" + Internal.sanitize(str));
            }
            String str2 = this.agent;
            if (str2 != null) {
                arrayList.add("agent=" + Internal.sanitize(str2));
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "AiInfo{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ AiInfo(String str, String str2, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) == 0 ? str2 : "", (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, str2, byteString, Integer.valueOf(i3), defaultConstructorMarker);
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
            builder.agent = this.agent;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AiInfo(@NotNull String path, @NotNull String agent, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(agent, "agent");
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, path, agent, unknownFields);
            } else {
                this.path = path;
                this.agent = agent;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\fR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TemplateModel;", "()V", "aiInfo", "", "Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "audioModel", "Lcom/tencent/videocut/model/AudioModel;", "fontInfo", "Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "id", "", "name", "path", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<TemplateModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public List<AiInfo> aiInfo;

        @JvmField
        @NotNull
        public List<AudioModel> audioModel;

        @JvmField
        @NotNull
        public List<FontInfo> fontInfo;

        @JvmField
        @Nullable
        public String id;

        @JvmField
        @Nullable
        public String name;

        @JvmField
        @Nullable
        public String path;

        public Builder() {
            List<AudioModel> emptyList;
            List<FontInfo> emptyList2;
            List<AiInfo> emptyList3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.audioModel = emptyList;
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                this.fontInfo = emptyList2;
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                this.aiInfo = emptyList3;
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @NotNull
        public final Builder aiInfo(@NotNull List<AiInfo> aiInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) aiInfo);
            }
            Intrinsics.checkNotNullParameter(aiInfo, "aiInfo");
            Internal.checkElementsNotNull(aiInfo);
            this.aiInfo = aiInfo;
            return this;
        }

        @NotNull
        public final Builder audioModel(@NotNull List<AudioModel> audioModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) audioModel);
            }
            Intrinsics.checkNotNullParameter(audioModel, "audioModel");
            Internal.checkElementsNotNull(audioModel);
            this.audioModel = audioModel;
            return this;
        }

        @NotNull
        public final Builder fontInfo(@NotNull List<FontInfo> fontInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) fontInfo);
            }
            Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
            Internal.checkElementsNotNull(fontInfo);
            this.fontInfo = fontInfo;
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
        public final Builder name(@Nullable String name) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) name);
            }
            this.name = name;
            return this;
        }

        @NotNull
        public final Builder path(@Nullable String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
            }
            this.path = path;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public TemplateModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? new TemplateModel(this.id, this.path, this.name, this.audioModel, this.fontInfo, this.aiInfo, buildUnknownFields()) : (TemplateModel) iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TemplateModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TemplateModel$FontInfo$Builder;", "name", "", "style", "path", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class FontInfo extends AndroidMessage<FontInfo, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<FontInfo> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<FontInfo> CREATOR;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        @JvmField
        @Nullable
        public final String name;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
        @JvmField
        @Nullable
        public final String path;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
        @JvmField
        @Nullable
        public final String style;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel$FontInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "()V", "name", "", "path", "style", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Builder extends Message.Builder<FontInfo, Builder> {
            static IPatchRedirector $redirector_;

            @JvmField
            @Nullable
            public String name;

            @JvmField
            @Nullable
            public String path;

            @JvmField
            @Nullable
            public String style;

            public Builder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
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
            public final Builder path(@Nullable String path) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) path);
                }
                this.path = path;
                return this;
            }

            @NotNull
            public final Builder style(@Nullable String style) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) style);
                }
                this.style = style;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public FontInfo build() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new FontInfo(this.name, this.style, this.path, buildUnknownFields()) : (FontInfo) iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/TemplateModel$FontInfo$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59288);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
                return;
            }
            INSTANCE = new Companion(null);
            final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FontInfo.class);
            ProtoAdapter<FontInfo> protoAdapter = new ProtoAdapter<FontInfo>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.TemplateModel$FontInfo$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.TemplateModel.FontInfo");
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public TemplateModel.FontInfo decode(@NotNull ProtoReader reader) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return (TemplateModel.FontInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                    }
                    Intrinsics.checkNotNullParameter(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new TemplateModel.FontInfo(str, str2, str3, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                        if (nextTag == 1) {
                            str = ProtoAdapter.STRING.decode(reader);
                        } else if (nextTag == 2) {
                            str2 = ProtoAdapter.STRING.decode(reader);
                        } else if (nextTag != 3) {
                            reader.readUnknownField(nextTag);
                        } else {
                            str3 = ProtoAdapter.STRING.decode(reader);
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull TemplateModel.FontInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(writer, "writer");
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    protoAdapter2.encodeWithTag(writer, 1, value.name);
                    protoAdapter2.encodeWithTag(writer, 2, value.style);
                    protoAdapter2.encodeWithTag(writer, 3, value.path);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull TemplateModel.FontInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    return protoAdapter2.encodedSizeWithTag(1, value.name) + protoAdapter2.encodedSizeWithTag(2, value.style) + protoAdapter2.encodedSizeWithTag(3, value.path) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public TemplateModel.FontInfo redact(@NotNull TemplateModel.FontInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return (TemplateModel.FontInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    return TemplateModel.FontInfo.copy$default(value, null, null, null, ByteString.EMPTY, 7, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public FontInfo() {
            this(null, null, null, null, 15, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this);
        }

        public static /* synthetic */ FontInfo copy$default(FontInfo fontInfo, String str, String str2, String str3, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = fontInfo.name;
            }
            if ((i3 & 2) != 0) {
                str2 = fontInfo.style;
            }
            if ((i3 & 4) != 0) {
                str3 = fontInfo.path;
            }
            if ((i3 & 8) != 0) {
                byteString = fontInfo.unknownFields();
            }
            return fontInfo.copy(str, str2, str3, byteString);
        }

        @NotNull
        public final FontInfo copy(@Nullable String name, @Nullable String style, @Nullable String path, @NotNull ByteString unknownFields) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (FontInfo) iPatchRedirector.redirect((short) 7, this, name, style, path, unknownFields);
            }
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            return new FontInfo(name, style, path, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
            }
            if (other == this) {
                return true;
            }
            if (!(other instanceof FontInfo)) {
                return false;
            }
            FontInfo fontInfo = (FontInfo) other;
            if (Intrinsics.areEqual(unknownFields(), fontInfo.unknownFields()) && Intrinsics.areEqual(this.name, fontInfo.name) && Intrinsics.areEqual(this.style, fontInfo.style) && Intrinsics.areEqual(this.path, fontInfo.path)) {
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
                int hashCode = unknownFields().hashCode() * 37;
                String str = this.name;
                int i18 = 0;
                if (str != null) {
                    i3 = str.hashCode();
                } else {
                    i3 = 0;
                }
                int i19 = (hashCode + i3) * 37;
                String str2 = this.style;
                if (str2 != null) {
                    i16 = str2.hashCode();
                } else {
                    i16 = 0;
                }
                int i26 = (i19 + i16) * 37;
                String str3 = this.path;
                if (str3 != null) {
                    i18 = str3.hashCode();
                }
                int i27 = i26 + i18;
                this.hashCode = i27;
                return i27;
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
            String str2 = this.style;
            if (str2 != null) {
                arrayList.add("style=" + Internal.sanitize(str2));
            }
            String str3 = this.path;
            if (str3 != null) {
                arrayList.add("path=" + Internal.sanitize(str3));
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "FontInfo{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ FontInfo(String str, String str2, String str3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) == 0 ? str3 : null, (i3 & 8) != 0 ? ByteString.EMPTY : byteString);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, byteString, Integer.valueOf(i3), defaultConstructorMarker);
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
            builder.style = this.style;
            builder.path = this.path;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FontInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, unknownFields);
                return;
            }
            this.name = str;
            this.style = str2;
            this.path = str3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59296);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TemplateModel.class);
        ProtoAdapter<TemplateModel> protoAdapter = new ProtoAdapter<TemplateModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.TemplateModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.TemplateModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TemplateModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (TemplateModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                long beginMessage = reader.beginMessage();
                String str = null;
                String str2 = null;
                String str3 = null;
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
                                arrayList.add(AudioModel.ADAPTER.decode(reader));
                                break;
                            case 5:
                                arrayList2.add(TemplateModel.FontInfo.ADAPTER.decode(reader));
                                break;
                            case 6:
                                arrayList3.add(TemplateModel.AiInfo.ADAPTER.decode(reader));
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        return new TemplateModel(str, str2, str3, arrayList, arrayList2, arrayList3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull TemplateModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.id);
                protoAdapter2.encodeWithTag(writer, 2, value.path);
                protoAdapter2.encodeWithTag(writer, 3, value.name);
                AudioModel.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.audioModel);
                TemplateModel.FontInfo.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.fontInfo);
                TemplateModel.AiInfo.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.aiInfo);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull TemplateModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return protoAdapter2.encodedSizeWithTag(1, value.id) + protoAdapter2.encodedSizeWithTag(2, value.path) + protoAdapter2.encodedSizeWithTag(3, value.name) + AudioModel.ADAPTER.asRepeated().encodedSizeWithTag(4, value.audioModel) + TemplateModel.FontInfo.ADAPTER.asRepeated().encodedSizeWithTag(5, value.fontInfo) + TemplateModel.AiInfo.ADAPTER.asRepeated().encodedSizeWithTag(6, value.aiInfo) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TemplateModel redact(@NotNull TemplateModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (TemplateModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                return TemplateModel.copy$default(value, null, null, null, Internal.m87redactElements(value.audioModel, AudioModel.ADAPTER), Internal.m87redactElements(value.fontInfo, TemplateModel.FontInfo.ADAPTER), Internal.m87redactElements(value.aiInfo, TemplateModel.AiInfo.ADAPTER), ByteString.EMPTY, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public TemplateModel() {
        this(null, null, null, null, null, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ TemplateModel copy$default(TemplateModel templateModel, String str, String str2, String str3, List list, List list2, List list3, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = templateModel.id;
        }
        if ((i3 & 2) != 0) {
            str2 = templateModel.path;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = templateModel.name;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            list = templateModel.audioModel;
        }
        List list4 = list;
        if ((i3 & 16) != 0) {
            list2 = templateModel.fontInfo;
        }
        List list5 = list2;
        if ((i3 & 32) != 0) {
            list3 = templateModel.aiInfo;
        }
        List list6 = list3;
        if ((i3 & 64) != 0) {
            byteString = templateModel.unknownFields();
        }
        return templateModel.copy(str, str4, str5, list4, list5, list6, byteString);
    }

    @NotNull
    public final TemplateModel copy(@Nullable String id5, @Nullable String path, @Nullable String name, @NotNull List<AudioModel> audioModel, @NotNull List<FontInfo> fontInfo, @NotNull List<AiInfo> aiInfo, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TemplateModel) iPatchRedirector.redirect((short) 7, this, id5, path, name, audioModel, fontInfo, aiInfo, unknownFields);
        }
        Intrinsics.checkNotNullParameter(audioModel, "audioModel");
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        Intrinsics.checkNotNullParameter(aiInfo, "aiInfo");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new TemplateModel(id5, path, name, audioModel, fontInfo, aiInfo, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof TemplateModel)) {
            return false;
        }
        TemplateModel templateModel = (TemplateModel) other;
        if (Intrinsics.areEqual(unknownFields(), templateModel.unknownFields()) && Intrinsics.areEqual(this.id, templateModel.id) && Intrinsics.areEqual(this.path, templateModel.path) && Intrinsics.areEqual(this.name, templateModel.name) && Intrinsics.areEqual(this.audioModel, templateModel.audioModel) && Intrinsics.areEqual(this.fontInfo, templateModel.fontInfo) && Intrinsics.areEqual(this.aiInfo, templateModel.aiInfo)) {
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
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.id;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.path;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str3 = this.name;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int hashCode2 = ((((((i26 + i18) * 37) + this.audioModel.hashCode()) * 37) + this.fontInfo.hashCode()) * 37) + this.aiInfo.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
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
        String str2 = this.path;
        if (str2 != null) {
            arrayList.add("path=" + Internal.sanitize(str2));
        }
        String str3 = this.name;
        if (str3 != null) {
            arrayList.add("name=" + Internal.sanitize(str3));
        }
        if (!this.audioModel.isEmpty()) {
            arrayList.add("audioModel=" + this.audioModel);
        }
        if (!this.fontInfo.isEmpty()) {
            arrayList.add("fontInfo=" + this.fontInfo);
        }
        if (!this.aiInfo.isEmpty()) {
            arrayList.add("aiInfo=" + this.aiInfo);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TemplateModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TemplateModel(String str, String str2, String str3, List list, List list2, List list3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r4, r5, r6, r7, r8, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
        List list4;
        List list5;
        List list6;
        List emptyList;
        List emptyList2;
        List emptyList3;
        String str4 = (i3 & 1) != 0 ? null : str;
        String str5 = (i3 & 2) != 0 ? null : str2;
        String str6 = (i3 & 4) != 0 ? null : str3;
        if ((i3 & 8) != 0) {
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList3;
        } else {
            list4 = list;
        }
        if ((i3 & 16) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list5 = emptyList2;
        } else {
            list5 = list2;
        }
        if ((i3 & 32) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list6 = emptyList;
        } else {
            list6 = list3;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, list, list2, list3, byteString, Integer.valueOf(i3), defaultConstructorMarker);
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
        builder.path = this.path;
        builder.name = this.name;
        builder.audioModel = this.audioModel;
        builder.fontInfo = this.fontInfo;
        builder.aiInfo = this.aiInfo;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull List<AudioModel> audioModel, @NotNull List<FontInfo> fontInfo, @NotNull List<AiInfo> aiInfo, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(audioModel, "audioModel");
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        Intrinsics.checkNotNullParameter(aiInfo, "aiInfo");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, audioModel, fontInfo, aiInfo, unknownFields);
            return;
        }
        this.id = str;
        this.path = str2;
        this.name = str3;
        this.audioModel = audioModel;
        this.fontInfo = fontInfo;
        this.aiInfo = aiInfo;
    }
}
