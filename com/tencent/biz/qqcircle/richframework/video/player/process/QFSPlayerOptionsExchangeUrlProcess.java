package com.tencent.biz.qqcircle.richframework.video.player.process;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.requests.QCircleVideoUrlAdapterRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoReporter;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StVideo;
import gb0.b;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import qqcircle.QQCircleVideourlexchange$StGetVideoAdaptRsp;
import uq3.o;

/* loaded from: classes5.dex */
public class QFSPlayerOptionsExchangeUrlProcess implements IRFWPlayerOptionsProcess {

    /* renamed from: a, reason: collision with root package name */
    public static String f92033a = "QFS_BUSINESS_PROCESS_URL_EXCHANGE";

    /* renamed from: b, reason: collision with root package name */
    public static String f92034b = "QFS_BUSINESS_PROCESS_URL_EXCHANGE_ERROR";

    /* renamed from: c, reason: collision with root package name */
    private static final LruCache<String, FeedCloudMeta$StVideo> f92035c = new LruCache<>(100);

    /* loaded from: classes5.dex */
    private class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleVideourlexchange$StGetVideoAdaptRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSPlayerOptionsExchangeUrlProcess> f92038a;

        /* renamed from: b, reason: collision with root package name */
        private final RFWPlayerOptions f92039b;

        /* renamed from: c, reason: collision with root package name */
        private final RFWPlayerOptionsProcessManager.IProcessCallBack f92040c;

        public a(@NonNull QFSPlayerOptionsExchangeUrlProcess qFSPlayerOptionsExchangeUrlProcess, @NonNull RFWPlayerOptions rFWPlayerOptions, @NonNull RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
            this.f92038a = new WeakReference<>(qFSPlayerOptionsExchangeUrlProcess);
            this.f92039b = rFWPlayerOptions;
            this.f92040c = iProcessCallBack;
        }

        private void a(FeedCloudMeta$StVideo feedCloudMeta$StVideo, long j3, String str) {
            boolean z16;
            RFWLog.e(QFSPlayerOptionsExchangeUrlProcess.this.f(this.f92039b), RFWLog.USR, "notifyChangeFail() |retCode:" + j3 + "|errMsg:" + str);
            RFWPlayerListenerDispatchUtils.notifyOptionsCallback(QFSPlayerOptionsExchangeUrlProcess.f92034b, this.f92039b, true);
            if (feedCloudMeta$StVideo != null) {
                if (!feedCloudMeta$StVideo.is_delete.get() && !feedCloudMeta$StVideo.is_block.get()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    RFWLog.e(QFSPlayerOptionsExchangeUrlProcess.this.f(this.f92039b), RFWLog.USR, "notifyChangeFail() is_delete:" + feedCloudMeta$StVideo.is_delete.get() + ",is_block" + feedCloudMeta$StVideo.is_block.get());
                }
                this.f92039b.setVideoIsDelete(z16);
            }
            this.f92039b.setExchangedUrlErrorCode(j3);
            RFWPlayerOptions rFWPlayerOptions = this.f92039b;
            rFWPlayerOptions.setRealPlayUrl(rFWPlayerOptions.getPlayUrl());
            this.f92040c.onFinish(this.f92039b, true);
        }

        private void b(FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
            if (feedCloudMeta$StVideo == null) {
                RFWLog.e(QFSPlayerOptionsExchangeUrlProcess.this.f(this.f92039b), RFWLog.USR, "notifyChangeSuccess()| video should not be null.");
                RFWPlayerOptions rFWPlayerOptions = this.f92039b;
                rFWPlayerOptions.setRealPlayUrl(rFWPlayerOptions.getPlayUrl());
                this.f92040c.onFinish(this.f92039b, true);
                return;
            }
            RFWLog.d(QFSPlayerOptionsExchangeUrlProcess.this.f(this.f92039b), RFWLog.USR, "notifyChangeSuccess()|success fileId:", feedCloudMeta$StVideo.fileId.get(), ",videoExchange url :", feedCloudMeta$StVideo.playUrl.get());
            d(feedCloudMeta$StVideo);
        }

