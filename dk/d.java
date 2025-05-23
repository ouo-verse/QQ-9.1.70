package dk;

import android.content.Context;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateLoveTreeInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends ck.b {
    @Override // ck.b
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str = qZoneSchemeBean.getAttrs().get("uin");
        String str2 = qZoneSchemeBean.getAttrs().get(ProtocolDownloaderConstants.HEADER_FRIEND_UIN);
        String valueOf = String.valueOf(LoginData.getInstance().getUin());
        if ((!Objects.equals(str2, valueOf) && !Objects.equals(str, valueOf)) || !mk.a.f416872a.a()) {
            yo.d.c("https://act.qzone.qq.com/v2/vip/tx/p/52298_94797a1a?enteranceId=moren&_wv=2", context);
            return;
        }
        if (Objects.equals(str2, valueOf)) {
            str2 = str;
            str = valueOf;
        }
        String str3 = qZoneSchemeBean.getAttrs().get("enter_page");
        String str4 = qZoneSchemeBean.getAttrs().get("flower_id");
        String str5 = qZoneSchemeBean.getAttrs().get("from");
        QLog.i("QZoneIntimateLoveTreeParser", 1, "parseScheme  | uin = " + str + " | peer_uin = " + str2 + " | enter_page = " + str3 + " | from = " + str5 + " | flowerId = " + str4);
        QZoneIntimateLoveTreeInitBean qZoneIntimateLoveTreeInitBean = new QZoneIntimateLoveTreeInitBean();
        if (str2 != null) {
            qZoneIntimateLoveTreeInitBean.setPeerUin(str2);
        }
        if (str3 != null) {
            qZoneIntimateLoveTreeInitBean.setEnterPage(str3);
        }
        if (str4 != null) {
            qZoneIntimateLoveTreeInitBean.setFlowerId(str4);
        }
        if (str5 != null) {
            qZoneIntimateLoveTreeInitBean.setFrom(str5);
        }
        ho.i.o().g(context, qZoneIntimateLoveTreeInitBean);
    }
}
