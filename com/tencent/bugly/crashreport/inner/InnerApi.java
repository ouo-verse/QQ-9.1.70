package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.proguard.av;
import com.tencent.bugly.proguard.bj;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i3, String str, String str2, String str3, Map<String, String> map) {
        if (str != null && str2 != null && str3 != null) {
            if (i3 != 5 && i3 != 6) {
                av.e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i3));
                return;
            } else {
                av.a("post cocos2d-x crash %s %s", str, str2);
                bj.a(Thread.currentThread(), i3, str, str2, str3, map);
                return;
            }
        }
        av.e("post cocos2d-x fail args null", new Object[0]);
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str != null && str2 != null && str3 != null) {
            av.a("post h5 crash %s %s", str, str2);
            bj.a(thread, 8, str, str2, str3, map);
        } else {
            av.e("post h5 fail args null", new Object[0]);
        }
    }

    public static void postU3dCrashAsync(String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null) {
            av.e("post u3d fail args null", new Object[0]);
        }
        av.a("post u3d crash %s %s", str, str2);
        bj.a(Thread.currentThread(), 4, str, str2, str3, map);
    }
}
