package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.r;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.h;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.quic.internal.QuicEngineImp;
import com.tencent.mobileqq.transfile.quic.open.IQuicEngine;
import com.tencent.mobileqq.transfile.quic.open.QuicEngineFactory;
import com.tencent.mobileqq.transfile.quic.open.QuicReq;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes19.dex */
public class ShortVideoDownloadProcessor extends BaseDownloadProcessor implements NetFailedListener {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ShortVideoDownloadProcessor";
    static HashSet<String> runningTasks;
    private String fileMd5;
    private String mFileId;
    protected boolean mForceDisableH265;
    protected boolean mIpListEmptyResp;
    protected boolean mIsQuicEncryption;
    protected QuicDownloadListener mQuicDownloadListener;
    protected int mQuicFec;
    protected QuicNetReport mQuicNetReport;
    int mRedirectCount;
    long mRedirectTime;
    int mReportBusiType;
    protected int mRequestFileType;
    protected int mResponseVideoCodecFormat;
    protected String mResponseVideoMd5;
    protected boolean mSupportQuic;
    private String mTaskKey;
    private String mUniseq;
    private int videoTime;

    /* loaded from: classes19.dex */
    public static class QuicDownloadListener implements DownloadListener {
        static IPatchRedirector $redirector_;
        public AtomicBoolean cancel;
        private WeakReference<ShortVideoDownloadProcessor> mVideoDownloadProcessor;