        private void d(FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
            QFSPlayerOptionsExchangeUrlProcess qFSPlayerOptionsExchangeUrlProcess = this.f92038a.get();
            if (qFSPlayerOptionsExchangeUrlProcess == null) {
                RFWLog.e(QFSPlayerOptionsExchangeUrlProcess.this.f(this.f92039b), RFWLog.USR, "[updateExchangeVideoInfo]process should not be null.");
            } else {
                qFSPlayerOptionsExchangeUrlProcess.g(this.f92039b, feedCloudMeta$StVideo);
                qFSPlayerOptionsExchangeUrlProcess.j(this.f92039b, this.f92040c, feedCloudMeta$StVideo);
            }
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleVideourlexchange$StGetVideoAdaptRsp qQCircleVideourlexchange$StGetVideoAdaptRsp) {
            if (z16 && j3 == 0 && qQCircleVideourlexchange$StGetVideoAdaptRsp.videos.size() > 0) {
                FeedCloudMeta$StVideo feedCloudMeta$StVideo = qQCircleVideourlexchange$StGetVideoAdaptRsp.videos.get(0);
                feedCloudMeta$StVideo.fileId.set(this.f92039b.getStVideo().getFileId());
                if (feedCloudMeta$StVideo.playUrl.get().trim().length() > 0) {
                    b(feedCloudMeta$StVideo);
                } else {
                    a(feedCloudMeta$StVideo, j3, str);
                }
            } else {
                a(null, j3, str);
            }
            QFSPlayerOptionsExchangeUrlProcess.this.h(this.f92039b);
        }
    }

    private void c(final RFWPlayerOptions rFWPlayerOptions, final RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.video.player.process.QFSPlayerOptionsExchangeUrlProcess.1
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StVideo l3;
                RFWStVideo stVideo = rFWPlayerOptions.getStVideo();
                if (o.P1()) {
                    l3 = new FeedCloudMeta$StVideo();
                    l3.playUrl.set(rFWPlayerOptions.getPlayUrl());
                    l3.width.set(stVideo.getWidth());
                    l3.height.set(stVideo.getHeight());
                    l3.duration.set(stVideo.getDuration());
                } else {
                    l3 = b.l(rFWPlayerOptions.getStVideo());
                }
                QCircleVideoUrlAdapterRequest qCircleVideoUrlAdapterRequest = new QCircleVideoUrlAdapterRequest(l3);
                qCircleVideoUrlAdapterRequest.setEnableCache(false);
                VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
                QFSPlayerOptionsExchangeUrlProcess qFSPlayerOptionsExchangeUrlProcess = QFSPlayerOptionsExchangeUrlProcess.this;
                vSNetworkHelper.sendRequest(qCircleVideoUrlAdapterRequest, new a(qFSPlayerOptionsExchangeUrlProcess, rFWPlayerOptions, iProcessCallBack));
            }
        });
    }

    private void d(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        FeedCloudMeta$StVideo l3 = b.l(rFWPlayerOptions.getStVideo());
        if (l3 != null && !TextUtils.isEmpty(l3.playUrl.get())) {
            FeedCloudMeta$StVideo feedCloudMeta$StVideo = f92035c.get(l3.fileId.get());
            if (feedCloudMeta$StVideo != null && feedCloudMeta$StVideo.playUrl.get().trim().length() > 0) {
                if (!RFWVideoUtils.checkVideoUrlIsNeedChange(feedCloudMeta$StVideo.playUrl.get())) {
                    RFWLog.d(f(rFWPlayerOptions), RFWLog.USR, "exchangeVideoUrl()|  success hit Cache fileId:" + feedCloudMeta$StVideo.fileId.get() + "|videoExchange url :" + feedCloudMeta$StVideo.playUrl.get());
                    j(rFWPlayerOptions, iProcessCallBack, feedCloudMeta$StVideo);
                    return;
                }
                RFWLog.d(f(rFWPlayerOptions), RFWLog.USR, "exchangeVideoUrl()| hit cache but not valid");
                c(rFWPlayerOptions, iProcessCallBack);
                return;
            }
            c(rFWPlayerOptions, iProcessCallBack);
            return;
        }
        RFWLog.d(f(rFWPlayerOptions), RFWLog.USR, "exchangeVideoUrl()| stVideo is empty,exchangeVideoUrl failed");
        iProcessCallBack.onFinish(rFWPlayerOptions, true);
    }

    private RFWPlayerReportInfo e(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions.getIOC() == null && rFWPlayerOptions.getIOC().getBusinessReportInfo() != null) {
            return rFWPlayerOptions.getIOC().getBusinessReportInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions.isHasExchangeUrl() && !rFWPlayerOptions.getPlayUrl().equals(rFWPlayerOptions.getExchangedUrl())) {
            i(-1L, "video_exchange_url", e(rFWPlayerOptions), Collections.singletonList(QCircleReportHelper.newEntry("ret_code", "0")));
        } else {
            i(-1L, "video_exchange_url", e(rFWPlayerOptions), Collections.singletonList(QCircleReportHelper.newEntry("ret_code", String.valueOf(rFWPlayerOptions.getExchangedUrlErrorCode()))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack, FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
        rFWPlayerOptions.setHasExchangeUrl(true);
        rFWPlayerOptions.setExchangedUrl(feedCloudMeta$StVideo.playUrl.get());
        rFWPlayerOptions.setStVideo(b.k(feedCloudMeta$StVideo));
        rFWPlayerOptions.setRealPlayUrl(feedCloudMeta$StVideo.playUrl.get());
        iProcessCallBack.onFinish(rFWPlayerOptions, true);
    }

    public /* synthetic */ String f(RFWPlayerOptions rFWPlayerOptions) {
        return com.tencent.biz.richframework.video.rfw.player.optionsprocess.a.a(this, rFWPlayerOptions);
    }

    protected void g(@NonNull RFWPlayerOptions rFWPlayerOptions, FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
        if (TextUtils.isEmpty(rFWPlayerOptions.getFileId())) {
            RFWLog.e(f(rFWPlayerOptions), RFWLog.USR, "putUrlToCacheMap()| feed id should not be null.");
        } else if (feedCloudMeta$StVideo == null) {
            RFWLog.e(f(rFWPlayerOptions), RFWLog.USR, "putUrlToCacheMap()|  video exchange url not be null.");
        } else {
            f92035c.put(rFWPlayerOptions.getFileId(), feedCloudMeta$StVideo);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public String getProcessKey() {
        return f92033a;
    }

    protected void i(long j3, String str, RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        RFWVideoReporter.getInstance().report(j3, str, rFWPlayerReportInfo, list);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public void onProcess(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (rFWPlayerOptions != null && iProcessCallBack != null) {
            if (rFWPlayerOptions.needExChangeUrl()) {
                RFWLog.d(f(rFWPlayerOptions), RFWLog.USR, "exchangeVideoUrl()| exchange url necessary from net");
                c(rFWPlayerOptions, iProcessCallBack);
            } else {
                if (!RFWVideoUtils.checkVideoUrlIsNeedChange(rFWPlayerOptions.getPlayUrl())) {
                    RFWLog.d(f(rFWPlayerOptions), RFWLog.USR, "should not exchange url");
                    rFWPlayerOptions.setRealPlayUrl(rFWPlayerOptions.getPlayUrl());
                    rFWPlayerOptions.setExchangedUrl(rFWPlayerOptions.getPlayUrl());
                    rFWPlayerOptions.setHasExchangeUrl(true);
                    iProcessCallBack.onFinish(rFWPlayerOptions, true);
                    return;
                }
                d(rFWPlayerOptions, iProcessCallBack);
            }
        }
    }
}
