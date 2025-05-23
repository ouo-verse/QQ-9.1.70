package com.tencent.liteav.audio2;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.liteav.audio2.c;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.util.l;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e extends PhoneStateListener implements c.a {

    /* renamed from: c, reason: collision with root package name */
    static c f118853c;

    /* renamed from: d, reason: collision with root package name */
    Class<?> f118856d;

    /* renamed from: e, reason: collision with root package name */
    Object f118857e;

    /* renamed from: g, reason: collision with root package name */
    private b f118859g;

    /* renamed from: f, reason: collision with root package name */
    int f118858f = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f118861i = false;

    /* renamed from: a, reason: collision with root package name */
    TelephonyManager f118854a = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");

    /* renamed from: b, reason: collision with root package name */
    AudioManager f118855b = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");

    /* renamed from: h, reason: collision with root package name */
    private l f118860h = new l("PhoneStateManager");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<e> f118862a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(e eVar) {
            this.f118862a = new WeakReference<>(eVar);
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            b bVar;
            try {
                if ("onModeChanged".equals(method.getName())) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    e eVar = this.f118862a.get();
                    if (eVar != null && (bVar = eVar.f118859g) != null) {
                        if (intValue == 2) {
                            eVar.f118861i = true;
                            bVar.onInterruptedByPhoneCall();
                        } else if (eVar.f118861i) {
                            eVar.f118861i = false;
                            bVar.onResumedByPhoneCall();
                        }
                    }
                }
            } catch (Throwable th5) {
                Log.e("PhoneStateManager", "notify mode changed failed, " + th5.getMessage(), new Object[0]);
            }
            return obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        void onInterruptedByPhoneCall();

        void onResumedByPhoneCall();
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f118853c = new c();
        }
    }

    public e(b bVar) {
        this.f118859g = bVar;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i3, String str) {
        b bVar = this.f118859g;
        if (bVar == null || this.f118858f == i3) {
            return;
        }
        this.f118858f = i3;
        if (i3 == 2) {
            bVar.onInterruptedByPhoneCall();
        } else if (i3 == 0) {
            bVar.onResumedByPhoneCall();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        try {
            return applicationContext.checkPermission(DeviceInfoUtil.PERMISSION_READ_PHONE, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th5) {
            Log.e("PhoneStateManager", "check permission exception, " + th5.getMessage(), new Object[0]);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        if (Build.VERSION.SDK_INT >= 26 && f118853c != null) {
            Log.i("PhoneStateManager", "unregister audio playback callback.", new Object[0]);
            f118853c.f118851a = null;
        }
    }

    @Override // com.tencent.liteav.audio2.c.a
    public final void a() {
        this.f118860h.a(f.a(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        b bVar = eVar.f118859g;
        if (bVar == null) {
            return;
        }
        try {
            if (eVar.f118855b.getMode() == 2) {
                eVar.f118861i = true;
                bVar.onInterruptedByPhoneCall();
            } else if (eVar.f118861i) {
                eVar.f118861i = false;
                bVar.onResumedByPhoneCall();
            }
        } catch (Throwable th5) {
            Log.e("PhoneStateManager", "get Mode exception, " + th5.getMessage(), new Object[0]);
        }
    }
}
