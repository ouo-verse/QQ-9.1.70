package com.tencent.litetransfersdk;

import android.os.Handler;
import android.os.Looper;
import com.dataline.util.g;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import lc1.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LiteTransferWrapper {
    static IPatchRedirector $redirector_ = null;
    static final int Business_ID_C2C = 3;
    static final int Business_ID_DataLine = 38;
    static final int Business_ID_Disc = 106;
    static final int Business_ID_Group = 102;
    public static final String sTagName = "dataline.LiteTTransferWrapper";
    private LiteTransferListenerCallback mListener;
    private long mLiteTransferOperator;
    private LiteTransferOperatorCallback mOperator;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 43)) {
            redirector.redirect((short) 43);
            return;
        }
        try {
            SoLoadUtil.m(BaseApplication.getContext(), "xplatform", 0, false);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        try {
            SoLoadUtil.m(BaseApplication.getContext(), "mbedtlsall", 0, false);
        } catch (UnsatisfiedLinkError e17) {
            e17.printStackTrace();
        }
        try {
            SoLoadUtil.m(BaseApplication.getContext(), "xphttpclientex", 0, false);
        } catch (UnsatisfiedLinkError e18) {
            e18.printStackTrace();
        }
        try {
            SoLoadUtil.m(BaseApplication.getContext(), "litetransfer", 0, false);
        } catch (UnsatisfiedLinkError e19) {
            e19.printStackTrace();
        }
    }

    public LiteTransferWrapper(LiteTransferOperatorCallback liteTransferOperatorCallback, LiteTransferListenerCallback liteTransferListenerCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) liteTransferOperatorCallback, (Object) liteTransferListenerCallback);
            return;
        }
        this.mOperator = liteTransferOperatorCallback;
        this.mListener = liteTransferListenerCallback;
        this.mLiteTransferOperator = 0L;
    }

    public static void OnLog(int i3, byte[] bArr, byte[] bArr2) {
        try {
            String str = new String(bArr, "UTF-8");
            String str2 = new String(bArr2, "UTF-8");
            if (i3 != 0 && i3 != 1) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(str, 4, str2);
                    return;
                }
                return;
            }
            QLog.d(str, 1, str2);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            if (QLog.isDevelopLevel()) {
                QLog.e(sTagName, 4, "native log encoding utf8 failed");
            }
        }
    }

    public static long getCurrentMillisTime() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    public static int getNetType() {
        return NetworkCenter.getInstance().getNetType();
    }

    public void CancelAll(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "CancelAll " + this.mLiteTransferOperator);
        }
        if (this.mLiteTransferOperator == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(sTagName, 2, "CancelAll mLiteTransferOperator is 0, maybe not inited, so has nothing to cancel");
                return;
            }
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(i3, z16) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f119761d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f119762e;

                {
                    this.f119761d = i3;
                    this.f119762e = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiteTransferWrapper.this, Integer.valueOf(i3), Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.CancelAllToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119761d, this.f119762e);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            CancelAllToJNI(j3, i3, z16);
        }
    }

    public native void CancelAllToJNI(long j3, int i3, boolean z16);

    public void CancelGroup(int i3, long j3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "CancelGroup " + this.mLiteTransferOperator);
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(i3, j3, i16, z16) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f119771d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f119772e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f119773f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f119774h;

                {
                    this.f119771d = i3;
                    this.f119772e = j3;
                    this.f119773f = i16;
                    this.f119774h = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiteTransferWrapper.this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.CancelGroupToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119771d, this.f119772e, this.f119773f, this.f119774h);
                    }
                }
            });
            return;
        }
        long j16 = this.mLiteTransferOperator;
        if (j16 != 0) {
            CancelGroupToJNI(j16, i3, j3, i16, z16);
        }
    }

    public native void CancelGroupToJNI(long j3, int i3, long j16, int i16, boolean z16);

    public native void DoGetThumbFilePathReplyToJNI(long j3, int i3, String str);

    public native void DoPbMsgReplyToJNI(long j3, int i3, MsgSCBody msgSCBody);

    public void OnGetThumbFilePathReply(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) str);
            return;
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(i3, str) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f119775d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f119776e;

                {
                    this.f119775d = i3;
                    this.f119776e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiteTransferWrapper.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.DoGetThumbFilePathReplyToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119775d, this.f119776e);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            DoGetThumbFilePathReplyToJNI(j3, i3, str);
        }
    }

    public void OnPbMsgReceive(MsgCSBody msgCSBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgCSBody);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "_PbMsgRecive " + this.mLiteTransferOperator);
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(msgCSBody) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MsgCSBody f119753d;

                {
                    this.f119753d = msgCSBody;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteTransferWrapper.this, (Object) msgCSBody);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.PbMsgReciveToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119753d);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            PbMsgReciveToJNI(j3, msgCSBody);
        }
    }

    public void OnPbMsgReply(int i3, MsgSCBody msgSCBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) msgSCBody);
            return;
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(i3, msgSCBody) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f119777d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ MsgSCBody f119778e;

                {
                    this.f119777d = i3;
                    this.f119778e = msgSCBody;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiteTransferWrapper.this, Integer.valueOf(i3), msgSCBody);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.DoPbMsgReplyToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119777d, this.f119778e);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            DoPbMsgReplyToJNI(j3, i3, msgSCBody);
        }
    }

    public native void PbMsgReciveToJNI(long j3, MsgCSBody msgCSBody);

    public void RecvGroup(Session[] sessionArr, NFCInfo[] nFCInfoArr, FTNInfo[] fTNInfoArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, sessionArr, nFCInfoArr, fTNInfoArr, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "RecvGroup " + this.mLiteTransferOperator);
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(sessionArr, nFCInfoArr, fTNInfoArr, z16) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Session[] f119767d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ NFCInfo[] f119768e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ FTNInfo[] f119769f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f119770h;

                {
                    this.f119767d = sessionArr;
                    this.f119768e = nFCInfoArr;
                    this.f119769f = fTNInfoArr;
                    this.f119770h = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiteTransferWrapper.this, sessionArr, nFCInfoArr, fTNInfoArr, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper.this.SetProxyToJni();
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.RecvGroupToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119767d, this.f119768e, this.f119769f, this.f119770h);
                    }
                }
            });
        } else if (this.mLiteTransferOperator != 0) {
            SetProxyToJni();
            RecvGroupToJNI(this.mLiteTransferOperator, sessionArr, nFCInfoArr, fTNInfoArr, z16);
        }
    }

    public native void RecvGroupToJNI(long j3, Session[] sessionArr, NFCInfo[] nFCInfoArr, FTNInfo[] fTNInfoArr, boolean z16);

    public void SendGroup(ArrayList<Session> arrayList, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, arrayList, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(arrayList, z16, z17) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f119764d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f119765e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f119766f;

                {
                    this.f119764d = arrayList;
                    this.f119765e = z16;
                    this.f119766f = z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiteTransferWrapper.this, arrayList, Boolean.valueOf(z16), Boolean.valueOf(z17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper.this.SetProxyToJni();
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        long j3 = liteTransferWrapper.mLiteTransferOperator;
                        ArrayList arrayList2 = this.f119764d;
                        liteTransferWrapper.SendGroupToJNI(j3, (Session[]) arrayList2.toArray(new Session[arrayList2.size()]), this.f119765e, this.f119766f);
                    }
                }
            });
        } else if (this.mLiteTransferOperator != 0) {
            SetProxyToJni();
            SendGroupToJNI(this.mLiteTransferOperator, (Session[]) arrayList.toArray(new Session[arrayList.size()]), z16, z17);
        }
    }

    public native void SendGroupToJNI(long j3, Session[] sessionArr, boolean z16, boolean z17);

    public native void SetBusinessID(int i3, int i16, int i17, int i18);

    public void SetDefaultPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "SetDefaultPath " + str);
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(str) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f119754d;

                {
                    this.f119754d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteTransferWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.SetDefaultPathToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119754d);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            SetDefaultPathToJNI(j3, str);
        }
    }

    public native void SetDefaultPathToJNI(long j3, String str);

    public void SetProxyToJni() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        g.a d16 = g.d();
        if (d16 != null) {
            try {
                setGlobalProxyInfo(1, d16.f32386a, (short) d16.f32387b, "", "");
                return;
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
                return;
            }
        }
        try {
            setGlobalProxyInfo(0, "", (short) 0, "", "");
        } catch (UnsatisfiedLinkError e17) {
            e17.printStackTrace();
        }
    }

    public void SetServicePath(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "SetServicePath " + str);
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(str, str2) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.13
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f119756d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f119757e;

                {
                    this.f119756d = str;
                    this.f119757e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiteTransferWrapper.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.SetServicePathToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119756d, this.f119757e);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            SetServicePathToJNI(j3, str, str2);
        }
    }

    public native void SetServicePathToJNI(long j3, String str, String str2);

    public void SetTempPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "SetTempPath " + str);
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(str) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.14
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f119758d;

                {
                    this.f119758d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteTransferWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.SetTempPathToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119758d);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            SetTempPathToJNI(j3, str);
        }
    }

    public native void SetTempPathToJNI(long j3, String str);

    public void SetThumbPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "SetThumbPath " + str);
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(str) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.12
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f119755d;

                {
                    this.f119755d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteTransferWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.SetThumbPathToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119755d);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            SetThumbPathToJNI(j3, str);
        }
    }

    public native void SetThumbPathToJNI(long j3, String str);

    public void SetThumbTempPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "SetThumbTempPath " + str);
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(str) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.15
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f119759d;

                {
                    this.f119759d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteTransferWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.SetThumbTempPathToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119759d);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            SetThumbTempPathToJNI(j3, str);
        }
    }

    public native void SetThumbTempPathToJNI(long j3, String str);

    public void SyncGroup(Session[] sessionArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sessionArr);
            return;
        }
        checkTransferAlive();
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(sessionArr) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Session[] f119763d;

                {
                    this.f119763d = sessionArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteTransferWrapper.this, (Object) sessionArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                        LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                        liteTransferWrapper.SyncGroupToJNI(liteTransferWrapper.mLiteTransferOperator, this.f119763d);
                    }
                }
            });
            return;
        }
        long j3 = this.mLiteTransferOperator;
        if (j3 != 0) {
            SyncGroupToJNI(j3, sessionArr);
        }
    }

    public native void SyncGroupToJNI(long j3, Session[] sessionArr);

    public void beginLiteTransfer() {
        LiteTransferListenerCallback liteTransferListenerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteTransferWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (LiteTransferWrapper.this.mOperator != null && LiteTransferWrapper.this.mListener != null) {
                        if (LiteTransferWrapper.this.mLiteTransferOperator == 0) {
                            try {
                                LiteTransferWrapper liteTransferWrapper = LiteTransferWrapper.this;
                                liteTransferWrapper.mLiteTransferOperator = liteTransferWrapper.createOperator(liteTransferWrapper.mOperator, LiteTransferWrapper.this.mListener);
                                LiteTransferWrapper.this.SetBusinessID(38, 3, 106, 102);
                                QLog.i(LiteTransferWrapper.sTagName, 1, "createOperator mLiteTransferOperator:" + LiteTransferWrapper.this.mLiteTransferOperator + " threadId:" + Thread.currentThread().getId());
                                LiteTransferWrapper.this.checkPathExist();
                                LiteTransferWrapper.this.SetProxyToJni();
                                return;
                            } catch (UnsatisfiedLinkError e16) {
                                e16.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LiteTransferWrapper.sTagName, 2, "litetransfer callback is null, do nothing");
                    }
                }
            });
            return;
        }
        LiteTransferOperatorCallback liteTransferOperatorCallback = this.mOperator;
        if (liteTransferOperatorCallback != null && (liteTransferListenerCallback = this.mListener) != null) {
            if (this.mLiteTransferOperator == 0) {
                try {
                    this.mLiteTransferOperator = createOperator(liteTransferOperatorCallback, liteTransferListenerCallback);
                    SetBusinessID(38, 3, 106, 102);
                    QLog.i(sTagName, 1, "createOperator mLiteTransferOperator:" + this.mLiteTransferOperator + " threadId:" + Thread.currentThread().getId());
                    checkPathExist();
                    SetProxyToJni();
                    return;
                } catch (UnsatisfiedLinkError e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "litetransfer callback is null, do nothing");
        }
    }

    public void checkPathExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            File file = new File(b.a().getDefaultRecvPath());
            if (!file.exists()) {
                file.mkdir();
            }
            SetDefaultPath(b.a().getDefaultRecvPath());
            File file2 = new File(b.a().getDefaultThumbPath());
            if (!file2.exists()) {
                file2.mkdir();
            }
            SetThumbPath(b.a().getDefaultThumbPath());
            File file3 = new File(b.a().getDefaultTmpPath());
            if (!file3.exists()) {
                file3.mkdir();
            }
            SetTempPath(b.a().getDefaultTmpPath());
            File file4 = new File(b.a().getDefaultTmpPath());
            if (!file4.exists()) {
                file4.mkdir();
            }
            SetThumbTempPath(b.a().getDefaultTmpPath());
        } catch (Exception unused) {
        }
    }

    public void checkTransferAlive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.mLiteTransferOperator == 0) {
            beginLiteTransfer();
        }
    }

    public native long createOperator(LiteTransferOperatorCallback liteTransferOperatorCallback, LiteTransferListenerCallback liteTransferListenerCallback);

    public native void destryOperator(long j3, boolean z16);

    public void endLiteTransfer(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (this.mLiteTransferOperator == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(sTagName, 2, "endLiteTransfer mLiteTransferOperator is 0, maybe not inited, so has nothing to cancel");
                return;
            }
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(z16) { // from class: com.tencent.litetransfersdk.LiteTransferWrapper.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f119760d;

                {
                    this.f119760d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiteTransferWrapper.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (LiteTransferWrapper.this.mLiteTransferOperator != 0) {
                            QLog.i(LiteTransferWrapper.sTagName, 1, "destryOperator mLiteTransferOperator:" + LiteTransferWrapper.this.mLiteTransferOperator + " threadId:" + Thread.currentThread().getId());
                            long j3 = LiteTransferWrapper.this.mLiteTransferOperator;
                            LiteTransferWrapper.this.mLiteTransferOperator = 0L;
                            LiteTransferWrapper.this.destryOperator(j3, this.f119760d);
                        }
                    } catch (UnsatisfiedLinkError e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LiteTransferWrapper.sTagName, 2, "cannot endLiteTransfer, load litetranfer library error?" + QLog.getStackTraceString(e16));
                        }
                    }
                    LiteTransferWrapper.this.mOperator = null;
                    LiteTransferWrapper.this.mListener = null;
                }
            });
            return;
        }
        try {
            if (this.mLiteTransferOperator != 0) {
                QLog.i(sTagName, 1, "destryOperator mLiteTransferOperator:" + this.mLiteTransferOperator + " threadId:" + Thread.currentThread().getId());
                long j3 = this.mLiteTransferOperator;
                this.mLiteTransferOperator = 0L;
                destryOperator(j3, z16);
            }
        } catch (UnsatisfiedLinkError e16) {
            if (QLog.isColorLevel()) {
                QLog.d(sTagName, 2, "cannot endLiteTransfer, load litetranfer library error?" + QLog.getStackTraceString(e16));
            }
        }
        this.mOperator = null;
        this.mListener = null;
    }

    public native int generateGroupID();

    public native long generateSessionID(int i3);

    public native long generateSessionIDByDev(int i3, int i16);

    public native long generateTaskID(long j3, byte b16);

    public native long initGlobalFunc();

    public native void setGlobalProxyInfo(int i3, String str, short s16, String str2, String str3);

    public native void setWanIP(int i3);
}
