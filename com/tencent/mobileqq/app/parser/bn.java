package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class bn extends com.tencent.mobileqq.utils.ax {
    public bn(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        try {
            String queryParameter = Uri.parse(this.f307438c).getQueryParameter(MiniAppPlugin.ATTR_PAGE_TYPE);
            if (!TextUtils.isEmpty(queryParameter) && "desktop".equals(queryParameter)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).openDesktopWxAuthFragment();
            } else {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).openWxBindingPage();
            }
            return true;
        } catch (Exception e16) {
            QLog.e("OpenMiniAppSettingPageAction", 1, "doAction error: " + e16.getMessage());
            i("OpenMiniAppSettingPageAction");
            return false;
        }
    }
}
