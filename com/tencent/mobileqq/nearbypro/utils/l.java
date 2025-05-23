package com.tencent.mobileqq.nearbypro.utils;

import android.graphics.BitmapFactory;
import android.util.Size;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.utils.FileUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/l;", "", "", "filePath", "Landroid/util/Size;", "a", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f253953a = new l();

    l() {
    }

    @NotNull
    public final Size a(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (!FileUtils.fileExistsAndNotEmpty(filePath)) {
            return new Size(0, 0);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(filePath, options);
        if (RichMediaUtil.isPicLandscape(filePath)) {
            return new Size(options.outWidth, options.outHeight);
        }
        return new Size(options.outHeight, options.outWidth);
    }
}
