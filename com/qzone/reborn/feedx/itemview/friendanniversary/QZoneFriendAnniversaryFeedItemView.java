package com.qzone.reborn.feedx.itemview.friendanniversary;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import qg.b;
import vg.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFriendAnniversaryFeedItemView extends QZoneBaseFeedItemView {
    public QZoneFriendAnniversaryFeedItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.c2y;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneFriendAnniversaryFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b.class);
        arrayList.add(qg.a.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public boolean v0() {
        return false;
    }
}
