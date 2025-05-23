package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.beans.QCircleHalfScreenInitBean;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.net.URLDecoder;
import java.util.HashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes4.dex */
public class c extends a {
    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void f(Context context, QCircleSchemeBean qCircleSchemeBean) {
        if (qCircleSchemeBean != null && qCircleSchemeBean.getAttrs() != null) {
            HashMap<String, String> attrs = qCircleSchemeBean.getAttrs();
            if (!attrs.containsKey("url")) {
                QLog.e("QCircleHalfScreenWebSchemeParser", 1, "[parse] not contain web view url params");
                return;
            }
            QCircleHalfScreenInitBean o16 = o(attrs, qCircleSchemeBean);
            boolean r16 = bz.r();
            boolean d16 = r30.c.f430661a.d();
            QLog.d("QCircleHalfScreenWebSchemeParser", 1, "[parse] isPadOrFold:" + r16 + ", configEnable:" + d16 + ", feedId:" + o16.getFeedId() + ", height:" + o16.getHeightRatio() + ", h5Url:" + o16.getH5Url());
            if (!r16 && d16) {
                com.tencent.biz.qqcircle.launcher.c.N(context, o16);
                return;
            } else {
                com.tencent.biz.qqcircle.launcher.c.g(context, o16.getH5Url());
                return;
            }
        }
        QLog.e("QCircleHalfScreenWebSchemeParser", 1, "[parse] bean error");
    }

    public QCircleHalfScreenInitBean o(HashMap<String, String> hashMap, QCircleSchemeBean qCircleSchemeBean) {
        QCircleHalfScreenInitBean qCircleHalfScreenInitBean = new QCircleHalfScreenInitBean();
        String decode = URLDecoder.decode(hashMap.get("url"));
        qCircleHalfScreenInitBean.setH5Url(decode);
        try {
            HashMap<String, String> c16 = com.tencent.biz.qqcircle.d.c(decode);
            if (c16 != null) {
                qCircleHalfScreenInitBean.setFeedId(c16.get("feedid"));
            }
            if (hashMap.containsKey("height")) {
                qCircleHalfScreenInitBean.setHeightRatio(Float.parseFloat(hashMap.get("height")));
            }
        } catch (Exception e16) {
            QLog.d("QCircleHalfScreenWebSchemeParser", 1, "[parseCommonParams] param parse error:" + e16.toString());
        }
        b(qCircleSchemeBean, qCircleHalfScreenInitBean);
        return qCircleHalfScreenInitBean;
    }
}
