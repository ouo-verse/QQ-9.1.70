package com.tencent.mobileqq.ptt.preop;

import android.os.Handler;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.preop.a;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes16.dex */
public class PTTPreDownloadStrategy implements IPTTPreDownloader.a, Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f261257d;

    /* renamed from: e, reason: collision with root package name */
    private a f261258e;

    /* renamed from: f, reason: collision with root package name */
    private a f261259f;

    /* renamed from: h, reason: collision with root package name */
    private a f261260h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<AppRuntime> f261261i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f261262m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final a.C8274a f261263a;

        /* renamed from: b, reason: collision with root package name */
        public int f261264b;

        /* renamed from: c, reason: collision with root package name */
        public int f261265c;

        /* renamed from: d, reason: collision with root package name */
        public int f261266d;

        /* renamed from: e, reason: collision with root package name */
        public int f261267e;

        /* renamed from: f, reason: collision with root package name */
        public int f261268f;

        public a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
                return;
            }
            a.C8274a c8274a = new a.C8274a();
            this.f261263a = c8274a;
            this.f261264b = i3;
            c8274a.f261271a = Integer.MIN_VALUE;
        }
    }

    public PTTPreDownloadStrategy(AppRuntime appRuntime, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
            return;
        }
        this.f261258e = new a(1);
        this.f261259f = new a(3);
        this.f261260h = new a(2);
        this.f261261i = new WeakReference<>(appRuntime);
        this.f261262m = handler;
        this.f261257d = false;
    }

    private long d(MessageForPtt messageForPtt) {
        int i3;
        int i16;
        long j3 = messageForPtt.fileSize;
        if (j3 <= 0) {
            int i17 = messageForPtt.voiceType;
            if (i17 == 1) {
                int i18 = messageForPtt.voiceLength;
                if (i18 <= 0) {
                    return 10240L;
                }
                i16 = i18 * 1200;
            } else {
                if (i17 != 0 || (i3 = messageForPtt.voiceLength) <= 0) {
                    return 4096L;
                }
                i16 = i3 * 700;
            }
            return i16;
        }
        return j3;
    }

    private void e(a aVar) {
        long j3;
        if (aVar.f261263a.f261271a == Integer.MIN_VALUE) {
            if (QLog.isDevelopLevel()) {
                QLog.d("PTTPreDownloadStrategy", 4, "initStrategyInfoIfNeccessary");
            }
            Date date = new Date();
            AppRuntime appRuntime = this.f261261i.get();
            a.C8274a a16 = com.tencent.mobileqq.ptt.preop.a.a(appRuntime, aVar.f261264b);
            a.C8274a c8274a = aVar.f261263a;
            int i3 = a16.f261271a;
            c8274a.f261271a = i3;
            if (i3 > 0) {
                a.C8274a c8274a2 = new a.C8274a();
                String d16 = com.tencent.mobileqq.ptt.preop.a.d(appRuntime, aVar.f261264b, c8274a2);
                String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(date);
                if (QLog.isDevelopLevel()) {
                    QLog.d("PTTPreDownloadStrategy", 4, "PreTime:" + d16 + " curTime:" + format);
                }
                if (format.equals(d16)) {
                    for (int i16 = 0; i16 <= 5; i16++) {
                        aVar.f261263a.f261272b[i16] = c8274a2.f261272b[i16];
                    }
                } else {
                    if (c8274a2.f261271a > -1) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(c8274a2.f261271a);
                        for (int i17 = 0; i17 <= 5; i17++) {
                            sb5.append('#');
                            sb5.append(i17);
                            sb5.append(util.base64_pad_url);
                            sb5.append(c8274a2.f261272b[i17]);
                        }
                        hashMap.put("RemainCfg", sb5.toString());
                        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttPreDownloadDailyRemain", true, 0L, 0L, hashMap, "");
                    }
                    for (int i18 = 0; i18 <= 5; i18++) {
                        aVar.f261263a.f261272b[i18] = a16.f261272b[i18];
                    }
                }
            }
            f(aVar);
            if (!this.f261257d) {
                long time = date.getTime();
                int hours = date.getHours();
                date.setHours(0);
                date.setMinutes(0);
                date.setSeconds(0);
                long time2 = date.getTime();
                if (hours < 0) {
                    j3 = 0;
                } else {
                    j3 = 86400000;
                }
                long j16 = j3 - (time - time2);
                if (QLog.isDevelopLevel()) {
                    long j17 = j16 / 1000;
                    QLog.d("PTTPreDownloadStrategy", 4, "Next reset time offset:" + (j17 / 60) + ":" + (j17 % 60));
                }
                this.f261257d = true;
                this.f261262m.postDelayed(this, j16);
            }
        }
    }

    private void f(a aVar) {
        String str = aVar.f261264b + ":" + aVar.f261263a;
        if (QLog.isDevelopLevel()) {
            QLog.d("PTTPreDownloadStrategy", 4, str);
        }
    }

    private void h() {
        if (QLog.isDevelopLevel()) {
            QLog.d("PTTPreDownloadStrategy", 4, "save");
        }
        AppRuntime appRuntime = this.f261261i.get();
        if (appRuntime == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        a aVar = this.f261258e;
        a.C8274a c8274a = aVar.f261263a;
        if (c8274a.f261271a != Integer.MIN_VALUE) {
            com.tencent.mobileqq.ptt.preop.a.h(appRuntime, c8274a, aVar.f261264b);
            f(this.f261258e);
            hashMap.put("C2CDownload", String.valueOf(this.f261258e.f261265c));
            hashMap.put("C2CView", String.valueOf(this.f261258e.f261267e));
            hashMap.put("C2CCancel", String.valueOf(this.f261258e.f261268f));
            hashMap.put("C2CEscape", String.valueOf(this.f261258e.f261266d));
        }
        a aVar2 = this.f261259f;
        a.C8274a c8274a2 = aVar2.f261263a;
        if (c8274a2.f261271a != Integer.MIN_VALUE) {
            com.tencent.mobileqq.ptt.preop.a.h(appRuntime, c8274a2, aVar2.f261264b);
            f(this.f261259f);
            f(this.f261258e);
            hashMap.put("GroupDownload", String.valueOf(this.f261259f.f261265c));
            hashMap.put("GroupView", String.valueOf(this.f261259f.f261267e));
            hashMap.put("GroupCancel", String.valueOf(this.f261259f.f261268f));
            hashMap.put("GroupEscape", String.valueOf(this.f261259f.f261266d));
        }
        a aVar3 = this.f261260h;
        a.C8274a c8274a3 = aVar3.f261263a;
        if (c8274a3.f261271a != Integer.MIN_VALUE) {
            com.tencent.mobileqq.ptt.preop.a.h(appRuntime, c8274a3, aVar3.f261264b);
            f(this.f261260h);
            hashMap.put("DiscussDownload", String.valueOf(this.f261260h.f261265c));
            hashMap.put("DiscussView", String.valueOf(this.f261260h.f261267e));
            hashMap.put("DiscussCancel", String.valueOf(this.f261260h.f261268f));
            hashMap.put("DiscussEscape", String.valueOf(this.f261260h.f261266d));
        }
        if (hashMap.size() > 0) {
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttPreDownloadPV", true, 0L, 0L, hashMap, "");
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader.a
    public boolean a(MessageForPtt messageForPtt) {
        a aVar;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        int i3 = messageForPtt.istroop;
        boolean z16 = true;
        if (i3 == 0) {
            aVar = this.f261258e;
        } else if (i3 == 1) {
            aVar = this.f261259f;
        } else if (i3 == 3000) {
            aVar = this.f261260h;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return false;
        }
        int netType = NetworkCenter.getInstance().getNetType();
        synchronized (aVar) {
            e(aVar);
            if (aVar.f261263a.f261271a > 0) {
                long j16 = messageForPtt.msgRecTime - messageForPtt.msgTime;
                if (j16 >= -10000 && j16 <= r4 * 24 * 60 * 60 * 100) {
                    long d16 = d(messageForPtt);
                    int[] iArr = aVar.f261263a.f261272b;
                    int i16 = iArr[netType];
                    if (d16 > i16) {
                        aVar.f261266d++;
                    } else {
                        aVar.f261265c++;
                        messageForPtt.estimatedSize = d16;
                        iArr[netType] = (int) (i16 - d16);
                        j3 = i16;
                    }
                }
            }
            j3 = 0;
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PTTPreDownloadStrategy", 4, "canDownload:" + z16 + " sesion:" + aVar.f261264b + " net:" + netType + " " + j3 + " - " + messageForPtt.estimatedSize + " = " + aVar.f261263a.f261272b[netType] + ", pttSize:" + messageForPtt.fileSize);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader.a
    public boolean b(MessageForPtt messageForPtt, int i3) {
        a aVar;
        boolean z16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPtt, i3)).booleanValue();
        }
        if (i3 == 2) {
            return true;
        }
        int i16 = messageForPtt.istroop;
        if (i16 == 0) {
            aVar = this.f261258e;
        } else if (i16 == 1) {
            aVar = this.f261259f;
        } else if (i16 == 3000) {
            aVar = this.f261260h;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            if ((messageForPtt.extFlag & 1) > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                int netType = NetworkCenter.getInstance().getNetType();
                synchronized (aVar) {
                    e(aVar);
                    j3 = aVar.f261263a.f261272b[netType];
                    long j16 = messageForPtt.fileSize + j3;
                    int i17 = com.tencent.mobileqq.ptt.preop.a.a(this.f261261i.get(), aVar.f261264b).f261272b[netType];
                    if (j16 > i17) {
                        aVar.f261263a.f261272b[netType] = i17;
                    } else {
                        aVar.f261263a.f261272b[netType] = (int) j16;
                    }
                }
                if (i3 == 1) {
                    aVar.f261267e++;
                } else if (i3 == 3) {
                    aVar.f261268f++;
                }
                if (!QLog.isDevelopLevel()) {
                    return true;
                }
                QLog.d("PTTPreDownloadStrategy", 4, "consume sesion:" + aVar.f261264b + " netType:" + netType + ", " + j3 + " + " + messageForPtt.fileSize + " = " + aVar.f261263a.f261272b[netType]);
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("PTTPreDownloadStrategy", 4, "consume sesion:" + aVar.f261264b + " not preDownload");
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader.a
    public boolean c(MessageForPtt messageForPtt) {
        a aVar;
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        if (messageForPtt.estimatedSize <= 0) {
            return false;
        }
        int i3 = messageForPtt.istroop;
        if (i3 == 0) {
            aVar = this.f261258e;
        } else if (i3 == 1) {
            aVar = this.f261259f;
        } else if (i3 == 3000) {
            aVar = this.f261260h;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return false;
        }
        int netType = NetworkCenter.getInstance().getNetType();
        synchronized (aVar) {
            int[] iArr = aVar.f261263a.f261272b;
            int i16 = iArr[netType];
            j3 = i16;
            j16 = messageForPtt.estimatedSize;
            iArr[netType] = i16 + ((int) (j16 - messageForPtt.fileSize));
            messageForPtt.estimatedSize = 0L;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PTTPreDownloadStrategy", 4, "fixEstimatedSize sesion:" + aVar.f261264b + " net:" + netType + ", " + j3 + " + " + j16 + " - " + messageForPtt.fileSize + " = " + aVar.f261263a.f261272b[netType] + ", PttSize:" + messageForPtt.fileSize);
        }
        return true;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f261258e = new a(1);
        this.f261259f = new a(3);
        this.f261260h = new a(2);
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PTTPreDownloadStrategy", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.f261262m.removeCallbacks(this);
        this.f261257d = false;
        h();
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PTTPreDownloadStrategy", 4, "reset");
        }
        this.f261262m.removeCallbacks(this);
        this.f261257d = false;
        g();
    }
}
