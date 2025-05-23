package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.util.BinderWarpper;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class PresendPicMgr {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    private static PresendPicMgr f258569l;

    /* renamed from: a, reason: collision with root package name */
    private final e f258570a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<z> f258571b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f258572c;

    /* renamed from: d, reason: collision with root package name */
    public x f258573d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f258574e;

    /* renamed from: f, reason: collision with root package name */
    Messenger f258575f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f258576g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f258577h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f258578i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f258579j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f258580k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class PresendRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private z f258581d;

        public PresendRunnable(z zVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PresendPicMgr.this, (Object) zVar);
            } else {
                this.f258581d = zVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            f.b("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.f258581d);
            this.f258581d.b();
        }
    }

    public PresendPicMgr(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
            return;
        }
        this.f258574e = true;
        this.f258576g = false;
        f.b("PresendPicMgr", "getInstance", "construct PresendPicMgr, service = " + eVar);
        this.f258570a = eVar;
        this.f258571b = new ArrayList<>();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("presend_worker_thread");
        this.f258572c = baseHandlerThread;
        baseHandlerThread.start();
        this.f258573d = new x(this.f258572c.getLooper(), this);
        try {
            boolean[] b46 = eVar.b4();
            if (b46 != null && b46.length >= 4) {
                this.f258577h = b46[0];
                this.f258578i = b46[1];
                this.f258579j = b46[2];
                this.f258580k = b46[3];
            }
            int[] P = eVar.P();
            if (P != null && P.length >= 9) {
                com.tencent.mobileqq.pic.compress.a.f258671d = P[0];
                com.tencent.mobileqq.pic.compress.a.f258672e = P[1];
                com.tencent.mobileqq.pic.compress.a.f258673f = P[2];
                com.tencent.mobileqq.pic.compress.a.f258674g = P[3];
                com.tencent.mobileqq.pic.compress.a.f258675h = P[4];
                com.tencent.mobileqq.pic.compress.a.f258676i = P[5];
                com.tencent.mobileqq.pic.compress.a.f258668a = P[6];
                com.tencent.mobileqq.pic.compress.a.f258669b = P[7];
                com.tencent.mobileqq.pic.compress.a.f258670c = P[8];
            }
            f.b("PresendPicMgr", "getInstance", "preCompressConfig = " + Arrays.toString(b46) + ",compressArgConfig = " + Arrays.toString(P));
            f.b("PresendPicMgr", "getInstance", "construct PresendPicMgr, mEnablePreCompress_WIFI = " + this.f258577h + ",mEnablePreCompress_2G = " + this.f258578i + ",mEnablePreCompress_3G = " + this.f258579j + ",mEnablePreCompress_4G = " + this.f258580k + ",PicType.MaxLongSide_Camera_C2C = " + com.tencent.mobileqq.pic.compress.a.f258671d + ",PicType.MaxLongSide_Camera_Grp = " + com.tencent.mobileqq.pic.compress.a.f258672e + ",PicType.MaxLongSide_Screenshot_C2C = " + com.tencent.mobileqq.pic.compress.a.f258673f + ",PicType.MaxLongSide_Screenshot_Grp = " + com.tencent.mobileqq.pic.compress.a.f258674g + ",PicType.MaxLongSide_Other_C2C = " + com.tencent.mobileqq.pic.compress.a.f258675h + ",PicType.MaxLongSide_Other_Grp = " + com.tencent.mobileqq.pic.compress.a.f258676i + ",PicType.SendPhotoWiFiPicQuality = " + com.tencent.mobileqq.pic.compress.a.f258668a + ",PicType.SendPhoto23GPicQuality = " + com.tencent.mobileqq.pic.compress.a.f258669b + ",PicType.SendPhoto4GPicQuality = " + com.tencent.mobileqq.pic.compress.a.f258670c);
        } catch (RemoteException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PresendPicMgr", 2, "getPreCompressConfig" + e16.getMessage(), e16);
            }
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork != 1) {
            if (systemNetwork != 2) {
                if (systemNetwork != 3) {
                    if (systemNetwork != 4) {
                        this.f258576g = true;
                    } else {
                        this.f258576g = this.f258580k;
                    }
                } else {
                    this.f258576g = this.f258579j;
                }
            } else {
                this.f258576g = this.f258578i;
            }
        } else {
            this.f258576g = this.f258577h;
        }
        f.b("PresendPicMgr", "getInstance", "construct PresendPicMgr, NetType = " + systemNetwork + ", mEnablePreCompress = " + this.f258576g);
    }

    private z e(String str) {
        f.b("PresendPicMgr", "findRequestByPath", "path = " + str);
        ArrayList<z> arrayList = this.f258571b;
        if (arrayList == null) {
            f.d("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
            return null;
        }
        if (arrayList.size() == 0) {
            f.d("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
            return null;
        }
        Iterator<z> it = this.f258571b.iterator();
        while (it.hasNext()) {
            z next = it.next();
            if (next.f258880e.D.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static PresendPicMgr f() {
        f.b("PresendPicMgr", "getInstance()", "mInstance = " + f258569l);
        return f258569l;
    }

    public static PresendPicMgr g(e eVar) {
        if (f258569l == null) {
            synchronized (PresendPicMgr.class) {
                if (f258569l == null && eVar != null) {
                    f258569l = new PresendPicMgr(eVar);
                }
            }
        }
        f.b("PresendPicMgr", "getInstance", "mInstance = " + f258569l + ", Ibinder = " + eVar);
        return f258569l;
    }

    public static PresendPicMgr i(e eVar) {
        if (f258569l != null) {
            f.b("PresendPicMgr", "newInstance()", "mInstance:" + f258569l + "is not null,reset mInstance!");
            f258569l = null;
        }
        synchronized (PresendPicMgr.class) {
            if (eVar != null) {
                f258569l = new PresendPicMgr(eVar);
            }
        }
        f.b("PresendPicMgr", "newInstance()", "mInstance = " + f258569l + ", Ibinder = " + eVar);
        return f258569l;
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (!this.f258576g) {
            f.b("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
            return;
        }
        f.b("PresendPicMgr", "cancelAll", "Start! cancelType = " + i3);
        for (int i16 = 0; i16 < this.f258571b.size(); i16++) {
            this.f258571b.get(i16).a(i3);
        }
        this.f258571b.clear();
        try {
            this.f258570a.p1(i3);
        } catch (RemoteException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PresendPicMgr", 2, e16.getMessage(), e16);
            }
        }
    }

    public void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        if (!this.f258576g) {
            f.b("PresendPicMgr", "cancelPresendPic", "mEnablePreCompress is false!");
            return;
        }
        f.b("PresendPicMgr", "cancelPresendPic", "path = " + str);
        z e16 = e(str);
        if (e16 == null) {
            f.b("PresendPicMgr", "cancelPresendPic", "cannot find PresendReq,path = " + str);
            return;
        }
        this.f258571b.remove(e16);
        e16.a(i3);
    }

    public void c(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        f.b("PresendPicMgr", "getCompossedIntent", "");
        if (!this.f258576g) {
            f.b("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
        } else {
            intent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.f258573d).getBinder()));
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        SharedPreferences u16 = PlusPanelUtils.u();
        u16.edit().putBoolean(PeakConstants.KEY_PRESEND_OFF_FLAG, true).commit();
        u16.edit().putLong(PeakConstants.KEY_PRESEND_OFF_TIME, System.currentTimeMillis()).commit();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        ArrayList<z> arrayList = this.f258571b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void j(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        } else {
            k(str, i3, 0);
        }
    }

    public void k(String str, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!this.f258576g) {
            f.b("PresendPicMgr", "presendPic", "mEnablePreCompress is false!");
            return;
        }
        f.b("PresendPicMgr", "presendPic", "path = " + str + ",busiType = " + i3);
        if (!TextUtils.isEmpty(str) && FileUtils.fileExistsAndNotEmpty(str)) {
            CompressInfo compressInfo = new CompressInfo(str, ((ICompressOperator) QRoute.api(ICompressOperator.class)).transformQuality(0), 1052);
            try {
                i17 = this.f258570a.getUinType();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PresendPicMgr", 2, e16.getMessage(), e16);
                }
                i17 = -1;
            }
            compressInfo.S = i17;
            compressInfo.T = true;
            f.b("PresendPicMgr", "presendPic", "uinType = " + i17);
            z zVar = new z(compressInfo, i3, i16, this.f258570a);
            this.f258571b.add(zVar);
            this.f258573d.post(new PresendRunnable(zVar));
            return;
        }
        f.d("PresendPicMgr", "presendPic", "path = " + str + " pic not exist,return!");
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        f.d("PresendPicMgr", "release", "");
        this.f258572c.quit();
        this.f258571b.clear();
        f258569l = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        try {
            this.f258570a.N();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PresendPicMgr", 2, e16.getMessage(), e16);
            }
        }
    }
}
