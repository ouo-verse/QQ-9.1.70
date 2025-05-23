package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bp extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public bp(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if ("open_file_expired".equals(this.f307440e)) {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openExpiredFilePageBySchema(this.f307437b);
            return true;
        }
        if (this.f307437b instanceof Activity) {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openMyFileBySchema((Activity) this.f307437b, f(IFileBrowserService.FILE_BROWSER_PAGE_FROM));
            return true;
        }
        QLog.e("OpenMyFileAction", 1, "jump mu file fail, content err");
        return false;
    }
}
