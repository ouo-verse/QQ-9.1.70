package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bBK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJQ\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Timeline;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Timeline$Builder;", "entityID", "", "type", "", DownloaderConstant.KEY_RANGE, "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "time", "", "event", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;Ljava/lang/Long;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;Ljava/lang/Long;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/Timeline;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class Timeline extends AndroidMessage<Timeline, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Timeline> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Timeline> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer entityID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String event;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.TimeRange#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final TimeRange range;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    @Nullable
    public final Long time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Timeline$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "()V", "entityID", "", "Ljava/lang/Integer;", "event", "", DownloaderConstant.KEY_RANGE, "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "time", "", "Ljava/lang/Long;", "type", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/Timeline$Builder;", "(Ljava/lang/Long;)Lcom/tencent/tavcut/composition/model/component/Timeline$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<Timeline, Builder> {

        @JvmField
        @Nullable
        public Integer entityID;

        @JvmField
        @Nullable
        public String event;

        @JvmField
        @Nullable
        public TimeRange range;

        @JvmField
        @Nullable
        public Long time;

        @JvmField
        @Nullable
        public String type;

        @NotNull
        public final Builder entityID(@Nullable Integer entityID) {
            this.entityID = entityID;
            return this;
        }

        @NotNull
        public final Builder event(@Nullable String event) {
            this.event = event;
            return this;
        }

        @NotNull
        public final Builder range(@Nullable TimeRange range) {
            this.range = range;
            return this;
        }

        @NotNull
        public final Builder time(@Nullable Long time) {
            this.time = time;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public Timeline build() {
            return new Timeline(this.entityID, this.type, this.range, this.time, this.event, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Timeline.class);
        final String str = "type.googleapis.com/publisher.Timeline";
        ProtoAdapter<Timeline> protoAdapter = new ProtoAdapter<Timeline>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.Timeline$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Timeline decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                String str2 = null;
                TimeRange timeRange = null;
                Long l3 = null;
                String str3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new Timeline(num, str2, timeRange, l3, str3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 1) {
                        num = ProtoAdapter.INT32.decode(reader);
                    } else if (nextTag == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (nextTag == 3) {
                        timeRange = TimeRange.ADAPTER.decode(reader);
                    } else if (nextTag == 4) {
                        l3 = ProtoAdapter.INT64.decode(reader);
                    } else if (nextTag != 5) {
                        reader.readUnknownField(nextTag);
                    } else {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Timeline value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter.INT32.encodeWithTag(writer, 1, value.entityID);
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 2, value.type);
                TimeRange.ADAPTER.encodeWithTag(writer, 3, value.range);
                ProtoAdapter.INT64.encodeWithTag(writer, 4, value.time);
                protoAdapter2.encodeWithTag(writer, 5, value.event);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Timeline value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                int encodedSizeWithTag = ProtoAdapter.INT32.encodedSizeWithTag(1, value.entityID);
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(2, value.type) + TimeRange.ADAPTER.encodedSizeWithTag(3, value.range) + ProtoAdapter.INT64.encodedSizeWithTag(4, value.time) + protoAdapter2.encodedSizeWithTag(5, value.event) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Timeline redact(@NotNull Timeline value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                TimeRange timeRange = value.range;
                return Timeline.copy$default(value, null, null, timeRange != null ? TimeRange.ADAPTER.redact(timeRange) : null, null, null, ByteString.EMPTY, 27, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public Timeline() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Timeline copy$default(Timeline timeline, Integer num, String str, TimeRange timeRange, Long l3, String str2, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = timeline.entityID;
        }
        if ((i3 & 2) != 0) {
            str = timeline.type;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            timeRange = timeline.range;
        }
        TimeRange timeRange2 = timeRange;
        if ((i3 & 8) != 0) {
            l3 = timeline.time;
        }
        Long l16 = l3;
        if ((i3 & 16) != 0) {
            str2 = timeline.event;
        }
        String str4 = str2;
        if ((i3 & 32) != 0) {
            byteString = timeline.unknownFields();
        }
        return timeline.copy(num, str3, timeRange2, l16, str4, byteString);
    }

    @NotNull
    public final Timeline copy(@Nullable Integer entityID, @Nullable String type, @Nullable TimeRange range, @Nullable Long time, @Nullable String event, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new Timeline(entityID, type, range, time, event, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) other;
        if (Intrinsics.areEqual(unknownFields(), timeline.unknownFields()) && Intrinsics.areEqual(this.entityID, timeline.entityID) && Intrinsics.areEqual(this.type, timeline.type) && Intrinsics.areEqual(this.range, timeline.range) && Intrinsics.areEqual(this.time, timeline.time) && Intrinsics.areEqual(this.event, timeline.event)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityID;
            int i26 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            String str = this.type;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            TimeRange timeRange = this.range;
            if (timeRange != null) {
                i17 = timeRange.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            Long l3 = this.time;
            if (l3 != null) {
                i18 = l3.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str2 = this.event;
            if (str2 != null) {
                i26 = str2.hashCode();
            }
            int i37 = i36 + i26;
            this.hashCode = i37;
            return i37;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.entityID != null) {
            arrayList.add("entityID=" + this.entityID);
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.range != null) {
            arrayList.add("range=" + this.range);
        }
        if (this.time != null) {
            arrayList.add("time=" + this.time);
        }
        if (this.event != null) {
            arrayList.add("event=" + Internal.sanitize(this.event));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Timeline{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ Timeline(Integer num, String str, TimeRange timeRange, Long l3, String str2, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : timeRange, (i3 & 8) != 0 ? null : l3, (i3 & 16) == 0 ? str2 : null, (i3 & 32) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityID = this.entityID;
        builder.type = this.type;
        builder.range = this.range;
        builder.time = this.time;
        builder.event = this.event;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Timeline(@Nullable Integer num, @Nullable String str, @Nullable TimeRange timeRange, @Nullable Long l3, @Nullable String str2, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityID = num;
        this.type = str;
        this.range = timeRange;
        this.time = l3;
        this.event = str2;
    }
}
