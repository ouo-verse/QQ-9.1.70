package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.feed.CertifiedFakeFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeFeedsEvent extends SimpleBaseEvent {
    public static final int STATE_COMPLETE = 2;
    public static final int STATE_CREATE = 1;
    public static final int STATE_DELETE = 3;
    public static final int STATE_INIT_FAKE_DATA = 4;
    public List<CertifiedAccountMeta$StFeed> mFakeFeedDataList;
    public CertifiedAccountMeta$StFeed mSingleFakeFeed;
    public int mState;
    public String mTargetId;

    public SubscribeFeedsEvent(CertifiedFakeFeed certifiedFakeFeed, int i3) {
        this.mState = i3;
        if (certifiedFakeFeed != null) {
            this.mTargetId = "fakeid_" + certifiedFakeFeed.getClientKey();
            this.mSingleFakeFeed = b(certifiedFakeFeed, i3);
        }
    }

    private CertifiedAccountMeta$StFeed b(CertifiedFakeFeed certifiedFakeFeed, int i3) {
        String str;
        String coverPath;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
        PBStringField pBStringField = certifiedAccountMeta$StFeed.f24925id;
        if (i3 == 2) {
            str = certifiedFakeFeed.getFeedId();
        } else {
            str = "fakeid_" + certifiedFakeFeed.getClientKey();
        }
        pBStringField.set(str);
        certifiedAccountMeta$StFeed.title.set(certifiedFakeFeed.getTitle());
        certifiedAccountMeta$StFeed.content.set(certifiedFakeFeed.getContent());
        certifiedAccountMeta$StFeed.poster.f24929id.set(certifiedFakeFeed.getPuin());
        certifiedAccountMeta$StFeed.poster.setHasFlag(true);
        certifiedAccountMeta$StFeed.type.set(certifiedFakeFeed.getFeedType());
        certifiedAccountMeta$StFeed.createTime.set(certifiedFakeFeed.getCreateTime());
        PBStringField pBStringField2 = certifiedAccountMeta$StFeed.cover.url;
        if (certifiedFakeFeed.getCoverPath() == null) {
            coverPath = "";
        } else {
            coverPath = certifiedFakeFeed.getCoverPath();
        }
        pBStringField2.set(coverPath);
        certifiedAccountMeta$StFeed.cover.setHasFlag(true);
        int feedType = certifiedFakeFeed.getFeedType();
        if (feedType != 0 && feedType != 3) {
            certifiedAccountMeta$StFeed.cover.width.set(certifiedFakeFeed.getWidth());
            certifiedAccountMeta$StFeed.cover.height.set(certifiedFakeFeed.getHeight());
        } else {
            certifiedAccountMeta$StFeed.video.width.set(certifiedFakeFeed.getWidth());
            certifiedAccountMeta$StFeed.video.height.set(certifiedFakeFeed.getHeight());
            certifiedAccountMeta$StFeed.video.duration.set(certifiedFakeFeed.getDuration());
            certifiedAccountMeta$StFeed.video.setHasFlag(true);
        }
        return certifiedAccountMeta$StFeed;
    }

    public SubscribeFeedsEvent(String str, int i3) {
        this.mState = i3;
        if (str != null) {
            this.mTargetId = str;
        }
    }

    public SubscribeFeedsEvent(List<CertifiedFakeFeed> list) {
        if (list == null) {
            return;
        }
        this.mState = 4;
        this.mFakeFeedDataList = new ArrayList();
        Iterator<CertifiedFakeFeed> it = list.iterator();
        while (it.hasNext()) {
            this.mFakeFeedDataList.add(b(it.next(), 1));
        }
    }

    public SubscribeFeedsEvent(int i3) {
        this.mState = i3;
    }
}
