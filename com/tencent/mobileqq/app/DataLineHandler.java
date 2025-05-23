package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.dataline.nt.DataLineRecentContactUtil;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.LiteTransferOperatorCallback;
import com.tencent.litetransfersdk.LiteTransferType;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.litetransfersdk.Session;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.CleanFileDetail;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.text.Typography;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm$Msg;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import oicq.wlogin_sdk.tools.util;
import rd0.g;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;
import tencent.im.msg.im_msg_head$InstCtrl;
import tencent.im.msg.im_msg_head$InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7$MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DataLineHandler extends BusinessHandler implements LiteTransferOperatorCallback, LiteTransferListenerCallback, g.c {
    static IPatchRedirector $redirector_;

    /* renamed from: j0, reason: collision with root package name */
    private static int f194537j0;

    /* renamed from: k0, reason: collision with root package name */
    private static int f194538k0;
    private k0.b C;
    public PrinterHandler D;
    private k0.a E;
    public boolean F;
    private BroadcastReceiver G;
    private BroadcastReceiver H;
    private INetInfoHandler I;
    private boolean J;
    private boolean K;
    private boolean L;
    private long M;
    private long N;
    private long P;
    private List<Integer> Q;
    protected ProtocolHelper R;
    private DatalineRemoteManager S;
    public l0.c T;
    private boolean U;
    private Set<String> V;
    private int W;
    private boolean X;
    private int Y;
    private rd0.g Z;

    /* renamed from: a0, reason: collision with root package name */
    public QQAppInterface f194539a0;

    /* renamed from: b0, reason: collision with root package name */
    private HashMap<Long, Integer> f194540b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f194541c0;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.service.f> f194542d;

    /* renamed from: d0, reason: collision with root package name */
    private long f194543d0;

    /* renamed from: e, reason: collision with root package name */
    protected HashMap<Long, Object> f194544e;

    /* renamed from: e0, reason: collision with root package name */
    private Timer f194545e0;

    /* renamed from: f, reason: collision with root package name */
    private int f194546f;

    /* renamed from: f0, reason: collision with root package name */
    private bs f194547f0;

    /* renamed from: g0, reason: collision with root package name */
    private HashMap<Long, Session> f194548g0;

    /* renamed from: h, reason: collision with root package name */
    public String f194549h;

    /* renamed from: h0, reason: collision with root package name */
    private int f194550h0;

    /* renamed from: i, reason: collision with root package name */
    public int f194551i;

    /* renamed from: i0, reason: collision with root package name */
    private int f194552i0;

    /* renamed from: m, reason: collision with root package name */
    protected LiteTransferWrapper f194553m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.DataLineHandler$5, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f194570d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FromServiceMsg f194571e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f194572f;
        final /* synthetic */ DataLineHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MsgSCBody msgSCBody = new MsgSCBody();
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            msgSCBody.uMsgType = LiteTransferType.MsgBodyType.MsgType_0x346;
            if (this.f194570d == null || this.f194571e == null) {
                msgSCBody.bTimeOut = true;
            }
            FromServiceMsg fromServiceMsg = this.f194571e;
            if (fromServiceMsg != null) {
                if (fromServiceMsg.getWupBuffer() != null) {
                    int length = this.f194571e.getWupBuffer().length - 4;
                    if (length >= 0) {
                        bArr = new byte[length];
                        PkgTools.copyData(bArr, 0, this.f194571e.getWupBuffer(), 4, length);
                    }
                } else {
                    bArr = null;
                }
                if (bArr != null) {
                    try {
                        cmd0x346_rspbody.mergeFrom(bArr);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            this.this$0.R.FillMsgSCBody(msgSCBody, cmd0x346_rspbody, this.f194572f);
            ToServiceMsg toServiceMsg = this.f194570d;
            if (toServiceMsg == null) {
                this.this$0.f194553m.OnPbMsgReply(0, msgSCBody);
                return;
            }
            j0.b bVar = (j0.b) toServiceMsg.getAttribute("callback");
            if (bVar != null) {
                j0.a aVar = new j0.a();
                aVar.a(msgSCBody);
                bVar.a(aVar);
            } else {
                this.this$0.f194553m.OnPbMsgReply(((Long) this.f194570d.getAttribute("cookie")).intValue(), msgSCBody);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.DataLineHandler$6, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FromServiceMsg f194573d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f194574e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f194575f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f194576h;
        final /* synthetic */ DataLineHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            FromServiceMsg fromServiceMsg = this.f194573d;
            if (fromServiceMsg != null) {
                if (fromServiceMsg.getWupBuffer() != null) {
                    int length = this.f194573d.getWupBuffer().length - 4;
                    if (length >= 0) {
                        bArr = new byte[length];
                        PkgTools.copyData(bArr, 0, this.f194573d.getWupBuffer(), 4, length);
                    }
                } else {
                    bArr = null;
                }
                if (bArr != null) {
                    try {
                        cmd0x346_rspbody.mergeFrom(bArr);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            int i3 = cmd0x346_rspbody.msg_file_query_rsp.int32_ret_code.get();
            DataLineMsgRecord d16 = this.this$0.f194539a0.getMessageFacade().t1(this.f194574e).d(this.f194575f);
            if (i3 == 0) {
                cmd0x346_rspbody.msg_file_query_rsp.msg_file_info.str_file_name.get();
                cmd0x346_rspbody.msg_file_query_rsp.msg_file_info.uint64_file_size.get();
                byte[] byteArray = cmd0x346_rspbody.msg_file_query_rsp.msg_file_info.bytes_10m_md5.get().toByteArray();
                Object attribute = this.f194576h.getAttribute("data");
                if (attribute != null && (attribute instanceof Bundle)) {
                    Bundle bundle = (Bundle) attribute;
                    if (bundle.getBoolean("newAssistant", false)) {
                        this.this$0.f194539a0.getFileTransferHandler().j1(this.f194575f, byteArray, bundle.getString(PreDownloadConstants.RPORT_KEY_FILE_KEY));
                        return;
                    }
                }
                if (d16 == null) {
                    return;
                }
                d16.md5 = byteArray;
                this.this$0.f194539a0.getMessageFacade().t1(this.f194574e).o(d16.msgId, d16.serverPath, d16.md5);
                this.this$0.v4(d16);
                return;
            }
            QLog.e("DatalineHandler<FileAssistant>", 1, "query file md5 return error:" + i3);
            if (d16 != null) {
                this.this$0.B4(d16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.DataLineHandler$7, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f194577d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f194578e;
        final /* synthetic */ DataLineHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.this$0.Z2(this.f194577d, this.f194578e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements com.tencent.mobileqq.weiyun.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f194582a;

        a(long j3) {
            this.f194582a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DataLineHandler.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.weiyun.a
        public void onError(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                com.tencent.mobileqq.filemanager.util.d.i(BaseApplication.getContext().getString(R.string.f170962w13));
                ((DataLineHandler) DataLineHandler.this.f194539a0.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).OnSessionComplete(this.f194582a, 41, i3);
            }
        }

        @Override // com.tencent.mobileqq.weiyun.a
        public void onSuccess(Object obj) {
            FileManagerEntity D;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            String str = (String) obj;
            DataLineHandler dataLineHandler = (DataLineHandler) DataLineHandler.this.f194539a0.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            if (TextUtils.isEmpty(str)) {
                dataLineHandler.OnSessionComplete(this.f194582a, 0, -999);
                return;
            }
            DataLineMsgRecord d16 = DataLineHandler.this.f194539a0.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(this.f194582a)).d(this.f194582a);
            if (d16 == null) {
                return;
            }
            d16.serverPath = str;
            d16.nOpType = 1;
            d16.bIsSended = true;
            d16.bIsTransfering = false;
            if (d16.entityID != 0 && (D = DataLineHandler.this.f194539a0.getFileManagerDataCenter().D(d16.entityID)) != null) {
                D.status = 1;
                D.Uuid = d16.serverPath;
            }
            if (dataLineHandler.k3(d16)) {
                dataLineHandler.v4(d16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataLineHandler.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (action.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTED") || action.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTABLE") || action.equalsIgnoreCase("android.intent.action.MEDIA_EJECT") || action.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED")) {
                DataLineHandler.this.h3(8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f194585a;

        c(QQAppInterface qQAppInterface) {
            this.f194585a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataLineHandler.this, (Object) qQAppInterface);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && (action = intent.getAction()) != null) {
                if (!action.equals(QQAppInterface.QQ_ACTION_LOGOUT) && !action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && !action.equals(NewIntent.ACTION_ACCOUNT_KICKED) && !action.equals(NewIntent.ACTION_FORCE_LOGOUT)) {
                    if (!action.equals("mqq.intent.action.EXIT_" + this.f194585a.getApp().getPackageName()) && !action.equals(NewIntent.ACTION_LOGOUT)) {
                        return;
                    }
                }
                DataLineHandler.this.O3();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataLineHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                DataLineHandler.this.R3();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                DataLineHandler.this.R3();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                DataLineHandler.this.S3();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                DataLineHandler.this.S3();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class e extends bs {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataLineHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onSelfIpadOnlineStatusUpdateNotify(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (i3 == 1 && DataLineHandler.this.z3()) {
                DataLineHandler.this.y4(true);
                DataLineHandler.this.N = com.tencent.mobileqq.service.message.e.K0();
                DataLineRecentContactUtil.f32313a.A(1, DataLineHandler.this.N);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onSelfPcOnlineStatusUpdateNotify(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == 1 && DataLineHandler.this.C3()) {
                DataLineHandler.this.A4(true);
                DataLineHandler.this.M = com.tencent.mobileqq.service.message.e.K0();
                DataLineRecentContactUtil.f32313a.A(0, DataLineHandler.this.M);
            }
            DataLineHandler dataLineHandler = DataLineHandler.this;
            dataLineHandler.D.i(dataLineHandler);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69661);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 106)) {
            redirector.redirect((short) 106);
        } else {
            f194537j0 = 0;
            f194538k0 = 0;
        }
    }

    public DataLineHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194542d = new ArrayList<>();
        this.f194544e = new HashMap<>();
        this.f194546f = 0;
        this.f194549h = AppConstants.DATALINE_PC_UIN;
        this.f194551i = 0;
        this.f194553m = new LiteTransferWrapper(this, this);
        this.C = new k0.b(this);
        this.D = null;
        this.E = null;
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = 0L;
        this.N = 0L;
        this.P = 0L;
        this.Q = new ArrayList();
        this.U = false;
        this.V = new HashSet();
        this.W = 0;
        this.X = false;
        this.Y = 0;
        this.f194540b0 = new HashMap<>();
        this.f194541c0 = -1L;
        this.f194543d0 = -1L;
        this.f194547f0 = new e();
        this.f194548g0 = new HashMap<>();
        this.f194539a0 = qQAppInterface;
        this.D = new PrinterHandler(qQAppInterface);
        this.T = new l0.c(qQAppInterface);
        this.E = new k0.a(qQAppInterface);
        this.f194550h0 = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f158611kg);
        this.f194552i0 = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f158610kf);
        Y3();
        this.G = new b();
        this.H = new c(qQAppInterface);
        this.I = new d();
        this.R = new ProtocolHelper(qQAppInterface, 0);
        IntentFilter intentFilter = new IntentFilter(QQAppInterface.QQ_ACTION_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction("mqq.intent.action.EXIT_" + qQAppInterface.getApp().getPackageName());
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        qQAppInterface.getApp().registerReceiver(this.H, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter2.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
        intentFilter2.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter2.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter2.addDataScheme("file");
        qQAppInterface.getApp().registerReceiver(this.G, intentFilter2);
        d4(qQAppInterface);
        qQAppInterface.addObserver(this.f194547f0);
        this.S = new DatalineRemoteManager(qQAppInterface);
        M3();
        L3();
        rd0.g gVar = (rd0.g) qQAppInterface.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
        this.Z = gVar;
        gVar.n(this);
        this.U = false;
    }

    private int A3(MsgHeader msgHeader) {
        if (msgHeader == null) {
            return 65793;
        }
        int i3 = msgHeader.uint32_src_ter_type;
        if (i3 != 2) {
            if (i3 != 3) {
                return 65793;
            }
            return Friends.TERM_TYPE_MOBILE_IPAD;
        }
        return 67586;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B4(DataLineMsgRecord dataLineMsgRecord) {
        dataLineMsgRecord.fileMsgStatus = 0L;
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid);
        this.f194539a0.getMessageFacade().t1(devTypeBySeId).j(dataLineMsgRecord.msgId);
        this.f194539a0.getMessageFacade().t1(devTypeBySeId).m(dataLineMsgRecord.msgId);
        N3(3, false, new Object[]{0L, Long.valueOf(dataLineMsgRecord.sessionid), dataLineMsgRecord.path});
    }

    public static int C4(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return -2005;
            }
            return -2009;
        }
        return -2000;
    }

    public static int D4(int i3) {
        if (i3 != -2009) {
            if (i3 != -2000) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    private Session E3(FileManagerEntity fileManagerEntity) {
        Session session = new Session();
        long j3 = fileManagerEntity.nSessionId;
        session.uSessionID = j3;
        session.bSend = fileManagerEntity.bSend;
        session.msgHeader = this.R.msgHeader(Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue(), DataLineMsgRecord.getDevTypeBySeId(j3));
        session.dwGroupID = fileManagerEntity.dlGroupId;
        session.dwGroupSize = fileManagerEntity.dlGroupCount;
        session.dwGroupIndex = fileManagerEntity.dlGourpIndex;
        int i3 = fileManagerEntity.nFileType;
        if (i3 == 2) {
            session.emFileType = 2;
        } else if (i3 == 0) {
            session.emFileType = 1;
        } else {
            session.emFileType = 0;
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(fileManagerEntity.peerUin)) {
            session.isFileAssist = true;
        }
        session.strFilePathSrc = com.tencent.mobileqq.filemanager.util.l.d(fileManagerEntity.strFilePath);
        session.strFilePathThumb = fileManagerEntity.strThumbPath;
        session.uFileSizeSrc = fileManagerEntity.fileSize;
        session.vFileMD5Src = HexUtil.hexStr2Bytes(fileManagerEntity.strFileMd5);
        if (QLog.isDevelopLevel() && fileManagerEntity.strFileMd5 != null) {
            QLog.d("DataLineHandler.NFRV", 4, "getSessionFromMsgRecord, uSessionID[" + fileManagerEntity.nSessionId + "], strMR[" + fileManagerEntity.strFileMd5 + "], filesize[" + fileManagerEntity.fileSize);
        }
        session.actionInfo = null;
        return session;
    }

    private void E4(int i3) {
        ThreadManager.getFileThreadHandler().post(new Runnable(i3) { // from class: com.tencent.mobileqq.app.DataLineHandler.18
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f194569d;

            {
                this.f194569d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataLineHandler.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DataLineHandler.this.f194539a0.getPreferences().edit().putInt(DataLineHandler.this.f194539a0.getCurrentAccountUin() + "_DATA_LINE_OLD_MSG_UNREAD_COUNT", this.f194569d).apply();
            }
        });
    }

    private void I3(DataLineMsgRecord dataLineMsgRecord, WeiYunFileInfo weiYunFileInfo) {
        this.f194539a0.getFileManagerEngine().Y().F(weiYunFileInfo, new a(dataLineMsgRecord.sessionid));
    }

    private synchronized boolean K3(String str) {
        return this.V.contains(str);
    }

    private void L3() {
        SharedPreferences preferences = this.f194539a0.getPreferences();
        String str = this.f194539a0.getCurrentAccountUin() + "_IPAD_STATE";
        if (preferences.contains(str)) {
            this.K = true;
            this.N = preferences.getLong(str, 0L);
        } else {
            this.K = false;
        }
    }

    private void M3() {
        SharedPreferences preferences = this.f194539a0.getPreferences();
        String str = this.f194539a0.getCurrentAccountUin() + "_PC_STATE";
        if (preferences.contains(str)) {
            this.J = true;
            this.M = preferences.getLong(str, 0L);
        } else {
            this.J = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Q2(Session session, String str) {
        String str2;
        String str3;
        if (session != null) {
            if (str != null && str.length() != 0) {
                ActionInfo actionInfo = session.actionInfo;
                if (actionInfo != null && (str3 = actionInfo.strServiceName) != null && str3.equals(str)) {
                    return true;
                }
                return false;
            }
            ActionInfo actionInfo2 = session.actionInfo;
            if (actionInfo2 == null || (str2 = actionInfo2.strServiceName) == null || str2.length() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static int R2(String str, boolean z16) {
        int fileType = FileManagerUtil.getFileType(str);
        if (fileType == 0) {
            return 1;
        }
        if (fileType != 1) {
            if (fileType == 2) {
                return 2;
            }
            if (z16) {
                return 1;
            }
            return 0;
        }
        return 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int S2(FileManagerEntity fileManagerEntity) {
        int i3 = 2;
        if (fileManagerEntity == null) {
            QLog.i("DataLineHandler", 2, "\u8f6c\u53d1\u6587\u4ef6, FileManagerEntity\u4e3a\u7a7a");
            return 255;
        }
        if (!TextUtils.isEmpty(fileManagerEntity.getFilePath()) && new File(fileManagerEntity.getFilePath()).exists()) {
            i3 = 0;
        } else {
            int cloudType = fileManagerEntity.getCloudType();
            if (cloudType != 10) {
                switch (cloudType) {
                    case 1:
                        int i16 = fileManagerEntity.peerType;
                        if (i16 != 0) {
                            if (i16 != 1) {
                                if (i16 != 3000) {
                                    if (i16 != 6000) {
                                        if (QLog.isColorLevel()) {
                                            QLog.i("DataLineHandler", 2, "\u8f6c\u53d1\u6587\u4ef6, \u672a\u77e5\u7684\u6587\u4ef6\u6765\u6e90\u9ed8\u8ba4\u4e3aC2C, peerType[" + fileManagerEntity.peerType + "]\uff0c name[" + fileManagerEntity.fileName + "], LocalPath[" + fileManagerEntity.getFilePath() + "], FileSize[" + fileManagerEntity.fileSize + "], fileFrom[1], peerUin[" + fileManagerEntity.peerUin + "], cloudType[" + fileManagerEntity.getCloudType());
                                        }
                                    } else {
                                        i3 = 5;
                                        break;
                                    }
                                } else {
                                    i3 = 3;
                                    break;
                                }
                            }
                        }
                        i3 = 1;
                        break;
                    case 2:
                        i3 = 4;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                        i3 = 255;
                        break;
                    case 4:
                        break;
                    default:
                        if (QLog.isColorLevel()) {
                            QLog.e("dataline", 2, "FileManagerEntity->cloudType \u8f6c ForwardFileInfo->type\uff0c \u672a\u8bc6\u522b\u7684cloudType[" + fileManagerEntity.getCloudType());
                        }
                        i3 = 255;
                        break;
                }
            } else {
                i3 = 6;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DataLineHandler", 4, "\u662f\u5426\u53ef\u4ee5\u8f6c\u53d1\u5230\u6570\u636e\u7ebf, [" + fileManagerEntity.peerType + "]\uff0c name[" + fileManagerEntity.fileName + "], LocalPath[" + fileManagerEntity.getFilePath() + "], FileSize[" + fileManagerEntity.fileSize + "], fileFrom[" + i3 + "], peerType[" + fileManagerEntity.peerType + "], peerUin[" + fileManagerEntity.peerUin + "], cloudType[" + fileManagerEntity.getCloudType());
        }
        return i3;
    }

    public static boolean U2(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3 || i3 == 5) {
            return true;
        }
        return false;
    }

    private void U3(Session session) {
        String str = session.strFilePathSrc;
        if (session.dwGroupID == 0 && session.bSend && session.emFileType == 1 && str != null && new File(str).exists()) {
            URLDrawable.getDrawable(AsyncImageView.a(str, this.f194550h0, this.f194552i0, true), (Drawable) null, (Drawable) null, false).downloadImediatly();
        }
    }

    public static boolean V2(FileManagerEntity fileManagerEntity) {
        return U2(S2(fileManagerEntity));
    }

    private void V3(DataLineMsgRecord dataLineMsgRecord) {
        if (dataLineMsgRecord != null && !dataLineMsgRecord.isSendFromLocal() && DataLineMsgSet.isSingle(dataLineMsgRecord) && dataLineMsgRecord.msgtype == -2000 && dataLineMsgRecord.path != null && new File(dataLineMsgRecord.path).exists()) {
            URLDrawable.getDrawable(AsyncImageView.a(dataLineMsgRecord.path, this.f194550h0, this.f194552i0, true), (Drawable) null, (Drawable) null, false).downloadImediatly();
        }
    }

    private boolean W2(com.tencent.mobileqq.service.f fVar) {
        StringBuffer stringBuffer = new StringBuffer();
        int b16 = fVar.b(stringBuffer);
        int i3 = 0;
        if (b16 == -1) {
            return false;
        }
        int i16 = this.f194551i;
        if (i16 == 0) {
            while (i3 < stringBuffer.length()) {
                if (stringBuffer.charAt(i3) == 20 && i3 < stringBuffer.length() - 1) {
                    int i17 = i3 + 1;
                    int convertToServer = QQSysFaceUtil.convertToServer(stringBuffer.charAt(i17));
                    if (convertToServer >= 0) {
                        stringBuffer.setCharAt(i17, (char) convertToServer);
                        i3 = i17;
                    }
                }
                i3++;
            }
        } else if (i16 == 1 || i16 == 2) {
            while (i3 < stringBuffer.length()) {
                if (stringBuffer.charAt(i3) == 20 && i3 < stringBuffer.length() - 1) {
                    int i18 = i3 + 1;
                    char charAt = stringBuffer.charAt(i18);
                    if (charAt == '\u00fa') {
                        charAt = '\n';
                    }
                    if (charAt >= 0) {
                        String[] strArr = EmotcationConstants.SYS_EMOTICON_SYMBOL;
                        if (charAt < strArr.length) {
                            String str = strArr[charAt];
                            try {
                                stringBuffer.replace(i18, i3 + 2, str);
                            } catch (StringIndexOutOfBoundsException e16) {
                                e16.printStackTrace();
                                QLog.d("DataLineHandler", 2, "SendSubText ipad emoj fail", e16);
                            }
                            i3 += str.length();
                        }
                    }
                }
                i3++;
            }
        }
        fVar.d(l4(fVar.a().longValue(), fVar.e(), 1001, fVar.c(), b16, stringBuffer.toString().getBytes()));
        return true;
    }

    private String W3(String str) {
        String str2;
        String str3;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            str3 = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf);
        } else {
            str2 = "";
            str3 = str;
        }
        VFSFile vFSFile = new VFSFile(str);
        int i3 = 1;
        while (i3 <= 512) {
            if (vFSFile.exists()) {
                str = str3 + "(" + i3 + ")" + str2;
                vFSFile = new VFSFile(str);
                i3++;
            } else {
                while (i3 <= 512) {
                    if (K3(str)) {
                        str = str3 + "(" + i3 + ")" + str2;
                        i3++;
                    } else {
                        return str;
                    }
                }
                return str3 + "(" + System.currentTimeMillis() + ")" + str2;
            }
        }
        return str3 + "(" + System.currentTimeMillis() + ")" + str2;
    }

    private void Y2(int i3, DataLineMsgRecord dataLineMsgRecord, int i16) {
        dataLineMsgRecord.bIsTransfering = false;
        e4(dataLineMsgRecord.path);
        if (dataLineMsgRecord.isSend()) {
            if (i16 == 2) {
                dataLineMsgRecord.fileMsgStatus = 0L;
                dataLineMsgRecord.bIsSended = true;
                if (TextUtils.isEmpty(dataLineMsgRecord.path) || !new File(dataLineMsgRecord.path).exists()) {
                    dataLineMsgRecord.nOpType = 1;
                    dataLineMsgRecord.progress = 0.0f;
                }
                p3(dataLineMsgRecord);
                if (!TextUtils.isEmpty(dataLineMsgRecord.thumbPath)) {
                    this.f194539a0.getMessageFacade().t1(i3).k(dataLineMsgRecord.msgId, dataLineMsgRecord.thumbPath);
                }
                this.f194539a0.getMessageFacade().t1(i3).j(dataLineMsgRecord.msgId);
                this.f194539a0.getMessageFacade().t1(i3).b();
                this.f194539a0.getMessageFacade().t1(i3).n(dataLineMsgRecord.msgId);
                if (dataLineMsgRecord.nSessionState == 2 && com.tencent.mobileqq.filemanager.util.q.p(dataLineMsgRecord.path)) {
                    this.f194539a0.getMessageFacade().t1(i3).i(dataLineMsgRecord.msgId, dataLineMsgRecord.path);
                }
                com.tencent.qqnt.kernel.api.af storageCleanService = ((IKernelService) this.f194539a0.getRuntimeService(IKernelService.class, "")).getStorageCleanService();
                if (storageCleanService != null && !TextUtils.isEmpty(dataLineMsgRecord.path)) {
                    File file = new File(dataLineMsgRecord.path);
                    storageCleanService.addNewDownloadOrUploadFile(new CleanFileDetail(0L, 0L, "", 0, file.lastModified(), dataLineMsgRecord.filename, file.length(), dataLineMsgRecord.path, true));
                }
                ReportController.o(this.f194539a0, "CliOper", "", "", "0X8006223", "0X8006223", 0, 0, "", "", "", "");
            } else if (i16 != 32 && i16 != 11 && i16 != 8) {
                dataLineMsgRecord.fileMsgStatus = 0L;
                this.f194539a0.getMessageFacade().t1(i3).j(dataLineMsgRecord.msgId);
                this.f194539a0.getMessageFacade().t1(i3).m(dataLineMsgRecord.msgId);
                ReportController.o(this.f194539a0, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
            } else {
                dataLineMsgRecord.fileMsgStatus = 2L;
                this.f194539a0.getMessageFacade().t1(i3).j(dataLineMsgRecord.msgId);
                this.f194539a0.getMessageFacade().t1(i3).m(dataLineMsgRecord.msgId);
                ReportController.o(this.f194539a0, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
            }
        } else if (i16 == 2) {
            dataLineMsgRecord.fileMsgStatus = 0L;
            p3(dataLineMsgRecord);
            if (!TextUtils.isEmpty(dataLineMsgRecord.thumbPath)) {
                this.f194539a0.getMessageFacade().t1(i3).k(dataLineMsgRecord.msgId, dataLineMsgRecord.thumbPath);
            }
            QLog.d("DataLineHandler", 1, "mr.path: " + dataLineMsgRecord.path + " ,mr.fileSize: " + dataLineMsgRecord.filesize + " ,mr:" + dataLineMsgRecord);
            String a16 = com.tencent.mobileqq.filemanager.util.l.a(dataLineMsgRecord.path);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("filePath: ");
            sb5.append(a16);
            QLog.d("DataLineHandler", 1, sb5.toString());
            if (a16 != null) {
                String str = dataLineMsgRecord.path;
                if (str != null && str.startsWith(lc1.b.a().getDefaultRecvPath())) {
                    FileUtils.deleteFile(dataLineMsgRecord.path);
                }
                dataLineMsgRecord.path = a16;
                this.f194539a0.getMessageFacade().t1(i3).i(dataLineMsgRecord.msgId, a16);
            }
            this.f194539a0.getMessageFacade().t1(i3).j(dataLineMsgRecord.msgId);
            this.f194539a0.getMessageFacade().t1(i3).n(dataLineMsgRecord.msgId);
            this.f194539a0.getMessageFacade().t1(i3).b();
            com.tencent.qqnt.kernel.api.af storageCleanService2 = ((IKernelService) this.f194539a0.getRuntimeService(IKernelService.class, "")).getStorageCleanService();
            if (storageCleanService2 != null && !TextUtils.isEmpty(dataLineMsgRecord.path)) {
                File file2 = new File(dataLineMsgRecord.path);
                storageCleanService2.addNewDownloadOrUploadFile(new CleanFileDetail(0L, 0L, "", 0, file2.lastModified(), dataLineMsgRecord.filename, file2.length(), dataLineMsgRecord.path, true));
            }
            ReportController.o(this.f194539a0, "CliOper", "", "", "0X8006226", "0X8006226", 0, 0, "", "", "", "");
        } else if (i16 != 32 && i16 != 11 && i16 != 8) {
            if (i16 == 41 && dataLineMsgRecord.fileMsgStatus == 1 && !dataLineMsgRecord.bIsTransfering) {
                QLog.w("DataLineHandler", 1, "uSessionID[" + dataLineMsgRecord.sessionid + "]_onSessionComplete. net fail. but comingfile is no start transfer");
                return;
            }
            dataLineMsgRecord.fileMsgStatus = 0L;
            this.f194539a0.getMessageFacade().t1(i3).j(dataLineMsgRecord.msgId);
            this.f194539a0.getMessageFacade().t1(i3).m(dataLineMsgRecord.msgId);
            ReportController.o(this.f194539a0, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
        } else {
            dataLineMsgRecord.fileMsgStatus = 2L;
            this.f194539a0.getMessageFacade().t1(i3).j(dataLineMsgRecord.msgId);
            this.f194539a0.getMessageFacade().t1(i3).m(dataLineMsgRecord.msgId);
            ReportController.o(this.f194539a0, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
        }
        dataLineMsgRecord.nSessionState = 1;
    }

    private void Y3() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.DataLineHandler.17
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataLineHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = DataLineHandler.this.f194539a0.getPreferences().getInt(DataLineHandler.this.f194539a0.getCurrentAccountUin() + "_DATA_LINE_OLD_MSG_UNREAD_COUNT", 0);
                synchronized (DataLineHandler.this.f194539a0) {
                    DataLineHandler.this.X = true;
                    DataLineHandler.this.Y += i3;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(long j3, int i3) {
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
        DataLineMsgRecord d16 = this.f194539a0.getMessageFacade().t1(devTypeBySeId).d(j3);
        if (d16 == null) {
            return;
        }
        if (d16.isSend() && d16.fileFrom == 0) {
            if (i3 == 2) {
                N3(4, true, new Object[]{0L, Long.valueOf(j3), Float.valueOf(1.0f)});
                N3(2, true, new Object[]{0L, Long.valueOf(j3), d16.path});
                if (j3 > 0) {
                    FileManagerEntity trans2Entity = d16.trans2Entity();
                    if (trans2Entity != null && trans2Entity.fileSize <= QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
                        ((DataLineMessageSpreadManager) this.f194539a0.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).i(d16, devTypeBySeId);
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e("AIOMessageSpreadManager", 1, "can't find File Msg sID:");
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (i3 != 32 && i3 != 11 && i3 != 8) {
                N3(2, false, new Object[]{0L, Long.valueOf(j3), d16.path});
                return;
            } else {
                N3(2, false, new Object[]{0L, Long.valueOf(j3), d16.path});
                return;
            }
        }
        if (i3 == 2) {
            N3(4, true, new Object[]{0L, Long.valueOf(j3), Float.valueOf(1.0f)});
            N3(3, true, new Object[]{0L, Long.valueOf(j3), d16.path});
        } else if (i3 != 32 && i3 != 11 && i3 != 8) {
            N3(3, false, new Object[]{0L, Long.valueOf(j3), d16.path});
        } else {
            N3(3, false, new Object[]{0L, Long.valueOf(j3), d16.path});
        }
    }

    private void Z3(Session session, NFCInfo nFCInfo) {
        FileManagerEntity D = this.f194539a0.getFileManagerDataCenter().D(session.uSessionID);
        if (D == null) {
            D = new FileManagerEntity();
            D.nSessionId = session.uSessionID;
            D.strFilePath = session.strFilePathSrc;
            D.strMiddleThumPath = session.strFilePathThumb;
            D.fileName = session.strFileNameSrc;
            D.strFileMd5 = HexUtil.bytes2HexStr(session.vFileMD5Src);
            D.fileSize = session.uFileSizeSrc;
            D.uniseq = FileManagerUtil.genSessionId().longValue();
            D.msgSeq = FileManagerUtil.genMsgSeq();
            D.peerUin = com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.f194539a0);
            D.peerType = 0;
            D.bDelInFM = true;
            D.bSend = false;
            this.f194539a0.getFileManagerDataCenter().t(D);
        }
        D.dlGourpIndex = session.dwGroupIndex;
        D.dlGroupCount = session.dwGroupSize;
        D.dlGroupId = session.dwGroupID;
        D.nfcServerIP = nFCInfo.dwServerIP;
        D.nfcServerPort = nFCInfo.wServerPort;
        D.nfcTokenKey = (byte[]) nFCInfo.vTokenKey.clone();
        D.nfcUrlNotify = (byte[]) nFCInfo.vUrlNotify.clone();
        D.cloudType = 11;
        D.status = 2;
        D.mContext = Integer.valueOf(A3(session.msgHeader));
        QLog.i("DataLineHandler.NFRV", 1, "recvByNewFileassistant:" + D.nSessionId + ",gip:" + D.nfcServerIP + ",gport:" + ((int) D.nfcServerPort));
        this.f194539a0.getFileManagerDataCenter().f0(D);
        this.f194539a0.getFileManagerEngine().t0(D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3(long j3, long j16, long j17) {
        float f16;
        if (j17 == 0) {
            f16 = 0.0f;
        } else {
            f16 = ((float) j16) / ((float) j17);
        }
        DataLineMsgRecord d16 = this.f194539a0.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(j3)).d(j3);
        if (d16 != null) {
            d16.progress = f16;
        }
        N3(4, true, new Object[]{0L, Long.valueOf(j3), Float.valueOf(f16)});
    }

    private void a4() {
        boolean z16;
        if (this.F) {
            z16 = false;
        } else {
            z16 = true;
        }
        w3().handleReceivedMessage(1, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3(int i3, long j3, String str) {
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
        DataLineMsgRecord d16 = this.f194539a0.getMessageFacade().t1(devTypeBySeId).d(j3);
        if (d16 == null) {
            return;
        }
        if (i3 == 0) {
            d16.thumbPath = str;
            if (!d16.isSend()) {
                if (QLog.isColorLevel()) {
                    QLog.d("DataLineHandler", 2, "uSessionID[" + j3 + "]OnSessionThumbUpdate: update");
                }
                N3(10, true, new Object[]{Long.valueOf(j3)});
                return;
            }
            return;
        }
        if (i3 == 1) {
            d16.serverPath = str;
            this.f194539a0.getMessageFacade().t1(devTypeBySeId).o(d16.msgId, d16.serverPath, d16.md5);
            return;
        }
        if (i3 == 2) {
            d16.md5 = HexUtil.hexStr2Bytes(str);
            if (QLog.isDevelopLevel() && d16.md5 != null) {
                QLog.d("DataLineHandler", 4, "SessionUpdateType_FileMD5, uSessionID[" + j3 + "], strValuebuf[" + str + "], strMD5MR[" + HexUtil.bytes2HexStr(d16.md5) + "], strMD5Notify" + str);
            }
            this.f194539a0.getMessageFacade().t1(devTypeBySeId).o(d16.msgId, d16.serverPath, d16.md5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c3(Session session, NFCInfo nFCInfo, FTNInfo fTNInfo, boolean z16) {
        if (session == null) {
            return;
        }
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(session.uSessionID);
        DataLineMsgRecord d16 = this.f194539a0.getMessageFacade().t1(devTypeBySeId).d(session.uSessionID);
        if (d16 == null) {
            d16 = new DataLineMsgRecord();
            d16.f203106msg = "";
            d16.msgtype = C4(session.emFileType);
            d16.sessionid = session.uSessionID;
            boolean z17 = session.bSend;
            d16.issend = z17 ? 1 : 0;
            d16.isread = z17;
            d16.nOpType = !z17 ? 1 : 0;
            d16.path = session.strFilePathSrc;
            d16.fileFrom = session.emFileFrom;
            byte[] bArr = session.vOfflineFileUUID;
            if (bArr != null) {
                d16.fileUuid = new String(bArr);
            }
            d16.uOwnerUin = session.uOwnerUin;
            d16.thumbPath = session.strFilePathThumb;
            d16.md5 = session.vFileMD5Src;
            if (nFCInfo != null) {
                d16.nServerIp = nFCInfo.dwServerIP;
                d16.nServerPort = nFCInfo.wServerPort;
                d16.vUrlNotify = nFCInfo.vUrlNotify;
                d16.vTokenKey = nFCInfo.vTokenKey;
            }
            if (fTNInfo != null) {
                d16.serverPath = fTNInfo.strFileIndex;
            }
            if (d16.path == null) {
                return;
            }
            String str = session.strFileNameSrc;
            if (str != null && str.length() > 0) {
                d16.filename = session.strFileNameSrc;
            } else {
                try {
                    d16.filename = new File(d16.path).getName();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            d16.filesize = session.uFileSizeSrc;
            d16.issuc = false;
            d16.vipBubbleID = T2();
            d16.time = session.uMsgTime;
            d16.groupId = session.dwGroupID;
            d16.groupSize = session.dwGroupSize;
            d16.groupIndex = session.dwGroupIndex;
            d16.progress = 0.0f;
            if (z16) {
                d16.fileMsgStatus = 0L;
            } else {
                d16.fileMsgStatus = 2L;
                if (!session.bSend) {
                    d16.fileMsgStatus = 1L;
                }
            }
            this.f194539a0.getMessageFacade().t1(devTypeBySeId).a(d16, !session.bSend);
        } else {
            if (z16) {
                d16.fileMsgStatus = 0L;
            } else {
                d16.fileMsgStatus = 2L;
            }
            this.f194539a0.getMessageFacade().t1(devTypeBySeId).j(d16.msgId);
            this.f194539a0.getMessageFacade().t1(devTypeBySeId).m(d16.msgId);
        }
        d16.issuc = true;
        d16.bIsTransfering = z16;
        if (z16 && d16.nSessionState != 1 && (!d16.isSend() || !FileManagerUtil.fileExist(d16.path))) {
            f3(d16.path);
        }
        if (session.bSend) {
            N3(7, true, new Object[]{0L, Long.valueOf(session.uSessionID), session.strFilePathSrc, Byte.valueOf((byte) session.emFileType), Boolean.FALSE, Boolean.valueOf(z16), Long.valueOf(d16.filesize)});
            return;
        }
        if (!z16) {
            DataLineMsgRecord t16 = this.f194539a0.getDataLineMsgProxy(devTypeBySeId).t(session.uSessionID);
            if (t16 != null && DataLineMsgSet.isSingle(t16)) {
                a4();
            } else {
                DataLineMsgSet u16 = this.f194539a0.getDataLineMsgProxy(devTypeBySeId).u(session.dwGroupID);
                if (u16 == null || u16.getComeCount() == 1) {
                    a4();
                }
            }
        }
        N3(6, true, new Object[]{0L, Long.valueOf(session.uSessionID), session.strFilePathSrc, Byte.valueOf((byte) session.emFileType), Boolean.FALSE, Boolean.valueOf(z16), Long.valueOf(d16.filesize)});
    }

    public static void d3(SubMsgType0x7$MsgBody subMsgType0x7$MsgBody, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        int i3;
        boolean z16;
        if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
            QLog.i("DataLineHandler", 1, "isNot new FileAssistant");
            return;
        }
        if (subMsgType0x7$MsgBody.uint32_sub_cmd.has()) {
            i3 = subMsgType0x7$MsgBody.uint32_sub_cmd.get();
        } else {
            i3 = -1;
        }
        if (i3 == 1 || ((i3 == 4 && subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.get().uint32_type.has() && subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.get().uint32_type.get() == 1) || i3 == 9)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            msg_svc_pbsendmsgreq.routing_head.trans_0x211.dataline_flag.set(1);
        }
    }

    private synchronized void e4(String str) {
        if (!TextUtils.isEmpty(str) && this.V.contains(str)) {
            this.V.remove(str);
            QLog.i("DataLineHandler", 1, "remRecvingFilePath[" + str + " size:" + this.V.size());
        }
    }

    private synchronized void f3(String str) {
        if (!TextUtils.isEmpty(str) && !this.V.contains(str)) {
            this.V.add(str);
            QLog.i("DataLineHandler", 1, "addRecvingFilePath[" + str + " size:" + this.V.size());
        }
    }

    private String g3(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf);
            str = substring;
        }
        str.replace('\\', util.base64_pad_url);
        str.replace('/', util.base64_pad_url);
        str.replace(':', util.base64_pad_url);
        str.replace('*', util.base64_pad_url);
        str.replace('?', util.base64_pad_url);
        str.replace('\"', util.base64_pad_url);
        str.replace(Typography.less, util.base64_pad_url);
        str.replace(Typography.greater, util.base64_pad_url);
        str.replace(QbAddrData.DATA_SPLITER, util.base64_pad_url);
        if (str.length() > 53) {
            str = str.substring(0, 53);
        }
        if (!TextUtils.isEmpty(str2)) {
            return str + "." + str2;
        }
        return str;
    }

    private void g4(String str, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
                    try {
                        bufferedWriter2.write(str);
                        bufferedWriter2.close();
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        bufferedWriter = bufferedWriter2;
                        QLog.e("DataLineHandler", 1, "create file failed!");
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (IOException e17) {
                        e = e17;
                        bufferedWriter = bufferedWriter2;
                        QLog.e("DataLineHandler", 1, "write file failed!");
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e19) {
                    e = e19;
                } catch (IOException e26) {
                    e = e26;
                }
            } catch (IOException e27) {
                e27.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private msg_svc$PbSendMsgReq k4(String str, int i3, byte[] bArr, long j3, int i16) {
        int i17;
        int i18;
        int i19;
        long genMsgUid = FileManagerUtil.genMsgUid();
        long genMsgSeq = FileManagerUtil.genMsgSeq();
        com.tencent.mobileqq.service.message.ac acVar = new com.tencent.mobileqq.service.message.ac();
        acVar.f286177a = i3;
        acVar.f286178b = bArr;
        msg_svc$PbSendMsgReq o36 = o3(13, str, acVar, genMsgSeq, com.tencent.mobileqq.service.message.s.g(genMsgUid), j3);
        im_msg_head$InstInfo im_msg_head_instinfo = new im_msg_head$InstInfo();
        if (i16 == 1) {
            i17 = 1;
            i18 = 1;
        } else {
            i17 = 0;
            i18 = 1001;
        }
        im_msg_head_instinfo.uint32_apppid.set(i18);
        im_msg_head_instinfo.uint32_instid.set(i17);
        im_msg_head_instinfo.enum_device_type.set(i16);
        im_msg_head_instinfo.setHasFlag(true);
        o36.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(im_msg_head_instinfo);
        im_msg_head$InstInfo im_msg_head_instinfo2 = new im_msg_head$InstInfo();
        im_msg_head_instinfo2.uint32_apppid.set(1001);
        im_msg_head_instinfo2.uint32_instid.set(AppSetting.f());
        PBEnumField pBEnumField = im_msg_head_instinfo2.enum_device_type;
        if (AppSetting.p(BaseApplication.getContext())) {
            i19 = 3;
        } else {
            i19 = 2;
        }
        pBEnumField.set(i19);
        im_msg_head_instinfo2.setHasFlag(true);
        im_msg_head$InstCtrl im_msg_head_instctrl = o36.routing_head.trans_0x211.inst_ctrl;
        im_msg_head_instctrl.msg_from_inst = im_msg_head_instinfo2;
        im_msg_head_instctrl.setHasFlag(true);
        return o36;
    }

    private void l3(DataLineMsgRecord dataLineMsgRecord) {
        if (dataLineMsgRecord != null && TextUtils.isEmpty(dataLineMsgRecord.path)) {
            String g36 = g3(dataLineMsgRecord.filename);
            if (TextUtils.isEmpty(g36)) {
                g36 = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(System.currentTimeMillis()));
            }
            String str = lc1.b.a().getDefaultRecvPath() + g36;
            if (FileUtils.fileExists(str)) {
                str = W3(str);
            }
            dataLineMsgRecord.path = str;
        }
    }

    private ToServiceMsg n3(boolean z16, int i3, long j3, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_MSG_PBSENDMSG);
        createToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
        createToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
        createToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
        createToServiceMsg.extraData.putInt("DATALINE_CMD", i3);
        createToServiceMsg.addAttribute("cookie", Long.valueOf(j3));
        createToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(z16));
        createToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
        createToServiceMsg.putWupBuffer(msg_svc_pbsendmsgreq.toByteArray());
        sendPbReq(createToServiceMsg);
        return createToServiceMsg;
    }

    private msg_svc$PbSendMsgReq o3(int i3, String str, com.tencent.mobileqq.service.message.ac acVar, long j3, int i16, long j16) {
        return com.tencent.mobileqq.service.message.p.a(this.f194539a0, i3, str, acVar, j3, i16);
    }

    private void p3(DataLineMsgRecord dataLineMsgRecord) {
        String str = dataLineMsgRecord.path;
        if (FileManagerUtil.getFileType(str) != 0 || FileUtils.fileExistsAndNotEmpty(dataLineMsgRecord.thumbPath)) {
            return;
        }
        String createMediaThumbnail = FileManagerUtil.createMediaThumbnail(str, MsgConstant.KRMFILETHUMBSIZE384, MsgConstant.KRMFILETHUMBSIZE384, null);
        if (!TextUtils.isEmpty(createMediaThumbnail)) {
            dataLineMsgRecord.thumbPath = createMediaThumbnail;
        }
    }

    private void r3(ToServiceMsg toServiceMsg) {
        NewIntent newIntent = new NewIntent(this.f194539a0.getApplication(), l.class);
        newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
        this.f194539a0.startServlet(newIntent);
        toServiceMsg.extraData.putLong("datalineSendTimekey", System.currentTimeMillis());
    }

    private void t4(ArrayList<Session> arrayList, boolean z16) {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.R.showNoNetworkDialog();
            return;
        }
        if (arrayList.size() == 0) {
            return;
        }
        LiteTransferWrapper liteTransferWrapper = this.f194553m;
        boolean z17 = true;
        if (arrayList.size() == 1) {
            z17 = false;
        }
        liteTransferWrapper.SendGroup(arrayList, z16, z17);
    }

    public void A4(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        this.J = z16;
        if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.f194539a0)) {
            SharedPreferences preferences = this.f194539a0.getPreferences();
            String str = this.f194539a0.getCurrentAccountUin() + "_PC_STATE";
            if (this.J) {
                preferences.edit().putLong(str, this.M).commit();
            } else {
                preferences.edit().remove(str).commit();
            }
        }
    }

    public int B3() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return ((Integer) iPatchRedirector.redirect((short) 101, (Object) this)).intValue();
        }
        synchronized (this.f194539a0) {
            i3 = this.Y;
        }
        return i3;
    }

    public boolean C3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.f194539a0.getPreferences().getBoolean("dl_pc_online_notify", true);
    }

    public DatalineRemoteManager D3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DatalineRemoteManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.S;
    }

    public Session F3(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Session) iPatchRedirector.redirect((short) 28, (Object) this, j3);
        }
        DataLineMsgRecord d16 = w3().getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(j3)).d(j3);
        if (d16 == null) {
            return null;
        }
        Session session = new Session();
        long j16 = d16.sessionid;
        session.uSessionID = j16;
        boolean z16 = true;
        if (d16.issend != 1) {
            z16 = false;
        }
        session.bSend = z16;
        session.msgHeader = this.R.msgHeader(Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue(), DataLineMsgRecord.getDevTypeBySeId(j16));
        session.dwGroupID = d16.groupId;
        session.dwGroupSize = d16.groupSize;
        session.dwGroupIndex = d16.groupIndex;
        session.emFileType = D4(d16.msgtype);
        session.strFilePathSrc = com.tencent.mobileqq.filemanager.util.l.d(d16.path);
        session.strFilePathThumb = d16.thumbPath;
        session.uFileSizeSrc = d16.filesize;
        session.vFileMD5Src = d16.md5;
        if (QLog.isDevelopLevel() && d16.md5 != null) {
            QLog.d("DataLineHandler", 4, "getSessionFromMsgRecord, uSessionID[" + d16.sessionid + "], strMR[" + HexUtil.bytes2HexStr(d16.md5) + "], filesize[" + d16.filesize);
        }
        session.actionInfo = null;
        return session;
    }

    public void G3(msg_comm$Msg msg_comm_msg, C2CType0x211_SubC2CType0x9$MsgBody c2CType0x211_SubC2CType0x9$MsgBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) msg_comm_msg, (Object) c2CType0x211_SubC2CType0x9$MsgBody);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new MqqHandler(mainLooper).post(new Runnable(this, msg_comm_msg, c2CType0x211_SubC2CType0x9$MsgBody) { // from class: com.tencent.mobileqq.app.DataLineHandler.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ DataLineHandler f194579d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ msg_comm$Msg f194580e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ C2CType0x211_SubC2CType0x9$MsgBody f194581f;

                {
                    this.f194579d = this;
                    this.f194580e = msg_comm_msg;
                    this.f194581f = c2CType0x211_SubC2CType0x9$MsgBody;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DataLineHandler.this, this, msg_comm_msg, c2CType0x211_SubC2CType0x9$MsgBody);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        DataLineHandler.this.D.g(this.f194579d, this.f194580e, this.f194581f);
                    }
                }
            });
        } else {
            this.D.g(this, msg_comm_msg, c2CType0x211_SubC2CType0x9$MsgBody);
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public void GetThumbFilePath(int i3, Session session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, i3, (Object) session);
            return;
        }
        QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath ");
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        if (registerProxySvcPackHandler != null && registerProxySvcPackHandler.P2() == 0) {
            QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath pc not line ");
            return;
        }
        if (session.uFileSizeSrc < 51200) {
            QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 333 MinSize_for_CreateThumb e ");
            return;
        }
        String e16 = n0.a.e(BaseApplication.getContext(), session.strFilePathSrc);
        if (e16 == null) {
            QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 444 MinSize_for_CreateThumb e ");
            return;
        }
        File file = new File(e16);
        if (!file.exists()) {
            QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 555 MinSize_for_CreateThumb e ");
        } else if (file.length() + 51200 < session.uFileSizeSrc) {
            QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 666 MinSize_for_CreateThumb e ");
            this.f194553m.OnGetThumbFilePathReply(i3, e16);
        } else {
            QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 777 MinSize_for_CreateThumb e ");
            file.delete();
        }
    }

    public boolean H3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        return this.C.e(str);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public void HandleSession(int i3, long j3, int i16, MsgHeader msgHeader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), msgHeader);
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public void InvokeReport(ReportItem reportItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, (Object) reportItem);
        } else {
            com.dataline.util.k.b(this.f194539a0, reportItem, com.dataline.util.k.f32463b);
        }
    }

    public boolean J3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        return this.C.f(str);
    }

    public void N3(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        Timer timer = this.f194545e0;
        if (timer != null) {
            timer.cancel();
            this.f194545e0 = null;
        }
        if ((i3 == 3 || i3 == 2 || i3 == 1 || i3 == 8) && !this.U) {
            try {
                BaseTimer baseTimer = new BaseTimer();
                this.f194545e0 = baseTimer;
                baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.app.DataLineHandler.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DataLineHandler.this);
                        }
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            DataLineHandler.this.m4();
                        }
                    }
                }, 20000L);
            } catch (IllegalStateException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            } catch (OutOfMemoryError e18) {
                e18.printStackTrace();
            }
        }
        notifyUI(i3, z16, obj);
    }

    protected void O3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "--->>logout cancel all task");
        }
        rd0.g gVar = this.Z;
        if (gVar != null) {
            gVar.p(this);
        }
        h3(32);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnGroupComplete(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "uGroupID[" + i3 + "]OnGroupComplete \u5206\u7ec4\u7ed3\u675f emGroupStatus[" + i16 + "]");
        }
        if (i3 == 0) {
            return;
        }
        DataLineMsgSet u16 = this.f194539a0.getDataLineMsgProxy(0).u(i3);
        if (u16 == null) {
            u16 = this.f194539a0.getDataLineMsgProxy(1).u(i3);
        }
        if (u16 == null) {
            return;
        }
        u16.setTimeOut();
        N3(11, true, null);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnGroupStart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "uGroupID[" + i3 + "]OnGroupStart \u5206\u7ec4\u5f00\u59cb");
        }
        N3(11, true, null);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public boolean OnQueryAutoDownload(long j3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return ((Boolean) iPatchRedirector.redirect((short) 79, this, Long.valueOf(j3), Byte.valueOf(b16))).booleanValue();
        }
        if (b16 != 2) {
            return true;
        }
        boolean isWifiConnected = NetworkUtil.isWifiConnected(BaseApplication.getContext());
        boolean j16 = com.tencent.mobileqq.filemanager.fileassistant.util.h.j(this.f194539a0, j3);
        if (!isWifiConnected && (!j16 || !getAutoDownload())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionComplete(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Session session = this.f194548g0.get(Long.valueOf(j3));
        if (i3 == 2 && session != null) {
            this.f194548g0.remove(Long.valueOf(j3));
        }
        if (this.f194540b0.containsKey(Long.valueOf(j3))) {
            this.f194540b0.remove(Long.valueOf(j3));
        }
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
        if (session == null) {
            Looper mainLooper = Looper.getMainLooper();
            DataLineMsgRecord d16 = this.f194539a0.getMessageFacade().t1(devTypeBySeId).d(j3);
            if (d16 == null) {
                if (Thread.currentThread() != mainLooper.getThread()) {
                    new Handler(mainLooper).post(new Runnable(j3, i3, i16) { // from class: com.tencent.mobileqq.app.DataLineHandler.13
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ long f194561d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f194562e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ int f194563f;

                        {
                            this.f194561d = j3;
                            this.f194562e = i3;
                            this.f194563f = i16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, DataLineHandler.this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                DataLineHandler.this.OnSessionComplete(this.f194561d, this.f194562e, this.f194563f);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if (i3 == 2) {
                V3(d16);
            }
            Y2(devTypeBySeId, d16, i3);
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable(j3, i3) { // from class: com.tencent.mobileqq.app.DataLineHandler.14
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f194564d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f194565e;

                    {
                        this.f194564d = j3;
                        this.f194565e = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, DataLineHandler.this, Long.valueOf(j3), Integer.valueOf(i3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            DataLineHandler.this.Z2(this.f194564d, this.f194565e);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return;
            } else {
                Z2(j3, i3);
                return;
            }
        }
        if (i3 != 2) {
            z16 = false;
        }
        N3(16, z16, session);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionConnected(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            N3(20, true, new Object[]{Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16)});
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionNew(Session session, NFCInfo nFCInfo, FTNInfo fTNInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, this, session, nFCInfo, fTNInfo);
            return;
        }
        if (session.isFileAssist) {
            if (session.bSend) {
                return;
            }
            Z3(session, nFCInfo);
            this.f194548g0.put(Long.valueOf(session.uSessionID), session);
            N3(17, true, session);
            return;
        }
        if (session.bSend) {
            ReportController.o(this.f194539a0, "CliOper", "", "", "0X8006222", "0X8006222", 0, 0, "", "", "", "");
        } else {
            ReportController.o(this.f194539a0, "CliOper", "", "", "0X8006225", "0X8006225", 0, 0, "", "", "", "");
        }
        ActionInfo actionInfo = session.actionInfo;
        if (actionInfo != null && (str = actionInfo.strServiceName) != null && str.length() != 0) {
            this.f194548g0.put(Long.valueOf(session.uSessionID), session);
            N3(17, true, session);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "uSessionID[" + session.uSessionID + "]OnSessionNew Session\u521b\u5efa");
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(session, nFCInfo, fTNInfo) { // from class: com.tencent.mobileqq.app.DataLineHandler.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Session f194554d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ NFCInfo f194555e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ FTNInfo f194556f;

                {
                    this.f194554d = session;
                    this.f194555e = nFCInfo;
                    this.f194556f = fTNInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DataLineHandler.this, session, nFCInfo, fTNInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DataLineHandler.this.c3(this.f194554d, this.f194555e, this.f194556f, false);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            c3(session, nFCInfo, fTNInfo, false);
        }
        U3(session);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionProgress(long j3, long j16, long j17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3));
            return;
        }
        Session session = this.f194548g0.get(Long.valueOf(j3));
        if (session == null) {
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable(j3, j16, j17) { // from class: com.tencent.mobileqq.app.DataLineHandler.12
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f194558d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ long f194559e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ long f194560f;

                    {
                        this.f194558d = j3;
                        this.f194559e = j16;
                        this.f194560f = j17;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, DataLineHandler.this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            DataLineHandler.this.a3(this.f194558d, this.f194559e, this.f194560f);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return;
            } else {
                a3(j3, j16, j17);
                return;
            }
        }
        N3(15, true, new Object[]{session, Float.valueOf((float) ((((float) j16) * 1.0d) / ((float) j17)))});
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionStart(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, j3);
            return;
        }
        Session session = this.f194548g0.get(Long.valueOf(j3));
        if (session == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DataLineHandler", 2, "uSessionID[" + j3 + "], OnSessionStart, Session\u5f00\u59cb");
            }
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable(j3) { // from class: com.tencent.mobileqq.app.DataLineHandler.11
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f194557d;

                    {
                        this.f194557d = j3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, DataLineHandler.this, Long.valueOf(j3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            DataLineHandler.this.c3(DataLineHandler.this.F3(this.f194557d), null, null, true);
                        }
                    }
                });
                return;
            } else {
                c3(F3(j3), null, null, true);
                return;
            }
        }
        N3(14, true, session);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionStartRun(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, j3);
        } else {
            N3(21, true, new Object[]{Long.valueOf(j3)});
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionUpdate(int i3, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, this, Integer.valueOf(i3), Long.valueOf(j3), str);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(i3, j3, str) { // from class: com.tencent.mobileqq.app.DataLineHandler.15
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f194566d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f194567e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f194568f;

                {
                    this.f194566d = i3;
                    this.f194567e = j3;
                    this.f194568f = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DataLineHandler.this, Integer.valueOf(i3), Long.valueOf(j3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DataLineHandler.this.b3(this.f194566d, this.f194567e, this.f194568f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            b3(i3, j3, str);
        }
    }

    public void P2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
            return;
        }
        if (i3 == 0) {
            return;
        }
        synchronized (this.Q) {
            if (!this.Q.contains(Integer.valueOf(i3))) {
                this.Q.add(Integer.valueOf(i3));
                if (this.Q.size() > 256) {
                    this.Q.remove(0);
                }
            }
        }
    }

    public void P3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, i3);
            return;
        }
        if (i3 == 1 && z3()) {
            y4(true);
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            this.N = K0;
            DataLineRecentContactUtil.f32313a.A(1, K0);
        }
    }

    public void Q3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, i3);
            return;
        }
        if (i3 == 1 && C3()) {
            A4(true);
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            this.M = K0;
            DataLineRecentContactUtil.f32313a.A(0, K0);
        }
    }

    protected void R3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    protected void S3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "--->>wifi lost cancel all task");
        }
        h3(41);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public void SendPbMsg(int i3, MsgCSBody msgCSBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, i3, (Object) msgCSBody);
        }
    }

    public int T2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Integer) iPatchRedirector.redirect((short) 74, (Object) this)).intValue();
        }
        return ((ISVIPHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getSelfBubbleId();
    }

    public int T3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).intValue();
        }
        if (str == null) {
            return 1;
        }
        return this.C.g(str);
    }

    public Long X2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Long) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3);
        }
        if (str.length() == 0) {
            return 0L;
        }
        Long u36 = u3(0, i3);
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.msgId = u36.longValue();
        dataLineMsgRecord.sessionid = u36.longValue();
        dataLineMsgRecord.f203106msg = str;
        dataLineMsgRecord.msgtype = -1000;
        dataLineMsgRecord.issend = 1;
        dataLineMsgRecord.isread = true;
        dataLineMsgRecord.issuc = false;
        ((ISVIPHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(dataLineMsgRecord);
        dataLineMsgRecord.time = com.tencent.mobileqq.service.message.e.K0();
        dataLineMsgRecord.sessionid = u36.longValue();
        dataLineMsgRecord.progress = 0.0f;
        this.f194539a0.getMessageFacade().t1(i3).a(dataLineMsgRecord, false);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return 0L;
        }
        dataLineMsgRecord.issuc = true;
        com.tencent.mobileqq.service.f fVar = new com.tencent.mobileqq.service.f(str, u36, dataLineMsgRecord);
        fVar.f(i3);
        if (!W2(fVar)) {
            return 0L;
        }
        this.f194542d.add(fVar);
        return u36;
    }

    public void X3(DataLineMsgRecord dataLineMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) dataLineMsgRecord);
            return;
        }
        if (dataLineMsgRecord == null) {
            QLog.e("DatalineHandler", 1, "reSendWeiYunFile entity=null");
            return;
        }
        if (!TextUtils.isEmpty(dataLineMsgRecord.strWeiyunId) && !TextUtils.isEmpty(dataLineMsgRecord.filename)) {
            WeiYunFileInfo weiYunFileInfo = new WeiYunFileInfo();
            weiYunFileInfo.f209605f = dataLineMsgRecord.filename;
            weiYunFileInfo.f209606h = dataLineMsgRecord.filesize;
            weiYunFileInfo.f209604e = dataLineMsgRecord.strWeiyunDir;
            weiYunFileInfo.f209603d = dataLineMsgRecord.strWeiyunId;
            weiYunFileInfo.f209608m = dataLineMsgRecord.nWeiyunSrcType;
            weiYunFileInfo.I = dataLineMsgRecord.strWeiyunMd5;
            weiYunFileInfo.J = dataLineMsgRecord.strWeiyunSha;
            dataLineMsgRecord.bNoInsertFm = true;
            I3(dataLineMsgRecord, weiYunFileInfo);
            return;
        }
        QLog.e("DatalineHandler", 1, "reSendWeiYunFile keyinfo=null");
    }

    public void b4(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, (Object) this, (Object) fileManagerEntity);
            return;
        }
        Session E3 = E3(fileManagerEntity);
        ArrayList arrayList = new ArrayList();
        arrayList.add(E3);
        ArrayList arrayList2 = new ArrayList();
        NFCInfo nFCInfo = new NFCInfo();
        nFCInfo.dwServerIP = fileManagerEntity.nfcServerIP;
        nFCInfo.wServerPort = fileManagerEntity.nfcServerPort;
        nFCInfo.vTokenKey = fileManagerEntity.nfcTokenKey;
        nFCInfo.vUrlNotify = fileManagerEntity.nfcUrlNotify;
        arrayList2.add(nFCInfo);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new FTNInfo());
        this.f194553m.RecvGroup((Session[]) arrayList.toArray(new Session[arrayList.size()]), (NFCInfo[]) arrayList2.toArray(new NFCInfo[arrayList2.size()]), (FTNInfo[]) arrayList3.toArray(new FTNInfo[arrayList3.size()]), false);
    }

    public boolean c4(List<Long> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) list)).booleanValue();
        }
        QLog.i("DataLineHandler", 1, "manually receives a file . sessionlist");
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        boolean z17 = false;
        for (Long l3 : list) {
            int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(l3.longValue());
            DataLineMsgRecord d16 = w3().getMessageFacade().t1(devTypeBySeId).d(l3.longValue());
            if (d16 != null) {
                d16.fileMsgStatus = 0L;
                this.f194539a0.getMessageFacade().t1(devTypeBySeId).j(d16.msgId);
            }
            if (d16 != null && (str = d16.strMoloKey) != null) {
                this.C.j(str);
                z17 = true;
            } else {
                arrayList.add(l3);
            }
        }
        ArrayList<DataLineMsgRecord> arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            ArrayList arrayList3 = null;
            ArrayList arrayList4 = null;
            ArrayList arrayList5 = null;
            for (Long l16 : list) {
                DataLineMsgRecord d17 = this.f194539a0.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(l16.longValue())).d(l16.longValue());
                if (d17 == null) {
                    QLog.e("DataLineHandler", 1, "uSessionID[" + l16 + "], prepareMsg: session not found");
                    return z16;
                }
                arrayList2.add(d17);
                if (d17.filename != null) {
                    boolean z18 = z17;
                    if (d17.filesize != 0 && (d17.md5 != null || !TextUtils.isEmpty(d17.serverPath))) {
                        l3(d17);
                        Session F3 = F3(d17.sessionid);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(F3);
                        FTNInfo fTNInfo = new FTNInfo();
                        fTNInfo.strFileIndex = d17.serverPath;
                        if (arrayList5 == null) {
                            arrayList5 = new ArrayList();
                        }
                        arrayList5.add(fTNInfo);
                        NFCInfo nFCInfo = new NFCInfo();
                        nFCInfo.dwServerIP = (int) d17.nServerIp;
                        nFCInfo.wServerPort = (short) d17.nServerPort;
                        nFCInfo.vTokenKey = d17.vTokenKey;
                        nFCInfo.vUrlNotify = d17.vUrlNotify;
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(nFCInfo);
                        z17 = z18;
                        z16 = false;
                    }
                }
                QLog.e("DataLineHandler", 1, "uSessionID[" + l16 + "], receive param err.filename:" + d17.filename + " filesize;" + d17.filesize);
                return false;
            }
            boolean z19 = z16;
            boolean z26 = z17;
            if (arrayList3 != null) {
                LiteTransferWrapper liteTransferWrapper = this.f194553m;
                Session[] sessionArr = (Session[]) arrayList3.toArray(new Session[arrayList3.size()]);
                NFCInfo[] nFCInfoArr = (NFCInfo[]) arrayList4.toArray(new NFCInfo[arrayList4.size()]);
                FTNInfo[] fTNInfoArr = (FTNInfo[]) arrayList5.toArray(new FTNInfo[arrayList5.size()]);
                if (arrayList.size() != 1) {
                    z19 = true;
                }
                liteTransferWrapper.RecvGroup(sessionArr, nFCInfoArr, fTNInfoArr, z19);
                for (DataLineMsgRecord dataLineMsgRecord : arrayList2) {
                    dataLineMsgRecord.bIsTransfering = true;
                    dataLineMsgRecord.nSessionState = 2;
                    f3(dataLineMsgRecord.path);
                }
                return true;
            }
            return z26;
        }
        return z17;
    }

    @Override // rd0.g.c
    public void d0(List<rd0.f> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() >= 0) {
            for (rd0.f fVar : list) {
                if (rd0.h.c(fVar.f431097b)) {
                    y4(true);
                    ((RegisterProxySvcPackHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).J2(1);
                    QLog.i("FileAssistantSender<FileAssistant>", 1, "ipad is online!");
                } else if (rd0.h.b(fVar.f431097b)) {
                    A4(true);
                    ((RegisterProxySvcPackHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).J2(0);
                    QLog.i("FileAssistantSender<FileAssistant>", 1, "pc is online!");
                }
            }
        }
    }

    protected void d4(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        } else {
            AppNetConnInfo.registerConnectionChangeReceiver(qQAppInterface.getApplication(), this.I);
        }
    }

    public void e3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this);
            return;
        }
        synchronized (this.f194539a0) {
            int i3 = this.Y + 1;
            this.Y = i3;
            if (this.X) {
                E4(i3);
            }
        }
    }

    public void f4(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.C.h(i3);
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public boolean getAutoDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return ((Boolean) iPatchRedirector.redirect((short) 90, (Object) this)).booleanValue();
        }
        return w3().getPreferences().getBoolean("auto_receive_files", false);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (Set) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(BaseConstants.CMD_MSG_PBSENDMSG);
        }
        return this.allowCmdSet;
    }

    public void h3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, i3);
        } else {
            i3(i3, false);
        }
    }

    public ToServiceMsg h4(long j3, int i3, SubMsgType0x7$MsgBody subMsgType0x7$MsgBody, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 68, this, Long.valueOf(j3), Integer.valueOf(i3), subMsgType0x7$MsgBody, Long.valueOf(j16));
        }
        String currentAccountUin = this.f194539a0.getCurrentAccountUin();
        int i16 = subMsgType0x7$MsgBody.msg_header.uint32_dst_ter_type.get();
        byte[] byteArray = subMsgType0x7$MsgBody.toByteArray();
        if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + j16);
        }
        msg_svc$PbSendMsgReq k46 = k4(currentAccountUin, 7, byteArray, j16, i16);
        d3(subMsgType0x7$MsgBody, k46);
        return n3(true, i3, j3, k46);
    }

    public void i3(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        LiteTransferWrapper liteTransferWrapper = this.f194553m;
        if (liteTransferWrapper != null) {
            liteTransferWrapper.CancelAll(i3, z16);
        }
        k0.b bVar = this.C;
        if (bVar != null) {
            bVar.c();
        }
    }

    public ToServiceMsg i4(DataLineMsgRecord dataLineMsgRecord, j0.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 61, (Object) this, (Object) dataLineMsgRecord, (Object) bVar);
        }
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(1200);
        cmd0x346_reqbody.uint32_business_id.set(38);
        cmd0x346$ApplyDownloadReq cmd0x346_applydownloadreq = new cmd0x346$ApplyDownloadReq();
        cmd0x346_applydownloadreq.uint64_uin.set(Long.parseLong(this.f194539a0.getCurrentAccountUin()));
        cmd0x346_applydownloadreq.bytes_uuid.set(ByteStringMicro.copyFrom(dataLineMsgRecord.serverPath.getBytes()));
        cmd0x346_applydownloadreq.uint32_owner_type.set(2);
        cmd0x346_reqbody.msg_apply_download_req.set(cmd0x346_applydownloadreq);
        cmd0x346_reqbody.uint32_business_id.set(38);
        cmd0x346_reqbody.uint32_client_type.set(104);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = f194538k0;
        f194538k0 = i3 + 1;
        pBUInt32Field.set(i3);
        ToServiceMsg createToServiceMsg = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", null);
        byte[] byteArray = cmd0x346_reqbody.toByteArray();
        byte[] bArr = new byte[byteArray.length + 4];
        PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
        PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
        if (createToServiceMsg != null) {
            createToServiceMsg.putWupBuffer(bArr);
            if (bVar != null) {
                createToServiceMsg.addAttribute("callback", bVar);
            }
            r3(createToServiceMsg);
        }
        return createToServiceMsg;
    }

    public void j3(int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "manually cancel a file . session =" + j3);
        }
        if (j3 == 0) {
            this.f194553m.CancelGroup(i3, j3, 32, z16);
            return;
        }
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
        DataLineMsgRecord d16 = w3().getMessageFacade().t1(devTypeBySeId).d(j3);
        if (d16 == null) {
            this.f194553m.CancelGroup(i3, j3, 32, z16);
            return;
        }
        d16.fileMsgStatus = 2L;
        d16.bIsTransfering = false;
        e4(d16.path);
        this.f194539a0.getMessageFacade().t1(devTypeBySeId).j(d16.msgId);
        String str = d16.strMoloKey;
        if (str != null) {
            this.C.b(str);
        } else {
            this.f194553m.CancelGroup(d16.groupId, j3, 32, z16);
        }
    }

    public ToServiceMsg j4(long j3, MsgCSBody0x346 msgCSBody0x346, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 63, this, Long.valueOf(j3), msgCSBody0x346, bundle);
        }
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(msgCSBody0x346.uMsgSubType);
        cmd0x346_reqbody.uint32_business_id.set(msgCSBody0x346.uint32_business_id);
        if (msgCSBody0x346.uint32_business_id == 0) {
            cmd0x346_reqbody.uint32_business_id.set(38);
        }
        cmd0x346_reqbody.uint32_client_type.set(104);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = f194538k0;
        f194538k0 = i3 + 1;
        pBUInt32Field.set(i3);
        ToServiceMsg toServiceMsg = null;
        if (!this.R.FillReqBody(msgCSBody0x346, cmd0x346_reqbody)) {
            return null;
        }
        int i16 = msgCSBody0x346.uMsgSubType;
        if (i16 != 1200) {
            if (i16 != 1400) {
                if (i16 != 1600) {
                    if (i16 != 1700) {
                        if (i16 != 1800) {
                            if (i16 == 60100) {
                                toServiceMsg = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", null);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("DataLineHandler", 2, "send0x346Req, unknwon nCmdType:" + msgCSBody0x346.uMsgSubType);
                            }
                        } else {
                            toServiceMsg = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800", null);
                        }
                    } else {
                        toServiceMsg = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", null);
                    }
                } else {
                    toServiceMsg = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600", null);
                }
            } else {
                toServiceMsg = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
            }
        } else {
            toServiceMsg = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", null);
        }
        byte[] byteArray = cmd0x346_reqbody.toByteArray();
        byte[] bArr = new byte[byteArray.length + 4];
        PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
        PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
        if (toServiceMsg != null) {
            toServiceMsg.putWupBuffer(bArr);
            toServiceMsg.addAttribute("cookie", Long.valueOf(j3));
            toServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
            if (bundle != null) {
                toServiceMsg.addAttribute("data", bundle);
                toServiceMsg.addAttribute("sendFromNative", Boolean.FALSE);
            }
            r3(toServiceMsg);
        }
        return toServiceMsg;
    }

    public boolean k3(DataLineMsgRecord dataLineMsgRecord) {
        boolean z16;
        String str;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this, (Object) dataLineMsgRecord)).booleanValue();
        }
        long j3 = dataLineMsgRecord.sessionid;
        long j16 = dataLineMsgRecord.filesize;
        OnSessionProgress(j3, (long) (j16 * 0.4d), j16, 0);
        if (0 != dataLineMsgRecord.filesize && (str = dataLineMsgRecord.path) != null && str.length() != 0 && (bArr = dataLineMsgRecord.md5) != null && bArr.length != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(1400);
        cmd0x346_reqbody.uint32_client_type.set(104);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = f194538k0;
        f194538k0 = i3 + 1;
        pBUInt32Field.set(i3);
        cmd0x346_reqbody.msg_file_query_req.setHasFlag(true);
        cmd0x346_reqbody.msg_file_query_req.uint64_uin.set(Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue());
        int i16 = dataLineMsgRecord.fileFrom;
        if (2 != i16 && 4 != i16 && 6 != i16) {
            cmd0x346_reqbody.msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(dataLineMsgRecord.fileUuid.getBytes()));
            cmd0x346_reqbody.uint32_business_id.set(3);
        } else {
            cmd0x346_reqbody.msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(dataLineMsgRecord.serverPath.getBytes()));
            cmd0x346_reqbody.uint32_business_id.set(38);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
        byte[] byteArray = cmd0x346_reqbody.toByteArray();
        byte[] bArr2 = new byte[byteArray.length + 4];
        PkgTools.dWord2Byte(bArr2, 0, byteArray.length + 4);
        PkgTools.copyData(bArr2, 4, byteArray, byteArray.length);
        if (createToServiceMsg != null) {
            createToServiceMsg.addAttribute("sendFromNative", Boolean.FALSE);
            createToServiceMsg.putWupBuffer(bArr2);
            createToServiceMsg.addAttribute("cookie", Long.valueOf(dataLineMsgRecord.sessionid));
            createToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
            r3(createToServiceMsg);
        }
        return false;
    }

    public ToServiceMsg l4(long j3, int i3, int i16, int i17, int i18, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 66, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), bArr);
        }
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(4);
        this.R.fillMsgHeader(subMsgType0x7$MsgBody.msg_header, Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue(), i3);
        subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.uint64_sessionid.set(j3);
        subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.uint32_size.set(i17);
        subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.uint32_index.set(i18);
        subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.uint32_type.set(1);
        SubMsgType0x7$MsgBody.GenericSubCmd.QQDataTextMsg qQDataTextMsg = new SubMsgType0x7$MsgBody.GenericSubCmd.QQDataTextMsg();
        SubMsgType0x7$MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem msgItem = new SubMsgType0x7$MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem();
        msgItem.uint32_type.set(1);
        msgItem.bytes_text.set(ByteStringMicro.copyFrom(bArr));
        msgItem.setHasFlag(true);
        qQDataTextMsg.rpt_msg_item.add(msgItem);
        qQDataTextMsg.setHasFlag(true);
        subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.bytes_buf.set(ByteStringMicro.copyFrom(qQDataTextMsg.toByteArray()));
        subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.setHasFlag(true);
        subMsgType0x7$MsgBody.setHasFlag(true);
        return h4(j3, i16, subMsgType0x7$MsgBody, j3);
    }

    public void m3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this);
            return;
        }
        synchronized (this.f194539a0) {
            if (this.Y == 0) {
                return;
            }
            this.Y = 0;
            E4(0);
        }
    }

    public void m4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        long j3 = this.f194539a0.getMessageFacade().getLastMessage(String.valueOf(AppConstants.DATALINE_PC_UIN), 6000).time;
        QLog.d("DataLineHandler", 2, "sendDatalineReadConfirm last time[" + j3 + "]");
        if (j3 != 0 && j3 != this.f194541c0) {
            ArrayList<Pair<Long, Long>> arrayList = new ArrayList<>();
            arrayList.add(new Pair<>(Long.valueOf(this.f194539a0.getCurrentAccountUin()), Long.valueOf(j3)));
            ((com.tencent.imcore.message.i) this.f194539a0.getMsgHandler().getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C)).T0(arrayList);
            this.f194541c0 = j3;
        }
        long j16 = this.f194539a0.getMessageFacade().getLastMessage(String.valueOf(AppConstants.DATALINE_IPAD_UIN), 6003).time;
        if (j16 != 0 && j16 != this.f194543d0) {
            ArrayList<Pair<Long, Long>> arrayList2 = new ArrayList<>();
            arrayList2.add(new Pair<>(Long.valueOf(this.f194539a0.getCurrentAccountUin()), Long.valueOf(j16)));
            ((com.tencent.imcore.message.i) this.f194539a0.getMsgHandler().getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C)).T0(arrayList2);
            this.f194543d0 = j16;
        }
    }

    public long n4(String str, String str2, int i3, long j3, int i16, int i17, int i18, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16))).longValue();
        }
        return o4(str, str2, null, i3, j3, i16, i17, i18, z16);
    }

    public long o4(String str, String str2, String str3, int i3, long j3, int i16, int i17, int i18, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, this, str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16))).longValue();
        }
        ArrayList<Session> arrayList = new ArrayList<>();
        Session genSession = this.R.genSession(0, str, str2, str3, i3, 0, j3, i16, i17, i18);
        if (genSession == null) {
            return 0L;
        }
        arrayList.add(genSession);
        if (0 == j3) {
            genSession.uSessionID = u3(0, this.f194551i).longValue();
        }
        genSession.msgHeader = this.R.msgHeader(Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue(), this.f194551i);
        t4(arrayList, z16);
        return genSession.uSessionID;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (Class) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return k.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        DataLineMsgSetList f16;
        DataLineMsgSetList f17;
        bs bsVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f194539a0;
        if (qQAppInterface != null && qQAppInterface.getApp() != null && this.H != null) {
            try {
                this.f194539a0.getApp().unregisterReceiver(this.H);
            } catch (Exception e16) {
                QLog.e("DataLineHandler", 1, "onDestroy fail unregisterReceiver exitReceiver:" + e16);
            }
            this.H = null;
        }
        QQAppInterface qQAppInterface2 = this.f194539a0;
        if (qQAppInterface2 != null && qQAppInterface2.getApp() != null && this.G != null) {
            try {
                this.f194539a0.getApp().unregisterReceiver(this.G);
            } catch (Exception e17) {
                QLog.e("DataLineHandler", 1, "onDestroy fail unregisterReceiver sdCardReceiver:" + e17);
            }
            this.G = null;
        }
        QQAppInterface qQAppInterface3 = this.f194539a0;
        if (qQAppInterface3 != null && qQAppInterface3.getApp() != null && (bsVar = this.f194547f0) != null) {
            this.f194539a0.removeObserver(bsVar);
            this.f194547f0 = null;
        }
        INetInfoHandler iNetInfoHandler = this.I;
        if (iNetInfoHandler != null) {
            AppNetConnInfo.unregisterNetInfoHandler(iNetInfoHandler);
            this.I = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "--->>close cancel all task");
        }
        h3(32);
        QQAppInterface qQAppInterface4 = this.f194539a0;
        boolean z16 = false;
        if (qQAppInterface4 != null && qQAppInterface4.getDataLineMsgProxy(0) != null && (f17 = this.f194539a0.getDataLineMsgProxy(0).f()) != null && f17.size() > 0) {
            Iterator<DataLineMsgSet> it = f17.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().hasSendingOrRecving()) {
                    z16 = true;
                    break;
                }
            }
        }
        QQAppInterface qQAppInterface5 = this.f194539a0;
        if (qQAppInterface5 != null && qQAppInterface5.getDataLineMsgProxy(1) != null && (f16 = this.f194539a0.getDataLineMsgProxy(1).f()) != null && f16.size() > 0) {
            Iterator<DataLineMsgSet> it5 = f16.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                } else if (it5.next().hasSendingOrRecving()) {
                    z16 = true;
                    break;
                }
            }
        }
        this.f194553m.endLiteTransfer(z16);
        this.S.e();
        this.C.a();
        this.D.c();
        this.E.i();
        Timer timer = this.f194545e0;
        if (timer != null) {
            timer.cancel();
            this.f194545e0 = null;
        }
        this.U = true;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // rd0.g.c
    public void p0(List<rd0.f> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this, (Object) list);
        }
    }

    public Session p4(FileManagerEntity fileManagerEntity, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Session) iPatchRedirector.redirect((short) 22, this, fileManagerEntity, Boolean.valueOf(z16));
        }
        int i16 = fileManagerEntity.nFileType;
        if (i16 == 0) {
            i3 = 1;
        } else if (i16 == 2) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        ArrayList<Session> arrayList = new ArrayList<>();
        Session genSession = this.R.genSession(0, fileManagerEntity.getFilePath(), fileManagerEntity.strMiddleThumPath, fileManagerEntity.fileName, i3, 1, fileManagerEntity.nSessionId, fileManagerEntity.dlGroupId, fileManagerEntity.dlGroupCount, fileManagerEntity.dlGourpIndex);
        if (genSession == null) {
            return null;
        }
        genSession.uChannelType = 1;
        genSession.isFileAssist = true;
        arrayList.add(genSession);
        if (genSession.uSessionID == 0) {
            long longValue = t3(0).longValue();
            genSession.uSessionID = longValue;
            fileManagerEntity.nSessionId = longValue;
        }
        QLog.i("FileAssistantSender<FileAssistant>", 1, "doWlanSend[" + fileManagerEntity.nSessionId + "],Send fro Wlan target:" + this.W);
        genSession.msgHeader = this.R.msgHeader(Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue(), this.W);
        t4(arrayList, z16);
        this.f194548g0.put(Long.valueOf(genSession.uSessionID), genSession);
        return genSession;
    }

    public boolean q3(DataLineMsgSet dataLineMsgSet) {
        List<DataLineMsgRecord> r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, (Object) dataLineMsgSet)).booleanValue();
        }
        if (!dataLineMsgSet.isSingle()) {
            P2(dataLineMsgSet.getGroupId());
        }
        int devTypeBySet = DataLineMsgRecord.getDevTypeBySet(dataLineMsgSet);
        Iterator<DataLineMsgRecord> it = dataLineMsgSet.values().iterator();
        while (it.hasNext()) {
            DataLineMsgRecord next = it.next();
            if (next.strMoloKey != null && ((r16 = w3().getDataLineMsgProxy(devTypeBySet).r(next.strMoloKey)) == null || r16.size() == 1)) {
                this.C.d(next.strMoloKey);
                if (QLog.isDevelopLevel()) {
                    QLog.d("DataLineHandler", 4, "\u5220\u9664\u5e94\u7528\u5b9d\u6d88\u606f sessionid[" + next.sessionid);
                }
            }
        }
        if (this.f194539a0.getMessageFacade().t1(devTypeBySet).g(dataLineMsgSet) >= 0) {
            return true;
        }
        return false;
    }

    public void q4(DataLineMsgRecord dataLineMsgRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, dataLineMsgRecord, Boolean.valueOf(z16));
            return;
        }
        if (dataLineMsgRecord == null) {
            return;
        }
        ArrayList<Session> arrayList = new ArrayList<>();
        Session genSession = this.R.genSession(dataLineMsgRecord);
        if (genSession == null) {
            return;
        }
        if (0 == dataLineMsgRecord.sessionid) {
            genSession.uSessionID = u3(0, this.f194551i).longValue();
        }
        genSession.msgHeader = this.R.msgHeader(Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue(), this.f194551i);
        arrayList.add(genSession);
        t4(arrayList, z16);
    }

    public void r4(ArrayList<DataLineMsgRecord> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, arrayList, Boolean.valueOf(z16));
        } else {
            s4(arrayList, z16, null, null, Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue());
        }
    }

    public int s3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        try {
            return this.f194553m.generateGroupID();
        } catch (Exception unused) {
            return 0;
        } catch (UnsatisfiedLinkError unused2) {
            QLog.e("DataLineHandler", 1, "native genGroupId failed");
            return 0;
        }
    }

    public void s4(ArrayList<DataLineMsgRecord> arrayList, boolean z16, String str, byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, arrayList, Boolean.valueOf(z16), str, bArr, Long.valueOf(j3));
            return;
        }
        ArrayList<Session> arrayList2 = new ArrayList<>();
        Iterator<DataLineMsgRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            DataLineMsgRecord next = it.next();
            Session genSession = this.R.genSession(next);
            if (genSession != null) {
                if (0 == genSession.uSessionID) {
                    genSession.uSessionID = u3(next.groupId, this.f194551i).longValue();
                }
                genSession.msgHeader = this.R.msgHeader(j3, this.f194551i);
                this.R.fillService(genSession, str, bArr);
                arrayList2.add(genSession);
            }
        }
        if (arrayList2.size() > 0) {
            t4(arrayList2, z16);
        }
    }

    public void sendFiles(ArrayList<FileInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) arrayList);
        } else {
            sendFilesWithService(arrayList, null, null, Long.valueOf(this.f194539a0.getCurrentAccountUin()).longValue());
        }
    }

    public void sendFilesWithService(ArrayList<FileInfo> arrayList, String str, byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, arrayList, str, bArr, Long.valueOf(j3));
            return;
        }
        if (arrayList == null) {
            return;
        }
        while (true) {
            int size = arrayList.size();
            if (size <= i3) {
                for (int i16 = 0; i16 < size; i16++) {
                    ArrayList<Session> arrayList2 = new ArrayList<>();
                    Session genSession = this.R.genSession(0, arrayList.get(i16).k(), null, arrayList.get(i16).c(), 0, 0, 0L, 0, 0, 0);
                    if (genSession != null) {
                        arrayList2.add(genSession);
                        genSession.uSessionID = u3(0, this.f194551i).longValue();
                        genSession.msgHeader = this.R.msgHeader(j3, this.f194551i);
                        this.R.fillService(genSession, str, bArr);
                    }
                    if (arrayList2.size() > 0) {
                        t4(arrayList2, false);
                    }
                }
                return;
            }
            if (size > i3 && size < 50) {
                ArrayList<Session> arrayList3 = new ArrayList<>();
                int s36 = s3();
                for (int i17 = 0; i17 < size; i17++) {
                    Session genSession2 = this.R.genSession(0, arrayList.get(i17).k(), null, arrayList.get(i17).c(), 0, 0, 0L, s36, size, i17);
                    if (genSession2 != null) {
                        arrayList3.add(genSession2);
                        genSession2.uSessionID = u3(s36, this.f194551i).longValue();
                        genSession2.msgHeader = this.R.msgHeader(j3, this.f194551i);
                        this.R.fillService(genSession2, str, bArr);
                        if (DataLineMsgSet.isSingle(0, s36)) {
                            genSession2.dwGroupID = 0;
                            genSession2.dwGroupIndex = 0;
                            genSession2.dwGroupSize = 0;
                            if (arrayList3.size() > 0) {
                                t4(arrayList3, false);
                            }
                            arrayList3 = new ArrayList<>();
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    t4(arrayList3, false);
                    return;
                }
                return;
            }
            int s37 = s3();
            int i18 = 0;
            ArrayList<Session> arrayList4 = new ArrayList<>();
            while (i18 < 50) {
                int i19 = i18;
                ArrayList<Session> arrayList5 = arrayList4;
                Session genSession3 = this.R.genSession(0, arrayList.get(i18).k(), null, arrayList.get(i18).c(), 0, 0, 0L, s37, 50, i19);
                if (genSession3 != null) {
                    arrayList5.add(genSession3);
                    genSession3.uSessionID = u3(s37, this.f194551i).longValue();
                    genSession3.msgHeader = this.R.msgHeader(j3, this.f194551i);
                    this.R.fillService(genSession3, str, bArr);
                    if (DataLineMsgSet.isSingle(0, s37)) {
                        genSession3.dwGroupID = 0;
                        genSession3.dwGroupIndex = 0;
                        genSession3.dwGroupSize = 0;
                        if (arrayList5.size() > 0) {
                            t4(arrayList5, false);
                        }
                        arrayList5 = new ArrayList<>();
                    }
                }
                arrayList4 = arrayList5;
                i18 = i19 + 1;
            }
            ArrayList<Session> arrayList6 = arrayList4;
            if (arrayList6.size() > 0) {
                t4(arrayList6, false);
            }
            for (int i26 = 0; i26 < 50; i26++) {
                arrayList.remove(0);
            }
            i3 = 3;
        }
    }

    public long sendTencentDocEntity(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return ((Long) iPatchRedirector.redirect((short) 93, (Object) this, (Object) fileManagerEntity)).longValue();
        }
        return X2(((fileManagerEntity.fileName + "\n") + fileManagerEntity.Uuid + "\n") + "\u6765\u81ea:\u817e\u8baf\u6587\u6863", 0).longValue();
    }

    public void sendWeiYunFile(WeiYunFileInfo weiYunFileInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, (Object) weiYunFileInfo);
            return;
        }
        if (weiYunFileInfo == null) {
            QLog.e("DatalineHandler", 1, "sendWeiYunFile weiYunFileInfo=null");
            return;
        }
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.selfuin = this.f194539a0.getCurrentUin();
        dataLineMsgRecord.filename = weiYunFileInfo.f209605f;
        dataLineMsgRecord.filesize = weiYunFileInfo.f209606h;
        dataLineMsgRecord.busId = 25;
        dataLineMsgRecord.fileFrom = 4;
        dataLineMsgRecord.nOpType = 35;
        dataLineMsgRecord.istroop = 0;
        DataLineHandler dataLineHandler = (DataLineHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        dataLineMsgRecord.sessionid = dataLineHandler.u3(0, 0).longValue();
        dataLineMsgRecord.f203106msg = "";
        dataLineMsgRecord.issend = 1;
        dataLineMsgRecord.isread = true;
        dataLineMsgRecord.issuc = false;
        ((ISVIPHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(dataLineMsgRecord);
        dataLineMsgRecord.time = com.tencent.mobileqq.service.message.e.K0();
        dataLineMsgRecord.progress = 0.2f;
        dataLineMsgRecord.fileMsgStatus = 0L;
        dataLineMsgRecord.msgtype = C4(0);
        dataLineMsgRecord.bIsTransfering = true;
        dataLineMsgRecord.bNoInsertFm = true;
        dataLineMsgRecord.strWeiyunId = weiYunFileInfo.f209603d;
        dataLineMsgRecord.strWeiyunDir = weiYunFileInfo.f209604e;
        dataLineMsgRecord.nWeiyunSrcType = weiYunFileInfo.f209608m;
        dataLineMsgRecord.strWeiyunMd5 = weiYunFileInfo.I;
        dataLineMsgRecord.strWeiyunSha = weiYunFileInfo.J;
        this.f194539a0.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid)).a(dataLineMsgRecord, true);
        Boolean bool = Boolean.FALSE;
        dataLineHandler.N3(7, true, new Object[]{0L, Long.valueOf(dataLineMsgRecord.sessionid), dataLineMsgRecord.path, Byte.valueOf((byte) D4(dataLineMsgRecord.msgtype)), bool, bool, Long.valueOf(dataLineMsgRecord.filesize)});
        I3(dataLineMsgRecord, weiYunFileInfo);
    }

    public Long t3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Long) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return Long.valueOf(this.f194553m.generateSessionID(i3));
    }

    public Long u3(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Long) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        try {
            long generateSessionIDByDev = this.f194553m.generateSessionIDByDev(i3, i16);
            if (i16 == 2) {
                generateSessionIDByDev |= LockFreeTaskQueueCore.CLOSED_MASK;
            }
            return Long.valueOf(generateSessionIDByDev);
        } catch (Exception unused) {
            return 0L;
        } catch (UnsatisfiedLinkError unused2) {
            QLog.e("DataLineHandler", 1, "genSessionId failed");
            return 0L;
        }
    }

    public void u4(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w("DataLineHandler", 1, "msg is null!");
            return;
        }
        String plainText = new QQText(str, 45, 32, 0).toPlainText(true);
        String str2 = lc1.b.a().getDefaultRecvPath() + FileManagerUtil.genSessionId() + ".txt";
        g4(plainText, new File(str2));
        n4(str2, null, 0, FileManagerUtil.genSessionId().longValue(), 0, 0, 0, false);
    }

    public long v3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return u3(0, this.W).longValue();
    }

    public void v4(DataLineMsgRecord dataLineMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) dataLineMsgRecord);
        }
    }

    public final QQAppInterface w3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f194539a0;
    }

    public void w4(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, (Object) this, i3);
        } else {
            this.W = i3;
        }
    }

    public int x3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return ((Integer) iPatchRedirector.redirect((short) 105, (Object) this)).intValue();
        }
        return this.W;
    }

    public void x4(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.C.i(i3);
        }
    }

    public k0.a y3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            return (k0.a) iPatchRedirector.redirect((short) 92, (Object) this);
        }
        return this.E;
    }

    public void y4(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
            return;
        }
        this.K = z16;
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.f194539a0)) {
            SharedPreferences preferences = this.f194539a0.getPreferences();
            String str = this.f194539a0.getCurrentAccountUin() + "_IPAD_STATE";
            if (this.K) {
                preferences.edit().putLong(str, this.N).commit();
            } else {
                preferences.edit().remove(str).commit();
            }
        }
    }

    public boolean z3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return this.f194539a0.getPreferences().getBoolean("dl_ipad_online_notify", true);
    }

    public void z4(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
            return;
        }
        this.L = z16;
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.f194539a0)) {
            SharedPreferences preferences = this.f194539a0.getPreferences();
            String str = this.f194539a0.getCurrentAccountUin() + "_PHONE_STATE";
            if (this.L) {
                preferences.edit().putLong(str, this.P).commit();
            } else {
                preferences.edit().remove(str).commit();
            }
        }
    }

    public void sendWeiYunFile(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, (Object) fileManagerEntity);
            return;
        }
        if (fileManagerEntity == null) {
            QLog.e("DatalineHandler", 1, "sendWeiYunFile weiyunEntity=null");
            return;
        }
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.selfuin = this.f194539a0.getCurrentUin();
        dataLineMsgRecord.filename = fileManagerEntity.fileName;
        if (fileManagerEntity.strThumbPath != null) {
            String a16 = com.tencent.mobileqq.filemanager.util.q.a(com.tencent.mobileqq.filemanager.util.q.o(this.f194539a0.getApplication()), FileManagerUtil.getFileName(fileManagerEntity.strThumbPath));
            dataLineMsgRecord.thumbPath = a16;
            FileUtils.copyFile(fileManagerEntity.strThumbPath, a16);
        }
        dataLineMsgRecord.filesize = fileManagerEntity.fileSize;
        dataLineMsgRecord.busId = 25;
        dataLineMsgRecord.fileFrom = 4;
        dataLineMsgRecord.nOpType = 35;
        dataLineMsgRecord.istroop = 0;
        DataLineHandler dataLineHandler = (DataLineHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        dataLineMsgRecord.sessionid = dataLineHandler.u3(0, 0).longValue();
        dataLineMsgRecord.f203106msg = "";
        dataLineMsgRecord.issend = 1;
        dataLineMsgRecord.isread = true;
        dataLineMsgRecord.issuc = false;
        ((ISVIPHandler) this.f194539a0.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(dataLineMsgRecord);
        dataLineMsgRecord.time = com.tencent.mobileqq.service.message.e.K0();
        dataLineMsgRecord.progress = 0.2f;
        dataLineMsgRecord.fileMsgStatus = 0L;
        dataLineMsgRecord.msgtype = C4(0);
        dataLineMsgRecord.bIsTransfering = true;
        dataLineMsgRecord.bNoInsertFm = true;
        this.f194539a0.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid)).a(dataLineMsgRecord, true);
        Boolean bool = Boolean.FALSE;
        dataLineHandler.N3(7, true, new Object[]{0L, Long.valueOf(dataLineMsgRecord.sessionid), dataLineMsgRecord.path, Byte.valueOf((byte) D4(dataLineMsgRecord.msgtype)), bool, bool, Long.valueOf(dataLineMsgRecord.filesize)});
        WeiYunFileInfo weiYunFileInfo = new WeiYunFileInfo();
        weiYunFileInfo.f209605f = fileManagerEntity.fileName;
        weiYunFileInfo.f209606h = fileManagerEntity.fileSize;
        String str = fileManagerEntity.WeiYunDirKey;
        weiYunFileInfo.f209604e = str;
        String str2 = fileManagerEntity.WeiYunFileId;
        weiYunFileInfo.f209603d = str2;
        int i3 = fileManagerEntity.nWeiYunSrcType;
        weiYunFileInfo.f209608m = i3;
        String str3 = fileManagerEntity.strFileMd5;
        weiYunFileInfo.I = str3;
        String str4 = fileManagerEntity.strFileSHA;
        weiYunFileInfo.J = str4;
        dataLineMsgRecord.strWeiyunId = str2;
        dataLineMsgRecord.strWeiyunDir = str;
        dataLineMsgRecord.nWeiyunSrcType = i3;
        dataLineMsgRecord.strWeiyunMd5 = str3;
        dataLineMsgRecord.strWeiyunSha = str4;
        I3(dataLineMsgRecord, weiYunFileInfo);
    }
}
