package com.tencent.biz.qqcircle.immersive.part;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPRatePlayGuideEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ex extends QFSFullScreenRatePlayGuidePart {

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f88074h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f88075i;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        A9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart
    protected String B9() {
        if (com.tencent.biz.qqcircle.utils.cb.b()) {
            return super.B9();
        }
        return "https://downV6.qq.com/video_story/qcircle/pag/video_rate_play_gesture.pag";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart
    protected Drawable C9() {
        if (com.tencent.biz.qqcircle.utils.cb.b()) {
            return RFWApplication.getApplication().getDrawable(R.drawable.ooa);
        }
        return RFWApplication.getApplication().getDrawable(R.drawable.oob);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart
    protected void H9() {
        super.H9();
        this.f88074h = (FrameLayout) this.f86591d.findViewById(R.id.f5149289);
        this.f88075i = (FrameLayout) this.f86591d.findViewById(R.id.f515028_);
        if (com.tencent.biz.qqcircle.utils.cb.b()) {
            QFSPagAnimView qFSPagAnimView = (QFSPagAnimView) this.f86591d.findViewById(R.id.f515128a);
            this.f86592e = qFSPagAnimView;
            qFSPagAnimView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.ew
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ex.this.F9(view);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart
    protected boolean I9(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!super.I9(feedCloudMeta$StFeed)) {
            return false;
        }
        if (com.tencent.biz.qqcircle.utils.cb.b()) {
            FrameLayout frameLayout = this.f88074h;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
                QLog.d(getTAG(), 1, "mOldGuidFrame setGone");
            }
            FrameLayout frameLayout2 = this.f88075i;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
                QLog.d(getTAG(), 1, "mNewGuidFrame setVisible");
            }
        } else {
            FrameLayout frameLayout3 = this.f88074h;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(0);
                QLog.d(getTAG(), 1, "mOldGuidFrame setVisible");
            }
            FrameLayout frameLayout4 = this.f88075i;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
                QLog.d(getTAG(), 1, "mNewGuidFrame setGone");
            }
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRatePlayLayerGuidePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPRatePlayGuideEvent) {
            QFSPRatePlayGuideEvent qFSPRatePlayGuideEvent = (QFSPRatePlayGuideEvent) simpleBaseEvent;
            if (!qFSPRatePlayGuideEvent.isFuLLScreen() && E9(qFSPRatePlayGuideEvent)) {
                H9();
                I9(qFSPRatePlayGuideEvent.getFeed());
            }
        }
    }
}
