package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\bJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "pageTag", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi$a;", "getVisitorJoinGuildTimerTaskClass", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQGuildVisitorApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi$a;", "", "", "b", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void a();

        void b();
    }

    @Nullable
    a getVisitorJoinGuildTimerTaskClass(@NotNull String pageTag, @NotNull JumpGuildParam jumpGuildParam);
}
