package com.tencent.biz.pubaccount.weishi;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.view.WSFeedsLinearLayout;
import com.tencent.biz.pubaccount.weishi.view.tab.WSTabLayout;

/* compiled from: P */
/* loaded from: classes32.dex */
public class p implements WSFeedsLinearLayout.b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f81024a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f81025b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f81026c;

    /* renamed from: d, reason: collision with root package name */
    private int f81027d;

    /* renamed from: e, reason: collision with root package name */
    private final WSRecommendFragment f81028e;

    /* renamed from: f, reason: collision with root package name */
    private final WSTabLayout f81029f;

    public p(WSRecommendFragment wSRecommendFragment, WSTabLayout wSTabLayout) {
        this.f81028e = wSRecommendFragment;
        this.f81029f = wSTabLayout;
    }

    private void f(int i3) {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][actionUp] moveState:" + i3 + ", mScrollingTopMargin:" + this.f81027d);
        this.f81024a = false;
        this.f81025b = false;
        if (i3 == 1) {
            this.f81029f.l0(true);
            this.f81028e.Rh(false);
        } else if (i3 == 2) {
            this.f81029f.u0(true);
            this.f81028e.Rh(true);
        }
    }

    private boolean g() {
        return this.f81028e.Lh() == 1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSFeedsLinearLayout.b
    public void a(int i3, int i16) {
        if (g()) {
            com.tencent.biz.pubaccount.weishi.util.x.m("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][actionUp] viewPager is dragging!! dy:" + i16);
            return;
        }
        f(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSFeedsLinearLayout.b
    public void b(int i3) {
        if (g()) {
            com.tencent.biz.pubaccount.weishi.util.x.m("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][actionMoveDown] viewPager is dragging!! dy:" + i3);
            return;
        }
        d(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSFeedsLinearLayout.b
    public void c(int i3) {
        if (g()) {
            com.tencent.biz.pubaccount.weishi.util.x.m("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][actionMoveUp] viewPager is dragging!! dy:" + i3);
            return;
        }
        e(i3);
    }

    private void d(int i3) {
        this.f81024a = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f81029f.getLayoutParams();
        if (!this.f81025b) {
            this.f81025b = true;
            this.f81026c = layoutParams.topMargin;
            this.f81028e.Rh(false);
            com.tencent.biz.pubaccount.weishi.util.x.b("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveDown] switchMoveDown!! ViewPager Cannot Scroll!!");
        }
        int i16 = layoutParams.topMargin;
        if (i16 == 0) {
            com.tencent.biz.pubaccount.weishi.util.x.m("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveDown] currentTopMargin:0, doNothing!!");
            return;
        }
        int min = Math.min((-i3) + this.f81026c, 0);
        this.f81027d = min;
        layoutParams.topMargin = min;
        this.f81029f.setLayoutParams(layoutParams);
        com.tencent.biz.pubaccount.weishi.util.x.j("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveDown] topMargin:" + this.f81027d + ", currentTopMargin:" + i16 + ", dy:" + i3);
    }

    private void e(int i3) {
        this.f81025b = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f81029f.getLayoutParams();
        if (!this.f81024a) {
            this.f81024a = true;
            this.f81026c = layoutParams.topMargin;
            this.f81028e.Rh(false);
            com.tencent.biz.pubaccount.weishi.util.x.b("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveUp] switchMoveUp!! ViewPager Cannot Scroll!!");
        }
        int i16 = ba.f81742q;
        int i17 = layoutParams.topMargin;
        int i18 = -i16;
        if (i17 == i18) {
            com.tencent.biz.pubaccount.weishi.util.x.m("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveUp] currentTopMargin:" + i17 + ", doNothing!!");
            return;
        }
        int max = Math.max((-i3) + this.f81026c, i18);
        this.f81027d = max;
        layoutParams.topMargin = max;
        this.f81029f.setLayoutParams(layoutParams);
        com.tencent.biz.pubaccount.weishi.util.x.j("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveUp] topMargin:" + this.f81027d + ", currentTopMargin:" + i17 + ", dy:" + i3);
    }
}
