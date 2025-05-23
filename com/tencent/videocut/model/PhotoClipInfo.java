package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJE\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/videocut/model/PhotoClipInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/PhotoClipInfo$Builder;", "imageFrameRect", "Lcom/tencent/videocut/model/RectF;", "clipFrameRect", "picClipRect", "Lcom/tencent/videocut/model/Rect;", CanvasView.ACTION_ROTATE, "", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/videocut/model/RectF;Lcom/tencent/videocut/model/RectF;Lcom/tencent/videocut/model/Rect;Ljava/lang/Float;Lokio/ByteString;)V", "Ljava/lang/Float;", "copy", "(Lcom/tencent/videocut/model/RectF;Lcom/tencent/videocut/model/RectF;Lcom/tencent/videocut/model/Rect;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/videocut/model/PhotoClipInfo;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PhotoClipInfo extends AndroidMessage<PhotoClipInfo, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<PhotoClipInfo> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PhotoClipInfo> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.tencent.videocut.model.RectF#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final RectF clipFrameRect;

    @WireField(adapter = "com.tencent.videocut.model.RectF#ADAPTER", tag = 1)
    @JvmField
    @Nullable
    public final RectF imageFrameRect;

    @WireField(adapter = "com.tencent.videocut.model.Rect#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final Rect picClipRect;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    @JvmField
    @Nullable
    public final Float rotate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\rR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/videocut/model/PhotoClipInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/PhotoClipInfo;", "()V", "clipFrameRect", "Lcom/tencent/videocut/model/RectF;", "imageFrameRect", "picClipRect", "Lcom/tencent/videocut/model/Rect;", CanvasView.ACTION_ROTATE, "", "Ljava/lang/Float;", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/PhotoClipInfo$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<PhotoClipInfo, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public RectF clipFrameRect;

        @JvmField
        @Nullable
        public RectF imageFrameRect;

        @JvmField
        @Nullable
        public Rect picClipRect;

        @JvmField
        @Nullable
        public Float rotate;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder clipFrameRect(@Nullable RectF clipFrameRect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clipFrameRect);
            }
            this.clipFrameRect = clipFrameRect;
            return this;
        }

        @NotNull
        public final Builder imageFrameRect(@Nullable RectF imageFrameRect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageFrameRect);
            }
            this.imageFrameRect = imageFrameRect;
            return this;
        }

        @NotNull
        public final Builder picClipRect(@Nullable Rect picClipRect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) picClipRect);
            }
            this.picClipRect = picClipRect;
            return this;
        }

        @NotNull
        public final Builder rotate(@Nullable Float rotate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) rotate);
            }
            this.rotate = rotate;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public PhotoClipInfo build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? new PhotoClipInfo(this.imageFrameRect, this.clipFrameRect, this.picClipRect, this.rotate, buildUnknownFields()) : (PhotoClipInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/PhotoClipInfo$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/PhotoClipInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PhotoClipInfo.class);
        ProtoAdapter<PhotoClipInfo> protoAdapter = new ProtoAdapter<PhotoClipInfo>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.PhotoClipInfo$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.PhotoClipInfo");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PhotoClipInfo decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (PhotoClipInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                RectF rectF = null;
                RectF rectF2 = null;
                Rect rect = null;
                Float f16 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new PhotoClipInfo(rectF, rectF2, rect, f16, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 1) {
                        rectF = RectF.ADAPTER.decode(reader);
                    } else if (nextTag == 2) {
                        rectF2 = RectF.ADAPTER.decode(reader);
                    } else if (nextTag == 3) {
                        rect = Rect.ADAPTER.decode(reader);
                    } else if (nextTag != 4) {
                        reader.readUnknownField(nextTag);
                    } else {
                        f16 = ProtoAdapter.FLOAT.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull PhotoClipInfo value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<RectF> protoAdapter2 = RectF.ADAPTER;
                protoAdapter2.encodeWithTag(writer, 1, value.imageFrameRect);
                protoAdapter2.encodeWithTag(writer, 2, value.clipFrameRect);
                Rect.ADAPTER.encodeWithTag(writer, 3, value.picClipRect);
                ProtoAdapter.FLOAT.encodeWithTag(writer, 4, value.rotate);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull PhotoClipInfo value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<RectF> protoAdapter2 = RectF.ADAPTER;
                return protoAdapter2.encodedSizeWithTag(1, value.imageFrameRect) + protoAdapter2.encodedSizeWithTag(2, value.clipFrameRect) + Rect.ADAPTER.encodedSizeWithTag(3, value.picClipRect) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, value.rotate) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PhotoClipInfo redact(@NotNull PhotoClipInfo value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (PhotoClipInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                RectF rectF = value.imageFrameRect;
                RectF redact = rectF != null ? RectF.ADAPTER.redact(rectF) : null;
                RectF rectF2 = value.clipFrameRect;
                RectF redact2 = rectF2 != null ? RectF.ADAPTER.redact(rectF2) : null;
                Rect rect = value.picClipRect;
                return PhotoClipInfo.copy$default(value, redact, redact2, rect != null ? Rect.ADAPTER.redact(rect) : null, null, ByteString.EMPTY, 8, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public PhotoClipInfo() {
        this(null, null, null, null, null, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (PhotoClipInfo) iPatchRedirector.redirect((short) 7, this, imageFrameRect, clipFrameRect, picClipRect, rotate, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new PhotoClipInfo(imageFrameRect, clipFrameRect, picClipRect, rotate, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
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
        this((i3 & 1) != 0 ? null : rectF, (i3 & 2) != 0 ? null : rectF2, (i3 & 4) != 0 ? null : rect, (i3 & 8) != 0 ? null : f16, (i3 & 16) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, rectF, rectF2, rect, f16, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.imageFrameRect = this.imageFrameRect;
        builder.clipFrameRect = this.clipFrameRect;
        builder.picClipRect = this.picClipRect;
        builder.rotate = this.rotate;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoClipInfo(@Nullable RectF rectF, @Nullable RectF rectF2, @Nullable Rect rect, @Nullable Float f16, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rectF, rectF2, rect, f16, unknownFields);
            return;
        }
        this.imageFrameRect = rectF;
        this.clipFrameRect = rectF2;
        this.picClipRect = rect;
        this.rotate = f16;
    }
}
