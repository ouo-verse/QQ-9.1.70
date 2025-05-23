package com.tencent.tbs.one.impl.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.tbs.one.impl.a.g;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b extends ContextWrapper {

    /* renamed from: b, reason: collision with root package name */
    private static Method f374786b;

    /* renamed from: a, reason: collision with root package name */
    public a f374787a;

    /* renamed from: c, reason: collision with root package name */
    private Resources f374788c;

    /* renamed from: d, reason: collision with root package name */
    private Resources.Theme f374789d;

    /* renamed from: e, reason: collision with root package name */
    private String f374790e;

    static {
        try {
            f374786b = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
        } catch (Throwable unused) {
        }
    }

    public b(Context context, String str) {
        super(context);
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            if (applicationInfo != null) {
                this.f374790e = applicationInfo.packageName;
                applicationInfo.sourceDir = str;
                applicationInfo.publicSourceDir = str;
                try {
                    this.f374788c = context.getPackageManager().getResourcesForApplication(applicationInfo);
                } catch (Throwable unused) {
                    this.f374788c = a(context, str);
                }
                Resources resources = this.f374788c;
                if (resources != null) {
                    this.f374789d = resources.newTheme();
                    Resources.Theme theme = getBaseContext().getTheme();
                    if (theme != null) {
                        this.f374789d.setTo(theme);
                    }
                    int i3 = applicationInfo.theme;
                    if (i3 != 0) {
                        this.f374789d.applyStyle(i3, true);
                    }
                } else {
                    g.b("Failed to create resource info from %s", str);
                }
            } else {
                g.b("Failed to get application info from %s", str);
            }
        } else {
            g.b("Failed to get package info from %s", str);
        }
        this.f374787a = new a(this);
    }

    private static Resources a(Context context, String str) {
        if (f374786b == null) {
            return null;
        }
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            f374786b.invoke(assetManager, str);
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            Class<?> cls = resources.getClass();
            if (!"android.taobao.atlas.runtime.DelegateResources".equals(cls.getName())) {
                try {
                    return (Resources) cls.getConstructor(AssetManager.class, DisplayMetrics.class, Configuration.class).newInstance(assetManager, displayMetrics, configuration);
                } catch (Throwable unused) {
                }
            }
            return new Resources(assetManager, displayMetrics, configuration);
        } catch (Throwable th5) {
            g.b("Failed to new resources from %s", str, th5);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        AssetManager assets;
        Resources resources = getResources();
        if (resources != null && (assets = resources.getAssets()) != null) {
            return assets;
        }
        return super.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final String getPackageName() {
        String str = this.f374790e;
        if (str != null) {
            return str;
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.f374788c;
        if (resources != null) {
            return resources;
        }
        return super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            return this.f374787a;
        }
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f374789d;
        if (theme != null) {
            return theme;
        }
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i3) {
        Resources.Theme theme = this.f374789d;
        if (theme != null) {
            theme.applyStyle(i3, true);
        } else {
            super.setTheme(i3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        super.startActivity(a(intent));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ComponentName startService(Intent intent) {
        return super.startService(a(intent));
    }

    private Intent a(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            intent.setComponent(new ComponentName(getBaseContext(), component.getClassName()));
        }
        return intent;
    }
}
