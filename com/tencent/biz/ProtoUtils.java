package com.tencent.biz;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes2.dex */
public class ProtoUtils {

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Foundation/QQCommon/src/main/resources/Inject_ProtoUtils.yml", version = 1)
    public static ArrayList<Class<Object>> f78315a;

    /* loaded from: classes2.dex */
    public static abstract class a extends TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<AppRuntime> f78322d = new WeakReference<>(null);
    }

    /* loaded from: classes2.dex */
    public static abstract class b implements BusinessObserver {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* bridge */ /* synthetic */ void a(b bVar, int i3, boolean z16, Bundle bundle) {
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class c extends a {
    }

    static {
        ArrayList<Class<Object>> arrayList = new ArrayList<>();
        f78315a = arrayList;
        arrayList.add(n.class);
    }

    public static void a(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, int i3, int i16) {
        c(appRuntime, troopProtocolObserver, bArr, str, i3, i16, null, 0L);
    }

    public static void b(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, int i3, int i16, Bundle bundle) {
        c(appRuntime, troopProtocolObserver, bArr, str, i3, i16, bundle, 0L);
    }

    public static void c(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, int i3, int i16, Bundle bundle, long j3) {
        if (appRuntime == null) {
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), m.class);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        if (troopProtocolObserver != null) {
            troopProtocolObserver.mType = 1;
            newIntent.setObserver(troopProtocolObserver);
        }
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        if (j3 > 0) {
            newIntent.putExtra("timeout", j3);
        }
        appRuntime.startServlet(newIntent);
    }

    public static void d(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str) {
        f(appRuntime, troopProtocolObserver, bArr, str, null, false);
    }

    public static void e(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, Bundle bundle) {
        f(appRuntime, troopProtocolObserver, bArr, str, bundle, false);
    }

    public static void f(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, Bundle bundle, boolean z16) {
        if (appRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplicationContext(), m.class);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        troopProtocolObserver.mApp = new WeakReference<>(appRuntime);
        troopProtocolObserver.mType = 2;
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("isResend", z16);
        newIntent.setObserver(troopProtocolObserver);
        appRuntime.startServlet(newIntent);
    }

    public static void g(AppRuntime appRuntime, byte[] bArr, String str) {
        h(appRuntime, bArr, str, null, false);
    }

    public static void h(AppRuntime appRuntime, byte[] bArr, String str, Bundle bundle, boolean z16) {
        if (appRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplicationContext(), m.class);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("isResend", z16);
        newIntent.putExtra("DataType", 2);
        appRuntime.startServlet(newIntent);
    }

    public static void i(AppRuntime appRuntime, a aVar, byte[] bArr, String str, int i3, int i16, Bundle bundle, long j3) {
        if (appRuntime == null) {
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        NewIntent newIntent = new NewIntent(appRuntime.getApplicationContext(), m.class);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        if (aVar != null) {
            aVar.f78322d = new WeakReference<>(appRuntime);
            aVar.mType = 1;
            newIntent.setObserver(aVar);
        }
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        if (j3 > 0) {
            newIntent.putExtra("timeout", j3);
        }
        appRuntime.startServlet(newIntent);
    }

    public static void j(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, int i3, int i16) {
        l(appRuntime, troopProtocolObserver, bArr, str, i3, i16, null, 0L);
    }

    public static void k(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, int i3, int i16, Bundle bundle) {
        l(appRuntime, troopProtocolObserver, bArr, str, i3, i16, bundle, 0L);
    }

    private static void l(AppRuntime appRuntime, TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, int i3, int i16, Bundle bundle, long j3) {
        if (appRuntime == null) {
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        NewIntent newIntent = new NewIntent(appRuntime.getApplicationContext(), m.class);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        if (troopProtocolObserver != null) {
            troopProtocolObserver.mApp = new WeakReference<>(appRuntime);
            troopProtocolObserver.mType = 1;
            newIntent.setObserver(troopProtocolObserver);
        }
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        if (j3 > 0) {
            newIntent.putExtra("timeout", j3);
        }
        appRuntime.startServlet(newIntent);
    }

    /* loaded from: classes2.dex */
    public static abstract class TroopProtocolObserver implements BusinessObserver {
        public static final int ERROR_GENERAL = -1;
        public static final int PB_OBSERVER = 2;
        public static final int SSO_OBSERVER = 1;
        public WeakReference<AppRuntime> mApp;
        public boolean mIsOnUIThread;
        public int mType;
        public Serializable troopCmdReport;

        public TroopProtocolObserver(boolean z16) {
            this.mType = 1;
            this.mApp = new WeakReference<>(null);
            this.mIsOnUIThread = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onReceiveReal(int i3, boolean z16, Bundle bundle) {
            if (!z16) {
                onResult(-1, null, bundle);
                return;
            }
            byte[] byteArray = bundle.getByteArray("data");
            int i16 = this.mType;
            if (i16 == 1) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(byteArray);
                    if (mergeFrom.uint32_result.get() != 0 && onError(mergeFrom.uint32_result.get(), mergeFrom.str_error_msg.get(), bundle)) {
                        return;
                    }
                    if (mergeFrom.uint32_result.has() && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        onResult(mergeFrom.uint32_result.get(), mergeFrom.bytes_bodybuffer.get().toByteArray(), bundle);
                        return;
                    } else {
                        onResult(-1, null, bundle);
                        return;
                    }
                } catch (InvalidProtocolBufferMicroException unused) {
                    onResult(-1, null, bundle);
                    return;
                } catch (Exception unused2) {
                    onResult(-1, null, bundle);
                    return;
                }
            }
            if (i16 == 2) {
                onResult(0, byteArray, bundle);
            }
        }

        public boolean onError(int i3, String str, Bundle bundle) {
            return false;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(final int i3, final boolean z16, final Bundle bundle) {
            if (this.mIsOnUIThread) {
                onReceiveReal(i3, z16, bundle);
            } else {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.ProtoUtils.TroopProtocolObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TroopProtocolObserver.this.onReceiveReal(i3, z16, bundle);
                    }
                }, 5, null, false);
            }
        }

        public abstract void onResult(int i3, byte[] bArr, Bundle bundle);

        public TroopProtocolObserver() {
            this.mType = 1;
            this.mApp = new WeakReference<>(null);
            this.mIsOnUIThread = true;
        }
    }
}
