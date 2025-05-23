package com.qzone.reborn.feedx.itemview.memoryseal;

import android.content.Context;
import android.widget.FrameLayout;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.cl;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import vg.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneGuestMemorySealFooterView extends QZoneBaseFeedItemView {
    public QZoneGuestMemorySealFooterView(Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, de.c
    public boolean Q() {
        return false;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.c6s;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneGuestMemorySealFooterView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cl.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public boolean v0() {
        return false;
    }
}
