package com.tencent.mobileqq.guild.feed.manager.info;

/* compiled from: P */
/* loaded from: classes13.dex */
public enum GuildInfoField {
    IS_PRIVATE_CHANNEL(Boolean.class),
    CHANNEL_NAME(String.class),
    ALL_MUTE_TIME(Long.class),
    USER_MUTE_TIME(Long.class),
    SPEAK_THRESHOLD_LIMITING(Boolean.class),
    IS_RESTRICT_POST(Boolean.class),
    IS_MANAGER(Boolean.class),
    IS_MEMBER(Boolean.class),
    IS_DISTURB(Boolean.class);

    private final Class mClassType;

    GuildInfoField(Class cls) {
        this.mClassType = cls;
    }

    public Class getClassType() {
        return this.mClassType;
    }
}
