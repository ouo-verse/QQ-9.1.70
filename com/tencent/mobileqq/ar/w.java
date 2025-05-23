package com.tencent.mobileqq.ar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.a;
import com.tencent.mobileqq.ar.aidl.b;
import com.tencent.mobileqq.ar.aidl.c;
import com.tencent.mobileqq.ar.aidl.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes11.dex */
public class w implements Handler.Callback {
    public s C;
    public t D;
    private u L;

    /* renamed from: d, reason: collision with root package name */
    private Context f198820d;

    /* renamed from: e, reason: collision with root package name */
    private HandlerThread f198821e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f198822f;

    /* renamed from: h, reason: collision with root package name */
    public ArConfigInfo f198823h;

    /* renamed from: i, reason: collision with root package name */
    public ArEffectConfig f198824i;

    /* renamed from: m, reason: collision with root package name */
    public ARCommonConfigInfo f198825m;
    public com.tencent.mobileqq.ar.aidl.a E = null;
    public boolean F = false;
    volatile boolean G = false;
    boolean H = false;
    public ServiceConnection I = new a();
    public com.tencent.mobileqq.ar.aidl.c J = new b();
    public com.tencent.mobileqq.ar.aidl.b K = new c();
    private com.tencent.mobileqq.ar.aidl.d M = new d();
    private int N = -1;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.this.E = a.AbstractBinderC7399a.j(iBinder);
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "onServiceConnected configManager=" + w.this.E);
            }
            w wVar = w.this;
            com.tencent.mobileqq.ar.aidl.a aVar = wVar.E;
            if (aVar != null) {
                try {
                    aVar.z4(wVar.J);
                    w wVar2 = w.this;
                    wVar2.E.w2(wVar2.K);
                    w wVar3 = w.this;
                    wVar3.E.n0(wVar3.M);
                    if (w.this.N != -1) {
                        w wVar4 = w.this;
                        wVar4.E.onToolScannerActivityStateChanged(wVar4.N);
                    }
                } catch (RemoteException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_RemoteArConfigManager", 2, "registerArCallback: " + e16.getMessage());
                    }
                }
                if (w.this.f198822f != null) {
                    w.this.f198822f.sendEmptyMessage(0);
                }
                w wVar5 = w.this;
                if (wVar5.H) {
                    wVar5.f198823h = wVar5.j();
                    w wVar6 = w.this;
                    if (wVar6.f198823h != null && wVar6.f198822f != null) {
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        w wVar7 = w.this;
                        obtain.obj = wVar7.f198823h;
                        wVar7.f198822f.sendMessage(obtain);
                    }
                }
                w wVar8 = w.this;
                wVar8.f198824i = wVar8.k();
                w wVar9 = w.this;
                if (wVar9.f198824i == null) {
                    wVar9.f198824i = new ArEffectConfig();
                }
                w wVar10 = w.this;
                if (wVar10.f198824i != null && wVar10.f198822f != null) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 2;
                    w wVar11 = w.this;
                    obtain2.obj = wVar11.f198824i;
                    wVar11.f198822f.sendMessage(obtain2);
                }
                w wVar12 = w.this;
                wVar12.f198825m = wVar12.i();
                w wVar13 = w.this;
                if (wVar13.f198825m != null && wVar13.f198822f != null) {
                    Message obtain3 = Message.obtain();
                    obtain3.what = 9;
                    w wVar14 = w.this;
                    obtain3.obj = wVar14.f198825m;
                    wVar14.f198822f.sendMessage(obtain3);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            w wVar = w.this;
            com.tencent.mobileqq.ar.aidl.a aVar = wVar.E;
            if (aVar != null) {
                try {
                    aVar.N2(wVar.J);
                    w wVar2 = w.this;
                    wVar2.E.f4(wVar2.K);
                    w wVar3 = w.this;
                    wVar3.E.N4(wVar3.M);
                } catch (RemoteException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_RemoteArConfigManager", 2, "unregisterCallback: " + e16.getMessage());
                    }
                }
                w.this.E = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends c.a {
        b() {
        }

        @Override // com.tencent.mobileqq.ar.aidl.c
        public void Q4(ArConfigInfo arConfigInfo, ArEffectConfig arEffectConfig, ARCommonConfigInfo aRCommonConfigInfo) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "onConfigChanged!");
            }
            if (w.this.f198822f == null) {
                QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onConfigChanged error mHandler is null ");
                return;
            }
            if (arConfigInfo != null) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = arConfigInfo;
                w.this.f198822f.sendMessage(obtain);
            }
            if (arEffectConfig != null) {
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                obtain2.obj = arEffectConfig;
                w.this.f198822f.sendMessage(obtain2);
            }
            if (aRCommonConfigInfo != null) {
                Message obtain3 = Message.obtain();
                obtain3.what = 9;
                obtain3.obj = aRCommonConfigInfo;
                w.this.f198822f.sendMessage(obtain3);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.c
        public void e(int i3) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadError|error= " + i3);
            }
            if (w.this.f198822f == null) {
                QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadError error mHandler is null ");
            } else {
                w.this.f198822f.sendMessage(w.this.f198822f.obtainMessage(5, Integer.valueOf(i3)));
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.c
        public void i(long j3, long j16) throws RemoteException {
            if (j16 != 0) {
                long j17 = (100 * j3) / j16;
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadProcess percent= " + j17);
                }
                if (w.this.f198822f == null) {
                    QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadProcess error mHandler is null ");
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.arg1 = (int) j3;
                obtain.arg2 = (int) j16;
                w.this.f198822f.sendMessage(obtain);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.c
        public void onDownloadSuccess() throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadSuccess ");
            }
            if (w.this.f198822f == null) {
                QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadSuccess error mHandler is null ");
            } else {
                w.this.f198822f.sendMessage(w.this.f198822f.obtainMessage(3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends b.a {
        c() {
        }

        @Override // com.tencent.mobileqq.ar.aidl.b
        public void H4(int i3, int i16) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "download error " + i3 + ProgressTracer.SEPARATOR + i16);
            }
            if (w.this.f198822f == null) {
                QLog.d("ArConfig_RemoteArConfigManager", 1, "mFaceCallback onDownloadError error mHandler is null ");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 8;
            obtain.arg1 = i3;
            obtain.arg2 = i16;
            w.this.f198822f.sendMessage(obtain);
        }

        @Override // com.tencent.mobileqq.ar.aidl.b
        public void R3(int i3) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "download success " + i3);
            }
            if (w.this.f198822f == null) {
                QLog.d("ArConfig_RemoteArConfigManager", 1, "mFaceCallback onDownloadSuccess error mHandler is null ");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 6;
            obtain.arg1 = i3;
            w.this.f198822f.sendMessage(obtain);
        }

        @Override // com.tencent.mobileqq.ar.aidl.b
        public void X0(int i3, int i16) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "download process " + i3 + ProgressTracer.SEPARATOR + i16);
            }
            if (w.this.f198822f == null) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.arg1 = i3;
            obtain.arg2 = i16;
            w.this.f198822f.sendMessage(obtain);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d extends d.a {
        d() {
        }

        @Override // com.tencent.mobileqq.ar.aidl.d
        public void F(int i3) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadProcess process=" + i3);
            }
            Message obtainMessage = w.this.f198822f.obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = i3;
            obtainMessage.sendToTarget();
        }

        @Override // com.tencent.mobileqq.ar.aidl.d
        public void p() throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadFail");
            }
            Message obtainMessage = w.this.f198822f.obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.sendToTarget();
        }

        @Override // com.tencent.mobileqq.ar.aidl.d
        public void t() throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "onArSoDownloadSuccess");
            }
            Message obtainMessage = w.this.f198822f.obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.sendToTarget();
        }
    }

    public w() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RemoteArConfigManager");
        this.f198821e = baseHandlerThread;
        baseHandlerThread.start();
        this.f198822f = new Handler(this.f198821e.getLooper(), this);
    }

    public void d() {
        if (this.E != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload");
            }
            try {
                this.E.cancelDownload();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload|RemoteException e= " + e16);
                }
            }
        }
    }

    public void e(Context context, boolean z16, s sVar, t tVar, u uVar) throws RuntimeException {
        if (context == null) {
            return;
        }
        this.f198820d = context;
        this.H = z16;
        this.f198820d.bindService(new Intent(this.f198820d, (Class<?>) ArConfigService.class), this.I, 1);
        this.G = true;
        if (sVar != null) {
            this.C = sVar;
        }
        if (tVar != null) {
            this.D = tVar;
        }
        this.L = uVar;
    }

    public void f() {
        Handler handler = this.f198822f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f198822f = null;
        }
        try {
            HandlerThread handlerThread = this.f198821e;
            if (handlerThread != null && handlerThread.isAlive()) {
                this.f198821e.quitSafely();
            }
            this.f198821e = null;
        } catch (Throwable th5) {
            QLog.e("ArConfig_RemoteArConfigManager", 1, "quit exception, ", th5);
        }
        if (this.F) {
            d();
            this.F = false;
        }
        if (this.G) {
            Context context = this.f198820d;
            if (context != null) {
                try {
                    context.unbindService(this.I);
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
            this.G = false;
            this.f198820d = null;
        }
        this.C = null;
        this.D = null;
        this.L = null;
    }

    public void g() {
        com.tencent.mobileqq.ar.aidl.a aVar = this.E;
        if (aVar != null) {
            try {
                aVar.A2();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadArSo fail!", e16);
                }
            }
        }
    }

    public void h(int i3) {
        if (this.E != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadFaceResources type " + i3);
            }
            try {
                this.E.V2(i3);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadFaceResources|RemoteException e= " + e16);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        switch (i3) {
            case 0:
                s sVar = this.C;
                if (sVar != null) {
                    sVar.k();
                }
                return false;
            case 1:
                s sVar2 = this.C;
                if (sVar2 != null) {
                    Object obj = message.obj;
                    if (obj instanceof ArConfigInfo) {
                        sVar2.l((ArConfigInfo) obj);
                    }
                }
                return false;
            case 2:
                s sVar3 = this.C;
                if (sVar3 != null) {
                    Object obj2 = message.obj;
                    if (obj2 instanceof ArEffectConfig) {
                        sVar3.j((ArEffectConfig) obj2);
                    }
                }
                return false;
            case 3:
                s sVar4 = this.C;
                if (sVar4 != null) {
                    sVar4.onDownloadSuccess();
                    this.F = false;
                }
                return false;
            case 4:
                s sVar5 = this.C;
                if (sVar5 != null) {
                    sVar5.i(message.arg1, message.arg2);
                }
                return false;
            case 5:
                s sVar6 = this.C;
                if (sVar6 != null) {
                    Object obj3 = message.obj;
                    if (obj3 instanceof Integer) {
                        sVar6.e(((Integer) obj3).intValue());
                        this.F = false;
                    }
                }
                return false;
            case 6:
                t tVar = this.D;
                if (tVar != null) {
                    tVar.a(message.arg1);
                }
                return false;
            case 7:
                t tVar2 = this.D;
                if (tVar2 != null) {
                    tVar2.b(message.arg1, message.arg2);
                }
                return false;
            case 8:
                t tVar3 = this.D;
                if (tVar3 != null) {
                    tVar3.c(message.arg1, message.arg2);
                }
                return false;
            case 9:
                s sVar7 = this.C;
                if (sVar7 != null) {
                    try {
                        Object obj4 = message.obj;
                        if (obj4 instanceof ARCommonConfigInfo) {
                            sVar7.m((ARCommonConfigInfo) obj4);
                        }
                    } catch (Exception e16) {
                        QLog.e("ArConfig_RemoteArConfigManager", 1, "handleMessage AR_COMMON_CONFIG_UPDATE fail.", e16);
                    }
                }
                return false;
            default:
                switch (i3) {
                    case 100:
                        u uVar = this.L;
                        if (uVar != null) {
                            uVar.t();
                            break;
                        }
                        break;
                    case 101:
                        u uVar2 = this.L;
                        if (uVar2 != null) {
                            uVar2.p();
                            break;
                        }
                        break;
                    case 102:
                        u uVar3 = this.L;
                        if (uVar3 != null) {
                            uVar3.F(message.arg1);
                            break;
                        }
                        break;
                }
        }
    }

    public ARCommonConfigInfo i() {
        ARCommonConfigInfo aRCommonConfigInfo = this.f198825m;
        if (aRCommonConfigInfo != null) {
            return aRCommonConfigInfo;
        }
        com.tencent.mobileqq.ar.aidl.a aVar = this.E;
        ARCommonConfigInfo aRCommonConfigInfo2 = null;
        if (aVar != null) {
            try {
                aRCommonConfigInfo2 = aVar.t1();
            } catch (Exception e16) {
                QLog.d("ArConfig_RemoteArConfigManager", 1, "getARCommonConfigInfo fail!", e16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", aRCommonConfigInfo2));
            }
        }
        return aRCommonConfigInfo2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArConfigInfo j() {
        ArConfigInfo D3;
        ArConfigInfo arConfigInfo = this.f198823h;
        if (arConfigInfo != null) {
            return arConfigInfo;
        }
        com.tencent.mobileqq.ar.aidl.a aVar = this.E;
        if (aVar != null) {
            try {
                D3 = aVar.D3();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|RemoteException e= " + e16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|info=" + D3);
            }
            return D3;
        }
        D3 = null;
        if (QLog.isColorLevel()) {
        }
        return D3;
    }

    public ArEffectConfig k() {
        ArEffectConfig arEffectConfig = this.f198824i;
        if (arEffectConfig != null) {
            return arEffectConfig;
        }
        com.tencent.mobileqq.ar.aidl.a aVar = this.E;
        ArEffectConfig arEffectConfig2 = null;
        if (aVar != null) {
            try {
                arEffectConfig2 = aVar.m1();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|RemoteException e= " + e16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|info=" + arEffectConfig2);
            }
        }
        return arEffectConfig2;
    }

    public boolean l() {
        com.tencent.mobileqq.ar.aidl.a aVar = this.E;
        if (aVar != null) {
            try {
                return aVar.a3();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_RemoteArConfigManager", 2, "isArSoReady fail!", e16);
                }
            }
        }
        return false;
    }

    public boolean m() {
        com.tencent.mobileqq.ar.aidl.a aVar = this.E;
        boolean z16 = false;
        if (aVar != null) {
            try {
                z16 = aVar.r1();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_RemoteArConfigManager", 2, "isFaceResConfigReady|RemoteException e= " + e16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_RemoteArConfigManager", 2, "isFaceResConfigReady " + z16);
            }
        }
        return z16;
    }

    public void n(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "onToolScannerActivityStateChanged state:" + i3 + "  mConfigManager:" + this.E);
        }
        com.tencent.mobileqq.ar.aidl.a aVar = this.E;
        if (aVar != null) {
            try {
                aVar.onToolScannerActivityStateChanged(i3);
                return;
            } catch (RemoteException e16) {
                e16.printStackTrace();
                return;
            }
        }
        this.N = i3;
    }
}
