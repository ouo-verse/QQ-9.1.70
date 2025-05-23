package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f94011a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class a<Request extends com.tencent.biz.qqstory.channel.c, Respond extends com.tencent.biz.qqstory.channel.a> implements c.a<Respond> {

        /* renamed from: a, reason: collision with root package name */
        public Request f94012a;

        /* renamed from: b, reason: collision with root package name */
        protected final long f94013b = System.currentTimeMillis();

        /* renamed from: c, reason: collision with root package name */
        protected InterfaceC0941b<Request, Respond> f94014c;

        public a(Request request) {
            this.f94012a = request;
        }

        private void b(int i3, String str, Respond respond) {
            InterfaceC0941b<Request, Respond> interfaceC0941b = this.f94014c;
            if (interfaceC0941b != null) {
                interfaceC0941b.v(this.f94012a, respond, new ErrorMessage(i3, str));
            } else {
                hd0.c.t("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
            }
        }

        @Override // com.tencent.biz.qqstory.channel.c.a
        public void a(int i3, String str, Respond respond) {
            b(i3, str, respond);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqstory.channel.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0941b<Request extends com.tencent.biz.qqstory.channel.c, Respond extends com.tencent.biz.qqstory.channel.a> {
        void v(@NonNull Request request, @Nullable Respond respond, @NonNull ErrorMessage errorMessage);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class c<Request extends com.tencent.biz.qqstory.channel.c, Respond extends com.tencent.biz.qqstory.channel.a> implements InterfaceC0941b<Request, Respond> {
    }

    b() {
    }

    public static b a() {
        b bVar = f94011a;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = f94011a;
                if (bVar == null) {
                    bVar = new b();
                    f94011a = bVar;
                }
            }
        }
        return bVar;
    }

    public <Request extends com.tencent.biz.qqstory.channel.c, Respond extends com.tencent.biz.qqstory.channel.a> void b(Request request, InterfaceC0941b<Request, Respond> interfaceC0941b) {
        a aVar = new a(request);
        aVar.f94014c = interfaceC0941b;
        aVar.f94012a.f(aVar);
        QQStoryContext.h().c().h(aVar.f94012a);
    }
}
