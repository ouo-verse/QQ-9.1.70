package ey2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeDataEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeExpandEvent;
import com.tencent.mobileqq.tvideo.view.TVideoErrorStatusView;
import com.tencent.mobileqq.tvideo.view.TVideoLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import ey2.n;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tvideo.EpisodeListStyle;
import tvideo.Video;
import tvideo.VideoBaseInfo;
import tvideo.VideoPlot;
import tvideo.VideoPlotDetails;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements n.a {
    private static final int U = cx.a(85.0f);
    private static final int V = cx.a(20.0f);
    private static final int W = cx.a(15.0f);
    private static final int X = cx.a(15.0f);
    private static final int Y = cx.a(20.0f);
    private static final int Z = cx.a(22.0f);

    /* renamed from: a0, reason: collision with root package name */
    private static final int f397399a0 = cx.a(15.0f);
    protected RecyclerView I;
    protected VideoPlotDetails J;
    protected Video K;
    protected n L;
    private Observer<VideoPlotDetails> M;
    private com.tencent.mobileqq.tvideo.viewmodel.h N;
    private TextView P;
    private TVideoLoadingView Q;
    private TVideoErrorStatusView R;
    private boolean S;
    private int T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            k.this.F1(rect, recyclerView.getChildAdapterPosition(view));
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
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeExpandEvent(false));
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
            if (!jy2.g.G(videoPlotDetails, k.this.K)) {
                QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "mVideoPlotObserver onChanged not same cid");
                return;
            }
            k kVar = k.this;
            kVar.J = videoPlotDetails;
            ((QFSBaseFeedChildPresenter) kVar).E.o("tvideo_episode_blockdara_transform", k.this.J);
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeDataEvent(videoPlotDetails));
            k.this.O1(videoPlotDetails);
        }
    }

    private void B1() {
        com.tencent.mobileqq.tvideo.viewmodel.h hVar = this.N;
        if (hVar != null) {
            hVar.f304835m.removeObserver(this.M);
        }
    }

    private void C1() {
        Video video;
        VideoBaseInfo videoBaseInfo;
        x1();
        J1();
        QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "requestEpisodeData");
        if (this.N != null && !jy2.g.J(this.K) && (video = this.K) != null && (videoBaseInfo = video.video_base_info) != null) {
            this.N.S1(videoBaseInfo.cid, 0, new HashMap());
        }
    }

    private void D1(List<VideoPlot> list) {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (jy2.g.x(this.K, list.get(i3))) {
                    QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "currentPos pos = " + i3);
                    this.I.scrollToPosition(i3);
                    return;
                }
            }
        }
    }

    private void E1(@NonNull Rect rect, int i3) {
        int ceil = (int) Math.ceil(i3 / 6);
        if (i3 >= 6) {
            rect.top = V;
        }
        if (ceil == this.T) {
            rect.bottom = U;
        }
    }

    private void G1(@NonNull Rect rect, int i3) {
        int i16 = i3 + 1;
        if (i3 > 0) {
            rect.top = W;
        }
        if (i16 == this.T) {
            rect.bottom = U;
        }
    }

    private void H1() {
        View view = this.f85016f;
        if (view != null) {
            view.setVisibility(0);
        }
        VideoReport.reportEvent("imp", this.f85016f, null);
    }

    private void I1() {
        TVideoErrorStatusView tVideoErrorStatusView = this.R;
        if (tVideoErrorStatusView != null) {
            tVideoErrorStatusView.x0("");
            this.R.setVisibility(0);
        }
    }

    private void J1() {
        this.Q.setVisibility(0);
        this.Q.l();
    }

    private void L1(VideoPlotDetails videoPlotDetails) {
        TextView textView = this.P;
        if (textView == null) {
            return;
        }
        textView.setText(videoPlotDetails.episode_updated);
    }

    private void N1(VideoPlotDetails videoPlotDetails) {
        L1(videoPlotDetails);
        p1();
        M1();
        this.I.setLayoutManager(n1());
        List<VideoPlot> list = videoPlotDetails.video_plot_list;
        this.L.o0(list);
        QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "setTransFormData size = " + this.L.l0().size());
        this.T = o1();
        this.I.invalidateItemDecorations();
        this.S = true;
        D1(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(VideoPlotDetails videoPlotDetails) {
        if (!E0()) {
            QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "videoPlotDetails onChanged isFeedOnScreen false");
            return;
        }
        r1();
        if (videoPlotDetails != null) {
            QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "videoPlotDetails onChanged = " + videoPlotDetails);
            N1(videoPlotDetails);
            return;
        }
        I1();
    }

    private void k1() {
        this.S = false;
        q1();
        n nVar = this.L;
        if (nVar != null) {
            nVar.o0(new ArrayList());
            this.L.notifyDataSetChanged();
        }
        TextView textView = this.P;
        if (textView != null) {
            textView.setText("");
        }
    }

    private void l1() {
        r1();
        p1();
        q1();
    }

    private int o1() {
        if (J() == EpisodeListStyle.EpisodeListStyleLongStrip.getValue()) {
            return this.L.getNUM_BACKGOURND_ICON();
        }
        return (int) Math.ceil(this.L.getNUM_BACKGOURND_ICON() / 6);
    }

    private void p1() {
        TVideoErrorStatusView tVideoErrorStatusView = this.R;
        if (tVideoErrorStatusView != null && tVideoErrorStatusView.getVisibility() == 0) {
            this.R.setVisibility(8);
        }
    }

    private void r1() {
        TVideoLoadingView tVideoLoadingView = this.Q;
        if (tVideoLoadingView != null && tVideoLoadingView.getVisibility() == 0) {
            this.Q.m();
            this.Q.setVisibility(8);
        }
    }

    private void t1() {
        if (this.S) {
            QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "init mHasSow");
            return;
        }
        w1();
        s1();
        VideoPlotDetails videoPlotDetails = this.J;
        if (videoPlotDetails != null) {
            N1(videoPlotDetails);
        } else {
            C1();
        }
    }

    private void v1() {
        VideoReport.setElementParams(this.f85016f, gy2.c.h("episode_float"));
        VideoReport.setElementExposePolicy(this.f85016f, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.f85016f, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.f85016f, "episode_slct_float");
    }

    private void x1() {
        com.tencent.mobileqq.tvideo.viewmodel.h hVar = this.N;
        if (hVar != null) {
            hVar.f304835m.removeObserver(this.M);
        }
        this.M = new c();
        com.tencent.mobileqq.tvideo.viewmodel.h hVar2 = new com.tencent.mobileqq.tvideo.viewmodel.h();
        this.N = hVar2;
        hVar2.f304835m.observeForever(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeExpandEvent(false));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        p1();
        C1();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.K = jy2.g.q(feedCloudMeta$StFeed);
    }

    protected void F1(@NonNull Rect rect, int i3) {
        if (J() == EpisodeListStyle.EpisodeListStyleLongStrip.getValue()) {
            G1(rect, i3);
        } else {
            E1(rect, i3);
        }
    }

    @Override // ey2.n.a
    public int J() {
        EpisodeListStyle episodeListStyle;
        VideoPlotDetails videoPlotDetails = this.J;
        if (videoPlotDetails != null && (episodeListStyle = videoPlotDetails.episode_list_style) != null) {
            return episodeListStyle.getValue();
        }
        return EpisodeListStyle.EpisodeListStyleSquare.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K1(boolean z16) {
        if (z16) {
            this.J = (VideoPlotDetails) this.E.b("tvideo_episode_blockdara_transform");
            QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "showOrHideView mVideoPlotDetails = " + this.J);
            t1();
            H1();
            return;
        }
        q1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        QLog.d("QFSTVideoEpisodeExpandPresenter", 1, this + " onDetachedFromWindow");
        k1();
        l1();
        B1();
    }

    protected void M1() {
        int i3 = X;
        int i16 = Z;
        int J = J();
        EpisodeListStyle episodeListStyle = EpisodeListStyle.EpisodeListStyleLongStrip;
        if (J == episodeListStyle.getValue()) {
            i3 = Y;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I.getLayoutParams();
        layoutParams.rightMargin = i3;
        this.I.setLayoutParams(layoutParams);
        if (this.P == null) {
            return;
        }
        if (J == episodeListStyle.getValue()) {
            i16 = f397399a0;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.P.getLayoutParams();
        layoutParams2.leftMargin = i16;
        this.P.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSTVideoEpisodeExpandEvent.class);
        return arrayList;
    }

    public void k(VideoPlot videoPlot) {
        QFSTVideoEpisodeClickEvent qFSTVideoEpisodeClickEvent = new QFSTVideoEpisodeClickEvent();
        qFSTVideoEpisodeClickEvent.setPos(this.f85018i);
        qFSTVideoEpisodeClickEvent.setVideoPlot(videoPlot);
        qFSTVideoEpisodeClickEvent.setVideoFeed(this.K);
        qFSTVideoEpisodeClickEvent.setVideoPlotDetails(this.J);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoEpisodeClickEvent);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeExpandEvent(false, true));
    }

    protected int m1() {
        return R.id.f45531s5;
    }

    protected RecyclerView.LayoutManager n1() {
        if (J() == EpisodeListStyle.EpisodeListStyleLongStrip.getValue()) {
            return new LinearLayoutManager(m0(), 1, false);
        }
        return new GridLayoutManager(m0(), 6);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (E0() && (simpleBaseEvent instanceof QFSTVideoEpisodeExpandEvent)) {
            K1(((QFSTVideoEpisodeExpandEvent) simpleBaseEvent).isExpand());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        QLog.d("QFSTVideoEpisodeExpandPresenter", 1, this + " onViewHolderDetachedFromWindow");
    }

    protected void q1() {
        View view = this.f85016f;
        if (view != null && view.getVisibility() == 0) {
            this.f85016f.setVisibility(8);
        }
    }

    protected void s1() {
        n nVar = new n(this.K, false, this);
        this.L = nVar;
        nVar.n0(this.K);
        this.I.setAdapter(this.L);
    }

    protected void u1() {
        this.P = (TextView) this.f85016f.findViewById(R.id.uwg);
        this.f85016f.findViewById(R.id.uwc).setOnClickListener(new View.OnClickListener() { // from class: ey2.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.y1(view);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoEpisodeExpandPresenter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w1() {
        if (this.f85016f != null) {
            QLog.d("QFSTVideoEpisodeExpandPresenter", 1, "initView mContainer != null");
            return;
        }
        View findViewById = this.C.findViewById(m1());
        if (findViewById instanceof ViewStub) {
            this.f85016f = ((ViewStub) findViewById).inflate();
        }
        View view = this.f85016f;
        if (view == null) {
            return;
        }
        this.Q = (TVideoLoadingView) view.findViewById(R.id.efs);
        TVideoErrorStatusView tVideoErrorStatusView = (TVideoErrorStatusView) this.f85016f.findViewById(R.id.byk);
        this.R = tVideoErrorStatusView;
        tVideoErrorStatusView.G0(cx.a(60.0f));
        this.R.setOnRetryClickListener(new View.OnClickListener() { // from class: ey2.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k.this.z1(view2);
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.f85016f.findViewById(R.id.uwe);
        this.I = recyclerView;
        recyclerView.addItemDecoration(new a());
        this.f85016f.findViewById(R.id.az7).setOnClickListener(new b());
        u1();
        v1();
    }
}
