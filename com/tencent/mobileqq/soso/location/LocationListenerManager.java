package com.tencent.mobileqq.soso.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LocationListenerManager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final HashSet<String> f288700f;

    /* renamed from: g, reason: collision with root package name */
    private static final SimpleDateFormat f288701g;

    /* renamed from: a, reason: collision with root package name */
    private int f288702a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private Boolean f288703b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f288704c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private SosoLbsInfo f288705d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<SosoInterfaceOnLocationListener> f288706e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34617);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f288700f = new HashSet<>();
        f288701g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        d();
    }

    public LocationListenerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f288702a = 0;
        this.f288703b = null;
        this.f288704c = true;
        this.f288705d = null;
        this.f288706e = new ArrayList<>();
    }

    private static void d() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105956", "");
        if (!loadAsString.isEmpty()) {
            QLog.w("LocationListenerManager", 1, "receive blacklist: " + loadAsString);
        }
        String[] split = loadAsString.split(",");
        f288700f.add("pathtrace");
        for (String str : split) {
            if (!Objects.equals(str, "") && !f288700f.remove(str)) {
                QLog.e("LocationListenerManager", 1, "remove unknown id in whitelist: " + str);
            }
        }
    }

    private void g(@NonNull SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener, int i3, @Nullable SosoLbsInfo sosoLbsInfo) {
        if (sosoInterfaceOnLocationListener.uiThread) {
            ThreadManager.getUIHandler().post(new Runnable(sosoInterfaceOnLocationListener, i3, sosoLbsInfo) { // from class: com.tencent.mobileqq.soso.location.LocationListenerManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SosoInterfaceOnLocationListener f288707d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f288708e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ SosoLbsInfo f288709f;

                {
                    this.f288707d = sosoInterfaceOnLocationListener;
                    this.f288708e = i3;
                    this.f288709f = sosoLbsInfo;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, LocationListenerManager.this, sosoInterfaceOnLocationListener, Integer.valueOf(i3), sosoLbsInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.f288707d.onLocationFinish(this.f288708e, this.f288709f);
                    }
                }
            });
        } else {
            sosoInterfaceOnLocationListener.onLocationFinish(i3, sosoLbsInfo);
        }
    }

    private void h() {
        boolean z16;
        Boolean bool;
        if (1 != MobileQQ.sProcessId) {
            QLog.w("LocationListenerManager", 1, "[notifySdkIfNecessary] called in sub-process");
        }
        if (!this.f288704c && this.f288702a == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.d("LocationListenerManager", 1, "[notifySdkIfNecessary] shouldSdkForeground:" + z16 + ", listenerInWhitelistCounter:" + this.f288702a + ", isAppForeground:" + this.f288704c);
        if (!f288700f.isEmpty() && (bool = this.f288703b) != null && bool.booleanValue() == z16) {
            return;
        }
        this.f288703b = Boolean.valueOf(z16);
        QLog.d("LocationListenerManager", 1, "[notifySdkIfNecessary] do notify, foreground:" + z16);
        if (z16) {
            TencentLocationManager.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).appStatusChanged(1);
        } else {
            TencentLocationManager.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).appStatusChanged(2);
        }
    }

    public synchronized void a(@Nullable SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sosoInterfaceOnLocationListener);
            return;
        }
        if (sosoInterfaceOnLocationListener != null && !this.f288706e.contains(sosoInterfaceOnLocationListener)) {
            QLog.d("LocationListenerManager", 1, "[addListener] " + sosoInterfaceOnLocationListener + " , tag = " + sosoInterfaceOnLocationListener.tag);
            if (this.f288706e.add(sosoInterfaceOnLocationListener) && f288700f.contains(sosoInterfaceOnLocationListener.tag)) {
                this.f288702a++;
                h();
            }
            return;
        }
        QLog.d("LocationListenerManager", 1, "[addListener] " + sosoInterfaceOnLocationListener);
    }

    public synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        boolean z16 = true;
        QLog.d("LocationListenerManager", 1, "[clear]");
        if (this.f288702a == 0) {
            z16 = false;
        }
        this.f288702a = 0;
        this.f288706e.clear();
        if (z16) {
            h();
        }
    }

    @NonNull
    public List<SosoInterfaceOnLocationListener> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f288706e;
    }

    public synchronized void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        QLog.d("LocationListenerManager", 1, "[notifyAppStatusChanged] isForeground = " + z16);
        this.f288704c = z16;
        h();
    }

    public synchronized void f(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener, int i3, @Nullable SosoLbsInfo sosoLbsInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, sosoInterfaceOnLocationListener, Integer.valueOf(i3), sosoLbsInfo);
            return;
        }
        if (sosoInterfaceOnLocationListener == null) {
            QLog.e("LocationListenerManager", 1, "expect nonnull but receive null lis");
            return;
        }
        HashSet<String> hashSet = f288700f;
        if (hashSet.isEmpty()) {
            g(sosoInterfaceOnLocationListener, i3, sosoLbsInfo);
            return;
        }
        if (this.f288704c) {
            this.f288705d = sosoLbsInfo;
        }
        if (sosoLbsInfo == null) {
            QLog.w("LocationListenerManager", 1, "[notifyListener], soso=null, err=" + i3);
        } else {
            QLog.d("LocationListenerManager", 4, "[notifyListener], time=" + f288701g.format(Long.valueOf(sosoLbsInfo.mLocation.locationTime)));
        }
        if (!hashSet.contains(sosoInterfaceOnLocationListener.tag)) {
            sosoLbsInfo = this.f288705d;
        }
        g(sosoInterfaceOnLocationListener, i3, sosoLbsInfo);
    }

    public synchronized void i(@Nullable SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sosoInterfaceOnLocationListener);
            return;
        }
        if (sosoInterfaceOnLocationListener == null) {
            QLog.d("LocationListenerManager", 1, "[removeListener] null");
            return;
        }
        QLog.d("LocationListenerManager", 1, "[removeListener] " + sosoInterfaceOnLocationListener + " , tag = " + sosoInterfaceOnLocationListener.tag);
        if (this.f288706e.remove(sosoInterfaceOnLocationListener) && f288700f.contains(sosoInterfaceOnLocationListener.tag)) {
            this.f288702a--;
            h();
        }
    }

    public synchronized void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 >= 0 && i3 < this.f288706e.size()) {
            SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener = this.f288706e.get(i3);
            this.f288706e.remove(i3);
            if (sosoInterfaceOnLocationListener == null) {
                QLog.e("LocationListenerManager", 1, "[removeListenerAt] null element in list, which is impossible");
                return;
            }
            QLog.d("LocationListenerManager", 1, "[removeListenerAt] " + i3 + " , tag = " + sosoInterfaceOnLocationListener.tag);
            if (f288700f.contains(sosoInterfaceOnLocationListener.tag)) {
                this.f288702a--;
                h();
            }
            return;
        }
        QLog.e("LocationListenerManager", 1, "[removeListenerAt] " + i3 + " out of bound");
    }
}
