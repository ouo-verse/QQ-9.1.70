package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGuildBannerMsgType {
    public static final int GUILD_GLOBAL_BANNER_FEED = 2;

    @Deprecated
    public static final int GUILD_GLOBAL_BANNER_SCHEDULE = 102;
    public static final int GUILD_GLOBAL_BANNER_TEXT = 1;

    @Deprecated
    public static final int GUILD_GLOBAL_BANNER_VIDEO = 103;

    @Deprecated
    public static final int GUILD_GLOBAL_BANNER_VOICE = 104;
    public static final int GUILD_WELCOME_BANNER_CUSTOM = 6;
    public static final int GUILD_WELCOME_BANNER_FOR_VISITOR = 7;
    public static final int UNSPECIFIED = 0;
}
