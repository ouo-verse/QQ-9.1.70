package com.tencent.upload.uinterface.data;

import NS_COMM_UPLOAD_PROTOCOL.CUploadDownstream;
import NS_COMM_UPLOAD_PROTOCOL.CUploadUpstream;
import SLICE_UPLOAD.UploadTouchuanReq;
import SLICE_UPLOAD.cnst.appid_touchuan;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AudioStreamUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AudioStreamUploadTask";
    private int mBusiType;
    private byte[] mExtra;
    private int mFileType;

    public AudioStreamUploadTask(String str, int i3, int i16, byte[] bArr) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
            return;
        }
        this.mBusiType = i3;
        this.mFileType = i16;
        this.mExtra = bArr;
        this.mAppid = appid_touchuan.value;
        this.iSync = 0;
    }

    private byte[] getAudioStreamData() {
        CUploadUpstream cUploadUpstream = new CUploadUpstream();
        cUploadUpstream.busiType = this.mBusiType;
        cUploadUpstream.fileType = this.mFileType;
        cUploadUpstream.extra = this.mExtra;
        try {
            return JceEncoder.encode(cUploadUpstream);
        } catch (Exception e16) {
            UploadLog.w(TAG, e16);
            byte[] buildExtra = super.buildExtra();
            UploadLog.w(TAG, "buildExtra() failed", e16);
            return buildExtra;
        }
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        UploadTouchuanReq uploadTouchuanReq = new UploadTouchuanReq();
        uploadTouchuanReq.iUploadType = getUploadTaskType().uploadType;
        uploadTouchuanReq.vReqData = getAudioStreamData();
        return JceEncoder.encode(uploadTouchuanReq);
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return TaskTypeConfig.AudioStreamUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.mKeepFileAfterUpload) {
            FileUtils.deleteTempFile(this.mFilePath);
        }
        CacheUtil.deleteSessionId(this, this.mSessionId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        String stackTraceString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            return;
        }
        CUploadDownstream cUploadDownstream = null;
        try {
            stackTraceString = null;
            cUploadDownstream = (CUploadDownstream) JceEncoder.decode(CUploadDownstream.class, bArr);
        } catch (Exception e16) {
            stackTraceString = Log.getStackTraceString(e16);
            UploadLog.w(TAG, e16);
        }
        if (cUploadDownstream == null) {
            if (stackTraceString == null) {
                stackTraceString = "\u97f3\u9891\u4e0a\u4f20\u56de\u5305\u89e3\u6790\u51fa\u9519\uff01";
            }
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "errorMsg = " + stackTraceString);
            return;
        }
        onUploadSucceed(cUploadDownstream);
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }
}
