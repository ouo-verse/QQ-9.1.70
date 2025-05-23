package com.tencent.luggage.wxa.rd;

import rx.Observable;
import rx.schedulers.Schedulers;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Observable.Transformer f139594a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Observable.Transformer {
        public a() {
        }

        @Override // rx.functions.Func1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable call(Observable observable) {
            return observable.subscribeOn(Schedulers.io()).observeOn(com.tencent.luggage.wxa.rd.a.a());
        }
    }

    public Observable.Transformer a() {
        return this.f139594a;
    }
}
