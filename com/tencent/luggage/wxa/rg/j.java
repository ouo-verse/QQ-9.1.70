package com.tencent.luggage.wxa.rg;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    public static volatile j f139673c;

    /* renamed from: b, reason: collision with root package name */
    public Set f139675b = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with root package name */
    public k f139674a = new k();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f139676a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f139677b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f139678c;

        public a(g gVar, long j3, h hVar, String str) {
            this.f139676a = gVar;
            this.f139677b = j3;
            this.f139678c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.a(this.f139676a.f139672b, this.f139677b, null, this.f139678c);
        }
    }

    public static void b() {
        if (f139673c == null) {
            synchronized (j.class) {
                if (f139673c == null) {
                    f139673c = new j();
                }
            }
        }
    }

    public boolean c(String str) {
        return this.f139674a.c(str);
    }

    public static j a() {
        if (f139673c != null) {
            return f139673c;
        }
        throw new IllegalStateException("Video SDK has not been initialized! Call init() first!");
    }

    public long a(String str) {
        return this.f139674a.a(str);
    }

    public void a(ArrayList arrayList, String str) {
        a(arrayList, 2, -1L, (h) null, str);
    }

    public String b(String str) {
        return this.f139674a.b(str);
    }

    public final void a(ArrayList arrayList, int i3, long j3, h hVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "preloadMediasAsync";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            boolean z16 = true;
            if (j3 == -1) {
                z16 = true ^ c(gVar.f139671a);
            } else if (j3 > 0) {
                long b16 = j3 - this.f139674a.a().b(com.tencent.luggage.wxa.tg.h.h(gVar.f139671a));
                com.tencent.luggage.wxa.tg.h.a(3, str, "preloadMediasAsync, remainingBytes2Cache " + b16 + ", url=" + gVar.f139671a);
                if (b16 <= 0) {
                    z16 = false;
                }
            }
            if (z16) {
                arrayList2.add(new a(gVar, j3, hVar, str));
            } else {
                if (hVar != null) {
                    hVar.b(gVar.f139671a);
                }
                com.tencent.luggage.wxa.tg.h.a(4, str, "preloadMediasAsync, url " + gVar.f139671a + " already cached, cacheMaxBytes=" + j3);
            }
        }
        if (arrayList2.size() > 0) {
            com.tencent.luggage.wxa.tg.m.a(arrayList2, i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c8, code lost:
    
        if (r35 == null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, long j3, h hVar, String str2) {
        long j16;
        long j17;
        long j18;
        com.tencent.luggage.wxa.qg.j jVar = new com.tencent.luggage.wxa.qg.j("com.tencent.mm.video", null, null);
        String str3 = "VideoManager/sendUrlRequest/" + str2;
        byte[] bArr = new byte[512];
        com.tencent.luggage.wxa.tg.h.a(4, str3, "sendUrlRequest start url=" + str);
        long j19 = -1;
        long j26 = 0;
        try {
            if (hVar != null) {
                try {
                    hVar.a(str);
                } catch (Exception e16) {
                    e = e16;
                    com.tencent.luggage.wxa.tg.h.a(4, str3, "sendUrlRequest fail with message" + e.getMessage());
                    try {
                        jVar.close();
                    } catch (Exception e17) {
                        com.tencent.luggage.wxa.tg.h.a(4, str3, "sendUrlRequest closeException" + e17);
                    }
                    if (hVar == null) {
                        j18 = j19;
                        j17 = j26;
                        hVar.b(str);
                        j16 = j18;
                        com.tencent.luggage.wxa.tg.h.a(4, str3, "sendUrlRequest totalLength=" + j16 + ", totalReadBytes=" + j17);
                        return;
                    }
                    j16 = j19;
                    j17 = j26;
                    com.tencent.luggage.wxa.tg.h.a(4, str3, "sendUrlRequest totalLength=" + j16 + ", totalReadBytes=" + j17);
                    return;
                }
            }
            jVar.a(new com.tencent.luggage.wxa.qg.g(Uri.parse(str), 0L, 0L, -1L, null, 0, null));
            j18 = jVar.c();
            j17 = 0;
            while (true) {
                try {
                    long read = jVar.read(bArr, 0, 512);
                    if (read == -1) {
                        break;
                    }
                    long j27 = j17 + read;
                    if (hVar != null) {
                        try {
                            hVar.a(str, j27, j3, j18);
                        } catch (Exception e18) {
                            e = e18;
                            j19 = j18;
                            j26 = j27;
                            com.tencent.luggage.wxa.tg.h.a(4, str3, "sendUrlRequest fail with message" + e.getMessage());
                            jVar.close();
                            if (hVar == null) {
                            }
                        }
                    }
                    if (j3 > 0 && j3 != -1 && j27 >= j3) {
                        j17 = j27;
                        break;
                    }
                    j17 = j27;
                } catch (Exception e19) {
                    e = e19;
                    j26 = j17;
                    j19 = j18;
                }
            }
            com.tencent.luggage.wxa.tg.h.a(4, str3, "sendUrlRequest finish, totalReadBytes=" + j17);
            try {
                jVar.close();
            } catch (Exception e26) {
                com.tencent.luggage.wxa.tg.h.a(4, str3, "sendUrlRequest closeException" + e26);
            }
        } finally {
        }
    }
}
