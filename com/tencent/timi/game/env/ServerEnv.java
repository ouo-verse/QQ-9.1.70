package com.tencent.timi.game.env;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.SSODebugUtil;
import eh4.b;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ServerEnv {

    /* renamed from: a, reason: collision with root package name */
    private static int f376875a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<Integer, b> f376876b = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public @interface ServerType {
    }

    public static b a() {
        int c16 = c();
        if (f376876b.containsKey(Integer.valueOf(c16))) {
            return f376876b.get(Integer.valueOf(c16));
        }
        b b16 = b.b(c16);
        f376876b.put(Integer.valueOf(c16), b16);
        return b16;
    }

    public static String b() {
        if (c() != 1) {
            return "Online";
        }
        return "Test";
    }

    public static int c() {
        if (f376875a <= 0) {
            if (!TextUtils.isEmpty(SSODebugUtil.loadTestEnvironment()[0])) {
                f376875a = 1;
            } else if (MsfSdkUtils.isBuildTestEnvValid()) {
                f376875a = 1;
            } else {
                f376875a = 2;
            }
        }
        return f376875a;
    }

    public static boolean d() {
        if (c() == 2) {
            return true;
        }
        return false;
    }
}
