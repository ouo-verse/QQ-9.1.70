package com.tencent.tavcut.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ0\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/tavcut/model/LayerMarkData;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/LayerMarkData$Builder;", "startTimeUs", "", "durationUs", "desc", "", "unknownFields", "Lokio/ByteString;", "(JJLjava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LayerMarkData extends AndroidMessage<LayerMarkData, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<LayerMarkData> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LayerMarkData> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @Nullable
    public final String desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 2)
    @JvmField
    public final long durationUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 1)
    @JvmField
    public final long startTimeUs;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/model/LayerMarkData$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/LayerMarkData;", "()V", "desc", "", "durationUs", "", "Ljava/lang/Long;", "startTimeUs", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<LayerMarkData, Builder> {

        @JvmField
        @Nullable
        public String desc;

        @JvmField
        @Nullable
        public Long durationUs;

        @JvmField
        @Nullable
        public Long startTimeUs;

        @NotNull
        public final Builder desc(@Nullable String desc) {
            this.desc = desc;
            return this;
        }

        @NotNull
        public final Builder durationUs(long durationUs) {
            this.durationUs = Long.valueOf(durationUs);
            return this;
        }

        @NotNull
        public final Builder startTimeUs(long startTimeUs) {
            this.startTimeUs = Long.valueOf(startTimeUs);
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public LayerMarkData build() {
            Long l3 = this.startTimeUs;
            if (l3 != null) {
                long longValue = l3.longValue();
                Long l16 = this.durationUs;
                if (l16 != null) {
                    return new LayerMarkData(longValue, l16.longValue(), this.desc, buildUnknownFields());
                }
                throw Internal.missingRequiredFields(l16, "durationUs");
            }
            throw Internal.missingRequiredFields(l3, "startTimeUs");
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LayerMarkData.class);
        final String str = "type.googleapis.com/publisher.LayerMarkData";
        ProtoAdapter<LayerMarkData> protoAdapter = new ProtoAdapter<LayerMarkData>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.LayerMarkData$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public LayerMarkData decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Long l3 = null;
                Long l16 = null;
                String str2 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        break;
                    }
                    if (nextTag == 1) {
                        l3 = ProtoAdapter.INT64.decode(reader);
                    } else if (nextTag == 2) {
                        l16 = ProtoAdapter.INT64.decode(reader);
                    } else if (nextTag != 3) {
                        reader.readUnknownField(nextTag);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
                ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                if (l3 != null) {
                    long longValue = l3.longValue();
                    if (l16 != null) {
                        return new LayerMarkData(longValue, l16.longValue(), str2, endMessageAndGetUnknownFields);
                    }
                    throw Internal.missingRequiredFields(l16, "durationUs");
                }
                throw Internal.missingRequiredFields(l3, "startTimeUs");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull LayerMarkData value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                protoAdapter2.encodeWithTag(writer, 1, Long.valueOf(value.startTimeUs));
                protoAdapter2.encodeWithTag(writer, 2, Long.valueOf(value.durationUs));
                ProtoAdapter.STRING.encodeWithTag(writer, 3, value.desc);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull LayerMarkData value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                return protoAdapter2.encodedSizeWithTag(1, Long.valueOf(value.startTimeUs)) + protoAdapter2.encodedSizeWithTag(2, Long.valueOf(value.durationUs)) + ProtoAdapter.STRING.encodedSizeWithTag(3, value.desc) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public LayerMarkData redact(@NotNull LayerMarkData value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return LayerMarkData.copy$default(value, 0L, 0L, null, ByteString.EMPTY, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public /* synthetic */ LayerMarkData(long j3, long j16, String str, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j16, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? ByteString.EMPTY : byteString);
    }

    public static /* synthetic */ LayerMarkData copy$default(LayerMarkData layerMarkData, long j3, long j16, String str, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = layerMarkData.startTimeUs;
        }
        long j17 = j3;
        if ((i3 & 2) != 0) {
            j16 = layerMarkData.durationUs;
        }
        long j18 = j16;
        if ((i3 & 4) != 0) {
            str = layerMarkData.desc;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            byteString = layerMarkData.unknownFields();
        }
        return layerMarkData.copy(j17, j18, str2, byteString);
    }

    @NotNull
    public final LayerMarkData copy(long startTimeUs, long durationUs, @Nullable String desc, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new LayerMarkData(startTimeUs, durationUs, desc, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof LayerMarkData)) {
            return false;
        }
        LayerMarkData layerMarkData = (LayerMarkData) other;
        if (Intrinsics.areEqual(unknownFields(), layerMarkData.unknownFields()) && this.startTimeUs == layerMarkData.startTimeUs && this.durationUs == layerMarkData.durationUs && Intrinsics.areEqual(this.desc, layerMarkData.desc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + a.a(this.startTimeUs)) * 37) + a.a(this.durationUs)) * 37;
            String str = this.desc;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        arrayList.add("startTimeUs=" + this.startTimeUs);
        arrayList.add("durationUs=" + this.durationUs);
        if (this.desc != null) {
            arrayList.add("desc=" + Internal.sanitize(this.desc));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "LayerMarkData{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerMarkData(long j3, long j16, @Nullable String str, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.startTimeUs = j3;
        this.durationUs = j16;
        this.desc = str;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.startTimeUs = Long.valueOf(this.startTimeUs);
        builder.durationUs = Long.valueOf(this.durationUs);
        builder.desc = this.desc;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
