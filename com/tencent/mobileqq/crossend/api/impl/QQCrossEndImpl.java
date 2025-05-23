package com.tencent.mobileqq.crossend.api.impl;

import com.tencent.mobileqq.crossend.api.IQQCrossEnd;
import com.tencent.mobileqq.crossend.communication.base.b;
import com.tencent.mobileqq.crossend.communication.base.e;
import com.tencent.mobileqq.crossend.communication.base.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.zplan.luabridge.LuaBasePlugin;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQCrossEndImpl implements IQQCrossEnd {
    static IPatchRedirector $redirector_;

    public QQCrossEndImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.crossend.api.IQQCrossEnd
    public HippyAPIProvider getQQCrossHippyAPIProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HippyAPIProvider) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.crossend.api.IQQCrossEnd
    public LuaBasePlugin getQQCrossLuaPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LuaBasePlugin) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new e();
    }

    @Override // com.tencent.mobileqq.crossend.api.IQQCrossEnd
    public String getQQCrossMiniEntryKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "QQWebApi";
    }

    @Override // com.tencent.mobileqq.crossend.api.IQQCrossEnd
    public Class getQQCrossMiniPluginClazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return g.class;
    }
}
