package com.tencent.mobileqq.guild.api;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/api/FeedListDelegateType;", "", "layoutType", "", "(Ljava/lang/String;II)V", "getLayoutType", "()I", "PlainText", "SimpleFeed", "SingleImage", "ThirdPartyShareLink", "TencentDoc", "SmallWorldVideo", "SingleVideo", "ThirdVideo", "LongFeed", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public enum FeedListDelegateType {
    PlainText(1),
    SimpleFeed(4),
    SingleImage(2),
    ThirdPartyShareLink(8),
    TencentDoc(7),
    SmallWorldVideo(9),
    SingleVideo(3),
    ThirdVideo(5),
    LongFeed(100001);

    private final int layoutType;

    FeedListDelegateType(int i3) {
        this.layoutType = i3;
    }

    public final int getLayoutType() {
        return this.layoutType;
    }
}
