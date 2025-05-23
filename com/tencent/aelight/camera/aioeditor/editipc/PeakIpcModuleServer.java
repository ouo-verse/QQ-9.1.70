package com.tencent.aelight.camera.aioeditor.editipc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.h;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.l;
import com.tencent.mobileqq.shortvideo.p;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ITransProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import eipc.EIPCResult;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PeakIpcModuleServer extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static PeakIpcModuleServer f67416d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f67423a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f67424b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f67425c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ITransFileController f67426d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f67427e;

        a(int i3, long j3, String str, ITransFileController iTransFileController, String str2) {
            this.f67423a = i3;
            this.f67424b = j3;
            this.f67425c = str;
            this.f67426d = iTransFileController;
            this.f67427e = str2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg != null && fileMsg.fileType == 24 && fileMsg.commandId == this.f67423a && fileMsg.uniseq == this.f67424b) {
                if (TextUtils.isEmpty(this.f67425c)) {
                    str = "com.tencent.mobileqq:peak";
                } else {
                    str = this.f67425c;
                }
                String str2 = str;
                Bundle bundle = new Bundle();
                int i3 = message.what;
                if (i3 != 1008) {
                    switch (i3) {
                        case 1002:
                            bundle.putInt("key_upload_ark_video_progress", (int) (((fileMsg.transferedSize * 1.0d) / fileMsg.fileSize) * 100.0d));
                            QIPCServerHelper.getInstance().callClient(str2, this.f67427e, "action_upload_ark_video_progress_update", bundle, null);
                            return;
                        case 1003:
                            break;
                        case 1004:
                            this.f67426d.removeHandle(this);
                            QIPCServerHelper.getInstance().callClient(str2, this.f67427e, "action_upload_ark_video_cancel", bundle, null);
                            return;
                        case 1005:
                            this.f67426d.removeHandle(this);
                            QIPCServerHelper.getInstance().callClient(str2, this.f67427e, "action_upload_ark_video_fail", bundle, null);
                            return;
                        default:
                            return;
                    }
                }
                this.f67426d.removeHandle(this);
                Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                String str3 = null;
                try {
                    uploadPicExtInfo.mergeFrom(fileMsg.bdhExtendInfo);
                    str3 = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                    ms.a.f(IPeakIpcModuleServer.NAME, "uploadVideo--transProcessorHandler--handleMessage: videoDownloadUrl=" + str3);
                } catch (InvalidProtocolBufferMicroException e16) {
                    ms.a.d(IPeakIpcModuleServer.NAME, "uploadVideo--transProcessorHandler--parse downUrl error:", e16);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("key_upload_ark_video_download_url", str3);
                    QIPCServerHelper.getInstance().callClient(str2, this.f67427e, "action_upload_ark_video_success", bundle, null);
                } else {
                    QIPCServerHelper.getInstance().callClient(str2, this.f67427e, "action_upload_ark_video_fail", bundle, null);
                }
            }
        }
    }

    PeakIpcModuleServer(String str) {
        super(str);
    }

    public static synchronized PeakIpcModuleServer c() {
        PeakIpcModuleServer peakIpcModuleServer;
        synchronized (PeakIpcModuleServer.class) {
            if (f67416d == null) {
                synchronized (PeakIpcModuleServer.class) {
                    if (f67416d == null) {
                        f67416d = new PeakIpcModuleServer(IPeakIpcModuleServer.NAME);
                    }
                }
            }
            peakIpcModuleServer = f67416d;
        }
        return peakIpcModuleServer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit d(Bundle bundle, String str, int i3, TroopMemberNickInfo troopMemberNickInfo) {
        bundle.putBoolean("key_result", true);
        bundle.putString("uinname", str);
        callbackResult(i3, EIPCResult.createSuccessResult(bundle));
        return null;
    }

    private String getReportId(String str) {
        return WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE + str;
    }

    private void e(String str, String str2, String str3, int i3, String str4) {
        ms.a.f(IPeakIpcModuleServer.NAME, "uploadVideo---videoFilePath=" + str + ", callbackClientName=" + str2);
        ITransFileController iTransFileController = (ITransFileController) fr.b.a().getRuntimeService(ITransFileController.class, "");
        long currentTimeMillis = System.currentTimeMillis() + ((long) (Math.random() * 10000.0d));
        a aVar = new a(i3, currentTimeMillis, str4, iTransFileController, str2);
        aVar.addFilter(BDHCommonUploadProcessor.class);
        iTransFileController.addHandle(aVar);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = i3;
        transferRequest.mRichTag = StatisticCollector.AE_CAMERA_ARK_VIDEO_UPLOAD_STATISTIC_TAG;
        transferRequest.mPeerUin = "0";
        transferRequest.mUniseq = currentTimeMillis;
        transferRequest.mSelfUin = fr.b.a().getCurrentAccountUin();
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        String str5 = str3 != null ? str3 : "";
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + str5));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        iTransFileController.transferAsync(transferRequest);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0166  */
    @Override // eipc.EIPCModule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EIPCResult onCall(String str, Bundle bundle, final int i3) {
        int i16;
        EIPCResult eIPCResult;
        boolean z16;
        boolean z17;
        boolean z18;
        String str2;
        boolean z19;
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d(IPeakIpcModuleServer.NAME, 2, "[onCall]action= " + str);
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.e(IPeakIpcModuleServer.NAME, 2, "[onCall] get app failed.");
            }
            return null;
        }
        final Bundle bundle2 = new Bundle();
        final String str4 = "";
        if ("action_start_send".equals(str)) {
            Intent intent = (Intent) bundle.getParcelable("key_intent");
            if (intent != null) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                final String stringExtra = intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
                final String stringExtra2 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5);
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String l3 = j.l(stringExtra2, "jpg");
                            if (FileUtils.fileExistsAndNotEmpty(l3) || FileUtils.copyFile(stringExtra, l3)) {
                                return;
                            }
                            QLog.e(IPeakIpcModuleServer.NAME, 2, "copy thumbPath fail, exist: " + FileUtils.fileExistsAndNotEmpty(stringExtra));
                        }
                    }, 5, null, false);
                }
                v b16 = h.b(3, 0);
                p a16 = l.a(0, intent, b16);
                a16.T = true;
                b16.d(a16);
                l.e(b16, qQAppInterface);
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("sendVideo intent= ");
                Object obj = str4;
                if (intent != null) {
                    obj = intent.getExtras();
                }
                sb5.append(obj);
                QLog.d(IPeakIpcModuleServer.NAME, 2, sb5.toString());
            }
            bundle2.putBoolean("key_result", intent != null);
            eIPCResult = EIPCResult.createSuccessResult(bundle2);
            i16 = i3;
        } else {
            if ("action_cancel_send".equals(str)) {
                String string = bundle.getString("uin");
                int i17 = bundle.getInt("uintype");
                long j3 = bundle.getLong("key_uinsequence");
                final QQAppInterface qQAppInterface2 = (QQAppInterface) runtime;
                final MessageRecord P = qQAppInterface2.getMessageFacade().P(string, i17, j3);
                IHttpCommunicatorListener findProcessor = ((ITransFileController) qQAppInterface2.getRuntimeService(ITransFileController.class)).findProcessor(string, j3);
                long j16 = P != null ? P.uniseq : -1L;
                if ((findProcessor instanceof xq2.a) && !((xq2.a) findProcessor).isUpLoadSuccess()) {
                    ((ITransProcessor) findProcessor).pause();
                    str3 = "forwardVideo";
                } else if ((findProcessor instanceof IPicTransFile.b) && !((IPicTransFile.b) findProcessor).isUploadSuccess()) {
                    ((BaseUploadProcessor) findProcessor).pause();
                    str3 = "C2CPic";
                } else {
                    z18 = false;
                    str2 = str4;
                    if (z18) {
                        z19 = false;
                    } else {
                        z19 = ((ITransFileController) qQAppInterface2.getRuntimeService(ITransFileController.class)).removeProcessor(string + j3);
                        ((IOrderMediaMsgService) qQAppInterface2.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(string, j3);
                        if (P != null) {
                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    qQAppInterface2.getMessageFacade().z0(P, false);
                                }
                            }, 8, null, true);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(IPeakIpcModuleServer.NAME, 2, "cancelInfo, uinseq:" + string + ", uinType:" + i17 + ", sequence:" + j3 + ", msgSequence" + j16 + ", cancel:" + z18 + ", removeProcess:" + z19 + ", tips:" + str2);
                    }
                    bundle2.putBoolean("key_result", z18);
                    eIPCResult = EIPCResult.createSuccessResult(bundle2);
                }
                z18 = true;
                str2 = str3;
                if (z18) {
                }
                if (QLog.isColorLevel()) {
                }
                bundle2.putBoolean("key_result", z18);
                eIPCResult = EIPCResult.createSuccessResult(bundle2);
            } else if ("action_pic_start_send".equals(str)) {
                bundle.setClassLoader(getClass().getClassLoader());
                String string2 = bundle.getString(QZoneHelper.Constants.KEY_FILE_PATH);
                SessionInfo sessionInfo = (SessionInfo) bundle.getParcelable("key_session");
                String string3 = bundle.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "");
                String string4 = bundle.getString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, "");
                if (!TextUtils.isEmpty(string2)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(ShortVideoConstants.KEY_STORY_PIC_TO_RECENT, true);
                    if (!TextUtils.isEmpty(string3)) {
                        intent2.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, string3);
                        intent2.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, string4);
                    }
                    ForwardUtils.A(intent2, sessionInfo, string2, (QQAppInterface) runtime);
                    bundle2.putBoolean("key_result", true);
                    z17 = true;
                } else {
                    bundle2.putBoolean("key_result", false);
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(IPeakIpcModuleServer.NAME, 2, "sendPic success:" + z17 + ", photoPath\uff1a" + string2);
                }
                eIPCResult = EIPCResult.createSuccessResult(bundle2);
            } else if ("action_re_send".equals(str)) {
                final QQAppInterface qQAppInterface3 = (QQAppInterface) runtime;
                MessageRecord P2 = qQAppInterface3.getMessageFacade().P(bundle.getString("uin"), bundle.getInt("uintype"), bundle.getLong("key_uinsequence"));
                if (P2 instanceof MessageForShortVideo) {
                    MessageForShortVideo messageForShortVideo = (MessageForShortVideo) P2;
                    if (FileUtils.fileExistsAndNotEmpty(j.l(messageForShortVideo.thumbMD5, "jpg")) && !TextUtils.isEmpty(messageForShortVideo.videoFileName) && messageForShortVideo.isStoryVideo) {
                        ((IOrderMediaMsgService) qQAppInterface3.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(messageForShortVideo.frienduin, messageForShortVideo, messageForShortVideo.videoFileName);
                        v b17 = h.b(4, 0);
                        p a17 = l.a(0, P2, b17);
                        a17.T = true;
                        b17.d(a17);
                        l.e(b17, qQAppInterface3);
                        z16 = true;
                    } else {
                        messageForShortVideo.videoFileStatus = 1005;
                        z16 = false;
                    }
                } else {
                    if (P2 instanceof MessageForPic) {
                        final MessageForPic messageForPic = (MessageForPic) P2;
                        if (FileUtils.fileExistsAndNotEmpty(messageForPic.path) && messageForPic.isStoryPhoto) {
                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    QQMessageFacade messageFacade = qQAppInterface3.getMessageFacade();
                                    MessageForPic messageForPic2 = messageForPic;
                                    messageFacade.T1(messageForPic2.frienduin, messageForPic2.istroop, messageForPic2.uniseq);
                                }
                            }, 5, null, false);
                            if (messageForPic.isSendFromLocal()) {
                                ((ITransFileController) qQAppInterface3.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(messageForPic.frienduin, messageForPic.uniseq));
                            }
                            v.a aVar = new v.a();
                            aVar.v(messageForPic.path);
                            aVar.m(5);
                            aVar.x(messageForPic.frienduin);
                            if (messageForPic.fileSizeFlag == 1) {
                                aVar.y(1);
                            } else {
                                aVar.y(0);
                            }
                            aVar.A(messageForPic.senderuin);
                            aVar.B(messageForPic.selfuin);
                            aVar.I(messageForPic.istroop);
                            aVar.H(messageForPic.getConfessTopicId());
                            aVar.Y = messageForPic.extLong;
                            aVar.Z = messageForPic.extStr;
                            aVar.D(true);
                            v.b bVar = new v.b();
                            bVar.f258841a = messageForPic.msgseq;
                            bVar.f258842b = messageForPic.shmsgseq;
                            bVar.f258843c = messageForPic.msgUid;
                            aVar.z(bVar);
                            aVar.r(messageForPic.uniseq);
                            ((IOrderMediaMsgService) qQAppInterface3.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(messageForPic.frienduin, messageForPic.uniseq);
                            com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(4, 5);
                            createPicReq.f(aVar.l());
                            createPicReq.E = messageForPic.picExtraData;
                            ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
                            z16 = true;
                        }
                    }
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("reSend success:");
                    sb6.append(z16);
                    sb6.append(", message\uff1a");
                    String str5 = str4;
                    if (P2 != null) {
                        str5 = P2.toString();
                    }
                    sb6.append(str5);
                    QLog.d(IPeakIpcModuleServer.NAME, 2, sb6.toString());
                }
                bundle2.putBoolean("key_result", z16);
                eIPCResult = EIPCResult.createSuccessResult(bundle2);
            } else {
                if ("action_get_troop_member_name".equals(str)) {
                    String string5 = bundle.getString("troop_uin");
                    String string6 = bundle.getString("uin");
                    if (string5 == null || string6 == null) {
                        return null;
                    }
                    ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(string5, string6, IPeakIpcModuleServer.NAME, new Function1() { // from class: com.tencent.aelight.camera.aioeditor.editipc.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit d16;
                            d16 = PeakIpcModuleServer.this.d(bundle2, str4, i3, (TroopMemberNickInfo) obj2);
                            return d16;
                        }
                    });
                    return null;
                }
                i16 = i3;
                if ("action_get_troop_info".equals(str)) {
                    String string7 = bundle.getString("troop_uin");
                    try {
                        TroopManager troopManager = (TroopManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.TROOP_MANAGER);
                        TroopInfo l3 = troopManager.l(troopManager.G(string7), true);
                        if (l3 != null) {
                            bundle2.putBoolean("key_result", true);
                            bundle2.putBoolean(AppConstants.Key.TROOP_OWNER, l3.isDisband());
                            bundle2.putBoolean(AppConstants.Key.TROOP_CODE, l3.isNewTroop() && !l3.hasSetTroopHead());
                            return EIPCResult.createSuccessResult(bundle2);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(IPeakIpcModuleServer.NAME, 2, "ACTION_GET_TROOP_INFO exception = " + e16.getMessage());
                        }
                        e16.printStackTrace();
                    }
                } else if ("action_get_name".equals(str)) {
                    try {
                        String B = ac.B((QQAppInterface) runtime, bundle.getString("uin"));
                        bundle2.putBoolean("key_result", true);
                        bundle2.putString("uinname", B);
                        return EIPCResult.createSuccessResult(bundle2);
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d(IPeakIpcModuleServer.NAME, 2, "ACTION_GET_NAME exception = " + e17.getMessage());
                        }
                        e17.printStackTrace();
                    }
                } else if ("action_get_display_name".equals(str)) {
                    try {
                        String s16 = ac.s((QQAppInterface) runtime, bundle.getString("uin"), bundle.getString("troop_uin", null), ac.w(bundle.getInt("uintype")), 3);
                        bundle2.putBoolean("key_result", true);
                        bundle2.putString("uinname", s16);
                        return EIPCResult.createSuccessResult(bundle2);
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d(IPeakIpcModuleServer.NAME, 2, "ACTION_GET_DISPLAY_NAME exception = " + e18.getMessage());
                        }
                        e18.printStackTrace();
                    }
                } else if ("action_send_video_ark_msg".equals(str)) {
                    try {
                        bundle.setClassLoader(SessionInfo.class.getClassLoader());
                        SessionInfo sessionInfo2 = (SessionInfo) bundle.getParcelable("key_session");
                        String string8 = bundle.getString("key_ark_msg_prompt");
                        String string9 = bundle.getString("key_ark_msg_meta_json");
                        ArkAppMessage arkAppMessage = new ArkAppMessage();
                        arkAppMessage.promptText = string8;
                        arkAppMessage.appMinVersion = "0.0.0.23";
                        arkAppMessage.appName = "com.tencent.camera.activity";
                        arkAppMessage.appView = "preview";
                        arkAppMessage.metaList = string9;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("forward", 1);
                        jSONObject.put("type", "normal");
                        jSONObject.put("width", 162);
                        jSONObject.put("height", 259);
                        arkAppMessage.config = jSONObject.toString();
                        ChatActivityFacade.w0((QQAppInterface) runtime, sessionInfo2, arkAppMessage);
                        return EIPCResult.createSuccessResult(bundle2);
                    } catch (Exception e19) {
                        if (QLog.isColorLevel()) {
                            QLog.d(IPeakIpcModuleServer.NAME, 2, "ACTION_SEND_VIDEO_ARK_MSG exception = " + e19.getMessage());
                        }
                        e19.printStackTrace();
                    }
                } else if ("action_upload_ark_video".equals(str)) {
                    try {
                        e(bundle.getString("key_upload_ark_video_path"), bundle.getString("key_upload_ark_video_callback_client_name"), bundle.getString("key_upload_ark_res_postfix"), bundle.getInt("key_upload_command_id"), bundle.getString("key_upload_ark_video_process_name"));
                        return EIPCResult.createSuccessResult(bundle2);
                    } catch (Exception e26) {
                        if (QLog.isColorLevel()) {
                            QLog.d(IPeakIpcModuleServer.NAME, 2, "ACTION_SEND_VIDEO_ARK_MSG exception = " + e26.getMessage());
                        }
                        e26.printStackTrace();
                    }
                } else if ("action_qcircle_picker_report".equals(str)) {
                    ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportPublishQuality(getReportId(bundle.getString(PeakConstants.QCIRCLE_CLIENT_EVENTID)), Arrays.asList(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).ext1(), bundle.getString(PeakConstants.QCIRCLE_CLIENT_EXT1)), ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).ext2(), bundle.getString(PeakConstants.QCIRCLE_CLIENT_EXT2)), ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).ext3(), bundle.getString(PeakConstants.QCIRCLE_CLIENT_EXT3)), ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).traceId(), bundle.getString(PeakConstants.QCIRCLE_CLIENT_TRACEID)), ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).desc(), bundle.getString(PeakConstants.QCIRCLE_CLIENT_MSG)), ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).keyRetCode(), bundle.getString(PeakConstants.QCIRCLE_CLIENT_RESULTCODE))));
                }
                eIPCResult = null;
            }
            i16 = i3;
        }
        callbackResult(i16, eIPCResult);
        return null;
    }
}
