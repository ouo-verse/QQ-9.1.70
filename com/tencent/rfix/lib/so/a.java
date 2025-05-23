package com.tencent.rfix.lib.so;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(InputStream inputStream, InputStream inputStream2, File file) {
        try {
            return com.tencent.tinker.bsdiff.a.a(inputStream, inputStream2, file);
        } catch (IOException e16) {
            e16.printStackTrace();
            return 1;
        }
    }

    public static int b(RandomAccessFile randomAccessFile, File file, File file2) {
        try {
            return com.tencent.tinker.bsdiff.a.d(randomAccessFile, file, file2, 0);
        } catch (IOException e16) {
            Log.e("PatchSo", "patchLessMemory error: ", e16);
            return 1;
        }
    }
}
