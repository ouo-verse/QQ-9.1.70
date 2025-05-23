package com.tencent.qqnt.qbasealbum.filter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.MediaMimeType;
import com.tencent.qqnt.qbasealbum.query.ICursor;
import com.tencent.qqnt.qbasealbum.utils.MimeHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/filter/QAlbumMediaFilterListener;", "Lcom/tencent/qqnt/qbasealbum/query/ICursor$b;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", "d", "", "", "mimeTypes", "b", "([Ljava/lang/String;)Z", "mimeType", "e", "c", "a", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "mediaFilter", "", "Lcom/tencent/qqnt/qbasealbum/model/MediaMimeType;", "Ljava/util/List;", "supportImageType", "<init>", "(Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QAlbumMediaFilterListener implements ICursor.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaFilter mediaFilter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MediaMimeType> supportImageType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/filter/QAlbumMediaFilterListener$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.filter.QAlbumMediaFilterListener$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38988);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QAlbumMediaFilterListener(@NotNull MediaFilter mediaFilter) {
        Intrinsics.checkNotNullParameter(mediaFilter, "mediaFilter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mediaFilter);
        } else {
            this.mediaFilter = mediaFilter;
            this.supportImageType = mediaFilter.k();
        }
    }

    private final boolean b(String[] mimeTypes) {
        if (!this.supportImageType.contains(MediaMimeType.IMAGE_GIF) && MimeHelper.f361630a.b(mimeTypes[1]) && Intrinsics.areEqual(mimeTypes[1], "gif")) {
            return true;
        }
        return false;
    }

    private final boolean c(String mimeType) {
        if (!this.supportImageType.contains(MediaMimeType.IMAGE_HEIF) && (Intrinsics.areEqual(com.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_HEIF, mimeType) || Intrinsics.areEqual(com.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_HEIC, mimeType))) {
            return true;
        }
        return false;
    }

    private final boolean d(final LocalMediaInfo info) {
        String str;
        Object orNull;
        String mMimeType = info.getMMimeType();
        if (mMimeType == null) {
            ox3.a.g("QBaseAlbum.MediaFilter", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.filter.QAlbumMediaFilterListener$filteringMediaMineType$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "mimeType is null, " + LocalMediaInfo.this;
                }
            });
            return true;
        }
        MimeHelper mimeHelper = MimeHelper.f361630a;
        String[] a16 = mimeHelper.a(mMimeType);
        if (a16 != null) {
            orNull = ArraysKt___ArraysKt.getOrNull(a16, 0);
            str = (String) orNull;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "image")) {
            if (b(a16) || e(mMimeType) || c(mMimeType)) {
                return true;
            }
        } else if (!Intrinsics.areEqual(str, "video") || !mimeHelper.c(mMimeType)) {
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

    @Override // com.tencent.qqnt.qbasealbum.query.ICursor.b
    public boolean a(@NotNull LocalMediaInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (!d(info) && a.f361199a.a(info, this.mediaFilter) == MediaFilteringCode.MEDIA_VALID) {
            return true;
        }
        return false;
    }
}
