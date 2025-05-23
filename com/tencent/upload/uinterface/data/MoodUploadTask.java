package com.tencent.upload.uinterface.data;

import FileUpload.ShuoshuoInfoReq;
import FileUpload.ShuoshuoInfoRsp;
import FileUpload.ShuoshuoPicInfo;
import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.cnst.appid_shuoshuo;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.BatchControlRequest;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MoodUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MoodUploadTask";
    public byte[] businessData;
    public int iAlbumTypeID;
    public long iBatchID;
    public List<PictureInfo> pictureInfoList;
    public String sAlbumID;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class PictureInfo {
        static IPatchRedirector $redirector_;
        public String albumid;
        public int hdheight;
        public String hdid;
        public int hdwidth;
        public int isAppExtPic;
        public boolean ishd;
        public Map<String, String> mapWaterMarkParams;
        public String picUrl;
        public int picheight;
        public String pictureid;
        public int pictype;
        public int picwidth;
        public String richval;
        public String sloc;
        public String strWaterMarkID;
        public String strWaterMarkMemo;

        public PictureInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public MoodUploadTask() {
        super(new byte[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sAlbumID = "";
        this.iAlbumTypeID = 0;
        this.iBatchID = 0L;
        this.businessData = null;
        this.pictureInfoList = null;
        this.mAppid = appid_shuoshuo.value;
    }

    private static Map<String, String> clearInValidValue(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                map.put(entry.getKey(), "");
            }
        }
        return map;
    }

    private ShuoshuoInfoReq createReq() {
        ShuoshuoInfoReq shuoshuoInfoReq = new ShuoshuoInfoReq();
        shuoshuoInfoReq.iAlbumTypeID = this.iAlbumTypeID;
        shuoshuoInfoReq.iBatchID = this.iBatchID;
        shuoshuoInfoReq.sAlbumID = this.sAlbumID;
        shuoshuoInfoReq.pic_list = new ArrayList<>();
        List<PictureInfo> list = this.pictureInfoList;
        if (list != null) {
            Iterator<PictureInfo> it = list.iterator();
            while (it.hasNext()) {
                shuoshuoInfoReq.pic_list.add(toShuoshuoPicInfo(it.next()));
            }
        }
        byte[] bArr = this.businessData;
        shuoshuoInfoReq.busiData = bArr;
        if (bArr == null) {
            shuoshuoInfoReq.busiData = new byte[0];
        }
        return shuoshuoInfoReq;
    }

    private static final ShuoshuoPicInfo toShuoshuoPicInfo(PictureInfo pictureInfo) {
        ShuoshuoPicInfo shuoshuoPicInfo = new ShuoshuoPicInfo();
        shuoshuoPicInfo.albumid = pictureInfo.albumid;
        shuoshuoPicInfo.pictureid = pictureInfo.pictureid;
        shuoshuoPicInfo.sloc = pictureInfo.sloc;
        int i3 = pictureInfo.pictype;
        shuoshuoPicInfo.pictype = i3;
        if (i3 == 2) {
            shuoshuoPicInfo.sourceType = 2;
        }
        shuoshuoPicInfo.picheight = pictureInfo.picheight;
        shuoshuoPicInfo.picwidth = pictureInfo.picwidth;
        shuoshuoPicInfo.ishd = pictureInfo.ishd;
        shuoshuoPicInfo.hdid = pictureInfo.hdid;
        shuoshuoPicInfo.hdheight = pictureInfo.hdheight;
        shuoshuoPicInfo.hdwidth = pictureInfo.hdwidth;
        shuoshuoPicInfo.strWaterMarkID = pictureInfo.strWaterMarkID;
        shuoshuoPicInfo.strWaterMarkMemo = pictureInfo.strWaterMarkMemo;
        shuoshuoPicInfo.mapWaterMarkParams = clearInValidValue(pictureInfo.mapWaterMarkParams);
        shuoshuoPicInfo.pic_url = pictureInfo.picUrl;
        shuoshuoPicInfo.is_appext_pic = pictureInfo.isAppExtPic;
        shuoshuoPicInfo.richval = pictureInfo.richval;
        return shuoshuoPicInfo;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ShuoshuoInfoReq createReq = createReq();
        try {
            bArr = ProtocolUtil.pack(createReq.getClass().getSimpleName(), createReq);
        } catch (Exception e16) {
            UploadLog.e(TAG, e16.toString());
            bArr = null;
        }
        if (bArr == null) {
            byte[] buildExtra = super.buildExtra();
            UploadLog.e(TAG, "package ShuoshuoInfoReq error!!!");
            return buildExtra;
        }
        return bArr;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask, com.tencent.upload.task.UploadTask
    protected UploadRequest getControlRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UploadRequest) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AuthToken authToken = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
        this.mCheckType = CheckType.TYPE_SHA1;
        this.mChecksum = "";
        buildEnv();
        this.mModel = UploadModel.MODEL_NORMAL;
        this.mStEnv = UploadGlobalConfig.getEnv();
        FileControlRequest fileControlRequest = new FileControlRequest(this.iUin + "", this.mAppid, authToken, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, null, this.mExtend_info);
        fileControlRequest.setExtraParam(buildExtra());
        HashMap hashMap = new HashMap();
        hashMap.put("1", (FileControlReq) fileControlRequest.createJceRequest());
        return new BatchControlRequest(hashMap);
    }

    @Override // com.tencent.upload.task.UploadTask
    /* renamed from: getUploadTaskType */
    public TaskTypeConfig getMTaskTypeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.ImageUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void onFileControlResponse(JceStruct jceStruct, UploadResponse uploadResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jceStruct, (Object) uploadResponse);
        } else {
            processUploadMoodRsp(((FileBatchControlRsp) jceStruct).control_rsp.get("1").biz_rsp);
        }
    }

    @Override // com.tencent.upload.task.UploadTask, com.tencent.upload.task.BaseTask
    public boolean onRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        UploadRequest controlRequest = getControlRequest();
        IUploadSession poll = this.mSessionPool.poll();
        if (poll == null) {
            UploadLog.e(TAG, "MoodUploadTask onRun(), get session return null !");
            retryPollSession();
            return false;
        }
        onSessionReport(new UploadQualityReportBuilder().setExt1(poll.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_MOOD_UPLOAD_PKG));
        this.mSavedSession = poll;
        this.mSession = poll;
        return poll.send(controlRequest, getMTaskTypeConfig(), this);
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public boolean onVerifyUploadFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    protected void processUploadMoodRsp(byte[] bArr) {
        ShuoshuoInfoRsp shuoshuoInfoRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "vRspData invalid");
            UploadLog.e(TAG, "vRspData == null");
            return;
        }
        try {
            shuoshuoInfoRsp = (ShuoshuoInfoRsp) ProtocolUtil.unpack(ShuoshuoInfoRsp.class.getSimpleName(), bArr);
        } catch (Exception e16) {
            UploadLog.e(TAG, e16.toString());
            shuoshuoInfoRsp = null;
        }
        if (shuoshuoInfoRsp == null) {
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE;
            onError(uploadRetCode.getCode(), "(" + uploadRetCode.getCode() + ")" + uploadRetCode.getDesc());
            return;
        }
        UploadLog.d(TAG, "onUploadSucceed flowid = " + this.flowId);
        onUploadSucceed(new MoodUploadResult(shuoshuoInfoRsp.vBusiNessDataRsp));
        setTaskStatus(TaskState.SUCCEED);
        Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.SUCCEED;
        onTaskFinished(uploadRetCode2.getCode(), uploadRetCode2.getDesc());
    }
}
