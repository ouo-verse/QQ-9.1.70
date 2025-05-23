package com.tencent.biz.richframework.ioc.callback;

import android.content.Context;
import android.view.View;

/* loaded from: classes5.dex */
public interface IocPromise<T> {
    IocPromise<T> done(OnPromiseResolved<T> onPromiseResolved);

    IocPromise<T> fail(OnPromiseRejected onPromiseRejected);

    IocPromise<T> originView(View view);

    void run();

    IocPromise<T> withGlobal(Context context);
}
