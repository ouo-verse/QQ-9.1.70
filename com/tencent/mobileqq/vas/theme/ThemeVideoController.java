package com.tencent.mobileqq.vas.theme;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.IThemeEffectApi;
import com.tencent.mobileqq.vas.theme.api.IThemeVideoController;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeVideoController {
    private static IThemeVideoController instance;

    public static void destroy() {
        instance = null;
    }

    public static synchronized IThemeVideoController getInstance() {
        IThemeVideoController iThemeVideoController;
        synchronized (ThemeVideoController.class) {
            if (instance == null) {
                instance = ((IThemeEffectApi) QRoute.api(IThemeEffectApi.class)).createThemeVideoController();
            }
            iThemeVideoController = instance;
        }
        return iThemeVideoController;
    }
}
