package com.tencent.mobileqq.tvideo.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoMidAdPlayEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* loaded from: classes19.dex */
public class QFSTVideoTopInfoPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private FrameLayout I;
    private TextView J;
    private Video K;
    private boolean L;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i1() {
        this.K = jy2.g.q((FeedCloudMeta$StFeed) this.f85017h);
        Object b16 = this.E.b("tvideo_material_played_transform");
        if ((!(b16 instanceof Boolean) || !((Boolean) b16).booleanValue()) && !qx2.a.c().k() && !jy2.g.A(this.K)) {
            this.J.setVisibility(0);
            p1();
        } else {
            this.J.setVisibility(8);
        }
    }

    private void j1(final QFSTVideoMidAdPlayEvent qFSTVideoMidAdPlayEvent) {
        pw2.g.a(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.QFSTVideoTopInfoPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                boolean isStart = qFSTVideoMidAdPlayEvent.isStart();
                boolean isComplete = qFSTVideoMidAdPlayEvent.isComplete();
                if (isStart) {
                    QFSTVideoTopInfoPresenter.this.J.setVisibility(8);
                } else if (isComplete) {
                    QFSTVideoTopInfoPresenter.this.i1();
                }
            }
        });
    }

    private void k1(int i3) {
        if (this.J.getVisibility() == 0) {
            VideoBaseInfo videoBaseInfo = this.K.video_base_info;
            int i16 = videoBaseInfo.material_end_time;
            int i17 = videoBaseInfo.material_starting_time;
            QLog.d("QFSTVideoTopInfoPresenter", 4, "playProgress = " + i3 + " materialStartTime = " + i17);
            if ((this.L && i3 < i17) || i3 > i16) {
                this.J.setVisibility(8);
                this.E.o("tvideo_material_played_transform", Boolean.TRUE);
            }
        }
    }

    private void l1(View view) {
        this.I = (FrameLayout) view.findViewById(R.id.uep);
        this.J = (TextView) view.findViewById(R.id.f100075ri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean m1(QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent) {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return false;
        }
        return TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSVideoFeedPlayEvent.feedId);
    }

    private void o1() {
        try {
            this.I.removeAllViews();
        } catch (Exception e16) {
            QLog.d("QFSTVideoTopInfoPresenter", 4, "removeDebugView " + e16);
        }
    }

    private void p1() {
        VideoBaseInfo videoBaseInfo;
        this.J.setText("");
        Video video = this.K;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            this.J.setText(videoBaseInfo.material_title);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        l1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoFeedPlayEvent.class);
        arrayList.add(QFSSeekEvent.class);
        arrayList.add(QFSTVideoMidAdPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.K = jy2.g.q(feedCloudMeta$StFeed);
        i1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        o1();
        this.L = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoFeedPlayEvent) {
            if (E0()) {
                QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent = (QFSVideoFeedPlayEvent) simpleBaseEvent;
                if (m1(qFSVideoFeedPlayEvent)) {
                    k1(qFSVideoFeedPlayEvent.progress);
                    return;
                }
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QFSSeekEvent) {
            this.L = !((QFSSeekEvent) simpleBaseEvent).mIsOnSeek;
        } else if (simpleBaseEvent instanceof QFSTVideoMidAdPlayEvent) {
            j1((QFSTVideoMidAdPlayEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoTopInfoPresenter";
    }
}
