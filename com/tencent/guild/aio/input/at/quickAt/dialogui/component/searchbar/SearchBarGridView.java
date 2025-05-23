package com.tencent.guild.aio.input.at.quickAt.dialogui.component.searchbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import androidx.annotation.RequiresApi;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SearchBarGridView extends GridView {

    /* renamed from: d, reason: collision with root package name */
    private int f110970d;

    public SearchBarGridView(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean checkInputConnectionProxy(View view) {
        if (view instanceof EditText) {
            return true;
        }
        return super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    @RequiresApi(api = 16)
    protected void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        int minimumHeight = getMinimumHeight();
        if (mode == 1073741824) {
            int i17 = this.f110970d;
            if (size > i17) {
                size = i17;
            }
            if (size <= minimumHeight) {
                size = minimumHeight;
            }
        }
        if (mode == 0) {
            int i18 = this.f110970d;
            if (size > i18) {
                size = i18;
            }
            if (size <= minimumHeight) {
                size = minimumHeight;
            }
        }
        if (mode == Integer.MIN_VALUE) {
            int i19 = this.f110970d;
            if (size > i19) {
                size = i19;
            }
            if (size > minimumHeight) {
                minimumHeight = size;
            }
            size = minimumHeight;
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i3) {
        this.f110970d = i3;
        requestLayout();
    }

    public SearchBarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SearchBarGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
