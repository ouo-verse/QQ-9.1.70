package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qqcircle.richframework.video.player.process.QFSPlayerOptionsExchangeUrlProcess;
import com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.RFWMediaFocusManager;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerRateChangListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSVideoView extends RFWVideoView implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    public static WeakReference<QFSVideoView> D;
    private static String E;
    private static String F;
    private static long G;
    private RFWMediaFocusManager C;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.widget.media.a f90475d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleReportBean f90476e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleProgressLoadingView f90477f;

    /* renamed from: h, reason: collision with root package name */
    private List<c> f90478h;

    /* renamed from: i, reason: collision with root package name */
    private int f90479i;

    /* renamed from: m, reason: collision with root package name */
    private int f90480m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements IRFWPlayerSeekListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e40.m f90485d;

        a(e40.m mVar) {
            this.f90485d = mVar;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onProgress(String str, int i3, int i16) {
            re0.b.a(this, str, i3, i16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            re0.b.b(this, seekBar, i3, z16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            QLog.d(QFSVideoView.this.getLogTag(), 1, "CommonListener onStartTrackingTouch:" + seekBar.getProgress());
            this.f90485d.c(seekBar);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            QLog.d(QFSVideoView.this.getLogTag(), 1, "CommonListener onStopTrackingTouch:" + seekBar.getProgress());
            this.f90485d.d(seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayerRateChangListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e40.i f90487a;

        b(e40.i iVar) {
            this.f90487a = iVar;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerRateChangListener
        public void onPlayerRateChanged(float f16, long j3, RFWPlayer rFWPlayer) {
            QLog.d(QFSVideoView.this.getLogTag(), 1, "CommonListener onPlayerRateChanged:" + f16 + APLogFileUtil.SEPARATOR_LOG + j3);
            this.f90487a.c(f16, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void L(boolean z16);
    }

    public QFSVideoView(@NonNull Context context) {
        this(context, null);
    }

    private void F0(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions.getSceneId() != 126) {
            return;
        }
        final e40.m mVar = new e40.m();
        final e40.i iVar = new e40.i();
        rFWPlayerOptions.getListenerSet().addSeekListeners(new a(mVar));
        rFWPlayerOptions.getListenerSet().addRateChangeListener(new b(iVar));
        rFWPlayerOptions.getListenerSet().addLifeCycleListeners(new IRFWPlayerLifeCycle() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSVideoView.3
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* synthetic */ void onDeInit(RFWPlayer rFWPlayer) {
                re0.a.a(this, rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* synthetic */ void onPause(RFWPlayer rFWPlayer) {
                re0.a.b(this, rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public void onRelease(RFWPlayer rFWPlayer) {
                boolean b16 = mVar.b();
                String a16 = mVar.a();
                if (b16) {
                    QFSVideoView.this.T0(a16);
                }
                boolean b17 = iVar.b();
                String a17 = iVar.a(QFSVideoView.this.H0());
                if (b17) {
                    QFSVideoView.this.S0(a17);
                }
                QLog.d(QFSVideoView.this.getLogTag(), 1, " CommonListener onRelease:" + b16 + APLogFileUtil.SEPARATOR_LOG + a16 + APLogFileUtil.SEPARATOR_LOG + b17 + APLogFileUtil.SEPARATOR_LOG + a17);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public void onStart(RFWPlayer rFWPlayer) {
                QLog.d(QFSVideoView.this.getLogTag(), 1, " CommonListener onStart set loading status false");
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSVideoView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSVideoView.this.setLoadingViewStatus(false);
                    }
                });
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* synthetic */ void onStop(RFWPlayer rFWPlayer) {
                re0.a.e(this, rFWPlayer);
            }
        });
    }

    public static long K0() {
        return G;
    }

    public static String L0() {
        return E;
    }

    private void O0(QCircleLpReportDc05507.DataBuilder dataBuilder) {
        float f16;
        boolean z16;
        long H0 = H0();
        long J0 = J0();
        if (J0 != 0) {
            f16 = Math.min(((float) H0) / ((float) J0), 1.0f);
        } else {
            f16 = 0.0f;
        }
        if (f16 >= 0.99d) {
            z16 = true;
        } else {
            z16 = false;
        }
        dataBuilder.setExt5(String.valueOf(z16)).setExt6(String.valueOf(f16));
    }

    private void P0(RFWPlayerOptions rFWPlayerOptions) {
        boolean b16 = com.tencent.a.b(String.valueOf(getContext().hashCode()));
        com.tencent.a.c(String.valueOf(getContext().hashCode()));
        rFWPlayerOptions.setIsFirstPlayer(b16);
        com.tencent.biz.qqcircle.immersive.report.b.f().v(rFWPlayerOptions.getFileId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(String str) {
        FeedCloudMeta$StFeed data = getData();
        if (data != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(data));
            dataBuilder.setActionType(2).setSubActionType(12).setToUin(data.poster.f398463id.get()).setPosition(this.f90479i).setPlayScene(this.f90480m).setIsAutoPlay(true).setErrorCode("").setExt4("1").setExt6(str).setPageId(getPageId()).setfpageid(getParentPageId());
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(String str) {
        FeedCloudMeta$StFeed data = getData();
        if (data != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(data));
            dataBuilder.setActionType(2).setSubActionType(11).setToUin(data.poster.f398463id.get()).setPosition(this.f90479i).setPlayScene(this.f90480m).setIsAutoPlay(true).setErrorCode("").setExt4("1").setExt6(str).setPageId(getPageId()).setfpageid(getParentPageId());
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    private void W0(boolean z16) {
        if (this.f90477f == null) {
            QLog.e("BaseVideoView", 1, "[showLoadingViewStatus] loading view should not be null.");
            return;
        }
        QLog.d("BaseVideoView", 1, "[setLoadingViewStatus] isShowLoadingAnim: " + z16 + APLogFileUtil.SEPARATOR_LOG + getPlayOptionUrl());
        if (z16) {
            this.f90477f.q0();
        } else {
            this.f90477f.p0();
        }
        List<c> list = this.f90478h;
        if (list != null && list.size() > 0) {
            for (c cVar : this.f90478h) {
                if (cVar != null) {
                    cVar.L(z16);
                }
            }
        }
    }

    public void G0(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f90478h == null) {
            this.f90478h = new ArrayList();
        }
        this.f90478h.add(cVar);
    }

    public long H0() {
        if (getSuperPlayer() != null) {
            return getSuperPlayer().getCurrentPositionMs();
        }
        return 0L;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public FeedCloudMeta$StFeed getData() {
        Object data = super.getData();
        if (data instanceof FeedCloudMeta$StFeed) {
            return (FeedCloudMeta$StFeed) data;
        }
        return null;
    }

    public long J0() {
        if (getSuperPlayer() != null) {
            return getSuperPlayer().getDurationMs();
        }
        return 0L;
    }

    public String M0() {
        RFWPlayerOptions rFWPlayerOptions = this.mPlayOptions;
        if (rFWPlayerOptions != null) {
            return rFWPlayerOptions.tag();
        }
        return "";
    }

    public String N0() {
        FeedCloudMeta$StFeed data = getData();
        if (data != null && data.type.get() == 3) {
            return data.video.playUrl.get();
        }
        return null;
    }

    public void Q0(Object obj) {
        if (obj instanceof FeedCloudMeta$StFeed) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) obj;
            E = feedCloudMeta$StFeed.f398449id.get();
            F = feedCloudMeta$StFeed.poster.f398463id.get();
            G = feedCloudMeta$StFeed.yuhengContentInfos.content_id.get();
        }
    }

    public void U0() {
        RFWMediaFocusManager rFWMediaFocusManager = this.C;
        if (rFWMediaFocusManager == null) {
            QLog.e(getLogTag(), 1, "[requestMediaFocus] mMediaFocusManager == null.");
        } else {
            rFWMediaFocusManager.requestMediaFocus();
        }
    }

    public void V0() {
        RFWMediaFocusManager rFWMediaFocusManager = this.C;
        if (rFWMediaFocusManager == null) {
            QLog.d(getLogTag(), 1, "[requestMediaUnFocus] mMediaFocusManager == null.");
        } else {
            rFWMediaFocusManager.requestMediaUnFocus();
        }
    }

    public void X0(String str) {
        RFWMediaFocusManager rFWMediaFocusManager = this.C;
        if (rFWMediaFocusManager == null) {
            QLog.d(getLogTag(), 1, "[updateFocusBusinessName] mMediaFocusManager == null.");
        } else {
            rFWMediaFocusManager.updateFocusBusinessName(str);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(Object obj, int i3) {
        super.bindData(obj, i3);
        this.f90479i = i3;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected void firstFrameRenderCallBack() {
        super.firstFrameRenderCallBack();
        W0(false);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected String getAddSceneProcessKey() {
        return com.tencent.biz.qqcircle.richframework.video.player.process.a.f92042a;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected String getExchangeUrlProcessKey() {
        return QFSPlayerOptionsExchangeUrlProcess.f92033a;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    public int getPageId() {
        return QCircleReportBean.getPageId(getLogTag(), this.f90476e);
    }

    protected int getParentPageId() {
        return QCircleReportBean.getParentPageId(getLogTag(), this.f90476e);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public com.tencent.widget.media.a getProgressBar() {
        return this.f90475d;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected boolean isNeedSeekWhenDragging() {
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void loadPlayOptions(RFWPlayerOptions rFWPlayerOptions) {
        P0(rFWPlayerOptions);
        setLoadingViewStatus(true);
        F0(rFWPlayerOptions);
        super.loadPlayOptions(rFWPlayerOptions);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RFWLog.d(getLogTag(), RFWLog.CLR, NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView, com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RFWLog.d(getLogTag(), RFWLog.CLR, NodeProps.ON_DETACHED_FROM_WINDOW);
        W0(false);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected void onLifecycleRelease(RFWPlayer rFWPlayer) {
        Object valueOf;
        super.onLifecycleRelease(rFWPlayer);
        V0();
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onLifecycleRelease] view hash: ");
        sb5.append(hashCode());
        sb5.append(" | media hash code: ");
        RFWMediaFocusManager rFWMediaFocusManager = this.C;
        if (rFWMediaFocusManager == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(rFWMediaFocusManager.hashCode());
        }
        sb5.append(valueOf);
        QLog.d(logTag, 1, sb5.toString());
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void onSecondBufferEnd() {
        super.onSecondBufferEnd();
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                QFSVideoView.this.setLoadingViewStatus(false);
                QLog.d(QFSVideoView.this.getLogTag(), 1, "onSecondBufferEnd hide loading");
            }
        });
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void onSecondBufferStart() {
        super.onSecondBufferStart();
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                QFSVideoView.this.setLoadingViewStatus(true);
                QLog.d(QFSVideoView.this.getLogTag(), 1, "onSecondBufferStart show loading");
            }
        });
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void pause() {
        Object valueOf;
        super.pause();
        V0();
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[pause] view hash: ");
        sb5.append(hashCode());
        sb5.append(" | media hash code: ");
        RFWMediaFocusManager rFWMediaFocusManager = this.C;
        if (rFWMediaFocusManager == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(rFWMediaFocusManager.hashCode());
        }
        sb5.append(valueOf);
        QLog.d(logTag, 1, sb5.toString());
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected void receiveVideoPrepared() {
        String fileId;
        super.receiveVideoPrepared();
        com.tencent.biz.qqcircle.immersive.report.b f16 = com.tencent.biz.qqcircle.immersive.report.b.f();
        RFWPlayerOptions rFWPlayerOptions = this.mPlayOptions;
        if (rFWPlayerOptions == null) {
            fileId = "";
        } else {
            fileId = rFWPlayerOptions.getFileId();
        }
        f16.o(fileId);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        Object valueOf;
        super.release();
        setLoadingViewStatus(false);
        V0();
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[release] view hash: ");
        sb5.append(hashCode());
        sb5.append(" | media hash code: ");
        RFWMediaFocusManager rFWMediaFocusManager = this.C;
        if (rFWMediaFocusManager == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(rFWMediaFocusManager.hashCode());
        }
        sb5.append(valueOf);
        QLog.d(logTag, 1, sb5.toString());
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected void replaceCallBack(RFWPlayerOptions rFWPlayerOptions) {
        super.replaceCallBack(rFWPlayerOptions);
        FeedCloudMeta$StFeed data = getData();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_ad_video_reuse_options_set_start_offset", true) && data != null && com.tencent.biz.qqcircle.immersive.adapter.n.e(data) == 4003) {
            rFWPlayerOptions.setStartOffset(this.mPlayOptions.getStartOffset());
            rFWPlayerOptions.setOffSetBySeek(true);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void reportVideoPassivePause(int i3, int i16, long j3, long j16, long j17) {
        String str;
        FeedCloudMeta$StFeed data = getData();
        if (data != null) {
            if (i3 == 0 && i16 == 0) {
                str = "";
            } else {
                str = i16 + ":" + i3;
            }
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(data));
            dataBuilder.setActionType(2).setSubActionType(7).setToUin(data.poster.f398463id.get()).setPosition(this.f90479i).setPlayScene(this.f90480m).setVideoPlayTime(j3).setVideoSoloTime(j16).setIsAutoPlay(true).setErrorCode(str).setExt4("1").setExt9(String.valueOf(j17)).setExt10(ua0.c.f(getContext())).setPageId(getPageId()).setfpageid(getParentPageId()).setFirstFeedId(w20.a.j().h());
            O0(dataBuilder);
            QCircleLpReportDc05507.report(dataBuilder);
            RFWLog.d(getLogTag(), RFWLog.USR, "reportVideoPassivePause2-7:| videoPlayTime:" + j3 + "| videoSoloTime:" + j16 + "| rate:" + dataBuilder.getExt6() + "| playTimeBaseVideoPos:" + j17 + "| firstFeedId:" + dataBuilder.getFirstFeedId() + "| publicAccountCurrentRedDotFeedId:" + dataBuilder.getExt11());
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    @RFWTestEvent(id = "VIDEO_START_PLAY_EVENT")
    protected void reportVideoStartPlay() {
        FeedCloudMeta$StFeed data = getData();
        if (data != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(data));
            dataBuilder.setActionType(2).setSubActionType(4).setToUin(data.poster.f398463id.get()).setPosition(this.f90479i).setPlayScene(this.f90480m).setVideoPlayTime(0L).setVideoSoloTime(0L).setIsAutoPlay(true).setErrorCode("").setExt4("1").setPageId(getPageId()).setfpageid(getParentPageId());
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setData(Object obj, int i3) {
        super.setData(obj, i3);
    }

    public void setLoadingView(View view) {
        if (view != null) {
            this.f90477f.setLoadingView(view);
        }
    }

    public void setLoadingViewStatus(boolean z16) {
        if (z16) {
            W0(true);
            if (getProgressBar() != null) {
                getProgressBar().d().setVisibility(8);
                return;
            }
            return;
        }
        W0(false);
        if (getProgressBar() != null) {
            getProgressBar().d().setVisibility(0);
        }
    }

    public void setPlayScene(int i3) {
        this.f90480m = i3;
    }

    public void setProgressBar(com.tencent.widget.media.a aVar) {
        this.f90475d = aVar;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void start() {
        Object valueOf;
        super.start();
        U0();
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[start] view hash: ");
        sb5.append(hashCode());
        sb5.append(" | media hash code: ");
        RFWMediaFocusManager rFWMediaFocusManager = this.C;
        if (rFWMediaFocusManager == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(rFWMediaFocusManager.hashCode());
        }
        sb5.append(valueOf);
        QLog.d(logTag, 1, sb5.toString());
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void stop() {
        Object valueOf;
        super.stop();
        setLoadingViewStatus(false);
        V0();
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[stop] view hash: ");
        sb5.append(hashCode());
        sb5.append(" | media hash code: ");
        RFWMediaFocusManager rFWMediaFocusManager = this.C;
        if (rFWMediaFocusManager == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(rFWMediaFocusManager.hashCode());
        }
        sb5.append(valueOf);
        QLog.d(logTag, 1, sb5.toString());
    }

    public QFSVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        return QCircleReportBean.getReportBean(getLogTag(), this.f90476e);
    }

    public void setLoadingView(View view, int i3) {
        if (view != null) {
            this.f90477f.setLoadingView(view);
            this.f90477f.setScreenOrientation(i3);
        }
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.f90476e = QCircleReportBean.setReportBean(getLogTag(), qCircleReportBean);
    }

    public QFSVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90480m = 2;
        this.f90477f = new QCircleProgressLoadingView(context);
        this.C = RFWMediaFocusManager.createMediaFocusManager(Constants.Business.QQCIRCLE);
    }
}
