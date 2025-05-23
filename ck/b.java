package ck;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b {
    public String a(QZoneSchemeBean qZoneSchemeBean) {
        String str;
        return (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null || (str = qZoneSchemeBean.getAttrs().get("adId")) == null) ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        return "QZoneIntimateSpaceBaseSchemeParser";
    }

    public abstract void e(Context context, QZoneSchemeBean qZoneSchemeBean);

    public int b(QZoneSchemeBean qZoneSchemeBean) {
        String str;
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null || (str = qZoneSchemeBean.getAttrs().get("insertspacepage")) == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            QLog.e(c(), 1, "[getInsertSpacePage] error = " + e16.toString());
            return 0;
        }
    }

    public int d(QZoneSchemeBean qZoneSchemeBean) {
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return 0;
        }
        String str = qZoneSchemeBean.getAttrs().get("spacetype");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            RFWLog.e(c(), RFWLog.USR, "[getSpaceType] error = " + e16.toString());
            return 0;
        }
    }
}
