package com.tencent.mobileqq.guild.gift.module;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/module/e;", "", "", "giftId", "", "receiver", "Lcom/tencent/mobileqq/qqgift/data/service/c;", "b", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "c", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {
    boolean a(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data);

    @Nullable
    com.tencent.mobileqq.qqgift.data.service.c b(int giftId, long receiver);

    @Nullable
    com.tencent.mobileqq.qqgift.mvvm.business.anim.a c(@NotNull com.tencent.mobileqq.qqgift.data.service.d data);
}
