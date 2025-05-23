package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqmini/sdk/utils/d;", "", "", "soFilePath", "", "c", "soFileFolder", "b", "soPath", "", "a", "<init>", "()V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f348364a = new d();

    d() {
    }

    @JvmStatic
    public static final void b(@Nullable String soFileFolder) {
        boolean z16;
        boolean endsWith$default;
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            if (soFileFolder != null && soFileFolder.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QMLog.e("SoUtil", "registerSo failed, soFileFolder=" + soFileFolder);
                return;
            }
            File file = new File(soFileFolder);
            if (!file.exists()) {
                QMLog.e("SoUtil", "registerSo failed, folderFile not exists. soFileFolder=" + soFileFolder);
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File it : listFiles) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    String name = it.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name, "it.name");
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name, ".so", false, 2, null);
                    if (endsWith$default) {
                        qQCustomizedProxy.registerSoFilePath(it.getAbsolutePath());
                    }
                }
            }
        }
    }

    @JvmStatic
    public static final void c(@Nullable String soFilePath) {
        boolean z16;
        if (soFilePath != null && soFilePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QMLog.e("SoUtil", "registerSo failed, soFilePath=" + soFilePath);
            return;
        }
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            qQCustomizedProxy.registerSoFilePath(soFilePath);
        }
    }

    public final boolean a(@NotNull String soPath) {
        Intrinsics.checkParameterIsNotNull(soPath, "soPath");
        try {
            File file = new File(soPath);
            if (file.exists()) {
                System.load(file.getAbsolutePath());
            } else {
                System.loadLibrary(soPath);
            }
            c(soPath);
            return true;
        } catch (Throwable unused) {
            QMLog.e("SoUtil", "load soPath=" + soPath + " failed.");
            return false;
        }
    }
}
