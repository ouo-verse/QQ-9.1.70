package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import com.tencent.mobileqq.transfile.SmartPttTranHelper;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import tencent.im.cs.smartptt.Smartptt$RspBody;

/* loaded from: classes19.dex */
public class PttSilkSliceUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final int COMMAND_ID_PTT_SLICE_TRANS = 68;
    private static final int EMPTY_SLICE_SIZE = 2;
    private static final byte[] HEAD;
    private static final int MAX_RESEND_COUNT = 2;
    private static final long RESEND_LOST_SLICE_INTERVAL = 2000;
    private static final int SIMPLE_RATE = 16000;
    public static final String TAG = "PttSilkSliceUploadProcessor";
    private static int offset;
    private static final ConcurrentSkipListMap<Integer, SmartPttTranHelper.PttSliceInfoBean> pendingRequestsCache;
    private SmartPttTranHelper.PttSliceInfoBean mCurInfo;
    private String mFirstPieceMd5;
    private byte[] mLocalPieceMd5;
    private com.tencent.mobileqq.qqaudio.audioprocessor.b processor;
    private SttRunnable sttRunnable;
    private Transaction trans;
    private String voiceID;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class SttRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private final SmartPttTranHelper.PttSliceInfoBean info;
        private final WeakReference<PttSilkSliceUploadProcessor> ref;
        private int retryCount;

        public SttRunnable(PttSilkSliceUploadProcessor pttSilkSliceUploadProcessor, SmartPttTranHelper.PttSliceInfoBean pttSliceInfoBean, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, pttSilkSliceUploadProcessor, pttSliceInfoBean, Integer.valueOf(i3));
                return;
            }
            this.ref = new WeakReference<>(pttSilkSliceUploadProcessor);
            this.info = pttSliceInfoBean;
            this.retryCount = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            PttSilkSliceUploadProcessor pttSilkSliceUploadProcessor = this.ref.get();
            if (pttSilkSliceUploadProcessor != null) {
                pttSilkSliceUploadProcessor.checkAndResendIfNeeded(this.info, this.retryCount);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44446);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        HEAD = RecordParams.a(1, 16000);
        offset = 0;
        pendingRequestsCache = new ConcurrentSkipListMap<>();
    }

    public PttSilkSliceUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        } else {
            this.mFirstPieceMd5 = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndResendIfNeeded(SmartPttTranHelper.PttSliceInfoBean pttSliceInfoBean, int i3) {
        ConcurrentSkipListMap<Integer, SmartPttTranHelper.PttSliceInfoBean> concurrentSkipListMap = pendingRequestsCache;
        QLog.i(TAG, 1, "[submitSlice] cache size: " + concurrentSkipListMap.size());
        for (Map.Entry<Integer, SmartPttTranHelper.PttSliceInfoBean> entry : concurrentSkipListMap.entrySet()) {
            if (!TextUtils.equals(pttSliceInfoBean.voiceId, entry.getValue().voiceId)) {
                QLog.d(TAG, 2, "[checkAndResendIfNeeded] voiceId changed. ignored. " + pttSliceInfoBean.voiceId + " --> " + entry.getValue().voiceId);
                return;
            }
            if (entry.getKey().intValue() <= pttSliceInfoBean.offset) {
                QLog.e(TAG, 1, "[run] submitSlice. find lost slice request. info:" + entry.getValue());
                submitSlice(entry.getValue(), i3 + 1);
                return;
            }
            QLog.i(TAG, 2, "[submitSlice] check offset:" + pttSliceInfoBean.offset + ", cache offset:" + entry.getKey());
        }
    }

    private void checkIsLast(boolean z16) throws IOException {
        if (this.mIsCancel) {
            sendMessageToUpdate(1004);
            return;
        }
        if (z16) {
            ThreadManagerV2.removeJobFromThreadPool(this.sttRunnable, 128);
            sendMessageToUpdate(2003);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendMessageToUpdate send finished!");
                return;
            }
            return;
        }
        sendMessageToUpdate(2002);
    }

    private SmartPttTranHelper.PttSliceInfoBean getTranBean() {
        boolean z16;
        boolean z17;
        SmartPttTranHelper.PttSliceInfoBean pttSliceInfoBean = new SmartPttTranHelper.PttSliceInfoBean();
        pttSliceInfoBean.voiceId = this.voiceID + this.mUiRequest.pcmForVadPos;
        pttSliceInfoBean.offset = offset;
        pttSliceInfoBean.md5 = this.mMd5Str;
        pttSliceInfoBean.chatType = this.mUiRequest.chatType;
        StringBuilder sb5 = new StringBuilder();
        String str = this.mUiRequest.mLocalPath;
        sb5.append(str.substring(0, str.lastIndexOf(File.separator)));
        sb5.append("/tmp_");
        sb5.append(pttSliceInfoBean.voiceId);
        sb5.append("_");
        sb5.append(offset);
        sb5.append(".silk");
        pttSliceInfoBean.filePath = sb5.toString();
        pttSliceInfoBean.encodeType = 6;
        TransferRequest transferRequest = this.mUiRequest;
        pttSliceInfoBean.vegNum = transferRequest.pcmForVadNum;
        pttSliceInfoBean.vegPos = 0;
        int i3 = transferRequest.pcmForVadPos;
        if (i3 == 3) {
            pttSliceInfoBean.isfirst = true;
            pttSliceInfoBean.isLast = true;
        } else {
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            pttSliceInfoBean.isLast = z16;
            if (i3 == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            pttSliceInfoBean.isfirst = z17;
        }
        if (pttSliceInfoBean.isfirst && pttSliceInfoBean.offset != 0) {
            QLog.w(TAG, 1, "[processSilkData] reset bean.offset to 0");
            pttSliceInfoBean.offset = 0;
        }
        return pttSliceInfoBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSuceess(byte[] bArr) {
        boolean z16;
        Smartptt$RspBody smartptt$RspBody = new Smartptt$RspBody();
        try {
            smartptt$RspBody.mergeFrom(bArr);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onSuccess  text =" + smartptt$RspBody.msg_ptttrans_rsp.str_text.get() + " id=" + smartptt$RspBody.msg_ptttrans_rsp.str_voice_id.get() + " pos=" + this.mUiRequest.pcmForVadPos + " uint32_is_final=" + smartptt$RspBody.msg_ptttrans_rsp.uint32_is_final.get() + " uint32_offset=" + smartptt$RspBody.msg_ptttrans_rsp.uint32_offset.get());
            }
            FileMsg fileMsg = this.file;
            fileMsg.fileType = FileMsg.TRANSFILE_TYPE_PTT_SILK_SLICE_TO_TEXT;
            fileMsg.pttSliceText = smartptt$RspBody.msg_ptttrans_rsp.str_text.get();
            FileMsg fileMsg2 = this.file;
            fileMsg2.commandId = 68;
            fileMsg2.pttSlicePos = this.mUiRequest.pcmForVadPos;
            if (smartptt$RspBody.msg_ptttrans_rsp.uint32_is_final.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            checkIsLast(z16);
            this.mProcessorReport.mStepTrans.logFinishTime();
            this.mProcessorReport.mStepTrans.result = 1;
            Iterator<Map.Entry<Integer, SmartPttTranHelper.PttSliceInfoBean>> it = pendingRequestsCache.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, SmartPttTranHelper.PttSliceInfoBean> next = it.next();
                if (z16 || next.getKey().intValue() < smartptt$RspBody.msg_ptttrans_rsp.uint32_offset.get() || (next.getKey().intValue() == 0 && smartptt$RspBody.msg_ptttrans_rsp.uint32_offset.get() == 0)) {
                    it.remove();
                }
            }
        } catch (IOException e16) {
            QLog.e(TAG, 1, "[handleSuceess] exception: " + e16, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitSlice$0() {
        if (!pendingRequestsCache.isEmpty()) {
            QLog.w(TAG, 1, "[submitSlice] last slice response lost.");
            sendMessageToUpdate(2005);
        }
    }

    private void processSilkData() {
        if (this.mIsCancel) {
            return;
        }
        SmartPttTranHelper.PttSliceInfoBean tranBean = getTranBean();
        try {
            QLog.i(TAG, 1, "[processSilkData] toSendData.length:" + this.mUiRequest.toSendData.length);
            byte[] bArr = this.mUiRequest.toSendData;
            int length = bArr.length;
            QLog.i(TAG, 1, "[processSilkData] toSendData set isLast = " + tranBean.isLast + " mUiRequest.pcmForVadPos=" + this.mUiRequest.pcmForVadPos + " " + this.mUiRequest.hashCode());
            c.a a16 = this.processor.a(bArr, 0, length);
            if (a16.f262208a == 0 && tranBean.isLast) {
                a16 = new c.a(new byte[2], 2);
            }
            writeToTmpFile(tranBean, a16);
            if (this.mFirstPieceMd5.isEmpty()) {
                byte[] fileMd5 = getFileMd5(tranBean.filePath, this.mUiRequest.toSendData.length);
                this.mLocalPieceMd5 = fileMd5;
                String bytes2HexStr = HexUtil.bytes2HexStr(fileMd5);
                this.mFirstPieceMd5 = bytes2HexStr;
                if (TextUtils.isEmpty(bytes2HexStr)) {
                    this.mFirstPieceMd5 = System.currentTimeMillis() + "";
                } else {
                    QLog.w(TAG, 1, "get file md5 error!");
                }
            }
            tranBean.md5 = this.mFirstPieceMd5;
            tranBean.voiceId = this.mUiRequest.resIdStr;
            this.mCurInfo = tranBean;
            submitSlice(tranBean, 0);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    private void submitSlice(SmartPttTranHelper.PttSliceInfoBean pttSliceInfoBean, int i3) {
        if (i3 == 0) {
            if (pttSliceInfoBean.isfirst) {
                QLog.d(TAG, 2, "[submitSlice] clear");
                pendingRequestsCache.clear();
            }
            pendingRequestsCache.put(Integer.valueOf(pttSliceInfoBean.offset), pttSliceInfoBean);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "submitSlice, info:" + pttSliceInfoBean);
        }
        ITransactionCallback iTransactionCallback = new ITransactionCallback(SystemClock.uptimeMillis()) { // from class: com.tencent.mobileqq.transfile.PttSilkSliceUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = r6;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PttSilkSliceUploadProcessor.this, Long.valueOf(r6));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i16, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i16), bArr, hashMap);
                    return;
                }
                QLog.w(PttSilkSliceUploadProcessor.TAG, 1, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (SystemClock.uptimeMillis() - this.val$startTime) + "ms retCode=" + i16);
                if (PttSilkSliceUploadProcessor.this.mCurInfo != null && PttSilkSliceUploadProcessor.this.mCurInfo.filePath != null) {
                    new File(PttSilkSliceUploadProcessor.this.mCurInfo.filePath).delete();
                }
                PttSilkSliceUploadProcessor pttSilkSliceUploadProcessor = PttSilkSliceUploadProcessor.this;
                FileMsg fileMsg = pttSilkSliceUploadProcessor.file;
                fileMsg.fileType = FileMsg.TRANSFILE_TYPE_PTT_SILK_SLICE_TO_TEXT;
                fileMsg.commandId = 68;
                fileMsg.errorCode = i16;
                fileMsg.errorMessage = "<BDH_LOG> Transaction End : Failed";
                fileMsg.bdhExtendInfo = bArr;
                ProcessorReport processorReport = pttSilkSliceUploadProcessor.mProcessorReport;
                processorReport.setError(i16, "OnFailed.", "", processorReport.mStepTrans);
                PttSilkSliceUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(PttSilkSliceUploadProcessor.TAG, 2, "onSuccess SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms");
                }
                if (PttSilkSliceUploadProcessor.this.mCurInfo != null && PttSilkSliceUploadProcessor.this.mCurInfo.filePath != null) {
                    new File(PttSilkSliceUploadProcessor.this.mCurInfo.filePath).delete();
                }
                PttSilkSliceUploadProcessor.this.handleSuceess(bArr);
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(PttSilkSliceUploadProcessor.TAG, 2, "<BDH_LOG> onTransStart()");
                }
                PttSilkSliceUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i16);
                } else if (QLog.isColorLevel()) {
                    QLog.d(PttSilkSliceUploadProcessor.TAG, 2, "onUpdateProgress transferedSize:" + i16);
                }
            }
        };
        String currentAccountUin = this.app.getCurrentAccountUin();
        String str = pttSliceInfoBean.filePath;
        this.trans = new Transaction(currentAccountUin, 68, str, 0, getMd5(str), iTransactionCallback, SmartPttTranHelper.getSmartPttReqBody(pttSliceInfoBean).toByteArray(), false);
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.trans);
        if (i3 < 2) {
            SttRunnable sttRunnable = new SttRunnable(this, pttSliceInfoBean, i3);
            this.sttRunnable = sttRunnable;
            ThreadManagerV2.executeDelay(sttRunnable, 128, null, true, 2000L);
            QLog.i(TAG, 1, "[submitSlice] post resend checker.");
        } else if (pttSliceInfoBean.isLast) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.transfile.c
                @Override // java.lang.Runnable
                public final void run() {
                    PttSilkSliceUploadProcessor.this.lambda$submitSlice$0();
                }
            }, 128, null, true, 2000L);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " bean:" + pttSliceInfoBean + " Cmd:");
        }
        if (submitTransactionTask != 0) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(submitTransactionTask, "SubmitError.", "", processorReport.mStepTrans);
            onError();
        }
    }

    private void writeToTmpFile(SmartPttTranHelper.PttSliceInfoBean pttSliceInfoBean, c.a aVar) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    File file = new File(pttSliceInfoBean.filePath);
                    if (file.exists()) {
                        file.delete();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        boolean z16 = pttSliceInfoBean.isfirst;
                        if (z16 && pttSliceInfoBean.isLast) {
                            fileOutputStream2.write(HEAD);
                            offset = 0;
                        } else if (pttSliceInfoBean.isLast) {
                            offset = 0;
                        } else if (z16) {
                            byte[] bArr = HEAD;
                            fileOutputStream2.write(bArr);
                            offset = aVar.f262208a + bArr.length;
                        } else {
                            offset += aVar.f262208a;
                        }
                        fileOutputStream2.write(aVar.f262210c, aVar.f262209b, aVar.f262208a);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e18) {
                    e = e18;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e19) {
            e19.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int cancel = super.cancel();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cancel");
        }
        Transaction transaction = this.trans;
        if (transaction != null) {
            transaction.cancelTransaction();
        }
        ThreadManagerV2.removeJobFromThreadPool(this.sttRunnable, 128);
        return cancel;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0035 -> B:8:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    byte[] getMd5(String str) {
        FileInputStream fileInputStream;
        byte[] hexStr2Bytes;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    try {
                        try {
                            hexStr2Bytes = MD5.toMD5Byte(fileInputStream, this.file.fileSize);
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "getMd5  fail e=" + e);
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return bArr;
                    }
                } catch (UnsatisfiedLinkError unused) {
                    File file = new File(str);
                    if (file.exists()) {
                        try {
                            String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                            if (d16 == null) {
                                d16 = "";
                            }
                            hexStr2Bytes = HexUtil.hexStr2Bytes(d16);
                        } catch (IOException unused2) {
                        }
                    }
                }
                bArr = hexStr2Bytes;
                fileInputStream.close();
            } catch (IOException e18) {
                e = e18;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getMd5  sus md5=" + HexUtil.bytes2HexStr(bArr));
        }
        return bArr;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        TransferRequest transferRequest = this.mUiRequest;
        byte[] bArr = transferRequest.toSendData;
        if (bArr != null && bArr.length != 0) {
            this.voiceID = transferRequest.resIdStr;
            com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = new com.tencent.mobileqq.qqaudio.audioprocessor.b();
            this.processor = bVar;
            bVar.c(new SilkCodecWrapper(BaseApplication.getContext()));
            try {
                this.processor.b(16000, 16000, 1);
            } catch (IOException e16) {
                QLog.e(TAG, 1, "[start] exception. " + e16, e16);
                e16.printStackTrace();
            }
            processSilkData();
            return;
        }
        this.mProcessorReport.setError(9042, "No pcm source", null, null);
        onError();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[start] empty data:");
        if (bArr == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(" uiRequest:");
        sb5.append(this.mUiRequest.hashCode());
        sb5.append(" pcmForVadPos:");
        sb5.append(this.mUiRequest.pcmForVadPos);
        QLog.w(TAG, 1, sb5.toString());
    }
}
