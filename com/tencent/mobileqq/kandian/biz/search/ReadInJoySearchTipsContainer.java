package com.tencent.mobileqq.kandian.biz.search;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ReadInJoySearchTipsContainer extends ViewGroup implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private int f239415d;

    /* renamed from: e, reason: collision with root package name */
    private int f239416e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public ReadInJoySearchTipsContainer(Context context) {
        super(context);
        this.f239415d = ViewUtils.dip2px(260.0f);
        this.f239416e = 5;
        b();
    }

    private void b() {
        this.f239415d = getResources().getDisplayMetrics().widthPixels / 2;
    }

    protected int a(int i3) {
        int a16 = (int) al.a(getContext(), 7.0f);
        int a17 = (int) al.a(getContext(), 10.0f);
        int a18 = (int) al.a(getContext(), 10.0f);
        int a19 = (int) al.a(getContext(), 4.0f);
        int a26 = (int) al.a(getContext(), 12.0f);
        int a27 = (int) al.a(getContext(), 12.0f);
        int childCount = getChildCount();
        int i16 = a26;
        int i17 = 1;
        int i18 = a17;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i19 == 0) {
                a17 += measuredHeight;
            }
            if (i16 + measuredWidth > i3 - a27) {
                i17++;
                int i26 = this.f239416e;
                if (i26 > 0 && i17 > i26) {
                    break;
                }
                i18 += measuredHeight + a16;
                i16 = a26;
                a17 = measuredHeight + i18;
            }
            i16 += measuredWidth + a19;
        }
        return a17 + a18;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = new a(Looper.getMainLooper());
        Message obtainMessage = aVar.obtainMessage();
        obtainMessage.obj = view.getTag();
        aVar.sendMessage(obtainMessage);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int a16 = (int) al.a(getContext(), 7.0f);
        int a17 = (int) al.a(getContext(), 10.0f);
        int a18 = (int) al.a(getContext(), 4.0f);
        int a19 = (int) al.a(getContext(), 12.0f);
        int a26 = (int) al.a(getContext(), 12.0f);
        int i19 = i17 - i3;
        int childCount = getChildCount();
        int i26 = 1;
        int i27 = 0;
        int i28 = a19;
        while (i27 < childCount) {
            View childAt = getChildAt(i27);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i28 + measuredWidth > i19 - a26) {
                a17 += measuredHeight + a16;
                i26++;
                int i29 = this.f239416e;
                if (i29 > 0 && i26 > i29) {
                    return;
                } else {
                    i28 = a19;
                }
            }
            childAt.layout(i28, a17, measuredWidth + i28, measuredHeight + a17);
            i27++;
            i28 = a18 + measuredWidth + i28;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        super.measureChildren(i3, i16);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            i17 = 0;
        } else {
            i17 = size;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                size2 = a(size);
            }
        } else {
            size2 = a(size);
        }
        super.setMeasuredDimension(i17, size2);
    }

    public void setMaxLines(int i3) {
        this.f239416e = i3;
    }

    public ReadInJoySearchTipsContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f239415d = ViewUtils.dip2px(260.0f);
        this.f239416e = 5;
        b();
    }
}
