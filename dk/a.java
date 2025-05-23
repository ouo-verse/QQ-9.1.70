package dk;

import android.content.Context;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends ck.b {
    @Override // ck.b
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str = qZoneSchemeBean.getAttrs().get("spaceid");
        String str2 = qZoneSchemeBean.getAttrs().get("albumid");
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        if (str != null) {
            qZoneIntimateAlbumDetailInitBean.setSpaceId(str);
        }
        if (str2 != null) {
            qZoneIntimateAlbumDetailInitBean.setAlbumId(str2);
        }
        QLog.i("QZoneIntimateAlbumDetailPageParser", 1, "parseScheme   | spaceId = " + str + " | albumId = " + str2);
        ho.i.o().j(context, qZoneIntimateAlbumDetailInitBean);
    }
}
