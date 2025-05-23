package com.tencent.mobileqq.hotchat;

import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f236853a;

    /* renamed from: b, reason: collision with root package name */
    final LruCache<String, b> f236854b;

    /* renamed from: c, reason: collision with root package name */
    final ConcurrentHashMap<String, Object> f236855c;

    /* renamed from: d, reason: collision with root package name */
    final List<Object> f236856d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.hotchat.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C7919a extends LruCache<String, b> {
        static IPatchRedirector $redirector_;

        C7919a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bVar)).intValue();
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f236858a;

        /* renamed from: b, reason: collision with root package name */
        public String f236859b;

        /* renamed from: c, reason: collision with root package name */
        public int f236860c;

        /* renamed from: d, reason: collision with root package name */
        public long f236861d;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f236853a = qQAppInterface;
        this.f236855c = new ConcurrentHashMap<>(3);
        this.f236856d = new ArrayList();
        this.f236854b = new C7919a(20);
    }

    private b b(String str) {
        try {
            LruCache<String, b> lruCache = this.f236854b;
            if (lruCache == null) {
                return null;
            }
            return lruCache.get(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    private void c(String str, b bVar) {
        try {
            this.f236854b.put(str, bVar);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void a(String str, String str2, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (str != null && str.length() != 0) {
            b b16 = b(str);
            if (b16 != null && b16.f236861d <= j3) {
                b16.f236860c = i3;
                if (str2 != null && str2.length() > 0) {
                    b16.f236859b = str2;
                }
                b16.f236861d = j3;
                if (QLog.isDevelopLevel()) {
                    l.c("PttShow", "cacheGender_update", str, Integer.valueOf(i3), Long.valueOf(j3));
                    return;
                }
                return;
            }
            if (b16 == null) {
                b bVar = new b();
                bVar.f236858a = str;
                bVar.f236860c = i3;
                if (str2 != null && str2.length() > 0) {
                    bVar.f236859b = str2;
                }
                bVar.f236861d = j3;
                c(str, bVar);
                if (QLog.isDevelopLevel()) {
                    l.c("PttShow", "cacheGender_add", str, Integer.valueOf(i3), Long.valueOf(j3));
                }
            }
        }
    }
}
