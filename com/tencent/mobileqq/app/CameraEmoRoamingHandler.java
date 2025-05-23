package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.selfgif.CameraEmotionRoaming_sso$DelReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso$DelRet;
import tencent.im.selfgif.CameraEmotionRoaming_sso$DelRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso$GetListReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso$GetListRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso$ImgInfo;
import tencent.im.selfgif.CameraEmotionRoaming_sso$ReqBody;
import tencent.im.selfgif.CameraEmotionRoaming_sso$RspBody;
import tencent.im.selfgif.CameraEmotionRoaming_sso$UpLoadReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso$UpLoadRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso$UpLoadState;
import tencent.im.selfgif.CameraEmotionRoaming_sso$UpLoadStateReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso$UpLoadStateRet;
import tencent.im.selfgif.CameraEmotionRoaming_sso$UploadImgInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CameraEmoRoamingHandler extends CustomEmoRoamingBaseHandler<CameraEmotionData> implements ICameraEmoRoamingHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final String f194459e;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Integer, CameraEmotionData> f194460d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36699);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f194459e = CameraEmoRoamingHandler.class.getName();
        }
    }

    protected CameraEmoRoamingHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f194460d = new ConcurrentHashMap<>();
        }
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Object valueOf;
        String str;
        boolean z16;
        QLog.d("CameraEmoRoamingHandler", 1, "timtest handleNotifyServerUploadStatus start");
        int i3 = toServiceMsg.extraData.getInt("camera_emo_upload_id");
        CameraEmotionData cameraEmotionData = this.f194460d.get(Integer.valueOf(i3));
        if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            CameraEmotionRoaming_sso$RspBody cameraEmotionRoaming_sso$RspBody = new CameraEmotionRoaming_sso$RspBody();
            try {
                cameraEmotionRoaming_sso$RspBody.mergeFrom((byte[]) obj);
                CameraEmotionRoaming_sso$UpLoadStateRet cameraEmotionRoaming_sso$UpLoadStateRet = cameraEmotionRoaming_sso$RspBody.upLoad_state_rsp.get().upload_state_ret.get(0);
                int i16 = cameraEmotionRoaming_sso$UpLoadStateRet.int32_upload_state_ret.get();
                if (i16 == 0) {
                    cameraEmotionData.url = cameraEmotionRoaming_sso$UpLoadStateRet.img_info.url.get().toStringUtf8();
                    I2(1, true, 0, cameraEmotionData);
                    this.f194460d.remove(Integer.valueOf(i3));
                    QLog.e("CameraEmoRoamingHandler", 1, "func handleNotifyServerUploadStatus suc");
                } else {
                    I2(1, false, 13, cameraEmotionData);
                    this.f194460d.remove(Integer.valueOf(i3));
                    QLog.e("CameraEmoRoamingHandler", 1, "func handleNotifyServerUploadStatus fail, result:", Integer.valueOf(i16));
                }
                HashMap<String, String> hashMap = new HashMap<>();
                if (i16 == 0) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("sucFlag", str);
                hashMap.put("retCode", String.valueOf(i16));
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                if (i16 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                statisticCollector.collectPerformance(null, "CamEmoUpdateStat", z16, 0L, 0L, hashMap, null);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("CameraEmoRoamingHandler", 1, "func handleNotifyServerUploadStatus ends, errInfo:" + e16.getMessage());
                I2(1, false, 100, cameraEmotionData);
                this.f194460d.remove(Integer.valueOf(i3));
                return;
            } catch (OutOfMemoryError unused) {
                QLog.e("CameraEmoRoamingHandler", 1, "handleNotifyServerUploadStatus oom");
                I2(1, false, 100, cameraEmotionData);
                this.f194460d.remove(Integer.valueOf(i3));
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fail to  handlePrepareUploadInfo error code is ");
        if (fromServiceMsg == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(fromServiceMsg.getResultCode());
        }
        sb5.append(valueOf);
        QLog.e("CameraEmoRoamingHandler", 1, sb5.toString());
        I2(1, false, 12, cameraEmotionData);
        this.f194460d.remove(Integer.valueOf(i3));
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Object valueOf;
        int i3;
        String str;
        boolean z16;
        int i16 = toServiceMsg.extraData.getInt("camera_emo_upload_id");
        QLog.d("CameraEmoRoamingHandler", 1, "timtest handlePrepareUploadInfo start, ", Integer.valueOf(i16));
        CameraEmotionData cameraEmotionData = this.f194460d.get(Integer.valueOf(i16));
        if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            CameraEmotionRoaming_sso$RspBody cameraEmotionRoaming_sso$RspBody = new CameraEmotionRoaming_sso$RspBody();
            try {
                cameraEmotionRoaming_sso$RspBody.mergeFrom((byte[]) obj);
                String stringUtf8 = cameraEmotionRoaming_sso$RspBody.bytes_fail_msg.get().toStringUtf8();
                if (cameraEmotionRoaming_sso$RspBody.upLoad_rsp.has()) {
                    CameraEmotionRoaming_sso$UpLoadRsp cameraEmotionRoaming_sso$UpLoadRsp = cameraEmotionRoaming_sso$RspBody.upLoad_rsp.get();
                    i3 = cameraEmotionRoaming_sso$UpLoadRsp.int32_is_upload.get();
                    if (i3 == 0) {
                        cameraEmotionData.resid = cameraEmotionRoaming_sso$UpLoadRsp.bytes_resource_id.get().toStringUtf8();
                        QLog.d("CameraEmoRoamingHandler", 1, "timtest handlePrepareUploadInfo success md5 = " + cameraEmotionData.md5 + "| resid=" + cameraEmotionData.resid + " | msg = " + stringUtf8 + ", templateId:" + cameraEmotionData.templateId);
                        ((ICameraEmoRoamingManagerService) this.app.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).realUploadCustomEmoticon(cameraEmotionData);
                    } else if (i3 == 1) {
                        I2(1, false, 2, cameraEmotionData);
                        this.f194460d.remove(Integer.valueOf(i16));
                        QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo fail, nCanupload:" + i3);
                    } else {
                        I2(1, false, 13, cameraEmotionData);
                        this.f194460d.remove(Integer.valueOf(i16));
                        QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo fail, nCanupload:" + i3);
                    }
                } else {
                    QLog.d("CameraEmoRoamingHandler", 1, "timtest handlePrepareUploadInfo end rspBody.upLoad_rsp no value msg = " + stringUtf8);
                    I2(1, false, 13, cameraEmotionData);
                    this.f194460d.remove(Integer.valueOf(i16));
                    i3 = -1;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                if (i3 == 0) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("sucFlag", str);
                hashMap.put("retCode", String.valueOf(i3));
                if (stringUtf8 == null) {
                    stringUtf8 = "";
                }
                hashMap.put("errMsg", stringUtf8);
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                statisticCollector.collectPerformance(null, "CamEmoPrepareUpload", z16, 0L, 0L, hashMap, null);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo ends, errInfo:" + e16.getMessage());
                I2(1, false, 100, cameraEmotionData);
                this.f194460d.remove(Integer.valueOf(i16));
                return;
            } catch (OutOfMemoryError unused) {
                QLog.e("CameraEmoRoamingHandler", 1, "handlePrepareUploadInfo oom");
                I2(1, false, 100, cameraEmotionData);
                this.f194460d.remove(Integer.valueOf(i16));
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fail to  handlePrepareUploadInfo error code is ");
        if (fromServiceMsg == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(fromServiceMsg.getResultCode());
        }
        sb5.append(valueOf);
        QLog.e("CameraEmoRoamingHandler", 1, sb5.toString());
        I2(1, false, 12, cameraEmotionData);
        this.f194460d.remove(Integer.valueOf(i16));
    }

    private void K2(List<CameraEmotionRoaming_sso$ImgInfo> list, List<CameraEmoImg> list2, List<String> list3) {
        String str;
        String str2;
        if (list != null && list2 != null && list3 != null) {
            for (CameraEmotionRoaming_sso$ImgInfo cameraEmotionRoaming_sso$ImgInfo : list) {
                String stringUtf8 = cameraEmotionRoaming_sso$ImgInfo.bytes_resource_id.get().toStringUtf8();
                String stringUtf82 = cameraEmotionRoaming_sso$ImgInfo.bytes_text.get(0).toStringUtf8();
                String stringUtf83 = cameraEmotionRoaming_sso$ImgInfo.url.get().toStringUtf8();
                String stringUtf84 = cameraEmotionRoaming_sso$ImgInfo.bytes_md5.get().toStringUtf8();
                String stringUtf85 = cameraEmotionRoaming_sso$ImgInfo.bytes_widget_id.get().toStringUtf8();
                if (!StringUtil.isEmpty(stringUtf8)) {
                    CameraEmoImg cameraEmoImg = new CameraEmoImg();
                    cameraEmoImg.resID = stringUtf8;
                    if (stringUtf82 == null) {
                        str = "";
                    } else {
                        str = stringUtf82;
                    }
                    cameraEmoImg.content = str;
                    if (stringUtf83 == null) {
                        str2 = "";
                    } else {
                        str2 = stringUtf83;
                    }
                    cameraEmoImg.url = str2;
                    if (stringUtf84 == null) {
                        stringUtf84 = "";
                    }
                    cameraEmoImg.md5 = stringUtf84;
                    cameraEmoImg.templateId = stringUtf85;
                    QLog.e("CameraEmoRoamingHandler", 1, "readSSoImgInfoList get CameraEmoImg content = " + stringUtf82 + "| url = " + stringUtf83 + ", templateId:" + stringUtf85);
                    list3.add(stringUtf8);
                    list2.add(cameraEmoImg);
                }
            }
            return;
        }
        QLog.e("CameraEmoRoamingHandler", 1, "readSSoImgInfoList param error");
    }

    protected void F2(Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, obj, (Object) str);
            return;
        }
        QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet start");
        CameraEmotionRoaming_sso$RspBody cameraEmotionRoaming_sso$RspBody = new CameraEmotionRoaming_sso$RspBody();
        try {
            cameraEmotionRoaming_sso$RspBody.mergeFrom((byte[]) obj);
            cameraEmotionRoaming_sso$RspBody.bytes_fail_msg.get().toStringUtf8();
            if (cameraEmotionRoaming_sso$RspBody.get_list_rsp.has()) {
                CameraEmotionRoaming_sso$GetListRsp cameraEmotionRoaming_sso$GetListRsp = cameraEmotionRoaming_sso$RspBody.get_list_rsp.get();
                String stringUtf8 = cameraEmotionRoaming_sso$GetListRsp.server_timestamp_version.get().toStringUtf8();
                if (str.equals(stringUtf8)) {
                    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet same version = " + stringUtf8);
                    H2(2, true, 0);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (cameraEmotionRoaming_sso$GetListRsp.rpt_img_info.has()) {
                    K2(cameraEmotionRoaming_sso$GetListRsp.rpt_img_info.get(), arrayList, arrayList2);
                }
                QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet cameraEmoImgs.size = " + arrayList.size());
                ThreadManagerV2.excute(new Runnable(stringUtf8, arrayList, arrayList2) { // from class: com.tencent.mobileqq.app.CameraEmoRoamingHandler.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f194465d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ List f194466e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ List f194467f;

                    {
                        this.f194465d = stringUtf8;
                        this.f194466e = arrayList;
                        this.f194467f = arrayList2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, CameraEmoRoamingHandler.this, stringUtf8, arrayList, arrayList2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        FileUtils.createFileIfNotExits(AppConstants.SDCARD_IMG_CAMERA_EMO + ".nomedia");
                        ((ICameraEmoRoamingManagerService) CameraEmoRoamingHandler.this.app.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).updateListVersion(this.f194465d);
                        ((ICameraEmotionRoamingDBManagerService) CameraEmoRoamingHandler.this.app.getRuntimeService(ICameraEmotionRoamingDBManagerService.class, "")).updateLocalDBFromServer(this.f194466e, this.f194467f, null);
                        if (this.f194466e.isEmpty()) {
                            QLog.i("CameraEmoRoamingHandler", 1, "no diy emoticon exist, set the flag");
                            com.tencent.mobileqq.config.business.h.INSTANCE.e(CameraEmoRoamingHandler.this.app, true);
                        }
                        CameraEmoRoamingHandler.this.H2(2, true, 0);
                        EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus("0", 2);
                    }
                }, 32, null, true);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("CameraEmoRoamingHandler", 1, "func handleUserInfoGet ends, errInfo:" + e16.getMessage());
        } catch (OutOfMemoryError unused) {
            QLog.e("CameraEmoRoamingHandler", 1, "handleUserInfoGet oom");
        }
    }

    public void G2(CameraEmotionData cameraEmotionData, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, cameraEmotionData, Boolean.valueOf(z16));
            return;
        }
        if (cameraEmotionData == null) {
            QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start, data is null");
            I2(1, false, 10, cameraEmotionData);
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start, net not support");
            I2(1, false, 12, cameraEmotionData);
            return;
        }
        QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start");
        CameraEmotionRoaming_sso$UpLoadStateReq cameraEmotionRoaming_sso$UpLoadStateReq = new CameraEmotionRoaming_sso$UpLoadStateReq();
        CameraEmotionRoaming_sso$UpLoadState cameraEmotionRoaming_sso$UpLoadState = new CameraEmotionRoaming_sso$UpLoadState();
        cameraEmotionRoaming_sso$UpLoadState.bytes_resource_id.set(ByteStringMicro.copyFrom(cameraEmotionData.resid.getBytes()));
        PBRepeatField<ByteStringMicro> pBRepeatField = cameraEmotionRoaming_sso$UpLoadState.bytes_text;
        String str = cameraEmotionData.strContext;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pBRepeatField.add(ByteStringMicro.copyFrom(str.getBytes()));
        cameraEmotionRoaming_sso$UpLoadState.int32_upload_state.set(!z16 ? 1 : 0);
        PBBytesField pBBytesField = cameraEmotionRoaming_sso$UpLoadState.bytes_widget_id;
        String str3 = cameraEmotionData.templateId;
        if (str3 != null) {
            str2 = str3;
        }
        pBBytesField.set(ByteStringMicro.copyFrom(str2.getBytes()));
        cameraEmotionRoaming_sso$UpLoadStateReq.upload_state.add(cameraEmotionRoaming_sso$UpLoadState);
        CameraEmotionRoaming_sso$ReqBody cameraEmotionRoaming_sso$ReqBody = new CameraEmotionRoaming_sso$ReqBody();
        cameraEmotionRoaming_sso$ReqBody.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
        cameraEmotionRoaming_sso$ReqBody.uint32_cmd_type.set(2);
        cameraEmotionRoaming_sso$ReqBody.uint32_src_term.set(3);
        cameraEmotionRoaming_sso$ReqBody.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f99551k.getBytes()));
        cameraEmotionRoaming_sso$ReqBody.upLoad_state_req.set(cameraEmotionRoaming_sso$UpLoadStateReq);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
        toServiceMsg.extraData.putInt("cmd_camera_emo_subcmd", 2);
        toServiceMsg.extraData.putInt("camera_emo_upload_id", cameraEmotionData.emoId);
        toServiceMsg.putWupBuffer(cameraEmotionRoaming_sso$ReqBody.toByteArray());
        super.sendPbReq(toServiceMsg);
    }

    public final void H2(int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        } else {
            notifyUI(i3, z16, (Object) Integer.valueOf(i16), false);
        }
    }

    public final void I2(int i3, boolean z16, Object obj, CameraEmotionData cameraEmotionData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj, cameraEmotionData);
        } else {
            notifyUI(i3, z16, (Object) new Object[]{obj, cameraEmotionData}, false);
        }
    }

    public void J2(CameraEmotionData cameraEmotionData, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, cameraEmotionData, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        if (cameraEmotionData == null) {
            QLog.d("CameraEmoRoamingHandler", 1, "timtest prepareUploadEmoReq start, data is null");
            I2(1, false, 10, cameraEmotionData);
            return;
        }
        QLog.d("CameraEmoRoamingHandler", 1, "timtest prepareUploadEmoReq start, md5:", cameraEmotionData.md5, ", size:", Long.valueOf(j3), ", emoId:", Integer.valueOf(cameraEmotionData.emoId));
        this.f194460d.put(Integer.valueOf(cameraEmotionData.emoId), cameraEmotionData);
        CameraEmotionRoaming_sso$UpLoadReq cameraEmotionRoaming_sso$UpLoadReq = new CameraEmotionRoaming_sso$UpLoadReq();
        CameraEmotionRoaming_sso$UploadImgInfo cameraEmotionRoaming_sso$UploadImgInfo = new CameraEmotionRoaming_sso$UploadImgInfo();
        cameraEmotionRoaming_sso$UploadImgInfo.bytes_img_md5.set(ByteStringMicro.copyFrom(cameraEmotionData.md5.getBytes()));
        cameraEmotionRoaming_sso$UploadImgInfo.uint32_img_height.set(i16);
        cameraEmotionRoaming_sso$UploadImgInfo.uint32_img_width.set(i3);
        cameraEmotionRoaming_sso$UploadImgInfo.uint64_img_size.set(j3);
        cameraEmotionRoaming_sso$UpLoadReq.img_info.set(cameraEmotionRoaming_sso$UploadImgInfo);
        CameraEmotionRoaming_sso$ReqBody cameraEmotionRoaming_sso$ReqBody = new CameraEmotionRoaming_sso$ReqBody();
        cameraEmotionRoaming_sso$ReqBody.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
        cameraEmotionRoaming_sso$ReqBody.uint32_cmd_type.set(1);
        cameraEmotionRoaming_sso$ReqBody.uint32_src_term.set(3);
        cameraEmotionRoaming_sso$ReqBody.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f99551k.getBytes()));
        cameraEmotionRoaming_sso$ReqBody.upLoad_req.set(cameraEmotionRoaming_sso$UpLoadReq);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
        toServiceMsg.extraData.putInt("cmd_camera_emo_subcmd", 1);
        toServiceMsg.extraData.putInt("camera_emo_upload_id", cameraEmotionData.emoId);
        toServiceMsg.putWupBuffer(cameraEmotionRoaming_sso$ReqBody.toByteArray());
        super.sendPbReq(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler
    public void delUserEmoRoamingReq(List<String> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, list, Boolean.valueOf(z16));
            return;
        }
        if (list != null && list.size() != 0) {
            QLog.d("CameraEmoRoamingHandler", 1, "timtest delUserEmoRoamingReq start size = " + list.size());
            CameraEmotionRoaming_sso$DelReq cameraEmotionRoaming_sso$DelReq = new CameraEmotionRoaming_sso$DelReq();
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str = list.get(i3);
                if (str != null) {
                    cameraEmotionRoaming_sso$DelReq.bytes_resource_id.get().add(ByteStringMicro.copyFrom(str.getBytes()));
                }
            }
            CameraEmotionRoaming_sso$ReqBody cameraEmotionRoaming_sso$ReqBody = new CameraEmotionRoaming_sso$ReqBody();
            cameraEmotionRoaming_sso$ReqBody.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
            cameraEmotionRoaming_sso$ReqBody.uint32_cmd_type.set(4);
            cameraEmotionRoaming_sso$ReqBody.uint32_src_term.set(3);
            cameraEmotionRoaming_sso$ReqBody.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f99551k.getBytes()));
            cameraEmotionRoaming_sso$ReqBody.del_req.set(cameraEmotionRoaming_sso$DelReq);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
            toServiceMsg.extraData.putInt("cmd_camera_emo_subcmd", 4);
            toServiceMsg.extraData.putBoolean("cmd_param_need_sync", z16);
            toServiceMsg.putWupBuffer(cameraEmotionRoaming_sso$ReqBody.toByteArray());
            super.sendPbReq(toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler
    protected void handleDelMessage(Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, obj, Boolean.valueOf(z16));
            return;
        }
        QLog.d("CameraEmoRoamingHandler", 1, "timtest handleDelMessage start ");
        CameraEmotionRoaming_sso$RspBody cameraEmotionRoaming_sso$RspBody = new CameraEmotionRoaming_sso$RspBody();
        try {
            cameraEmotionRoaming_sso$RspBody.mergeFrom((byte[]) obj);
            cameraEmotionRoaming_sso$RspBody.bytes_fail_msg.get().toStringUtf8();
            if (cameraEmotionRoaming_sso$RspBody.del_rsp.has()) {
                CameraEmotionRoaming_sso$DelRsp cameraEmotionRoaming_sso$DelRsp = cameraEmotionRoaming_sso$RspBody.del_rsp.get();
                String stringUtf8 = cameraEmotionRoaming_sso$DelRsp.client_timestamp_version.get().toStringUtf8();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (cameraEmotionRoaming_sso$DelRsp.rpt_img_info.has()) {
                    K2(cameraEmotionRoaming_sso$DelRsp.rpt_img_info.get(), arrayList, arrayList3);
                }
                if (cameraEmotionRoaming_sso$DelRsp.del_ret.has()) {
                    for (CameraEmotionRoaming_sso$DelRet cameraEmotionRoaming_sso$DelRet : cameraEmotionRoaming_sso$DelRsp.del_ret.get()) {
                        if (cameraEmotionRoaming_sso$DelRet.int32_del_ret.get() == 0) {
                            arrayList2.add(cameraEmotionRoaming_sso$DelRet.bytes_resource_id.get().toStringUtf8());
                        }
                    }
                }
                QLog.d("CameraEmoRoamingHandler", 1, "timtest handleDelMessage delResIDList.size = " + arrayList2.size() + "| cameraEmoImgs.size = " + arrayList.size());
                ThreadManagerV2.excute(new Runnable(stringUtf8, arrayList, arrayList3, arrayList2) { // from class: com.tencent.mobileqq.app.CameraEmoRoamingHandler.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f194461d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ List f194462e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ List f194463f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ List f194464h;

                    {
                        this.f194461d = stringUtf8;
                        this.f194462e = arrayList;
                        this.f194463f = arrayList3;
                        this.f194464h = arrayList2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, CameraEmoRoamingHandler.this, stringUtf8, arrayList, arrayList3, arrayList2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        ((ICameraEmoRoamingManagerService) CameraEmoRoamingHandler.this.app.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).updateListVersion(this.f194461d);
                        ((ICameraEmotionRoamingDBManagerService) CameraEmoRoamingHandler.this.app.getRuntimeService(ICameraEmotionRoamingDBManagerService.class, "")).updateLocalDBFromServer(this.f194462e, this.f194463f, this.f194464h);
                        EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("0", 2);
                        CameraEmoRoamingHandler.this.H2(3, true, 0);
                    }
                }, 32, null, true);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("CameraEmoRoamingHandler", 1, "func handleDelMessage ends, errInfo:" + e16.getMessage());
        } catch (OutOfMemoryError unused) {
            QLog.e("CameraEmoRoamingHandler", 1, "handleDelMessage oom");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Class) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return CameraEmoRoamingObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg == null) {
            QLog.e("CameraEmoRoamingHandler", 1, "timtest onReceive error : ToServiceMsg is null");
            return;
        }
        QLog.d("CameraEmoRoamingHandler", 1, "timtest onReceive start");
        int i3 = toServiceMsg.extraData.getInt("cmd_camera_emo_subcmd");
        if (i3 != 1) {
            if (i3 != 2) {
                Object obj2 = "null";
                if (i3 != 3) {
                    if (i3 == 4) {
                        if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                            handleDelMessage(obj, toServiceMsg.extraData.getBoolean("cmd_param_need_sync"));
                            return;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("fail to  handleDelMessage error code is ");
                        if (fromServiceMsg != null) {
                            obj2 = Integer.valueOf(fromServiceMsg.getResultCode());
                        }
                        sb5.append(obj2);
                        QLog.e("CameraEmoRoamingHandler", 1, sb5.toString());
                        if (fromServiceMsg != null && !fromServiceMsg.isSuccess()) {
                            EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus(String.valueOf(fromServiceMsg.getResultCode()), 2);
                            return;
                        } else {
                            EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("3003", 2);
                            return;
                        }
                    }
                    return;
                }
                if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                    F2(obj, toServiceMsg.extraData.getString("cmd_param_data_version", ""));
                    return;
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("fail to  handleUserInfoGet error code is ");
                if (fromServiceMsg != null) {
                    obj2 = Integer.valueOf(fromServiceMsg.getResultCode());
                }
                sb6.append(obj2);
                QLog.e("CameraEmoRoamingHandler", 1, sb6.toString());
                if (fromServiceMsg != null && !fromServiceMsg.isSuccess()) {
                    EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus(String.valueOf(fromServiceMsg.getResultCode()), 2);
                    return;
                } else {
                    EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("3002", 2);
                    return;
                }
            }
            D2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        E2(toServiceMsg, fromServiceMsg, obj);
    }

    @Override // com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler
    public void queryUserEmoRoamingReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d("CameraEmoRoamingHandler", 1, "timtest queryUserEmoRoamingReq  start");
        String listVersion = ((ICameraEmoRoamingManagerService) this.app.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).getListVersion();
        CameraEmotionRoaming_sso$GetListReq cameraEmotionRoaming_sso$GetListReq = new CameraEmotionRoaming_sso$GetListReq();
        cameraEmotionRoaming_sso$GetListReq.client_timestamp_version.set(ByteStringMicro.copyFrom(listVersion.getBytes()));
        CameraEmotionRoaming_sso$ReqBody cameraEmotionRoaming_sso$ReqBody = new CameraEmotionRoaming_sso$ReqBody();
        cameraEmotionRoaming_sso$ReqBody.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
        cameraEmotionRoaming_sso$ReqBody.uint32_cmd_type.set(3);
        cameraEmotionRoaming_sso$ReqBody.uint32_src_term.set(3);
        cameraEmotionRoaming_sso$ReqBody.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f99551k.getBytes()));
        cameraEmotionRoaming_sso$ReqBody.get_list_req.set(cameraEmotionRoaming_sso$GetListReq);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
        toServiceMsg.extraData.putInt("cmd_camera_emo_subcmd", 3);
        toServiceMsg.extraData.putString("cmd_param_data_version", listVersion);
        toServiceMsg.putWupBuffer(cameraEmotionRoaming_sso$ReqBody.toByteArray());
        super.sendPbReq(toServiceMsg);
    }
}
