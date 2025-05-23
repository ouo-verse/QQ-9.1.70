package com.qzone.reborn.feedx.itemview.pymk;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import vg.a;
import yg.c;
import yg.d;

/* loaded from: classes37.dex */
public class QZonePYMKFeedItemView extends QZoneBaseFeedItemView {
    public QZonePYMKFeedItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cgv;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZonePYMKFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(d.class);
        arrayList.add(c.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public boolean v0() {
        return false;
    }
}
