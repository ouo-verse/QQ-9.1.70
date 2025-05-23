package com.tencent.qqnt.avatar.meta;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f352911a;

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f352912b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f352911a = "0123456789abcdef".toCharArray();
            f352912b = new char[64];
        }
    }

    @NonNull
    private static String a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            char[] cArr2 = f352911a;
            cArr[i17] = cArr2[i16 >>> 4];
            cArr[i17 + 1] = cArr2[i16 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    public static int b(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + HippyTKDListViewAdapter.X + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    @NonNull
    public static String c(@NonNull byte[] bArr) {
        String a16;
        char[] cArr = f352912b;
        synchronized (cArr) {
            a16 = a(bArr, cArr);
        }
        return a16;
    }
}
