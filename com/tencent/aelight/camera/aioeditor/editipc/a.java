package com.tencent.aelight.camera.aioeditor.editipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.takevideo.ab;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import eipc.EIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface h {
        void onCancel();

        void onFail();

        void onProgress(int i3);

        void onSuccess(String str);
    }

    public static void a(com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar) {
        if (QLog.isColorLevel()) {
            QLog.i("PeakIpcController", 2, "cancelSendVideoOrPhoto uinseq:" + eVar.f68848o);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("key_uinsequence", eVar.f68848o);
        bundle.putString("uin", eVar.f68834a);
        bundle.putInt("uintype", eVar.f68837d);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_cancel_send", bundle, new b(eVar));
    }

    public static String b(String str) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putString("uin", str);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_get_name", bundle2);
        if (callServer == null || !callServer.isSuccess() || (bundle = callServer.data) == null) {
            return null;
        }
        String string = bundle.getString("uinname");
        if (QLog.isColorLevel()) {
            QLog.i("PeakIpcController", 2, "getFriendName success name = " + string);
        }
        return string;
    }

    public static Pair<Boolean, Boolean> c(String str) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putString("troop_uin", str);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_get_troop_info", bundle2);
        if (callServer == null || !callServer.isSuccess() || (bundle = callServer.data) == null) {
            return null;
        }
        return new Pair<>(Boolean.valueOf(bundle.getBoolean(AppConstants.Key.TROOP_OWNER)), Boolean.valueOf(callServer.data.getBoolean(AppConstants.Key.TROOP_CODE)));
    }

    public static void d(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("troop_uin", str);
        bundle.putString("uin", str2);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_get_troop_member_name", bundle, new e(str2));
    }

    public static void e(com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar) {
        if (eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.i("PeakIpcController", 2, "reSendMessage editVideoInfo is null");
            }
        } else {
            if (eVar.f68848o <= 0) {
                QLog.e("PeakIpcController", 1, "reSendMessage error!");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("key_uinsequence", eVar.f68848o);
            bundle.putString("uin", eVar.f68834a);
            bundle.putInt("uintype", eVar.f68837d);
            QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_re_send", bundle, new d());
        }
    }

    public static void f(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, str);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, str2, bundle);
    }

    public static void g(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, str);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_EXT1, str3);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, str2, bundle);
    }

    public static void h(String str, String str2, String str3, long j3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_EXT1, str2);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_EXT2, str3);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_COST, String.valueOf(j3));
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_RESULTCODE, str4);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, str, bundle);
    }

    public static void i(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Bundle bundle = new Bundle();
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_EVENTID, str3);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_EXT1, str4);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_EXT2, str5);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_EXT3, str6);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_MSG, str8);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, str);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_RESULTCODE, str7);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, str2, bundle);
    }

    public static void j(String str, com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar, String str2, String str3) {
        if (eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.i("PeakIpcController", 2, "sendPhoto editVideoInfo is null");
                return;
            }
            return;
        }
        eVar.f68848o = 0L;
        String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(str));
        if (bytes2HexStr == null) {
            QLog.e("PeakIpcController", 1, "sendPic file md5 fail!");
            return;
        }
        eVar.f68847n = bytes2HexStr;
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = eVar.f68834a;
        sessionInfo.f179555d = eVar.f68837d;
        sessionInfo.f179559f = eVar.f68835b;
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_session", sessionInfo);
        bundle.putString(QZoneHelper.Constants.KEY_FILE_PATH, str);
        bundle.putString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, str2);
        bundle.putString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, str3);
        ms.a.f("PeakIpcController", "sendPhoto---takeSameName=" + str3);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_pic_start_send", bundle, new c());
    }

    public static void k(String str, String str2, com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar, String str3, String str4) {
        ms.a.f("PeakIpcController", "sendVideo---takeSameName=" + str4);
        eVar.f68848o = 0L;
        Intent a16 = ab.a(str, str2, eVar, str3, str4);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_intent", a16);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_start_send", bundle, new C0583a());
    }

    public static void l(SessionInfo sessionInfo, String str, String str2) {
        ms.a.f("PeakIpcController", "sendVideoArkMsg---");
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_session", sessionInfo);
        bundle.putString("key_ark_msg_prompt", str);
        bundle.putString("key_ark_msg_meta_json", str2);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_send_video_ark_msg", bundle, new f());
    }

    public static void m(MessageRecord messageRecord, int i3, int i16) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("key_status", i3);
        bundle2.putInt("key_progress", i16);
        bundle2.putLong("key_uinsequence", messageRecord.uniseq);
        bundle2.putString("uin", messageRecord.frienduin);
        bundle2.putInt("uintype", messageRecord.istroop);
        if (messageRecord instanceof MessageForShortVideo) {
            bundle2.putString("key_file_md5", ((MessageForShortVideo) messageRecord).md5);
        } else if (messageRecord instanceof MessageForPic) {
            bundle2.putString("key_file_md5", ((MessageForPic) messageRecord).md5);
        }
        EIPCResult callClient = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:peak", 1, "PeakIpcModuleClient", "action_update_status", bundle2);
        boolean z16 = (callClient == null || (bundle = callClient.data) == null) ? false : bundle.getBoolean("key_result");
        if (QLog.isColorLevel()) {
            QLog.i("PeakIpcController", 2, "client result:" + z16);
        }
    }

    public static void n(String str, String str2, h hVar) {
        ms.a.f("PeakIpcController", "uploadArkVideo---");
        String str3 = "receive_progress_" + System.nanoTime() + "_" + UUID.randomUUID().toString();
        QIPCClientHelper.getInstance().getClient().registerModule(new g(str3, hVar, str3));
        Bundle bundle = new Bundle();
        bundle.putString("key_upload_ark_video_path", str);
        bundle.putString("key_upload_ark_res_postfix", str2);
        bundle.putString("key_upload_ark_video_callback_client_name", str3);
        bundle.putInt("key_upload_command_id", 82);
        QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_upload_ark_video", bundle, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.editipc.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0583a implements EIPCResultCallback {
        C0583a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult != null) {
                QLog.d("PeakIpcController", 2, "sendVideo result:" + eIPCResult.data.getBoolean("key_result"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e f67429d;

        b(com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar) {
            this.f67429d = eVar;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            boolean z16 = (eIPCResult == null || (bundle = eIPCResult.data) == null) ? false : bundle.getBoolean("key_result");
            if (QLog.isColorLevel()) {
                QLog.d("PeakIpcController", 2, "cancelSendVideoOrPhoto result:" + z16 + ", uinseq:" + this.f67429d.f68848o + ", status:" + this.f67429d.f68838e + ", progress:" + this.f67429d.f68839f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements EIPCResultCallback {
        c() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult != null) {
                QLog.d("PeakIpcController", 2, "sendPic result:" + eIPCResult.data.getBoolean("key_result"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements EIPCResultCallback {
        d() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult != null) {
                QLog.d("PeakIpcController", 2, "reSendMessage result:" + eIPCResult.data.getBoolean("key_result"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f67430d;

        e(String str) {
            this.f67430d = str;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult != null) {
                String string = eIPCResult.data.getString("uinname");
                if (QLog.isColorLevel()) {
                    QLog.i("PeakIpcController", 2, "getTroopMemberName success name = " + string);
                }
                SendPanelManager.k().D(this.f67430d, string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements EIPCResultCallback {
        f() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult != null) {
                QLog.d("PeakIpcController", 2, "sendVideoArkMsg result:" + eIPCResult.data.getBoolean("key_result"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g extends EIPCModule {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f67431d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f67432e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, h hVar, String str2) {
            super(str);
            this.f67431d = hVar;
            this.f67432e = str2;
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            if (bundle == null) {
                return null;
            }
            if ("action_upload_ark_video_progress_update".equals(str)) {
                if (bundle.containsKey("key_upload_ark_video_progress")) {
                    int i16 = bundle.getInt("key_upload_ark_video_progress");
                    h hVar = this.f67431d;
                    if (hVar != null) {
                        hVar.onProgress(i16);
                    }
                }
            } else if ("action_upload_ark_video_success".equals(str)) {
                String string = bundle.containsKey("key_upload_ark_video_download_url") ? bundle.getString("key_upload_ark_video_download_url") : null;
                ms.a.f("PeakIpcController", this.f67432e + " uploadArkVideo SUCCESS: videoDownUrl=" + string);
                h hVar2 = this.f67431d;
                if (hVar2 != null) {
                    hVar2.onSuccess(string);
                }
            } else if ("action_upload_ark_video_fail".equals(str)) {
                ms.a.f("PeakIpcController", this.f67432e + " uploadArkVideo FAIL");
                h hVar3 = this.f67431d;
                if (hVar3 != null) {
                    hVar3.onFail();
                }
            } else if ("action_upload_ark_video_cancel".equals(str)) {
                ms.a.f("PeakIpcController", this.f67432e + " uploadArkVideo CANCEL");
                h hVar4 = this.f67431d;
                if (hVar4 != null) {
                    hVar4.onCancel();
                }
            }
            return null;
        }
    }
}
