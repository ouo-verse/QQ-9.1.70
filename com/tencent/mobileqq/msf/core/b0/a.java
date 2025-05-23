package com.tencent.mobileqq.msf.core.b0;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f247529b = "MSF.D.MMKV";

    /* renamed from: c, reason: collision with root package name */
    public static final int f247530c = 10;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, String> f247531d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, Object> f247532e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, com.tencent.mobileqq.msf.core.b0.b> f247533f;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f247534a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f247535a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12399);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f247535a = new a(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f247531d = new ConcurrentHashMap();
        f247532e = new ConcurrentHashMap();
        f247533f = new ConcurrentHashMap();
    }

    /* synthetic */ a(C8073a c8073a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8073a);
    }

    public static a b() {
        return b.f247535a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c(String str) {
        return new Object();
    }

    public MMKVOptionEntity a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f247534a : (MMKVOptionEntity) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f247534a = QMMKV.from(BaseApplication.getContext(), "msf_mmkv_file");
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public SharedPreferences a(@NonNull String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        }
        if (z16) {
            return QMMKV.fromSpAdapter(BaseApplication.getContext(), str, "msf_mmkv_file");
        }
        return a(str);
    }

    public SharedPreferences b(@NonNull String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? a(str, i3) : (SharedPreferences) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
    }

    public static Object b(String str) {
        Object obj;
        Object computeIfAbsent;
        if (Build.VERSION.SDK_INT >= 24) {
            computeIfAbsent = f247532e.computeIfAbsent(str, new Function() { // from class: com.tencent.mobileqq.msf.core.b0.k
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    Object c16;
                    c16 = a.c((String) obj2);
                    return c16;
                }
            });
            return computeIfAbsent;
        }
        Map<String, Object> map = f247532e;
        synchronized (map) {
            obj = map.get(str);
            if (obj == null) {
                obj = new Object();
                map.put(str, obj);
            }
        }
        return obj;
    }

    public SharedPreferences a(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? b(str, 4) : (SharedPreferences) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
    }

    private static SharedPreferences a(String str, int i3) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), str, "msf_mmkv_file");
        synchronized (b(str)) {
            Map<String, String> map = f247531d;
            if (map.containsKey(str)) {
                return new c(fromSpAdapter, str, "msf_mmkv_file", true);
            }
            if (fromSpAdapter.getBoolean(com.tencent.mobileqq.msf.core.b0.b.f247537d, false)) {
                map.put(str, str);
                return new c(fromSpAdapter, str, "msf_mmkv_file", true);
            }
            Map<String, ?> all = BaseApplication.getContext().getSharedPreferences(str, 0).getAll();
            if (all != null && !all.isEmpty()) {
                int i16 = fromSpAdapter.getInt(com.tencent.mobileqq.msf.core.b0.b.f247538e, 0);
                if (i16 > 10) {
                    QLog.d(f247529b, 1, "migrate " + str + " to msf_mmkv_file fail " + i16 + " times, use old sp");
                    return new c(BaseApplication.getContext().getSharedPreferences(str, i3), str, "msf_mmkv_file", false);
                }
                String processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
                if (!processName.equals(BaseApplication.getContext().getPackageName() + ":MSF")) {
                    QLog.d(f247529b, 1, "migrate " + str + " to msf_mmkv_file with " + processName + " is not allowed");
                    return new c(BaseApplication.getContext().getSharedPreferences(str, i3), str, "msf_mmkv_file", false);
                }
                Map<String, com.tencent.mobileqq.msf.core.b0.b> map2 = f247533f;
                if (map2.get(str) == null) {
                    com.tencent.mobileqq.msf.core.b0.b bVar = new com.tencent.mobileqq.msf.core.b0.b(str, "msf_mmkv_file");
                    map2.put(str, bVar);
                    q.a(bVar);
                }
                QLog.d(f247529b, 1, "sp has not migrate to mmkv\uff0cuse old sp: " + str);
                return new c(BaseApplication.getContext().getSharedPreferences(str, i3), str, "msf_mmkv_file", false);
            }
            QLog.d(f247529b, 1, "[getMMkvSp], SP: " + str + "is null, return MMKV");
            fromSpAdapter.edit().putBoolean(com.tencent.mobileqq.msf.core.b0.b.f247537d, true).apply();
            return new c(fromSpAdapter, str, "msf_mmkv_file", true);
        }
    }
}
