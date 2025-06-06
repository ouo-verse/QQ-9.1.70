package com.tencent.mobileqq.guild.share;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "HOME", "SCHEDULE", "LIVE", "AV", "LLM_CONVERSATION", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GuildArkBusiId {
    HOME("pd_home"),
    SCHEDULE("pd_schedule"),
    LIVE("pd_live"),
    AV("pd_av"),
    LLM_CONVERSATION("pd_aisearch");


    @NotNull
    private final String id;

    GuildArkBusiId(String str) {
        this.id = str;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }
}
