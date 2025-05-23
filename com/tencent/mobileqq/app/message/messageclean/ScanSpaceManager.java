package com.tencent.mobileqq.app.message.messageclean;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ScanSpaceManager implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public static final ArrayList<String> C;

    /* renamed from: d, reason: collision with root package name */
    public long f196104d;

    /* renamed from: e, reason: collision with root package name */
    public long f196105e;

    /* renamed from: f, reason: collision with root package name */
    public long f196106f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f196107h;

    /* renamed from: i, reason: collision with root package name */
    private ad f196108i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f196109m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class ScanSpaceTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class a implements com.tencent.mobileqq.app.message.filescan.c {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanSpaceTask.this);
                }
            }

            @Override // com.tencent.mobileqq.app.message.filescan.c
            public void a(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ScanSpaceManager.this.l(i3);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
            }
        }

        ScanSpaceTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanSpaceManager.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long totalInternalMemorySize = SdCardUtil.getTotalInternalMemorySize();
            long totalExternalMemorySize = SdCardUtil.getTotalExternalMemorySize(BaseApplicationImpl.getApplication());
            long availableInternalMemorySize = SdCardUtil.getAvailableInternalMemorySize();
            long availableExternalMemorySize = SdCardUtil.getAvailableExternalMemorySize(BaseApplicationImpl.getApplication());
            ScanSpaceManager scanSpaceManager = ScanSpaceManager.this;
            scanSpaceManager.f196104d = totalInternalMemorySize + totalExternalMemorySize;
            scanSpaceManager.f196106f = availableInternalMemorySize + availableExternalMemorySize;
            a aVar = new a();
            ScanSpaceManager.this.f196105e = StorageReport.k().o(aVar, 0, 98);
            long h16 = q.h(true);
            ScanSpaceManager.this.f196105e += h16;
            aVar.a(100);
            QLog.d("ScanSpaceManager", 1, "SpaceInfo total: " + ScanSpaceManager.this.f196104d + " ava: " + ScanSpaceManager.this.f196106f + " qq: " + ScanSpaceManager.this.f196105e + " qqApp: " + h16);
            QLog.d("ScanSpaceManager", 1, "SpaceInfo totalIner: " + totalInternalMemorySize + " totalExter: " + totalExternalMemorySize + " avaInter: " + availableInternalMemorySize + " avaExter: " + availableExternalMemorySize);
            ScanSpaceManager.this.f196107h = true;
            ScanSpaceManager.this.k();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            C = new ArrayList<>(2);
        }
    }

    public ScanSpaceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f196104d = 0L;
        this.f196105e = 0L;
        this.f196106f = 0L;
        this.f196107h = false;
        h();
        this.f196107h = false;
        this.f196109m = new Handler(Looper.getMainLooper(), this);
    }

    private void h() {
        String defaultRecvPath = lc1.b.a().getDefaultRecvPath();
        String otherRecvPath = lc1.b.a().getOtherRecvPath();
        ArrayList<String> arrayList = C;
        arrayList.clear();
        if (!TextUtils.isEmpty(defaultRecvPath)) {
            arrayList.add(defaultRecvPath);
            QLog.d("ScanSpaceManager", 2, " need scan file path1 = " + defaultRecvPath);
        }
        if (!TextUtils.isEmpty(otherRecvPath)) {
            arrayList.add(otherRecvPath);
            QLog.d("ScanSpaceManager", 2, " need scan file path2 = " + otherRecvPath);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScanSpaceManager", 2, " need scan file path1 = " + defaultRecvPath + " path2 = " + otherRecvPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Handler handler = this.f196109m;
        if (handler != null) {
            this.f196109m.sendMessageDelayed(handler.obtainMessage(2), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3) {
        Handler handler = this.f196109m;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.arg1 = i3;
            this.f196109m.sendMessage(obtainMessage);
        }
    }

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        if (this.f196107h) {
            return this.f196106f;
        }
        return 0L;
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        if (this.f196107h) {
            return (this.f196104d - this.f196105e) - this.f196106f;
        }
        return 0L;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.f196107h) {
            ad adVar = this.f196108i;
            if (adVar != null) {
                adVar.B0();
                this.f196108i.O1(0.0f);
            }
            StorageReport.p().post(new ScanSpaceTask());
        }
    }

    public long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        if (this.f196107h) {
            return this.f196104d;
        }
        return 0L;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2 && this.f196108i != null) {
                be beVar = new be();
                beVar.z(this.f196105e);
                beVar.u(this.f196106f);
                beVar.v(this.f196104d);
                this.f196108i.U0(beVar, false);
            }
        } else {
            ad adVar = this.f196108i;
            if (adVar != null) {
                adVar.O1(message.arg1);
            }
        }
        return false;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f196107h;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f196107h = false;
        StorageReport.s();
        C.clear();
        Handler handler = this.f196109m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f196109m = null;
        }
        this.f196108i = null;
    }

    public void m(ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) adVar);
        } else {
            this.f196108i = adVar;
        }
    }
}
