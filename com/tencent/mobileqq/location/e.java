package com.tencent.mobileqq.location;

import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile ILocationShareService f241285a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile IFloatMapService f241286b;

    public static IFloatMapService a(AppRuntime appRuntime) {
        IFloatMapService iFloatMapService = (IFloatMapService) appRuntime.getRuntimeService(IFloatMapService.class, "");
        if (f241286b != iFloatMapService) {
            iFloatMapService.addFloatMapCallback(new com.tencent.mobileqq.location.callback.c());
            f241286b = iFloatMapService;
        }
        return iFloatMapService;
    }

    public static ILocationShareService b(AppRuntime appRuntime) {
        ILocationShareService iLocationShareService = (ILocationShareService) appRuntime.getRuntimeService(ILocationShareService.class, "");
        if (f241285a != iLocationShareService) {
            iLocationShareService.addErrorShareStateCallback(new com.tencent.mobileqq.location.callback.a());
            iLocationShareService.addErrorShareStateCallback(new com.tencent.mobileqq.location.callback.b());
            f241285a = iLocationShareService;
        }
        return iLocationShareService;
    }
}
