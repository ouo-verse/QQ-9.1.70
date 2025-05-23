package com.tencent.mobileqq.tvideo.presenter.intro;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment;
import com.tencent.mobileqq.tvideo.event.QFSTVideoIntroEvent;
import com.tencent.mobileqq.tvideo.pr.TVideoPrFloatShowShowEvent;
import com.tencent.mobileqq.tvideo.view.TVideoErrorStatusView;
import com.tencent.mobileqq.tvideo.view.TVideoLoadingView;
import com.tencent.mobileqq.tvideo.viewmodel.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;
import tvideo.CoverBaseInfo;
import tvideo.Video;
import tvideo.VideoBriefIntro$VideoBriefIntroductionActorList;
import tvideo.VideoBriefIntro$VideoBriefIntroductionPage;
import tvideo.VideoBriefIntro$VideoBriefIntroductionPoster;
import tvideo.VideoBriefIntro$VideoBriefIntroductionText;

/* loaded from: classes19.dex */
public class QFSTVideoIntroPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    protected RecyclerView I;
    protected View J;
    protected TextView K;
    protected ImageView L;
    protected ImageView M;
    protected e N;
    private TVideoErrorStatusView P;
    private TVideoLoadingView Q;
    private View R;
    private ImageView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private Video f304699a0;

    /* renamed from: b0, reason: collision with root package name */
    private i f304700b0;

    /* renamed from: c0, reason: collision with root package name */
    private Observer<VideoBriefIntro$VideoBriefIntroductionPage> f304701c0;

    /* renamed from: d0, reason: collision with root package name */
    private VideoBriefIntro$VideoBriefIntroductionPage f304702d0;

    /* renamed from: e0, reason: collision with root package name */
    protected volatile boolean f304703e0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public enum ViewStatus {
        LOADING,
        SUCCEED,
        ERROR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements Observer<VideoBriefIntro$VideoBriefIntroductionPage> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage) {
            QLog.d("QFSTVideoTopInfoPresenter", 1, "onChanged old = " + QFSTVideoIntroPresenter.this.f304702d0 + " new = " + videoBriefIntro$VideoBriefIntroductionPage);
            QFSTVideoIntroPresenter.this.f304702d0 = videoBriefIntro$VideoBriefIntroductionPage;
            QFSTVideoIntroPresenter.this.K1(videoBriefIntro$VideoBriefIntroductionPage);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f304705a;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f304705a = iArr;
            try {
                iArr[ViewStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f304705a[ViewStatus.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f304705a[ViewStatus.SUCCEED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void A1() {
        this.P.setVisibility(0);
        this.R.setVisibility(8);
        this.Q.setVisibility(8);
        this.Q.m();
        this.P.x0("");
    }

    private void C1() {
        this.P.setVisibility(8);
        this.R.setVisibility(8);
        this.Q.setVisibility(0);
        this.Q.l();
    }

    private void D1() {
        this.P.setVisibility(8);
        this.R.setVisibility(0);
        this.Q.setVisibility(8);
        this.Q.m();
    }

    private void E1(VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage) {
        e eVar = (e) this.I.getAdapter();
        VideoBriefIntro$VideoBriefIntroductionActorList videoBriefIntro$VideoBriefIntroductionActorList = videoBriefIntro$VideoBriefIntroductionPage.actor_info;
        if (videoBriefIntro$VideoBriefIntroductionActorList != null) {
            TextView textView = this.X;
            if (textView != null) {
                textView.setText(videoBriefIntro$VideoBriefIntroductionActorList.title.get());
            }
            eVar.n0(this.f304699a0);
            eVar.m0(videoBriefIntro$VideoBriefIntroductionPage.actor_info.actor_list.get());
            return;
        }
        TextView textView2 = this.X;
        if (textView2 != null) {
            textView2.setText("");
        }
        eVar.n0(null);
        eVar.m0(new ArrayList());
    }

    private void F1(VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage) {
        VideoBriefIntro$VideoBriefIntroductionText videoBriefIntro$VideoBriefIntroductionText = videoBriefIntro$VideoBriefIntroductionPage.text;
        if (videoBriefIntro$VideoBriefIntroductionText != null) {
            this.Y.setText(videoBriefIntro$VideoBriefIntroductionText.title.get());
            this.Z.setText(videoBriefIntro$VideoBriefIntroductionPage.text.description.get());
        } else {
            this.Y.setText("");
            this.Z.setText("");
        }
    }

    private void H1(VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage) {
        String str;
        VideoBriefIntro$VideoBriefIntroductionPoster videoBriefIntro$VideoBriefIntroductionPoster = videoBriefIntro$VideoBriefIntroductionPage.poster;
        if (videoBriefIntro$VideoBriefIntroductionPoster == null) {
            return;
        }
        String str2 = videoBriefIntro$VideoBriefIntroductionPoster.third_label_info.get();
        String str3 = videoBriefIntro$VideoBriefIntroductionPage.poster.sub_label_info.get();
        String str4 = "";
        if (TextUtils.isEmpty(str3)) {
            str = "";
        } else {
            str = str2;
            str2 = str3;
        }
        String str5 = videoBriefIntro$VideoBriefIntroductionPage.poster.first_label_info.get();
        if (!TextUtils.isEmpty(str5)) {
            str4 = str;
            str = str2;
            str2 = str5;
        }
        this.U.setText(str2);
        TextView textView = this.V;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.W;
        if (textView2 != null) {
            textView2.setText(str4);
        }
    }

    private void I1(VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage) {
        if (this.S == null) {
            return;
        }
        Option requestWidth = Option.obtain().setUrl(videoBriefIntro$VideoBriefIntroductionPage.poster.img_url.get()).setTargetView(this.S).setRequestHeight(this.S.getHeight()).setRequestWidth(this.S.getWidth());
        requestWidth.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(requestWidth, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage) {
        if (videoBriefIntro$VideoBriefIntroductionPage != null) {
            z1(ViewStatus.SUCCEED);
            try {
                this.E.o("tvideo_intro_blockdara_transform", new VideoBriefIntro$VideoBriefIntroductionPage().mergeFrom(videoBriefIntro$VideoBriefIntroductionPage.toByteArray()));
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("QFSTVideoTopInfoPresenter", 1, "introductionInfo setTransFormData " + e16);
            }
            QLog.d("QFSTVideoTopInfoPresenter", 1, "introductionInfo = " + videoBriefIntro$VideoBriefIntroductionPage);
            m1(videoBriefIntro$VideoBriefIntroductionPage);
            return;
        }
        z1(ViewStatus.ERROR);
    }

    private void p1() {
        this.f304700b0 = new i();
        a aVar = new a();
        this.f304701c0 = aVar;
        this.f304700b0.f304837m.observeForever(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.P.setVisibility(8);
        w1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        VideoReport.reportEvent("clck", this.M, null);
        t1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void u1() {
        i iVar = this.f304700b0;
        if (iVar != null) {
            iVar.f304837m.removeObserver(this.f304701c0);
        }
    }

    private void v1() {
        Map<String, Object> map;
        Fragment hostFragment = s0().getHostFragment();
        if (hostFragment instanceof QFSLayerTVideoPageFragment) {
            map = ((QFSLayerTVideoPageFragment) hostFragment).getChildDaTongPageParams();
        } else {
            map = null;
        }
        VideoReport.setPageParams(this.f85016f, gy2.c.f("TVideoVerticalIntroPresenter", map));
        VideoReport.setPageReportPolicy(this.f85016f, PageReportPolicy.REPORT_NONE);
        VideoReport.reportPgIn(this.f85016f);
    }

    private void w1() {
        CoverBaseInfo coverBaseInfo;
        z1(ViewStatus.LOADING);
        Video video = this.f304699a0;
        if (video != null && (coverBaseInfo = video.cover_base_info) != null) {
            this.f304700b0.L1(coverBaseInfo.cid);
        }
    }

    private void x1() {
        if (this.f85016f == null) {
            return;
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setImageResource(0);
        }
        this.T.setText("");
        this.K.setText("");
        this.U.setText("");
        TextView textView = this.V;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = this.W;
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    private void y1(View view, String str) {
        VideoReport.setElementParams(view, gy2.c.i(this.f304699a0));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, str);
        VideoReport.reportEvent("imp", view, null);
    }

    private void z1(ViewStatus viewStatus) {
        int i3 = b.f304705a[viewStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    D1();
                    return;
                }
                return;
            }
            C1();
            return;
        }
        A1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B1() {
        View view;
        T0(new wx2.e(true));
        VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage = (VideoBriefIntro$VideoBriefIntroductionPage) this.E.b("tvideo_intro_blockdara_transform");
        this.f304702d0 = videoBriefIntro$VideoBriefIntroductionPage;
        if (videoBriefIntro$VideoBriefIntroductionPage != null && (view = this.f85016f) != null) {
            view.setVisibility(0);
            m1(this.f304702d0);
            e eVar = this.N;
            if (eVar != null) {
                eVar.notifyDataSetChanged();
            }
            v1();
            return;
        }
        o1();
        p1();
        w1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G1(ImageView imageView, String str) {
        Option targetView = Option.obtain().setUrl(str).setTargetView(imageView);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(targetView, null);
    }

    protected void J1(VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage) {
        if (!TextUtils.isEmpty(videoBriefIntro$VideoBriefIntroductionPage.poster.rating.get())) {
            this.K.setText(videoBriefIntro$VideoBriefIntroductionPage.poster.rating.get());
            G1(this.L, "https://ugd.gtimg.com//vg/1672831601830_%E7%9F%A9%E5%BD%A2.png");
        } else if (!TextUtils.isEmpty(videoBriefIntro$VideoBriefIntroductionPage.poster.hotval.get())) {
            this.K.setText(videoBriefIntro$VideoBriefIntroductionPage.poster.hotval.get());
            G1(this.L, "https://ugd.gtimg.com//vg/1672831556775_%E7%9F%A9%E5%BD%A2.png");
        } else {
            this.J.findViewById(R.id.f80254az).setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        u1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSTVideoIntroEvent.class);
        return arrayList;
    }

    protected int l1() {
        return R.id.f45631se;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m1(VideoBriefIntro$VideoBriefIntroductionPage videoBriefIntro$VideoBriefIntroductionPage) {
        VideoBriefIntro$VideoBriefIntroductionPoster videoBriefIntro$VideoBriefIntroductionPoster = videoBriefIntro$VideoBriefIntroductionPage.poster;
        if (videoBriefIntro$VideoBriefIntroductionPoster != null) {
            this.T.setText(videoBriefIntro$VideoBriefIntroductionPoster.title.get());
            I1(videoBriefIntro$VideoBriefIntroductionPage);
            H1(videoBriefIntro$VideoBriefIntroductionPage);
            J1(videoBriefIntro$VideoBriefIntroductionPage);
        } else {
            x1();
        }
        E1(videoBriefIntro$VideoBriefIntroductionPage);
        F1(videoBriefIntro$VideoBriefIntroductionPage);
    }

    protected void n1() {
        e eVar = new e();
        this.N = eVar;
        this.I.setAdapter(eVar);
        this.I.setLayoutManager(new GridLayoutManager(m0(), 5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o1() {
        View view = this.f85016f;
        if (view != null) {
            view.setVisibility(0);
            return;
        }
        View findViewById = this.C.findViewById(l1());
        if (findViewById instanceof ViewStub) {
            this.f85016f = ((ViewStub) findViewById).inflate();
        }
        VideoReport.setPageId(this.f85016f, "page_ugqqoa_intro");
        View view2 = this.f85016f;
        this.J = view2;
        this.S = (ImageView) view2.findViewById(R.id.f26640e3);
        this.I = (RecyclerView) this.J.findViewById(R.id.f7879481);
        n1();
        this.T = (TextView) this.J.findViewById(R.id.kbs);
        this.U = (TextView) this.J.findViewById(R.id.f108006by);
        this.V = (TextView) this.J.findViewById(R.id.f110996k1);
        this.W = (TextView) this.J.findViewById(R.id.f111876me);
        this.K = (TextView) this.J.findViewById(R.id.f110896jr);
        this.L = (ImageView) this.J.findViewById(R.id.xej);
        this.X = (TextView) this.J.findViewById(R.id.f10580670);
        this.Y = (TextView) this.J.findViewById(R.id.f108836e7);
        this.Z = (TextView) this.J.findViewById(R.id.f108826e6);
        this.Q = (TVideoLoadingView) this.J.findViewById(R.id.efs);
        TVideoErrorStatusView tVideoErrorStatusView = (TVideoErrorStatusView) this.J.findViewById(R.id.byk);
        this.P = tVideoErrorStatusView;
        tVideoErrorStatusView.G0(cx.a(90.0f));
        this.P.setOnRetryClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.intro.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QFSTVideoIntroPresenter.this.q1(view3);
            }
        });
        this.R = this.J.findViewById(R.id.zey);
        ImageView imageView = (ImageView) this.J.findViewById(R.id.az7);
        this.M = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.intro.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QFSTVideoIntroPresenter.this.r1(view3);
            }
        });
        v1();
        y1(this.M, "close");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        u1();
        t1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        this.f304703e0 = true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!E0()) {
            QLog.d("QFSTVideoTopInfoPresenter", 1, "onReceiveEvent isFeedOnScreen false");
            return;
        }
        if (ScreenUtils.isPortrait()) {
            QLog.d("QFSTVideoTopInfoPresenter", 1, "onReceiveEvent isPortrait true");
        } else if (simpleBaseEvent instanceof QFSTVideoIntroEvent) {
            QLog.d("QFSTVideoTopInfoPresenter", 1, "onReceiveEvent QFSTVideoIntroEvent");
            B1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        this.f304703e0 = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        Video q16 = jy2.g.q(feedCloudMeta$StFeed);
        this.f304699a0 = q16;
        e eVar = this.N;
        if (eVar != null) {
            eVar.n0(q16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t1() {
        View view = this.f85016f;
        if (view != null && view.getVisibility() == 0) {
            VideoReport.reportPgOut(this.f85016f);
            this.f85016f.setVisibility(8);
            T0(new wx2.e(false));
            if (ScreenUtils.isLandscape()) {
                return;
            }
            TVideoPrFloatShowShowEvent tVideoPrFloatShowShowEvent = new TVideoPrFloatShowShowEvent();
            tVideoPrFloatShowShowEvent.setShow(true);
            tVideoPrFloatShowShowEvent.setHandleLeftWebView(true);
            SimpleEventBus.getInstance().dispatchEvent(tVideoPrFloatShowShowEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoTopInfoPresenter";
    }
}
