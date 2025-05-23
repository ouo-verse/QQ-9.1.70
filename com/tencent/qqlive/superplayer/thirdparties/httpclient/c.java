package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import android.net.Uri;
import com.tencent.qqlive.superplayer.thirdparties.httpclient.HttpDataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements h {

    /* renamed from: a, reason: collision with root package name */
    private final HttpDataSource.b f345430a;

    public c(HttpDataSource.b bVar) {
        this.f345430a = bVar;
    }

    private static String b(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException) {
        List<String> list;
        Map<String, List<String>> map = invalidResponseCodeException.headerFields;
        if (map != null && (list = map.get("Location")) != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008a A[Catch: all -> 0x0071, TRY_LEAVE, TryCatch #0 {all -> 0x0071, blocks: (B:11:0x0061, B:19:0x0074, B:25:0x008a, B:29:0x0098, B:31:0x007e), top: B:18:0x0074, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092 A[LOOP:1: B:9:0x003f->B:27:0x0092, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k a(Request request) throws IOException {
        int i3;
        boolean z16;
        String str;
        HttpDataSource createDataSource = this.f345430a.createDataSource(request.l());
        if (request.i() != null) {
            for (Map.Entry<String, String> entry : request.i().entrySet()) {
                createDataSource.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        String n3 = request.n();
        int i16 = 0;
        while (true) {
            e eVar = new e(createDataSource, new DataSpec(Uri.parse(n3), request.j(), request.k(), 0L, 0L, -1L, null, 1));
            try {
                return k.c(n.b(eVar), createDataSource.getResponseHeaders());
            } catch (HttpDataSource.InvalidResponseCodeException e16) {
                try {
                    int i17 = e16.responseCode;
                    if (i17 == 307 || i17 == 308) {
                        i3 = i16 + 1;
                        if (i16 < 5) {
                            z16 = true;
                            if (!z16) {
                                str = b(e16);
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                n.a(eVar);
                                n3 = str;
                                i16 = i3;
                            } else {
                                throw e16;
                            }
                        } else {
                            i16 = i3;
                        }
                    }
                    i3 = i16;
                    z16 = false;
                    if (!z16) {
                    }
                    if (str == null) {
                    }
                } finally {
                    n.a(eVar);
                }
            }
        }
    }
}
