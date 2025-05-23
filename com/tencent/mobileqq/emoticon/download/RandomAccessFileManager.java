package com.tencent.mobileqq.emoticon.download;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class RandomAccessFileManager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static RandomAccessFileManager f204775f;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f204776a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, a> f204777b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f204778c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f204779d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f204780e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class CloseThread implements Runnable {
        static IPatchRedirector $redirector_;

        CloseThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RandomAccessFileManager.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            while (true) {
                try {
                    LockMethodProxy.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                synchronized (RandomAccessFileManager.this.f204779d) {
                    if (RandomAccessFileManager.this.f204777b.isEmpty()) {
                        synchronized (RandomAccessFileManager.this.f204780e) {
                            RandomAccessFileManager.this.f204778c = null;
                        }
                        return;
                    }
                    String[] strArr = new String[RandomAccessFileManager.this.f204777b.size()];
                    Iterator it = RandomAccessFileManager.this.f204777b.keySet().iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        strArr[i3] = (String) it.next();
                        i3++;
                    }
                    for (int i16 = 0; i16 < i3; i16++) {
                        a aVar = (a) RandomAccessFileManager.this.f204777b.get(strArr[i16]);
                        a aVar2 = aVar.f204785e;
                        while (true) {
                            a aVar3 = aVar2.f204785e;
                            if (aVar2.f204782b == 0 && System.currentTimeMillis() - aVar2.f204786f > 1000) {
                                try {
                                    aVar2.f204781a.close();
                                    if (QLog.isColorLevel()) {
                                        QLog.d("AppleMojiHandler", 2, "file ", strArr[i16], "[", Long.valueOf(aVar2.f204783c), "]", " close by Thread:", Long.valueOf(Thread.currentThread().getId()));
                                    }
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                                RandomAccessFileManager randomAccessFileManager = RandomAccessFileManager.this;
                                randomAccessFileManager.k(aVar, aVar2, strArr[i16], randomAccessFileManager.f204777b);
                            }
                            if (aVar == aVar2) {
                                break;
                            } else {
                                aVar2 = aVar3;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RandomAccessFile f204781a;

        /* renamed from: b, reason: collision with root package name */
        public volatile int f204782b;

        /* renamed from: c, reason: collision with root package name */
        public long f204783c;

        /* renamed from: d, reason: collision with root package name */
        public a f204784d;

        /* renamed from: e, reason: collision with root package name */
        public a f204785e;

        /* renamed from: f, reason: collision with root package name */
        public long f204786f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RandomAccessFileManager.this);
                return;
            }
            this.f204782b = 0;
            this.f204783c = 0L;
            this.f204784d = null;
            this.f204785e = null;
            this.f204786f = 0L;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f204775f = new RandomAccessFileManager();
        }
    }

    public RandomAccessFileManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f204776a = new HashMap();
        this.f204777b = new HashMap();
        this.f204778c = null;
        this.f204779d = new byte[0];
        this.f204780e = new byte[0];
    }

    private void f(a aVar, String str, Map<String, a> map) {
        a aVar2 = map.get(str);
        if (aVar == null) {
            return;
        }
        if (aVar2 == null) {
            aVar.f204785e = aVar;
            aVar.f204784d = aVar;
            map.put(str, aVar);
        } else {
            aVar.f204784d = aVar2;
            aVar.f204785e = aVar2.f204785e;
            aVar2.f204785e.f204784d = aVar;
            aVar2.f204785e = aVar;
        }
    }

    private a h(String str, Map<String, a> map) {
        a aVar = map.get(str);
        boolean z16 = false;
        if (aVar != null) {
            a aVar2 = aVar;
            while (true) {
                if (aVar2.f204783c == Thread.currentThread().getId()) {
                    z16 = true;
                    break;
                }
                aVar2 = aVar2.f204784d;
                if (aVar2 == aVar) {
                    break;
                }
            }
            aVar = aVar2;
        }
        if (z16) {
            return aVar;
        }
        return null;
    }

    public static synchronized RandomAccessFileManager i() {
        RandomAccessFileManager randomAccessFileManager;
        synchronized (RandomAccessFileManager.class) {
            randomAccessFileManager = f204775f;
        }
        return randomAccessFileManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(a aVar, a aVar2, String str, Map<String, a> map) {
        if (aVar == null) {
            aVar = map.get(str);
        }
        if (aVar != null && aVar2 != null) {
            if (aVar2 == aVar) {
                a aVar3 = aVar.f204784d;
                if (aVar3 != aVar && aVar3 != null) {
                    map.put(str, aVar3);
                } else {
                    map.remove(str);
                }
            }
            a aVar4 = aVar2.f204785e;
            aVar4.f204784d = aVar2.f204784d;
            aVar2.f204784d.f204785e = aVar4;
            aVar2.f204784d = null;
            aVar2.f204785e = null;
        }
    }

    private void l(String str, a aVar) {
        aVar.f204786f = System.currentTimeMillis();
        synchronized (this.f204779d) {
            f(aVar, str, this.f204777b);
        }
        synchronized (this.f204780e) {
            if (this.f204778c == null) {
                CloseThread closeThread = new CloseThread();
                this.f204778c = closeThread;
                ThreadManagerV2.post(closeThread, 8, null, false);
            }
        }
    }

    public synchronized void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        a h16 = h(str, this.f204776a);
        if (h16 != null) {
            h16.f204782b--;
            if (h16.f204782b == 0) {
                k(null, h16, str, this.f204776a);
                l(str, h16);
            }
        }
    }

    public synchronized RandomAccessFile j(String str) throws FileNotFoundException {
        a h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RandomAccessFile) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        a h17 = h(str, this.f204776a);
        if (h17 == null) {
            synchronized (this.f204779d) {
                h16 = h(str, this.f204777b);
                if (h16 != null) {
                    k(null, h16, str, this.f204777b);
                }
            }
            if (h16 != null) {
                f(h16, str, this.f204776a);
            }
            h17 = h16;
        }
        if (h17 == null) {
            h17 = new a();
            h17.f204781a = new RandomAccessFile(str, "r");
            h17.f204783c = Thread.currentThread().getId();
            if (QLog.isColorLevel()) {
                QLog.d("AppleMojiHandler", 2, "open file:", str, " threadID:", Long.valueOf(h17.f204783c));
            }
            f(h17, str, this.f204776a);
        }
        h17.f204782b++;
        return h17.f204781a;
    }
}
