package com.qzone.reborn.feedx.itemview.handblog;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.presenter.al;
import com.qzone.reborn.feedx.presenter.ao;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.presenter.bk;
import com.qzone.reborn.feedx.presenter.ca;
import com.qzone.reborn.feedx.presenter.cc;
import com.qzone.reborn.feedx.presenter.ce;
import com.qzone.reborn.feedx.presenter.i;
import com.qzone.reborn.feedx.presenter.v;
import com.qzone.reborn.feedx.util.x;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import vg.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneForwardHandBlogItemView extends QZoneBaseFeedItemView {
    public QZoneForwardHandBlogItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.c2i;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneForwardHandBlogItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aj.class);
        arrayList.add(ca.class);
        arrayList.add(bk.class);
        arrayList.add(i.class);
        arrayList.add(bd.class);
        arrayList.add(cc.class);
        arrayList.add(al.class);
        arrayList.add(ce.class);
        arrayList.addAll(x.f55790a.a(q0()));
        arrayList.add(ao.class);
        arrayList.add(v.class);
        return arrayList;
    }
}
