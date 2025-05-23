package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class WrapContentGridView extends GridView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f60693d;

    public WrapContentGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int defaultSize = View.getDefaultSize(0, i3);
        if (this.f60693d) {
            setMeasuredDimension(defaultSize, (int) (ViewUtils.getScreenWidth() * 0.625f));
        } else {
            setMeasuredDimension(defaultSize, (int) (ViewUtils.getScreenWidth() * 0.51180553f));
        }
    }

    public WrapContentGridView(Context context, boolean z16) {
        super(context);
        this.f60693d = z16;
    }

    public WrapContentGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrapContentGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
