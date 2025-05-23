package com.tencent.mobileqq.leba.business.plugins;

import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.AppSetting;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/e;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "", "mode", "style", "", "l", "", "v", "()J", "resId", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean l(int mode, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
        }
        return !AppSetting.isGrayVersion();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 777L;
    }
}
