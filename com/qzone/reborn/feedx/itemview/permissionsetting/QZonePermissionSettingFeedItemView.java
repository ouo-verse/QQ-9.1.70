package com.qzone.reborn.feedx.itemview.permissionsetting;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import vg.a;

/* loaded from: classes37.dex */
public class QZonePermissionSettingFeedItemView extends QZoneBaseFeedItemView {
    public QZonePermissionSettingFeedItemView(Context context) {
        super(context);
        setEnabled(false);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167279cg3;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZonePermissionSettingFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(wg.a.class);
        return arrayList;
    }
}
