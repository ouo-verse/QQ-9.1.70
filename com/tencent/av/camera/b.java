package com.tencent.av.camera;

import android.content.Context;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.camera.api.ICameraUtilsStaticApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f73501a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static final Integer f73502b = 3;

    public static ICameraManagerApi a(Context context) {
        return ((ICameraUtilsStaticApi) QRoute.api(ICameraUtilsStaticApi.class)).getInstance(context);
    }
}
