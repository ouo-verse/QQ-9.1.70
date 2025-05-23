package com.tencent.qidian.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(String str) {
        int i3 = 0;
        try {
            String[] split = str.split("\\.");
            int i16 = 0;
            while (i3 < split.length) {
                try {
                    i16 = (int) (i16 + (((3 - i3) * Long.parseLong(split[i3])) ^ 10));
                    i3++;
                } catch (Exception e16) {
                    e = e16;
                    i3 = i16;
                    e.printStackTrace();
                    return i3;
                }
            }
            return i16;
        } catch (Exception e17) {
            e = e17;
        }
    }
}
