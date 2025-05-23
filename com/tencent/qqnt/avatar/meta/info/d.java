package com.tencent.qqnt.avatar.meta.info;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/info/d;", "", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "", "", "", "b", "(Lcom/tencent/qqnt/avatar/meta/a;)[Ljava/util/Map;", "", "skipMemory", "Lcom/tencent/qqnt/avatar/meta/info/g;", "callback", "", "c", "d", "infoAvatarBean", "", "lastCheckTime", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface d {
    boolean a(@NotNull com.tencent.qqnt.avatar.meta.a infoAvatarBean, long lastCheckTime);

    @NotNull
    Map<String, Object>[] b(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean);

    void c(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean, boolean skipMemory, @NotNull g callback);

    void d(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean, @NotNull g callback);
}
