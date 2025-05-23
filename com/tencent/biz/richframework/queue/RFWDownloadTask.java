package com.tencent.biz.richframework.queue;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloadTask {
    private long mDownloadedLength;
    private HashMap<String, String> mExtMap;
    private String mFilePath;
    private final Handler mHandler;
    private float mPercent;
    private final RFWDownloadStateProgressBox mStateProgressBox;
    private final RFWDownloadQueueStrategy mStrategy;
    private long mTotalLength;
    private final String mUrl;
    private DownloadState mState = DownloadState.STATE_WAITING;
    private final long mTaskGenerateTime = System.currentTimeMillis();

    public RFWDownloadTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, String str, Handler handler, RFWDownloadStateProgressBox rFWDownloadStateProgressBox) {
        this.mHandler = handler;
        this.mStateProgressBox = rFWDownloadStateProgressBox;
        this.mUrl = str;
        this.mStrategy = rFWDownloadQueueStrategy;
    }

    private void handleDownloadFinalResult() {
        RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
        if (rFWDownloadStateProgressBox != null) {
            rFWDownloadStateProgressBox.updateTaskEntry(this);
        }
        sendMsgTriggerNestTaskRun(this.mStrategy);
        sendMsgTriggerClearCurrentTask();
    }

    private void handleInsertMediaResult(final Boolean bool) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.queue.n
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadTask.this.lambda$handleInsertMediaResult$2(bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleInsertMediaResult$2(Boolean bool) {
        RFWLog.i("DQ-RFWDownloadTask", RFWLog.USR, "[handleInsertMediaResult]  | result = " + bool + " | task = " + this);
        if (bool.booleanValue()) {
            RFWFileUtils.deleteFile(this.mFilePath);
        } else {
            this.mState = DownloadState.STATE_ERROR;
        }
        handleDownloadFinalResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDownloadProgress$3(float f16, long j3, long j16) {
        DownloadState downloadState = this.mState;
        if (downloadState != DownloadState.STATE_PAUSE && downloadState != DownloadState.STATE_CANCEL) {
            this.mState = DownloadState.STATE_RUNNING;
        }
        this.mPercent = f16;
        this.mDownloadedLength = j3;
        this.mTotalLength = j16;
        RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
        if (rFWDownloadStateProgressBox != null) {
            rFWDownloadStateProgressBox.updateTaskEntry(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDownloadResult$0(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        handleInsertMediaResult(Boolean.valueOf(rFWSaveMediaResultBean.isSuccess));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDownloadResult$1(boolean z16, String str) {
        RFWLog.i("DQ-RFWDownloadTask", RFWLog.USR, "[updateDownloadResult] before\uff0c task = " + this);
        if (z16) {
            this.mState = DownloadState.STATE_SUCCESS;
        } else {
            DownloadState downloadState = this.mState;
            if (downloadState != DownloadState.STATE_PAUSE && downloadState != DownloadState.STATE_CANCEL) {
                this.mState = DownloadState.STATE_ERROR;
            }
        }
        this.mFilePath = str;
        RFWLog.i("DQ-RFWDownloadTask", RFWLog.USR, "[updateDownloadResult]  task = " + this);
        if (z16 && this.mStrategy.supportSaveToSystemAlbum() && RFWApplication.getApplication() != null) {
            RFWSaveUtil.insertMedia(RFWApplication.getApplication(), this.mFilePath, new Consumer() { // from class: com.tencent.biz.richframework.queue.m
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    RFWDownloadTask.this.lambda$updateDownloadResult$0((RFWSaveMediaResultBean) obj);
                }
            });
        } else {
            handleDownloadFinalResult();
        }
    }

    private void sendMsgTriggerClearCurrentTask() {
        Message message = new Message();
        message.what = 1002;
        message.obj = this;
        this.mHandler.sendMessage(message);
    }

    private void sendMsgTriggerNestTaskRun(RFWDownloadQueueStrategy rFWDownloadQueueStrategy) {
        Message message = new Message();
        message.what = 1001;
        message.obj = rFWDownloadQueueStrategy;
        this.mHandler.sendMessage(message);
    }

    private void startDownload() {
        this.mState = DownloadState.STATE_START_RUN;
        RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
        if (rFWDownloadStateProgressBox != null) {
            rFWDownloadStateProgressBox.updateTaskEntry(this);
        }
        RFWDownloaderFactory.getDownloader(this.mStrategy).download(this.mUrl, new RFWDownloader.RFWDownloadListener() { // from class: com.tencent.biz.richframework.queue.RFWDownloadTask.1
            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callEnd(Call call) {
                v.a(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callFailed(Call call, IOException iOException) {
                v.b(this, call, iOException);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callStart(Call call) {
                v.c(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
                v.d(this, call, inetSocketAddress, proxy, protocol2);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
                v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                v.f(this, call, inetSocketAddress, proxy);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
                v.g(this, call, connection);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectionReleased(Call call, Connection connection) {
                v.h(this, call, connection);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void dnsEnd(Call call, String str, List list) {
                v.i(this, call, str, list);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void dnsStart(Call call, String str) {
                v.j(this, call, str);
            }

            @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
                RFWDownloadTask.this.updateDownloadProgress(f16, j3, j16);
            }

            @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
            public void onRspCallback(boolean z16, String str) {
                RFWDownloadTask.this.updateDownloadResult(z16, str);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestBodyEnd(Call call, long j3) {
                v.k(this, call, j3);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestBodyStart(Call call) {
                v.l(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
                v.m(this, call, request);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestHeadersStart(Call call) {
                v.n(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseBodyEnd(Call call, long j3) {
                v.o(this, call, j3);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseBodyStart(Call call) {
                v.p(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
                v.q(this, call, response);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseHeadersStart(Call call) {
                v.r(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
                v.s(this, call, handshake);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void secureConnectStart(Call call) {
                v.t(this, call);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadProgress(final float f16, final long j3, final long j16) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.queue.l
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadTask.this.lambda$updateDownloadProgress$3(f16, j3, j16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadResult(final boolean z16, final String str) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.queue.k
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadTask.this.lambda$updateDownloadResult$1(z16, str);
            }
        });
    }

    public void cancelTask() {
        this.mState = DownloadState.STATE_CANCEL;
        RFWDownloaderFactory.getDownloader(this.mStrategy).cancelDownloadRequest(this.mUrl);
        RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
        if (rFWDownloadStateProgressBox != null) {
            rFWDownloadStateProgressBox.updateTaskEntry(this);
        }
        RFWLog.i("DQ-RFWDownloadTask", RFWLog.USR, "[onCancel]  task = " + this);
    }

    public long getDownloadedLength() {
        return this.mDownloadedLength;
    }

    public HashMap<String, String> getExtMap() {
        return this.mExtMap;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public DownloadState getState() {
        return this.mState;
    }

    public RFWDownloadQueueStrategy getStrategy() {
        return this.mStrategy;
    }

    public long getTotalLength() {
        return this.mTotalLength;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void pauseTask() {
        this.mState = DownloadState.STATE_PAUSE;
        RFWDownloaderFactory.getDownloader(this.mStrategy).cancelDownloadRequest(this.mUrl);
        RFWLog.i("DQ-RFWDownloadTask", RFWLog.USR, "[onPause]  task = " + this);
    }

    public void runTask() {
        if (this.mStrategy != null && !TextUtils.isEmpty(this.mUrl)) {
            startDownload();
            RFWLog.i("DQ-RFWDownloadTask", RFWLog.USR, "[runTask]  task = " + this);
            return;
        }
        RFWLog.e("DQ-RFWDownloadTask", RFWLog.USR, "[onRun]  params error, strategy = " + this.mStrategy + " , url = " + this.mUrl);
    }

    public void setDownloadedLength(long j3) {
        this.mDownloadedLength = j3;
    }

    public void setExtMap(HashMap<String, String> hashMap) {
        this.mExtMap = hashMap;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setPercent(float f16) {
        this.mPercent = f16;
    }

    public void setState(DownloadState downloadState) {
        this.mState = downloadState;
    }

    public void setTotalLength(long j3) {
        this.mTotalLength = j3;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("RFWDownloadTask{mUrl='");
        sb5.append(this.mUrl);
        sb5.append(", mStrategy=");
        RFWDownloadQueueStrategy rFWDownloadQueueStrategy = this.mStrategy;
        if (rFWDownloadQueueStrategy != null) {
            str = rFWDownloadQueueStrategy.getBusinessKey();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(", mState=");
        sb5.append(this.mState);
        sb5.append(", mFilePath='");
        sb5.append(this.mFilePath);
        sb5.append(", mPercent=");
        sb5.append(this.mPercent);
        sb5.append(", mDownloadedLength=");
        sb5.append(this.mDownloadedLength);
        sb5.append(", mTotalLength=");
        sb5.append(this.mTotalLength);
        sb5.append(", mTaskGenerateTime=");
        sb5.append(this.mTaskGenerateTime);
        sb5.append(", mExtMap=");
        sb5.append(RFWDownloadQueueUtils.mapToString(this.mExtMap));
        sb5.append('}');
        return sb5.toString();
    }

    public void waitTask() {
        this.mState = DownloadState.STATE_WAITING;
        RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
        if (rFWDownloadStateProgressBox != null) {
            rFWDownloadStateProgressBox.updateTaskEntry(this);
        }
        RFWLog.i("DQ-RFWDownloadTask", RFWLog.USR, "[waitTask]  task = " + this);
    }
}
