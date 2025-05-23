package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
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
import com.wx.voice.vad.WXVadSeg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import tencent.im.cs.smartptt.Smartptt$RspBody;

/* loaded from: classes19.dex */
public class PttSliceUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final int BLOCK_SIZE = 6400;
    private static final float BYTES_MSECOND = 32.0f;
    private static final int BYTES_SECOND = 32000;
    public static final int COMMAND_ID_PTT_SLICE_TRANS = 68;
    private static final byte[] HEAD;
    private static final int SIMPLE_RATE = 16000;
    public static final String TAG = "PttSliceUploadProcessor";
    private SmartPttTranHelper.PttSliceInfoBean mCurInfo;
    private int offset;
    private String pcmPath;
    private com.tencent.mobileqq.qqaudio.audioprocessor.b processor;
    private String result;
    private Transaction trans;
    private long vadSegEndPos;
    private long vadSegStartPos;
    private String voiceID;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45855);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            HEAD = RecordParams.a(1, 16000);
        }
    }

    public PttSliceUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.result = "";
        this.vadSegStartPos = 0L;
        this.vadSegEndPos = 0L;
        this.offset = 0;
    }

    private void checkIsLast(boolean z16, boolean z17) throws IOException {
        if (this.mIsCancel) {
            sendMessageToUpdate(1004);
            return;
        }
        if (z16) {
            sendMessageToUpdate(2003);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendMessageToUpdate send finished!");
                return;
            }
            return;
        }
        processVADSegSlice();
        if (z17) {
            sendMessageToUpdate(2002);
        }
    }

    private void checkNextDataIsValid(SmartPttTranHelper.PttSliceInfoBean pttSliceInfoBean, int i3) throws IOException {
        if (!pttSliceInfoBean.isLast && this.vadSegEndPos - this.vadSegStartPos < 6400) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "last p of seg ");
            }
            long j3 = this.vadSegEndPos;
            long j16 = this.vadSegStartPos;
            byte[] bArr = new byte[(int) (j3 - j16)];
            c.a a16 = this.processor.a(bArr, 0, this.mRaf.read(bArr, 0, (int) (j3 - j16)));
            if (a16 == null || a16.f262208a == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "last p silk len is 0 ");
                }
                pttSliceInfoBean.isLast = true;
                this.offset = 0;
            }
        }
    }

    private File checkPCMFile() {
        File file = new File(this.pcmPath);
        if (!file.exists()) {
            this.mProcessorReport.setError(9042, BaseTransProcessor.getExpStackString(new Exception("sendFile not exist " + this.pcmPath)), null, null);
            onError();
            return null;
        }
        return file;
    }

    private SmartPttTranHelper.PttSliceInfoBean getTranBean() {
        SmartPttTranHelper.PttSliceInfoBean pttSliceInfoBean = new SmartPttTranHelper.PttSliceInfoBean();
        pttSliceInfoBean.voiceId = this.voiceID + this.mUiRequest.pcmForVadPos;
        pttSliceInfoBean.offset = this.offset;
        pttSliceInfoBean.md5 = this.mMd5Str;
        pttSliceInfoBean.chatType = this.mUiRequest.chatType;
        StringBuilder sb5 = new StringBuilder();
        String str = this.mUiRequest.mLocalPath;
        sb5.append(str.substring(0, str.lastIndexOf(File.separator)));
        sb5.append("/tmp_");
        sb5.append(pttSliceInfoBean.voiceId);
        sb5.append("_");
        sb5.append(this.offset);
        sb5.append(".silk");
        pttSliceInfoBean.filePath = sb5.toString();
        pttSliceInfoBean.encodeType = 6;
        if (this.offset == 0) {
            pttSliceInfoBean.isfirst = true;
        } else {
            pttSliceInfoBean.isfirst = false;
        }
        TransferRequest transferRequest = this.mUiRequest;
        pttSliceInfoBean.vegNum = transferRequest.pcmForVadNum;
        pttSliceInfoBean.vegPos = transferRequest.pcmForVadPos;
        return pttSliceInfoBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSuceess(byte[] bArr) {
        boolean z16;
        Smartptt$RspBody smartptt$RspBody = new Smartptt$RspBody();
        try {
            smartptt$RspBody.mergeFrom(bArr);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onSuccess  text =" + smartptt$RspBody.msg_ptttrans_rsp.str_text.get() + " id=" + smartptt$RspBody.msg_ptttrans_rsp.str_voice_id.get() + " pos=" + this.mUiRequest.pcmForVadPos + " uint32_is_final=" + smartptt$RspBody.msg_ptttrans_rsp.uint32_is_final.get());
            }
            FileMsg fileMsg = this.file;
            fileMsg.fileType = FileMsg.TRANSFILE_TYPE_PTT_SLICE_TO_TEXT;
            fileMsg.pttSliceText = this.result + smartptt$RspBody.msg_ptttrans_rsp.str_text.get();
            FileMsg fileMsg2 = this.file;
            fileMsg2.commandId = 68;
            fileMsg2.pttSlicePos = this.mUiRequest.pcmForVadPos;
            if (smartptt$RspBody.msg_ptttrans_rsp.uint32_is_final.get() != 1 && !this.mCurInfo.isLast) {
                z16 = false;
                checkIsLast(z16, true);
                this.mProcessorReport.mStepTrans.logFinishTime();
                this.mProcessorReport.mStepTrans.result = 1;
            }
            z16 = true;
            checkIsLast(z16, true);
            this.mProcessorReport.mStepTrans.logFinishTime();
            this.mProcessorReport.mStepTrans.result = 1;
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    private boolean initRandomFile() {
        if (this.mRaf == null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.pcmPath, "r");
                this.mRaf = randomAccessFile;
                randomAccessFile.seek(0L);
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                this.mRaf = null;
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            if (this.mRaf == null) {
                this.mProcessorReport.setError(9303, "read file error", null, null);
                onError();
                return true;
            }
            return false;
        }
        return false;
    }

    private void processVADSeg() {
        WXVadSeg wXVadSeg = this.mUiRequest.vadSeg;
        if (wXVadSeg != null && (wXVadSeg instanceof WXVadSeg)) {
            this.vadSegStartPos = wXVadSeg.mbtm * 32;
            this.vadSegEndPos = wXVadSeg.metm * 32;
            this.offset = 0;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "generateFileByOneSeg, vadSegStartPos=" + this.vadSegStartPos + " EPS=" + this.vadSegEndPos + " segPos=" + this.mUiRequest.pcmForVadPos + " size=" + this.mUiRequest.pcmForVadNum);
            }
            try {
                this.mRaf.seek(this.vadSegStartPos);
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            processVADSegSlice();
        }
    }

    private void processVADSegSlice() {
        int read;
        byte[] bArr;
        if (this.mIsCancel) {
            return;
        }
        SmartPttTranHelper.PttSliceInfoBean tranBean = getTranBean();
        try {
            long j3 = this.vadSegEndPos;
            long j16 = this.vadSegStartPos;
            if (j3 - j16 > 6400) {
                bArr = new byte[6400];
                read = this.mRaf.read(bArr, 0, 6400);
                this.vadSegStartPos += 6400;
                tranBean.isLast = false;
            } else {
                byte[] bArr2 = new byte[(int) (j3 - j16)];
                read = this.mRaf.read(bArr2, 0, (int) (j3 - j16));
                tranBean.isLast = true;
                this.offset = 0;
                bArr = bArr2;
            }
            checkNextDataIsValid(tranBean, read);
            c.a a16 = this.processor.a(bArr, 0, read);
            if (a16 != null && a16.f262208a != 0) {
                writeToTmpFile(tranBean, a16);
                this.mCurInfo = tranBean;
                submitSlice(tranBean);
                return;
            }
            checkIsLast(tranBean.isLast, false);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    private void submitSlice(SmartPttTranHelper.PttSliceInfoBean pttSliceInfoBean) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "submitSlice, info:" + pttSliceInfoBean);
        }
        ITransactionCallback iTransactionCallback = new ITransactionCallback(SystemClock.uptimeMillis()) { // from class: com.tencent.mobileqq.transfile.PttSliceUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = r6;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PttSliceUploadProcessor.this, Long.valueOf(r6));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), bArr, hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(PttSliceUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms retCode=" + i3);
                }
                if (PttSliceUploadProcessor.this.mCurInfo != null && PttSliceUploadProcessor.this.mCurInfo.filePath != null) {
                    new File(PttSliceUploadProcessor.this.mCurInfo.filePath).delete();
                }
                PttSliceUploadProcessor.this.sendMessageToUpdate(2005);
                PttSliceUploadProcessor pttSliceUploadProcessor = PttSliceUploadProcessor.this;
                pttSliceUploadProcessor.file.bdhExtendInfo = bArr;
                ProcessorReport processorReport = pttSliceUploadProcessor.mProcessorReport;
                processorReport.setError(i3, "OnFailed.", "", processorReport.mStepTrans);
                PttSliceUploadProcessor.this.onError();
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
                    QLog.d(PttSliceUploadProcessor.TAG, 2, "onSuccess SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms");
                }
                if (PttSliceUploadProcessor.this.mCurInfo != null && PttSliceUploadProcessor.this.mCurInfo.filePath != null) {
                    new File(PttSliceUploadProcessor.this.mCurInfo.filePath).delete();
                }
                PttSliceUploadProcessor.this.handleSuceess(bArr);
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
                    QLog.d(PttSliceUploadProcessor.TAG, 2, "<BDH_LOG> onTransStart()");
                }
                PttSliceUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                } else if (QLog.isColorLevel()) {
                    QLog.d(PttSliceUploadProcessor.TAG, 2, "onUpdateProgress transferedSize:" + i3);
                }
            }
        };
        String currentAccountUin = this.app.getCurrentAccountUin();
        String str = pttSliceInfoBean.filePath;
        this.trans = new Transaction(currentAccountUin, 68, str, (int) this.mStartOffset, getMd5(str), iTransactionCallback, SmartPttTranHelper.getSmartPttReqBody(pttSliceInfoBean).toByteArray(), false);
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.trans);
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
                        if (pttSliceInfoBean.isfirst) {
                            byte[] bArr = HEAD;
                            fileOutputStream2.write(bArr);
                            this.offset += aVar.f262208a + bArr.length;
                        } else if (!pttSliceInfoBean.isLast) {
                            this.offset += aVar.f262208a;
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
            } catch (Exception e19) {
                e19.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
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
        File checkPCMFile;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str = this.mUiRequest.pcmForVadPath;
        this.pcmPath = str;
        if (str == null) {
            this.mProcessorReport.setError(9042, "No pcm source", null, null);
            onError();
            return;
        }
        if (this.mLocalMd5 == null && !getMd5()) {
            this.mProcessorReport.setError(9041, "No Local MD5", null, null);
            onError();
            return;
        }
        if (initRandomFile() || (checkPCMFile = checkPCMFile()) == null) {
            return;
        }
        this.mFileSize = checkPCMFile.length();
        this.voiceID = this.mMd5Str;
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = new com.tencent.mobileqq.qqaudio.audioprocessor.b();
        this.processor = bVar;
        bVar.c(new SilkCodecWrapper(BaseApplication.getContext()));
        try {
            this.processor.b(16000, 16000, 1);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        processVADSeg();
    }
}
