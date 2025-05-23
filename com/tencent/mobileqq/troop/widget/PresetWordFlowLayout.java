package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.TraceUtils;

/* loaded from: classes19.dex */
public class PresetWordFlowLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected BaseAdapter f302359d;

    /* renamed from: e, reason: collision with root package name */
    private DataSetObserver f302360e;

    /* renamed from: f, reason: collision with root package name */
    public int f302361f;

    /* renamed from: h, reason: collision with root package name */
    public int f302362h;

    /* renamed from: i, reason: collision with root package name */
    public int f302363i;

    /* renamed from: m, reason: collision with root package name */
    public int f302364m;

    /* loaded from: classes19.dex */
    class a extends DataSetObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PresetWordFlowLayout.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onChanged();
                PresetWordFlowLayout.this.a();
            }
        }
    }

    public PresetWordFlowLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f302361f = 0;
        this.f302362h = 0;
        this.f302363i = 0;
        this.f302364m = 0;
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < this.f302359d.getCount() && i3 < childCount) {
            this.f302359d.getView(i3, getChildAt(i3), this);
            i3++;
        }
        if (childCount > this.f302359d.getCount()) {
            removeViews(i3, childCount - this.f302359d.getCount());
        }
        if (childCount < this.f302359d.getCount()) {
            while (i3 < this.f302359d.getCount()) {
                View view = this.f302359d.getView(i3, null, this);
                if (view != null) {
                    addView(view, new ViewGroup.MarginLayoutParams(-2, -2));
                }
                i3++;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        TraceUtils.traceBegin("PresetWordFlowLayout.onLayout");
        int width = getWidth();
        int childCount = getChildCount();
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i28 = this.f302361f;
                if (i19 + i28 + measuredWidth + this.f302362h > width) {
                    i26 += this.f302363i + measuredHeight + this.f302364m;
                    i19 = 0;
                }
                int i29 = i28 + i19;
                int i36 = this.f302363i + i26;
                childAt.layout(i29, i36, i29 + measuredWidth, measuredHeight + i36);
                i19 += this.f302361f + measuredWidth + this.f302362h;
            }
        }
        TraceUtils.traceEnd();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        TraceUtils.traceBegin("PresetWordFlowLayout.onMeasure");
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i16);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i28 = measuredWidth + this.f302361f + this.f302362h;
                int i29 = measuredHeight + this.f302363i + this.f302364m;
                int i36 = i18 + i28;
                if (i36 > size) {
                    i17 = Math.max(i18, i28);
                    i26 += i29;
                } else {
                    i29 = Math.max(i19, i29);
                    i28 = i36;
                }
                if (i27 == childCount - 1) {
                    i17 = Math.max(i28, i17);
                    i26 += i29;
                }
                i19 = i29;
                i18 = i28;
            }
        }
        if (mode != 1073741824) {
            size = i17;
        }
        if (mode2 != 1073741824) {
            size2 = i26;
        }
        setMeasuredDimension(size, size2);
        TraceUtils.traceEnd();
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        DataSetObserver dataSetObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) baseAdapter);
            return;
        }
        BaseAdapter baseAdapter2 = this.f302359d;
        if (baseAdapter2 != null && (dataSetObserver = this.f302360e) != null) {
            baseAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        removeAllViews();
        this.f302359d = baseAdapter;
        if (baseAdapter != null) {
            a aVar = new a();
            this.f302360e = aVar;
            this.f302359d.registerDataSetObserver(aVar);
            this.f302359d.notifyDataSetChanged();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? (RelativeLayout.LayoutParams) new ViewGroup.MarginLayoutParams(getContext(), attributeSet) : (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 4, (Object) this, (Object) attributeSet);
    }

    public PresetWordFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302361f = 0;
        this.f302362h = 0;
        this.f302363i = 0;
        this.f302364m = 0;
    }

    public PresetWordFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302361f = 0;
        this.f302362h = 0;
        this.f302363i = 0;
        this.f302364m = 0;
    }
}
