package com.tencent.upload.uinterface.data;

import FileUpload.UploadVideoInfoReq;
import FileUpload.UploadVideoInfoRsp;
import SLICE_UPLOAD.cnst.appid_video;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.ReportManager;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import v4.b;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoUploadTask";
    public Map<String, String> extend_info;
    public int iBusiNessType;
    public int iFlag;
    public int iIsFormatF20;
    public int iIsNew;
    public int iIsOriginalVideo;
    public int iPlayTime;
    private int iVideoH;
    private int iVideoW;
    public String mClientKey;
    public String sCoverUrl;
    public String sDesc;
    public String sTitle;
    public byte[] vBusiNessData;

    public VideoUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.sTitle = "";
        this.sDesc = "";
        this.iFlag = 0;
        this.sCoverUrl = "";
        this.iPlayTime = 0;
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
        this.iIsOriginalVideo = 0;
        this.iIsFormatF20 = 0;
        this.mClientKey = "";
        this.mAppid = appid_video.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    private void initVideoSize() {
        String str = TAG;
        if (TextUtils.isEmpty(this.uploadFilePath) || !new File(this.uploadFilePath).exists()) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int i3 = 0;
        try {
            try {
                mediaMetadataRetriever.setDataSource(this.uploadFilePath);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                try {
                    this.iVideoW = Integer.parseInt(extractMetadata);
                    this.iVideoH = Integer.parseInt(extractMetadata2);
                    ?? intValue = Integer.valueOf(extractMetadata3).intValue();
                    i3 = intValue;
                    str = intValue;
                } catch (NumberFormatException e16) {
                    this.iVideoW = 0;
                    this.iVideoH = 0;
                    UploadLog.w(TAG, "Video size is not number format...", e16);
                    str = str;
                }
            } catch (Throwable th5) {
                mediaMetadataRetriever.release();
                throw th5;
            }
        } catch (Exception e17) {
            UploadLog.w(str, "MediaMetadataRetriever exception", e17);
        }
        mediaMetadataRetriever.release();
        if (i3 % 180 != 0) {
            int i16 = this.iVideoH;
            this.iVideoH = this.iVideoW;
            this.iVideoW = i16;
        }
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        initVideoSize();
        UploadVideoInfoReq uploadVideoInfoReq = new UploadVideoInfoReq();
        uploadVideoInfoReq.sTitle = this.sTitle;
        uploadVideoInfoReq.sDesc = this.sDesc;
        uploadVideoInfoReq.iFlag = this.iFlag;
        uploadVideoInfoReq.iIsNew = this.iIsNew;
        uploadVideoInfoReq.iUploadTime = this.iUploadTime;
        uploadVideoInfoReq.sCoverUrl = this.sCoverUrl;
        uploadVideoInfoReq.iPlayTime = this.iPlayTime;
        byte[] bArr = this.vBusiNessData;
        if (bArr == null) {
            bArr = new byte[0];
        }
        uploadVideoInfoReq.vBusiNessData = bArr;
        uploadVideoInfoReq.iBusiNessType = this.iBusiNessType;
        uploadVideoInfoReq.iIsOriginalVideo = this.iIsOriginalVideo;
        uploadVideoInfoReq.iIsFormatF20 = this.iIsFormatF20;
        Map<String, String> map = this.extend_info;
        uploadVideoInfoReq.extend_info = map;
        uploadVideoInfoReq.width = this.iVideoW;
        uploadVideoInfoReq.height = this.iVideoH;
        if (map == null) {
            uploadVideoInfoReq.extend_info = new HashMap();
        }
        if (!TextUtils.isEmpty(this.mClientKey)) {
            uploadVideoInfoReq.extend_info.put(b.CLIENTKEY, this.mClientKey);
        }
        try {
            return JceEncoder.encode(uploadVideoInfoReq);
        } catch (Exception e16) {
            UploadLog.e(TAG, e16.toString());
            return null;
        }
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.BaseTask
    public Const.FileType getFileType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Const.FileType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return Const.FileType.Video;
    }

    @Override // com.tencent.upload.task.UploadTask
    protected int getMaxNetworkRetryTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 24;
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.VideoUploadTaskType;
    }

    @Override // com.tencent.upload.task.UploadTask
    protected void processBatchControlRsp(byte[] bArr) {
        String stackTraceString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
            return;
        }
        UploadVideoInfoRsp uploadVideoInfoRsp = null;
        try {
            stackTraceString = null;
            uploadVideoInfoRsp = (UploadVideoInfoRsp) JceEncoder.decode(UploadVideoInfoRsp.class, bArr);
        } catch (Exception e16) {
            stackTraceString = Log.getStackTraceString(e16);
            UploadLog.w(TAG, "process finish", e16);
        }
        if (uploadVideoInfoRsp == null) {
            if (stackTraceString == null) {
                stackTraceString = "unpack onBatchControlRsp == null. " + bArr;
            }
            UploadLog.w(TAG, "onBatchControlRsp... " + stackTraceString);
            onSessionReport(new UploadQualityReportBuilder().setExt2(UploadQualityReportBuilder.CONTROL_PKG_DECODE_ERROR));
            return;
        }
        UploadLog.d(TAG, "onBatchControlRsp flowid = " + this.flowId + " vid:" + uploadVideoInfoRsp.sVid + " filepath = " + this.mFilePath);
        VideoUploadResult videoUploadResult = new VideoUploadResult();
        videoUploadResult.flowId = this.flowId;
        videoUploadResult.sVid = uploadVideoInfoRsp.sVid;
        videoUploadResult.iBusiNessType = uploadVideoInfoRsp.iBusiNessType;
        videoUploadResult.vBusiNessData = uploadVideoInfoRsp.vBusiNessData;
        videoUploadResult.isControlPkg = true;
        onBatchControlRsp(videoUploadResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        String stackTraceString;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
            return;
        }
        UploadVideoInfoRsp uploadVideoInfoRsp = null;
        try {
            stackTraceString = null;
            uploadVideoInfoRsp = (UploadVideoInfoRsp) JceEncoder.decode(UploadVideoInfoRsp.class, bArr);
        } catch (Exception e16) {
            stackTraceString = Log.getStackTraceString(e16);
            UploadLog.w(TAG, "process finish", e16);
        }
        if (uploadVideoInfoRsp == null) {
            if (stackTraceString == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("unpack UploadVideoInfoRsp == null. vRspData.length = ");
                if (bArr != null) {
                    i3 = bArr.length;
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                stackTraceString = sb5.toString();
            }
            UploadLog.w(TAG, "processFileUploadFinishRsp... " + stackTraceString);
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE;
            onError(uploadRetCode.getCode(), "(" + uploadRetCode.getCode() + ")" + uploadRetCode.getDesc());
            return;
        }
        UploadLog.d(TAG, "onUploadSucceed flowid = " + this.flowId + " filepath = " + this.mFilePath);
        VideoUploadResult videoUploadResult = new VideoUploadResult();
        videoUploadResult.flowId = this.flowId;
        videoUploadResult.sVid = uploadVideoInfoRsp.sVid;
        videoUploadResult.iBusiNessType = uploadVideoInfoRsp.iBusiNessType;
        videoUploadResult.vBusiNessData = uploadVideoInfoRsp.vBusiNessData;
        onUploadSucceed(videoUploadResult);
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask, com.tencent.upload.task.BaseTask
    public void report(int i3, String str) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
            return;
        }
        super.report(i3, str);
        Report report = this.mReportObj;
        if (this.iIsNew == 1) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        report.source = i16;
        if (!this.mReported) {
            if (isUseNewTaskReport()) {
                taskReport(getReportObj());
            } else {
                ReportManager.report(getReportObj());
            }
            this.mReported = true;
        }
    }

    public void setIsNew(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.iIsNew = i3;
        }
    }
}
