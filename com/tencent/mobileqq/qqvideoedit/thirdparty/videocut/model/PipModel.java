package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB1\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J;\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "mediaClip", "", "startOffset", "timelineIndex", "Lokio/ByteString;", "unknownFields", "copy", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;Ljava/lang/Long;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "J", "I", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;JILokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PipModel extends AndroidMessage<PipModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<PipModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PipModel> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip#ADAPTER", tag = 1)
    @JvmField
    @Nullable
    public final MediaClip mediaClip;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @JvmField
    public final long startOffset;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    public final int timelineIndex;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "a", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "mediaClip", "", "b", "J", "startOffset", "", "c", "Ljava/lang/Integer;", "timelineIndex", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<PipModel, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public MediaClip mediaClip;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long startOffset;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer timelineIndex;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PipModel build() {
            int i3;
            MediaClip mediaClip = this.mediaClip;
            long j3 = this.startOffset;
            Integer num = this.timelineIndex;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            return new PipModel(mediaClip, j3, i3, buildUnknownFields());
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<PipModel> {
        b(FieldEncoding fieldEncoding, KClass<PipModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.PipModel");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PipModel decode(@NotNull ProtoReader reader) {
            int i3;
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            MediaClip mediaClip = null;
            long j3 = 0;
            Integer num = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag == -1) {
                    break;
                }
                if (nextTag != 1) {
                    if (nextTag != 2) {
                        if (nextTag != 3) {
                            reader.readUnknownField(nextTag);
                        } else {
                            num = ProtoAdapter.INT32.decode(reader);
                        }
                    } else {
                        j3 = ProtoAdapter.INT64.decode(reader).longValue();
                    }
                } else {
                    mediaClip = MediaClip.ADAPTER.decode(reader);
                }
            }
            ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
            MediaClip mediaClip2 = mediaClip;
            Integer num2 = num;
            if (num2 != null) {
                i3 = num2.intValue();
            } else {
                i3 = 0;
            }
            return new PipModel(mediaClip2, j3, i3, endMessageAndGetUnknownFields);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull PipModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            MediaClip.ADAPTER.encodeWithTag(writer, 1, value.mediaClip);
            ProtoAdapter.INT64.encodeWithTag(writer, 2, Long.valueOf(value.startOffset));
            ProtoAdapter.INT32.encodeWithTag(writer, 3, Integer.valueOf(value.timelineIndex));
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull PipModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return MediaClip.ADAPTER.encodedSizeWithTag(1, value.mediaClip) + ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(value.startOffset)) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(value.timelineIndex)) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public PipModel redact(@NotNull PipModel value) {
            MediaClip mediaClip;
            Intrinsics.checkNotNullParameter(value, "value");
            MediaClip mediaClip2 = value.mediaClip;
            if (mediaClip2 != null) {
                mediaClip = MediaClip.ADAPTER.redact(mediaClip2);
            } else {
                mediaClip = null;
            }
            return PipModel.copy$default(value, mediaClip, null, null, ByteString.EMPTY, 6, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PipModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public PipModel() {
        this(null, 0L, 0, null, 15, null);
    }

    public static /* synthetic */ PipModel copy$default(PipModel pipModel, MediaClip mediaClip, Long l3, Integer num, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            mediaClip = pipModel.mediaClip;
        }
        if ((i3 & 2) != 0) {
            l3 = Long.valueOf(pipModel.startOffset);
        }
        if ((i3 & 4) != 0) {
            num = Integer.valueOf(pipModel.timelineIndex);
        }
        if ((i3 & 8) != 0) {
            byteString = pipModel.unknownFields();
        }
        return pipModel.copy(mediaClip, l3, num, byteString);
    }

    @NotNull
    public final PipModel copy(@Nullable MediaClip mediaClip, @Nullable Long startOffset, @Nullable Integer timelineIndex, @NotNull ByteString unknownFields) {
        long j3;
        int i3;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (startOffset != null) {
            j3 = startOffset.longValue();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        if (timelineIndex != null) {
            i3 = timelineIndex.intValue();
        } else {
            i3 = 0;
        }
        return new PipModel(mediaClip, j16, i3, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PipModel)) {
            return false;
        }
        PipModel pipModel = (PipModel) other;
        if (Intrinsics.areEqual(unknownFields(), pipModel.unknownFields()) && Intrinsics.areEqual(this.mediaClip, pipModel.mediaClip) && this.startOffset == pipModel.startOffset && this.timelineIndex == pipModel.timelineIndex) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            MediaClip mediaClip = this.mediaClip;
            if (mediaClip != null) {
                i3 = mediaClip.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = ((((hashCode + i3) * 37) + androidx.fragment.app.a.a(this.startOffset)) * 37) + this.timelineIndex;
            this.hashCode = a16;
            return a16;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        MediaClip mediaClip = this.mediaClip;
        if (mediaClip != null) {
            arrayList.add("mediaClip=" + mediaClip);
        }
        arrayList.add("startOffset=" + this.startOffset);
        arrayList.add("timelineIndex=" + this.timelineIndex);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "PipModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ PipModel(MediaClip mediaClip, long j3, int i3, ByteString byteString, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : mediaClip, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.mediaClip = this.mediaClip;
        aVar.startOffset = this.startOffset;
        aVar.timelineIndex = Integer.valueOf(this.timelineIndex);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipModel(@Nullable MediaClip mediaClip, long j3, int i3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.mediaClip = mediaClip;
        this.startOffset = j3;
        this.timelineIndex = i3;
    }
}
