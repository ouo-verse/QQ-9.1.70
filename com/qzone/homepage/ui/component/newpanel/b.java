package com.qzone.homepage.ui.component.newpanel;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {
    public static ArrayList<HomePanelItem> a(long j3) {
        return new ArrayList<>();
    }

    public static ArrayList<HomePanelItem> b(long j3) {
        ArrayList<HomePanelItem> arrayList = new ArrayList<>();
        HomePanelItem homePanelItem = new HomePanelItem(1, null, "https://h5.qzone.qq.com/follow/feeds/{uin}/followfeeds?_wv=1027&_proxy=1".replace("{uin}", String.valueOf(j3)), com.qzone.util.l.a(R.string.n8y), false, 0, 0, true, false, "");
        homePanelItem.canEdit = true;
        homePanelItem.iconDrawableId = R.drawable.ftx;
        arrayList.add(homePanelItem);
        HomePanelItem homePanelItem2 = new HomePanelItem(2, null, "https://h5.qzone.qq.com/qzonegift/index?uin={uin}&_proxy=1&_wv=2097155".replace("{uin}", String.valueOf(j3)), com.qzone.util.l.a(R.string.n8x), false, 0, 0, true, false, "");
        homePanelItem2.canEdit = true;
        homePanelItem2.iconDrawableId = R.drawable.ftw;
        arrayList.add(homePanelItem2);
        HomePanelItem homePanelItem3 = new HomePanelItem(3, null, "mqzonev2://arouse/todayinhistory?source=myspace&version=1&uin={uin}".replace("{uin}", String.valueOf(j3)), com.qzone.util.l.a(R.string.f172091n90), false, 0, 0, true, false, "");
        homePanelItem3.canEdit = true;
        homePanelItem3.iconDrawableId = R.drawable.f162162fu0;
        arrayList.add(homePanelItem3);
        HomePanelItem homePanelItem4 = new HomePanelItem(4, null, "mqzonev2://arouse/customsettingt?source=myspace&version=1&uin={uin}".replace("{uin}", String.valueOf(j3)), com.qzone.util.l.a(R.string.n8z), false, 0, 0, true, false, "");
        homePanelItem4.canEdit = true;
        homePanelItem4.iconDrawableId = R.drawable.ftz;
        arrayList.add(homePanelItem4);
        return arrayList;
    }

    private static HomePanelList c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return HomePanelList.fromJSONObject(str);
    }

    public static HomePanelList d(Context context, long j3) {
        if (context != null && LoginData.getInstance().getUin() == j3) {
            return c(u5.c.u("panel_list_cache", null, LoginData.getInstance().getUin()));
        }
        return null;
    }

    public static void e(Context context, long j3, HomePanelList homePanelList) {
        JSONObject jSONObject;
        if (context == null || homePanelList == null || (jSONObject = homePanelList.toJSONObject()) == null) {
            return;
        }
        u5.c.L("panel_list_cache", jSONObject.toString(), LoginData.getInstance().getUin());
    }
}
