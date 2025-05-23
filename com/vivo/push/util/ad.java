package com.vivo.push.util;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ad extends c {

    /* renamed from: b, reason: collision with root package name */
    private static ad f387870b;

    public static synchronized ad b() {
        ad adVar;
        synchronized (ad.class) {
            if (f387870b == null) {
                f387870b = new ad();
            }
            adVar = f387870b;
        }
        return adVar;
    }

    public final synchronized void a(Context context) {
        if (this.f387891a == null) {
            this.f387891a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] b16 = b(b("com.vivo.push.secure_cache_iv", ""));
        if (b16 == null || b16.length <= 0) {
            return new byte[]{WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 32, 33, 37, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 32, 33, 33, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 41, 35, 32, 32, 32};
        }
        return b16;
    }

    public final byte[] d() {
        byte[] b16 = b(b("com.vivo.push.secure_cache_key", ""));
        if (b16 == null || b16.length <= 0) {
            return new byte[]{33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, 35, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 33};
        }
        return b16;
    }

    private static byte[] b(String str) {
        int i3;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i3 = split.length;
            } else {
                i3 = 0;
            }
            for (int i16 = 0; i16 < i3; i16++) {
                bArr[i16] = Byte.parseByte(split[i16].trim());
            }
        } catch (Exception e16) {
            u.a("SharePreferenceManager", "getCodeBytes error:" + e16.getMessage());
        }
        return bArr;
    }
}
