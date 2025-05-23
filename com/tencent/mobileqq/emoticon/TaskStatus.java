package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TaskStatus {
    static IPatchRedirector $redirector_;
    private String epId;
    private AtomicBoolean isCanceled;
    private float percent;
    private final com.tencent.mobileqq.vip.g task;

    public TaskStatus(String str, com.tencent.mobileqq.vip.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) gVar);
            return;
        }
        this.isCanceled = new AtomicBoolean();
        this.epId = str;
        this.task = gVar;
    }

    public void cancel(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface);
            return;
        }
        this.isCanceled.set(true);
        com.tencent.mobileqq.vip.g gVar = this.task;
        if (gVar != null) {
            gVar.c(true);
            return;
        }
        String str = VasUpdateConstants.SCID_H5_MAGIC_ZIP + this.epId + ".zip";
        IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) appInterface.getRuntimeService(IVasQuickUpdateService.class, "");
        if (iVasQuickUpdateService != null) {
            iVasQuickUpdateService.cancelDwonloadItem(1004L, str);
        }
    }

    public Bundle getParams(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface);
        }
        com.tencent.mobileqq.vip.g gVar = this.task;
        if (gVar != null) {
            return gVar.h();
        }
        return ((IVasEmojiManager) ((IEmosmService) QRoute.api(IEmosmService.class)).getVasEmojiManager(appInterface)).getParamMap().get(this.epId);
    }

    public float getPercent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        com.tencent.mobileqq.vip.g gVar = this.task;
        if (gVar != null) {
            return gVar.f313015m;
        }
        return this.percent;
    }

    public boolean isCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isCanceled.get();
    }

    public void setPercent(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.percent = f16;
        }
    }
}
