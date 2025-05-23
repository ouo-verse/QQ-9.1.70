package com.tencent.qqnt.qbasealbum.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016R\u0017\u0010'\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0014\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/URLDrawableHelper;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "photoInfo", "", "decodeType", "Ljava/net/URL;", "a", "path", "", "b", "Landroid/graphics/Bitmap$Config;", "Landroid/graphics/Bitmap$Config;", "getMConfig", "()Landroid/graphics/Bitmap$Config;", "mConfig", "c", "getMThumbConfig", "mThumbConfig", "d", "I", "getSmallSize", "()I", "setSmallSize", "(I)V", "smallSize", "e", "mTargetDensity", "Landroid/graphics/drawable/ColorDrawable;", "f", "Landroid/graphics/drawable/ColorDrawable;", "getTRANSPARENT", "()Landroid/graphics/drawable/ColorDrawable;", "TRANSPARENT", "g", "getAIO_IMAGE_MIN_SIZE", "AIO_IMAGE_MIN_SIZE", tl.h.F, "getAIO_IMAGE_MAX_SIZE", "AIO_IMAGE_MAX_SIZE", "i", "sAioVideoMaxSize", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class URLDrawableHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final URLDrawableHelper f361631a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Bitmap.Config mConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Bitmap.Config mThumbConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int smallSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int mTargetDensity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ColorDrawable TRANSPARENT;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int AIO_IMAGE_MIN_SIZE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final int AIO_IMAGE_MAX_SIZE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int sAioVideoMaxSize;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
            return;
        }
        f361631a = new URLDrawableHelper();
        mConfig = Bitmap.Config.ARGB_8888;
        mThumbConfig = Bitmap.Config.RGB_565;
        smallSize = 921600;
        mTargetDensity = com.tencent.qqnt.qbasealbum.inject.a.f361230a.a().getResources().getDisplayMetrics().densityDpi;
        TRANSPARENT = new ColorDrawable(0);
        AIO_IMAGE_MIN_SIZE = com.tencent.qqnt.qbasealbum.ktx.d.b(45);
        AIO_IMAGE_MAX_SIZE = com.tencent.qqnt.qbasealbum.ktx.d.a(135.0f);
        sAioVideoMaxSize = -1;
    }

    URLDrawableHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final URL a(@NotNull LocalMediaInfo photoInfo, @Nullable String decodeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (URL) iPatchRedirector.redirect((short) 13, (Object) this, (Object) photoInfo, (Object) decodeType);
        }
        Intrinsics.checkNotNullParameter(photoInfo, "photoInfo");
        StringBuilder sb5 = new StringBuilder("qbasealbumthumb");
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(photoInfo.getPath());
        if (decodeType != null) {
            sb5.append("#");
            sb5.append(decodeType);
        }
        try {
            return new URL(sb5.toString());
        } catch (MalformedURLException e16) {
            ox3.a.a(com.tencent.mobileqq.transfile.URLDrawableHelper.TAG, new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.utils.URLDrawableHelper$generateAlbumThumbURL$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ MalformedURLException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "generateAlbumThumbURL error, " + this.$e;
                }
            });
            return null;
        }
    }

    public final int b(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) path)).intValue();
        }
        int heifOrientation = Utils.getHeifOrientation(path);
        if (heifOrientation != 3) {
            if (heifOrientation != 6) {
                if (heifOrientation != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }
}
