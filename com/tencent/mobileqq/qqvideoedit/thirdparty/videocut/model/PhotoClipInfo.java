package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.tencent.qqmini.miniapp.widget.CanvasView;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eBA\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016JG\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "imageFrameRect", "clipFrameRect", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;", "picClipRect", "", CanvasView.ACTION_ROTATE, "Lokio/ByteString;", "unknownFields", "copy", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;", "Ljava/lang/Float;", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;Ljava/lang/Float;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PhotoClipInfo extends AndroidMessage<PhotoClipInfo, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<PhotoClipInfo> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PhotoClipInfo> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RectF#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final RectF clipFrameRect;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RectF#ADAPTER", tag = 1)
    @JvmField
    @Nullable
    public final RectF imageFrameRect;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Rect#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final Rect picClipRect;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    @JvmField
    @Nullable
    public final Float rotate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;", "a", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "imageFrameRect", "b", "clipFrameRect", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;", "c", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Rect;", "picClipRect", "", "d", "Ljava/lang/Float;", CanvasView.ACTION_ROTATE, "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<PhotoClipInfo, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public RectF imageFrameRect;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public RectF clipFrameRect;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Rect picClipRect;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Float rotate;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoClipInfo build() {
            return new PhotoClipInfo(this.imageFrameRect, this.clipFrameRect, this.picClipRect, this.rotate, buildUnknownFields());
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<PhotoClipInfo> {
        b(FieldEncoding fieldEncoding, KClass<PhotoClipInfo> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.PhotoClipInfo");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoClipInfo decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            RectF rectF = null;
            RectF rectF2 = null;
            Rect rect = null;
            Float f16 = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    reader.readUnknownField(nextTag);
                                } else {
                                    f16 = ProtoAdapter.FLOAT.decode(reader);
                                }
                            } else {
                                rect = Rect.ADAPTER.decode(reader);
                            }
                        } else {
                            rectF2 = RectF.ADAPTER.decode(reader);
                        }
                    } else {
                        rectF = RectF.ADAPTER.decode(reader);
                    }
                } else {
                    return new PhotoClipInfo(rectF, rectF2, rect, f16, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull PhotoClipInfo value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<RectF> protoAdapter = RectF.ADAPTER;
            protoAdapter.encodeWithTag(writer, 1, value.imageFrameRect);
            protoAdapter.encodeWithTag(writer, 2, value.clipFrameRect);
            Rect.ADAPTER.encodeWithTag(writer, 3, value.picClipRect);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 4, value.rotate);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull PhotoClipInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<RectF> protoAdapter = RectF.ADAPTER;
            return protoAdapter.encodedSizeWithTag(1, value.imageFrameRect) + protoAdapter.encodedSizeWithTag(2, value.clipFrameRect) + Rect.ADAPTER.encodedSizeWithTag(3, value.picClipRect) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, value.rotate) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public PhotoClipInfo redact(@NotNull PhotoClipInfo value) {
            RectF rectF;
            RectF rectF2;
            Intrinsics.checkNotNullParameter(value, "value");
            RectF rectF3 = value.imageFrameRect;
            Rect rect = null;
            if (rectF3 != null) {
                rectF = RectF.ADAPTER.redact(rectF3);
            } else {
                rectF = null;
            }
            RectF rectF4 = value.clipFrameRect;
            if (rectF4 != null) {
                rectF2 = RectF.ADAPTER.redact(rectF4);
            } else {
                rectF2 = null;
            }
            Rect rect2 = value.picClipRect;
            if (rect2 != null) {
                rect = Rect.ADAPTER.redact(rect2);
            }
            return PhotoClipInfo.copy$default(value, rectF, rectF2, rect, null, ByteString.EMPTY, 8, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PhotoClipInfo.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public PhotoClipInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PhotoClipInfo copy$default(PhotoClipInfo photoClipInfo, RectF rectF, RectF rectF2, Rect rect, Float f16, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            rectF = photoClipInfo.imageFrameRect;
        }
        if ((i3 & 2) != 0) {
            rectF2 = photoClipInfo.clipFrameRect;
        }
        RectF rectF3 = rectF2;
        if ((i3 & 4) != 0) {
            rect = photoClipInfo.picClipRect;
        }
        Rect rect2 = rect;
        if ((i3 & 8) != 0) {
            f16 = photoClipInfo.rotate;
        }
        Float f17 = f16;
        if ((i3 & 16) != 0) {
            byteString = photoClipInfo.unknownFields();
        }
        return photoClipInfo.copy(rectF, rectF3, rect2, f17, byteString);
    }

    @NotNull
    public final PhotoClipInfo copy(@Nullable RectF imageFrameRect, @Nullable RectF clipFrameRect, @Nullable Rect picClipRect, @Nullable Float rotate, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new PhotoClipInfo(imageFrameRect, clipFrameRect, picClipRect, rotate, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PhotoClipInfo)) {
            return false;
        }
        PhotoClipInfo photoClipInfo = (PhotoClipInfo) other;
        if (Intrinsics.areEqual(unknownFields(), photoClipInfo.unknownFields()) && Intrinsics.areEqual(this.imageFrameRect, photoClipInfo.imageFrameRect) && Intrinsics.areEqual(this.clipFrameRect, photoClipInfo.clipFrameRect) && Intrinsics.areEqual(this.picClipRect, photoClipInfo.picClipRect) && Intrinsics.areEqual(this.rotate, photoClipInfo.rotate)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18 = this.hashCode;
        if (i18 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RectF rectF = this.imageFrameRect;
            int i19 = 0;
            if (rectF != null) {
                i3 = rectF.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            RectF rectF2 = this.clipFrameRect;
            if (rectF2 != null) {
                i16 = rectF2.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 37;
            Rect rect = this.picClipRect;
            if (rect != null) {
                i17 = rect.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 37;
            Float f16 = this.rotate;
            if (f16 != null) {
                i19 = f16.hashCode();
            }
            int i29 = i28 + i19;
            this.hashCode = i29;
            return i29;
        }
        return i18;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        RectF rectF = this.imageFrameRect;
        if (rectF != null) {
            arrayList.add("imageFrameRect=" + rectF);
        }
        RectF rectF2 = this.clipFrameRect;
        if (rectF2 != null) {
            arrayList.add("clipFrameRect=" + rectF2);
        }
        Rect rect = this.picClipRect;
        if (rect != null) {
            arrayList.add("picClipRect=" + rect);
        }
        Float f16 = this.rotate;
        if (f16 != null) {
            arrayList.add("rotate=" + f16);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "PhotoClipInfo{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ PhotoClipInfo(RectF rectF, RectF rectF2, Rect rect, Float f16, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : rectF, (i3 & 2) != 0 ? null : rectF2, (i3 & 4) != 0 ? null : rect, (i3 & 8) == 0 ? f16 : null, (i3 & 16) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.imageFrameRect = this.imageFrameRect;
        aVar.clipFrameRect = this.clipFrameRect;
        aVar.picClipRect = this.picClipRect;
        aVar.rotate = this.rotate;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoClipInfo(@Nullable RectF rectF, @Nullable RectF rectF2, @Nullable Rect rect, @Nullable Float f16, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.imageFrameRect = rectF;
        this.clipFrameRect = rectF2;
        this.picClipRect = rect;
        this.rotate = f16;
    }
}
