package com.tencent.mobileqq.guild.schedule.detail.member;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes14.dex */
public @interface GuildScheduleMemberFetcher$FetchStep {
    public static final int HAS_MORE = 1;
    public static final int INIT = 0;
    public static final int PULL_ENDING = 2;
}
