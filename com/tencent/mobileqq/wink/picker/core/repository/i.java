package com.tencent.mobileqq.wink.picker.core.repository;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.querymedia.ICursor;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaFilteringCode;
import com.tencent.mobileqq.wink.picker.MediaMimeType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/i;", "Lcom/tencent/mobileqq/activity/photo/album/querymedia/ICursor$FilterListener;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "d", "", "", "mimeTypes", "b", "([Ljava/lang/String;)Z", "mimeType", "e", "c", "a", "needMediaInfo", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "mediaFilter", "", "Lcom/tencent/mobileqq/wink/picker/MediaMimeType;", "Ljava/util/List;", "supportImageType", "<init>", "(Lcom/tencent/mobileqq/wink/picker/MediaFilter;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i implements ICursor.FilterListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaFilter mediaFilter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MediaMimeType> supportImageType;

    public i(@NotNull MediaFilter mediaFilter) {
        Intrinsics.checkNotNullParameter(mediaFilter, "mediaFilter");
        this.mediaFilter = mediaFilter;
        this.supportImageType = mediaFilter.getSupportImageType();
    }

    private final boolean a(String mimeType) {
        if (!this.supportImageType.contains(MediaMimeType.IMAGE_AVIF) && Intrinsics.areEqual("image/avif", mimeType)) {
            return true;
        }
        return false;
    }

    private final boolean b(String[] mimeTypes) {
        if (!this.supportImageType.contains(MediaMimeType.IMAGE_GIF) && MimeHelper.validateImageType(mimeTypes[1]) && Intrinsics.areEqual(mimeTypes[1], "gif")) {
            return true;
        }
        return false;
    }

    private final boolean c(String mimeType) {
        if (!this.supportImageType.contains(MediaMimeType.IMAGE_HEIF) && (Intrinsics.areEqual(MimeHelper.IMAGE_HEIF, mimeType) || Intrinsics.areEqual(MimeHelper.IMAGE_HEIC, mimeType))) {
            return true;
        }
        return false;
    }

    private final boolean d(LocalMediaInfo info) {
        String str;
        Object orNull;
        String str2 = info.mMimeType;
        if (str2 == null) {
            w53.b.f("WinkMediaFilterListener", "mimeType is null, " + info);
            return true;
        }
        String[] mimeTypes = MimeHelper.getMimeType(str2);
        if (mimeTypes != null) {
            orNull = ArraysKt___ArraysKt.getOrNull(mimeTypes, 0);
            str = (String) orNull;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "image")) {
            Intrinsics.checkNotNullExpressionValue(mimeTypes, "mimeTypes");
            if (b(mimeTypes) || e(str2) || c(str2) || a(str2)) {
                return true;
            }
        } else if (!Intrinsics.areEqual(str, "video") || !MimeHelper.validateVideoType(str2)) {
            return true;
        }
        return false;
    }

    private final boolean e(String mimeType) {
        if (!this.supportImageType.contains(MediaMimeType.IMAGE_WEBP) && Intrinsics.areEqual("image/webp", mimeType)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor.FilterListener
    public boolean needMediaInfo(@NotNull LocalMediaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (!d(info) && d93.b.f393235a.a(info, this.mediaFilter) == MediaFilteringCode.MEDIA_VALID) {
            return true;
        }
        return false;
    }
}
