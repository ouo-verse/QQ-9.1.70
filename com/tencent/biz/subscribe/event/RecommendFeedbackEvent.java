package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RecommendFeedbackEvent extends SimpleBaseEvent {
    public static final int FEEDBACK_TYPE_RECOMMEND_BANNER_FEED = 2;
    public static final int FEEDBACK_TYPE_RECOMMEND_BANNER_USER = 1;
    public CertifiedAccountMeta$StFeed feed;
    public int type = 2;
    public CertifiedAccountMeta$StUser user;

    public RecommendFeedbackEvent(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
        this.user = certifiedAccountMeta$StUser;
    }

    public RecommendFeedbackEvent(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        this.feed = certifiedAccountMeta$StFeed;
    }
}
