package com.tencent.qqnt.http.download;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/http/download/f;", "Lokhttp3/Interceptor;", "Lokhttp3/Request;", Const.BUNDLE_KEY_REQUEST, "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "a", "intercept", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f implements Interceptor {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Response a(Request request, Interceptor.Chain chain) {
        try {
            return chain.proceed(request);
        } catch (IOException e16) {
            throw e16;
        } catch (Throwable th5) {
            throw new IOException(th5.getMessage());
        }
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        int lastIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Response) iPatchRedirector.redirect((short) 2, (Object) this, (Object) chain);
        }
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        com.tencent.qqnt.http.api.b bVar = (com.tencent.qqnt.http.api.b) request.tag(com.tencent.qqnt.http.api.b.class);
        if (bVar == null) {
            return a(request, chain);
        }
        ArrayList arrayList = new ArrayList();
        if (bVar.t()) {
            arrayList.add(new b());
        }
        arrayList.add(new c());
        if (arrayList.isEmpty()) {
            return a(request, chain);
        }
        Request.Builder newBuilder = request.newBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((e) it.next()).b(bVar, request, newBuilder);
        }
        Response a16 = a(newBuilder.build(), chain);
        Response.Builder newBuilder2 = a16.newBuilder();
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        if (lastIndex >= 0) {
            while (true) {
                int i3 = lastIndex - 1;
                ((e) arrayList.get(lastIndex)).a(bVar, a16, newBuilder2);
                if (i3 < 0) {
                    break;
                }
                lastIndex = i3;
            }
        }
        return newBuilder2.build();
    }
}
