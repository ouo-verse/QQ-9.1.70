package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditControlButtonLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private final List<Integer> f68947d;

    /* renamed from: e, reason: collision with root package name */
    private final Comparator<Integer> f68948e;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements Comparator<Integer> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return EditControlButtonLayout.this.getChildAt(num.intValue()).getLeft() - EditControlButtonLayout.this.getChildAt(num2.intValue()).getLeft();
        }
    }

    public EditControlButtonLayout(Context context) {
        this(context, null);
    }

    private void b(Context context) {
        addOnLayoutChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i3;
        if (getParent() instanceof HorizontalScrollView) {
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) getParent();
            int width = (horizontalScrollView.getWidth() - horizontalScrollView.getPaddingLeft()) - horizontalScrollView.getPaddingRight();
            int measuredWidth = getMeasuredWidth();
            if (measuredWidth <= width) {
                return;
            }
            this.f68947d.clear();
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                if (getChildAt(i16).getVisibility() != 8) {
                    this.f68947d.add(Integer.valueOf(i16));
                }
            }
            if (this.f68947d.isEmpty()) {
                return;
            }
            Collections.sort(this.f68947d, this.f68948e);
            int i17 = -1;
            for (int i18 = 0; i18 < this.f68947d.size(); i18++) {
                View childAt = getChildAt(this.f68947d.get(i18).intValue());
                int abs = Math.abs(width - ((childAt.getLeft() + childAt.getRight()) / 2));
                if (abs < measuredWidth) {
                    i17 = i18;
                    measuredWidth = abs;
                }
            }
            if (i17 <= 0) {
                return;
            }
            View childAt2 = getChildAt(this.f68947d.get(i17).intValue());
            int right = childAt2.getRight();
            int width2 = childAt2.getWidth();
            if (right < width || right - width >= width2 / 2) {
                int paddingLeft = getPaddingLeft() + getPaddingRight();
                for (int i19 = 0; i19 <= i17; i19++) {
                    paddingLeft += getChildAt(this.f68947d.get(i19).intValue()).getWidth();
                }
                if (i17 < 4 && (i3 = i17 + 1) < this.f68947d.size()) {
                    View childAt3 = getChildAt(this.f68947d.get(i3).intValue());
                    if (childAt3.getWidth() + paddingLeft < width) {
                        paddingLeft += childAt3.getWidth();
                        i17 = i3;
                    }
                }
                float f16 = (width - paddingLeft) / (i17 * 2);
                if (f16 > 0.0f) {
                    int i26 = 0;
                    while (i26 < this.f68947d.size()) {
                        View childAt4 = getChildAt(this.f68947d.get(i26).intValue());
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt4.getLayoutParams();
                        layoutParams.leftMargin = i26 == 0 ? 0 : (int) (1.0f + f16);
                        layoutParams.rightMargin = i26 == this.f68947d.size() + (-1) ? 0 : (int) f16;
                        childAt4.setLayoutParams(layoutParams);
                        i26++;
                    }
                }
            }
        }
    }

    public EditControlButtonLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditControlButtonLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f68947d = new ArrayList(20);
        this.f68948e = new b();
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if ((i3 == i19 && i17 == i27 && i16 == i26 && i18 == i28) ? false : true) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("EditControlButtonLayout", 2, String.format("onLayoutChange [%d, %d, %d, %d]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
                }
                EditControlButtonLayout.this.c();
            }
        }
    }
}
