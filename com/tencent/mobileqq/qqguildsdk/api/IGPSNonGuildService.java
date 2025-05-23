package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import vh2.bm;
import vh2.y;

@Service(process = {"all"})
/* loaded from: classes17.dex */
public interface IGPSNonGuildService extends IRuntimeService {
    public static final String SP_KEY_IS_NEWUSER_KEY = "SP_KEY_IsNewUserAlreadyRequested_";

    void fetchIsJoinedGuild(y yVar);

    void fetchIsNewUser(bm bmVar);
}
