package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.UploadTouchuanReq;
import SLICE_UPLOAD.cnst.appid_touchuan;
import Sound.UploadReq;
import Sound.UploadRsp;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.UploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AudioUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AudioUploadTask";
    public int appid;
    public long client_ip;
    public int format;
    public int voice_length;

    public AudioUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.format = 0;
        this.appid = 0;
        this.voice_length = 0;
        this.client_ip = 0L;
        this.mAppid = appid_touchuan.value;
        this.iSync = 0;
    }

    private byte[] getSoundReq() {
        UploadReq uploadReq = new UploadReq();
        uploadReq.uin = this.iUin;
        uploadReq.appid = this.appid;
        uploadReq.format = this.format;
        uploadReq.voice_length = this.voice_length;
        uploadReq.client_ip = this.client_ip;
        uploadReq.data = new byte[0];
        uploadReq.key_type = 0L;
        uploadReq.key_value = new byte[0];
        uploadReq.server_ip = 0L;
        byte[] bArr = new byte[0];
        try {
            return ProtocolUtil.pack(UploadReq.class.getSimpleName(), uploadReq);
        } catch (Exception e16) {
            e16.printStackTrace();
            return bArr;
        }
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        UploadTouchuanReq uploadTouchuanReq = new UploadTouchuanReq();
        uploadTouchuanReq.iUploadType = getUploadTaskType().uploadType;
        uploadTouchuanReq.vReqData = getSoundReq();
        try {
            return JceEncoder.encode(uploadTouchuanReq);
        } catch (Exception e16) {
            UploadLog.e(TAG, e16.toString());
            return null;
        }
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.AudioUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        String stackTraceString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        UploadRsp uploadRsp = null;
        try {
            stackTraceString = null;
            uploadRsp = (UploadRsp) ProtocolUtil.unpack(UploadRsp.class.getSimpleName(), bArr);
        } catch (Exception e16) {
            stackTraceString = Log.getStackTraceString(e16);
            UploadLog.i(TAG, "processFileUploadFinishRsp", e16);
        }
        if (uploadRsp == null) {
            if (stackTraceString == null) {
                stackTraceString = "unpack UploadRsp == null. " + bArr;
            }
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), stackTraceString);
            return;
        }
        AudioUploadResult audioUploadResult = new AudioUploadResult();
        audioUploadResult.result = uploadRsp.result;
        audioUploadResult.voice_id = uploadRsp.voice_id;
        audioUploadResult.flowId = this.flowId;
        audioUploadResult.voice_length = this.voice_length;
        onUploadSucceed(audioUploadResult);
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }
}
