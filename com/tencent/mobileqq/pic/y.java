package com.tencent.mobileqq.pic;

import android.os.RemoteException;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.pic.e;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.utils.an;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AccountNotMatchException;

/* compiled from: P */
/* loaded from: classes16.dex */
public class y extends e.a {
    static IPatchRedirector $redirector_;
    private static y Z;

    /* renamed from: a0, reason: collision with root package name */
    static int f258866a0;
    private boolean C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    protected long H;
    protected long I;
    protected long J;
    protected long K;
    protected int L;
    protected int M;
    protected int N;
    protected int P;
    protected boolean Q;
    private int R;
    private String S;
    private String T;
    private String U;
    private int V;
    public int W;
    public long X;
    public String Y;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<p> f258867d;

    /* renamed from: e, reason: collision with root package name */
    protected ArrayList<p> f258868e;

    /* renamed from: f, reason: collision with root package name */
    protected long f258869f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f258870h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f258871i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f258872m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements ac {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ p f258873d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ v f258874e;

        a(p pVar, v vVar) {
            this.f258873d = pVar;
            this.f258874e = vVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, y.this, pVar, vVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void b(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void c(int i3, q qVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) qVar);
                return;
            }
            ad.a aVar = (ad.a) qVar.f258793d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("PresendStatus: destPath:");
            sb5.append(this.f258873d.C.K);
            sb5.append(",uuid:");
            sb5.append(this.f258873d.f258785f);
            sb5.append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
            if (i3 == 0) {
                str = "ResultOk";
            } else {
                str = "ResultFail";
            }
            sb5.append(str);
            f.b("PresendPicMgrService", "onSend ", sb5.toString());
            f.b("PresendPicMgrService", "onSend", " SendResult = " + aVar);
            synchronized (y.this.f258868e) {
                if (!this.f258874e.X) {
                    if (i3 == 0) {
                        this.f258873d.C.E = 1;
                    } else {
                        this.f258873d.C.E = 2;
                    }
                    f.b("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.f258873d);
                    y.this.f258868e.add(this.f258873d);
                } else if (i3 == 0) {
                    try {
                        ((IOrderMediaMsgService) ((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(y.this.U)).getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg((MessageRecord) this.f258873d.C.F, null);
                        f.b("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.f258873d);
                    } catch (AccountNotMatchException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PresendPicMgrService", 2, "no appRuntime");
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("PresendPicMgrService", 2, "onSend SendResult = " + aVar + ", upload failed");
                }
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void d(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void f(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void g(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void i(int i3, ArrayList<q> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) arrayList);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73556);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f258866a0 = 0;
        }
    }

    public y(int i3, String str, String str2, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16));
            return;
        }
        this.f258867d = new ArrayList<>();
        this.f258868e = new ArrayList<>();
        this.H = 209715200L;
        this.I = 157286400L;
        this.J = 73400320L;
        this.K = IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE;
        this.L = 0;
        this.M = 90;
        this.N = 70;
        this.P = 50;
        this.Q = false;
        this.W = 0;
        this.R = i3;
        this.S = str;
        this.T = str2;
        this.U = str3;
        this.V = i16;
        long b16 = com.tencent.mobileqq.pic.a.b("presend_lastDayTime", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        f.b("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + currentTimeMillis + ", lastDayTime = " + b16 + ", curFriendUin = " + str + ",troopUin = " + str2 + ",myUin = " + str3);
        B1();
        if (currentTimeMillis - b16 > 86400000) {
            f.b("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
            com.tencent.mobileqq.activity.photo.m.g(com.tencent.mobileqq.pic.a.b("presend_FlowWaste", 0L));
            com.tencent.mobileqq.pic.a.e("presend_lastDayTime", currentTimeMillis);
            com.tencent.mobileqq.pic.a.e("presend_FlowWaste", 0L);
        }
        this.f258869f = com.tencent.mobileqq.pic.a.b("presend_FlowWaste", 0L);
        Z = this;
    }

    private void B1() {
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pic_presend.name());
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("In VIP list, presendConfigString ");
            featureValue = "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50";
            sb5.append("1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
            f.b("PresendPicMgrService", "getServerConfig", sb5.toString());
        }
        f.b("PresendPicMgrService", "getServerConfig", "presendConfigString = " + featureValue);
        if (featureValue != null && featureValue.length() > 0) {
            String[] split = featureValue.split("\\|");
            if (split.length >= 16) {
                this.f258870h = split[0].equals("1");
                this.f258871i = split[1].equals("1");
                this.f258872m = split[2].equals("1");
                this.C = split[3].equals("1");
                this.D = split[4].equals("1");
                this.E = split[5].equals("1");
                this.F = split[6].equals("1");
                this.G = split[7].equals("1");
                try {
                    this.H = Long.valueOf(split[8]).longValue();
                    this.K = Long.valueOf(split[9]).longValue();
                    this.J = Long.valueOf(split[10]).longValue();
                    this.I = Long.valueOf(split[11]).longValue();
                    this.L = Integer.parseInt(split[12]);
                    this.M = Integer.parseInt(split[13]);
                    this.N = Integer.parseInt(split[14]);
                    this.P = Integer.parseInt(split[15]);
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
                f.b("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.f258870h + "mEnablePreCompress_2G = " + this.f258871i + "mEnablePreCompress_3G = " + this.f258872m + "mEnablePreCompress_4G = " + this.C + "mEnablePreUpload_WIFI = " + this.D + ",mEnablePreUpload_2G = " + this.E + ",mEnablePreUpload_3G = " + this.F + ",mEnablePreUpload_4G = " + this.G + "mPreUpMaxWasteSizeWIFI = " + this.H + ", mPreUpMaxWasteSize2G = " + this.K + ",mPreUpMaxWasteSize3G = " + this.J + ",mPreUpMaxWasteSize4G = " + this.I + ",mCancelPercentWIFI = " + this.L + ",mCancelPercent2G = " + this.M + ",mCancelPercent3G = " + this.N + ",mCancelPercent4G = " + this.P);
            }
        }
    }

    private void Z(MessageRecord messageRecord) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ((IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(messageRecord.frienduin, messageRecord.uniseq);
        ((IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(messageRecord, ((MessageForPic) messageRecord).path);
    }

    private void h2(MessageForPic messageForPic) {
        f.b("PresendPicMgrService", "reuploadPhoto", " ");
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.U);
            qQAppInterface.getMessageFacade().T1(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq);
            if (messageForPic.isSendFromLocal()) {
                ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(messageForPic.frienduin, messageForPic.uniseq));
            }
            v.a aVar = new v.a();
            aVar.v(messageForPic.path);
            aVar.m(5);
            aVar.x(messageForPic.frienduin);
            aVar.r(messageForPic.uniseq);
            if (messageForPic.fileSizeFlag == 1) {
                aVar.y(1);
            } else {
                aVar.y(0);
            }
            aVar.A(messageForPic.senderuin);
            aVar.B(messageForPic.selfuin);
            aVar.I(messageForPic.istroop);
            aVar.Y = messageForPic.extLong;
            aVar.Z = messageForPic.extStr;
            v.b bVar = new v.b();
            long j3 = messageForPic.msgseq;
            bVar.f258842b = messageForPic.shmsgseq;
            bVar.f258841a = j3;
            aVar.z(bVar);
            p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(4, 5);
            createPicReq.f(aVar.l());
            ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
        } catch (AccountNotMatchException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("PresendPicMgrService", 2, "no appRuntime");
            }
        }
    }

    private v o0(String str, boolean z16, int i3, int i16) {
        v.a aVar = new v.a();
        f.b("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.S);
        aVar.x(this.S);
        aVar.v(str);
        aVar.I(this.R);
        aVar.A(this.T);
        aVar.m(i3);
        aVar.C(0);
        aVar.n(i16);
        aVar.H(this.V);
        v l3 = aVar.l();
        if (i16 == 10) {
            if (l3.f258840z0 == null) {
                l3.f258840z0 = new u();
            }
            l3.f258840z0.f258811h = 9;
        }
        l3.U = true;
        if (((IPicUtil) QRoute.api(IPicUtil.class)).isProgressiveJpeg(str)) {
            bm.a();
            try {
                ArrayList<Integer> sliceInfos = ((IPicUtil) QRoute.api(IPicUtil.class)).getSliceInfos(str);
                l3.P = sliceInfos;
                if (sliceInfos != null && QLog.isColorLevel()) {
                    QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + l3.P.toString());
                }
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos\uff0c " + str + "'s size is " + FileUtils.getFileSizes(str));
                }
            }
            bm.b("peak_pgjpeg", "PeakUtils.getSliceInfos(" + str + ")");
        }
        if (z16) {
            l3.Q = 1;
            f.b(l3, "fixProtocolType", "sendReq.upInfo.protocolType");
        } else {
            l3.Q = l3.g();
        }
        return l3;
    }

    private void u0(long j3, int i3) {
        long j16 = this.f258869f + j3;
        this.f258869f = j16;
        com.tencent.mobileqq.pic.a.e("presend_FlowWaste", j16);
        com.tencent.mobileqq.activity.photo.m.d(j3, i3);
        f.b("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + j3 + ",mWastedUploadFlow = " + this.f258869f + ",cancelType = " + i3);
    }

    public static y z1() {
        return Z;
    }

    @Override // com.tencent.mobileqq.pic.e
    public void E1(String str, int i3) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        f.b("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + str + ", cancelType = " + i3);
        p h16 = h1(this.f258867d, str);
        if (h16 == null) {
            f.b("PresendPicMgrService", "cancelUploadReq", " find req failed ");
            return;
        }
        this.f258867d.remove(h16);
        b1(h16, i3);
        f.b("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + str);
    }

    @Override // com.tencent.mobileqq.pic.e
    public void M2(String str, String str2, boolean z16, int i3, int i16) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgVia", 2, "presendPic in main process " + i16);
        }
        f.b("PresendPicMgrService", "presendPic", "PresendStatus : path = " + str + ", localUUID = " + str2 + ",fileSize = " + FileUtils.getFileSizes(str) + ",entrance = " + i16);
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, 1052);
        v o06 = o0(str, z16, i3, i16);
        createPicReq.f(o06);
        createPicReq.j(str2);
        if (!o06.b()) {
            m.a aVar = o06.f258735d;
            f.e("PresendPicMgrService", str2, aVar.f258736a, aVar.f258737b);
            o06.E = 4;
            this.f258867d.add(createPicReq);
            return;
        }
        createPicReq.g(new a(createPicReq, o06));
        if (!U1() || S1() || FileUtils.getFileSizes(createPicReq.C.K) > 512000) {
            f.b("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
            createPicReq.g(null);
            createPicReq.C.E = 3;
        }
        try {
            ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
            this.f258867d.add(createPicReq);
        } catch (AccountNotMatchException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("PresendPicMgrService", 2, "no appRuntime");
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.e
    public void N() throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        f.b("PresendPicMgrService", "sendMsg__ start!", " ");
        Z = null;
        ArrayList arrayList = new ArrayList();
        try {
            synchronized (this.f258868e) {
                this.Q = true;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.U);
            ArrayList arrayList2 = new ArrayList(this.f258867d);
            ArrayList arrayList3 = new ArrayList(this.f258868e);
            long j3 = 0;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                p pVar = (p) arrayList2.get(i3);
                v vVar = pVar.C;
                if (vVar.E == 4) {
                    f.b("PresendPicMgrService", SmsPlugin.API_SEND_SMS, "FLAG_UPLOADINFO_ERROR do not send! uuid = " + pVar.f258785f);
                } else {
                    synchronized (vVar) {
                        if (pVar.C.F == null) {
                            try {
                                f.b("PresendPicMgrService", SmsPlugin.API_SEND_SMS, "start wait! uuid = " + pVar.f258785f);
                                v vVar2 = pVar.C;
                                vVar2.W = true;
                                LockMethodProxy.wait(vVar2);
                                f.b("PresendPicMgrService", SmsPlugin.API_SEND_SMS, "finish wait! uuid = " + pVar.f258785f);
                            } catch (InterruptedException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    v vVar3 = pVar.C;
                    vVar3.X = true;
                    Object obj = vVar3.F;
                    if (obj == null) {
                        f.d("PresendPicMgrService", SmsPlugin.API_SEND_SMS, "get MR failed! uuid = " + pVar.C.f258711e);
                    } else {
                        MessageRecord messageRecord = (MessageRecord) obj;
                        if (this.W == 1) {
                            messageRecord.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_IS_SYNC_QZONE, String.valueOf(1));
                            messageRecord.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_ALBUM_ID, this.Y);
                            messageRecord.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_BATCH_ID, String.valueOf(this.X));
                            messageRecord.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_IS_RAW, String.valueOf(pVar.C.Q));
                            messageRecord.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_BATCH_COUNT, String.valueOf(arrayList2.size()));
                            messageRecord.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_PHOTO_INDEX, String.valueOf(i3));
                        }
                        Z(messageRecord);
                        if (messageRecord instanceof MessageForPic) {
                            arrayList.add(((MessageForPic) messageRecord).path);
                            j3 = messageRecord.uniseq;
                        }
                        if (pVar.C.E == 3) {
                            f.b("PresendPicMgrService", SmsPlugin.API_SEND_SMS, "Pic not upload,reupload! mr = " + messageRecord);
                            h2((MessageForPic) messageRecord);
                        }
                    }
                }
            }
            synchronized (arrayList3) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    p pVar2 = (p) it.next();
                    v vVar4 = pVar2.C;
                    int i16 = vVar4.E;
                    MessageRecord messageRecord2 = (MessageRecord) vVar4.F;
                    if (arrayList2.contains(pVar2)) {
                        if (i16 == 1) {
                            f.b("PresendPicMgrService", SmsPlugin.API_SEND_SMS, "preupload success,dosend! mr =  " + messageRecord2);
                            ((IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(messageRecord2, null);
                        } else {
                            f.b("PresendPicMgrService", SmsPlugin.API_SEND_SMS, "preupload failed,reupload! mr =  " + messageRecord2);
                            h2((MessageForPic) messageRecord2);
                        }
                    } else {
                        f.b("PresendPicMgrService", SmsPlugin.API_SEND_SMS, "unselect,do not send mr =  " + messageRecord2);
                    }
                }
            }
            if (arrayList.size() >= 5 && this.R == 1) {
                if (QLog.isColorLevel()) {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths path=" + ((String) it5.next()));
                    }
                    QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  lastMessageUniseq=" + j3);
                }
                an.a((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.U), this.S, this.U, arrayList, j3);
            } else if (QLog.isColorLevel()) {
                QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths size=" + arrayList.size());
            }
        } catch (AccountNotMatchException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("PresendPicMgrService", 2, "no appRuntime");
            }
        }
        f.b("PresendPicMgrService", "sendMsg__ end!", " ");
        Q0();
    }

