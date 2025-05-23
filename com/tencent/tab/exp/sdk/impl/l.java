package com.tencent.tab.exp.sdk.impl;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.tencent.mtt.abtestsdk.BuildConfig;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class l {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a implements MMKV.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f374133a;

        a(Application application) {
            this.f374133a = application;
        }

        @Override // com.tencent.mmkv.MMKV.b
        public void loadLibrary(String str) {
            try {
                com.getkeepsafe.relinker.b.a(this.f374133a, str);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(@NonNull Application application) {
        b.b(application);
        c(application);
    }

    private static void b(@NonNull Application application) {
        application.getSharedPreferences("BuglySdkInfos", 0).edit().putString("4aeafa6143", BuildConfig.VERSION_NAME).apply();
    }

    private static void c(@NonNull Application application) {
        b(application);
        d(application);
        e(application);
    }

    private static void d(@NonNull Application application) {
        File filesDir = application.getFilesDir();
        if (filesDir == null) {
            return;
        }
        String absolutePath = filesDir.getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath)) {
            return;
        }
        MMKV.W(absolutePath + File.separator + "mmkv", new a(application));
    }

    private static void e(@NonNull Application application) {
        nd4.o.a(application);
    }
}
