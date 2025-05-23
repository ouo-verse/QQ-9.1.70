package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic$RspStoryVideo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.biz.qqstory.utils.e;
import com.tencent.biz.qqstory.utils.f;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class StoryUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_;
    public static String TAG;
    private Runnable mDelayRunnable;
    private Handler mHandler;
    public String mPhotoUrl;
    private byte[] mSessionKey;
    private byte[] mSigSession;
    private long mStartUploadTime;
    private long mStartWaitTime;
    private String mTag;
    public String mVid;
    public String mVideoUrl;
    private Transaction trans;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            TAG = "Q.qqstory.publish.upload.StoryUploadProcessor";
        }
    }

    public StoryUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.trans = null;
        this.mTag = "Q.qqstory.publish.upload";
        FileMsg fileMsg = this.file;
        fileMsg.processor = this;
        fileMsg.bdhExtendInfo = transferRequest.mExtentionInfo;
        this.mStartWaitTime = System.currentTimeMillis();
        TAG = this.mTag + ".StoryUploadProcessor";
    }

    private String getSdcardInfo() {
        return String.format("sdcard free size:%d, upload dir exist:%b ", Long.valueOf(d.r()), Boolean.valueOf(FileUtils.fileExists(vc0.a.f441365e)));
    }

    public static int makeStoryErrorCoder(int i3) {
        return i3 + 95000000;
    }

    private int thisFileRemoveByOtherSoftWareErrorCode(String str) {
        long j3;
        String m3 = d.m(str);
        try {
            j3 = Long.valueOf(m3.substring(0, m3.indexOf("_"))).longValue();
        } catch (Exception e16) {
            hd0.c.h(TAG, "exception", e16);
            j3 = 0;
        }
        long z16 = d.z(vc0.a.f441365e);
        hd0.c.i(TAG, "orig file create time:%d, flag file create time:%d", Long.valueOf(j3), Long.valueOf(z16));
        if (z16 != 0 && (j3 <= 0 || z16 <= j3)) {
            if (j3 > 0) {
                long currentTimeMillis = ((((System.currentTimeMillis() - j3) / 24) / 60) / 60) / 1000;
                if (currentTimeMillis > 30) {
                    currentTimeMillis = 30;
                }
                return (int) (currentTimeMillis + 999000);
            }
            return 9071;
        }
        hd0.c.i(TAG, "your file delete by software %s", str);
        return 940017;
    }

    public void cancelTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.trans != null) {
            this.app.getHwEngine().cancelTransactionTask(this.trans);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        String str = this.mUiRequest.mLocalPath;
        if (TextUtils.isEmpty(str)) {
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("filePath null")), null, null);
            onError();
            return -1;
        }
        File file = new File(str);
        if (!file.exists()) {
            this.mProcessorReport.setError(thisFileRemoveByOtherSoftWareErrorCode(str), getSdcardInfo() + "sendFile not exist " + str, null, null);
            onError();
            return -1;
        }
        if (!file.canRead()) {
            this.mProcessorReport.setError(9070, BaseTransProcessor.getExpStackString(new Exception("sendFile not readable " + this.file.filePath)), null, null);
            onError();
            return -1;
        }
        long length = file.length();
        this.file.fileSize = length;
        this.mFileSize = length;
        hd0.c.c(TAG, "upload file size %d, file %s", Long.valueOf(length), str);
        if (length <= 0) {
            this.mProcessorReport.setError(thisFileRemoveByOtherSoftWareErrorCode(str), getSdcardInfo() + "sendFile size empty " + str, null, null);
            onError();
            return -1;
        }
        return super.checkParam();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    protected long getBlockSize(long j3) {
        long min;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, j3)).longValue();
        }
        long j16 = this.mFileSize - j3;
        if (!this.mSSCMSpanned) {
            min = Math.min(j16, this.sscmObject.d(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));
        } else {
            min = Math.min(j16, 14600L);
        }
        return Math.min(min, 131072L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public byte[] getStreamData(int i3, int i16) {
        return super.getStreamData(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        sendMessageToUpdate(1005);
        hd0.c.v(TAG, "error errCode:%d,errDesc:%s, %s", Integer.valueOf(this.mProcessorReport.errCode), this.mProcessorReport.errDesc, this.mUiRequest.mLocalPath);
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = -1;
            aVar.f258598b = makeStoryErrorCoder(this.mProcessorReport.errCode);
            aVar.f258599c = this.mProcessorReport.errDesc;
            this.mUiRequest.mUpCallBack.q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) netResp);
        } else {
            super.onResp(netResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        sendMessageToUpdate(1003);
        hd0.c.v(TAG, "success path:%s", this.mUiRequest.mLocalPath);
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = 0;
            aVar.f258602f = this.mVid;
            aVar.f258600d = this.mVideoUrl;
            this.mUiRequest.mUpCallBack.q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        cancelTask();
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public void sendFile() {
        int i3;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        hd0.c.v(TAG, "send file %s", this.mUiRequest.mLocalPath);
        this.mProcessorReport.mStepTrans.logStartTime();
        ITransactionCallback iTransactionCallback = new ITransactionCallback(SystemClock.uptimeMillis()) { // from class: com.tencent.mobileqq.transfile.StoryUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = r6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, StoryUploadProcessor.this, Long.valueOf(r6));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i16, byte[] bArr2, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i16), bArr2, hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                f.a(hashMap.get(TransReport.rep_upFlow_wifi), -1L);
                f.a(hashMap.get(TransReport.rep_dwFlow_wifi), -1L);
                f.a(hashMap.get(TransReport.rep_upFlow_Xg), -1L);
                f.a(hashMap.get(TransReport.rep_dwFlow_Xg), -1L);
                String str = hashMap.get(TransReport.rep_time_cache);
                String str2 = hashMap.get(TransReport.rep_bdhTrans);
                String str3 = hashMap.get(TransReport.rep_segsPerConn);
                String str4 = hashMap.get(TransReport.rep_confSegSize);
                String str5 = hashMap.get(TransReport.rep_confSegNum);
                String str6 = hashMap.get(TransReport.rep_confMaxConn);
                hd0.c.k(StoryUploadProcessor.TAG, "Transaction End : Failed. take time:" + (uptimeMillis - this.val$startTime) + "ms");
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put("X-piccachetime", str);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHTRANS_INFO, str2);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SEG_PER_CNT, str3);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegSize, str4);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegNum, str5);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confMaxConn, str6);
                ProcessorReport processorReport = StoryUploadProcessor.this.mProcessorReport;
                processorReport.setError(i16, "OnFailed.", "", processorReport.mStepTrans);
                StoryUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr2, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr2, (Object) hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_Xg)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_Xg)).longValue();
                String str = hashMap.get(TransReport.rep_time_cache);
                String str2 = hashMap.get(TransReport.rep_bdhTrans);
                String str3 = hashMap.get(TransReport.rep_segsPerConn);
                String str4 = hashMap.get(TransReport.rep_confSegSize);
                String str5 = hashMap.get(TransReport.rep_confSegNum);
                String str6 = hashMap.get(TransReport.rep_confMaxConn);
                hd0.c.k(StoryUploadProcessor.TAG, "Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms ,fileSize:" + StoryUploadProcessor.this.file.fileSize + " transInfo:" + str2);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put("X-piccachetime", str);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHTRANS_INFO, str2);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SEG_PER_CNT, str3);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegSize, str4);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegNum, str5);
                StoryUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confMaxConn, str6);
                StoryUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                StoryUploadProcessor storyUploadProcessor = StoryUploadProcessor.this;
                storyUploadProcessor.mProcessorReport.mStepTrans.result = 1;
                storyUploadProcessor.mTransferedSize = storyUploadProcessor.mFileSize;
                hd0.c.k(StoryUploadProcessor.TAG, "ITransactionCallback.onSuccess()");
                if (bArr2 == null) {
                    StoryUploadProcessor.this.onError();
                } else {
                    StoryUploadProcessor storyUploadProcessor2 = StoryUploadProcessor.this;
                    if (storyUploadProcessor2.file.fileType == 327681) {
                        qqstory_bhd_upload_pic$RspStoryVideo qqstory_bhd_upload_pic_rspstoryvideo = new qqstory_bhd_upload_pic$RspStoryVideo();
                        try {
                            qqstory_bhd_upload_pic_rspstoryvideo.mergeFrom(bArr2);
                            int i16 = qqstory_bhd_upload_pic_rspstoryvideo.retcode.get();
                            if (i16 == 0) {
                                StoryUploadProcessor.this.mVideoUrl = qqstory_bhd_upload_pic_rspstoryvideo.cdn_url.get().toStringUtf8();
                                StoryUploadProcessor storyUploadProcessor3 = StoryUploadProcessor.this;
                                storyUploadProcessor3.mVideoUrl = UIUtils.w(storyUploadProcessor3.mVideoUrl, "authkey");
                                StoryUploadProcessor.this.mVid = qqstory_bhd_upload_pic_rspstoryvideo.file_key.get().toStringUtf8();
                                if (!TextUtils.isEmpty(StoryUploadProcessor.this.mVideoUrl) && !TextUtils.isEmpty(StoryUploadProcessor.this.mVid)) {
                                    StoryUploadProcessor.this.onSuccess();
                                }
                                StoryUploadProcessor storyUploadProcessor4 = StoryUploadProcessor.this;
                                ProcessorReport processorReport = storyUploadProcessor4.mProcessorReport;
                                processorReport.errCode = 940010;
                                processorReport.errDesc = String.format("return illegal arg vid:%s, url:%s", storyUploadProcessor4.mVid, storyUploadProcessor4.mVideoUrl);
                                StoryUploadProcessor.this.onError();
                                String bytes2HexStr = HexUtil.bytes2HexStr(bArr2);
                                String str7 = StoryUploadProcessor.TAG;
                                Object[] objArr = new Object[1];
                                if (bytes2HexStr == null) {
                                    bytes2HexStr = "";
                                }
                                objArr[0] = bytes2HexStr;
                                hd0.c.i(str7, "url not return %s", objArr);
                            } else {
                                ProcessorReport processorReport2 = StoryUploadProcessor.this.mProcessorReport;
                                processorReport2.errCode = i16;
                                processorReport2.errDesc = qqstory_bhd_upload_pic_rspstoryvideo.f94084msg.get().toStringUtf8();
                                StoryUploadProcessor.this.onError();
                            }
                        } catch (InvalidProtocolBufferMicroException unused) {
                            hd0.c.t(StoryUploadProcessor.TAG, "parser buffer exception");
                            StoryUploadProcessor.this.onError();
                        }
                    } else {
                        storyUploadProcessor2.sendMessageToUpdate(1005);
                        StoryUploadProcessor.this.onError();
                    }
                }
                StoryUploadProcessor.this.file.closeInputStream();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                hd0.c.b(StoryUploadProcessor.TAG, "onTransStart %s", StoryUploadProcessor.this.mUiRequest.mLocalPath);
                id0.a.k("publish_story", "publish_bdh", 0, 0, "", String.valueOf(System.currentTimeMillis() - StoryUploadProcessor.this.mStartWaitTime), id0.a.d(BaseApplication.getContext()), "video");
                StoryUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
                StoryUploadProcessor.this.mStartUploadTime = System.currentTimeMillis();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                    return;
                }
                StoryUploadProcessor storyUploadProcessor = StoryUploadProcessor.this;
                long j3 = i16;
                storyUploadProcessor.file.transferedSize = j3;
                storyUploadProcessor.mTransferedSize = j3;
                if (j3 <= storyUploadProcessor.mFileSize && !storyUploadProcessor.mIsCancel && !storyUploadProcessor.mIsPause) {
                    storyUploadProcessor.sendProgressMessage();
                }
            }
        };
        FileMsg fileMsg = this.file;
        if (fileMsg.fileType == 327681) {
            i3 = 57;
        } else {
            i3 = -1;
        }
        fileMsg.commandId = i3;
        synchronized (SessionInfo.class) {
            if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session() != null) {
                int length = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session().length;
                this.mSigSession = new byte[length];
                System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session(), 0, this.mSigSession, 0, length);
            }
            if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey() != null) {
                int length2 = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey().length;
                this.mSessionKey = new byte[length2];
                System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey(), 0, this.mSessionKey, 0, length2);
            }
        }
        byte[] bArr2 = this.mSigSession;
        if (bArr2 == null || bArr2.length == 0 || (bArr = this.mSessionKey) == null || bArr.length == 0) {
            HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
        }
        Transaction transaction = new Transaction(this.app.getCurrentAccountUin(), i3, this.mUiRequest.mLocalPath, (int) this.mStartOffset, this.mLocalMd5, iTransactionCallback, this.file.bdhExtendInfo, false);
        this.trans = transaction;
        transaction.setVideoSegmentMode(true);
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.trans);
        hd0.c.k(TAG, "Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.trans.filePath + " Cmd:" + i3);
        if (submitTransactionTask != 0) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(submitTransactionTask, "SubmitError.", "", processorReport.mStepTrans);
            onError();
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.start();
        hd0.c.v(TAG, "start upload %s", this.mUiRequest.mLocalPath);
        if (this.mLocalMd5 == null && !getMd5()) {
            this.mProcessorReport.setError(940006, "make md5 fail", null, null);
            onError();
        } else if (!e.a(QQStoryContext.h().b())) {
            this.mProcessorReport.setError(880001, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, null, null);
            onError();
        } else {
            sendFile();
        }
    }
}
