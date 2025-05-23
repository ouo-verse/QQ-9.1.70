package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.qq.e.comm.constants.Constants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;
import tencent.gdt.qq_ad_get;

/* loaded from: classes4.dex */
public class QFSFullScreenAdVideoPresenter extends QFSFullScreenVideoPresenter {
    private FeedCloudMeta$StFeed B0;
    private GdtAd C0 = new GdtAd();
    private JSONObject D0 = new JSONObject();
    private String E0;
    private int F0;
    private int G0;
    private int H0;
    private int I0;
    private FeedCloudMeta$StFeed J0;
    private int K0;

    /* loaded from: classes4.dex */
    class a implements IRFWPlayerSdkInitListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).I.setProgressBar(((QFSFullScreenVideoPresenter) QFSFullScreenAdVideoPresenter.this).P);
            ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).I.setLoadingView(((QFSFullScreenVideoPresenter) QFSFullScreenAdVideoPresenter.this).Q, 1);
            ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).I.setLoopBack(true);
            ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).I.setOutPutMute(false);
        }
    }

    /* loaded from: classes4.dex */
    class b implements IRFWPlayerPrepareListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            QFSFullScreenAdVideoPresenter.this.r2();
            QFSFullScreenAdVideoPresenter.this.s3();
            QFSFullScreenAdVideoPresenter.this.l2(true);
            QFSFullScreenAdVideoPresenter.this.L4("bf", "1");
            QFSFullScreenAdVideoPresenter.this.l1(rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            if (rFWPlayer != null && ((QFSFullScreenVideoPresenter) QFSFullScreenAdVideoPresenter.this).f85259n0) {
                QFSFullScreenAdVideoPresenter.this.x2(rFWPlayer.getRealPlayer());
                QFSFullScreenAdVideoPresenter.this.L4("pa", "11");
            }
        }
    }

    /* loaded from: classes4.dex */
    class d implements IRFWPlayerLooperListener {
        d() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            QFSFullScreenAdVideoPresenter.f4(QFSFullScreenAdVideoPresenter.this);
            QFSFullScreenAdVideoPresenter.this.L4("ef", "1");
            QFSFullScreenAdVideoPresenter.this.G4();
            QFSFullScreenAdVideoPresenter.this.L4("ef", "0");
            if ((QFSFullScreenAdVideoPresenter.this.I0 > 30000 && ((QFSFullScreenVideoPresenter) QFSFullScreenAdVideoPresenter.this).f85263r0 == 2) || (QFSFullScreenAdVideoPresenter.this.I0 <= 30000 && ((QFSFullScreenVideoPresenter) QFSFullScreenAdVideoPresenter.this).f85263r0 == 3)) {
                ((QFSFullScreenVideoPresenter) QFSFullScreenAdVideoPresenter.this).f85263r0 = 0;
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            QFSFullScreenAdVideoPresenter.this.F0 = 0;
            QFSFullScreenAdVideoPresenter.this.L4("pa", "14");
            QFSFullScreenAdVideoPresenter.this.L4("bt", "0");
        }
    }

    /* loaded from: classes4.dex */
    class e implements IRFWPlayerCompletionListener {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            RFWLog.d("VFS-QFSFullScreenAdVideoPresenter", RFWLog.CLR, "[onCompletion] current is auto scroll: ", Boolean.valueOf(QFSFullScreenAdVideoPresenter.this.G3()));
            QFSFullScreenAdVideoPresenter.this.L4("ef", "1");
            QFSFullScreenAdVideoPresenter.this.G4();
        }
    }

    /* loaded from: classes4.dex */
    class f extends RFWPlayerIOC {
        f() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            return gb0.b.m(((QFSBaseFeedChildPresenter) QFSFullScreenAdVideoPresenter.this).E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(((QFSBaseFeedChildPresenter) QFSFullScreenAdVideoPresenter.this).f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean B4(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "onBindData is null: " + i3);
            return true;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.r.B0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2) && i3 == this.f85018i) {
            return true;
        }
        return false;
    }

    private int C4(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return -1;
        }
        int position = rFWFeedSelectInfo.getPosition();
        int nextPosition = rFWFeedSelectInfo.getNextPosition();
        if (nextPosition == 0) {
            return 5;
        }
        if (position > nextPosition) {
            return 2;
        }
        if (position >= nextPosition) {
            return -1;
        }
        return 1;
    }

    private void D4() {
        try {
            this.D0.put("bt", "0");
            this.D0.put(FileReaderHelper.ET_EXT, "0");
            this.D0.put("bf", "0");
            this.D0.put("ef", "0");
            this.D0.put("pp", "0");
            this.D0.put("pa", "0");
            this.D0.put("ft", "0");
            this.D0.put(Constants.KEYS.PLACEMENTS, "0");
            this.D0.put("pt", "0");
        } catch (JSONException e16) {
            QLog.e("VFS-QFSFullScreenAdVideoPresenter", 1, "initVideoReportParams failed, exception is " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E4(RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.s(rFWPlayerOptions, i3, i16, i17, str, feedCloudMeta$StFeed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F4(final RFWPlayerOptions rFWPlayerOptions, final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final int i3, final int i16, final int i17, final String str) {
        if (rFWPlayerOptions.isPlayerByDirectIP()) {
            QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "error play by ip return");
        } else {
            L4(Constants.KEYS.PLACEMENTS, "2");
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ep
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFullScreenAdVideoPresenter.this.E4(rFWPlayerOptions, i3, i16, i17, str, feedCloudMeta$StFeed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G4() {
        if (TextUtils.isEmpty(this.E0)) {
            QLog.i("VFS-QFSFullScreenAdVideoPresenter", 1, "videoReportUrl is empty, cancel video report");
        } else {
            com.tencent.biz.qqcircle.immersive.utils.d.f90201a.d(String.format(Locale.CHINA, "%s&video=%s", this.E0, URLEncoder.encode(this.D0.toString())));
            L4("ft", "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H4(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str, String str2) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setVideoPlayTime(this.G0).setSealTransfer(qCircleExtraTypeInfo.mFeed.recomInfo.recomTrace.get()).setExt1(str).setExt4(str2).setPageId(y0()).setFeedType1(5).setFeedType2(1).setfpageid(Integer.parseInt(t0())).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(dataBuilder);
        } else {
            QLog.e("QCircleReportHelper_VFS-QFSFullScreenAdVideoPresenter", 1, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
        }
    }

    private void I4(int i3) {
        if (i3 == -1) {
            return;
        }
        Gson gson = new Gson();
        HashMap hashMap = new HashMap();
        hashMap.put(QFS5507ReportHelper.JsonKey.END_TYPE, Integer.valueOf(i3));
        H4(400, 3, r(), "", gson.toJson(hashMap));
    }

    private void J4() {
        this.f85257l0 = 0;
        this.f85256k0 = 0;
        this.f85263r0 = 0;
        this.G0 = 0;
    }

    private void K4() {
        if (!TextUtils.equals(this.D0.optString("ft"), "2")) {
            L4("ft", "3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L4(String str, String str2) {
        try {
            this.D0.put(str, str2);
        } catch (JSONException e16) {
            QLog.e("VFS-QFSFullScreenAdVideoPresenter", 1, "initVideoReportParams failed, exception is " + e16);
        }
    }

    static /* synthetic */ int f4(QFSFullScreenAdVideoPresenter qFSFullScreenAdVideoPresenter) {
        int i3 = qFSFullScreenAdVideoPresenter.f85263r0;
        qFSFullScreenAdVideoPresenter.f85263r0 = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void y2() {
        if (this.I != null && this.N != null) {
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.N));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85258m0 + 1));
            buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_FULL_SCREEN_PAGE);
            try {
                QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
                qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.N.reportInfoForClient.get().toByteArray());
                if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.w("VFS-QFSFullScreenAdVideoPresenter", 1, "QCircleWaterfallFeedItemView, transferInfo error");
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_TIMESTAMP, Long.valueOf(this.N.createTime.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_COVER_URL, this.N.cover.picUrl.get());
            if (this.C0.isValid()) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_ID, Long.valueOf(this.C0.getAId()));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_TRACE_ID, this.C0.getTraceId());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_URL, this.C0.getUrlForClick());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_POS_ID, this.C0.getPosId());
            }
            buildElementParams.put("xsj_feed_id", this.E.g().f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, ((FeedCloudMeta$StFeed) this.f85017h).feedShowReason.showReason.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE, 5);
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoEntity build = new VideoEntity.Builder().setContentId(this.N.f398449id.get()).setPage((Object) QCircleDaTongConstant.PageId.PG_XSJ_FULL_SCREEN_PAGE).setContentType(2).setVideoDuration(this.I0).setVideoView((View) this.I).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            if (this.I.getSuperPlayer() != null) {
                VideoReport.bindVideoPlayerInfo(this.I, build);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        MotionEvent a16;
        View view;
        super.C0(hVar);
        if ((hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ak) && (a16 = ((com.tencent.biz.qqcircle.immersive.feed.event.ak) hVar).a()) != null && (view = this.f85249d0) != null) {
            int height = view.getHeight();
            float y16 = a16.getY();
            boolean b16 = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.b(this.C0, height, y16);
            QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "handleBroadcastMessage |heightPx: " + height + "|touchY: " + y16 + "|canOpenLandingPageInVideoArea: " + b16);
            if (b16) {
                com.tencent.biz.qqcircle.immersive.utils.j.f90213a.K(this.C0, this.f85249d0, this.f85018i, r(), 6);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void H3(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (this.I != null && this.B0 != null) {
            n1();
            QFSVideoView.D = new WeakReference<>(this.I);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.B0;
            this.I.setData(feedCloudMeta$StFeed, 0);
            String N = com.tencent.biz.qqcircle.immersive.utils.r.N(feedCloudMeta$StFeed.video.playUrl.get());
            long max = Math.max(this.f85256k0, 0);
            if (G2() - max <= 5000) {
                max = 0;
            }
            QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "fs_lifecycle  startANewPlayer , feedId = " + this.N.f398449id.get() + " , playUrlKey = " + this.N.video.playUrl.get() + " , adFeedId = " + feedCloudMeta$StFeed.f398449id.get() + " , adPlayUrlKey:" + N + " , hashcode: " + hashCode() + " , traceId: " + com.tencent.biz.qqcircle.immersive.utils.ba.d(feedCloudMeta$StFeed));
            RFWPlayerOptions fromType = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get()).setFileId(feedCloudMeta$StFeed.video.fileId.get()).setStVideo(gb0.b.k(feedCloudMeta$StFeed.video)).setStartOffset(max).setFromType(6);
            U1(feedCloudMeta$StFeed, fromType, N);
            fromType.setPlayIOC(new f());
            this.I.loadPlayOptions(fromType);
            this.J0 = this.B0;
            this.K0 = this.f85018i;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        String str;
        super.K0();
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null) {
            qFSVideoView.setReportBean(getReportBean());
        }
        L4("bt", String.valueOf(this.F0));
        if (this.F0 == 0) {
            str = "1";
        } else {
            str = "0";
        }
        L4("bf", str);
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "onAttachedToWindow  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void L2(boolean z16) {
        this.f85260o0 = z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "[onDetachedFromWindow] mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void V1(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addCompletionListener(new e());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void W1(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull final RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.eo
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public final void onVideoPlayError(int i3, int i16, int i17, String str) {
                QFSFullScreenAdVideoPresenter.this.F4(rFWPlayerOptions, feedCloudMeta$StFeed, i3, i16, i17, str);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void X1(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addLooperListeners(new d());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void Z1(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new b());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void a2(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new a());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void c2(@NonNull RFWPlayerOptions rFWPlayerOptions, String str) {
        rFWPlayerOptions.getListenerSet().addSeekListeners(new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected boolean d3() {
        T t16;
        if (this.J0 != null && (t16 = this.f85017h) != 0 && this.K0 == this.f85018i) {
            try {
                if (((FeedCloudMeta$StFeed) t16).f398449id.get().equals(this.J0.f398449id.get()) && ((FeedCloudMeta$StFeed) this.f85017h).video.playUrl.get().equals(this.J0.video.playUrl.get())) {
                    QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "fs_lifecycle , same video, playUrl = " + this.J0.video.playUrl.get());
                    return true;
                }
            } catch (Exception e16) {
                QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "same video, exception = " + e16.getMessage());
            }
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void f2() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.B0;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.video.height.get() != 0 && this.B0.video.width.get() != 0 && this.I != null) {
            if (this.B0.cover.width.get() < this.B0.cover.height.get()) {
                QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "error cover url");
            }
            int c16 = com.tencent.biz.qqcircle.utils.cx.c(this.I.getContext());
            int b16 = (int) (com.tencent.biz.qqcircle.utils.cx.b(this.I.getContext()) * 1.77f);
            if (b16 < c16) {
                c16 = b16;
            }
            g2(this.B0, c16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void k2(final int i3) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFullScreenAdVideoPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                if (((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).I == null) {
                    return;
                }
                QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "change play status to = " + i3);
                if (i3 == 0) {
                    QFSFullScreenAdVideoPresenter qFSFullScreenAdVideoPresenter = QFSFullScreenAdVideoPresenter.this;
                    qFSFullScreenAdVideoPresenter.L4("bt", String.valueOf(qFSFullScreenAdVideoPresenter.F0));
                    QFSFullScreenAdVideoPresenter.this.y2();
                    ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).I.start();
                    QFSFullScreenAdVideoPresenter.this.T0(new com.tencent.biz.qqcircle.immersive.feed.event.ap(false));
                    return;
                }
                VideoReport.unbindVideoPlayerInfo(((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).I);
                ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).I.pause();
                QFSFullScreenAdVideoPresenter.this.T0(new com.tencent.biz.qqcircle.immersive.feed.event.ap(true));
                QFSFullScreenAdVideoPresenter.this.L4("ef", "0");
                QFSFullScreenAdVideoPresenter qFSFullScreenAdVideoPresenter2 = QFSFullScreenAdVideoPresenter.this;
                qFSFullScreenAdVideoPresenter2.H4(400, 5, qFSFullScreenAdVideoPresenter2.r(), "", "");
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
    protected void l2(final boolean z16) {
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "change view status to = " + z16);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFullScreenAdVideoPresenter.7
            @Override // java.lang.Runnable
            public void run() {
                if (((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).J == null) {
                    return;
                }
                if (z16) {
                    ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).J.setVisibility(8);
                } else {
                    ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFullScreenAdVideoPresenter.this).J.setVisibility(0);
                }
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "fs_lifecycle onDestroy: | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        this.J0 = null;
        this.K0 = 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        GdtAd gdtAd = this.C0;
        if (gdtAd != null && !TextUtils.isEmpty(gdtAd.getTraceId())) {
            v.c(this.C0.getTraceId());
            v.b(this.C0.getTraceId());
        }
        this.F0 = 0;
        D4();
        J4();
        cc0.e.d(System.currentTimeMillis(), rFWFeedSelectInfo.getPosition());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        this.J0 = null;
        this.K0 = 0;
        L4("ft", "3");
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null || qFSVideoView.getSuperPlayer() == null || this.I.getSuperPlayer().isPlaying()) {
            G4();
        }
        I4(C4(rFWFeedSelectInfo));
        H4(400, 3, r(), "", "");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "fs_lifecycle onPaused:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode());
        K4();
        G4();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        GdtAd gdtAd = this.C0;
        if (gdtAd != null && !TextUtils.isEmpty(gdtAd.getTraceId())) {
            v.c(this.C0.getTraceId());
        }
        if (this.I == null) {
            QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode() + "|playView is null");
            return;
        }
        if (rFWFeedSelectInfo == null) {
            return;
        }
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "fs_lifecycle onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "fs_lifecycle onStop:" + rFWFeedSelectInfo + " |  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        K4();
        L4("bf", "0");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "fs_lifecycle onViewHolderDetachedFromWindow: | mPos:" + this.f85018i + " | holder.pos:" + viewHolder.getAdapterPosition() + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.J0 = null;
        this.K0 = 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: s1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        int i16;
        if (B4(feedCloudMeta$StFeed, i3)) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        QLog.d("VFS-QFSFullScreenAdVideoPresenter", 1, "[onBindData] feed id: " + com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed) + " | position: " + i3);
        U0(ae.b(this.E.g(), i3));
        this.B0 = u.c(this.E);
        this.C0 = new GdtAd(u.e(this.E));
        this.I0 = this.B0.video.duration.get();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.C0.info;
        if (adInfo != null) {
            i16 = adInfo.report_info.thirdparty_monitor_urls.video_play_duration.get();
        } else {
            i16 = 0;
        }
        this.H0 = i16;
        this.E0 = this.C0.getVideoReportUrl();
    }

    /* loaded from: classes4.dex */
    class c implements IRFWPlayerSeekListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            QFSFullScreenAdVideoPresenter.this.L4(FileReaderHelper.ET_EXT, String.valueOf(i16));
            QFSFullScreenAdVideoPresenter qFSFullScreenAdVideoPresenter = QFSFullScreenAdVideoPresenter.this;
            qFSFullScreenAdVideoPresenter.G0 = (qFSFullScreenAdVideoPresenter.G0 + i16) - QFSFullScreenAdVideoPresenter.this.F0;
            QFSFullScreenAdVideoPresenter qFSFullScreenAdVideoPresenter2 = QFSFullScreenAdVideoPresenter.this;
            qFSFullScreenAdVideoPresenter2.L4("pt", String.valueOf(qFSFullScreenAdVideoPresenter2.G0));
            if (QFSFullScreenAdVideoPresenter.this.H0 != 0 && QFSFullScreenAdVideoPresenter.this.G0 >= QFSFullScreenAdVideoPresenter.this.H0 && QFSFullScreenAdVideoPresenter.this.H0 <= QFSFullScreenAdVideoPresenter.this.I0) {
                com.tencent.biz.qqcircle.immersive.utils.d.f90201a.i(QFSFullScreenAdVideoPresenter.this.C0);
            }
            QFSFullScreenAdVideoPresenter.this.F0 = i16;
            ((QFSFullScreenVideoPresenter) QFSFullScreenAdVideoPresenter.this).f85256k0 = i16;
            ((QFSFullScreenVideoPresenter) QFSFullScreenAdVideoPresenter.this).f85257l0 = i3;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }
}
