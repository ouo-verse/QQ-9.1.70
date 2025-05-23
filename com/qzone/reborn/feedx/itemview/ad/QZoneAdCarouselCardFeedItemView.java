package com.qzone.reborn.feedx.itemview.ad;

import android.content.Context;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import gf.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vg.a;
import vg.b;
import vg.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QZoneAdCarouselCardFeedItemView extends QZoneAdBaseFeedItemView implements r {
    private View F;

    public QZoneAdCarouselCardFeedItemView(Context context) {
        super(context);
    }

    @Override // gf.r
    public void a() {
        b bVar = this.f54810e;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        Iterator<a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).a();
            }
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        b bVar = this.f54810e;
        if (bVar != null && bVar.g() != null) {
            Iterator<a> it = this.f54810e.g().iterator();
            while (it.hasNext()) {
                c cVar = (a) it.next();
                if (cVar instanceof r) {
                    return ((r) cVar).d();
                }
            }
        }
        return null;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneAdCarouselCardFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.ad.QZoneAdBaseFeedItemView, com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
        super.bindData(businessFeedData, i3);
        this.F = findViewById(R.id.f162844my0);
    }

    @Override // gf.r
    public void pause() {
        b bVar = this.f54810e;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        Iterator<a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).pause();
            }
        }
    }

    @Override // gf.r
    public void play() {
        b bVar = this.f54810e;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        Iterator<a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).play();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.ad.QZoneAdBaseFeedItemView, com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public List<Class<? extends a>> s0() {
        List<Class<? extends a>> s06 = super.s0();
        if (s06 == null) {
            s06 = new ArrayList<>();
        }
        s06.add(ng.a.class);
        return s06;
    }

    private boolean E0(MotionEvent motionEvent, boolean z16) {
        if (motionEvent == null) {
            QLog.e("QZoneAdCarouselCardFeedItemView", 1, "[inCarouselCardView] error, event is null");
            return z16;
        }
        if (this.F == null) {
            QLog.e("QZoneAdCarouselCardFeedItemView", 1, "[inCarouselCardView] error, mCarouselCardView is null");
            return z16;
        }
        try {
            return new Region(B0(this.F, this), D0(this.F, this), C0(this.F, this), A0(this.F, this)).contains((int) motionEvent.getX(), (int) motionEvent.getY());
        } catch (Throwable th5) {
            QLog.e("QZoneAdCarouselCardFeedItemView", 1, "inCarouselCardView", th5);
            return z16;
        }
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            this.f54814m = !E0(motionEvent, true);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            this.f54814m = false;
            return onInterceptTouchEvent;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            this.f54814m = !E0(motionEvent, true);
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            this.f54814m = false;
            return onTouchEvent;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private static int A0(View view, View view2) throws Exception {
        if (view != null && view2 != null) {
            if (view.getParent() != null) {
                if (view.getParent() == view2) {
                    return view.getBottom();
                }
                return view.getBottom() + A0((View) view.getParent(), view2);
            }
            throw new Exception("parentView is not the parent of childView");
        }
        throw new Exception("childView or parentView is null");
    }

    private static int B0(View view, View view2) throws Exception {
        if (view != null && view2 != null) {
            if (view.getParent() != null) {
                if (view.getParent() == view2) {
                    return view.getLeft();
                }
                return view.getLeft() + B0((View) view.getParent(), view2);
            }
            throw new Exception("parentView is not the parent of childView");
        }
        throw new Exception("childView or parentView is null");
    }

    private static int C0(View view, View view2) throws Exception {
        if (view != null && view2 != null) {
            if (view.getParent() != null) {
                if (view.getParent() == view2) {
                    return view.getRight();
                }
                return view.getRight() + C0((View) view.getParent(), view2);
            }
            throw new Exception("parentView is not the parent of childView");
        }
        throw new Exception("childView or parentView is null");
    }

    private static int D0(View view, View view2) throws Exception {
        if (view != null && view2 != null) {
            if (view.getParent() != null) {
                if (view.getParent() == view2) {
                    return view.getTop();
                }
                return view.getTop() + D0((View) view.getParent(), view2);
            }
            throw new Exception("parentView is not the parent of childView");
        }
        throw new Exception("childView or parentView is null");
    }
}
