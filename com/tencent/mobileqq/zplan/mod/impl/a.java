package com.tencent.mobileqq.zplan.mod.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vi3.ModCloudConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/mod/impl/a;", "Lsi3/a;", "", "from", "Lvi3/b;", "cfg", "", "d0", "b", "Lvi3/b;", "mConfig", "<init>", "()V", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements si3.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ModCloudConfig mConfig = new ModCloudConfig(null, 1, null);

    public a() {
        ModCloudConfig modCloudConfig = (ModCloudConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100248");
        if (modCloudConfig != null) {
            d0("init data", modCloudConfig);
        }
    }

    @Override // si3.a
    public void d0(String from, ModCloudConfig cfg) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        this.mConfig = cfg;
        QLog.i("ModCloudConfigImpl_", 1, "onConfigUpdate from:" + from + ", cfg:" + cfg);
    }
}
