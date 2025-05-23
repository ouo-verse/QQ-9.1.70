package com.tencent.gdtad.api.interstitial;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd;
import com.tencent.gdtad.api.interstitial.f;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    private static volatile e f108638e;

    /* renamed from: c, reason: collision with root package name */
    private volatile a f108641c;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f108639a = false;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private GdtInterstitialNotifyReg f108640b = new GdtInterstitialNotifyReg();

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private Map<String, WeakReference<GdtInterstitialFragment>> f108642d = new HashMap();

    e(a aVar) {
        this.f108641c = aVar;
    }

    public static e d() {
        if (f108638e == null) {
            synchronized (e.class) {
                if (f108638e == null) {
                    a aVar = new a();
                    aVar.f108629a = "com.tencent.tangram.interstitial";
                    aVar.f108630b = "Index";
                    aVar.f108632d = AskAnonymouslyUtil.ARK_APP_VER;
                    f108638e = new e(aVar);
                }
            }
        }
        return f108638e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a() {
        return this.f108641c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public GdtInterstitialNotifyReg b() {
        return this.f108640b;
    }

    public GdtInterstitialFragment c(String str) {
        WeakReference<GdtInterstitialFragment> weakReference;
        if (TextUtils.isEmpty(str) || !this.f108642d.containsKey(str) || (weakReference = this.f108642d.get(str)) == null) {
            return null;
        }
        return weakReference.get();
    }

    public void e() {
        GdtLog.i("GdtInterstitialManager", "[init] initialized:" + this.f108639a);
        if (this.f108639a) {
            return;
        }
        synchronized (this) {
            if (this.f108639a) {
                return;
            }
            this.f108639a = true;
            AdIPCManager.getInstance().register("ipc_interstitial_close", new GdtInterstitialAd.IPCHandlerForClose());
            AdIPCManager.getInstance().register("ipc_interstitial_predownload", new f.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(String str, @Nullable WeakReference<GdtInterstitialFragment> weakReference) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && !this.f108642d.containsKey(str) && weakReference != null && weakReference.get() != null) {
            this.f108642d.put(str, weakReference);
            z16 = true;
        } else {
            z16 = false;
        }
        GdtLog.i("GdtInterstitialManager", String.format("register %b traceId:%s", Boolean.valueOf(z16), str));
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str) || !this.f108642d.containsKey(str)) {
            z16 = false;
        } else {
            this.f108642d.remove(str);
            z16 = true;
        }
        GdtLog.i("GdtInterstitialManager", String.format("unregister %b traceId:%s", Boolean.valueOf(z16), str));
        return z16;
    }
}
