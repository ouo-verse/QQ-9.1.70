package com.tencent.ams.mosaic.jsengine;

import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.h;
import com.tencent.ams.mosaic.jsengine.component.Component;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0686a {
        void onFail(String str);

        void onSuccess(String str);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void onFail(JSFunction jSFunction);

        void onSuccess(JSFunction jSFunction, JSValue jSValue);
    }

    f.c c();

    void close();

    com.tencent.ams.mosaic.jsengine.b d();

    void e(f.c cVar);

    Class<? extends Component> f(String str);

    @NonNull
    h g();

    f.InterfaceC0685f getVideoLoader();

    void h(String str, Object obj);

    void i(@NonNull Runnable runnable, long j3);

    boolean isClosed();

    c j();

    void k(c cVar);

    JSContext l();

    void m(JSFunction jSFunction, Object[] objArr, b bVar);

    void n(String str, Object[] objArr, b bVar);

    void o(String str, Class<? extends Component> cls);

    void p(JSFunction jSFunction, Object[] objArr, b bVar);

    void q(f.InterfaceC0685f interfaceC0685f);

    void r(Object obj, String str, InterfaceC0686a interfaceC0686a);

    void s(String str, Object[] objArr, b bVar);

    Class<? extends Component> t(String str);

    void u(JSFunction jSFunction, Object[] objArr, b bVar);
}
