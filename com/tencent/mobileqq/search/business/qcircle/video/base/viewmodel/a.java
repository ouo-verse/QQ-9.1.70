package com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a extends p70.a {
    private Object C;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public String S1() {
        return String.valueOf(hashCode());
    }

    public abstract void T1(List<FeedCloudMeta$StFeed> list);

    public boolean U1(Object obj) {
        if (this.C == obj) {
            return false;
        }
        this.C = obj;
        L1();
        return true;
    }

    public abstract void W1(String str);

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>(1);
        arrayList.add(QFSVideoFeedPlayEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoFeedPlayEvent) {
            QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent = (QFSVideoFeedPlayEvent) simpleBaseEvent;
            if (TextUtils.equals(qFSVideoFeedPlayEvent.globalKey, S1())) {
                R1(qFSVideoFeedPlayEvent.feedId, qFSVideoFeedPlayEvent.progress);
            }
        }
    }
}
