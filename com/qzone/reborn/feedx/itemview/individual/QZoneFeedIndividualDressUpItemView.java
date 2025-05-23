package com.qzone.reborn.feedx.itemview.individual;

import android.content.Context;
import android.view.MotionEvent;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.ad;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.presenter.al;
import com.qzone.reborn.feedx.presenter.bk;
import com.qzone.reborn.feedx.presenter.ca;
import com.qzone.reborn.util.p;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import vg.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedIndividualDressUpItemView extends QZoneBaseFeedItemView {
    public QZoneFeedIndividualDressUpItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cf5;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneFeedIndividualDressUpItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && !p.a(motionEvent.getX(), motionEvent.getY(), this.f54812h, this.f54813i)) {
                return true;
            }
        } else {
            this.f54812h = motionEvent.getX();
            this.f54813i = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aj.class);
        arrayList.add(ca.class);
        arrayList.add(bk.class);
        arrayList.add(al.class);
        arrayList.add(ad.class);
        return arrayList;
    }
}
