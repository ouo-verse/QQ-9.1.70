package com.tencent.qqnt.avatar.meta.cache;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J'\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/cache/b;", "", "", "avatarType", "", "id", "", "b", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "infoArr", "a", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;)Ljava/lang/String;", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {
    @NotNull
    String a(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @Nullable com.tencent.qqnt.avatar.meta.info.a[] infoArr);

    void b(int avatarType, @Nullable String id5);
}
