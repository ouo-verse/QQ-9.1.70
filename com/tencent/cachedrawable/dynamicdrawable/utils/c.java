package com.tencent.cachedrawable.dynamicdrawable.utils;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/utils/c;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Ljava/io/FileOutputStream;", "outputStream", "", "a", "sourceBitmap", "b", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f99061a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11366);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f99061a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Bitmap bitmap, @NotNull FileOutputStream outputStream) {
        Bitmap.CompressFormat compressFormat;
        Bitmap.CompressFormat compressFormat2;
        Bitmap.CompressFormat compressFormat3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap, (Object) outputStream);
            return;
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                if (!com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.f()) {
                    compressFormat3 = Bitmap.CompressFormat.WEBP_LOSSY;
                    bitmap.compress(compressFormat3, 100, outputStream);
                } else {
                    compressFormat2 = Bitmap.CompressFormat.WEBP_LOSSLESS;
                    bitmap.compress(compressFormat2, 100, outputStream);
                }
            } else if (!com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.e()) {
                bitmap.compress(Bitmap.CompressFormat.WEBP, 100, outputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            }
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 30) {
                compressFormat = Bitmap.CompressFormat.WEBP_LOSSY;
                bitmap.compress(compressFormat, 100, outputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.WEBP, 100, outputStream);
            }
        }
    }

    @NotNull
    public final Bitmap b(@NotNull Bitmap sourceBitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sourceBitmap);
        }
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        Bitmap createBitmap = Bitmap.createBitmap(sourceBitmap.getWidth(), sourceBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(sourceBitma\u2026 Bitmap.Config.ARGB_8888)");
        ByteBuffer allocate = ByteBuffer.allocate(sourceBitmap.getByteCount());
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(sourceBitmap.byteCount)");
        sourceBitmap.copyPixelsToBuffer(allocate);
        allocate.rewind();
        createBitmap.copyPixelsFromBuffer(allocate);
        return createBitmap;
    }
}
