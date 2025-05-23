package com.tencent.mobileqq.vas.vipicon.api;

import android.content.res.Resources;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public final /* synthetic */ class b {
    static {
        IVipIconFactory.Companion companion = IVipIconFactory.INSTANCE;
    }

    @JvmStatic
    public static float a(@NotNull Resources resources) {
        return IVipIconFactory.INSTANCE.getIconHeight(resources);
    }

    @JvmStatic
    public static float b(@NotNull Resources resources) {
        return IVipIconFactory.INSTANCE.getIconWidth(resources);
    }
}
