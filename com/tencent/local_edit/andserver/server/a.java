package com.tencent.local_edit.andserver.server;

import android.content.Context;
import com.tencent.local_edit.andserver.server.BasicServer;
import j11.c;
import j11.e;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import org.apache.httpcore.protocol.HttpRequestHandler;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends BasicServer<b> {

    /* renamed from: i, reason: collision with root package name */
    private Context f119868i;

    /* renamed from: j, reason: collision with root package name */
    private String f119869j;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b extends BasicServer.a<b, a> implements e.a<b, a> {

        /* renamed from: g, reason: collision with root package name */
        private Context f119870g;

        /* renamed from: h, reason: collision with root package name */
        private String f119871h;

        /* JADX WARN: Type inference failed for: r1v2, types: [j11.e$a, com.tencent.local_edit.andserver.server.a$b] */
        @Override // j11.e.a
        public /* bridge */ /* synthetic */ b a(int i3) {
            return (e.a) super.g(i3);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [j11.e$a, com.tencent.local_edit.andserver.server.a$b] */
        @Override // j11.e.a
        public /* bridge */ /* synthetic */ b b(InetAddress inetAddress) {
            return (e.a) super.e(inetAddress);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [j11.e$a, com.tencent.local_edit.andserver.server.a$b] */
        @Override // j11.e.a
        public /* bridge */ /* synthetic */ b c(int i3, TimeUnit timeUnit) {
            return (e.a) super.h(i3, timeUnit);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [j11.e$a, com.tencent.local_edit.andserver.server.a$b] */
        @Override // j11.e.a
        public /* bridge */ /* synthetic */ b d(e.b bVar) {
            return (e.a) super.f(bVar);
        }

        @Override // j11.e.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public a build() {
            return new a(this);
        }

        b(Context context, String str) {
            this.f119870g = context;
            this.f119871h = str;
        }
    }

    public static b e(Context context, String str) {
        return new b(context, str);
    }

    @Override // com.tencent.local_edit.andserver.server.BasicServer
    protected HttpRequestHandler d() {
        c cVar = new c(this.f119868i);
        try {
            new j11.b(this.f119868i).a(cVar, this.f119869j);
            return cVar;
        } catch (IllegalAccessException e16) {
            throw new RuntimeException(e16);
        } catch (InstantiationException e17) {
            throw new RuntimeException(e17);
        }
    }

    a(b bVar) {
        super(bVar);
        this.f119868i = bVar.f119870g;
        this.f119869j = bVar.f119871h;
    }
}
