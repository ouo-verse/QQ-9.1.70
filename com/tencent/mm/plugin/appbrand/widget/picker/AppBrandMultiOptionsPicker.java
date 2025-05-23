package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public final class AppBrandMultiOptionsPicker extends FrameLayout implements com.tencent.luggage.wxa.zf.c {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f152423a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f152424b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f152425c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f152426d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.zl.c f152427e;

    /* renamed from: f, reason: collision with root package name */
    public final a.d f152428f;

    /* loaded from: classes9.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.picker.a.d
        public void a(com.tencent.mm.plugin.appbrand.widget.picker.a aVar, int i3, int i16) {
            if (AppBrandMultiOptionsPicker.this.f152427e != null) {
                AppBrandMultiOptionsPicker.this.f152427e.a(new int[]{((Integer) aVar.getTag(R.id.src)).intValue(), i16});
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends AppBrandOptionsPickerV2 {
        public b(Context context) {
            super(context);
        }
    }

    /* loaded from: classes9.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f152430a;

        /* renamed from: b, reason: collision with root package name */
        public final int f152431b;

        public c(String[] strArr, int i3) {
            this.f152430a = strArr;
            this.f152431b = Math.max(0, Math.min(i3, strArr.length - 1));
        }
    }

    @Keep
    public AppBrandMultiOptionsPicker(Context context) {
        super(context);
        this.f152428f = new a();
        Drawable drawable = context.getResources().getDrawable(R.drawable.j_l);
        this.f152423a = drawable;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f152424b = linearLayout;
        linearLayout.setPadding(com.tencent.luggage.wxa.kn.a.a(context, 2), 0, com.tencent.luggage.wxa.kn.a.a(context, 2), 0);
        this.f152424b.setOrientation(0);
        addView(this.f152424b, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f152424b.setDividerDrawable(drawable);
        this.f152424b.setShowDividers(2);
    }

    private int getPickersCount() {
        LinearLayout linearLayout = this.f152424b;
        if (linearLayout == null) {
            return 0;
        }
        return linearLayout.getChildCount();
    }

    public final AppBrandOptionsPickerV2 b(int i3) {
        LinearLayout linearLayout;
        if (i3 >= 0 && (linearLayout = this.f152424b) != null) {
            return (AppBrandOptionsPickerV2) linearLayout.getChildAt(i3);
        }
        return null;
    }

    public final void c(int i3) {
        if (i3 <= 0) {
            return;
        }
        int pickersCount = getPickersCount() - 1;
        while (i3 > 0) {
            this.f152424b.removeViewAt(pickersCount);
            pickersCount--;
            i3--;
        }
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onAttach(com.tencent.luggage.wxa.zl.c cVar) {
        this.f152427e = cVar;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onDetach(com.tencent.luggage.wxa.zl.c cVar) {
        this.f152427e = null;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onHide(com.tencent.luggage.wxa.zl.c cVar) {
        int pickersCount = getPickersCount();
        for (int i3 = 0; i3 < pickersCount; i3++) {
            AppBrandOptionsPickerV2 b16 = b(i3);
            if (b16 != null) {
                b16.h();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f152425c) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onShow(com.tencent.luggage.wxa.zl.c cVar) {
        this.f152427e = cVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f152425c) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f152425c) {
            this.f152426d = true;
        } else {
            super.requestLayout();
        }
    }

    public void setLayoutFrozen(boolean z16) {
        if (this.f152425c != z16) {
            this.f152425c = z16;
            if (z16) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            } else if (this.f152426d) {
                requestLayout();
            }
        }
    }

    public void a(c[] cVarArr) {
        if (cVarArr == null || cVarArr.length <= 0) {
            return;
        }
        int pickersCount = getPickersCount();
        setLayoutFrozen(true);
        if (pickersCount < cVarArr.length) {
            a(cVarArr.length - pickersCount);
        } else if (pickersCount > cVarArr.length) {
            c(pickersCount - cVarArr.length);
        }
        for (int i3 = 0; i3 < cVarArr.length; i3++) {
            AppBrandOptionsPickerV2 b16 = b(i3);
            c cVar = cVarArr[i3];
            b16.setOptionsArray(cVar.f152430a);
            b16.setValue(cVar.f152431b);
            b16.setOnValueChangedListener(this.f152428f);
        }
        this.f152424b.setWeightSum(getPickersCount());
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
            iArr[i3] = b(i3).getValue();
        }
        return iArr;
    }

    public final void a(int i3) {
        if (i3 <= 0) {
            return;
        }
        while (i3 > 0) {
            AppBrandOptionsPickerV2 a16 = a();
            a16.setTag(R.id.src, Integer.valueOf(this.f152424b.getChildCount()));
            this.f152424b.addView(a16, new LinearLayout.LayoutParams(0, -1, 1.0f));
            i3--;
        }
    }

    public final AppBrandOptionsPickerV2 a() {
        b bVar = new b(getContext());
        bVar.setOnValueChangedListener(this.f152428f);
        bVar.setEllipsizeType("end");
        bVar.setDividerHeight(com.tencent.luggage.wxa.kn.a.a(getContext(), 1));
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public View getView() {
        return this;
    }
}
