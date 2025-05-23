package com.tencent.biz.qqcircle.manager;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StIconDecorate;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public enum QCircleAvatarDecorateManager implements SimpleEventReceiver {
    INSTANCE;

    private static final String TAG = "QCircleAvatarDecorateManager";
    private FeedCloudMeta$StIconDecorate mOwnerAvatarDecorateInfo;

    public boolean enableDecorateManagerEntrance() {
        return com.tencent.biz.qqcircle.f.d();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AccountChangeEvent.class);
        return arrayList;
    }

    public FeedCloudMeta$StIconDecorate getOwnerAvatarDecorateInfo() {
        return this.mOwnerAvatarDecorateInfo;
    }

    public void init() {
        QLog.d(TAG, 1, "QCircleRefreshIconDecorate QCircleAvatarDecorateManager init");
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AccountChangeEvent) {
            reset();
        }
    }

    public void reset() {
        QLog.d(TAG, 1, "QCircleRefreshIconDecorate QCircleAvatarDecorateManager reset");
        this.mOwnerAvatarDecorateInfo = null;
    }

    public void setOwnerAvatarDecorateInfo(FeedCloudMeta$StIconDecorate feedCloudMeta$StIconDecorate) {
        this.mOwnerAvatarDecorateInfo = feedCloudMeta$StIconDecorate;
    }
}
