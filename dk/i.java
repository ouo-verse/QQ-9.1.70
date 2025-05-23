package dk;

import android.content.Context;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i extends ck.b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ck.b
    public String c() {
        return "QZoneIntimateWriteMoodPageParser";
    }

    @Override // ck.b
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str = qZoneSchemeBean.getAttrs().get("spaceid");
        if (str == null) {
            RFWLog.e(c(), RFWLog.USR, "[parseScheme] spaceid is null");
            return;
        }
        int d16 = d(qZoneSchemeBean);
        QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = new QZoneIntimateWriteMoodInitBean();
        qZoneIntimateWriteMoodInitBean.setSpaceId(str);
        qZoneIntimateWriteMoodInitBean.setSpaceType(d16);
        qZoneIntimateWriteMoodInitBean.setInsertSpacePage(b(qZoneSchemeBean));
        qZoneIntimateWriteMoodInitBean.setAdId(a(qZoneSchemeBean));
        ho.i.o().u(context, qZoneIntimateWriteMoodInitBean);
    }
}
