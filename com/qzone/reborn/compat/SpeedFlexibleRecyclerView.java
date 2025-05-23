package com.qzone.reborn.compat;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes37.dex */
public class SpeedFlexibleRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView.OnFlingListener f53812f;

    public SpeedFlexibleRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        if (getLayoutManager() == null) {
            return false;
        }
        boolean canScrollHorizontally = getLayoutManager().canScrollHorizontally();
        boolean canScrollVertically = getLayoutManager().canScrollVertically();
        if (!canScrollHorizontally || Math.abs(i3) < getMinFlingVelocity()) {
            i3 = 0;
        }
        if (!canScrollVertically || Math.abs(i16) < getMinFlingVelocity()) {
            i16 = 0;
        }
        if (i3 == 0 && i16 == 0) {
            return false;
        }
        RecyclerView.OnFlingListener onFlingListener = this.f53812f;
        if (onFlingListener == null || !onFlingListener.onFling(i3, i16)) {
            return super.fling(i3, i16);
        }
        return true;
    }

    public void setMaxFlingVelocityX() {
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mMaxFlingVelocity");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(getMaxFlingVelocity() / 15));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SpeedFlexibleRecyclerView", 2, e16.getMessage());
            }
        }
    }

    public SpeedFlexibleRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpeedFlexibleRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
