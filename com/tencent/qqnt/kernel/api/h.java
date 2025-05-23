package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.AvatarSize;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/kernel/api/h;", "Lcom/tencent/qqnt/kernel/api/j;", "", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/AvatarSize;", "size", "getAvatarPath", "", "groupCode", "getGroupAvatarPath", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface h extends j {
    @NotNull
    String getAvatarPath(@NotNull String uid, @NotNull AvatarSize size);

    @NotNull
    String getGroupAvatarPath(long groupCode, @NotNull AvatarSize size);
}
