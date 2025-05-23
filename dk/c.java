package dk;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends ck.b {
    @Override // ck.b
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str = qZoneSchemeBean.getAttrs().get("feedid");
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.getFeedCommInfo().feedsid = str;
        businessFeedData.getFeedCommInfo().bizId = 2;
        if (TextUtils.isEmpty(str)) {
            ToastUtil.o(R.string.f169553v94, 1);
        } else {
            ho.i.o().c(context, businessFeedData);
        }
    }
}
