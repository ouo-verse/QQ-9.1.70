package com.tencent.biz.pubaccount.weishi.net.common;

import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.weishi.net.WeishiIntent;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSServiceExecutor<T extends JceStruct> {

    /* renamed from: a, reason: collision with root package name */
    private g<T> f80929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.net.common.a<T, UniAttribute> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f80936a;

        a(b bVar) {
            this.f80936a = bVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(UniAttribute uniAttribute, int i3, String str, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            WSServiceExecutor.this.f(i3, str, this.f80936a);
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(T t16, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            WSServiceExecutor.this.g(t16, this.f80936a, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <E> void f(final int i3, final String str, final b<T, E> bVar) {
        x.f("[WSService][WSServiceExecutor]", "[callbackFailure]failCode:" + str + ", failMsg:" + str);
        if (bVar != null) {
            final j jVar = new j(i3, str);
            bVar.a(jVar);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.net.common.WSServiceExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    WSServiceExecutor.this.k(i3, str);
                    bVar.b(jVar);
                }
            });
        }
    }

    private <E> com.tencent.biz.pubaccount.weishi.net.common.a<T, UniAttribute> h(b<T, E> bVar) {
        return new a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f80929a.getTimeRecord().x();
        com.tencent.biz.pubaccount.weishi.report.g.d().q(this.f80929a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3, String str) {
        com.tencent.biz.pubaccount.weishi.report.g.d().s(this.f80929a, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <E> void i(b<T, E> bVar) {
        g<T> gVar = this.f80929a;
        if (gVar == null) {
            f(1000004, "request is null", bVar);
            return;
        }
        gVar.getTimeRecord().s();
        d dVar = new d(this.f80929a, h(bVar));
        try {
            WeishiIntent weishiIntent = new WeishiIntent(BaseApplication.getContext(), l.class);
            weishiIntent.setWithouLogin(true);
            weishiIntent.setObserver(dVar);
            weishiIntent.putExtra("timeout", this.f80929a.mTimeout);
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                runtime.startServlet(weishiIntent);
                x.j("[WSService][WSServiceExecutor]", "[execute]cmd=" + this.f80929a.getReqUniKey() + ", pkgId=" + this.f80929a.getRequestPkgId() + " submit to MSF, isLogin: " + runtime.isLogin());
            } else {
                x.f("[WSService][WSServiceExecutor]", "[execute]app is null");
                f(AECameraConstants.TRIBE_MAX_RATE, "AppRuntime is null", bVar);
            }
        } catch (Exception e16) {
            x.f("[WSService][WSServiceExecutor]", "[execute]occur exception. stack=" + e16.getLocalizedMessage());
            f(2000001, "occur exception", bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(g<T> gVar) {
        this.f80929a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <E> void g(T t16, final b<T, E> bVar, com.tencent.biz.pubaccount.weishi.net.d dVar) {
        if (bVar != null) {
            final E c16 = bVar.c(this.f80929a, t16, dVar);
            this.f80929a.getTimeRecord().y();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.net.common.WSServiceExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    if (WSServiceExecutor.this.f80929a.isReportPerformance()) {
                        WSServiceExecutor.this.j();
                    }
                    bVar.d(c16);
                }
            });
        }
    }
}
