package com.tencent.videocut.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0012JP\u0010\u0017\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016Jf\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/videocut/model/MediaClipForCover;", "Lcom/tencent/videocut/model/MediaClip;", "resource", "Lcom/tencent/videocut/model/ResourceModel;", "transform", "Lcom/tencent/videocut/model/Transform;", "filter", "Lcom/tencent/videocut/model/FilterModel;", "voiceKindName", "", "photoClip", "Lcom/tencent/videocut/model/PhotoClipInfo;", "matrix", "", "", "unknownFields", "Lokio/ByteString;", "byteArray", "(Lcom/tencent/videocut/model/ResourceModel;Lcom/tencent/videocut/model/Transform;Lcom/tencent/videocut/model/FilterModel;Ljava/lang/String;Lcom/tencent/videocut/model/PhotoClipInfo;Ljava/util/List;Lokio/ByteString;Lokio/ByteString;)V", "getByteArray", "()Lokio/ByteString;", "setByteArray", "(Lokio/ByteString;)V", "copy", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class MediaClipForCover extends MediaClip {
    static IPatchRedirector $redirector_;

    @NotNull
    private ByteString byteArray;

    public MediaClipForCover() {
        this(null, null, null, null, null, null, null, null, 255, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    public static /* synthetic */ MediaClipForCover copy$default(MediaClipForCover mediaClipForCover, ResourceModel resourceModel, Transform transform, FilterModel filterModel, String str, PhotoClipInfo photoClipInfo, List list, ByteString byteString, ByteString byteString2, int i3, Object obj) {
        ResourceModel resourceModel2;
        Transform transform2;
        FilterModel filterModel2;
        String str2;
        PhotoClipInfo photoClipInfo2;
        List list2;
        ByteString byteString3;
        ByteString byteString4;
        if ((i3 & 1) != 0) {
            resourceModel2 = mediaClipForCover.resource;
        } else {
            resourceModel2 = resourceModel;
        }
        if ((i3 & 2) != 0) {
            transform2 = mediaClipForCover.transform;
        } else {
            transform2 = transform;
        }
        if ((i3 & 4) != 0) {
            filterModel2 = mediaClipForCover.filter;
        } else {
            filterModel2 = filterModel;
        }
        if ((i3 & 8) != 0) {
            str2 = mediaClipForCover.voiceKindName;
        } else {
            str2 = str;
        }
        if ((i3 & 16) != 0) {
            photoClipInfo2 = mediaClipForCover.photoClip;
        } else {
            photoClipInfo2 = photoClipInfo;
        }
        if ((i3 & 32) != 0) {
            list2 = mediaClipForCover.matrix;
        } else {
            list2 = list;
        }
        if ((i3 & 64) != 0) {
            byteString3 = mediaClipForCover.unknownFields();
        } else {
            byteString3 = byteString;
        }
        if ((i3 & 128) != 0) {
            byteString4 = mediaClipForCover.byteArray;
        } else {
            byteString4 = byteString2;
        }
        return mediaClipForCover.copy(resourceModel2, transform2, filterModel2, str2, photoClipInfo2, list2, byteString3, byteString4);
    }

    @Override // com.tencent.videocut.model.MediaClip
    public /* bridge */ /* synthetic */ MediaClip copy(ResourceModel resourceModel, Transform transform, FilterModel filterModel, String str, PhotoClipInfo photoClipInfo, List list, ByteString byteString) {
        return copy(resourceModel, transform, filterModel, str, photoClipInfo, (List<Float>) list, byteString);
    }

    @NotNull
    public final ByteString getByteArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ByteString) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.byteArray;
    }

    public final void setByteArray(@NotNull ByteString byteString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) byteString);
        } else {
            Intrinsics.checkNotNullParameter(byteString, "<set-?>");
            this.byteArray = byteString;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MediaClipForCover(ResourceModel resourceModel, Transform transform, FilterModel filterModel, String str, PhotoClipInfo photoClipInfo, List list, ByteString byteString, ByteString byteString2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r6, r7, r8, r9, (i3 & 64) != 0 ? ByteString.EMPTY : byteString, (i3 & 128) != 0 ? ByteString.EMPTY : byteString2);
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
        iPatchRedirector.redirect((short) 2, this, resourceModel, transform, filterModel, str, photoClipInfo, list, byteString, byteString2, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.tencent.videocut.model.MediaClip
    @NotNull
    public MediaClipForCover copy(@Nullable ResourceModel resource, @Nullable Transform transform, @Nullable FilterModel filter, @Nullable String voiceKindName, @Nullable PhotoClipInfo photoClip, @NotNull List<Float> matrix, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MediaClipForCover) iPatchRedirector.redirect((short) 5, this, resource, transform, filter, voiceKindName, photoClip, matrix, unknownFields);
        }
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return copy(resource, transform, filter, voiceKindName, photoClip, matrix, unknownFields, this.byteArray);
    }

    @NotNull
    public final MediaClipForCover copy(@Nullable ResourceModel resource, @Nullable Transform transform, @Nullable FilterModel filter, @Nullable String voiceKindName, @Nullable PhotoClipInfo photoClip, @NotNull List<Float> matrix, @NotNull ByteString unknownFields, @NotNull ByteString byteArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MediaClipForCover) iPatchRedirector.redirect((short) 6, this, resource, transform, filter, voiceKindName, photoClip, matrix, unknownFields, byteArray);
        }
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return new MediaClipForCover(resource, transform, filter, voiceKindName == null ? "" : voiceKindName, photoClip, matrix, unknownFields, byteArray);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaClipForCover(@Nullable ResourceModel resourceModel, @Nullable Transform transform, @Nullable FilterModel filterModel, @NotNull String voiceKindName, @Nullable PhotoClipInfo photoClipInfo, @NotNull List<Float> matrix, @NotNull ByteString unknownFields, @NotNull ByteString byteArray) {
        super(resourceModel, transform, filterModel, voiceKindName, photoClipInfo, matrix, unknownFields);
        Intrinsics.checkNotNullParameter(voiceKindName, "voiceKindName");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.byteArray = byteArray;
        } else {
            iPatchRedirector.redirect((short) 1, this, resourceModel, transform, filterModel, voiceKindName, photoClipInfo, matrix, unknownFields, byteArray);
        }
    }
}
