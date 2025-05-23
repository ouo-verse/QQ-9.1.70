package com.tencent.mobileqq.guild.schedule.detail.member;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes14.dex */
public @interface GuildScheduleDetailMemberListViewModel$LoadState {
    public static final int END = 3;
    public static final int HAS_MORE = 2;
    public static final int IDLE = 0;
    public static final int LOADING = 1;
}
