package com.tencent.mobileqq.guild.util;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
/* loaded from: classes14.dex */
public class bz {
    public static AppInterface a() {
        return (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime();
    }

    public static <T extends IRuntimeService> T b(@NonNull Class<T> cls) {
        return (T) c(cls, "");
    }

    public static <T extends IRuntimeService> T c(@NonNull Class<T> cls, String str) {
        return (T) a().getRuntimeService(cls, str);
    }
}
