package com.tencent.biz.qqcircle.bean;

import androidx.annotation.NonNull;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import feedcloud.FeedCloudWrite$PushBoxBasicDrawInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPushBoxBean {
    private String authUin;
    private String feedId;
    private List<QFSPushBoxDrawInfo> pushBoxDrawInfos = new ArrayList();
    private QFSPushBoxViewInfo pushBoxViewInfo;

    /* loaded from: classes4.dex */
    public static class QFSPushBoxDrawInfo {
        private int boxType;
        private long count;
        private float rate;

        public QFSPushBoxDrawInfo(@NonNull FeedCloudWrite$PushBoxBasicDrawInfo feedCloudWrite$PushBoxBasicDrawInfo) {
            this.boxType = feedCloudWrite$PushBoxBasicDrawInfo.box_type.get();
            this.rate = feedCloudWrite$PushBoxBasicDrawInfo.rate.get();
            this.count = feedCloudWrite$PushBoxBasicDrawInfo.count.get();
        }

        public FeedCloudWrite$PushBoxBasicDrawInfo getPushBoxViewInfo() {
            FeedCloudWrite$PushBoxBasicDrawInfo feedCloudWrite$PushBoxBasicDrawInfo = new FeedCloudWrite$PushBoxBasicDrawInfo();
            feedCloudWrite$PushBoxBasicDrawInfo.box_type.set(this.boxType);
            feedCloudWrite$PushBoxBasicDrawInfo.rate.set(this.rate);
            feedCloudWrite$PushBoxBasicDrawInfo.count.set(this.count);
            return feedCloudWrite$PushBoxBasicDrawInfo;
        }
    }

    /* loaded from: classes4.dex */
    public static class QFSPushBoxViewInfo {
        private final int availableBoxCnt;
        private final int boxType;
        private final String desc;
        private final long drawCount;
        private final float loading;
        private final String pushTime;
        private final String rulesJumpUrl;
        private final int viewType;

        public QFSPushBoxViewInfo(FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo) {
            this.viewType = feedCloudMeta$PushBoxViewInfo.viewType.get();
            this.loading = feedCloudMeta$PushBoxViewInfo.loading.get();
            this.boxType = feedCloudMeta$PushBoxViewInfo.boxType.get();
            this.drawCount = feedCloudMeta$PushBoxViewInfo.drawCount.get();
            this.desc = feedCloudMeta$PushBoxViewInfo.desc.get();
            this.availableBoxCnt = feedCloudMeta$PushBoxViewInfo.available_box_cnt.get();
            this.rulesJumpUrl = feedCloudMeta$PushBoxViewInfo.rules_jump_url.get();
            this.pushTime = feedCloudMeta$PushBoxViewInfo.push_time.get();
        }

        public FeedCloudMeta$PushBoxViewInfo getPushBoxViewInfo() {
            FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo = new FeedCloudMeta$PushBoxViewInfo();
            feedCloudMeta$PushBoxViewInfo.viewType.set(this.viewType);
            feedCloudMeta$PushBoxViewInfo.boxType.set(this.boxType);
            feedCloudMeta$PushBoxViewInfo.loading.set(this.loading);
            feedCloudMeta$PushBoxViewInfo.drawCount.set(this.drawCount);
            feedCloudMeta$PushBoxViewInfo.desc.set(this.desc);
            feedCloudMeta$PushBoxViewInfo.available_box_cnt.set(this.availableBoxCnt);
            feedCloudMeta$PushBoxViewInfo.rules_jump_url.set(this.rulesJumpUrl);
            feedCloudMeta$PushBoxViewInfo.push_time.set(this.pushTime);
            return feedCloudMeta$PushBoxViewInfo;
        }
    }

    public QFSPushBoxBean(@NonNull FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic) {
        this.feedId = feedCloudWrite$PushBoxBasic.feed_id.get();
        this.authUin = feedCloudWrite$PushBoxBasic.auth_uin.get();
        Iterator<FeedCloudWrite$PushBoxBasicDrawInfo> it = feedCloudWrite$PushBoxBasic.drawBoxInfo.get().iterator();
        while (it.hasNext()) {
            this.pushBoxDrawInfos.add(new QFSPushBoxDrawInfo(it.next()));
        }
        this.pushBoxViewInfo = new QFSPushBoxViewInfo(feedCloudWrite$PushBoxBasic.pushBoxViewInfo.get());
    }

    public String getFeedId() {
        return this.feedId;
    }

    public List<QFSPushBoxDrawInfo> getPushBoxDrawInfos() {
        return this.pushBoxDrawInfos;
    }

    public FeedCloudMeta$PushBoxViewInfo getPushBoxViewInfo() {
        return this.pushBoxViewInfo.getPushBoxViewInfo();
    }
}
