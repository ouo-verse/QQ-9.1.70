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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dBY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J^\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/videocut/model/MediaClip;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/MediaClip$Builder;", "resource", "Lcom/tencent/videocut/model/ResourceModel;", "transform", "Lcom/tencent/videocut/model/Transform;", "filter", "Lcom/tencent/videocut/model/FilterModel;", "voiceKindName", "", "photoClip", "Lcom/tencent/videocut/model/PhotoClipInfo;", "matrix", "", "", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/videocut/model/ResourceModel;Lcom/tencent/videocut/model/Transform;Lcom/tencent/videocut/model/FilterModel;Ljava/lang/String;Lcom/tencent/videocut/model/PhotoClipInfo;Ljava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class MediaClip extends AndroidMessage<MediaClip, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<MediaClip> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<MediaClip> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.tencent.videocut.model.FilterModel#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final FilterModel filter;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REPEATED, tag = 6)
    @JvmField
    @NotNull
    public List<Float> matrix;

    @WireField(adapter = "com.tencent.videocut.model.PhotoClipInfo#ADAPTER", tag = 5)
    @JvmField
    @Nullable
    public final PhotoClipInfo photoClip;

    @WireField(adapter = "com.tencent.videocut.model.ResourceModel#ADAPTER", tag = 1)
    @JvmField
    @Nullable
    public final ResourceModel resource;

    @WireField(adapter = "com.tencent.videocut.model.Transform#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final Transform transform;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @NotNull
    public final String voiceKindName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/videocut/model/MediaClip$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/MediaClip;", "()V", "filter", "Lcom/tencent/videocut/model/FilterModel;", "matrix", "", "", "photoClip", "Lcom/tencent/videocut/model/PhotoClipInfo;", "resource", "Lcom/tencent/videocut/model/ResourceModel;", "transform", "Lcom/tencent/videocut/model/Transform;", "voiceKindName", "", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<MediaClip, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public FilterModel filter;

        @JvmField
        @NotNull
        public List<Float> matrix;

        @JvmField
        @Nullable
        public PhotoClipInfo photoClip;

        @JvmField
        @Nullable
        public ResourceModel resource;

        @JvmField
        @Nullable
        public Transform transform;

        @JvmField
        @Nullable
        public String voiceKindName;

        public Builder() {
            List<Float> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.matrix = emptyList;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder filter(@Nullable FilterModel filter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) filter);
            }
            this.filter = filter;
            return this;
        }

        @NotNull
        public final Builder photoClip(@Nullable PhotoClipInfo photoClip) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) photoClip);
            }
            this.photoClip = photoClip;
            return this;
        }

        @NotNull
        public final Builder resource(@Nullable ResourceModel resource) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) resource);
            }
            this.resource = resource;
            return this;
        }

        @NotNull
        public final Builder transform(@Nullable Transform transform) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) transform);
            }
            this.transform = transform;
            return this;
        }

        @NotNull
        public final Builder voiceKindName(@Nullable String voiceKindName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) voiceKindName);
            }
            this.voiceKindName = voiceKindName;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public MediaClip build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (MediaClip) iPatchRedirector.redirect((short) 7, (Object) this);
            }
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/MediaClip$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/MediaClip;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MediaClip.class);
        ProtoAdapter<MediaClip> protoAdapter = new ProtoAdapter<MediaClip>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.MediaClip$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.MediaClip");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public MediaClip decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (MediaClip) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
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
            public void encode(@NotNull ProtoWriter writer, @NotNull MediaClip value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
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
            public int encodedSize(@NotNull MediaClip value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                return ResourceModel.ADAPTER.encodedSizeWithTag(1, value.resource) + Transform.ADAPTER.encodedSizeWithTag(2, value.transform) + FilterModel.ADAPTER.encodedSizeWithTag(3, value.filter) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.voiceKindName) + PhotoClipInfo.ADAPTER.encodedSizeWithTag(5, value.photoClip) + ProtoAdapter.FLOAT.asRepeated().encodedSizeWithTag(6, value.matrix) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public MediaClip redact(@NotNull MediaClip value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (MediaClip) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ResourceModel resourceModel = value.resource;
                ResourceModel redact = resourceModel != null ? ResourceModel.ADAPTER.redact(resourceModel) : null;
                Transform transform = value.transform;
                Transform redact2 = transform != null ? Transform.ADAPTER.redact(transform) : null;
                FilterModel filterModel = value.filter;
                FilterModel redact3 = filterModel != null ? FilterModel.ADAPTER.redact(filterModel) : null;
                PhotoClipInfo photoClipInfo = value.photoClip;
                return MediaClip.copy$default(value, redact, redact2, redact3, null, photoClipInfo != null ? PhotoClipInfo.ADAPTER.redact(photoClipInfo) : null, null, ByteString.EMPTY, 40, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public MediaClip() {
        this(null, null, null, null, null, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ MediaClip copy$default(MediaClip mediaClip, ResourceModel resourceModel, Transform transform, FilterModel filterModel, String str, PhotoClipInfo photoClipInfo, List list, ByteString byteString, int i3, Object obj) {
        if (obj == null) {
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
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    @NotNull
    public MediaClip copy(@Nullable ResourceModel resource, @Nullable Transform transform, @Nullable FilterModel filter, @Nullable String voiceKindName, @Nullable PhotoClipInfo photoClip, @NotNull List<Float> matrix, @NotNull ByteString unknownFields) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MediaClip) iPatchRedirector.redirect((short) 7, this, resource, transform, filter, voiceKindName, photoClip, matrix, unknownFields);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MediaClip(ResourceModel resourceModel, Transform transform, FilterModel filterModel, String str, PhotoClipInfo photoClipInfo, List list, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r4, r5, r6, r7, r8, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
        List list2;
        List emptyList;
        ResourceModel resourceModel2 = (i3 & 1) != 0 ? null : resourceModel;
        Transform transform2 = (i3 & 2) != 0 ? null : transform;
        FilterModel filterModel2 = (i3 & 4) != 0 ? null : filterModel;
        String str2 = (i3 & 8) != 0 ? "" : str;
        PhotoClipInfo photoClipInfo2 = (i3 & 16) != 0 ? null : photoClipInfo;
        if ((i3 & 32) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, resourceModel, transform, filterModel, str, photoClipInfo, list, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.resource = this.resource;
        builder.transform = this.transform;
        builder.filter = this.filter;
        builder.voiceKindName = this.voiceKindName;
        builder.photoClip = this.photoClip;
        builder.matrix = this.matrix;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaClip(@Nullable ResourceModel resourceModel, @Nullable Transform transform, @Nullable FilterModel filterModel, @NotNull String voiceKindName, @Nullable PhotoClipInfo photoClipInfo, @NotNull List<Float> matrix, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(voiceKindName, "voiceKindName");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resourceModel, transform, filterModel, voiceKindName, photoClipInfo, matrix, unknownFields);
            return;
        }
        this.resource = resourceModel;
        this.transform = transform;
        this.filter = filterModel;
        this.voiceKindName = voiceKindName;
        this.photoClip = photoClipInfo;
        this.matrix = matrix;
    }
}
