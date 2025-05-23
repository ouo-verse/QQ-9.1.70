package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IAuthRequestCallback;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsFramework {

    /* renamed from: a, reason: collision with root package name */
    private static Context f369120a;

    public static void authenticateX5(boolean z16, IAuthRequestCallback iAuthRequestCallback) {
        QbSdk.a(f369120a, z16, iAuthRequestCallback);
    }

    public static Context getAppContext() {
        return f369120a;
    }

    public static boolean installStaticX5() {
        return QbSdk.preinstallStaticTbs(f369120a);
    }

    public static void setLicense(String str) {
        QbSdk.b(str);
    }

    public static void setUp(Context context, String str) {
        if (context != null && context.getApplicationContext() != null) {
            f369120a = context.getApplicationContext();
            QbSdk.a(str);
            return;
        }
        throw new IllegalArgumentException("context or getApplicationContext is null");
    }

    public static void setUp(Context context) {
        setUp(context, (File) null);
    }

    public static void setUp(Context context, File file) {
        QbSdk.usePrivateCDN(QbSdk.PrivateCDNMode.STANDARD_IMPL);
        if (context != null && context.getApplicationContext() != null) {
            f369120a = context.getApplicationContext();
            com.tencent.smtt.sdk.core.dynamicinstall.a.a().a(file);
            if (com.tencent.smtt.sdk.core.dynamicinstall.a.a().b() != null) {
                QbSdk.a(com.tencent.smtt.sdk.core.dynamicinstall.a.a().b().e());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("context or getApplicationContext is null");
    }
}
