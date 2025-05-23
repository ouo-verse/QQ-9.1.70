package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model;

/* compiled from: P */
/* loaded from: classes19.dex */
public enum FeedViewSkinType {
    DEFAULT(0),
    DARK(1);

    private final int mValue;

    FeedViewSkinType(int i3) {
        this.mValue = i3;
    }

    public static FeedViewSkinType fromValue(int i3) {
        if (i3 == 1) {
            return DARK;
        }
        return DEFAULT;
    }

    public int getValue() {
        return this.mValue;
    }
}
