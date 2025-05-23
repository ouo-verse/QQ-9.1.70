package com.tencent.qqnt.qbasealbum.urldrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.utils.URLDrawableHelper;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/ImagePreviewDecoder;", "Lcom/tencent/qqnt/qbasealbum/urldrawable/c;", "Ljava/net/URL;", "url", "Landroid/graphics/Bitmap;", "getBitmap", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mInfo", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ImagePreviewDecoder implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo mInfo;

    public ImagePreviewDecoder(@NotNull LocalMediaInfo mInfo) {
        Intrinsics.checkNotNullParameter(mInfo, "mInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mInfo);
        } else {
            this.mInfo = mInfo;
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.urldrawable.c
    @Nullable
    public Bitmap getBitmap(@NotNull URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(this.mInfo.getPath(), options);
        options.inSampleSize = 1;
        options.inJustDecodeBounds = false;
        Bitmap c16 = DecoderUtil.c(this.mInfo, options, "QBaseAlbum.Decoder");
        if (c16 == null) {
            ox3.a.c("QBaseAlbum.Decoder", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.urldrawable.ImagePreviewDecoder$getBitmap$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImagePreviewDecoder.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    LocalMediaInfo localMediaInfo;
                    LocalMediaInfo localMediaInfo2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    localMediaInfo = ImagePreviewDecoder.this.mInfo;
                    String path = localMediaInfo.getPath();
                    localMediaInfo2 = ImagePreviewDecoder.this.mInfo;
                    String path2 = localMediaInfo2.getPath();
                    return "ImagePreviewDecoder bitmap is null, path: " + path + ", isExist: " + (path2 != null ? Boolean.valueOf(new File(path2).exists()) : null);
                }
            });
            QLog.e("ImagePreviewDecoder", 2, "decode bitmap return null,maybe oom");
            return null;
        }
        int b16 = URLDrawableHelper.f361631a.b(this.mInfo.getPath());
        if (b16 != 0) {
            return DecoderUtil.d(c16, b16);
        }
        return c16;
    }
}
