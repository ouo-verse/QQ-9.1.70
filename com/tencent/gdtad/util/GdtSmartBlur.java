package com.tencent.gdtad.util;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtSmartBlur {

    /* renamed from: a, reason: collision with root package name */
    public boolean f109538a = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public static GdtSmartBlur f109539a = new GdtSmartBlur();
    }

    GdtSmartBlur() {
        c();
    }

    @NonNull
    public static GdtSmartBlur b() {
        return a.f109539a;
    }

    private native void blurBitmap(Bitmap bitmap, int i3, int i16);

    private void c() {
        try {
            System.loadLibrary("smart-blur");
            this.f109538a = true;
        } catch (Throwable th5) {
            QLog.e("GdtSmartBlur", 1, "load library error", th5);
            this.f109538a = false;
        }
    }

    public void a(Bitmap bitmap, int i3) {
        int numCores = AVCoreSystemInfo.getNumCores();
        if (numCores <= 0) {
            numCores = 1;
        }
        blurBitmap(bitmap, i3, numCores);
    }
}
