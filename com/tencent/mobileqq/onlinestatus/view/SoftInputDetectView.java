package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SoftInputDetectView extends RelativeLayout {
    private a C;

    /* renamed from: d, reason: collision with root package name */
    private Rect f256433d;

    /* renamed from: e, reason: collision with root package name */
    private int f256434e;

    /* renamed from: f, reason: collision with root package name */
    private int f256435f;

    /* renamed from: h, reason: collision with root package name */
    private int f256436h;

    /* renamed from: i, reason: collision with root package name */
    private int f256437i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f256438m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void n4(boolean z16, int i3);
    }

    public SoftInputDetectView(Context context) {
        this(context, null);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        getWindowVisibleDisplayFrame(this.f256433d);
        int i17 = this.f256436h;
        boolean z17 = this.f256438m;
        Rect rect = this.f256433d;
        int i18 = rect.bottom;
        if (z17) {
            i18 -= rect.top;
        }
        if (this.f256435f == 0) {
            this.f256435f = i18;
        }
        if (this.f256437i < 0) {
            this.f256437i = this.f256433d.top;
        }
        this.f256436h = i18;
        if (i18 != 0 && i17 != 0 && i18 != i17) {
            int i19 = this.f256437i;
            int i26 = this.f256433d.top;
            if (i19 != i26) {
                if (z17) {
                    this.f256435f -= i26 - i19;
                }
                this.f256437i = i26;
            }
            int i27 = this.f256435f;
            if (i18 < i27) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f256434e = i27 - i18;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SoftInputDetectView", 2, "Detected layout change. Input Method is showing? " + z16 + " Input Method Height is " + this.f256434e);
            }
            a aVar = this.C;
            if (aVar != null) {
                aVar.n4(z16, this.f256434e);
            }
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f256435f, 1073741824));
    }

    public void setExcludeStatusBar(boolean z16) {
        this.f256438m = z16;
    }

    public void setOnImStateChangedListener(a aVar) {
        this.C = aVar;
    }

    public SoftInputDetectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f256433d = new Rect();
        this.f256434e = 0;
        this.f256435f = 0;
        this.f256436h = 0;
        this.f256437i = -1;
        this.f256438m = true;
        this.C = null;
    }
}
