package com.huya.huyasdk.api;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class HuyaPresenterSubscriptionInfo {
    public long presenterUid = 0;
    public long subscriberUid = 0;

    @Nullable
    public String subscriberNick = "";

    @Nullable
    public String subscriberAvatar = "";

    public String toString() {
        return "HuyaPresenterSubscriptionInfo{presenterUid=" + this.presenterUid + ", subscriberUid=" + this.subscriberUid + ", subscriberNick='" + this.subscriberNick + "', subscriberAvatar='" + this.subscriberAvatar + "'}";
    }
}
