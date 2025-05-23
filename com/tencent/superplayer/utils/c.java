package com.tencent.superplayer.utils;

import com.tencent.thumbplayer.api.capability.TPHdrCapability;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f374001a = false;

    /* renamed from: b, reason: collision with root package name */
    private static StringBuilder f374002b = new StringBuilder();

    public static synchronized String a() {
        String sb5;
        synchronized (c.class) {
            if (!f374001a) {
                f374001a = true;
                for (int i3 = 0; i3 <= 3; i3++) {
                    if (b(i3)) {
                        f374002b.append(i3);
                        f374002b.append(",");
                    }
                }
                if (f374002b.length() > 0 && f374002b.lastIndexOf(",") == f374002b.length() - 1) {
                    StringBuilder sb6 = f374002b;
                    sb6.deleteCharAt(sb6.length() - 1);
                } else if (f374002b.length() == 0) {
                    f374002b.append("notSupport");
                }
            }
            sb5 = f374002b.toString();
        }
        return sb5;
    }

    public static boolean b(int i3) {
        try {
            if (1 != TPHdrCapability.getHdrCapability(i3)) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            LogUtil.e("isSupportHDR", e16);
            return false;
        }
    }
}
