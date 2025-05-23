package kx2;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.tvideo.binge.data.TVideoBingeWatchStateOperationViewModel;
import com.tencent.mobileqq.tvideo.binge.data.TVideoBingeWatchUiData;
import com.tencent.mobileqq.tvideo.binge.data.TVideoBingeWatchUiState;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jy2.i;
import mqq.app.Foreground;
import tvideo.CoverBaseInfo;
import tvideo.TVideoBingeWatch$AlbumAtom;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private Video I;
    private volatile int J;
    private volatile int K;
    private volatile long M;
    private ViewStub N;
    private ViewStub P;
    private TextView Q;
    private TextView R;
    private ImageView S;
    private ImageView T;
    private ViewGroup U;

    @TVideoBingeWatchUiState
    private volatile int L = -2;
    private final TVideoBingeWatchStateOperationViewModel V = new TVideoBingeWatchStateOperationViewModel(new com.tencent.mobileqq.tvideo.binge.data.e() { // from class: kx2.a
        @Override // com.tencent.mobileqq.tvideo.binge.data.e
        public final void a(List list, boolean z16) {
            g.this.t1(list, z16);
        }
    });
    private final View.OnClickListener W = new View.OnClickListener() { // from class: kx2.b
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.this.u1(view);
        }
    };

    private void A1(boolean z16, @TVideoBingeWatchUiState int i3) {
        VideoBaseInfo videoBaseInfo;
        if (i3 != -2 && i3 != -1) {
            HashMap hashMap = new HashMap();
            Video video = this.I;
            if (video != null && (videoBaseInfo = video.video_base_info) != null) {
                hashMap.put("material_vid", videoBaseInfo.material_aspect_vid);
            }
            String str = "cancel_binge_watch";
            if (z16) {
                if (i3 == 0) {
                    str = "binge_watch";
                }
                hashMap.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str);
                VideoReport.reportEvent("imp", this.S, hashMap);
                return;
            }
            if (i3 != 0) {
                str = "binge_watch";
            }
            hashMap.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str);
            VideoReport.reportEvent("clck", this.S, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void w1(boolean z16) {
        ViewGroup viewGroup = this.U;
        if (viewGroup == null) {
            return;
        }
        if (z16) {
            i.f411173a.c(viewGroup, "\u52a0\u8ffd\u6210\u529f\uff0c\u53ef\u8fdb\u5165\"\u6211\u7684\"-\"\u6211\u7684\u8ffd\u5267\"\u67e5\u770b");
        } else {
            i.f411173a.c(viewGroup, "\u5df2\u53d6\u6d88\u52a0\u8ffd");
        }
    }

    private void C1() {
        ViewStub viewStub = this.N;
        if (viewStub != null && viewStub.getVisibility() != 0) {
            this.N.setVisibility(0);
        }
        ViewStub viewStub2 = this.P;
        if (viewStub2 != null && viewStub2.getVisibility() != 0) {
            this.P.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void v1(long j3) {
        String str;
        this.M = j3;
        if (j3 > 0) {
            str = jy2.g.d(j3);
        } else {
            str = "\u8ffd\u5267";
        }
        G1(str);
    }

    private void E1(@TVideoBingeWatchUiState int i3, boolean z16) {
        boolean z17;
        String str;
        if (i3 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            str = "https://ugd.gtimg.com/vg/1687945462256_ic_yizhui.png";
        } else {
            str = "https://ugd.gtimg.com/vg/1687945493582_ic_zhuiju.png";
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            jy2.f.f411169a.j(imageView, str);
            if (!z16) {
                A1(false, i3);
            }
            A1(true, i3);
        }
        ImageView imageView2 = this.T;
        if (imageView2 != null) {
            jy2.f.f411169a.j(imageView2, str);
        }
        this.L = i3;
    }

    private void F1() {
        int i3;
        final long j3;
        VideoBaseInfo videoBaseInfo;
        final boolean z16 = true;
        if (this.L == 1) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        zt2.e eVar = zt2.e.f453199a;
        if (!eVar.k()) {
            eVar.l(Foreground.getTopActivity());
            A1(false, this.L);
            return;
        }
        if (i3 != 1) {
            z16 = false;
        }
        long j16 = this.M;
        if (z16) {
            j3 = j16 + 1;
        } else {
            j3 = j16 - 1;
        }
        this.M = j3;
        TVideoBingeWatch$AlbumAtom tVideoBingeWatch$AlbumAtom = new TVideoBingeWatch$AlbumAtom();
        Video video = this.I;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            tVideoBingeWatch$AlbumAtom.cid.set(videoBaseInfo.cid);
            tVideoBingeWatch$AlbumAtom.vid.set(this.I.video_base_info.vid);
            tVideoBingeWatch$AlbumAtom.material_aspect_vid.set(this.I.video_base_info.material_aspect_vid);
            tVideoBingeWatch$AlbumAtom.timestamp.set(System.currentTimeMillis() / 1000);
            if (this.J + 5000 > this.K) {
                tVideoBingeWatch$AlbumAtom.video_time.set(-2);
            } else {
                tVideoBingeWatch$AlbumAtom.video_time.set(this.J / 1000);
            }
            com.tencent.mobileqq.tvideo.binge.data.b.d().h(this.I.video_base_info.cid, j3);
        }
        this.V.T1(i3, tVideoBingeWatch$AlbumAtom, "page_ugqqoa_play");
        x0().post(new Runnable() { // from class: kx2.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.v1(j3);
            }
        });
        x0().post(new Runnable() { // from class: kx2.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.w1(z16);
            }
        });
    }

    private void G1(String str) {
        TextView textView = this.Q;
        if (textView != null && this.R != null) {
            textView.setText(str);
            this.R.setText(str);
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
        }
    }

    private synchronized void m1(@NonNull TVideoBingeWatchUiData tVideoBingeWatchUiData, boolean z16) {
        int uiState = tVideoBingeWatchUiData.getUiState();
        if (uiState != -1) {
            if (uiState != 0) {
                if (uiState == 1) {
                    E1(1, z16);
                    C1();
                }
            } else {
                E1(0, z16);
                C1();
            }
        } else {
            n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        ViewStub viewStub = this.N;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
        ViewStub viewStub2 = this.P;
        if (viewStub2 != null) {
            viewStub2.setVisibility(8);
        }
    }

    private void o1() {
        VideoReport.setElementParams(this.S, gy2.c.g());
        VideoReport.setElementExposePolicy(this.S, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.S, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.S, "binge_watch");
    }

    private void p1() {
        CoverBaseInfo coverBaseInfo;
        VideoBaseInfo videoBaseInfo;
        Video video = this.I;
        if (video != null && (coverBaseInfo = video.cover_base_info) != null && coverBaseInfo.hot_tag != null) {
            String str = coverBaseInfo.cid;
            if (TextUtils.isEmpty(str) && (videoBaseInfo = this.I.video_base_info) != null) {
                str = videoBaseInfo.cid;
            }
            long c16 = com.tencent.mobileqq.tvideo.binge.data.b.d().c(str);
            if (c16 > 0) {
                v1(c16);
                return;
            } else {
                v1(this.I.cover_base_info.hot_tag.hot_tag_num);
                return;
            }
        }
        v1(0L);
    }

    private void q1(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f39411bl);
        this.P = viewStub;
        viewStub.inflate();
        this.R = (TextView) view.findViewById(R.id.f40361e6);
        ImageView imageView = (ImageView) view.findViewById(R.id.f40351e5);
        this.T = imageView;
        imageView.setOnClickListener(this.W);
    }

    private void r1(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f39421bm);
        this.N = viewStub;
        viewStub.inflate();
        this.Q = (TextView) view.findViewById(R.id.f39401bk);
        ImageView imageView = (ImageView) view.findViewById(R.id.f39391bj);
        this.S = imageView;
        imageView.setOnClickListener(this.W);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1(List list, boolean z16) {
        m1((TVideoBingeWatchUiData) list.get(0), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(final List list, final boolean z16) {
        if (this.S == null) {
            return;
        }
        if (list != null && list.size() > 0 && list.get(0) != null) {
            this.S.post(new Runnable() { // from class: kx2.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.s1(list, z16);
                }
            });
        } else {
            this.S.post(new Runnable() { // from class: kx2.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.n1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        y1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void y1() {
        F1();
    }

    private void z1() {
        VideoBaseInfo videoBaseInfo;
        if (qx2.a.c().a() && !jy2.g.J(this.I)) {
            if (!zt2.e.f453199a.k()) {
                E1(0, true);
                return;
            }
            Video video = this.I;
            if (video != null && (videoBaseInfo = video.video_base_info) != null) {
                this.V.R1(videoBaseInfo.cid);
                return;
            }
            return;
        }
        n1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        r1(view);
        q1(view);
        this.U = (ViewGroup) view.findViewById(R.id.f112776ou);
        o1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSVideoFeedPlayEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        z1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSVideoFeedPlayEvent) {
            QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent = (QFSVideoFeedPlayEvent) simpleBaseEvent;
            this.J = qFSVideoFeedPlayEvent.progress;
            this.K = qFSVideoFeedPlayEvent.duration;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "TVideoBingeWatchPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.I = jy2.g.q(feedCloudMeta$StFeed);
        p1();
    }
}
