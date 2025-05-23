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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B[\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\\\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0018R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "resource", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", "transform", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "filter", "voiceKindName", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;", "photoClip", "", "", "matrix", "Lokio/ByteString;", "unknownFields", "copy", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "Ljava/lang/String;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;", "Ljava/util/List;", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;Ljava/util/List;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class MediaClip extends AndroidMessage<MediaClip, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<MediaClip> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<MediaClip> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final FilterModel filter;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REPEATED, tag = 6)
    @JvmField
    @NotNull
    public final List<Float> matrix;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PhotoClipInfo#ADAPTER", tag = 5)
    @JvmField
    @Nullable
    public final PhotoClipInfo photoClip;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel#ADAPTER", tag = 1)
    @JvmField
    @Nullable
    public final ResourceModel resource;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Transform#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final Transform transform;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @NotNull
    public final String voiceKindName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "a", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "resource", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", "b", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", "transform", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "c", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "filter", "", "d", "Ljava/lang/String;", "voiceKindName", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;", "e", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PhotoClipInfo;", "photoClip", "", "", "f", "Ljava/util/List;", "matrix", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<MediaClip, a> {

        /* renamed from: a, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public ResourceModel resource;

        /* renamed from: b, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public Transform transform;

        /* renamed from: c, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public FilterModel filter;

        /* renamed from: d, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public String voiceKindName;

        /* renamed from: e, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public PhotoClipInfo photoClip;

        /* renamed from: f, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public List<Float> matrix;

        public a() {
            List<Float> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.matrix = emptyList;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a */
        public MediaClip build() {
            ResourceModel resourceModel = this.resource;
            Transform transform = this.transform;
            FilterModel filterModel = this.filter;
            String str = this.voiceKindName;
            if (str == null) {
                str = "";
            }
            return new MediaClip(resourceModel, transform, filterModel, str, this.photoClip, this.matrix, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<MediaClip> {
        b(FieldEncoding fieldEncoding, KClass<MediaClip> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.MediaClip");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a */
        public MediaClip decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            ArrayList arrayList = new ArrayList();
            long beginMessage = reader.beginMessage();
            ResourceModel resourceModel = null;
            Transform transform = null;
            FilterModel filterModel = null;
            String str = null;
            PhotoClipInfo photoClipInfo = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            resourceModel = ResourceModel.ADAPTER.decode(reader);
                            break;
                        case 2:
                            transform = Transform.ADAPTER.decode(reader);
                            break;
                        case 3:
                            filterModel = FilterModel.ADAPTER.decode(reader);
                            break;
                        case 4:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            photoClipInfo = PhotoClipInfo.ADAPTER.decode(reader);
                            break;
                        case 6:
                            arrayList.add(ProtoAdapter.FLOAT.decode(reader));
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                    ResourceModel resourceModel2 = resourceModel;
                    Transform transform2 = transform;
                    FilterModel filterModel2 = filterModel;
                    String str2 = str;
                    if (str2 == null) {
                        str2 = "";
                    }
                    return new MediaClip(resourceModel2, transform2, filterModel2, str2, photoClipInfo, arrayList, endMessageAndGetUnknownFields);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(@NotNull ProtoWriter writer, @NotNull MediaClip value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ResourceModel.ADAPTER.encodeWithTag(writer, 1, value.resource);
            Transform.ADAPTER.encodeWithTag(writer, 2, value.transform);
            FilterModel.ADAPTER.encodeWithTag(writer, 3, value.filter);
            ProtoAdapter.STRING.encodeWithTag(writer, 4, value.voiceKindName);
            PhotoClipInfo.ADAPTER.encodeWithTag(writer, 5, value.photoClip);
            ProtoAdapter.FLOAT.asRepeated().encodeWithTag(writer, 6, value.matrix);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(@NotNull MediaClip value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return ResourceModel.ADAPTER.encodedSizeWithTag(1, value.resource) + Transform.ADAPTER.encodedSizeWithTag(2, value.transform) + FilterModel.ADAPTER.encodedSizeWithTag(3, value.filter) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.voiceKindName) + PhotoClipInfo.ADAPTER.encodedSizeWithTag(5, value.photoClip) + ProtoAdapter.FLOAT.asRepeated().encodedSizeWithTag(6, value.matrix) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d */
        public MediaClip redact(@NotNull MediaClip value) {
            ResourceModel resourceModel;
            Transform transform;
            FilterModel filterModel;
            Intrinsics.checkNotNullParameter(value, "value");
            ResourceModel resourceModel2 = value.resource;
            PhotoClipInfo photoClipInfo = null;
            if (resourceModel2 != null) {
                resourceModel = ResourceModel.ADAPTER.redact(resourceModel2);
            } else {
                resourceModel = null;
            }
            Transform transform2 = value.transform;
            if (transform2 != null) {
                transform = Transform.ADAPTER.redact(transform2);
            } else {
                transform = null;
            }
            FilterModel filterModel2 = value.filter;
            if (filterModel2 != null) {
                filterModel = FilterModel.ADAPTER.redact(filterModel2);
            } else {
                filterModel = null;
            }
            PhotoClipInfo photoClipInfo2 = value.photoClip;
            if (photoClipInfo2 != null) {
                photoClipInfo = PhotoClipInfo.ADAPTER.redact(photoClipInfo2);
            }
            return MediaClip.copy$default(value, resourceModel, transform, filterModel, null, photoClipInfo, null, ByteString.EMPTY, 40, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MediaClip.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public MediaClip() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MediaClip copy$default(MediaClip mediaClip, ResourceModel resourceModel, Transform transform, FilterModel filterModel, String str, PhotoClipInfo photoClipInfo, List list, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            resourceModel = mediaClip.resource;
        }
        if ((i3 & 2) != 0) {
            transform = mediaClip.transform;
        }
        Transform transform2 = transform;
        if ((i3 & 4) != 0) {
            filterModel = mediaClip.filter;
        }
        FilterModel filterModel2 = filterModel;
        if ((i3 & 8) != 0) {
            str = mediaClip.voiceKindName;
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            photoClipInfo = mediaClip.photoClip;
        }
        PhotoClipInfo photoClipInfo2 = photoClipInfo;
        if ((i3 & 32) != 0) {
            list = mediaClip.matrix;
        }
        List list2 = list;
        if ((i3 & 64) != 0) {
            byteString = mediaClip.unknownFields();
        }
        return mediaClip.copy(resourceModel, transform2, filterModel2, str2, photoClipInfo2, list2, byteString);
    }

    @NotNull
    public final MediaClip copy(@Nullable ResourceModel resource, @Nullable Transform transform, @Nullable FilterModel filter, @Nullable String voiceKindName, @Nullable PhotoClipInfo photoClip, @NotNull List<Float> matrix, @NotNull ByteString unknownFields) {
        String str;
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (voiceKindName == null) {
            str = "";
        } else {
            str = voiceKindName;
        }
        return new MediaClip(resource, transform, filter, str, photoClip, matrix, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof MediaClip)) {
            return false;
        }
        MediaClip mediaClip = (MediaClip) other;
        if (Intrinsics.areEqual(unknownFields(), mediaClip.unknownFields()) && Intrinsics.areEqual(this.resource, mediaClip.resource) && Intrinsics.areEqual(this.transform, mediaClip.transform) && Intrinsics.areEqual(this.filter, mediaClip.filter) && Intrinsics.areEqual(this.voiceKindName, mediaClip.voiceKindName) && Intrinsics.areEqual(this.photoClip, mediaClip.photoClip) && Intrinsics.areEqual(this.matrix, mediaClip.matrix)) {
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
            ResourceModel resourceModel = this.resource;
            int i19 = 0;
            if (resourceModel != null) {
                i3 = resourceModel.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            Transform transform = this.transform;
            if (transform != null) {
                i16 = transform.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 37;
            FilterModel filterModel = this.filter;
            if (filterModel != null) {
                i17 = filterModel.hashCode();
            } else {
                i17 = 0;
            }
            int hashCode2 = (((i27 + i17) * 37) + this.voiceKindName.hashCode()) * 37;
            PhotoClipInfo photoClipInfo = this.photoClip;
            if (photoClipInfo != null) {
                i19 = photoClipInfo.hashCode();
            }
            int hashCode3 = ((hashCode2 + i19) * 37) + this.matrix.hashCode();
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i18;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        ResourceModel resourceModel = this.resource;
        if (resourceModel != null) {
            arrayList.add("resource=" + resourceModel);
        }
        Transform transform = this.transform;
        if (transform != null) {
            arrayList.add("transform=" + transform);
        }
        FilterModel filterModel = this.filter;
        if (filterModel != null) {
            arrayList.add("filter=" + filterModel);
        }
        String str = this.voiceKindName;
        if (str != null) {
            arrayList.add("voiceKindName=" + Internal.sanitize(str));
        }
        PhotoClipInfo photoClipInfo = this.photoClip;
        if (photoClipInfo != null) {
            arrayList.add("photoClip=" + photoClipInfo);
        }
        if (!this.matrix.isEmpty()) {
            arrayList.add("matrix=" + this.matrix);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "MediaClip{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ MediaClip(ResourceModel resourceModel, Transform transform, FilterModel filterModel, String str, PhotoClipInfo photoClipInfo, List list, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : resourceModel, (i3 & 2) != 0 ? null : transform, (i3 & 4) != 0 ? null : filterModel, (i3 & 8) != 0 ? "" : str, (i3 & 16) == 0 ? photoClipInfo : null, (i3 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.resource = this.resource;
        aVar.transform = this.transform;
        aVar.filter = this.filter;
        aVar.voiceKindName = this.voiceKindName;
        aVar.photoClip = this.photoClip;
        aVar.matrix = this.matrix;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaClip(@Nullable ResourceModel resourceModel, @Nullable Transform transform, @Nullable FilterModel filterModel, @NotNull String voiceKindName, @Nullable PhotoClipInfo photoClipInfo, @NotNull List<Float> matrix, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(voiceKindName, "voiceKindName");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.resource = resourceModel;
        this.transform = transform;
        this.filter = filterModel;
        this.voiceKindName = voiceKindName;
        this.photoClip = photoClipInfo;
        this.matrix = matrix;
    }
}
