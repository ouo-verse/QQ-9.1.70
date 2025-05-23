package com.tencent.mobileqq.emotionintegrate;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionDownGIFCallback implements com.tencent.mobileqq.pic.ac, com.tencent.mobileqq.pic.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Handler f205157d;

    /* renamed from: e, reason: collision with root package name */
    private MessageForPic f205158e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<a> f205159f;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void d2(boolean z16, MessageForPic messageForPic);

        void nf(int i3, MessageForPic messageForPic);
    }

    public EmotionDownGIFCallback(MessageForPic messageForPic, Handler handler, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, messageForPic, handler, aVar);
            return;
        }
        this.f205158e = messageForPic;
        this.f205157d = handler;
        this.f205159f = new WeakReference<>(aVar);
    }

    @Override // com.tencent.mobileqq.pic.c
    public void a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.f205157d.post(new Runnable(i3) { // from class: com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f205161d;

                {
                    this.f205161d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionDownGIFCallback.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("EmotionDownGIFCallback", 2, "onDownloadProgress:", Integer.valueOf(this.f205161d));
                    }
                    if (EmotionDownGIFCallback.this.f205159f.get() != 0) {
                        ((a) EmotionDownGIFCallback.this.f205159f.get()).nf(this.f205161d, EmotionDownGIFCallback.this.f205158e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.pic.ac
    public void b(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmotionDownGIFCallback", 2, "onUpdateProgress:", i3 + " needRefresh:" + z16, " picMr:", Long.valueOf(this.f205158e.uniseq));
        }
        if (this.f205159f.get() != null) {
            this.f205159f.get().nf(i3, this.f205158e);
        }
    }

    @Override // com.tencent.mobileqq.pic.ac
    public void c(int i3, com.tencent.mobileqq.pic.q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) qVar);
        }
    }

    @Override // com.tencent.mobileqq.pic.ac
    public void d(int i3, com.tencent.mobileqq.pic.q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) qVar);
        }
    }

    @Override // com.tencent.mobileqq.pic.ac
    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.pic.ac
    public void f(int i3, com.tencent.mobileqq.pic.q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) qVar);
        }
    }

    @Override // com.tencent.mobileqq.pic.ac
    public void g(int i3, com.tencent.mobileqq.pic.q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) qVar);
            return;
        }
        if (this.f205159f.get() == null) {
            QLog.d("EmotionDownGIFCallback", 1, "onDownload fail, callback is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmotionDownGIFCallback", 2, "onDownload ", Integer.valueOf(qVar.f258790a));
        }
        int i16 = qVar.f258790a;
        if (i16 == 0) {
            this.f205159f.get().d2(true, this.f205158e);
        } else if (-1 == i16) {
            m.a aVar = qVar.f258791b;
            if (aVar != null) {
                QLog.d("EmotionDownGIFCallback", 1, "onDownloadFail errDec:", aVar.f258737b);
            }
            this.f205159f.get().d2(false, this.f205158e);
        }
    }

    @Override // com.tencent.mobileqq.pic.c
    public void h(c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f205157d.post(new Runnable(aVar) { // from class: com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ c.a f205160d;

                {
                    this.f205160d = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionDownGIFCallback.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("EmotionDownGIFCallback", 1, "onDownload");
                    }
                    c.a aVar2 = this.f205160d;
                    if (aVar2 != null && aVar2.f258658e != null) {
                        com.tencent.mobileqq.pic.q qVar = new com.tencent.mobileqq.pic.q();
                        c.a aVar3 = this.f205160d;
                        int i3 = aVar3.f258654a;
                        qVar.f258790a = i3;
                        qVar.f258793d = aVar3;
                        qVar.f258794e = aVar3.f258663j;
                        if (i3 != 0) {
                            if (aVar3.f258657d == null) {
                                m.a aVar4 = new m.a();
                                aVar4.f258737b = this.f205160d.f258655b + "_" + this.f205160d.f258656c;
                                aVar4.f258736a = "onDownload";
                                this.f205160d.f258657d = aVar4;
                            }
                            qVar.f258791b = this.f205160d.f258657d;
                        }
                        EmotionDownGIFCallback.this.g(this.f205160d.f258654a, qVar);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.pic.ac
    public void i(int i3, ArrayList<com.tencent.mobileqq.pic.q> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) arrayList);
        }
    }
}
