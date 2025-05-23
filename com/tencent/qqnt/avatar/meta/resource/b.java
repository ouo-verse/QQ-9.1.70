package com.tencent.qqnt.avatar.meta.resource;

import android.graphics.Bitmap;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/resource/b;", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfo", "", "size", "Landroid/graphics/Bitmap;", "b", "", "url", "Ljava/io/File;", "file", "Lcom/tencent/qqnt/avatar/meta/resource/a;", "callback", "", "c", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {
    @Nullable
    File a(@NotNull String url);

    @Nullable
    Bitmap b(@NotNull com.tencent.qqnt.avatar.meta.info.a avatarInfo, int size);

    void c(@NotNull String url, @NotNull File file, @NotNull a callback);
}
