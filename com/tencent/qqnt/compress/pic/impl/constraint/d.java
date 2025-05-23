package com.tencent.qqnt.compress.pic.impl.constraint;

import android.graphics.Bitmap;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/compress/pic/impl/constraint/a;", "", "width", "height", "Landroid/graphics/Bitmap$CompressFormat;", "format", CustomImageProps.QUALITY, "", "a", "compress_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d {
    public static final void a(@NotNull a aVar, int i3, int i16, @NotNull Bitmap.CompressFormat format, int i17) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        aVar.a(new c(i3, i16, format, i17, 0.0f, 16, null));
    }

    public static /* synthetic */ void b(a aVar, int i3, int i16, Bitmap.CompressFormat compressFormat, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = 720;
        }
        if ((i18 & 2) != 0) {
            i16 = 720;
        }
        if ((i18 & 4) != 0) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if ((i18 & 8) != 0) {
            i17 = 70;
        }
        a(aVar, i3, i16, compressFormat, i17);
    }
}
