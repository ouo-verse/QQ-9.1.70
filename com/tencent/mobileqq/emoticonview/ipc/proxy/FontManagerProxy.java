package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* loaded from: classes12.dex */
public class FontManagerProxy extends AbsEmoRuntimeServiceProxy<IFontManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_FONTMANAGER_ISSUPPORTFONT = "fontmanager_issupportfont";
    private static final String SUPPORT_FONT = "SupportFont";
    public static final String TAG = "FontManagerProxy";

    public FontManagerProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IFontManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult onIsSupportFont(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        boolean isSupportFont = ((IFontManagerService) baseQQAppInterface.getRuntimeService(IFontManagerService.class)).isSupportFont();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(SUPPORT_FONT, isSupportFont);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public boolean isSupportFont() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.manager != 0) {
            return ((IFontManagerService) this.mApp.getRuntimeService(IFontManagerService.class)).isSupportFont();
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_FONTMANAGER_ISSUPPORTFONT, null);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(SUPPORT_FONT);
        }
        QLog.e(TAG, 4, "isSupportFont fail.");
        return false;
    }
}
