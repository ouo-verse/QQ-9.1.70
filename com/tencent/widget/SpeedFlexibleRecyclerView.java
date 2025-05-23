package com.tencent.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SpeedFlexibleRecyclerView extends RecyclerView {
    static IPatchRedirector $redirector_;
    private OnFlingListener mOnFlingListener;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class OnFlingListener {
        static IPatchRedirector $redirector_;

        public OnFlingListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract boolean onFling(int i3, int i16);
    }

    public SpeedFlexibleRecyclerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
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
        OnFlingListener onFlingListener = this.mOnFlingListener;
        if (onFlingListener != null && onFlingListener.onFling(i3, i16)) {
            return true;
        }
        return super.fling(i3, i16);
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (OnFlingListener) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mOnFlingListener;
    }

    public void setMaxFlingVelocityX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
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

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onFlingListener);
        } else {
            this.mOnFlingListener = onFlingListener;
        }
    }

    public void smoothScrollBy(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mViewFlinger");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Class<?> cls = Class.forName("android.support.v7.widget.RecyclerView$ViewFlinger");
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("smoothScrollBy", cls2, cls2, cls2);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } catch (ClassNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SpeedFlexibleRecyclerView", 2, e16.getMessage());
            }
            super.smoothScrollBy(i3, i16);
        } catch (IllegalAccessException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("SpeedFlexibleRecyclerView", 2, e17.getMessage());
            }
            super.smoothScrollBy(i3, i16);
        } catch (NoSuchFieldException e18) {
            if (QLog.isColorLevel()) {
                QLog.d("SpeedFlexibleRecyclerView", 2, e18.getMessage());
            }
            super.smoothScrollBy(i3, i16);
        } catch (NoSuchMethodException e19) {
            if (QLog.isColorLevel()) {
                QLog.d("SpeedFlexibleRecyclerView", 2, e19.getMessage());
            }
            super.smoothScrollBy(i3, i16);
        } catch (InvocationTargetException e26) {
            if (QLog.isColorLevel()) {
                QLog.d("SpeedFlexibleRecyclerView", 2, e26.getMessage());
            }
            super.smoothScrollBy(i3, i16);
        }
    }

    public SpeedFlexibleRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SpeedFlexibleRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
