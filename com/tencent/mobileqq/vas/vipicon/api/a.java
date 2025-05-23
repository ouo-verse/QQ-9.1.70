package com.tencent.mobileqq.vas.vipicon.api;

import android.content.res.Resources;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public final /* synthetic */ class a {
    static {
        IVipIconExFactory.Companion companion = IVipIconExFactory.INSTANCE;
    }

    @JvmStatic
    public static float a(@NotNull Resources resources) {
        return IVipIconExFactory.INSTANCE.getIconHeight(resources);
    }

    @JvmStatic
    public static float b(@NotNull Resources resources) {
        return IVipIconExFactory.INSTANCE.getIconWidth(resources);
    }
}
