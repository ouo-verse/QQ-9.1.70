package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.QFSFlowAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.request.QFSGetMusicInfoRequest;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.views.QFSAudioView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.Call;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeedMusic;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StMusicPageData;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$SongInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAggregationMusicHeadWidget extends QFSAggregationHeadWidgetView implements View.OnClickListener, y30.a {
    private QFSFlowAggregationFragment C;
    private SquareImageView D;
    private QCircleAvatarView E;
    private ImageView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private QQCircleFeedBase$StMusicPageData K;
    private QFSFlowAggregationViewModel L;
    private QFSAudioView M;
    private boolean N;
    private boolean P;
    private Size Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
            QFSAggregationMusicHeadWidget.this.s0(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayErrorStatusListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            QLog.e("QFSAggregationMusicHeadWidget", 1, "mAudioView onError  | module = " + i3 + " | errorType = " + i16 + " | errorCode = " + i17 + " | extraInfo = " + str);
            if (QFSAggregationMusicHeadWidget.this.K != null) {
                QFSAggregationMusicHeadWidget qFSAggregationMusicHeadWidget = QFSAggregationMusicHeadWidget.this;
                qFSAggregationMusicHeadWidget.x0(qFSAggregationMusicHeadWidget.K.music.MID.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Call.OnRspCallBack<QCircleBaseRequest> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f84796d;

        c(String str) {
            this.f84796d = str;
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
            if (QFSAggregationMusicHeadWidget.this.M != null && (obj instanceof QQCircleSmartMatchMusic$MusicInfoRsp)) {
                QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp = (QQCircleSmartMatchMusic$MusicInfoRsp) obj;
                if (qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.isEmpty()) {
                    QLog.i("QFSAggregationMusicHeadWidget", 1, "[requestMusicInfo] musicListInfo is null");
                    return;
                }
                QQCircleSmartMatchMusic$SongInfo qQCircleSmartMatchMusic$SongInfo = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get().get(0).songInfo;
                if (qQCircleSmartMatchMusic$SongInfo == null) {
                    QLog.i("QFSAggregationMusicHeadWidget", 1, "[requestMusicInfo] songInfo is null");
                    return;
                }
                QQCircleSmartMatchMusic$SongInfo qQCircleSmartMatchMusic$SongInfo2 = qQCircleSmartMatchMusic$SongInfo.get();
                QFSAggregationMusicHeadWidget.this.M.loadPlayOptions(RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setIsVideo(false).setPlayUrl(qQCircleSmartMatchMusic$SongInfo2.PlayUrl.get()).setFileId(this.f84796d).setStartOffset(0L));
                QLog.i("QFSAggregationMusicHeadWidget", 1, "requestMusicInfo  rsp playUrl = " + qQCircleSmartMatchMusic$SongInfo2.PlayUrl.get());
            }
        }
    }

    public QFSAggregationMusicHeadWidget(@NonNull Context context) {
        this(context, null);
    }

    private void A0() {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.K;
        if (qQCircleFeedBase$StMusicPageData != null && (feedCloudMeta$StFeedMusic = qQCircleFeedBase$StMusicPageData.music) != null) {
            if (feedCloudMeta$StFeedMusic.scene.get() == 3) {
                this.D.setVisibility(8);
                this.E.setVisibility(0);
                this.E.setUser(this.K.music.authorUser, this.Q);
            } else {
                this.D.setVisibility(0);
                this.E.setVisibility(8);
                Option targetView = Option.obtain().setUrl(this.K.music.cover.picUrl.get()).setFailDrawable(getContext().getResources().getDrawable(R.drawable.onp)).setLoadingDrawable(getContext().getResources().getDrawable(R.drawable.onp)).setTargetView(this.D);
                QCircleFeedPicLoader.setViewWidthHeight(targetView, this.D);
                QCircleFeedPicLoader.g().loadImage(targetView);
            }
        }
    }

    private void B0(boolean z16) {
        if (this.F == null) {
            QLog.e(getLogTag(), 1, "[updatePlayIcon] mIvPlayControl == null");
            return;
        }
        QLog.d(getLogTag(), 1, "[updatePlayIcon] isPlay = " + z16);
        this.F.setSelected(z16);
    }

    private void C0() {
        int i3;
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.K;
        if (qQCircleFeedBase$StMusicPageData != null && qQCircleFeedBase$StMusicPageData.music != null) {
            this.G.setText(qQCircleFeedBase$StMusicPageData.title.get());
            TextView textView = this.G;
            int i16 = 8;
            if (TextUtils.isEmpty(this.K.title.get())) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
            this.H.setText(this.K.subTitle.get());
            TextView textView2 = this.H;
            if (!TextUtils.isEmpty(this.K.subTitle.get())) {
                i16 = 0;
            }
            textView2.setVisibility(i16);
            this.I.setText(this.K.music.singerName.get());
            this.J.setText(this.K.desc.get());
        }
    }

    private void initView() {
        this.D = (SquareImageView) findViewById(R.id.duw);
        this.E = (QCircleAvatarView) findViewById(R.id.f165909du3);
        this.F = (ImageView) findViewById(R.id.y6x);
        this.G = (TextView) findViewById(R.id.kbs);
        this.I = (TextView) findViewById(R.id.k5h);
        this.H = (TextView) findViewById(R.id.f167057me2);
        this.J = (TextView) findViewById(R.id.f107316a3);
        this.F.setOnClickListener(this);
        this.M = new QFSAudioView(getContext());
        this.Q = n.a(getContext(), R.dimen.czr);
    }

    private void q0(RFWPlayerOptions rFWPlayerOptions) {
        QFSAudioView qFSAudioView = this.M;
        if (qFSAudioView != null && qFSAudioView.getSuperPlayer() != null) {
            rFWPlayerOptions.getListenerSet().addErrorStatusListener(new b());
        }
    }

    private void r0(boolean z16) {
        String str;
        VideoReport.setElementId(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_PLAY_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PLAY_BUTTON);
        buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_MUSIC_AGG_PAGE);
        if (z16) {
            str = "play";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.SUSPEND;
        }
        buildElementParams.put("xsj_status", str);
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.K;
        if (qQCircleFeedBase$StMusicPageData != null) {
            buildElementParams.put("xsj_music_id", qQCircleFeedBase$StMusicPageData.music.MID.get());
            buildElementParams.put("xsj_music_name", this.K.music.musicName.get());
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.M, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state == 2 || state == 3) {
            z0(uIStateData.getData());
        }
    }

    private boolean v0() {
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.K;
        if (qQCircleFeedBase$StMusicPageData != null && !TextUtils.isEmpty(qQCircleFeedBase$StMusicPageData.music.MID.get()) && !TextUtils.isEmpty(this.K.music.playUrl.get())) {
            return true;
        }
        return false;
    }

    private void w0() {
        QFSAudioView qFSAudioView;
        if (v0() && (qFSAudioView = this.M) != null) {
            if (qFSAudioView.getSuperPlayer() == null) {
                RFWLog.d("QFSAggregationMusicHeadWidget", RFWLog.USR, "execute a new player" + hashCode());
                y0();
                r0(false);
                return;
            }
            if (!this.M.isRelease() && !this.M.getQCirclePlayer().isDeInit()) {
                if (this.M.getSuperPlayer().isPlaying()) {
                    RFWLog.d("QFSAggregationMusicHeadWidget", RFWLog.USR, "isPlaying when resume:" + hashCode());
                    this.M.pause();
                    B0(false);
                    QLog.i("QFSAggregationMusicHeadWidget", 1, "[musicPlayClick] pause");
                    r0(true);
                    return;
                }
                if (this.M.getSuperPlayer().isPausing()) {
                    RFWLog.d("QFSAggregationMusicHeadWidget", RFWLog.USR, "startFromPause hashCode:" + hashCode());
                    this.M.start();
                    B0(true);
                    QLog.i("QFSAggregationMusicHeadWidget", 1, "[musicPlayClick] start");
                    r0(false);
                    return;
                }
                y0();
                return;
            }
            RFWLog.d("QFSAggregationMusicHeadWidget", RFWLog.USR, "execute a new player released" + hashCode());
            y0();
            r0(false);
            return;
        }
        QLog.e("QFSAggregationMusicHeadWidget", 1, "[musicPlayClick] mid or url == null");
        QCircleToast.j(QCircleToast.f91645e, h.a(R.string.f1919846_), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str) {
        QLog.i("QFSAggregationMusicHeadWidget", 1, "requestMusicInfo  mid = " + str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSGetMusicInfoRequest(arrayList)).m250setRspOnCallBack((Call.OnRspCallBack) new c(str)).execute();
    }

    private void y0() {
        RFWPlayerOptions startOffset = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setIsVideo(false).setPlayUrl(this.K.music.playUrl.get()).setFileId(this.K.music.MID.get()).setStartOffset(0L);
        q0(startOffset);
        B0(true);
        this.M.loadPlayOptions(startOffset);
        QLog.i("QFSAggregationMusicHeadWidget", 1, "[startANewAudioPlayer] setVideoPath | mid = " + this.K.music.MID.get() + " | path = " + this.K.music.playUrl.get());
    }

    private void z0(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
        if (qQCircleFeedBase$StFeedListBusiRspData == null) {
            return;
        }
        this.K = qQCircleFeedBase$StFeedListBusiRspData.musicPageData.get();
        A0();
        C0();
    }

    @Override // y30.a
    public void f() {
        QFSAudioView qFSAudioView = this.M;
        if (qFSAudioView != null) {
            qFSAudioView.release();
        }
        this.N = true;
        QLog.i("QFSAggregationMusicHeadWidget", 1, "onPartDestroy  release");
    }

    @Override // com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g7i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidgetView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSAggregationMusicHeadWidget";
    }

    @Override // y30.a
    public void onActivityPause() {
        QFSAudioView qFSAudioView = this.M;
        if (qFSAudioView != null && qFSAudioView.getSuperPlayer() != null && this.M.getSuperPlayer().isPlaying()) {
            this.M.pause();
            this.P = true;
            QLog.i("QFSAggregationMusicHeadWidget", 1, "onActivityPause  audio pause");
        }
    }

    @Override // y30.a
    public void onActivityResume() {
        if (this.P && this.M != null) {
            if (!v0()) {
                QLog.e("QFSAggregationMusicHeadWidget", 1, "[onActivityResume] mid or url == null");
                B0(false);
                return;
            } else {
                if (this.M.getSuperPlayer() != null && this.M.getSuperPlayer().isPausing()) {
                    this.M.start();
                    B0(true);
                    return;
                }
                if (this.M == null) {
                    this.M = new QFSAudioView(getContext());
                }
                y0();
                this.P = false;
                QLog.i("QFSAggregationMusicHeadWidget", 1, "[onActivityResume] audio start");
                return;
            }
        }
        QLog.i("QFSAggregationMusicHeadWidget", 1, "[onActivityResume] is not need start audio");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y6x) {
            w0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void u0() {
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel = (QFSFlowAggregationViewModel) getViewModel(this.C, QFSFlowAggregationViewModel.class);
        this.L = qFSFlowAggregationViewModel;
        qFSFlowAggregationViewModel.X1().observe(this, new a());
    }

    public QFSAggregationMusicHeadWidget(@NonNull Context context, QFSFlowAggregationFragment qFSFlowAggregationFragment) {
        super(context);
        this.N = true;
        initView();
        this.C = qFSFlowAggregationFragment;
        u0();
    }
}
