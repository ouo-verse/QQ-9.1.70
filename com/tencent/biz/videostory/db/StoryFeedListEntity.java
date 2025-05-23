package com.tencent.biz.videostory.db;

import NS_QQ_STORY_CLIENT.CLIENT$StGetStoryFeedListRsp;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StoryFeedListEntity extends Entity {
    public byte[] storyFeedList = null;

    @unique
    public String uin;

    public void updateStoryFeedListEntity(String str, CLIENT$StGetStoryFeedListRsp cLIENT$StGetStoryFeedListRsp) {
        if (cLIENT$StGetStoryFeedListRsp == null) {
            return;
        }
        this.uin = str;
        this.storyFeedList = cLIENT$StGetStoryFeedListRsp.toByteArray();
    }
}
