package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {""})
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildGProService;", "Lmqq/app/api/IRuntimeService;", "getGuildInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildId", "", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public interface IGuildGProService extends IRuntimeService {
    @NotNull
    Flow<IGProGuildInfo> getGuildInfo(@NotNull String guildId);
}
