package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.SharedPreferences;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TabMMKVManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile TabMMKVManager f182340b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, WeakReference<SharedPreferences.OnSharedPreferenceChangeListener>> f182341a;

    TabMMKVManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        SharedPreferences c16 = c();
        boolean z16 = c16.getBoolean("mmkv_tab_sp_migrate", false);
        if (!z16) {
            QLog.d("TabMMKVManager", 1, "migrate tab sp to mmkv");
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), TabDataHelper.K_TAB_DATA_HELPER_SP, "common_mmkv_configurations");
            c16.edit().putBoolean("mmkv_tab_sp_migrate", true).commit();
        }
        this.f182341a = new HashMap();
        QLog.d("TabMMKVManager", 1, "isMigrate: " + z16);
    }

    public static TabMMKVManager d() {
        if (f182340b == null) {
            synchronized (TabMMKVManager.class) {
                if (f182340b == null) {
                    f182340b = new TabMMKVManager();
                }
            }
        }
        return f182340b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(SharedPreferences sharedPreferences, String str) {
        Iterator<Map.Entry<String, WeakReference<SharedPreferences.OnSharedPreferenceChangeListener>>> it = this.f182341a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, WeakReference<SharedPreferences.OnSharedPreferenceChangeListener>> next = it.next();
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = next.getValue().get();
            if (onSharedPreferenceChangeListener == null) {
                it.remove();
                QLog.d("TabMMKVManager", 1, "notifyDataChanged remove key:" + next.getKey());
            } else {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(sharedPreferences, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(@NonNull String str, @NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f182341a.put(str, new WeakReference<>(onSharedPreferenceChangeListener));
        QLog.d("TabMMKVManager", 1, "registerDataChangeListener key:" + str);
    }

    public SharedPreferences c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), TabDataHelper.K_TAB_DATA_HELPER_SP, "common_mmkv_configurations");
    }

    public void e(SharedPreferences sharedPreferences, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sharedPreferences, (Object) str);
            return;
        }
        if (this.f182341a == null) {
            QLog.d("TabMMKVManager", 1, "notifyDataChanged mDataChangeListeners is null");
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            f(sharedPreferences, str);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(sharedPreferences, str) { // from class: com.tencent.mobileqq.activity.framebusiness.controllerinject.TabMMKVManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SharedPreferences f182344d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f182345e;

                {
                    this.f182344d = sharedPreferences;
                    this.f182345e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TabMMKVManager.this, sharedPreferences, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TabMMKVManager.this.f(this.f182344d, this.f182345e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void g(@NonNull String str, @NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) onSharedPreferenceChangeListener);
            return;
        }
        if (this.f182341a == null) {
            QLog.d("TabMMKVManager", 1, "registerDataChangeListener mDataChangeListeners is null");
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            h(str, onSharedPreferenceChangeListener);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(str, onSharedPreferenceChangeListener) { // from class: com.tencent.mobileqq.activity.framebusiness.controllerinject.TabMMKVManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f182342d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ SharedPreferences.OnSharedPreferenceChangeListener f182343e;

                {
                    this.f182342d = str;
                    this.f182343e = onSharedPreferenceChangeListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TabMMKVManager.this, str, onSharedPreferenceChangeListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TabMMKVManager.this.h(this.f182342d, this.f182343e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
