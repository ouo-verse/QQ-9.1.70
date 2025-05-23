package com.tencent.tavcut.composition.model.component;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TimeRange;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/TimeRange$Builder;", "startTime", "", "duration", "unknownFields", "Lokio/ByteString;", "(JJLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TimeRange extends AndroidMessage<TimeRange, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<TimeRange> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TimeRange> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 2)
    @JvmField
    public final long duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 1)
    @JvmField
    public final long startTime;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TimeRange$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "()V", "duration", "", "Ljava/lang/Long;", "startTime", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<TimeRange, Builder> {

        @JvmField
        @Nullable
        public Long duration;

        @JvmField
        @Nullable
        public Long startTime;

        @NotNull
        public final Builder duration(long duration) {
            this.duration = Long.valueOf(duration);
            return this;
        }

        @NotNull
        public final Builder startTime(long startTime) {
            this.startTime = Long.valueOf(startTime);
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public TimeRange build() {
            Long l3 = this.startTime;
            if (l3 != null) {
                long longValue = l3.longValue();
                Long l16 = this.duration;
                if (l16 != null) {
                    return new TimeRange(longValue, l16.longValue(), buildUnknownFields());
                }
                throw Internal.missingRequiredFields(l16, "duration");
            }
            throw Internal.missingRequiredFields(l3, "startTime");
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TimeRange.class);
        final String str = "type.googleapis.com/publisher.TimeRange";
        ProtoAdapter<TimeRange> protoAdapter = new ProtoAdapter<TimeRange>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.TimeRange$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TimeRange decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Long l3 = null;
                Long l16 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        break;
                    }
                    if (nextTag == 1) {
                        l3 = ProtoAdapter.INT64.decode(reader);
                    } else if (nextTag != 2) {
                        reader.readUnknownField(nextTag);
                    } else {
                        l16 = ProtoAdapter.INT64.decode(reader);
                    }
                }
                ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                if (l3 != null) {
                    long longValue = l3.longValue();
                    if (l16 != null) {
                        return new TimeRange(longValue, l16.longValue(), endMessageAndGetUnknownFields);
                    }
                    throw Internal.missingRequiredFields(l16, "duration");
                }
                throw Internal.missingRequiredFields(l3, "startTime");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull TimeRange value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                protoAdapter2.encodeWithTag(writer, 1, Long.valueOf(value.startTime));
                protoAdapter2.encodeWithTag(writer, 2, Long.valueOf(value.duration));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull TimeRange value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                return protoAdapter2.encodedSizeWithTag(1, Long.valueOf(value.startTime)) + protoAdapter2.encodedSizeWithTag(2, Long.valueOf(value.duration)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TimeRange redact(@NotNull TimeRange value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return TimeRange.copy$default(value, 0L, 0L, ByteString.EMPTY, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public /* synthetic */ TimeRange(long j3, long j16, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j16, (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
    }

    public static /* synthetic */ TimeRange copy$default(TimeRange timeRange, long j3, long j16, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = timeRange.startTime;
        }
        long j17 = j3;
        if ((i3 & 2) != 0) {
            j16 = timeRange.duration;
        }
        long j18 = j16;
        if ((i3 & 4) != 0) {
            byteString = timeRange.unknownFields();
        }
        return timeRange.copy(j17, j18, byteString);
    }

    @NotNull
    public final TimeRange copy(long startTime, long duration, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new TimeRange(startTime, duration, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TimeRange)) {
            return false;
        }
        TimeRange timeRange = (TimeRange) other;
        if (Intrinsics.areEqual(unknownFields(), timeRange.unknownFields()) && this.startTime == timeRange.startTime && this.duration == timeRange.duration) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + a.a(this.startTime)) * 37) + a.a(this.duration);
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
        arrayList.add("startTime=" + this.startTime);
        arrayList.add("duration=" + this.duration);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TimeRange{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeRange(long j3, long j16, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.startTime = j3;
        this.duration = j16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.startTime = Long.valueOf(this.startTime);
        builder.duration = Long.valueOf(this.duration);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
