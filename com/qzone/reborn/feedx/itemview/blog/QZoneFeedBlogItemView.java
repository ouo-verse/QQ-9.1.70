package com.qzone.reborn.feedx.itemview.blog;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.QZoneFeedGuideBarContentPresenter;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.presenter.ao;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.presenter.i;
import com.qzone.reborn.feedx.presenter.j;
import com.qzone.reborn.feedx.presenter.v;
import com.qzone.reborn.feedx.util.x;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import vg.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedBlogItemView extends QZoneBaseFeedItemView {
    public QZoneFeedBlogItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167262a32;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneFeedBlogItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aj.class);
        arrayList.add(i.class);
        arrayList.add(bd.class);
        arrayList.add(j.class);
        arrayList.add(QZoneFeedGuideBarContentPresenter.class);
        arrayList.addAll(x.f55790a.a(q0()));
        arrayList.add(ao.class);
        arrayList.add(v.class);
        return arrayList;
    }
}
