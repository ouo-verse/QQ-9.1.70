package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c extends k {

    /* renamed from: a, reason: collision with root package name */
    private Context f32819a;

    /* renamed from: b, reason: collision with root package name */
    private int f32820b;

    /* renamed from: c, reason: collision with root package name */
    private d f32821c;

    public c(Context context, int i3) {
        Context applicationContext = context.getApplicationContext();
        this.f32819a = applicationContext;
        if (applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.f32819a = context;
        }
        this.f32820b = i3;
        this.f32821c = new d(new File(this.f32819a.getApplicationInfo().nativeLibraryDir), i3);
    }

    public static File d(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // com.facebook.soloader.k
    public int a(String str, int i3, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.f32821c.a(str, i3, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.k
    public void b(int i3) throws IOException {
        this.f32821c.b(i3);
    }

    public boolean c() throws IOException {
        File file = this.f32821c.f32822a;
        Context e16 = e();
        File d16 = d(e16);
        if (!file.equals(d16)) {
            Log.d("SoLoader", "Native library directory updated from " + file + " to " + d16);
            int i3 = this.f32820b | 1;
            this.f32820b = i3;
            d dVar = new d(d16, i3);
            this.f32821c = dVar;
            dVar.b(this.f32820b);
            this.f32819a = e16;
            return true;
        }
        return false;
    }

    public Context e() {
        try {
            Context context = this.f32819a;
            return context.createPackageContext(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // com.facebook.soloader.k
    public String toString() {
        return this.f32821c.toString();
    }
}
