package com.tencent.qqnt.qbasealbum.urldrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.utils.URLDrawableHelper;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/ThumbDecoder;", "Lcom/tencent/qqnt/qbasealbum/urldrawable/c;", "Ljava/net/URL;", "url", "Landroid/graphics/Bitmap;", "getBitmap", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ThumbDecoder implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo info;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ(\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/ThumbDecoder$a;", "", "", "width", "height", "thumbWidth", "sampleSize", "b", "a", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.urldrawable.ThumbDecoder$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final int b(int width, int height, int thumbWidth, int sampleSize) {
            int i3 = width * height;
            int i16 = thumbWidth * sampleSize * thumbWidth * sampleSize;
            while (true) {
                i16 *= 4;
                if (i3 > i16) {
                    sampleSize *= 2;
                } else {
                    return sampleSize;
                }
            }
        }

        public final int a(int width, int height, int thumbWidth) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(thumbWidth))).intValue();
            }
            if (width > height) {
                i3 = height;
            } else {
                i3 = width;
            }
            while (i3 > thumbWidth * 2) {
                i16 *= 2;
                i3 /= 2;
            }
            return b(width, height, thumbWidth, i16);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ThumbDecoder(@NotNull LocalMediaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) info);
        } else {
            this.info = info;
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
        SafeBitmapFactory.decodeFile(this.info.getPath(), options);
        options.inSampleSize = INSTANCE.a(options.outWidth, options.outHeight, this.info.getThumbWidth());
        options.inJustDecodeBounds = false;
        Bitmap c16 = DecoderUtil.c(this.info, options, "QBaseAlbum.Decoder");
        if (c16 == null) {
            ox3.a.c("QBaseAlbum.Decoder", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.urldrawable.ThumbDecoder$getBitmap$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThumbDecoder.this);
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
                    localMediaInfo = ThumbDecoder.this.info;
                    String path = localMediaInfo.getPath();
                    localMediaInfo2 = ThumbDecoder.this.info;
                    String path2 = localMediaInfo2.getPath();
                    return "ThumbDecoder bitmap is null, path: " + path + ", isExist: " + (path2 != null ? Boolean.valueOf(new File(path2).exists()) : null);
                }
            });
            ox3.a.f("QBaseAlbum.Decoder", ThumbDecoder$getBitmap$2.INSTANCE);
            return null;
        }
        int b16 = URLDrawableHelper.f361631a.b(this.info.getPath());
        if (b16 != 0) {
            return DecoderUtil.d(c16, b16);
        }
        return c16;
    }
}
