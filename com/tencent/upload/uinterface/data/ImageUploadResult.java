package com.tencent.upload.uinterface.data;

import FileUpload.UploadPicInfoRsp;
import FileUpload.stWaterTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public long iBatchID;
    public int iBusiNessType;
    public int iHeight;
    public int iOriHeight;
    public int iOriWidth;
    public int iPicType;
    public long iUin;
    public int iWidth;
    public String imageFilePath;
    public UploadPicInfoRsp rsp;
    public String sAdaptUrl_1000;
    public String sAdaptUrl_160;
    public String sAdaptUrl_200;
    public String sAdaptUrl_400;
    public String sAdaptUrl_640;
    public String sAlbumID;
    public String sBURL;
    public String sOriPhotoID;
    public String sOriUrl;
    public String sPhotoID;
    public String sPhotoMD5;
    public String sSURL;
    public String sSloc;
    public byte[] vBusiNessData;
    public stWaterTemplate waterTemplate;

    public ImageUploadResult(long j3, int i3, long j16, UploadPicInfoRsp uploadPicInfoRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), uploadPicInfoRsp);
            return;
        }
        this.sSURL = "";
        this.sBURL = "";
        this.sAlbumID = "";
        this.sPhotoID = "";
        this.sSloc = "";
        this.iWidth = 0;
        this.iHeight = 0;
        this.sOriUrl = "";
        this.iOriWidth = 0;
        this.iOriHeight = 0;
        this.sOriPhotoID = "";
        this.iPicType = 0;
        this.sAdaptUrl_160 = "";
        this.sAdaptUrl_200 = "";
        this.sAdaptUrl_400 = "";
        this.sAdaptUrl_640 = "";
        this.sAdaptUrl_1000 = "";
        this.waterTemplate = null;
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
        this.imageFilePath = "";
        this.sPhotoMD5 = "";
        this.iUin = j3;
        this.iBatchID = j16;
        this.flowId = i3;
        if (uploadPicInfoRsp == null) {
            return;
        }
        this.rsp = uploadPicInfoRsp;
        this.sSURL = uploadPicInfoRsp.sSURL;
        this.sBURL = uploadPicInfoRsp.sBURL;
        this.sAlbumID = uploadPicInfoRsp.sAlbumID;
        this.sPhotoID = uploadPicInfoRsp.sPhotoID;
        this.sSloc = uploadPicInfoRsp.sSloc;
        this.iWidth = uploadPicInfoRsp.iWidth;
        this.iHeight = uploadPicInfoRsp.iHeight;
        this.sOriUrl = uploadPicInfoRsp.sOriUrl;
        this.iOriWidth = uploadPicInfoRsp.iOriWidth;
        this.iOriHeight = uploadPicInfoRsp.iOriHeight;
        this.sOriPhotoID = uploadPicInfoRsp.sOriPhotoID;
        this.iPicType = uploadPicInfoRsp.iPicType;
        this.sAdaptUrl_160 = uploadPicInfoRsp.sAdaptUrl_160;
        this.sAdaptUrl_200 = uploadPicInfoRsp.sAdaptUrl_200;
        this.sAdaptUrl_400 = uploadPicInfoRsp.sAdaptUrl_400;
        this.sAdaptUrl_640 = uploadPicInfoRsp.sAdaptUrl_640;
        this.sAdaptUrl_1000 = uploadPicInfoRsp.sAdaptUrl_1000;
        this.waterTemplate = uploadPicInfoRsp.waterTemplate;
        this.iBusiNessType = uploadPicInfoRsp.iBusiNessType;
        this.vBusiNessData = uploadPicInfoRsp.vBusiNessDataRsp;
        this.sPhotoMD5 = uploadPicInfoRsp.sPhotoMD5;
    }
}
