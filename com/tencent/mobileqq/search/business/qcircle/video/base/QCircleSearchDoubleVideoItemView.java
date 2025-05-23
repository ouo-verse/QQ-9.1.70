package com.tencent.mobileqq.search.business.qcircle.video.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.search.event.QFSSearchCheckPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.biz.qqcircle.immersive.views.search.util.k;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.base.widget.RoundRelativeLayout;
import com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.widget.HorizontalListView;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e80.g;
import e80.j;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lo2.z;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class QCircleSearchDoubleVideoItemView extends QFSSearchBaseWidgetView<FeedCloudMeta$StFeed> implements View.OnClickListener, g, SimpleEventReceiver {
    private URLImageView C;
    private ImageView D;
    private RoundRelativeLayout E;
    private View F;
    private int G;
    private float H;
    private float I;
    private mo2.a J;
    private com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a K;
    private QFSSearchVideoPlayHelper L;
    private FeedCloudMeta$StFeed M;
    private int N;
    private boolean P;
    private boolean Q;
    private final k R;

    /* renamed from: e, reason: collision with root package name */
    private HorizontalListView f283053e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.search.business.qcircle.video.base.a f283054f;

    /* renamed from: h, reason: collision with root package name */
    private final j<FeedCloudMeta$StFeed> f283055h;

    /* renamed from: i, reason: collision with root package name */
    private final oo2.a f283056i;

    /* renamed from: m, reason: collision with root package name */
    protected QFSVideoView f283057m;

    public QCircleSearchDoubleVideoItemView(@NonNull Context context) {
        super(context);
        this.f283055h = new j<>();
        this.f283056i = new oo2.a();
        this.G = -1;
        this.R = new k();
    }

    private void B0() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void C0() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        final Bitmap y16 = this.L.y(this.C.getWidth(), this.C.getHeight());
        post(new Runnable() { // from class: com.tencent.mobileqq.search.business.qcircle.video.base.d
            @Override // java.lang.Runnable
            public final void run() {
                QCircleSearchDoubleVideoItemView.this.I0(y16);
            }
        });
    }

    private void H0() {
        K0();
        int O0 = O0();
        w20.a.j().registerDisplaySurface(this.K.S1(), this.K);
        com.tencent.biz.qqcircle.launcher.c.u(this.f283053e.getContext(), A0(O0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(Bitmap bitmap) {
        if (bitmap == null) {
            wo2.b.c(this.C, getData().cover.picUrl.get());
        } else {
            this.C.setImageBitmap(bitmap);
        }
        this.f283057m.setVisibility(4);
        this.C.setVisibility(0);
    }

    private void J0(QFSVideoOnPlayEvent qFSVideoOnPlayEvent) {
        if (getData() == null) {
            return;
        }
        if (getData().f398449id.get().equals(qFSVideoOnPlayEvent.getFeedId()) && qFSVideoOnPlayEvent.getPlayHashCode() == hashCode()) {
            return;
        }
        stop();
    }

    private void K0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QQ_SEARCHBAR_RESULTS);
        buildElementParams.put("xsj_sub_entrance", E0());
        buildElementParams.put("xsj_session_id", p.r());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PAGE_STACK_NUM, p.n());
        QCircleDTLoginReporter.executeDaTongLoginReport(buildElementParams);
    }

    private void N0() {
        if (this.J.f417103i) {
            this.D.setImageResource(R.drawable.mge);
        } else {
            this.D.setImageResource(R.drawable.mgg);
        }
    }

    private int O0() {
        int i3;
        if (this.G == 1) {
            i3 = (int) this.f283057m.H0();
        } else {
            i3 = 0;
        }
        this.K.R1(getData().f398449id.get(), i3);
        return i3;
    }

    private static void s0(View view, float f16, float f17) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) f16;
        layoutParams.height = (int) f17;
        view.setLayoutParams(layoutParams);
    }

    private void v0() {
        if (this.P) {
            w0();
        } else {
            y0();
        }
    }

    private void w0() {
        float Z = (float) ((ah.Z() - this.f283053e.getPaddingLeft()) - this.f283053e.getPaddingRight());
        this.H = Z;
        float f16 = Z / 1.7777778f;
        this.I = f16;
        s0(this.E, Z, f16);
        findViewById(R.id.b8q).getLayoutParams().width = (int) this.H;
    }

    private void x0() {
        float f16;
        int i3 = getData().video.width.get();
        int i16 = getData().video.height.get();
        if (i16 > 0 && i3 > 0) {
            f16 = i3 / i16;
        } else {
            f16 = 0.0f;
        }
        if (f16 > 0.74f) {
            URLImageView uRLImageView = this.C;
            float f17 = this.H;
            s0(uRLImageView, f17, f17 / f16);
            QFSVideoView qFSVideoView = this.f283057m;
            float f18 = this.H;
            s0(qFSVideoView, f18, f18 / f16);
            return;
        }
        s0(this.C, this.H, this.I);
        s0(this.f283057m, this.H, this.I);
    }

    private void y0() {
        float Z = ((float) (((ah.Z() - this.f283053e.getPaddingLeft()) - this.f283053e.getPaddingRight()) - QCircleSearchDoubleVideoView.f283061m)) / 2.0f;
        this.H = Z;
        float f16 = Z / 0.74f;
        this.I = f16;
        s0(this.E, Z, f16);
        findViewById(R.id.b8q).getLayoutParams().width = (int) this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int i3) {
        if (this.G == i3) {
            return;
        }
        this.G = i3;
        if (i3 != 1) {
            if (i3 == 2) {
                this.F.setVisibility(0);
                this.D.setVisibility(4);
                this.f283057m.setVisibility(4);
                this.C.setVisibility(0);
                return;
            }
            return;
        }
        this.F.setVisibility(4);
        this.f283057m.setVisibility(0);
        this.C.setVisibility(4);
        this.D.setVisibility(0);
        N0();
    }

    public QCircleLayerBean A0(int i3) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setSourceType(70);
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setSourceType(70);
        qCircleLayerBean.setDataPosInList(this.dataPosInList);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        qCircleLayerBean.setLayerBizAssemblerType("biz_qq_search");
        qCircleLayerBean.setGlobalViewModelKey(this.K.S1());
        qCircleLayerBean.setFeed(getData());
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("feedid", getData().f398449id.get());
        hashMap.put(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(i3));
        qCircleLayerBean.setSchemeAttrs(hashMap);
        return qCircleLayerBean;
    }

    protected abstract String E0();

    protected abstract String F0();

    protected abstract String G0();

    protected void L0() {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", F0());
        hashMap.put("xsj_eid", F0());
        this.R.b(this.f283057m, hashMap, getData(), "pg_search_result");
    }

    protected void M0() {
        this.R.c(this.f283057m);
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        if (isPlaying()) {
            O0();
            z0(2);
        }
        this.L.K();
        M0();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoOnPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.fur;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.f283057m = (QFSVideoView) findViewById(R.id.koo);
        this.C = (URLImageView) findViewById(R.id.duw);
        this.D = (ImageView) findViewById(R.id.f165951y63);
        this.E = (RoundRelativeLayout) findViewById(R.id.f7848477);
        this.F = findViewById(R.id.lzl);
        this.E.setRoundLayoutRadius(ViewUtils.dip2px(4.0f));
        this.D.setOnClickListener(this);
        setOnClickListener(this);
        this.f283055h.c(this.f283056i);
        this.f283055h.h(this);
        this.J = (mo2.a) getViewModel(mo2.a.class);
        QFSSearchVideoPlayHelper qFSSearchVideoPlayHelper = new QFSSearchVideoPlayHelper(new b(), new a(), G0(), "pg_search_result");
        this.L = qFSSearchVideoPlayHelper;
        qFSSearchVideoPlayHelper.T(this.f283057m);
        this.L.R(new c(this));
    }

    @Override // e80.g
    public boolean isPlaying() {
        if (this.G == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("QCircleSearchDoubleVideoItemView", 4, "onAttachedToWindow: hash=" + hashCode());
        B0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            this.J.f417103i = !r0.f417103i;
            N0();
            this.f283057m.setOutPutMute(this.J.f417103i);
        } else {
            H0();
            com.tencent.mobileqq.search.business.qcircle.video.base.a aVar = this.f283054f;
            if (aVar != null) {
                aVar.b();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("QCircleSearchDoubleVideoItemView", 4, "onDetachedFromWindow: hash=" + hashCode());
        C0();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        QLog.d("QCircleSearchDoubleVideoItemView", 4, "onFinishTemporaryDetach: hash=" + hashCode());
        B0();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoOnPlayEvent) {
            J0((QFSVideoOnPlayEvent) simpleBaseEvent);
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        QLog.d("QCircleSearchDoubleVideoItemView", 4, "onStartTemporaryDetach: hash=" + hashCode());
        C0();
    }

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        stop();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        if (isPlaying()) {
            return;
        }
        z0(1);
        this.K.P1(getData().f398449id.get());
        L0();
        QFSSearchPrerenderManager.E(getContext()).s(G0(), this.N);
        QFSSearchVideoPlayHelper.N(getData().f398449id.get(), hashCode());
        this.L.I();
    }

    public void setHorizontalMode(boolean z16) {
        this.P = z16;
    }

    public void setLoop(boolean z16) {
        this.Q = z16;
    }

    public void setup(HorizontalListView horizontalListView, z zVar, com.tencent.mobileqq.search.business.qcircle.video.base.a aVar, com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a aVar2) {
        this.f283053e = horizontalListView;
        this.f283054f = aVar;
        this.K = aVar2;
        initView();
        this.f283056i.i1(zVar);
    }

    @Override // e80.g
    public void stop() {
        if (!isPlaying()) {
            return;
        }
        O0();
        z0(2);
        this.L.V(new Runnable() { // from class: com.tencent.mobileqq.search.business.qcircle.video.base.c
            @Override // java.lang.Runnable
            public final void run() {
                QCircleSearchDoubleVideoItemView.this.D0();
            }
        });
        M0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (this.M == feedCloudMeta$StFeed) {
            return;
        }
        this.M = feedCloudMeta$StFeed;
        this.N = i3;
        stop();
        z0(2);
        v0();
        x0();
        N0();
        wo2.b.c(this.C, getData().cover.picUrl.get());
        this.f283056i.h1(this.C.getLayoutParams().width);
        this.f283055h.f(getData(), i3);
        this.L.P(this.Q);
        this.L.Q(i3);
        this.L.S(feedCloudMeta$StFeed);
        SimpleEventBus.getInstance().dispatchEvent(new QFSSearchCheckPlayEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements QFSSearchVideoPlayHelper.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.a
        public boolean H() {
            return QCircleSearchDoubleVideoItemView.this.J.f417103i;
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.a
        public void onPlay() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements QFSSearchVideoPlayHelper.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.b
        public void setStatusPlay() {
            QCircleSearchDoubleVideoItemView.this.z0(1);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.b
        public void setStatusLoading() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c implements QFSSearchVideoPlayHelper.d {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleSearchDoubleVideoItemView> f283060d;

        public c(QCircleSearchDoubleVideoItemView qCircleSearchDoubleVideoItemView) {
            this.f283060d = null;
            this.f283060d = new WeakReference<>(qCircleSearchDoubleVideoItemView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            QCircleSearchDoubleVideoItemView qCircleSearchDoubleVideoItemView = this.f283060d.get();
            if (qCircleSearchDoubleVideoItemView != null) {
                if (!qCircleSearchDoubleVideoItemView.isPlaying()) {
                    return;
                }
                qCircleSearchDoubleVideoItemView.stop();
                qCircleSearchDoubleVideoItemView.K.R1(qCircleSearchDoubleVideoItemView.getData().f398449id.get(), 0);
                if (qCircleSearchDoubleVideoItemView.f283054f != null) {
                    qCircleSearchDoubleVideoItemView.f283054f.r();
                    return;
                }
                return;
            }
            QLog.w("QCircleSearchDoubleVideoItemView", 1, "playNext error");
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public int b0() {
            QCircleSearchDoubleVideoItemView qCircleSearchDoubleVideoItemView = this.f283060d.get();
            if (qCircleSearchDoubleVideoItemView != null) {
                return qCircleSearchDoubleVideoItemView.K.N1(qCircleSearchDoubleVideoItemView.getData().f398449id.get());
            }
            QLog.w("QCircleSearchDoubleVideoItemView", 1, "getStartOffset error");
            return 0;
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void o0() {
            QCircleSearchDoubleVideoItemView qCircleSearchDoubleVideoItemView = this.f283060d.get();
            if (qCircleSearchDoubleVideoItemView != null) {
                QFSSearchPrerenderManager.E(qCircleSearchDoubleVideoItemView.getContext()).r(qCircleSearchDoubleVideoItemView.G0(), qCircleSearchDoubleVideoItemView.N);
            } else {
                QLog.w("QCircleSearchDoubleVideoItemView", 1, "onPostPlay error");
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void onCompletion() {
            QCircleSearchDoubleVideoItemView qCircleSearchDoubleVideoItemView = this.f283060d.get();
            if (qCircleSearchDoubleVideoItemView != null && !qCircleSearchDoubleVideoItemView.Q) {
                qCircleSearchDoubleVideoItemView.post(new Runnable() { // from class: com.tencent.mobileqq.search.business.qcircle.video.base.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleSearchDoubleVideoItemView.c.this.b();
                    }
                });
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public boolean onPlayError(int i3) {
            return false;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            QCircleSearchDoubleVideoItemView qCircleSearchDoubleVideoItemView = this.f283060d.get();
            if (qCircleSearchDoubleVideoItemView != null) {
                qCircleSearchDoubleVideoItemView.M0();
            } else {
                QLog.w("QCircleSearchDoubleVideoItemView", 1, "onVideoLoopStart error");
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            QCircleSearchDoubleVideoItemView qCircleSearchDoubleVideoItemView = this.f283060d.get();
            if (qCircleSearchDoubleVideoItemView != null) {
                qCircleSearchDoubleVideoItemView.L0();
            } else {
                QLog.w("QCircleSearchDoubleVideoItemView", 1, "onVideoLoopStart error");
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void p0(ISuperPlayer iSuperPlayer) {
            QCircleSearchDoubleVideoItemView qCircleSearchDoubleVideoItemView = this.f283060d.get();
            if (qCircleSearchDoubleVideoItemView != null) {
                qCircleSearchDoubleVideoItemView.L0();
            }
            QLog.w("QCircleSearchDoubleVideoItemView", 1, "getStartOffset error");
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void R() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void d0() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void c0(int i3, int i16) {
        }
    }
}
