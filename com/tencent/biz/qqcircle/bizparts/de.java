package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSRecommendPanelStatusEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSStartVideoEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qcircle.cooperation.config.AccountKickedEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class de extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.qqcircle.helpers.ab f83060d;

    /* renamed from: e, reason: collision with root package name */
    private FeedCloudMeta$StFeed f83061e;

    /* renamed from: f, reason: collision with root package name */
    private String f83062f;

    private void A9(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() == 28 || qCirclePanelStateEvent.getPanelType() == 39) {
            this.f83062f = qCirclePanelStateEvent.getFeedId();
            QLog.d("QFSRecommendPanelAnimPart", 1, "[handlePanelStateEvent] receive feedId:" + this.f83062f);
        }
    }

    private void B9(QFSRecommendPanelStatusEvent qFSRecommendPanelStatusEvent) {
        if (this.f83060d == null) {
            QLog.d("QFSRecommendPanelAnimPart", 1, "mAnimHelper is null. ");
            return;
        }
        if (!TextUtils.equals(qFSRecommendPanelStatusEvent.feedId, this.f83062f)) {
            if (qFSRecommendPanelStatusEvent.status == 4) {
                this.f83060d.p();
                return;
            }
            return;
        }
        if (qFSRecommendPanelStatusEvent.status == 2) {
            this.f83060d.l(qFSRecommendPanelStatusEvent.enableCropVideoCover);
        }
        if (qFSRecommendPanelStatusEvent.status == 3) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QFSRecommendPanelAnimPart", 1, "[handleRecommendSheetEvent] height: " + qFSRecommendPanelStatusEvent.height + ", defaultHeight: " + qFSRecommendPanelStatusEvent.defaultHeight + ", topSpaceHeight: " + qFSRecommendPanelStatusEvent.topSpaceHeight);
            }
            this.f83060d.q(qFSRecommendPanelStatusEvent.defaultHeight);
            this.f83060d.s(qFSRecommendPanelStatusEvent.topSpaceHeight);
            this.f83060d.k(qFSRecommendPanelStatusEvent.height);
        }
        if (qFSRecommendPanelStatusEvent.status == 1) {
            this.f83060d.t();
        }
        if (qFSRecommendPanelStatusEvent.status == 4) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QFSRecommendPanelAnimPart", 1, "[handleRecommendSheetEvent] dismiss. ");
            }
            this.f83060d.d();
            if (qFSRecommendPanelStatusEvent.scene == 1) {
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(28, qFSRecommendPanelStatusEvent.feedId, false));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C9() {
        this.f83060d.d();
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(28, this.f83062f, false));
        SimpleEventBus.getInstance().dispatchEvent(new QFSStartVideoEvent(this.f83062f, false));
    }

    private void z9() {
        if (this.f83060d != null && QCirclePanelStateEvent.isSpecifiedPanelShowing(28)) {
            QLog.d("QFSRecommendPanelAnimPart", 1, "[handleAccountKickedEvent] half web view is showing, dismiss");
            if (getMainHandler() != null) {
                getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dd
                    @Override // java.lang.Runnable
                    public final void run() {
                        de.this.C9();
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSRecommendPanelStatusEvent.class);
        arrayList.add(QCirclePanelStateEvent.class);
        arrayList.add(AccountKickedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals("action_open_similar_panel", str) && (obj instanceof FeedCloudMeta$StFeed)) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) obj;
            this.f83061e = feedCloudMeta$StFeed;
            this.f83062f = com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed);
            QLog.d("QFSRecommendPanelAnimPart", 1, "[handleBroadcastMessage] receive feedId:" + this.f83062f);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f83060d = new com.tencent.biz.qqcircle.helpers.ab(getPartRootView());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSRecommendPanelStatusEvent) {
            B9((QFSRecommendPanelStatusEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            A9((QCirclePanelStateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof AccountKickedEvent) {
            z9();
        }
    }
}
