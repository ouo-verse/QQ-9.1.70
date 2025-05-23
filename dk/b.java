package dk;

import android.content.Context;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSelectAlbumInitBean;
import com.qzone.reborn.intimate.bean.init.Source;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends ck.b {
    @Override // ck.b
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str = qZoneSchemeBean.getAttrs().get("spaceid");
        QLog.d("QZoneIntimateAlbumListPageParser", 1, "[parseScheme] spaceId = " + str);
        if (str == null) {
            str = "";
        }
        ho.i.o().n(context, new QZoneIntimateSelectAlbumInitBean(str, Source.DISSOLUTION_RELATIONSHIP, null));
    }
}
