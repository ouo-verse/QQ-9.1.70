package com.tencent.qqnt.avatar.meta.transform;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qqnt.avatar.layer.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a2\u0006\u0004\b\b\u0010\tJ5\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H&\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/transform/b;", "", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfoArr", "", "a", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;)Z", "Landroid/graphics/Bitmap;", "bitmapArr", "b", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/qqnt/avatar/layer/c;", "c", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;Landroid/graphics/Bitmap;)Lcom/tencent/qqnt/avatar/layer/c;", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        @Nullable
        public static c a(@NotNull b bVar, @NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
            Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            return null;
        }
    }

    boolean a(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr);

    @Nullable
    Bitmap b(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap[] bitmapArr);

    @Nullable
    c c(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap bitmap);
}
