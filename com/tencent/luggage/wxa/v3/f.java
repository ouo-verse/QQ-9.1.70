package com.tencent.luggage.wxa.v3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap f143062a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f143063b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f143064c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static IWXAPI f143065d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f143066e = "";

    /* renamed from: f, reason: collision with root package name */
    public static final Random f143067f = new Random(42);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void onResp(BaseResp baseResp);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        String a(BaseResp baseResp);
    }

    public static boolean b(BaseResp baseResp) {
        String str;
        b bVar;
        try {
            if (!w0.c(baseResp.transaction)) {
                String[] a16 = a(baseResp.transaction);
                if (a16 == null) {
                    return false;
                }
                baseResp.transaction = a16[0];
                b bVar2 = (b) f143062a.remove(a16[1]);
                if (bVar2 == null) {
                    return false;
                }
                bVar2.onResp(baseResp);
            } else {
                c cVar = (c) f143063b.get(baseResp.getClass());
                if (cVar == null) {
                    return false;
                }
                try {
                    str = cVar.a(baseResp);
                } catch (ClassCastException unused) {
                    str = null;
                }
                if (w0.c(str) || (bVar = (b) f143064c.remove(str)) == null) {
                    return false;
                }
                bVar.onResp(baseResp);
            }
        } catch (ClassCastException unused2) {
        }
        return true;
    }

    public static boolean c() {
        return f143065d.isWXAppInstalled();
    }

    public static Boolean d() {
        boolean z16;
        String str = f143066e;
        if (str != null && str.length() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    public static void a(Class cls, c cVar) {
        f143063b.put(cls, cVar);
    }

    public static boolean a(String str, BaseReq baseReq, b bVar) {
        if (f143065d == null) {
            w.b("Luggage.OpenSDKApiClient", "send open sdk request failed, not initilized");
            return false;
        }
        if (w0.c(str)) {
            w.d("Luggage.OpenSDKApiClient", "oriKey is empty, return");
            return false;
        }
        f143064c.put(str, bVar);
        baseReq.transaction = "";
        return f143065d.sendReq(baseReq);
    }

    public static String[] a(String str) {
        String[] split;
        if (str == null || (split = str.split("`-`-`-`")) == null || split.length != 2) {
            return null;
        }
        return split;
    }

    public static void b(String str) {
        f143066e = str;
    }

    public static String a() {
        return f143066e;
    }

    public static boolean b() {
        return f143065d != null;
    }

    public static void a(IWXAPI iwxapi) {
        f143065d = iwxapi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        if (r0 != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, Intent intent) {
        if (f143065d == null) {
            return false;
        }
        boolean z16 = context instanceof Activity;
        Context context2 = context;
        if (z16) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                boolean isDestroyed = activity.isDestroyed();
                context2 = activity;
            }
            context2 = z.c();
        } else if (context == null) {
            context2 = z.c();
        }
        boolean[] zArr = {false};
        f143065d.handleIntent(intent, new a(context2, zArr, intent));
        return zArr[0];
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements IWXAPIEventHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f143068a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f143069b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f143070c;

        public a(Context context, boolean[] zArr, Intent intent) {
            this.f143068a = context;
            this.f143069b = zArr;
            this.f143070c = intent;
        }

        @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
        public void onResp(BaseResp baseResp) {
            if (!f.b(baseResp)) {
                if (baseResp instanceof WXLaunchMiniProgram.Resp) {
                    j a16 = j.a((WXLaunchMiniProgram.Resp) baseResp);
                    if (this.f143068a != null && a16.f143117c && !w0.c(a16.f143118d)) {
                        this.f143069b[0] = true;
                        w.d("Luggage.OpenSDKApiClient", "startActivity name:%s", a16.f143118d);
                        this.f143070c.setClassName(this.f143068a, a16.f143118d);
                        Context context = this.f143068a;
                        Intent intent = this.f143070c;
                        com.tencent.luggage.wxa.fa.b.a(context, intent);
                        context.startActivity(intent);
                        return;
                    }
                    return;
                }
                if (baseResp instanceof WXLaunchWxaRedirectingPage.Resp) {
                    this.f143069b[0] = true;
                    WXLaunchWxaRedirectingPage.Resp resp = (WXLaunchWxaRedirectingPage.Resp) baseResp;
                    if (this.f143068a != null && !TextUtils.isEmpty(resp.callbackActivity)) {
                        if (this.f143068a.getClass().getName().equals(resp.callbackActivity)) {
                            w.h("Luggage.OpenSDKApiClient", "already in target callbackActivity %s", resp.callbackActivity);
                            return;
                        }
                        this.f143070c.setClassName(this.f143068a, resp.callbackActivity);
                        if (!(this.f143068a instanceof Activity)) {
                            this.f143070c.addFlags(268435456);
                        }
                        this.f143070c.addFlags(603979776);
                        Context context2 = this.f143068a;
                        Intent intent2 = this.f143070c;
                        com.tencent.luggage.wxa.fa.b.a(context2, intent2);
                        context2.startActivity(intent2);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f143069b[0] = true;
        }

        @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
        public void onReq(BaseReq baseReq) {
        }
    }
}
