package com.tencent.mobileqq.tvideo.like;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSDoublePraiseEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QFSLikeImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.tvideo.pr.TVideoRightPrPositionEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;
import jy2.g;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;
import tvideo.AttitudeInfo;
import tvideo.TVideoLike$UserAttitudeOption;
import tvideo.TVideoLike$UserAttitudeOptionRequest;
import tvideo.Video;
import zt2.e;

/* loaded from: classes19.dex */
public class QFSTVideoLikePresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private ViewStub I;
    private View J;
    private QFSLikeImageView K;
    private TextView L;
    private ViewStub M;
    private View N;
    private QFSLikeImageView P;
    private TextView Q;
    private Video R;
    private AttitudeInfo S;
    private int T;
    private long V;
    private boolean U = false;
    Runnable W = new Runnable() { // from class: com.tencent.mobileqq.tvideo.like.QFSTVideoLikePresenter.4
        @Override // java.lang.Runnable
        public void run() {
            QLog.d("QFSTVideoLikePresenter", 1, "mRootView y = " + QFSTVideoLikePresenter.this.J.getY());
            TVideoRightPrPositionEvent tVideoRightPrPositionEvent = new TVideoRightPrPositionEvent();
            tVideoRightPrPositionEvent.setYPosition((int) QFSTVideoLikePresenter.this.J.getY());
            SimpleEventBus.getInstance().dispatchEvent(tVideoRightPrPositionEvent);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSTVideoLikePresenter qFSTVideoLikePresenter = QFSTVideoLikePresenter.this;
            qFSTVideoLikePresenter.u1(qFSTVideoLikePresenter.K);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSTVideoLikePresenter qFSTVideoLikePresenter = QFSTVideoLikePresenter.this;
            qFSTVideoLikePresenter.u1(qFSTVideoLikePresenter.P);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void A1() {
        VideoReport.setElementExposePolicy(this.K, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.K, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.K, "like");
    }

    private void B1() {
        this.J.setVisibility(0);
        this.N.setVisibility(0);
        C1(this.K, this.L);
        C1(this.P, this.Q);
        if (ScreenUtils.isPortrait()) {
            this.J.post(this.W);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C1(QFSLikeImageView qFSLikeImageView, TextView textView) {
        int i3 = this.T;
        if (i3 == 0) {
            textView.setText(R.string.f1909843k);
            qFSLikeImageView.setContentDescription(h.a(R.string.f1909843k));
        } else {
            textView.setText(r.d(i3, 11));
            qFSLikeImageView.setContentDescription(h.a(R.string.f187813v0) + ((Object) textView.getText()));
        }
        qFSLikeImageView.setData((FeedCloudMeta$StFeed) this.f85017h);
        qFSLikeImageView.n(this.U);
    }

    private void D1(boolean z16) {
        boolean z17 = true;
        QLog.d("QFSTVideoLikePresenter", 1, "updateLikeStateCount useCache = " + z16);
        if (z16) {
            Object b16 = this.E.b("tvideo_like_state_blockdata_transform");
            if (b16 instanceof Integer) {
                if (((Integer) b16).intValue() != 3) {
                    z17 = false;
                }
                this.U = z17;
            }
            Object b17 = this.E.b("tvideo_like_count_blockdata_transform");
            if (b17 instanceof Integer) {
                this.T = ((Integer) b17).intValue();
                return;
            }
            return;
        }
        AttitudeInfo attitudeInfo = this.S;
        if (attitudeInfo.attitude_status != 3) {
            z17 = false;
        }
        this.U = z17;
        this.T = attitudeInfo.attitude_count;
    }

    private void n1() {
        QLog.d("QFSTVideoLikePresenter", 1, "cacheLikeData mIsLiked = " + this.U + " \uff1b mLikeNum = " + this.T);
        if (this.U) {
            this.E.o("tvideo_like_state_blockdata_transform", 3);
        } else {
            this.E.o("tvideo_like_state_blockdata_transform", 0);
        }
        this.E.o("tvideo_like_count_blockdata_transform", Integer.valueOf(this.T));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void o1(@NonNull QFSDoublePraiseEvent qFSDoublePraiseEvent) {
        if (this.S == null || !TextUtils.equals(qFSDoublePraiseEvent.getFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()) || !g.T(this.R)) {
            return;
        }
        e eVar = e.f453199a;
        if (!eVar.k()) {
            eVar.l(Foreground.getTopActivity());
            return;
        }
        if (this.U) {
            QLog.d("QFSTVideoLikePresenter", 1, "has liked");
            return;
        }
        this.U = true;
        this.T++;
        this.K.j();
        n1();
        B1();
        z1();
        w1("double");
        x1();
    }

    private boolean p1() {
        return this.E.b("tvideo_like_count_blockdata_transform") instanceof Integer;
    }

    private void q1() {
        this.J.setVisibility(8);
        this.N.setVisibility(8);
    }

    private void r1(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f40571eq);
        this.M = viewStub;
        View inflate = viewStub.inflate();
        this.N = inflate;
        this.P = (QFSLikeImageView) inflate.findViewById(R.id.f40581er);
        this.Q = (TextView) this.N.findViewById(R.id.f40601et);
        this.P.setOnClickListener(new b());
    }

    private void s1(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f40591es);
        this.I = viewStub;
        View inflate = viewStub.inflate();
        this.J = inflate;
        this.K = (QFSLikeImageView) inflate.findViewById(R.id.f40581er);
        this.L = (TextView) this.J.findViewById(R.id.f40601et);
        this.K.setOnClickListener(new a());
        A1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(TVideoLike$UserAttitudeOption tVideoLike$UserAttitudeOption) {
        boolean z16;
        if (tVideoLike$UserAttitudeOption != null && E0()) {
            this.T = tVideoLike$UserAttitudeOption.attitude_counts.get();
            if (tVideoLike$UserAttitudeOption.user_attitude.att_type.get() == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.U = z16;
            n1();
            B1();
            x1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(QFSLikeImageView qFSLikeImageView) {
        e eVar = e.f453199a;
        if (!eVar.k()) {
            eVar.l(Foreground.getTopActivity());
            return;
        }
        boolean z16 = !this.U;
        this.U = z16;
        if (z16) {
            this.T++;
        } else {
            this.T--;
        }
        n1();
        qFSLikeImageView.j();
        B1();
        z1();
        w1("single");
        x1();
    }

    private void w1(String str) {
        String str2;
        Map<String, Object> i3 = gy2.c.i(this.R);
        if (this.U) {
            str2 = "like";
        } else {
            str2 = "unlike";
        }
        i3.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str2);
        i3.put("button_type", str);
        VideoReport.reportEvent("clck", this.K, i3);
    }

    private void x1() {
        String str;
        Map<String, Object> i3 = gy2.c.i(this.R);
        if (this.U) {
            str = "like";
        } else {
            str = "unlike";
        }
        i3.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str);
        VideoReport.reportEvent("imp", this.K, i3);
    }

    private void y1() {
        Video video = this.R;
        if (video != null && video.video_base_info != null) {
            com.tencent.mobileqq.tvideo.like.b bVar = new com.tencent.mobileqq.tvideo.like.b();
            bVar.f304485m.observeForever(new Observer() { // from class: com.tencent.mobileqq.tvideo.like.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QFSTVideoLikePresenter.this.t1((TVideoLike$UserAttitudeOption) obj);
                }
            });
            bVar.L1(this.R.video_base_info.vid);
        }
    }

    private void z1() {
        Video video = this.R;
        if (video != null && video.video_base_info != null) {
            JSONObject jSONObject = new JSONObject();
            int i3 = 1;
            try {
                jSONObject.put("material_aspect_vid", this.R.video_base_info.material_aspect_vid);
                jSONObject.put("material_title", this.R.video_base_info.material_title);
                jSONObject.put("material_end_time", this.R.video_base_info.material_end_time);
                jSONObject.put("leading_actor", this.R.cover_base_info.leading_actor);
            } catch (JSONException e16) {
                QLog.d("QFSTVideoLikePresenter", 1, "requestLikeState exception : " + e16);
            }
            TVideoLike$UserAttitudeOptionRequest tVideoLike$UserAttitudeOptionRequest = new TVideoLike$UserAttitudeOptionRequest();
            tVideoLike$UserAttitudeOptionRequest.cid.set(this.R.video_base_info.cid);
            tVideoLike$UserAttitudeOptionRequest.vid.set(this.R.video_base_info.vid);
            PBInt32Field pBInt32Field = tVideoLike$UserAttitudeOptionRequest.attitude_option_type;
            if (!this.U) {
                i3 = 2;
            }
            pBInt32Field.set(i3);
            tVideoLike$UserAttitudeOptionRequest.play_back_time.set(this.V);
            tVideoLike$UserAttitudeOptionRequest.extra_params.set(jSONObject.toString());
            new c().L1(tVideoLike$UserAttitudeOptionRequest);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        s1(view);
        r1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSDoublePraiseEvent.class);
        eventClass.add(QFSVideoFeedPlayEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        View view = this.J;
        if (view != null) {
            view.removeCallbacks(this.W);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (!g.E((FeedCloudMeta$StFeed) this.f85017h) && !g.z((FeedCloudMeta$StFeed) this.f85017h)) {
            x1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.like.QFSTVideoLikePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleBaseEvent simpleBaseEvent2 = simpleBaseEvent;
                if (simpleBaseEvent2 instanceof QFSDoublePraiseEvent) {
                    QFSTVideoLikePresenter.this.o1((QFSDoublePraiseEvent) simpleBaseEvent2);
                } else if (simpleBaseEvent2 instanceof QFSVideoFeedPlayEvent) {
                    QFSTVideoLikePresenter.this.V = ((QFSVideoFeedPlayEvent) simpleBaseEvent2).progress;
                }
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        Video q16 = g.q(feedCloudMeta$StFeed);
        this.R = q16;
        if (!g.T(q16)) {
            q1();
            return;
        }
        this.S = this.R.video_base_info.attitude_info;
        if (p1()) {
            D1(true);
            B1();
        } else if (!g.E(feedCloudMeta$StFeed) && !g.z(feedCloudMeta$StFeed)) {
            D1(false);
            B1();
        } else {
            q1();
            y1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoLikePresenter";
    }
}
