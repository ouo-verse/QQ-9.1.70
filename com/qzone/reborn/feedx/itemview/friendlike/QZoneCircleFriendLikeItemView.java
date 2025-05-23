package com.qzone.reborn.feedx.itemview.friendlike;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseVideoFeedItemView;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.presenter.bo;
import com.qzone.reborn.feedx.presenter.ci;
import com.qzone.reborn.feedx.presenter.ck;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneCircleFriendLikeItemView extends QZoneBaseVideoFeedItemView {
    public QZoneCircleFriendLikeItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfg;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneCircleFriendLikeItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends vg.a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ci.class);
        arrayList.add(ck.class);
        arrayList.add(bo.class);
        arrayList.add(com.qzone.reborn.feedx.presenter.i.class);
        arrayList.add(bd.class);
        return arrayList;
    }
}
