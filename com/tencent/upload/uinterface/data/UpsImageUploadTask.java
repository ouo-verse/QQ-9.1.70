package com.tencent.upload.uinterface.data;

import FileUpload.UploadUpsInfoReq;
import FileUpload.UploadUpsInfoRsp;
import SLICE_UPLOAD.cnst.appid_ups;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.BitmapUtils;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UpsImageUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    public static final String BUSINESS_CHAT_IMAGE = "gappchat";
    public static final String BUSINESS_COVER = "mqzonecover";
    public static final String BUSINESS_FACADE = "mqfacade";
    public static final String BUSINESS_FAVOR_PHOTO = "favpic";
    public static final String BUSINESS_LIVE_INTEREACT = "liveintereact";
    public static final String BUSINESS_MESSAGE = "msgboardpic";
    public static final String BUSINESS_SECRET_MOOD = "secretpic";
    public static final String BUSINESS_SHAREALBUM = "qqshare_photo";
    public static final String BUSINESS_SMART_VIDEO_COVER = "micro_video";
    public static final String BUSINESS_TOPIC_GROUP_PHOTO = "topicgroup_pic";
    private static final String TAG = "UpsImageUploadTask";
    public static final int TYPE_COVER = 2;
    public static final int TYPE_FACADE = 5;
    public static final int TYPE_FAVOR_PHOTO = 3;
    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_SECRET_MOOD = 4;
    public static final int TYPE_SHAREALBUM_PHOTO = 1;
    public int dataType;
    public String fileId;
    public long iBatchID;
    public int iBatchUploadCount;
    public int iBusiNessType;
    public int iCurrentUploadOrder;
    public int iUploadType;
    public int keepRaw;
    public Map<String, byte[]> mapExt;
    public String sBusinessId;
    public String sCommand;
    public byte[] vBusiNessData;

    public UpsImageUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.sBusinessId = "";
        this.iUploadType = 0;
        this.mAppid = appid_ups.value;
        this.iSync = 0;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        UploadUpsInfoReq uploadUpsInfoReq = new UploadUpsInfoReq();
        uploadUpsInfoReq.iKeppRaw = this.keepRaw;
        uploadUpsInfoReq.iAppid = this.iAppid;
        uploadUpsInfoReq.iType = this.dataType;
        uploadUpsInfoReq.sFileId = this.fileId;
        uploadUpsInfoReq.sBusinessId = this.sBusinessId;
        uploadUpsInfoReq.vBusiNessData = this.vBusiNessData;
        if (this.iBusiNessType != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        uploadUpsInfoReq.bNotifyWns = (byte) i3;
        uploadUpsInfoReq.iBatchId = this.iBatchID;
        uploadUpsInfoReq.iBatUploadNum = this.iBatchUploadCount;
        uploadUpsInfoReq.iCurUpload = this.iCurrentUploadOrder;
        uploadUpsInfoReq.sWnsCmd = this.sCommand;
        BitmapFactory.Options options = BitmapUtils.getOptions();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.uploadFilePath, options);
        uploadUpsInfoReq.iPicHight = options.outHeight;
        uploadUpsInfoReq.iPicWidth = options.outWidth;
        uploadUpsInfoReq.mapExt = this.mapExt;
        return JceEncoder.encode(uploadUpsInfoReq);
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (UploadGlobalConfig.getConfig().isSwitchOn(Const.SwitchConfigKey.UPS_USE_NEW_STRATEGY)) {
            return TaskTypeConfig.UpsUploadEpollTaskType;
        }
        return TaskTypeConfig.UpsUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            return;
        }
        UploadUpsInfoRsp uploadUpsInfoRsp = null;
        try {
            stackTraceString = null;
            uploadUpsInfoRsp = (UploadUpsInfoRsp) JceEncoder.decode(UploadUpsInfoRsp.class, bArr);
        } catch (Exception e16) {
            stackTraceString = Log.getStackTraceString(e16);
            UploadLog.w(TAG, "get rsp ", e16);
        }
        if (uploadUpsInfoRsp == null) {
            if (stackTraceString == null) {
                stackTraceString = "unpack UploadUpsInfoRsp==null. " + bArr;
            }
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), stackTraceString);
            return;
        }
        UpsImageUploadResult upsImageUploadResult = new UpsImageUploadResult();
        upsImageUploadResult.flowId = this.flowId;
        upsImageUploadResult.dataType = uploadUpsInfoRsp.iType;
        upsImageUploadResult.vBusiNessData = uploadUpsInfoRsp.vBusiNessData;
        upsImageUploadResult.url = uploadUpsInfoRsp.sUrl;
        upsImageUploadResult.rawWidth = uploadUpsInfoRsp.iWidth;
        upsImageUploadResult.rawHeight = uploadUpsInfoRsp.iHight;
        upsImageUploadResult.photoType = uploadUpsInfoRsp.iPhotoType;
        onUploadSucceed(upsImageUploadResult);
        super.processFileUploadFinishRsp(bArr);
        onDestroy();
    }

    public void setAppid(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.iAppid = i3;
        }
    }
}
