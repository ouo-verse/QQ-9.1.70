package com.tencent.mobileqq.ark.api.scheme;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.module.h;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements h {
    public static EntryModel b() {
        AIOContact a16;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if ((baseActivity instanceof BaseActivity) && (a16 = com.tencent.qqnt.aio.utils.a.f352276a.a(baseActivity)) != null) {
            int e16 = a16.e();
            String j3 = a16.j();
            QLog.d("MiniAppSchemeHandler", 1, "chatType:" + e16 + " uid:" + j3);
            if (!TextUtils.isEmpty(j3) && e16 == 2) {
                return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).createEntryModel(((TroopManager) baseActivity.getAppInterface().getManager(QQManagerFactory.TROOP_MANAGER)).k(j3), j3);
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.h
    public boolean a(String str, String str2, JSONObject jSONObject, long j3, String str3, String str4) {
        Activity f16;
        if (j3 == 0 && (f16 = com.tencent.mobileqq.ark.module.b.f()) != null && str.startsWith("open/")) {
            try {
                int parseInt = Integer.parseInt(str.substring(5, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)));
                String str5 = URLUtil.getArgumentsFromURL(str).get("url");
                if (!((IMiniAppService) QRoute.api(IMiniAppService.class)).verifyArkScene(parseInt)) {
                    parseInt = 2059;
                }
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniApp(f16, str5, parseInt, b());
                return true;
            } catch (Exception e16) {
                QLog.e("ArkApp", 1, "parse miniapp scheme failed:" + str, e16);
            }
        }
        return false;
    }
}
