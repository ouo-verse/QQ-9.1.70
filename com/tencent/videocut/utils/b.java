package com.tencent.videocut.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Size;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/videocut/utils/b;", "", "Landroid/graphics/BitmapFactory$Options;", "options", "", "reqWidth", "reqHeight", "a", "", "path", "Landroid/util/Size;", "size", "Landroid/graphics/Bitmap;", "b", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f384233a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7170);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f384233a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    private final int a(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        Pair pair = TuplesKt.to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        int i3 = 1;
        if (intValue > reqHeight || intValue2 > reqWidth) {
            int i16 = intValue / 2;
            int i17 = intValue2 / 2;
            while (i16 / i3 >= reqHeight && i17 / i3 >= reqWidth) {
                i3 *= 2;
            }
        }
        return i3;
    }

    @Nullable
    public final Bitmap b(@NotNull String path, @NotNull Size size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Bitmap) iPatchRedirector.redirect((short) 1, (Object) this, (Object) path, (Object) size);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(size, "size");
        if (!new File(path).exists()) {
            com.tencent.videocut.utils.log.b.a("BitmapUtils", "target file not exit");
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inSampleSize = f384233a.a(options, size.getWidth(), size.getHeight());
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }
}
