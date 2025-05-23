package com.tencent.upload.uinterface.data;

import FileUpload.MultiPicInfo;
import FileUpload.UploadUppInfoV2Req;
import FileUpload.UploadUppInfoV2Rsp;
import FileUpload.stPhotoSepcInfo;
import SLICE_UPLOAD.cnst.appid_qun;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QunUppUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    public static final String QunUppAppId = "";
    private static final String TAG = "QunUppUploadTask";
    public String A2;
    public String albumId;
    public String appId;
    public boolean autoRotate;
    public long batchId;
    public String clientFakeKey;
    public String desc;
    public String deviceInfo;
    public int iUploadType;
    public MultiPicInfo mutipic;
    public long photoHeight;
    public long photoSize;
    public long photoType;
    public long photoWidth;
    public String picPath;
    public String poiName;
    public int poiType;
    public String poiX;
    public String poiY;
    public String title;
    public int type;
    public long uploadIp;
    public String userId;

    public QunUppUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.iUploadType = 0;
        this.autoRotate = false;
        this.appId = "";
        this.userId = "";
        this.albumId = "";
        this.title = "";
        this.desc = "";
        this.type = 0;
        this.uploadIp = 0L;
        this.photoSize = 0L;
        this.photoWidth = 0L;
        this.photoHeight = 0L;
        this.photoType = 0L;
        this.deviceInfo = "";
        this.poiX = "";
        this.poiY = "";
        this.poiName = "";
        this.poiType = 0;
        this.picPath = "";
        this.batchId = 0L;
    }

    private final UploadUppInfoV2Req getDescriptionObject(QunUppUploadTask qunUppUploadTask) {
        UploadUppInfoV2Req uploadUppInfoV2Req = new UploadUppInfoV2Req();
        uploadUppInfoV2Req.sAppId = appid_qun.value;
        uploadUppInfoV2Req.sUserId = qunUppUploadTask.userId;
        uploadUppInfoV2Req.sAlbumId = qunUppUploadTask.albumId;
        uploadUppInfoV2Req.sTitle = qunUppUploadTask.title;
        uploadUppInfoV2Req.sDesc = qunUppUploadTask.desc;
        uploadUppInfoV2Req.sPicPath = qunUppUploadTask.uploadFilePath;
        uploadUppInfoV2Req.iType = 0;
        uploadUppInfoV2Req.iUploadIp = 1L;
        uploadUppInfoV2Req.iBatchID = qunUppUploadTask.batchId;
        stPhotoSepcInfo stphotosepcinfo = new stPhotoSepcInfo();
        File file = new File(qunUppUploadTask.uploadFilePath);
        stphotosepcinfo.iPhotoSize = file.length();
        IUploadConfig.UploadImageSize decodeBitmapSize = ImageProcessUtil.decodeBitmapSize(qunUppUploadTask.uploadFilePath);
        stphotosepcinfo.iPhotoWidth = decodeBitmapSize.width;
        stphotosepcinfo.iPhotoHeight = decodeBitmapSize.height;
        stphotosepcinfo.iPhotoType = qunUppUploadTask.photoType;
        uploadUppInfoV2Req.PhotoSpecInfo = stphotosepcinfo;
        uploadUppInfoV2Req.mutlipicinfo = qunUppUploadTask.mutipic;
        HashMap hashMap = new HashMap();
        hashMap.put("sFileMD5", FileUtils.getMd5ByFile_REAL(file));
        hashMap.put("sFirm", qunUppUploadTask.deviceInfo);
        hashMap.put("dLongitude", qunUppUploadTask.poiX);
        hashMap.put("dLatitude", qunUppUploadTask.poiY);
        hashMap.put("sPOIName", qunUppUploadTask.poiName);
        hashMap.put("sPOIType", Integer.toString(qunUppUploadTask.poiType));
        hashMap.put(FSUploadConst.KEY_FAKEFEED_CLIENTKEY, StringUtils.getEmptyString(qunUppUploadTask.clientFakeKey));
        hashMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_2, StringUtils.getEmptyString(qunUppUploadTask.A2));
        uploadUppInfoV2Req.mapExt = hashMap;
        return uploadUppInfoV2Req;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    protected byte[] getControlRequestData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            return ProtocolUtil.pack(getClass().getSimpleName(), this);
        } catch (Exception e16) {
            UploadLog.w(TAG, "getControlRequestData()", e16);
            return null;
        }
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.QunUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        UploadUppInfoV2Rsp uploadUppInfoV2Rsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            return;
        }
        try {
            uploadUppInfoV2Rsp = (UploadUppInfoV2Rsp) ProtocolUtil.unpack(UploadUppInfoV2Rsp.class.getSimpleName(), bArr);
        } catch (Exception e16) {
            UploadLog.w(TAG, "finish", e16);
            uploadUppInfoV2Rsp = null;
        }
        if (uploadUppInfoV2Rsp == null) {
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "unpack PhotoWallUploadResult==null. " + bArr);
            return;
        }
        IUploadTaskCallback iUploadTaskCallback = this.uploadTaskCallback;
        if (iUploadTaskCallback != null) {
            QunUppUploadResult qunUppUploadResult = new QunUppUploadResult();
            qunUppUploadResult.flowId = this.flowId;
            qunUppUploadResult.url = uploadUppInfoV2Rsp.sUrl;
            qunUppUploadResult.photoId = uploadUppInfoV2Rsp.sPhotoId;
            qunUppUploadResult.mapSpecInfo = uploadUppInfoV2Rsp.mapSpecInfo;
            this.uploadTaskCallback.onUploadSucceed(this, qunUppUploadResult);
        } else if (iUploadTaskCallback != null) {
            iUploadTaskCallback.onUploadSucceed(this, null);
        }
        super.processFileUploadFinishRsp(bArr);
    }
}
