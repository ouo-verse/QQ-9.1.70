package od0;

import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static void a(HashMap<String, String> hashMap) {
        Iterator<String> it = hashMap.keySet().iterator();
        StringBuilder sb5 = null;
        while (it.hasNext()) {
            String next = it.next();
            if (!next.equals(ISchemeApi.KEY_IOS_SRC_TYPE) && !next.equals("version") && !next.equals("from_leba") && !next.equals("leba_resid") && !next.equals("config_res_plugin_item_name") && !next.equals("redtouch_click_timestamp") && !next.equals("lebaVersion") && !next.equals("redid")) {
                if (QLog.isColorLevel()) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder();
                    } else {
                        sb5.append(QbAddrData.DATA_SPLITER);
                    }
                    sb5.append(next);
                }
                it.remove();
            }
        }
        if (sb5 != null && QLog.isColorLevel()) {
            QLog.d("Q.qqstory.share.trans.helper", 2, "remove attrs:" + ((Object) sb5));
        }
    }
}
