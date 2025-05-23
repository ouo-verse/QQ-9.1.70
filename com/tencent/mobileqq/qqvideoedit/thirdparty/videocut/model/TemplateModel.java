package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001e\u001f !Be\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016Jd\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "path", "name", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "audioModel", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$FontInfo;", "fontInfo", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$AiInfo;", "aiInfo", "Lokio/ByteString;", "unknownFields", "copy", "Ljava/lang/String;", "Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lokio/ByteString;)V", "Companion", "AiInfo", "a", "c", "FontInfo", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TemplateModel extends AndroidMessage<TemplateModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<TemplateModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TemplateModel> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TemplateModel$AiInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    @JvmField
    @NotNull
    public final List<AiInfo> aiInfo;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    @JvmField
    @NotNull
    public final List<AudioModel> audioModel;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TemplateModel$FontInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
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
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B%\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$AiInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$AiInfo$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "path", "agent", "Lokio/ByteString;", "unknownFields", "copy", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class AiInfo extends AndroidMessage<AiInfo, a> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<AiInfo> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<AiInfo> CREATOR;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
        @JvmField
        @NotNull
        public final String agent;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        @JvmField
        @NotNull
        public final String path;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$AiInfo$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$AiInfo;", "a", "", "Ljava/lang/String;", "path", "b", "agent", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends Message.Builder<AiInfo, a> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @JvmField
            @NotNull
            public String path = "";

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @JvmField
            @NotNull
            public String agent = "";

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AiInfo build() {
                return new AiInfo(this.path, this.agent, buildUnknownFields());
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$AiInfo$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$AiInfo;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class b extends ProtoAdapter<AiInfo> {
            b(FieldEncoding fieldEncoding, KClass<AiInfo> kClass) {
                super(fieldEncoding, kClass, "type.googleapis.com/publisher.TemplateModel.AiInfo");
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AiInfo decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = "";
                String str2 = "";
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        if (nextTag != 1) {
                            if (nextTag != 2) {
                                reader.readUnknownField(nextTag);
                            } else {
                                str2 = ProtoAdapter.STRING.decode(reader);
                            }
                        } else {
                            str = ProtoAdapter.STRING.decode(reader);
                        }
                    } else {
                        return new AiInfo(str, str2, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void encode(@NotNull ProtoWriter writer, @NotNull AiInfo value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
                protoAdapter.encodeWithTag(writer, 1, value.path);
                protoAdapter.encodeWithTag(writer, 2, value.agent);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public int encodedSize(@NotNull AiInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
                return protoAdapter.encodedSizeWithTag(1, value.path) + protoAdapter.encodedSizeWithTag(2, value.agent) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public AiInfo redact(@NotNull AiInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return AiInfo.copy$default(value, null, null, ByteString.EMPTY, 3, null);
            }
        }

        static {
            b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AiInfo.class));
            ADAPTER = bVar;
            CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
        }

        public AiInfo() {
            this(null, null, null, 7, null);
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
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public a newBuilder() {
            a aVar = new a();
            aVar.path = this.path;
            aVar.agent = this.agent;
            aVar.addUnknownFields(unknownFields());
            return aVar;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AiInfo(@NotNull String path, @NotNull String agent, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(agent, "agent");
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            this.path = path;
            this.agent = agent;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B5\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J4\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$FontInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$FontInfo$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "name", "style", "path", "Lokio/ByteString;", "unknownFields", "copy", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class FontInfo extends AndroidMessage<FontInfo, a> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<FontInfo> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<FontInfo> CREATOR;

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
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$FontInfo$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$FontInfo;", "a", "", "Ljava/lang/String;", "name", "b", "style", "c", "path", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends Message.Builder<FontInfo, a> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @JvmField
            @Nullable
            public String name;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @JvmField
            @Nullable
            public String style;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @JvmField
            @Nullable
            public String path;

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public FontInfo build() {
                return new FontInfo(this.name, this.style, this.path, buildUnknownFields());
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$FontInfo$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$FontInfo;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class b extends ProtoAdapter<FontInfo> {
            b(FieldEncoding fieldEncoding, KClass<FontInfo> kClass) {
                super(fieldEncoding, kClass, "type.googleapis.com/publisher.TemplateModel.FontInfo");
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public FontInfo decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = null;
                String str2 = null;
                String str3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        if (nextTag != 1) {
                            if (nextTag != 2) {
                                if (nextTag != 3) {
                                    reader.readUnknownField(nextTag);
                                } else {
                                    str3 = ProtoAdapter.STRING.decode(reader);
                                }
                            } else {
                                str2 = ProtoAdapter.STRING.decode(reader);
                            }
                        } else {
                            str = ProtoAdapter.STRING.decode(reader);
                        }
                    } else {
                        return new FontInfo(str, str2, str3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void encode(@NotNull ProtoWriter writer, @NotNull FontInfo value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
                protoAdapter.encodeWithTag(writer, 1, value.name);
                protoAdapter.encodeWithTag(writer, 2, value.style);
                protoAdapter.encodeWithTag(writer, 3, value.path);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public int encodedSize(@NotNull FontInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
                return protoAdapter.encodedSizeWithTag(1, value.name) + protoAdapter.encodedSizeWithTag(2, value.style) + protoAdapter.encodedSizeWithTag(3, value.path) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public FontInfo redact(@NotNull FontInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return FontInfo.copy$default(value, null, null, null, ByteString.EMPTY, 7, null);
            }
        }

        static {
            b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FontInfo.class));
            ADAPTER = bVar;
            CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
        }

        public FontInfo() {
            this(null, null, null, null, 15, null);
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
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            return new FontInfo(name, style, path, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
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
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? ByteString.EMPTY : byteString);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public a newBuilder() {
            a aVar = new a();
            aVar.name = this.name;
            aVar.style = this.style;
            aVar.path = this.path;
            aVar.addUnknownFields(unknownFields());
            return aVar;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FontInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            this.name = str;
            this.style = str2;
            this.path = str3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;", "a", "", "Ljava/lang/String;", "id", "b", "path", "c", "name", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "d", "Ljava/util/List;", "audioModel", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$FontInfo;", "e", "fontInfo", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$AiInfo;", "f", "aiInfo", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<TemplateModel, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String path;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String name;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public List<AudioModel> audioModel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public List<FontInfo> fontInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public List<AiInfo> aiInfo;

        public a() {
            List<AudioModel> emptyList;
            List<FontInfo> emptyList2;
            List<AiInfo> emptyList3;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.audioModel = emptyList;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.fontInfo = emptyList2;
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            this.aiInfo = emptyList3;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TemplateModel build() {
            return new TemplateModel(this.id, this.path, this.name, this.audioModel, this.fontInfo, this.aiInfo, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<TemplateModel> {
        b(FieldEncoding fieldEncoding, KClass<TemplateModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.TemplateModel");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TemplateModel decode(@NotNull ProtoReader reader) {
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
                            arrayList2.add(FontInfo.ADAPTER.decode(reader));
                            break;
                        case 6:
                            arrayList3.add(AiInfo.ADAPTER.decode(reader));
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
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull TemplateModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.id);
            protoAdapter.encodeWithTag(writer, 2, value.path);
            protoAdapter.encodeWithTag(writer, 3, value.name);
            AudioModel.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.audioModel);
            FontInfo.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.fontInfo);
            AiInfo.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.aiInfo);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull TemplateModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, value.id) + protoAdapter.encodedSizeWithTag(2, value.path) + protoAdapter.encodedSizeWithTag(3, value.name) + AudioModel.ADAPTER.asRepeated().encodedSizeWithTag(4, value.audioModel) + FontInfo.ADAPTER.asRepeated().encodedSizeWithTag(5, value.fontInfo) + AiInfo.ADAPTER.asRepeated().encodedSizeWithTag(6, value.aiInfo) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public TemplateModel redact(@NotNull TemplateModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return TemplateModel.copy$default(value, null, null, null, Internal.m87redactElements(value.audioModel, AudioModel.ADAPTER), Internal.m87redactElements(value.fontInfo, FontInfo.ADAPTER), Internal.m87redactElements(value.aiInfo, AiInfo.ADAPTER), ByteString.EMPTY, 7, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TemplateModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public TemplateModel() {
        this(null, null, null, null, null, null, null, 127, null);
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
        Intrinsics.checkNotNullParameter(audioModel, "audioModel");
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        Intrinsics.checkNotNullParameter(aiInfo, "aiInfo");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new TemplateModel(id5, path, name, audioModel, fontInfo, aiInfo, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
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

    public /* synthetic */ TemplateModel(String str, String str2, String str3, List list, List list2, List list3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) == 0 ? str3 : null, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.path = this.path;
        aVar.name = this.name;
        aVar.audioModel = this.audioModel;
        aVar.fontInfo = this.fontInfo;
        aVar.aiInfo = this.aiInfo;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull List<AudioModel> audioModel, @NotNull List<FontInfo> fontInfo, @NotNull List<AiInfo> aiInfo, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(audioModel, "audioModel");
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        Intrinsics.checkNotNullParameter(aiInfo, "aiInfo");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.id = str;
        this.path = str2;
        this.name = str3;
        this.audioModel = audioModel;
        this.fontInfo = fontInfo;
        this.aiInfo = aiInfo;
    }
}
