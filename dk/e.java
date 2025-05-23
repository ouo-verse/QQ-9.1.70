package dk;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.reborn.intimate.bean.QZoneIntimateUserBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends ck.b {
    private int f(String str) {
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

    private ArrayList<QZoneIntimateUserBean> g(String str) {
        ArrayList<QZoneIntimateUserBean> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String[] split = str.split(",");
        if (split.length < 1) {
            return arrayList;
        }
        for (String str2 : split) {
            QZoneIntimateUserBean qZoneIntimateUserBean = new QZoneIntimateUserBean();
            qZoneIntimateUserBean.setUid(str2);
            arrayList.add(qZoneIntimateUserBean);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00bf  */
    @Override // ck.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        int parseInt;
        if (qZoneSchemeBean != null && qZoneSchemeBean.getAttrs() != null) {
            String str = qZoneSchemeBean.getAttrs().get("spaceid");
            String str2 = qZoneSchemeBean.getAttrs().get("tabid");
            String str3 = qZoneSchemeBean.getAttrs().get("from");
            String str4 = qZoneSchemeBean.getAttrs().get("adId");
            String str5 = qZoneSchemeBean.getAttrs().get("isdraft");
            String str6 = qZoneSchemeBean.getAttrs().get("key_scheme");
            String str7 = qZoneSchemeBean.getAttrs().get("uids");
            String str8 = qZoneSchemeBean.getAttrs().get("spacetype");
            QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
            if (str != null) {
                qZoneIntimateMainPageInitBean.setSpaceId(str);
            }
            if (str3 != null) {
                qZoneIntimateMainPageInitBean.setFrom(str3);
                qZoneIntimateMainPageInitBean.setFromQRCode(TextUtils.equals(str3, "10"));
            }
            if (str4 != null) {
                qZoneIntimateMainPageInitBean.setAdId(str4);
            }
            if (str6 != null) {
                qZoneIntimateMainPageInitBean.setJumpSchema(str6);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    parseInt = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    QLog.e("QZoneIntimateMainPageParser", 1, "[parseScheme] tabId format error, tabId = " + str2);
                }
                qZoneIntimateMainPageInitBean.setTabId(parseInt);
                if (str5 != null) {
                    qZoneIntimateMainPageInitBean.setDraft(TextUtils.equals(str5, "1"));
                }
                if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                    h(str7, str8, qZoneIntimateMainPageInitBean);
                }
                ho.i.o().r(context, qZoneIntimateMainPageInitBean);
                return;
            }
            parseInt = 0;
            qZoneIntimateMainPageInitBean.setTabId(parseInt);
            if (str5 != null) {
            }
            if (!TextUtils.isEmpty(str7)) {
                h(str7, str8, qZoneIntimateMainPageInitBean);
            }
            ho.i.o().r(context, qZoneIntimateMainPageInitBean);
            return;
        }
        QLog.e("QZoneIntimateMainPageParser", 1, "[parseScheme] schemeBean or attrs is null");
    }

    private void h(String str, String str2, QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean) {
        if (qZoneIntimateMainPageInitBean == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean = new QZoneIntimateActivateSpaceBean();
        qZoneIntimateActivateSpaceBean.setSpaceType(f(str2));
        qZoneIntimateActivateSpaceBean.setUsers(g(str));
        qZoneIntimateMainPageInitBean.setActivateSpaceBean(qZoneIntimateActivateSpaceBean);
    }
}
