package com.tencent.mobileqq.qqguildsdk.tianjige;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GuildNTConstants {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, GuildHistogramScene> f268492a = new HashMap<String, GuildHistogramScene>() { // from class: com.tencent.mobileqq.qqguildsdk.tianjige.GuildNTConstants.1
        {
            put("guild_nt_service_call_duration", GuildHistogramScene.GUILD_NT_SERVICE_CALL_DURATION);
            put("guild_nt_orm_call_duration", GuildHistogramScene.GUILD_NT_ORM_CALL_DURATION);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<String, GuildCounterNames> f268493b = new HashMap<String, GuildCounterNames>() { // from class: com.tencent.mobileqq.qqguildsdk.tianjige.GuildNTConstants.2
        {
            put("guild_nt_db_open_total", GuildCounterNames.NT_DB_OPEN);
            put("guild_nt_service_call_total", GuildCounterNames.NT_SERVICE_CALL);
            put("guild_nt_push_count", GuildCounterNames.NT_PUSH_COUNT);
        }
    };
}
