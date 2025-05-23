package com.qq.e.tg.preload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.ADPLI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AdPreloader {

    /* renamed from: a, reason: collision with root package name */
    private static volatile AdPreloader f40598a;

    /* renamed from: b, reason: collision with root package name */
    private ADPLI f40599b;

    AdPreloader() {
    }

    public static AdPreloader getInstance() {
        if (f40598a == null) {
            synchronized (AdPreloader.class) {
                if (f40598a == null) {
                    f40598a = new AdPreloader();
                }
            }
        }
        return f40598a;
    }

    public void preloadAfterAdLoaded(final Context context, final String str, String str2, final String str3) {
        if (SDKStatus.getSDKVersionCode() < 110) {
            GDTLogger.e("preloadAfterAdLoaded failed sdk version < 110");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e("preloadAfterAdLoaded params invalid. ad is null");
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject(str2);
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.preload.AdPreloader.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GDTADManager gDTADManager = GDTADManager.getInstance();
                        if (gDTADManager != null && gDTADManager.initWith(context, str)) {
                            try {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.preload.AdPreloader.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                                            if (pOFactory != null) {
                                                AdPreloader.this.f40599b = pOFactory.getAdPreloader();
                                                JSONArray jSONArray = new JSONArray();
                                                jSONArray.mo162put(jSONObject);
                                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                AdPreloader.a(AdPreloader.this, jSONArray, str3);
                                            }
                                        } catch (a e16) {
                                            e16.printStackTrace();
                                        }
                                    }
                                });
                            } catch (Throwable th5) {
                                GDTLogger.e("Exception while init AdPreloader Core", th5);
                                GDTADManager.getInstance().getPM().autoRollbackPlugin(th5.toString());
                            }
                        }
                    } catch (Throwable th6) {
                        GDTLogger.e(th6.getMessage());
                    }
                }
            });
        } catch (Throwable unused) {
            GDTLogger.e("preloadAfterAdLoaded params invalid. ad parse failed");
        }
    }

    static /* synthetic */ void a(AdPreloader adPreloader, JSONArray jSONArray, String str) {
        ADPLI adpli = adPreloader.f40599b;
        if (adpli != null) {
            adpli.preloadAfterAdLoaded(jSONArray, str);
        }
    }
}
