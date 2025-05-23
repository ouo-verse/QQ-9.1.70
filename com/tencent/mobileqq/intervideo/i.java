package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;

/* compiled from: P */
/* loaded from: classes33.dex */
public class i implements g {

    /* renamed from: b, reason: collision with root package name */
    private final PluginManagerUpdater f238274b;

    /* renamed from: c, reason: collision with root package name */
    private final String f238275c;

    /* renamed from: e, reason: collision with root package name */
    private DynamicPluginManager f238277e;

    /* renamed from: a, reason: collision with root package name */
    private final String f238273a = "shadow::PluginManagerWrapper";

    /* renamed from: d, reason: collision with root package name */
    private IVPluginDataReporter f238276d = new IVPluginDataReporter();

    public i(String str, PluginManagerUpdater pluginManagerUpdater) {
        this.f238274b = pluginManagerUpdater;
        this.f238275c = str;
        this.f238277e = new DynamicPluginManager(pluginManagerUpdater);
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManager
    public void enter(Context context, long j3, Bundle bundle, EnterCallback enterCallback) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i("shadow::PluginManagerWrapper", 2, "enter formId:" + j3 + " enterCallback:" + enterCallback);
        }
        ((IPluginEnterManager) QRoute.api(IPluginEnterManager.class)).switchBiz(this.f238275c, this.f238277e);
        try {
            this.f238277e.enter(context, j3, bundle, enterCallback);
        } catch (Exception e16) {
            QLog.i("shadow::PluginManagerWrapper", 2, "enter exception :" + e16.getMessage());
            this.f238277e = new DynamicPluginManager(this.f238274b);
            ((IPluginEnterManager) QRoute.api(IPluginEnterManager.class)).switchBiz(this.f238275c, this.f238277e);
            this.f238277e.enter(context, j3, bundle, enterCallback);
        }
        if ("Now".equals(this.f238275c)) {
            str = "33669800";
        } else {
            str = "33669805";
        }
        Monitor.b(str);
        this.f238276d.opDepartment("shadow").opName(this.f238275c).opType(BaseConstants.BROADCAST_USERSYNC_ENTER).d1(j3 + "").report();
    }
}
