package com.tencent.biz.qqcircle.launcher;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {
    public static void a(HashMap<String, String> hashMap) {
        if (b(hashMap) || d(hashMap)) {
            return;
        }
        e(hashMap);
    }

    public static boolean b(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return false;
        }
        String str = hashMap.get(QCircleSchemeAttr.Detail.BUSINESS_EXIT_SCHEME);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QCircleSchemeLauncher.d(RFWApplication.getApplication(), str);
        return true;
    }

    public static boolean c(QCircleInitBean qCircleInitBean) {
        String str;
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null && (str = qCircleInitBean.getSchemeAttrs().get(QCircleSchemeAttr.Detail.BUSINESS_EXIT_SCHEME)) != null && str.startsWith(QCircleSchemeAttr.ExitSchemeValue.EXIT_SCHEME_FINISH_AFFINITY_QQ_HUAWEI)) {
            try {
                String replace = str.replace(QCircleSchemeAttr.ExitSchemeValue.EXIT_SCHEME_FINISH_AFFINITY_QQ_HUAWEI, QCircleSchemeAttr.ExitSchemeValue.EXIT_SCHEME_DEEP_LINK_HUAWEI_SEARCH);
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setData(Uri.parse(replace));
                intent.setFlags(268435456);
                QCircleApplication.getAPP().getBaseContext().startActivity(intent);
                return true;
            } catch (Exception e16) {
                QLog.e("QFSBackToBusinessHelper", 1, "handleJumpHuaWeiScheme" + e16);
            }
        }
        return false;
    }

    public static boolean d(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return false;
        }
        String str = hashMap.get("mini_app_id");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(RFWApplication.getApplication(), str, "", "", 1131, null);
        return true;
    }

    public static boolean e(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return false;
        }
        String str = hashMap.get(QCircleScheme.AttrQQPublish.MINI_GAME_ID);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(RFWApplication.getApplication(), str, "", "", 1131, null);
        return true;
    }
}
