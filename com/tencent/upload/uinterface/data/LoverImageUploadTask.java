package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.UploadTouchuanReq;
import SLICE_UPLOAD.cnst.appid_touchuan;
import SWU.SWUploadPicReq;
import SWU.SWUploadPicRsp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.ProtocolUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LoverImageUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LoverImageUploadTask";
    private int iRetCode;
    public int iUploadType;
    public String mAddress;
    public String mAlbumID;
    public String mAppVersion;
    public long mBatchID;
    public String mClientip;
    public int mCurPicNum;
    public String mDeviceID;
    public int mFromQZone;
    public int mIsShareFeeds;
    public String mLocalid;
    public String mOs;
    public String mOsVersion;
    public String mPicDesc;
    public int mPicHight;
    public String mPicTitle;
    public String mPicUrl;
    public int mPicWidth;
    public int mPictotalNum;
    public int mPictureType;
    public String mUserAgent;

    public LoverImageUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.iUploadType = 0;
        this.iRetCode = 0;
        this.mPicTitle = "";
        this.mPicDesc = "";
        this.mAlbumID = "";
        this.mBatchID = 0L;
        this.mPictureType = 0;
        this.mPicWidth = 0;
        this.mPicHight = 0;
        this.mClientip = "";
        this.mIsShareFeeds = 0;
        this.mUserAgent = "";
        this.mAddress = "";
        this.mPictotalNum = 0;
        this.mCurPicNum = 0;
        this.mFromQZone = 0;
        this.mPicUrl = "";
        this.mLocalid = "";
        this.mOs = "";
        this.mDeviceID = "";
        this.mOsVersion = "";
        this.mAppVersion = "";
        this.mAppid = appid_touchuan.value;
    }

    private byte[] getSWUploadPicReq() {
        SWUploadPicReq sWUploadPicReq = new SWUploadPicReq();
        sWUploadPicReq.sPicTitle = this.mPicTitle;
        sWUploadPicReq.sPicDesc = this.mPicDesc;
        sWUploadPicReq.eUseType = 3;
        sWUploadPicReq.sAlbumID = this.mAlbumID;
        sWUploadPicReq.iBatchID = this.mBatchID;
        sWUploadPicReq.eFileType = this.mPictureType;
        sWUploadPicReq.sPicPath = this.uploadFilePath;
        sWUploadPicReq.iPicWidth = this.mPicWidth;
        sWUploadPicReq.iPicHight = this.mPicHight;
        sWUploadPicReq.sClientip = this.mClientip;
        sWUploadPicReq.isShareFeeds = this.mIsShareFeeds;
        sWUploadPicReq.sUserAgent = this.mUserAgent;
        sWUploadPicReq.sAddress = this.mAddress;
        sWUploadPicReq.iPictotalNum = this.mPictotalNum;
        sWUploadPicReq.iCurPicNum = this.mCurPicNum;
        sWUploadPicReq.iFromQZone = this.mFromQZone;
        sWUploadPicReq.pic_url = this.mPicUrl;
        sWUploadPicReq.keyType = 64;
        sWUploadPicReq.wnskey = this.vLoginData;
        sWUploadPicReq.localid = this.mLocalid;
        sWUploadPicReq.f25099os = this.mOs;
        sWUploadPicReq.device = this.mDeviceID;
        sWUploadPicReq.osver = this.mOsVersion;
        sWUploadPicReq.ver = this.mAppVersion;
        sWUploadPicReq.duration = "0.0";
        sWUploadPicReq.itemid = "0";
        sWUploadPicReq.emojitype = "0";
        byte[] bArr = new byte[0];
        try {
            return ProtocolUtil.pack(SWUploadPicReq.class.getSimpleName(), sWUploadPicReq);
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
        uploadTouchuanReq.vReqData = getSWUploadPicReq();
        return JceEncoder.encode(uploadTouchuanReq);
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.LoverImageUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        SWUploadPicRsp sWUploadPicRsp = new SWUploadPicRsp();
        int i3 = this.iRetCode;
        sWUploadPicRsp.iCode = i3;
        if (i3 != 0) {
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "iRetCode = " + this.iRetCode);
            return;
        }
        LoverImageUploadResult loverImageUploadResult = new LoverImageUploadResult();
        loverImageUploadResult.code = sWUploadPicRsp.iCode;
        loverImageUploadResult.albumId = sWUploadPicRsp.sAlbumID;
        loverImageUploadResult.flowId = this.flowId;
        loverImageUploadResult.height = sWUploadPicRsp.iHeight;
        loverImageUploadResult.width = sWUploadPicRsp.iWidth;
        loverImageUploadResult.name = sWUploadPicRsp.sName;
        loverImageUploadResult.photoId = sWUploadPicRsp.sPhotoID;
        loverImageUploadResult.picType = sWUploadPicRsp.ePicType;
        loverImageUploadResult.uploadTs = sWUploadPicRsp.iUploadTs;
        loverImageUploadResult.url = sWUploadPicRsp.sURL;
        onUploadSucceed(loverImageUploadResult);
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }
}
