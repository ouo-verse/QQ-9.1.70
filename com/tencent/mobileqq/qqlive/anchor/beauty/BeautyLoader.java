package com.tencent.mobileqq.qqlive.anchor.beauty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class BeautyLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static BeautyLoader f270359f;

    /* renamed from: a, reason: collision with root package name */
    private final BroadcastReceiver f270360a;

    /* renamed from: b, reason: collision with root package name */
    private int f270361b;

    /* renamed from: c, reason: collision with root package name */
    private b f270362c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.utils.b f270363d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f270364e;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BeautyLoader.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (intent != null && "ACTION_RECEIVE_MSH_SET_SYNC".equals(intent.getAction())) {
                AegisLogger.i("Open_Live|BeautyLoader", "aeBundleMsgReceiverOnReceive", "receive ACTION_RECEIVE_MSH_SET_SYNC msg!");
                BeautyLoader.this.j();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void a(int i3, int i16);

        void b();

        void onLoadComplete();

        void onLoadStart();
    }

    public BeautyLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270360a = new a();
        this.f270361b = 0;
        this.f270362c = null;
        this.f270363d = new com.tencent.mobileqq.qqlive.anchor.beauty.utils.b();
        this.f270364e = false;
    }

    public static BeautyLoader d() {
        if (f270359f == null) {
            f270359f = new BeautyLoader();
        }
        return f270359f;
    }

    private boolean e() {
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_VIDEO_FILTER.agentType, "qq_live");
    }

    private boolean f() {
        boolean isLightSDKResExist = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightSDKResExist();
        this.f270363d.c(isLightSDKResExist);
        if (!isLightSDKResExist) {
            AegisLogger.e("Open_Live|BeautyLoader", "loadBase", "Beauty base resource miss!");
            return false;
        }
        boolean loadLightSdk = ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadLightSdk();
        this.f270363d.c(loadLightSdk);
        if (!loadLightSdk) {
            AegisLogger.e("Open_Live|BeautyLoader", "loadBase", "Beauty so miss!");
            return false;
        }
        return true;
    }

    private boolean h() {
        while (true) {
            boolean z16 = true;
            for (Map.Entry entry : new HashMap(f.a()).entrySet()) {
                boolean isAEResExist = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(((AEResInfo) entry.getKey()).agentType, "qq_live");
                f.b((AEResInfo) entry.getKey(), isAEResExist);
                this.f270363d.c(isAEResExist);
                if (!z16 || !isAEResExist) {
                    z16 = false;
                }
            }
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).setHasSynced(false);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f270362c = null;
        }
    }

    public void g() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f270362c != null) {
            this.f270363d.b();
            this.f270361b = 0;
            this.f270362c.onLoadStart();
            if (f()) {
                i3 = this.f270361b | 4096;
            } else {
                i3 = this.f270361b;
            }
            this.f270361b = i3;
            AegisLogger.i("Open_Live|BeautyLoader", "loadBeautyRes", String.format("load base end. State:%x", Integer.valueOf(i3)));
            if (h()) {
                i16 = this.f270361b | 256;
            } else {
                i16 = this.f270361b;
            }
            this.f270361b = i16;
            AegisLogger.i("Open_Live|BeautyLoader", "loadBeautyRes", String.format("load bundle end. State:%x", Integer.valueOf(i16)));
            if (e()) {
                i17 = this.f270361b | 16;
            } else {
                i17 = this.f270361b;
            }
            this.f270361b = i17;
            AegisLogger.i("Open_Live|BeautyLoader", "loadBeautyRes", String.format("load assert end. State:%x", Integer.valueOf(i17)));
            if (4368 == this.f270361b) {
                this.f270364e = false;
                this.f270362c.onLoadComplete();
                return;
            } else {
                if (this.f270364e) {
                    this.f270362c.a(1, this.f270363d.a());
                    return;
                }
                j();
                com.tencent.mobileqq.qqlive.anchor.beauty.a.e().d(this.f270361b);
                this.f270362c.b();
                this.f270364e = true;
                return;
            }
        }
        throw new NullPointerException("BeautyLoader#loadBeautyRes BeautyLoadListener can not be NULL!");
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (BaseApplication.getContext().getApplicationContext() != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyLoader.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BeautyLoader.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            AegisLogger.i("Open_Live|BeautyLoader", "registerReceiver", "registerReceiver ASync");
                            BaseApplication.getContext().getApplicationContext().registerReceiver(BeautyLoader.this.f270360a, new IntentFilter("ACTION_RECEIVE_MSH_SET_SYNC"));
                        }
                    }
                }, 16, null, true);
            } else {
                AegisLogger.i("Open_Live|BeautyLoader", "registerReceiver", "registerReceiver Sync");
                BaseApplication.getContext().getApplicationContext().registerReceiver(this.f270360a, new IntentFilter("ACTION_RECEIVE_MSH_SET_SYNC"));
            }
        }
    }

    public void k(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.f270362c = bVar;
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (BaseApplication.getContext().getApplicationContext() != null) {
            try {
                AegisLogger.i("Open_Live|BeautyLoader", "unregisterReceiver", "sync unregisterReceiver");
                BaseApplication.getContext().getApplicationContext().unregisterReceiver(this.f270360a);
            } catch (Throwable unused) {
                AegisLogger.e("Open_Live|BeautyLoader", "unregisterReceiver", "can not unregister");
            }
        }
    }
}