    public void N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        f.b("PresendPicMgrService", "handletWifi2Mobile", "netType = " + systemNetwork);
        ArrayList<p> arrayList = this.f258867d;
        if (arrayList != null && arrayList.size() != 0) {
            if (systemNetwork == 2) {
                f.b("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
                Iterator<p> it = this.f258867d.iterator();
                while (it.hasNext()) {
                    p next = it.next();
                    b1(next, 1001);
                    next.C.E = 3;
                }
            }
            if ((systemNetwork == 3 || systemNetwork == 4) && S1()) {
                f.b("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
                Iterator<p> it5 = this.f258867d.iterator();
                while (it5.hasNext()) {
                    p next2 = it5.next();
                    b1(next2, 1002);
                    next2.C.E = 3;
                }
                return;
            }
            return;
        }
        f.b("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }

    @Override // com.tencent.mobileqq.pic.e
    public int[] P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (int[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        try {
            return ((ICompressOperator) QRoute.api(ICompressOperator.class)).getCompressConfigFromServer((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.U));
        } catch (AccountNotMatchException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("PresendPicMgrService", 2, "getPicCompressArgConfig no appRuntime");
            }
            return null;
        }
    }

    public void Q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.W = 0;
        this.X = 0L;
        this.Y = null;
    }

    protected boolean S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        boolean z16 = true;
        if (systemNetwork == 1 ? this.f258869f <= this.H : systemNetwork == 2 ? this.f258869f <= this.K : systemNetwork == 3 ? this.f258869f <= this.J : systemNetwork != 4 || this.f258869f <= this.I) {
            z16 = false;
        }
        f.b("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + systemNetwork + " result =  " + z16 + ",mWastedUploadFlow = " + this.f258869f);
        return z16;
    }

    boolean U1() {
        boolean z16;
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork != 1) {
            if (systemNetwork != 2) {
                if (systemNetwork != 3) {
                    if (systemNetwork != 4) {
                        z16 = false;
                    } else {
                        z16 = this.G;
                    }
                } else {
                    z16 = this.F;
                }
            } else {
                z16 = this.E;
            }
        } else {
            z16 = this.D;
        }
        f.b("PresendPicMgrService", "isPreuploadEnable", "nettype = " + systemNetwork + " result =  " + z16);
        return z16;
    }

    void W1() {
        f.b("PresendPicMgrService", "resetStatus", "");
        this.f258867d.clear();
        this.f258868e.clear();
        this.Q = false;
    }

    protected void b1(p pVar, int i3) {
        v vVar;
        long fileSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pVar, i3);
            return;
        }
        synchronized (pVar.C) {
            vVar = pVar.C;
            vVar.V = true;
        }
        Object obj = vVar.F;
        if (obj == null) {
            f.d("PresendPicMgrService", IECSearchBar.METHOD_DO_CANCEL, " req.upInfo.picExtraObject == null!");
            return;
        }
        MessageRecord messageRecord = (MessageRecord) obj;
        try {
            BaseUploadProcessor baseUploadProcessor = (BaseUploadProcessor) ((ITransFileController) ((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.U)).getRuntimeService(ITransFileController.class)).findProcessor(messageRecord.frienduin, messageRecord.uniseq);
            if (baseUploadProcessor == null) {
                f.b("PresendPicMgrService", IECSearchBar.METHOD_DO_CANCEL, " processor == null!");
                fileSize = ((MessageForPic) messageRecord).mPresendTransferedSize;
            } else {
                int s16 = s1();
                if (baseUploadProcessor.getRealProgress() < s16) {
                    f.b("PresendPicMgrService", IECSearchBar.METHOD_DO_CANCEL, " processor upload less than cancelPercent:" + s16 + ", do cancel! ");
                    baseUploadProcessor.cancel();
                    fileSize = baseUploadProcessor.getTransferedSize();
                } else {
                    f.b("PresendPicMgrService", IECSearchBar.METHOD_DO_CANCEL, " processor upload more than cancelPercent:" + s16 + ", do not cancel!");
                    fileSize = baseUploadProcessor.getFileSize();
                }
            }
            f.b("PresendPicMgrService", IECSearchBar.METHOD_DO_CANCEL, "picSize = " + FileUtils.getFileSizes(((MessageForPic) messageRecord).path));
            u0(fileSize, i3);
            f.b("PresendPicMgrService", "doCancel ", "PresendStatus: Path:" + pVar.C.K + ",uuid:" + pVar.C.f258711e + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        } catch (AccountNotMatchException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("PresendPicMgrService", 2, "no appRuntime");
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.e
    public boolean[] b4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (boolean[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new boolean[]{this.f258870h, this.f258871i, this.f258872m, this.C};
    }

    @Override // com.tencent.mobileqq.pic.e
    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.R;
    }

    protected p h1(ArrayList<p> arrayList, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (p) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList, (Object) str);
        }
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next.f258785f.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public void j2(int i3, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Long.valueOf(j3), str);
            return;
        }
        this.W = i3;
        this.X = j3;
        this.Y = str;
    }

    @Override // com.tencent.mobileqq.pic.e
    public void p1(int i3) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        f.b("PresendPicMgrService", "cancelAll", "cancelType = " + i3);
        W1();
    }

    protected int s1() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork != 1) {
            if (systemNetwork != 2) {
                if (systemNetwork != 3) {
                    if (systemNetwork != 4) {
                        i3 = 0;
                    } else {
                        i3 = this.P;
                    }
                } else {
                    i3 = this.N;
                }
            } else {
                i3 = this.M;
            }
        } else {
            i3 = this.L;
        }
        f.b("PresendPicMgrService", "getCancelPercent", " NetType = " + systemNetwork + ", cancelpercent = " + i3);
        return i3;
    }
}
