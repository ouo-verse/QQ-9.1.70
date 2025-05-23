package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusListLayout extends ViewGroup {
    private int C;
    private int D;
    private int E;
    private com.tencent.mobileqq.onlinestatus.guide.c F;
    private ba G;

    /* renamed from: d, reason: collision with root package name */
    private int f255343d;

    /* renamed from: e, reason: collision with root package name */
    private int f255344e;

    /* renamed from: f, reason: collision with root package name */
    private int f255345f;

    /* renamed from: h, reason: collision with root package name */
    private int f255346h;

    /* renamed from: i, reason: collision with root package name */
    private int f255347i;

    /* renamed from: m, reason: collision with root package name */
    private int f255348m;

    public OnlineStatusListLayout(Context context) {
        super(context);
        this.E = -1;
    }

    private View b() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                return childAt;
            }
        }
        return null;
    }

    private int d(int i3) {
        int i16 = 1;
        int i17 = i3 + 1;
        int i18 = this.G.f255565d;
        int i19 = i17 / i18;
        if (i17 % i18 == 0) {
            i16 = 0;
        }
        return i19 + i16;
    }

    public static boolean h(au auVar, au auVar2) {
        if (auVar == null || auVar2 == null || auVar.f255494g.getValue() != auVar2.f255494g.getValue() || auVar.f255489b != auVar2.f255489b) {
            return false;
        }
        return true;
    }

    private void k() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof OnlineStatusItemView) && childAt.getVisibility() == 0) {
                OnlineStatusItemView onlineStatusItemView = (OnlineStatusItemView) childAt;
                onlineStatusItemView.setItemWidth(this.f255343d);
                ViewGroup.LayoutParams layoutParams = onlineStatusItemView.getLayoutParams();
                int i16 = this.f255343d;
                layoutParams.width = i16;
                layoutParams.height = i16;
            }
        }
        requestLayout();
    }

    public void a(List<au> list, ArrayList<au> arrayList, Long l3, aw awVar) {
        boolean z16;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            childAt.setVisibility(4);
            OnlineStatusItemView onlineStatusItemView = (OnlineStatusItemView) childAt;
            onlineStatusItemView.z(false);
            onlineStatusItemView.x(false);
        }
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2 != null && (childAt2 instanceof OnlineStatusItemView)) {
                OnlineStatusItemView onlineStatusItemView2 = (OnlineStatusItemView) childAt2;
                onlineStatusItemView2.setVisibility(0);
                au auVar = list.get(i16);
                onlineStatusItemView2.e(auVar);
                onlineStatusItemView2.setTag(auVar);
                int i17 = 0;
                while (true) {
                    if (i17 < arrayList.size()) {
                        if (h(auVar, arrayList.get(i17))) {
                            onlineStatusItemView2.z(true);
                            z16 = true;
                            break;
                        }
                        i17++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (l3 != null && auVar.f255489b == l3.longValue()) {
                    if (z16) {
                        onlineStatusItemView2.x(false);
                        AppRuntime waitAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
                        if (this.F == null) {
                            this.F = new com.tencent.mobileqq.onlinestatus.guide.c();
                        }
                        this.F.h(waitAppRuntime, auVar.f255489b);
                        this.F.f(waitAppRuntime, auVar.f255489b);
                        awVar.f255554m = null;
                    } else {
                        onlineStatusItemView2.x(true);
                    }
                }
            } else {
                return;
            }
        }
    }

    public int c() {
        return this.E;
    }

    public void e(ba baVar) {
        this.G = baVar;
        this.f255346h = ViewUtils.dpToPx(baVar.f255570i);
        this.f255347i = ViewUtils.dpToPx(baVar.f255566e);
        int dpToPx = ViewUtils.dpToPx(baVar.f255567f);
        this.f255348m = dpToPx;
        int i3 = this.f255346h;
        setPadding(i3, this.f255347i, i3, dpToPx);
        this.f255344e = ViewUtils.dpToPx(baVar.f255568g);
        this.f255345f = ViewUtils.dpToPx(baVar.f255568g);
        if (OnlineStatusToggleUtils.d() && baVar.f255562a == 1) {
            this.f255345f = ViewUtils.dpToPx(baVar.f255569h);
        }
    }

    public void f(int i3, View.OnClickListener onClickListener) {
        for (int i16 = 0; i16 < i3; i16++) {
            OnlineStatusItemView onlineStatusItemView = new OnlineStatusItemView(getContext());
            onlineStatusItemView.o(this.G);
            onlineStatusItemView.setItemWidth(this.f255343d);
            onlineStatusItemView.setOnClickListener(onClickListener);
            onlineStatusItemView.setVisibility(4);
            onlineStatusItemView.setStatusTextOnClickListener(onClickListener);
            int i17 = this.f255343d;
            addView(onlineStatusItemView, new ViewGroup.LayoutParams(i17, i17));
        }
    }

    public boolean g() {
        View b16;
        boolean z16;
        if (this.D == 0 || this.C == 0 || (b16 = b()) == null) {
            return false;
        }
        int bottom = b16.getBottom();
        int right = b16.getRight();
        int top = b16.getTop() - this.f255345f;
        int i3 = this.C;
        int i16 = this.D;
        if (this.f255343d + right >= getRight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 <= bottom && (i3 <= right || z16 || i16 <= top)) {
            return false;
        }
        return true;
    }

    public void i() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof OnlineStatusItemView) {
                ((OnlineStatusItemView) childAt).y();
            }
        }
    }

    public void j(int i3) {
        if (this.f255343d != i3) {
            setItemWidth(i3);
            k();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            int i26 = this.f255346h + ((i19 % this.G.f255565d) * (this.f255343d + this.f255344e));
            int d16 = this.f255347i + ((d(i19) - 1) * (this.f255343d + this.f255345f));
            View childAt = getChildAt(i19);
            int i27 = this.f255343d;
            childAt.layout(i26, d16, i26 + i27, i27 + d16);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int childCount = getChildCount();
        if (View.MeasureSpec.getMode(i16) == 1073741824) {
            i17 = View.MeasureSpec.getSize(i16);
        } else {
            int d16 = d(childCount - 1);
            int i18 = this.f255343d;
            int i19 = this.f255345f;
            i17 = (d16 * (i18 + i19)) - i19;
        }
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i3), i17);
        measureChildren(i3, View.MeasureSpec.makeMeasureSpec(i17, View.MeasureSpec.getMode(i16)));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.C = (int) motionEvent.getX();
            this.D = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setItemWidth(int i3) {
        this.f255343d = i3;
    }

    public void setPageIndex(int i3) {
        this.E = i3;
    }

    public OnlineStatusListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = -1;
    }

    public OnlineStatusListLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = -1;
    }
}
