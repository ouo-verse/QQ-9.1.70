package com.qzone.util;

import android.app.Application;
import android.content.Context;
import com.qzone.proxy.feedcomponent.FeedEnvImpl;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.common.app.BaseApplicationImpl;

/* compiled from: P */
/* loaded from: classes37.dex */
public class i {
    public static Application a() {
        return BaseApplicationImpl.getApplication();
    }

    public static Context b() {
        return a().getApplicationContext();
    }

    public static com.qzone.adapter.feedcomponent.i c() {
        return (com.qzone.adapter.feedcomponent.i) com.qzone.app.f.a(FeedEnvImpl.class);
    }

    public static FeedGlobalEnv d() {
        return (FeedGlobalEnv) com.qzone.app.f.a(com.qzone.proxy.feedcomponent.g.class);
    }

    public static com.qzone.adapter.feedcomponent.o e() {
        return (com.qzone.adapter.feedcomponent.o) com.qzone.app.f.a(com.qzone.proxy.feedcomponent.f.class);
    }
}
