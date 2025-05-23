package com.tencent.open.agent.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/open/agent/util/n;", "", "Landroid/content/Context;", "context", "", "apkName", "", "a", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f340616a = new n();

    n() {
    }

    @JvmStatic
    @NotNull
    public static final byte[] a(@NotNull Context context, @Nullable String apkName) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (apkName == null) {
            return new byte[0];
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), apkName, 64);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g\u2026geManager.GET_SIGNATURES)");
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null) {
                if (signatureArr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    Signature signature = signatureArr[0];
                    if (signature == null) {
                        return new byte[0];
                    }
                    byte[] f16 = com.tencent.open.base.g.f(signature.toByteArray());
                    Intrinsics.checkNotNullExpressionValue(f16, "toMD5Byte(signature.toByteArray())");
                    return f16;
                }
            }
            return new byte[0];
        } catch (Throwable unused) {
            QLog.e("PackageManagerUtils", 1, "getPkgSigFromApkName ");
            return new byte[0];
        }
    }
}
