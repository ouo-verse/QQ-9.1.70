package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class al extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public al(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            Uri parse = Uri.parse(this.f307438c);
            String queryParameter = parse.getQueryParameter("_miniapptype");
            ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).reportIfNeed(this.f307438c);
            HashMap<String, Object> hashMap = null;
            if (TextUtils.equals(queryParameter, "2")) {
                String queryParameter2 = parse.getQueryParameter("_mappid");
                String queryParameter3 = parse.getQueryParameter("_path");
                String queryParameter4 = parse.getQueryParameter("_vt");
                if (TextUtils.isEmpty(queryParameter4)) {
                    parseInt = 3;
                } else {
                    parseInt = Integer.parseInt(queryParameter4);
                }
                int resetQQMiniAppVtToWxMiniAppVt = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).resetQQMiniAppVtToWxMiniAppVt(parseInt);
                int formatHostScene = ((IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class)).formatHostScene(parse.getQueryParameter("host_scene"), 0);
                String queryParameter5 = parse.getQueryParameter(StartupReportKey.SCENE_NOTE);
                if (!TextUtils.isEmpty(queryParameter5)) {
                    hashMap = new HashMap<>();
                    hashMap.put(StartupReportKey.SCENE_NOTE, queryParameter5);
                }
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(this.f307437b, queryParameter2, queryParameter3, formatHostScene, resetQQMiniAppVtToWxMiniAppVt, parse, hashMap);
                return true;
            }
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.f307437b, this.f307438c, 2016, null);
        } catch (Exception e16) {
            QLog.e("HttpOpenMiniAppAndAdAction", 1, "doAction error: " + e16.getMessage());
            i("HttpOpenMiniAppAndAdAction");
            return false;
        }
    }
}
