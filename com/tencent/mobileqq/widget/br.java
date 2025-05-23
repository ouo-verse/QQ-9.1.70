package com.tencent.mobileqq.widget;

import android.content.Context;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public class br extends Scroller {

    /* renamed from: a, reason: collision with root package name */
    private int f316778a;

    public br(Context context) {
        super(context);
        this.f316778a = 750;
    }

    public void a(ViewPager viewPager) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, this);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.widget.Scroller
    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        super.startScroll(i3, i16, i17, i18, this.f316778a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i3, int i16, int i17, int i18) {
        super.startScroll(i3, i16, i17, i18, this.f316778a);
    }
}
