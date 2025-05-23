package com.tencent.mobileqq.guild.feed.launcher;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedMainInitBean extends GuildFeedBaseInitBean {
    public boolean hideTitle = false;
    private boolean mIsNewCreated;

    public boolean isNewCreated() {
        return this.mIsNewCreated;
    }

    public GuildFeedMainInitBean setIsNewCreated(boolean z16) {
        this.mIsNewCreated = z16;
        return this;
    }
}
