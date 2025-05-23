package com.tencent.mobileqq.richmedia.conn;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ConnManager implements c {

    /* renamed from: h, reason: collision with root package name */
    private static String f281452h = "PeakAudioTransHandler ConnManager";

    /* renamed from: b, reason: collision with root package name */
    private AppInterface f281454b;

    /* renamed from: d, reason: collision with root package name */
    private a f281456d;

    /* renamed from: g, reason: collision with root package name */
    private rm2.a f281459g;

    /* renamed from: a, reason: collision with root package name */
    private b f281453a = null;

    /* renamed from: e, reason: collision with root package name */
    protected ConcurrentLinkedQueue<byte[]> f281457e = new ConcurrentLinkedQueue<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<a> f281458f = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private Handler f281455c = new Handler(Looper.getMainLooper());

    public ConnManager(AppInterface appInterface, rm2.a aVar) {
        this.f281454b = appInterface;
        this.f281459g = aVar;
    }

    private void j(final long j3) {
        this.f281455c.post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.conn.ConnManager.4
            @Override // java.lang.Runnable
            public void run() {
                ((PeakAudioTransHandler) ConnManager.this.f281454b.getBusinessHandler(PeakAppInterface.G)).F2(j3);
            }
        });
    }

    @Override // com.tencent.mobileqq.richmedia.conn.c
    public void a(boolean z16, final long j3, b bVar, final a aVar, int i3) {
        final PeakAudioTransHandler peakAudioTransHandler = (PeakAudioTransHandler) this.f281454b.getBusinessHandler(PeakAppInterface.G);
        if (aVar == null) {
            QLog.e(f281452h, 2, "onConnect failed ep = null return");
            j(j3);
            return;
        }
        if (z16) {
            this.f281455c.post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.conn.ConnManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnManager.this.f281459g.c(12);
                    peakAudioTransHandler.notifyUI(1, true, new Object[]{Long.valueOf(j3), Integer.valueOf(aVar.C), 2000, aVar});
                    peakAudioTransHandler.J2(j3, true);
                }
            });
            return;
        }
        String str = aVar.f281490d;
        int i16 = aVar.f281491e;
        a aVar2 = this.f281456d;
        if (aVar2 != null && str.equals(aVar2.f281490d) && i16 == this.f281456d.f281491e) {
            if (!this.f281459g.g()) {
                if (QLog.isColorLevel()) {
                    QLog.e(f281452h, 2, "onConnect reConnect state legal lSessionID = " + j3);
                }
                j(j3);
                return;
            }
            boolean z17 = true;
            if (!this.f281459g.m()) {
                QLog.e(f281452h, 1, "onConnect : TCP not in Opening state = " + this.f281459g.f());
                f(j3);
                return;
            }
            if (this.f281456d.f281495m >= 1) {
                QLog.d(f281452h, 2, "reConnect > 1 return");
                int i17 = 0;
                while (true) {
                    if (i17 < this.f281458f.size()) {
                        a aVar3 = this.f281458f.get(i17);
                        if (aVar3 != this.f281456d && aVar3.f281495m == 0) {
                            this.f281456d = aVar3;
                            break;
                        }
                        i17++;
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (z17) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f281452h, 2, "onConnect failed change ip new ip = " + this.f281456d.f281490d + ", port =" + this.f281456d.f281491e);
                    }
                    i(this.f281456d, j3);
                    return;
                }
                QLog.e(f281452h, 2, "onConnect  not ip notify  connect failed ");
                j(j3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f281452h, 2, "onConnect failed reconnect ip = " + this.f281456d.f281490d + ", port =" + this.f281456d.f281491e);
            }
            if (i3 == 3) {
                this.f281455c.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.richmedia.conn.ConnManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnManager.this.f281459g.c(10);
                        ConnManager connManager = ConnManager.this;
                        connManager.i(connManager.f281456d, j3);
                    }
                }, 2000L);
            } else {
                this.f281455c.post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.conn.ConnManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnManager.this.f281459g.c(10);
                        ConnManager connManager = ConnManager.this;
                        connManager.i(connManager.f281456d, j3);
                    }
                });
            }
            a aVar4 = this.f281456d;
            if (aVar4 != null) {
                aVar4.f281495m++;
                return;
            }
            return;
        }
        QLog.e(f281452h, 2, "onConnect ip or port changed ");
        j(j3);
    }

    @Override // com.tencent.mobileqq.richmedia.conn.c
    public void b(long j3, b bVar) {
        if (QLog.isColorLevel()) {
            QLog.e(f281452h, 2, "onDisConnect connId = " + j3 + ",sendDataQueue size =" + this.f281457e.size() + " mTCPstate =" + this.f281459g.f());
        }
        this.f281459g.c(10);
        this.f281456d = null;
        this.f281457e.clear();
        this.f281458f.clear();
        if (this.f281459g.i()) {
            ((PeakAudioTransHandler) this.f281454b.getBusinessHandler(PeakAppInterface.G)).K2(String.valueOf(j3), "TransInfo.ExitSession", null, 0, 0, false);
        } else {
            QLog.e(f281452h, 1, "onDisConnect : session not open need not sso exit");
        }
    }

    public void f(long j3) {
        if (this.f281453a != null) {
            if (!this.f281459g.l()) {
                QLog.e(f281452h, 1, "closeConnection : TCP not opened  mTCPstate =" + this.f281459g.f());
                return;
            }
            this.f281459g.c(13);
            this.f281453a.disConnect();
            this.f281453a = null;
        }
    }

    public byte[] g() {
        if (!this.f281457e.isEmpty()) {
            return this.f281457e.poll();
        }
        return null;
    }

    public boolean h() {
        if (NetworkUtil.isNetSupportHw(this.f281454b.getApp().getApplicationContext())) {
            return true;
        }
        return false;
    }

    public void i(a aVar, long j3) {
        if (aVar == null) {
            QLog.e(f281452h, 1, "openNewConnection : endPoint is null");
            return;
        }
        if (!TextUtils.isEmpty(aVar.f281490d) && aVar.f281491e != 0) {
            if (!this.f281459g.i()) {
                QLog.e(f281452h, 1, "openNewConnection : Session not Open");
                return;
            }
            if (!this.f281459g.k()) {
                QLog.e(f281452h, 1, "openNewConnection : TCP not Close mTCPstate =" + this.f281459g.f());
                return;
            }
            QLog.d(f281452h, 1, "openNewConnection : host:" + aVar.f281490d + ",port=" + aVar.f281491e);
            this.f281456d = aVar;
            b bVar = this.f281453a;
            if (bVar != null) {
                bVar.disConnect();
            }
            LiteTcpConnection liteTcpConnection = new LiteTcpConnection(this, j3, aVar, 3000, 10000);
            this.f281453a = liteTcpConnection;
            liteTcpConnection.a(this);
            this.f281453a.connect();
            this.f281459g.c(11);
            return;
        }
        QLog.e(f281452h, 1, "openNewConnection : endPoint is illegal");
    }

    public void k(ArrayList<a> arrayList) {
        this.f281458f.clear();
        this.f281458f.addAll(arrayList);
    }
}
