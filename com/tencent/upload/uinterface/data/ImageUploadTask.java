package com.tencent.upload.uinterface.data;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadPicInfoRsp;
import FileUpload.stPoi;
import FileUpload.stWaterTemplate;
import SLICE_UPLOAD.cnst.appid_photo;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.report.ReportManager;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    public static final int IMAGE_QUALITY_HIGH = 2;
    public static final int IMAGE_QUALITY_ORIGIN = 3;
    private static final String TAG = "ImageUploadTask";
    public boolean autoRotate;
    public boolean bWaterType;
    public String clientFakeKey;
    public long compressEndTime;
    public long compressStartTime;
    public String exifTime;
    public int iAlbumTypeID;
    public long iBatchID;
    public int iBitmap;
    public int iBusiNessType;
    public int iDistinctUse;
    public int iUpPicType;
    public int iUploadType;
    public boolean isCover;
    public boolean isHead;
    public HashMap<String, byte[]> mExternalByteData;
    public HashMap<String, String> mapExt;
    public MultiPicInfo mutliPicInfo;
    public boolean needBatch;
    public String sAlbumID;
    public String sAlbumName;
    public String sPicDesc;
    public String sPicTitle;
    public String srcVideoPath;
    public PicExtendInfo stExtendInfo;
    public HashMap<String, String> stExternalMapExt;
    public stPoi uploadPoi;
    public byte[] vBusiNessData;
    public String waterTemplateId;
    public String watermarkPoiName;

    public ImageUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.autoRotate = false;
        this.bWaterType = false;
        this.sPicTitle = "";
        this.sPicDesc = "";
        this.sAlbumName = "";
        this.sAlbumID = "";
        this.iAlbumTypeID = 0;
        this.iBitmap = 0;
        this.iUploadType = 0;
        this.iUpPicType = 0;
        this.iBatchID = 0L;
        this.mutliPicInfo = null;
        this.stExtendInfo = null;
        this.iDistinctUse = 0;
        this.uploadPoi = null;
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
        this.stExternalMapExt = null;
        this.mapExt = null;
        this.exifTime = "";
        this.needBatch = true;
        this.mExternalByteData = null;
        this.mKeepFileAfterUpload = false;
    }

    private boolean isValidImageFile() {
        boolean z16;
        SoftReference softReference = new SoftReference(new byte[0]);
        IUploadConfig.UploadImageSize decodeBitmapSize = ImageProcessUtil.decodeBitmapSize(this.uploadFilePath);
        if (softReference.get() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (decodeBitmapSize.height <= 0 || decodeBitmapSize.width <= 0) {
            return false;
        }
        return z16;
    }

    private String safeString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            return JceEncoder.encode(createUploadPicInfoReq());
        } catch (Throwable th5) {
            UploadLog.e(TAG, "buildExtra " + th5.toString());
            return null;
        }
    }

    public UploadPicInfoReq createUploadPicInfoReq() {
        Map<String, String> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (UploadPicInfoReq) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        UploadPicInfoReq uploadPicInfoReq = new UploadPicInfoReq();
        uploadPicInfoReq.sPicTitle = StringUtils.getEmptyString(this.sPicTitle);
        uploadPicInfoReq.sPicDesc = StringUtils.getEmptyString(this.sPicDesc);
        uploadPicInfoReq.sAlbumID = StringUtils.getEmptyString(this.sAlbumID);
        uploadPicInfoReq.sAlbumName = StringUtils.getEmptyString(this.sAlbumName);
        uploadPicInfoReq.iAlbumTypeID = this.iAlbumTypeID;
        uploadPicInfoReq.iBitmap = this.iBitmap;
        uploadPicInfoReq.iUploadType = this.iUploadType;
        uploadPicInfoReq.iUpPicType = this.iUpPicType;
        uploadPicInfoReq.iBatchID = this.iBatchID;
        uploadPicInfoReq.mutliPicInfo = this.mutliPicInfo;
        uploadPicInfoReq.mapExt = this.mapExt;
        if (this.stExtendInfo == null) {
            this.stExtendInfo = new PicExtendInfo();
        }
        uploadPicInfoReq.stExtendInfo = this.stExtendInfo;
        uploadPicInfoReq.stExternalMapExt = this.stExternalMapExt;
        if (this.isCover && !TextUtils.isEmpty(this.srcVideoPath)) {
            uploadPicInfoReq.sPicPath = this.srcVideoPath;
        } else {
            uploadPicInfoReq.sPicPath = getOriginalUploadFilePath();
        }
        IUploadConfig.UploadImageSize decodeBitmapSize = ImageProcessUtil.decodeBitmapSize(this.uploadFilePath);
        uploadPicInfoReq.iPicWidth = decodeBitmapSize.width;
        uploadPicInfoReq.iPicHight = decodeBitmapSize.height;
        uploadPicInfoReq.iWaterType = this.bWaterType ? 1 : 0;
        PicExtendInfo picExtendInfo = uploadPicInfoReq.stExtendInfo;
        if (picExtendInfo == null) {
            map = null;
        } else {
            map = picExtendInfo.mapExif;
        }
        if (map != null) {
            String str = map.get(UploadConfiguration.getExifTagCode("Make"));
            String str2 = "";
            if (str == null) {
                str = "";
            }
            uploadPicInfoReq.sExif_CameraMaker = str;
            String str3 = map.get(UploadConfiguration.getExifTagCode("Model"));
            if (str3 == null) {
                str3 = "";
            }
            uploadPicInfoReq.sExif_CameraModel = str3;
            String str4 = map.get(UploadConfiguration.getExifTagCode("GPSLatitude"));
            if (str4 == null) {
                str4 = "";
            }
            uploadPicInfoReq.sExif_Latitude = str4;
            String str5 = map.get(UploadConfiguration.getExifTagCode("GPSLatitudeRef"));
            if (str5 == null) {
                str5 = "";
            }
            uploadPicInfoReq.sExif_LatitudeRef = str5;
            String str6 = map.get(UploadConfiguration.getExifTagCode("GPSLongitude"));
            if (str6 == null) {
                str6 = "";
            }
            uploadPicInfoReq.sExif_Longitude = str6;
            String str7 = map.get(UploadConfiguration.getExifTagCode("GPSLongitudeRef"));
            if (str7 == null) {
                str7 = "";
            }
            uploadPicInfoReq.sExif_LongitudeRef = str7;
            if (this.iUploadType == 3) {
                String str8 = map.get(UploadConfiguration.getExifTagCode("Orientation"));
                try {
                    int parseInt = Integer.parseInt(str8);
                    if (parseInt != 3) {
                        if (parseInt != 6) {
                            if (parseInt != 8) {
                                str8 = "0";
                            } else {
                                str8 = "270";
                            }
                        } else {
                            str8 = "90";
                        }
                    } else {
                        str8 = "180";
                    }
                } catch (NumberFormatException unused) {
                }
                PicExtendInfo picExtendInfo2 = uploadPicInfoReq.stExtendInfo;
                if (picExtendInfo2.mapParams == null) {
                    picExtendInfo2.mapParams = new HashMap();
                }
                Map<String, String> map2 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str8 != null) {
                    str2 = str8;
                }
                map2.put(BasicAnimation.KeyPath.ROTATION, str2);
            }
        }
        uploadPicInfoReq.sExif_Time = this.exifTime;
        uploadPicInfoReq.iUploadTime = this.iUploadTime;
        HashMap hashMap = (HashMap) uploadPicInfoReq.mapExt;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(FSUploadConst.KEY_FAKEFEED_CLIENTKEY, StringUtils.getEmptyString(this.clientFakeKey));
        PicExtendInfo picExtendInfo3 = uploadPicInfoReq.stExtendInfo;
        if (picExtendInfo3 != null && picExtendInfo3.mapParams == null) {
            picExtendInfo3.mapParams = new HashMap();
        }
        if (uploadPicInfoReq.stExtendInfo != null) {
            try {
                String originalUploadFilePath = getOriginalUploadFilePath();
                BitmapFactory.Options decodeBitmapOptions = ImageProcessUtil.decodeBitmapOptions(originalUploadFilePath);
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_width", Integer.toString(decodeBitmapOptions.outWidth));
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_height", Integer.toString(decodeBitmapOptions.outHeight));
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_size", Long.toString(new File(originalUploadFilePath).length()));
                uploadPicInfoReq.stExtendInfo.mapParams.put("geo_x", safeString(this.stExtendInfo.mapParams.get("geo_x")));
                uploadPicInfoReq.stExtendInfo.mapParams.put("geo_y", safeString(this.stExtendInfo.mapParams.get("geo_y")));
                uploadPicInfoReq.stExtendInfo.mapParams.put("geo_id", safeString(this.stExtendInfo.mapParams.get("geo_id")));
                uploadPicInfoReq.stExtendInfo.mapParams.put("geo_idname", safeString(this.stExtendInfo.mapParams.get("geo_idname")));
                uploadPicInfoReq.stExtendInfo.mapParams.put("geo_name", safeString(this.stExtendInfo.mapParams.get("geo_name")));
                uploadPicInfoReq.stExtendInfo.mapParams.put("show_geo", safeString(this.stExtendInfo.mapParams.get("show_geo")));
            } catch (Exception unused2) {
            }
        }
        hashMap.put("appid", this.mAppid);
        byte[] bArr = this.vLoginData;
        if (bArr != null && bArr.length > 0) {
            hashMap.put("a2_key", new String(bArr));
        }
        if (!TextUtils.isEmpty(this.uiRefer)) {
            hashMap.put("refer", this.uiRefer);
        }
        uploadPicInfoReq.mapExt = hashMap;
        uploadPicInfoReq.iDistinctUse = this.iDistinctUse;
        uploadPicInfoReq.uploadPoi = this.uploadPoi;
        uploadPicInfoReq.waterTemplate = new stWaterTemplate(this.waterTemplateId, this.watermarkPoiName);
        int i3 = this.iBusiNessType;
        uploadPicInfoReq.iBusiNessType = i3;
        if (i3 == 1) {
            byte[] bArr2 = this.vBusiNessData;
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            uploadPicInfoReq.vBusiNessData = bArr2;
        } else {
            uploadPicInfoReq.vBusiNessData = new byte[0];
        }
        uploadPicInfoReq.ExternalData = this.mExternalByteData;
        return uploadPicInfoReq;
    }

    public long getCompressTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        long j3 = this.compressEndTime;
        if (j3 != 0) {
            long j16 = this.compressStartTime;
            if (j16 != 0) {
                return j3 - j16;
            }
        }
        return 0L;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.BaseTask
    public Const.FileType getFileType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Const.FileType) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return Const.FileType.Photo;
    }

    public final String getOriginalUploadFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mFilePath;
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.isHead) {
            return TaskTypeConfig.HeadUploadTaskType;
        }
        return TaskTypeConfig.ImageUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!this.mKeepFileAfterUpload) {
            UploadLog.d(TAG, "onDestroy taskId=" + getTaskId() + ", delete tmpFile=" + this.mTmpUploadPath);
            FileUtils.deleteTempFile(this.mTmpUploadPath);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        String stackTraceString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
            return;
        }
        UploadLog.d(TAG, "ImageUploadTask put <" + this.mOriginFilePath + "," + this.mSessionId + ">");
        SessionPool.recordSessionId(this.mOriginFilePath, this.mSessionId);
        UploadPicInfoRsp uploadPicInfoRsp = null;
        if (!this.isHead && bArr != null && bArr.length > 0) {
            try {
                stackTraceString = null;
                uploadPicInfoRsp = (UploadPicInfoRsp) JceEncoder.decode(UploadPicInfoRsp.class, bArr);
            } catch (Exception e16) {
                stackTraceString = Log.getStackTraceString(e16);
                UploadLog.w(TAG, "get rsp ", e16);
            }
            if (uploadPicInfoRsp == null) {
                if (stackTraceString == null) {
                    bArr.toString();
                }
                Const.UploadRetCode uploadRetCode = Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE;
                onError(uploadRetCode.getCode(), "(" + uploadRetCode.getCode() + ")" + uploadRetCode.getDesc());
                return;
            }
        }
        if (uploadPicInfoRsp == null) {
            uploadPicInfoRsp = new UploadPicInfoRsp();
        }
        ImageUploadResult imageUploadResult = new ImageUploadResult(this.iUin, this.flowId, this.iBatchID, uploadPicInfoRsp);
        imageUploadResult.sessionId = this.mSessionId;
        UploadLog.d(TAG, "onUploadSucceed flowid = " + this.flowId + " filepath = " + this.mFilePath);
        onUploadSucceed(imageUploadResult);
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask, com.tencent.upload.task.BaseTask
    public void report(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str);
            return;
        }
        super.report(i3, str);
        if (!this.mReported) {
            if (isUseNewTaskReport()) {
                taskReport(getReportObj());
            } else {
                ReportManager.getInstance().report(this);
            }
            this.mReported = true;
        }
    }

    public ImageUploadTask(boolean z16, String str) {
        this(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            return;
        }
        this.isHead = z16;
        this.mAppid = appid_photo.value;
        this.mNeedBatch = this.needBatch;
    }
}
