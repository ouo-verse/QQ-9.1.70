package com.tencent.mobileqq.guild.media.core.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserBarNodePermission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00000\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserBarNodePermission;", "Lcom/tencent/mobileqq/guild/media/core/data/d;", "a", "", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {
    @NotNull
    public static final GuildMediaUserBarNodePermission a(@NotNull IGProUserBarNodePermission iGProUserBarNodePermission) {
        Intrinsics.checkNotNullParameter(iGProUserBarNodePermission, "<this>");
        return new GuildMediaUserBarNodePermission(iGProUserBarNodePermission.getNodeType(), iGProUserBarNodePermission.getVisibleType());
    }

    @NotNull
    public static final List<GuildMediaUserBarNodePermission> b(@NotNull List<? extends IGProUserBarNodePermission> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends IGProUserBarNodePermission> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }
}
