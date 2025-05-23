package com.qq.e.comm.plugin.l;

import android.text.TextUtils;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static boolean a() {
        return false;
    }

    public static PublicApi.VelenApi b() {
        return (PublicApi.VelenApi) PublicApiHelper.getModuleApi(PublicApi.VelenApi.class);
    }

    public static boolean a(int i3) {
        String a16 = c.a((String) null, "velen_switch_for_pos_type", "");
        String valueOf = String.valueOf(i3);
        try {
            if (TextUtils.isEmpty(a16)) {
                return false;
            }
            return Arrays.asList(a16.split(",")).contains(valueOf);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
