package ey2;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeDataEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeExpandEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tvideo.Video;
import tvideo.VideoBaseInfo;
import tvideo.VideoPlot;
import tvideo.VideoPlotDetails;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    Video I;
    private View J;
    private View K;
    private ImageView L;
    private TextView M;
    private TextView N;
    private ImageView P;
    private TextView Q;
    private int R;
    private com.tencent.mobileqq.tvideo.viewmodel.h S;
    private Observer<VideoPlotDetails> T;
    private VideoPlotDetails U;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeExpandEvent(true));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.k1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements Observer<VideoPlotDetails> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(VideoPlotDetails videoPlotDetails) {
            if (!jy2.g.G(videoPlotDetails, e.this.I)) {
                QLog.d("QFSTVideoBottomEpisodePresenter", 1, "mVideoPlotObserver onChanged not same cid");
                return;
            }
            if (videoPlotDetails != null && ((QFSBaseFeedChildPresenter) e.this).E != null) {
                ((QFSBaseFeedChildPresenter) e.this).E.o("tvideo_episode_blockdara_transform", videoPlotDetails);
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeDataEvent(videoPlotDetails));
            e.this.t1(videoPlotDetails);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        List<VideoPlot> list;
        int i3;
        VideoPlotDetails videoPlotDetails = this.U;
        if (videoPlotDetails != null && (list = videoPlotDetails.video_plot_list) != null && (i3 = this.R) > 0 && i3 < list.size()) {
            VideoPlot videoPlot = this.U.video_plot_list.get(this.R);
            QFSTVideoEpisodeClickEvent qFSTVideoEpisodeClickEvent = new QFSTVideoEpisodeClickEvent();
            qFSTVideoEpisodeClickEvent.setPos(this.f85018i);
            qFSTVideoEpisodeClickEvent.setVideoPlot(videoPlot);
            qFSTVideoEpisodeClickEvent.setVideoFeed(this.I);
            qFSTVideoEpisodeClickEvent.setVideoPlotDetails(this.U);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoEpisodeClickEvent);
            q1();
        }
    }

    private boolean l1(List<VideoPlot> list) {
        VideoBaseInfo videoBaseInfo;
        String str = this.I.video_base_info.vid;
        for (int i3 = 0; i3 < list.size(); i3++) {
            VideoPlot videoPlot = list.get(i3);
            if (videoPlot != null && (videoBaseInfo = videoPlot.video_base_info) != null && TextUtils.equals(str, videoBaseInfo.vid)) {
                this.R = i3 + 1;
            }
        }
        int i16 = this.R;
        if (i16 <= 0 || i16 >= list.size()) {
            return false;
        }
        return true;
    }

    private void m1(View view) {
        this.J = view.findViewById(R.id.f45511s3);
        this.L = (ImageView) view.findViewById(R.id.uci);
        this.M = (TextView) view.findViewById(R.id.uch);
        this.N = (TextView) view.findViewById(R.id.uwb);
        this.P = (ImageView) view.findViewById(R.id.uwd);
        this.Q = (TextView) view.findViewById(R.id.zqo);
        View findViewById = view.findViewById(R.id.f164809tx4);
        this.K = findViewById;
        findViewById.setOnClickListener(new a());
        this.Q.setOnClickListener(new b());
        s1();
        u1(this.L, "https://ugd.gtimg.com//vg/1675221121775_tvideo_public_account_episode_icon.png");
        u1(this.P, "https://ugd.gtimg.com//vg/1675236103863_tvideo_public_account_episode_expand_icon.png");
    }

    private void n1() {
        Video video;
        VideoBaseInfo videoBaseInfo;
        p1();
        this.T = new c();
        com.tencent.mobileqq.tvideo.viewmodel.h hVar = new com.tencent.mobileqq.tvideo.viewmodel.h();
        this.S = hVar;
        hVar.f304835m.observeForever(this.T);
        if (this.S != null && !jy2.g.J(this.I) && (video = this.I) != null && (videoBaseInfo = video.video_base_info) != null) {
            this.S.S1(videoBaseInfo.cid, 0, new HashMap());
        }
    }

    private void p1() {
        com.tencent.mobileqq.tvideo.viewmodel.h hVar = this.S;
        if (hVar != null) {
            hVar.f304835m.removeObserver(this.T);
        }
    }

    private void q1() {
        VideoReport.reportEvent("clck", this.Q, gy2.c.i(this.I));
    }

    private void r1() {
        this.J.setVisibility(8);
        VideoPlotDetails videoPlotDetails = (VideoPlotDetails) this.E.b("tvideo_episode_blockdara_transform");
        if (videoPlotDetails != null) {
            t1(videoPlotDetails);
        } else {
            n1();
        }
    }

    private void s1() {
        VideoReport.setElementExposePolicy(this.Q, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.Q, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.Q, "next_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(VideoPlotDetails videoPlotDetails) {
        List<VideoPlot> list;
        VideoBaseInfo videoBaseInfo;
        this.U = videoPlotDetails;
        Video video = this.I;
        if (video != null && video.video_base_info != null && videoPlotDetails != null && (list = videoPlotDetails.video_plot_list) != null && list.size() > 1) {
            this.J.setVisibility(0);
            this.N.setText(videoPlotDetails.episode_updated);
            Video video2 = this.I;
            if (video2 != null && (videoBaseInfo = video2.video_base_info) != null) {
                this.M.setText(videoBaseInfo.series_num);
            } else {
                this.M.setText("");
            }
            if (videoPlotDetails.next_episode_btn_shown && l1(videoPlotDetails.video_plot_list)) {
                this.Q.setVisibility(0);
                return;
            } else {
                this.Q.setVisibility(8);
                return;
            }
        }
        this.J.setVisibility(8);
    }

    private void u1(ImageView imageView, String str) {
        Option targetView = Option.obtain().setUrl(str).setTargetView(imageView);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(targetView, null);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        m1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSTVideoEpisodeExpandEvent.class);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.I = jy2.g.q((FeedCloudMeta$StFeed) this.f85017h);
        r1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        p1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoBottomEpisodePresenter";
    }
}
