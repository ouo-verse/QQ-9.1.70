package com.qzone.reborn.feedx.itemview.friendbirthday;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import rg.b;
import vg.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFriendBirthdayFeedItemView extends QZoneBaseFeedItemView {
    public QZoneFriendBirthdayFeedItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.c2z;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneFriendBirthdayFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b.class);
        arrayList.add(rg.a.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public boolean v0() {
        return false;
    }
}
