package com.qq.e.comm.plugin.k;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f39623a = new Random(System.currentTimeMillis());

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f39624b = null;

    public static void a() {
        f39624b = null;
    }

    public static boolean b() {
        SM sm5 = GDTADManager.getInstance().getSM();
        if (sm5 != null) {
            return a(sm5.getInteger("securityVulnerabilityReport", 10), 10000);
        }
        return false;
    }

    public static boolean a(int i3, int i16) {
        if (i3 <= 0 || i16 <= 0) {
            return false;
        }
        return i3 >= i16 || f39623a.nextInt(i16) < i3;
    }
}
