package com.tencent.oskplayer.util;

import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class Util {
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    public static final int SDK_INT = Build.VERSION.SDK_INT;

    Util() {
    }

    public static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j3) {
        int i3 = SDK_INT;
        if (i3 != 19 && i3 != 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j3 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j3 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (IOException | Exception unused) {
        }
    }
}
