package com.tencent.mobileqq.wink.utils;

import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/am;", "", "", "mediaPath", "b", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class am {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final am f326679a = new am();

    static {
        NativeGifImage.loadLibrary();
    }

    am() {
    }

    private final String b(String mediaPath) {
        return u53.a.f438361b + "/" + l.f326716a.a(mediaPath) + "_gif.jpg";
    }

    @Nullable
    public final String a(@NotNull String mediaPath) {
        boolean saveBitmapFileAsJPEG;
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        String b16 = b(mediaPath);
        try {
            if (new File(b16).exists()) {
                saveBitmapFileAsJPEG = true;
            } else {
                saveBitmapFileAsJPEG = BaseImageUtil.saveBitmapFileAsJPEG(new NativeGifImage(new File(mediaPath), true, false, 0, 0, 0.0f).getFirstFrameBitmap(), new File(b16));
            }
            if (!saveBitmapFileAsJPEG) {
                new File(b16).delete();
                return null;
            }
            return b16;
        } catch (Exception e16) {
            w53.b.d("WinkGifUtils", "parse gif image " + mediaPath + " error", e16);
            new File(b16).delete();
            return null;
        }
    }
}
