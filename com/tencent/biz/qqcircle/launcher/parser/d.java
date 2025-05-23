package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleHalfScreenInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends a {
    private boolean o(Context context, @NonNull QCircleSchemeBean qCircleSchemeBean, @NonNull HashMap<String, String> hashMap) {
        if (!TextUtils.equals(hashMap.get(QCircleSchemeAttr.WebView.OPEN_TYPE), "half")) {
            return false;
        }
        if (bz.r()) {
            QLog.d("QCircleBaseSchemeParser", 1, "[jumpByHalfH5] is pad");
            return false;
        }
        r30.c cVar = r30.c.f430661a;
        if (!cVar.d()) {
            QLog.d("QCircleBaseSchemeParser", 1, "[jumpByHalfH5] config close");
            return false;
        }
        QCircleHalfScreenInitBean q16 = q(hashMap, qCircleSchemeBean);
        boolean h16 = cVar.h(q16.getH5Url());
        QLog.d("QCircleBaseSchemeParser", 1, "[jumpByHalfH5] feedId:" + q16.getFeedId() + ", height:" + q16.getHeightRatio() + ", isKuiklyScheme:" + h16 + ", h5Url:" + q16.getH5Url());
        if (h16) {
            if (!cVar.e(q16.getH5Url())) {
                com.tencent.biz.qqcircle.launcher.c.O(context, q16);
            }
        } else if (!cVar.f(q16.getH5Url())) {
            com.tencent.biz.qqcircle.launcher.c.N(context, q16);
        }
        return true;
    }

    private void p(Context context, QCircleSchemeBean qCircleSchemeBean) {
        HashMap<String, String> attrs;
        if (qCircleSchemeBean != null && (attrs = qCircleSchemeBean.getAttrs()) != null && attrs.containsKey("url")) {
            try {
                String decode = URLDecoder.decode(attrs.get("url"));
                if (decode.startsWith("https://h5.qzone.qq.com/v2/wezone/message")) {
                    HashMap<String, String> c16 = com.tencent.biz.qqcircle.d.c(decode);
                    QCircleSchemeBean qCircleSchemeBean2 = new QCircleSchemeBean();
                    qCircleSchemeBean2.setAttrs(c16);
                    qCircleSchemeBean2.setSchemeAction(QCircleScheme.Q_CIRCLE_ACTION_OPEN_MESSAGE_PAGE);
                    QCircleSchemeLauncher.b(context, qCircleSchemeBean2);
                    return;
                }
                if (o(context, qCircleSchemeBean, attrs)) {
                    return;
                }
                Intent intent = new Intent();
                for (Map.Entry<String, String> entry : attrs.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
                com.tencent.biz.qqcircle.launcher.c.o0(context, decode, intent, -1);
            } catch (Exception e16) {
                QLog.e("QCircleBaseSchemeParser", 1, "parseUrl:" + attrs.get("url") + " error:" + e16.getMessage());
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void f(Context context, QCircleSchemeBean qCircleSchemeBean) {
        p(context, qCircleSchemeBean);
    }

    public QCircleHalfScreenInitBean q(@NonNull HashMap<String, String> hashMap, @NonNull QCircleSchemeBean qCircleSchemeBean) {
        String str;
        QCircleHalfScreenInitBean qCircleHalfScreenInitBean = new QCircleHalfScreenInitBean();
        String decode = URLDecoder.decode(hashMap.get("url"));
        String str2 = hashMap.get(QCircleSchemeAttr.WebView.OPEN_TYPE);
        if (!TextUtils.isEmpty(decode) && TextUtils.equals(str2, "half")) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(decode);
            if (decode.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str = "&is_qfs_half_pannel=1";
            } else {
                str = "?is_qfs_half_pannel=1";
            }
            sb5.append(str);
            decode = sb5.toString();
        }
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
            QLog.d("QCircleBaseSchemeParser", 1, "[parseCommonParams] param parse error:" + e16.toString());
        }
        b(qCircleSchemeBean, qCircleHalfScreenInitBean);
        return qCircleHalfScreenInitBean;
    }
}
