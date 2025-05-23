package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;

/* loaded from: classes5.dex */
public class SubscribePublishFeedsEvent extends SimpleBaseEvent {
    public static final int STATE_PUBLISH = 1;
    public CertifiedAccountMeta$StFeed mFeed;
    public List<CertifiedAccountMeta$StFeed> mFeedList;
    public int mState;

    public SubscribePublishFeedsEvent(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, int i3) {
        this.mState = i3;
        this.mFeed = certifiedAccountMeta$StFeed;
    }
}
