package com.tencent.paysdk.data;

import android.content.pm.PackageInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/paysdk/data/a;", "Lcom/tencent/paysdk/api/a;", "", "e", "c", "f", "g", "a", "Landroid/content/pm/PackageInfo;", "d", "b", "toString", "Ljava/lang/String;", "packageName", "Lcom/tencent/paysdk/api/a;", "delegate", "<init>", "(Lcom/tencent/paysdk/api/a;)V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class a implements com.tencent.paysdk.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String packageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.paysdk.api.a delegate;

    public a(@NotNull com.tencent.paysdk.api.a delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) delegate);
        } else {
            this.delegate = delegate;
            this.packageName = "";
        }
    }

    private final String c() {
        try {
            PackageInfo d16 = d();
            if (d16 != null) {
                String str = d16.versionName;
                Intrinsics.checkNotNullExpressionValue(str, "packageInfo.versionName");
                return str;
            }
            return "0";
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "0";
        }
    }

    private final String e() {
        boolean z16;
        if (this.packageName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String packageName = com.tencent.paysdk.a.f341941i.getContext().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "AuthSDK.getContext().packageName");
            this.packageName = packageName;
        }
        return this.packageName;
    }

    @Override // com.tencent.paysdk.api.a
    @NotNull
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.delegate.a();
    }

    @Override // com.tencent.paysdk.api.a
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.delegate.b();
    }

    @Nullable
    public final PackageInfo d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PackageInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(com.tencent.paysdk.a.f341941i.getContext().getPackageManager(), e(), 0);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return e();
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return c();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "getPkgName: " + e() + " \ngetVersion: " + g() + " \ngetPlayerPlatform: " + a() + " \n";
    }
}
