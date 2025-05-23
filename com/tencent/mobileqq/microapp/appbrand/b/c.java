package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f245952a;

    /* renamed from: b, reason: collision with root package name */
    private static StringBuilder f245953b;

    /* renamed from: c, reason: collision with root package name */
    private static String f245954c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f245955d;

    /* renamed from: e, reason: collision with root package name */
    private static String f245956e;

    /* renamed from: f, reason: collision with root package name */
    private static a f245957f;

    /* renamed from: g, reason: collision with root package name */
    private static a f245958g;

    /* renamed from: h, reason: collision with root package name */
    private static RecyclablePool f245959h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile b f245960i;

    /* renamed from: j, reason: collision with root package name */
    private static String f245961j;

    /* renamed from: k, reason: collision with root package name */
    private static HashMap f245962k;

    /* renamed from: l, reason: collision with root package name */
    private static Map f245963l;

    /* renamed from: m, reason: collision with root package name */
    private static final String f245964m;

    /* renamed from: n, reason: collision with root package name */
    private static SimpleDateFormat f245965n;

    /* renamed from: o, reason: collision with root package name */
    private static SimpleDateFormat f245966o;

    /* renamed from: p, reason: collision with root package name */
    private static Map f245967p;

    /* renamed from: q, reason: collision with root package name */
    private static LinkedBlockingQueue f245968q;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends RecyclablePool.Recyclable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f245969a;

        /* renamed from: b, reason: collision with root package name */
        public int f245970b;

        /* renamed from: c, reason: collision with root package name */
        public int f245971c;

        /* renamed from: d, reason: collision with root package name */
        public String f245972d;

        /* renamed from: e, reason: collision with root package name */
        public String f245973e;

        /* renamed from: f, reason: collision with root package name */
        public Throwable f245974f;

        /* renamed from: g, reason: collision with root package name */
        public String f245975g;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.commonsdk.pool.RecyclablePool.Recyclable
        public void recycle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.recycle();
            this.f245969a = 0L;
            this.f245970b = 0;
            this.f245971c = 0;
            this.f245972d = "";
            this.f245973e = "";
            this.f245974f = null;
            this.f245975g = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b extends Handler {
        static IPatchRedirector $redirector_;

        /* synthetic */ b(Looper looper, d dVar) {
            this(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) looper, (Object) dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2 && !c.f245968q.isEmpty()) {
                    ThreadManagerV2.excute(new f(this), 64, null, false);
                    return;
                }
                return;
            }
            if (c.f245957f != null && c.f245959h != null) {
                ThreadManagerV2.excute(new e(this), 64, null, false);
            }
        }

        b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14725);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f245953b = new StringBuilder(10240);
        f245954c = "";
        f245955d = Process.myPid();
        f245956e = "";
        f245957f = null;
        f245958g = null;
        f245961j = "";
        f245962k = new HashMap();
        f245963l = new HashMap();
        f245964m = Environment.getExternalStorageDirectory().getPath() + "/miniApp/files/miniprogramLog/";
        f245965n = new SimpleDateFormat("yy.MM.dd.HH");
        f245966o = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        f245967p = new HashMap();
        f245968q = new LinkedBlockingQueue(256);
        new LruCache(5);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(String str, boolean z16) {
        f245962k.put(str, Boolean.valueOf(z16));
    }

    private static void g() {
        if (f245960i == null) {
            synchronized (c.class) {
                if (f245960i == null) {
                    f245960i = new b(ThreadManagerV2.getSubThreadLooper(), null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void h() {
        a aVar;
        a aVar2;
        BufferedWriter bufferedWriter;
        synchronized (c.class) {
            try {
                synchronized (f245956e) {
                    aVar = f245958g;
                    aVar2 = f245957f;
                    f245958g = null;
                    f245957f = null;
                }
            } finally {
                try {
                } finally {
                }
            }
            if (aVar2 == null) {
                return;
            }
            while (true) {
                long j3 = aVar2.f245969a;
                long j16 = f245952a;
                if (j3 >= j16 + 1000 || j3 < j16) {
                    f245954c = f245966o.format(Long.valueOf(j3));
                    long j17 = f245952a;
                    if (j3 >= j17 + 1000 && j3 < 2000 + j17) {
                        f245952a = j17 + 1000;
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(j3);
                        calendar.set(14, 0);
                        f245952a = calendar.getTimeInMillis();
                    }
                }
                String str = c(aVar2.f245975g) + d(f245965n.format(Long.valueOf(System.currentTimeMillis())));
                File file = new File(str);
                if (!file.exists()) {
                    FileUtils.createFile(str);
                    bufferedWriter = new BufferedWriter(new g(file, true), 8192);
                    bufferedWriter.write(f245954c + "|" + f245956e + "|D||QQ_Version: " + f245961j + "\r\n");
                } else {
                    bufferedWriter = (BufferedWriter) f245963l.get(str);
                    if (bufferedWriter == null) {
                        bufferedWriter = new BufferedWriter(new g(file, true), 8192);
                    }
                }
                StringBuilder sb5 = f245953b;
                StringBuilder delete = sb5.delete(0, sb5.length());
                delete.append(f245954c);
                delete.append(QbAddrData.DATA_SPLITER);
                delete.append(aVar2.f245969a);
                delete.append(aVar2.f245975g);
                delete.append('[');
                delete.append(f245955d);
                delete.append(']');
                delete.append(aVar2.f245970b);
                delete.append(QbAddrData.DATA_SPLITER);
                delete.append(QLog.getReportLevel(aVar2.f245971c));
                delete.append(QbAddrData.DATA_SPLITER);
                delete.append(aVar2.f245972d);
                delete.append(QbAddrData.DATA_SPLITER);
                delete.append(aVar2.f245973e);
                delete.append('\n');
                bufferedWriter.write(delete.toString());
                Throwable th5 = aVar2.f245974f;
                if (th5 != null) {
                    bufferedWriter.write(Log.getStackTraceString(th5));
                    bufferedWriter.write(10);
                }
                f245963l.put(str, bufferedWriter);
                a aVar3 = (a) aVar2.getNext();
                f245959h.recycle(aVar2);
                if (aVar2 == aVar) {
                    break;
                } else {
                    aVar2 = aVar3;
                }
            }
            i();
        }
    }

    private static void i() {
        for (BufferedWriter bufferedWriter : f245963l.values()) {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        f245963l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void j() {
        BufferedWriter bufferedWriter;
        synchronized (c.class) {
            while (!f245968q.isEmpty()) {
                try {
                    com.tencent.mobileqq.microapp.a.c cVar = (com.tencent.mobileqq.microapp.a.c) f245968q.poll();
                    if (cVar != null && !StringUtil.isEmpty(cVar.f245826g)) {
                        String str = cVar.f245826g;
                        File file = new File(str);
                        if (!file.exists()) {
                            FileUtils.createFile(str);
                            bufferedWriter = new BufferedWriter(new g(file, true), 8192);
                        } else {
                            bufferedWriter = (BufferedWriter) f245967p.get(str);
                            if (bufferedWriter == null) {
                                bufferedWriter = new BufferedWriter(new g(file, true), 8192);
                            }
                        }
                        bufferedWriter.write(cVar.f245827h);
                        f245967p.put(str, bufferedWriter);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }

    private static void k() {
        for (BufferedWriter bufferedWriter : f245967p.values()) {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        f245967p.clear();
    }

    public static Boolean a(String str) {
        return Boolean.valueOf(f245962k.get(str) != null && ((Boolean) f245962k.get(str)).booleanValue());
    }

    public static boolean b(String str) {
        return a(str).booleanValue() || QLog.isColorLevel();
    }

    public static String c(String str) {
        return f245964m + MD5.toMD5(str) + "/" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "/";
    }

    private static String d(String str) {
        return f245956e.replace(":", "_") + "." + str + ".log";
    }

    public static void a() {
        if (f245959h != null || BaseApplicationImpl.getApplication() == null) {
            return;
        }
        f245961j = AppSetting.d();
        BaseApplicationImpl.getApplication();
        i.a();
        f245956e = null;
        BaseApplicationImpl.getApplication().getPackageName();
        f245959h = new RecyclablePool(a.class, 512);
    }

    public static void b(String str, int i3, String str2, String str3, Throwable th5) {
        if (a(str2).booleanValue()) {
            a(str2, str, i3, str3, th5);
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, i3, str3, th5);
        }
    }

    public static void a(String str, int i3, String str2, Throwable th5, Object... objArr) {
        StringBuilder sb5 = new StringBuilder((objArr.length * 30) + (th5 == null ? 0 : 128));
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        a(str, i3, str2, sb5.toString(), th5);
    }

    public static void a(String str, int i3, String str2, String str3, Throwable th5) {
        if (a(str2).booleanValue()) {
            a(str2, str, i3, str3, th5);
        }
        if (QLog.isColorLevel()) {
            QLog.e(str, i3, str3, th5);
        }
    }

    public static void a(String str, int i3, String str2, String str3) {
        b(str, i3, str2, str3, null);
    }

    private static void a(String str, String str2, int i3, String str3, Throwable th5) {
        a aVar;
        if (f245959h == null || StringUtil.isEmpty(str) || (aVar = (a) f245959h.obtain(a.class)) == null) {
            return;
        }
        aVar.f245969a = System.currentTimeMillis();
        aVar.f245970b = Process.myTid();
        aVar.f245971c = i3;
        aVar.f245972d = str2;
        aVar.f245973e = str3;
        aVar.f245974f = th5;
        aVar.f245975g = str;
        synchronized (f245956e) {
            if (f245957f == null) {
                f245957f = aVar;
                f245958g = aVar;
            } else {
                f245958g.changeNext(aVar, true);
                f245958g = aVar;
            }
        }
        g();
        f245960i.removeMessages(1);
        f245960i.sendEmptyMessageDelayed(1, 1000L);
    }
}
