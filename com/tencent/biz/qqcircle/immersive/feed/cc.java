package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSSeekBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.media.QUISeekBar;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cc extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements QUISeekBar.d {
    private QFSSeekBar I;
    private long J;
    private boolean K = false;

    /* JADX WARN: Multi-variable type inference failed */
    private void g1(QCirclePanelStateEvent qCirclePanelStateEvent) {
        QFSSeekBar qFSSeekBar;
        float f16;
        T t16 = this.f85017h;
        if (t16 == 0 || !TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qCirclePanelStateEvent.getFeedId()) || qCirclePanelStateEvent.getPanelType() != 21 || (qFSSeekBar = this.I) == null) {
            return;
        }
        if (h1() && !qCirclePanelStateEvent.isShowing()) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        qFSSeekBar.setAlpha(f16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean h1() {
        T t16;
        if (this.K || (t16 = this.f85017h) == 0 || ((FeedCloudMeta$StFeed) t16).video == null) {
            return true;
        }
        long j3 = ((FeedCloudMeta$StFeed) t16).video.duration.get();
        if (this.J > 0 && j3 > 0 && ((FeedCloudMeta$StFeed) this.f85017h).video.duration.get() <= this.J) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.widget.media.QUISeekBar.d
    public void F() {
        float f16;
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "[changToMinStyle]");
        }
        QFSSeekBar qFSSeekBar = this.I;
        if (qFSSeekBar == null) {
            return;
        }
        if (h1()) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        qFSSeekBar.setAlpha(f16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
        QFSSeekBar qFSSeekBar = (QFSSeekBar) view.findViewById(R.id.vad);
        this.I = qFSSeekBar;
        qFSSeekBar.A(this);
        this.J = com.tencent.biz.qqcircle.utils.co.a();
        QLog.d(getTAG(), 1, "[onInitView] mHideVideoDuration=" + this.J);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCirclePanelStateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.widget.media.QUISeekBar.d
    public void h() {
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "[changeToMiddleStyle]");
        }
        if (this.K) {
            QLog.d(getTAG(), 2, "[changeToMiddleStyle] ad feed, return.");
            return;
        }
        QFSSeekBar qFSSeekBar = this.I;
        if (qFSSeekBar != null) {
            qFSSeekBar.setAlpha(1.0f);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        long j3;
        boolean z16;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) != null) {
            j3 = feedCloudMeta$StVideo.duration.get();
        } else {
            j3 = 0;
        }
        if (com.tencent.biz.qqcircle.immersive.adapter.n.e(feedCloudMeta$StFeed) == 4003) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.K = z16;
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "[onBindData] videDuration=" + j3 + ", mHideVideoDuration=" + this.J + ", mNeedHideAdSeekBar=" + this.K);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        QFSSeekBar qFSSeekBar = this.I;
        if (qFSSeekBar != null) {
            qFSSeekBar.V(this);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            g1((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.widget.media.QUISeekBar.d
    public void p() {
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "[videoDuration]");
        }
        if (this.K) {
            QLog.d(getTAG(), 2, "[changeToMaxStyle] ad feed, return.");
            return;
        }
        QFSSeekBar qFSSeekBar = this.I;
        if (qFSSeekBar != null) {
            qFSSeekBar.setAlpha(1.0f);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildVideoSeekBarVisibleControlPresenter";
    }
}
