package com.tencent.cachedrawable.dynamicdrawable;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/f;", "", "", "key", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameAnimData", "", "a", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public interface f {
    void a(@NotNull String key, @NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameAnimData);

    @Nullable
    com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b b(@NotNull String key, @Nullable Bitmap bitmap);
}
