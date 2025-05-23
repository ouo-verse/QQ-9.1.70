package com.qq.e.tg.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GDTAD {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f40464a = false;

    /* renamed from: b, reason: collision with root package name */
    private static InitListener f40465b;

    /* renamed from: c, reason: collision with root package name */
    private static PM.a.InterfaceC0276a f40466c = new PM.a.InterfaceC0276a() { // from class: com.qq.e.tg.cfg.GDTAD.1
        public final void onLoadFail() {
            GDTLogger.w("Init fail");
        }

        public final void onLoadSuccess() {
            GDTAD.a(true);
            if (GDTAD.f40465b != null) {
                GDTAD.f40465b.onSuccess();
            }
        }

        public final void onDexMerged(boolean z16) {
        }
    };

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f40464a) {
            GDTLogger.w("SDK\u5df2\u7ecf\u88ab\u521d\u59cb\u5316\u8fc7");
            return;
        }
        if (context == null) {
            GDTLogger.e("Context\u53c2\u6570\u4e0d\u80fd\u4e3anull");
            return;
        }
        if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId\u53c2\u6570\u4e0d\u80fd\u4e3a\u7a7a");
            return;
        }
        f40465b = initListener;
        GDTADManager gDTADManager = GDTADManager.getInstance();
        gDTADManager.setPluginLoadListener(f40466c);
        gDTADManager.initWith(context.getApplicationContext(), str);
    }

    static /* synthetic */ boolean a(boolean z16) {
        f40464a = true;
        return true;
    }
}
