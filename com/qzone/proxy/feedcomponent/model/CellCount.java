package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_count;
import NS_MOBILE_FEEDS.multiple_count;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellCount implements SmartParcelable {
    public static final String CELL_COUNT = "cell_count";

    @NeedParcel
    public String desc;

    @NeedParcel
    public String icon;

    @NeedParcel
    public int num;

    @NeedParcel
    public int type;
    public String unikey;
    public String displayStr = "";
    public int icon_width = 0;
    public int icon_height = 0;
    public ArrayList<multiple_count> mulcount = null;

    public void calculate(String str) {
        String str2;
        if (TextUtils.isEmpty(this.icon) && TextUtils.isEmpty(this.desc)) {
            this.unikey = null;
            return;
        }
        if (!TextUtils.isEmpty(this.icon) && this.icon.startsWith("http")) {
            str2 = "{img:" + URLEncoder.encode(this.icon) + ",w:" + com.qzone.proxy.feedcomponent.util.g.a(12.0f) + ",h:" + com.qzone.proxy.feedcomponent.util.g.a(12.0f) + "}";
        } else {
            str2 = "";
        }
        this.displayStr = str2 + " " + this.num + this.desc;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(CELL_COUNT);
        this.unikey = sb5.toString();
    }

    public static CellCount create(l lVar) {
        if (lVar == null || lVar.R == null) {
            return null;
        }
        CellCount cellCount = new CellCount();
        cell_count cell_countVar = lVar.R;
        cellCount.desc = cell_countVar.desc;
        cellCount.icon = cell_countVar.icon;
        cellCount.num = cell_countVar.num;
        cellCount.type = cell_countVar.type;
        cellCount.icon_width = cell_countVar.icon_width;
        cellCount.icon_height = cell_countVar.icon_height;
        cellCount.mulcount = cell_countVar.mulcount;
        return cellCount;
    }
}
