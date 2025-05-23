package com.tencent.mobileqq.pic;

import android.os.RemoteException;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes16.dex */
public class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private e f258876a;

    /* renamed from: b, reason: collision with root package name */
    public String f258877b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f258878c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f258879d;

    /* renamed from: e, reason: collision with root package name */
    public CompressInfo f258880e;

    /* renamed from: f, reason: collision with root package name */
    public int f258881f;

    /* renamed from: g, reason: collision with root package name */
    public int f258882g;

    public z(CompressInfo compressInfo, int i3, int i16, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, compressInfo, Integer.valueOf(i3), Integer.valueOf(i16), eVar);
            return;
        }
        this.f258878c = false;
        this.f258879d = false;
        this.f258881f = -1;
        this.f258876a = eVar;
        String c16 = c();
        this.f258877b = c16;
        this.f258880e = compressInfo;
        compressInfo.f258514d = c16;
        this.f258881f = i3;
        this.f258882g = i16;
    }

    public synchronized void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        f.b("PresendPicMgr", "PresendReq.cancel", "current PresendReq is " + this);
        this.f258878c = true;
        if (this.f258879d) {
            try {
                f.b("PresendPicMgr", "PresendReq.cancel", "call cancelUpload");
                this.f258876a.E1(this.f258877b, i3);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PresendPicMgr", 2, e16.getMessage(), e16);
                }
            }
        } else {
            f.b("PresendPicMgr", "PresendReq.cancel", "mIsUpload is false,no need to call cancelUpload");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f.b("PresendPicMgr", "PresendReq.compressAndUploadPic", "call start,current PresendReq is " + this);
        long nanoTime = System.nanoTime();
        if (this.f258878c) {
            f.b("PresendPicMgr", "compressAndUploadPic ", "PresendStatus: srcPah:" + this.f258880e.D + ",destPath:" + this.f258880e.H + ",uuid:" + this.f258877b + " ,canceled:true, peakCompress:false, peakUpload:false");
            return;
        }
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(this.f258880e);
        f.b("PresendPicMgr", "compressAndUploadPic ", "PresendStatus: srcPah:" + this.f258880e.D + ",destPath:" + this.f258880e.H + ",uuid:" + this.f258877b + ",canceled:false,peakCompress:true,peakUpload:false");
        long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Process peak,[#]compress, cost= ");
        sb5.append(nanoTime2);
        f.b("PresendPicMgr", "PresendReq.compressAndUploadPic", sb5.toString());
        d();
        f.b("PresendPicMgr", "PresendReq.compressAndUploadPic", "call end,current PresendReq is " + this);
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "__" + UUID.randomUUID().toString();
    }

    public synchronized void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        f.b("PresendPicMgr", "PresendReq.uploadPic", "current PresendReq is " + this);
        if (this.f258878c) {
            f.b("PresendPicMgr", "uploadPic ", "PresendStatus: srcPah:" + this.f258880e.D + ",destPath:" + this.f258880e.H + ",uuid:" + this.f258877b + " ,canceled:true, peakCompress:true, peakUpload:false");
            return;
        }
        CompressInfo compressInfo = this.f258880e;
        String str = compressInfo.H;
        if (str == null) {
            f.d("PresendPicMgr", "PresendReq.uploadPic", "mCompressInfo.destPath == null! ");
            return;
        }
        try {
            this.f258876a.M2(str, this.f258877b, compressInfo.Q, this.f258881f, this.f258882g);
            this.f258879d = true;
            f.b("PresendPicMgr", "uploadPic ", "PresendStatus: srcPah:" + this.f258880e.D + ",destPath:" + this.f258880e.H + ",uuid:" + this.f258877b + " ,canceled:false, peakCompress:true, peakUpload:true");
        } catch (RemoteException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PresendPicMgr", 2, e16.getMessage(), e16);
            }
        }
        f.b("PresendPicMgr", "PresendReq.uploadPic", "call end");
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "\nPresendReq\n|-localUUID:" + this.f258877b + "\n|-mIsCancel:" + this.f258878c + "\n|-mIsUpload:" + this.f258879d + "\n|-mCompressInfo:" + this.f258880e;
    }
}
