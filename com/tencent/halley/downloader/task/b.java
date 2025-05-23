package com.tencent.halley.downloader.task;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    volatile DownloaderTaskStatus f113769a;

    /* renamed from: b, reason: collision with root package name */
    Vector<DownloaderTaskListener> f113770b;

    /* renamed from: c, reason: collision with root package name */
    Vector<DownloaderTaskListener> f113771c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f113772d;

    /* renamed from: e, reason: collision with root package name */
    public int f113773e;

    /* renamed from: f, reason: collision with root package name */
    c f113774f;

    /* renamed from: g, reason: collision with root package name */
    private LinkedBlockingQueue<a> f113775g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.task.b$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f113778a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f113779b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16284);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[a.values().length];
            f113779b = iArr;
            try {
                iArr[a.f113780a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f113779b[a.f113781b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f113779b[a.f113782c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f113779b[a.f113783d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f113779b[a.f113784e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f113779b[a.f113785f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f113779b[a.f113786g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f113779b[a.f113787h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[DownloaderTaskStatus.values().length];
            f113778a = iArr2;
            try {
                iArr2[DownloaderTaskStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f113778a[DownloaderTaskStatus.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f113778a[DownloaderTaskStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f113778a[DownloaderTaskStatus.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f113778a[DownloaderTaskStatus.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f113778a[DownloaderTaskStatus.PAUSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f113778a[DownloaderTaskStatus.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f113780a;

        /* renamed from: b, reason: collision with root package name */
        public static final a f113781b;

        /* renamed from: c, reason: collision with root package name */
        public static final a f113782c;

        /* renamed from: d, reason: collision with root package name */
        public static final a f113783d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f113784e;

        /* renamed from: f, reason: collision with root package name */
        public static final a f113785f;

        /* renamed from: g, reason: collision with root package name */
        public static final a f113786g;

        /* renamed from: h, reason: collision with root package name */
        public static final a f113787h;

        /* renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ a[] f113788i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16586);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            a aVar = new a("Inform_Pending", 0);
            f113780a = aVar;
            a aVar2 = new a("Inform_Started", 1);
            f113781b = aVar2;
            a aVar3 = new a("Inform_Detected", 2);
            f113782c = aVar3;
            a aVar4 = new a("Inform_Received", 3);
            f113783d = aVar4;
            a aVar5 = new a("Inform_Paused", 4);
            f113784e = aVar5;
            a aVar6 = new a("Inform_Failed", 5);
            f113785f = aVar6;
            a aVar7 = new a("Inform_Succeed", 6);
            f113786g = aVar7;
            a aVar8 = new a("Inform_Deleted", 7);
            f113787h = aVar8;
            f113788i = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8};
        }

        a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f113788i.clone();
        }
    }

    public b(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f113769a = DownloaderTaskStatus.PENDING;
        this.f113770b = new Vector<>();
        this.f113771c = new Vector<>();
        this.f113775g = new LinkedBlockingQueue<>();
        this.f113772d = false;
        this.f113773e = 0;
        this.f113774f = cVar;
    }

    private void c(a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            this.f113775g.put(aVar);
        } catch (InterruptedException e16) {
            d.c("halley-downloader-StatusInformer", "informOnSubLoop- " + aVar + ", exception", e16);
        }
    }

    public final synchronized void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f113775g.clear();
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0024. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        a aVar;
        Throwable th5;
        boolean z16;
        InterruptedException e16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        boolean z18 = true;
        this.f113772d = true;
        while (true) {
            try {
                aVar = this.f113775g.take();
            } catch (InterruptedException e17) {
                z16 = false;
                aVar = null;
                e16 = e17;
            } catch (Throwable th6) {
                aVar = null;
                th5 = th6;
            }
            try {
            } catch (InterruptedException e18) {
                e16 = e18;
                z16 = false;
                try {
                    d.c("halley-downloader-StatusInformer", "loopInform- " + aVar + ", exception", e16);
                    if (!z16) {
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    z18 = z16;
                    if (!z18) {
                        throw th5;
                    }
                    d.d("halley-downloader-StatusInformer", "loopInform finish on command:".concat(String.valueOf(aVar)));
                    this.f113772d = false;
                }
            } catch (Throwable th8) {
                th5 = th8;
                z18 = false;
                if (!z18) {
                }
                d.d("halley-downloader-StatusInformer", "loopInform finish on command:".concat(String.valueOf(aVar)));
                this.f113772d = false;
            }
            switch (AnonymousClass2.f113779b[aVar.ordinal()]) {
                case 1:
                    j.a().a(this.f113774f);
                    z17 = false;
                    if (z17) {
                        break;
                    }
                case 2:
                    j.a().onTaskStartedSubloop(this.f113774f);
                    synchronized (this.f113770b) {
                        Iterator<DownloaderTaskListener> it = this.f113770b.iterator();
                        while (it.hasNext()) {
                            DownloaderTaskListener next = it.next();
                            if (next != null) {
                                next.onTaskStartedSubloop(this.f113774f);
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                    break;
                case 3:
                    j.a().onTaskDetectedSubloop(this.f113774f);
                    synchronized (this.f113770b) {
                        Iterator<DownloaderTaskListener> it5 = this.f113770b.iterator();
                        while (it5.hasNext()) {
                            DownloaderTaskListener next2 = it5.next();
                            if (next2 != null) {
                                next2.onTaskDetectedSubloop(this.f113774f);
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                    break;
                case 4:
                    j.a().onTaskReceivedSubloop(this.f113774f);
                    synchronized (this.f113770b) {
                        Iterator<DownloaderTaskListener> it6 = this.f113770b.iterator();
                        while (it6.hasNext()) {
                            DownloaderTaskListener next3 = it6.next();
                            if (next3 != null) {
                                next3.onTaskReceivedSubloop(this.f113774f);
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                    break;
                case 5:
                    j.a().onTaskPausedSubloop(this.f113774f);
                    synchronized (this.f113770b) {
                        Iterator<DownloaderTaskListener> it7 = this.f113770b.iterator();
                        while (it7.hasNext()) {
                            DownloaderTaskListener next4 = it7.next();
                            if (next4 != null) {
                                next4.onTaskPausedSubloop(this.f113774f);
                            }
                        }
                    }
                    z17 = true;
                    if (z17) {
                    }
                    break;
                case 6:
                    j.a().onTaskFailedSubloop(this.f113774f);
                    synchronized (this.f113770b) {
                        Iterator<DownloaderTaskListener> it8 = this.f113770b.iterator();
                        while (it8.hasNext()) {
                            DownloaderTaskListener next5 = it8.next();
                            if (next5 != null) {
                                next5.onTaskFailedSubloop(this.f113774f);
                            }
                        }
                    }
                    z17 = true;
                    if (z17) {
                    }
                    break;
                case 7:
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        synchronized (this.f113770b) {
                            Iterator<DownloaderTaskListener> it9 = this.f113770b.iterator();
                            while (it9.hasNext()) {
                                DownloaderTaskListener next6 = it9.next();
                                if (next6 != null) {
                                    next6.onTaskCompletedSubloop(this.f113774f);
                                }
                            }
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        this.f113773e = (int) (elapsedRealtime2 - elapsedRealtime);
                        c cVar = this.f113774f;
                        if (cVar.f113811aj) {
                            String a16 = c.a(cVar.f113840o, cVar.f113842q);
                            if (!TextUtils.isEmpty(a16)) {
                                cVar.f113848w = a16;
                            }
                        }
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        d.b("halley-downloader-StatusInformer", "calcMd5 cost time:" + elapsedRealtime3 + ",file size:" + this.f113774f.getTotalLen());
                        this.f113774f.P = (int) elapsedRealtime3;
                        j.a().onTaskCompletedSubloop(this.f113774f);
                        z17 = true;
                        if (z17) {
                        }
                    } catch (InterruptedException e19) {
                        e16 = e19;
                        z16 = true;
                        d.c("halley-downloader-StatusInformer", "loopInform- " + aVar + ", exception", e16);
                        if (!z16) {
                            d.d("halley-downloader-StatusInformer", "loopInform finish on command:".concat(String.valueOf(aVar)));
                            this.f113772d = false;
                        }
                    } catch (Throwable th9) {
                        th5 = th9;
                        if (!z18) {
                        }
                        d.d("halley-downloader-StatusInformer", "loopInform finish on command:".concat(String.valueOf(aVar)));
                        this.f113772d = false;
                    }
                    break;
                case 8:
                    z17 = true;
                    if (z17) {
                    }
                    break;
                default:
                    z17 = false;
                    if (z17) {
                    }
                    break;
            }
        }
        d.d("halley-downloader-StatusInformer", "loopInform finish on command:".concat(String.valueOf(aVar)));
        this.f113772d = false;
    }

    private void b(a aVar) {
        if (aVar == null || aVar == a.f113787h) {
            return;
        }
        com.tencent.halley.common.a.f().post(new Runnable(aVar) { // from class: com.tencent.halley.downloader.task.b.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f113776a;

            {
                this.f113776a = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                switch (AnonymousClass2.f113779b[this.f113776a.ordinal()]) {
                    case 1:
                        b bVar = b.this;
                        j.a().onTaskPendingMainloop(bVar.f113774f);
                        synchronized (bVar.f113771c) {
                            Iterator<DownloaderTaskListener> it = bVar.f113771c.iterator();
                            while (it.hasNext()) {
                                DownloaderTaskListener next = it.next();
                                if (next != null) {
                                    next.onTaskPendingMainloop(bVar.f113774f);
                                }
                            }
                        }
                        return;
                    case 2:
                        b bVar2 = b.this;
                        j.a().onTaskStartedMainloop(bVar2.f113774f);
                        synchronized (bVar2.f113771c) {
                            Iterator<DownloaderTaskListener> it5 = bVar2.f113771c.iterator();
                            while (it5.hasNext()) {
                                DownloaderTaskListener next2 = it5.next();
                                if (next2 != null) {
                                    next2.onTaskStartedMainloop(bVar2.f113774f);
                                }
                            }
                        }
                        return;
                    case 3:
                        b bVar3 = b.this;
                        j.a().onTaskDetectedMainloop(bVar3.f113774f);
                        synchronized (bVar3.f113771c) {
                            Iterator<DownloaderTaskListener> it6 = bVar3.f113771c.iterator();
                            while (it6.hasNext()) {
                                DownloaderTaskListener next3 = it6.next();
                                if (next3 != null) {
                                    next3.onTaskDetectedMainloop(bVar3.f113774f);
                                }
                            }
                        }
                        return;
                    case 4:
                        b bVar4 = b.this;
                        j.a().onTaskReceivedMainloop(bVar4.f113774f);
                        synchronized (bVar4.f113771c) {
                            Iterator<DownloaderTaskListener> it7 = bVar4.f113771c.iterator();
                            while (it7.hasNext()) {
                                DownloaderTaskListener next4 = it7.next();
                                if (next4 != null) {
                                    next4.onTaskReceivedMainloop(bVar4.f113774f);
                                }
                            }
                        }
                        return;
                    case 5:
                        b bVar5 = b.this;
                        j.a().onTaskPausedMainloop(bVar5.f113774f);
                        synchronized (bVar5.f113771c) {
                            Iterator<DownloaderTaskListener> it8 = bVar5.f113771c.iterator();
                            while (it8.hasNext()) {
                                DownloaderTaskListener next5 = it8.next();
                                if (next5 != null) {
                                    next5.onTaskPausedMainloop(bVar5.f113774f);
                                }
                            }
                        }
                        return;
                    case 6:
                        b bVar6 = b.this;
                        j.a().onTaskFailedMainloop(bVar6.f113774f);
                        synchronized (bVar6.f113771c) {
                            Iterator<DownloaderTaskListener> it9 = bVar6.f113771c.iterator();
                            while (it9.hasNext()) {
                                DownloaderTaskListener next6 = it9.next();
                                if (next6 != null) {
                                    next6.onTaskFailedMainloop(bVar6.f113774f);
                                }
                            }
                        }
                        return;
                    case 7:
                        b bVar7 = b.this;
                        d.a("halley-downloader-StatusInformer", "updateTaskStatus-COMPLETE-handleSucceedInformOnMain", true);
                        j.a().onTaskCompletedMainloop(bVar7.f113774f);
                        synchronized (bVar7.f113771c) {
                            Iterator<DownloaderTaskListener> it10 = bVar7.f113771c.iterator();
                            while (it10.hasNext()) {
                                DownloaderTaskListener next7 = it10.next();
                                if (next7 != null) {
                                    next7.onTaskCompletedMainloop(bVar7.f113774f);
                                }
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final void a(DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloaderTaskListener);
            return;
        }
        if (downloaderTaskListener == null) {
            return;
        }
        try {
            synchronized (this.f113770b) {
                if (!this.f113770b.contains(downloaderTaskListener)) {
                    this.f113770b.add(downloaderTaskListener);
                }
            }
            synchronized (this.f113771c) {
                if (!this.f113771c.contains(downloaderTaskListener)) {
                    this.f113771c.add(downloaderTaskListener);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final synchronized void a(DownloaderTaskStatus downloaderTaskStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloaderTaskStatus);
            return;
        }
        d.c("halley-downloader-StatusInformer", "updateTaskStatus:" + downloaderTaskStatus.name());
        a(downloaderTaskStatus, true);
    }

    public final synchronized void a(DownloaderTaskStatus downloaderTaskStatus, boolean z16) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, downloaderTaskStatus, Boolean.valueOf(z16));
            return;
        }
        if ((this.f113769a == DownloaderTaskStatus.COMPLETE || this.f113769a == DownloaderTaskStatus.FAILED || this.f113769a == DownloaderTaskStatus.PAUSED || this.f113769a == DownloaderTaskStatus.DELETED) && downloaderTaskStatus != DownloaderTaskStatus.PENDING) {
            return;
        }
        this.f113769a = downloaderTaskStatus;
        if (z16) {
            switch (AnonymousClass2.f113778a[downloaderTaskStatus.ordinal()]) {
                case 1:
                    aVar = a.f113780a;
                    break;
                case 2:
                    aVar = a.f113781b;
                    break;
                case 3:
                    aVar = a.f113783d;
                    break;
                case 4:
                    aVar = a.f113786g;
                    break;
                case 5:
                    aVar = a.f113785f;
                    break;
                case 6:
                    aVar = a.f113784e;
                    break;
                case 7:
                    aVar = a.f113787h;
                    break;
                default:
                    aVar = null;
                    break;
            }
            a(aVar);
        }
    }

    public final void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else if (aVar != null) {
            b(aVar);
            c(aVar);
        }
    }
}
