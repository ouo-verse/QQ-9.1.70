package com.tencent.qqnt.doutu.api.impl;

import com.tencent.mobileqq.config.aio.DoutuConfParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.doutu.api.IDoutuManageApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/doutu/api/impl/DoutuManageApiImpl;", "Lcom/tencent/qqnt/doutu/api/IDoutuManageApi;", "()V", "loadConfig", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class DoutuManageApiImpl implements IDoutuManageApi {
    static IPatchRedirector $redirector_;

    public DoutuManageApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuManageApi
    public void loadConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(DoutuConfParser.INSTANCE.b(), 1, "loadConfig");
        }
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(DoutuConfParser.INSTANCE.a());
    }
}
