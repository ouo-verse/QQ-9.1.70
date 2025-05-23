package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import com.dataline.mpfile.MpfileTaskRecord;
import com.dataline.util.m;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes11.dex */
public class MpfileTaskProxy extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    List<MpfileTaskRecord> f196515a;

    /* renamed from: com.tencent.mobileqq.app.proxy.MpfileTaskProxy$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f196519d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ContentValues f196520e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f196521f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String[] f196522h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ProxyListener f196523i;
        final /* synthetic */ MpfileTaskProxy this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.proxyManager.addMsgQueue(String.valueOf(0), 0, this.f196519d, this.f196520e, this.f196521f, this.f196522h, 1, this.f196523i);
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.app.proxy.MpfileTaskProxy$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f196524d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f196525e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String[] f196526f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ProxyListener f196527h;
        final /* synthetic */ MpfileTaskProxy this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.proxyManager.addMsgQueue(String.valueOf(0), 0, this.f196524d, this.f196525e, this.f196526f, 2, this.f196527h);
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.app.proxy.MpfileTaskProxy$4, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MpfileTaskRecord f196528d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f196529e;
        final /* synthetic */ MpfileTaskProxy this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.a(this.f196528d, null);
                this.f196529e.a();
            }
        }
    }

    public MpfileTaskProxy(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
        } else {
            this.f196515a = null;
        }
    }

    public void a(Entity entity, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entity, (Object) proxyListener);
            return;
        }
        m mVar = new m(false, false);
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            this.proxyManager.addMsgQueue(String.valueOf(0), 0, MpfileTaskRecord.tableName(), ((MpfileTaskRecord) entity).m42clone(), 0, proxyListener);
        } else {
            new Handler(mainLooper).post(new Runnable(entity, proxyListener, mVar) { // from class: com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Entity f196516d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ProxyListener f196517e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ m f196518f;

                {
                    this.f196516d = entity;
                    this.f196517e = proxyListener;
                    this.f196518f = mVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MpfileTaskProxy.this, entity, proxyListener, mVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MpfileTaskProxy.this.proxyManager.addMsgQueue(String.valueOf(0), 0, MpfileTaskRecord.tableName(), ((MpfileTaskRecord) this.f196516d).m42clone(), 0, this.f196517e);
                    this.f196518f.a();
                }
            });
            mVar.b(-1L);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
