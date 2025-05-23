package com.qzone.reborn.feedx.itemview.timeline;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.co;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import vg.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneUserHomeTimeLineEmptyView extends QZoneBaseFeedItemView {
    public QZoneUserHomeTimeLineEmptyView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ch8;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected String getLogTag() {
        return "QZoneUserHomeTimeLineEmptyView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(co.class);
        return arrayList;
    }
}
