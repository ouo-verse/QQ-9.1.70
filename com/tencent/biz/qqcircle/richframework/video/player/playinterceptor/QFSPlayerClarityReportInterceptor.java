package com.tencent.biz.qqcircle.richframework.video.player.playinterceptor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerFrameDropInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerSPRInterceptor;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.superplayer.player.MediaInfo;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Arrays;
import java.util.List;
import lb0.b;

/* loaded from: classes5.dex */
public class QFSPlayerClarityReportInterceptor extends RFWPlayerBaseInterceptor {

    /* renamed from: d, reason: collision with root package name */
    private static String f92013d = "qcircle_player_use_system_player";

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f92014e = new a();

    /* loaded from: classes5.dex */
    class a extends ThreadLocal<StringBuilder> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    }

    private void b(b.a aVar, long j3) {
        float computeCacheTimeS = RFWVideoUtils.computeCacheTimeS(this.mPlayerOptions.getSceneId(), this.mPlayerOptions.getRealPlayUrl(), this.mPlayerOptions.getFileId(), aVar.f414275e.mRate);
        aVar.y(computeCacheTimeS).z(RFWVideoUtils.computeCacheTimeS(this.mPlayerOptions.getSceneId(), this.mPlayerOptions.getRealPlayUrl(), this.mPlayerOptions.getFileId(), (int) j3));
    }

    private static String c(RFWVideoUrlBean rFWVideoUrlBean, List<RFWVideoUrlBean> list) {
        StringBuilder sb5 = f92014e.get();
        sb5.setLength(0);
        sb5.append("cid=");
        sb5.append(rFWVideoUrlBean.mFormatId);
        sb5.append("cw=");
        sb5.append(rFWVideoUrlBean.mShortSide);
        sb5.append("ch=");
        sb5.append(rFWVideoUrlBean.mLongSide);
        for (RFWVideoUrlBean rFWVideoUrlBean2 : list) {
            sb5.append("id=");
            sb5.append(rFWVideoUrlBean2.mFormatId);
            sb5.append("type=");
            sb5.append(rFWVideoUrlBean2.mLevelType);
            sb5.append("encode=");
            sb5.append(rFWVideoUrlBean2.mVideoEncode);
            sb5.append("w=");
            sb5.append(rFWVideoUrlBean2.mShortSide);
            sb5.append("h=");
            sb5.append(rFWVideoUrlBean2.mLongSide);
            sb5.append("score=");
            sb5.append(rFWVideoUrlBean2.mScore);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(RFWStVideo rFWStVideo, FeedCloudMeta$StFeed feedCloudMeta$StFeed, long j3) {
        RFWVideoUrlBean serverPlayBean = this.mPlayerOptions.getServerPlayBean();
        List<RFWVideoUrlBean> vecUrlBean = this.mPlayerOptions.getVecUrlBean();
        RFWVideoUrlBean f16 = f(vecUrlBean);
        RFWVideoUrlBean realPlayBean = this.mPlayerOptions.getRealPlayBean();
        if (realPlayBean != null && serverPlayBean != null) {
            b.a aVar = new b.a(String.valueOf(this.mPlayer.getVideoPlayId()));
            aVar.E(feedCloudMeta$StFeed.f398449id.get(), feedCloudMeta$StFeed.poster.f398463id.get()).c0(rFWStVideo.getFileId()).P(feedCloudMeta$StFeed.poster).e0(feedCloudMeta$StFeed.sourceType.get()).S(realPlayBean.mFormatId).N(realPlayBean.mShortSide, realPlayBean.mLongSide).R(realPlayBean.mHost).U(realPlayBean.mVideoEncode).T(realPlayBean.mResolutionLevel).d0(String.valueOf(rFWStVideo.getMediaQualityScore())).X(serverPlayBean.mFormatId).W(serverPlayBean.mRate).L(this.mIsSystemPlayer).F(((RFWPlayerSPRInterceptor) getTargetInterceptor(RFWPlayerSPRInterceptor.class)).hasOpenSpr());
            if (f16 != null) {
                aVar.a0(f16.mResolutionLevel).Z(f16.mRate).D(f16.mVideoEncode).b0(f16.mShortSide, f16.mLongSide).Y(f16.mHost);
            }
            aVar.x(c(serverPlayBean, vecUrlBean));
            aVar.B(String.valueOf(serverPlayBean.mShortSide));
            aVar.K(g(f16, serverPlayBean));
            aVar.H(g(serverPlayBean, realPlayBean));
            aVar.Q(this.mPlayerOptions.getPredictSpeed());
            aVar.M(this.mPlayerOptions.tag());
            aVar.w(e(this.mPlayerOptions));
            aVar.V(this.mPlayerOptions.hitSelectUrlCache());
            aVar.G(this.mPlayerOptions.hitPreloadCache());
            aVar.J(this.mPlayerOptions.isPreloadPlayer());
            aVar.I(this.mPlayerOptions.isPlayerByDirectIP());
            aVar.A(((RFWPlayerFrameDropInterceptor) getTargetInterceptor(RFWPlayerFrameDropInterceptor.class)).getDecodeType());
            MediaInfo mediaInfo = this.mPlayer.getRealPlayer().getMediaInfo();
            if (mediaInfo != null) {
                aVar.O(mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight());
            }
            aVar.C(f16, realPlayBean);
            b(aVar, j3);
            if (n.e(feedCloudMeta$StFeed) == 1003) {
                aVar.v();
            }
            i(aVar);
            RFWLog.d(getTag(), RFWLog.USR, "debugInfo:" + aVar.f0());
            return;
        }
        RFWLog.w("QFSPlayerClarityReportInterceptor", RFWLog.USR, "getRealPlayVideoUrlBean error");
    }

    private String e(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (rFWPlayerOptions.getServerPlayBean().mVideoEncode == 4) {
            sb5.append("\u540e\u53f0\u9ed8\u8ba4\uff1a");
            sb5.append(rFWPlayerOptions.getServerPlayBean());
        }
        for (RFWVideoUrlBean rFWVideoUrlBean : rFWPlayerOptions.getVecUrlBean()) {
            if (rFWVideoUrlBean.mVideoEncode == 4 && rFWVideoUrlBean.mFormatId != rFWPlayerOptions.getServerPlayBean().mFormatId) {
                sb5.append("\u5907\u9009\uff1a");
                sb5.append(rFWVideoUrlBean);
            }
        }
        RFWLog.d(getTag(), RFWLog.USR, "AV1Info:" + ((Object) sb5));
        return sb5.toString();
    }

    private static RFWVideoUrlBean f(List<RFWVideoUrlBean> list) {
        for (RFWVideoUrlBean rFWVideoUrlBean : list) {
            if (rFWVideoUrlBean.mFormatId == 0) {
                return rFWVideoUrlBean;
            }
        }
        return null;
    }

    private static boolean g(RFWVideoUrlBean rFWVideoUrlBean, RFWVideoUrlBean rFWVideoUrlBean2) {
        if (rFWVideoUrlBean == null || rFWVideoUrlBean2 == null || rFWVideoUrlBean2.mPlayLevel >= rFWVideoUrlBean.mPlayLevel) {
            return false;
        }
        return true;
    }

    private void h(int i3) {
        QCircleQualityReporter.reportQualityEvent(f92013d, Arrays.asList(QCircleReportHelper.newEntry("ret_code", String.valueOf(i3))), false);
    }

    private void i(b.a aVar) {
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_CLARITY_INFO, 0)) {
            w20.a.j().initOrUpdateGlobalState((w20.a) aVar, true);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onInfo(int i3, long j3, long j16, Object obj) {
        super.onInfo(i3, j3, j16, obj);
        if (124 == i3) {
            if (j3 == 1) {
                h(1);
                RFWLog.d(getTag(), RFWLog.USR, "onInfo: use system player");
            } else {
                h(2);
                RFWLog.d(getTag(), RFWLog.USR, "onInfo: use super player");
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        RFWPlayerReportInfo businessReportInfo;
        final FeedCloudMeta$StFeed g16;
        final long j3;
        if (this.mPlayerOptions.isLocalVideo() || !this.mPlayerOptions.isVideo() || !this.mPlayer.enableReport() || TextUtils.isEmpty(this.mPlayerOptions.getRealPlayUrl()) || this.mPlayerOptions.getIOC() == null || !this.mPlayerOptions.getIOC().isValid() || (businessReportInfo = this.mPlayerOptions.getIOC().getBusinessReportInfo()) == null || (g16 = ((e30.b) businessReportInfo.getOriginBusinessData()).g()) == null) {
            return;
        }
        final RFWStVideo stVideo = this.mPlayerOptions.getStVideo();
        if (this.mPlayer.getRealPlayer().getMediaInfo() != null) {
            long audioBitRate = this.mPlayer.getRealPlayer().getMediaInfo().getAudioBitRate();
            long videoBitRate = this.mPlayer.getRealPlayer().getMediaInfo().getVideoBitRate();
            long j16 = ((float) (audioBitRate + videoBitRate)) / 1024.0f;
            RFWLog.d(getTag(), RFWLog.USR, " audioRate:" + audioBitRate + " videoRate:" + videoBitRate + " totalRate:" + j16 + " serviceRate:" + this.mPlayerOptions.getRealPlayBean().mRate);
            j3 = j16;
        } else {
            j3 = 0;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.QFSPlayerClarityReportInterceptor.2
            @Override // java.lang.Runnable
            public void run() {
                QFSPlayerClarityReportInterceptor.this.d(stVideo, g16, j3);
            }
        });
    }
}
