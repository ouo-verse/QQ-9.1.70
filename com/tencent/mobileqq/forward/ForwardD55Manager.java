package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import tencent.im.oidb.oidb_0xd55$RspBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardD55Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<a> f210613a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Long, b> f210614b;

    /* renamed from: c, reason: collision with root package name */
    private int f210615c;

    /* renamed from: d, reason: collision with root package name */
    private b f210616d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a();
    }

    public ForwardD55Manager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f210614b = new ConcurrentHashMap();
        }
    }

    public void c(String str, long j3, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3), str2);
            return;
        }
        this.f210615c = 0;
        this.f210616d = null;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        QLog.d("ForwardD55Manager", 1, "fetchAppInfoByD55 openId=", str, ", appId=", Long.valueOf(j3), ", pkgName=", str2);
        ForwardStatisticsReporter.m("KEY_STAGE_1_D55");
        MessageHandler msgHandler = qQAppInterface.getMsgHandler();
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        msgHandler.M2(false, str3, false, 0L, j3, 1, 2, str2, true, x.k(), new ProtoUtils.TroopProtocolObserver(str2, j3) { // from class: com.tencent.mobileqq.forward.ForwardD55Manager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f210617d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f210618e;

            {
                this.f210617d = str2;
                this.f210618e = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ForwardD55Manager.this, str2, Long.valueOf(j3));
                }
            }

            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int i3, byte[] bArr, Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                    return;
                }
                QLog.d("ForwardD55Manager", 1, "fetchAppInfoByD55 onResult errorCode: " + i3);
                ForwardStatisticsReporter.c("KEY_STAGE_1_D55");
                ThreadManager.getUIHandler().post(new Runnable(bArr, i3) { // from class: com.tencent.mobileqq.forward.ForwardD55Manager.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ byte[] f210620d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f210621e;

                    {
                        this.f210620d = bArr;
                        this.f210621e = i3;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, bArr, Integer.valueOf(i3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        b bVar = new b();
                        oidb_0xd55$RspBody a06 = ForwardUtils.a0(this.f210620d);
                        if (a06 != null) {
                            b.b(a06, AnonymousClass1.this.f210617d, bVar);
                        }
                        ForwardD55Manager.this.f210615c = this.f210621e;
                        ForwardD55Manager.this.f210616d = bVar;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        ForwardD55Manager.this.j(anonymousClass1.f210618e, bVar);
                    }
                });
            }
        });
    }

    public synchronized b d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (b) iPatchRedirector.redirect((short) 9, (Object) this, j3);
        }
        return this.f210614b.get(Long.valueOf(j3));
    }

    public synchronized b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f210616d;
    }

    public synchronized String f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        b bVar = this.f210616d;
        if (bVar != null) {
            str = bVar.g();
        } else {
            str = "";
        }
        return str;
    }

    public synchronized boolean g() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f210616d != null && this.f210615c == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized boolean h() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f210616d != null && this.f210615c > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f210614b.clear();
        }
    }

    public synchronized void j(long j3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), bVar);
            return;
        }
        QLog.d("ForwardD55Manager", 1, "--> onResult appId=", Long.valueOf(j3), ", appInfo=", bVar.toString());
        this.f210614b.put(Long.valueOf(j3), bVar);
        if (this.f210613a != null) {
            QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener");
            if (this.f210613a.get() != null) {
                QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener.get()");
                this.f210613a.get().a();
            } else {
                QLog.d("ForwardD55Manager", 1, "--> onResult null == mListener.get()");
            }
        } else {
            QLog.d("ForwardD55Manager", 1, "--> onResult null == mListener");
        }
    }

    public synchronized void k(a aVar) {
        WeakReference<a> weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        QLog.d("ForwardD55Manager", 1, "--> setD55Listener=", aVar);
        if (aVar == null) {
            weakReference = null;
        } else {
            weakReference = new WeakReference<>(aVar);
        }
        this.f210613a = weakReference;
    }

    public synchronized boolean l() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f210616d != null && this.f210615c <= -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }
}
