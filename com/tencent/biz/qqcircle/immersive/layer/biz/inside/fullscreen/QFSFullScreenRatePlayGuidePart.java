package com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPRatePlayGuideEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.qqcircle.utils.ce;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QFSFullScreenRatePlayGuidePart extends u implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    protected View f86591d;

    /* renamed from: e, reason: collision with root package name */
    protected QFSPagAnimView f86592e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f86593f;

    private void D9() {
        this.f86593f = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart.1
            @Override // java.lang.Runnable
            public void run() {
                QFSFullScreenRatePlayGuidePart.this.A9();
                QLog.d(QFSFullScreenRatePlayGuidePart.this.getTAG(), 1, "disMiss pagView:" + QFSFullScreenRatePlayGuidePart.this.hashCode());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        A9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        A9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A9() {
        View view = this.f86591d;
        if (view == null) {
            return;
        }
        cb.f92740b = false;
        view.setVisibility(8);
        this.f86592e.V();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String B9() {
        return "https://downV6.qq.com/video_story/qcircle/pag/video_rate_play_full_screen_gesture.pag";
    }

    protected Drawable C9() {
        return RFWApplication.getApplication().getDrawable(R.drawable.ooa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean E9(QFSPRatePlayGuideEvent qFSPRatePlayGuideEvent) {
        if (getActivity() == null || qFSPRatePlayGuideEvent.getContextHashCode() != getActivity().hashCode()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H9() {
        View view = this.f86591d;
        if (view != null) {
            view.setVisibility(8);
            return;
        }
        View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f515428d)).inflate();
        this.f86591d = inflate;
        inflate.setVisibility(8);
        this.f86592e = (QFSPagAnimView) this.f86591d.findViewById(R.id.f5148288);
        this.f86591d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSFullScreenRatePlayGuidePart.this.F9(view2);
            }
        });
        this.f86592e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSFullScreenRatePlayGuidePart.this.G9(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I9(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (cb.a()) {
            return false;
        }
        if (QCirclePanelStateEvent.isSpecifiedPanelShowing(0)) {
            QLog.d(getTAG(), 1, "comment panel is show");
            return false;
        }
        cb.f92740b = true;
        cb.h();
        this.f86591d.setVisibility(0);
        this.f86592e.Q(C9());
        this.f86592e.M(B9());
        getMainHandler().removeCallbacks(this.f86593f);
        getMainHandler().postDelayed(this.f86593f, 4000L);
        cb.f(this.f86591d, QCircleDaTongConstant.ElementId.EM_XSJ_SPEED_GUIDE_GESTURE, feedCloudMeta$StFeed, getHostFragment().getReportBean().getDtPageId());
        QLog.d("QFSFullScreenRatePlayGuidePart", 1, "show pag view:" + hashCode());
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPRatePlayGuideEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFullScreenRatePlayGuidePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        cb.f92739a = true;
        D9();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QLog.d(getTAG(), 1, "onPartDestroy:" + hashCode());
        getMainHandler().removeCallbacks(this.f86593f);
        A9();
        cb.f92739a = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPRatePlayGuideEvent) {
            QFSPRatePlayGuideEvent qFSPRatePlayGuideEvent = (QFSPRatePlayGuideEvent) simpleBaseEvent;
            if (!qFSPRatePlayGuideEvent.isFuLLScreen() || !E9(qFSPRatePlayGuideEvent) || ce.c(getContext())) {
                return;
            }
            H9();
            I9(qFSPRatePlayGuideEvent.getFeed());
        }
    }
}
