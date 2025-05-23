package com.tencent.luggage.wxa.nd;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import rx.Observable;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f135624a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.nd.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6509a implements Observable.OnSubscribe {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.pd.b f135625a;

        public C6509a(com.tencent.luggage.wxa.pd.b bVar) {
            this.f135625a = bVar;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Subscriber subscriber) {
            String a16 = this.f135625a.a("LOCATION");
            if (TextUtils.isEmpty(a16)) {
                Log.e("DlnaRepositoryImpl", "mDevice location is empty");
                subscriber.onError(new Throwable("mDevice location is empty"));
                return;
            }
            try {
                URL url = new URL(a16);
                com.tencent.luggage.wxa.md.b b16 = m.a().b(url.openStream());
                if (b16 != null) {
                    b16.f134421a = a16;
                    b16.f134422b = url.getHost();
                    b16.f134423c = url.getPort();
                }
                subscriber.onNext(b16);
                subscriber.onCompleted();
            } catch (IOException e16) {
                subscriber.onError(e16.getCause());
                com.tencent.luggage.wxa.kd.a.a("DlnaRepositoryImpl", e16, "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Observable.OnSubscribe {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ld.d f135627a;

        public b(com.tencent.luggage.wxa.ld.d dVar) {
            this.f135627a = dVar;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Subscriber subscriber) {
            try {
                l.a().a(this.f135627a);
                subscriber.onCompleted();
            } catch (IOException e16) {
                subscriber.onError(e16.getCause());
                com.tencent.luggage.wxa.kd.a.a("DlnaRepositoryImpl", e16, "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Observable.OnSubscribe {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ld.e f135629a;

        public c(com.tencent.luggage.wxa.ld.e eVar) {
            this.f135629a = eVar;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Subscriber subscriber) {
            try {
                subscriber.onNext(l.c().a(this.f135629a));
                subscriber.onCompleted();
            } catch (IOException e16) {
                Throwable cause = e16.getCause();
                if (cause == null) {
                    cause = new Throwable("Error msg: " + e16.toString());
                }
                subscriber.onError(cause);
                com.tencent.luggage.wxa.kd.a.a("DlnaRepositoryImpl", e16, "");
            }
        }
    }

    public static a a() {
        if (f135624a == null) {
            synchronized (a.class) {
                if (f135624a == null) {
                    f135624a = new a();
                }
            }
        }
        return f135624a;
    }

    public Observable a(com.tencent.luggage.wxa.pd.b bVar) {
        return Observable.create(new C6509a(bVar));
    }

    public Observable a(com.tencent.luggage.wxa.ld.d dVar) {
        return Observable.create(new b(dVar));
    }

    public Observable a(com.tencent.luggage.wxa.ld.e eVar) {
        return Observable.create(new c(eVar));
    }
}
