package com.tencent.mobileqq.guild.rolegroup.bindpermission.actions;

import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "", "guildId", "", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/previewavatar/a$b;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f {
    @NotNull
    public static final List<a.b> a(@Nullable List<? extends IGProUserInfo> list, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (IGProUserInfo iGProUserInfo : list) {
                arrayList.add(new a.b(2, guildId, iGProUserInfo.getTinyId(), ch.d0(iGProUserInfo)));
            }
        }
        return arrayList;
    }
}
