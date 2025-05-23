package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.co;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00040\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/y;", "", "", "url", "", "b", "noticeId", "actionId", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "guildNotice", "a", "guildId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "block", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface y {
    void a(@NotNull co guildNotice);

    void b(@NotNull String url);

    void c(@NotNull String noticeId, @NotNull String actionId);

    void d(@NotNull String guildId, @NotNull Function1<? super IGProGuildInfo, Unit> block);
}
