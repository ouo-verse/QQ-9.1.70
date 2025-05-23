package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.zf.c;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public final class AppBrandMultiOptionsPickerV2 extends LinearLayout implements c {

    /* renamed from: a, reason: collision with root package name */
    public List f152432a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f152433b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f152434c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.zl.c f152435d;

    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.fc.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f152436a;

        public a(int i3) {
            this.f152436a = i3;
        }

        @Override // com.tencent.luggage.wxa.fc.c
        public void onOptionsSelectChanged(int i3) {
            if (AppBrandMultiOptionsPickerV2.this.f152435d != null) {
                AppBrandMultiOptionsPickerV2.this.f152435d.a(new int[]{this.f152436a, i3});
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f152438a;

        /* renamed from: b, reason: collision with root package name */
        public final int f152439b;

        public b(String[] strArr, int i3) {
            this.f152438a = strArr;
            this.f152439b = Math.max(0, Math.min(i3, strArr.length - 1));
        }
    }

    @Keep
    public AppBrandMultiOptionsPickerV2(Context context) {
        super(context);
        setOrientation(0);
        this.f152432a = new ArrayList();
    }

    private int getPickersCount() {
        return getChildCount();
    }

    public final AppBrandOptionsPickerV3 b(int i3) {
        if (i3 < 0) {
            return null;
        }
        return (AppBrandOptionsPickerV3) this.f152432a.get(i3);
    }

    public final void c(int i3) {
        if (i3 <= 0) {
            return;
        }
        int pickersCount = getPickersCount() - 1;
        while (i3 > 0) {
            removeViewAt(pickersCount);
            pickersCount--;
            i3--;
        }
        a();
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onAttach(com.tencent.luggage.wxa.zl.c cVar) {
        this.f152435d = cVar;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onDetach(com.tencent.luggage.wxa.zl.c cVar) {
        this.f152435d = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f152433b) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onShow(com.tencent.luggage.wxa.zl.c cVar) {
        this.f152435d = cVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f152433b) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f152433b) {
            this.f152434c = true;
        } else {
            super.requestLayout();
        }
    }

    public void setLayoutFrozen(boolean z16) {
        if (this.f152433b != z16) {
            this.f152433b = z16;
            if (z16) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            } else if (this.f152434c) {
                requestLayout();
            }
        }
    }

    public void a(b[] bVarArr) {
        if (bVarArr == null || bVarArr.length <= 0) {
            return;
        }
        int pickersCount = getPickersCount();
        setLayoutFrozen(true);
        if (pickersCount < bVarArr.length) {
            a(bVarArr.length - pickersCount, bVarArr);
        } else if (pickersCount > bVarArr.length) {
            c(pickersCount - bVarArr.length);
        }
        for (int i3 = 0; i3 < bVarArr.length; i3++) {
            AppBrandOptionsPickerV3 b16 = b(i3);
            b bVar = bVarArr[i3];
            b16.a(bVar.f152438a);
            b16.c(bVar.f152439b);
            b16.a(new a(i3));
        }
        setWeightSum(getPickersCount());
        setLayoutFrozen(false);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int[] currentValue() {
        int pickersCount = getPickersCount();
        if (pickersCount <= 0) {
            return new int[0];
        }
        int[] iArr = new int[pickersCount];
        for (int i3 = 0; i3 < pickersCount; i3++) {
            iArr[i3] = b(i3).c();
        }
        return iArr;
    }

    public void a(int i3, b bVar) {
        if (i3 >= 0 && i3 < getPickersCount() && bVar != null) {
            setLayoutFrozen(true);
            b(i3).a(bVar.f152438a);
            if (!w0.a(bVar.f152438a)) {
                b(i3).d(bVar.f152439b);
            }
            setLayoutFrozen(false);
        }
    }

    public final void a(int i3, b[] bVarArr) {
        if (i3 <= 0) {
            return;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            AppBrandOptionsPickerV3 a16 = a(bVarArr[i16].f152439b);
            this.f152432a.add(a16);
            addView(a16.getView(), new LinearLayout.LayoutParams(-1, -2, 1.0f));
        }
        a();
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onHide(com.tencent.luggage.wxa.zl.c cVar) {
    }

    public final void a() {
        if (this.f152432a.size() == 1) {
            ((AppBrandOptionsPickerV3) this.f152432a.get(0)).getView().setPadding(0, getContext().getResources().getDimensionPixelSize(R.dimen.bht), 0, getContext().getResources().getDimensionPixelSize(R.dimen.bht));
            return;
        }
        if (this.f152432a.size() == 2) {
            ((AppBrandOptionsPickerV3) this.f152432a.get(0)).getView().setPadding(0, getContext().getResources().getDimensionPixelSize(R.dimen.bht), getContext().getResources().getDimensionPixelSize(R.dimen.bht), getContext().getResources().getDimensionPixelSize(R.dimen.bht));
            ((AppBrandOptionsPickerV3) this.f152432a.get(1)).getView().setPadding(getContext().getResources().getDimensionPixelSize(R.dimen.bht), getContext().getResources().getDimensionPixelSize(R.dimen.bht), 0, getContext().getResources().getDimensionPixelSize(R.dimen.bht));
        } else if (this.f152432a.size() == 3) {
            ((AppBrandOptionsPickerV3) this.f152432a.get(0)).getView().setPadding(0, getContext().getResources().getDimensionPixelSize(R.dimen.bht), getContext().getResources().getDimensionPixelSize(R.dimen.bgc), getContext().getResources().getDimensionPixelSize(R.dimen.bht));
            ((AppBrandOptionsPickerV3) this.f152432a.get(1)).getView().setPadding(getContext().getResources().getDimensionPixelSize(R.dimen.bgc), getContext().getResources().getDimensionPixelSize(R.dimen.bht), getContext().getResources().getDimensionPixelSize(R.dimen.bgc), getContext().getResources().getDimensionPixelSize(R.dimen.bht));
            ((AppBrandOptionsPickerV3) this.f152432a.get(2)).getView().setPadding(getContext().getResources().getDimensionPixelSize(R.dimen.bgc), getContext().getResources().getDimensionPixelSize(R.dimen.bht), 0, getContext().getResources().getDimensionPixelSize(R.dimen.bht));
        }
    }

    public final AppBrandOptionsPickerV3 a(int i3) {
        AppBrandOptionsPickerV3 appBrandOptionsPickerV3 = new AppBrandOptionsPickerV3(getContext());
        appBrandOptionsPickerV3.c(i3);
        appBrandOptionsPickerV3.e();
        appBrandOptionsPickerV3.a(getContext().getResources().getDimensionPixelSize(R.dimen.c5l));
        appBrandOptionsPickerV3.b(getContext().getResources().getDimensionPixelSize(R.dimen.cxz));
        return appBrandOptionsPickerV3;
    }
}
