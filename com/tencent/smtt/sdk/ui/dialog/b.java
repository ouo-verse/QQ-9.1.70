package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedInputStream;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f369530a;

    /* renamed from: b, reason: collision with root package name */
    private ResolveInfo f369531b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f369532c;

    /* renamed from: d, reason: collision with root package name */
    private String f369533d;

    /* renamed from: e, reason: collision with root package name */
    private String f369534e;

    /* renamed from: f, reason: collision with root package name */
    private String f369535f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f369536g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f369537h;

    /* renamed from: i, reason: collision with root package name */
    private String f369538i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, ResolveInfo resolveInfo) {
        this.f369533d = "";
        this.f369534e = "";
        this.f369536g = false;
        this.f369537h = false;
        this.f369538i = "";
        this.f369530a = context.getApplicationContext();
        this.f369531b = resolveInfo;
        this.f369532c = null;
        this.f369533d = null;
        this.f369535f = null;
    }

    public void a(Drawable drawable) {
        this.f369532c = drawable;
    }

    public String b() {
        ResolveInfo resolveInfo = this.f369531b;
        if (resolveInfo != null) {
            return resolveInfo.loadLabel(this.f369530a.getPackageManager()).toString();
        }
        return this.f369533d;
    }

    public ResolveInfo c() {
        return this.f369531b;
    }

    public String d() {
        ResolveInfo resolveInfo = this.f369531b;
        if (resolveInfo != null) {
            return resolveInfo.activityInfo.packageName;
        }
        String str = this.f369535f;
        if (str == null) {
            return "";
        }
        return str;
    }

    public boolean e() {
        return this.f369536g;
    }

    public boolean f() {
        return this.f369537h;
    }

    public String g() {
        return this.f369538i;
    }

    public String h() {
        return this.f369534e;
    }

    public Drawable a() {
        Drawable drawable = this.f369532c;
        if (drawable != null) {
            return drawable;
        }
        Drawable a16 = a(this.f369530a, d());
        if (a16 != null) {
            return a16;
        }
        ResolveInfo resolveInfo = this.f369531b;
        if (resolveInfo != null) {
            return resolveInfo.loadIcon(this.f369530a.getPackageManager());
        }
        return this.f369532c;
    }

    public void a(ResolveInfo resolveInfo) {
        this.f369531b = resolveInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0090, code lost:
    
        if (r2 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Drawable a(Context context, String str) {
        ApplicationInfo applicationInfo;
        AssetFileDescriptor assetFileDescriptor;
        BufferedInputStream bufferedInputStream;
        Drawable drawable = null;
        if (TbsConfig.APP_QB.equals(str)) {
            try {
                return e.a("application_icon");
            } catch (Throwable th5) {
                Log.e("error", "getApkIcon Error:" + Log.getStackTraceString(th5));
                return null;
            }
        }
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(str, 128);
        } catch (Exception e16) {
            Log.e("sdk", "e = " + e16);
        }
        if (applicationInfo == null) {
            return null;
        }
        Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
        TypedValue typedValue = new TypedValue();
        resourcesForApplication.getValue(applicationInfo.icon, typedValue, true);
        try {
            assetFileDescriptor = resourcesForApplication.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString());
            try {
                bufferedInputStream = new BufferedInputStream(assetFileDescriptor.createInputStream());
            } catch (Exception unused) {
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
            }
        } catch (Exception unused2) {
            assetFileDescriptor = null;
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            assetFileDescriptor = null;
            bufferedInputStream = null;
        }
        try {
            drawable = Drawable.createFromResourceStream(resourcesForApplication, typedValue, bufferedInputStream, null);
            assetFileDescriptor.close();
        } catch (Exception unused3) {
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
        } catch (Throwable th8) {
            th = th8;
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
        bufferedInputStream.close();
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Drawable drawable, String str, String str2, String str3) {
        this.f369533d = "";
        this.f369534e = "";
        this.f369536g = false;
        this.f369537h = false;
        this.f369538i = "";
        this.f369530a = context.getApplicationContext();
        this.f369531b = null;
        this.f369532c = drawable;
        this.f369533d = str;
        this.f369535f = str2;
        this.f369537h = true;
        this.f369534e = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Context context, int i3, String str, String str2) {
        Drawable drawable;
        this.f369533d = "";
        this.f369534e = "";
        this.f369536g = false;
        this.f369537h = false;
        this.f369538i = "";
        if (i3 != -1) {
            try {
                drawable = context.getResources().getDrawable(i3);
            } catch (Exception unused) {
            }
            drawable = drawable == null ? e.a("application_icon") : drawable;
            this.f369530a = context.getApplicationContext();
            this.f369531b = null;
            this.f369535f = null;
            this.f369532c = drawable;
            this.f369533d = str2;
            this.f369536g = true;
            this.f369538i = str;
        }
        drawable = null;
        if (drawable == null) {
        }
        this.f369530a = context.getApplicationContext();
        this.f369531b = null;
        this.f369535f = null;
        this.f369532c = drawable;
        this.f369533d = str2;
        this.f369536g = true;
        this.f369538i = str;
    }

    public void a(String str) {
        this.f369534e = str;
    }

    public void a(boolean z16) {
        this.f369537h = z16;
    }
}
