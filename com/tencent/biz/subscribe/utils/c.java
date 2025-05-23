package com.tencent.biz.subscribe.utils;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends FlingGestureHandler {

    /* renamed from: d, reason: collision with root package name */
    private CertifiedAccountMeta$StFeed f96277d;

    /* renamed from: e, reason: collision with root package name */
    private CertifiedAccountMeta$StUser f96278e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<View> f96279f;

    public c(Activity activity) {
        super(activity);
        TopGestureLayout topGestureLayout = new TopGestureLayout(activity);
        topGestureLayout.setInterceptScrollRLFlag(true);
        setTopLayout(topGestureLayout);
        if (this.mTopLayout != null) {
            this.mTopLayout.setInterceptTouchEventListener(new a(new Rect()));
        }
        onStart();
    }

    public void b(View view) {
        if (view == null) {
            return;
        }
        if (this.f96279f == null) {
            this.f96279f = new ArrayList<>();
        }
        if (!this.f96279f.contains(view)) {
            this.f96279f.add(view);
        }
    }

    public void c(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
        this.f96278e = certifiedAccountMeta$StUser;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.fling.FlingHandler
    public boolean canWrapContent() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingGestureHandler, com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
    public void flingRToL() {
        TopGestureLayout topGestureLayout = this.mTopLayout;
        if (topGestureLayout != null) {
            if (this.f96278e != null) {
                com.tencent.biz.subscribe.d.t(topGestureLayout.getContext(), this.f96278e);
            } else if (this.f96277d != null) {
                com.tencent.biz.subscribe.d.o(topGestureLayout.getContext(), this.f96277d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements TopGestureLayout.InterceptTouchEventListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f96280a;

        a(Rect rect) {
            this.f96280a = rect;
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public boolean OnInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x16 = (int) (motionEvent.getX() + 0.5f);
                int y16 = (int) (motionEvent.getY() + 0.5f);
                if (c.this.f96279f != null) {
                    Iterator it = c.this.f96279f.iterator();
                    while (it.hasNext()) {
                        ((View) it.next()).getGlobalVisibleRect(this.f96280a);
                        if (this.f96280a.contains(x16, y16)) {
                            return false;
                        }
                    }
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public void OnDispatchTouchEvent(MotionEvent motionEvent) {
        }
    }
}
