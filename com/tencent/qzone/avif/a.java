package com.tencent.qzone.avif;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(File file) {
        if (file != null) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        boolean b16 = AvifImageDetector.b(bufferedInputStream2);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        return b16;
                    } catch (IOException e17) {
                        e = e17;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                                return false;
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e26) {
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            return false;
        }
    }

    public static boolean b(String str) {
        if (str != null && str.length() != 0) {
            return "8".equals(Uri.parse(str).getQueryParameter("t"));
        }
        return false;
    }
}
