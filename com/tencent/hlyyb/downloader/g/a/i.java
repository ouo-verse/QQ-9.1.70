package com.tencent.hlyyb.downloader.g.a;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes7.dex */
public class i extends a {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void e(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                return;
            }
            IBinder iBinder = (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "media_router");
            if (iBinder == null) {
                k.m(context, d(), 20, null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(UUID.randomUUID().toString());
            Object obj = Class.forName("android.media.RouteDiscoveryPreference").getDeclaredField(PatternUtils.NO_MATCH).get(null);
            Field declaredField = obj.getClass().getDeclaredField("mPreferredFeatures");
            declaredField.setAccessible(true);
            declaredField.set(obj, arrayList);
            Field declaredField2 = obj.getClass().getDeclaredField("mShouldPerformActiveScan");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, Boolean.TRUE);
            Binder binder = new Binder();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            OaidMonitor.writeParcelToken(obtain, "android.media.IMediaRouterService");
            obtain.writeStrongBinder(binder);
            obtain.writeString(context.getPackageName());
            int b16 = k.b("android.media.IMediaRouterService$Stub", "TRANSACTION_registerRouter2");
            if (b16 == -1) {
                k.m(context, d(), 21, null);
                return;
            }
            OaidMonitor.binderTransact(iBinder, b16, obtain, obtain2, 0);
            Parcel obtain3 = Parcel.obtain();
            Parcel obtain4 = Parcel.obtain();
            OaidMonitor.writeParcelToken(obtain3, "android.media.IMediaRouterService");
            obtain3.writeStrongBinder(binder);
            obtain3.writeInt(1);
            obj.getClass().getDeclaredMethod("writeToParcel", Parcel.class, Integer.TYPE).invoke(obj, obtain3, 0);
            int b17 = k.b("android.media.IMediaRouterService$Stub", "TRANSACTION_setDiscoveryRequestWithRouter2");
            if (b17 == -1) {
                k.m(context, d(), 22, null);
            } else {
                OaidMonitor.binderTransact(iBinder, b17, obtain3, obtain4, 0);
            }
        } catch (Throwable unused) {
            k.m(context, d(), 23, null);
        }
    }

    @Override // com.tencent.hlyyb.downloader.g.a.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            e(this.f114655b);
        }
    }

    @Override // com.tencent.hlyyb.downloader.g.a.a
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "b";
    }
}
