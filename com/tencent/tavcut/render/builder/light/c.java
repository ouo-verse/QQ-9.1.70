package com.tencent.tavcut.render.builder.light;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightEngine;
import qd4.DynamicSoConfig;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0003J(\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\u0014\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R$\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/tavcut/render/builder/light/c;", "", "", "soPath", "soName", "", "c", "absolutePath", "e", "Landroid/content/Context;", "context", "licencePath", "appId", "appEntry", "", "a", "", "Lqd4/a;", "dynamicSoConfigs", "d", "I", "authResult", "<set-?>", "b", "Z", "()Z", "isSoLoaded", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isSoLoaded;

    /* renamed from: c, reason: collision with root package name */
    public static final c f374382c = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static int authResult = -1;

    c() {
    }

    private final boolean c(String soPath, String soName) {
        boolean endsWith$default;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(soPath, ".so", false, 2, null);
        if (endsWith$default) {
            return e(soPath);
        }
        return e(soPath + File.separator + soName);
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private final boolean e(String absolutePath) {
        File file = new File(absolutePath);
        if (file.exists() && file.isFile()) {
            try {
                ee4.b.e("LightSDKUtils", "tryInstallSo : " + absolutePath);
                System.load(absolutePath);
                return true;
            } catch (NullPointerException e16) {
                ee4.b.b("LightSDKUtils", "NullPointerException:" + e16.getMessage());
                return false;
            } catch (SecurityException e17) {
                ee4.b.b("LightSDKUtils", "SecurityException:" + e17.getMessage());
                return false;
            } catch (UnsatisfiedLinkError e18) {
                ee4.b.b("LightSDKUtils", "UnsatisfiedLinkError:" + e18.getMessage());
                return false;
            }
        }
        ee4.b.b("LightSDKUtils", "file not exist:" + absolutePath);
        return false;
    }

    public final int a(@Nullable Context context, @NotNull String licencePath, @NotNull String appId, @NotNull String appEntry) {
        Intrinsics.checkParameterIsNotNull(licencePath, "licencePath");
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appEntry, "appEntry");
        int i3 = authResult;
        if (i3 == 0) {
            return i3;
        }
        if (isSoLoaded) {
            int initAuth = LightEngine.initAuth(context, licencePath, appId, appEntry);
            authResult = initAuth;
            return initAuth;
        }
        return -100086;
    }

    public final boolean b() {
        return isSoLoaded;
    }

    public final synchronized boolean d(@NotNull List<DynamicSoConfig> dynamicSoConfigs) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(dynamicSoConfigs, "dynamicSoConfigs");
        z16 = true;
        for (DynamicSoConfig dynamicSoConfig : dynamicSoConfigs) {
            if (dynamicSoConfig.getNeedLoad()) {
                z16 &= f374382c.c(dynamicSoConfig.getSoPath(), dynamicSoConfig.getSoName());
            }
        }
        isSoLoaded = z16;
        return z16;
    }
}
