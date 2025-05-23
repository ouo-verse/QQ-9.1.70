package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.search.model.ab;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import on2.d;

/* compiled from: P */
@Deprecated
/* loaded from: classes18.dex */
public class MessageSearchEngine implements on2.b<ab> {

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f284792d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.mobileqq.app.fms.a f284793e;

    /* renamed from: f, reason: collision with root package name */
    public String f284794f;

    public MessageSearchEngine(QQAppInterface qQAppInterface) {
        this.f284792d = qQAppInterface;
        this.f284793e = (com.tencent.mobileqq.app.fms.a) qQAppInterface.getManager(QQManagerFactory.FULL_MESSAGE_SEARCH_MANAGER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ab> d(String str, FullMessageSearchResult fullMessageSearchResult) {
        ArrayList arrayList = new ArrayList();
        if (fullMessageSearchResult != null && fullMessageSearchResult.f195605a != null) {
            for (int i3 = 0; i3 < fullMessageSearchResult.f195605a.size(); i3++) {
                arrayList.add(new ab(this.f284792d, str, fullMessageSearchResult.f195605a.get(i3)));
            }
        }
        return arrayList;
    }

    @Override // on2.b
    public List<ab> a(pn2.a aVar) {
        FullMessageSearchResult d16;
        if (QLog.isColorLevel()) {
            QLog.d("MessageSearchEngine", 2, "========== search message use MessageSearchEngine");
        }
        this.f284794f = aVar.f426495a;
        Bundle bundle = aVar.f426496b;
        if (bundle != null && bundle.getBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", false)) {
            d16 = this.f284793e.e(this.f284794f);
        } else {
            d16 = this.f284793e.d(this.f284794f);
        }
        return d(this.f284794f, d16);
    }

    @Override // on2.b
    public void c(final pn2.a aVar, final d<ab> dVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchengine.MessageSearchEngine.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.search.searchengine.MessageSearchEngine$1$a */
            /* loaded from: classes18.dex */
            class a implements Observer {
                a() {
                }

                @Override // java.util.Observer
                public void update(Observable observable, Object obj) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    d dVar = dVar;
                    MessageSearchEngine messageSearchEngine = MessageSearchEngine.this;
                    dVar.onUpdate(messageSearchEngine.d(messageSearchEngine.f284794f, (FullMessageSearchResult) obj));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar2;
                if (dVar != null) {
                    aVar2 = new a();
                    MessageSearchEngine.this.f284793e.addObserver(aVar2);
                } else {
                    aVar2 = null;
                }
                List<ab> a16 = MessageSearchEngine.this.a(aVar);
                if (aVar2 != null) {
                    MessageSearchEngine.this.f284793e.deleteObserver(aVar2);
                }
                d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onFinish(a16, 1);
                }
            }
        }, 8, null, true);
    }

    @Override // on2.b
    public void cancel() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchengine.MessageSearchEngine.2
            @Override // java.lang.Runnable
            public void run() {
                MessageSearchEngine.this.f284793e.f();
            }
        }, 8, null, true);
    }

    @Override // on2.b
    public void pause() {
        final String str = this.f284794f;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchengine.MessageSearchEngine.3
            @Override // java.lang.Runnable
            public void run() {
                MessageSearchEngine.this.f284793e.c(str);
            }
        }, 8, null, true);
    }

    @Override // on2.b
    public void resume() {
        final String str = this.f284794f;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchengine.MessageSearchEngine.4
            @Override // java.lang.Runnable
            public void run() {
                MessageSearchEngine.this.f284793e.c(str);
            }
        }, 8, null, true);
    }

    @Override // on2.b
    public void destroy() {
    }

    @Override // on2.b
    public void init() {
    }
}
