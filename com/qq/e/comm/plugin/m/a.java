package com.qq.e.comm.plugin.m;

import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static boolean a() {
        if (PublicApiHelper.getModuleApi(PublicApi.VideoCacheApi.class) != null) {
            return true;
        }
        return false;
    }

    public static PublicApi.VideoCacheApi b() {
        return (PublicApi.VideoCacheApi) PublicApiHelper.getModuleApi(PublicApi.VideoCacheApi.class);
    }
}
