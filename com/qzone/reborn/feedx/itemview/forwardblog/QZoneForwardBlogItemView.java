package com.qzone.reborn.feedx.itemview.forwardblog;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.QZoneFeedGuideBarContentPresenter;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.presenter.ao;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.presenter.bk;
import com.qzone.reborn.feedx.presenter.cc;
import com.qzone.reborn.feedx.presenter.cd;
import com.qzone.reborn.feedx.presenter.v;
import com.qzone.reborn.feedx.util.x;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import vg.a;
import xg.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneForwardBlogItemView extends QZoneBaseFeedItemView {
    public QZoneForwardBlogItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.bxq;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneForwardBlogItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected void p0() {
        if (x.f55790a.c(q0())) {
            return;
        }
        d.a(getData(), getHostActivity(), this);
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aj.class);
        arrayList.add(bk.class);
        arrayList.add(bd.class);
        arrayList.add(cc.class);
        arrayList.add(cd.class);
        arrayList.add(QZoneFeedGuideBarContentPresenter.class);
        arrayList.addAll(x.f55790a.a(q0()));
        arrayList.add(ao.class);
        arrayList.add(v.class);
        return arrayList;
    }
}
