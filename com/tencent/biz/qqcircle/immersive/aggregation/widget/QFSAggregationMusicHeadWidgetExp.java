package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.QFSFlowAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.request.QFSGetMusicInfoRequest;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.views.QFSAudioView;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.Call;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeedMusic;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StMusicPageData;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$SongInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAggregationMusicHeadWidgetExp extends QFSAggregationHeadWidgetView implements View.OnClickListener, y30.a {
    private QFSFlowAggregationFragment C;
    private LinearLayout D;
    private SquareImageView E;
    private QCircleAvatarView F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private ImageView K;
    private TextView L;
    private View M;
    private SquareImageView N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private QQCircleFeedBase$StMusicPageData S;
    private QFSFlowAggregationViewModel T;
    private QFSAudioView U;
    private boolean V;
    private Size W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
            QFSAggregationMusicHeadWidgetExp.this.w0(uIStateData);
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
            QLog.e("QFSAggregationMusicHeadWidgetExp", 1, "mAudioView onError  | module = " + i3 + " | errorType = " + i16 + " | errorCode = " + i17 + " | extraInfo = " + str);
            if (QFSAggregationMusicHeadWidgetExp.this.S != null) {
                QFSAggregationMusicHeadWidgetExp qFSAggregationMusicHeadWidgetExp = QFSAggregationMusicHeadWidgetExp.this;
                qFSAggregationMusicHeadWidgetExp.F0(qFSAggregationMusicHeadWidgetExp.S.music.MID.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Call.OnRspCallBack<QCircleBaseRequest> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f84800d;

        c(String str) {
            this.f84800d = str;
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
            if (QFSAggregationMusicHeadWidgetExp.this.U != null && (obj instanceof QQCircleSmartMatchMusic$MusicInfoRsp)) {
                QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp = (QQCircleSmartMatchMusic$MusicInfoRsp) obj;
                if (qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.isEmpty()) {
                    QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "[requestMusicInfo] musicListInfo is null");
                    return;
                }
                QQCircleSmartMatchMusic$SongInfo qQCircleSmartMatchMusic$SongInfo = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get().get(0).songInfo;
                if (qQCircleSmartMatchMusic$SongInfo == null) {
                    QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "[requestMusicInfo] songInfo is null");
                    return;
                }
                QQCircleSmartMatchMusic$SongInfo qQCircleSmartMatchMusic$SongInfo2 = qQCircleSmartMatchMusic$SongInfo.get();
                QFSAggregationMusicHeadWidgetExp.this.U.loadPlayOptions(RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setIsVideo(false).setPlayUrl(qQCircleSmartMatchMusic$SongInfo2.PlayUrl.get()).setFileId(this.f84800d).setStartOffset(0L));
                QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "requestMusicInfo  rsp playUrl = " + qQCircleSmartMatchMusic$SongInfo2.PlayUrl.get());
            }
        }
    }

    public QFSAggregationMusicHeadWidgetExp(@NonNull Context context) {
        this(context, null);
    }

    private boolean A0() {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData == null || (feedCloudMeta$StFeedMusic = qQCircleFeedBase$StMusicPageData.music) == null || feedCloudMeta$StFeedMusic.scene.get() != 3) {
            return false;
        }
        return true;
    }

    private void B0() {
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData != null && qQCircleFeedBase$StMusicPageData.include_music != null) {
            QFSFlowAggregationInitBean qFSFlowAggregationInitBean = new QFSFlowAggregationInitBean();
            qFSFlowAggregationInitBean.setFeedMusic(this.S.include_music.get());
            qFSFlowAggregationInitBean.setAggregationType(43);
            com.tencent.biz.qqcircle.launcher.c.H(getContext(), qFSFlowAggregationInitBean);
        }
    }

    private void C0() {
        PBStringField pBStringField;
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData == null || (pBStringField = qQCircleFeedBase$StMusicPageData.include_publish_schema) == null || TextUtils.isEmpty(pBStringField.get())) {
            return;
        }
        QCircleSchemeLauncher.d(getContext(), this.S.include_publish_schema.get());
    }

    private void D0() {
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData == null || TextUtils.isEmpty(qQCircleFeedBase$StMusicPageData.music.authorUser.f398463id.get()) || this.K.getVisibility() != 0) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(this.S.music.authorUser.f398463id.get());
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
    }

    private void E0() {
        QFSAudioView qFSAudioView;
        if (z0() && (qFSAudioView = this.U) != null) {
            if (qFSAudioView.getSuperPlayer() == null) {
                RFWLog.d("QFSAggregationMusicHeadWidgetExp", RFWLog.USR, "execute a new player" + hashCode());
                I0();
                r0(false);
                return;
            }
            if (!this.U.isRelease() && !this.U.getQCirclePlayer().isDeInit()) {
                if (this.U.getSuperPlayer().isPlaying()) {
                    RFWLog.d("QFSAggregationMusicHeadWidgetExp", RFWLog.USR, "isPlaying when resume:" + hashCode());
                    this.U.pause();
                    N0(false);
                    QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "[musicPlayClick] pause");
                    r0(true);
                    return;
                }
                if (this.U.getSuperPlayer().isPausing()) {
                    RFWLog.d("QFSAggregationMusicHeadWidgetExp", RFWLog.USR, "startFromPause hashCode:" + hashCode());
                    this.U.start();
                    N0(true);
                    QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "[musicPlayClick] start");
                    r0(false);
                    return;
                }
                I0();
                return;
            }
            RFWLog.d("QFSAggregationMusicHeadWidgetExp", RFWLog.USR, "execute a new player released" + hashCode());
            I0();
            r0(false);
            return;
        }
        QLog.e("QFSAggregationMusicHeadWidgetExp", 1, "[musicPlayClick] mid or url == null");
        QCircleToast.j(QCircleToast.f91645e, h.a(R.string.f1919846_), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(String str) {
        QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "requestMusicInfo  mid = " + str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSGetMusicInfoRequest(arrayList)).m250setRspOnCallBack((Call.OnRspCallBack) new c(str)).execute();
    }

    private void G0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.E.setVisibility(8);
        this.F.setVisibility(0);
        this.F.setUser(feedCloudMeta$StUser, this.W);
    }

    private void H0(String str) {
        this.E.setVisibility(0);
        this.F.setVisibility(8);
        Option targetView = Option.obtain().setUrl(str).setFailDrawable(getContext().getResources().getDrawable(R.drawable.onp)).setLoadingDrawable(getContext().getResources().getDrawable(R.drawable.onp)).setTargetView(this.E);
        QCircleFeedPicLoader.setViewWidthHeight(targetView, this.E);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    private void I0() {
        RFWPlayerOptions startOffset = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setIsVideo(false).setPlayUrl(this.S.music.playUrl.get()).setFileId(this.S.music.MID.get()).setStartOffset(0L);
        q0(startOffset);
        N0(true);
        this.U.loadPlayOptions(startOffset);
        QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "[startANewAudioPlayer] setVideoPath | mid = " + this.S.music.MID.get() + " | path = " + this.S.music.playUrl.get());
    }

    private void J0(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData, boolean z16) {
        if (qQCircleFeedBase$StFeedListBusiRspData == null) {
            return;
        }
        this.S = qQCircleFeedBase$StFeedListBusiRspData.musicPageData.get();
        K0();
        O0();
        M0(z16);
    }

    private void K0() {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData != null && (feedCloudMeta$StFeedMusic = qQCircleFeedBase$StMusicPageData.music) != null) {
            if (feedCloudMeta$StFeedMusic.scene.get() == 3) {
                if (o83.b.f422214a.a()) {
                    H0(this.S.music.authorUser.icon.iconUrl.get());
                    return;
                } else {
                    G0(this.S.music.authorUser);
                    return;
                }
            }
            H0(this.S.music.cover.picUrl.get());
        }
    }

    private void L0() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.bottomMargin = cx.a(16.0f);
        this.D.setLayoutParams(layoutParams);
    }

    private void M0(boolean z16) {
        if (z16) {
            QLog.d("QFSAggregationMusicHeadWidgetExp", 1, "updateMusicAreaInfo, loadMore data do not refresh UI.");
            return;
        }
        if (!A0()) {
            return;
        }
        this.K.setVisibility(0);
        s0(this.J, false);
        s0(this.K, true);
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic = this.S.include_music;
        if (feedCloudMeta$StFeedMusic != null && !TextUtils.isEmpty(feedCloudMeta$StFeedMusic.MID.get())) {
            this.M.setVisibility(0);
            Option targetView = Option.obtain().setUrl(this.S.include_music.cover.picUrl.get()).setFailDrawable(getContext().getResources().getDrawable(R.drawable.onp)).setLoadingDrawable(getContext().getResources().getDrawable(R.drawable.onp)).setTargetView(this.N);
            QCircleFeedPicLoader.setViewWidthHeight(targetView, this.N);
            QCircleFeedPicLoader.g().loadImage(targetView);
            this.P.setText(this.S.include_music.musicName.get());
            this.Q.setText(this.S.include_music.singerName.get());
            L0();
            v0();
            u0();
            return;
        }
        QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "include_music info is empty.");
    }

    private void N0(boolean z16) {
        if (this.G == null) {
            QLog.e(getLogTag(), 1, "[updatePlayIcon] mIvPlayControl == null");
            return;
        }
        QLog.d(getLogTag(), 1, "[updatePlayIcon] isPlay = " + z16);
        this.G.setSelected(z16);
    }

    private void O0() {
        int i3;
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData != null && qQCircleFeedBase$StMusicPageData.music != null) {
            this.H.setText(qQCircleFeedBase$StMusicPageData.title.get());
            TextView textView = this.H;
            if (TextUtils.isEmpty(this.S.title.get())) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
            this.J.setText(this.S.music.singerName.get());
            this.L.setText(this.S.desc.get());
        }
    }

    private void initView() {
        this.D = (LinearLayout) findViewById(R.id.x88);
        this.E = (SquareImageView) findViewById(R.id.duw);
        this.F = (QCircleAvatarView) findViewById(R.id.f165909du3);
        this.G = (ImageView) findViewById(R.id.y6x);
        this.H = (TextView) findViewById(R.id.kbs);
        this.J = (TextView) findViewById(R.id.k5h);
        this.K = (ImageView) findViewById(R.id.f10618681);
        this.I = (TextView) findViewById(R.id.f167057me2);
        this.L = (TextView) findViewById(R.id.f107316a3);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.U = new QFSAudioView(getContext());
        this.W = n.a(getContext(), R.dimen.czr);
    }

    private void q0(RFWPlayerOptions rFWPlayerOptions) {
        QFSAudioView qFSAudioView = this.U;
        if (qFSAudioView != null && qFSAudioView.getSuperPlayer() != null) {
            rFWPlayerOptions.getListenerSet().addErrorStatusListener(new b());
        }
    }

    private void r0(boolean z16) {
        String str;
        VideoReport.setElementId(this.U, QCircleDaTongConstant.ElementId.EM_XSJ_PLAY_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PLAY_BUTTON);
        buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_MUSIC_AGG_PAGE);
        if (z16) {
            str = "play";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.SUSPEND;
        }
        buildElementParams.put("xsj_status", str);
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData != null) {
            buildElementParams.put("xsj_music_id", qQCircleFeedBase$StMusicPageData.music.MID.get());
            buildElementParams.put("xsj_music_name", this.S.music.musicName.get());
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.U, buildElementParams);
    }

    private void s0(View view, boolean z16) {
        ExposurePolicy exposurePolicy;
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_USER_INFO);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.S.music.authorUser.f398463id.get());
        VideoReport.setElementParams(view, buildElementParams);
        if (z16) {
            exposurePolicy = ExposurePolicy.REPORT_ALL;
        } else {
            exposurePolicy = ExposurePolicy.REPORT_NONE;
        }
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void u0() {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        VideoReport.setElementId(this.R, QCircleDaTongConstant.ElementId.EM_XSJ_REAL_VOICE_USER_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData != null && (feedCloudMeta$StFeedMusic = qQCircleFeedBase$StMusicPageData.include_music) != null) {
            buildElementParams.put("xsj_music_id", feedCloudMeta$StFeedMusic.MID.get());
            buildElementParams.put("xsj_music_name", this.S.include_music.musicName.get());
        }
        VideoReport.setElementParams(this.R, buildElementParams);
        VideoReport.setElementExposePolicy(this.R, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.R, ClickPolicy.REPORT_ALL);
    }

    private void v0() {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        VideoReport.setElementId(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_REAL_VOICE_SONG);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData != null && (feedCloudMeta$StFeedMusic = qQCircleFeedBase$StMusicPageData.include_music) != null) {
            buildElementParams.put("xsj_music_id", feedCloudMeta$StFeedMusic.MID.get());
            buildElementParams.put("xsj_music_name", this.S.include_music.musicName.get());
        }
        VideoReport.setElementParams(this.M, buildElementParams);
        VideoReport.setElementExposePolicy(this.M, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.M, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state == 2 || state == 3) {
            J0(uIStateData.getData(), uIStateData.getIsLoadMore());
        }
    }

    private void x0() {
        this.M = findViewById(R.id.f3k);
        this.N = (SquareImageView) findViewById(R.id.f166358zk3);
        this.P = (TextView) findViewById(R.id.zkb);
        this.Q = (TextView) findViewById(R.id.zju);
        this.R = (TextView) findViewById(R.id.tiw);
        this.M.setOnClickListener(this);
        this.R.setOnClickListener(this);
    }

    private boolean z0() {
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.S;
        if (qQCircleFeedBase$StMusicPageData != null && !TextUtils.isEmpty(qQCircleFeedBase$StMusicPageData.music.MID.get()) && !TextUtils.isEmpty(this.S.music.playUrl.get())) {
            return true;
        }
        return false;
    }

    @Override // y30.a
    public void f() {
        QFSAudioView qFSAudioView = this.U;
        if (qFSAudioView != null) {
            qFSAudioView.release();
        }
        QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "onPartDestroy  release");
    }

    @Override // com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g7j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidgetView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSAggregationMusicHeadWidgetExp";
    }

    @Override // y30.a
    public void onActivityPause() {
        QFSAudioView qFSAudioView = this.U;
        if (qFSAudioView != null && qFSAudioView.getSuperPlayer() != null && this.U.getSuperPlayer().isPlaying()) {
            this.U.pause();
            this.V = true;
            QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "onActivityPause  audio pause");
        }
    }

    @Override // y30.a
    public void onActivityResume() {
        if (this.V && this.U != null) {
            if (!z0()) {
                QLog.e("QFSAggregationMusicHeadWidgetExp", 1, "[onActivityResume] mid or url == null");
                N0(false);
                return;
            } else {
                if (this.U.getSuperPlayer() != null && this.U.getSuperPlayer().isPausing()) {
                    this.U.start();
                    N0(true);
                    return;
                }
                if (this.U == null) {
                    this.U = new QFSAudioView(getContext());
                }
                I0();
                this.V = false;
                QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "[onActivityResume] audio start");
                return;
            }
        }
        QLog.i("QFSAggregationMusicHeadWidgetExp", 1, "[onActivityResume] is not need start audio");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y6x) {
            E0();
        } else if (view.getId() != R.id.k5h && view.getId() != R.id.f10618681) {
            if (view.getId() == R.id.tiw) {
                C0();
            } else if (view.getId() == R.id.f3k) {
                B0();
            }
        } else {
            D0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void y0() {
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel = (QFSFlowAggregationViewModel) getViewModel(this.C, QFSFlowAggregationViewModel.class);
        this.T = qFSFlowAggregationViewModel;
        qFSFlowAggregationViewModel.X1().observe(this, new a());
    }

    public QFSAggregationMusicHeadWidgetExp(@NonNull Context context, QFSFlowAggregationFragment qFSFlowAggregationFragment) {
        super(context);
        initView();
        x0();
        this.C = qFSFlowAggregationFragment;
        y0();
    }
}
