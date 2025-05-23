package com.qzone.reborn.feedx.util;

import com.tencent.mobileqq.utils.QQTheme;
import common.config.service.QZoneConfigHelper;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f55733a = QZoneConfigHelper.B();

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f55734b = com.qzone.reborn.configx.g.f53821a.b().k0();

    public static boolean a() {
        return f55733a && QQTheme.isVasTheme();
    }

    public static boolean b() {
        return f55734b && QQTheme.isVasTheme();
    }
}
