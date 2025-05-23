package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSDoTopProfileEvent;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;

/* compiled from: P */
/* loaded from: classes4.dex */
public class az extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private QCircleDoubleClickLayout I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QCircleDoubleClickLayout.c {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.c
        public void a(MotionEvent motionEvent) {
            az azVar = az.this;
            azVar.T0(new com.tencent.biz.qqcircle.immersive.feed.event.ak(((FeedCloudMeta$StFeed) azVar.f85017h).f398449id.get(), motionEvent));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (QCircleDoubleClickLayout) view.findViewById(R.id.v_o);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = (QQCircleDitto$StCircleDittoDataNew) this.E.b("DITTO_FEED_PUBLISH_TEMPLATE");
        if (qQCircleDitto$StCircleDittoDataNew != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.get() != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.size() > 0 && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.size() > 0) {
            super.L0(qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.get(0), i3);
            this.I.setOnTapClickListener(new a());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSDoTopProfileEvent.class);
        return eventClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSDoTopProfileEvent) {
            QFSDoTopProfileEvent qFSDoTopProfileEvent = (QFSDoTopProfileEvent) simpleBaseEvent;
            T t16 = this.f85017h;
            if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSDoTopProfileEvent.mTargetFeedId)) {
                if (qFSDoTopProfileEvent.isDoProfile) {
                    ((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().add(20);
                } else {
                    ((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().remove((Object) 20);
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildPublishDoublePraisePresenter";
    }
}
