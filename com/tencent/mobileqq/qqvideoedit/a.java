package com.tencent.mobileqq.qqvideoedit;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    public static AppInterface a() {
        return (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("peak");
    }

    public static AppRuntime b() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static Context c() {
        return MobileQQ.sMobileQQ;
    }
}
