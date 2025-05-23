package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d extends k {

    /* renamed from: a, reason: collision with root package name */
    protected final File f32822a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f32823b;

    public d(File file, int i3) {
        this.f32822a = file;
        this.f32823b = i3;
    }

    private static String[] c(File file) throws IOException {
        boolean z16 = SoLoader.f32785a;
        if (z16) {
            a.a("SoLoader.getElfDependencies[", file.getName(), "]");
        }
        try {
            String[] a16 = MinElf.a(file);
            if (z16) {
                a.b();
            }
            return a16;
        } catch (Throwable th5) {
            if (SoLoader.f32785a) {
                a.b();
            }
            throw th5;
        }
    }

    private static void d(File file, int i3, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] c16 = c(file);
        Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(c16));
        for (String str : c16) {
            if (!str.startsWith("/")) {
                SoLoader.m(str, i3 | 1, threadPolicy);
            }
        }
    }

    @Override // com.facebook.soloader.k
    public int a(String str, int i3, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return e(str, i3, this.f32822a, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(String str, int i3, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            Log.d("SoLoader", str + " not found on " + file.getCanonicalPath());
            return 0;
        }
        Log.d("SoLoader", str + " found on " + file.getCanonicalPath());
        if ((i3 & 1) != 0 && (this.f32823b & 2) != 0) {
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        if ((this.f32823b & 1) != 0) {
            d(file2, i3, threadPolicy);
        } else {
            Log.d("SoLoader", "Not resolving dependencies for " + str);
        }
        try {
            SoLoader.f32786b.a(file2.getAbsolutePath(), i3);
            return 1;
        } catch (UnsatisfiedLinkError e16) {
            if (e16.getMessage().contains("bad ELF magic")) {
                Log.d("SoLoader", "Corrupted lib file detected");
                return 3;
            }
            throw e16;
        }
    }

    @Override // com.facebook.soloader.k
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.f32822a.getCanonicalPath());
        } catch (IOException unused) {
            name = this.f32822a.getName();
        }
        return getClass().getName() + "[root = " + name + " flags = " + this.f32823b + ']';
    }
}
