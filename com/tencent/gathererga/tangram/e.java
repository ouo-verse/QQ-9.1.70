package com.tencent.gathererga.tangram;

import android.content.Context;
import com.tencent.gathererga.tangram.internal.TangramServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface e {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public static e a(Context context, b bVar) {
            return TangramServiceImpl.l(context, bVar);
        }
    }

    Map<Integer, d> a();

    void b(ConcurrentHashMap<Integer, String> concurrentHashMap);

    void c();

    void d(ConcurrentHashMap<Integer, Object> concurrentHashMap);

    void e();

    void f(ConcurrentHashMap<Integer, c> concurrentHashMap);
}
