package com.tencent.localedit.fakenative.localserver;

import com.tencent.local_edit.andserver.http.HttpMethod;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class m extends n11.c {

    /* renamed from: e, reason: collision with root package name */
    private Object f119927e;

    public m(Object obj, o11.b bVar, o11.a aVar, m11.a aVar2) {
        super(obj, bVar, aVar, aVar2);
        this.f119927e = obj;
    }

    @Override // n11.c
    protected p11.c h(com.tencent.local_edit.andserver.http.b bVar, com.tencent.local_edit.andserver.http.c cVar) throws Throwable {
        String path = bVar.getPath();
        HttpMethod method = bVar.getMethod();
        Object attribute = bVar.getAttribute("http.message.converter");
        if (attribute != null && (attribute instanceof k11.e)) {
        }
        if (bVar instanceof com.tencent.local_edit.andserver.http.multipart.c) {
        }
        if (method.allowBody()) {
            bVar.getBody();
        }
        f(path);
        return new p11.b(true, ((LocalServerRequestProxy) this.f119927e).uploadImage(bVar));
    }
}
