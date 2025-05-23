package com.qq.e.comm.plugin.c;

import androidx.viewpager.widget.ViewPager;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static boolean a() {
        return false;
    }

    public static PublicApi.CanvasApi b() {
        return (PublicApi.CanvasApi) PublicApiHelper.getModuleApi(PublicApi.CanvasApi.class);
    }

    public static boolean c() {
        Class<ViewPager> cls;
        try {
            cls = ViewPager.class;
            int i3 = ViewPager.SCROLL_STATE_IDLE;
        } catch (Throwable th5) {
            GDTLogger.e("appendEnvInfoIntoPassThroughData error ", th5);
            cls = null;
        }
        if (cls != null) {
            return true;
        }
        return false;
    }
}
