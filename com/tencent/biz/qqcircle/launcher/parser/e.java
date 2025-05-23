package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends a {
    private void o(Context context, QCircleSchemeBean qCircleSchemeBean) {
        if (qCircleSchemeBean != null && qCircleSchemeBean.getAttrs() != null) {
            HashMap<String, String> attrs = qCircleSchemeBean.getAttrs();
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            b(qCircleSchemeBean, qCircleInitBean);
            i(qCircleInitBean, attrs);
            j(qCircleInitBean, attrs);
            if (!attrs.containsKey("uin") && !attrs.containsKey(QCircleSchemeAttr.MainPage.EUID)) {
                return;
            }
            String str = attrs.get("uin");
            String str2 = attrs.get(QCircleSchemeAttr.MainPage.EUID);
            if (q(attrs, str)) {
                com.tencent.biz.qqcircle.f.v().U(1);
            }
            if (TextUtils.isEmpty(str)) {
                str = HostDataTransUtils.getAccount();
            }
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101818", true);
            if (TextUtils.isEmpty(str2) || !isSwitchOn) {
                str2 = str;
            }
            qCircleInitBean.setUin(str2);
            String str3 = attrs.get(QCircleSchemeAttr.MainPage.CLIENT_FROM);
            if (!TextUtils.isEmpty(str3)) {
                qCircleInitBean.setClientFromType(cu.c(str3, 0));
            } else if (TextUtils.equals(ISchemeApi.KEY_IOS_SRC_TYPE, attrs.get("web"))) {
                qCircleInitBean.setClientFromType(3);
            }
            if (p(qCircleSchemeBean)) {
                qCircleInitBean.setIsMiniPage(true);
            }
            com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
        }
    }

    private boolean p(QCircleSchemeBean qCircleSchemeBean) {
        HashMap<String, String> hashMap;
        if (qCircleSchemeBean != null) {
            hashMap = qCircleSchemeBean.getAttrs();
        } else {
            hashMap = null;
        }
        if (hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("mini") || !TextUtils.equals("1", hashMap.get("mini"))) {
            return false;
        }
        return true;
    }

    private boolean q(HashMap<String, String> hashMap, String str) {
        if (hashMap != null && "rank".equals(hashMap.get("frompage")) && com.tencent.biz.qqcircle.f.v().y() == 0 && QCirclePluginUtil.isOwner(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void f(Context context, QCircleSchemeBean qCircleSchemeBean) {
        o(context, qCircleSchemeBean);
    }
}
