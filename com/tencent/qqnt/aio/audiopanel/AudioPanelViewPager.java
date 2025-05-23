package com.tencent.qqnt.aio.audiopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes34.dex */
public class AudioPanelViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private AudioPanel f349539d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f349540e;

    public AudioPanelViewPager(Context context) {
        super(context);
    }

    public void a(AudioPanel audioPanel) {
        this.f349539d = audioPanel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f349540e = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f349539d.q() == 1) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (ArrayIndexOutOfBoundsException e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AudioPanelViewPager", 4, "onInterceptTouchEvent: " + e16);
                }
            } catch (IllegalArgumentException e17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AudioPanelViewPager", 4, "onInterceptTouchEvent: " + e17);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f349540e = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        this.f349540e = true;
    }

    public AudioPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
