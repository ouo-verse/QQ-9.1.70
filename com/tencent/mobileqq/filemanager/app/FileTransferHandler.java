package com.tencent.mobileqq.filemanager.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.config.AppSetting;
import com.tencent.litetransfersdk.FileQueryReq;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.e;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.w;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.ac;
import com.tencent.mobileqq.service.message.k;
import com.tencent.mobileqq.service.message.m;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.Pair;
import com.tencent.xweb.FileReaderX5;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import org.apache.commons.lang.CharEncoding;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import tencent.im.cs.cmd0x345.cmd0x345$ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345$RspBody;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyDownloadAbsReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyDownloadAbsRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346$DeleteFileReq;
import tencent.im.cs.cmd0x346.cmd0x346$DeleteFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346$DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346$DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346$DownloadSuccRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346$FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346$RecallFileReq;
import tencent.im.cs.cmd0x346.cmd0x346$RecallFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346$RecvListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;
import tencent.im.cs.cmd0x346.cmd0x346$SendListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346$UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346$UploadSuccRsp;
import tencent.im.cs.face2face_file.face2face_file$msg;
import tencent.im.msg.hummer.resv.notonlinefile.tencent_im_msg_hummer_resv_notonlinefile$ResvAttr;
import tencent.im.msg.im_msg_body$GroupFile;
import tencent.im.msg.im_msg_body$NotOnlineFile;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_head$InstCtrl;
import tencent.im.msg.im_msg_head$InstInfo;
import tencent.im.msg.resv21.hummer_resv_21$FileApkInfo;
import tencent.im.msg.resv21.hummer_resv_21$FileAssitInfo;
import tencent.im.msg.resv21.hummer_resv_21$FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21$ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4$MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4$WlanRecvNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x5.SubMsgType0x5$MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7$MsgBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileTransferHandler {

    /* renamed from: h, reason: collision with root package name */
    private static final String f206931h = com.tencent.mobileqq.filemanager.app.d.class.getName();

    /* renamed from: i, reason: collision with root package name */
    private static int f206932i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static Handler f206933j = new a(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f206934k = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101};

    /* renamed from: a, reason: collision with root package name */
    public final QQAppInterface f206935a;

    /* renamed from: b, reason: collision with root package name */
    private long f206936b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Long, com.tencent.mobileqq.filemanager.app.d> f206937c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private DecimalFormat f206938d = new DecimalFormat("0.00");

    /* renamed from: e, reason: collision with root package name */
    AIOMessageSpreadManager f206939e = null;

    /* renamed from: f, reason: collision with root package name */
    private m f206940f = new m();

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.service.message.k f206941g = new com.tencent.mobileqq.service.message.k();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.app.FileTransferHandler$10, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass10 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f206942d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f206943e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f206944f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f206945h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f206946i;
        final /* synthetic */ FileTransferHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.f206942d + "] upload competed:");
            this.this$0.f206935a.getOnlineFileSessionCenter().r(this.f206943e, this.f206942d, this.f206944f, this.f206945h, this.f206946i);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.app.FileTransferHandler$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f206948d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f206949e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ short f206950f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f206951h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f206952i;
        final /* synthetic */ FileTransferHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            FileManagerEntity P = this.this$0.f206935a.getFileManagerDataCenter().P(this.f206948d, this.f206949e);
            if (P != null) {
                P.msgSeq = this.f206950f;
                P.msgUid = this.f206951h;
                P.msgTime = this.f206952i;
                this.this$0.f206935a.getFileManagerProxy().h0(P);
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, "online change to offline, update offline msg seq , uid and msgTime" + FileManagerUtil.printFileManagerEntityInfo(P));
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.app.FileTransferHandler$4, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f206959d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f206960e;
        final /* synthetic */ FileTransferHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.f206959d + "]  handle cmd 0x211-0x1.save to weiyun");
            this.this$0.f206935a.getOnlineFileSessionCenter().l(this.f206960e, this.f206959d, 4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object[] objArr = (Object[]) message.obj;
            ((com.tencent.mobileqq.filemanager.app.d) objArr[0]).i(message.what, ((Boolean) objArr[1]).booleanValue(), objArr[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private long f206985a;

        /* renamed from: b, reason: collision with root package name */
        private String f206986b;

        /* renamed from: c, reason: collision with root package name */
        private int f206987c;

        /* renamed from: d, reason: collision with root package name */
        private String f206988d;

        /* renamed from: e, reason: collision with root package name */
        private String f206989e;

        /* renamed from: f, reason: collision with root package name */
        private String f206990f;

        /* renamed from: g, reason: collision with root package name */
        private String f206991g;

        /* renamed from: h, reason: collision with root package name */
        private short f206992h;

        /* renamed from: i, reason: collision with root package name */
        private String f206993i;

        /* renamed from: j, reason: collision with root package name */
        private Bundle f206994j;

        /* renamed from: k, reason: collision with root package name */
        private cmd0x345$RspBody.SubCmd0x3RspBody f206995k;

        public b(long j3, String str, int i3, String str2, String str3, String str4, String str5, short s16, String str6, Bundle bundle, cmd0x345$RspBody.SubCmd0x3RspBody subCmd0x3RspBody) {
            this.f206985a = j3;
            this.f206986b = str;
            this.f206987c = i3;
            this.f206988d = str2;
            this.f206989e = str3;
            this.f206990f = str4;
            this.f206991g = str5;
            this.f206992h = s16;
            this.f206993i = str6;
            this.f206994j = bundle;
            this.f206995k = subCmd0x3RspBody;
        }

        public short a() {
            return this.f206992h;
        }

        public int b() {
            return this.f206987c;
        }

        public long c() {
            return this.f206985a;
        }

        public String d() {
            return this.f206990f;
        }

        public String e() {
            return this.f206988d;
        }

        public String f() {
            return this.f206989e;
        }

        public String g() {
            return this.f206986b;
        }

        public String h() {
            return this.f206993i;
        }

        public String i() {
            return this.f206991g;
        }

        public b j() {
            if (this.f206995k.str_host.has()) {
                this.f206986b = this.f206995k.str_host.get();
            }
            if (this.f206995k.uint32_port.has()) {
                this.f206987c = this.f206995k.uint32_port.get();
            }
            if (this.f206995k.str_check_sum.has()) {
                this.f206988d = this.f206995k.str_check_sum.get();
            }
            if (this.f206995k.str_cookie.has()) {
                this.f206989e = "FTN5K=" + this.f206995k.str_cookie.get();
            }
            if (this.f206995k.int32_ret_code.has()) {
                this.f206985a = this.f206995k.int32_ret_code.get();
            }
            if (this.f206995k.str_ret_msg.has()) {
                this.f206990f = this.f206995k.str_ret_msg.get();
            }
            if (this.f206995k.str_suggest_file_name.has()) {
                String str = this.f206995k.str_suggest_file_name.get();
                this.f206991g = str;
                this.f206991g = FileManagerUtil.getFileName(str);
            }
            if (this.f206995k.str_https_domain.has()) {
                this.f206994j.putString("strHttpsDomain", this.f206995k.str_https_domain.get());
            }
            if (this.f206995k.uint32_https_port.has()) {
                this.f206992h = (short) this.f206995k.uint32_https_port.get();
            }
            if (this.f206995k.str_dns.has()) {
                this.f206993i = this.f206995k.str_dns.get();
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f206997a;

        /* renamed from: b, reason: collision with root package name */
        public long f206998b;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f206999a;

        /* renamed from: b, reason: collision with root package name */
        private msg_comm$Msg f207000b;

        /* renamed from: c, reason: collision with root package name */
        private msg_comm$MsgHead f207001c;

        /* renamed from: d, reason: collision with root package name */
        private int f207002d;

        /* renamed from: e, reason: collision with root package name */
        private int f207003e;

        /* renamed from: f, reason: collision with root package name */
        private im_msg_body$NotOnlineFile f207004f;

        public d(msg_comm$Msg msg_comm_msg, msg_comm$MsgHead msg_comm_msghead, int i3, int i16) {
            this.f207000b = msg_comm_msg;
            this.f207001c = msg_comm_msghead;
            this.f207002d = i3;
            this.f207003e = i16;
        }

        private boolean a(SubMsgType0x4$MsgBody subMsgType0x4$MsgBody) {
            if (!subMsgType0x4$MsgBody.msg_not_online_file.has()) {
                if (QLog.isColorLevel()) {
                    QLog.e("FileTransferHandler<FileAssistant>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
                    return true;
                }
                return true;
            }
            return false;
        }

        private boolean e(msg_comm$Msg msg_comm_msg) {
            if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().rich_text.has()) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + msg_comm_msg.msg_body.has() + "hasRichT:" + msg_comm_msg.msg_body.get().rich_text.has());
                return true;
            }
            return true;
        }

        private boolean f(im_msg_body$RichText im_msg_body_richtext) {
            if (!im_msg_body_richtext.not_online_file.has()) {
                if (QLog.isColorLevel()) {
                    QLog.e("FileTransferHandler<FileAssistant>", 2, "hasNotOnlineFile");
                    return true;
                }
                return true;
            }
            return false;
        }

        public im_msg_body$NotOnlineFile b() {
            return this.f207004f;
        }

        public d c() {
            if (s.i(this.f207002d) && this.f207001c.c2c_cmd.has() && this.f207003e == 169) {
                if (e(this.f207000b)) {
                    this.f206999a = true;
                    return this;
                }
                im_msg_body$RichText im_msg_body_richtext = this.f207000b.msg_body.get().rich_text.get();
                if (f(im_msg_body_richtext)) {
                    this.f206999a = true;
                    return this;
                }
                this.f207004f = im_msg_body_richtext.not_online_file.get();
            } else if (this.f207002d == 529 && this.f207003e == 4) {
                try {
                    try {
                        SubMsgType0x4$MsgBody mergeFrom = new SubMsgType0x4$MsgBody().mergeFrom(this.f207000b.msg_body.get().msg_content.get().toByteArray());
                        if (a(mergeFrom)) {
                            this.f206999a = true;
                            return this;
                        }
                        this.f207004f = mergeFrom.msg_not_online_file.get();
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("FileTransferHandler<FileAssistant>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", e16);
                        }
                        this.f206999a = true;
                        return this;
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("FileTransferHandler<FileAssistant>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", e17);
                    }
                    this.f206999a = true;
                    return this;
                }
            } else {
                this.f206999a = true;
                return this;
            }
            this.f206999a = false;
            return this;
        }

        boolean d() {
            return this.f206999a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class f implements ProtoReqManagerImpl.IProtoRespBack {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<FileTransferHandler> f207017d;

        public f(FileTransferHandler fileTransferHandler) {
            this.f207017d = new WeakReference<>(fileTransferHandler);
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            FileTransferHandler fileTransferHandler = this.f207017d.get();
            if (fileTransferHandler == null) {
                QLog.e("FileTransferHandler<FileAssistant>", 1, "onProtoResp weakHandler is null! return");
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100".equals(protoReq.ssoCmd)) {
                fileTransferHandler.c0(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200".equals(protoReq.ssoCmd)) {
                fileTransferHandler.d0(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500".equals(protoReq.ssoCmd)) {
                fileTransferHandler.n0(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(protoReq.ssoCmd)) {
                fileTransferHandler.r0(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200".equals(protoReq.ssoCmd)) {
                fileTransferHandler.Q(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000".equals(protoReq.ssoCmd)) {
                fileTransferHandler.R(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(protoReq.ssoCmd)) {
                fileTransferHandler.T(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(protoReq.ssoCmd)) {
                fileTransferHandler.S(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100".equals(protoReq.ssoCmd)) {
                fileTransferHandler.b0(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900".equals(protoReq.ssoCmd)) {
                fileTransferHandler.g0(protoReq, protoResp);
                return;
            }
            if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(protoReq.ssoCmd)) {
                fileTransferHandler.P(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600".equals(protoReq.ssoCmd)) {
                fileTransferHandler.p0(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(protoReq.ssoCmd)) {
                fileTransferHandler.q0(protoReq, protoResp);
                return;
            }
            if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800".equals(protoReq.ssoCmd)) {
                fileTransferHandler.o0(protoReq, protoResp);
            } else if ("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ".equals(protoReq.ssoCmd)) {
                fileTransferHandler.i0(protoReq, protoResp);
            } else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400".equals(protoReq.ssoCmd)) {
                fileTransferHandler.e0(protoReq, protoResp);
            }
        }
    }

    public FileTransferHandler(QQAppInterface qQAppInterface) {
        this.f206935a = qQAppInterface;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        boolean z16;
        boolean z17;
        FileManagerEntity D;
        String str = "";
        String str2 = null;
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
            try {
                cmd0x345_rspbody.mergeFrom(wupBuffer);
                if (cmd0x345_rspbody.uint32_return_code.has()) {
                    i3 = cmd0x345_rspbody.uint32_return_code.get();
                } else {
                    i3 = 0;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x345_rspbody.msg_subcmd_0x6_rsp_body.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
                i3 = -100003;
            } else {
                cmd0x345$RspBody.SubCmd0x6RspBody subCmd0x6RspBody = cmd0x345_rspbody.msg_subcmd_0x6_rsp_body.get();
                if (subCmd0x6RspBody.str_ret_msg.has()) {
                    str = subCmd0x6RspBody.str_ret_msg.get();
                }
                if (subCmd0x6RspBody.str_file_id.has()) {
                    str2 = subCmd0x6RspBody.str_file_id.get();
                }
                z16 = true;
                if (i3 != 0) {
                    z16 = false;
                }
                if (str2 != null) {
                    z17 = false;
                } else {
                    z17 = z16;
                }
                long d16 = ((e) protoReq.busiData).d();
                D = this.f206935a.getFileManagerDataCenter().D(d16);
                if (D != null) {
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
                    return;
                }
                D.status = 0;
                x1(z17, D, str2, i3, str, d16);
                this.f206935a.getFileManagerDataCenter().f0(D);
                return;
            }
        }
        z16 = false;
        if (i3 != 0) {
        }
        if (str2 != null) {
        }
        long d162 = ((e) protoReq.busiData).d();
        D = this.f206935a.getFileManagerDataCenter().D(d162);
        if (D != null) {
        }
    }

    private void A1(long j3, boolean z16, int i3, String str, String str2, FileManagerEntity fileManagerEntity) {
        int i16 = fileManagerEntity.nOpType;
        if (i16 != 4) {
            if (i16 != 7) {
                if (i16 != 32) {
                    switch (i16) {
                        case 26:
                        case 27:
                            break;
                        case 28:
                            break;
                        case 29:
                            try {
                                w wVar = (w) fileManagerEntity.mContext;
                                if (wVar != null) {
                                    wVar.e(z16, fileManagerEntity.datalineEntitySessionId, i3, str, null, null, str2);
                                    return;
                                }
                                return;
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + e16.toString());
                                return;
                            }
                        default:
                            return;
                    }
                }
                try {
                    ((w) fileManagerEntity.mContext).d(z16, fileManagerEntity.strTroopFileUuid, fileManagerEntity.nSessionId, i3, str, String.valueOf(fileManagerEntity.peerUin), str2);
                    return;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + e17.toString());
                    return;
                }
            }
            z1(j3, z16, i3, str, str2, fileManagerEntity);
            return;
        }
        y1(j3, z16, i3, str, str2, fileManagerEntity);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        String str;
        String str2;
        int i16;
        String str3;
        String str4;
        String str5;
        String str6;
        short s16;
        boolean z16;
        e eVar;
        String str7 = "";
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
            try {
                cmd0x345_rspbody.mergeFrom(wupBuffer);
                if (cmd0x345_rspbody.uint32_return_code.has()) {
                    i3 = cmd0x345_rspbody.uint32_return_code.get();
                } else {
                    i3 = 0;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x345_rspbody.msg_subcmd_0x7_rsp_body.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: rspBody has not hasMsgApplyDownloadRsp");
                i3 = -100003;
            } else {
                cmd0x345$RspBody.SubCmd0x7RspBody subCmd0x7RspBody = cmd0x345_rspbody.msg_subcmd_0x7_rsp_body.get();
                str = subCmd0x7RspBody.str_server_ip.get();
                str2 = subCmd0x7RspBody.str_dns.get();
                i16 = subCmd0x7RspBody.uint32_server_port.get();
                str3 = subCmd0x7RspBody.str_url.get();
                str4 = subCmd0x7RspBody.str_ret_msg.get();
                str5 = "FTN5K=" + subCmd0x7RspBody.bytes_cookie.get().toStringUtf8();
                if (subCmd0x7RspBody.str_https_domain.has()) {
                    str6 = subCmd0x7RspBody.str_https_domain.get();
                } else {
                    str6 = null;
                }
                if (subCmd0x7RspBody.uint32_https_port.has()) {
                    s16 = (short) subCmd0x7RspBody.uint32_https_port.get();
                } else {
                    s16 = 0;
                }
                if (subCmd0x7RspBody.str_dns.has()) {
                    str7 = subCmd0x7RspBody.str_dns.get();
                }
                z16 = true;
                if (i3 != 0) {
                    z16 = false;
                }
                Bundle bundle = new Bundle();
                if (str6 != null) {
                    bundle.putString("strHttpsDomain", str6);
                }
                bundle.putShort("httpsPort", s16);
                bundle.putString("IPv6Dns", str7);
                eVar = (e) protoReq.busiData;
                if (!eVar.k()) {
                    this.f206935a.getFileManagerNotifyCenter().b(z16, 192, new Object[]{Integer.valueOf(i3), str4, str5, str3, str, str2, Integer.valueOf(i16), null, Long.valueOf(eVar.d()), bundle});
                    return;
                } else {
                    this.f206935a.getFileManagerNotifyCenter().b(z16, 21, new Object[]{Integer.valueOf(i3), str4, str5, str3, str, str2, Integer.valueOf(i16), bundle});
                    return;
                }
            }
        }
        z16 = false;
        i16 = 0;
        s16 = 0;
        str = "";
        str2 = str;
        str3 = str2;
        str4 = str3;
        str5 = str4;
        str6 = null;
        if (i3 != 0) {
        }
        Bundle bundle2 = new Bundle();
        if (str6 != null) {
        }
        bundle2.putShort("httpsPort", s16);
        bundle2.putString("IPv6Dns", str7);
        eVar = (e) protoReq.busiData;
        if (!eVar.k()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0143 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void C0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        long j3;
        e eVar = (e) protoReq.busiData;
        long d16 = eVar.d();
        QLog.i("FileTransferHandler<FileAssistant>", 2, "=_= ^ [Feed Replay] Id[" + d16 + "]sendDiscFeed Replay");
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + d16 + "]internalSendDiscFileRequest: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            j3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + d16 + "]internalSendDiscFileRequest: resp is failed[" + protoResp.resp.getResultCode() + "]");
            j3 = WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
            try {
                cmd0x345_rspbody.mergeFrom(wupBuffer);
                if (cmd0x345_rspbody.uint32_return_code.has()) {
                    j3 = cmd0x345_rspbody.uint32_return_code.get();
                } else {
                    j3 = 0;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x345_rspbody.msg_subcmd_0x2_rsp_body.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + d16 + "]internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
                z16 = false;
                j3 = -100003;
                if (j3 != 0) {
                    z16 = false;
                }
                if (d16 == 0) {
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay]why sessoinId is 0?!");
                } else {
                    FileManagerEntity D = this.f206935a.getFileManagerDataCenter().D(d16);
                    if (D != null) {
                        if (z16) {
                            D.status = 1;
                            this.f206935a.getFileManagerNotifyCenter().a(D, 6, "");
                        } else {
                            QLog.e("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay]nSessionId[" + d16 + "] sendDiscFeed faild,retCode[" + j3 + "]");
                            D.status = 0;
                            W0(j3, D);
                        }
                        this.f206935a.getFileManagerDataCenter().f0(D);
                    }
                }
                if (z16 && d16 > 0) {
                    FileManagerUtil.processAIOTimGraytips(this.f206935a, d16);
                }
                Q0(eVar.g(), 5016, z16, new Object[]{Long.valueOf(j3)});
            }
            z16 = true;
            if (j3 != 0) {
            }
            if (d16 == 0) {
            }
            if (z16) {
                FileManagerUtil.processAIOTimGraytips(this.f206935a, d16);
            }
            Q0(eVar.g(), 5016, z16, new Object[]{Long.valueOf(j3)});
        }
        z16 = false;
        if (j3 != 0) {
        }
        if (d16 == 0) {
        }
        if (z16) {
        }
        Q0(eVar.g(), 5016, z16, new Object[]{Long.valueOf(j3)});
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void D0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j3;
        long j16;
        String str7;
        String str8;
        String str9;
        int i3;
        String str10;
        String str11;
        short s16;
        boolean z16;
        long j17;
        String str12;
        long j18;
        boolean z17;
        long j19;
        String str13 = "";
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            j3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is failed[" + protoResp.resp.getResultCode() + "]");
            j3 = WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT;
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
            try {
                cmd0x345_rspbody.mergeFrom(wupBuffer);
                if (cmd0x345_rspbody.uint32_return_code.has()) {
                    j16 = cmd0x345_rspbody.uint32_return_code.get();
                } else {
                    j16 = 0;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x345_rspbody.msg_subcmd_0x1_rsp_body.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
                str6 = str5;
                j3 = -100003;
            } else {
                cmd0x345$RspBody.SubCmd0x1RspBody subCmd0x1RspBody = cmd0x345_rspbody.msg_subcmd_0x1_rsp_body.get();
                if (!subCmd0x1RspBody.str_file_id.has()) {
                    str7 = "";
                } else {
                    str7 = subCmd0x1RspBody.str_file_id.get();
                }
                if (!subCmd0x1RspBody.str_file_key.has()) {
                    str8 = "";
                } else {
                    str8 = subCmd0x1RspBody.str_file_key.get();
                }
                if (!subCmd0x1RspBody.str_check_sum.has()) {
                    str5 = "";
                } else {
                    str5 = subCmd0x1RspBody.str_check_sum.get();
                }
                if (!subCmd0x1RspBody.str_host.has()) {
                    str9 = "";
                } else {
                    str9 = subCmd0x1RspBody.str_host.get();
                }
                if (subCmd0x1RspBody.uint32_port.has()) {
                    i3 = subCmd0x1RspBody.uint32_port.get();
                } else {
                    i3 = 0;
                }
                if (!subCmd0x1RspBody.str_file_name.has()) {
                    str6 = "";
                } else {
                    str6 = subCmd0x1RspBody.str_file_name.get();
                }
                if (!subCmd0x1RspBody.str_warn.has()) {
                    str10 = "";
                } else {
                    str10 = subCmd0x1RspBody.str_warn.get();
                }
                if (subCmd0x1RspBody.str_https_domain.has()) {
                    str11 = subCmd0x1RspBody.str_https_domain.get();
                } else {
                    str11 = null;
                }
                if (subCmd0x1RspBody.uint32_https_port.has()) {
                    s16 = (short) subCmd0x1RspBody.uint32_https_port.get();
                } else {
                    s16 = 0;
                }
                if (subCmd0x1RspBody.str_dns.has()) {
                    str13 = subCmd0x1RspBody.str_dns.get();
                }
                str = str7;
                z16 = true;
                j17 = 0;
                String str14 = str10;
                str2 = str8;
                j3 = j16;
                str4 = str13;
                str13 = str9;
                str12 = str11;
                str3 = str14;
                if (j3 != j17) {
                    z16 = false;
                }
                e eVar = (e) protoReq.busiData;
                boolean z18 = z16;
                if (j3 != -100001) {
                    j19 = 9043;
                } else if (j3 == -100003) {
                    j19 = 9045;
                } else {
                    if (str13 != null && str13.length() != 0) {
                        j18 = j3;
                        z17 = false;
                    } else {
                        j18 = j3;
                        z17 = true;
                    }
                    int c16 = eVar.c();
                    if (z17 && c16 < 3) {
                        eVar.i();
                        q1(protoReq.ssoCmd, protoReq.reqBody, eVar);
                        return;
                    }
                    j19 = j18;
                }
                Bundle bundle = new Bundle();
                if (str12 != null) {
                    bundle.putString("strHttpsDomain", str12);
                }
                bundle.putShort("httpsPort", s16);
                bundle.putString("IPv6Dns", str4);
                Q0(eVar.g(), 5015, z18, new Object[]{Long.valueOf(j19), str, str2, str5, str13, Integer.valueOf(i3), str6, str3, bundle});
            }
        }
        s16 = 0;
        i3 = 0;
        z16 = false;
        str12 = null;
        j17 = 0;
        if (j3 != j17) {
        }
        e eVar2 = (e) protoReq.busiData;
        boolean z182 = z16;
        if (j3 != -100001) {
        }
        Bundle bundle2 = new Bundle();
        if (str12 != null) {
        }
        bundle2.putShort("httpsPort", s16);
        bundle2.putString("IPv6Dns", str4);
        Q0(eVar2.g(), 5015, z182, new Object[]{Long.valueOf(j19), str, str2, str5, str13, Integer.valueOf(i3), str6, str3, bundle2});
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ef, code lost:
    
        if (P0(java.lang.String.valueOf(r20), r9.bytes_file_uuid.get().toStringUtf8(), N(r12, r9, 0), r4, r14, r23, java.lang.String.valueOf(r12)) != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean G0(long j3, boolean z16, List<MessageRecord> list, int i3, msg_comm$Msg msg_comm_msg, msg_comm$MsgHead msg_comm_msghead) {
        boolean z17;
        if (!v(i3, msg_comm_msg)) {
            short s16 = (short) msg_comm_msghead.msg_seq.get();
            long j16 = msg_comm_msghead.from_uin.get();
            long j17 = msg_comm_msghead.msg_time.get();
            long j18 = msg_comm_msghead.msg_uid.get();
            int i16 = msg_comm_msghead.msg_type.get();
            int i17 = msg_comm_msg.msg_head.get().c2c_cmd.get();
            if ((s.i(i16) && msg_comm_msghead.c2c_cmd.has() && i17 == 169) || (i16 == 529 && i17 == 4)) {
                d c16 = new d(msg_comm_msg, msg_comm_msghead, i16, i17).c();
                if (!c16.d()) {
                    im_msg_body$NotOnlineFile b16 = c16.b();
                    if (!u0(b16)) {
                        int i18 = b16.uint32_file_type.get();
                        b16.uint64_file_size.get();
                        b16.uint32_subcmd.get();
                        if (!K0(z16, i18)) {
                            long j19 = s16;
                            MessageRecord w3 = w(0, String.valueOf(j3), String.valueOf(j16), j17, j19, j18);
                            if (w3 != null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
                                }
                                list.add(w3);
                            } else {
                                z17 = false;
                            }
                        }
                    }
                }
            } else {
                z17 = false;
            }
            return z17;
        }
        return true;
    }

    private boolean H0(ProtoReqManagerImpl.ProtoResp protoResp, com.tencent.mobileqq.filemanager.app.f fVar) {
        if (M0(protoResp)) {
            fVar.f207264m = -100001;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            return true;
        }
        if (protoResp.resp.getResultCode() != 1000) {
            fVar.f207264m = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
            return true;
        }
        return false;
    }

    private List<String> I(com.tencent.mobileqq.filemanager.app.f fVar, List<String> list, cmd0x346$RspBody cmd0x346_rspbody) {
        cmd0x346$ApplyUploadRsp cmd0x346_applyuploadrsp = cmd0x346_rspbody.msg_apply_upload_rsp.get();
        if (cmd0x346_applyuploadrsp.int32_ret_code.has()) {
            fVar.f207264m = cmd0x346_applyuploadrsp.int32_ret_code.get();
        }
        if (cmd0x346_applyuploadrsp.str_ret_msg.has()) {
            fVar.f207265n = cmd0x346_applyuploadrsp.str_ret_msg.get();
        }
        if (cmd0x346_applyuploadrsp.uint64_total_space.has()) {
            fVar.f207266o = cmd0x346_applyuploadrsp.uint64_total_space.get();
        }
        if (cmd0x346_applyuploadrsp.uint64_used_space.has()) {
            fVar.f207267p = cmd0x346_applyuploadrsp.uint64_used_space.get();
        }
        if (cmd0x346_applyuploadrsp.uint64_uploaded_size.has()) {
            fVar.f207268q = cmd0x346_applyuploadrsp.uint64_uploaded_size.get();
        }
        if (cmd0x346_applyuploadrsp.str_upload_ip.has()) {
            fVar.f207269r = cmd0x346_applyuploadrsp.str_upload_ip.get();
        } else if (cmd0x346_applyuploadrsp.str_upload_domain.has()) {
            fVar.f207269r = cmd0x346_applyuploadrsp.str_upload_domain.get();
        } else {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
        }
        if (cmd0x346_applyuploadrsp.uint32_upload_port.has()) {
            fVar.f207270s = (short) cmd0x346_applyuploadrsp.uint32_upload_port.get();
        }
        if (cmd0x346_applyuploadrsp.bytes_uuid.has()) {
            fVar.f207271t = cmd0x346_applyuploadrsp.bytes_uuid.get().toByteArray();
        }
        if (cmd0x346_applyuploadrsp.bytes_upload_key.has()) {
            fVar.f207272u = cmd0x346_applyuploadrsp.bytes_upload_key.get().toByteArray();
        }
        if (cmd0x346_applyuploadrsp.bool_file_exist.has()) {
            fVar.f207273v = cmd0x346_applyuploadrsp.bool_file_exist.get();
        }
        if (cmd0x346_applyuploadrsp.uint32_upload_port.has()) {
            fVar.f207274w = cmd0x346_applyuploadrsp.uint32_pack_size.get();
        }
        if (cmd0x346_applyuploadrsp.rpt_str_uploadip_list.has() && cmd0x346_applyuploadrsp.rpt_str_uploadip_list.get().size() > 0) {
            list = cmd0x346_applyuploadrsp.rpt_str_uploadip_list.get();
        }
        if (cmd0x346_applyuploadrsp.str_upload_dns.has()) {
            fVar.f207258g = cmd0x346_applyuploadrsp.str_upload_dns.get();
        }
        return list;
    }

    private boolean J0(boolean z16, boolean z17, boolean z18, boolean z19, int i3) {
        if (((z19 && z17) || z18 || z16) && i3 < 3) {
            return true;
        }
        return false;
    }

    private boolean K0(boolean z16, int i3) {
        if (z16 && i3 == 1) {
            return true;
        }
        return false;
    }

    private ic1.d L(jc1.a aVar) {
        ic1.d dVar = new ic1.d();
        dVar.f407454c = new ic1.a();
        aVar.f409770a = aVar.f409770a.replace(Marker.ANY_NON_NULL_MARKER, "");
        long parseLong = Long.parseLong(this.f206935a.getCurrentAccountUin());
        ic1.a aVar2 = dVar.f407454c;
        aVar2.f407422a = parseLong;
        aVar2.f407423b = Long.parseLong(aVar.f409770a);
        ic1.a aVar3 = dVar.f407454c;
        aVar3.f407424c = aVar.f409771b;
        aVar3.f407425d = new String(aVar.f409775f);
        dVar.f407454c.f407429h = new String(aVar.f409774e);
        ic1.a aVar4 = dVar.f407454c;
        aVar4.f407426e = aVar.f409776g;
        aVar4.f407428g = aVar.f409778i;
        aVar4.f407427f = aVar.f409779j;
        return dVar;
    }

    private boolean L0(int i3) {
        if (i3 != 1002 && i3 != 1013) {
            return false;
        }
        return true;
    }

    private boolean M0(ProtoReqManagerImpl.ProtoResp protoResp) {
        if (protoResp.resp.getResultCode() != 1002 && protoResp.resp.getResultCode() != 1013) {
            return false;
        }
        return true;
    }

    private int N(long j3, im_msg_body$NotOnlineFile im_msg_body_notonlinefile, int i3) {
        if (im_msg_body_notonlinefile.uint32_reserved.has()) {
            int i16 = im_msg_body_notonlinefile.uint32_reserved.get();
            if (i16 == j3) {
                return 0;
            }
            return i16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        e eVar = (e) protoReq.busiData;
        switch (eVar.h()) {
            case 1:
                D0(protoReq, protoResp);
                return;
            case 2:
                C0(protoReq, protoResp);
                return;
            case 3:
                y0(protoReq, protoResp);
                return;
            case 4:
            case 5:
                return;
            case 6:
                z0(protoReq, protoResp);
                return;
            case 7:
                A0(protoReq, protoResp);
                return;
            case 8:
                B0(protoReq, protoResp);
                return;
            case 9:
            default:
                QLog.e("FileTransferHandler<FileAssistant>", 1, "handleDiscGetFileInfo: subcmd[" + eVar.h() + "] is not implemented");
                return;
            case 10:
                w0(protoReq, protoResp);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean P0(String str, String str2, long j3, long j16, long j17, List<MessageRecord> list, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        List<FileManagerEntity> list2;
        String str8;
        int i3;
        String str9;
        FileManagerEntity fileManagerEntity;
        String str10;
        int i16;
        List<MessageRecord> list3;
        String str11;
        FileManagerEntity P;
        MessageRecord w06;
        FileTransferHandler fileTransferHandler = this;
        String str12 = str;
        long j18 = j16;
        long j19 = j17;
        List<MessageRecord> list4 = list;
        String str13 = "FileTransferHandler<FileAssistant>";
        if (j3 != 0 && (P = fileTransferHandler.f206935a.getFileManagerDataCenter().P(String.valueOf(str), j3)) != null) {
            if (!P.bDelInAio && (w06 = fileTransferHandler.f206935a.getMessageFacade().w0(String.valueOf(str), P.peerType, P.uniseq)) != null) {
                list4.add(w06);
            }
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "ol2offline duplicate msg, entity info" + FileManagerUtil.printFileManagerEntityInfo(P));
            }
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("msgFilterByFMDB,friendUin[");
        sb5.append(FileManagerUtil.enCodecString(str));
        sb5.append("],uuid[");
        sb5.append(str2);
        sb5.append("],olSessionId[");
        sb5.append(j3);
        sb5.append("],msgSeq[");
        sb5.append(j18);
        sb5.append("],msgUid[");
        sb5.append(j19);
        sb5.append("],senderuin[");
        sb5.append(FileManagerUtil.enCodecString(str3));
        String str14 = "]";
        sb5.append("]");
        QLog.i("FileTransferHandler<FileAssistant>", 1, sb5.toString());
        String str15 = "/offline";
        String str16 = "";
        String replace = str2.replace("/offline", "");
        List<FileManagerEntity> r16 = fileTransferHandler.f206935a.getFileManagerProxy().r();
        int i17 = 0;
        while (i17 < r16.size()) {
            FileManagerEntity fileManagerEntity2 = r16.get(i17);
            String replace2 = replace.replace(str15, str16);
            String str17 = replace;
            String str18 = fileManagerEntity2.Uuid;
            if (str18 != null) {
                str5 = str18.replace(str15, str16);
                str4 = str14;
            } else {
                str4 = str14;
                str5 = str16;
            }
            int i18 = fileManagerEntity2.nOpType;
            String str19 = str15;
            if (i18 != 0 && i18 != 1 && i18 != 3 && i18 != 7 && i18 != 21) {
                str6 = str17;
                str7 = str4;
                fileManagerEntity = fileManagerEntity2;
                list2 = r16;
                str8 = str16;
                str10 = str13;
                list3 = list4;
                i3 = i17;
                str9 = str19;
            } else if (j18 == fileManagerEntity2.msgSeq && j19 == fileManagerEntity2.msgUid) {
                List<FileManagerEntity> list5 = r16;
                MessageRecord w07 = fileTransferHandler.f206935a.getMessageFacade().w0(str12, fileManagerEntity2.peerType, fileManagerEntity2.uniseq);
                if (w07 != null) {
                    list4.add(w07);
                    if (QLog.isColorLevel()) {
                        QLog.d(str13, 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity2));
                        return true;
                    }
                    return true;
                }
                ArrayList arrayList = new ArrayList();
                list2 = list5;
                str8 = str16;
                String str20 = str13;
                i3 = i17;
                str6 = str17;
                str9 = str19;
                str7 = str4;
                v0(arrayList, str, str3, fileManagerEntity2.fileName, fileManagerEntity2.fileSize, fileManagerEntity2.isReaded, 0, null, j16, j16, str6, 0, fileManagerEntity2.uniseq, j17, -1L, fileManagerEntity2.srvTime / 1000, -2005, 0, null);
                if (arrayList.size() > 0) {
                    list.add(arrayList.get(0));
                    if (QLog.isColorLevel()) {
                        QLog.d(str20, 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity2));
                        return true;
                    }
                    return true;
                }
                fileManagerEntity = fileManagerEntity2;
                list3 = list;
                str10 = str20;
            } else {
                str6 = str17;
                str7 = str4;
                list2 = r16;
                str8 = str16;
                String str21 = str13;
                List<MessageRecord> list6 = list4;
                i3 = i17;
                str9 = str19;
                if (str5.equalsIgnoreCase(replace2)) {
                    MessageRecord w08 = this.f206935a.getMessageFacade().w0(str, fileManagerEntity2.peerType, fileManagerEntity2.uniseq);
                    if (w08 != null) {
                        list6.add(w08);
                        if (QLog.isColorLevel()) {
                            QLog.d(str21, 2, "duplicate msg, entity info" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity2));
                        }
                        return true;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    fileManagerEntity = fileManagerEntity2;
                    v0(arrayList2, str, str3, fileManagerEntity2.fileName, fileManagerEntity2.fileSize, fileManagerEntity2.isReaded, 0, null, j16, j16, str6, 0, fileManagerEntity2.uniseq, j17, -1L, fileManagerEntity2.srvTime / 1000, -2005, 0, null);
                    if (arrayList2.size() > 0) {
                        list.add(arrayList2.get(0));
                        if (QLog.isColorLevel()) {
                            QLog.d(str21, 2, "Uuid are all equal, duplicate msg, entity info" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity));
                            return true;
                        }
                        return true;
                    }
                    list3 = list;
                    str10 = str21;
                } else {
                    fileManagerEntity = fileManagerEntity2;
                    str10 = str21;
                    i16 = 1;
                    list3 = list6;
                    if (!QLog.isColorLevel()) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Entity [");
                        sb6.append(FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity));
                        str11 = str7;
                        sb6.append(str11);
                        QLog.w(str10, i16, sb6.toString());
                    } else {
                        str11 = str7;
                    }
                    i17 = i3 + 1;
                    fileTransferHandler = this;
                    str12 = str;
                    j18 = j16;
                    j19 = j17;
                    list4 = list3;
                    str13 = str10;
                    str14 = str11;
                    r16 = list2;
                    str16 = str8;
                    replace = str6;
                    str15 = str9;
                }
            }
            i16 = 1;
            if (!QLog.isColorLevel()) {
            }
            i17 = i3 + 1;
            fileTransferHandler = this;
            str12 = str;
            j18 = j16;
            j19 = j17;
            list4 = list3;
            str13 = str10;
            str14 = str11;
            r16 = list2;
            str16 = str8;
            replace = str6;
            str15 = str9;
        }
        return false;
    }

    public static Pair<String, String> T0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        if (bytes.length <= 36) {
            return null;
        }
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[bytes.length - 32];
        for (int i3 = 0; i3 < bytes.length; i3++) {
            if (i3 < 32) {
                bArr[i3] = bytes[i3];
            } else {
                bArr2[i3 - 32] = bytes[i3];
            }
        }
        return new Pair<>(new String(bArr), new String(bArr2));
    }

    private void U(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, k.b bVar) {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "check handleGetOffLineFileResp is not used!");
    }

    private void W0(long j3, FileManagerEntity fileManagerEntity) {
        MessageHandler messageHandler;
        if ((j3 != -5 && j3 != -6) || (messageHandler = (MessageHandler) this.f206935a.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)) == null) {
            return;
        }
        messageHandler.notifyBusiness(3008, false, new Object[]{fileManagerEntity.peerUin, 3000, 103});
    }

    private void X0(FileManagerEntity fileManagerEntity, String str) {
        DataLineHandler dataLineHandler = (DataLineHandler) this.f206935a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        MsgCSBody0x346 msgCSBody0x346 = new MsgCSBody0x346();
        msgCSBody0x346.uMsgSubType = 1400;
        FileQueryReq fileQueryReq = new FileQueryReq();
        msgCSBody0x346.fileQueryReq = fileQueryReq;
        fileQueryReq.uint64_uin = this.f206935a.getLongAccountUin();
        msgCSBody0x346.fileQueryReq.bytes_uuid = fileManagerEntity.Uuid.getBytes();
        msgCSBody0x346.uint32_business_id = 3;
        Bundle bundle = new Bundle();
        bundle.putBoolean("newAssistant", true);
        bundle.putString(PreDownloadConstants.RPORT_KEY_FILE_KEY, str);
        dataLineHandler.j4(fileManagerEntity.nSessionId, msgCSBody0x346, bundle);
    }

    private List<String> Z0(com.tencent.mobileqq.filemanager.app.f fVar, List<String> list, cmd0x346$ApplyUploadRspV3 cmd0x346_applyuploadrspv3) {
        if (cmd0x346_applyuploadrspv3.int32_ret_code.has()) {
            fVar.f207264m = cmd0x346_applyuploadrspv3.int32_ret_code.get();
        }
        if (cmd0x346_applyuploadrspv3.str_ret_msg.has()) {
            fVar.f207265n = cmd0x346_applyuploadrspv3.str_ret_msg.get();
        }
        if (cmd0x346_applyuploadrspv3.uint64_total_space.has()) {
            fVar.f207266o = cmd0x346_applyuploadrspv3.uint64_total_space.get();
        }
        if (cmd0x346_applyuploadrspv3.uint64_used_space.has()) {
            fVar.f207267p = cmd0x346_applyuploadrspv3.uint64_used_space.get();
        }
        if (cmd0x346_applyuploadrspv3.uint64_uploaded_size.has()) {
            fVar.f207268q = cmd0x346_applyuploadrspv3.uint64_uploaded_size.get();
        }
        if (cmd0x346_applyuploadrspv3.str_upload_ip.has()) {
            fVar.f207269r = cmd0x346_applyuploadrspv3.str_upload_ip.get();
        } else if (cmd0x346_applyuploadrspv3.str_upload_domain.has()) {
            fVar.f207269r = cmd0x346_applyuploadrspv3.str_upload_domain.get();
        } else {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
        }
        if (cmd0x346_applyuploadrspv3.uint32_upload_port.has()) {
            fVar.f207270s = (short) cmd0x346_applyuploadrspv3.uint32_upload_port.get();
        }
        if (cmd0x346_applyuploadrspv3.bytes_uuid.has()) {
            fVar.f207271t = cmd0x346_applyuploadrspv3.bytes_uuid.get().toByteArray();
        }
        if (cmd0x346_applyuploadrspv3.bytes_upload_key.has()) {
            fVar.f207272u = cmd0x346_applyuploadrspv3.bytes_upload_key.get().toByteArray();
        }
        if (cmd0x346_applyuploadrspv3.bool_file_exist.has()) {
            fVar.f207273v = cmd0x346_applyuploadrspv3.bool_file_exist.get();
        }
        if (fVar.f207261j) {
            if (fVar.f207273v) {
                if (cmd0x346_applyuploadrspv3.str_fileidcrc.has()) {
                    fVar.f207263l = cmd0x346_applyuploadrspv3.str_fileidcrc.get();
                }
            } else if (cmd0x346_applyuploadrspv3.bytes_media_plateform_upload_key.has()) {
                fVar.f207262k = cmd0x346_applyuploadrspv3.bytes_media_plateform_upload_key.get().toByteArray();
            } else {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform but has not bytes_media_plateform_upload_key");
            }
        }
        if (cmd0x346_applyuploadrspv3.uint32_upload_port.has()) {
            fVar.f207274w = cmd0x346_applyuploadrspv3.uint32_pack_size.get();
        }
        if (cmd0x346_applyuploadrspv3.rpt_str_uploadip_list.has() && cmd0x346_applyuploadrspv3.rpt_str_uploadip_list.get().size() > 0) {
            list = cmd0x346_applyuploadrspv3.rpt_str_uploadip_list.get();
        }
        if (cmd0x346_applyuploadrspv3.str_upload_https_domain.has()) {
            fVar.f207256e = cmd0x346_applyuploadrspv3.str_upload_https_domain.get();
        }
        if (cmd0x346_applyuploadrspv3.uint32_upload_https_port.has()) {
            fVar.f207257f = (short) cmd0x346_applyuploadrspv3.uint32_upload_https_port.get();
        }
        if (cmd0x346_applyuploadrspv3.str_upload_dns.has()) {
            fVar.f207258g = cmd0x346_applyuploadrspv3.str_upload_dns.get();
        }
        if (cmd0x346_applyuploadrspv3.str_upload_lanip.has()) {
            fVar.f207259h = cmd0x346_applyuploadrspv3.str_upload_lanip.get();
        }
        return list;
    }

    private List<String> a1(com.tencent.mobileqq.filemanager.app.f fVar, List<String> list, cmd0x346$ApplyUploadRspV2 cmd0x346_applyuploadrspv2) {
        if (cmd0x346_applyuploadrspv2.int32_ret_code.has()) {
            fVar.f207264m = cmd0x346_applyuploadrspv2.int32_ret_code.get();
        }
        if (cmd0x346_applyuploadrspv2.str_ret_msg.has()) {
            fVar.f207265n = cmd0x346_applyuploadrspv2.str_ret_msg.get();
        }
        if (cmd0x346_applyuploadrspv2.uint64_total_space.has()) {
            fVar.f207266o = cmd0x346_applyuploadrspv2.uint64_total_space.get();
        }
        if (cmd0x346_applyuploadrspv2.uint64_used_space.has()) {
            fVar.f207267p = cmd0x346_applyuploadrspv2.uint64_used_space.get();
        }
        if (cmd0x346_applyuploadrspv2.uint64_uploaded_size.has()) {
            fVar.f207268q = cmd0x346_applyuploadrspv2.uint64_uploaded_size.get();
        }
        if (cmd0x346_applyuploadrspv2.str_upload_ip.has()) {
            fVar.f207269r = cmd0x346_applyuploadrspv2.str_upload_ip.get();
        } else if (cmd0x346_applyuploadrspv2.str_upload_domain.has()) {
            fVar.f207269r = cmd0x346_applyuploadrspv2.str_upload_domain.get();
        } else {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
        }
        if (cmd0x346_applyuploadrspv2.uint32_upload_port.has()) {
            fVar.f207270s = (short) cmd0x346_applyuploadrspv2.uint32_upload_port.get();
        }
        if (cmd0x346_applyuploadrspv2.bytes_uuid.has()) {
            fVar.f207271t = cmd0x346_applyuploadrspv2.bytes_uuid.get().toByteArray();
        }
        if (cmd0x346_applyuploadrspv2.bytes_upload_key.has()) {
            fVar.f207272u = cmd0x346_applyuploadrspv2.bytes_upload_key.get().toByteArray();
        }
        if (cmd0x346_applyuploadrspv2.bool_file_exist.has()) {
            fVar.f207273v = cmd0x346_applyuploadrspv2.bool_file_exist.get();
        }
        if (cmd0x346_applyuploadrspv2.uint32_upload_port.has()) {
            fVar.f207274w = cmd0x346_applyuploadrspv2.uint32_pack_size.get();
        }
        if (cmd0x346_applyuploadrspv2.uint32_httpsvr_api_ver.has()) {
            fVar.f207255d = cmd0x346_applyuploadrspv2.uint32_httpsvr_api_ver.get();
        }
        if (cmd0x346_applyuploadrspv2.bytes_sha.has()) {
            fVar.f207253b = cmd0x346_applyuploadrspv2.bytes_sha.get().toByteArray();
        }
        if (cmd0x346_applyuploadrspv2.rpt_str_uploadip_list.has() && cmd0x346_applyuploadrspv2.rpt_str_uploadip_list.get().size() > 0) {
            list = cmd0x346_applyuploadrspv2.rpt_str_uploadip_list.get();
        }
        if (cmd0x346_applyuploadrspv2.str_upload_https_domain.has()) {
            fVar.f207256e = cmd0x346_applyuploadrspv2.str_upload_https_domain.get();
        }
        if (cmd0x346_applyuploadrspv2.uint32_upload_https_port.has()) {
            fVar.f207257f = (short) cmd0x346_applyuploadrspv2.uint32_upload_https_port.get();
        }
        if (cmd0x346_applyuploadrspv2.str_upload_dns.has()) {
            fVar.f207258g = cmd0x346_applyuploadrspv2.str_upload_dns.get();
        }
        if (cmd0x346_applyuploadrspv2.str_upload_lanip.has()) {
            fVar.f207259h = cmd0x346_applyuploadrspv2.str_upload_lanip.get();
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        boolean z17;
        ProtoReqManagerImpl.ProtoReq protoReq2;
        boolean z18;
        int i3;
        ArrayList arrayList = new ArrayList();
        boolean z19 = false;
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x346_rspbody.msg_recv_list_query_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: rspBody has not msg_recv_list_query_rsp");
            } else {
                cmd0x346$RecvListQueryRsp cmd0x346_recvlistqueryrsp = cmd0x346_rspbody.msg_recv_list_query_rsp.get();
                if (cmd0x346_recvlistqueryrsp.int32_ret_code.has() && (i3 = cmd0x346_recvlistqueryrsp.int32_ret_code.get()) != 0) {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: failed retCode[" + i3 + "]");
                } else {
                    if (cmd0x346_rspbody.uint32_flag_use_media_platform.has()) {
                        if (cmd0x346_rspbody.uint32_flag_use_media_platform.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: bUseMediaPlatform " + z16);
                    } else {
                        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
                        z16 = false;
                    }
                    for (cmd0x346$FileInfo cmd0x346_fileinfo : cmd0x346_recvlistqueryrsp.rpt_msg_file_list.get()) {
                        OfflineFileInfo offlineFileInfo = new OfflineFileInfo();
                        offlineFileInfo.f207720d = z19;
                        offlineFileInfo.f207724i = cmd0x346_fileinfo.uint32_danger_evel.get();
                        offlineFileInfo.C = cmd0x346_fileinfo.uint64_file_size.get();
                        offlineFileInfo.D = (com.tencent.mobileqq.service.message.e.K0() * 1000) + (cmd0x346_fileinfo.uint32_life_time.get() * 1000);
                        offlineFileInfo.E = cmd0x346_fileinfo.uint32_upload_time.get() * 1000;
                        offlineFileInfo.f207725m = cmd0x346_fileinfo.str_file_name.get();
                        offlineFileInfo.f207721e = new String(cmd0x346_fileinfo.bytes_uuid.get().toByteArray());
                        if (z16) {
                            offlineFileInfo.f207722f = cmd0x346_fileinfo.str_fileidcrc.get();
                        }
                        offlineFileInfo.f207723h = cmd0x346_fileinfo.uint64_uin.get();
                        offlineFileInfo.F = HexUtil.bytes2HexStr(cmd0x346_fileinfo.bytes_md5.get().toByteArray());
                        arrayList.add(offlineFileInfo);
                        if (QLog.isColorLevel()) {
                            QLog.d("FileTransferHandler<FileAssistant>", 2, "handleQueryRecvListResponse OfflineFileInfo[" + offlineFileInfo.toString() + "]");
                        }
                        z19 = false;
                    }
                    if (cmd0x346_recvlistqueryrsp.uint32_is_end.get() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    protoReq2 = protoReq;
                    z18 = true;
                    Q0(((e) protoReq2.busiData).g(), 5021, z18, new Object[]{Boolean.valueOf(z17), arrayList});
                }
            }
        }
        protoReq2 = protoReq;
        z17 = true;
        z18 = false;
        Q0(((e) protoReq2.busiData).g(), 5021, z18, new Object[]{Boolean.valueOf(z17), arrayList});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        boolean z17;
        ProtoReqManagerImpl.ProtoReq protoReq2;
        boolean z18;
        int i3;
        ArrayList arrayList = new ArrayList();
        boolean z19 = true;
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x346_rspbody.msg_send_list_query_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: rspBody has not msg_send_list_query_rsp");
            } else {
                cmd0x346$SendListQueryRsp cmd0x346_sendlistqueryrsp = cmd0x346_rspbody.msg_send_list_query_rsp.get();
                if (cmd0x346_sendlistqueryrsp.int32_ret_code.has() && (i3 = cmd0x346_sendlistqueryrsp.int32_ret_code.get()) != 0) {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: failed retCode[" + i3 + "]");
                } else {
                    if (cmd0x346_rspbody.uint32_flag_use_media_platform.has()) {
                        if (cmd0x346_rspbody.uint32_flag_use_media_platform.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: bUseMediaPlatform " + z16);
                    } else {
                        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
                        z16 = false;
                    }
                    for (cmd0x346$FileInfo cmd0x346_fileinfo : cmd0x346_sendlistqueryrsp.rpt_msg_file_list.get()) {
                        OfflineFileInfo offlineFileInfo = new OfflineFileInfo();
                        offlineFileInfo.f207720d = z19;
                        offlineFileInfo.f207724i = cmd0x346_fileinfo.uint32_danger_evel.get();
                        offlineFileInfo.C = cmd0x346_fileinfo.uint64_file_size.get();
                        offlineFileInfo.D = (com.tencent.mobileqq.service.message.e.K0() * 1000) + (cmd0x346_fileinfo.uint32_life_time.get() * 1000);
                        offlineFileInfo.E = cmd0x346_fileinfo.uint32_upload_time.get() * 1000;
                        offlineFileInfo.f207725m = cmd0x346_fileinfo.str_file_name.get();
                        offlineFileInfo.f207721e = new String(cmd0x346_fileinfo.bytes_uuid.get().toByteArray());
                        if (z16) {
                            offlineFileInfo.f207722f = cmd0x346_fileinfo.str_fileidcrc.get();
                        }
                        offlineFileInfo.f207723h = cmd0x346_fileinfo.uint64_uin.get();
                        offlineFileInfo.F = HexUtil.bytes2HexStr(cmd0x346_fileinfo.bytes_md5.get().toByteArray());
                        arrayList.add(offlineFileInfo);
                        if (QLog.isColorLevel()) {
                            QLog.d("FileTransferHandler<FileAssistant>", 2, "handleQuerySendListResponse OfflineFileInfo[" + offlineFileInfo.toString() + "]");
                        }
                        z19 = true;
                    }
                    if (cmd0x346_sendlistqueryrsp.uint32_is_end.get() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    protoReq2 = protoReq;
                    z18 = true;
                    Q0(((e) protoReq2.busiData).g(), 5022, z18, new Object[]{Boolean.valueOf(z17), arrayList});
                }
            }
        }
        protoReq2 = protoReq;
        z17 = true;
        z18 = false;
        Q0(((e) protoReq2.busiData).g(), 5022, z18, new Object[]{Boolean.valueOf(z17), arrayList});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse ");
        }
        boolean z16 = true;
        boolean z17 = false;
        String str = null;
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x346_rspbody.msg_recall_file_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
                z16 = false;
                i3 = -100003;
                if (i3 == 0) {
                    z17 = z16;
                }
                e.a aVar = (e.a) ((e) protoReq.busiData).f();
                if (QLog.isColorLevel()) {
                    QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse [" + z17 + "],retCode[" + i3 + "], retMsg[" + str + "]");
                }
                if (z17) {
                    aVar.onSuccess();
                    return;
                } else {
                    aVar.onError(i3, str);
                    return;
                }
            }
            cmd0x346$RecallFileRsp cmd0x346_recallfilersp = cmd0x346_rspbody.msg_recall_file_rsp.get();
            if (cmd0x346_recallfilersp.int32_ret_code.has()) {
                i16 = cmd0x346_recallfilersp.int32_ret_code.get();
            } else {
                i16 = 0;
            }
            if (cmd0x346_recallfilersp.str_ret_msg.has()) {
                str = cmd0x346_recallfilersp.str_ret_msg.get();
            }
            i3 = i16;
            if (i3 == 0) {
            }
            e.a aVar2 = (e.a) ((e) protoReq.busiData).f();
            if (QLog.isColorLevel()) {
            }
            if (z17) {
            }
        }
        z16 = false;
        if (i3 == 0) {
        }
        e.a aVar22 = (e.a) ((e) protoReq.busiData).f();
        if (QLog.isColorLevel()) {
        }
        if (z17) {
        }
    }

    private void f1(ToServiceMsg toServiceMsg) {
        n(toServiceMsg);
        NewIntent newIntent = new NewIntent(this.f206935a.getApplication(), com.tencent.mobileqq.filemanager.app.e.class);
        newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
        this.f206935a.startServlet(newIntent);
        toServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        int i3;
        int i16;
        WeiYunFileInfo removeDeletedCloudFile;
        String str = null;
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x346_rspbody.msg_delete_file_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
                z16 = false;
                i3 = -100003;
                if (i3 != 0) {
                    z16 = false;
                }
                String e17 = ((e) protoReq.busiData).e();
                removeDeletedCloudFile = ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).removeDeletedCloudFile(e17);
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse, bSuccess[" + String.valueOf(z16) + "]");
                if (removeDeletedCloudFile != null) {
                    this.f206935a.getFileManagerNotifyCenter().b(z16, 20, new Object[]{Integer.valueOf(i3), str, e17, removeDeletedCloudFile.f209605f, Boolean.TRUE});
                    return;
                }
                return;
            }
            cmd0x346$DeleteFileRsp cmd0x346_deletefilersp = cmd0x346_rspbody.msg_delete_file_rsp.get();
            if (cmd0x346_deletefilersp.int32_ret_code.has()) {
                i16 = cmd0x346_deletefilersp.int32_ret_code.get();
            } else {
                i16 = 0;
            }
            if (cmd0x346_deletefilersp.str_ret_msg.has()) {
                str = cmd0x346_deletefilersp.str_ret_msg.get();
            }
            i3 = i16;
            z16 = true;
            if (i3 != 0) {
            }
            String e172 = ((e) protoReq.busiData).e();
            removeDeletedCloudFile = ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).removeDeletedCloudFile(e172);
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse, bSuccess[" + String.valueOf(z16) + "]");
            if (removeDeletedCloudFile != null) {
            }
        }
        z16 = false;
        if (i3 != 0) {
        }
        String e1722 = ((e) protoReq.busiData).e();
        removeDeletedCloudFile = ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).removeDeletedCloudFile(e1722);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse, bSuccess[" + String.valueOf(z16) + "]");
        if (removeDeletedCloudFile != null) {
        }
    }

    private void h0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "handleReqOffFilePackError, count: " + i3);
        }
        if (i3 < 3) {
            toServiceMsg.extraData.putInt("retryIndex", i3 + 1);
            f1(toServiceMsg);
            return;
        }
        StatictisInfo statictisInfo = new StatictisInfo();
        statictisInfo.errCode = fromServiceMsg.getResultCode();
        statictisInfo.retryCount = i3;
        if (fromServiceMsg.getResultCode() == 1000) {
            statictisInfo.errCode = BaseConstants.CODE_SERVER_RETURN_ERROR;
            statictisInfo.detailErrorReason = fromServiceMsg.extraData.getLong("ServerReplyCode", StatictisInfo.DETAIL_REASON_UNKNOWN);
        }
        statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
        String string = toServiceMsg.extraData.getString("uin");
        int i16 = toServiceMsg.extraData.getInt("offfile_type");
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    R0(toServiceMsg, 5004, false, new Object[]{string, statictisInfo});
                    return;
                }
                return;
            }
            R0(toServiceMsg, 5005, false, new Object[]{string, statictisInfo});
            return;
        }
        R0(toServiceMsg, 5003, false, new Object[]{string, statictisInfo});
    }

    private msg_svc$PbSendMsgReq h1(String str, int i3, byte[] bArr, long j3, int i16) {
        int i17;
        long genMsgUid = FileManagerUtil.genMsgUid();
        long genMsgSeq = FileManagerUtil.genMsgSeq();
        ac acVar = new ac();
        acVar.f286177a = i3;
        acVar.f286178b = bArr;
        msg_svc$PbSendMsgReq a16 = p.a(this.f206935a, 13, str, acVar, genMsgSeq, s.g(genMsgUid));
        im_msg_head$InstInfo im_msg_head_instinfo = new im_msg_head$InstInfo();
        if (i16 == 3) {
            i17 = 1001;
        } else {
            i17 = 1;
        }
        im_msg_head_instinfo.uint32_apppid.set(i17);
        im_msg_head_instinfo.uint32_instid.set(0);
        im_msg_head_instinfo.enum_device_type.set(i16);
        im_msg_head_instinfo.setHasFlag(true);
        a16.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(im_msg_head_instinfo);
        im_msg_head$InstInfo im_msg_head_instinfo2 = new im_msg_head$InstInfo();
        im_msg_head_instinfo2.uint32_apppid.set(1001);
        im_msg_head_instinfo2.uint32_instid.set(AppSetting.f());
        im_msg_head_instinfo2.enum_device_type.set(2);
        im_msg_head_instinfo2.setHasFlag(true);
        im_msg_head$InstCtrl im_msg_head_instctrl = a16.routing_head.trans_0x211.inst_ctrl;
        im_msg_head_instctrl.msg_from_inst = im_msg_head_instinfo2;
        im_msg_head_instctrl.setHasFlag(true);
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        long j3;
        face2face_file$msg face2face_file_msg = new face2face_file$msg();
        SharedPreferences sharedPreferences = this.f206935a.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResistTerrorist: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            j3 = -100001L;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResistTerrorist: resp is failed[" + protoResp.resp.getResultCode() + "]");
            j3 = WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT;
        } else {
            try {
                face2face_file_msg.mergeFrom(protoResp.resp.getWupBuffer());
                j3 = 0;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                j3 = -100003;
            }
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (face2face_file_msg.has() && face2face_file_msg.result.has()) {
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "handleResistTerrorist: return resMessage.result:" + face2face_file_msg.result.get());
            }
            edit.putInt("QlinkResistTerrorist_res", face2face_file_msg.result.get());
            edit.putLong("SettingQlinkResistTerroristLastTime", com.tencent.mobileqq.service.message.e.K0());
            edit.putString("SettingQlinkResistTerroristLastAccount", this.f206935a.getCurrentAccountUin());
        }
        edit.commit();
        if (j3 == -100001) {
            j3 = 9043;
        } else if (j3 == -100003) {
            j3 = 9045;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "handleResistTerrorist: return " + face2face_file_msg.result + " ,retCode:" + j3);
        }
    }

    public static void j(im_msg_body$NotOnlineFile im_msg_body_notonlinefile, int i3) {
        if (im_msg_body_notonlinefile != null && i3 != 0) {
            tencent_im_msg_hummer_resv_notonlinefile$ResvAttr tencent_im_msg_hummer_resv_notonlinefile_resvattr = new tencent_im_msg_hummer_resv_notonlinefile$ResvAttr();
            if (im_msg_body_notonlinefile.bytes_pb_reserve.has()) {
                try {
                    tencent_im_msg_hummer_resv_notonlinefile_resvattr.mergeFrom(im_msg_body_notonlinefile.bytes_pb_reserve.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.d("FileTransferHandler<FileAssistant>", 1, e16, new Object[0]);
                }
            }
            tencent_im_msg_hummer_resv_notonlinefile_resvattr.uint32_file_from_scene.set(i3);
            im_msg_body_notonlinefile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(tencent_im_msg_hummer_resv_notonlinefile_resvattr.toByteArray()));
        }
    }

    private void k0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, k.b bVar) {
        int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
        StatictisInfo statictisInfo = new StatictisInfo();
        statictisInfo.errCode = fromServiceMsg.getResultCode();
        statictisInfo.retryCount = i3;
        R0(toServiceMsg, 5003, true, new Object[]{bVar.f286298m, statictisInfo});
    }

    private boolean l(SubMsgType0x4$WlanRecvNotify subMsgType0x4$WlanRecvNotify) {
        if (!subMsgType0x4$WlanRecvNotify.uint64_session_id.has()) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no session_id");
            return false;
        }
        if (!subMsgType0x4$WlanRecvNotify.uint32_send_client_type.has()) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no send_type");
            return false;
        }
        if (!subMsgType0x4$WlanRecvNotify.uint32_target_client_type.has()) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no recv_type");
            return false;
        }
        if (!subMsgType0x4$WlanRecvNotify.str_file_name.has()) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no file_name");
            return false;
        }
        if (!subMsgType0x4$WlanRecvNotify.uint64_file_size.has()) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no file_size");
            return false;
        }
        if (subMsgType0x4$WlanRecvNotify.uint32_time.has()) {
            return true;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "checkHandleWlanNotifyParam has no time");
        return false;
    }

    private void l0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, k.b bVar) {
        if (bVar != null && bVar.f286287b == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
            }
            int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = fromServiceMsg.getResultCode();
            statictisInfo.retryCount = i3;
            statictisInfo.appSeq = fromServiceMsg.getAppSeq();
            R0(toServiceMsg, 5004, true, new Object[]{bVar, statictisInfo});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->handleError");
        }
        h0(toServiceMsg, fromServiceMsg);
    }

    private void m0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, k.b bVar) {
        if (bVar != null && bVar.f286287b == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
            }
            int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = fromServiceMsg.getResultCode();
            statictisInfo.retryCount = i3;
            R0(toServiceMsg, 5005, true, new Object[]{bVar, statictisInfo});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->handleError");
        }
        h0(toServiceMsg, fromServiceMsg);
    }

    private void n(ToServiceMsg toServiceMsg) {
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        int i3 = f206932i;
        f206932i = i3 + 1;
        uniPacket.setRequestId(i3);
        this.f206940f.w(toServiceMsg, uniPacket);
        toServiceMsg.putWupBuffer(uniPacket.encode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        List<String> list;
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        int i3;
        boolean z19;
        byte[] bArr;
        boolean z26;
        e eVar;
        String str2;
        com.tencent.mobileqq.filemanager.app.f fVar = new com.tencent.mobileqq.filemanager.app.f();
        if (!H0(protoResp, fVar)) {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            fVar.f207260i = wupBuffer;
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
            }
            if (!cmd0x346_rspbody.msg_apply_upload_rsp.has()) {
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            } else {
                list = I(fVar, null, cmd0x346_rspbody);
                z16 = true;
                if (fVar.f207264m != 0 && ((str2 = fVar.f207269r) == null || str2.length() == 0)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                str = fVar.f207269r;
                if (str == null && str.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                i3 = fVar.f207264m;
                if (i3 == -91245 && i3 != -7010) {
                    z19 = false;
                } else {
                    z19 = true;
                }
                bArr = fVar.f207271t;
                if (bArr == null && bArr.length != 0) {
                    z26 = false;
                } else {
                    z26 = true;
                }
                eVar = (e) protoReq.busiData;
                if (!J0(z17, z18, z19, z26, eVar.c())) {
                    eVar.i();
                    q1(protoReq.ssoCmd, protoReq.reqBody, eVar);
                    return;
                }
                StatictisInfo statictisInfo = new StatictisInfo();
                statictisInfo.errCode = fVar.f207264m;
                statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
                if (z26 && z18) {
                    fVar.f207265n = "uuid_null[" + fVar.toString() + "]";
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + z16 + ", retCode=" + fVar.f207264m + ", retMsg=" + fVar.f207265n + ", totalSpace=" + fVar.f207266o + ", usedSpace=" + fVar.f207267p + ", ip=" + fVar.f207269r + ", port=" + ((int) fVar.f207270s));
                }
                Q0(eVar.g(), 5004, z16, new Object[]{fVar, statictisInfo, list});
                return;
            }
        }
        list = null;
        z16 = false;
        if (fVar.f207264m != 0) {
        }
        z17 = false;
        str = fVar.f207269r;
        if (str == null) {
        }
        z18 = false;
        i3 = fVar.f207264m;
        if (i3 == -91245) {
        }
        z19 = true;
        bArr = fVar.f207271t;
        if (bArr == null) {
        }
        z26 = true;
        eVar = (e) protoReq.busiData;
        if (!J0(z17, z18, z19, z26, eVar.c())) {
        }
    }

    private ToServiceMsg o(boolean z16, int i3, long j3, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        ToServiceMsg p16 = p(BaseConstants.CMD_MSG_PBSENDMSG);
        p16.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
        p16.extraData.putInt("ROUNTING_TYPE", 13);
        p16.extraData.putBoolean("ISFROM_DATALINE", true);
        p16.extraData.putInt("DATALINE_CMD", i3);
        p16.addAttribute("cookie", Long.valueOf(j3));
        p16.addAttribute("sendFromNative", Boolean.valueOf(z16));
        p16.extraData.putInt("DATALINE_TRYINDEX", 0);
        p16.putWupBuffer(msg_svc_pbsendmsgreq.toByteArray());
        p16.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        this.f206935a.sendToService(p16);
        return p16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        String str;
        boolean z17;
        byte[] bArr;
        boolean z18;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Replay] response FileHit");
        com.tencent.mobileqq.filemanager.app.f fVar = new com.tencent.mobileqq.filemanager.app.f();
        if (M0(protoResp)) {
            fVar.f207264m = -100001;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
        } else if (protoResp.resp.getResultCode() != 1000) {
            fVar.f207264m = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
            }
            if (!cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.has()) {
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
                QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            } else {
                cmd0x346$ApplyUploadHitRspV2 cmd0x346_applyuploadhitrspv2 = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.get();
                if (cmd0x346_applyuploadhitrspv2.int32_ret_code.has()) {
                    fVar.f207264m = cmd0x346_applyuploadhitrspv2.int32_ret_code.get();
                }
                if (cmd0x346_applyuploadhitrspv2.str_ret_msg.has()) {
                    fVar.f207265n = cmd0x346_applyuploadhitrspv2.str_ret_msg.get();
                }
                if (cmd0x346_applyuploadhitrspv2.uint64_total_space.has()) {
                    fVar.f207266o = cmd0x346_applyuploadhitrspv2.uint64_total_space.get();
                }
                if (cmd0x346_applyuploadhitrspv2.uint64_used_space.has()) {
                    fVar.f207267p = cmd0x346_applyuploadhitrspv2.uint64_used_space.get();
                }
                if (cmd0x346_applyuploadhitrspv2.str_upload_ip.has()) {
                    fVar.f207269r = cmd0x346_applyuploadhitrspv2.str_upload_ip.get();
                } else if (cmd0x346_applyuploadhitrspv2.str_upload_domain.has()) {
                    fVar.f207269r = cmd0x346_applyuploadhitrspv2.str_upload_domain.get();
                } else {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
                }
                if (cmd0x346_applyuploadhitrspv2.uint32_upload_port.has()) {
                    fVar.f207270s = (short) cmd0x346_applyuploadhitrspv2.uint32_upload_port.get();
                }
                if (cmd0x346_applyuploadhitrspv2.bytes_uuid.has()) {
                    fVar.f207271t = cmd0x346_applyuploadhitrspv2.bytes_uuid.get().toByteArray();
                }
                if (cmd0x346_applyuploadhitrspv2.bytes_upload_key.has()) {
                    fVar.f207272u = cmd0x346_applyuploadhitrspv2.bytes_upload_key.get().toByteArray();
                }
                if (cmd0x346_applyuploadhitrspv2.str_upload_https_domain.has()) {
                    fVar.f207256e = cmd0x346_applyuploadhitrspv2.str_upload_https_domain.get();
                }
                if (cmd0x346_applyuploadhitrspv2.uint32_upload_https_port.has()) {
                    fVar.f207257f = (short) cmd0x346_applyuploadhitrspv2.uint32_upload_https_port.get();
                }
                if (cmd0x346_applyuploadhitrspv2.str_upload_dns.has()) {
                    fVar.f207258g = cmd0x346_applyuploadhitrspv2.str_upload_dns.get();
                }
                z16 = true;
                str = fVar.f207269r;
                if (str == null && str.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bArr = fVar.f207271t;
                if (bArr == null && bArr.length != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                StatictisInfo statictisInfo = new StatictisInfo();
                statictisInfo.errCode = fVar.f207264m;
                statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
                if (z18 && z17) {
                    fVar.f207265n = "uuid_null[" + fVar.toString() + "]";
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + z16 + ", retCode=" + fVar.f207264m + ", retMsg=" + fVar.f207265n + ", totalSpace=" + fVar.f207266o + ", usedSpace=" + fVar.f207267p + ", ip=" + fVar.f207269r + ", port=" + ((int) fVar.f207270s));
                }
                Q0(((e) protoReq.busiData).g(), 5020, z16, new Object[]{fVar, statictisInfo, null});
            }
        }
        z16 = false;
        str = fVar.f207269r;
        if (str == null) {
        }
        z17 = false;
        bArr = fVar.f207271t;
        if (bArr == null) {
        }
        z18 = true;
        StatictisInfo statictisInfo2 = new StatictisInfo();
        statictisInfo2.errCode = fVar.f207264m;
        statictisInfo2.retryCount = protoResp.freeRunnalbleIndex;
        if (z18) {
            fVar.f207265n = "uuid_null[" + fVar.toString() + "]";
            z16 = false;
        }
        if (QLog.isColorLevel()) {
        }
        Q0(((e) protoReq.busiData).g(), 5020, z16, new Object[]{fVar, statictisInfo2, null});
    }

    private Object r(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg.isSuccess()) {
            try {
                return this.f206941g.o(toServiceMsg, fromServiceMsg);
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, this.f206941g.getClass().getSimpleName() + " decode error," + e16.toString());
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        com.tencent.mobileqq.filemanager.app.f fVar = new com.tencent.mobileqq.filemanager.app.f();
        if (M0(protoResp)) {
            fVar.f207264m = -100001;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
        } else if (protoResp.resp.getResultCode() != 1000) {
            fVar.f207264m = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
            }
            if (!cmd0x346_rspbody.msg_upload_succ_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
            } else {
                cmd0x346$UploadSuccRsp cmd0x346_uploadsuccrsp = cmd0x346_rspbody.msg_upload_succ_rsp.get();
                if (cmd0x346_uploadsuccrsp.int32_ret_code.has()) {
                    fVar.f207264m = cmd0x346_uploadsuccrsp.int32_ret_code.get();
                }
                if (cmd0x346_uploadsuccrsp.str_ret_msg.has()) {
                    fVar.f207265n = cmd0x346_uploadsuccrsp.str_ret_msg.get();
                }
                z16 = true;
                if (fVar.f207264m != 0) {
                    z16 = false;
                }
                StatictisInfo statictisInfo = new StatictisInfo();
                statictisInfo.errCode = fVar.f207264m;
                statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, "handleUploadSuccResponse: return " + z16 + ", retCode=" + fVar.f207264m + ", retMsg=" + fVar.f207265n);
                }
                Q0(((e) protoReq.busiData).g(), 5005, z16, new Object[]{fVar, statictisInfo});
            }
        }
        z16 = false;
        if (fVar.f207264m != 0) {
        }
        StatictisInfo statictisInfo2 = new StatictisInfo();
        statictisInfo2.errCode = fVar.f207264m;
        statictisInfo2.retryCount = protoResp.freeRunnalbleIndex;
        if (QLog.isColorLevel()) {
        }
        Q0(((e) protoReq.busiData).g(), 5005, z16, new Object[]{fVar, statictisInfo2});
    }

    private c s(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int length = bArr.length;
            c cVar = new c();
            if (length >= 16) {
                int shortData = PkgTools.getShortData(bArr, 0);
                byte[] bArr2 = new byte[shortData];
                int i3 = 2 + shortData;
                if (length >= i3) {
                    PkgTools.getBytesData(bArr, 2, bArr2, shortData);
                    try {
                        cVar.f206997a = new String(bArr2, CharEncoding.UTF_16LE);
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo: Exception is " + e16.toString());
                    }
                    int i16 = i3 + 4;
                    if (length >= i16) {
                        long longData = PkgTools.getLongData(bArr, i3);
                        int i17 = i16 + 2;
                        if (length >= i17) {
                            int shortData2 = PkgTools.getShortData(bArr, i16);
                            byte[] bArr3 = new byte[shortData2];
                            int i18 = i17 + shortData2;
                            if (length >= i18) {
                                PkgTools.getBytesData(bArr, i17, bArr3, shortData2);
                                if (length >= i18 + 4) {
                                    cVar.f206998b = (PkgTools.getLongData(bArr, i18) << 32) + longData;
                                    return cVar;
                                }
                                QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenhi");
                                return null;
                            }
                            QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- bufotherinfo");
                            return null;
                        }
                        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- otherlen");
                        return null;
                    }
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenlo");
                    return null;
                }
                QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamebuf");
                return null;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamelen");
        }
        return null;
    }

    private boolean u0(im_msg_body$NotOnlineFile im_msg_body_notonlinefile) {
        if (!im_msg_body_notonlinefile.bytes_file_name.has()) {
            if (QLog.isColorLevel()) {
                QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not fileName");
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean v(int i3, msg_comm$Msg msg_comm_msg) {
        if (!msg_comm_msg.msg_head.has()) {
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMessagePackage: msgList[" + i3 + "] : msg doesn't has msgHead.");
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void w0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        int i3;
        e.a aVar;
        boolean z17 = false;
        String str = "";
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
            try {
                cmd0x345_rspbody.mergeFrom(wupBuffer);
                if (cmd0x345_rspbody.uint32_return_code.has()) {
                    i3 = cmd0x345_rspbody.uint32_return_code.get();
                } else {
                    i3 = 0;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x345_rspbody.msg_subcmd_0xa_rsp_body.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
                z16 = false;
                i3 = -100003;
                if (i3 == 0) {
                    z17 = z16;
                }
                aVar = (e.a) ((e) protoReq.busiData).f();
                if (QLog.isColorLevel()) {
                    QLog.i("FileTransferHandler<FileAssistant>", 2, "internalDeleteDiscFile [" + z17 + "],retCode[" + i3 + "], retMsg[" + str + "]");
                }
                if (aVar == null) {
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "del disc file, but callback is null!!!,check here!!!");
                    return;
                } else if (z17) {
                    aVar.onSuccess();
                    return;
                } else {
                    aVar.onError(i3, str);
                    return;
                }
            }
            cmd0x345$RspBody.SubCmd0xaRspBody subCmd0xaRspBody = cmd0x345_rspbody.msg_subcmd_0xa_rsp_body.get();
            if (subCmd0xaRspBody.str_ret_msg.has()) {
                str = subCmd0xaRspBody.str_ret_msg.get();
            }
            z16 = true;
            if (i3 == 0) {
            }
            aVar = (e.a) ((e) protoReq.busiData).f();
            if (QLog.isColorLevel()) {
            }
            if (aVar == null) {
            }
        }
        z16 = false;
        if (i3 == 0) {
        }
        aVar = (e.a) ((e) protoReq.busiData).f();
        if (QLog.isColorLevel()) {
        }
        if (aVar == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long x0(long j3, long j16, long j17, long j18, long j19, long j26, im_msg_body$GroupFile im_msg_body_groupfile, int i3, int i16) {
        String str;
        String str2;
        long j27;
        byte[] bArr;
        long h16;
        if (im_msg_body_groupfile == null) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "disc file is coming but file info is null!");
            return -1L;
        }
        String valueOf = String.valueOf(j16);
        String valueOf2 = String.valueOf(j17);
        if (im_msg_body_groupfile.bytes_filename.has()) {
            try {
                str = new String(im_msg_body_groupfile.bytes_filename.get().toByteArray(), "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e = e16;
                str = null;
            }
            try {
                str2 = FileManagerUtil.getFileName(str);
            } catch (UnsupportedEncodingException e17) {
                e = e17;
                e.printStackTrace();
                QLog.e("FileTransferHandler<FileAssistant>", 1, "internalDiscOfflineFile: Exception is " + e.toString());
                str2 = str;
                if (!im_msg_body_groupfile.uint64_file_size.has()) {
                }
                if (!im_msg_body_groupfile.bytes_file_id.has()) {
                }
                if (im_msg_body_groupfile.bytes_batch_id.has()) {
                }
                if (im_msg_body_groupfile.bytes_mark.has()) {
                }
                byte[] bArr2 = bArr;
                h16 = this.f206935a.getFileManagerDataCenter().h(3000, j18, j26, j16, j19);
                if (h16 <= 0) {
                }
            }
        } else {
            str2 = null;
        }
        if (!im_msg_body_groupfile.uint64_file_size.has()) {
            j27 = im_msg_body_groupfile.uint64_file_size.get();
        } else {
            j27 = 0;
        }
        if (!im_msg_body_groupfile.bytes_file_id.has()) {
            bArr = im_msg_body_groupfile.bytes_file_id.get().toByteArray();
        } else {
            bArr = null;
        }
        if (im_msg_body_groupfile.bytes_batch_id.has()) {
            im_msg_body_groupfile.bytes_batch_id.get().toByteArray();
        }
        if (im_msg_body_groupfile.bytes_mark.has()) {
            im_msg_body_groupfile.bytes_mark.get().toByteArray();
        }
        byte[] bArr22 = bArr;
        h16 = this.f206935a.getFileManagerDataCenter().h(3000, j18, j26, j16, j19);
        if (h16 <= 0) {
            FileManagerEntity E = this.f206935a.getFileManagerDataCenter().E(h16, String.valueOf(j16), 3000);
            if (E != null) {
                E.status = 1;
                E.fProgress = 1.0f;
            }
            return h16;
        }
        String currentAccountUin = this.f206935a.getCurrentAccountUin();
        FileManagerEntity i17 = this.f206935a.getFileManagerDataCenter().i(j3, valueOf, 3000);
        i17.setCloudType(1);
        i17.fileName = str2;
        i17.fileSize = j27;
        i17.nOpType = 1;
        i17.peerNick = FileManagerUtil.getPeerNick(this.f206935a, valueOf, valueOf2, 3000);
        i17.peerType = 3000;
        i17.peerUin = valueOf;
        i17.selfUin = valueOf2;
        i17.srvTime = 1000 * j26;
        i17.status = -1;
        if (bArr22 != null) {
            i17.Uuid = new String(bArr22);
        }
        i17.isReaded = false;
        i17.bSend = false;
        i17.msgSeq = j18;
        i17.msgUid = 0L;
        i17.imgHeight = i16;
        i17.imgWidth = i3;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_=k recv DiscFile Id[" + i17.nSessionId + "],File[" + str2 + "]");
        FileManagerUtil.getFileType(str2);
        String str3 = i17.Uuid;
        if (str3 == null || str3.length() == 0) {
            i17.nWeiYunSrcType = -2;
        }
        FileManagerUtil.preLoadThumb(this.f206935a, i17);
        if (currentAccountUin.equals(String.valueOf(j17))) {
            this.f206935a.getFileManagerDataCenter().d0(valueOf2, 3000, j3);
            i17.nOpType = 7;
            i17.peerNick = this.f206935a.getApplication().getString(R.string.b_b);
            i17.bSend = true;
            i17.isReaded = true;
            i17.bOnceSuccess = true;
        }
        this.f206935a.getFileManagerDataCenter().t(i17);
        FileManagerUtil.checkFileExisted(i17, this.f206935a, null);
        if (QLog.isColorLevel()) {
            QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + FileManagerUtil.printFileManagerEntityInfo(i17));
        }
        FileManagerUtil.updateBatProcessTips(this.f206935a, String.valueOf(j17), valueOf, 3000);
        this.f206935a.getFileManagerNotifyCenter().c(j3, i17.nSessionId, valueOf, 3000, 17, null, 0, null);
        return j3;
    }

    private void x1(boolean z16, FileManagerEntity fileManagerEntity, String str, int i3, String str2, long j3) {
        if (z16) {
            fileManagerEntity.status = 1;
            int i16 = fileManagerEntity.nOpType;
            if (i16 != 20) {
                if (i16 != 21) {
                    if (i16 != 27) {
                        if (QLog.isDevelopLevel()) {
                            throw new NullPointerException(HardCodeUtil.qqStr(R.string.f171983mk0));
                        }
                        return;
                    } else {
                        if (fileManagerEntity.mContext instanceof w) {
                            com.tencent.mobileqq.activity.aio.forward.b.d().k(this.f206935a, fileManagerEntity.uniseq);
                            ((w) fileManagerEntity.mContext).d(z16, fileManagerEntity.strTroopFileUuid, fileManagerEntity.nSessionId, i3, str2, String.valueOf(fileManagerEntity.peerUin), str);
                            return;
                        }
                        return;
                    }
                }
                fileManagerEntity.Uuid = str;
                fileManagerEntity.peerType = 0;
                fileManagerEntity.setCloudType(1);
                this.f206935a.getFileManagerNotifyCenter().b(z16, 19, new Object[]{Integer.valueOf(i3), str2, 0L, 0L, str, Long.valueOf(j3)});
                i1(fileManagerEntity.peerUin, fileManagerEntity, null);
                this.f206935a.getFileManagerNotifyCenter().a(fileManagerEntity, 6, null);
                return;
            }
            Pair<String, String> T0 = T0(str);
            if (T0 != null) {
                fileManagerEntity.WeiYunDirKey = T0.first;
                fileManagerEntity.WeiYunFileId = T0.second;
            } else {
                fileManagerEntity.WeiYunFileId = str;
            }
            fileManagerEntity.setCloudType(2);
            this.f206935a.getFileManagerNotifyCenter().b(z16, 34, new Object[]{Integer.valueOf(i3), str2, str, Long.valueOf(j3)});
            return;
        }
        int i17 = fileManagerEntity.nOpType;
        if (i17 != 20) {
            if (i17 != 21) {
                if (i17 != 27) {
                    if (QLog.isDevelopLevel()) {
                        throw new NullPointerException(HardCodeUtil.qqStr(R.string.f171984mk1));
                    }
                    return;
                }
                if (i3 == -6101 || i3 == -7003) {
                    fileManagerEntity.status = 16;
                    Object obj = fileManagerEntity.mContext;
                    if (obj != null && (obj instanceof FileManagerEntity)) {
                        FileManagerEntity fileManagerEntity2 = (FileManagerEntity) obj;
                        fileManagerEntity2.status = 16;
                        this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity2);
                        fileManagerEntity.mContext = null;
                    }
                    this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
                }
                Object obj2 = fileManagerEntity.mContext;
                if (obj2 instanceof w) {
                    ((w) obj2).d(z16, fileManagerEntity.strTroopFileUuid, fileManagerEntity.nSessionId, i3, str2, String.valueOf(fileManagerEntity.peerUin), str);
                    return;
                }
                return;
            }
            if (i3 == -6101 || i3 == -7003) {
                fileManagerEntity.status = 16;
                Object obj3 = fileManagerEntity.mContext;
                if (obj3 != null && (obj3 instanceof FileManagerEntity)) {
                    FileManagerEntity fileManagerEntity3 = (FileManagerEntity) obj3;
                    fileManagerEntity3.status = 16;
                    this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity3);
                    fileManagerEntity.mContext = null;
                }
                this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
            }
            this.f206935a.getFileManagerNotifyCenter().b(z16, 19, new Object[]{Integer.valueOf(i3), str2, 0L, 0L, str, Long.valueOf(j3)});
            return;
        }
        if (i3 == -6101 || i3 == -7003) {
            fileManagerEntity.status = 16;
            Object obj4 = fileManagerEntity.mContext;
            if (obj4 != null && (obj4 instanceof FileManagerEntity)) {
                FileManagerEntity fileManagerEntity4 = (FileManagerEntity) obj4;
                fileManagerEntity4.status = 16;
                this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity4);
                fileManagerEntity.mContext = null;
            }
            this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
        }
        this.f206935a.getFileManagerNotifyCenter().b(z16, 34, new Object[]{Integer.valueOf(i3), str2, str, Long.valueOf(j3)});
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        Bundle bundle;
        String str;
        ProtoReqManagerImpl.ProtoReq protoReq2;
        int i3;
        short s16;
        long j3;
        String str2;
        long j16;
        boolean z16;
        boolean z17;
        char c16;
        String str3;
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        Bundle bundle2 = new Bundle();
        if (L0(protoResp.resp.getResultCode())) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            bundle = bundle2;
            str = "FileTransferHandler<FileAssistant>";
            protoReq2 = protoReq;
            j3 = -100001L;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is failed[" + protoResp.resp.getResultCode() + "]");
            j3 = WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT;
            bundle = bundle2;
            str = "FileTransferHandler<FileAssistant>";
            protoReq2 = protoReq;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
            try {
                cmd0x345_rspbody.mergeFrom(wupBuffer);
                if (cmd0x345_rspbody.uint32_return_code.has()) {
                    str2 = "";
                    j16 = cmd0x345_rspbody.uint32_return_code.get();
                } else {
                    str2 = "";
                    j16 = 0;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                bundle = bundle2;
                str = "FileTransferHandler<FileAssistant>";
                protoReq2 = protoReq;
                i3 = 80;
                s16 = 0;
                e16.printStackTrace();
                j3 = -100003;
                str5 = "";
            }
            if (!cmd0x345_rspbody.msg_subcmd_0x3_rsp_body.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: rspBody has not hasMsgApplyDownloadRsp");
                bundle = bundle2;
                str = "FileTransferHandler<FileAssistant>";
                protoReq2 = protoReq;
                j3 = -100003;
                str5 = str2;
            } else {
                bundle = bundle2;
                str = "FileTransferHandler<FileAssistant>";
                protoReq2 = protoReq;
                b j17 = new b(j16, "", 80, str2, "", "", "", (short) 0, "", bundle, cmd0x345_rspbody.msg_subcmd_0x3_rsp_body.get()).j();
                long c17 = j17.c();
                str4 = j17.g();
                i3 = j17.b();
                str5 = j17.e();
                str6 = j17.f();
                str7 = j17.d();
                str8 = j17.i();
                s16 = j17.a();
                str9 = j17.h();
                j3 = c17;
                e eVar = (e) protoReq2.busiData;
                if (j3 != -100001) {
                    j3 = 9043;
                } else if (j3 == -100003) {
                    j3 = 9045;
                } else {
                    if (j3 == 0 && str4 == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    int c18 = eVar.c();
                    if (z16 && c18 < 3) {
                        eVar.i();
                        q1(protoReq2.ssoCmd, protoReq2.reqBody, eVar);
                        return;
                    }
                }
                if (str4 == null && str4.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("internalDownloadDiscFile: return ");
                    sb5.append(z17);
                    sb5.append(", retCode=");
                    sb5.append(j3);
                    sb5.append(", strHost=");
                    sb5.append(str4);
                    sb5.append(", strCheckSum=");
                    if (str5 != null) {
                        str3 = str5;
                    } else {
                        str3 = "";
                    }
                    sb5.append(str3);
                    sb5.append(", strCookie=");
                    sb5.append(str6);
                    sb5.append(", port=");
                    sb5.append(i3);
                    c16 = 1;
                    QLog.i(str, 1, sb5.toString());
                } else {
                    c16 = 1;
                }
                Bundle bundle3 = bundle;
                bundle3.putShort("httpsPort", s16);
                bundle3.putString("IPv6Dns", str9);
                com.tencent.mobileqq.filemanager.app.d g16 = eVar.g();
                Object[] objArr = new Object[10];
                objArr[0] = Long.valueOf(j3);
                objArr[c16] = str7;
                objArr[2] = str8;
                objArr[3] = str4;
                objArr[4] = Integer.valueOf(i3);
                objArr[5] = str5;
                objArr[6] = str6;
                objArr[7] = Integer.valueOf(protoResp.resp.getAppSeq());
                objArr[8] = Long.valueOf(eVar.d());
                objArr[9] = bundle3;
                Q0(g16, 5013, z17, objArr);
            }
        }
        i3 = 80;
        s16 = 0;
        e eVar2 = (e) protoReq2.busiData;
        if (j3 != -100001) {
        }
        if (str4 == null) {
        }
        z17 = false;
        if (!QLog.isColorLevel()) {
        }
        Bundle bundle32 = bundle;
        bundle32.putShort("httpsPort", s16);
        bundle32.putString("IPv6Dns", str9);
        com.tencent.mobileqq.filemanager.app.d g162 = eVar2.g();
        Object[] objArr2 = new Object[10];
        objArr2[0] = Long.valueOf(j3);
        objArr2[c16] = str7;
        objArr2[2] = str8;
        objArr2[3] = str4;
        objArr2[4] = Integer.valueOf(i3);
        objArr2[5] = str5;
        objArr2[6] = str6;
        objArr2[7] = Integer.valueOf(protoResp.resp.getAppSeq());
        objArr2[8] = Long.valueOf(eVar2.d());
        objArr2[9] = bundle32;
        Q0(g162, 5013, z17, objArr2);
    }

    private void y1(long j3, boolean z16, int i3, String str, String str2, FileManagerEntity fileManagerEntity) {
        if ((str2 == null || str2.length() < 1) && QLog.isColorLevel()) {
            QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(i3) + "retMsg[" + String.valueOf(str) + "]");
        }
        if (z16) {
            fileManagerEntity.status = 1;
            fileManagerEntity.setCloudType(2);
        } else {
            fileManagerEntity.status = 0;
        }
        if (i3 == -6101 || i3 == -7003) {
            fileManagerEntity.status = 16;
            Object obj = fileManagerEntity.mContext;
            if (obj != null && (obj instanceof FileManagerEntity)) {
                FileManagerEntity fileManagerEntity2 = (FileManagerEntity) obj;
                fileManagerEntity2.status = 16;
                this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity2);
                fileManagerEntity.mContext = null;
            }
            this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
        }
        Pair<String, String> T0 = T0(str2);
        if (T0 != null) {
            fileManagerEntity.WeiYunDirKey = T0.first;
            fileManagerEntity.WeiYunFileId = T0.second;
        } else {
            fileManagerEntity.WeiYunFileId = str2;
        }
        this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
        this.f206935a.getFileManagerNotifyCenter().b(z16, 34, new Object[]{Integer.valueOf(i3), str, str2, Long.valueOf(j3)});
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void z0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        int i3;
        String str;
        String str2;
        FileManagerEntity D;
        FileManagerEntity fileManagerEntity;
        String str3 = "";
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
            try {
                cmd0x345_rspbody.mergeFrom(wupBuffer);
                if (cmd0x345_rspbody.uint32_return_code.has()) {
                    i3 = cmd0x345_rspbody.uint32_return_code.get();
                } else {
                    i3 = 0;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x345_rspbody.msg_subcmd_0x5_rsp_body.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
                z16 = false;
                i3 = -100003;
                str2 = null;
                if (i3 != 0) {
                    z16 = false;
                }
                if (str2 == null) {
                    z16 = false;
                }
                long d16 = ((e) protoReq.busiData).d();
                D = this.f206935a.getFileManagerDataCenter().D(d16);
                if (D == null) {
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
                    return;
                }
                if (z16) {
                    D.Uuid = str2;
                    D.setCloudType(1);
                    this.f206935a.getFileManagerNotifyCenter().b(z16, 19, new Object[]{Integer.valueOf(i3), str3, 0L, 0L, str2, Long.valueOf(d16)});
                    k1(d16, D.peerUin, this.f206935a.getCurrentAccountUin(), D.fileName, D.fileSize, str2, D.uniseq, D.msgUid, null);
                    this.f206935a.getFileManagerNotifyCenter().a(D, 6, null);
                    fileManagerEntity = D;
                } else {
                    fileManagerEntity = D;
                    fileManagerEntity.status = 0;
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "nId[" + d16 + "],forward disc2disc faild, retCode[" + i3 + "], retMsg[" + str3 + "]");
                    if (i3 == -6101 || i3 == -7003) {
                        fileManagerEntity.status = 16;
                        Object obj = fileManagerEntity.mContext;
                        if (obj != null && (obj instanceof FileManagerEntity)) {
                            FileManagerEntity fileManagerEntity2 = (FileManagerEntity) obj;
                            fileManagerEntity2.status = 16;
                            this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity2);
                            fileManagerEntity.mContext = null;
                        }
                        this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
                    }
                    this.f206935a.getFileManagerNotifyCenter().b(z16, 19, new Object[]{Integer.valueOf(i3), str3, 0L, 0L, str2, Long.valueOf(d16)});
                }
                this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
                return;
            }
            cmd0x345$RspBody.SubCmd0x5RspBody subCmd0x5RspBody = cmd0x345_rspbody.msg_subcmd_0x5_rsp_body.get();
            if (subCmd0x5RspBody.str_ret_msg.has()) {
                str3 = subCmd0x5RspBody.str_ret_msg.get();
            }
            if (subCmd0x5RspBody.str_file_id.has()) {
                str = subCmd0x5RspBody.str_file_id.get();
            } else {
                str = null;
            }
            str2 = str;
            z16 = true;
            if (i3 != 0) {
            }
            if (str2 == null) {
            }
            long d162 = ((e) protoReq.busiData).d();
            D = this.f206935a.getFileManagerDataCenter().D(d162);
            if (D == null) {
            }
        }
        z16 = false;
        str2 = null;
        if (i3 != 0) {
        }
        if (str2 == null) {
        }
        long d1622 = ((e) protoReq.busiData).d();
        D = this.f206935a.getFileManagerDataCenter().D(d1622);
        if (D == null) {
        }
    }

    private void z1(long j3, boolean z16, int i3, String str, String str2, FileManagerEntity fileManagerEntity) {
        char c16;
        char c17;
        char c18;
        FileManagerEntity fileManagerEntity2;
        int i16;
        FileTransferHandler fileTransferHandler;
        if (TextUtils.isEmpty(str2) && QLog.isColorLevel()) {
            QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(i3) + "retMsg[" + String.valueOf(str) + "]");
        }
        if (z16) {
            fileManagerEntity.status = 1;
        } else {
            fileManagerEntity.status = 0;
        }
        if (z16) {
            fileManagerEntity.Uuid = str2;
            fileManagerEntity.setCloudType(1);
            fileManagerEntity.peerType = 3000;
            c16 = 1;
            c17 = 2;
            c18 = 0;
            fileManagerEntity2 = fileManagerEntity;
            i16 = i3;
            k1(fileManagerEntity.nSessionId, fileManagerEntity.peerUin, this.f206935a.getCurrentAccountUin(), fileManagerEntity.fileName, fileManagerEntity.fileSize, str2, fileManagerEntity.uniseq, fileManagerEntity.msgUid, null);
        } else {
            c16 = 1;
            c17 = 2;
            c18 = 0;
            fileManagerEntity2 = fileManagerEntity;
            i16 = i3;
        }
        if (i16 != -6101 && i16 != -7003) {
            fileTransferHandler = this;
        } else {
            fileManagerEntity2.status = 16;
            Object obj = fileManagerEntity2.mContext;
            if (obj != null && (obj instanceof FileManagerEntity)) {
                FileManagerEntity fileManagerEntity3 = (FileManagerEntity) obj;
                fileManagerEntity3.status = 16;
                fileTransferHandler = this;
                fileTransferHandler.f206935a.getFileManagerDataCenter().f0(fileManagerEntity3);
                fileManagerEntity2.mContext = null;
            } else {
                fileTransferHandler = this;
            }
            fileTransferHandler.f206935a.getFileManagerDataCenter().f0(fileManagerEntity2);
        }
        FileManagerNotifyCenter fileManagerNotifyCenter = fileTransferHandler.f206935a.getFileManagerNotifyCenter();
        Object[] objArr = new Object[6];
        objArr[c18] = Integer.valueOf(i3);
        objArr[c16] = str;
        objArr[c17] = 0L;
        objArr[3] = 0L;
        objArr[4] = str2;
        objArr[5] = Long.valueOf(j3);
        fileManagerNotifyCenter.b(z16, 19, objArr);
    }

    public cmd0x346$ApplyUploadHitReqV2 A(ic1.d dVar) {
        cmd0x346$ApplyUploadHitReqV2 cmd0x346_applyuploadhitreqv2 = new cmd0x346$ApplyUploadHitReqV2();
        ic1.a aVar = dVar.f407454c;
        cmd0x346_applyuploadhitreqv2.uint64_sender_uin.set(aVar.f407422a);
        cmd0x346_applyuploadhitreqv2.uint64_recver_uin.set(aVar.f407423b);
        cmd0x346_applyuploadhitreqv2.uint64_file_size.set(aVar.f407424c);
        cmd0x346_applyuploadhitreqv2.str_file_name.set(aVar.f407425d);
        cmd0x346_applyuploadhitreqv2.bytes_10m_md5.set(ByteStringMicro.copyFrom(aVar.f407426e));
        cmd0x346_applyuploadhitreqv2.bytes_3sha.set(ByteStringMicro.copyFrom(aVar.f407427f));
        cmd0x346_applyuploadhitreqv2.bytes_sha.set(ByteStringMicro.copyFrom(aVar.f407428g));
        cmd0x346_applyuploadhitreqv2.str_local_filepath.set(aVar.f407429h);
        cmd0x346_applyuploadhitreqv2.uint32_danger_level.set(aVar.f407430i);
        cmd0x346_applyuploadhitreqv2.uint64_total_space.set(aVar.f407431j);
        return cmd0x346_applyuploadhitreqv2;
    }

    public cmd0x346$ApplyUploadReqV2 B(ic1.d dVar) {
        cmd0x346$ApplyUploadReqV2 cmd0x346_applyuploadreqv2 = new cmd0x346$ApplyUploadReqV2();
        ic1.b bVar = dVar.f407452a;
        cmd0x346_applyuploadreqv2.uint64_sender_uin.set(bVar.f407432a);
        cmd0x346_applyuploadreqv2.uint64_recver_uin.set(bVar.f407433b);
        cmd0x346_applyuploadreqv2.uint64_file_size.set(bVar.f407434c);
        cmd0x346_applyuploadreqv2.str_file_name.set(bVar.f407435d);
        cmd0x346_applyuploadreqv2.bytes_10m_md5.set(ByteStringMicro.copyFrom(bVar.f407436e));
        cmd0x346_applyuploadreqv2.bytes_3sha.set(ByteStringMicro.copyFrom(bVar.f407437f));
        cmd0x346_applyuploadreqv2.str_local_filepath.set(bVar.f407438g);
        cmd0x346_applyuploadreqv2.uint32_danger_level.set(bVar.f407439h);
        cmd0x346_applyuploadreqv2.uint64_total_space.set(bVar.f407440i);
        return cmd0x346_applyuploadreqv2;
    }

    public void B1() {
        face2face_file$msg face2face_file_msg = new face2face_file$msg();
        face2face_file_msg.version.set(1);
        face2face_file_msg.result.set(0);
        q1("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ", face2face_file_msg.toByteArray(), null);
    }

    public cmd0x346$ApplyUploadReqV3 C(ic1.d dVar) {
        cmd0x346$ApplyUploadReqV3 cmd0x346_applyuploadreqv3 = new cmd0x346$ApplyUploadReqV3();
        ic1.c cVar = dVar.f407453b;
        cmd0x346_applyuploadreqv3.uint64_sender_uin.set(cVar.f407441a);
        cmd0x346_applyuploadreqv3.uint64_recver_uin.set(cVar.f407442b);
        cmd0x346_applyuploadreqv3.uint64_file_size.set(cVar.f407443c);
        cmd0x346_applyuploadreqv3.str_file_name.set(cVar.f407444d);
        cmd0x346_applyuploadreqv3.bytes_10m_md5.set(ByteStringMicro.copyFrom(cVar.f407445e));
        byte[] bArr = cVar.f407446f;
        if (bArr != null) {
            cmd0x346_applyuploadreqv3.bytes_md5.set(ByteStringMicro.copyFrom(bArr));
        }
        cmd0x346_applyuploadreqv3.bytes_sha.set(ByteStringMicro.copyFrom(cVar.f407447g));
        byte[] bArr2 = cVar.f407448h;
        if (bArr2 != null) {
            cmd0x346_applyuploadreqv3.bytes_3sha.set(ByteStringMicro.copyFrom(bArr2));
        }
        cmd0x346_applyuploadreqv3.uint32_contenttype.set(0);
        cmd0x346_applyuploadreqv3.str_local_filepath.set(cVar.f407449i);
        cmd0x346_applyuploadreqv3.uint32_danger_level.set(cVar.f407450j);
        cmd0x346_applyuploadreqv3.uint64_total_space.set(cVar.f407451k);
        return cmd0x346_applyuploadreqv3;
    }

    public void C1() {
        if (!N0()) {
            return;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "wifiPhotoSmartReminder, switch on ");
        if (this.f206935a.getCurrentAccountUin() == null || !m() || J() > 1073741824) {
            return;
        }
        long picCount = ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getPicCount(this.f206935a.getApplication());
        if (picCount < 50) {
            return;
        }
        s1(J(), picCount);
    }

    public void D(long j3, String str, String str2, boolean z16, com.tencent.mobileqq.filemanager.app.d dVar) {
        int i3;
        cmd0x346$ApplyDownloadReq cmd0x346_applydownloadreq = new cmd0x346$ApplyDownloadReq();
        cmd0x346_applydownloadreq.uint64_uin.set(Long.parseLong(this.f206935a.getCurrentAccountUin()));
        cmd0x346_applydownloadreq.bytes_uuid.set(ByteStringMicro.copyFrom(str.getBytes()));
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        cmd0x346_applydownloadreq.uint32_owner_type.set(i3);
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.msg_apply_download_req.set(cmd0x346_applydownloadreq);
        cmd0x346_reqbody.uint32_cmd.set(1200);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i16 = f206932i;
        f206932i = i16 + 1;
        pBUInt32Field.set(i16);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
        cmd0x346_extensionreq.uint32_download_url_type.set(1);
        cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
        if (I0()) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
            if (str2 != null && str2.length() > 0) {
                cmd0x346_applydownloadreq.str_fileidcrc.set(str2);
                QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform endabled");
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform endabled but FileIdCrc is null");
            }
        } else {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform not enabled");
        }
        q1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", cmd0x346_reqbody.toByteArray(), new e(j3, dVar));
    }

    public ic1.d E(jc1.a aVar) {
        ic1.d dVar = new ic1.d();
        long parseLong = Long.parseLong(this.f206935a.getCurrentAccountUin());
        int i3 = aVar.f409772c;
        if (i3 == 1700) {
            dVar.f407453b = new ic1.c();
            String replace = aVar.f409770a.replace(Marker.ANY_NON_NULL_MARKER, "");
            aVar.f409770a = replace;
            ic1.c cVar = dVar.f407453b;
            cVar.f407441a = parseLong;
            cVar.f407442b = Long.parseLong(replace);
            ic1.c cVar2 = dVar.f407453b;
            cVar2.f407443c = aVar.f409771b;
            cVar2.f407444d = new String(aVar.f409775f);
            dVar.f407453b.f407449i = new String(aVar.f409774e);
            ic1.c cVar3 = dVar.f407453b;
            cVar3.f407445e = aVar.f409776g;
            cVar3.f407447g = aVar.f409778i;
            cVar3.f407446f = aVar.f409777h;
            cVar3.f407448h = aVar.f409779j;
        } else if (i3 == 1600) {
            dVar.f407452a = new ic1.b();
            String replace2 = aVar.f409770a.replace(Marker.ANY_NON_NULL_MARKER, "");
            aVar.f409770a = replace2;
            ic1.b bVar = dVar.f407452a;
            bVar.f407432a = parseLong;
            bVar.f407433b = Long.parseLong(replace2);
            ic1.b bVar2 = dVar.f407452a;
            bVar2.f407434c = aVar.f409771b;
            bVar2.f407435d = new String(aVar.f409775f);
            dVar.f407452a.f407438g = new String(aVar.f409774e);
            ic1.b bVar3 = dVar.f407452a;
            bVar3.f407436e = aVar.f409776g;
            bVar3.f407437f = aVar.f409779j;
        }
        return dVar;
    }

    public void E0(int i3, String str, String str2, long j3, short s16, boolean z16, int i16, String str3, com.tencent.mobileqq.filemanager.data.m mVar, long j16, int i17) {
        if (!F0(mVar)) {
            return;
        }
        if (i3 != 129) {
            if (i3 != 131) {
                if (i3 != 133) {
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] handleOnLineFilePushMsg. error cmd:" + i3);
                    return;
                }
                QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] handle cmd 0x85. cancel.type:" + ((int) mVar.F) + " reason:" + ((int) mVar.G));
                short s17 = mVar.F;
                if (2 == s17) {
                    this.f206935a.getOnlineFileSessionCenter().l(str, mVar.f207826f, 2);
                    return;
                }
                if (1 == s17) {
                    short s18 = mVar.G;
                    if (57 == s18) {
                        this.f206935a.getOnlineFileSessionCenter().l(str, mVar.f207826f, 5);
                        return;
                    }
                    if (70 == s18) {
                        this.f206935a.getOnlineFileSessionCenter().q(str, mVar.f207826f);
                        return;
                    }
                    if (71 == s18) {
                        this.f206935a.getOnlineFileSessionCenter().l(str, mVar.f207826f, 4);
                        return;
                    }
                    if (5 == s18) {
                        this.f206935a.getOnlineFileSessionCenter().l(str, mVar.f207826f, 2);
                        return;
                    }
                    if (s18 == 0) {
                        this.f206935a.getOnlineFileSessionCenter().l(str, mVar.f207826f, 3);
                        return;
                    }
                    if (58 == s18) {
                        this.f206935a.getOnlineFileSessionCenter().q(str, mVar.f207826f);
                        return;
                    }
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] canceltype:1.unkonw reason:" + ((int) mVar.G));
                    return;
                }
                QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] unknow canceltype:" + ((int) mVar.F));
                return;
            }
            QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] handle cmd 0x83. accept");
            this.f206935a.getOnlineFileSessionCenter().l(str, mVar.f207826f, 1);
            return;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] handle cmd 0x81. request");
        this.f206935a.getOnlineFileSessionCenter().m(str, str2, j3, s16, z16, mVar, j16, i17);
    }

    public void F(long j3, String str, long j16, String str2, com.tencent.mobileqq.filemanager.app.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscFile : String[" + str2 + "], nDiscId[" + j16 + "]");
        }
        cmd0x345$ReqBody.SubCmd0x3ReqBody subCmd0x3ReqBody = new cmd0x345$ReqBody.SubCmd0x3ReqBody();
        subCmd0x3ReqBody.uint64_uin.set(Long.parseLong(this.f206935a.getCurrentAccountUin()));
        subCmd0x3ReqBody.str_file_id.set(str2);
        subCmd0x3ReqBody.uint64_disscus_uin.set(j16);
        subCmd0x3ReqBody.uint32_costom_id.set(0);
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x3_req_body.set(subCmd0x3ReqBody);
        cmd0x345_reqbody.uint32_sub_cmd.set(3);
        q1("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), new e(false, j3, dVar, 3));
    }

    public boolean F0(com.tencent.mobileqq.filemanager.data.m mVar) {
        if (mVar == null) {
            return false;
        }
        f206934k.equals(mVar.f207829m);
        if (mVar.E) {
            return true;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "]  is not surpport mulitendpoint");
        return false;
    }

    public void G(String str, String str2, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscVideoThumbInfo : FileUUID[" + str2 + "]");
        }
        cmd0x345$ReqBody.SubCmd0x7ReqBody subCmd0x7ReqBody = new cmd0x345$ReqBody.SubCmd0x7ReqBody();
        subCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(str));
        subCmd0x7ReqBody.str_file_path.set(str2);
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x7_req_body.set(subCmd0x7ReqBody);
        cmd0x345_reqbody.uint32_sub_cmd.set(8);
        r1("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), new e(true, j3, (com.tencent.mobileqq.filemanager.app.d) null, 8), 30000, 3, 1);
    }

    public void H(String str, String str2, boolean z16, boolean z17, com.tencent.mobileqq.filemanager.app.d dVar) {
        int i3;
        cmd0x346$ApplyDownloadReq cmd0x346_applydownloadreq = new cmd0x346$ApplyDownloadReq();
        cmd0x346_applydownloadreq.uint64_uin.set(Long.parseLong(this.f206935a.getCurrentAccountUin()));
        cmd0x346_applydownloadreq.bytes_uuid.set(ByteStringMicro.copyFrom(str.getBytes()));
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        cmd0x346_applydownloadreq.uint32_owner_type.set(i3);
        if (z17) {
            cmd0x346_applydownloadreq.uint32_need_https_url.set(1);
        }
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        if (I0()) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
            if (str2 != null && str2.length() > 0) {
                cmd0x346_applydownloadreq.str_fileidcrc.set(str2);
                QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform enabled");
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform enabled, but FileIdCrc is null");
            }
        } else {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform not enabled");
        }
        cmd0x346_reqbody.msg_apply_download_req.set(cmd0x346_applydownloadreq);
        cmd0x346_reqbody.uint32_cmd.set(1200);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i16 = f206932i;
        f206932i = i16 + 1;
        pBUInt32Field.set(i16);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
        cmd0x346_extensionreq.uint32_download_url_type.set(1);
        cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
        q1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", cmd0x346_reqbody.toByteArray(), new e(dVar));
    }

    protected boolean I0() {
        return ((IQFileConfigManager) this.f206935a.getRuntimeService(IQFileConfigManager.class, "")).isMediaPlatformEnabled();
    }

    long J() {
        boolean e16 = cu.e();
        long b16 = cu.b();
        long c16 = cu.c();
        if (e16 && b16 != 0) {
            return Math.min(b16, c16) * 1024;
        }
        return c16 * 1024;
    }

    public void K(String str, String str2, BuddyTransfileProcessor.A9Message a9Message, long j3, short s16, long j16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "--->>getOffLineFile--toUin: " + str2 + " filePath: " + a9Message.serverPath + " delUin: " + j16);
        }
        ToServiceMsg p16 = p("TransService.ReqOffFilePack");
        p16.extraData.putString("selfuin", this.f206935a.getCurrentAccountUin());
        p16.extraData.putString("uin", str2);
        p16.extraData.putByteArray("filepath", a9Message.serverPath.getBytes());
        p16.extraData.putInt("offfile_type", 0);
        p16.extraData.putLong("msgTime", j3);
        p16.extraData.putShort("msgSeq", s16);
        p16.extraData.putLong("delUin", j16);
        p16.extraData.putByte("type", a9Message.type);
        p16.extraData.putInt("retryIndex", 0);
        p16.extraData.putString("friendUin", str);
        p16.extraData.putBoolean("isRead", z16);
        f1(p16);
    }

    public void M(String str, String str2, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "getOfflineVideoThumbInfo : FileUUID[" + str + "]");
        }
        cmd0x346$ApplyDownloadAbsReq cmd0x346_applydownloadabsreq = new cmd0x346$ApplyDownloadAbsReq();
        cmd0x346_applydownloadabsreq.uint64_uin.set(Long.parseLong(this.f206935a.getCurrentAccountUin()));
        cmd0x346_applydownloadabsreq.bytes_uuid.set(ByteStringMicro.copyFrom(str.getBytes()));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.msg_apply_download_abs_req.set(cmd0x346_applydownloadabsreq);
        cmd0x346_reqbody.uint32_cmd.set(1100);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = f206932i;
        f206932i = i3 + 1;
        pBUInt32Field.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        if (I0()) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
            if (str2 != null && str2.length() > 0) {
                cmd0x346_applydownloadabsreq.str_fileidcrc.set(str2);
                QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform enabled");
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform enabled but FileIdCrc is null");
            }
        } else {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform not enabled");
        }
        r1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", cmd0x346_reqbody.toByteArray(), new e(true, j3), 30000, 3, 1);
    }

    boolean N0() {
        QQAppInterface qQAppInterface = this.f206935a;
        if (qQAppInterface == null) {
            return false;
        }
        return ((IFeatureRuntimeService) qQAppInterface.getRuntimeService(IFeatureRuntimeService.class)).isFeatureSwitchEnable("wifi_photo_reminder", false);
    }

    public long O(long j3, long j16, long j17, long j18, long j19, long j26, im_msg_body$GroupFile im_msg_body_groupfile, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "handleDiscFileCome,uinseq[" + String.valueOf(j3) + "],discUin[" + String.valueOf(j16) + "],sendUin[" + String.valueOf(j17) + "],seq[" + String.valueOf(j18) + "],msgTime[" + String.valueOf(j26) + "],fileInfo[" + String.valueOf(im_msg_body_groupfile) + "],oriImgWidth[" + String.valueOf(i3) + "],oriImgHeight[" + String.valueOf(i16) + "]");
        }
        return x0(j3, j16, j17, j18, j19, j26, im_msg_body_groupfile, i3, i16);
    }

    public List<MessageRecord> O0(List<msg_comm$Msg> list, long j3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(list);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            msg_comm$Msg msg_comm_msg = (msg_comm$Msg) arrayList2.get(i3);
            if (G0(j3, z16, arrayList, i3, msg_comm_msg, msg_comm_msg.msg_head.get())) {
                list.remove(msg_comm_msg);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Q(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        long j3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        com.tencent.mobileqq.filemanager.app.a aVar = new com.tencent.mobileqq.filemanager.app.a();
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            j3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + protoResp.resp.getResultCode() + "]");
            j3 = WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            j3 = -100003;
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x346_rspbody.msg_apply_download_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: rspBody has not hasMsgApplyDownloadRsp");
                if (wupBuffer.length > 0 && protoReq != null) {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp, reqData = " + Arrays.toString(protoReq.reqBody) + ", busiData = " + protoReq.busiData + ", reqSso = " + protoReq.ssoCmd + ", respData = " + Arrays.toString(wupBuffer));
                }
            } else {
                if (cmd0x346_rspbody.uint32_flag_use_media_platform.has()) {
                    if (cmd0x346_rspbody.uint32_flag_use_media_platform.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: bUseMediaPlatform " + z16);
                } else {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: bUseMediaPlatform false uint32_flag_use_media_platform not set");
                    z16 = false;
                }
                com.tencent.mobileqq.filemanager.app.a.a(aVar, cmd0x346_rspbody.msg_apply_download_rsp.get(), z16, this.f206935a.getAccount());
                j3 = aVar.f207227a;
                z17 = true;
                if (j3 != 0 && aVar.f207232f == null && aVar.f207230d == null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (j3 == -91245 && j3 != -7010) {
                    z19 = false;
                } else {
                    z19 = true;
                }
                if (protoReq != null) {
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: req null");
                    return;
                }
                e eVar = (e) protoReq.busiData;
                int c16 = eVar.c();
                if ((z19 || z18) && c16 < 3) {
                    eVar.i();
                    q1(protoReq.ssoCmd, protoReq.reqBody, eVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handleDownloadResp: return ");
                    sb5.append(z17);
                    sb5.append(", retCode=");
                    sb5.append(j3);
                    sb5.append(", retMsg=");
                    sb5.append(aVar.f207228b);
                    sb5.append(", key=");
                    ByteStringMicro byteStringMicro = aVar.f207229c;
                    if (byteStringMicro != null) {
                        str = byteStringMicro.toStringUtf8();
                    } else {
                        str = "";
                    }
                    sb5.append(str);
                    sb5.append(", strIP=");
                    sb5.append(aVar.f207230d);
                    sb5.append(", port=");
                    sb5.append((int) aVar.f207231e);
                    sb5.append(", strUrl=");
                    sb5.append(aVar.f207232f);
                    sb5.append(", strHttpsDomain=");
                    sb5.append(aVar.f207238l);
                    sb5.append(", httpsPort=");
                    sb5.append((int) aVar.f207240n);
                    QLog.d("FileTransferHandler<FileAssistant>", 2, sb5.toString());
                }
                Bundle bundle = new Bundle();
                String str2 = aVar.f207238l;
                if (str2 != null) {
                    bundle.putString("strHttpsDomain", str2);
                }
                String str3 = aVar.f207239m;
                if (str3 != null) {
                    bundle.putString("IPv6Dns", str3);
                }
                bundle.putShort("httpsPort", aVar.f207240n);
                List<String> list = aVar.f207241o;
                if (list != null && list.size() > 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(aVar.f207241o);
                    bundle.putStringArrayList("ipv6list", arrayList);
                }
                Q0(eVar.g(), 5006, z17, new Object[]{Long.valueOf(j3), aVar.f207228b, aVar.f207233g, aVar.f207229c, Boolean.valueOf(z16), aVar.f207230d, Short.valueOf(aVar.f207231e), aVar.f207232f, aVar.f207235i, Integer.valueOf(protoResp.resp.getAppSeq()), aVar.f207234h, aVar.f207236j, aVar.f207237k, Long.valueOf(eVar.d()), bundle});
                return;
            }
        }
        z16 = false;
        z17 = false;
        if (j3 != 0) {
        }
        z18 = false;
        if (j3 == -91245) {
        }
        z19 = true;
        if (protoReq != null) {
        }
    }

    public void Q0(com.tencent.mobileqq.filemanager.app.d dVar, int i3, boolean z16, Object obj) {
        if (dVar != null) {
            Message obtainMessage = f206933j.obtainMessage();
            obtainMessage.what = i3;
            obtainMessage.obj = new Object[]{dVar, Boolean.valueOf(z16), obj};
            obtainMessage.sendToTarget();
            QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget[" + z16 + "] .type=" + i3);
            return;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer .type=" + i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void R(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        com.tencent.mobileqq.filemanager.app.f fVar = new com.tencent.mobileqq.filemanager.app.f();
        if (M0(protoResp)) {
            fVar.f207264m = -100001;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
        } else if (protoResp.resp.getResultCode() != 1000) {
            fVar.f207264m = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
            }
            if (!cmd0x346_rspbody.msg_download_succ_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
            } else {
                cmd0x346$DownloadSuccRsp cmd0x346_downloadsuccrsp = cmd0x346_rspbody.msg_download_succ_rsp.get();
                if (cmd0x346_downloadsuccrsp.int32_ret_code.has()) {
                    fVar.f207264m = cmd0x346_downloadsuccrsp.int32_ret_code.get();
                }
                if (cmd0x346_downloadsuccrsp.str_ret_msg.has()) {
                    fVar.f207265n = cmd0x346_downloadsuccrsp.str_ret_msg.get();
                }
                if (cmd0x346_downloadsuccrsp.int32_down_stat.has()) {
                    fVar.f207252a = cmd0x346_downloadsuccrsp.int32_down_stat.get();
                }
                z16 = true;
                StatictisInfo statictisInfo = new StatictisInfo();
                statictisInfo.errCode = fVar.f207264m;
                statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, "handleDownloadSuccResponse: return " + z16 + ", retCode=" + fVar.f207264m + ", retMsg=" + fVar.f207265n + ", retStat" + fVar.f207252a);
                }
                Q0(((e) protoReq.busiData).g(), 5007, z16, new Object[]{fVar, statictisInfo});
            }
        }
        z16 = false;
        StatictisInfo statictisInfo2 = new StatictisInfo();
        statictisInfo2.errCode = fVar.f207264m;
        statictisInfo2.retryCount = protoResp.freeRunnalbleIndex;
        if (QLog.isColorLevel()) {
        }
        Q0(((e) protoReq.busiData).g(), 5007, z16, new Object[]{fVar, statictisInfo2});
    }

    public final void R0(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        com.tencent.mobileqq.filemanager.app.d remove;
        Bundle bundle = toServiceMsg.extraData;
        String str = f206931h;
        if (bundle.containsKey(str)) {
            long j3 = toServiceMsg.extraData.getLong(str);
            synchronized (this.f206937c) {
                remove = this.f206937c.remove(Long.valueOf(j3));
            }
            if (remove != null) {
                Message obtainMessage = f206933j.obtainMessage();
                obtainMessage.what = i3;
                obtainMessage.obj = new Object[]{remove, Boolean.valueOf(z16), obj};
                obtainMessage.sendToTarget();
                QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget. seq=" + j3 + ".type=" + i3);
                return;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer. seq=" + j3 + ".type=" + i3);
            return;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find seq_key. type=" + i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void S(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z16;
        FileManagerEntity D;
        boolean z17 = false;
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x346_rspbody.msg_apply_copy_to_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse rspBody has not hasMsgApplyDownloadAbsRsp");
                i3 = -100003;
            } else {
                cmd0x346$ApplyCopyToRsp cmd0x346_applycopytorsp = cmd0x346_rspbody.msg_apply_copy_to_rsp.get();
                if (cmd0x346_applycopytorsp.int32_ret_code.has()) {
                    i16 = cmd0x346_applycopytorsp.int32_ret_code.get();
                } else {
                    i16 = 0;
                }
                if (cmd0x346_applycopytorsp.str_ret_msg.has()) {
                    str = cmd0x346_applycopytorsp.str_ret_msg.get();
                } else {
                    str = null;
                }
                if (cmd0x346_applycopytorsp.str_file_key.has()) {
                    str2 = cmd0x346_applycopytorsp.str_file_key.get();
                } else {
                    str2 = null;
                }
                str3 = str2;
                i3 = i16;
                str4 = str;
                z16 = true;
                if (i3 == 0) {
                    z17 = z16;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardFromOfflineResponse: return " + z17 + ", retCode=" + i3 + ", retMsg=" + str4);
                }
                long d16 = ((e) protoReq.busiData).d();
                D = this.f206935a.getFileManagerDataCenter().D(d16);
                if (D != null) {
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "forward offline file, but entity is null!!!");
                    return;
                }
                if (z17) {
                    FileManagerReporter.a aVar = new FileManagerReporter.a();
                    aVar.f209157b = "send_file_suc";
                    aVar.f209158c = 1;
                    FileManagerReporter.addData(this.f206935a.getCurrentAccountUin(), aVar);
                }
                if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.f206935a) && com.tencent.mobileqq.filemanager.fileassistant.util.h.k(D.peerUin)) {
                    if (z17) {
                        X0(D, str3);
                    }
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "notify to old device[" + z17 + "]:" + D.nSessionId);
                    return;
                }
                if (i3 == -6101 || i3 == -7003) {
                    D.status = 16;
                    Object obj = D.mContext;
                    if (obj != null && (obj instanceof FileManagerEntity)) {
                        FileManagerEntity fileManagerEntity = (FileManagerEntity) obj;
                        fileManagerEntity.status = 16;
                        this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
                        D.mContext = null;
                    }
                    this.f206935a.getFileManagerDataCenter().f0(D);
                }
                A1(d16, z17, i3, str4, str3, D);
                return;
            }
        }
        z16 = false;
        str4 = null;
        str3 = null;
        if (i3 == 0) {
        }
        if (QLog.isColorLevel()) {
        }
        long d162 = ((e) protoReq.busiData).d();
        D = this.f206935a.getFileManagerDataCenter().D(d162);
        if (D != null) {
        }
    }

    public void S0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (obj == null) {
            h0(toServiceMsg, fromServiceMsg);
            return;
        }
        k.b bVar = (k.b) obj;
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + ((int) bVar.f286296k));
        }
        byte b16 = bVar.f286296k;
        if (b16 != 1) {
            if (b16 != 2) {
                if (b16 != 3) {
                    if (b16 == 6) {
                        k0(toServiceMsg, fromServiceMsg, bVar);
                        return;
                    }
                    return;
                }
                U(toServiceMsg, fromServiceMsg, bVar);
                return;
            }
            m0(toServiceMsg, fromServiceMsg, bVar);
            return;
        }
        l0(toServiceMsg, fromServiceMsg, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void T(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        boolean z16;
        String str;
        String str2;
        long j3;
        String str3;
        long j16;
        String str4;
        boolean z17;
        int i16;
        boolean z18;
        FileManagerEntity D;
        String str5 = null;
        long j17 = 0;
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i16 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i16 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            i3 = FileReaderX5.ERR_CODE_INIT_FAILED;
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x346_rspbody.msg_apply_forward_file_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse rspBody has not hasMsgApplyForwardFileRsp");
                str4 = null;
                str3 = null;
                j16 = 0;
                z16 = false;
                z17 = false;
                if (i3 != 0) {
                    z18 = false;
                } else {
                    z18 = z17;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardResponse: return " + z18 + ", retCode=" + i3 + ", retMsg=" + str5 + ", totalSpace=" + j17 + ", usedSpace=" + j16);
                }
                long d16 = ((e) protoReq.busiData).d();
                if (z18) {
                    FileManagerReporter.a aVar = new FileManagerReporter.a();
                    aVar.f209157b = "send_file_suc";
                    aVar.f209158c = 1;
                    FileManagerReporter.addData(this.f206935a.getCurrentAccountUin(), aVar);
                }
                boolean z19 = z18;
                this.f206935a.getFileManagerDataCenter().S(z18, i3, str5, str4, z16, str3, d16);
                this.f206935a.getFileManagerNotifyCenter().b(z19, 19, new Object[]{Integer.valueOf(i3), str5, Long.valueOf(j17), Long.valueOf(j16), str4, Long.valueOf(d16)});
                D = this.f206935a.getFileManagerDataCenter().D(d16);
                if (D != null) {
                    FileManagerUtil.preLoadThumb(this.f206935a, D);
                    int i17 = D.nOpType;
                    if (i17 == 26 || i17 == 27) {
                        try {
                            ((w) D.mContext).d(z19, D.strTroopFileUuid, D.nSessionId, i3, str5, String.valueOf(D.peerUin), str4);
                            return;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: Exception is " + e17.toString());
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (cmd0x346_rspbody.uint32_flag_use_media_platform.has()) {
                if (cmd0x346_rspbody.uint32_flag_use_media_platform.get() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: bUseMediaPlatform " + z16);
            } else {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
                z16 = false;
            }
            cmd0x346$ApplyForwardFileRsp cmd0x346_applyforwardfilersp = cmd0x346_rspbody.msg_apply_forward_file_rsp.get();
            if (cmd0x346_applyforwardfilersp.int32_ret_code.has()) {
                i3 = cmd0x346_applyforwardfilersp.int32_ret_code.get();
            } else {
                i3 = 0;
            }
            if (cmd0x346_applyforwardfilersp.str_ret_msg.has()) {
                str = cmd0x346_applyforwardfilersp.str_ret_msg.get();
            } else {
                str = null;
            }
            if (cmd0x346_applyforwardfilersp.bytes_uuid.has()) {
                str2 = new String(cmd0x346_applyforwardfilersp.bytes_uuid.get().toByteArray());
            } else {
                str2 = null;
            }
            if (z16 && cmd0x346_applyforwardfilersp.str_fileidcrc.has()) {
                str5 = cmd0x346_applyforwardfilersp.str_fileidcrc.get();
            }
            if (cmd0x346_applyforwardfilersp.uint64_total_space.has()) {
                j3 = cmd0x346_applyforwardfilersp.uint64_total_space.get();
            } else {
                j3 = 0;
            }
            if (cmd0x346_applyforwardfilersp.uint64_used_space.has()) {
                j17 = cmd0x346_applyforwardfilersp.uint64_used_space.get();
            }
            str3 = str5;
            j16 = j17;
            str5 = str;
            str4 = str2;
            j17 = j3;
            z17 = true;
            if (i3 != 0) {
            }
            if (QLog.isColorLevel()) {
            }
            long d162 = ((e) protoReq.busiData).d();
            if (z18) {
            }
            boolean z192 = z18;
            this.f206935a.getFileManagerDataCenter().S(z18, i3, str5, str4, z16, str3, d162);
            this.f206935a.getFileManagerNotifyCenter().b(z192, 19, new Object[]{Integer.valueOf(i3), str5, Long.valueOf(j17), Long.valueOf(j16), str4, Long.valueOf(d162)});
            D = this.f206935a.getFileManagerDataCenter().D(d162);
            if (D != null) {
            }
        }
        i3 = i16;
        str4 = null;
        str3 = null;
        j16 = 0;
        z16 = false;
        z17 = false;
        if (i3 != 0) {
        }
        if (QLog.isColorLevel()) {
        }
        long d1622 = ((e) protoReq.busiData).d();
        if (z18) {
        }
        boolean z1922 = z18;
        this.f206935a.getFileManagerDataCenter().S(z18, i3, str5, str4, z16, str3, d1622);
        this.f206935a.getFileManagerNotifyCenter().b(z1922, 19, new Object[]{Integer.valueOf(i3), str5, Long.valueOf(j17), Long.valueOf(j16), str4, Long.valueOf(d1622)});
        D = this.f206935a.getFileManagerDataCenter().D(d1622);
        if (D != null) {
        }
    }

    public void U0(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + str2 + "]");
        }
        cmd0x345$ReqBody.SubCmd0x7ReqBody subCmd0x7ReqBody = new cmd0x345$ReqBody.SubCmd0x7ReqBody();
        subCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(str));
        subCmd0x7ReqBody.str_file_path.set(str2);
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x7_req_body.set(subCmd0x7ReqBody);
        cmd0x345_reqbody.uint32_sub_cmd.set(8);
        r1("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), new e(false, 0L, (com.tencent.mobileqq.filemanager.app.d) null, 8), 30000, 3, 1);
    }

    public void V0(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + str + "]");
        }
        cmd0x346$ApplyDownloadAbsReq cmd0x346_applydownloadabsreq = new cmd0x346$ApplyDownloadAbsReq();
        cmd0x346_applydownloadabsreq.uint64_uin.set(Long.parseLong(this.f206935a.getCurrentAccountUin()));
        cmd0x346_applydownloadabsreq.bytes_uuid.set(ByteStringMicro.copyFrom(str.getBytes()));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.msg_apply_download_abs_req.set(cmd0x346_applydownloadabsreq);
        cmd0x346_reqbody.uint32_cmd.set(1100);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = f206932i;
        f206932i = i3 + 1;
        pBUInt32Field.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        if (I0()) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
            if (str2 != null && str2.length() > 0) {
                cmd0x346_applydownloadabsreq.str_fileidcrc.set(str2);
                QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform enabled");
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
            }
        } else {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform not enabled");
        }
        r1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", cmd0x346_reqbody.toByteArray(), new e(), 30000, 3, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, long j3) {
        boolean z16;
        boolean z17;
        long j16;
        FileManagerEntity M;
        long resultCode = fromServiceMsg.getResultCode();
        if (resultCode != Constant.FROM_ID_UNINSTALL_PLUGIN && resultCode != 1013) {
            if (resultCode != 1000) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleOffLineFileSendCCSuccess: resp is failed[" + fromServiceMsg + "]");
                resultCode = WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT;
                z16 = false;
                if (resultCode != -100001) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
                if (!z17 && i3 < 3) {
                    toServiceMsg.extraData.putInt("retryIndex", i3 + 1);
                    return;
                }
                j16 = fromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
                if (j16 != 0 && j16 != 241) {
                    resultCode = j16;
                    z16 = false;
                }
                if (z16 && j3 > 0) {
                    FileManagerUtil.processAIOTimGraytips(this.f206935a, j3);
                    M = this.f206935a.getFileManagerDataCenter().M(j3);
                    if (M != null) {
                        if (M.fileSize <= FileManagerUtil.getDocsImportFileMaxSize(M.fileName)) {
                            ((AIOMessageSpreadManager) this.f206935a.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).n(this.f206935a.getMessageProxy(M.peerType).H(M.peerUin, M.peerType, M.uniseq));
                        } else if (QLog.isColorLevel()) {
                            QLog.e("AIOMessageSpreadManager", 1, "can't find File Msg sID:" + j3);
                        }
                    }
                }
                long j17 = toServiceMsg.extraData.getLong("uniseq");
                R0(toServiceMsg, 5014, z16, new Object[]{Boolean.valueOf(z16), Long.valueOf(resultCode), Integer.valueOf(fromServiceMsg.getAppSeq()), Long.valueOf(j3), Long.valueOf(j17)});
                com.tencent.mobileqq.activity.aio.forward.b.d().k(this.f206935a, j17);
            }
        } else {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleOffLineFileSendCCSuccess: resp is timeout[" + fromServiceMsg + "]");
            resultCode = -100001L;
        }
        z16 = true;
        if (resultCode != -100001) {
        }
        int i36 = toServiceMsg.extraData.getInt("retryIndex", 0);
        if (!z17) {
        }
        j16 = fromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
        if (j16 != 0) {
            resultCode = j16;
            z16 = false;
        }
        if (z16) {
            FileManagerUtil.processAIOTimGraytips(this.f206935a, j3);
            M = this.f206935a.getFileManagerDataCenter().M(j3);
            if (M != null) {
            }
        }
        long j172 = toServiceMsg.extraData.getLong("uniseq");
        R0(toServiceMsg, 5014, z16, new Object[]{Boolean.valueOf(z16), Long.valueOf(resultCode), Integer.valueOf(fromServiceMsg.getAppSeq()), Long.valueOf(j3), Long.valueOf(j172)});
        com.tencent.mobileqq.activity.aio.forward.b.d().k(this.f206935a, j172);
    }

    public void X(final int i3, final String str, final String str2, final long j3, final short s16, final boolean z16, final int i16, final String str3, final com.tencent.mobileqq.filemanager.data.m mVar, final long j16, final int i17) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    FileTransferHandler.this.E0(i3, str, str2, j3, s16, z16, i16, str3, mVar, j16, i17);
                }
            });
        } else {
            E0(i3, str, str2, j3, s16, z16, i16, str3, mVar, j16, i17);
        }
    }

    public void Y(final String str, final long j3, final boolean z16) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.7
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + j3 + "]  handle query onlinefile upload progress resp. sucess =" + z16);
                    FileTransferHandler.this.f206935a.getOnlineFileSessionCenter().j(str, j3, z16);
                }
            });
            return;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + j3 + "]  handle query onlinefile upload progress resp. sucess =" + z16);
        this.f206935a.getOnlineFileSessionCenter().j(str, j3, z16);
    }

    public boolean Y0(String str, long j3) {
        SubMsgType0x5$MsgBody subMsgType0x5$MsgBody = new SubMsgType0x5$MsgBody();
        subMsgType0x5$MsgBody.uint32_sessionid.set((int) j3);
        byte[] byteArray = subMsgType0x5$MsgBody.toByteArray();
        FMTransC2CMsgInfo fMTransC2CMsgInfo = new FMTransC2CMsgInfo();
        fMTransC2CMsgInfo.sessionId = j3;
        fMTransC2CMsgInfo.busiType = 1025;
        fMTransC2CMsgInfo.msgSeq = FileManagerUtil.genMsgSeq();
        fMTransC2CMsgInfo.msgUid = FileManagerUtil.genMsgUid();
        fMTransC2CMsgInfo.entity = this.f206935a.getFileManagerDataCenter().D(j3);
        return g1(str, 529, 5, byteArray, fMTransC2CMsgInfo);
    }

    public void Z(final String str, int i3, final int i16, final String str2) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            final long j3 = i3;
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.8
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + j3 + "] Handle upload failed notify. retCode =" + i16 + "(1:cancel upload) reason=" + str2);
                    int i17 = i16;
                    if (1 == i17) {
                        FileTransferHandler.this.f206935a.getOnlineFileSessionCenter().p(str, j3);
                        return;
                    }
                    if (2 == i17) {
                        FileTransferHandler.this.f206935a.getOnlineFileSessionCenter().p(str, j3);
                    } else if (3 == i17) {
                        FileTransferHandler.this.f206935a.getOnlineFileSessionCenter().k(str, j3);
                    } else {
                        FileTransferHandler.this.f206935a.getOnlineFileSessionCenter().p(str, j3);
                    }
                }
            });
            return;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + i3 + "] Handle upload failed notify. retCode =" + i16 + "(1:cancel upload) reason=" + str2);
        if (1 == i16) {
            this.f206935a.getOnlineFileSessionCenter().p(str, i3);
            return;
        }
        if (2 == i16) {
            this.f206935a.getOnlineFileSessionCenter().p(str, i3);
        } else if (3 == i16) {
            this.f206935a.getOnlineFileSessionCenter().k(str, i3);
        } else {
            this.f206935a.getOnlineFileSessionCenter().p(str, i3);
        }
    }

    public void a0(final String str, int i3, final int i16, final int i17) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            final long j3 = i3;
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.9
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + j3 + "] Handle upload progress notify. speed=" + i17 + " progress =" + i16);
                    FileTransferHandler.this.f206935a.getOnlineFileSessionCenter().t(str, j3, i17, i16);
                }
            });
            return;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + i3 + "] Handle upload progress notify. speed=" + i17 + " progress =" + i16);
        this.f206935a.getOnlineFileSessionCenter().t(str, (long) i3, i17, i16);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void b0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        int i17;
        String str4;
        String str5;
        boolean z16;
        ByteStringMicro byteStringMicro;
        String bytes2HexStr;
        String str6;
        short s16;
        String str7;
        String str8;
        String str9;
        boolean z17;
        e eVar;
        String str10 = "";
        if (M0(protoResp)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        } else if (protoResp.resp.getResultCode() != 1000) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (!cmd0x346_rspbody.msg_apply_download_abs_rsp.has()) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not hasMsgApplyDownloadAbsRsp");
                i3 = FileReaderX5.ERR_CODE_INIT_FAILED;
            } else {
                cmd0x346$ApplyDownloadAbsRsp cmd0x346_applydownloadabsrsp = cmd0x346_rspbody.msg_apply_download_abs_rsp.get();
                if (cmd0x346_applydownloadabsrsp.int32_ret_code.has()) {
                    i16 = cmd0x346_applydownloadabsrsp.int32_ret_code.get();
                } else {
                    i16 = 0;
                }
                if (cmd0x346_applydownloadabsrsp.str_ret_msg.has()) {
                    str = cmd0x346_applydownloadabsrsp.str_ret_msg.get();
                } else {
                    str = null;
                }
                if (i16 == 0 && !cmd0x346_applydownloadabsrsp.msg_download_info.has()) {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not MsgDownloadSuccRsp");
                    str9 = str;
                    i3 = FileReaderX5.ERR_CODE_INIT_FAILED;
                    bytes2HexStr = null;
                    str8 = null;
                    s16 = 0;
                    z17 = false;
                    str2 = null;
                    str3 = null;
                    i17 = 0;
                    str4 = null;
                    str7 = null;
                    if (QLog.isColorLevel()) {
                    }
                    if (i3 == -100001) {
                    }
                    if (i3 != 0) {
                    }
                    eVar = (e) protoReq.busiData;
                    Bundle bundle = new Bundle();
                    if (str8 != null) {
                    }
                    bundle.putShort("httpsPort", s16);
                    if (!TextUtils.isEmpty(str10)) {
                    }
                    if (eVar.k()) {
                    }
                } else {
                    cmd0x346$DownloadInfo cmd0x346_downloadinfo = cmd0x346_applydownloadabsrsp.msg_download_info.get();
                    str2 = cmd0x346_downloadinfo.str_download_ip.get();
                    str3 = cmd0x346_downloadinfo.str_download_domain.get();
                    i17 = cmd0x346_downloadinfo.uint32_port.get();
                    str4 = cmd0x346_downloadinfo.str_download_url.get();
                    if (cmd0x346_downloadinfo.str_cookie.has()) {
                        str5 = "FTN5K=" + cmd0x346_downloadinfo.str_cookie.get();
                    } else {
                        str5 = null;
                    }
                    if (cmd0x346_rspbody.uint32_flag_use_media_platform.has()) {
                        if (cmd0x346_rspbody.uint32_flag_use_media_platform.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: bUseMediaPlatform " + z16);
                    } else {
                        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
                        z16 = false;
                    }
                    if (z16) {
                        byteStringMicro = cmd0x346_downloadinfo.bytes_media_platform_download_key.get();
                    } else {
                        byteStringMicro = cmd0x346_downloadinfo.bytes_download_key.get();
                    }
                    bytes2HexStr = HexUtil.bytes2HexStr(byteStringMicro.toByteArray());
                    if (cmd0x346_downloadinfo.str_https_download_domain.has()) {
                        str6 = cmd0x346_downloadinfo.str_https_download_domain.get();
                    } else {
                        str6 = null;
                    }
                    if (cmd0x346_downloadinfo.uint32_https_port.has()) {
                        s16 = (short) cmd0x346_downloadinfo.uint32_https_port.get();
                    } else {
                        s16 = 0;
                    }
                    if (cmd0x346_downloadinfo.str_download_dns.has()) {
                        str10 = cmd0x346_downloadinfo.str_download_dns.get();
                    }
                    i3 = i16;
                    str7 = str5;
                    str8 = str6;
                    str9 = str;
                    z17 = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("FileTransferHandler<FileAssistant>", 2, "handlePreviewResponse: return " + z17 + ", retCode=" + i3 + ", retMsg=" + str9 + ", Key=" + bytes2HexStr + ", IP=" + str2 + ", Domain=" + str3 + ", port=" + i17 + ", strHttpsDomain=" + str8 + ", httpsPort=" + ((int) s16) + "ipv6Domain=" + str10);
                    }
                    if (i3 == -100001) {
                        i3 = FileMsg.RESULT_CODE_MSF_TIMEOUT;
                    } else if (i3 == -100003) {
                        i3 = 9045;
                    }
                    if (i3 != 0) {
                        z17 = false;
                    }
                    eVar = (e) protoReq.busiData;
                    Bundle bundle2 = new Bundle();
                    if (str8 != null) {
                        bundle2.putString("strHttpsDomain", str8);
                    }
                    bundle2.putShort("httpsPort", s16);
                    if (!TextUtils.isEmpty(str10)) {
                        bundle2.putString("IPv6Dns", str10);
                    }
                    if (eVar.k()) {
                        this.f206935a.getFileManagerNotifyCenter().b(z17, 191, new Object[]{Integer.valueOf(i3), str9, str7, bytes2HexStr, str2, str3, Integer.valueOf(i17), str4, Long.valueOf(eVar.d()), bundle2});
                        return;
                    } else {
                        this.f206935a.getFileManagerNotifyCenter().b(z17, 18, new Object[]{Integer.valueOf(i3), str9, str7, bytes2HexStr, str2, str3, Integer.valueOf(i17), bundle2});
                        return;
                    }
                }
            }
        }
        bytes2HexStr = null;
        str8 = null;
        s16 = 0;
        z17 = false;
        str9 = null;
        str2 = null;
        str3 = null;
        i17 = 0;
        str4 = null;
        str7 = null;
        if (QLog.isColorLevel()) {
        }
        if (i3 == -100001) {
        }
        if (i3 != 0) {
        }
        eVar = (e) protoReq.busiData;
        Bundle bundle22 = new Bundle();
        if (str8 != null) {
        }
        bundle22.putShort("httpsPort", s16);
        if (!TextUtils.isEmpty(str10)) {
        }
        if (eVar.k()) {
        }
    }

    public boolean b1(String str, long j3) {
        com.tencent.mobileqq.filemanager.data.m mVar = new com.tencent.mobileqq.filemanager.data.m();
        mVar.f207829m = (byte[]) f206934k.clone();
        mVar.F = (short) 4;
        mVar.f207826f = j3;
        byte[] u16 = this.f206935a.getFileTransferHandler().u(mVar);
        if (u16 == null) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "]. recvOnLineFile failed:");
            return false;
        }
        return this.f206935a.getMsgHandler().a3().g0(str, j3, 133, u16);
    }

    public void c1(String str, String str2, String str3, String str4, boolean z16) {
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "RemoveOfflineFile : PeerUin[" + FileManagerUtil.enCodecString(str) + "], FileUUID[" + str2 + "], bSend[" + z16 + "]");
        }
        if (z16) {
            i3 = 1;
        }
        cmd0x346$DeleteFileReq cmd0x346_deletefilereq = new cmd0x346$DeleteFileReq();
        this.f206935a.getCurrentAccountUin();
        try {
            long parseLong = Long.parseLong(this.f206935a.getCurrentAccountUin());
            long parseLong2 = Long.parseLong(str);
            cmd0x346_deletefilereq.uint64_uin.set(parseLong);
            cmd0x346_deletefilereq.uint64_peer_uin.set(parseLong2);
            cmd0x346_deletefilereq.uint32_delete_type.set(i3);
            cmd0x346_deletefilereq.bytes_uuid.set(ByteStringMicro.copyFrom(str2.getBytes()));
            cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
            cmd0x346_reqbody.msg_delete_file_req.set(cmd0x346_deletefilereq);
            cmd0x346_reqbody.uint32_cmd.set(900);
            PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
            int i16 = f206932i;
            f206932i = i16 + 1;
            pBUInt32Field.set(i16);
            cmd0x346_reqbody.uint32_business_id.set(3);
            cmd0x346_reqbody.uint32_client_type.set(104);
            if (I0()) {
                cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
                if (str3 != null && str3.length() > 0) {
                    cmd0x346_deletefilereq.str_fileidcrc.set(str3);
                    QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform enabled");
                } else {
                    QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
                }
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform not enabled");
            }
            r1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900", cmd0x346_reqbody.toByteArray(), new e(str2), 30000, 3, 1);
        } catch (Exception unused) {
        }
    }

    public void d1(FileManagerEntity fileManagerEntity, e.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i("FileTransferHandler<FileAssistant>", 2, "revertC2CFile ");
        }
        cmd0x346$RecallFileReq cmd0x346_recallfilereq = new cmd0x346$RecallFileReq();
        cmd0x346_recallfilereq.uint64_uin.set(this.f206935a.getLongAccountUin());
        cmd0x346_recallfilereq.bytes_uuid.set(ByteStringMicro.copyFrom(fileManagerEntity.Uuid.getBytes()));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.msg_recall_file_req.set(cmd0x346_recallfilereq);
        cmd0x346_reqbody.uint32_cmd.set(400);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = f206932i;
        f206932i = i3 + 1;
        pBUInt32Field.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        if (I0()) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
            String str = fileManagerEntity.fileIdCrc;
            if (str != null && str.length() > 0) {
                cmd0x346_recallfilereq.str_fileidcrc.set(fileManagerEntity.fileIdCrc);
                QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform enabled");
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform enabled but FileIdCrc is null");
            }
        } else {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform not enabled");
        }
        e eVar = new e();
        eVar.f207006a = aVar;
        r1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400", cmd0x346_reqbody.toByteArray(), eVar, 10000, 3, 1);
    }

    public void e1(String str, String str2, String str3, e.a aVar) {
        cmd0x345$ReqBody.SubCmd0xaReqBody subCmd0xaReqBody = new cmd0x345$ReqBody.SubCmd0xaReqBody();
        try {
            subCmd0xaReqBody.uint64_disscus_uin.set(Long.parseLong(str));
            subCmd0xaReqBody.uint64_uin.set(Long.parseLong(str2));
            subCmd0xaReqBody.str_file_id.set(str3);
            cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
            cmd0x345_reqbody.msg_subcmd_0xa_req_body.set(subCmd0xaReqBody);
            cmd0x345_reqbody.uint32_sub_cmd.set(10);
            e eVar = new e();
            eVar.f207010e = 10;
            eVar.f207006a = aVar;
            q1("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), eVar);
        } catch (Exception e16) {
            aVar.onError(-1, e16.toString());
        }
    }

    public void f0(final String str, final long j3, final boolean z16) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + j3 + "]  handle recv onlinefile resp. sucess =" + z16);
                    FileTransferHandler.this.f206935a.getOnlineFileSessionCenter().o(str, j3, z16);
                }
            });
            return;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + j3 + "]  handle recv onlinefile resp. sucess =" + z16);
        this.f206935a.getOnlineFileSessionCenter().o(str, j3, z16);
    }

    public boolean g1(String str, int i3, int i16, byte[] bArr, FMTransC2CMsgInfo fMTransC2CMsgInfo) {
        fMTransC2CMsgInfo.subCmd = i16;
        if (fMTransC2CMsgInfo.fileTransferObserver != null) {
            synchronized (this.f206937c) {
                long j3 = this.f206936b;
                fMTransC2CMsgInfo.observerSeq = j3;
                this.f206937c.put(Long.valueOf(j3), fMTransC2CMsgInfo.fileTransferObserver);
                this.f206936b++;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "send0x211c2cMsg transC2CMsgInfo:" + fMTransC2CMsgInfo.toString());
        }
        return this.f206935a.getMsgHandler().a3().f0(str, i3, bArr, fMTransC2CMsgInfo);
    }

    public boolean i1(final String str, final FileManagerEntity fileManagerEntity, final com.tencent.mobileqq.filemanager.app.d dVar) {
        hummer_resv_21$ResvAttr hummer_resv_21_resvattr;
        MessageRecord w06 = this.f206935a.getMessageFacade().w0(str, 0, fileManagerEntity.uniseq);
        if (w06 != null) {
            fileManagerEntity.msgSeq = w06.msgseq;
            fileManagerEntity.msgUid = w06.msgUid;
        }
        final SubMsgType0x4$MsgBody subMsgType0x4$MsgBody = new SubMsgType0x4$MsgBody();
        im_msg_body$NotOnlineFile im_msg_body_notonlinefile = new im_msg_body$NotOnlineFile();
        im_msg_body_notonlinefile.uint32_file_type.set(0);
        im_msg_body_notonlinefile.bytes_file_uuid.set(ByteStringMicro.copyFrom(fileManagerEntity.Uuid.getBytes()));
        im_msg_body_notonlinefile.uint64_file_size.set(fileManagerEntity.fileSize);
        im_msg_body_notonlinefile.bytes_file_name.set(ByteStringMicro.copyFrom(fileManagerEntity.fileName.getBytes()));
        if (!TextUtils.isEmpty(fileManagerEntity.strFileMd5)) {
            im_msg_body_notonlinefile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(fileManagerEntity.strFileMd5)));
        }
        im_msg_body_notonlinefile.uint32_subcmd.set(1);
        if (fileManagerEntity.bUseMediaPlatform) {
            String str2 = fileManagerEntity.fileIdCrc;
            if (str2 != null && str2.length() > 0) {
                im_msg_body_notonlinefile.str_fileidcrc_media.set(fileManagerEntity.fileIdCrc);
                QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform enabled");
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform enabled but FileIdCrc is null");
            }
        } else {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform not enabled");
        }
        j(im_msg_body_notonlinefile, com.tencent.mobileqq.filemanager.util.k.f(w06));
        subMsgType0x4$MsgBody.msg_not_online_file.set(im_msg_body_notonlinefile);
        if (!TextUtils.isEmpty(fileManagerEntity.yybApkPackageName)) {
            hummer_resv_21$ResvAttr hummer_resv_21_resvattr2 = new hummer_resv_21$ResvAttr();
            hummer_resv_21$FileApkInfo hummer_resv_21_fileapkinfo = new hummer_resv_21$FileApkInfo();
            if (!TextUtils.isEmpty(fileManagerEntity.yybApkPackageName)) {
                hummer_resv_21_fileapkinfo.str_package_name.set(fileManagerEntity.yybApkPackageName);
            }
            if (!TextUtils.isEmpty(fileManagerEntity.yybApkName)) {
                hummer_resv_21_fileapkinfo.str_app_name.set(fileManagerEntity.yybApkName);
            }
            if (!TextUtils.isEmpty(fileManagerEntity.yybApkIconUrl)) {
                hummer_resv_21_fileapkinfo.str_icon_url.set(fileManagerEntity.yybApkIconUrl);
            }
            hummer_resv_21_resvattr2.file_apk_info.set(hummer_resv_21_fileapkinfo);
            subMsgType0x4$MsgBody.resv_attr.set(hummer_resv_21_resvattr2);
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(str)) {
            if (subMsgType0x4$MsgBody.resv_attr.has()) {
                hummer_resv_21_resvattr = subMsgType0x4$MsgBody.resv_attr.get();
            } else {
                hummer_resv_21_resvattr = new hummer_resv_21$ResvAttr();
            }
            hummer_resv_21$FileAssitInfo hummer_resv_21_fileassitinfo = new hummer_resv_21$FileAssitInfo();
            hummer_resv_21_fileassitinfo.uint64_session_id.set(fileManagerEntity.nSessionId);
            hummer_resv_21_fileassitinfo.uint32_group_id.set(fileManagerEntity.dlGroupId);
            hummer_resv_21_fileassitinfo.uint32_group_count.set(fileManagerEntity.dlGroupCount);
            hummer_resv_21_fileassitinfo.uint32_group_idx.set(fileManagerEntity.dlGourpIndex);
            hummer_resv_21_resvattr.file_assist_info.set(hummer_resv_21_fileassitinfo);
            hummer_resv_21_resvattr.device_type.set(com.tencent.mobileqq.filemanager.fileassistant.util.h.d());
            subMsgType0x4$MsgBody.resv_attr.set(hummer_resv_21_resvattr);
        }
        final hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo = new hummer_resv_21$FileImgInfo();
        final Handler handler = new Handler(Looper.getMainLooper());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.6
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                FileManagerUtil.fixEntityThumbSize(fileManagerEntity);
                FileManagerEntity fileManagerEntity2 = fileManagerEntity;
                int i16 = fileManagerEntity2.imgHeight;
                if (i16 > 0 && fileManagerEntity2.imgWidth > 0) {
                    hummer_resv_21_fileimginfo.uint32_file_height.set(i16);
                    hummer_resv_21_fileimginfo.uint32_file_width.set(fileManagerEntity.imgWidth);
                    subMsgType0x4$MsgBody.file_image_info.set(hummer_resv_21_fileimginfo);
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + fileManagerEntity.nSessionId + "]Send CCMsg, setThumbSize height[" + fileManagerEntity.imgHeight + "], width[" + fileManagerEntity.imgWidth + "]");
                } else if (!FileManagerUtil.hasNoThumb(fileManagerEntity2) && ((i3 = fileManagerEntity.nFileType) == 0 || i3 == 2)) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i17 = fileManagerEntity.nFileType;
                            if (i17 == 0) {
                                QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + fileManagerEntity.nSessionId + "]Send CCMsg, but not size and thumb, try download Pic Thumb");
                                FileTransferHandler.this.f206935a.getFileManagerEngine().n(fileManagerEntity, 7);
                                return;
                            }
                            if (i17 == 2) {
                                QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + fileManagerEntity.nSessionId + "]Send CCMsg, but not size and thumb, try download Video Thumb");
                                FileTransferHandler.this.f206935a.getFileManagerEngine().p(fileManagerEntity);
                            }
                        }
                    }, 1000L);
                }
                final byte[] byteArray = subMsgType0x4$MsgBody.toByteArray();
                final FMTransC2CMsgInfo fMTransC2CMsgInfo = new FMTransC2CMsgInfo();
                fMTransC2CMsgInfo.busiType = 1028;
                FileManagerEntity fileManagerEntity3 = fileManagerEntity;
                fMTransC2CMsgInfo.uuid = fileManagerEntity3.Uuid;
                fMTransC2CMsgInfo.uniseq = fileManagerEntity3.uniseq;
                fMTransC2CMsgInfo.fileTransferObserver = dVar;
                fMTransC2CMsgInfo.msgSeq = fileManagerEntity3.msgSeq;
                fMTransC2CMsgInfo.msgUid = fileManagerEntity3.msgUid;
                fMTransC2CMsgInfo.sessionId = fileManagerEntity3.nSessionId;
                fMTransC2CMsgInfo.entity = fileManagerEntity3;
                fileManagerEntity3.bOnceSuccess = true;
                fileManagerEntity3.strQRUrl = FileManagerUtil.getImageUrl(fileManagerEntity3);
                FileTransferHandler.this.f206935a.getFileManagerDataCenter().f0(fileManagerEntity);
                QLog.i("FileTransferHandler<FileAssistant>", 2, "=_= ^> [Send CC]send offline CC [" + fileManagerEntity.nSessionId + "], 0x211, 0x4");
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        FileTransferHandler.this.g1(str, 529, 4, byteArray, fMTransC2CMsgInfo);
                    }
                });
            }
        }, 32, null, false);
        return true;
    }

    public void j0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.i("FileTransferHandler<FileAssistant>", 2, "handleResponse : req is null");
                return;
            }
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            float currentTimeMillis = ((float) (System.currentTimeMillis() - toServiceMsg.extraData.getLong("sendtimekey"))) / 1000.0f;
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "[RES]cmd=" + fromServiceMsg.getServiceCmd() + " app seq:" + fromServiceMsg.getAppSeq() + " during " + this.f206938d.format(currentTimeMillis) + "sec.");
            }
        }
        if (toServiceMsg.getServiceCmd().equals("TransService.ReqOffFilePack")) {
            S0(toServiceMsg, fromServiceMsg, (k.b) r(toServiceMsg, fromServiceMsg));
            return;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResponse : cmd " + toServiceMsg.getServiceCmd().hashCode() + QzoneWebMusicJsPlugin.EVENT_UNKOWN);
    }

    public void j1(long j3, byte[] bArr, String str) {
        int i3;
        FileManagerEntity D = this.f206935a.getFileManagerDataCenter().D(j3);
        if (D == null) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "entity is null");
            return;
        }
        D.strFileMd5 = HexUtil.bytes2HexStr(bArr);
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(1);
        long longAccountUin = this.f206935a.getLongAccountUin();
        ProtocolHelper.fillMsgHeader(subMsgType0x7$MsgBody.msg_header, longAccountUin, longAccountUin, 0);
        SubMsgType0x7$MsgBody.FTNNotify fTNNotify = new SubMsgType0x7$MsgBody.FTNNotify();
        fTNNotify.uint64_sessionid.set(D.nSessionId);
        fTNNotify.str_file_name.set(D.fileName);
        fTNNotify.str_file_index.set(str);
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(D.strFileMd5);
        fTNNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(hexStr2Bytes));
        fTNNotify.uint64_file_len.set(D.fileSize);
        fTNNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(hexStr2Bytes));
        int i16 = D.nFileType;
        if (i16 != 0) {
            if (i16 != 2) {
                i3 = 0;
            } else {
                i3 = 2;
            }
        } else {
            i3 = 1;
        }
        fTNNotify.uint32_originfiletype.set(i3);
        fTNNotify.setHasFlag(true);
        subMsgType0x7$MsgBody.rpt_msg_subcmd_0x1_ftn_notify.add(fTNNotify);
        subMsgType0x7$MsgBody.setHasFlag(true);
        int i17 = subMsgType0x7$MsgBody.msg_header.uint32_dst_ter_type.get();
        String currentAccountUin = this.f206935a.getCurrentAccountUin();
        byte[] byteArray = subMsgType0x7$MsgBody.toByteArray();
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + D.nSessionId);
        }
        msg_svc$PbSendMsgReq h16 = h1(currentAccountUin, 7, byteArray, D.nSessionId, i17);
        DataLineHandler.d3(subMsgType0x7$MsgBody, h16);
        o(false, 1004, D.nSessionId, h16);
    }

    public void k(int i3, int i16, FileManagerEntity fileManagerEntity) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardIntrlnal : uDstId[" + String.valueOf(fileManagerEntity.peerUin) + "], uDstUin[" + String.valueOf(fileManagerEntity.selfUin) + " nDstSvcId[" + String.valueOf(i3) + " uFileSize[" + String.valueOf(fileManagerEntity.fileSize) + " strFileName[" + String.valueOf(fileManagerEntity.fileName) + " strUuid[" + String.valueOf(fileManagerEntity.Uuid) + "]");
        }
        String str = fileManagerEntity.Uuid;
        if (str != null && str.length() >= 1 && this.f206935a.getAccount() != null) {
            cmd0x346$ApplyCopyToReq cmd0x346_applycopytoreq = new cmd0x346$ApplyCopyToReq();
            String replace = this.f206935a.getAccount().replace(Marker.ANY_NON_NULL_MARKER, "");
            cmd0x346_applycopytoreq.uint64_dst_id.set(Long.parseLong(replace));
            if (i3 == 106 || i3 == 102 || i3 == 104) {
                cmd0x346_applycopytoreq.uint64_dst_id.set(Long.parseLong(fileManagerEntity.peerUin));
            }
            cmd0x346_applycopytoreq.uint32_dst_svcid.set(i3);
            cmd0x346_applycopytoreq.uint64_src_uin.set(Long.parseLong(replace));
            cmd0x346_applycopytoreq.uint64_file_size.set(fileManagerEntity.fileSize);
            cmd0x346_applycopytoreq.str_file_name.set(fileManagerEntity.fileName);
            cmd0x346_applycopytoreq.bytes_uuid.set(ByteStringMicro.copyFrom(fileManagerEntity.Uuid.getBytes()));
            cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
            cmd0x346_reqbody.msg_apply_copy_to_req.set(cmd0x346_applycopytoreq);
            cmd0x346_reqbody.uint32_cmd.set(60100);
            PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
            int i17 = f206932i;
            f206932i = i17 + 1;
            pBUInt32Field.set(i17);
            cmd0x346_reqbody.uint32_business_id.set(i16);
            cmd0x346_reqbody.uint32_client_type.set(104);
            r1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", cmd0x346_reqbody.toByteArray(), new e(false, fileManagerEntity.nSessionId), 30000, 3, 1);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("FileTransferHandler<FileAssistant>", 2, "uuid or selfUin is null!!!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k1(long j3, String str, String str2, String str3, long j16, String str4, long j17, long j18, com.tencent.mobileqq.filemanager.app.d dVar) {
        boolean z16;
        int i3;
        cmd0x345$ReqBody.SubCmd0x2ReqBody subCmd0x2ReqBody = new cmd0x345$ReqBody.SubCmd0x2ReqBody();
        subCmd0x2ReqBody.uint32_disscus_uin.set((int) Long.parseLong(str));
        subCmd0x2ReqBody.uint32_sender_uin.set((int) Long.parseLong(str2));
        subCmd0x2ReqBody.str_file_name.set(str3);
        subCmd0x2ReqBody.uint64_file_size.set(j16);
        subCmd0x2ReqBody.str_file_id.set(str4);
        subCmd0x2ReqBody.str_batch_id.set(UUID.randomUUID().toString().replaceAll("-", ""));
        subCmd0x2ReqBody.str_batch_item_id.set(UUID.randomUUID().toString().replaceAll("-", ""));
        subCmd0x2ReqBody.uint64_time.set(com.tencent.mobileqq.service.message.e.K0());
        subCmd0x2ReqBody.uint32_busid.set(106);
        final FileManagerEntity D = this.f206935a.getFileManagerDataCenter().D(j3);
        if (D != null) {
            hummer_resv_21$ResvAttr hummer_resv_21_resvattr = new hummer_resv_21$ResvAttr();
            boolean z17 = true;
            if (FileManagerUtil.getFileType(D.fileName) == 5 && !TextUtils.isEmpty(D.strApkPackageName)) {
                hummer_resv_21$FileApkInfo hummer_resv_21_fileapkinfo = new hummer_resv_21$FileApkInfo();
                hummer_resv_21_fileapkinfo.str_package_name.set(D.strApkPackageName);
                hummer_resv_21_fileapkinfo.str_version.set("");
                hummer_resv_21_resvattr.file_apk_info.set(hummer_resv_21_fileapkinfo);
                z16 = true;
            } else {
                z16 = false;
            }
            int i16 = D.nFileType;
            if (i16 == 0 || i16 == 2) {
                FileManagerUtil.fixEntityThumbSize(D);
                if (D.imgHeight > 0 && D.imgWidth > 0) {
                    hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo = new hummer_resv_21$FileImgInfo();
                    hummer_resv_21_fileimginfo.uint32_file_height.set(D.imgHeight);
                    hummer_resv_21_fileimginfo.uint32_file_width.set(D.imgWidth);
                    hummer_resv_21_resvattr.file_image_info.set(hummer_resv_21_fileimginfo);
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "send Disc Feeds setThumbSize height[" + D.imgHeight + "], width[" + D.imgWidth + "]");
                    if (z17) {
                        subCmd0x2ReqBody.bytes_pb_bytes_reserve.set(ByteStringMicro.copyFrom(hummer_resv_21_resvattr.toByteArray()));
                    }
                } else if (!FileManagerUtil.hasNoThumb(D) && ((i3 = D.nFileType) == 0 || i3 == 2)) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileTransferHandler.11
                        @Override // java.lang.Runnable
                        public void run() {
                            int i17 = D.nFileType;
                            if (i17 == 0) {
                                QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + D.nSessionId + "]Send CCMsg, but not size and thumb, try download Pic Thumb");
                                FileTransferHandler.this.f206935a.getFileManagerEngine().n(D, 7);
                                return;
                            }
                            if (i17 == 2) {
                                QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + D.nSessionId + "]Send CCMsg, but not size and thumb, try download Video Thumb");
                                FileTransferHandler.this.f206935a.getFileManagerEngine().o(D);
                            }
                        }
                    }, 1000L);
                }
            }
            z17 = z16;
            if (z17) {
            }
        }
        if (j18 == 0 && QLog.isDevelopLevel()) {
            throw null;
        }
        subCmd0x2ReqBody.uint32_random.set(s.e(j18));
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x2_req_body.set(subCmd0x2ReqBody);
        cmd0x345_reqbody.uint32_sub_cmd.set(2);
        QLog.i("FileTransferHandler<FileAssistant>", 2, "=_= ^ [Disc Feed]send Disc Feed[" + j3 + "]");
        r1("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), new e(false, j3, dVar, 2), 30000, 3, 1);
    }

    public boolean l1(String str, String str2, String str3, long j3, long j16) {
        SubMsgType0x4$MsgBody subMsgType0x4$MsgBody = new SubMsgType0x4$MsgBody();
        im_msg_body$NotOnlineFile im_msg_body_notonlinefile = new im_msg_body$NotOnlineFile();
        im_msg_body_notonlinefile.uint32_file_type.set(1);
        im_msg_body_notonlinefile.bytes_file_uuid.set(ByteStringMicro.copyFrom(str3.getBytes()));
        im_msg_body_notonlinefile.uint64_file_size.set(j3);
        im_msg_body_notonlinefile.bytes_file_name.set(ByteStringMicro.copyFrom(str2.getBytes()));
        im_msg_body_notonlinefile.uint32_subcmd.set(2);
        subMsgType0x4$MsgBody.msg_not_online_file.set(im_msg_body_notonlinefile);
        byte[] byteArray = subMsgType0x4$MsgBody.toByteArray();
        FMTransC2CMsgInfo fMTransC2CMsgInfo = new FMTransC2CMsgInfo();
        fMTransC2CMsgInfo.busiType = 1029;
        fMTransC2CMsgInfo.uuid = str3;
        fMTransC2CMsgInfo.msgSeq = FileManagerUtil.genMsgSeq();
        fMTransC2CMsgInfo.msgUid = FileManagerUtil.genMsgUid();
        return g1(str, 529, 4, byteArray, fMTransC2CMsgInfo);
    }

    boolean m() {
        SharedPreferences sharedPreferences = this.f206935a.getApplication().getSharedPreferences("wifiphoto_smart_reminder", 0);
        long j3 = sharedPreferences.getLong("wifiphoto_smart_reminder_last_time", 0L);
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        if (K0 - j3 <= 86400) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("wifiphoto_smart_reminder_last_time", K0);
        edit.commit();
        return true;
    }

    public void m1(jc1.a aVar, com.tencent.mobileqq.filemanager.app.d dVar, FileManagerEntity fileManagerEntity) {
        ic1.d E = E(aVar);
        fileManagerEntity.strFileSha3 = vb1.a.b(aVar.f409779j);
        o1(1L, aVar.f409772c, aVar.f409773d, E, dVar, fileManagerEntity);
    }

    public void n1(jc1.a aVar, com.tencent.mobileqq.filemanager.app.d dVar, FileManagerEntity fileManagerEntity) {
        ic1.d L = L(aVar);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Send] Id[" + fileManagerEntity.nSessionId + "]SendOfflineFileHit");
        o1(1L, TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC, false, L, dVar, fileManagerEntity);
    }

    public void o1(long j3, int i3, boolean z16, ic1.d dVar, com.tencent.mobileqq.filemanager.app.d dVar2, FileManagerEntity fileManagerEntity) {
        e eVar;
        String str;
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i16 = f206932i;
        f206932i = i16 + 1;
        pBUInt32Field.set(i16);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + fileManagerEntity.nSessionId + "], send pb uMsgSubType[" + i3 + "]");
        if (i3 != 1600) {
            if (i3 != 1700) {
                if (i3 != 1800) {
                    QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^! SessionId[" + fileManagerEntity.nSessionId + "]send0x346Req, unknwon nCmdType:" + i3);
                    return;
                }
                cmd0x346_reqbody.msg_apply_upload_hit_req_v2.set(A(dVar));
                ic1.a aVar = dVar.f407454c;
                eVar = new e(aVar.f407426e, aVar.f407428g, (byte[]) null, dVar2);
                str = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
            } else {
                cmd0x346_reqbody.msg_apply_upload_req_v3.set(C(dVar));
                ic1.c cVar = dVar.f407453b;
                eVar = new e(cVar.f407445e, cVar.f407447g, (byte[]) null, dVar2);
                str = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
            }
        } else {
            cmd0x346_reqbody.msg_apply_upload_req_v2.set(B(dVar));
            ic1.b bVar = dVar.f407452a;
            eVar = new e(bVar.f407436e, (byte[]) null, bVar.f407437f, dVar2);
            str = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
        }
        if (fileManagerEntity.tmpSessionType > 0) {
            cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
            cmd0x346_extensionreq.uint64_id.set(3L);
            cmd0x346_extensionreq.uint64_type.set(fileManagerEntity.tmpSessionType);
            byte[] bArr = fileManagerEntity.tmpSessionSig;
            if (bArr != null && bArr.length > 0) {
                cmd0x346_extensionreq.bytes_sig.set(ByteStringMicro.copyFrom(bArr));
            }
            String str2 = fileManagerEntity.tmpSessionToPhone;
            if (str2 != null && str2.length() > 0) {
                cmd0x346_extensionreq.str_dst_phonenum.set(fileManagerEntity.tmpSessionToPhone);
            }
            QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^> SessionId[" + fileManagerEntity.nSessionId + "]send0x346Req, add TempInfo:" + fileManagerEntity.tmpSessionType);
            cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
        }
        if (z16) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
        }
        q1(str, cmd0x346_reqbody.toByteArray(), eVar);
    }

    ToServiceMsg p(String str) {
        return new ToServiceMsg("mobileqq.service", this.f206935a.getCurrentAccountUin(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        String str;
        boolean z17;
        byte[] bArr;
        boolean z18;
        QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^> [CS Replay]response V2");
        com.tencent.mobileqq.filemanager.app.f fVar = new com.tencent.mobileqq.filemanager.app.f();
        List<String> list = null;
        if (M0(protoResp)) {
            fVar.f207264m = -100001;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
        } else if (protoResp.resp.getResultCode() != 1000) {
            fVar.f207264m = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            fVar.f207260i = wupBuffer;
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
            }
            if (!cmd0x346_rspbody.msg_apply_upload_rsp_v2.has()) {
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
                QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            } else {
                list = a1(fVar, null, cmd0x346_rspbody.msg_apply_upload_rsp_v2.get());
                z16 = true;
                str = fVar.f207269r;
                if (str == null && str.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bArr = fVar.f207271t;
                if (bArr == null && bArr.length != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                StatictisInfo statictisInfo = new StatictisInfo();
                statictisInfo.errCode = fVar.f207264m;
                statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
                if (z18 && z17) {
                    fVar.f207265n = "uuid_null[" + fVar.toString() + "]";
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + z16 + ", retCode=" + fVar.f207264m + ", retMsg=" + fVar.f207265n + ", totalSpace=" + fVar.f207266o + ", usedSpace=" + fVar.f207267p + ", ip=" + fVar.f207269r + ", port=" + ((int) fVar.f207270s));
                }
                Q0(((e) protoReq.busiData).g(), 5004, z16, new Object[]{fVar, statictisInfo, list});
            }
        }
        z16 = false;
        str = fVar.f207269r;
        if (str == null) {
        }
        z17 = false;
        bArr = fVar.f207271t;
        if (bArr == null) {
        }
        z18 = true;
        StatictisInfo statictisInfo2 = new StatictisInfo();
        statictisInfo2.errCode = fVar.f207264m;
        statictisInfo2.retryCount = protoResp.freeRunnalbleIndex;
        if (z18) {
            fVar.f207265n = "uuid_null[" + fVar.toString() + "]";
            z16 = false;
        }
        if (QLog.isColorLevel()) {
        }
        Q0(((e) protoReq.busiData).g(), 5004, z16, new Object[]{fVar, statictisInfo2, list});
    }

    public void p1(ProtoReqManagerImpl.ProtoReq protoReq) {
        protoReq.callback = new f(this);
        ((IProtoReqManager) this.f206935a.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(protoReq);
    }

    public com.tencent.mobileqq.filemanager.data.m q(byte[] bArr) {
        boolean z16;
        if (bArr != null && bArr.length != 0) {
            int length = bArr.length;
            com.tencent.mobileqq.filemanager.data.m mVar = new com.tencent.mobileqq.filemanager.data.m();
            if (length >= 16) {
                PkgTools.getBytesData(bArr, 0, mVar.f207829m, 16);
                if (length >= 26) {
                    mVar.f207826f = PkgTools.getLongData(bArr, 22);
                    if (length >= 30) {
                        mVar.F = PkgTools.getShortData(bArr, 28);
                        if (length >= 32) {
                            short shortData = PkgTools.getShortData(bArr, 30);
                            if (shortData < 2) {
                                if (length >= 34) {
                                    mVar.G = PkgTools.getShortData(bArr, 32);
                                } else {
                                    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufReason");
                                    return null;
                                }
                            }
                            int i3 = 32 + shortData + 2;
                            int i16 = i3 + 2;
                            if (length >= i16) {
                                int shortData2 = PkgTools.getShortData(bArr, i3);
                                if (shortData2 < 4) {
                                    mVar.E = false;
                                } else {
                                    byte[] bArr2 = new byte[shortData2];
                                    PkgTools.getBytesData(bArr, i16, bArr2, shortData2);
                                    int i17 = 0;
                                    while (true) {
                                        if (i17 >= shortData2) {
                                            break;
                                        }
                                        byte b16 = bArr2[i17];
                                        int i18 = i17 + 1;
                                        int i19 = i18 + 2;
                                        if (shortData2 > i19) {
                                            int shortData3 = PkgTools.getShortData(bArr2, i18);
                                            if (b16 == 15) {
                                                if (shortData3 != 1) {
                                                    mVar.E = false;
                                                } else if (shortData2 >= i19 + shortData3) {
                                                    byte[] bArr3 = new byte[shortData3];
                                                    PkgTools.getBytesData(bArr2, i19, bArr3, shortData3);
                                                    if (bArr3[0] == 1) {
                                                        z16 = true;
                                                    } else {
                                                        z16 = false;
                                                    }
                                                    mVar.E = z16;
                                                }
                                            } else if (b16 == 4) {
                                                byte[] bArr4 = new byte[shortData3];
                                                if (shortData2 >= i19 + shortData3) {
                                                    PkgTools.getBytesData(bArr2, i19, bArr4, shortData3);
                                                    c s16 = s(bArr4);
                                                    if (s16 != null) {
                                                        mVar.f207824d = s16.f206997a;
                                                        mVar.f207825e = s16.f206998b;
                                                    } else {
                                                        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode fileinfo error for request or accept");
                                                        return null;
                                                    }
                                                } else {
                                                    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
                                                    break;
                                                }
                                            } else {
                                                continue;
                                            }
                                            i17 = shortData3 + i19;
                                        } else {
                                            QLog.e("FileTransferHandler<FileAssistant>", 1, "decode Cancel or accept tlv error - L");
                                            break;
                                        }
                                    }
                                }
                                return mVar;
                            }
                            QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wContextDataLen");
                            return null;
                        }
                        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wReasonLen");
                        return null;
                    }
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wCancelType");
                    return null;
                }
                QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - dwSessionId");
                return null;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufAppGUID");
            return null;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed context=null");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q0(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        byte[] bArr;
        boolean z19;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Replay]reponse V3");
        com.tencent.mobileqq.filemanager.app.f fVar = new com.tencent.mobileqq.filemanager.app.f();
        List<String> list = null;
        if (M0(protoResp)) {
            fVar.f207264m = -100001;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
        } else if (protoResp.resp.getResultCode() != 1000) {
            fVar.f207264m = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
        } else {
            byte[] wupBuffer = protoResp.resp.getWupBuffer();
            fVar.f207260i = wupBuffer;
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(wupBuffer);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
            }
            if (!cmd0x346_rspbody.msg_apply_upload_rsp_v3.has()) {
                fVar.f207264m = FileReaderX5.ERR_CODE_INIT_FAILED;
                QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            } else {
                if (cmd0x346_rspbody.uint32_flag_use_media_platform.has()) {
                    if (cmd0x346_rspbody.uint32_flag_use_media_platform.get() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    fVar.f207261j = z17;
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform " + fVar.f207261j);
                } else {
                    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform false uint32_flag_use_media_platform not set");
                }
                list = Z0(fVar, null, cmd0x346_rspbody.msg_apply_upload_rsp_v3.get());
                if (fVar.f207264m == 0) {
                    z16 = true;
                    fVar.f207255d = 2;
                    str = fVar.f207269r;
                    if (str == null && str.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    bArr = fVar.f207271t;
                    if (bArr == null && bArr.length != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    StatictisInfo statictisInfo = new StatictisInfo();
                    statictisInfo.errCode = fVar.f207264m;
                    statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
                    if (z19 && z18) {
                        fVar.f207265n = "uuid_null[" + fVar.toString() + "]";
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + z16 + ", retCode=" + fVar.f207264m + ", retMsg=" + fVar.f207265n + ", totalSpace=" + fVar.f207266o + ", usedSpace=" + fVar.f207267p + ", ip=" + fVar.f207269r + ", port=" + ((int) fVar.f207270s));
                    }
                    Q0(((e) protoReq.busiData).g(), 5004, z16, new Object[]{fVar, statictisInfo, list});
                }
            }
        }
        z16 = false;
        fVar.f207255d = 2;
        str = fVar.f207269r;
        if (str == null) {
        }
        z18 = false;
        bArr = fVar.f207271t;
        if (bArr == null) {
        }
        z19 = true;
        StatictisInfo statictisInfo2 = new StatictisInfo();
        statictisInfo2.errCode = fVar.f207264m;
        statictisInfo2.retryCount = protoResp.freeRunnalbleIndex;
        if (z19) {
            fVar.f207265n = "uuid_null[" + fVar.toString() + "]";
            z16 = false;
        }
        if (QLog.isColorLevel()) {
        }
        Q0(((e) protoReq.busiData).g(), 5004, z16, new Object[]{fVar, statictisInfo2, list});
    }

    public void q1(String str, byte[] bArr, e eVar) {
        ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
        protoReq.ssoCmd = str;
        protoReq.reqBody = bArr;
        protoReq.busiData = eVar;
        p1(protoReq);
    }

    public void r1(String str, byte[] bArr, e eVar, int i3, int i16, int i17) {
        ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
        protoReq.ssoCmd = str;
        protoReq.reqBody = bArr;
        protoReq.busiData = eVar;
        protoReq.tryTime = i3;
        protoReq.tryCount = i16;
        protoReq.fixScheduleCount = i17;
        p1(protoReq);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean z17;
        long j3;
        long resultCode = fromServiceMsg.getResultCode();
        boolean z18 = false;
        if (resultCode != Constant.FROM_ID_UNINSTALL_PLUGIN && resultCode != 1013) {
            if (resultCode != 1000) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleWlanNotify: resp is failed[" + fromServiceMsg + "]");
                resultCode = WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT;
                z16 = false;
                if (resultCode != -100001) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
                if (!z17 && i3 < 3) {
                    toServiceMsg.extraData.putInt("retryIndex", i3 + 1);
                    return;
                }
                j3 = fromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
                if (j3 == 0 && j3 != 241) {
                    resultCode = j3;
                } else {
                    z18 = z16;
                }
                QLog.i("FileTransferHandler<FileAssistant>", 1, "handleWlanNotify bSuccess: " + z18 + ", serverCode : " + resultCode);
            }
        } else {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleWlanNotify: resp is timeout[" + fromServiceMsg + "]");
            resultCode = -100001L;
        }
        z16 = true;
        if (resultCode != -100001) {
        }
        int i36 = toServiceMsg.extraData.getInt("retryIndex", 0);
        if (!z17) {
        }
        j3 = fromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
        if (j3 == 0) {
        }
        z18 = z16;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleWlanNotify bSuccess: " + z18 + ", serverCode : " + resultCode);
    }

    void s1(long j3, long j16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("freeSize", j3);
            jSONObject.put("deviceType", 2);
            jSONObject.put("subtype", "8");
            jSONObject.put("photoCount", j16);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        SubMsgType0x7$MsgBody.GenericSubCmd genericSubCmd = new SubMsgType0x7$MsgBody.GenericSubCmd();
        genericSubCmd.uint64_sessionid.set(1L);
        genericSubCmd.uint32_size.set(1);
        genericSubCmd.uint32_index.set(0);
        genericSubCmd.uint32_type.set(5);
        genericSubCmd.bytes_buf.set(ByteStringMicro.copyFrom(jSONObject.toString().getBytes()));
        genericSubCmd.setHasFlag(true);
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(4);
        subMsgType0x7$MsgBody.msg_header.uint32_src_app_id.set(1001);
        subMsgType0x7$MsgBody.msg_header.uint32_src_inst_id.set(AppSetting.f());
        subMsgType0x7$MsgBody.msg_header.uint32_dst_app_id.set(1);
        subMsgType0x7$MsgBody.msg_header.uint32_dst_inst_id.set(1);
        subMsgType0x7$MsgBody.msg_header.uint64_dst_uin.set(Long.valueOf(this.f206935a.getCurrentAccountUin()).longValue());
        subMsgType0x7$MsgBody.msg_header.uint64_src_uin.set(Long.valueOf(this.f206935a.getCurrentAccountUin()).longValue());
        subMsgType0x7$MsgBody.msg_header.setHasFlag(true);
        subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.set(genericSubCmd);
        subMsgType0x7$MsgBody.setHasFlag(true);
        String currentAccountUin = this.f206935a.getCurrentAccountUin();
        byte[] byteArray = subMsgType0x7$MsgBody.toByteArray();
        ToServiceMsg p16 = p(BaseConstants.CMD_MSG_PBSENDMSG);
        p16.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
        p16.extraData.putInt("ROUNTING_TYPE", 13);
        p16.extraData.putBoolean("ISFROM_DATALINE", true);
        p16.extraData.putInt("DATALINE_CMD", 1002);
        p16.addAttribute("cookie", 1);
        p16.extraData.putInt("DATALINE_TRYINDEX", 0);
        long genMsgUid = FileManagerUtil.genMsgUid();
        long genMsgSeq = FileManagerUtil.genMsgSeq();
        ac acVar = new ac();
        acVar.f286177a = 7;
        acVar.f286178b = byteArray;
        msg_svc$PbSendMsgReq a16 = p.a(this.f206935a, 13, currentAccountUin, acVar, genMsgSeq, s.g(genMsgUid));
        im_msg_head$InstInfo im_msg_head_instinfo = new im_msg_head$InstInfo();
        im_msg_head_instinfo.uint32_apppid.set(1);
        im_msg_head_instinfo.uint32_instid.set(1);
        im_msg_head_instinfo.setHasFlag(true);
        a16.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(im_msg_head_instinfo);
        im_msg_head$InstInfo im_msg_head_instinfo2 = new im_msg_head$InstInfo();
        im_msg_head_instinfo2.uint32_apppid.set(1001);
        im_msg_head_instinfo2.uint32_instid.set(AppSetting.f());
        im_msg_head_instinfo2.setHasFlag(true);
        im_msg_head$InstCtrl im_msg_head_instctrl = a16.routing_head.trans_0x211.inst_ctrl;
        im_msg_head_instctrl.msg_from_inst = im_msg_head_instinfo2;
        im_msg_head_instctrl.setHasFlag(true);
        p16.putWupBuffer(a16.toByteArray());
        p16.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        this.f206935a.sendToService(p16);
    }

    public com.tencent.mobileqq.filemanager.data.m t(byte[] bArr) {
        boolean z16;
        boolean z17;
        if (bArr != null && bArr.length != 0) {
            int length = bArr.length;
            com.tencent.mobileqq.filemanager.data.m mVar = new com.tencent.mobileqq.filemanager.data.m();
            if (length >= 16) {
                PkgTools.getBytesData(bArr, 0, mVar.f207829m, 16);
                if (length >= 28) {
                    mVar.f207826f = PkgTools.getLongData(bArr, 24);
                    if (length >= 51) {
                        int shortData = PkgTools.getShortData(bArr, 49);
                        if (shortData < 4) {
                            mVar.E = false;
                        } else {
                            byte[] bArr2 = new byte[shortData];
                            if (length >= 51 + shortData) {
                                PkgTools.getBytesData(bArr, 51, bArr2, shortData);
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= shortData) {
                                        break;
                                    }
                                    byte b16 = bArr2[i3];
                                    int i16 = i3 + 1;
                                    int i17 = i16 + 2;
                                    if (shortData >= i17) {
                                        int shortData2 = PkgTools.getShortData(bArr2, i16);
                                        if (b16 != 1 && b16 != 2 && b16 != 3) {
                                            if (b16 == 4) {
                                                byte[] bArr3 = new byte[shortData2];
                                                if (shortData >= i17 + shortData2) {
                                                    PkgTools.getBytesData(bArr2, i17, bArr3, shortData2);
                                                    c s16 = s(bArr3);
                                                    if (s16 != null) {
                                                        mVar.f207824d = s16.f206997a;
                                                        mVar.f207825e = s16.f206998b;
                                                    } else {
                                                        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode file info error for request or accept");
                                                        return null;
                                                    }
                                                } else {
                                                    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
                                                    break;
                                                }
                                            } else if (b16 != 12) {
                                                if (b16 == 15) {
                                                    if (shortData2 < 1) {
                                                        mVar.E = false;
                                                    } else if (shortData >= i17 + shortData2) {
                                                        byte[] bArr4 = new byte[shortData2];
                                                        PkgTools.getBytesData(bArr2, i17, bArr4, shortData2);
                                                        if (bArr4[0] == 1) {
                                                            z17 = true;
                                                        } else {
                                                            z17 = false;
                                                        }
                                                        mVar.E = z17;
                                                    }
                                                } else if (b16 == 17) {
                                                    if (shortData2 < 1) {
                                                        mVar.H = false;
                                                    } else if (shortData >= i17 + shortData2) {
                                                        byte[] bArr5 = new byte[shortData2];
                                                        PkgTools.getBytesData(bArr2, i17, bArr5, shortData2);
                                                        if (bArr5[0] == 1) {
                                                            z16 = true;
                                                        } else {
                                                            z16 = false;
                                                        }
                                                        mVar.H = z16;
                                                    }
                                                }
                                            }
                                        }
                                        i3 = shortData2 + i17;
                                    } else {
                                        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - L");
                                        break;
                                    }
                                }
                            } else {
                                QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - ismulitendpoint");
                                return null;
                            }
                        }
                        return mVar;
                    }
                    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufOther");
                    return null;
                }
                QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - dwSessionId");
                return null;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufAppGuid");
            return null;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed context=null");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t0(SubMsgType0x4$WlanRecvNotify subMsgType0x4$WlanRecvNotify) {
        long j3;
        if (!l(subMsgType0x4$WlanRecvNotify)) {
            QLog.e("FileTransferHandler<FileAssistant>", 1, "handleWlanNotify param failed");
            return;
        }
        long j16 = subMsgType0x4$WlanRecvNotify.uint64_session_id.get();
        if (this.f206935a.getFileManagerDataCenter().y(j16)) {
            QLog.i("FileTransferHandler<FileAssistant>", 1, j16 + " is exsited, igone!");
            return;
        }
        int i3 = subMsgType0x4$WlanRecvNotify.uint32_send_client_type.get();
        int i16 = subMsgType0x4$WlanRecvNotify.uint32_target_client_type.get();
        int d16 = com.tencent.mobileqq.filemanager.fileassistant.util.h.d();
        int f16 = com.tencent.mobileqq.filemanager.fileassistant.util.h.f(i3);
        int f17 = com.tencent.mobileqq.filemanager.fileassistant.util.h.f(i16);
        int f18 = com.tencent.mobileqq.filemanager.fileassistant.util.h.f(d16);
        if (f16 == 2) {
            j3 = 1152921504606846976L;
        } else {
            if (f16 == 1) {
                j3 = LockFreeTaskQueueCore.CLOSED_MASK;
            }
            if (this.f206935a.getFileManagerDataCenter().D(j16) == null) {
                QLog.i("FileTransferHandler<FileAssistant>", 1, j16 + " is exsited, igone!");
                return;
            }
            String str = subMsgType0x4$WlanRecvNotify.str_file_name.get();
            long j17 = subMsgType0x4$WlanRecvNotify.uint64_file_size.get();
            int i17 = subMsgType0x4$WlanRecvNotify.uint32_time.get();
            String g16 = com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.f206935a);
            FileManagerEntity fileManagerEntity = new FileManagerEntity();
            fileManagerEntity.nSessionId = j16;
            long j18 = j16;
            fileManagerEntity.uniseq = FileManagerUtil.genSessionId().longValue();
            fileManagerEntity.peerUin = g16;
            fileManagerEntity.fileName = str;
            fileManagerEntity.fileSize = j17;
            fileManagerEntity.msgTime = i17;
            fileManagerEntity.bDelInFM = true;
            boolean z16 = false;
            fileManagerEntity.cloudType = 0;
            fileManagerEntity.bOnceSuccess = true;
            if (f16 == f18) {
                z16 = true;
            }
            QLog.i("FileTransferHandler<FileAssistant>.NFRV", 1, "sendType:" + i3 + ",recvType:" + i16 + ",currentType:" + d16 + ",parentSendType:" + f16 + ",parentCurrentType:" + f18);
            if (f18 != f16 && f18 != f17) {
                fileManagerEntity.status = 5;
                fileManagerEntity.nOpType = 11;
            } else {
                fileManagerEntity.status = 16;
                fileManagerEntity.cloudType = 1;
            }
            String currentUin = this.f206935a.getCurrentUin();
            this.f206935a.getFileManagerDataCenter().t(fileManagerEntity);
            this.f206935a.getFileManagerDataCenter().r(g16, currentUin, z16, i3, fileManagerEntity);
            this.f206935a.getFileManagerDataCenter().d(j18);
            return;
        }
        j16 |= j3;
        if (this.f206935a.getFileManagerDataCenter().D(j16) == null) {
        }
    }

    public boolean t1(SubMsgType0x4$WlanRecvNotify subMsgType0x4$WlanRecvNotify) {
        SubMsgType0x4$MsgBody subMsgType0x4$MsgBody = new SubMsgType0x4$MsgBody();
        subMsgType0x4$MsgBody.msg_wlan_recved_notify.set(subMsgType0x4$WlanRecvNotify);
        byte[] byteArray = subMsgType0x4$MsgBody.toByteArray();
        FMTransC2CMsgInfo fMTransC2CMsgInfo = new FMTransC2CMsgInfo();
        fMTransC2CMsgInfo.busiType = 1055;
        fMTransC2CMsgInfo.msgSeq = FileManagerUtil.genMsgSeq();
        fMTransC2CMsgInfo.msgUid = FileManagerUtil.genMsgUid();
        return g1(com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.f206935a), 529, 4, byteArray, fMTransC2CMsgInfo);
    }

    public byte[] u(com.tencent.mobileqq.filemanager.data.m mVar) {
        if (mVar == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        PkgTools.copyData(bArr, 0, mVar.f207829m, 16);
        PkgTools.dWord2Byte(bArr, 22, mVar.f207826f);
        PkgTools.word2Byte(bArr, 28, mVar.F);
        PkgTools.word2Byte(bArr, 30, (short) 1);
        bArr[32] = 1;
        PkgTools.word2Byte(bArr, 35, (short) 11);
        bArr[37] = RegisterType.DOUBLE_HI;
        PkgTools.word2Byte(bArr, 38, (short) 1);
        bArr[40] = 1;
        bArr[41] = RegisterType.UNINIT_REF;
        PkgTools.word2Byte(bArr, 42, (short) 4);
        PkgTools.dWord2Byte(bArr, 44, this.f206935a.getAppid());
        byte[] bArr2 = new byte[48];
        PkgTools.copyData(bArr2, 0, bArr, 48);
        return bArr2;
    }

    public void u1(String str, String str2, boolean z16, String str3, com.tencent.mobileqq.filemanager.app.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "setDownloadSuccState : selfUin[" + FileManagerUtil.enCodecString(str) + "], filePath[" + str2 + "]");
        }
        cmd0x346$DownloadSuccReq cmd0x346_downloadsuccreq = new cmd0x346$DownloadSuccReq();
        cmd0x346_downloadsuccreq.uint64_uin.set(Long.parseLong(str));
        cmd0x346_downloadsuccreq.bytes_uuid.set(ByteStringMicro.copyFrom(str2.getBytes()));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.msg_download_succ_req.set(cmd0x346_downloadsuccreq);
        cmd0x346_reqbody.uint32_cmd.set(1000);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = f206932i;
        f206932i = i3 + 1;
        pBUInt32Field.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        if (z16) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
            if (str3 != null && str3.length() > 0) {
                cmd0x346_downloadsuccreq.str_fileidcrc.set(str3);
                QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform enabled");
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform enabled, but FileIdCrc is null");
            }
        } else {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform not enabled");
        }
        r1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000", cmd0x346_reqbody.toByteArray(), new e(dVar), 30000, 3, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public long v0(List<MessageRecord> list, String str, String str2, String str3, long j3, boolean z16, int i3, String str4, long j16, long j17, String str5, int i16, long j18, long j19, long j26, long j27, int i17, int i18, hummer_resv_21$ResvAttr hummer_resv_21_resvattr) {
        String str6;
        String makeTransFileProtocolData;
        MessageRecord d16 = q.d(i17);
        if (j18 > 0) {
            d16.uniseq = j18;
        } else {
            d16.createMessageUniseq();
        }
        d16.selfuin = this.f206935a.getCurrentAccountUin();
        d16.frienduin = str;
        d16.senderuin = str2;
        if (str4 == null || str4.length() < 1) {
            str6 = str3;
            makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(str6, j3, 0, z16);
        } else {
            str6 = str3;
            makeTransFileProtocolData = str4;
        }
        if (i17 == -3008) {
            makeTransFileProtocolData = str6;
        }
        d16.f203106msg = makeTransFileProtocolData;
        d16.msgtype = i17;
        d16.isread = z16;
        d16.issend = str2.equals(this.f206935a.getAccount()) ? 1 : 0;
        d16.istroop = i3;
        d16.msgseq = j16;
        d16.shmsgseq = s.b(j16, i3);
        d16.msgUid = j19;
        d16.time = j27;
        if (d16.isSend()) {
            ((ISVIPHandler) this.f206935a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(d16);
        } else if (j26 != -1) {
            d16.vipBubbleID = j26;
        } else {
            d16.vipBubbleID = com.tencent.imcore.message.facade.i.a(this.f206935a, str);
        }
        d16.vipBubbleDiyTextId = i18;
        if (hummer_resv_21_resvattr != null && hummer_resv_21_resvattr.file_image_info.has()) {
            hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo = hummer_resv_21_resvattr.file_image_info.get();
            d16.saveExtInfoToExtStr("file_pic_width", String.valueOf(hummer_resv_21_fileimginfo.uint32_file_width.get()));
            d16.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(hummer_resv_21_fileimginfo.uint32_file_height.get()));
            QLog.i("FileTransferHandler<FileAssistant>", 1, "Insert ThumbSize toMsg height[" + hummer_resv_21_fileimginfo.uint32_file_width.get() + "], width[" + hummer_resv_21_fileimginfo.uint32_file_height.get() + "]");
        }
        if (i17 == -2005) {
            ((MessageForFile) d16).parse();
        }
        list.add(d16);
        FileManagerUtil.updateBatProcessTips(this.f206935a, str2, str, i3);
        if (this.f206939e == null) {
            this.f206939e = (AIOMessageSpreadManager) this.f206935a.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER);
        }
        if (d16 instanceof MessageForFile) {
            this.f206939e.p((MessageForFile) d16);
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(d16.uniseq) + "], selfuin[" + FileManagerUtil.enCodecString(d16.selfuin) + "], frienduin[" + FileManagerUtil.enCodecString(d16.frienduin) + "], senderuin[" + FileManagerUtil.enCodecString(d16.senderuin) + "], issend[" + String.valueOf(d16.issend) + "], istroop[" + String.valueOf(d16.istroop) + "], shmsgseq[" + String.valueOf(d16.shmsgseq) + "], msgUid[" + String.valueOf(d16.msgUid) + "], time[" + String.valueOf(d16.time) + "], vipBubbleID[" + String.valueOf(j26) + "], bubbleDiyTextId[" + String.valueOf(i18) + "]");
        return d16.uniseq;
    }

    public void v1(FileManagerEntity fileManagerEntity, String str, String str2, String str3, com.tencent.mobileqq.filemanager.app.d dVar) {
        w1(fileManagerEntity, str, str2, str3, false, null, dVar);
    }

    public MessageRecord w(int i3, String str, String str2, long j3, long j16, long j17) {
        int size;
        List<MessageRecord> Q = this.f206935a.getMessageFacade().Q(str, i3);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("------->msgFilter :msgIsTroop:");
            sb5.append(i3);
            sb5.append(",peerUin:");
            sb5.append(str);
            sb5.append(",list size:");
            if (Q == null) {
                size = 0;
            } else {
                size = Q.size();
            }
            sb5.append(size);
            QLog.d("FileTransferHandler<FileAssistant>", 2, sb5.toString());
        }
        if (Q != null && Q.size() > 0) {
            for (MessageRecord messageRecord : Q) {
                long j18 = messageRecord.msgUid;
                if (j18 != 0 && j17 != 0) {
                    if (j18 == j17 && messageRecord.shmsgseq == j16 && messageRecord.senderuin.equals(str2)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
                        }
                        return messageRecord;
                    }
                } else if (Math.abs(messageRecord.time - j3) < 30 && messageRecord.shmsgseq == j16 && messageRecord.senderuin.equals(str2)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
                    }
                    return messageRecord;
                }
            }
            return null;
        }
        return null;
    }

    public void w1(FileManagerEntity fileManagerEntity, String str, String str2, String str3, boolean z16, String str4, com.tencent.mobileqq.filemanager.app.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : selfUin[" + FileManagerUtil.enCodecString(str) + "], toUin[" + FileManagerUtil.enCodecString(str2) + "], filePath[" + str3 + "]");
        }
        cmd0x346$UploadSuccReq cmd0x346_uploadsuccreq = new cmd0x346$UploadSuccReq();
        cmd0x346_uploadsuccreq.uint64_sender_uin.set(Long.parseLong(str));
        cmd0x346_uploadsuccreq.uint64_recver_uin.set(Long.parseLong(str2.replace(Marker.ANY_NON_NULL_MARKER, "")));
        cmd0x346_uploadsuccreq.bytes_uuid.set(ByteStringMicro.copyFrom(str3.getBytes()));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        if (z16) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
            if (str4 != null && str4.length() > 0) {
                cmd0x346_uploadsuccreq.str_fileidcrc.set(str4);
                QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform enabled");
            } else {
                QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform enabled but FileIdCrc is null");
            }
        } else {
            QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform not enabled");
        }
        cmd0x346_reqbody.msg_upload_succ_req.set(cmd0x346_uploadsuccreq);
        cmd0x346_reqbody.uint32_cmd.set(800);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = f206932i;
        f206932i = i3 + 1;
        pBUInt32Field.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        if (fileManagerEntity.tmpSessionType > 0) {
            cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
            cmd0x346_extensionreq.uint64_id.set(3L);
            cmd0x346_extensionreq.uint64_type.set(fileManagerEntity.tmpSessionType);
            byte[] bArr = fileManagerEntity.tmpSessionSig;
            if (bArr != null && bArr.length > 0) {
                cmd0x346_extensionreq.bytes_sig.set(ByteStringMicro.copyFrom(bArr));
            }
            String str5 = fileManagerEntity.tmpSessionToPhone;
            if (str5 != null && str5.length() > 0) {
                cmd0x346_extensionreq.str_dst_phonenum.set(fileManagerEntity.tmpSessionToPhone);
            }
            cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : addtempinfo SessionType[" + fileManagerEntity.tmpSessionType + "], sessionId[" + fileManagerEntity.nSessionId + "]");
            }
        }
        r1("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", cmd0x346_reqbody.toByteArray(), new e(dVar), 30000, 3, 1);
    }

    public void x(long j3, String str, long j16, String str2, String str3, String str4, String str5) {
        cmd0x345$ReqBody.SubCmd0x5ReqBody subCmd0x5ReqBody = new cmd0x345$ReqBody.SubCmd0x5ReqBody();
        subCmd0x5ReqBody.uint32_src_bus_id.set(106);
        subCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
        subCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(str4.getBytes()));
        subCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(str));
        subCmd0x5ReqBody.uint64_file_size.set(j16);
        subCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(str2));
        subCmd0x5ReqBody.str_file_name.set(str3);
        if (str5 != null && str5.length() > 0) {
            subCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(str5.getBytes()));
        }
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x5_req_body.set(subCmd0x5ReqBody);
        cmd0x345_reqbody.uint32_sub_cmd.set(6);
        r1("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), new e(false, j3, (com.tencent.mobileqq.filemanager.app.d) null, 6), 30000, 3, 1);
    }

    public void y(FileManagerEntity fileManagerEntity, int i3) {
        cmd0x345$ReqBody.SubCmd0x6ReqBody subCmd0x6ReqBody = new cmd0x345$ReqBody.SubCmd0x6ReqBody();
        subCmd0x6ReqBody.uint32_dst_bus_id.set(i3);
        subCmd0x6ReqBody.uint64_file_size.set(fileManagerEntity.fileSize);
        subCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(fileManagerEntity.Uuid.getBytes()));
        String str = fileManagerEntity.strFileMd5;
        if (str != null && str.length() > 0) {
            subCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(fileManagerEntity.strFileMd5.getBytes()));
        }
        subCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(fileManagerEntity.selfUin));
        subCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong(fileManagerEntity.peerUin.replace(Marker.ANY_NON_NULL_MARKER, "")));
        subCmd0x6ReqBody.str_file_name.set(fileManagerEntity.fileName);
        subCmd0x6ReqBody.str_src_file_path.set(fileManagerEntity.Uuid);
        subCmd0x6ReqBody.str_src_parent_folder.set("/");
        subCmd0x6ReqBody.uint32_client_type.set(104);
        if (fileManagerEntity.tmpSessionType > 0) {
            subCmd0x6ReqBody.uint64_app_id.set(3L);
            subCmd0x6ReqBody.uint64_talk_type.set(fileManagerEntity.tmpSessionType);
            byte[] bArr = fileManagerEntity.tmpSessionSig;
            if (bArr != null && bArr.length > 0) {
                subCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(bArr));
            }
            String str2 = fileManagerEntity.tmpSessionToPhone;
            if (str2 != null && str2.length() > 0) {
                subCmd0x6ReqBody.str_dst_phone_number.set(fileManagerEntity.tmpSessionToPhone);
            }
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardDiscFile : addtempinfo SessionType[" + fileManagerEntity.tmpSessionType + "], sessionId[" + fileManagerEntity.nSessionId + "]");
            }
        }
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x6_req_body.set(subCmd0x6ReqBody);
        cmd0x345_reqbody.uint32_sub_cmd.set(7);
        r1("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), new e(false, fileManagerEntity.nSessionId, (com.tencent.mobileqq.filemanager.app.d) null, 7), 30000, 3, 1);
    }

    public void z(int i3, FileManagerEntity fileManagerEntity) {
        k(i3, 3, fileManagerEntity);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        private Object f207006a;

        /* renamed from: b, reason: collision with root package name */
        private int f207007b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f207008c;

        /* renamed from: d, reason: collision with root package name */
        private long f207009d;

        /* renamed from: e, reason: collision with root package name */
        private int f207010e;

        /* renamed from: f, reason: collision with root package name */
        private com.tencent.mobileqq.filemanager.app.d f207011f;

        /* renamed from: g, reason: collision with root package name */
        private String f207012g;

        /* renamed from: h, reason: collision with root package name */
        private byte[] f207013h;

        /* renamed from: i, reason: collision with root package name */
        private byte[] f207014i;

        /* renamed from: j, reason: collision with root package name */
        private byte[] f207015j;

        e() {
            j(false, 0L, null, null, 0);
        }

        private void j(boolean z16, long j3, String str, com.tencent.mobileqq.filemanager.app.d dVar, int i3) {
            this.f207007b = 0;
            this.f207008c = z16;
            this.f207009d = j3;
            this.f207010e = i3;
            this.f207012g = str;
            this.f207011f = dVar;
            this.f207006a = null;
        }

        int c() {
            return this.f207007b;
        }

        long d() {
            return this.f207009d;
        }

        String e() {
            return this.f207012g;
        }

        Object f() {
            return this.f207006a;
        }

        com.tencent.mobileqq.filemanager.app.d g() {
            return this.f207011f;
        }

        int h() {
            return this.f207010e;
        }

        void i() {
            this.f207007b++;
        }

        boolean k() {
            return this.f207008c;
        }

        e(String str) {
            j(false, 0L, str, null, 0);
        }

        e(long j3, com.tencent.mobileqq.filemanager.app.d dVar) {
            j(false, j3, null, dVar, 0);
        }

        e(boolean z16, long j3) {
            j(z16, j3, null, null, 0);
        }

        e(com.tencent.mobileqq.filemanager.app.d dVar) {
            j(false, 0L, null, dVar, 0);
        }

        e(boolean z16, long j3, com.tencent.mobileqq.filemanager.app.d dVar, int i3) {
            j(z16, j3, null, dVar, i3);
        }

        e(byte[] bArr, byte[] bArr2, byte[] bArr3, com.tencent.mobileqq.filemanager.app.d dVar) {
            j(false, 0L, null, dVar, 0);
            this.f207013h = bArr;
            this.f207014i = bArr2;
            this.f207015j = bArr3;
        }
    }

    @Deprecated
    public void V(MessageHandler messageHandler, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, im_msg_body$NotOnlineFile im_msg_body_notonlinefile, String str, boolean z16, boolean z17, long j3, int i3, hummer_resv_21$ResvAttr hummer_resv_21_resvattr) {
    }
}
