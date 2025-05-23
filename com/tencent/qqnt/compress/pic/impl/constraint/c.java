package com.tencent.qqnt.compress.pic.impl.constraint;

import android.graphics.Bitmap;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/compress/pic/impl/constraint/c;", "Lcom/tencent/qqnt/compress/pic/impl/constraint/b;", "Ljava/io/File;", "imageFile", "", "a", "b", "", "I", "width", "height", "Landroid/graphics/Bitmap$CompressFormat;", "c", "Landroid/graphics/Bitmap$CompressFormat;", "format", "d", CustomImageProps.QUALITY, "", "e", UserInfo.SEX_FEMALE, "maxRatio", "f", "Z", "isSolved", "<init>", "(IILandroid/graphics/Bitmap$CompressFormat;IF)V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bitmap.CompressFormat format;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int quality;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float maxRatio;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isSolved;

    public c(int i3, int i16, @NotNull Bitmap.CompressFormat format, int i17, float f16) {
        Intrinsics.checkNotNullParameter(format, "format");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), format, Integer.valueOf(i17), Float.valueOf(f16));
            return;
        }
        this.width = i3;
        this.height = i16;
        this.format = format;
        this.quality = i17;
        this.maxRatio = f16;
    }

    @Override // com.tencent.qqnt.compress.pic.impl.constraint.b
    public boolean a(@NotNull File imageFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageFile)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        return this.isSolved;
    }

    @Override // com.tencent.qqnt.compress.pic.impl.constraint.b
    @Nullable
    public File b(@NotNull File imageFile) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (File) iPatchRedirector.redirect((short) 4, (Object) this, (Object) imageFile);
        }
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        this.isSolved = true;
        Bitmap d16 = com.tencent.qqnt.compress.pic.impl.util.a.f355759a.d(imageFile, this.width, this.height, this.maxRatio);
        if (d16 != null) {
            bitmap = com.tencent.qqnt.compress.pic.impl.util.b.f355760a.a(d16);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        if (com.tencent.qqnt.util.bitmap.a.f362978a.b(imageFile)) {
            com.tencent.qqnt.compress.pic.impl.util.b.f355760a.b(bitmap);
        }
        return com.tencent.qqnt.compress.pic.impl.util.b.f355760a.c(imageFile, bitmap, this.format, this.quality);
    }

    public /* synthetic */ c(int i3, int i16, Bitmap.CompressFormat compressFormat, int i17, float f16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? com.tencent.qqnt.compress.pic.config.a.AIO_THUMB_PX_MAX : i3, (i18 & 2) != 0 ? com.tencent.qqnt.compress.pic.config.a.AIO_THUMB_PX_MAX : i16, (i18 & 4) != 0 ? Bitmap.CompressFormat.JPEG : compressFormat, (i18 & 8) != 0 ? 70 : i17, (i18 & 16) != 0 ? 3.0f : f16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), compressFormat, Integer.valueOf(i17), Float.valueOf(f16), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
