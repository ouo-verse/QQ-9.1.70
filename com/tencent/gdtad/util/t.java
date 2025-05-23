package com.tencent.gdtad.util;

import android.os.Bundle;
import com.tencent.gdtad.config.IGdtConfigAPI;
import com.tencent.gdtad.config.data.GdtWXMiniJumpConfig;
import com.tencent.gdtad.config.parser.GdtWXMiniJumpConfigParser;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f109569a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f109570b = 0;

    public static int c() {
        return f109570b;
    }

    private static void d(String str) {
        f109570b = QMMKV.fromV2(BaseApplication.getContext(), QMMKVFile.FILE_AD).getInt(str, 0);
        QLog.i("GdtWXMiniAuthUtil", 1, "[initWXMiniAuthState] sWXMiniAuthStatus:" + f109570b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str, boolean z16, Bundle bundle) {
        int i3;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        f109570b = i3;
        g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(final String str) {
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkWxAuthed(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.gdtad.util.s
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                t.e(str, z16, bundle);
            }
        });
    }

    private static void g(String str) {
        QMMKV.fromV2(BaseApplication.getContext(), QMMKVFile.FILE_AD).putInt(str, f109570b);
        QLog.i("GdtWXMiniAuthUtil", 1, "[saveWXMiniAuthStateToMMKV] sWXMiniAuthStatus:" + f109570b);
    }

    public static void h(boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        try {
            z17 = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).isDeviceInfoWXMINIAuthorizationStateEnabled();
        } catch (Throwable th5) {
            QLog.e("GdtWXMiniAuthUtil", 1, "[updateWXMiniAuthState]", th5);
            z17 = false;
        }
        GdtWXMiniJumpConfig c16 = GdtWXMiniJumpConfigParser.INSTANCE.c();
        if (c16 != null && c16.getUploadAuthStatusEnable()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16) {
            z19 = z17;
        } else {
            z19 = z18;
        }
        if (!z19) {
            QLog.i("GdtWXMiniAuthUtil", 1, "[updateWXMiniAuthState] do nothing, supportWXMiniAuthState:" + z16 + " enabled:" + z19 + " enabledIfSupportWXMiniAuthState:" + z17 + " enabledIfNotSupportWXMiniAuthState:" + z18);
            return;
        }
        if (f109569a.compareAndSet(false, true)) {
            final String str = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "wxmini_auth_state";
            d(str);
            if (1 == MobileQQ.sProcessId) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.util.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.f(str);
                    }
                }, 16, null, false);
            }
        }
    }
}
