package com.tencent.troopguild.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import uo4.c;
import uo4.d;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/troopguild/api/ITroopGuildRecentService;", "Lmqq/app/api/IRuntimeService;", "Luo4/c;", "callback", "", "setRecentListRefreshCallback", "unSetRecentListRefreshCallback", "Luo4/d;", "setTroopAssistantRefreshCallback", "unSetTroopAssistantRefreshCallback", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface ITroopGuildRecentService extends IRuntimeService {
    void setRecentListRefreshCallback(@NotNull c callback);

    void setTroopAssistantRefreshCallback(@NotNull d callback);

    void unSetRecentListRefreshCallback();

    void unSetTroopAssistantRefreshCallback();
}
