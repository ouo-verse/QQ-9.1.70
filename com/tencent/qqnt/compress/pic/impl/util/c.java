package com.tencent.qqnt.compress.pic.impl.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Ljava/io/File;", "Landroid/graphics/Bitmap$CompressFormat;", "a", "", "b", "compress_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355761a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39566);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f355761a = iArr;
        }
    }

    @NotNull
    public static final Bitmap.CompressFormat a(@NotNull File file) {
        String extension;
        Intrinsics.checkNotNullParameter(file, "<this>");
        extension = FilesKt__UtilsKt.getExtension(file);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = extension.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "png")) {
            return Bitmap.CompressFormat.PNG;
        }
        if (Intrinsics.areEqual(lowerCase, "webp")) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @NotNull
    public static final String b(@NotNull Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(compressFormat, "<this>");
        int i3 = a.f355761a[compressFormat.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return "jpg";
            }
            return "webp";
        }
        return "png";
    }
}
