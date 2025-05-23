package dk;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f extends ck.b {
    @Override // ck.b
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str = qZoneSchemeBean.getAttrs().get("uid");
        QZoneIntimateManageInitBean qZoneIntimateManageInitBean = new QZoneIntimateManageInitBean();
        if (str != null) {
            qZoneIntimateManageInitBean.setUid(str);
        } else {
            qZoneIntimateManageInitBean.setUid(LoginData.getInstance().getUid());
        }
        String str2 = qZoneSchemeBean.getAttrs().get("from");
        if (str2 != null) {
            qZoneIntimateManageInitBean.setFrom(str2);
        }
        if (TextUtils.equals(qZoneSchemeBean.getAttrs().get("opencreatepage"), "1")) {
            qZoneIntimateManageInitBean.setOpenCreatePage(true);
        }
        QLog.i("QZoneIntimateAlbumDetailPageParser", 1, "parseScheme  | uid = " + str + " | from = " + str2);
        ho.i.o().s(context, qZoneIntimateManageInitBean);
    }
}