        public QuicDownloadListener(ShortVideoDownloadProcessor shortVideoDownloadProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) shortVideoDownloadProcessor);
            } else {
                this.cancel = new AtomicBoolean(false);
                this.mVideoDownloadProcessor = new WeakReference<>(shortVideoDownloadProcessor);
            }
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public boolean isCanceled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.cancel.get();
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public void onDownloadFailed(String str, QuicNetReport quicNetReport) {
            HttpNetReq httpNetReq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) quicNetReport);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoDownloadProcessor.TAG, 4, "quic download failed. use http try again. errCode: " + quicNetReport.errCode + " errMsg: " + quicNetReport.errMsg + " ip: " + quicNetReport.f293473ip + " port: " + quicNetReport.port);
            }
            if (this.cancel.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoDownloadProcessor.TAG, 4, "task canceled.");
                    return;
                }
                return;
            }
            ShortVideoDownloadProcessor shortVideoDownloadProcessor = this.mVideoDownloadProcessor.get();
            boolean z16 = true;
            if (shortVideoDownloadProcessor != null && (httpNetReq = (HttpNetReq) shortVideoDownloadProcessor.mNetReq) != null) {
                if (quicNetReport.failReason == 8) {
                    if (httpNetReq.mCallback != null) {
                        QLog.d(ShortVideoDownloadProcessor.TAG, 4, "shortVideoDownloadProcessor failReason downloading.");
                        NetResp netResp = new NetResp(httpNetReq);
                        netResp.mResult = 3;
                        httpNetReq.mCallback.onResp(netResp);
                        return;
                    }
                    return;
                }
                quicNetReport.isHttpRetryed = true;
                quicNetReport.stats = QuicEngineImp.saveNetStats(quicNetReport);
                shortVideoDownloadProcessor.mQuicNetReport = quicNetReport;
                shortVideoDownloadProcessor.mNetEngine.sendReq(httpNetReq);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shortVideoDownloadProcessor or netReq is null. processor: ");
            if (shortVideoDownloadProcessor != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.e(ShortVideoDownloadProcessor.TAG, 4, sb5.toString());
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public void onDownloadProgress(String str, long j3, long j16) {
            HttpNetReq httpNetReq;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (this.cancel.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoDownloadProcessor.TAG, 4, "task canceled.");
                    return;
                }
                return;
            }
            ShortVideoDownloadProcessor shortVideoDownloadProcessor = this.mVideoDownloadProcessor.get();
            if (shortVideoDownloadProcessor != null && (httpNetReq = (HttpNetReq) shortVideoDownloadProcessor.mNetReq) != null) {
                INetEngineListener iNetEngineListener = httpNetReq.mCallback;
                if (iNetEngineListener != null) {
                    iNetEngineListener.onUpdateProgeress(httpNetReq, j16, j3);
                    return;
                }
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shortVideoDownloadProcessor or netReq is null. processor: ");
            if (shortVideoDownloadProcessor != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.e(ShortVideoDownloadProcessor.TAG, 4, sb5.toString());
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public void onDownloadSucceed(String str, QuicNetReport quicNetReport) {
            HttpNetReq httpNetReq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) quicNetReport);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoDownloadProcessor.TAG, 2, "quic download cost time: " + quicNetReport.totaltime + " waitTime: " + quicNetReport.waitCost + "  firstCostTime: " + quicNetReport.firstPackageCost);
            }
            if (this.cancel.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoDownloadProcessor.TAG, 4, "task canceled.");
                    return;
                }
                return;
            }
            ShortVideoDownloadProcessor shortVideoDownloadProcessor = this.mVideoDownloadProcessor.get();
            boolean z16 = true;
            if (shortVideoDownloadProcessor != null && (httpNetReq = (HttpNetReq) shortVideoDownloadProcessor.mNetReq) != null) {
                quicNetReport.stats = QuicEngineImp.saveNetStats(quicNetReport);
                quicNetReport.success = true;
                shortVideoDownloadProcessor.mQuicNetReport = quicNetReport;
                shortVideoDownloadProcessor.quicDownloadSuc(quicNetReport, httpNetReq);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shortVideoDownloadProcessor or netReq is null. processor: ");
            if (shortVideoDownloadProcessor != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.e(ShortVideoDownloadProcessor.TAG, 4, sb5.toString());
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public void setCancel(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.cancel.set(z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            runningTasks = new HashSet<>();
        }
    }

    public ShortVideoDownloadProcessor(TransFileControllerImpl transFileControllerImpl, TransferRequest transferRequest) {
        super(transFileControllerImpl, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) transFileControllerImpl, (Object) transferRequest);
            return;
        }
        this.fileMd5 = "";
        this.mReportBusiType = -1;
        this.mRedirectTime = 0L;
        this.mRedirectCount = 0;
        String str = transferRequest.mLocalPath;
        if (str != null) {
            String[] split = str.split(ShortVideoForwardProcessor.SEPERATOR);
            if (split.length < 3) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "path was not set correctlly------path = " + str);
                }
                throw new IllegalArgumentException("path was not set correctlly.");
            }
            transferRequest.mOutFilePath = split[0];
            this.mFileId = split[1];
            this.mTaskKey = this.mFileId + transferRequest.mFileType + transferRequest.mUniseq;
            if (split.length > 3) {
                this.videoTime = Integer.parseInt(split[3]);
            }
        }
        this.mUniseq = String.valueOf(transferRequest.mUniseq);
    }

    private void handleReqErr(RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp) {
        MessageRecord messageRecord;
        if (!shortVideoDownResp.isAllowRetry && (messageRecord = this.mUiRequest.mRec) != null && (messageRecord instanceof MessageForShortVideo)) {
            ((MessageForShortVideo) messageRecord).isAllowAutoDown = false;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onBusiProtoResp()-- server return not allow auto retry");
            }
        }
        ProcessorReport processorReport = this.mProcessorReport;
        int i3 = processorReport.errCode;
        if (-5100026 == i3) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onBusiProtoResp()---- \u5b89\u5168\u6253\u51fbmUiRequest.mMd5:" + this.mUiRequest.mMd5);
            }
            this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERR_BAN_DOWNLOAD, "\u5b89\u5168\u6253\u51fbmUiRequest.mMd5:" + this.mUiRequest.mMd5, null, null);
        } else if (-9527 == i3 && (processorReport.errDesc.equals("H_400_-5103017") || this.mProcessorReport.errDesc.equals("H_400_-5103059"))) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onBusiProtoResp()---- \u89c6\u9891\u6587\u4ef6\u8fc7\u671ferrCode=" + this.mProcessorReport.errCode);
            }
            ProcessorReport processorReport2 = this.mProcessorReport;
            processorReport2.setError(processorReport2.errCode, HardCodeUtil.qqStr(R.string.thq), null, null);
        } else {
            ProcessorReport processorReport3 = this.mProcessorReport;
            if (-5100528 == processorReport3.errCode) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onBusiProtoResp()---- \u540e\u53f0\u4e0d\u5141\u8bb8\u81ea\u52a8\u4e0b\u8f7d, errCode = " + this.mProcessorReport.errCode);
                }
                this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERR_REJECT_VIDEO_AUTO_DOWN, HardCodeUtil.qqStr(R.string.thv), null, null);
            } else {
                processorReport3.setError(9045, HardCodeUtil.qqStr(R.string.thx), null, null);
            }
        }
        onError();
    }

    private void handleReqSuc(RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp) {
        Object obj;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[1];
            if (("onBusiProtoResp() cdn ---- mIpListSize:" + this.mIpList) == null) {
                obj = 0;
            } else {
                obj = this.mIpList.size() + " mHostType:" + shortVideoDownResp.mHostType + " domain:" + shortVideoDownResp.mDomain + " url:" + shortVideoDownResp.mUrl;
            }
            objArr[0] = obj;
            QLog.d(TAG, 2, objArr);
            QLog.d(TAG, 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.mUiRequest.mMd5 + " ---- downResp.md5:" + HexUtil.bytes2HexStr(shortVideoDownResp.md5));
        }
        this.mRespUrl = shortVideoDownResp.mUrl;
        this.mSupportQuic = shortVideoDownResp.mIsSupportQuic;
        this.mIsQuicEncryption = shortVideoDownResp.mIsQuicEncryption;
        this.mQuicFec = shortVideoDownResp.mQuicFec;
        handleReqSucForH265(shortVideoDownResp);
        receiveFile(shortVideoDownResp.mIsHttps);
    }

    private void handleReqSucForH265(RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp) {
        if (this.mRequestFileType != 2) {
            return;
        }
        if (!h.h(this.app)) {
            QLog.d(TAG, 1, "[H265_VIDEO]", this.mUniseq, " handleReqSucForH265 return, config disable h265 video.");
            return;
        }
        byte[] bArr = shortVideoDownResp.md5;
        if (bArr != null) {
            this.mResponseVideoMd5 = HexUtil.bytes2HexStr(bArr);
        }
        this.mResponseVideoCodecFormat = shortVideoDownResp.mVideoCodecFormat;
        MessageRecord f16 = h.f((QQAppInterface) this.app, this.mUiRequest);
        if (!(f16 instanceof MessageForShortVideo)) {
            QLog.e(TAG, 1, "[H265_VIDEO]", this.mUniseq, " handleReqSucForH265 return, not MessageForShortVideo.");
            return;
        }
        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) f16;
        if (TextUtils.isEmpty(messageForShortVideo.getExtInfoFromExtStr("video_init_download_response_codec_format"))) {
            messageForShortVideo.saveExtInfoToExtStr("video_init_download_response_codec_format", String.valueOf(this.mResponseVideoCodecFormat));
        } else if (messageForShortVideo.getBitValue(0) == 1) {
            if (TextUtils.equals(messageForShortVideo.getExtInfoFromExtStr("video_init_download_response_codec_format"), String.valueOf(this.mResponseVideoCodecFormat))) {
                messageForShortVideo.saveExtInfoToExtStr("video_keep_download_after_pre_download", "1");
            } else {
                messageForShortVideo.saveExtInfoToExtStr("video_keep_download_after_pre_download", "0");
            }
        }
        messageForShortVideo.saveExtInfoToExtStr("video_download_response_codec_format", String.valueOf(this.mResponseVideoCodecFormat));
        if (!TextUtils.isEmpty(this.mResponseVideoMd5)) {
            messageForShortVideo.saveExtInfoToExtStr("video_download_response_md5", this.mResponseVideoMd5);
        }
        QLog.d(TAG, 1, "[H265_VIDEO]", this.mUniseq, " handleReqSucForH265 mResponseVideoCodecFormat = ", Integer.valueOf(this.mResponseVideoCodecFormat), ", mResponseVideoMd5 = ", this.mResponseVideoMd5, ", mFileId = ", this.mFileId);
    }

    private void setBusiType(RichProto.RichProtoReq.ShortVideoDownReq shortVideoDownReq) {
        TransferRequest transferRequest = this.mUiRequest;
        MessageRecord messageRecord = transferRequest.mRec;
        if (messageRecord != null && (messageRecord instanceof MessageForShortVideo)) {
            int i3 = ((MessageForShortVideo) messageRecord).busiType;
            shortVideoDownReq.busiType = i3;
            if (i3 == 1021 && shortVideoDownReq.fileType == 1) {
                shortVideoDownReq.busiType = 1022;
            }
        } else if (1008 == shortVideoDownReq.uinType) {
            shortVideoDownReq.busiType = transferRequest.mBusiType;
        } else {
            shortVideoDownReq.busiType = 0;
        }
        this.mReportBusiType = shortVideoDownReq.busiType;
        shortVideoDownReq.subBusiType = 0;
        if (messageRecord != null && (messageRecord instanceof MessageForShortVideo)) {
            if (((MessageForShortVideo) messageRecord).subBusiType == 1) {
                shortVideoDownReq.subBusiType = 1;
            }
            if (shortVideoDownReq.uinType == 10014) {
                shortVideoDownReq.subBusiType = ((MessageForShortVideo) messageRecord).subBusiType;
            }
        }
    }

    private void setChatType(RichProto.RichProtoReq.ShortVideoDownReq shortVideoDownReq) {
        int i3 = shortVideoDownReq.uinType;
        if (i3 == 0) {
            shortVideoDownReq.chatType = 0;
            return;
        }
        if (1 == i3) {
            shortVideoDownReq.chatType = 1;
            return;
        }
        if (3000 == i3) {
            shortVideoDownReq.chatType = 2;
        } else if (10014 == i3) {
            shortVideoDownReq.chatType = 4;
        } else {
            shortVideoDownReq.chatType = 3;
        }
    }

    private void setFileType(RichProto.RichProtoReq.ShortVideoDownReq shortVideoDownReq) {
        int i3 = this.mUiRequest.mFileType;
        if (i3 != 7 && i3 != 16 && i3 != 18 && i3 != 68) {
            if (i3 == 6 || i3 == 9 || i3 == 17 || i3 == 67) {
                shortVideoDownReq.fileType = 2;
            }
        } else {
            shortVideoDownReq.fileType = 1;
        }
        this.mRequestFileType = shortVideoDownReq.fileType;
    }

    private void setTroopUin(RichProto.RichProtoReq.ShortVideoDownReq shortVideoDownReq) {
        int i3 = shortVideoDownReq.uinType;
        if (i3 != 0 && 1008 != i3) {
            TransferRequest transferRequest = this.mUiRequest;
            if ((transferRequest.mRec instanceof MessageForShortVideo) && 10014 == transferRequest.mUinType) {
                shortVideoDownReq.troopUin = String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(this.mUiRequest.mRec));
                return;
            } else {
                shortVideoDownReq.troopUin = transferRequest.mPeerUin;
                return;
            }
        }
        shortVideoDownReq.troopUin = null;
    }

    private void setVideoCodecInfo(RichProto.RichProtoReq.ShortVideoDownReq shortVideoDownReq) {
        if (this.mRequestFileType != 2) {
            return;
        }
        if (this.mForceDisableH265) {
            shortVideoDownReq.targetVideoCodecFormat = 0;
        } else {
            shortVideoDownReq.targetVideoCodecFormat = this.mUiRequest.mTargetVideoCodecFormat;
        }
        shortVideoDownReq.sourceVideoCodecFormat = this.mUiRequest.mSourceVideoCodecFormat;
        QLog.d(TAG, 1, "[H265_VIDEO]", this.mUniseq, "setVideoCodecInfo videoCodecFormat = ", Integer.valueOf(shortVideoDownReq.targetVideoCodecFormat), ", sourceVideoCodecFormat = ", Integer.valueOf(shortVideoDownReq.sourceVideoCodecFormat), ", mForceDisableH265 = ", Boolean.valueOf(this.mForceDisableH265));
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cancel()");
        }
        runningTasks.remove(this.mTaskKey);
        QuicDownloadListener quicDownloadListener = this.mQuicDownloadListener;
        if (quicDownloadListener != null) {
            quicDownloadListener.cancel.set(true);
            this.mQuicDownloadListener = null;
        }
        return super.cancel();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        MessageRecord messageRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest != null && transferRequest.mOutFilePath != null) {
            if (transferRequest != null && (messageRecord = transferRequest.mRec) != null && ((MessageForShortVideo) messageRecord).busiType == 0) {
                this.mIsShortVideoReceive = true;
                return 0;
            }
            return 0;
        }
        this.mProcessorReport.setError(9302, HardCodeUtil.qqStr(R.string.f172707th4), null, null);
        onError();
        return -1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(3:19|20|(2:21|22))|(2:24|(3:26|27|(6:35|36|(1:38)|40|41|42)))|62|40|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ac, code lost:
    
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d5, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor.TAG, 2, "check MD5 erro!", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkVideoMD5() {
        FileInputStream fileInputStream;
        byte[] mD5Byte;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        String str = this.mUiRequest.mMd5;
        int i3 = 0;
        int i16 = 1;
        if (this.mRequestFileType == 2 && this.mResponseVideoCodecFormat == 1) {
            if (!TextUtils.isEmpty(this.mResponseVideoMd5)) {
                str = this.mResponseVideoMd5;
            } else {
                QLog.e(TAG, 2, "[H265_VIDEO]", this.mUniseq, " onResp() check MD5 warning. mResponseVideoMd5 is empty!");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(this.mUiRequest.mOutFilePath);
                    try {
                        try {
                            mD5Byte = MD5.toMD5Byte(fileInputStream, fileInputStream.available());
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e(TAG, 2, "check MD5 erro!", e16);
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e17) {
                        e = e17;
                        i3 = 1;
                    }
                } catch (IOException e18) {
                    e = e18;
                    i3 = 1;
                }
                if (mD5Byte != null) {
                    String bytes2HexStr = HexUtil.bytes2HexStr(mD5Byte);
                    this.fileMd5 = bytes2HexStr;
                    if (!bytes2HexStr.equals(str)) {
                        int i17 = this.mUiRequest.mFileType;
                        if (i17 == 6 || i17 == 9 || i17 == 17 || i17 == 67) {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.e(TAG, 2, "onResp() check MD5 failed ! md5FormMessage:" + str + " fileMd5:" + this.fileMd5);
                                }
                                fileInputStream.close();
                            } catch (IOException e19) {
                                e = e19;
                                fileInputStream2 = fileInputStream;
                                if (QLog.isColorLevel()) {
                                    QLog.e(TAG, 2, "check MD5 erro!", e);
                                }
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e26) {
                                        e = e26;
                                    }
                                }
                                i16 = i3;
                                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_MD5CHECK, String.valueOf(i16));
                            }
                            i16 = i3;
                        }
                    }
                }
                i3 = 1;
                fileInputStream.close();
                i16 = i3;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_MD5CHECK, String.valueOf(i16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        int i3;
        boolean z17;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        if (this.mUiRequest.mIsOnlyGetUrl) {
            return;
        }
        if (!z16 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (!processorReport.mIsOldDbRec) {
            if (!z16 || (processorReport.mReportedFlag & 2) <= 0) {
                if (z16 || (processorReport.mReportedFlag & 1) <= 0) {
                    int i16 = processorReport.mReportedFlag;
                    if (z16) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    processorReport.mReportedFlag = i16 | i3;
                    if (this.mRedirectCount > 0) {
                        new HashMap().put("businessType", String.valueOf(this.mUiRequest.mFileType));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.GROUP_SHORTVIDEO_REDIRECT, true, this.mRedirectTime, this.mRedirectCount, this.mProcessorReport.mReportInfo, "");
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "mRedirectReportInfo = " + this.mRedirectCount + " " + this.mRedirectTime + " " + this.mUiRequest.mFileType);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "reportTag = " + getReportTAG());
                    }
                    long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, this.mProcessorReport.mStepUrl.getReportInfo(1) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(2) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(3));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_FROM_UIN, this.mUiRequest.mPeerUin);
                    if (this.mIpList.size() > 0) {
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SERVER_VIDEO_IPS, this.mIpList.toString());
                    }
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_UUID, this.mFileId);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.file.fileSize));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_FILE_MD5, this.mUiRequest.mMd5);
                    this.mProcessorReport.mReportInfo.put("param_busiType", this.mReportBusiType + "");
                    this.mProcessorReport.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_DOWN_MODE, String.valueOf(this.mUiRequest.mDownMode));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_VIDEO_CODEC_FORMAT, String.valueOf(this.mResponseVideoCodecFormat));
                    QuicNetReport quicNetReport = this.mQuicNetReport;
                    if (quicNetReport != null && !quicNetReport.isHttpRetryed) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    HashMap<String, String> hashMap = this.mProcessorReport.mReportInfo;
                    String str3 = "1";
                    if (z17) {
                        str = "2";
                    } else if (this.mIsHttpsDownload) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    hashMap.put(ReportConstant.KEY_IS_HTTPS, str);
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    processorReport2.mReportInfo.put(ReportConstant.KEY_TRANS_CONSUME, String.valueOf(processorReport2.mStepTrans.getTimeConsume()));
                    HashMap<String, String> hashMap2 = this.mProcessorReport.mReportInfo;
                    if (z17) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    hashMap2.put(QuicNetReport.KEY_QUIC_DOWNLOAD, str2);
                    HashMap<String, String> hashMap3 = this.mProcessorReport.mReportInfo;
                    QuicNetReport quicNetReport2 = this.mQuicNetReport;
                    if (quicNetReport2 == null || !quicNetReport2.success) {
                        str3 = "0";
                    }
                    hashMap3.put(QuicNetReport.KEY_QUIC_DOWNLOAD_STATUS, str3);
                    reportQuicNetState();
                    if (z16) {
                        reportForIpv6(true, nanoTime);
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, nanoTime, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
                        doReportForGuild(true, nanoTime);
                    } else {
                        ProcessorReport processorReport3 = this.mProcessorReport;
                        if (processorReport3.errCode != -9527) {
                            processorReport3.mReportInfo.remove("param_rspHeader");
                        }
                        ProcessorReport processorReport4 = this.mProcessorReport;
                        processorReport4.mReportInfo.put("param_FailCode", String.valueOf(processorReport4.errCode));
                        ProcessorReport processorReport5 = this.mProcessorReport;
                        processorReport5.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport5.errDesc);
                        ProcessorReport processorReport6 = this.mProcessorReport;
                        if (processorReport6.errCode == -6103066) {
                            processorReport6.mReportInfo.put(ReportConstant.KEY_PIC_MD5, "uierquest md5=" + this.mUiRequest.mMd5 + "fileMd5=" + this.fileMd5);
                        }
                        reportForIpv6(false, nanoTime);
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, nanoTime, 0L, this.mProcessorReport.mReportInfo, "");
                        doReportForGuild(false, nanoTime);
                    }
                    setReportFlag();
                }
            }
        }
    }

    protected String doReportForGuild(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
        if (10014 == this.mUiRequest.mUinType) {
            r.a aVar = new r.a();
            String str = "0";
            aVar.f231044a = "0";
            NetReq netReq = this.mNetReq;
            if (netReq instanceof HttpNetReq) {
                aVar.f231045b = ((HttpNetReq) netReq).mReqUrl;
            }
            aVar.f231046c = String.valueOf(this.mTotolLen);
            aVar.f231047d = this.mUiRequest.mMd5;
            aVar.f231048e = String.valueOf(this.videoTime);
            aVar.f231049f = String.valueOf(System.currentTimeMillis() - j3);
            aVar.f231050g = String.valueOf(j3);
            if (!z16) {
                str = String.valueOf(this.mProcessorReport.errCode);
            }
            aVar.f231051h = str;
            aVar.f231052i = this.mProcessorReport.errDesc;
            if (j3 > 0) {
                aVar.f231053j = (((((float) this.mTotolLen) * 1.0f) / ((float) j3)) * 1000.0f) + "B/s";
            }
            aVar.f231054k = this.mUiRequest.mOutFilePath;
            r.c(GuildTelemetryTask.DOWNLOAD_VIDEO, aVar);
            return aVar.f231051h;
        }
        return null;
    }

    protected String getConnUrl(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            sb5.append("https://");
        } else {
            sb5.append("http://");
        }
        if (this.mIpList.size() > 0) {
            ServerAddr serverAddr = this.mIpList.get(0);
            if (serverAddr.isIpv6 && !serverAddr.mIp.startsWith("[")) {
                sb5.append("[" + serverAddr.mIp + "]");
            } else {
                sb5.append(serverAddr.mIp);
            }
            int i3 = serverAddr.port;
            if (i3 != 80 && i3 != 0) {
                sb5.append(":");
                sb5.append(serverAddr.port);
            }
        } else {
            sb5.append(this.mDownDomain);
        }
        sb5.append("/");
        sb5.append(this.mRespUrl);
        logRichMediaEvent("getConnUrl", "cdn url = " + sb5.toString());
        return sb5.toString();
    }

    protected IQuicEngine getQuicEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IQuicEngine) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return QuicEngineFactory.createEngine();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        TransferRequest transferRequest = this.mUiRequest;
        int i3 = transferRequest.mFileType;
        if (i3 == 7) {
            return StatisticCollector.C2C_SHORTVIDEO_DOWNLOAD_THUMB;
        }
        if (i3 != 6) {
            if (i3 != 16 && i3 != 18) {
                if (i3 == 9 || i3 == 17) {
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, transferRequest.mPeerUin);
                    return StatisticCollector.GROUP_SHORTVIDEO_DOWNLOAD_VIDEO;
                }
            } else {
                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, transferRequest.mPeerUin);
                return StatisticCollector.GROUP_SHORTVIDEO_DOWNLOAD_THUMB;
            }
        }
        return StatisticCollector.C2C_SHORTVIDEO_DOWNLOAD_VIDEO;
    }

    public void handleOnRespErr(NetResp netResp) {
        long parseLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) netResp);
            return;
        }
        if (netResp.mRespProperties.get(HttpMsg.XRetryFlag) == null) {
            parseLong = Long.MAX_VALUE;
        } else {
            parseLong = Long.parseLong(netResp.mRespProperties.get(HttpMsg.XRetryFlag));
        }
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_XRT_FLAG, String.valueOf(parseLong));
        if (netResp.mErrCode == 9364 && this.mNetworkChgRetryCount < 3) {
            logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
            this.mNetworkChgRetryCount++;
            clearReprotInfo();
            sendRequest();
            return;
        }
        if (this.mRequestFileType == 2 && this.mResponseVideoCodecFormat == 1 && !this.mForceDisableH265) {
            this.mForceDisableH265 = true;
            QLog.d(TAG, 1, "[H265_VIDEO]", this.mUniseq, " download h265 video failed, retry download use h264.");
            this.mNetworkChgRetryCount = 0;
            clearReprotInfo();
            sendRequest();
            return;
        }
        String str = netResp.mRespProperties.get(HttpMsg.Param_Reason);
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.setError(netResp.mErrCode, netResp.mErrDesc, str, processorReport.mStepTrans);
        onError();
    }

    public void handleOnRespSuc(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) netResp);
            return;
        }
        checkVideoMD5();
        onSuccess();
        this.mRSMReporter.mBusiType = this.mReportBusiType + "";
        this.mRSMReporter.mFileSize = this.file.fileSize;
        reportForServerMonitor(netResp, true, RMServMonitorReport.REPORT_NAME_NM_VIDEODOWN, this.mFileId);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp = (RichProto.RichProtoResp.ShortVideoDownResp) richProtoResp.resps.get(i3);
                logRichMediaEvent("procUrl", shortVideoDownResp.toString());
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, shortVideoDownResp);
                ArrayList<ServerAddr> selectIpList = selectIpList(shortVideoDownResp.mIpv6List, shortVideoDownResp.mIpList);
                this.mIpList = selectIpList;
                if (selectIpList != null && !selectIpList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                this.mIpListEmptyResp = z16;
                this.mDownDomain = shortVideoDownResp.mDomain;
                if (this.isDomainTest) {
                    this.mDownDomain = BaseDownloadProcessor.PTT_VIDEO_DOWNLOAD_DOMAIN;
                    ArrayList<ServerAddr> arrayList = this.mIpList;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (shortVideoDownResp.result == 0) {
                    handleReqSuc(shortVideoDownResp);
                } else {
                    handleReqErr(shortVideoDownResp);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        TransferResult transferResult;
        super.onError();
        runningTasks.remove(this.mTaskKey);
        FileMsg fileMsg = this.file;
        ProcessorReport processorReport = this.mProcessorReport;
        int i3 = processorReport.errCode;
        fileMsg.errorCode = i3;
        if (-5100026 == i3) {
            sendMessageToUpdate(5001);
        } else if (-9527 == i3 && (processorReport.errDesc.equals("H_400_-5103017") || this.mProcessorReport.errDesc.equals("H_400_-5103059"))) {
            sendMessageToUpdate(5002);
        } else {
            sendMessageToUpdate(2005);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onError()---- errCode:" + this.mProcessorReport.errCode);
            QLog.d(TAG, 2, "onError()---- errDesc:" + this.mProcessorReport.errDesc);
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest != null) {
            transferResult = transferRequest.mResult;
        } else {
            transferResult = null;
        }
        if (transferResult != null) {
            transferResult.mResult = -1;
            ProcessorReport processorReport2 = this.mProcessorReport;
            transferResult.mErrCode = processorReport2.errCode;
            transferResult.mErrDesc = processorReport2.errDesc;
            transferResult.mOrigReq = transferRequest;
        }
        Iterator<com.tencent.mobileqq.pic.c> it = this.mDownCallBacks.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.pic.c next = it.next();
            c.a aVar = new c.a();
            aVar.f258654a = -1;
            ProcessorReport processorReport3 = this.mProcessorReport;
            aVar.f258655b = processorReport3.errCode;
            aVar.f258656c = processorReport3.errDesc;
            next.h(aVar);
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoConstants.TAG, 2, "onError ");
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.NetFailedListener
    public void onFailed(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) netResp);
            return;
        }
        this.mRSMReporter.mBusiType = this.mReportBusiType + "";
        this.mRSMReporter.mFileSize = this.file.fileSize;
        reportForServerMonitor(netResp, false, RMServMonitorReport.REPORT_NAME_NM_VIDEODOWN, this.mFileId);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        StepInfo stepInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) netResp);
            return;
        }
        super.onResp(netResp);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("directMsgUrlDown:");
        sb5.append(this.mDirectMsgUrlDown);
        sb5.append(" result:");
        boolean z17 = true;
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        logRichMediaEvent("onHttpResp", sb5.toString());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onResp()---- result:" + netResp.mResult);
            QLog.d(TAG, 2, "onResp()---- errCode:" + netResp.mErrCode);
            QLog.d(TAG, 2, "onResp()---- errDesc:" + netResp.mErrDesc);
        }
        if (this.mDirectMsgUrlDown) {
            stepInfo = this.mProcessorReport.mStepDirectDown;
        } else {
            stepInfo = this.mProcessorReport.mStepTrans;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (netResp.mResult != 0) {
            z17 = false;
        }
        processorReport.copyStaticsInfoFromNetResp(stepInfo, netResp, z17);
        long j3 = netResp.mTotalFileLen;
        this.mTotolLen = j3;
        if (j3 <= 0) {
            this.mTotolLen = netResp.mTotalBlockLen + netResp.mReq.mStartDownOffset;
        }
        this.mRecvLen += netResp.mWrittenBlockLen;
        this.mRedirectTime = netResp.mRedirectTime;
        this.mRedirectCount = netResp.mRedirectCount;
        if (netResp.mResult == 0) {
            handleOnRespSuc(netResp);
        } else {
            handleOnRespErr(netResp);
        }
        this.mNetReq = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "successfully downloaded.");
        }
        runningTasks.remove(this.mTaskKey);
        sendMessageToUpdate(2003);
        TransferRequest transferRequest = this.mUiRequest;
        TransferResult transferResult = transferRequest.mResult;
        if (transferResult != null) {
            transferResult.mResult = 0;
            transferResult.mOrigReq = transferRequest;
        }
        Iterator<com.tencent.mobileqq.pic.c> it = this.mDownCallBacks.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.pic.c next = it.next();
            c.a aVar = new c.a();
            aVar.f258654a = 0;
            TransferRequest transferRequest2 = this.mUiRequest;
            aVar.f258658e = transferRequest2.mOutFilePath;
            aVar.f258660g = transferRequest2.mMd5;
            aVar.f258662i = transferRequest2.mDownMode;
            next.h(aVar);
        }
        IMsgStorageApi iMsgStorageApi = (IMsgStorageApi) QRoute.api(IMsgStorageApi.class);
        TransferRequest transferRequest3 = this.mUiRequest;
        iMsgStorageApi.onFileDownload(transferRequest3.mOutFilePath, transferRequest3.mRec);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.mIsPause) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
                return;
            }
            return;
        }
        FileMsg fileMsg = this.file;
        fileMsg.transferedSize = j3;
        fileMsg.fileSize = j16;
        sendMessageToUpdate(2002);
        int i3 = (int) ((j3 * 10000) / j16);
        Iterator<com.tencent.mobileqq.pic.c> it = this.mDownCallBacks.iterator();
        while (it.hasNext()) {
            it.next().a(i3, false);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pause() mIsPause : " + this.mIsPause);
        }
        if (!this.mIsPause) {
            this.mIsPause = true;
            sendMessageToUpdate(2004);
            RichProto.RichProtoReq richProtoReq = this.mRichProtoReq;
            if (richProtoReq != null) {
                RichProtoProc.cancelRichProtoReq(richProtoReq);
                this.mRichProtoReq = null;
            }
            NetReq netReq = this.mNetReq;
            if (netReq != null) {
                this.mNetEngine.cancelReq(netReq);
                this.mNetReq = null;
            }
            QuicDownloadListener quicDownloadListener = this.mQuicDownloadListener;
            if (quicDownloadListener != null) {
                quicDownloadListener.cancel.set(true);
                this.mQuicDownloadListener = null;
            }
        }
    }

    protected void quicDownloadSuc(QuicNetReport quicNetReport, HttpNetReq httpNetReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) quicNetReport, (Object) httpNetReq);
            return;
        }
        if (httpNetReq != null && httpNetReq.mCallback != null) {
            NetResp netResp = new NetResp(httpNetReq);
            netResp.mHttpCode = quicNetReport.httpStatus;
            netResp.mTotalFileLen = quicNetReport.fileSize;
            netResp.reqCost = quicNetReport.totaltime;
            Set<String> keySet = quicNetReport.headers.keySet();
            HashMap<String, String> hashMap = new HashMap<>();
            for (String str : keySet) {
                hashMap.put(str, quicNetReport.headers.get(str));
            }
            netResp.setResult(0, quicNetReport.errCode, quicNetReport.errMsg, hashMap);
            httpNetReq.mCallback.onResp(netResp);
        }
    }

    void receiveFile(boolean z16) {
        String Q1;
        String[] split;
        this.mIsHttpsDownload = z16;
        this.mRSMReporter.mIsHttps = z16;
        if (TextUtils.isEmpty(this.mDownDomain)) {
            this.mDownDomain = BaseDownloadProcessor.PTT_VIDEO_DOWNLOAD_DOMAIN;
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        String connUrl = getConnUrl(z16);
        HttpNetReq httpNetReq = new HttpNetReq();
        if (!StringUtil.isEmpty(this.mDownDomain)) {
            httpNetReq.mReqProperties.put("host", this.mDownDomain);
        }
        httpNetReq.mCallback = this;
        httpNetReq.mFailedListener = this;
        httpNetReq.mReqUrl = connUrl;
        httpNetReq.mIsHttps = z16;
        String str = this.mDownDomain;
        httpNetReq.mHostForHttpsVerify = str;
        httpNetReq.mHttpMethod = 0;
        TransFileUtil.addDomainToList(this.mIpList, str);
        httpNetReq.mServerList = this.mIpList;
        TransferRequest transferRequest = this.mUiRequest;
        httpNetReq.mOutPath = transferRequest.mOutFilePath;
        httpNetReq.mMsgId = String.valueOf(transferRequest.mUniseq);
        TransferRequest transferRequest2 = this.mUiRequest;
        httpNetReq.mBusiProtoType = transferRequest2.mUinType;
        int i3 = transferRequest2.mFileType;
        httpNetReq.mFileType = i3;
        if ((i3 == 6 || i3 == 9 || i3 == 17 || i3 == 67) && (Q1 = ea.Q1(BaseApplication.getContext())) != null && Q1.length() > 0 && (split = Q1.split("\\|")) != null && split.length > 0) {
            httpNetReq.mWhiteListContentType = split;
        }
        httpNetReq.mStartDownOffset = 0L;
        httpNetReq.mIsNetChgAsError = true;
        httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
        httpNetReq.mSupportBreakResume = true;
        httpNetReq.mTempPath = this.mUiRequest.mOutFilePath + "." + MD5.toMD5(this.mFileId) + ".tmp";
        logRichMediaEvent("httpDown", "url:" + connUrl + ",downOffset:" + httpNetReq.mStartDownOffset);
        if (!canDoNextStep()) {
            runningTasks.remove(this.mTaskKey);
            return;
        }
        this.mNetReq = httpNetReq;
        setMtype();
        httpNetReq.mNeedRedirectCallback = true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "recieveFile mIsOnlyGetUrl " + this.mUiRequest.mIsOnlyGetUrl + " domain=" + this.mDownDomain + " ipsize=" + this.mIpList.size());
        }
        if (this.mUiRequest.mIsOnlyGetUrl) {
            String[] strArr = new String[this.mIpList.size()];
            for (int i16 = 0; i16 < this.mIpList.size(); i16++) {
                ServerAddr serverAddr = this.mIpList.get(i16);
                StringBuffer stringBuffer = new StringBuffer();
                if (z16) {
                    stringBuffer.append("https://");
                } else {
                    stringBuffer.append("http://");
                }
                stringBuffer.append(serverAddr.mIp);
                if (serverAddr.port != 80) {
                    stringBuffer.append(":");
                    stringBuffer.append(serverAddr.port);
                }
                stringBuffer.append("/");
                strArr[i16] = TransFileUtil.replaceIp(connUrl, stringBuffer.toString());
            }
            FileMsg fileMsg = this.file;
            fileMsg.urls = strArr;
            fileMsg.domain = this.mDownDomain;
            fileMsg.stepUrlCost = this.mProcessorReport.mStepUrl.getTimeConsume();
            sendMessageToUpdate(2002);
            this.mController.removeProcessor(getKey());
            runningTasks.remove(this.mTaskKey);
            return;
        }
        tryUseQuicDownload(httpNetReq);
    }

    protected void reportQuicNetState() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.mQuicNetReport != null) {
            String reportTAG = getReportTAG();
            boolean z17 = false;
            if (!StatisticCollector.C2C_SHORTVIDEO_DOWNLOAD_VIDEO.equals(reportTAG) && !StatisticCollector.GROUP_SHORTVIDEO_DOWNLOAD_VIDEO.equals(reportTAG)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (StatisticCollector.C2C_SHORTVIDEO_DOWNLOAD_VIDEO.equals(reportTAG) || StatisticCollector.C2C_SHORTVIDEO_DOWNLOAD_THUMB.equals(reportTAG)) {
                z17 = true;
            }
            this.mQuicNetReport.reportBeaconEvent(z16, z17);
            this.mQuicNetReport = null;
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "resume()");
        }
        if (this.mIsPause) {
            this.mIsPause = false;
            this.mIsCancel = false;
            sendMessageToUpdate(2001);
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.errCode = 0;
            processorReport.errDesc = "";
            this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoDownloadProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ShortVideoDownloadProcessor.this.sendRequest();
                    }
                }
            });
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void sendMessageToUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        super.sendMessageToUpdate(i3);
        if (this.mIsPause && 2004 != i3) {
            return;
        }
        h.r((QQAppInterface) this.app, this.file, this.mUiRequest);
    }

    void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.ShortVideoDownReq shortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
        shortVideoDownReq.seq = (int) this.mUiRequest.mUniseq;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendGetUrlReq()----busiReq.seq : " + shortVideoDownReq.seq);
        }
        TransferRequest transferRequest = this.mUiRequest;
        shortVideoDownReq.selfUin = transferRequest.mSelfUin;
        String str = transferRequest.mPeerUin;
        shortVideoDownReq.peerUin = str;
        shortVideoDownReq.secondUin = transferRequest.mSecondId;
        shortVideoDownReq.uinType = transferRequest.mUinType;
        shortVideoDownReq.troopUin = str;
        shortVideoDownReq.agentType = 0;
        shortVideoDownReq.clientType = 2;
        shortVideoDownReq.fileId = this.mFileId;
        shortVideoDownReq.md5 = HexUtil.hexStr2Bytes(transferRequest.mMd5);
        setChatType(shortVideoDownReq);
        setTroopUin(shortVideoDownReq);
        setFileType(shortVideoDownReq);
        setBusiType(shortVideoDownReq);
        setVideoCodecInfo(shortVideoDownReq);
        TransferRequest transferRequest2 = this.mUiRequest;
        shortVideoDownReq.downType = transferRequest2.mDownMode;
        Object obj = transferRequest2.mExtraObj;
        if (obj != null && (obj instanceof Integer)) {
            shortVideoDownReq.sceneType = ((Integer) obj).intValue();
        }
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.SHORT_VIDEO_DW;
        richProtoReq.reqs.add(shortVideoDownReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
        } else {
            logRichMediaEvent("requestStart", richProtoReq.toString());
            if (!canDoNextStep()) {
                runningTasks.remove(this.mTaskKey);
            } else {
                this.mRichProtoReq = richProtoReq;
                RichProtoProc.procRichProtoReq(richProtoReq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void setMtype() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        NetReq netReq = this.mNetReq;
        if (netReq != null && (netReq instanceof HttpNetReq)) {
            if (ao.r(this.mUiRequest.mUinType)) {
                str = AppConstants.HTTP_TYPE_VIDEO_CD;
            } else {
                int i3 = this.mUiRequest.mUinType;
                if (i3 == 1) {
                    str = AppConstants.HTTP_TYPE_VIDEO_GD;
                } else if (i3 == 3000) {
                    str = AppConstants.HTTP_TYPE_VIDEO_DD;
                } else {
                    str = AppConstants.HTTP_TYPE_VIDEO_OD;
                }
            }
            NetReq netReq2 = this.mNetReq;
            ((HttpNetReq) netReq2).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq) netReq2).mReqUrl);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        MessageRecord messageRecord;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start()----runningTasks.contains(mTaskKey) = " + runningTasks.contains(this.mTaskKey));
        }
        MessageRecord messageRecord2 = this.mUiRequest.mRec;
        if (messageRecord2 != null && (messageRecord2 instanceof MessageForShortVideo)) {
            logRichMediaEvent("start", "[tvk] videoFileSize = " + ((MessageForShortVideo) messageRecord2).videoFileSize);
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest.mDownMode == 2 && (messageRecord = transferRequest.mRec) != null && (messageRecord instanceof MessageForShortVideo) && !((MessageForShortVideo) messageRecord).isAllowAutoDown && ((i3 = transferRequest.mFileType) == 6 || i3 == 9 || i3 == 17 || i3 == 67)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "start()-- server not allow auto down video");
            }
            runningTasks.remove(this.mTaskKey);
            super.cancel();
            return;
        }
        if (runningTasks.contains(this.mTaskKey)) {
            return;
        }
        runningTasks.add(this.mTaskKey);
        sendMessageToUpdate(2001);
        sendRequest();
    }

    protected void tryUseQuicDownload(HttpNetReq httpNetReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) httpNetReq);
            return;
        }
        QQShortVideoQuicNetProcessor.a a16 = QQShortVideoQuicNetProcessor.a();
        if (a16 != null && a16.a() && this.mSupportQuic && !this.mIpListEmptyResp && !this.mIpList.isEmpty()) {
            IQuicEngine quicEngine = getQuicEngine();
            if (quicEngine == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "current support quic, but quic can not be used.");
                }
                QuicNetReport quicNetReport = new QuicNetReport();
                this.mQuicNetReport = quicNetReport;
                quicNetReport.failReason = 7;
                quicNetReport.isHttpRetryed = true;
                this.mNetEngine.sendReq(httpNetReq);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "current support quic, use quic. ");
            }
            useQuicDownload(httpNetReq, quicEngine);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "current not support quic, use net engine.supportQuic: " + this.mSupportQuic + " ipListEmpty: " + this.mIpListEmptyResp);
        }
        this.mNetEngine.sendReq(httpNetReq);
    }

    protected void useQuicDownload(HttpNetReq httpNetReq, IQuicEngine iQuicEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) httpNetReq, (Object) iQuicEngine);
            return;
        }
        ServerAddr serverAddr = this.mIpList.get(0);
        String str = serverAddr.mIp;
        int i3 = serverAddr.port;
        if (str == null) {
            str = "";
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
        }
        if (i3 <= 0) {
            i3 = WebSocketImpl.DEFAULT_WSS_PORT;
        }
        QuicReq.Builder builder = new QuicReq.Builder(str, i3, "/" + this.mRespUrl, httpNetReq.mOutPath);
        if (!StringUtil.isEmpty(this.mDownDomain)) {
            builder.addHeader("host", this.mDownDomain);
        }
        this.mQuicDownloadListener = new QuicDownloadListener(this);
        iQuicEngine.execute(builder.addHeader("Accept-Encoding", "identity").isQuicEncryption(this.mIsQuicEncryption).fec(this.mQuicFec).tempPath(httpNetReq.mTempPath).timeOut(new TimeoutParam().getReadTimeout(NetworkCenter.getInstance().getNetType())).businessId(1).isIpv6(serverAddr.isIpv6).rttHost(QuicNetReport.RTT_HOST).listener(this.mQuicDownloadListener).build());
    }

    public ShortVideoDownloadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.fileMd5 = "";
        this.mReportBusiType = -1;
        this.mRedirectTime = 0L;
        this.mRedirectCount = 0;
    }
}
