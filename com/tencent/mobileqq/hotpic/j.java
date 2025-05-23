package com.tencent.mobileqq.hotpic;

import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j implements URLDrawable.DownloadListener {
    static IPatchRedirector $redirector_;
    volatile int C;
    private NTHotPicPageView D;

    /* renamed from: d, reason: collision with root package name */
    boolean f237015d;

    /* renamed from: e, reason: collision with root package name */
    int f237016e;

    /* renamed from: f, reason: collision with root package name */
    private Object f237017f;

    /* renamed from: h, reason: collision with root package name */
    private LinkedList<URLDrawable> f237018h;

    /* renamed from: i, reason: collision with root package name */
    SparseArray<URLDrawable> f237019i;

    /* renamed from: m, reason: collision with root package name */
    private Set<Integer> f237020m;

    public j(NTHotPicPageView nTHotPicPageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTHotPicPageView);
            return;
        }
        this.f237015d = false;
        this.f237016e = 1;
        this.f237017f = new Object();
        this.f237018h = new LinkedList<>();
        this.f237019i = new SparseArray<>();
        this.f237020m = new HashSet();
        this.C = 0;
        this.D = nTHotPicPageView;
        if (nTHotPicPageView.I == 0) {
            c(true);
        } else {
            c(false);
        }
    }

    private synchronized void b() {
        NTHotPicPageView nTHotPicPageView;
        synchronized (this.f237017f) {
            this.C--;
            while (true) {
                if (this.C >= this.f237016e || this.f237018h.size() <= 0) {
                    break;
                }
                URLDrawable removeFirst = this.f237018h.removeFirst();
                if (removeFirst.getStatus() != 1) {
                    if (removeFirst.getStatus() == 2) {
                        removeFirst.restartDownload();
                        this.C++;
                        if (QLog.isColorLevel()) {
                            QLog.i("HotPicManager.Panel.HotpicDownloadDispatcher", 2, "handlerNext,restartDownload, current " + this.C);
                        }
                    } else {
                        removeFirst.startDownload();
                        this.C++;
                    }
                }
            }
            if (this.C == 0 && this.f237018h.size() == 0 && (nTHotPicPageView = this.D) != null && this.f237015d) {
                nTHotPicPageView.n();
            }
        }
    }

    public synchronized void a(URLDrawable uRLDrawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable, i3);
            return;
        }
        synchronized (this.f237017f) {
            if (this.f237020m.contains(Integer.valueOf(i3))) {
                return;
            }
            this.f237020m.add(Integer.valueOf(i3));
            uRLDrawable.setDownloadListener(this);
            if (this.C >= this.f237016e) {
                if (!this.f237018h.contains(uRLDrawable)) {
                    uRLDrawable.setAutoDownload(false);
                    this.f237018h.addFirst(uRLDrawable);
                    if (this.f237018h.size() > 15) {
                        URLDrawable removeLast = this.f237018h.removeLast();
                        removeLast.setAutoDownload(true);
                        removeLast.setDownloadListener(null);
                    }
                }
            } else {
                if (uRLDrawable.getStatus() == 2) {
                    uRLDrawable.restartDownload();
                }
                this.C++;
            }
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else if (z16) {
            this.f237015d = true;
            this.f237016e = 3;
        } else {
            this.f237015d = false;
            this.f237016e = 1;
        }
    }

    public void d(int i3, URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) uRLDrawable);
            return;
        }
        this.f237019i.put(i3, uRLDrawable);
        uRLDrawable.startDownload();
        a(uRLDrawable, i3);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        synchronized (this.f237017f) {
            Iterator<URLDrawable> it = this.f237018h.iterator();
            while (it.hasNext()) {
                it.next().setDownloadListener(null);
            }
            this.f237018h.clear();
            for (int i3 = 0; i3 < this.f237019i.size(); i3++) {
                this.f237019i.valueAt(0).setDownloadListener(null);
            }
        }
    }

    @Override // com.tencent.image.URLDrawable.DownloadListener
    public void onFileDownloadFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f237019i.remove(i3);
        this.f237020m.remove(Integer.valueOf(i3));
        b();
    }

    @Override // com.tencent.image.URLDrawable.DownloadListener
    public void onFileDownloadStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.image.URLDrawable.DownloadListener
    public void onFileDownloadSucceed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        int i3 = (int) j3;
        this.f237019i.remove(i3);
        this.f237020m.remove(Integer.valueOf(i3));
        this.D.m(i3);
        b();
    }
}
