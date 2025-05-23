package com.tencent.bugly.impl;

import android.content.Context;
import com.tencent.bugly.common.config.creator.CommonConfigCreator;
import com.tencent.bugly.crashreport.common.config.CrashConfigCreator;
import com.tencent.bugly.library.BuglyBuilder;
import com.tencent.feedback.eup.a;
import com.tencent.rmonitor.base.config.creator.DefaultConfigCreator;
import com.tencent.rmonitor.base.config.creator.LagConfigCreator;
import com.tencent.rmonitor.base.config.creator.MemoryConfigCreator;
import com.tencent.rmonitor.base.config.creator.ResourceConfigCreator;
import com.tencent.rmonitor.base.config.data.ConfigCreatorProxy;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.manager.LinkDataWrapper;
import com.tencent.rmonitor.manager.e;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BuglyInitializer {
    public static void init(Context context, BuglyBuilder buglyBuilder) {
        initJsonProtocol();
        initConfig();
        initPluginFactory();
        LinkDataWrapper.initLinkage(context, buglyBuilder.appId);
    }

    private static void initConfig() {
        Logger.f365497g.w("RMonitor_init", "initConfig");
        ConfigCreatorProxy.d().a(new CrashConfigCreator());
        ConfigCreatorProxy.d().a(new LagConfigCreator());
        ConfigCreatorProxy.d().a(new MemoryConfigCreator());
        ConfigCreatorProxy.d().a(new DefaultConfigCreator());
        ConfigCreatorProxy.d().a(new ResourceConfigCreator());
        ConfigCreatorProxy.d().a(new CommonConfigCreator());
    }

    private static void initJsonProtocol() {
        Logger.f365497g.w("RMonitor_init", "initJsonProtocol");
        a.s(true);
    }

    private static void initPluginFactory() {
        Logger.f365497g.w("RMonitor_init", "initPluginFactory");
        e.f365703f.k(new PluginFactoryImpl());
    }
}
