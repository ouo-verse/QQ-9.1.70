package com.tencent.tavcut.core.render.builder.light;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.tavcut.core.render.log.TavLogger;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightEngine;
import sd4.DynamicSoConfig;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0003J(\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/LightSDKUtils;", "", "", "soPath", "soName", "", "loadSo", "absolutePath", "tryInstallSo", "Landroid/content/Context;", "context", "licencePath", "appId", "appEntry", "", "authLightSdk", "", "Lsd4/a;", "dynamicSoConfigs", "templatePath", "getTemplateJsonPath", "isTemplateJsonExist", "TEMPLATE_JSON_FILE_NAME", "Ljava/lang/String;", "TAG", "SO_SUFFIX", "SO_UNLOAD", "I", "authResult", "isSoLoaded", "Z", "()Z", "setSoLoaded", "(Z)V", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class LightSDKUtils {
    private static final String SO_SUFFIX = ".so";
    private static final int SO_UNLOAD = -100086;
    private static final String TAG = "LightSDKUtils";
    private static final String TEMPLATE_JSON_FILE_NAME = "template.json";
    private static boolean isSoLoaded;
    public static final LightSDKUtils INSTANCE = new LightSDKUtils();
    private static int authResult = -1;

    LightSDKUtils() {
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private final boolean tryInstallSo(String absolutePath) {
        File file = new File(absolutePath);
        if (file.exists() && file.isFile()) {
            try {
                TavLogger.i(TAG, "tryInstallSo : " + absolutePath);
                System.load(absolutePath);
                return true;
            } catch (NullPointerException e16) {
                TavLogger.e(TAG, "NullPointerException:" + e16.getMessage());
                return false;
            } catch (SecurityException e17) {
                TavLogger.e(TAG, "SecurityException:" + e17.getMessage());
                return false;
            } catch (UnsatisfiedLinkError e18) {
                TavLogger.e(TAG, "UnsatisfiedLinkError:" + e18.getMessage());
                return false;
            }
        }
        TavLogger.e(TAG, "file not exist:" + absolutePath);
        return false;
    }

    public final int authLightSdk(@Nullable Context context, @NotNull String licencePath, @NotNull String appId, @NotNull String appEntry) {
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
        return SO_UNLOAD;
    }

    @NotNull
    public final String getTemplateJsonPath(@NotNull String templatePath) {
        boolean endsWith$default;
        boolean endsWith$default2;
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(templatePath, "template.json", false, 2, null);
        if (!endsWith$default) {
            String str = File.separator;
            Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(templatePath, str, false, 2, null);
            if (endsWith$default2) {
                return templatePath + "template.json";
            }
            return (templatePath + str) + "template.json";
        }
        return templatePath;
    }

    public final boolean isSoLoaded() {
        return isSoLoaded;
    }

    public final boolean isTemplateJsonExist(@NotNull String templatePath) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        return new File(getTemplateJsonPath(templatePath)).exists();
    }

    public final synchronized boolean loadSo(@NotNull List<DynamicSoConfig> dynamicSoConfigs) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(dynamicSoConfigs, "dynamicSoConfigs");
        z16 = true;
        for (DynamicSoConfig dynamicSoConfig : dynamicSoConfigs) {
            if (dynamicSoConfig.getNeedLoad()) {
                z16 &= INSTANCE.loadSo(dynamicSoConfig.getSoPath(), dynamicSoConfig.getSoName());
            }
        }
        isSoLoaded = z16;
        return z16;
    }

    public final void setSoLoaded(boolean z16) {
        isSoLoaded = z16;
    }

    private final boolean loadSo(String soPath, String soName) {
        boolean endsWith$default;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(soPath, SO_SUFFIX, false, 2, null);
        if (endsWith$default) {
            return tryInstallSo(soPath);
        }
        return tryInstallSo(soPath + File.separator + soName);
    }
}
