package com.tencent.mobileqq.zplan.utils;

import android.graphics.Color;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    public static final String f335761a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f335762b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f335763c;

    static {
        String str = MobileQQ.sMobileQQ.getApplicationContext().getFilesDir() + "/crossengine";
        f335761a = str;
        f335762b = str + "/CrossEngine_Assets/";
        f335763c = Color.parseColor(((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZPlanAvatarBackgroundColor());
    }
}
