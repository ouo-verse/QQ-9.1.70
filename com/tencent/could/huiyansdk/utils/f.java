package com.tencent.could.huiyansdk.utils;

import com.google.gson.Gson;
import com.tencent.could.component.common.ai.net.IJsonDataListener;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.entity.ConfigEntity;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class f implements IJsonDataListener {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onFailed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        k.a.f100197a.a(2, "HuiYanSenderHelper", "get config error! " + str);
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        ConfigEntity configEntity = (ConfigEntity) new Gson().fromJson(str, ConfigEntity.class);
        if (configEntity == null) {
            k.a.f100197a.a(2, "HuiYanSenderHelper", "config entity is null");
        } else if (configEntity.getErrorCode() == 0) {
            HuiYanAuthImp.getInstance().setConfigEntity(configEntity);
        }
    }
}
